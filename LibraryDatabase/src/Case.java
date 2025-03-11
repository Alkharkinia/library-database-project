import java.sql.*;

public class Case {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";
    static final String QUERY = "SELECT DISTINCT librarianID, librarianName, CASE " +
            "WHEN librarianSalary < 37500 THEN 'This is an intern' " +
            "WHEN librarianSalary BETWEEN 37500 AND 47500 THEN 'This is an employee' " +
            "WHEN librarianSalary > 47500 THEN 'This is the head librarian' ELSE 'Isnt assigned yet' END AS librarianRank FROM librarian";

    public static void main(String[] args) {


        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {

            while (rs.next()) {


                System.out.print("librarianID: " + rs.getString("librarianID"));
                System.out.print(" librarianName: " + rs.getString("librarianName"));
                System.out.println(" librarianRank: " + rs.getString("librarianRank"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}