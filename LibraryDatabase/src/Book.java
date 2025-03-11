import java.sql.*;

public class Book {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";
    static final String QUERY = "SELECT bookName, bookDate FROM book ORDER BY bookDate ASC";

    public static void main(String[] args) {


        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {

            while (rs.next()) {


                System.out.print(", bookName: " + rs.getString("bookName"));
                System.out.println(", bookDate: " + rs.getString("bookDate"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

