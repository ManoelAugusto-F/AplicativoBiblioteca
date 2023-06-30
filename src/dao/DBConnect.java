package dao;

import java.sql.*;


public class DBConnect {

    private static final String URL_MYSQL = "jdbc:mariadb://localhost:3306/LIVROS";
    private static final String DRIVER_CLASS_MYSQL = "org.mariadb.jdbc.Driver";
    private static final String USER = "admin";
    private static final String PASS = "123456";

    public static Connection getConnection() {
        System.out.println("Conectando ao Banco de Dados");
        try {
            Class.forName(DRIVER_CLASS_MYSQL);
            return DriverManager.getConnection(URL_MYSQL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable() {
        Connection connection = getConnection();
        PreparedStatement stmt = null;

        String sql = "CREATE TABLE IF NOT EXISTS Livros (" +
                "ID bigint(20) NOT NULL AUTO_INCREMENT, " +
                "Editora varchar(50) NOT NULL, " +
                "Titulo varchar(50) NOT NULL, " +
                "Isbn varchar(50) NOT NULL, " +
                "PRIMARY KEY (ID)" +
                ") ENGINE=InnoDB";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.execute();
            System.out.println("Create Tables Ok!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }
}
