package javaproject;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTable;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCustomers extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JLabel lblAvailability;
    private JLabel lblCleanStatus;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
      private JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    
    private JLabel lblId, l3, l4, l5, l6;
    String username;

    public static void main(String[] args) throws SQLException {
      new ViewCustomers("raazz");
       
    }

    public ViewCustomers(String username) throws SQLException {
        
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(580, 220, 900, 680);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i3 = i1.getImage().getScaledInstance(626, 201, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(0, 450, 626, 201);
        add(l1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(626, 201, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(615, 450, 626, 201);
        add(l2);

        table = new JTable();
        table.setBounds(0, 40, 900, 350);
        contentPane.add(table);

        try {
            Conn c = new Conn();
            String query = "select * from customer  where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblAvailability.setText(rs.getString("username"));
                lblCleanStatus.setText(rs.getString("id"));
                lblNewLabel.setText(rs.getString("number"));
                lblNewLabel_1.setText(rs.getString("name"));
                lblId.setText(rs.getString("gender"));
                l3.setText(rs.getString("country"));
                l4.setText(rs.getString("addresh"));
                l5.setText(rs.getString("phone"));
                l6.setText(rs.getString("email"));
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnNewButton.setBounds(390, 400, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        lblAvailability = new JLabel("Username");
        lblAvailability.setBounds(10, 15, 69, 14);
        contentPane.add(lblAvailability);
        
           t1 = new JTextField();
        t1.setBounds(10, 50, 69, 14);
        contentPane.add(t1);
        t1.setColumns(10);

        lblCleanStatus = new JLabel("Id Type");
        lblCleanStatus.setBounds(110, 15, 76, 14);
        contentPane.add(lblCleanStatus);

        lblNewLabel = new JLabel("Number");
        lblNewLabel.setBounds(220, 15, 46, 14);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setBounds(320, 15, 76, 14);
        contentPane.add(lblNewLabel_1);

        lblId = new JLabel("Gender");
        lblId.setBounds(420, 15, 90, 14);
        contentPane.add(lblId);

         l3 = new JLabel("Country");
        l3.setBounds(520, 15, 90, 14);
        contentPane.add(l3);

         l4 = new JLabel("Address");
        l4.setBounds(620, 15, 90, 14);
        contentPane.add(l4);

         l5 = new JLabel("Phone");
        l5.setBounds(720, 15, 90, 14);
        contentPane.add(l5);

        l6 = new JLabel("Email");
        l6.setBounds(820, 15, 90, 14);
        contentPane.add(l6);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

}
