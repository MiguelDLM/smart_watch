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

/* loaded from: classes.dex */
public class GpsStatusImageView extends ImageView {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f4597IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Drawable f4598IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public final int f4599O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public Drawable f4600Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public final int f4601OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Drawable f4602Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f4603OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public final int f4604X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f4605XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public II0xO0 f4606XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public oxoX f4607XO;

    /* renamed from: o00, reason: collision with root package name */
    public final int f4608o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public Drawable f4609oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public Context f4610xoXoI;

    /* loaded from: classes.dex */
    public class oIX0oI implements II0xO0 {
        public oIX0oI() {
        }

        @Override // OOXIXo.II0xO0
        public void I0Io() {
        }

        @Override // OOXIXo.II0xO0
        public void II0xO0() {
        }

        @Override // OOXIXo.II0xO0
        public void oIX0oI(int i, int i2) {
            GpsStatusImageView.this.oxoX(i, i2);
        }

        @Override // OOXIXo.II0xO0
        public void onStart() {
        }

        @Override // OOXIXo.II0xO0
        public void onStop() {
            GpsStatusImageView.this.setSignalStrength(0);
        }
    }

    public GpsStatusImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4603OxxIIOOXO = 4;
        this.f4597IIXOooo = 7;
        this.f4608o00 = 0;
        this.f4601OxI = 1;
        this.f4599O0xOxO = 2;
        this.f4604X0IIOO = 3;
        this.f4605XI0IXoo = 0;
        this.f4606XIxXXX0x0 = new oIX0oI();
        I0Io(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSignalStrength(int i) {
        this.f4605XI0IXoo = i;
        invalidate();
    }

    public final void I0Io(Context context, AttributeSet attributeSet) {
        this.f4610xoXoI = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GpsStatusImageView, 0, 0);
        this.f4600Oo = obtainStyledAttributes.getDrawable(R.styleable.GpsStatusImageView_drawable0);
        this.f4598IXxxXO = obtainStyledAttributes.getDrawable(R.styleable.GpsStatusImageView_drawable1);
        this.f4602Oxx0xo = obtainStyledAttributes.getDrawable(R.styleable.GpsStatusImageView_drawable2);
        this.f4609oI0IIXIo = obtainStyledAttributes.getDrawable(R.styleable.GpsStatusImageView_drawable3);
        this.f4603OxxIIOOXO = obtainStyledAttributes.getInt(R.styleable.GpsStatusImageView_thr_1_2, this.f4603OxxIIOOXO);
        this.f4597IIXOooo = obtainStyledAttributes.getInt(R.styleable.GpsStatusImageView_thr_2_3, this.f4597IIXOooo);
        obtainStyledAttributes.recycle();
        if (this.f4600Oo == null) {
            this.f4600Oo = getResources().getDrawable(R.drawable.ic_gps_0_24dp);
        }
        if (this.f4598IXxxXO == null) {
            this.f4598IXxxXO = getResources().getDrawable(R.drawable.ic_gps_1_24dp);
        }
        if (this.f4602Oxx0xo == null) {
            this.f4602Oxx0xo = getResources().getDrawable(R.drawable.ic_gps_2_24dp);
        }
        if (this.f4609oI0IIXIo == null) {
            this.f4609oI0IIXIo = getResources().getDrawable(R.drawable.ic_gps_3_24dp);
        }
        oxoX xxIXOIIO2 = oxoX.xxIXOIIO(context.getApplicationContext());
        this.f4607XO = xxIXOIIO2;
        xxIXOIIO2.XO(this.f4606XIxXXX0x0);
    }

    public int getSignalStrength() {
        return this.f4605XI0IXoo;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4607XO.x0XOIxOo(this.f4606XIxXXX0x0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i = this.f4605XI0IXoo;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.f4609oI0IIXIo.draw(canvas);
                        return;
                    }
                    return;
                }
                this.f4602Oxx0xo.draw(canvas);
                return;
            }
            this.f4598IXxxXO.draw(canvas);
            return;
        }
        this.f4600Oo.draw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f4600Oo.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.f4598IXxxXO.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.f4602Oxx0xo.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.f4609oI0IIXIo.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public final void oxoX(int i, int i2) {
        if (i <= this.f4603OxxIIOOXO) {
            setSignalStrength(1);
        } else if (i <= this.f4597IIXOooo) {
            setSignalStrength(2);
        } else {
            setSignalStrength(3);
        }
    }

    public GpsStatusImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4603OxxIIOOXO = 4;
        this.f4597IIXOooo = 7;
        this.f4608o00 = 0;
        this.f4601OxI = 1;
        this.f4599O0xOxO = 2;
        this.f4604X0IIOO = 3;
        this.f4605XI0IXoo = 0;
        this.f4606XIxXXX0x0 = new oIX0oI();
        I0Io(context, attributeSet);
    }

    @TargetApi(21)
    public GpsStatusImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f4603OxxIIOOXO = 4;
        this.f4597IIXOooo = 7;
        this.f4608o00 = 0;
        this.f4601OxI = 1;
        this.f4599O0xOxO = 2;
        this.f4604X0IIOO = 3;
        this.f4605XI0IXoo = 0;
        this.f4606XIxXXX0x0 = new oIX0oI();
        I0Io(context, attributeSet);
    }
}
