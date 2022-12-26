package ma.enset.events;

import lombok.Getter;
import ma.enset.dtos.Etat;

public class CategoryCreatedEvent extends BaseEvent<String> {

    @Getter private String nom;
    @Getter private String description;


    public CategoryCreatedEvent(String id,String nom, String description) {
        super(id);
        this.nom = nom;
        this.description = description;
    }
}
