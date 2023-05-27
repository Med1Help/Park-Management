package com.ParkManagement.ParkManagement.controllers;

public class myObject {
   String update;
   String reference;
   Object[] params;

    public myObject() {
    }

    public myObject(String update, String reference, Object[] params) {
        this.update = update;
        this.reference = reference;
        this.params = params;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
