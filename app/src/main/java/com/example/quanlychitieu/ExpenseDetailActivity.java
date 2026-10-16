package com.example.quanlychitieu;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ExpenseDetailActivity extends AppCompatActivity {

    private TextView tvIcon, tvTen, tvSoTien, tvDanhMuc, tvNgay, tvGhiChu;
    private MaterialButton btnQuayLai, btnXoaKhoanChi;

    private final ExpenseRepository repo = ExpenseRepository.getInstance();
    private int viTri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_detail);

        tvIcon = findViewById(R.id.tvIconDanhMucChiTiet);
        tvTen = findViewById(R.id.tvTenKhoanChiChiTiet);
        tvSoTien = findViewById(R.id.tvSoTienChiTiet);
        tvDanhMuc = findViewById(R.id.tvDanhMucChiTiet);
        tvNgay = findViewById(R.id.tvNgayChiTieuChiTiet);
        tvGhiChu = findViewById(R.id.tvGhiChuChiTiet);
        btnQuayLai = findViewById(R.id.btnQuayLai);
        btnXoaKhoanChi = findViewById(R.id.btnXoaKhoanChi);

        viTri = getIntent().getIntExtra("vi_tri", -1);

        if (viTri < 0 || viTri >= repo.getDanhSach().size()) {
            finish();
            return;
        }

        hienThiChiTiet();

        btnQuayLai.setOnClickListener(v -> finish());
        btnXoaKhoanChi.setOnClickListener(v -> xacNhanXoa());
    }

    private void hienThiChiTiet() {
        Expense e = repo.getDanhSach().get(viTri);

        tvTen.setText(e.getTenKhoanChi());
        tvSoTien.setText("-" + Utils.dinhDangTien(e.getSoTien()));
        tvDanhMuc.setText(e.getDanhMuc());
        tvNgay.setText(Utils.dinhDangNgay(e.getNgayChiTieu()));
        tvGhiChu.setText(TextUtils.isEmpty(e.getGhiChu()) ? "(Không có ghi chú)" : e.getGhiChu());

        tvIcon.setText(DanhMucHelper.layEmoji(e.getDanhMuc()));
        Drawable nen = tvIcon.getBackground().mutate();
        if (nen instanceof GradientDrawable) {
            ((GradientDrawable) nen).setColor(DanhMucHelper.layMau(e.getDanhMuc()));
        }
    }

    private void xacNhanXoa() {
        new AlertDialog.Builder(this)
                .setTitle("Xóa khoản chi")
                .setMessage("Bạn có chắc muốn xóa khoản chi này?")
                .setPositiveButton("Xóa", (dialog, which) -> {
                    repo.xoaKhoanChi(viTri);
                    finish();
                })
                .setNegativeButton("Hủy", null)
                .show();
    }
}