import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class updatePage extends JFrame {
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
    private JButton UpdateEmployeeButton;
    private JButton Home;
     static String empId;

    updatePage(String empId){
        this.empId = empId;

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Employee");
        setLayout(null);

        JLabel headingLabel = new JLabel("Update Employee Details");
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

        UpdateEmployeeButton = new JButton("Update");
        UpdateEmployeeButton.setBounds(labelX, buttonY, buttonWidth, buttonHeight);
        UpdateEmployeeButton.addActionListener(new ActionListener() {
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
                    String query = "UPDATE employee SET "
                            + "name = '" + name + "', "
                            + "fname = '" + fname + "', "
                            + "dob = '" + dob + "', "
                            + "salary = '" + salary + "', "
                            + "address = '" + address + "', "
                            + "phone = '" + phone + "', "
                            + "email = '" + email + "', "
                            + "education = '" + education + "', "
                            + "designation = '" + designation + "' "
                            + "WHERE empId = '" + empId + "'";
                    connect.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Details Updated");
                    setVisible(false);
                    new viewEmployee();
                }catch (Exception de){
                    System.out.println("invalid details");
                    de.printStackTrace();
                }
            }
        });
        add(UpdateEmployeeButton);

        Home = new JButton("Home");
        Home.setBounds(fieldX, buttonY, buttonWidth, buttonHeight);
        Home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Home();
            }});
        add(Home);

        try{
            connect c = new connect();
            String query = "Select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                String name = rs.getString("name");
                String fathersName = rs.getString("fname");
                String dob = rs.getString("dob");
                String salary = rs.getString("salary");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String education = rs.getString("education");
                String designation = rs.getString("designation");
                String empId1 = rs.getString("empId");

                nameField.setText(name);
                fathersNameField.setText(fathersName);
                dobField.setText(dob);
                salaryField.setText(salary);
                addressArea.setText(address);
                phoneField.setText(phone);
                emailField.setText(email);
                educationComboBox.setSelectedItem(education);
                designationField.setText(designation);
                employeeIdField.setText(empId1);

            }
        }catch (Exception hj){
            hj.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new updatePage("");
    }
}
