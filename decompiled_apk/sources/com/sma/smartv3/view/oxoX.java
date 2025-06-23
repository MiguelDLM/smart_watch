package com.sma.smartv3.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.blankj.utilcode.util.SizeUtils;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class oxoX extends Drawable {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f25482xxIXOIIO = new oIX0oI(null);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f25483I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public float f25484II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RectF f25485II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f25486Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f25487X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f25488XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f25489oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f25490oxoX;

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final oxoX oIX0oI(float f, int i, int i2) {
            oxoX oxox = new oxoX();
            oxox.setBounds(0, 0, i, i2);
            oxox.oxoX(f);
            return oxox;
        }

        public oIX0oI() {
        }
    }

    public oxoX() {
        Paint paint = new Paint();
        this.f25489oIX0oI = paint;
        this.f25485II0xO0 = new RectF();
        this.f25483I0Io = Color.parseColor("#888888");
        this.f25490oxoX = Color.parseColor("#FF834C");
        this.f25487X0o0xo = SizeUtils.dp2px(8.0f);
        this.f25488XO = SizeUtils.dp2px(14.0f);
        this.f25486Oxx0IOOO = Color.parseColor("#888888");
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    public final void I0Io(int i) {
        this.f25490oxoX = i;
    }

    public final void II0xO0(int i) {
        this.f25487X0o0xo = i;
    }

    @OXOo.OOXIXo
    public final Bitmap Oxx0IOOO() {
        Bitmap createBitmap = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
        IIX0o.oO(createBitmap, "createBitmap(...)");
        draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public final void X0o0xo(int i) {
        this.f25486Oxx0IOOO = i;
    }

    public final void XO(int i) {
        this.f25488XO = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        Rect bounds = getBounds();
        IIX0o.oO(bounds, "getBounds(...)");
        float width = bounds.width();
        float f = 2;
        float f2 = width / f;
        this.f25489oIX0oI.setTextSize(this.f25488XO);
        Paint paint = this.f25489oIX0oI;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f25487X0o0xo);
        paint.setColor(this.f25483I0Io);
        canvas.drawCircle(f2, f2, f2 - (this.f25487X0o0xo / 2), this.f25489oIX0oI);
        canvas.save();
        canvas.rotate(-90.0f, f2, f2);
        this.f25489oIX0oI.setColor(this.f25490oxoX);
        RectF rectF = this.f25485II0xO0;
        int i = this.f25487X0o0xo;
        rectF.set(i / 2, i / 2, width - (i / 2), width - (i / 2));
        canvas.drawArc(this.f25485II0xO0, 0.0f, this.f25484II0XooXoX * 360, false, this.f25489oIX0oI);
        canvas.restore();
        this.f25489oIX0oI.setStyle(Paint.Style.FILL);
        this.f25489oIX0oI.setColor(this.f25486Oxx0IOOO);
        StringBuilder sb = new StringBuilder();
        sb.append((int) (this.f25484II0XooXoX * 100));
        sb.append(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
        canvas.drawText(sb.toString(), f2, (this.f25489oIX0oI.getTextSize() / f) + f2, this.f25489oIX0oI);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 1 - this.f25489oIX0oI.getAlpha();
    }

    public final void oIX0oI(int i) {
        this.f25483I0Io = i;
    }

    public final void oxoX(float f) {
        this.f25484II0XooXoX = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f25489oIX0oI.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@OXOo.oOoXoXO ColorFilter colorFilter) {
        this.f25489oIX0oI.setColorFilter(colorFilter);
    }
}
