
package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField tfusername,tfname,tfquestion,tfanswer,tfpassword;
    JButton search, retrieve, back;
    
     ForgetPassword (){
         setBounds(350,200,850,380);
         
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
         Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
         ImageIcon i3= new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(580,70,200,200);
         add(image);
         
         //panel where all the content situated
         JPanel p1 = new JPanel();
         p1.setLayout(null);
         p1.setBounds(30,30,500,280);
         add(p1);
         
         
         // for text username
         JLabel iblusername= new JLabel("Username");
         iblusername.setBounds(40,20,100,25);
         iblusername.setFont(new Font("Tahoma",Font.BOLD,14));
         p1.add(iblusername);
         
         //for taking input as username
         tfusername =new JTextField();
         tfusername.setBounds(220,20,150,25);
         tfusername.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfusername);
         
         //for search button along with username
         search = new JButton("search");
         search.setBackground(Color.GRAY);
         search.setForeground(Color.WHITE);
         search.setBounds(380,20,100,25);
         search.addActionListener(this);
         p1.add(search);
         
         
         // for text name
         JLabel iblname= new JLabel("Name");
         iblname.setBounds(40,60,100,25);
         iblname.setFont(new Font("Tahoma",Font.BOLD,14));
         p1.add(iblname);
         
         //for taking input as name
         tfname =new JTextField();
         tfname.setBounds(220,60,150,25);
         tfname.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfname);
        
         // for text question
         JLabel iblquestion= new JLabel("Security Question");
         iblquestion.setBounds(40,100,150,25);
         iblquestion.setFont(new Font("Tahoma",Font.BOLD,14));
         p1.add(iblquestion);
         
         //for taking input as question
         tfquestion=new JTextField();
         tfquestion.setBounds(220,100,150,25);
         tfquestion.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfquestion);
         
         // for text answer
         JLabel iblanswer= new JLabel("Answer");
         iblanswer.setBounds(40,140,150,25);
         iblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
         p1.add(iblanswer);
         
         //for taking input as answer
         tfanswer=new JTextField();
         tfanswer.setBounds(220,140,150,25);
         tfanswer.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfanswer);
         
               
         //for retriving button 
         retrieve = new JButton(" retrieve");
          retrieve.setBackground(Color.GRAY);
          retrieve.setForeground(Color.WHITE);
          retrieve.setBounds(380,140,100,25);
           retrieve.addActionListener(this);

         p1.add( retrieve);
         
         
          // for text question
         JLabel iblpassword= new JLabel("Password");
         iblpassword.setBounds(40,180,150,25);
         iblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
         p1.add(iblpassword);
         
         //for taking input as question
         tfpassword=new JTextField();
         tfpassword.setBounds(220,180,150,25);
         tfpassword.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfpassword);
         
         //for back button 
         back = new JButton(" Back");
          back.setBackground(Color.GRAY);
          back.setForeground(Color.WHITE);
          back.setBounds(150,230,100,25);
          back.addActionListener(this);
         p1.add( back);
         
      setVisible(true);
     }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == search){
             try{
                 String query = "select * from account where username ='"+tfusername.getText()+"'";
                 Conn c= new Conn();
                ResultSet rs= c.s.executeQuery(query);
                while(rs.next()){
                   tfname.setText(rs.getString("name"));
                   tfquestion.setText(rs.getString("security"));
                }
             }catch(Exception e){
                 e.printStackTrace();
             }
         }else if(ae.getSource() ==retrieve){
              try{
                 String query = "select * from account where answer ='"+tfanswer.getText() +"'AND username = '"+tfusername.getText()+"'";    
                 Conn c= new Conn();
                ResultSet rs= c.s.executeQuery(query);
                while(rs.next()){
                   tfpassword.setText(rs.getString("password"));
                  
                }
             }catch(Exception e){
                 e.printStackTrace();
             }
         }else{
             setVisible(false);
             new Login();
         }
     }
     
    public static void main(String args[]){
        new ForgetPassword ();
    }
}
