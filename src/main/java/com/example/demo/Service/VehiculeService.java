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
public class VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;


    public Vehicule createVehicule(Vehicule vehicule)
    {

        return vehiculeRepository.save(vehicule);

    }
    public Vehicule getvehicule(String id)
    {

        return  vehiculeRepository.findById(id).get();
    }


    public void updateVehciule(Vehicule vehicule) {
    }


    public void ajouterVehicule(Client client, Vehicule vehicule) {
        vehicule.setClient(client); // Associer le client au véhicule
        vehiculeRepository.save(vehicule);
    }
}

