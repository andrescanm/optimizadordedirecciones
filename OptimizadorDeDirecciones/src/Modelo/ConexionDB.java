/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class ConexionDB {
    
    // Variale que guarda el nombre de la BD a conectar
    public String db = "Examen_Certificacion"; 
    //Variable que guarda la localizaci[on de la BD
    //public String url = "jdbc:mysql://127.0.0.1/" + db;
    public String url = "jdbc:derby:.//" + db;//"jdbc:derby://localhost:1527/" //"jdbc:derby:.//"
    public String user = "root";
    public String pass = "root";
    Connection con = null;
   
    public ConexionDB() {
               
        try {
            //Ubicacion del controlador de conexion BD
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            
            System.out.println("Conectando a la base de datos...");
            con = DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("Conexion exitosa...");
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }        
    }
    
    /**Permite retornar la conexión
     * @return n*/
   public Connection getConnection(){
      return con;
   }
    
    public void desconectar(){
        con = null;
    }
    
}
