package ma.enset.commands;

import lombok.Getter;
import ma.enset.dtos.Etat;

public class CreateProduitCommand extends BaseCommand<String>{

    @Getter
    public String nom;
    @Getter public double quantite;
    @Getter public Etat etat;
    @Getter public String category;


    public CreateProduitCommand(String id,String nom,double quantite,Etat etat,String category) {
        super(id);
        this.nom = nom;
        this.quantite = quantite;
        this.etat = etat;
        this.category = category;
    }
}
