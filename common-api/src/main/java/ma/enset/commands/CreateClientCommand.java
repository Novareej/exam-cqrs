package ma.enset.commands;

import lombok.Getter;

public class CreateClientCommand extends BaseCommand<String>{

    @Getter public String nom;
    @Getter public String adresse;
    @Getter public String email;
    @Getter public int tel;

    public CreateClientCommand(String id,String nom,String adresse,String email,int tel) {
        super(id);
        this.adresse=adresse;
        this.nom=nom;
        this.tel=tel;
        this.email=email;
    }
}
