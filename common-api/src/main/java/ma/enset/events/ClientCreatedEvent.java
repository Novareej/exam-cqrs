package ma.enset.events;

import lombok.Getter;

public class ClientCreatedEvent extends BaseEvent<String>{
    @Getter
    private String nom;
    @Getter private String adresse;
    @Getter private String email;
    @Getter private int tel;

    public ClientCreatedEvent(String id, String adresse, String nom, String email, int tel) {
        super(id);
        this.adresse= this.adresse;
        this.nom= this.nom;
        this.tel= this.tel;
        this.email= this.email;
    }
}
