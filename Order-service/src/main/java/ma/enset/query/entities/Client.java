package ma.enset.query.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String id;
    private String nom;
    private String adresse;
    private String email;
    private int tel;
    @OneToMany(mappedBy = "client")
    private List<Order> orders;
}
