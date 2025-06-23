package oI00o;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;

/* loaded from: classes6.dex */
public class X0o0xo {
    public static int I0Io(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    public static int II0XooXoX(Context context, float f) {
        return (int) TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static Rect II0xO0(float f, float f2, float f3, int i, int i2, int i3, int i4) {
        int i5 = (int) ((i * f) / 2.0f);
        int i6 = (int) ((i2 * f) / 2.0f);
        int i7 = (int) (((f2 / i3) * 2000.0f) - 1000.0f);
        int i8 = (int) (((f3 / i4) * 2000.0f) - 1000.0f);
        RectF rectF = new RectF(I0Io(i7 - i5, -1000, 1000), I0Io(i8 - i6, -1000, 1000), I0Io(i7 + i5, -1000, 1000), I0Io(i8 + i6, -1000, 1000));
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public static void Oxx0IOOO(String str, Rect rect) {
        II0xO0.oIX0oI(str + " centerX：" + rect.centerX() + " centerY：" + rect.centerY() + " width：" + rect.width() + " height：" + rect.height() + " rectHalfWidth：" + (rect.width() / 2) + " rectHalfHeight：" + (rect.height() / 2) + " left：" + rect.left + " top：" + rect.top + " right：" + rect.right + " bottom：" + rect.bottom);
    }

    public static Point X0o0xo(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static boolean XO(Context context) {
        Point X0o0xo2 = X0o0xo(context);
        if (X0o0xo2.y > X0o0xo2.x) {
            return true;
        }
        return false;
    }

    public static float oIX0oI(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public static int oxoX(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
