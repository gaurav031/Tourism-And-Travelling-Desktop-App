package javaproject;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame  implements ActionListener{
    
    JButton login,signup,password;
    JTextField tfpassword, tfusername;
    Login() {
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        
        //for change the color of whole panel
        getContentPane().setBackground(Color.WHITE);
        // this panel is for lest side
        JPanel  p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        add(p1);
        
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
       Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT );
       ImageIcon i3= new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(100,120,200,200);
       p1.add(image);
       
       //this panel for right side
       
       JPanel p2 =new JPanel();
       p2.setLayout(null);
       p2.setBounds(400,30,450,300);
       add(p2);
      
       //jlebel is user for type anything on jpanel
       //for username
       JLabel lblusername = new JLabel("Username");
       lblusername.setBounds(60,20,100,25);
       lblusername.setFont(new Font("SAN_SERIf",Font.PLAIN,20));
       p2.add(lblusername);
        
        tfusername = new JTextField();//textfeild for taking input
       tfusername.setBounds(60,60,300,30);//for set height and width
       tfusername.setBorder(BorderFactory.createEmptyBorder());//for remove border
       p2.add(tfusername);
       
       
       //jlebel is user for type anything on jpanel
       //for password
        JLabel lblpassword = new JLabel("Password");
       lblpassword.setBounds(60,110,100,25);
       lblpassword.setFont(new Font("SAN_SERIf",Font.PLAIN,20));
       p2.add(lblpassword);
        
        tfpassword = new JTextField();//textfeild for taking input
       tfpassword.setBounds(60,150,300,30);//for set height and width
       tfpassword.setBorder(BorderFactory.createEmptyBorder());//for remove border
       p2.add(tfpassword);
       
       //jbutton is use for button group log in button
        login = new JButton("Login");
       login.setBounds(60,200,130,30);
       login.setBackground(new  Color(133,193,233));
       login.setForeground(Color.WHITE);
       login.setBorder(new LineBorder (new Color(133,193,233)));
       login.addActionListener(this);
       p2.add(login);
       
         //sigup button
        signup = new JButton("Signup");
       signup.setBounds(230,200,130,30);
      signup.setBackground(new  Color(133,193,233));
     signup.setForeground(Color.WHITE);
       signup.setBorder(new LineBorder (new Color(133,193,233)));
             signup.addActionListener(this);

       p2.add(signup);
       
         //forgot password 
        password = new JButton("Forgot Password");
       password.setBounds(130,250,150,20);
       password.setBackground(new  Color(133,193,233));
       password.setForeground(Color.WHITE);
       password.setBorder(new LineBorder (new Color(133,193,233)));
       password.addActionListener(this);

       p2.add(password);
       
       
       JLabel text = new JLabel("Trouble in login");
       text.setBounds(300,250,150,20);
       text.setForeground(Color.RED);
       p2.add(text);
       
       
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            try{
                String username =tfusername.getText();
                String pass=tfpassword.getText();
                String query ="select * from account where username ='"+username+"'AND password = '"+pass+"'";
                Conn c=new Conn();
                
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
        }else {
            setVisible(false);
            new ForgetPassword();
        }
    }
    
    public static void main(String []args){
        Login l = new Login();
    }
    
}
