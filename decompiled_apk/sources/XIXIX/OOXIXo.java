package XIXIX;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.List;
import ox.x0xO0oo;

/* loaded from: classes9.dex */
public abstract class OOXIXo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static int f3754I0Io = 8000;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static int f3756II0xO0 = 50;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final float f3759X0o0xo = 0.017453292f;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static DisplayMetrics f3761oIX0oI = null;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final double f3765oxoX = 0.017453292519943295d;

    /* renamed from: XO, reason: collision with root package name */
    public static final double f3760XO = Double.longBitsToDouble(1);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final float f3758Oxx0IOOO = Float.intBitsToFloat(1);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static Rect f3755II0XooXoX = new Rect();

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static Paint.FontMetrics f3768xxIXOIIO = new Paint.FontMetrics();

    /* renamed from: xoIox, reason: collision with root package name */
    public static Rect f3767xoIox = new Rect();

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int[] f3757OOXIXo = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static x0xO0oo f3763oOoXoXO = Oo();

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static Rect f3764ooOOo0oXI = new Rect();

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static Rect f3766x0XOIxOo = new Rect();

    /* renamed from: oO, reason: collision with root package name */
    public static Paint.FontMetrics f3762oO = new Paint.FontMetrics();

    public static void I0Io(Paint paint, String str, I0Io i0Io) {
        Rect rect = f3767xoIox;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        i0Io.f3743IXxxXO = rect.width();
        i0Io.f3744Oxx0xo = rect.height();
    }

    public static String[] II0XooXoX(List<String> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = list.get(i);
        }
        return strArr;
    }

    public static I0Io II0xO0(Paint paint, String str) {
        I0Io II0xO02 = I0Io.II0xO0(0.0f, 0.0f);
        I0Io(paint, str, II0xO02);
        return II0xO02;
    }

    public static I0Io IIX0o(I0Io i0Io, float f) {
        return xXxxox0I(i0Io.f3743IXxxXO, i0Io.f3744Oxx0xo, f);
    }

    public static float IIXOooo(Paint paint) {
        return xoXoI(paint, f3768xxIXOIIO);
    }

    public static int IXxxXO(float f) {
        float IoOoX2 = IoOoX(f);
        if (Float.isInfinite(IoOoX2)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10(IoOoX2))) + 2;
    }

    public static float IoOoX(double d) {
        double d2;
        if (!Double.isInfinite(d) && !Double.isNaN(d) && d != f3760XO) {
            if (d < f3760XO) {
                d2 = -d;
            } else {
                d2 = d;
            }
            float pow = (float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d2))));
            return ((float) Math.round(d * pow)) / pow;
        }
        return 0.0f;
    }

    public static float O0xOxO(float f) {
        while (f < 0.0f) {
            f += 360.0f;
        }
        return f % 360.0f;
    }

    public static void OOXIXo(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
        Oxx0IOOO II0xO02 = Oxx0IOOO.II0xO0();
        II0xO02.f3771IXxxXO = i - (i3 / 2);
        II0xO02.f3772Oxx0xo = i2 - (i4 / 2);
        drawable.copyBounds(f3764ooOOo0oXI);
        Rect rect = f3764ooOOo0oXI;
        int i5 = rect.left;
        int i6 = rect.top;
        drawable.setBounds(i5, i6, i5 + i3, i3 + i6);
        int save = canvas.save();
        canvas.translate(II0xO02.f3771IXxxXO, II0xO02.f3772Oxx0xo);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public static x0xO0oo Oo() {
        return new ox.II0XooXoX(1);
    }

    public static int OxI() {
        return f3756II0xO0;
    }

    public static float Oxx0IOOO(float f) {
        DisplayMetrics displayMetrics = f3761oIX0oI;
        if (displayMetrics == null) {
            Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertPixelsToDp(...). Otherwise conversion does not take place.");
            return f;
        }
        return f / displayMetrics.density;
    }

    public static x0xO0oo Oxx0xo() {
        return f3763oOoXoXO;
    }

    public static float OxxIIOOXO(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static Oxx0IOOO X0IIOO(Oxx0IOOO oxx0IOOO, float f, float f2) {
        Oxx0IOOO I0Io2 = Oxx0IOOO.I0Io(0.0f, 0.0f);
        XI0IXoo(oxx0IOOO, f, f2, I0Io2);
        return I0Io2;
    }

    public static float X0o0xo(float f) {
        DisplayMetrics displayMetrics = f3761oIX0oI;
        if (displayMetrics == null) {
            Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
            return f;
        }
        return f * displayMetrics.density;
    }

    public static void XI0IXoo(Oxx0IOOO oxx0IOOO, float f, float f2, Oxx0IOOO oxx0IOOO2) {
        double d = f;
        double d2 = f2;
        oxx0IOOO2.f3771IXxxXO = (float) (oxx0IOOO.f3771IXxxXO + (Math.cos(Math.toRadians(d2)) * d));
        oxx0IOOO2.f3772Oxx0xo = (float) (oxx0IOOO.f3772Oxx0xo + (d * Math.sin(Math.toRadians(d2))));
    }

    public static int XIxXXX0x0() {
        return Build.VERSION.SDK_INT;
    }

    public static int[] XO(List<Integer> list) {
        int[] iArr = new int[list.size()];
        xxIXOIIO(list, iArr);
        return iArr;
    }

    public static I0Io XxX0x0xxx(I0Io i0Io, float f) {
        return xXxxox0I(i0Io.f3743IXxxXO, i0Io.f3744Oxx0xo, f * 0.017453292f);
    }

    public static int o00() {
        return f3754I0Io;
    }

    public static float oI0IIXIo(Paint paint) {
        return OxxIIOOXO(paint, f3768xxIXOIIO);
    }

    public static int oIX0oI(Paint paint, String str) {
        Rect rect = f3755II0XooXoX;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static String oO(float f, int i, boolean z) {
        return x0xO0oo(f, i, z, '.');
    }

    public static void oOXoIIIo(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, f3754I0Io);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            if (i != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    public static void oOoXoXO(Canvas canvas, StaticLayout staticLayout, float f, float f2, TextPaint textPaint, Oxx0IOOO oxx0IOOO, float f3) {
        float fontMetrics = textPaint.getFontMetrics(f3762oO);
        float width = staticLayout.getWidth();
        float lineCount = staticLayout.getLineCount() * fontMetrics;
        float f4 = 0.0f - f3766x0XOIxOo.left;
        float f5 = lineCount + 0.0f;
        Paint.Align textAlign = textPaint.getTextAlign();
        textPaint.setTextAlign(Paint.Align.LEFT);
        if (f3 != 0.0f) {
            float f6 = f4 - (width * 0.5f);
            float f7 = f5 - (lineCount * 0.5f);
            if (oxx0IOOO.f3771IXxxXO != 0.5f || oxx0IOOO.f3772Oxx0xo != 0.5f) {
                I0Io xxX2 = xxX(width, lineCount, f3);
                f -= xxX2.f3743IXxxXO * (oxx0IOOO.f3771IXxxXO - 0.5f);
                f2 -= xxX2.f3744Oxx0xo * (oxx0IOOO.f3772Oxx0xo - 0.5f);
                I0Io.I0Io(xxX2);
            }
            canvas.save();
            canvas.translate(f, f2);
            canvas.rotate(f3);
            canvas.translate(f6, f7);
            staticLayout.draw(canvas);
            canvas.restore();
        } else {
            float f8 = oxx0IOOO.f3771IXxxXO;
            if (f8 != 0.0f || oxx0IOOO.f3772Oxx0xo != 0.0f) {
                f4 -= width * f8;
                f5 -= lineCount * oxx0IOOO.f3772Oxx0xo;
            }
            canvas.save();
            canvas.translate(f4 + f, f5 + f2);
            staticLayout.draw(canvas);
            canvas.restore();
        }
        textPaint.setTextAlign(textAlign);
    }

    @SuppressLint({"NewApi"})
    public static void oo(View view) {
        view.postInvalidateOnAnimation();
    }

    public static double oo0xXOI0I(double d) {
        long j;
        if (d == Double.POSITIVE_INFINITY) {
            return d;
        }
        double d2 = d + f3760XO;
        long doubleToRawLongBits = Double.doubleToRawLongBits(d2);
        if (d2 >= f3760XO) {
            j = 1;
        } else {
            j = -1;
        }
        return Double.longBitsToDouble(doubleToRawLongBits + j);
    }

    public static void ooOOo0oXI(Canvas canvas, String str, float f, float f2, TextPaint textPaint, I0Io i0Io, Oxx0IOOO oxx0IOOO, float f3) {
        oOoXoXO(canvas, new StaticLayout(str, 0, str.length(), textPaint, (int) Math.max(Math.ceil(i0Io.f3743IXxxXO), 1.0d), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false), f, f2, textPaint, oxx0IOOO, f3);
    }

    public static void ooXIXxIX(Context context) {
        if (context == null) {
            f3756II0xO0 = ViewConfiguration.getMinimumFlingVelocity();
            f3754I0Io = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            f3756II0xO0 = viewConfiguration.getScaledMinimumFlingVelocity();
            f3754I0Io = viewConfiguration.getScaledMaximumFlingVelocity();
            f3761oIX0oI = context.getResources().getDisplayMetrics();
        }
    }

    public static int oxoX(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static void x0XOIxOo(Canvas canvas, String str, float f, float f2, Paint paint, Oxx0IOOO oxx0IOOO, float f3) {
        float fontMetrics = paint.getFontMetrics(f3762oO);
        paint.getTextBounds(str, 0, str.length(), f3766x0XOIxOo);
        float f4 = 0.0f - f3766x0XOIxOo.left;
        float f5 = (-f3762oO.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f3 != 0.0f) {
            float width = f4 - (f3766x0XOIxOo.width() * 0.5f);
            float f6 = f5 - (fontMetrics * 0.5f);
            if (oxx0IOOO.f3771IXxxXO != 0.5f || oxx0IOOO.f3772Oxx0xo != 0.5f) {
                I0Io xxX2 = xxX(f3766x0XOIxOo.width(), fontMetrics, f3);
                f -= xxX2.f3743IXxxXO * (oxx0IOOO.f3771IXxxXO - 0.5f);
                f2 -= xxX2.f3744Oxx0xo * (oxx0IOOO.f3772Oxx0xo - 0.5f);
                I0Io.I0Io(xxX2);
            }
            canvas.save();
            canvas.translate(f, f2);
            canvas.rotate(f3);
            canvas.drawText(str, width, f6, paint);
            canvas.restore();
        } else {
            if (oxx0IOOO.f3771IXxxXO != 0.0f || oxx0IOOO.f3772Oxx0xo != 0.0f) {
                f4 -= f3766x0XOIxOo.width() * oxx0IOOO.f3771IXxxXO;
                f5 -= fontMetrics * oxx0IOOO.f3772Oxx0xo;
            }
            canvas.drawText(str, f4 + f, f5 + f2, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static String x0xO0oo(float f, int i, boolean z, char c) {
        boolean z2;
        boolean z3;
        int i2;
        float f2 = f;
        char[] cArr = new char[35];
        if (f2 == 0.0f) {
            return "0";
        }
        int i3 = 0;
        if (f2 < 1.0f && f2 > -1.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (f2 < 0.0f) {
            f2 = -f2;
            z3 = true;
        } else {
            z3 = false;
        }
        int[] iArr = f3757OOXIXo;
        if (i > iArr.length) {
            i2 = iArr.length - 1;
        } else {
            i2 = i;
        }
        long round = Math.round(f2 * iArr[i2]);
        int i4 = 34;
        boolean z4 = false;
        while (true) {
            if (round == 0 && i3 >= i2 + 1) {
                break;
            }
            int i5 = (int) (round % 10);
            round /= 10;
            int i6 = i4 - 1;
            cArr[i4] = (char) (i5 + 48);
            int i7 = i3 + 1;
            if (i7 == i2) {
                i4 -= 2;
                cArr[i6] = ',';
                i3 += 2;
                z4 = true;
            } else {
                if (z && round != 0 && i7 > i2) {
                    if (z4) {
                        if ((i7 - i2) % 4 == 0) {
                            i4 -= 2;
                            cArr[i6] = c;
                            i3 += 2;
                        }
                    } else if ((i7 - i2) % 4 == 3) {
                        i4 -= 2;
                        cArr[i6] = c;
                        i3 += 2;
                    }
                }
                i3 = i7;
                i4 = i6;
            }
        }
        if (z2) {
            cArr[i4] = '0';
            i3++;
            i4--;
        }
        if (z3) {
            cArr[i4] = '-';
            i3++;
        }
        int i8 = 35 - i3;
        return String.valueOf(cArr, i8, 35 - i8);
    }

    @Deprecated
    public static void xI(Resources resources) {
        f3761oIX0oI = resources.getDisplayMetrics();
        f3756II0xO0 = ViewConfiguration.getMinimumFlingVelocity();
        f3754I0Io = ViewConfiguration.getMaximumFlingVelocity();
    }

    public static I0Io xXxxox0I(float f, float f2, float f3) {
        double d = f3;
        return I0Io.II0xO0(Math.abs(((float) Math.cos(d)) * f) + Math.abs(((float) Math.sin(d)) * f2), Math.abs(f * ((float) Math.sin(d))) + Math.abs(f2 * ((float) Math.cos(d))));
    }

    public static void xoIox(List<String> list, String[] strArr) {
        int size;
        if (strArr.length < list.size()) {
            size = strArr.length;
        } else {
            size = list.size();
        }
        for (int i = 0; i < size; i++) {
            strArr[i] = list.get(i);
        }
    }

    public static float xoXoI(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static void xxIXOIIO(List<Integer> list, int[] iArr) {
        int size;
        if (iArr.length < list.size()) {
            size = iArr.length;
        } else {
            size = list.size();
        }
        for (int i = 0; i < size; i++) {
            iArr[i] = list.get(i).intValue();
        }
    }

    public static I0Io xxX(float f, float f2, float f3) {
        return xXxxox0I(f, f2, f3 * 0.017453292f);
    }
}
