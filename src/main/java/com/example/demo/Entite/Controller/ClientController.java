package com.example.demo.Entite.Controller;

import com.example.demo.Entite.Client;
import com.example.demo.Repository.ClientRepository;
import com.example.demo.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public Client createclient(@RequestBody Client client){
        return clientService.createClient(client);
    }
    @GetMapping("/getByid")
    public Client getclient(@RequestParam String id)
    {
        return clientService.getclient(id);
    }
}
