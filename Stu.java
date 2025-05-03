/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.sql.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.lang.Object;
import javax.swing.table.DefaultTableModel;
import java.lang.String;
import student.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JTable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Stu {
    
            Connection conn = connection.getConnection();
            PreparedStatement st;
    
    public int getMax()
    {
            int Serial_Number =0;
            
            //String url ="jdbc:mysql://localhost:3306/cseoffice";
           // String user = "root";
           // String password="";
            Statement st;
        try{
                 //Class.forName("com.mysql.cj.jdbc.Driver");
                 //Connection conn = DriverManager.getConnection(url,user,password);
                st = conn.createStatement();
                ResultSet rs = st.executeQuery("Select max(Serial_Number) from student_information");
                while(rs.next()){
                    Serial_Number = rs.getInt(1);
                    
                }
            
        }catch (SQLException ex) {
             Logger.getLogger(Stu.class.getName()).log(Level.SEVERE,null,ex);
    } 
        return Serial_Number+1;
    }
    
    
    // For Getting Value
    
     public void getStudentValue(JTable table,String searchValue) 
    {
            
            PreparedStatement st;
            String sql = "select * from student_information where concat(Serial_Number,Email,Phone_Number,Roll_Number,Registration)like? order by Serial_Number desc";
            try{
               // Class.forName("com.mysql.cj.jdbc.Driver");
                 //Connection conn = DriverManager.getConnection(url,user,password);
                 Connection conn = connection.getConnection();
                 st = conn.prepareStatement(sql);
                 st.setString(1, "%"+searchValue+"%");
                 ResultSet rs = st.executeQuery();
                 DefaultTableModel model= (DefaultTableModel)table.getModel();
                 Object[] row;
                 while(rs.next())
                 {
                     row = new Object[12];
                     row[0] = rs.getInt(1);
                     row[1] = rs.getString(2);
                     row[2] = rs.getString(3);
                     row[3] = rs.getString(4);
                     row[4] = rs.getString(5);
                     row[5] = rs.getString(6);
                     row[6] = rs.getString(7);
                     row[7] = rs.getString(8);
                     row[8] = rs.getString(9);
                     row[9] = rs.getString(10);
                     row[10] = rs.getString(11);
                     row[11] = rs.getString(12);
                     model.addRow(row);
                     
                 }
                
            }catch (SQLException ex) {
             Logger.getLogger(Stu.class.getName()).log(Level.SEVERE,null,ex);
       } 
    }
     //Get teacher Value
     public void getTeacherValue(JTable table,String searchValue) 
    {
            
            PreparedStatement st;
            String sql = "select * from teacher where concat(Teacher_ID,Name,Phone,Email)like? order by Teacher_ID desc";
            try{
               // Class.forName("com.mysql.cj.jdbc.Driver");
                 //Connection conn = DriverManager.getConnection(url,user,password);
                 Connection conn = connection.getConnection();
                 st = conn.prepareStatement(sql);
                 st.setString(1, "%"+searchValue+"%");
                 ResultSet rs = st.executeQuery();
                 DefaultTableModel model= (DefaultTableModel)table.getModel();
                 Object[] row;
                 while(rs.next())
                 {
                     row = new Object[4];
                     row[0] = rs.getInt(1);
                     row[1] = rs.getString(2);
                     row[2] = rs.getString(3);
                     row[3] = rs.getString(4);
                     
                    
                     model.addRow(row);
                     
                 }
                
            }catch (SQLException ex) {
             Logger.getLogger(Stu.class.getName()).log(Level.SEVERE,null,ex);
       } 
    }
     
     //max
    public int getmax() {
        int Teacher_ID = 100;

        //String url ="jdbc:mysql://localhost:3306/cseoffice";
        // String user = "root";
        // String password="";
        Statement st;
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection conn = DriverManager.getConnection(url,user,password);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select max(Teacher_ID) from teacher");
            while (rs.next()) {
                Teacher_ID = rs.getInt(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Stu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Teacher_ID +1;
    }

    
    public boolean isIdExist(int Serial_Number) {
        PreparedStatement st;

        String sql = "select * from student_information where Serial_Number=?";
        try {
            Connection conn = connection.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, Serial_Number);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Stu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean isIDExist(int Teacher_ID) {
        PreparedStatement st;

        String sql = "select * from teacher where Teacher_ID=?";
        try {
            Connection conn = connection.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, Teacher_ID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Stu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


}
