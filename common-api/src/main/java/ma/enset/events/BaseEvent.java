package ma.enset.events;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseEvent<T> {
    @TargetAggregateIdentifier
    @Getter
    public T id;

    public BaseEvent(T id) {
        this.id = id;
    }

}
