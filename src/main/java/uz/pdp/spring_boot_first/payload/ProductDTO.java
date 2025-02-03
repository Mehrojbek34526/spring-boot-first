package uz.pdp.spring_boot_first.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 03/02/25 20:37
 **/
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {ProductDTO.Fields.id, ProductDTO.Fields.price})
public class ProductDTO {

    private Integer id;

    @JsonProperty("title")
    private String name;

    private Long price;

    @JsonIgnore
    private Integer count;

    private String description;

    private List<CommentDTO> comments;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CommentDTO {
        private Integer id;
        private String comment;
    }

}
