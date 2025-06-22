import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/guvi_db";
        String user = "root";
        String password = "";

        try {
            // Step 1: Load the JDBC driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // Step 3: Prepare SQL insert statement
            String sql = "INSERT INTO employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Step 4: Insert employee data
            Object[][] data = {
                {101, "Jenny", 25, 10000},
                {102, "Jacky", 30, 20000},
                {103, "Joe", 20, 40000},
                {104, "John", 40, 80000},
                {105, "Shameer", 25, 90000}
            };

            for (Object[] emp : data) {
                pstmt.setInt(1, (int) emp[0]);
                pstmt.setString(2, (String) emp[1]);
                pstmt.setInt(3, (int) emp[2]);
                pstmt.setDouble(4, (double) emp[3]);
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully!");

            // Step 5: Close resources
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
