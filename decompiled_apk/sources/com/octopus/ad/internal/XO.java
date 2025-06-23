package com.octopus.ad.internal;

import android.graphics.Rect;
import android.view.View;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public class XO {

    /* renamed from: I0Io, reason: collision with root package name */
    public ScheduledExecutorService f18622I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public xXoOI00O.II0xO0 f18623II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public View f18624oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public Runnable f18625oxoX;

    /* loaded from: classes11.dex */
    public class II0xO0 implements Runnable {
        public II0xO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (XO.this.f18624oIX0oI != null) {
                XO.this.f18624oIX0oI.post(XO.this.f18625oxoX);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (XO.this.II0XooXoX()) {
                if (XO.this.f18623II0xO0 != null) {
                    XO.this.f18623II0xO0.oIX0oI(true);
                }
                if (XO.this.f18622I0Io != null) {
                    XO.this.f18622I0Io.shutdownNow();
                }
                XO.this.f18623II0xO0 = null;
                XO.this.f18624oIX0oI = null;
                XO.this.f18622I0Io = null;
            }
        }
    }

    public XO(View view, xXoOI00O.II0xO0 iI0xO0) {
        this.f18624oIX0oI = view;
        this.f18623II0xO0 = iI0xO0;
        X0o0xo();
    }

    public static XO II0xO0(View view, xXoOI00O.II0xO0 iI0xO0) {
        if (view == null) {
            return null;
        }
        return new XO(view, iI0xO0);
    }

    public final boolean II0XooXoX() {
        int i;
        View view = this.f18624oIX0oI;
        if (view == null || view.getVisibility() != 0 || this.f18624oIX0oI.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        this.f18624oIX0oI.getLocalVisibleRect(rect);
        try {
            DecimalFormat decimalFormat = new DecimalFormat("##0.00");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            if (rect.left == 0) {
                if (rect.top >= 0) {
                    if (rect.bottom <= this.f18624oIX0oI.getHeight()) {
                        if (Float.parseFloat(decimalFormat.format((((rect.bottom - rect.top) * rect.right) * 1.0d) / (this.f18624oIX0oI.getWidth() * this.f18624oIX0oI.getHeight()))) <= 0.5d) {
                        }
                        return true;
                    }
                }
            }
            if (rect.left <= 0 || (i = rect.right) < 0 || i > this.f18624oIX0oI.getWidth()) {
                return false;
            }
            if (Float.parseFloat(decimalFormat.format((((rect.right - rect.left) * (rect.bottom - rect.top)) * 1.0d) / (this.f18624oIX0oI.getWidth() * this.f18624oIX0oI.getHeight()))) <= 0.5d) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public final void X0o0xo() {
        this.f18625oxoX = new oIX0oI();
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f18622I0Io = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(new II0xO0(), 0L, 250L, TimeUnit.MILLISECONDS);
    }
}
