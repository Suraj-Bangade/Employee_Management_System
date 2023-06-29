import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.SQLException;


public class login extends JFrame {

    login(){
        setSize(600, 300);
        setLocation(50, 50);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel usernameLabel = new JLabel("User Name:");
        usernameLabel.setBounds(30, 40, 100, 30);
        add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(140, 40, 150, 30);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 80, 100, 30);
        add(passwordLabel);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(140, 80, 150, 30);
        add(passwordField);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200  ,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(350,30,200,200);
        add(image);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(140, 120, 100, 30);
        add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                String username = usernameField.getText();
                String password = passwordField.getText();


                connect c = new connect();

                String query = "select * from login where username='"+username+"' and password='"+password+"'";


                    ResultSet rs = c.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Home();
                    }else{
                        JOptionPane.showMessageDialog(null,"invalid username or password");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });



        setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }

}
