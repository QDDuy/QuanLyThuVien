package connecttosqlserver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection conn;

    public static Connection getConnection() {
        
            String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyThuVien;trustServerCertificate=true";
            String username = "sa";
            String password = "loiha12345";
        
            //  bắt ngoại lệ khi connect
        try {
            // Kết nối đến cơ sở dữ liệu SQL Server
            conn = DriverManager.getConnection(jdbcUrl, username, password);

            // Kiểm tra kết nối thành công
            if (conn != null) {
                System.out.println("Kết nối đến SQL Server thành công!");
                conn.close(); // Đóng kết nối sau khi sử dụng
            }
        } catch (SQLException e) {
// in lỗi cần sửa khi sảy ra ngoại lệ
            e.printStackTrace();
            System.err.println("Lỗi kết nối đến SQL Server: " + e.getMessage());
        }
        return conn;
        
    }
}
