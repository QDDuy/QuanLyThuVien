/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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

    


    
}
