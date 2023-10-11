/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Date;

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
    
}
