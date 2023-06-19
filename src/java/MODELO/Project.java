/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.InputStream;
import java.time.LocalDate;

/**
 *
 * @author maria
 */
public class Project {
    private int id;
    private String title;
    private String name;
    private int user_id;
    private String img;
    private String description;
    private float goal;
    private LocalDate currentDate;
    private String status;
    private float amount_raised;
    private int donors;

    public Project(int id, String title, String name, int user_id, String img, String description, float goal, LocalDate currentDate, String status, float amount_raised) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.user_id = user_id;
        this.img = img;
        this.description = description;
        this.goal = goal;
        this.currentDate = currentDate;
        this.status = status;
        this.amount_raised = amount_raised;
    }
    
    public Project(String title, String name, int user_id, String img, String description, float goal, LocalDate currentDate) {
        this.title = title;
        this.name = name;
        this.user_id = user_id;
        this.img = img;
        this.description = description;
        this.goal = goal;
        this.currentDate = currentDate;
    }

    public Project(String title, String name, int user_id, String img, String description, float goal, String status) {
        this.title = title;
        this.name = name;
        this.user_id = user_id;
        this.img = img;
        this.description = description;
        this.goal = goal;
        this.status = status;
    }

    public Project(int Vid, String Vtitle, String Vname, int VuserId, int VimgId, String Vdesc, float Vgoal, LocalDate Vdate, String Vstatus, float Vamount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Project(int id) {
        this.id = id;
    }
    
    
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getAmount_raised() {
        return amount_raised;
    }

    public void setAmount_raised(float amount_raised) {
        this.amount_raised = amount_raised;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }
    
    
    
    



}
