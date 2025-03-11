import java.sql.*;

public class Delete {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";

    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement())

        {

            System.out.println("Deleting records in the table...");
            String sql = "DELETE FROM book WHERE bookID = 14";
            stmt.executeUpdate(sql);
            System.out.println("Deleted records in the table.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
