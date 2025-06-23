package vi.com.gdi.bgl.android.java;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;

/* loaded from: classes6.dex */
public class EnvDrawText {
    private static final String DEVICE_VIVOX3L = "vivo X3L";
    private static final int FONT_STYLE_BOLD = 1;
    private static final int FONT_STYLE_ITALIC = 2;
    private static final int FONT_STYLE_NORMAL = 0;
    public static int[] buffer;
    private static Bitmap defaultFontBmp;
    public static SparseArray<a> fontCache;
    private static Context mContext;
    private static String phonetype;

    /* JADX WARN: Removed duplicated region for block: B:102:0x0276 A[EDGE_INSN: B:102:0x0276->B:103:0x0276 BREAK  A[LOOP:1: B:93:0x0226->B:99:0x025e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x027e A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x0011, B:6:0x0023, B:7:0x002b, B:9:0x0030, B:12:0x003c, B:14:0x0059, B:15:0x006c, B:17:0x007d, B:19:0x00a1, B:24:0x00da, B:26:0x00de, B:29:0x00e7, B:31:0x00ef, B:35:0x00f4, B:36:0x00f9, B:38:0x00fd, B:40:0x0109, B:41:0x0127, B:43:0x02c1, B:45:0x02c7, B:47:0x02d0, B:49:0x02d6, B:52:0x0104, B:53:0x013b, B:54:0x014b, B:56:0x0153, B:60:0x0162, B:63:0x0167, B:65:0x016d, B:68:0x0180, B:70:0x019b, B:75:0x01df, B:77:0x01e3, B:80:0x01ec, B:82:0x01f4, B:85:0x01f9, B:86:0x01fe, B:88:0x0202, B:89:0x020c, B:93:0x0226, B:95:0x022e, B:97:0x0239, B:99:0x025e, B:103:0x0276, B:105:0x027e, B:107:0x028b, B:108:0x02ab, B:112:0x021c, B:113:0x0220, B:114:0x0209), top: B:3:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0209 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x0011, B:6:0x0023, B:7:0x002b, B:9:0x0030, B:12:0x003c, B:14:0x0059, B:15:0x006c, B:17:0x007d, B:19:0x00a1, B:24:0x00da, B:26:0x00de, B:29:0x00e7, B:31:0x00ef, B:35:0x00f4, B:36:0x00f9, B:38:0x00fd, B:40:0x0109, B:41:0x0127, B:43:0x02c1, B:45:0x02c7, B:47:0x02d0, B:49:0x02d6, B:52:0x0104, B:53:0x013b, B:54:0x014b, B:56:0x0153, B:60:0x0162, B:63:0x0167, B:65:0x016d, B:68:0x0180, B:70:0x019b, B:75:0x01df, B:77:0x01e3, B:80:0x01ec, B:82:0x01f4, B:85:0x01f9, B:86:0x01fe, B:88:0x0202, B:89:0x020c, B:93:0x0226, B:95:0x022e, B:97:0x0239, B:99:0x025e, B:103:0x0276, B:105:0x027e, B:107:0x028b, B:108:0x02ab, B:112:0x021c, B:113:0x0220, B:114:0x0209), top: B:3:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e3 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x0011, B:6:0x0023, B:7:0x002b, B:9:0x0030, B:12:0x003c, B:14:0x0059, B:15:0x006c, B:17:0x007d, B:19:0x00a1, B:24:0x00da, B:26:0x00de, B:29:0x00e7, B:31:0x00ef, B:35:0x00f4, B:36:0x00f9, B:38:0x00fd, B:40:0x0109, B:41:0x0127, B:43:0x02c1, B:45:0x02c7, B:47:0x02d0, B:49:0x02d6, B:52:0x0104, B:53:0x013b, B:54:0x014b, B:56:0x0153, B:60:0x0162, B:63:0x0167, B:65:0x016d, B:68:0x0180, B:70:0x019b, B:75:0x01df, B:77:0x01e3, B:80:0x01ec, B:82:0x01f4, B:85:0x01f9, B:86:0x01fe, B:88:0x0202, B:89:0x020c, B:93:0x0226, B:95:0x022e, B:97:0x0239, B:99:0x025e, B:103:0x0276, B:105:0x027e, B:107:0x028b, B:108:0x02ab, B:112:0x021c, B:113:0x0220, B:114:0x0209), top: B:3:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01f4 A[Catch: all -> 0x0028, TRY_LEAVE, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x0011, B:6:0x0023, B:7:0x002b, B:9:0x0030, B:12:0x003c, B:14:0x0059, B:15:0x006c, B:17:0x007d, B:19:0x00a1, B:24:0x00da, B:26:0x00de, B:29:0x00e7, B:31:0x00ef, B:35:0x00f4, B:36:0x00f9, B:38:0x00fd, B:40:0x0109, B:41:0x0127, B:43:0x02c1, B:45:0x02c7, B:47:0x02d0, B:49:0x02d6, B:52:0x0104, B:53:0x013b, B:54:0x014b, B:56:0x0153, B:60:0x0162, B:63:0x0167, B:65:0x016d, B:68:0x0180, B:70:0x019b, B:75:0x01df, B:77:0x01e3, B:80:0x01ec, B:82:0x01f4, B:85:0x01f9, B:86:0x01fe, B:88:0x0202, B:89:0x020c, B:93:0x0226, B:95:0x022e, B:97:0x0239, B:99:0x025e, B:103:0x0276, B:105:0x027e, B:107:0x028b, B:108:0x02ab, B:112:0x021c, B:113:0x0220, B:114:0x0209), top: B:3:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f9 A[Catch: all -> 0x0028, TRY_ENTER, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x0011, B:6:0x0023, B:7:0x002b, B:9:0x0030, B:12:0x003c, B:14:0x0059, B:15:0x006c, B:17:0x007d, B:19:0x00a1, B:24:0x00da, B:26:0x00de, B:29:0x00e7, B:31:0x00ef, B:35:0x00f4, B:36:0x00f9, B:38:0x00fd, B:40:0x0109, B:41:0x0127, B:43:0x02c1, B:45:0x02c7, B:47:0x02d0, B:49:0x02d6, B:52:0x0104, B:53:0x013b, B:54:0x014b, B:56:0x0153, B:60:0x0162, B:63:0x0167, B:65:0x016d, B:68:0x0180, B:70:0x019b, B:75:0x01df, B:77:0x01e3, B:80:0x01ec, B:82:0x01f4, B:85:0x01f9, B:86:0x01fe, B:88:0x0202, B:89:0x020c, B:93:0x0226, B:95:0x022e, B:97:0x0239, B:99:0x025e, B:103:0x0276, B:105:0x027e, B:107:0x028b, B:108:0x02ab, B:112:0x021c, B:113:0x0220, B:114:0x0209), top: B:3:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0202 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x0011, B:6:0x0023, B:7:0x002b, B:9:0x0030, B:12:0x003c, B:14:0x0059, B:15:0x006c, B:17:0x007d, B:19:0x00a1, B:24:0x00da, B:26:0x00de, B:29:0x00e7, B:31:0x00ef, B:35:0x00f4, B:36:0x00f9, B:38:0x00fd, B:40:0x0109, B:41:0x0127, B:43:0x02c1, B:45:0x02c7, B:47:0x02d0, B:49:0x02d6, B:52:0x0104, B:53:0x013b, B:54:0x014b, B:56:0x0153, B:60:0x0162, B:63:0x0167, B:65:0x016d, B:68:0x0180, B:70:0x019b, B:75:0x01df, B:77:0x01e3, B:80:0x01ec, B:82:0x01f4, B:85:0x01f9, B:86:0x01fe, B:88:0x0202, B:89:0x020c, B:93:0x0226, B:95:0x022e, B:97:0x0239, B:99:0x025e, B:103:0x0276, B:105:0x027e, B:107:0x028b, B:108:0x02ab, B:112:0x021c, B:113:0x0220, B:114:0x0209), top: B:3:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x022e A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x0011, B:6:0x0023, B:7:0x002b, B:9:0x0030, B:12:0x003c, B:14:0x0059, B:15:0x006c, B:17:0x007d, B:19:0x00a1, B:24:0x00da, B:26:0x00de, B:29:0x00e7, B:31:0x00ef, B:35:0x00f4, B:36:0x00f9, B:38:0x00fd, B:40:0x0109, B:41:0x0127, B:43:0x02c1, B:45:0x02c7, B:47:0x02d0, B:49:0x02d6, B:52:0x0104, B:53:0x013b, B:54:0x014b, B:56:0x0153, B:60:0x0162, B:63:0x0167, B:65:0x016d, B:68:0x0180, B:70:0x019b, B:75:0x01df, B:77:0x01e3, B:80:0x01ec, B:82:0x01f4, B:85:0x01f9, B:86:0x01fe, B:88:0x0202, B:89:0x020c, B:93:0x0226, B:95:0x022e, B:97:0x0239, B:99:0x025e, B:103:0x0276, B:105:0x027e, B:107:0x028b, B:108:0x02ab, B:112:0x021c, B:113:0x0220, B:114:0x0209), top: B:3:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized int[] drawText(java.lang.String r23, int r24, int r25, int[] r26, int r27, int r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 733
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: vi.com.gdi.bgl.android.java.EnvDrawText.drawText(java.lang.String, int, int, int[], int, int, int, int, int):int[]");
    }

    private static Bitmap drawTextAlpha(String str, int i, int i2, int i3) {
        int i4;
        int desiredWidth;
        Canvas canvas = new Canvas();
        TextPaint textPaint = new TextPaint();
        if (TextUtils.isEmpty(phonetype)) {
            phonetype = Build.MODEL;
        }
        String str2 = phonetype;
        int i5 = 0;
        if (str2 != null && str2.equals(DEVICE_VIVOX3L)) {
            i4 = 0;
        } else {
            i4 = i2;
        }
        textPaint.reset();
        textPaint.setSubpixelText(false);
        textPaint.setAntiAlias(false);
        textPaint.setTextSize(i);
        textPaint.setTypeface(getTypeface(i4));
        float f = (i3 * 1.3f) + 0.5f;
        int i6 = 92;
        int indexOf = str.indexOf(92, 0);
        Bitmap bitmap = null;
        if (indexOf == -1) {
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            int desiredWidth2 = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint) + f);
            int ceil = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
            if (desiredWidth2 > 0 && ceil > 0) {
                bitmap = Bitmap.createBitmap(desiredWidth2, ceil, Bitmap.Config.ALPHA_8);
                if (bitmap == null) {
                    return bitmap;
                }
                bitmap.eraseColor(0);
                canvas.setBitmap(bitmap);
            }
            textPaint.setStyle(Paint.Style.FILL);
            canvas.drawText(str, f * 0.5f, 0.0f - fontMetrics.ascent, textPaint);
        } else {
            int i7 = indexOf + 1;
            int desiredWidth3 = (int) (Layout.getDesiredWidth(str.substring(0, indexOf), textPaint) + 0.5d);
            int i8 = 2;
            while (true) {
                int indexOf2 = str.indexOf(i6, i7);
                if (indexOf2 <= 0) {
                    break;
                }
                int desiredWidth4 = (int) (Layout.getDesiredWidth(str.substring(i7, indexOf2), textPaint) + 0.5d);
                if (desiredWidth4 > desiredWidth3) {
                    desiredWidth3 = desiredWidth4;
                }
                i7 = indexOf2 + 1;
                i8++;
                i6 = 92;
            }
            if (i7 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i7, str.length()), textPaint) + 0.5d)) > desiredWidth3) {
                desiredWidth3 = desiredWidth;
            }
            Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
            int i9 = desiredWidth3 + i3;
            int ceil2 = i8 * ((int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent));
            if (i9 > 0 && ceil2 > 0) {
                bitmap = Bitmap.createBitmap(i9, ceil2, Bitmap.Config.ALPHA_8);
                if (bitmap == null) {
                    return bitmap;
                }
                bitmap.eraseColor(0);
                canvas.setBitmap(bitmap);
            }
            textPaint.setTextAlign(getTextAlignedType(3));
            float f2 = i9 - (f * 0.5f);
            int i10 = 0;
            while (true) {
                int indexOf3 = str.indexOf(92, i5);
                if (indexOf3 <= 0) {
                    break;
                }
                String substring = str.substring(i5, indexOf3);
                Layout.getDesiredWidth(substring, textPaint);
                textPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(substring, f2, (i10 * r7) - fontMetrics2.ascent, textPaint);
                i10++;
                i5 = indexOf3 + 1;
            }
            if (i5 != str.length()) {
                String substring2 = str.substring(i5, str.length());
                Layout.getDesiredWidth(substring2, textPaint);
                textPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(substring2, f2, (i10 * r7) - fontMetrics2.ascent, textPaint);
            }
        }
        return bitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00e0 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x0011, B:6:0x0023, B:7:0x002b, B:9:0x0030, B:12:0x003c, B:14:0x0059, B:15:0x006c, B:17:0x007d, B:19:0x00a1, B:24:0x00dc, B:26:0x00e0, B:29:0x00e9, B:34:0x00f3, B:35:0x00f8, B:37:0x00fc, B:39:0x0108, B:40:0x0126, B:43:0x0103, B:45:0x0138, B:46:0x0148, B:48:0x0150, B:52:0x015f, B:55:0x0164, B:57:0x016a, B:60:0x017d, B:62:0x0198, B:67:0x01d9, B:69:0x01dd, B:72:0x01e6, B:76:0x01f0, B:77:0x01f5, B:79:0x01f9, B:80:0x0203, B:84:0x021d, B:86:0x0225, B:88:0x0230, B:90:0x0255, B:94:0x026d, B:96:0x0275, B:98:0x0282, B:99:0x02a2, B:102:0x0213, B:103:0x0217, B:104:0x0200), top: B:3:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f1 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f3 A[Catch: all -> 0x0028, TRY_ENTER, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x0011, B:6:0x0023, B:7:0x002b, B:9:0x0030, B:12:0x003c, B:14:0x0059, B:15:0x006c, B:17:0x007d, B:19:0x00a1, B:24:0x00dc, B:26:0x00e0, B:29:0x00e9, B:34:0x00f3, B:35:0x00f8, B:37:0x00fc, B:39:0x0108, B:40:0x0126, B:43:0x0103, B:45:0x0138, B:46:0x0148, B:48:0x0150, B:52:0x015f, B:55:0x0164, B:57:0x016a, B:60:0x017d, B:62:0x0198, B:67:0x01d9, B:69:0x01dd, B:72:0x01e6, B:76:0x01f0, B:77:0x01f5, B:79:0x01f9, B:80:0x0203, B:84:0x021d, B:86:0x0225, B:88:0x0230, B:90:0x0255, B:94:0x026d, B:96:0x0275, B:98:0x0282, B:99:0x02a2, B:102:0x0213, B:103:0x0217, B:104:0x0200), top: B:3:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fc A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x0011, B:6:0x0023, B:7:0x002b, B:9:0x0030, B:12:0x003c, B:14:0x0059, B:15:0x006c, B:17:0x007d, B:19:0x00a1, B:24:0x00dc, B:26:0x00e0, B:29:0x00e9, B:34:0x00f3, B:35:0x00f8, B:37:0x00fc, B:39:0x0108, B:40:0x0126, B:43:0x0103, B:45:0x0138, B:46:0x0148, B:48:0x0150, B:52:0x015f, B:55:0x0164, B:57:0x016a, B:60:0x017d, B:62:0x0198, B:67:0x01d9, B:69:0x01dd, B:72:0x01e6, B:76:0x01f0, B:77:0x01f5, B:79:0x01f9, B:80:0x0203, B:84:0x021d, B:86:0x0225, B:88:0x0230, B:90:0x0255, B:94:0x026d, B:96:0x0275, B:98:0x0282, B:99:0x02a2, B:102:0x0213, B:103:0x0217, B:104:0x0200), top: B:3:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0108 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x0011, B:6:0x0023, B:7:0x002b, B:9:0x0030, B:12:0x003c, B:14:0x0059, B:15:0x006c, B:17:0x007d, B:19:0x00a1, B:24:0x00dc, B:26:0x00e0, B:29:0x00e9, B:34:0x00f3, B:35:0x00f8, B:37:0x00fc, B:39:0x0108, B:40:0x0126, B:43:0x0103, B:45:0x0138, B:46:0x0148, B:48:0x0150, B:52:0x015f, B:55:0x0164, B:57:0x016a, B:60:0x017d, B:62:0x0198, B:67:0x01d9, B:69:0x01dd, B:72:0x01e6, B:76:0x01f0, B:77:0x01f5, B:79:0x01f9, B:80:0x0203, B:84:0x021d, B:86:0x0225, B:88:0x0230, B:90:0x0255, B:94:0x026d, B:96:0x0275, B:98:0x0282, B:99:0x02a2, B:102:0x0213, B:103:0x0217, B:104:0x0200), top: B:3:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0103 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x0011, B:6:0x0023, B:7:0x002b, B:9:0x0030, B:12:0x003c, B:14:0x0059, B:15:0x006c, B:17:0x007d, B:19:0x00a1, B:24:0x00dc, B:26:0x00e0, B:29:0x00e9, B:34:0x00f3, B:35:0x00f8, B:37:0x00fc, B:39:0x0108, B:40:0x0126, B:43:0x0103, B:45:0x0138, B:46:0x0148, B:48:0x0150, B:52:0x015f, B:55:0x0164, B:57:0x016a, B:60:0x017d, B:62:0x0198, B:67:0x01d9, B:69:0x01dd, B:72:0x01e6, B:76:0x01f0, B:77:0x01f5, B:79:0x01f9, B:80:0x0203, B:84:0x021d, B:86:0x0225, B:88:0x0230, B:90:0x0255, B:94:0x026d, B:96:0x0275, B:98:0x0282, B:99:0x02a2, B:102:0x0213, B:103:0x0217, B:104:0x0200), top: B:3:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized android.graphics.Bitmap drawTextExt(java.lang.String r23, int r24, int r25, int[] r26, int r27, int r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: vi.com.gdi.bgl.android.java.EnvDrawText.drawTextExt(java.lang.String, int, int, int[], int, int, int, int, int):android.graphics.Bitmap");
    }

    private static Paint.Align getTextAlignedType(int i) {
        if (1 == i) {
            return Paint.Align.LEFT;
        }
        if (2 == i) {
            return Paint.Align.RIGHT;
        }
        return Paint.Align.CENTER;
    }

    private static Bitmap getTextBitmap() {
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(false);
        paint.setTextSize(12.0f);
        paint.setTypeface(Typeface.DEFAULT);
        float measureText = paint.measureText("!");
        float descent = paint.descent() - paint.ascent();
        if (measureText <= 0.0f) {
            measureText = 3.0f;
        }
        if (descent <= 0.0f) {
            descent = 15.0f;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) Math.ceil(measureText), (int) Math.ceil(descent), Bitmap.Config.ALPHA_8);
        createBitmap.eraseColor(0);
        Canvas canvas = new Canvas();
        canvas.setBitmap(createBitmap);
        canvas.drawText("!", 0.0f, 0.0f - paint.ascent(), paint);
        return createBitmap;
    }

    private static short[] getTextSize(String str, int i, int i2) {
        int length = str.length();
        if (length == 0) {
            return null;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setSubpixelText(true);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(i);
        textPaint.setTypeface(getTypeface(i2));
        short[] sArr = new short[length];
        for (int i3 = 0; i3 < length; i3++) {
            sArr[i3] = (short) (Layout.getDesiredWidth(str, 0, r3, textPaint) + 0.5d);
        }
        return sArr;
    }

    private static float[] getTextSizeExt(String str, int i, int i2) {
        if (str.length() == 0) {
            return null;
        }
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setTextSize(i);
        paint.setTypeface(getTypeface(i2));
        return new float[]{paint.measureText(str), paint.descent() - paint.ascent()};
    }

    private static Typeface getTypeface(int i) {
        Typeface typeface = Typeface.DEFAULT;
        if (i != 1) {
            if (i == 2) {
                return Typeface.create(typeface, 2);
            }
            return typeface;
        }
        return Typeface.DEFAULT_BOLD;
    }

    private static synchronized boolean isSystemFontChanged() {
        synchronized (EnvDrawText.class) {
            if (defaultFontBmp == null) {
                defaultFontBmp = getTextBitmap();
                return false;
            }
            Bitmap textBitmap = getTextBitmap();
            if (!nativeIsBitmapSame(textBitmap, defaultFontBmp)) {
                defaultFontBmp.recycle();
                defaultFontBmp = Bitmap.createBitmap(textBitmap);
                textBitmap.recycle();
                return true;
            }
            textBitmap.recycle();
            return false;
        }
    }

    private static native boolean nativeIsBitmapSame(Bitmap bitmap, Bitmap bitmap2);

    public static synchronized void registFontCache(int i, Typeface typeface) {
        synchronized (EnvDrawText.class) {
            if (i != 0 && typeface != null) {
                try {
                    if (fontCache == null) {
                        fontCache = new SparseArray<>();
                    }
                    a aVar = fontCache.get(i);
                    if (aVar == null) {
                        a aVar2 = new a();
                        aVar2.f33676a = typeface;
                        aVar2.b++;
                        fontCache.put(i, aVar2);
                    } else {
                        aVar.b++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static synchronized void removeFontCache(int i) {
        synchronized (EnvDrawText.class) {
            a aVar = fontCache.get(i);
            if (aVar == null) {
                return;
            }
            int i2 = aVar.b - 1;
            aVar.b = i2;
            if (i2 == 0) {
                fontCache.remove(i);
            }
        }
    }

    public static void setContext(Context context) {
        mContext = context;
    }
}
