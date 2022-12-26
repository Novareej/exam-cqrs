package ma.enset.events;

import lombok.Getter;

import java.util.Date;

public class OrderCreatedEvent extends BaseEvent<String>{


    @Getter private Date date_cmd;
    @Getter private Date date_livr;
    @Getter private String add_livr;
    @Getter private String statut;

    public OrderCreatedEvent(String id,Date date_cmd,Date date_livr,String add_livr,String statut) {
        super(id);
        this.date_cmd = date_cmd;
        this.date_livr = date_livr;
        this.add_livr = add_livr;
        this.statut = statut;
    }
}
