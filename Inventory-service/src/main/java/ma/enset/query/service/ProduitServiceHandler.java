package ma.enset.query.service;

import lombok.AllArgsConstructor;
import ma.enset.events.ProduitCreatedEvent;
import ma.enset.queries.GetAllClients;
import ma.enset.query.entities.Produit;
import ma.enset.query.repositories.ProduitRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ProduitServiceHandler {
    private ProduitRepository produitRepository;

    @EventHandler
    @Transactional
    public void on(ProduitCreatedEvent produitCreatedEvent){
        Produit produit = new Produit();
        produit.setId(produitCreatedEvent.getId());
        produit.setNom(produitCreatedEvent.getNom());
        produit.setQuantite(produitCreatedEvent.getQuantite());
        produitRepository.save(produit);


    }

    @QueryHandler
    public List<Produit> on(GetAllClients query){
        return produitRepository.findAll();
    }
}
