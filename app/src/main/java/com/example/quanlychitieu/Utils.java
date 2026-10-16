package com.example.quanlychitieu;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Utils {

    public static String dinhDangTien(long soTien) {
        DecimalFormatSymbols kyHieu = new DecimalFormatSymbols(Locale.US);
        kyHieu.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###", kyHieu);
        return df.format(soTien) + " đ";
    }

    public static String dinhDangNgay(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return sdf.format(millis);
    }
}