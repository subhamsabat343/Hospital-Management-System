
package hospital.managemant.system;


import java.sql.*;

public class conn {
    
    Connection connection;
    Statement statement;

    public conn()
    {
        try{
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root","subham");
            statement=connection.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new conn();
    }
}