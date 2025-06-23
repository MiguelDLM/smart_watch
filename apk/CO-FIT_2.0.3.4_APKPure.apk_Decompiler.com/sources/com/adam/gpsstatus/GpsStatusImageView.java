package com.adam.gpsstatus;

import OOXIXo.II0xO0;
import OOXIXo.oxoX;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class GpsStatusImageView extends ImageView {

    /* renamed from: IIXOooo  reason: collision with root package name */
    public int f603IIXOooo = 7;

    /* renamed from: IXxxXO  reason: collision with root package name */
    public Drawable f604IXxxXO;

    /* renamed from: O0xOxO  reason: collision with root package name */
    public final int f605O0xOxO = 2;

    /* renamed from: Oo  reason: collision with root package name */
    public Drawable f606Oo;

    /* renamed from: OxI  reason: collision with root package name */
    public final int f607OxI = 1;

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public Drawable f608Oxx0xo;

    /* renamed from: OxxIIOOXO  reason: collision with root package name */
    public int f609OxxIIOOXO = 4;

    /* renamed from: X0IIOO  reason: collision with root package name */
    public final int f610X0IIOO = 3;

    /* renamed from: XI0IXoo  reason: collision with root package name */
    public int f611XI0IXoo = 0;

    /* renamed from: XIxXXX0x0  reason: collision with root package name */
    public II0xO0 f612XIxXXX0x0 = new oIX0oI();

    /* renamed from: XO  reason: collision with root package name */
    public oxoX f613XO;

    /* renamed from: o00  reason: collision with root package name */
    public final int f614o00 = 0;

    /* renamed from: oI0IIXIo  reason: collision with root package name */
    public Drawable f615oI0IIXIo;

    /* renamed from: xoXoI  reason: collision with root package name */
    public Context f616xoXoI;

    public class oIX0oI implements II0xO0 {
        public oIX0oI() {
        }

        public void I0Io() {
        }

        public void II0xO0() {
        }

        public void oIX0oI(int i, int i2) {
            GpsStatusImageView.this.oxoX(i, i2);
        }

        public void onStart() {
        }

        public void onStop() {
            GpsStatusImageView.this.setSignalStrength(0);
        }
    }

    public GpsStatusImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        I0Io(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public void setSignalStrength(int i) {
        this.f611XI0IXoo = i;
        invalidate();
    }

    public final void I0Io(Context context, AttributeSet attributeSet) {
        this.f616xoXoI = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GpsStatusImageView, 0, 0);
        this.f606Oo = obtainStyledAttributes.getDrawable(R.styleable.GpsStatusImageView_drawable0);
        this.f604IXxxXO = obtainStyledAttributes.getDrawable(R.styleable.GpsStatusImageView_drawable1);
        this.f608Oxx0xo = obtainStyledAttributes.getDrawable(R.styleable.GpsStatusImageView_drawable2);
        this.f615oI0IIXIo = obtainStyledAttributes.getDrawable(R.styleable.GpsStatusImageView_drawable3);
        this.f609OxxIIOOXO = obtainStyledAttributes.getInt(R.styleable.GpsStatusImageView_thr_1_2, this.f609OxxIIOOXO);
        this.f603IIXOooo = obtainStyledAttributes.getInt(R.styleable.GpsStatusImageView_thr_2_3, this.f603IIXOooo);
        obtainStyledAttributes.recycle();
        if (this.f606Oo == null) {
            this.f606Oo = getResources().getDrawable(R.drawable.ic_gps_0_24dp);
        }
        if (this.f604IXxxXO == null) {
            this.f604IXxxXO = getResources().getDrawable(R.drawable.ic_gps_1_24dp);
        }
        if (this.f608Oxx0xo == null) {
            this.f608Oxx0xo = getResources().getDrawable(R.drawable.ic_gps_2_24dp);
        }
        if (this.f615oI0IIXIo == null) {
            this.f615oI0IIXIo = getResources().getDrawable(R.drawable.ic_gps_3_24dp);
        }
        oxoX xxIXOIIO2 = oxoX.xxIXOIIO(context.getApplicationContext());
        this.f613XO = xxIXOIIO2;
        xxIXOIIO2.XO(this.f612XIxXXX0x0);
    }

    public int getSignalStrength() {
        return this.f611XI0IXoo;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f613XO.x0XOIxOo(this.f612XIxXXX0x0);
    }

    public void onDraw(Canvas canvas) {
        int i = this.f611XI0IXoo;
        if (i == 0) {
            this.f606Oo.draw(canvas);
        } else if (i == 1) {
            this.f604IXxxXO.draw(canvas);
        } else if (i == 2) {
            this.f608Oxx0xo.draw(canvas);
        } else if (i == 3) {
            this.f615oI0IIXIo.draw(canvas);
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f606Oo.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.f604IXxxXO.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.f608Oxx0xo.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.f615oI0IIXIo.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public final void oxoX(int i, int i2) {
        if (i <= this.f609OxxIIOOXO) {
            setSignalStrength(1);
        } else if (i <= this.f603IIXOooo) {
            setSignalStrength(2);
        } else {
            setSignalStrength(3);
        }
    }

    public GpsStatusImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        I0Io(context, attributeSet);
    }

    @TargetApi(21)
    public GpsStatusImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        I0Io(context, attributeSet);
    }
}
