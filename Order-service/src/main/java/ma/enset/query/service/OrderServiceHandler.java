package ma.enset.query.service;

import lombok.AllArgsConstructor;
import ma.enset.events.OrderCreatedEvent;
import ma.enset.events.ProduitCreatedEvent;
import ma.enset.queries.GetAllClients;
import ma.enset.query.entities.Order;
import ma.enset.query.entities.Produit;
import ma.enset.query.repositories.OrderRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceHandler {
    private OrderRepository orderRepository;

    @EventHandler
    @Transactional
    public void on(OrderCreatedEvent orderCreatedEvent){
        Order order= new Order();
        order.setId(orderCreatedEvent.getId());
        order.setDate_cmd(orderCreatedEvent.getDate_cmd());
        order.setDate_livr(orderCreatedEvent.getDate_livr());
        orderRepository.save(order);


    }

    @QueryHandler
    public List<Order> on(GetAllClients query){
        return orderRepository.findAll();
    }
}
