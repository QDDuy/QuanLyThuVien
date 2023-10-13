/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contructor;

import java.sql.Date;

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
    private Double sotien;
    
    public QuanLyMuonTra(int maGiaodich, int mathe, int masach, Date ngaymuon, Date ngayhethan, Date ngaytrasach, Double sotien) {
        this.maGiaodich = maGiaodich;
        this.mathe = mathe;
        this.masach = masach;
        this.ngaymuon = ngaymuon;
        this.ngayhethan = ngayhethan;
        this.ngaytrasach = ngaytrasach;
        this.sotien = sotien;
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

    public Double getSotien() {
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

    public void setSotien(Double sotien) {
        this.sotien = sotien;
    }

}
