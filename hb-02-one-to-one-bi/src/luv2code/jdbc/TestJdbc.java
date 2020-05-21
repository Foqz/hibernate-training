package luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";
        try {
            System.out.println("connecting to database");
            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("connection successful!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
