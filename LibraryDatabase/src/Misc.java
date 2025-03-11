import java.sql.*;
import java.util.Scanner;

public class Misc {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";

    static Scanner myObj = new Scanner(System.in);
    static String query = myObj.nextLine();

    static final String QUERY = "SELECT * FROM puma.use WHERE useID IS NULL";
    static final String QUERY2 = "SELECT bookName, bookAuthor FROM book WHERE bookAuthor LIKE 'g%' ";
    static final String QUERY3 = "SELECT bookName FROM book WHERE bookStatus IN (1)";
    static final String QUERY4 = "SELECT bookName FROM book WHERE bookStatus NOT IN (1)";

    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            Statement stmt3 = conn.createStatement();
            Statement stmt4 = conn.createStatement();

            ResultSet rs = stmt.executeQuery(QUERY);
            ResultSet rs2 = stmt2.executeQuery(QUERY2);
            ResultSet rs3 = stmt3.executeQuery(QUERY3);
            ResultSet rs4 = stmt4.executeQuery(QUERY4);

        ) {

            switch (query) {

                case "null":

                    while (rs.next()) {

                        System.out.print("useID: " + rs.getInt("useID"));
                        System.out.print(", useDate: " + rs.getString("useDate"));
                        System.out.print(", useDue: " + rs.getString("useDue"));
                        System.out.print(", laptopID: " + rs.getInt("laptopID"));
                        System.out.println(", membersID: " + rs.getInt("membersID"));

                    }

                    return;

                case "like":

                    while (rs2.next()) {


                        System.out.print("bookName: " + rs2.getString("bookName"));
                        System.out.println(", bookAuthor: " + rs2.getString("bookAuthor"));


                    }

                    return;

                case "in":

                    while (rs3.next()) {


                        System.out.println("bookName: " + rs3.getString("bookName"));


                    }

                    return;

                case "not in":

                    while (rs4.next()) {


                        System.out.println("bookName: " + rs4.getString("bookName"));


                    }

                default:


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
