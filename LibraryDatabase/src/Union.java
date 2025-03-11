import java.sql.*;
import java.util.Scanner;

public class Union {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";

    static Scanner myObj = new Scanner(System.in);
    static String query = myObj.nextLine();


    static final String QUERY = "SELECT bookID FROM book UNION SELECT bookID FROM borrow ORDER BY bookID DESC";
    static final String QUERY2 = "SELECT bookID FROM book INTERSECT SELECT bookID FROM borrow ORDER BY bookID DESC";
    static final String QUERY3 = "SELECT bookID FROM book EXCEPT SELECT bookID FROM borrow ORDER BY bookID DESC";


    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement stmt = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            Statement stmt3 = conn.createStatement();

            ResultSet rs = stmt.executeQuery(QUERY);
            ResultSet rs2 = stmt2.executeQuery(QUERY2);
            ResultSet rs3 = stmt3.executeQuery(QUERY3);

        ) {

            switch (query) {

                case "union":

                    while (rs.next()) {


                        System.out.println("bookID: " + rs.getInt("bookID"));


                    }

                    return;

                case "intersect":

                    while (rs2.next()) {


                        System.out.println("bookID: " + rs2.getInt("bookID"));

                    }

                    return;


                case "except":

                    while (rs3.next()) {


                        System.out.println("bookID: " + rs3.getInt("bookID"));

                    }



                default:

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

