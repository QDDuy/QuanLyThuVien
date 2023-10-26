/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contructor;

import connectsql.DatabaseConnection;
import java.sql.Connection;
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
public class QuanLyNguoiDung {
    private int manguoidung;
    private String tennguoidung;
    private String matkhau;
    private String chucvu;
    
    public QuanLyNguoiDung(int manguoidung, String tennguoidung, String matkhau, String chucvu) {
        this.manguoidung = manguoidung;
        this.tennguoidung = tennguoidung;
        this.matkhau = matkhau;
        this.chucvu = chucvu;
    }

    public QuanLyNguoiDung() {
    }

    public int getManguoidung() {
        return manguoidung;
    }

    public void setManguoidung(int manguoidung) {
        this.manguoidung = manguoidung;
    }

    public String getTennguoidung() {
        return tennguoidung;
    }

    public void setTennguoidung(String tennguoidung) {
        this.tennguoidung = tennguoidung;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

     // xu ly su kien them, sua, xoa, tim kiem, hiển thị
    public List<QuanLyNguoiDung> getList(){
        Connection conn = DatabaseConnection.getConnection();
        String sql = "select * from TaiKhoan";
        List<QuanLyNguoiDung> list = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLyNguoiDung nguoiDung = new QuanLyNguoiDung();
                nguoiDung.setManguoidung(rs.getInt("MaNguoiDung"));
                nguoiDung.setTennguoidung(rs.getString("TenNguoiDung"));
                nguoiDung.setMatkhau(rs.getString("MatKhau"));
                nguoiDung.setChucvu(rs.getString("ChucVu"));
                list.add(nguoiDung);
            }
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public int create(QuanLyNguoiDung nguoiDung) {
        try{
            Connection conn = DatabaseConnection.getConnection();
            // Kiểm tra xem mã Thẻ đã có trong bảng chưa
            String sql = "SELECT * FROM TaiKhoan WHERE MaNguoiDung = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nguoiDung.getManguoidung());
            ResultSet rs = ps.executeQuery();

            // Nếu mã Thẻ đã có trong bảng, hiển thị thông báo lỗi
            if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Mã người dùng đã tồn tại!");
            return 0;
            }
            
            
            sql = "INSERT INTO TaiKhoan(MaNguoiDung, TenNguoiDung, MatKhau, ChucVu) values(?, ? , ?, ?) ";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, nguoiDung.getManguoidung());
            ps.setString(2, nguoiDung.getTennguoidung());
            ps.setString(3, nguoiDung.getMatkhau());
            ps.setString(4, nguoiDung.getChucvu());
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
    
    
    public int edit(QuanLyNguoiDung nguoiDung) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            // Sử dụng dữ liệu này để thực hiện hành động sửa
            String sql = "UPDATE TaiKhoan SET TenNguoiDung = ?, MatKhau = ?, ChucVu = ? WHERE MaNguoiDung = ?";
            PreparedStatement ps = conn.prepareStatement(sql);    
            ps.setInt(4, nguoiDung.getManguoidung());
            ps.setString(1, nguoiDung.getTennguoidung());
            ps.setString(2, nguoiDung.getMatkhau());
            ps.setString(3, nguoiDung.getChucvu());
            ps.execute();       
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int delete(QuanLyNguoiDung nguoiDung) {
    try {
        Connection conn = DatabaseConnection.getConnection();
        // Sử dụng dữ liệu này để thực hiện hành động xóa
        String sql = "DELETE FROM TaiKhoan WHERE MaNguoiDung = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, nguoiDung.getManguoidung());
        ps.execute();
        return 1;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}

    

}
