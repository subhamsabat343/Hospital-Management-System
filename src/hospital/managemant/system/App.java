package hospital.managemant.system;
import java.sql.*;

import javax.swing.JFrame;

public class App extends JFrame {

   App()
   {
        setSize(750,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);
   }
   static final String DB_URL = "jdbc:mysql://localhost:3306/hospital_management_system";
   static final String USER = "root";
   static final String PASS = "subham";
   static final String QUERY = "SELECT * FROM login";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("ID: " + rs.getString("Id"));
            System.out.print(", Password: " + rs.getString("PW"));
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 

      new App();
   }
}

