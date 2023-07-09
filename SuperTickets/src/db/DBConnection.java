package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection getConnection(String driver, String dbname, String user, String pwd) {
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(getConnectionUrl(driver, dbname, user, pwd));
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException(ex);
        }

        return con;
    }

    public String getConnectionUrl(String driver, String dbname, String user, String pwd) {
        if (driver.equals(DBDriver.MYSQL)) {
            return "jdbc:mysql://localhost/" + dbname + "?user=" + user + "&password=" + pwd;
        } else if (driver.equals(DBDriver.SQLSERVER)) {
            return "jdbc:sqlserver://127.0.0.1; databaseName=" + dbname + "; user=" + user + ";password=" + pwd + ";";
        }
        return null;
    }
}
