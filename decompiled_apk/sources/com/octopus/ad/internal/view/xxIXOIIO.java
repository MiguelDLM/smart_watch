package com.octopus.ad.internal.view;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.octopus.ad.internal.xoIox;

/* loaded from: classes11.dex */
public class xxIXOIIO implements View.OnTouchListener {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public final oIX0oI f19043IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public float f19044IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public float f19045Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f19046Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public final boolean f19047OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public long f19048XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f19049oI0IIXIo = false;

    /* loaded from: classes11.dex */
    public interface oIX0oI {
        void a(View view);
    }

    public xxIXOIIO(boolean z, oIX0oI oix0oi) {
        this.f19047OxxIIOOXO = z;
        this.f19043IIXOooo = oix0oi;
    }

    public static float II0xO0(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return oIX0oI((float) Math.sqrt((f5 * f5) + (f6 * f6)));
    }

    public static float oIX0oI(float f) {
        return f / xoIox.oIX0oI().xoXoI().density;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        oIX0oI oix0oi;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.f19046Oxx0xo && II0xO0(this.f19045Oo, this.f19044IXxxXO, motionEvent.getX(), motionEvent.getY()) > 15.0f) {
                    this.f19046Oxx0xo = false;
                }
            } else {
                if (System.currentTimeMillis() - this.f19048XO < 1000 && this.f19046Oxx0xo && (!this.f19047OxxIIOOXO || (this.f19049oI0IIXIo && this.f19043IIXOooo != null))) {
                    this.f19043IIXOooo.a(view);
                }
                this.f19049oI0IIXIo = true;
            }
        } else {
            this.f19048XO = System.currentTimeMillis();
            this.f19045Oo = motionEvent.getX();
            this.f19044IXxxXO = motionEvent.getY();
            this.f19046Oxx0xo = true;
            if (this.f19047OxxIIOOXO && !this.f19049oI0IIXIo && (oix0oi = this.f19043IIXOooo) != null) {
                oix0oi.a(view);
            }
        }
        return true;
    }
}
