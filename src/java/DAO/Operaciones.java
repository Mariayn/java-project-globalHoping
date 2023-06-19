/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.Donation;
import MODELO.Images;
import MODELO.Project;
import MODELO.User;
import MODELO.myException;
import MODELO.project_donation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.*;

/**
 *
 * @author maria
 */
public class Operaciones {

    public boolean validateName(String registerUser) {
        String validName="^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$"; 
        boolean result;
        
        // Compile the ReGex
        Pattern p = Pattern.compile(validName);
        
        if(registerUser == null){// If the username is empty-return false 
            System.out.println("nombre vacio");
            
            result =  false;
        }
        Matcher m = p.matcher(registerUser);
        result =  m.matches();
         return result;
    }
    
    public boolean validateEmail(String Vemail){
        String validEmail="^[a-zA-Z0-9]{0,30}@[a-zA-Z]{0,10}.[a-zA-Z]{2,3}$";
        boolean result;
        //SURNAME
        Pattern pEmail = Pattern.compile(validEmail);
                System.out.println(Vemail);
        if(Vemail == null){
            System.out.println("email vacio");
            result =  false;
        }
        Matcher ln = pEmail.matcher(Vemail);
        result =  ln.matches();
        System.out.println(result);
        return result;
    }
    
    public boolean validatePass(String Vpass){
        String pattern = "(?=[#$-/:-?{-~!\"^_`\\[\\]a-zA-Z]*([0-9#$-/:-?{-~!\"^_`\\[\\]]))(?=[#$-/:-?{-~!\"^_`\\[\\]a-zA-Z0-9]*[a-zA-Z])[#$-/:-?{-~!\"^_`\\[\\]a-zA-Z0-9]{6,}";
        boolean result;
        
        Pattern pEmail = Pattern.compile(pattern);
                System.out.println(Vpass);
        if(Vpass == null){
            System.out.println("pass vacio");
            result =  false;
        }
        Matcher ln = pEmail.matcher(Vpass);
        result =  ln.matches();
        System.out.println(result);
        return result;      
    }
    
    public boolean validatePhone(String Vphone){
        String pattern = "^6\\d{8}$|^7[1-9]\\d{7}$";
        boolean result;
        
        Pattern pPhone = Pattern.compile(pattern);
        System.out.println("phone : " + Vphone);
        
        if(Vphone == null){
            System.out.println("pass vacio");
            result =  false;
        }
        Matcher ln = pPhone.matcher(Vphone);
        result =  ln.matches();
        System.out.println(result);
        return result;    
        
    }
    
    public void register(User regUser, Connection Con) throws myException {
        //String SQL = "INSERT INTO user VALUES (NULL,?,AES_ENCRYPT(?, 'mar'),?,?,?,?,'USER')";
        try{
        String SQL = "INSERT INTO user VALUES (NULL,?,?,?,AES_ENCRYPT(?, 'mar'),NULL,NULL,NULL,'user')";
        
        PreparedStatement ps = Con.prepareStatement(SQL);
        
        ps.setString(1, regUser.getName());
        ps.setString(2, regUser.getLastname());
        ps.setString(3, regUser.getEmail());
        ps.setString(4, regUser.getPassword());
        
        int executep = ps.executeUpdate();
        
        if(executep != 1){
            throw new myException(200,"No se pudo completar el registro","función register","../logoutController");
        }
         }catch(SQLException SQLE){
            String Mensaje = SQLE.getMessage();
            int CodigoError = SQLE.getErrorCode();
            throw new myException(CodigoError,Mensaje,"función register","../logoutController");
        }
    }
    
