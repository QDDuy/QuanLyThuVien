package connecttosqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectToSql {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyThuVien;trustServerCertificate=true"; 

 

//  tạo biến gán tên đăng nhập và mật khẩu để kết nối tới sqlserver 

        String username = "sa"; 

        String password = "admin123"; 

 

//  bắt ngoại lệ khi connect 

        try { 

            // Kết nối đến cơ sở dữ liệu SQL Server 

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password); 

 

            // Kiểm tra kết nối thành công 

            if (connection != null) { 

                System.out.println("Ok roi!"); 

                connection.close(); // Đóng kết nối sau khi sử dụng 

            } 

        } catch (SQLException e) { 


// in lỗi cần sửa khi sảy ra ngoại lệ
                System.err.println("Loiiiiiiiiiii: " + e.getMessage()); 

        } 
    }
}
