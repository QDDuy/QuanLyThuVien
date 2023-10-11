/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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

    
}
