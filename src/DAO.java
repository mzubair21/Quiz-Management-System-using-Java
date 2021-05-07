/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Qureshi Home
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class DAO {
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    String query;
    
    
    void Connection(){
        String URL = "jdbc:mysql://localhost:3306/aooplms";
        try{
            Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection(URL,"root","");
           st=con.createStatement();
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
        }
    }
    //Function to check user registered by matching email and password in account tbl
    variable authentication(variable v){
        ResultSet rs=null;
        int member_id=0;
        try{
            Connection();
            query="Select * from account where Email=? and Password=?";
            ps=con.prepareStatement(query);
            ps.setString(1, v.email);
            ps.setString(2, v.password);
            rs=ps.executeQuery();
            if(rs.next()){
              //  JOptionPane.showMessageDialog(null, "Member id  = "+rs.getString(3));
                member_id=Integer.parseInt(rs.getString(3));
                
            }else{
                JOptionPane.showMessageDialog(null, "User not Found");
            }
            con.close();
            
        }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);   
        }
        return welcome(member_id);  
    }
    //Function to Get role id(admin-1/member-2) from member tbl using foreign member id in accounts
    variable welcome(int member_id){
        variable v = new variable();
        try{
           Connection();
           query="Select * from member where member_id=?";
           ps=con.prepareStatement(query);
           ps.setInt(1,member_id);
           rs=ps.executeQuery();
           if(rs.next()){
              JOptionPane.showMessageDialog(null, "Welcome "+rs.getString(2));
              v.name=rs.getString(2);
              v.roll=rs.getString(3);
              v.section=rs.getString(4);
              v.role_id=rs.getString(5);
              
              
           }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return v;
    }
    
    
    
}
