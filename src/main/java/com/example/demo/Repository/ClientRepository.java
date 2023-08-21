package com.example.demo.Repository;

import com.example.demo.Entite.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client,String> {
}
