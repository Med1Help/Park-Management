package com.ParkManagement.ParkManagement.models;

public class Manager {
    int id ;
    String name;
    String e_mail;
    int lead_id;
    String secteur;
    String phone_number;

    public Manager() {
    }

    public Manager(String name, String e_mail, int lead_id, String secteur, String phone_number) {
        this.name = name;
        this.e_mail = e_mail;
        this.lead_id = lead_id;
        this.secteur = secteur;
        this.phone_number = phone_number;
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

    public int getLead_id() {
        return lead_id;
    }

    public void setLead_id(int lead_id) {
        this.lead_id = lead_id;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", lead_id=" + lead_id +
                ", secteur='" + secteur + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
