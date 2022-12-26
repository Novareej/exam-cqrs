package ma.enset.query.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private String id;
    private Date date_cmd;
    private Date date_livr;
    private String add_livr;
    private Statut statut;
    @OneToMany(mappedBy = "order")
    private List<LigneCommande> ligneCommandes;
    @ManyToOne
    private Client client;
}
