package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

public final class BitmapCompat {

    @RequiresApi(27)
    public static class Api27Impl {
        private Api27Impl() {
        }

        @DoNotInline
        public static Bitmap copyBitmapIfHardware(Bitmap bitmap) {
            if (bitmap.getConfig() != Bitmap.Config.HARDWARE) {
                return bitmap;
            }
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT >= 31) {
                config = Api31Impl.getHardwareBitmapConfig(bitmap);
            }
            return bitmap.copy(config, true);
        }

        @DoNotInline
        public static Bitmap createBitmapWithSourceColorspace(int i, int i2, Bitmap bitmap, boolean z) {
            Bitmap.Config config = bitmap.getConfig();
            ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (z && !bitmap.getColorSpace().equals(colorSpace2)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = colorSpace2;
            } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                config = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    config = Api31Impl.getHardwareBitmapConfig(bitmap);
                }
            }
            return Bitmap.createBitmap(i, i2, config, bitmap.hasAlpha(), colorSpace);
        }

        @DoNotInline
        public static boolean isAlreadyF16AndLinear(Bitmap bitmap) {
            ColorSpace colorSpace = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (bitmap.getConfig() != Bitmap.Config.RGBA_F16 || !bitmap.getColorSpace().equals(colorSpace)) {
                return false;
            }
            return true;
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static Bitmap.Config getHardwareBitmapConfig(Bitmap bitmap) {
            if (bitmap.getHardwareBuffer().getFormat() == 22) {
                return Bitmap.Config.RGBA_F16;
            }
            return Bitmap.Config.ARGB_8888;
        }
    }

    private BitmapCompat() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01a9, code lost:
        if (androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r11) == false) goto L_0x01bb;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap createScaledBitmap(@androidx.annotation.NonNull android.graphics.Bitmap r21, int r22, int r23, @androidx.annotation.Nullable android.graphics.Rect r24, boolean r25) {
        /*
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            if (r1 <= 0) goto L_0x020e
            if (r2 <= 0) goto L_0x020e
            if (r3 == 0) goto L_0x0035
            boolean r4 = r24.isEmpty()
            if (r4 != 0) goto L_0x002d
            int r4 = r3.left
            if (r4 < 0) goto L_0x002d
            int r4 = r3.right
            int r5 = r21.getWidth()
            if (r4 > r5) goto L_0x002d
            int r4 = r3.top
            if (r4 < 0) goto L_0x002d
            int r4 = r3.bottom
            int r5 = r21.getHeight()
            if (r4 > r5) goto L_0x002d
            goto L_0x0035
        L_0x002d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "srcRect must be contained by srcBm!"
            r0.<init>(r1)
            throw r0
        L_0x0035:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 27
            if (r4 < r5) goto L_0x0040
            android.graphics.Bitmap r6 = androidx.core.graphics.BitmapCompat.Api27Impl.copyBitmapIfHardware(r21)
            goto L_0x0041
        L_0x0040:
            r6 = r0
        L_0x0041:
            if (r3 == 0) goto L_0x0048
            int r7 = r24.width()
            goto L_0x004c
        L_0x0048:
            int r7 = r21.getWidth()
        L_0x004c:
            if (r3 == 0) goto L_0x0053
            int r8 = r24.height()
            goto L_0x0057
        L_0x0053:
            int r8 = r21.getHeight()
        L_0x0057:
            float r9 = (float) r1
            float r10 = (float) r7
            float r9 = r9 / r10
            float r10 = (float) r2
            float r11 = (float) r8
            float r10 = r10 / r11
            if (r3 == 0) goto L_0x0062
            int r12 = r3.left
            goto L_0x0063
        L_0x0062:
            r12 = 0
        L_0x0063:
            if (r3 == 0) goto L_0x0068
            int r3 = r3.top
            goto L_0x0069
        L_0x0068:
            r3 = 0
        L_0x0069:
            r13 = 1
            if (r12 != 0) goto L_0x008c
            if (r3 != 0) goto L_0x008c
            int r14 = r21.getWidth()
            if (r1 != r14) goto L_0x008c
            int r14 = r21.getHeight()
            if (r2 != r14) goto L_0x008c
            boolean r1 = r21.isMutable()
            if (r1 == 0) goto L_0x008b
            if (r0 != r6) goto L_0x008b
            android.graphics.Bitmap$Config r1 = r21.getConfig()
            android.graphics.Bitmap r0 = r0.copy(r1, r13)
            return r0
        L_0x008b:
            return r6
        L_0x008c:
            android.graphics.Paint r14 = new android.graphics.Paint
            r14.<init>(r13)
            r14.setFilterBitmap(r13)
            r15 = 29
            if (r4 < r15) goto L_0x009c
            androidx.core.graphics.BitmapCompat.Api29Impl.setPaintBlendMode(r14)
            goto L_0x00a6
        L_0x009c:
            android.graphics.PorterDuffXfermode r15 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r11 = android.graphics.PorterDuff.Mode.SRC
            r15.<init>(r11)
            r14.setXfermode(r15)
        L_0x00a6:
            if (r7 != r1) goto L_0x00bf
            if (r8 != r2) goto L_0x00bf
            android.graphics.Bitmap$Config r0 = r6.getConfig()
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r1, r2, r0)
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r1.<init>(r0)
            int r2 = -r12
            float r2 = (float) r2
            int r3 = -r3
            float r3 = (float) r3
            r1.drawBitmap(r6, r2, r3, r14)
            return r0
        L_0x00bf:
            r16 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r16 = java.lang.Math.log(r16)
            r11 = 1065353216(0x3f800000, float:1.0)
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 <= 0) goto L_0x00da
            r24 = r14
            double r13 = (double) r9
            double r13 = java.lang.Math.log(r13)
            double r13 = r13 / r16
            double r13 = java.lang.Math.ceil(r13)
        L_0x00d8:
            int r9 = (int) r13
            goto L_0x00e8
        L_0x00da:
            r24 = r14
            double r13 = (double) r9
            double r13 = java.lang.Math.log(r13)
            double r13 = r13 / r16
            double r13 = java.lang.Math.floor(r13)
            goto L_0x00d8
        L_0x00e8:
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 <= 0) goto L_0x00f9
            double r10 = (double) r10
            double r10 = java.lang.Math.log(r10)
            double r10 = r10 / r16
            double r10 = java.lang.Math.ceil(r10)
        L_0x00f7:
            int r10 = (int) r10
            goto L_0x0105
        L_0x00f9:
            double r10 = (double) r10
            double r10 = java.lang.Math.log(r10)
            double r10 = r10 / r16
            double r10 = java.lang.Math.floor(r10)
            goto L_0x00f7
        L_0x0105:
            if (r25 == 0) goto L_0x013b
            if (r4 < r5) goto L_0x013b
            boolean r4 = androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r21)
            if (r4 != 0) goto L_0x013b
            r4 = 1
            if (r9 <= 0) goto L_0x0117
            int r11 = sizeAtStep(r7, r1, r4, r9)
            goto L_0x0118
        L_0x0117:
            r11 = r7
        L_0x0118:
            if (r10 <= 0) goto L_0x011f
            int r13 = sizeAtStep(r8, r2, r4, r10)
            goto L_0x0120
        L_0x011f:
            r13 = r8
        L_0x0120:
            android.graphics.Bitmap r11 = androidx.core.graphics.BitmapCompat.Api27Impl.createBitmapWithSourceColorspace(r11, r13, r0, r4)
            android.graphics.Canvas r13 = new android.graphics.Canvas
            r13.<init>(r11)
            int r12 = -r12
            float r12 = (float) r12
            int r3 = -r3
            float r3 = (float) r3
            r14 = r24
            r13.drawBitmap(r6, r12, r3, r14)
            r3 = 0
            r12 = 0
            r13 = 1
            r20 = r11
            r11 = r6
            r6 = r20
            goto L_0x0140
        L_0x013b:
            r14 = r24
            r4 = 1
            r11 = 0
            r13 = 0
        L_0x0140:
            android.graphics.Rect r15 = new android.graphics.Rect
            r15.<init>(r12, r3, r7, r8)
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            r12 = r9
            r16 = r10
        L_0x014d:
            if (r12 != 0) goto L_0x015a
            if (r16 == 0) goto L_0x0152
            goto L_0x015a
        L_0x0152:
            if (r11 == r0) goto L_0x0159
            if (r11 == 0) goto L_0x0159
            r11.recycle()
        L_0x0159:
            return r6
        L_0x015a:
            if (r12 >= 0) goto L_0x015f
            int r12 = r12 + 1
            goto L_0x0163
        L_0x015f:
            if (r12 <= 0) goto L_0x0163
            int r12 = r12 + -1
        L_0x0163:
            if (r16 >= 0) goto L_0x016a
            int r16 = r16 + 1
        L_0x0167:
            r4 = r16
            goto L_0x016f
        L_0x016a:
            if (r16 <= 0) goto L_0x0167
            int r16 = r16 + -1
            goto L_0x0167
        L_0x016f:
            int r5 = sizeAtStep(r7, r1, r12, r9)
            r24 = r14
            int r14 = sizeAtStep(r8, r2, r4, r10)
            r18 = r15
            r15 = 0
            r3.set(r15, r15, r5, r14)
            if (r12 != 0) goto L_0x0185
            if (r4 != 0) goto L_0x0185
            r5 = 1
            goto L_0x0186
        L_0x0185:
            r5 = 0
        L_0x0186:
            if (r11 == 0) goto L_0x0196
            int r14 = r11.getWidth()
            if (r14 != r1) goto L_0x0196
            int r14 = r11.getHeight()
            if (r14 != r2) goto L_0x0196
            r14 = 1
            goto L_0x0197
        L_0x0196:
            r14 = 0
        L_0x0197:
            if (r11 == 0) goto L_0x01b9
            if (r11 == r0) goto L_0x01b9
            if (r25 == 0) goto L_0x01ac
            int r15 = android.os.Build.VERSION.SDK_INT
            r19 = r3
            r3 = 27
            if (r15 < r3) goto L_0x01ae
            boolean r3 = androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r11)
            if (r3 == 0) goto L_0x01bb
            goto L_0x01ae
        L_0x01ac:
            r19 = r3
        L_0x01ae:
            if (r5 == 0) goto L_0x01b5
            if (r14 == 0) goto L_0x01bb
            if (r13 == 0) goto L_0x01b5
            goto L_0x01bb
        L_0x01b5:
            r3 = r11
            r15 = 27
            goto L_0x01ee
        L_0x01b9:
            r19 = r3
        L_0x01bb:
            if (r11 == r0) goto L_0x01c2
            if (r11 == 0) goto L_0x01c2
            r11.recycle()
        L_0x01c2:
            if (r12 <= 0) goto L_0x01c6
            r3 = r13
            goto L_0x01c7
        L_0x01c6:
            r3 = r12
        L_0x01c7:
            int r3 = sizeAtStep(r7, r1, r3, r9)
            if (r4 <= 0) goto L_0x01cf
            r11 = r13
            goto L_0x01d0
        L_0x01cf:
            r11 = r4
        L_0x01d0:
            int r11 = sizeAtStep(r8, r2, r11, r10)
            int r14 = android.os.Build.VERSION.SDK_INT
            r15 = 27
            if (r14 < r15) goto L_0x01e6
            if (r25 == 0) goto L_0x01e0
            if (r5 != 0) goto L_0x01e0
            r5 = 1
            goto L_0x01e1
        L_0x01e0:
            r5 = 0
        L_0x01e1:
            android.graphics.Bitmap r3 = androidx.core.graphics.BitmapCompat.Api27Impl.createBitmapWithSourceColorspace(r3, r11, r0, r5)
            goto L_0x01ee
        L_0x01e6:
            android.graphics.Bitmap$Config r5 = r6.getConfig()
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3, r11, r5)
        L_0x01ee:
            android.graphics.Canvas r5 = new android.graphics.Canvas
            r5.<init>(r3)
            r11 = r24
            r14 = r18
            r15 = r19
            r5.drawBitmap(r6, r14, r15, r11)
            r14.set(r15)
            r16 = r4
            r4 = 1
            r5 = 27
            r20 = r6
            r6 = r3
            r3 = r15
            r15 = r14
            r14 = r11
            r11 = r20
            goto L_0x014d
        L_0x020e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "dstW and dstH must be > 0!"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.BitmapCompat.createScaledBitmap(android.graphics.Bitmap, int, int, android.graphics.Rect, boolean):android.graphics.Bitmap");
    }

    public static int getAllocationByteCount(@NonNull Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    public static boolean hasMipMap(@NonNull Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    public static void setHasMipMap(@NonNull Bitmap bitmap, boolean z) {
        bitmap.setHasMipMap(z);
    }

    @VisibleForTesting
    public static int sizeAtStep(int i, int i2, int i3, int i4) {
        return i3 == 0 ? i2 : i3 > 0 ? i * (1 << (i4 - i3)) : i2 << ((-i3) - 1);
    }
}
