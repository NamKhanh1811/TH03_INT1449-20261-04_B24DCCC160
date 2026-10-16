package com.example.quanlychitieu;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.Calendar;

public class AddExpenseActivity extends AppCompatActivity {

    private EditText edtTenKhoanChi, edtSoTien, edtGhiChu;
    private Spinner spinnerDanhMuc;
    private DatePicker datePickerNgayChiTieu;
    private MaterialButton btnLuuKhoanChi, btnHuy;

    private final ExpenseRepository repo = ExpenseRepository.getInstance();

    private static final String[] DANH_SACH_DANH_MUC = {
            "Ăn uống", "Đi lại", "Học tập", "Giải trí", "Khác"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        edtTenKhoanChi = findViewById(R.id.edtTenKhoanChi);
        edtSoTien = findViewById(R.id.edtSoTien);
        edtGhiChu = findViewById(R.id.edtGhiChu);
        spinnerDanhMuc = findViewById(R.id.spinnerDanhMuc);
        datePickerNgayChiTieu = findViewById(R.id.datePickerNgayChiTieu);
        btnLuuKhoanChi = findViewById(R.id.btnLuuKhoanChi);
        btnHuy = findViewById(R.id.btnHuy);

        ArrayAdapter<String> adapterDanhMuc = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, DANH_SACH_DANH_MUC);
        spinnerDanhMuc.setAdapter(adapterDanhMuc);

        btnLuuKhoanChi.setOnClickListener(v -> xuLyLuu());
        btnHuy.setOnClickListener(v -> finish());
    }

    private void xuLyLuu() {
        String ten = edtTenKhoanChi.getText().toString().trim();
        String soTienNhap = edtSoTien.getText().toString().trim();

        if (TextUtils.isEmpty(ten)) {
            edtTenKhoanChi.setError("Tên khoản chi không được để trống");
            edtTenKhoanChi.requestFocus();
            return;
        }

        long soTien;
        try {
            soTien = Long.parseLong(soTienNhap);
        } catch (NumberFormatException e) {
            edtSoTien.setError("Số tiền không hợp lệ");
            edtSoTien.requestFocus();
            return;
        }

        if (soTien <= 0) {
            edtSoTien.setError("Số tiền phải lớn hơn 0");
            edtSoTien.requestFocus();
            return;
        }

        String danhMuc = (String) spinnerDanhMuc.getSelectedItem();
        String ghiChu = edtGhiChu.getText().toString().trim();

        Calendar lich = Calendar.getInstance();
        lich.set(Calendar.YEAR, datePickerNgayChiTieu.getYear());
        lich.set(Calendar.MONTH, datePickerNgayChiTieu.getMonth());
        lich.set(Calendar.DAY_OF_MONTH, datePickerNgayChiTieu.getDayOfMonth());

        Expense khoanChiMoi = new Expense(ten, soTien, danhMuc, lich.getTimeInMillis(), ghiChu);
        repo.themKhoanChi(khoanChiMoi);

        Toast.makeText(this, "Đã lưu khoản chi", Toast.LENGTH_SHORT).show();
        finish();
    }
}