/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import connectsql.DatabaseConnection;
import java.sql.Connection;
import java.util.Date;
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
public class QuanLyMuonTra {

    private int maGiaodich;
    private int mathe;
    private int masach;
    private Date ngaymuon;
    private Date ngayhethan;
    private Date ngaytrasach;
    private int sotien;
    
    public QuanLyMuonTra(int maGiaodich, int mathe, int masach, Date ngaymuon, Date ngayhethan, Date ngaytrasach) {
        this.maGiaodich = maGiaodich;
        this.mathe = mathe;
        this.masach = masach;
        this.ngaymuon = ngaymuon;
        this.ngayhethan = ngayhethan;
        this.ngaytrasach = ngaytrasach;
        
    }

    public QuanLyMuonTra() {
    }  
    
    public int getMaGiaodich() {
        return maGiaodich;
    }

    public int getMathe() {
        return mathe;
    }

    public int getMasach() {
        return masach;
    }

    public Date getNgaymuon() {
        return ngaymuon;
    }

    public Date getNgayhethan() {
        return ngayhethan;
    }

    public Date getNgaytrasach() {
        return ngaytrasach;
    }

    public int getSotien() {
        return sotien;
    }
    
    public void setMaGiaodich(int maGiaodich) {
        this.maGiaodich = maGiaodich;
    }

    public void setMathe(int mathe) {
        this.mathe = mathe;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    public void setNgaymuon(Date ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public void setNgayhethan(Date ngayhethan) {
        this.ngayhethan = ngayhethan;
    }

    public void setNgaytrasach(Date ngaytrasach) {
        this.ngaytrasach = ngaytrasach;
    }

    public void setSotien(int sotien) {
        this.sotien = sotien;
    }
    // xu ly su kien them, sua, xoa, tim kiem, hiển thị
    public List<QuanLyMuonTra> getList(){
        Connection conn = DatabaseConnection.getConnection();
        String sql = "select * from Muontra";
        List<QuanLyMuonTra> list = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLyMuonTra muontra = new QuanLyMuonTra();
                muontra.setMaGiaodich(rs.getInt("MaGiaoDich"));
                muontra.setMathe(rs.getInt("MaThe"));
                muontra.setMasach(rs.getInt("MaSach"));
                muontra.setNgaymuon(rs.getDate("NgayMuon"));
                muontra.setNgayhethan(rs.getDate("NgayHetHan"));
                muontra.setNgaytrasach(rs.getDate("NgayTraSach"));
                muontra.setSotien(rs.getInt("SoTien"));
                list.add(muontra);
            }
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public int create(QuanLyMuonTra muontra) {
        try{
            Connection conn = DatabaseConnection.getConnection();
            // Kiểm tra xem mã Thẻ đã có trong bảng chưa
            String sql = "SELECT * FROM MuonTra WHERE MaGiaoDich = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, muontra.getMaGiaodich());
            ps.execute();
            ResultSet rs = ps.executeQuery();

            // Nếu mã Thẻ đã có trong bảng, hiển thị thông báo lỗi
            if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Mã giao dịch đã tồn tại!");
            return 0;
            }
            
            sql = "SELECT * FROM DocGia WHERE MaThe = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, muontra.getMathe());

            rs = ps.executeQuery();

            // Nếu mã thẻ không tồn tại trong bảng độc giả, hiển thị thông báo lỗi
            if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "Mã thẻ không tồn tại!");
            return 0;
            }
            java.sql.Date ngayMuon = new java.sql.Date(muontra.getNgaymuon().getTime());
            java.sql.Date ngayHetHan = new java.sql.Date(muontra.getNgayhethan().getTime());
            java.sql.Date ngayTra = new java.sql.Date(muontra.getNgaytrasach().getTime());
            sql = "INSERT INTO Muontra values(?, ? , ?, ?, ?, ?, ?) ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, muontra.getMaGiaodich());
            ps.setInt(2, muontra.getMathe());
            ps.setInt(3, muontra.getMasach());
            ps.setDate(4, ngayMuon);
            ps.setDate(5, ngayHetHan);
            ps.setDate(6, ngayTra);
            ps.setDouble(7,muontra.getSotien());
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
    
    
    public int edit(QuanLyMuonTra muontra) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            // Sử dụng dữ liệu này để thực hiện hành động sửa
            java.sql.Date ngayMuon = new java.sql.Date(muontra.getNgaymuon().getTime());
            java.sql.Date ngayHetHan = new java.sql.Date(muontra.getNgayhethan().getTime());
            java.sql.Date ngayTra = new java.sql.Date(muontra.getNgaytrasach().getTime());
            String sql = "UPDATE MuonTra SET  MaThe = ?, MaSach = ?, NgayMuon = ?, NgayHetHan = ?,NgayTraSach = ?,SoTien=? WHERE MaGiaoDich = ?";
            PreparedStatement ps = conn.prepareStatement(sql);    
            ps.setInt(1, muontra.getMathe());
            ps.setInt(2, muontra.getMasach());
            ps.setDate(3,  ngayMuon);
            ps.setDate(4,  ngayHetHan);
            ps.setDate(5,  ngayHetHan);
            ps.setDouble(6, muontra.getSotien());
            ps.setInt(7,muontra.getMaGiaodich() );
            ps.execute();       
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int delete(QuanLyMuonTra muonTra) {
    try {
        Connection conn = DatabaseConnection.getConnection();
        // Sử dụng dữ liệu này để thực hiện hành động xóa
        String sql = "DELETE FROM Muontra WHERE MaThe = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, muonTra.getMaGiaodich());
        ps.execute();
        return 1;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}
}
