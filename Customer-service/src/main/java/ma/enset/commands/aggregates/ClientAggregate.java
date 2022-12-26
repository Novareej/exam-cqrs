package ma.enset.commands.aggregates;


import lombok.Getter;
import lombok.NoArgsConstructor;
import ma.enset.commands.CreateClientCommand;
import ma.enset.events.ClientCreatedEvent;
import ma.enset.query.entities.Client;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ClientAggregate {
    @AggregateIdentifier
    @Getter private String clientId;

    @Getter  private String nom;
    @Getter private String adresse;
    @Getter private String email;
    @Getter private int tel;

    public ClientAggregate(){

    }

    @CommandHandler
    public ClientAggregate(CreateClientCommand command){
        AggregateLifecycle.apply(new ClientCreatedEvent(
                command.getId(),
                command.getAdresse(),
                command.getNom(),
                command.getEmail(),
                command.getTel()));
    }

    @EventSourcingHandler
    public void on(ClientCreatedEvent event){
        this.clientId = event.getId();
        this.nom = event.getNom();
        this.adresse = event.getAdresse();
        this.email = event.getEmail();
        this.tel = event.getTel();
    }

}
