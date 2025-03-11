import java.sql.*;

public class GroupBy {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";
    static final String QUERY = "SELECT SUM(bookLength), bookGenre FROM book GROUP BY bookGenre HAVING SUM(bookLength) > 500" +
            " AND bookGenre = 'Science Fiction' ";
    public static void main(String[] args) {


        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {

            while (rs.next()) {


                System.out.print("sum of book length: " + rs.getInt(1));
                System.out.println(", bookGenre: " + rs.getString("bookGenre"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
