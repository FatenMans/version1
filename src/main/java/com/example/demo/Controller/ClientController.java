package com.example.demo.Controller;

import com.example.demo.Entite.Client;
import com.example.demo.Entite.EmailDetails;
import com.example.demo.Repository.ClientRepository;
import com.example.demo.Service.ClientService;
import com.example.demo.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmailService emailService;

    @PostMapping("/create")
    public Client createclient(@RequestBody Client client){
        return clientService.createClient(client);
    }
    @GetMapping("/{id}")
    public Client getclient(@PathVariable String id)
    {
        return clientService.getclient(id);
    }

    @PostMapping("/activer/{id}")
    public String activerClient(@PathVariable String id) {
        Client client = clientRepository.findById(id).orElse(null);

        if (client != null) {
            client.setEstActif(true);
            clientRepository.save(client); // Cette ligne mettra à jour le compte dans la base de données
            return "Le compte client a été activé avec succès.";
        } else {
            return "Le compte client n'existe pas.";
        }
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody EmailDetails emailDetails) {
        String status = emailService.sendSimpleMail(emailDetails);
        return status;
    }
    @PostMapping("/archiver/{id}")
    public String archiverClient(@PathVariable String id) {
        Client client = clientRepository.findById(id).orElse(null);

        if (client != null) {
            client.setEstArchive(true);
            clientRepository.save(client); // Cette ligne mettra à jour le compte dans la base de données
            return "Le compte client a été archivé avec succès.";
        } else {
            return "Le compte client n'existe pas.";
        }
    }

}
