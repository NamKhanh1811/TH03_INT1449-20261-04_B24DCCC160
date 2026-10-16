package com.example.quanlychitieu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView tvTongTien;
    private ListView lvDanhSachChiTieu;
    private MaterialButton btnThemKhoanChi;

    private final ExpenseRepository repo = ExpenseRepository.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTongTien = findViewById(R.id.tvTongTien);
        lvDanhSachChiTieu = findViewById(R.id.lvDanhSachChiTieu);
        btnThemKhoanChi = findViewById(R.id.btnThemKhoanChi);

        lvDanhSachChiTieu.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, ExpenseDetailActivity.class);
            intent.putExtra("vi_tri", position);
            startActivity(intent);
        });

        btnThemKhoanChi.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, AddExpenseActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        lvDanhSachChiTieu.setAdapter(new ExpenseAdapter(this, repo.getDanhSach()));
        tvTongTien.setText(Utils.dinhDangTien(repo.tinhTongTien()));
    }
}