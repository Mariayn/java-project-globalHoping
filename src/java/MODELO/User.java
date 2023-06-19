/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author maria
 */
public class User {
    private int id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String cif;
    private String address;
    private String phone;
    private String Rol;

    public User(int id, String name, String lastname, String email, String password, String cif, String address, String phone, String Rol) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.cif = cif;
        this.address = address;
        this.phone = phone;
        this.Rol = Rol;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(int id, String name, String lastname, String email, String password, String Rol) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.Rol = Rol;
    }

    public User(String name, String lastname, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public User(String name, String lastname, String email, String cif, String address, String phone) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.cif = cif;
        this.address = address;
        this.phone = phone;
    }

    public User(String password) {
        this.password = password;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String surname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }
    
    
    
    
    
    
}
