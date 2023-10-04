package connecttosqlserver;

import java.sql.Connection; // Sử dụng Connection từ gói java.sql
import java.sql.DriverManager;
import java.sql.SQLException; // Sử dụng SQLException từ gói java.sql
import java.sql.*;
public class connectToSql {
    public static void main(String[] args) {
        try {
          String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyThuVien;trustServerCertificate=true";
          String userName = "sa";
          String password = "123456789";
            
            // Sử dụng Connection từ gói java.sql
            Connection connection = DriverManager.getConnection(url, userName, password);
            
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
               e.printStackTrace();
            System.err.println("Lỗi kết nối đến SQL Server: " + e.getMessage());

        }
    }
}
