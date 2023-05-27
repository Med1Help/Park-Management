package com.ParkManagement.ParkManagement.models;

import java.sql.Date;

public class Affectation {
    int id;
    int id_car;
    int id_rider;
    Date date_debut;
    Date date_fin;

    public Affectation() {
    }

    public Affectation(int id_car, int id_rider, Date date_debut, Date date_fin) {
        this.id_car = id_car;
        this.id_rider = id_rider;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public int getId_rider() {
        return id_rider;
    }

    public void setId_rider(int id_rider) {
        this.id_rider = id_rider;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "Affectation{" +
                "id=" + id +
                ", id_car=" + id_car +
                ", id_rider=" + id_rider +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                '}';
    }
}
