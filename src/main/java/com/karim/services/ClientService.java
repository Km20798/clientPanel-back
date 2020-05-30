package com.karim.services;

import com.karim.model.Client;
import com.karim.repository.ClientRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepoistory repoistory;

    public List<Client> getAllClients(){
        return repoistory.findAll();
    }

    public Client getClient(long id ){
        return repoistory.findById(id).get();
    }

    public Client save(Client client){
        return repoistory.save(client);
    }

    public void deleteClient(long id){
        repoistory.deleteById(id);
    }

    public Client UpdateClient(long id ,Client client){
        Client c = getClient(id);
        if(c == null)
            return null ;
        c.setFirstname(client.getFirstname());
        c.setLastname(client.getLastname());
        c.setEmail(client.getEmail());
        c.setPhone(client.getPhone());
        c.setBalance(client.getBalance());
        return repoistory.saveAndFlush(c);
    }

}
