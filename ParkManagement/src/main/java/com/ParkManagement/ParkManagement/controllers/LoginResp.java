package com.ParkManagement.ParkManagement.controllers;

public class LoginResp {
    private String token;
    private String secteur;

    public LoginResp() {
    }

    public LoginResp(String token, String secteur) {
        this.token = token;
        this.secteur = secteur;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }
}
