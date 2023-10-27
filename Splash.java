package javaproject;

import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame implements Runnable{
    Thread thread;
   Splash(){
     //  setSize(800,800);
       // setLocation(200,100);
       
       //imageicon is the class for the print the img 
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
       //for scaling the image we use the i2
       Image i2 = i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
       //i3 is the object for displaying the i2
       ImageIcon i3 = new ImageIcon(i2);
       //jlebel is used for display the pic on frame
       JLabel image = new JLabel(i3);
       add(image);
       

       setVisible(true);    
       thread = new Thread(this);
       thread.start();
   }
   //override the abstract class 
   public void run(){
       try{
           //we use this for taking pause for 7 sec and close the frame
           Thread.sleep(3000);
           new Login();
           setVisible(false);
       }catch(Exception e){
           
       }
   }
   public static void main(String args[]){
       SwingUtilities.invokeLater(() -> {
          Splash  frame= new Splash();
          int x=1;
          //for dynamic location we use loop
          for(int i=1; i<=500; x+=7, i+=6){
           frame.setLocation(750-(x+i)/2, 400-(i/2));
           frame.setSize(x+i,i);
           try{
               Thread.sleep(10);//we use sleep to open frame slowly
           }catch(Exception e){ 
           }
           
       }
        });
   }
}
