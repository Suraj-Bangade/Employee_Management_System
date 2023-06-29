import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;


public class addEmployee extends JFrame {
    private JTextField nameField;
    private JTextField fathersNameField;
    private JTextField dobField;
    private JTextField salaryField;
    private JTextArea addressArea;
    private JTextField phoneField;
    private JTextField emailField;
    private JComboBox<String> educationComboBox;
    private JTextField designationField;
    private JLabel employeeIdField;
    private JButton addEmployeeButton;
    private JButton Home;
    addEmployee(){
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Employee");
        setLayout(null);

        JLabel headingLabel = new JLabel("Add Employee Details");
        headingLabel.setBounds(0, 20, 600, 30);
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(headingLabel);

        int labelX = 50;
        int fieldX = 200;
        int startY = 80;
        int verticalSpacing = 30;
        int fieldWidth = 250;
        int fieldHeight = 20;
        int buttonY = 400;
        int buttonWidth = 120;
        int buttonHeight = 30;

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(labelX, startY, 100, 20);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(fieldX, startY, fieldWidth, fieldHeight);
        add(nameField);

        JLabel fathersNameLabel = new JLabel("Father's Name:");
        fathersNameLabel.setBounds(labelX, startY + verticalSpacing, 100, 20);
        add(fathersNameLabel);

        fathersNameField = new JTextField();
        fathersNameField.setBounds(fieldX, startY + verticalSpacing, fieldWidth, fieldHeight);
        add(fathersNameField);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(labelX, startY + (2 * verticalSpacing), 100, 20);
        add(dobLabel);


        dobField = new JTextField();
        dobField.setBounds(fieldX, startY + (2 * verticalSpacing), fieldWidth, fieldHeight);
        add(dobField);

        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(labelX, startY + (3 * verticalSpacing), 100, 20);
        add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setBounds(fieldX, startY + (3 * verticalSpacing), fieldWidth, fieldHeight);
        add(salaryField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(labelX, startY + (4 * verticalSpacing), 100, 20);
        add(addressLabel);

        addressArea = new JTextArea();
        addressArea.setBounds(fieldX, startY + (4 * verticalSpacing), fieldWidth, 30);
        add(addressArea);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(labelX, startY + (5 * verticalSpacing) + 20, 100, 20);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(fieldX, startY + (5 * verticalSpacing) + 20, fieldWidth, fieldHeight);
        add(phoneField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(labelX, startY + (6 * verticalSpacing) + 20, 100, 20);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(fieldX, startY + (6 * verticalSpacing) + 20, fieldWidth, fieldHeight);
        add(emailField);

        JLabel educationLabel = new JLabel("Highest Education:");
        educationLabel.setBounds(labelX, startY + (7 * verticalSpacing) + 20, 130, 20);
        add(educationLabel);

        String[] educationOptions = {"10th", "12th", "Btech", "BE", "BBA", "Mtech", "MBA", "Others"};
        educationComboBox = new JComboBox<>(educationOptions);
        educationComboBox.setBounds(fieldX, startY + (7 * verticalSpacing) + 20, fieldWidth, fieldHeight);
        add(educationComboBox);

        JLabel designationLabel = new JLabel("Designation:");
        designationLabel.setBounds(labelX, startY + (8 * verticalSpacing) + 20, 100, 20);
        add(designationLabel);

        designationField = new JTextField();
        designationField.setBounds(fieldX, startY + (8 * verticalSpacing) + 20, fieldWidth, fieldHeight);
        add(designationField);

        JLabel employeeIdLabel = new JLabel("Employee ID:");
        employeeIdLabel.setBounds(labelX, startY + (9 * verticalSpacing) + 20, 100, 20);
        add(employeeIdLabel);

        Random random = new Random();
        int number = random.nextInt(9999);

        employeeIdField = new  JLabel(Integer.toString(number));
        employeeIdField.setBounds(fieldX, startY + (9 * verticalSpacing) + 20, fieldWidth, fieldHeight);
        add(employeeIdField);

        addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.setBounds(labelX, buttonY, buttonWidth, buttonHeight);
        addEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText ();
                String fname = fathersNameField.getText ();
                String dob = dobField.getText();
                String salary = salaryField.getText ();
                String address = addressArea.getText ();
                String phone = phoneField.getText ();
                String email = emailField.getText ();
                String education = (String) educationComboBox.getSelectedItem();
                String designation = designationField.getText();
                String empId = employeeIdField.getText();

                try {
                    connect connect = new connect();
                    String query = "insert into employee values ('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+empId+"')";
                    connect.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Employee Added");
                    setVisible(false);
                    new Home();
                }catch (Exception de){
                    System.out.println("invalid details");
                    de.printStackTrace();
                }
            }
        });
        add(addEmployeeButton);

        Home = new JButton("Home");
        Home.setBounds(fieldX, buttonY, buttonWidth, buttonHeight);
        Home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Home();
            }});
        add(Home);

        setVisible(true);
    }

    public static void main(String[] args) {
        new addEmployee();
    }
}
