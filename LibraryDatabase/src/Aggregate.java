import java.sql.*;

public class Aggregate {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";
    static final String QUERY = "SELECT AVG(bookLength), COUNT(*), MAX(bookDate) FROM book";

    public static void main(String[] args) {


        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {

            while (rs.next()) {

                System.out.print("average book length: " + rs.getInt(1));
                System.out.print(", count of books: " + rs.getInt(2));
                System.out.println(", max book date " + rs.getString(3));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}