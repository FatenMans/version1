package com.example.demo.Service;

import com.example.demo.Entite.Client;
import com.example.demo.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public  Client createClient(Client client)
    {
 return clientRepository.save(client);
    }
    public  Client getclient( String id)
    {
        return  clientRepository.findById(id).get();
    }
}
