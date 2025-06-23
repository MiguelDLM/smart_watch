package IIXOooo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;
import ooOOo0oXI.OxxIIOOXO;

/* loaded from: classes.dex */
public final class xoIox {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f318oIX0oI = 1000000000;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final ThreadLocal<PathMeasure> f314II0xO0 = new oIX0oI();

    /* renamed from: I0Io, reason: collision with root package name */
    public static final ThreadLocal<Path> f313I0Io = new II0xO0();

    /* renamed from: oxoX, reason: collision with root package name */
    public static final ThreadLocal<Path> f319oxoX = new I0Io();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final ThreadLocal<float[]> f316X0o0xo = new oxoX();

    /* renamed from: XO, reason: collision with root package name */
    public static final float f317XO = (float) (Math.sqrt(2.0d) / 2.0d);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static float f315Oxx0IOOO = -1.0f;

    /* loaded from: classes.dex */
    public class I0Io extends ThreadLocal<Path> {
        @Override // java.lang.ThreadLocal
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 extends ThreadLocal<Path> {
        @Override // java.lang.ThreadLocal
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI extends ThreadLocal<PathMeasure> {
        @Override // java.lang.ThreadLocal
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    }

    /* loaded from: classes.dex */
    public class oxoX extends ThreadLocal<float[]> {
        @Override // java.lang.ThreadLocal
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    }

    public static void I0Io(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean II0XooXoX(Matrix matrix) {
        float[] fArr = f316X0o0xo.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        if (fArr[0] != fArr[2] && fArr[1] != fArr[3]) {
            return false;
        }
        return true;
    }

    public static void II0xO0(Path path, @Nullable OxxIIOOXO oxxIIOOXO) {
        if (oxxIIOOXO != null && !oxxIIOOXO.xoIox()) {
            oIX0oI(path, ((x0XOIxOo.I0Io) oxxIIOOXO.II0XooXoX()).x0xO0oo() / 100.0f, ((x0XOIxOo.I0Io) oxxIIOOXO.XO()).x0xO0oo() / 100.0f, ((x0XOIxOo.I0Io) oxxIIOOXO.Oxx0IOOO()).x0xO0oo() / 360.0f);
        }
    }

    public static boolean OOXIXo(Throwable th) {
        if (!(th instanceof SocketException) && !(th instanceof ClosedChannelException) && !(th instanceof InterruptedIOException) && !(th instanceof ProtocolException) && !(th instanceof SSLException) && !(th instanceof UnknownHostException) && !(th instanceof UnknownServiceException)) {
            return false;
        }
        return true;
    }

    public static float Oxx0IOOO(Matrix matrix) {
        float[] fArr = f316X0o0xo.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = f317XO;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static float X0o0xo() {
        if (f315Oxx0IOOO == -1.0f) {
            f315Oxx0IOOO = Resources.getSystem().getDisplayMetrics().density;
        }
        return f315Oxx0IOOO;
    }

    public static float XO(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static void oIX0oI(Path path, float f, float f2, float f3) {
        com.airbnb.lottie.X0o0xo.oIX0oI("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = f314II0xO0.get();
        Path path2 = f313I0Io.get();
        Path path3 = f319oxoX.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            com.airbnb.lottie.X0o0xo.II0xO0("applyTrimPathIfNeeded");
            return;
        }
        if (length >= 1.0f && Math.abs((f2 - f) - 1.0f) >= 0.01d) {
            float f4 = f * length;
            float f5 = f2 * length;
            float f6 = f3 * length;
            float min = Math.min(f4, f5) + f6;
            float max = Math.max(f4, f5) + f6;
            if (min >= length && max >= length) {
                min = xxIXOIIO.Oxx0IOOO(min, length);
                max = xxIXOIIO.Oxx0IOOO(max, length);
            }
            if (min < 0.0f) {
                min = xxIXOIIO.Oxx0IOOO(min, length);
            }
            if (max < 0.0f) {
                max = xxIXOIIO.Oxx0IOOO(max, length);
            }
            if (min == max) {
                path.reset();
                com.airbnb.lottie.X0o0xo.II0xO0("applyTrimPathIfNeeded");
                return;
            }
            if (min >= max) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            com.airbnb.lottie.X0o0xo.II0xO0("applyTrimPathIfNeeded");
            return;
        }
        com.airbnb.lottie.X0o0xo.II0xO0("applyTrimPathIfNeeded");
    }

    public static void oO(Canvas canvas, RectF rectF, Paint paint, int i) {
        com.airbnb.lottie.X0o0xo.oIX0oI("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        com.airbnb.lottie.X0o0xo.II0xO0("Utils#saveLayer");
    }

    public static Bitmap oOoXoXO(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, false);
        Bitmap createBitmap = Bitmap.createBitmap((int) rectF.right, (int) rectF.bottom, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        oOoXoXO.oIX0oI oix0oi = new oOoXoXO.oIX0oI();
        oix0oi.setAntiAlias(true);
        oix0oi.setColor(-16776961);
        canvas.drawPath(path, oix0oi);
        return createBitmap;
    }

    public static Bitmap ooOOo0oXI(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static Path oxoX(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            float f = pointF3.x + pointF.x;
            float f2 = pointF.y + pointF3.y;
            float f3 = pointF2.x;
            float f4 = f3 + pointF4.x;
            float f5 = pointF2.y;
            path.cubicTo(f, f2, f4, f5 + pointF4.y, f3, f5);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void x0XOIxOo(Canvas canvas, RectF rectF, Paint paint) {
        oO(canvas, rectF, paint, 31);
    }

    public static boolean xoIox(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        if (i2 <= i5 && i3 < i6) {
            return false;
        }
        return true;
    }

    public static int xxIXOIIO(float f, float f2, float f3, float f4) {
        int i;
        if (f != 0.0f) {
            i = (int) (527 * f);
        } else {
            i = 17;
        }
        if (f2 != 0.0f) {
            i = (int) (i * 31 * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        if (f4 != 0.0f) {
            return (int) (i * 31 * f4);
        }
        return i;
    }
}
