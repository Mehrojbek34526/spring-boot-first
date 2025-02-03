package uz.pdp.spring_boot_first.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.spring_boot_first.payload.ProductDTO;

import java.util.LinkedHashMap;
import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 03/02/25 20:36
 **/
@RestController
@RequestMapping("/api/jackson")
public class JacksonController {

    @GetMapping("/test")
    public ProductDTO test() {

        ProductDTO productDTO = new ProductDTO(
                1,
                "Samsung s10",
                4000000L,
                12,
                "Bu yaxshi mahsulot",
                null
        );

        return productDTO;
    }

    public static void main(String[] args) throws JsonProcessingException {

        String json = """
                [
                  {
                    "id": 1,
                    "name": "Samsung A14",
                    "price": 3000000
                  },
                  {
                    "id": 2,
                    "name": "Samsung A15",
                    "price": 4000000
                  },
                  {
                    "id": 3,
                    "name": "Samsung A16",
                    "price": 4500000
                  }
                ]
                """;

        ObjectMapper mapper = new ObjectMapper();

//        TypeFactory typeFactory = TypeFactory.defaultInstance();
//        JavaType javaType = typeFactory.constructParametricType(List.class, ProductDTO.class);

        List<ProductDTO> list = mapper.readValue(json, new TypeReference<>() {});
        Object o = list.get(0);
        System.out.println("o.getClass() = " + o.getClass());

    }

}
