package uz.pdp.spring_boot_first.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import uz.pdp.spring_boot_first.entity.template.AbsUUIDEntity;

/**
 Created by: Mehrojbek
 DateTime: 31/01/25 19:50
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Attachment extends AbsUUIDEntity {

    private String path;

    //generated unique name
    private String name;

    @Column(columnDefinition = "text")
    private String fileName;

    //application/pdf, image/png
    private String contentType;

    private long size;
}
