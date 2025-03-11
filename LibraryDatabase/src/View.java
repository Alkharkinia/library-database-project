import java.sql.*;
import java.util.Scanner;

public class View {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";

    static Scanner myObj = new Scanner(System.in);
    static String query = myObj.nextLine();

    static String sql = "CREATE VIEW bookaile AS SELECT bookName, bookAuthor FROM book";
    static String sql2 = "DROP VIEW bookaile";
    static String sql3 = "ALTER VIEW bookstore AS SELECT bookName, bookAuthor, bookDate FROM book";
    static final String QUERY = "SELECT bookName, bookAuthor from bookstore";

    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

        ) {

            switch (query) {

            case "create":

            System.out.println("Creating view table...");

            stmt.executeUpdate(sql);

            System.out.println("Created view table...");

            return;

                case "select":

                    while (rs.next()) {


                        System.out.print("bookName: " + rs.getString("bookName"));
                        System.out.println(", bookAuthor: " + rs.getString("bookAuthor"));

                    }

                    return;


                case "drop":

                    System.out.println("Dropping view table...");

                    stmt.executeUpdate(sql2);

                    System.out.println("Dropped view table...");


                    return;

                case "alter":

                    System.out.println("Altering view table...");

                    stmt.executeUpdate(sql3);

                    System.out.println("Altering view table...");

                default:

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
