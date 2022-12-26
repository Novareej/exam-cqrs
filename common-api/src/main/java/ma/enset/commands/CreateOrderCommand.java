package ma.enset.commands;

import lombok.Getter;

import java.util.Date;

public class CreateOrderCommand extends BaseCommand<String>{

    @Getter
    public Date date_cmd;
    @Getter public  Date date_livr;
    @Getter public  String add_livr;
    @Getter public  String statut;

    public CreateOrderCommand(String id) {
        super(id);
    }
}
