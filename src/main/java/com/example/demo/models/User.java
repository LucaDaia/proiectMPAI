package com.example.demo.models;

public class User implements UserInterface {

    private static int idUser;
    private String name;
    private String mail;



    @Override
    public boolean reserveRoom() {
        return false;
    }
}
