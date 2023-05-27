package com.ParkManagement.ParkManagement.models;

public class Lead_manager {
    int id ;
    String name;
    String e_mail;
    String secteur;

    public Lead_manager() {
    }

    public Lead_manager(String name, String e_mail, String secteur) {
        this.name = name;
        this.e_mail = e_mail;
        this.secteur = secteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    @Override
    public String toString() {
        return "Lead_manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", secteur='" + secteur + '\'' +
                '}';
    }
}
