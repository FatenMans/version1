package com.example.demo.Service;

import com.example.demo.Entite.Client;
import com.example.demo.Entite.Vehicule;
import com.example.demo.Repository.ClientRepository;
import com.example.demo.Repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private VehiculeRepository vehiculeRepository;




    public Client createClient(Client client)
    {
        System.out.println(client.getEmail());
 return clientRepository.save(client);
    }
    public  Client getclient( String id)
    {

        return  clientRepository.findById(id).get();
    }


    public void updateClient(Client client) {
    }

//    public void ajouterClientAuVehicule(String VehiculeId, Client client) {
//      Vehicule vehicule = vehiculeRepository.findById(VehiculeId).orElse(null);
//
//        if (vehicule != null) {
//            vehicule.setClient(client);
//
//            client.getVehicules().add(vehicule);
//            clientRepository.save(client);
//            vehiculeRepository.save(vehicule);
//        }
//    }

    public void ajouterVehiculeAuClient(String clientId, String vehiculeId) {
        Client client = clientRepository.findById(clientId).orElse(null);
        Vehicule vehicule = vehiculeRepository.findById(vehiculeId).orElse(null);

        if (client != null && vehicule != null) {
            vehicule.setClient(client);
            client.getVehicules().add(vehicule);
            vehiculeRepository.save(vehicule);
            clientRepository.save(client);
        }
    }





}
