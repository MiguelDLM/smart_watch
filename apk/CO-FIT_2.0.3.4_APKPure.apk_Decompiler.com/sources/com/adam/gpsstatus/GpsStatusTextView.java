package com.adam.gpsstatus;

import OOXIXo.II0xO0;
import OOXIXo.oxoX;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class GpsStatusTextView extends TextView {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public int f618IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public Context f619Oo;

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public int f620Oxx0xo;

    /* renamed from: OxxIIOOXO  reason: collision with root package name */
    public II0xO0 f621OxxIIOOXO = new oIX0oI();

    /* renamed from: XO  reason: collision with root package name */
    public oxoX f622XO;

    /* renamed from: oI0IIXIo  reason: collision with root package name */
    public int f623oI0IIXIo;

    public class oIX0oI implements II0xO0 {
        public oIX0oI() {
        }

        public void I0Io() {
            GpsStatusTextView gpsStatusTextView = GpsStatusTextView.this;
            gpsStatusTextView.setTextColor(gpsStatusTextView.f623oI0IIXIo);
        }

        public void II0xO0() {
            GpsStatusTextView gpsStatusTextView = GpsStatusTextView.this;
            gpsStatusTextView.setTextColor(gpsStatusTextView.f620Oxx0xo);
        }

        public void oIX0oI(int i, int i2) {
        }

        public void onStart() {
            GpsStatusTextView gpsStatusTextView = GpsStatusTextView.this;
            gpsStatusTextView.setTextColor(gpsStatusTextView.f623oI0IIXIo);
        }

        public void onStop() {
            GpsStatusTextView gpsStatusTextView = GpsStatusTextView.this;
            gpsStatusTextView.setTextColor(gpsStatusTextView.f618IXxxXO);
        }
    }

    public GpsStatusTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        oxoX(context, attributeSet);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f622XO.x0XOIxOo(this.f621OxxIIOOXO);
    }

    public final void oxoX(Context context, AttributeSet attributeSet) {
        this.f619Oo = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GpsStatusTextView, 0, 0);
        this.f618IXxxXO = obtainStyledAttributes.getColor(R.styleable.GpsStatusTextView_colorClosed, getResources().getColor(R.color.gps_icon_red));
        this.f620Oxx0xo = obtainStyledAttributes.getColor(R.styleable.GpsStatusTextView_colorFixed, getResources().getColor(R.color.gps_icon_green));
        this.f623oI0IIXIo = obtainStyledAttributes.getColor(R.styleable.GpsStatusTextView_colorUnFixed, getResources().getColor(R.color.gps_icon_yellow));
        obtainStyledAttributes.recycle();
        oxoX xxIXOIIO2 = oxoX.xxIXOIIO(context.getApplicationContext());
        this.f622XO = xxIXOIIO2;
        xxIXOIIO2.XO(this.f621OxxIIOOXO);
        this.f622XO.oOoXoXO();
    }

    public GpsStatusTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        oxoX(context, attributeSet);
    }

    @RequiresApi(api = 21)
    public GpsStatusTextView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        oxoX(context, attributeSet);
    }
}
