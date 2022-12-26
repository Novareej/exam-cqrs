package ma.enset.commands;

import lombok.Getter;

public class CreateCategoryCommand extends BaseCommand<String>{

    @Getter
    public String nom;
    @Getter public String description;

    public CreateCategoryCommand(String id,String nom, String description) {
        super(id);
        this.nom = nom;
        this.description= description;
    }
}
