package uz.pdp.spring_boot_first.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.spring_boot_first.entity.Attachment;
import uz.pdp.spring_boot_first.exception.RestException;
import uz.pdp.spring_boot_first.payload.AttachmentDTO;
import uz.pdp.spring_boot_first.repository.AttachmentRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

/**
 Created by: Mehrojbek
 DateTime: 31/01/25 19:56
 **/
@RestController
@RequestMapping("/api/attachment")
@RequiredArgsConstructor
public class AttachmentController {
    private final AttachmentRepository attachmentRepository;

    @Value("${app.files.baseFolder}")
    private String baseFolder;

    @PostMapping("/upload")
    public AttachmentDTO upload(@RequestPart("file") MultipartFile multipartFile) {

        try {
            //yil/oy/kun/file.png

            LocalDate localDate = LocalDate.now();
            int year = localDate.getYear();
            int month = localDate.getMonthValue();
            int day = localDate.getDayOfMonth();

            String contentType = multipartFile.getContentType();

            long size = multipartFile.getSize();

            String originalFilename = multipartFile.getOriginalFilename();

            String name = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(originalFilename);

            //files/2025/1/31/
            Path path = Paths.get(baseFolder)
                    .resolve(String.valueOf(year))
                    .resolve(String.valueOf(month))
                    .resolve(String.valueOf(day));

            Files.createDirectories(path);

            //files/2025/1/31/test.png
            path = path.resolve(name);


            Files.copy(multipartFile.getInputStream(), path);

            Attachment attachment = new Attachment(
                    path.toString(),
                    name,
                    originalFilename,
                    contentType,
                    size
            );

            attachmentRepository.save(attachment);

            String attachmentDownloadApi = "/api/attachment/download/";

            return new AttachmentDTO(
                    attachment.getId(),
                    attachment.getCreatedAt(),
                    attachment.getFileName(),
                    attachment.getContentType(),
                    attachment.getSize(),
                    attachmentDownloadApi + attachment.getId()
            );

        } catch (IOException e) {
            e.printStackTrace();
            throw RestException.error(e.getMessage());
        }
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> download(@PathVariable("fileId") UUID fileId) {

        Attachment attachment = attachmentRepository.findById(fileId).orElseThrow(() -> RestException.notFound("Attachment not found", fileId));

        String path = attachment.getPath();
        String contentType = attachment.getContentType();
        long size = attachment.getSize();

        Resource resource = new FileSystemResource(path);

        HttpHeaders headers = new HttpHeaders();
        //application/pdf
        headers.setContentType(MediaType.parseMediaType(contentType));
        headers.setContentLength(size);

        headers.add("Content-Disposition", "inline; filename=\"" + attachment.getFileName() + "\"");

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

}
