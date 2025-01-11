package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table
public class User implements UserInterface {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private int idUser;
    private String name;
    private String mail;

    public User(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }


    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }



    @Override
    public boolean reserveRoom() {
        return false;
    }
}
