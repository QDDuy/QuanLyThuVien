/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contructor;


import connectsql.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;
import javax.swing.JButton;
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
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    // xu ly su kien them, sua, xoa, tim kiem
    
    
}