    public User login(User loginForm,Connection con) throws myException{
        User user  = null;
        
        try{
            String SQL = "SELECT * FROM user WHERE email=? AND AES_DECRYPT(password, 'mar')=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1, loginForm.getEmail());
            ps.setString(2, loginForm.getPassword());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                String surname = rs.getString("lastname");
                String  email = rs.getString("email");
                String  pass = rs.getString("password");
                String  cif = rs.getString("cif");
                String  address = rs.getString("address");
                String  phone = rs.getString("phone");
                String rol = rs.getString("rol");
                
                user = new User(id,name,surname,email,pass,cif,address,phone,rol);
                System.out.println("user" + user);
            }
            
        }catch(SQLException SQLE){
            String Mensaje = SQLE.getMessage();
            int CodigoError = SQLE.getErrorCode();
            throw new myException(CodigoError,Mensaje,"función login","../logoutController");
        }
    
        return user;
    }
    
    public void update(User userForm, int id, Connection con) throws myException{
        try{
            System.out.println("try ");
            String SQL = "UPDATE user SET name=?, lastname=?, email=?, cif=?, address=?, phone=? WHERE id =?";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1, userForm.getName());
            ps.setString(2, userForm.getLastname());
            ps.setString(3, userForm.getEmail());
            ps.setString(4, userForm.getCif());
            ps.setString(5, userForm.getAddress());
            ps.setString(6, userForm.getPhone());
            ps.setInt(7, id);
            System.out.println("0");
            int rowAffected = ps.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            
            if(rowAffected !=1){
                throw new myException(300,"No se pudieron actualizar los datos del usuario","funcion update","./userProfile.jsp");
            }      
            
        }
        catch(SQLException SQLE){
            String Mensaje = SQLE.getMessage();
            int CodigoError = SQLE.getErrorCode();
            throw new myException(CodigoError,Mensaje,"funcion update","./userProfile.jsp");
        }
    }
    
    public void changePass(User userForm, int id, Connection con) throws myException{
        try{
            String SQL = "UPDATE user SET password=AES_ENCRYPT(?, 'mar') WHERE id=?";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1, userForm.getPassword());
            ps.setInt(2, id); 
            
            int rowAffected = ps.executeUpdate();
            System.out.println("Vpass5");
            if(rowAffected !=1){
                throw new myException(300,"No se pudo  actualizar la contraseña del usuario","función changePass","./userProfile.jsp");
            }   
        }
        catch(SQLException SQLE){
            String Mensaje = SQLE.getMessage();
            int CodigoError = SQLE.getErrorCode();
            throw new myException(CodigoError,Mensaje,"función changePass","./userProfile.jsp");
        }
    }
    
    public void createProject(Project projectObj,Connection con) throws myException{
        try{
        String SQL = "INSERT INTO project VALUES (NULL,?,?,?,?,?,?,?,'no active',0)";
        System.out.println("a");
        PreparedStatement ps = con.prepareStatement(SQL);
   System.out.println("b");
        ps.setString(1, projectObj.getTitle());
        ps.setString(2, projectObj.getName());
        ps.setInt(3, projectObj.getUser_id());
        ps.setString(4, projectObj.getImg());
        ps.setString(5, projectObj.getDescription());
        ps.setFloat(6, projectObj.getGoal());
        ps.setDate(7, java.sql.Date.valueOf(projectObj.getCurrentDate()));
        
         int executep = ps.executeUpdate();
        System.out.println("op 1");
        if(executep != 1){
            throw new myException(301,"Error al crear el proyecto","función createProject","../getImagesController");
            //algo fue mal
        }
       System.out.println("op 2");
    }   catch(SQLException SQLE){
            String Mensaje = SQLE.getMessage();
            int CodigoError = SQLE.getErrorCode();
            throw new myException(CodigoError,Mensaje,"función createProject","../getImagesController");
        }}
    
    public ArrayList<Images> getImages(Connection con) throws myException{
          ArrayList<Images> ArrayImages = new ArrayList();
          
          try{
              String SQL = "SELECT * FROM fundraisers_images";
              PreparedStatement ps = con.prepareStatement(SQL);
              
              ResultSet rs = ps.executeQuery();
              
              while(rs.next()){
                  int Vid = rs.getInt("id");
                  String Vruta = rs.getString("ruta");
                  
                  Images objImages = new Images(Vid,Vruta);
                  ArrayImages.add(objImages);
              }
          }catch(SQLException SQLE){
                String Mensaje = SQLE.getMessage();
                 int CodigoError = SQLE.getErrorCode();
                throw new myException(CodigoError,Mensaje,"función getImages","./userProfile.jsp");
          }
          return ArrayImages;
          
    }
    
    
    public ArrayList<Project> getProjects(Connection con) throws myException{
        ArrayList<Project> ArrayProjects = new ArrayList();
          
          try{
              String SQL = "SELECT * FROM project";
              PreparedStatement ps = con.prepareStatement(SQL);
              
              ResultSet rs = ps.executeQuery();
                     System.out.println("1");
              while(rs.next()){
                     System.out.println("2");
                  int Vid = rs.getInt("id");
                  String Vtitle = rs.getString("project_title");
                  String Vname = rs.getString("name");
                  int VuserId = rs.getInt("user_id");
                  String VimgId = Integer.toString(rs.getInt("img"));//lo paso a string porque en la clase proeycto la var IMG esta declarado string y en heidi como int
                  String Vdesc = rs.getString("description");
                  float Vgoal = rs.getFloat("fund_goal");
                  LocalDate Vdate = rs.getDate("current_date").toLocalDate();
                  String Vstatus = rs.getString("status");
                  float Vamount = rs.getFloat("amount_raised");
                     System.out.println("3");
                  Project obj = new Project(Vid,Vtitle,Vname,VuserId,VimgId,Vdesc,Vgoal,Vdate,Vstatus,Vamount);
                     System.out.println("4");
                  ArrayProjects.add(obj);
                     System.out.println("5");
              }
          }catch(SQLException SQLE){
                String Mensaje = SQLE.getMessage();
                 int CodigoError = SQLE.getErrorCode();
                throw new myException(CodigoError,Mensaje,"función getProjects","../getImagesController3");
          }
             System.out.println("6");
          return ArrayProjects;
          
}
    
    public ArrayList<User> getUsers(Connection con) throws myException{
        ArrayList<User> ArrayUsers = new ArrayList();
          
          try{
              String SQL = "SELECT * FROM user";
              PreparedStatement ps = con.prepareStatement(SQL);
              
              ResultSet rs = ps.executeQuery();
              
              while(rs.next()){
                  int id = rs.getInt("id");
                String  name = rs.getString("name");
                String surname = rs.getString("lastname");
                String  email = rs.getString("email");
                String  pass = rs.getString("password");
                String  cif = rs.getString("cif");
                String  address = rs.getString("address");
                String  phone = rs.getString("phone");
                String rol = rs.getString("rol");
       
                  User obj = new User(id,name,surname,email,pass,cif,address,phone,rol);
                  ArrayUsers.add(obj);
              }
          }catch(SQLException SQLE){
                 String Mensaje = SQLE.getMessage();
                 int CodigoError = SQLE.getErrorCode();
                throw new myException(CodigoError,Mensaje,"funcion getUsers","../getImagesController3");
          }
          return ArrayUsers;
       
    }
    
    public void projectApproval(int id, Connection con) throws myException{
        
        try{
            String SQL = "UPDATE project SET status='active' WHERE id =?";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setInt(1,id);
            
            int rowAffected = ps.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            
            if(rowAffected !=1){
                   throw new myException(305,"Error al aprobar el proyecto","función projectApproval","./projectInfo.jsp");
            }
        }
        catch(SQLException SQLE){
             String Mensaje = SQLE.getMessage();
                 int CodigoError = SQLE.getErrorCode();
                throw new myException(CodigoError,Mensaje,"función projectApproval","./projectInfo.jsp");
        }
        
        
    }
    
    public ArrayList<Project> getMainProjects(Connection con)throws myException{
        ArrayList<Project> ArrayProjects = new ArrayList();
          
          try{
              String SQL = "SELECT * FROM project ORDER BY amount_raised DESC LIMIT 4";
              PreparedStatement ps = con.prepareStatement(SQL);
              
              ResultSet rs = ps.executeQuery();
                     System.out.println("1");
              while(rs.next()){
                     System.out.println("2");
                  int Vid = rs.getInt("id");
                  String Vtitle = rs.getString("project_title");
                  String Vname = rs.getString("name");
                  int VuserId = rs.getInt("user_id");
                  String VimgId = Integer.toString(rs.getInt("img"));//lo paso a string porque en la clase proeycto la var IMG esta declarado string y en heidi como int
                  String Vdesc = rs.getString("description");
                  float Vgoal = rs.getFloat("fund_goal");
                  LocalDate Vdate = rs.getDate("current_date").toLocalDate();
                  String Vstatus = rs.getString("status");
                  float Vamount = rs.getFloat("amount_raised");
                     System.out.println("3");
                  Project obj = new Project(Vid,Vtitle,Vname,VuserId,VimgId,Vdesc,Vgoal,Vdate,Vstatus,Vamount);
                     System.out.println("4");
                  ArrayProjects.add(obj);
                     System.out.println("5");
              }
          }catch(SQLException SQLE){
                 String Mensaje = SQLE.getMessage();
                 int CodigoError = SQLE.getErrorCode();
                throw new myException(CodigoError,Mensaje,"función getMainProjects","../getImagesController3");
          }
             System.out.println("6");
          return ArrayProjects;
        
        
    }
            
            public ArrayList<Project> getAllProjects(Connection con)throws myException{
                ArrayList<Project> ArrayProjects = new ArrayList();
          
          try{
              String SQL = "SELECT * FROM project WHERE STATUS='active'";
              PreparedStatement ps = con.prepareStatement(SQL);
              
              ResultSet rs = ps.executeQuery();
  
              while(rs.next()){
            
                  int Vid = rs.getInt("id");
                  String Vtitle = rs.getString("project_title");
                  String Vname = rs.getString("name");
                  int VuserId = rs.getInt("user_id");
                  String VimgId = Integer.toString(rs.getInt("img"));//lo paso a string porque en la clase proeycto la var IMG esta declarado string y en heidi como int
                  String Vdesc = rs.getString("description");
                  float Vgoal = rs.getFloat("fund_goal");
                  LocalDate Vdate = rs.getDate("current_date").toLocalDate();
                  String Vstatus = rs.getString("status");
                  float Vamount = rs.getFloat("amount_raised");
              
                  Project obj = new Project(Vid,Vtitle,Vname,VuserId,VimgId,Vdesc,Vgoal,Vdate,Vstatus,Vamount);
          
                  ArrayProjects.add(obj);
        
              }
          }catch(SQLException SQLE){
                               String Mensaje = SQLE.getMessage();
                 int CodigoError = SQLE.getErrorCode();
                throw new myException(CodigoError,Mensaje,"función getAllProjects","../getImagesController3");
          }

          return ArrayProjects;
                
                
            }
                    
          public void  donate(Donation obj,Connection con) throws  myException{
          try{
              
              String SQL = "INSERT INTO donation VALUES (NULL,?,?,?,?,?,?)";
                System.out.println("a");
                PreparedStatement ps = con.prepareStatement(SQL);
                System.out.println("b");
                ps.setInt(1, obj.getProjectId());
                ps.setString(2, obj.getFullName());
                ps.setString(3, obj.getEmail());
                ps.setInt(4, obj.getUserId());
                ps.setString(5, obj.getNumberCard());
                ps.setFloat(6, obj.getAmount());
        
                int executep = ps.executeUpdate();
               System.out.println("op 111");
               if(executep != 1){
                   System.out.println("nadaaaa");
                   //algo fue mal
               }
              System.out.println("op 222");
  
              // update AMOUNT_RAISE from  project table
                    float cantidad = obj.getAmount();
                    int myId = obj.getProjectId();
                    //UPDATE project SET amount_raised=(amount_raised+50) WHERE id=8
                    String sqlUpdate = "UPDATE project SET amount_raised=(amount_raised+"+cantidad+") WHERE id="+myId;
                    PreparedStatement ps2 = con.prepareStatement(sqlUpdate);
              System.out.println("linea 462");
                    int rowAffected = ps2.executeUpdate();
                    System.out.println(String.format(" PS2 Row affected %d", rowAffected));
 System.out.println("linea 465");
                    if(rowAffected !=1){
                   throw new myException(306,"No se pudo realizar la donacion","funcion donate","../getImagesController3");
                  }
              
            }catch(SQLException SQLE){
                 String Mensaje = SQLE.getMessage();
                 int CodigoError = SQLE.getErrorCode();
                 throw new myException(CodigoError,Mensaje,"funcion donate","../getImagesController3");
            }
                  
          }
          
          
          public void contactForm(String name,String lastname,String tel,String email,String asunto,String mje,LocalDate currentDate, Connection con) throws myException{
              
              try{
              String SQL = "INSERT INTO form_contacto VALUES (NULL,?,?,?,?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(SQL);
        
        ps.setString(1, name);
        ps.setString(2, lastname);
        ps.setString(3, tel);
        ps.setString(4, email);
        ps.setString(5, asunto);
        ps.setString(6, mje);
       ps.setDate(7, java.sql.Date.valueOf(currentDate));
       
        int executep = ps.executeUpdate();
        
        if(executep != 1){
                             throw new myException(308,"No se pudo enviar el formulario, intentalo de nuevo más adelante","función contactForm","./formularioContacto.jsp");
        }
              
            }catch(SQLException SQLE){
                 String Mensaje = SQLE.getMessage();
                 int CodigoError = SQLE.getErrorCode();
                 throw new myException(CodigoError,Mensaje,"función contactForm","./formularioContacto.jsp");
            }

    
}
        
     public ArrayList<project_donation> getMyDonations(String variable,Connection con) throws myException{
        ArrayList<project_donation> ArrayProjects = new ArrayList();
          
          try{
              String SQL = "SELECT project_title,name,amount,status FROM project,donation WHERE donation.user_id="+variable+" AND donation.project_id=project.id";
              PreparedStatement ps = con.prepareStatement(SQL);
              
              ResultSet rs = ps.executeQuery();
                     System.out.println("1");
              while(rs.next()){

                  //int Vid = rs.getInt("id");
                  String Vtitle = rs.getString("project_title");
                  String Vname = rs.getString("name");
                  String Vstatus = rs.getString("status");
                  float Vamount = rs.getFloat("amount");
               
                  project_donation obj = new project_donation(Vtitle,Vname,Vamount,Vstatus);
                     System.out.println("4");
                  ArrayProjects.add(obj);
                     System.out.println("5");
              }
          }catch(SQLException SQLE){
                String Mensaje = SQLE.getMessage();
                 int CodigoError = SQLE.getErrorCode();
                throw new myException(CodigoError,Mensaje,"función getMyDonations","./userProfile");
          }
             System.out.println("6");
          return ArrayProjects;   
}
        
        public void rejectProject(int id, Connection con) throws myException{
        
        try{
            String SQL = "DELETE FROM project WHERE id =?";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setInt(1,id);
            
            int rowAffected = ps.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            
            if(rowAffected !=1){
                   throw new myException(305,"Error al rechazar proyecto","función rejectProject","./projectInfo.jsp");
            }
        }
        catch(SQLException SQLE){
             String Mensaje = SQLE.getMessage();
                 int CodigoError = SQLE.getErrorCode();
                throw new myException(CodigoError,Mensaje,"función rejectProject","./projectInfo.jsp");
        }
        
        
    }
     
     
     
   /*public void createFile() throws myException, IOException{
        File myObj = new File("../FILES/filename.txt");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
            
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
        } else {
            System.out.println("File already exists.");
        }
     }*/
        
        
          
}
