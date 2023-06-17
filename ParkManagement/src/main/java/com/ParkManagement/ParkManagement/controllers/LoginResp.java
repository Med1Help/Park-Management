package com.ParkManagement.ParkManagement.controllers;

public class LoginResp {
    private String token;
    private String secteur;

    private String role;

    public LoginResp() {
    }

    public LoginResp(String token, String secteur,String role) {
        this.token   = token;
        this.secteur = secteur;
        this.role    = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
