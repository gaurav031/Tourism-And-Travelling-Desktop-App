package javaproject;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    
   JButton create,back;  
   JTextField tfname,tfusername,tfpassword,tfanswer;
   Choice security;
   
   Signup(){
        setBounds(350,200,900,360);
        //all the color component is in the awt package
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        //for writing anything we use jlabel forusername
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font ("Tahoma", Font.BOLD,14));
        lblusername.setBounds(50,20,125,25);
        p1.add(lblusername);
        
        //for taking input username
       tfusername = new JTextField();
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        
        //for name 
          JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font ("Tahoma", Font.BOLD,14));
        lblname.setBounds(50,60,125,25);
        p1.add(lblname);
        
        //for taking input name
        tfname = new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        
        //for passwords
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font ("Tahoma", Font.BOLD,14));
        lblpassword.setBounds(50,100,125,25);
        p1.add(lblpassword);
        
        //for taking input passwords
        tfpassword = new JTextField();
        tfpassword.setBounds(190,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
         //for Security question
        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font ("Tahoma", Font.BOLD,14));
        lblsecurity.setBounds(50,140,125,25);
        p1.add(lblsecurity);
        
        //for taking input Security question
        security = new Choice();
        security.add("Fav cartoon");
        security.add("fav Marvel Superhero");
        security.add("your Lucky number");
        security.add("fav Book");
        security.setBounds(190,140,100,25);
        p1.add(security);
        
        //for answer
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font ("Tahoma", Font.BOLD,14));
        lblanswer.setBounds(50,180,125,25);
        p1.add(lblanswer);
        
        //for taking answers
        tfanswer = new JTextField();
        tfanswer.setBounds(190,180,180,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        //button for create
        create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);//for clicking buttion action performed is used
        p1.add(create);
        
        //button for Back
        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(250,250,100,30);
        back.addActionListener(this);//for clicking buttion action performed is used
        p1.add(back);
        
        //for image
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
       Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT );
       //image is change into imageicon because jlabel is taking only icon
       ImageIcon i3= new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(580,50,250,250);
       add(image);
       
        
        setVisible(true);
    }
   
   //override the actionlistener for performing button
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();
            
            String query ="insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try{
            Conn c= new Conn();
            c.s.execute(query);
            
            JOptionPane.showMessageDialog(null,"Account created sucessfully");
            setVisible(false);
            new Login();
            
        } catch (Exception e){
            e.printStackTrace();
        }
            
        }else if(ae.getSource()== back){
            setVisible(false);
            new Login();
            
        }
    }
    
    public static void main(String[]args){
        new Signup();
    }
}
