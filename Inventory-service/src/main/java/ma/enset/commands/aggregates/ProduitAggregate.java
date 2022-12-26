package ma.enset.commands.aggregates;


import ma.enset.commands.CreateProduitCommand;
import ma.enset.dtos.Etat;
import ma.enset.events.ProduitCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ProduitAggregate {
    @AggregateIdentifier

    private String id;
    private String nom;
    private double quantite;
    private Etat etat;
    private String category;


    public ProduitAggregate(){

    }

    @CommandHandler
    public ProduitAggregate(CreateProduitCommand command){
        AggregateLifecycle.apply(new ProduitCreatedEvent(
                command.getId(),
                command.getNom(),
                command.getQuantite(),
                command.getEtat(),
                command.getCategory()));
    }

    @EventSourcingHandler
    public void on(ProduitCreatedEvent event){
        this.id= event.getId();
        this.nom=event.getNom();
        this.quantite=event.getQuantite();
        this.etat=event.getEtat();
        this.category=event.getCategory();
    }

}
