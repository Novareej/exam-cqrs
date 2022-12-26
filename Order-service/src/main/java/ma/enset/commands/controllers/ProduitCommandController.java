package ma.enset.commands.controllers;

import lombok.AllArgsConstructor;
import ma.enset.commands.CreateProduitCommand;
import ma.enset.dtos.ProduitRequestDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
@RestController
@RequestMapping("/command/produit")
@Service
@AllArgsConstructor
public class ProduitCommandController {
    private CommandGateway commandGateway;

    @PostMapping(path="/create")
    public CompletableFuture<String> createProduit(ProduitRequestDto produitRequestDto){
        CompletableFuture<String> response = commandGateway.send(new CreateProduitCommand(
                UUID.randomUUID().toString(),
                produitRequestDto.getNom(),
                produitRequestDto.getQuantite(),
                produitRequestDto.getEtat(),
                produitRequestDto.getCategory()

        ));
        return response;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
