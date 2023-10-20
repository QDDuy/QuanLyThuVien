/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import connectsql.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author haloi
 */
public class DAO_thong_ke {

   
    
    public void getTotalRowLabel_luot_giao_dich(JLabel jlabel_luot_giao_dich) {
        // Tạo truy vấn lấy tổng số row trong bảng Sách
        String query = "SELECT COUNT(*) FROM Muontra";

        // Thực thi truy vấn
        int totalRow = 0;
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            totalRow = resultSet.getInt(1);
        } catch (SQLException e) {
        e.printStackTrace();
        }
        if(totalRow < 10){
            jlabel_luot_giao_dich.setText("00" + totalRow);
        }else if(totalRow < 100){
            jlabel_luot_giao_dich.setText("0" + totalRow);
        }else if(totalRow < 1000){
            jlabel_luot_giao_dich.setText("" + totalRow);
        }else if(totalRow >= 1000){
            JOptionPane.showMessageDialog(null, "số giao dịch vượt quá khả năng tính toán");
        }
        

    }
    
    
    
    
    public void getTotalRowLabel_tre_han_tra_sach(JLabel jlabel_tre_han_tra_sach) {
        // Tạo truy vấn lấy tổng số row trong bảng Sách
        String query = "SELECT COUNT(*) FROM Muontra";

        // Thực thi truy vấn
        int totalRow = 0;
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            totalRow = resultSet.getInt(1);
        } catch (SQLException e) {
        e.printStackTrace();
        }
        if(totalRow < 10){
            jlabel_tre_han_tra_sach.setText("00" + totalRow);
        }else if(totalRow < 100){
            jlabel_tre_han_tra_sach.setText("0" + totalRow);
        }else if(totalRow < 1000){
            jlabel_tre_han_tra_sach.setText("" + totalRow);
        }else if(totalRow >= 1000){
            JOptionPane.showMessageDialog(null, "số giao dịch vượt quá khả năng tính toán");
        }
        

    }
    
        public void getTotalRowLabel_tong_so_sach(JLabel jlabel_tong_so_sach) {
        // Tạo truy vấn lấy tổng số row trong bảng Sách
        String query = "SELECT COUNT(*) FROM Sach";

        // Thực thi truy vấn
        int totalRow = 0;
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            totalRow = resultSet.getInt(1);
        } catch (SQLException e) {
        e.printStackTrace();
        }
        if(totalRow < 10){
            jlabel_tong_so_sach.setText("00" + totalRow);
        }else if(totalRow < 100){
            jlabel_tong_so_sach.setText("0" + totalRow);
        }else if(totalRow < 1000){
            jlabel_tong_so_sach.setText("" + totalRow);
        }else if(totalRow >= 1000){
            JOptionPane.showMessageDialog(null, "số giao dịch vượt quá khả năng tính toán");
        }
        

    }
    
}
