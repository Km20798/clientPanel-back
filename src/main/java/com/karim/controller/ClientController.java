package com.karim.controller;

import com.karim.model.Client;
import com.karim.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping()
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients = service.getAllClients();
        if(clients.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<Client>>(clients , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable long id){
        Client client = service.getClient(id);
        if(client == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Client>(client , HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        service.save(client);
        return new ResponseEntity<Client>(client , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable long id){
        Client client = service.getClient(id);
        if(client == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        service.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable long id , @RequestBody Client client){
        Client c = service.getClient(id);
        if(c==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        service.UpdateClient(id , client);
        return new ResponseEntity<Client>(service.getClient(id) , HttpStatus.OK);
    }

}
