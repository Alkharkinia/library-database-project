import java.sql.*;

public class Librarian {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";
    static final String QUERY = "SELECT librarianName FROM (SELECT * FROM librarian WHERE librarianSalary > 37500) AS employee WHERE librarianPassword LIKE '%2' ";

    public static void main(String[] args) {


        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {

            while (rs.next()) {


                System.out.println("librarianName: " + rs.getString("librarianName"));



            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

