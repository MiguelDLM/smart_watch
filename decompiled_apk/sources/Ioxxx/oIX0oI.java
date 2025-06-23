package Ioxxx;

import Ioxxx.II0xO0;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import androidx.annotation.RequiresApi;

/* loaded from: classes9.dex */
public class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f934oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    public float f933II0xO0 = 1.0f;

    /* renamed from: I0Io, reason: collision with root package name */
    public float f932I0Io = 1.0f;

    public oIX0oI() {
    }

    @RequiresApi(11)
    public void I0Io(int i, int i2) {
        II0xO0.xxX xxx2 = II0xO0.f905II0xO0;
        X0o0xo(i, i2, xxx2, xxx2);
    }

    public float II0XooXoX() {
        return this.f932I0Io;
    }

    @RequiresApi(11)
    public void II0xO0(int i, II0xO0.xxX xxx2) {
        ObjectAnimator oOoXoXO2 = oOoXoXO(i, xxx2);
        oOoXoXO2.addUpdateListener(this.f934oIX0oI);
        oOoXoXO2.start();
    }

    public void OOXIXo(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.f933II0xO0 = f;
    }

    @RequiresApi(11)
    public void Oxx0IOOO(int i, II0xO0.xxX xxx2) {
        ObjectAnimator ooOOo0oXI2 = ooOOo0oXI(i, xxx2);
        ooOOo0oXI2.addUpdateListener(this.f934oIX0oI);
        ooOOo0oXI2.start();
    }

    @RequiresApi(11)
    public void X0o0xo(int i, int i2, II0xO0.xxX xxx2, II0xO0.xxX xxx3) {
        ObjectAnimator oOoXoXO2 = oOoXoXO(i, xxx2);
        ObjectAnimator ooOOo0oXI2 = ooOOo0oXI(i2, xxx3);
        if (i > i2) {
            oOoXoXO2.addUpdateListener(this.f934oIX0oI);
        } else {
            ooOOo0oXI2.addUpdateListener(this.f934oIX0oI);
        }
        oOoXoXO2.start();
        ooOOo0oXI2.start();
    }

    @RequiresApi(11)
    public void XO(int i) {
        Oxx0IOOO(i, II0xO0.f905II0xO0);
    }

    @RequiresApi(11)
    public void oIX0oI(int i) {
        II0xO0(i, II0xO0.f905II0xO0);
    }

    @RequiresApi(11)
    public final ObjectAnimator oOoXoXO(int i, II0xO0.xxX xxx2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", 0.0f, 1.0f);
        ofFloat.setInterpolator(xxx2);
        ofFloat.setDuration(i);
        return ofFloat;
    }

    @RequiresApi(11)
    public final ObjectAnimator ooOOo0oXI(int i, II0xO0.xxX xxx2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", 0.0f, 1.0f);
        ofFloat.setInterpolator(xxx2);
        ofFloat.setDuration(i);
        return ofFloat;
    }

    @RequiresApi(11)
    public void oxoX(int i, int i2, II0xO0.xxX xxx2) {
        ObjectAnimator oOoXoXO2 = oOoXoXO(i, xxx2);
        ObjectAnimator ooOOo0oXI2 = ooOOo0oXI(i2, xxx2);
        if (i > i2) {
            oOoXoXO2.addUpdateListener(this.f934oIX0oI);
        } else {
            ooOOo0oXI2.addUpdateListener(this.f934oIX0oI);
        }
        oOoXoXO2.start();
        ooOOo0oXI2.start();
    }

    public void xoIox(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.f932I0Io = f;
    }

    public float xxIXOIIO() {
        return this.f933II0xO0;
    }

    @RequiresApi(11)
    public oIX0oI(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f934oIX0oI = animatorUpdateListener;
    }
}
