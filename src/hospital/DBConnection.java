package hospital;

import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hospital_db",
                "root",
                "root"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
