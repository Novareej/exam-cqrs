package ma.enset.commands.aggregates;


import ma.enset.commands.CreateCategoryCommand;
import ma.enset.events.CategoryCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CategoryAggregate {
    @AggregateIdentifier
    private String id;
    private String nom;
    private String description;


    public CategoryAggregate(){

    }

    @CommandHandler
    public CategoryAggregate(CreateCategoryCommand command){

        AggregateLifecycle.apply(new CategoryCreatedEvent(
                command.getId(),
                command.getNom(),
                command.getDescription()));
    }

    @EventSourcingHandler
    public void on(CategoryCreatedEvent event){
        this.id= event.getId();
        this.nom=event.getNom();
        this.description= event.getDescription();
    }

}
