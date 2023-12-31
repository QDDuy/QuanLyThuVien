/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contructor;

import connectsql.DatabaseConnection;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public QuanLyNhapSach() {
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
    public List<QuanLyNhapSach> getList(){
        Connection conn = DatabaseConnection.getConnection();
        String sql = "select * from PhieuNhap";
        List<QuanLyNhapSach> list = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLyNhapSach nhapSach= new QuanLyNhapSach();
                nhapSach.setMaphieunhap(rs.getInt("MaPhieuNhap"));
                nhapSach.setMasach(rs.getInt("MaSach"));
                nhapSach.setNguoinhap(rs.getString("NguoiNhap"));
                nhapSach.setNgaynhap(rs.getDate("NgayNhap"));
                nhapSach.setSoluong(rs.getInt("SoLuong"));
                list.add(nhapSach);
            }
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public int create(QuanLyNhapSach nhapSach) {
        try{
            Connection conn = DatabaseConnection.getConnection();
            // Kiểm tra xem mã Thẻ đã có trong bảng chưa
            String sql = "SELECT * FROM PhieuNhap WHERE MaPhieuNhap = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nhapSach.getMaphieunhap());
            ResultSet rs = ps.executeQuery();

            // Nếu mã Thẻ đã có trong bảng, hiển thị thông báo lỗi
            if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Mã phiếu nhập đã tồn tại!");
            return 0;
            }
            
            sql = "SELECT * FROM Sach WHERE MaSach = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, nhapSach.getMasach());
            rs = ps.executeQuery();

            // Nếu mã sách không có trong bảng sách, hiển thị thông báo lỗi
            if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "Mã sách không tồn tại!");
            return 0;
            }
            
            int SoLuong = getSoLuongSach_Bangsach(nhapSach.getMasach()) + nhapSach.getSoluong();
            capNhatSoLuongSach(nhapSach.getMasach(), SoLuong);
            java.sql.Date ngayNhap = new java.sql.Date(nhapSach.getNgaynhap().getTime());
            sql = "INSERT INTO PhieuNhap(MaPhieuNhap, MaSach, NguoiNhap, NgayNhap, SoLuong) values(?, ? , ?, ?, ?) ";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, nhapSach.getMaphieunhap());
            ps.setInt(2, nhapSach.getMasach());
            ps.setString(3, nhapSach.getNguoinhap());
            ps.setDate(4, ngayNhap); 
            ps.setInt(5, nhapSach.getSoluong());
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
    
    
    public int edit(QuanLyNhapSach nhapSach) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            // Sử dụng dữ liệu này để thực hiện hành động sửa
            if(nhapSach.getSoLuongSach_BangNhap(nhapSach.getMaphieunhap())> nhapSach.getSoluong()){
                int SoLuong = nhapSach.getSoLuongSach_Bangsach(nhapSach.getMasach()) - (nhapSach.getSoLuongSach_BangNhap(nhapSach.getMaphieunhap()) - nhapSach.getSoluong());
                capNhatSoLuongSach(nhapSach.getMasach(), SoLuong);
            }
            
            else if(nhapSach.getSoLuongSach_BangNhap(nhapSach.getMaphieunhap())< nhapSach.getSoluong()){
                int SoLuong = nhapSach.getSoluong() - nhapSach.getSoLuongSach_BangNhap(nhapSach.getMaphieunhap());
                capNhatSoLuongSach(nhapSach.getMasach(), SoLuong + nhapSach.getSoLuongSach_Bangsach(nhapSach.getMasach()));
            }
            java.sql.Date ngayNhap = new java.sql.Date(nhapSach.getNgaynhap().getTime());
            String sql = "UPDATE PhieuNhap SET MaSach = ?, NguoiNhap = ?, NgayNhap = ?, SoLuong = ? WHERE MaPhieuNhap = ?";
            PreparedStatement ps = conn.prepareStatement(sql);    
            ps.setInt(5, nhapSach.getMaphieunhap());
            ps.setInt(1, nhapSach.getMasach());
            ps.setString(2, nhapSach.getNguoinhap());
            ps.setDate(3, ngayNhap);
            ps.setInt(4 , nhapSach.getSoluong());
            ps.execute();       
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int delete(QuanLyNhapSach nhapSach) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            // Sử dụng dữ liệu này để thực hiện hành động xóa
            String sql = "DELETE FROM PhieuNhap WHERE MaPhieuNhap = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nhapSach.getMaphieunhap());
            ps.execute();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void capNhatSoLuongSach(int masach, int soluong) throws SQLException {
        // Tạo truy vấn cập nhật số lượng sách
        Connection conn = DatabaseConnection.getConnection();
        String query = "UPDATE Sach SET SoLuong = ? WHERE MaSach = ?";

        // Tạo đối tượng PreparedStatement
        PreparedStatement ps = conn.prepareStatement(query);

        // Gán giá trị cho các tham số
        ps.setInt(1, soluong);
        ps.setInt(2, masach);

        // Thực thi truy vấn
        ps.execute();
        ps.close();
        
    }
    
    public int getSoLuongSach_Bangsach(int masach) throws SQLException {
        // Tạo truy vấn lấy số lượng sách
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT SoLuong FROM Sach WHERE MaSach = ?";

        // Tạo đối tượng PreparedStatement
        PreparedStatement ps = conn.prepareStatement(query);

        // Gán giá trị cho tham số
        ps.setInt(1, masach);

        // Thực thi truy vấn
        ResultSet resultSet = ps.executeQuery();

        // Lấy số lượng sách
        int soluong = 0;
        if (resultSet.next()) {
            soluong = resultSet.getInt(1);
        }

        return soluong;
    }
    public int getSoLuongSach_BangNhap(int maphieunhap) throws SQLException {
        // Tạo truy vấn lấy số lượng sách
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT SoLuong FROM PhieuNhap WHERE MaPhieuNhap = ?";

        // Tạo đối tượng PreparedStatement
        PreparedStatement ps = conn.prepareStatement(query);

        // Gán giá trị cho tham số
        ps.setInt(1, maphieunhap);

        // Thực thi truy vấn
        ResultSet resultSet = ps.executeQuery();

        // Lấy số lượng sách
        int soluong = 0;
        if (resultSet.next()) {
            soluong = resultSet.getInt(1);
        }

        return soluong;
    } 
}
