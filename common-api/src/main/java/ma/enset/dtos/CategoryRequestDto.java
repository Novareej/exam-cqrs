package ma.enset.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CategoryRequestDto {

    private String nom;
    private String description;

}
