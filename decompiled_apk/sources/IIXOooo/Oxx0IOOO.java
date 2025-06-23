package IIXOooo;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes.dex */
public class Oxx0IOOO extends I0Io implements Choreographer.FrameCallback {

    /* renamed from: OxI, reason: collision with root package name */
    @Nullable
    public com.airbnb.lottie.Oxx0IOOO f305OxI;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public float f303IXxxXO = 1.0f;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f306Oxx0xo = false;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public long f309oI0IIXIo = 0;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public float f307OxxIIOOXO = 0.0f;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f302IIXOooo = 0;

    /* renamed from: xoXoI, reason: collision with root package name */
    public float f310xoXoI = -2.1474836E9f;

    /* renamed from: o00, reason: collision with root package name */
    public float f308o00 = 2.1474836E9f;

    /* renamed from: O0xOxO, reason: collision with root package name */
    @VisibleForTesting
    public boolean f304O0xOxO = false;

    @FloatRange(from = XIXIX.OOXIXo.f3760XO, to = 1.0d)
    public float II0XooXoX() {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f305OxI;
        if (oxx0IOOO == null) {
            return 0.0f;
        }
        return (this.f307OxxIIOOXO - oxx0IOOO.x0xO0oo()) / (this.f305OxI.XO() - this.f305OxI.x0xO0oo());
    }

    public void IIXOooo(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
        boolean z;
        if (this.f305OxI == null) {
            z = true;
        } else {
            z = false;
        }
        this.f305OxI = oxx0IOOO;
        if (z) {
            OxI((int) Math.max(this.f310xoXoI, oxx0IOOO.x0xO0oo()), (int) Math.min(this.f308o00, oxx0IOOO.XO()));
        } else {
            OxI((int) oxx0IOOO.x0xO0oo(), (int) oxx0IOOO.XO());
        }
        float f = this.f307OxxIIOOXO;
        this.f307OxxIIOOXO = 0.0f;
        xoXoI((int) f);
        X0o0xo();
    }

    @MainThread
    public void IXxxXO() {
        Oxx0xo(true);
    }

    public void O0xOxO(int i) {
        OxI(i, (int) this.f308o00);
    }

    public float OOXIXo() {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f305OxI;
        if (oxx0IOOO == null) {
            return 0.0f;
        }
        float f = this.f308o00;
        if (f == 2.1474836E9f) {
            return oxx0IOOO.XO();
        }
        return f;
    }

    public void Oo() {
        if (isRunning()) {
            Oxx0xo(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void OxI(float f, float f2) {
        float x0xO0oo2;
        float XO2;
        if (f <= f2) {
            com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f305OxI;
            if (oxx0IOOO == null) {
                x0xO0oo2 = -3.4028235E38f;
            } else {
                x0xO0oo2 = oxx0IOOO.x0xO0oo();
            }
            com.airbnb.lottie.Oxx0IOOO oxx0IOOO2 = this.f305OxI;
            if (oxx0IOOO2 == null) {
                XO2 = Float.MAX_VALUE;
            } else {
                XO2 = oxx0IOOO2.XO();
            }
            this.f310xoXoI = xxIXOIIO.I0Io(f, x0xO0oo2, XO2);
            this.f308o00 = xxIXOIIO.I0Io(f2, x0xO0oo2, XO2);
            xoXoI((int) xxIXOIIO.I0Io(this.f307OxxIIOOXO, f, f2));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
    }

    @MainThread
    public void Oxx0IOOO() {
        IXxxXO();
        II0xO0(x0XOIxOo());
    }

    @MainThread
    public void Oxx0xo(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f304O0xOxO = false;
        }
    }

    public void OxxIIOOXO() {
        X0IIOO(-ooOOo0oXI());
    }

    public void X0IIOO(float f) {
        this.f303IXxxXO = f;
    }

    public final void XI0IXoo() {
        if (this.f305OxI == null) {
            return;
        }
        float f = this.f307OxxIIOOXO;
        if (f >= this.f310xoXoI && f <= this.f308o00) {
        } else {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f310xoXoI), Float.valueOf(this.f308o00), Float.valueOf(this.f307OxxIIOOXO)));
        }
    }

