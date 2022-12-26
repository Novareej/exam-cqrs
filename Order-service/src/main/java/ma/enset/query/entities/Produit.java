package ma.enset.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Produit {
    private String id;
    private String nom;
    private double quantite;
    private Etat etat;
}
