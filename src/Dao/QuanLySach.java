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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author haloi
 */
public class QuanLySach {
    
    
    private int masach;
    private int makesach;
    private String tensach;
    private String theloai;
    private String tacgia;
    private int soluong;
    private Date ngayxuatban;
    private String nhasanxuat;
    private String tinhtrangsach;
    
    
    public QuanLySach(int masach, int makesach, String tensach, String theloai, String tacgia, int soluong, Date ngayxuatban, String nhasanxuat, String tinhtrangsach) {
        this.masach = masach;
        this.makesach = makesach;
        this.tensach = tensach;
        this.theloai = theloai;
        this.tacgia = tacgia;
        this.soluong = soluong;
        this.ngayxuatban = ngayxuatban;
        this.nhasanxuat = nhasanxuat;
        this.tinhtrangsach = tinhtrangsach;
    }
    public QuanLySach(){
        
    }

    public int getMasach() {
        return masach;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    public int getMakesach() {
        return makesach;
    }

    public void setMakesach(int makesach) {
        this.makesach = makesach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Date getNgayxuatban() {
        return ngayxuatban;
    }

    public void setNgayxuatban(Date ngayxuatban) {
        this.ngayxuatban = ngayxuatban;
    }

    public String getNhasanxuat() {
        return nhasanxuat;
    }

    public void setNhasanxuat(String nhasanxuat) {
        this.nhasanxuat = nhasanxuat;
    }

    public String getTinhtrangsach() {
        return tinhtrangsach;
    }

    public void setTinhtrangsach(String tinhtrangsach) {
        this.tinhtrangsach = tinhtrangsach;
    }

    
    
    public List<QuanLySach> getList(){
        Connection conn = DatabaseConnection.getConnection();
        String sql = "select * from Muontra";
        List<QuanLySach> list = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLySach sach = new QuanLySach();
                sach.setMasach(rs.getInt("MaSach"));
                sach.setMakesach(rs.getInt("MaKeSach"));
                sach.setTensach(rs.getString("TenSach"));
                sach.setTheloai(rs.getString("TheLoai"));
                sach.setTacgia(rs.getString("TacGia"));
                sach.setSoluong(rs.getInt("SoLuong"));
                sach.setNgayxuatban(rs.getDate("NgayXuatBan"));
                sach.setNhasanxuat(rs.getString("NhaSanXuat"));
                sach.setTinhtrangsach(rs.getString("TinhTrangSach"));
                list.add(sach);
            }
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public int create(QuanLySach sach) {
        try{
            Connection conn = DatabaseConnection.getConnection();
            // Kiểm tra xem mã sách đã có trong bảng chưa
            String sql = "SELECT * FROM Sach WHERE MaSach = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sach.getMasach());
            ps.execute();
            ResultSet rs = ps.executeQuery();

            // Nếu mã sách đã có trong bảng, hiển thị thông báo lỗi
            if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Mã sách đã tồn tại!");
            return 0;
            }
            
            sql = "SELECT * FROM KeSach WHERE MaSach = MaKeSach ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sach.getMakesach());
            ps.execute();
            rs = ps.executeQuery();

            // Nếu mã Thẻ đã có trong bảng, hiển thị thông báo lỗi
            if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Mã kệ sách đã tồn tại!");
            return 0;
            }
            
            
            java.sql.Date ngayXB = new java.sql.Date(sach.getNgayxuatban().getTime());
            
            
            sql = "INSERT INTO Sach values(?, ? , ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sach.getMasach());
            ps.setInt(2, sach.getMakesach());
            ps.setString(3, sach.getTensach());
            ps.setString(4, sach.getTensach());
            ps.setString(5, sach.getTacgia());
            ps.setInt(6, sach.getSoluong());
            ps.setDate(7, ngayXB);
            ps.setString(8, sach.getNhasanxuat());
            ps.setString(9, sach.getTinhtrangsach());
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
    
    
    public int edit(QuanLySach sach) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            // Sử dụng dữ liệu này để thực hiện hành động sửa
            String sql = "SELECT * FROM KeSach WHERE MaSach = MaKeSach ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sach.getMakesach());
            ps.execute();
            ResultSet rs = ps.executeQuery();

            // Nếu mã Thẻ đã có trong bảng, hiển thị thông báo lỗi
            if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Mã kệ sách đã tồn tại!");
            return 0;
            }
            
            
            java.sql.Date ngayXB = new java.sql.Date(sach.getNgayxuatban().getTime());
            
            sql = "UPDATE Sach SET  MaKeSach = ?, TenSach = ?, TheLoai = ?, TacGia = ?, SoLuong = ?, NgayXuatBan = ?, NhaSanXuat = ?, TinhTrangSach = ? WHERE MaSach = ?";
            ps = conn.prepareStatement(sql);    
            ps.setInt(9, sach.getMasach());
            ps.setInt(1, sach.getMakesach());
            ps.setString(2, sach.getTensach());
            ps.setString(3, sach.getTensach());
            ps.setString(4, sach.getTacgia());
            ps.setInt(5, sach.getSoluong());
            ps.setDate(6, ngayXB);
            ps.setString(7, sach.getNhasanxuat());
            ps.setString(8, sach.getTinhtrangsach());
            ps.execute();     
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int delete(QuanLySach sach) {
    try {
        Connection conn = DatabaseConnection.getConnection();
        // Sử dụng dữ liệu này để thực hiện hành động xóa
        String sql = "DELETE FROM Sach WHERE MaSach = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, sach.getMasach());
        ps.execute();
        return 1;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}
}
