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
public class Donation {
    private int id;
    private int projectId;
    private String fullName;
    private String email;
    private int userId;
    private String numberCard;
    private float amount;

    public Donation(int projectId, String fullName, String email, int userId, String numberCard, float amount) {

        this.projectId = projectId;
        this.fullName = fullName;
        this.email = email;
        this.userId = userId;
        this.numberCard = numberCard;
        this.amount = amount;
    }

    public Donation(int projectId, String fullName, String email, String numberCard, float amount) {
        this.projectId = projectId;
        this.fullName = fullName;
        this.email = email;
        this.numberCard = numberCard;
        this.amount = amount;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    
    
}
