import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewEmployee extends JFrame {
    viewEmployee(){
        setSize(900,600);
        setLocation(300,50);

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel searchlabel = new JLabel("Search by employee ID");
        searchlabel.setBounds(20,20,150,20);
        add(searchlabel);

        Choice choice = new Choice();
        choice.setBounds(190,20,150,20);
        add(choice);

        JTable table = new JTable();
        try {
            connect connect = new connect();
            ResultSet rs = connect.s.executeQuery("select * from employee");
            while(rs.next()){
                choice.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            connect connect = new connect();
            ResultSet rs = connect.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));


        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,120,900,600);
        add(jsp);

        JButton searchButton = new JButton("Search");
        JButton printButton = new JButton("Print");
        JButton updateButton = new JButton("Update");
        JButton backButton = new JButton("Back");

        // Set the positions and size of the buttons
        searchButton.setBounds(20, 70, 100, 30);
        printButton.setBounds(130, 70, 100, 30);
        updateButton.setBounds(240, 70, 100, 30);
        backButton.setBounds(350, 70, 100, 30);

        // Add action listeners to the buttons
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Add code for search button action
                String query = "select * from employee where empId ='"+choice.getSelectedItem()+"'";

                try {
                    connect c = new connect();
                    ResultSet rs = c.s.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    table.print();

                }catch (Exception fd){
                    fd.printStackTrace();
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new updatePage(choice.getSelectedItem());
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Add code for back button action
                setVisible(false);
                new Home();
            }
        });

        // Add the buttons to the JFrame
        getContentPane().add(searchButton);
        getContentPane().add(printButton);
        getContentPane().add(updateButton);
        getContentPane().add(backButton);



        setVisible(true);

    }

    public static void main(String[] args) {
        new viewEmployee();
    }
}
