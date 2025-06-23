package OIx0xoOo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import androidx.core.view.ViewCompat;
import java.util.Iterator;
import java.util.Vector;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public final float f1686I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Paint f1687II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Paint f1688oIX0oI;

    public oIX0oI(float f) {
        this(-1, ViewCompat.MEASURED_STATE_MASK, f);
    }

    public void I0Io(Canvas canvas, float f, float f2, String str, Paint paint) {
        float measureText = this.f1687II0xO0.measureText(str);
        float textSize = this.f1687II0xO0.getTextSize();
        Paint paint2 = new Paint(paint);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAlpha(160);
        canvas.drawRect(f, f2 + ((int) textSize), f + ((int) measureText), f2, paint2);
        canvas.drawText(str, f, f2 + textSize, this.f1688oIX0oI);
    }

    public void II0XooXoX(int i) {
        this.f1688oIX0oI.setColor(i);
    }

    public void II0xO0(Canvas canvas, float f, float f2, String str) {
        canvas.drawText(str, f, f2, this.f1687II0xO0);
        canvas.drawText(str, f, f2, this.f1688oIX0oI);
    }

    public void Oxx0IOOO(int i) {
        this.f1687II0xO0.setColor(i);
    }

    public float X0o0xo() {
        return this.f1686I0Io;
    }

    public void XO(int i) {
        this.f1688oIX0oI.setAlpha(i);
        this.f1687II0xO0.setAlpha(i);
    }

    public void oIX0oI(Canvas canvas, float f, float f2, Vector<String> vector) {
        Iterator<String> it = vector.iterator();
        int i = 0;
        while (it.hasNext()) {
            II0xO0(canvas, f, f2 - (X0o0xo() * ((vector.size() - i) - 1)), it.next());
            i++;
        }
    }

    public void oxoX(String str, int i, int i2, Rect rect) {
        this.f1688oIX0oI.getTextBounds(str, i, i2, rect);
    }

    public void xoIox(Typeface typeface) {
        this.f1688oIX0oI.setTypeface(typeface);
        this.f1687II0xO0.setTypeface(typeface);
    }

    public void xxIXOIIO(Paint.Align align) {
        this.f1688oIX0oI.setTextAlign(align);
        this.f1687II0xO0.setTextAlign(align);
    }

    public oIX0oI(int i, int i2, float f) {
        Paint paint = new Paint();
        this.f1688oIX0oI = paint;
        paint.setTextSize(f);
        paint.setColor(i);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(false);
        paint.setAlpha(255);
        Paint paint2 = new Paint();
        this.f1687II0xO0 = paint2;
        paint2.setTextSize(f);
        paint2.setColor(i2);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setStrokeWidth(f / 8.0f);
        paint2.setAntiAlias(false);
        paint2.setAlpha(255);
        this.f1686I0Io = f;
    }
}
