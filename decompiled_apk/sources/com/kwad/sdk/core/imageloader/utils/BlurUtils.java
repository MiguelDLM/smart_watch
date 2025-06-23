package com.kwad.sdk.core.imageloader.utils;

import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

/* loaded from: classes11.dex */
public class BlurUtils {
    public static Bitmap stackBlur(Bitmap bitmap, @IntRange(from = 1, to = 180) int i, boolean z) {
        Bitmap copy;
        int[] iArr;
        int i2 = i;
        if (z) {
            copy = bitmap;
        } else {
            copy = bitmap.copy(bitmap.getConfig(), true);
        }
        if (i2 <= 0) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2;
        int i7 = i6 + 1;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[i3];
        int[] iArr6 = new int[Math.max(width, height)];
        int i8 = (i6 + 2) >> 1;
        int i9 = i8 * i8;
        int i10 = i9 * 256;
        int[] iArr7 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr7[i11] = i11 / i9;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i7, 3);
        int i12 = i2 + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < height) {
            Bitmap bitmap2 = copy;
            int i16 = height;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = -i2;
            int i26 = 0;
            while (i25 <= i2) {
                int i27 = i5;
                int[] iArr9 = iArr6;
                int i28 = iArr2[i14 + Math.min(i4, Math.max(i25, 0))];
                int[] iArr10 = iArr8[i25 + i2];
                iArr10[0] = (i28 & 16711680) >> 16;
                iArr10[1] = (i28 & 65280) >> 8;
                iArr10[2] = i28 & 255;
                int abs = i12 - Math.abs(i25);
                int i29 = iArr10[0];
                i26 += i29 * abs;
                int i30 = iArr10[1];
                i17 += i30 * abs;
                int i31 = iArr10[2];
                i18 += abs * i31;
                if (i25 > 0) {
                    i22 += i29;
                    i23 += i30;
                    i24 += i31;
                } else {
                    i19 += i29;
                    i20 += i30;
                    i21 += i31;
                }
                i25++;
                i5 = i27;
                iArr6 = iArr9;
            }
            int i32 = i5;
            int[] iArr11 = iArr6;
            int i33 = i2;
            int i34 = i26;
            int i35 = 0;
            while (i35 < width) {
                iArr3[i14] = iArr7[i34];
                iArr4[i14] = iArr7[i17];
                iArr5[i14] = iArr7[i18];
                int i36 = i34 - i19;
                int i37 = i17 - i20;
                int i38 = i18 - i21;
                int[] iArr12 = iArr8[((i33 - i2) + i7) % i7];
                int i39 = i19 - iArr12[0];
                int i40 = i20 - iArr12[1];
                int i41 = i21 - iArr12[2];
                if (i13 == 0) {
                    iArr = iArr7;
                    iArr11[i35] = Math.min(i35 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i42 = iArr2[i15 + iArr11[i35]];
                int i43 = (i42 & 16711680) >> 16;
                iArr12[0] = i43;
                int i44 = (i42 & 65280) >> 8;
                iArr12[1] = i44;
                int i45 = i42 & 255;
                iArr12[2] = i45;
                int i46 = i22 + i43;
                int i47 = i23 + i44;
                int i48 = i24 + i45;
                i34 = i36 + i46;
                i17 = i37 + i47;
                i18 = i38 + i48;
                i33 = (i33 + 1) % i7;
                int[] iArr13 = iArr8[i33 % i7];
                int i49 = iArr13[0];
                i19 = i39 + i49;
                int i50 = iArr13[1];
                i20 = i40 + i50;
                int i51 = iArr13[2];
                i21 = i41 + i51;
                i22 = i46 - i49;
                i23 = i47 - i50;
                i24 = i48 - i51;
                i14++;
                i35++;
                iArr7 = iArr;
            }
            i15 += width;
            i13++;
            copy = bitmap2;
            height = i16;
            i5 = i32;
            iArr6 = iArr11;
        }
        int[] iArr14 = iArr7;
        Bitmap bitmap3 = copy;
        int i52 = i5;
        int[] iArr15 = iArr6;
        int i53 = height;
        int i54 = 0;
        while (i54 < width) {
            int i55 = -i2;
            int i56 = i7;
            int[] iArr16 = iArr2;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = 0;
            int i64 = i55;
            int i65 = i55 * width;
            int i66 = 0;
            int i67 = 0;
            while (i64 <= i2) {
                int i68 = width;
                int max = Math.max(0, i65) + i54;
                int[] iArr17 = iArr8[i64 + i2];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i12 - Math.abs(i64);
                i66 += iArr3[max] * abs2;
                i67 += iArr4[max] * abs2;
                i57 += iArr5[max] * abs2;
                if (i64 > 0) {
                    i61 += iArr17[0];
                    i62 += iArr17[1];
                    i63 += iArr17[2];
                } else {
                    i58 += iArr17[0];
                    i59 += iArr17[1];
                    i60 += iArr17[2];
                }
                int i69 = i52;
                if (i64 < i69) {
                    i65 += i68;
                }
                i64++;
                i52 = i69;
                width = i68;
            }
            int i70 = width;
            int i71 = i52;
            int i72 = i2;
            int i73 = i54;
            int i74 = i53;
            int i75 = 0;
            while (i75 < i74) {
                iArr16[i73] = (iArr16[i73] & ViewCompat.MEASURED_STATE_MASK) | (iArr14[i66] << 16) | (iArr14[i67] << 8) | iArr14[i57];
                int i76 = i66 - i58;
                int i77 = i67 - i59;
                int i78 = i57 - i60;
                int[] iArr18 = iArr8[((i72 - i2) + i56) % i56];
                int i79 = i58 - iArr18[0];
                int i80 = i59 - iArr18[1];
                int i81 = i60 - iArr18[2];
                if (i54 == 0) {
                    iArr15[i75] = Math.min(i75 + i12, i71) * i70;
                }
                int i82 = iArr15[i75] + i54;
                int i83 = iArr3[i82];
                iArr18[0] = i83;
                int i84 = iArr4[i82];
                iArr18[1] = i84;
                int i85 = iArr5[i82];
                iArr18[2] = i85;
                int i86 = i61 + i83;
                int i87 = i62 + i84;
                int i88 = i63 + i85;
                i66 = i76 + i86;
                i67 = i77 + i87;
                i57 = i78 + i88;
                i72 = (i72 + 1) % i56;
                int[] iArr19 = iArr8[i72];
                int i89 = iArr19[0];
                i58 = i79 + i89;
                int i90 = iArr19[1];
                i59 = i80 + i90;
                int i91 = iArr19[2];
                i60 = i81 + i91;
                i61 = i86 - i89;
                i62 = i87 - i90;
                i63 = i88 - i91;
                i73 += i70;
                i75++;
                i2 = i;
            }
            i54++;
            i2 = i;
            i52 = i71;
            i53 = i74;
            i7 = i56;
            iArr2 = iArr16;
            width = i70;
        }
        int i92 = width;
        bitmap3.setPixels(iArr2, 0, i92, 0, 0, i92, i53);
        return bitmap3;
    }
}
