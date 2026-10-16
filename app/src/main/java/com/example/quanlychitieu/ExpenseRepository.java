package com.example.quanlychitieu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExpenseRepository {

    private static ExpenseRepository instance;

    private final List<Expense> danhSach = new ArrayList<>();

    private ExpenseRepository() {
        khoiTaoDuLieuMau();
    }

    public static synchronized ExpenseRepository getInstance() {
        if (instance == null) {
            instance = new ExpenseRepository();
        }
        return instance;
    }

    public List<Expense> getDanhSach() {
        return danhSach;
    }

    public void themKhoanChi(Expense expense) {
        danhSach.add(expense);
    }

    public void xoaKhoanChi(int viTri) {
        if (viTri >= 0 && viTri < danhSach.size()) {
            danhSach.remove(viTri);
        }
    }

    public long tinhTongTien() {
        long tong = 0;
        for (Expense e : danhSach) {
            tong += e.getSoTien();
        }
        return tong;
    }


    private void khoiTaoDuLieuMau() {
        long homNay = Calendar.getInstance().getTimeInMillis();
        danhSach.add(new Expense("Ăn sáng", 30000, "Ăn uống", homNay, ""));
        danhSach.add(new Expense("Đổ xăng", 50000, "Đi lại", homNay, ""));
        danhSach.add(new Expense("Mua sách", 120000, "Học tập", homNay, ""));
    }
}