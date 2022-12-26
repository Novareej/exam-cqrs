package ma.enset.commands.controllers;

import lombok.AllArgsConstructor;
import ma.enset.commands.CreateClientCommand;
import ma.enset.dtos.ClientRequestDto;
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
@RequestMapping("/command/client")
@Service
@AllArgsConstructor
public class ClientCommandController {
    private CommandGateway commandGateway;

    @PostMapping(path="/create")
    public CompletableFuture<String> createClient(ClientRequestDto clientRequestDto){
        CompletableFuture<String> response = commandGateway.send(new CreateClientCommand(
                UUID.randomUUID().toString(),
                clientRequestDto.getNom(),
                clientRequestDto.getAdresse(),
                clientRequestDto.getEmail(),
                clientRequestDto.getTel()

        ));
        return response;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
