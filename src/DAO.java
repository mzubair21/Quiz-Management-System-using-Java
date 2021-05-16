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
    String getmember_id(variable v){
        ResultSet rs=null;
        String member_id="";
        try{
            Connection();
            query="Select * from member where Email=? and Password=?";
            ps=con.prepareStatement(query);
            ps.setString(1, v.email);
            ps.setString(2, v.password);
            rs=ps.executeQuery();
            if(rs.next()){
              //  JOptionPane.showMessageDialog(null, "Member id  = "+rs.getString(3));
                member_id=rs.getString(1).toString();
                
            }else{
                JOptionPane.showMessageDialog(null, "User not Found");
            }
            con.close();
            
        }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);   
        }
        return member_id;  
    }
    variable authentication(variable v){
        ResultSet rs=null;
        int member_id=0;
        try{
            Connection();
            query="Select * from member where Email=? and Password=?";
            ps=con.prepareStatement(query);
            ps.setString(1, v.email);
            ps.setString(2, v.password);
            rs=ps.executeQuery();
            if(rs.next()){
              //  JOptionPane.showMessageDialog(null, "Member id  = "+rs.getString(3));
                member_id=Integer.parseInt(rs.getString(1));
                
            }else{
                JOptionPane.showMessageDialog(null, "User not Found");
            }
            
            
        }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);   
        }
        return details(member_id);  
    }
    //Function to Get role id(admin-1/member-2) from member tbl using foreign member id in accounts
    variable details(int member_id){
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
              v.role_id=rs.getString(7);
              
              
           }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return v;
    }
    
    void addMember(variable v){
        try{
            Connection();
            query="INSERT INTO member (member_id, Name, Roll, Section,Email,Password, role_id) VALUES (NULL,?,?,?,?,?,?)";
            ps=con.prepareStatement(query);
            ps.setString(1,v.name);
            ps.setString(2,v.roll);
            ps.setString(3,v.section);
            ps.setString(4,v.email);
            ps.setString(5,v.password);
            ps.setString(6,v.role_id);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Member Added Successfully");
              
            }else{
                JOptionPane.showMessageDialog(null,"Member Addition Failed");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    void addinResult(variable v){
         try{
            Connection();
            query="INSERT INTO result VALUES (?,?)";
            ps=con.prepareStatement(query);
            ps.setString(1,v.member_id);
            ps.setInt(2,v.total);
            ps.executeUpdate();
               
 
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    void addQuestion(variable v){
        try{
            Connection();
            query="INSERT INTO question (q_id, q_title, opt1, opt2,opt3,opt4, q_answer,q_marks,q_cat) VALUES (NULL,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(query);
            ps.setString(1,v.q_title);
            ps.setString(2,v.opt1);
            ps.setString(3,v.opt2);
            ps.setString(4,v.opt3);
            ps.setString(5,v.opt4);
            ps.setString(6,v.q_answer);
            ps.setString(7,v.q_marks);
            ps.setString(8,v.q_cat);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Question Added Successfully");
            }else{
                JOptionPane.showMessageDialog(null,"Question Addition Failed");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    void deleteQuestion(variable v){
        try{
            Connection();
            query="Delete from question where q_id = ?";
            ps=con.prepareStatement(query);
            ps.setString(1,v.q_id);
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Question Added Successfully");
            }else{
                JOptionPane.showMessageDialog(null,"Question Addition Failed");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
     ResultSet selectQuestionid(variable v){
         rs=null;
        try{
            Connection();
            query="Select * from question where q_id = ?";
            ps=con.prepareStatement(query);
            ps.setString(1,v.q_id);
            rs=ps.executeQuery();
            if(rs.next()){
                return rs;
            }else{
                JOptionPane.showMessageDialog(null,"Question not Available");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }
     ResultSet selectQuestion(){
         rs=null;
        try{
            Connection();
            query="Select * from question";
            ps=con.prepareStatement(query);
            rs=ps.executeQuery();
            if(rs.next()){
                return rs;
            }else{
                JOptionPane.showMessageDialog(null,"Question not Available");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }
      ResultSet selectCat(){
         rs=null;
        try{
            Connection();
            query="Select * from result";
            ps=con.prepareStatement(query);
            rs=ps.executeQuery();
            if(rs.next()){
                return rs;
            }else{
                JOptionPane.showMessageDialog(null,"Student not Available");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }
     ResultSet selectCatid(variable v){
         rs=null;
        try{
            Connection();
            query="Select * from result where member_id = ?";
            ps=con.prepareStatement(query);
            ps.setString(1,v.member_id);
            rs=ps.executeQuery();
            if(rs.next()){
                return rs;
            }else{
                JOptionPane.showMessageDialog(null,"Student not Available");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }
   void updateCat(variable v){
      try
        {
            Connection ();
            query= " UPDATE result SET cat1 = ? , cat2 = ? , cat3 = ?, cat4 = ?,cat5 = ? WHERE member_id =?";
            ps = con.prepareStatement(query); 
            ps.setString(1,v.cat1);
            ps.setString(2,v.cat2);
            ps.setString(3,v.cat3);
            ps.setString(4,v.cat4);
            ps.setString(5,v.cat5);
            ps.setString(6,v.member_id);
            if( ps.executeUpdate()>0){
               JOptionPane.showMessageDialog(null,"Category Updated"); 
            }else{
                JOptionPane.showMessageDialog(null,"Student not Found"); 
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Exception Occured-->"+ex.getMessage());
        } 
   }
    ResultSet pickPaper(variable v){
       ResultSet rs=null;
       
       try
        {
            Connection ();
            query= "(select * from question where q_cat = ? ORDER BY RAND() LIMIT 10) UNION (select * from question where q_cat = ? ORDER BY RAND() LIMIT 10) UNION (select * from question where q_cat = ? ORDER BY RAND() LIMIT 10)";
            ps = con.prepareStatement(query);
            ps.setString(1,v.cat_name1);
            ps.setString(2,v.cat_name2);
            ps.setString(3,v.cat_name3);
            rs=ps.executeQuery();
            for(int a=1;a<=30;a++){
                if(rs.next()){
                    
                }else{
                  JOptionPane.showMessageDialog(null,"30 Questions not Available for Test");
                  return rs=null;
                }
            }
            rs.first();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Exception Occured-->"+ex.getMessage());
        }
       
        
       return rs;
    }
    int checkPaper(String v){
       int res=0;
       
       try
        {
            Connection ();
            query= "select * from question where q_cat = ? ORDER BY RAND() LIMIT 10";
            ps = con.prepareStatement(query);
            ps.setString(1,v);
            rs=ps.executeQuery();
            for(int a=1;a<=10;a++){
                if(rs.next()){
                    
                }else{
                  JOptionPane.showMessageDialog(null,"10 Questions not Available for "+v);
                  return res=0;
                }
            }
            for(int a=1;a<10;a++){
            rs.previous();
        }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Exception Occured-->"+ex.getMessage());
        }
       
        
       return res=1;
    }
    ResultSet getCat(){
       rs=null;
       try{
           Connection();
           query="select * from category";
          ps=con.prepareStatement(query);
          rs=ps.executeQuery();
       }catch(Exception ex){
           
       }
       
        return rs;
    }
    int addCat(variable v){
       int a=0;
       try{
           Connection();
           query="insert into category values(null,?)";
          ps=con.prepareStatement(query);
          ps.setString(1,v.q_cat);
          a=ps.executeUpdate();
       }catch(Exception ex){
           
       }
       
        return a;
    }
    void updateAttempt(variable v){
      try
        {
            Connection ();
            query=("insert into answersheet VALUES (?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,?)");
            ps = con.prepareStatement(query); 
            ps.setString(1,v.member_id);
            int q=1,a=1;
            for(int i=2;i<=61;i++){
                if(i%2==0){
                    ps.setString(i,v.ques[q]);
                    q++;
                }else{
                    ps.setString(i,v.ans[a]);
                    a++;
                }
                
            }
            if( ps.executeUpdate()>0){
               JOptionPane.showMessageDialog(null,"Answer Sheet Updated"); 
            }else{
                JOptionPane.showMessageDialog(null,"Answer Sheet Update Failed"); 
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Exception Occured-->"+ex.getMessage());
        } 
   }
        int checkResult(variable v){
        int a=0;
        try{
            Connection();
            query="Select * from result where member_id = ?";
            ps=con.prepareStatement(query);
            ps.setString(1, v.member_id);
            rs=ps.executeQuery();
            if(rs.next()){
              JOptionPane.showMessageDialog(null,"Result Found");
              return 1;
            }else{
                return 0;
            }
            
            
        }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);   
        }
        return a;
    }
        ResultSet fetchResult(variable v){
            rs=null;
            try{
            Connection();
            query="select member.member_id, member.Name,result.total FROM member INNER JOIN result ON result.member_id=member.member_id ORDER by total DESC";
            ps=con.prepareStatement(query);
            rs=ps.executeQuery();
            if(rs.next()){
              JOptionPane.showMessageDialog(null,"Result Found");
              return rs;
            }else{
                    
            }
            
            
        }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);   
        }
            return rs;
        }
    
    
    
}
