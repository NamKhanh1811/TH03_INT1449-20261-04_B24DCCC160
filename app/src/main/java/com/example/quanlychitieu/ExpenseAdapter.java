package com.example.quanlychitieu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ExpenseAdapter extends ArrayAdapter<Expense> {

    public ExpenseAdapter(Context context, List<Expense> danhSach) {
        super(context, 0, danhSach);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_expense, parent, false);
        }

        Expense expense = getItem(position);
        if (expense == null) return convertView;

        TextView tvIcon = convertView.findViewById(R.id.tvIconDanhMuc);
        TextView tvTen = convertView.findViewById(R.id.tvTenKhoanChi);
        TextView tvDanhMucNgay = convertView.findViewById(R.id.tvDanhMucNgay);
        TextView tvSoTien = convertView.findViewById(R.id.tvSoTien);

        tvTen.setText(expense.getTenKhoanChi());
        tvDanhMucNgay.setText(expense.getDanhMuc() + "  •  " + Utils.dinhDangNgay(expense.getNgayChiTieu()));
        tvSoTien.setText("-" + Utils.dinhDangTien(expense.getSoTien()));

        tvIcon.setText(DanhMucHelper.layEmoji(expense.getDanhMuc()));

        Drawable nen = tvIcon.getBackground().mutate();
        if (nen instanceof GradientDrawable) {
            ((GradientDrawable) nen).setColor(DanhMucHelper.layMau(expense.getDanhMuc()));
        }

        return convertView;
    }
}