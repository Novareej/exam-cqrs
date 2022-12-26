package ma.enset.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitRequestDto {
    private String nom;
    private double quantite;
    private Etat etat;
    private String category;
}
