package ma.enset.commands;

import lombok.Getter;

import javax.persistence.Id;

public class CreateLigneCommand extends BaseCommand<String>{
    @Getter public double quantite;
    @Getter public double prixUnit;
    @Getter public double remise;
    @Getter public String order;

    public CreateLigneCommand(String id,double quantite,double prixUnit,double remise,String order) {
        super(id);
        this.quantite = quantite;
        this.prixUnit = prixUnit;
        this.remise = remise;
        this.order = order;
    }
}
