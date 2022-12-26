package ma.enset.events;

import lombok.Getter;
import ma.enset.dtos.Etat;

public class ProduitCreatedEvent extends BaseEvent<String> {

    @Getter private String nom;
    @Getter private double quantite;
    @Getter private Etat etat;
    @Getter private String category;


    public ProduitCreatedEvent(String id,String nom,double quantite,Etat etat,String category) {
        super(id);
        this.nom = nom;
        this.quantite = quantite;
        this.etat = etat;
        this.category = category;
    }
}
