package javaproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener{

    Payment() {
        setBounds(500, 200, 800, 600);
        JEditorPane j = new JEditorPane();
        j.setEditable(false);

        try {
            j.setPage("https://paytm.com");
        } catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        }

        JScrollPane scrollPane = new JScrollPane(j);
        getContentPane().add(scrollPane);

        JButton back = new JButton("Back");
        back.setBounds(610, 20, 80, 40);
        back.addActionListener(this);
        j.add(back);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Paytm();
    }

    public static void main(String[] args) {
        new Payment().setVisible(true);
    }
}
