package com.example.quanlychitieu;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {
    private static final String TAI_KHOAN_DUNG = "admin";
    private static final String MAT_KHAU_DUNG = "123456";

    private EditText edtTenDangNhap, edtMatKhau;
    private TextView tvThongBaoLoi;
    private MaterialButton btnDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtTenDangNhap = findViewById(R.id.edtTenDangNhap);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        tvThongBaoLoi = findViewById(R.id.tvThongBaoLoi);
        btnDangNhap = findViewById(R.id.btnDangNhap);

        btnDangNhap.setOnClickListener(v -> xuLyDangNhap());
    }

    private void xuLyDangNhap() {
        String tenDangNhap = edtTenDangNhap.getText().toString().trim();
        String matKhau = edtMatKhau.getText().toString().trim();

        if (TextUtils.isEmpty(tenDangNhap) || TextUtils.isEmpty(matKhau)) {
            hienThiLoi("Vui lòng nhập đầy đủ tên đăng nhập và mật khẩu");
            return;
        }

        if (tenDangNhap.equals(TAI_KHOAN_DUNG) && matKhau.equals(MAT_KHAU_DUNG)) {
            tvThongBaoLoi.setVisibility(View.GONE);
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            hienThiLoi("Sai tên đăng nhập hoặc mật khẩu");
        }
    }

    private void hienThiLoi(String noiDung) {
        tvThongBaoLoi.setText(noiDung);
        tvThongBaoLoi.setVisibility(View.VISIBLE);
    }
}