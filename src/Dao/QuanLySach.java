/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Date;

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

}
