package com.adam.gpsstatus;

import OOXIXo.II0xO0;
import OOXIXo.oxoX;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* loaded from: classes.dex */
public class GpsStatusTextView extends TextView {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f4612IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public Context f4613Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f4614Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public II0xO0 f4615OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public oxoX f4616XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f4617oI0IIXIo;

    /* loaded from: classes.dex */
    public class oIX0oI implements II0xO0 {
        public oIX0oI() {
        }

        @Override // OOXIXo.II0xO0
        public void I0Io() {
            GpsStatusTextView gpsStatusTextView = GpsStatusTextView.this;
            gpsStatusTextView.setTextColor(gpsStatusTextView.f4617oI0IIXIo);
        }

        @Override // OOXIXo.II0xO0
        public void II0xO0() {
            GpsStatusTextView gpsStatusTextView = GpsStatusTextView.this;
            gpsStatusTextView.setTextColor(gpsStatusTextView.f4614Oxx0xo);
        }

        @Override // OOXIXo.II0xO0
        public void oIX0oI(int i, int i2) {
        }

        @Override // OOXIXo.II0xO0
        public void onStart() {
            GpsStatusTextView gpsStatusTextView = GpsStatusTextView.this;
            gpsStatusTextView.setTextColor(gpsStatusTextView.f4617oI0IIXIo);
        }

        @Override // OOXIXo.II0xO0
        public void onStop() {
            GpsStatusTextView gpsStatusTextView = GpsStatusTextView.this;
            gpsStatusTextView.setTextColor(gpsStatusTextView.f4612IXxxXO);
        }
    }

    public GpsStatusTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4615OxxIIOOXO = new oIX0oI();
        oxoX(context, attributeSet);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4616XO.x0XOIxOo(this.f4615OxxIIOOXO);
    }

    public final void oxoX(Context context, AttributeSet attributeSet) {
        this.f4613Oo = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GpsStatusTextView, 0, 0);
        this.f4612IXxxXO = obtainStyledAttributes.getColor(R.styleable.GpsStatusTextView_colorClosed, getResources().getColor(R.color.gps_icon_red));
        this.f4614Oxx0xo = obtainStyledAttributes.getColor(R.styleable.GpsStatusTextView_colorFixed, getResources().getColor(R.color.gps_icon_green));
        this.f4617oI0IIXIo = obtainStyledAttributes.getColor(R.styleable.GpsStatusTextView_colorUnFixed, getResources().getColor(R.color.gps_icon_yellow));
        obtainStyledAttributes.recycle();
        oxoX xxIXOIIO2 = oxoX.xxIXOIIO(context.getApplicationContext());
        this.f4616XO = xxIXOIIO2;
        xxIXOIIO2.XO(this.f4615OxxIIOOXO);
        this.f4616XO.oOoXoXO();
    }

    public GpsStatusTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4615OxxIIOOXO = new oIX0oI();
        oxoX(context, attributeSet);
    }

    @RequiresApi(api = 21)
    public GpsStatusTextView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f4615OxxIIOOXO = new oIX0oI();
        oxoX(context, attributeSet);
    }
}
