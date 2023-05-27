package com.ParkManagement.ParkManagement.models;

public class Rider {
   int id;
   String name;
   String e_mail;
   int manager_id;
   String secteur;
   String permis;
   long points;
   String phone_number;

    public Rider() {
    }

    public Rider(String name, String e_mail, int manager_id, String secteur, String permis, long points, String phone_number) {
        this.name = name;
        this.e_mail = e_mail;
        this.manager_id = manager_id;
        this.secteur = secteur;
        this.permis = permis;
        this.points = points;
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

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getPermis() {
        return permis;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", manager_id=" + manager_id +
                ", secteur='" + secteur + '\'' +
                ", permis='" + permis + '\'' +
                ", points=" + points +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
