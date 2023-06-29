import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {

    Home(){
        setSize(1120, 630);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(550, 10, 1000, 80);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 40));
        heading.setForeground(Color.BLACK);
        image.add(heading);

// Add Buttons
        int buttonWidth = 150;
        int buttonHeight = 50;
        int buttonSpacing = 10;

        JButton button1 = new JButton("Add Employee");
        button1.setBounds(1010 - buttonWidth, 100, buttonWidth, buttonHeight);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new addEmployee();
            }
        });
        image.add(button1);

        JButton button2 = new JButton("Update Employee");
        button2.setBounds(1010 - buttonWidth, 100 + buttonHeight + buttonSpacing, buttonWidth, buttonHeight);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new viewEmployee();
            }
        });
        image.add(button2);

        JButton button3 = new JButton("Remove Employee");
        button3.setBounds(1010 - buttonWidth, 100 + 2 * (buttonHeight + buttonSpacing), buttonWidth, buttonHeight);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new removePage();
            }
        });
        image.add(button3);

        JButton button4 = new JButton("View Employee");
        button4.setBounds(1010 - buttonWidth, 100 + 3 * (buttonHeight + buttonSpacing), buttonWidth, buttonHeight);
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new viewEmployee();
            }
        });
        image.add(button4);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }
}
