package com.example.demo.Entite;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "clients")
public class Client {

    @Id
    private String id;
    private String raisonSociale;
    private String matriculeSociale;
    private String siegeSocial;
    private String email;
    private String telephone;
    private String secteurActivite;
    private String nomComplet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
