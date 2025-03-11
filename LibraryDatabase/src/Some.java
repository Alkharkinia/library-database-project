import java.sql.*;
import java.util.Scanner;

public class Some {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";

    static Scanner myObj = new Scanner(System.in);
    static String query = myObj.nextLine();


    static final String QUERY = "SELECT bookName, bookAuthor FROM book WHERE bookID = SOME (SELECT bookID FROM borrow WHERE book.bookID = borrow.bookID)";
    static final String QUERY2 = "SELECT bookName, bookAuthor FROM book WHERE bookID = ALL (SELECT bookID FROM borrow WHERE book.bookID = borrow.bookID)";


    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            Statement stmt2 = conn.createStatement();


            ResultSet rs = stmt.executeQuery(QUERY);
            ResultSet rs2 = stmt2.executeQuery(QUERY2);


        ) {

            switch (query) {

                case "some":

                    while (rs.next()) {

                        System.out.print("bookName: " + rs.getString("bookName"));
                        System.out.println(", bookAuthor: " + rs.getString("bookAuthor"));

                    }

                    return;

                case "all":

                    while (rs2.next()) {


                        System.out.print("bookName: " + rs2.getString("bookName"));
                        System.out.println(", bookAuthor: " + rs2.getString("bookAuthor"));

                    }


                default:


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
