package Dao;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static HikariDataSource dataSource;

    static {
        try {
            // Cấu hình HikariCP
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=gaugaumeomeo;encrypt=false");
            config.setUsername("tuyen09");
            config.setPassword("8");

            // Các cấu hình Connection Pool
            config.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            config.setMaximumPoolSize(10); // Số lượng kết nối tối đa
            config.setMinimumIdle(5); // Số lượng kết nối tối thiểu
            config.setIdleTimeout(30000); // Thời gian idle tối đa (ms)
            config.setMaxLifetime(1800000); // Thời gian tồn tại tối đa của một connection (ms)
            config.setConnectionTimeout(20000); // Thời gian chờ để lấy một connection (ms)

            // Tạo DataSource
            dataSource = new HikariDataSource(config);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing HikariCP connection pool", e);
        }
    }

    // Phương thức để lấy DataSource
    public static Connection getConnection() throws SQLException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void shutdown() {
        if (dataSource != null) {
            dataSource.close();
        }


    }


    public static void main(String[] args) throws SQLException {
        try(Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Database connection successful!");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    }
