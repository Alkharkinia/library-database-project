import java.sql.*;

public class Exists {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";
    static final String QUERY = "SELECT memberName, EXISTS (SELECT memberID FROM borrow WHERE member.memberID = borrow.memberID AND borrowID > 100) AS result, " +
            "NOT EXISTS (SELECT memberID FROM borrow WHERE member.memberID = borrow.memberID AND borrowID < 100) AS result2  FROM member WHERE EXISTS (SELECT memberID FROM borrow WHERE member.memberID = borrow.memberID AND borrowID > 100)";

    public static void main(String[] args) {


        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {




            while (rs.next()) {

                System.out.print("result: " + rs.getBoolean("result"));
                System.out.print(", result2: " + rs.getBoolean("result2"));
                System.out.println(", memberName: " + rs.getString("memberName"));



            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}