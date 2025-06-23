package com.baidu.navisdk.vi;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: classes8.dex */
public class EnvDrawText {
    public static boolean bBmpChange = false;
    public static Bitmap bmp;
    public static int[] buffer;
    public static Canvas canvasTemp;
    public static int iWordHightMax;
    public static int iWordWidthMax;
    public static Paint pt;

    public static int[] drawText(String str, int i, int i2, int[] iArr, int i3, int i4, int i5, int i6) {
        boolean z;
        int measureText;
        Paint paint = pt;
        if (paint == null) {
            pt = new Paint();
        } else {
            paint.reset();
        }
        pt.setSubpixelText(true);
        pt.setAntiAlias(true);
        pt.setTextSize(i);
        int indexOf = str.indexOf(92, 0);
        if (indexOf == -1) {
            Paint.FontMetrics fontMetrics = pt.getFontMetrics();
            int measureText2 = (int) pt.measureText(str);
            int ceil = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
            iArr[0] = measureText2;
            iArr[1] = ceil;
            double log = Math.log(2.0d);
            if (log > 1.0E-7d || log < -1.0E-7d) {
                measureText2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(measureText2) / log));
                ceil = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(ceil) / log));
            }
            if (iWordWidthMax < measureText2 || iWordHightMax < ceil) {
                bBmpChange = true;
                iWordWidthMax = measureText2;
                iWordHightMax = ceil;
            }
            int i7 = iWordWidthMax;
            iArr[2] = i7;
            int i8 = iWordHightMax;
            iArr[3] = i8;
            if (!bBmpChange) {
                bmp.eraseColor(0);
            } else if (i7 > 0 && i8 > 0) {
                bmp = Bitmap.createBitmap(i7, i8, Bitmap.Config.ARGB_8888);
                canvasTemp = new Canvas(bmp);
            } else {
                bBmpChange = false;
                return null;
            }
            if (((-16777216) & i5) == 0) {
                canvasTemp.drawColor(33554431);
            } else {
                canvasTemp.drawColor(i5);
            }
            if (i6 != 0) {
                pt.setStrokeWidth(i6);
                pt.setStrokeCap(Paint.Cap.ROUND);
                pt.setStrokeJoin(Paint.Join.ROUND);
                pt.setStyle(Paint.Style.STROKE);
                pt.setColor(i4);
                canvasTemp.drawText(str, 0.0f, 0.0f - fontMetrics.ascent, pt);
            }
            pt.setStyle(Paint.Style.FILL);
            pt.setColor(i3);
            canvasTemp.drawText(str, 0.0f, 0.0f - fontMetrics.ascent, pt);
        } else {
            int i9 = indexOf + 1;
            int measureText3 = (int) pt.measureText(str.substring(0, indexOf));
            int i10 = 2;
            while (true) {
                int indexOf2 = str.indexOf(92, i9);
                if (indexOf2 <= 0) {
                    break;
                }
                int measureText4 = (int) pt.measureText(str.substring(i9, indexOf2));
                if (measureText4 > measureText3) {
                    measureText3 = measureText4;
                }
                i9 = indexOf2 + 1;
                i10++;
            }
            if (i9 != str.length() && (measureText = (int) pt.measureText(str.substring(i9, str.length()))) > measureText3) {
                measureText3 = measureText;
            }
            Paint.FontMetrics fontMetrics2 = pt.getFontMetrics();
            int ceil2 = i10 * ((int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent));
            iArr[0] = measureText3;
            iArr[1] = ceil2;
            int pow = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(measureText3) / Math.log(2.0d)));
            int pow2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(ceil2) / Math.log(2.0d)));
            int i11 = iWordWidthMax;
            if (i11 >= pow && iWordHightMax >= pow2) {
                z = true;
            } else if (i11 > 0 && iWordHightMax > 0) {
                z = true;
                bBmpChange = true;
                iWordWidthMax = pow;
                iWordHightMax = pow2;
            } else {
                bBmpChange = false;
                return null;
            }
            int i12 = iWordWidthMax;
            iArr[2] = i12;
            int i13 = iWordHightMax;
            iArr[3] = i13;
            if (bBmpChange == z) {
                try {
                    bmp = Bitmap.createBitmap(i12, i13, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError unused) {
                    bmp = null;
                }
                canvasTemp = new Canvas(bmp);
            } else {
                bmp.eraseColor(0);
            }
            if (((-16777216) & i5) == 0) {
                canvasTemp.drawColor(33554431);
            } else {
                canvasTemp.drawColor(i5);
            }
            int i14 = 0;
            int i15 = 0;
            while (true) {
                int indexOf3 = str.indexOf(92, i15);
                if (indexOf3 <= 0) {
                    break;
                }
                String substring = str.substring(i15, indexOf3);
                int measureText5 = (int) pt.measureText(substring);
                int i16 = indexOf3 + 1;
                if (i6 != 0) {
                    pt.setStrokeWidth(i6);
                    pt.setStrokeCap(Paint.Cap.ROUND);
                    pt.setStrokeJoin(Paint.Join.ROUND);
                    pt.setStyle(Paint.Style.STROKE);
                    pt.setColor(i4);
                    canvasTemp.drawText(substring, (iArr[0] - measureText5) / 2, (i14 * r13) - fontMetrics2.ascent, pt);
                }
                pt.setStyle(Paint.Style.FILL);
                pt.setColor(i3);
                canvasTemp.drawText(substring, (iArr[0] - measureText5) / 2, (i14 * r13) - fontMetrics2.ascent, pt);
                i14++;
                i15 = i16;
            }
            if (i15 != str.length()) {
                String substring2 = str.substring(i15, str.length());
                int measureText6 = (int) pt.measureText(substring2);
                if (i6 != 0) {
                    pt.setStrokeWidth(i6);
                    pt.setStrokeCap(Paint.Cap.ROUND);
                    pt.setStrokeJoin(Paint.Join.ROUND);
                    pt.setStyle(Paint.Style.STROKE);
                    pt.setColor(i4);
                    canvasTemp.drawText(substring2, (iArr[0] - measureText6) / 2, (i14 * r13) - fontMetrics2.ascent, pt);
                }
                pt.setStyle(Paint.Style.FILL);
                pt.setColor(i3);
                canvasTemp.drawText(substring2, (iArr[0] - measureText6) / 2, (i14 * r13) - fontMetrics2.ascent, pt);
            }
        }
        int i17 = iWordWidthMax;
        int i18 = iWordHightMax;
        int i19 = i17 * i18;
        if (bBmpChange) {
            buffer = new int[i19];
        }
        bmp.getPixels(buffer, 0, i17, 0, 0, i17, i18);
        bBmpChange = false;
        return buffer;
    }

    public static short[] getTextSize(String str, int i) {
        int i2;
        int length = str.length();
        if (length == 0) {
            return null;
        }
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setTextSize(i);
        short[] sArr = new short[length];
        for (int i3 = 0; i3 < length; i3++) {
            if (length > 0 && (i2 = i3 + 1) <= length) {
                sArr[i3] = (short) paint.measureText(str.substring(0, i2));
            }
        }
        return sArr;
    }
}
