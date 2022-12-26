package ma.enset.query.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    private String id;
    private String nom;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Produit> produits;
}
