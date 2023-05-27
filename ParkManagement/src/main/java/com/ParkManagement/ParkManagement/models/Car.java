package com.ParkManagement.ParkManagement.models;

public class Car {
    int id;
    String matricule;
    String permition;
    String visite;
    String assurance;
    String vignette;
    String secteur;

    public Car() {
    }

    public Car(String matricule, String permition, String visite, String assurance, String vignette, String secteur) {
        this.matricule = matricule;
        this.permition = permition;
        this.visite = visite;
        this.assurance = assurance;
        this.vignette = vignette;
        this.secteur = secteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPermition() {
        return permition;
    }

    public void setPermition(String permition) {
        this.permition = permition;
    }

    public String getVisite() {
        return visite;
    }

    public void setVisite(String visite) {
        this.visite = visite;
    }

    public String getAssurance() {
        return assurance;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }

    public String getVignette() {
        return vignette;
    }

    public void setVignette(String vignette) {
        this.vignette = vignette;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", matricule='" + matricule + '\'' +
                ", permition='" + permition + '\'' +
                ", visite='" + visite + '\'' +
                ", assurance='" + assurance + '\'' +
                ", vignette='" + vignette + '\'' +
                ", secteur='" + secteur + '\'' +
                '}';
    }
}
