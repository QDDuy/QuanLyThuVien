/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


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
        this.ngaytrasach = null;
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
            if(muontra.getNgaytrasach() != null){
                
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
                ps.setInt(7,muontra.getSotien());
                ps.execute();
                rs = ps.getGeneratedKeys();
                int generatedKey = 0;
                if(rs.next()){
                    generatedKey = rs.getInt(1);
                }
                ps.close();
                return generatedKey;
                
            }else if(muontra.getNgaytrasach() == null){
                if(muontra.getSoLuongSach(muontra.getMasach()) == 0){
                        String tinhTrangSach = "Hết Sách";
                        muontra.capNhatTinhTrangSach(muontra.getMasach(), tinhTrangSach);
                        JOptionPane.showMessageDialog(null, "số lượng sách có mã sách là "+ muontra.getMasach()+ " không đủ để cho mượn");
                        return 0;
                }
                if(muontra.getSoLuongSach(muontra.getMasach()) > 0){
                    int soluong = muontra.getSoLuongSach(muontra.getMasach()) - 1;
                    capNhatSoLuongSach(muontra.getMasach(), soluong);
                }
                java.sql.Date ngayMuon = new java.sql.Date(muontra.getNgaymuon().getTime());
                java.sql.Date ngayHetHan = new java.sql.Date(muontra.getNgayhethan().getTime());
                
                sql = "INSERT INTO Muontra(MaGiaoDich, MaThe, MaSach, NgayMuon, NgayHetHan, SoTien) values(?, ? , ?, ?, ?, ?) ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, muontra.getMaGiaodich());
                ps.setInt(2, muontra.getMathe());
                ps.setInt(3, muontra.getMasach());
                ps.setDate(4, ngayMuon);
                ps.setDate(5, ngayHetHan);
                ps.setInt(6,muontra.getSotien());
                ps.execute();
                rs = ps.getGeneratedKeys();
                int generatedKey = 0;
                if(rs.next()){
                    generatedKey = rs.getInt(1);
                }
                ps.close();
                return generatedKey;
            }
          
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    
    public int edit(QuanLyMuonTra muontra) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            // Sử dụng dữ liệu này để thực hiện hành động sửa
            
            if(getNgaytrasach() != null){
                if(muontra.getSoLuongSach(muontra.getMasach()) == 0){
                    String tinhtrangsach = "Còn sách";
                    capNhatTinhTrangSach(muontra.getMasach(), tinhtrangsach);
                }
                if(isNgayTraNull(muontra.getMaGiaodich()) == true){
                    int soluong = muontra.getSoLuongSach(muontra.getMasach()) + 1;
                    capNhatSoLuongSach(muontra.getMasach(), soluong);
                } 
                java.sql.Date ngayMuon = new java.sql.Date(muontra.getNgaymuon().getTime());
                java.sql.Date ngayHetHan = new java.sql.Date(muontra.getNgayhethan().getTime());
                java.sql.Date ngayTra = new java.sql.Date(muontra.getNgaytrasach().getTime());
                String sql = "UPDATE Muontra SET MaThe = ?, MaSach = ?, NgayMuon = ?, NgayHetHan = ?, NgayTraSach = ?, SoTien = ? WHERE MaGiaoDich = ? ";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(7, muontra.getMaGiaodich());
                ps.setInt(1, muontra.getMathe());
                ps.setInt(2, muontra.getMasach());
                ps.setDate(3, ngayMuon);
                ps.setDate(4, ngayHetHan);
                ps.setDate(5, ngayTra);
                ps.setInt(6,muontra.getSotien());
                ps.execute();
                ps.close();
                
            }else if(getNgaytrasach() == null){
                
                if(isNgayTraNull(muontra.getMaGiaodich()) != true){
                    if(muontra.getSoLuongSach(muontra.getMasach()) == 0){
                        JOptionPane.showMessageDialog(null, "số lượng sách có mã sách là "+ muontra.getMasach()+ " không đủ để cho mượn");
                        return 0;
                    }
                    if(muontra.getSoLuongSach(muontra.getMasach()) > 0){
                        int soluong = muontra.getSoLuongSach(muontra.getMasach()) - 1;
                        capNhatSoLuongSach(muontra.getMasach(), soluong);
                    }
                } 
                java.sql.Date ngayMuon = new java.sql.Date(muontra.getNgaymuon().getTime());
                java.sql.Date ngayHetHan = new java.sql.Date(muontra.getNgayhethan().getTime());
                
                String sql = "UPDATE Muontra SET MaThe = ?, MaSach = ?, NgayMuon = ?, NgayHetHan = ?, NgayTraSach = ?, SoTien = ? WHERE MaGiaoDich = ? ";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(7, muontra.getMaGiaodich());
                ps.setInt(1, muontra.getMathe());
                ps.setInt(2, muontra.getMasach());
                ps.setDate(3, ngayMuon);
                ps.setDate(4, ngayHetHan);
                ps.setDate(5, (java.sql.Date)(muontra.getNgaytrasach()) );
                ps.setInt(6,muontra.getSotien());
                ps.execute();
                ps.close();
                
            }
            
            return 1;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int delete(QuanLyMuonTra muonTra) {
    try {
        Connection conn = DatabaseConnection.getConnection();
        if(isNgayTraNull(muonTra.getMaGiaodich()) == true){
            JOptionPane.showMessageDialog(null, "Bạn không thể xóa dữ liệu này khi sách chưa được trả!!!");
            return 0;
        }
        
        // Sử dụng dữ liệu này để thực hiện hành động xóa
        String sql = "DELETE FROM Muontra WHERE MaGiaoDich = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, muonTra.getMaGiaodich());
        ps.execute();
        ps.close();
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
    public void capNhatTinhTrangSach(int masach, String tinhtrangsach) throws SQLException {
        // Tạo truy vấn cập nhật số lượng sách
        Connection conn = DatabaseConnection.getConnection();
        String query = "UPDATE Sach SET TinhTrangSach = ? WHERE MaSach = ?";

        // Tạo đối tượng PreparedStatement
        PreparedStatement ps = conn.prepareStatement(query);

        // Gán giá trị cho các tham số
        ps.setString(1, tinhtrangsach);
        ps.setInt(2, masach);

        // Thực thi truy vấn
        ps.execute();
        ps.close();
        
    }    

    public int getSoLuongSach(int masach) throws SQLException {
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

    
    public boolean isNgayTraNull(int magiaodich) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String sql = "SELECT NgayTraSach FROM Muontra WHERE MaGiaoDich = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, magiaodich);
        ResultSet rs = ps.executeQuery();

        // Nếu ngày trả là null thì trả về true
        if (!rs.next()) {
            return true;
        }

        // Nếu ngày trả không phải là null thì trả về false
        return rs.getDate("NgayTraSach") == null;
    }
    
    

}
