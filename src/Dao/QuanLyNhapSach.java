/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import connectsql.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author haloi
 */
public class QuanLyNhapSach {
    
    private int maphieunhap;
    private int masach;
    private String nguoinhap;
    private Date ngaynhap;
    private int soluong;

    public QuanLyNhapSach(int maphieunhap, int masach, String nguoinhap, Date ngaynhap, int soluong) {
        this.maphieunhap = maphieunhap;
        this.masach = masach;
        this.nguoinhap = nguoinhap;
        this.ngaynhap = ngaynhap;
        this.soluong = soluong;
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public int getMasach() {
        return masach;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    public String getNguoinhap() {
        return nguoinhap;
    }

    public void setNguoinhap(String nguoinhap) {
        this.nguoinhap = nguoinhap;
    }

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
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
