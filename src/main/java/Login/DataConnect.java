package Login;

import org.mariadb.jdbc.Connection;

import java.sql.DriverManager;

public class DataConnect {

    public static Connection getConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/LikeHeroToZero", "root", "start");
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }

    }

    public static void close (Connection con) {
        try {
            con.close();
        } catch (Exception ex) {

        }
    }

}
