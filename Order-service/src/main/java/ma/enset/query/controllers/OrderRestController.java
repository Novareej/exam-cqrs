package ma.enset.query.controllers;

import lombok.AllArgsConstructor;
import ma.enset.queries.GetAllOrders;
import ma.enset.queries.GetAllProduits;
import ma.enset.query.entities.Order;
import ma.enset.query.entities.Produit;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/query/orders")
@AllArgsConstructor
public class OrderRestController {

    private QueryGateway queryGateway;

    @GetMapping("/all")
    public List<Order> getAll(){
            List<Order> orders= queryGateway.query(new GetAllOrders(), ResponseTypes.multipleInstancesOf(Order.class)).join();
            return orders;
    }
}
