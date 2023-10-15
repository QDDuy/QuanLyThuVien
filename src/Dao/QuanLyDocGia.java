/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import connectsql.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haloi
 */
public class QuanLyDocGia {


    private int MaTHe;
    private String tenKH;
    private String diachi;
    private String SDT;
    private String cccd;
    private String email;
    
    
    public QuanLyDocGia(int MaTHe, String tenKH, String diachi, String SDT, String cccd, String email) {
        this.MaTHe = MaTHe;
        this.tenKH = tenKH;
        this.diachi = diachi;
        this.SDT = SDT;
        this.cccd = cccd;
        this.email = email;
    }

    public QuanLyDocGia() {
    }

    public void setMaTHe(int MaTHe) {
        this.MaTHe = MaTHe;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMaTHe() {
        return MaTHe;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getSDT() {
        return SDT;
    }

    public String getCccd() {
        return cccd;
    }

    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "QuanLyDocGia{" + "MaTHe=" + MaTHe + ", tenKH=" + tenKH + ", diachi=" + diachi + ", SDT=" + SDT + ", cccd=" + cccd + ", email=" + email + '}';
    }
    // xu ly su kien them, sua, xoa, tim kiem, hiển thị
    public List<QuanLyDocGia> getList(){
        Connection conn = DatabaseConnection.getConnection();
        String sql = "select * from DocGia";
        List<QuanLyDocGia> list = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLyDocGia docgia = new QuanLyDocGia();
                docgia.setMaTHe(rs.getInt("MaTHe"));
                docgia.setTenKH(rs.getString("HoVaTenDem"));
                docgia.setDiachi(rs.getString("DiaChi"));
                docgia.setSDT(rs.getString("SoDienThoai"));
                docgia.setCccd(rs.getString("SoCCCD"));
                docgia.setEmail(rs.getString("Email"));
                list.add(docgia);
            }
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public int create(QuanLyDocGia docGia) {
        try{
            Connection conn = DatabaseConnection.getConnection();
            // Kiểm tra xem mã Thẻ đã có trong bảng chưa
            String sql = "SELECT * FROM DocGia WHERE MaThe = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, docGia.getMaTHe());
            ResultSet rs = ps.executeQuery();

            // Nếu mã Thẻ đã có trong bảng, hiển thị thông báo lỗi
            if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Mã Thẻ đã tồn tại!");
            return 0;
            }
            
            
            sql = "INSERT INTO DocGia(MaThe, HoVaTenDem, DiaChi, SoDienThoai, SoCCCD, Email) values(?, ? , ?, ?, ?, ?) ";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, docGia.getMaTHe());
            ps.setString(2, docGia.getTenKH());
            ps.setString(3, docGia.getDiachi());
            ps.setString(4, docGia.getSDT());
            ps.setString(5, docGia.getCccd());
            ps.setString(6, docGia.getEmail());
            ps.execute();
            rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if(rs.next()){
                generatedKey = rs.getInt(1);
            }
            ps.close();
            return generatedKey;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    
    public int edit(QuanLyDocGia docGia) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            // Sử dụng dữ liệu này để thực hiện hành động sửa
            String sql = "UPDATE DocGia SET HoVaTenDem = ?, DiaChi = ?, SoDienThoai = ?, SoCCCD = ?, Email = ? WHERE MaThe = ?";
            PreparedStatement ps = conn.prepareStatement(sql);    
            ps.setString(1, docGia.getTenKH());
            ps.setString(2, docGia.getDiachi());
            ps.setString(3, docGia.getSDT());
            ps.setString(4, docGia.getCccd());
            ps.setString(5, docGia.getEmail());
            ps.setInt(6, docGia.getMaTHe());
            ps.execute();       
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int delete(QuanLyDocGia docGia) {
    try {
        Connection conn = DatabaseConnection.getConnection();
        // Sử dụng dữ liệu này để thực hiện hành động xóa
        String sql = "DELETE FROM DocGia WHERE MaThe = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, docGia.getMaTHe());
        ps.execute();
        return 1;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}

}
