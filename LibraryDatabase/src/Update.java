import java.sql.*;

public class Update {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";

    public static void main(String[] args) {


        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement())

        {

            System.out.println("Updating records in the table...");
            String sql = "UPDATE book SET bookName = 'Harry Potter and the Deathly Hallows' , bookAuthor = 'J. K. Rowling', " +
                    " bookGenre = 'Fantasy' , bookLength = 698 , bookDate = '2018-07-23' , bookStatus = 1 WHERE bookID = 14";
            stmt.executeUpdate(sql);
            System.out.println("Updated records in the table.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}