package connecttosqlserver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyThuVien;trustServerCertificate=true";
            String username = "sa";
            String password = "123456789";

            try {
                conn = DriverManager.getConnection(jdbcUrl, username, password);
            } catch (SQLException e) {
                // Xử lý lỗi kết nối tại đây (ví dụ: ghi log, thông báo lỗi, v.v.)
                   e.printStackTrace();
            }
        }
        return conn;
    }
}
