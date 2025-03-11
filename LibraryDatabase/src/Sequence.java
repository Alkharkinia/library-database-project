import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sequence {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";

    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {

            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO borrow (borrowDate, borrowDue, borrowExtension, bookID, memberID)" +
                    " VALUES ('2023-12-06', '2024-01-06', 1, (SELECT bookID FROM book WHERE bookID = 12), " +
                    "(SELECT memberID FROM member WHERE memberID = 6))";
            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
