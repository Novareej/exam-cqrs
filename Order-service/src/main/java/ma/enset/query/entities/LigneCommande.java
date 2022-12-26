package ma.enset.query.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class LigneCommande {
    @Id
    private String id;
    private double quantite;
    private double prixUnit;
    private double remise;

    @ManyToOne
    private Order order;
}
