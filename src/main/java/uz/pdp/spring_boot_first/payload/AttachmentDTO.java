package uz.pdp.spring_boot_first.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.spring_boot_first.entity.Attachment;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * DTO for {@link Attachment}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentDTO implements Serializable {
    private UUID id;
    private Timestamp createdAt;
    private String fileName;
    private String contentType;
    private long size;
    private String url;//  /api/attachment/download/{attachmentId}
}