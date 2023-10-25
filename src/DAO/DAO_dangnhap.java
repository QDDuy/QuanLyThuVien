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
    
public Boolean isChucvu(String taiKhoan, String matKhau) throws SQLException{
    Connection conn = DatabaseConnection.getConnection();
    String sql = "SELECT ChucVu FROM TaiKhoan WHERE TenNguoiDung = '" + taiKhoan + "' and MatKhau = '"+ matKhau +"' ";
    ResultSet rs = conn.createStatement().executeQuery(sql);

    String chucvu = "";
    if(rs.next()){
        chucvu = rs.getString("ChucVu");
    }
    if(chucvu.equals("Quản Lý")){
        return true;
    }
    return false;
}
}
