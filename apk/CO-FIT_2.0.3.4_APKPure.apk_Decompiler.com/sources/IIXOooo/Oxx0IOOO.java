package IIXOooo;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.airbnb.lottie.X0o0xo;

public class Oxx0IOOO extends I0Io implements Choreographer.FrameCallback {

    /* renamed from: IIXOooo  reason: collision with root package name */
    public int f18IIXOooo = 0;

    /* renamed from: IXxxXO  reason: collision with root package name */
    public float f19IXxxXO = 1.0f;
    @VisibleForTesting

    /* renamed from: O0xOxO  reason: collision with root package name */
    public boolean f20O0xOxO = false;
    @Nullable

    /* renamed from: OxI  reason: collision with root package name */
    public com.airbnb.lottie.Oxx0IOOO f21OxI;

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public boolean f22Oxx0xo = false;

    /* renamed from: OxxIIOOXO  reason: collision with root package name */
    public float f23OxxIIOOXO = 0.0f;

    /* renamed from: o00  reason: collision with root package name */
    public float f24o00 = 2.14748365E9f;

    /* renamed from: oI0IIXIo  reason: collision with root package name */
    public long f25oI0IIXIo = 0;

    /* renamed from: xoXoI  reason: collision with root package name */
    public float f26xoXoI = -2.14748365E9f;

    @FloatRange(from = 0.0d, to = 1.0d)
    public float II0XooXoX() {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f21OxI;
        if (oxx0IOOO == null) {
            return 0.0f;
        }
        return (this.f23OxxIIOOXO - oxx0IOOO.x0xO0oo()) / (this.f21OxI.XO() - this.f21OxI.x0xO0oo());
    }

    public void IIXOooo(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
        boolean z;
        if (this.f21OxI == null) {
            z = true;
        } else {
            z = false;
        }
        this.f21OxI = oxx0IOOO;
        if (z) {
            OxI((float) ((int) Math.max(this.f26xoXoI, oxx0IOOO.x0xO0oo())), (float) ((int) Math.min(this.f24o00, oxx0IOOO.XO())));
        } else {
            OxI((float) ((int) oxx0IOOO.x0xO0oo()), (float) ((int) oxx0IOOO.XO()));
        }
        float f = this.f23OxxIIOOXO;
        this.f23OxxIIOOXO = 0.0f;
        xoXoI((float) ((int) f));
        X0o0xo();
    }

    @MainThread
    public void IXxxXO() {
        Oxx0xo(true);
    }

    public void O0xOxO(int i) {
        OxI((float) i, (float) ((int) this.f24o00));
    }

