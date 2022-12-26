package ma.enset.query.controllers;

import lombok.AllArgsConstructor;
import ma.enset.queries.GetAllClients;
import ma.enset.query.entities.Client;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/query/client")
@AllArgsConstructor
public class ClientRestController {

    private QueryGateway queryGateway;

    @GetMapping("/all")
    public List<Client> getAll(){
            List<Client> clients= queryGateway.query(new GetAllClients(), ResponseTypes.multipleInstancesOf(Client.class)).join();
            return clients;
    }
}
