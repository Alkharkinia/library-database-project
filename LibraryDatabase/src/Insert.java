import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    static final String DB_URL = "jdbc:mysql://localhost:3306/puma";
    static final String USER = "root";
    static final String PASS = "Je3Bz4h4";

    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {

            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO book (bookID, bookName, bookAuthor, bookGenre, bookLength, bookDate, bookStatus)" +
                    " VALUES (24,'Nutuk', 'Mustafa Kemal Atatürk', 'Politics', 534, '2020-10-15', 0)," +
                    "(25,'The Martian', 'Andy Weir', 'Science Fiction', 534, '2020-10-15', 1)," +
                    "(26,'Nutuk', 'Mustafa Kemal Atatürk', 'Politics', 534, '2020-10-15', 1)," +
                    "(27,'Nutuk', 'Mustafa Kemal Atatürk', 'Politics', 534, '2020-10-15', 0)," +
                    "(28,'Nutuk', 'Mustafa Kemal Atatürk', 'Politics', 534, '2020-10-15', 1)," +
                    "(29,'Nutuk', 'Mustafa Kemal Atatürk', 'Politics', 534, '2020-10-15', 1)," +
                    "(30,'Nutuk', 'Mustafa Kemal Atatürk', 'Politics', 534, '2020-10-15', 0)," +
                    "(31,'Nutuk', 'Mustafa Kemal Atatürk', 'Politics', 534, '2020-10-15', 0)," +
                    "(32,'Nutuk', 'Mustafa Kemal Atatürk', 'Politics', 534, '2020-10-15', 1)," +
                    "(33,'Nutuk', 'Mustafa Kemal Atatürk', 'Politics', 534, '2020-10-15', 0)";

            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