    public void XO() {
        this.f305OxI = null;
        this.f310xoXoI = -2.1474836E9f;
        this.f308o00 = 2.1474836E9f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        oIX0oI();
        IXxxXO();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        float oOoXoXO2;
        float OOXIXo2;
        Oo();
        if (this.f305OxI != null && isRunning()) {
            com.airbnb.lottie.X0o0xo.oIX0oI("LottieValueAnimator#doFrame");
            long j2 = this.f309oI0IIXIo;
            long j3 = 0;
            if (j2 != 0) {
                j3 = j - j2;
            }
            float xoIox2 = ((float) j3) / xoIox();
            float f = this.f307OxxIIOOXO;
            if (x0XOIxOo()) {
                xoIox2 = -xoIox2;
            }
            float f2 = f + xoIox2;
            this.f307OxxIIOOXO = f2;
            boolean X0o0xo2 = xxIXOIIO.X0o0xo(f2, oOoXoXO(), OOXIXo());
            this.f307OxxIIOOXO = xxIXOIIO.I0Io(this.f307OxxIIOOXO, oOoXoXO(), OOXIXo());
            this.f309oI0IIXIo = j;
            X0o0xo();
            if (!X0o0xo2) {
                if (getRepeatCount() != -1 && this.f302IIXOooo >= getRepeatCount()) {
                    if (this.f303IXxxXO < 0.0f) {
                        OOXIXo2 = oOoXoXO();
                    } else {
                        OOXIXo2 = OOXIXo();
                    }
                    this.f307OxxIIOOXO = OOXIXo2;
                    IXxxXO();
                    II0xO0(x0XOIxOo());
                } else {
                    I0Io();
                    this.f302IIXOooo++;
                    if (getRepeatMode() == 2) {
                        this.f306Oxx0xo = !this.f306Oxx0xo;
                        OxxIIOOXO();
                    } else {
                        if (x0XOIxOo()) {
                            oOoXoXO2 = OOXIXo();
                        } else {
                            oOoXoXO2 = oOoXoXO();
                        }
                        this.f307OxxIIOOXO = oOoXoXO2;
                    }
                    this.f309oI0IIXIo = j;
                }
            }
            XI0IXoo();
            com.airbnb.lottie.X0o0xo.II0xO0("LottieValueAnimator#doFrame");
        }
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = XIXIX.OOXIXo.f3760XO, to = 1.0d)
    public float getAnimatedFraction() {
        float oOoXoXO2;
        float OOXIXo2;
        float oOoXoXO3;
        if (this.f305OxI == null) {
            return 0.0f;
        }
        if (x0XOIxOo()) {
            oOoXoXO2 = OOXIXo() - this.f307OxxIIOOXO;
            OOXIXo2 = OOXIXo();
            oOoXoXO3 = oOoXoXO();
        } else {
            oOoXoXO2 = this.f307OxxIIOOXO - oOoXoXO();
            OOXIXo2 = OOXIXo();
            oOoXoXO3 = oOoXoXO();
        }
        return oOoXoXO2 / (OOXIXo2 - oOoXoXO3);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(II0XooXoX());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.f305OxI == null) {
            return 0L;
        }
        return r0.oxoX();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f304O0xOxO;
    }

    public void o00(float f) {
        OxI(this.f310xoXoI, f);
    }

    @MainThread
    public void oI0IIXIo() {
        this.f304O0xOxO = true;
        Oo();
        this.f309oI0IIXIo = 0L;
        if (x0XOIxOo() && xxIXOIIO() == oOoXoXO()) {
            this.f307OxxIIOOXO = OOXIXo();
        } else if (!x0XOIxOo() && xxIXOIIO() == OOXIXo()) {
            this.f307OxxIIOOXO = oOoXoXO();
        }
    }

    @MainThread
    public void oO() {
        IXxxXO();
    }

    public float oOoXoXO() {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f305OxI;
        if (oxx0IOOO == null) {
            return 0.0f;
        }
        float f = this.f310xoXoI;
        if (f == -2.1474836E9f) {
            return oxx0IOOO.x0xO0oo();
        }
        return f;
    }

    public float ooOOo0oXI() {
        return this.f303IXxxXO;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.f306Oxx0xo) {
            this.f306Oxx0xo = false;
            OxxIIOOXO();
        }
    }

    public final boolean x0XOIxOo() {
        if (ooOOo0oXI() < 0.0f) {
            return true;
        }
        return false;
    }

    @MainThread
    public void x0xO0oo() {
        float oOoXoXO2;
        this.f304O0xOxO = true;
        oxoX(x0XOIxOo());
        if (x0XOIxOo()) {
            oOoXoXO2 = OOXIXo();
        } else {
            oOoXoXO2 = oOoXoXO();
        }
        xoXoI((int) oOoXoXO2);
        this.f309oI0IIXIo = 0L;
        this.f302IIXOooo = 0;
        Oo();
    }

    public final float xoIox() {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f305OxI;
        if (oxx0IOOO == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / oxx0IOOO.II0XooXoX()) / Math.abs(this.f303IXxxXO);
    }

    public void xoXoI(float f) {
        if (this.f307OxxIIOOXO == f) {
            return;
        }
        this.f307OxxIIOOXO = xxIXOIIO.I0Io(f, oOoXoXO(), OOXIXo());
        this.f309oI0IIXIo = 0L;
        X0o0xo();
    }

    public float xxIXOIIO() {
        return this.f307OxxIIOOXO;
    }
}
