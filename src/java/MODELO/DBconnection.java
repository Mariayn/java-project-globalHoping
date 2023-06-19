
package MODELO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author maria
 */
public class DBconnection {
    private static DBconnection connectionUnique = null;
    private Connection Con;
    
    private DBconnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://localhost:3306/fundraisingdb";
        Con = DriverManager.getConnection(connectionUrl,"root","");
        System.out.println("Conexion establecida");
    }
    
     public synchronized static DBconnection GetConexion()throws ClassNotFoundException, SQLException{
        if(connectionUnique == null){
           connectionUnique = new DBconnection();
        }
        return connectionUnique;
    }
     
        public Connection GetCon(){
            return Con;
        }
 
        public void Destroy() throws SQLException{
            Con.close();
        }
    
}
