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
import java.sql.Date;
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
    
    
    
    
    public void getTotalRowLabel_tre_han_tra_sach(JLabel jlabel_tre_han_tra_sach) throws SQLException {
        
        // Thực hiện truy vấn SQL
        try {
            int diff = 0;
            int totalRow = 0;
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT NgayHetHan, NgayTraSach FROM Muontra WHERE NgayHetHan < NgayTraSach";
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            // Tính toán số ngày trễ trả
            while (resultSet.next()) {
            Date date1 = resultSet.getDate("NgayHetHan");
            Date date2 = resultSet.getDate("NgayTraSach");
            diff = (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
            if(diff > 0){
               totalRow++; 
            }
            }
  
            // Trả về số ngày trễ trả tổng cộng
            jlabel_tre_han_tra_sach.setText(String.valueOf(diff));
            
            if(totalRow < 10){
                jlabel_tre_han_tra_sach.setText("00" + totalRow);
            }else if(totalRow < 100){
                jlabel_tre_han_tra_sach.setText("0" + totalRow);
            }else if(totalRow < 1000){
                jlabel_tre_han_tra_sach.setText("" + totalRow);
            }else if(totalRow >= 1000){
                JOptionPane.showMessageDialog(null, "số giao dịch vượt quá khả năng tính toán");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
