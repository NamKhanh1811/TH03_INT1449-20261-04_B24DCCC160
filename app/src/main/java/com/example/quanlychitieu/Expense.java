package com.example.quanlychitieu;

import java.io.Serializable;

public class Expense implements Serializable {

    private String tenKhoanChi;
    private long soTien;
    private String danhMuc;
    private long ngayChiTieu;
    private String ghiChu;

    public Expense(String tenKhoanChi, long soTien, String danhMuc, long ngayChiTieu, String ghiChu) {
        this.tenKhoanChi = tenKhoanChi;
        this.soTien = soTien;
        this.danhMuc = danhMuc;
        this.ngayChiTieu = ngayChiTieu;
        this.ghiChu = ghiChu;
    }

    public String getTenKhoanChi() { return tenKhoanChi; }
    public long getSoTien() { return soTien; }
    public String getDanhMuc() { return danhMuc; }
    public long getNgayChiTieu() { return ngayChiTieu; }
    public String getGhiChu() { return ghiChu; }
}