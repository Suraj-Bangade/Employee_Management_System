import java.sql.*;

public class connect {

    Connection c;
    Statement s;
    connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql:///employeeManagement", "root","1234");
            s=c.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
