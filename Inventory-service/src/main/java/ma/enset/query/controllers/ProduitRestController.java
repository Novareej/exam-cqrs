package ma.enset.query.controllers;

import lombok.AllArgsConstructor;
import ma.enset.queries.GetAllProduits;
import ma.enset.query.entities.Produit;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/query/produits")
@AllArgsConstructor
public class ProduitRestController {

    private QueryGateway queryGateway;

    @GetMapping("/all")
    public List<Produit> getAll(){
        return queryGateway.query(new GetAllProduits(), ResponseTypes.multipleInstancesOf(Produit.class)).join();

    }
}
