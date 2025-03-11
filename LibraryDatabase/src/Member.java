import java.sql.*;

public class Member {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";
    static final String QUERY = "SELECT memberID, memberName, memberAddress, memberPassword FROM member";

    public static void main(String[] args) {


        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {

            while (rs.next()) {

                System.out.print("memberID: " + rs.getInt("memberID"));
                System.out.print(", memberName: " + rs.getString("memberName"));
                System.out.print(", memberAddress: " + rs.getString("memberAddress"));
                System.out.println(", memberPassword: " + rs.getInt("memberPassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


