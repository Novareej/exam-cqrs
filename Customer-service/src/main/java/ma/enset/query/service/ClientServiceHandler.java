package ma.enset.query.service;

import lombok.AllArgsConstructor;
import ma.enset.events.ClientCreatedEvent;
import ma.enset.queries.GetAllClients;
import ma.enset.query.entities.Client;
import ma.enset.query.repositories.ClientRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceHandler {
    private ClientRepository clientRepository;

    @EventHandler
    @Transactional
    public void on(ClientCreatedEvent clientCreatedEvent){
        Client client = new Client();
        client.setId(clientCreatedEvent.getId());
        client.setNom(clientCreatedEvent.getNom());
        client.setAdresse(clientCreatedEvent.getAdresse());
        client.setEmail(clientCreatedEvent.getEmail());
        client.setTel(clientCreatedEvent.getTel());
        clientRepository.save(client);
    }

    @QueryHandler
    public List<Client> on(GetAllClients query){
        return clientRepository.findAll();
    }
}