    public float OOXIXo() {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f21OxI;
        if (oxx0IOOO == null) {
            return 0.0f;
        }
        float f = this.f24o00;
        if (f == 2.14748365E9f) {
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
        float f3;
        float f4;
        if (f <= f2) {
            com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f21OxI;
            if (oxx0IOOO == null) {
                f3 = -3.4028235E38f;
            } else {
                f3 = oxx0IOOO.x0xO0oo();
            }
            com.airbnb.lottie.Oxx0IOOO oxx0IOOO2 = this.f21OxI;
            if (oxx0IOOO2 == null) {
                f4 = Float.MAX_VALUE;
            } else {
                f4 = oxx0IOOO2.XO();
            }
            this.f26xoXoI = xxIXOIIO.I0Io(f, f3, f4);
            this.f24o00 = xxIXOIIO.I0Io(f2, f3, f4);
            xoXoI((float) ((int) xxIXOIIO.I0Io(this.f23OxxIIOOXO, f, f2)));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[]{Float.valueOf(f), Float.valueOf(f2)}));
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
            this.f20O0xOxO = false;
        }
    }

    public void OxxIIOOXO() {
        X0IIOO(-ooOOo0oXI());
    }

    public void X0IIOO(float f) {
        this.f19IXxxXO = f;
    }

    public final void XI0IXoo() {
        if (this.f21OxI != null) {
            float f = this.f23OxxIIOOXO;
            if (f < this.f26xoXoI || f > this.f24o00) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.f26xoXoI), Float.valueOf(this.f24o00), Float.valueOf(this.f23OxxIIOOXO)}));
            }
        }
    }

    public void XO() {
        this.f21OxI = null;
        this.f26xoXoI = -2.14748365E9f;
        this.f24o00 = 2.14748365E9f;
    }

    @MainThread
    public void cancel() {
        oIX0oI();
        IXxxXO();
    }

    public void doFrame(long j) {
        float f;
        float f2;
        Oo();
        if (this.f21OxI != null && isRunning()) {
            X0o0xo.oIX0oI("LottieValueAnimator#doFrame");
            long j2 = this.f25oI0IIXIo;
            long j3 = 0;
            if (j2 != 0) {
                j3 = j - j2;
            }
            float xoIox2 = ((float) j3) / xoIox();
            float f3 = this.f23OxxIIOOXO;
            if (x0XOIxOo()) {
                xoIox2 = -xoIox2;
            }
            float f4 = f3 + xoIox2;
            this.f23OxxIIOOXO = f4;
            boolean X0o0xo2 = xxIXOIIO.X0o0xo(f4, oOoXoXO(), OOXIXo());
            this.f23OxxIIOOXO = xxIXOIIO.I0Io(this.f23OxxIIOOXO, oOoXoXO(), OOXIXo());
            this.f25oI0IIXIo = j;
            X0o0xo();
            if (!X0o0xo2) {
                if (getRepeatCount() == -1 || this.f18IIXOooo < getRepeatCount()) {
                    I0Io();
                    this.f18IIXOooo++;
                    if (getRepeatMode() == 2) {
                        this.f22Oxx0xo = !this.f22Oxx0xo;
                        OxxIIOOXO();
                    } else {
                        if (x0XOIxOo()) {
                            f = OOXIXo();
                        } else {
                            f = oOoXoXO();
                        }
                        this.f23OxxIIOOXO = f;
                    }
                    this.f25oI0IIXIo = j;
                } else {
                    if (this.f19IXxxXO < 0.0f) {
                        f2 = oOoXoXO();
                    } else {
                        f2 = OOXIXo();
                    }
                    this.f23OxxIIOOXO = f2;
                    IXxxXO();
                    II0xO0(x0XOIxOo());
                }
            }
            XI0IXoo();
            X0o0xo.II0xO0("LottieValueAnimator#doFrame");
        }
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float oOoXoXO2;
        float OOXIXo2;
        float oOoXoXO3;
        if (this.f21OxI == null) {
            return 0.0f;
        }
        if (x0XOIxOo()) {
            oOoXoXO2 = OOXIXo() - this.f23OxxIIOOXO;
            OOXIXo2 = OOXIXo();
            oOoXoXO3 = oOoXoXO();
        } else {
            oOoXoXO2 = this.f23OxxIIOOXO - oOoXoXO();
            OOXIXo2 = OOXIXo();
            oOoXoXO3 = oOoXoXO();
        }
        return oOoXoXO2 / (OOXIXo2 - oOoXoXO3);
    }

    public Object getAnimatedValue() {
        return Float.valueOf(II0XooXoX());
    }

    public long getDuration() {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f21OxI;
        if (oxx0IOOO == null) {
            return 0;
        }
        return (long) oxx0IOOO.oxoX();
    }

    public boolean isRunning() {
        return this.f20O0xOxO;
    }

    public void o00(float f) {
        OxI(this.f26xoXoI, f);
    }

    @MainThread
    public void oI0IIXIo() {
        this.f20O0xOxO = true;
        Oo();
        this.f25oI0IIXIo = 0;
        if (x0XOIxOo() && xxIXOIIO() == oOoXoXO()) {
            this.f23OxxIIOOXO = OOXIXo();
        } else if (!x0XOIxOo() && xxIXOIIO() == OOXIXo()) {
            this.f23OxxIIOOXO = oOoXoXO();
        }
    }

    @MainThread
    public void oO() {
        IXxxXO();
    }

    public float oOoXoXO() {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f21OxI;
        if (oxx0IOOO == null) {
            return 0.0f;
        }
        float f = this.f26xoXoI;
        if (f == -2.14748365E9f) {
            return oxx0IOOO.x0xO0oo();
        }
        return f;
    }

    public float ooOOo0oXI() {
        return this.f19IXxxXO;
    }

    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.f22Oxx0xo) {
            this.f22Oxx0xo = false;
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
        float f;
        this.f20O0xOxO = true;
        oxoX(x0XOIxOo());
        if (x0XOIxOo()) {
            f = OOXIXo();
        } else {
            f = oOoXoXO();
        }
        xoXoI((float) ((int) f));
        this.f25oI0IIXIo = 0;
        this.f18IIXOooo = 0;
        Oo();
    }

    public final float xoIox() {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f21OxI;
        if (oxx0IOOO == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / oxx0IOOO.II0XooXoX()) / Math.abs(this.f19IXxxXO);
    }

    public void xoXoI(float f) {
        if (this.f23OxxIIOOXO != f) {
            this.f23OxxIIOOXO = xxIXOIIO.I0Io(f, oOoXoXO(), OOXIXo());
            this.f25oI0IIXIo = 0;
            X0o0xo();
        }
    }

    public float xxIXOIIO() {
        return this.f23OxxIIOOXO;
    }
}
