package com.example.quanlychitieu;

public class DanhMucHelper {

    public static String layEmoji(String danhMuc) {
        if (danhMuc == null) return "📦";
        switch (danhMuc) {
            case "Ăn uống": return "🍔";
            case "Đi lại": return "🚗";
            case "Học tập": return "📚";
            case "Giải trí": return "🎮";
            default: return "📦";
        }
    }

    public static int layMau(String danhMuc) {
        if (danhMuc == null) return 0xFF9E9E9E;
        switch (danhMuc) {
            case "Ăn uống": return 0xFFFF6B6B;
            case "Đi lại": return 0xFF4ECDC4;
            case "Học tập": return 0xFF6C63FF;
            case "Giải trí": return 0xFFFFA726;
            default: return 0xFF9E9E9E;
        }
    }
}