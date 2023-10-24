/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connectsql.DatabaseConnection;
import form_main.Form_Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author haloi
 */
public class DAO_dangnhap {
    public Boolean isChucvu(String taikhoan) throws SQLException{
        Connection conn = DatabaseConnection.getConnection();
        String sql = "SELECT ChucVu FROM TaiKhoan WHERE TenNguoiDung = " + taikhoan;
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        
        String chucvu = "";
        if(rs.next()){
            chucvu = rs.getString("ChucVu");
        }
        if(chucvu.equals("Quản Lý")){
            return true;
        }
        return false;
    }
    
    public void KTTaikhoan (String taiKhoan, String matKhau){
        String sql_login = "select * from TaiKhoan where TenNguoiDung=? and MatKhau=?";
        try {
            // Kiểm tra xem conn đã được khởi tạo hay chưa
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql_login);
                pst.setString(1, taiKhoan);
                pst.setString(2, matKhau);
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                    Form_Main fm = new Form_Main();
                    fm.setVisible(true);
                    if(isChucvu(taiKhoan) == true){
                        fm.getjpanel_nguoi_dung().setVisible(true);
                        fm.getjlabel_nguoi_dung().setVisible(true);
                        
                    }
                    else if(isChucvu(taiKhoan) == false){
                        fm.getjpanel_nguoi_dung().setVisible(false);
                        fm.getjlabel_nguoi_dung().setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thực hiện đăng nhập: " + e.getMessage());
        }
    }
}
