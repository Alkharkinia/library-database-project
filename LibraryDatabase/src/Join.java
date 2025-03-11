import java.sql.*;
import java.util.Scanner;

public class Join {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";

    static Scanner myObj = new Scanner(System.in);
    static String query = myObj.nextLine();
    static final String QUERY = "SELECT bookName, borrowDate ,borrowDue FROM book INNER JOIN borrow ON book.bookID = borrow.bookID ORDER BY borrowDue ASC;";
    static final String QUERY2 = "SELECT book.bookID, book.bookName, book.bookAuthor, book.bookDate, book.bookStatus, member.memberID, member.memberPassword, member.memberAddress," +
            " borrow.borrowID, borrow.borrowDate, borrow.borrowDue FROM book book JOIN borrow ON book.bookID = borrow.bookID JOIN member member ON borrow.memberID = member.memberID";

    public static void main(String[] args) {


        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            Statement stmt2 = conn.createStatement();

            ResultSet rs = stmt.executeQuery(QUERY);
            ResultSet rs2 = stmt2.executeQuery(QUERY2);

        ) {

            switch (query) {

                case "double":

            while (rs.next()) {


                System.out.print(" bookName: " + rs.getString("bookName"));
                System.out.print(", borrowDate: " + rs.getString("borrowDate"));
                System.out.println(", borrowDue: " + rs.getString("borrowDue"));

            }

            return;

                case "triple":

                    while (rs2.next()) {


                        System.out.print(" bookID: " + rs2.getInt("bookID"));
                        System.out.print(" bookName: " + rs2.getString("bookName"));
                        System.out.print(" bookAuthor: " + rs2.getString("bookAuthor"));
                        System.out.print(" bookDate: " + rs2.getString("bookDate"));
                        System.out.print(" bookStatus: " + rs2.getInt("bookStatus"));
                        System.out.print(" memberID: " + rs2.getInt("memberID"));
                        System.out.print(" memberPassword: " + rs2.getInt("memberPassword"));
                        System.out.print(" memberAddress: " + rs2.getString("memberAddress"));
                        System.out.print(" borrowID: " + rs2.getInt("borrowID"));
                        System.out.print(", borrowDate: " + rs2.getString("borrowDate"));
                        System.out.println(", borrowDue: " + rs2.getString("borrowDue"));

                    }

                default:


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}