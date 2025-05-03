/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public class connection {
    
    public static void main(String[] args)
    {
            String url ="jdbc:mysql://localhost:3306/cseoffice";
            String user = "root";
            String password="";
            
            try{
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 Connection conn = DriverManager.getConnection(url,user,password);
                  if (conn != null) {
                  System.out.println("Connected to the database!");
                  conn.close();
                  }else {
                System.out.println("Failed to connect to the database!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
                
            }
    }

    public static Connection getConnection() {
         // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            String url ="jdbc:mysql://localhost:3306/cseoffice";
            String user = "root";
            String password="";
            Connection conn;
        conn = null;
          try{
                 Class.forName("com.mysql.cj.jdbc.Driver");
                  conn = DriverManager.getConnection(url,user,password);
                  
                  
            

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
    }
    return conn;
}
}




