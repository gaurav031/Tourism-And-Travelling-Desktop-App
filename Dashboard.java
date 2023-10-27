package javaproject;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dashboard extends JFrame implements ActionListener {

    String username;
    JButton addPersonalDetails, viewPersonalDetails, udatePersonalDetails, checkpackages, bookpackage, viewpackage;
    JButton deletpersonalDetails;
    JButton viewhotels, destination, bookhostels, viewbookedhostels, payments, notepad, calculator, about;
    private String userame;

    Dashboard(String username) {
        this.username = username;
        setBounds(0, 0, 1600, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.BLACK);
        p1.setBounds(0, 0, 1950, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dadhboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.BLACK);
        p2.setBounds(0, 65, 300, 1000);
        add(p2);

        addPersonalDetails = new JButton("Add Personal Detail");
        addPersonalDetails.setBounds(0, 0, 300, 50);
        addPersonalDetails.setBackground(Color.BLACK);
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        udatePersonalDetails = new JButton("Update Your Detail");
        udatePersonalDetails.setBounds(0, 60, 300, 50);
        udatePersonalDetails.setBackground(Color.BLACK);
        udatePersonalDetails.setForeground(Color.WHITE);
        udatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        udatePersonalDetails.setMargin(new Insets(0, 0, 0, 55));
        udatePersonalDetails.addActionListener(this);
        p2.add(udatePersonalDetails);

        viewPersonalDetails = new JButton("View Detail");
        viewPersonalDetails.setBounds(0, 120, 300, 50);
        viewPersonalDetails.setBackground(Color.BLACK);
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalDetails.setMargin(new Insets(0, 0, 0, 130));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletpersonalDetails = new JButton("Delet Personal Detail");
        deletpersonalDetails.setBounds(0, 180, 300, 50);
        deletpersonalDetails.setBackground(Color.BLACK);
        deletpersonalDetails.setForeground(Color.WHITE);
        deletpersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletpersonalDetails.setMargin(new Insets(0, 0, 0, 50));
        deletpersonalDetails.addActionListener(this);
        p2.add(deletpersonalDetails);

        checkpackages = new JButton(" Check package");
        checkpackages.setBounds(0, 240, 300, 50);
        checkpackages.setBackground(Color.BLACK);
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkpackages.setMargin(new Insets(0, 0, 0, 110));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);

        bookpackage = new JButton(" Book package");
        bookpackage.setBounds(0, 300, 300, 50);
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookpackage.setMargin(new Insets(0, 0, 0, 120));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);

        viewpackage = new JButton(" View package");
        viewpackage.setBounds(0, 360, 300, 50);
        viewpackage.setBackground(Color.BLACK);
        viewpackage.setForeground(Color.WHITE);
        viewpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewpackage.setMargin(new Insets(0, 0, 0, 120));
        viewpackage.addActionListener(this);
        p2.add(viewpackage);

        viewhotels = new JButton(" View Hotels");
        viewhotels.setBounds(0, 420, 300, 50);
        viewhotels.setBackground(Color.BLACK);
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewhotels.setMargin(new Insets(0, 0, 0, 130));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

        bookhostels = new JButton(" Book Hotels");
        bookhostels.setBounds(0, 480, 300, 50);
        bookhostels.setBackground(Color.BLACK);
        bookhostels.setForeground(Color.WHITE);
        bookhostels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookhostels.setMargin(new Insets(0, 0, 0, 140));
        bookhostels.addActionListener(this);
        p2.add(bookhostels);

        viewbookedhostels = new JButton(" View Booked Hotels");
        viewbookedhostels.setBounds(0, 540, 300, 50);
        viewbookedhostels.setBackground(Color.BLACK);
        viewbookedhostels.setForeground(Color.WHITE);
        viewbookedhostels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewbookedhostels.setMargin(new Insets(0, 0, 0, 70));
        viewbookedhostels.addActionListener(this);
        p2.add(viewbookedhostels);

        destination = new JButton(" Destination");
        destination.setBounds(0, 600, 300, 50);
        destination.setBackground(Color.BLACK);
        destination.setForeground(Color.WHITE);
        destination.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destination.setMargin(new Insets(0, 0, 0, 125));
        destination.addActionListener(this);
        p2.add(destination);

        payments = new JButton(" Payments");
        payments.setBounds(0, 660, 300, 50);
        payments.setBackground(Color.BLACK);
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payments.setMargin(new Insets(0, 0, 0, 155));
        payments.addActionListener(this);
        p2.add(payments);

        calculator = new JButton("Calculator");
        calculator.setBounds(0, 720, 300, 50);
        calculator.setBackground(Color.BLACK);
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculator.setMargin(new Insets(0, 0, 0, 145));
        calculator.addActionListener(this);
        p2.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setBounds(0, 780, 300, 50);
        notepad.setBackground(Color.BLACK);
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.setMargin(new Insets(0, 0, 0, 155));
        notepad.addActionListener(this);

        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0, 840, 300, 50);
        about.setBackground(Color.BLACK);
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setMargin(new Insets(0, 0, 0, 175));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(2050, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Maagement System");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN, 55));
        image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonalDetails) {
            try {
                new Addcustomer(username).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ae.getSource() == viewPersonalDetails) {
            try {
                new ViewCustomers(username).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ae.getSource() == udatePersonalDetails) {
            try {
                new UpdateCustomer(username).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ae.getSource() == checkpackages) {
            new CheckPackage().setVisible(true);
        } else if (ae.getSource() == bookpackage) {
            new BookPackage(username).setVisible(true);
        } else if (ae.getSource() == viewpackage) {
            new ViewPackage(username).setVisible(true);
        } else if (ae.getSource() == viewhotels) {
            new CheckHotels().setVisible(true);
        } else if (ae.getSource() == destination) {
            new Destination().setVisible(true);
        } else if (ae.getSource() == bookhostels) {
            new BookHotel(username).setVisible(true);
        } else if (ae.getSource() == viewbookedhostels) {
            new ViewBookedHotel(username).setVisible(true);
        } else if (ae.getSource() == payments) {
            new Paytm();
        } else if (ae.getSource() == calculator) {
            try {
                //for using system calculator we use calc funcion present in runtime
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == notepad) {
            try {
                //for using system notepade we use notepad.exe funcion present in runtime
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == about) {
            new About();
        } else if (ae.getSource() == deletpersonalDetails) {
            try {
                new DeleteCustomer(username);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        new Dashboard("");
    }
}
