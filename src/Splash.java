import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame {

    Splash(){
        setSize(1170,650);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Employee Management System");
        heading.setForeground(Color.green);
        heading.setBounds(250,0,1200,100);
        heading.setFont(new Font("Serif",Font.PLAIN,50));
        heading.setForeground(Color.red);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);

        JButton ClickHere = new JButton("Continue");
        ClickHere.setFont(new Font("serif",Font.BOLD,50));
        ClickHere.setBounds(400,500,300,70);
        ClickHere.setBackground(Color.WHITE);
        ClickHere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new login();
            }
        });
        add(ClickHere);


        add(heading);
        setVisible(true);
        while(true){
            heading.setVisible(false);

            try {
                Thread.sleep(500);
            }catch (Exception e){

            }

            heading.setVisible(true);

            try {
                Thread.sleep(500);
            }catch (Exception e){

            }
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
