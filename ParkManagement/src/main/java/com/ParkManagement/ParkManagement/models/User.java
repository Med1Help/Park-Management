package com.ParkManagement.ParkManagement.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class User implements UserDetails {
    int id;
    String name;
    String e_mail;
    String role;
    String secteur;
    String password;
    public User() {
    }
    public User(String e_mail,String password) {
        this.e_mail     = e_mail;
        this.password   = password;
    }
    public User(String name, String e_mail, String role,String password,String secteur) {
        this.name       = name;
        this.e_mail     = e_mail;
        this.password   = password;
        this.role       = role;
        this.secteur    = secteur;
    }
    public User(int id,String name, String e_mail, String role,String password, String secteur) {
        this.id         = id;
        this.name       = name;
        this.e_mail     = e_mail;
        this.password   = password;
        this.role       = role;
        this.secteur    = secteur;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.getRole()));
    }
    public void setPassword(String password){
        this.password = password;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return e_mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
