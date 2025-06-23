package xoXoI;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class oIX0oI<T> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f35162IXxxXO = 784923401;

    /* renamed from: Oo, reason: collision with root package name */
    public static final float f35163Oo = -3987645.8f;

    /* renamed from: I0Io, reason: collision with root package name */
    @Nullable
    public T f35164I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @Nullable
    public Float f35165II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @Nullable
    public final T f35166II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f35167OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final float f35168Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @Nullable
    public final Interpolator f35169X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @Nullable
    public final Interpolator f35170XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @Nullable
    public final com.airbnb.lottie.Oxx0IOOO f35171oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public PointF f35172oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f35173oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public float f35174ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    @Nullable
    public final Interpolator f35175oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public float f35176x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public PointF f35177x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public float f35178xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public float f35179xxIXOIIO;

    public oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.f35179xxIXOIIO = -3987645.8f;
        this.f35178xoIox = -3987645.8f;
        this.f35167OOXIXo = f35162IXxxXO;
        this.f35173oOoXoXO = f35162IXxxXO;
        this.f35174ooOOo0oXI = Float.MIN_VALUE;
        this.f35176x0XOIxOo = Float.MIN_VALUE;
        this.f35172oO = null;
        this.f35177x0xO0oo = null;
        this.f35171oIX0oI = oxx0IOOO;
        this.f35166II0xO0 = t;
        this.f35164I0Io = t2;
        this.f35175oxoX = interpolator;
        this.f35169X0o0xo = null;
        this.f35170XO = null;
        this.f35168Oxx0IOOO = f;
        this.f35165II0XooXoX = f2;
    }

    public float I0Io() {
        if (this.f35178xoIox == -3987645.8f) {
            this.f35178xoIox = ((Float) this.f35164I0Io).floatValue();
        }
        return this.f35178xoIox;
    }

    public boolean II0XooXoX() {
        if (this.f35175oxoX == null && this.f35169X0o0xo == null && this.f35170XO == null) {
            return true;
        }
        return false;
    }

    public float II0xO0() {
        if (this.f35171oIX0oI == null) {
            return 1.0f;
        }
        if (this.f35176x0XOIxOo == Float.MIN_VALUE) {
            if (this.f35165II0XooXoX == null) {
                this.f35176x0XOIxOo = 1.0f;
            } else {
                this.f35176x0XOIxOo = X0o0xo() + ((this.f35165II0XooXoX.floatValue() - this.f35168Oxx0IOOO) / this.f35171oIX0oI.X0o0xo());
            }
        }
        return this.f35176x0XOIxOo;
    }

    public int Oxx0IOOO() {
        if (this.f35167OOXIXo == 784923401) {
            this.f35167OOXIXo = ((Integer) this.f35166II0xO0).intValue();
        }
        return this.f35167OOXIXo;
    }

    public float X0o0xo() {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f35171oIX0oI;
        if (oxx0IOOO == null) {
            return 0.0f;
        }
        if (this.f35174ooOOo0oXI == Float.MIN_VALUE) {
            this.f35174ooOOo0oXI = (this.f35168Oxx0IOOO - oxx0IOOO.x0xO0oo()) / this.f35171oIX0oI.X0o0xo();
        }
        return this.f35174ooOOo0oXI;
    }

    public float XO() {
        if (this.f35179xxIXOIIO == -3987645.8f) {
            this.f35179xxIXOIIO = ((Float) this.f35166II0xO0).floatValue();
        }
        return this.f35179xxIXOIIO;
    }

    public boolean oIX0oI(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f >= X0o0xo() && f < II0xO0()) {
            return true;
        }
        return false;
    }

    public int oxoX() {
        if (this.f35173oOoXoXO == 784923401) {
            this.f35173oOoXoXO = ((Integer) this.f35164I0Io).intValue();
        }
        return this.f35173oOoXoXO;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f35166II0xO0 + ", endValue=" + this.f35164I0Io + ", startFrame=" + this.f35168Oxx0IOOO + ", endFrame=" + this.f35165II0XooXoX + ", interpolator=" + this.f35175oxoX + '}';
    }

    public oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, float f, @Nullable Float f2) {
        this.f35179xxIXOIIO = -3987645.8f;
        this.f35178xoIox = -3987645.8f;
        this.f35167OOXIXo = f35162IXxxXO;
        this.f35173oOoXoXO = f35162IXxxXO;
        this.f35174ooOOo0oXI = Float.MIN_VALUE;
        this.f35176x0XOIxOo = Float.MIN_VALUE;
        this.f35172oO = null;
        this.f35177x0xO0oo = null;
        this.f35171oIX0oI = oxx0IOOO;
        this.f35166II0xO0 = t;
        this.f35164I0Io = t2;
        this.f35175oxoX = null;
        this.f35169X0o0xo = interpolator;
        this.f35170XO = interpolator2;
        this.f35168Oxx0IOOO = f;
        this.f35165II0XooXoX = f2;
    }

    public oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, @Nullable Interpolator interpolator3, float f, @Nullable Float f2) {
        this.f35179xxIXOIIO = -3987645.8f;
        this.f35178xoIox = -3987645.8f;
        this.f35167OOXIXo = f35162IXxxXO;
        this.f35173oOoXoXO = f35162IXxxXO;
        this.f35174ooOOo0oXI = Float.MIN_VALUE;
        this.f35176x0XOIxOo = Float.MIN_VALUE;
        this.f35172oO = null;
        this.f35177x0xO0oo = null;
        this.f35171oIX0oI = oxx0IOOO;
        this.f35166II0xO0 = t;
        this.f35164I0Io = t2;
        this.f35175oxoX = interpolator;
        this.f35169X0o0xo = interpolator2;
        this.f35170XO = interpolator3;
        this.f35168Oxx0IOOO = f;
        this.f35165II0XooXoX = f2;
    }

    public oIX0oI(T t) {
        this.f35179xxIXOIIO = -3987645.8f;
        this.f35178xoIox = -3987645.8f;
        this.f35167OOXIXo = f35162IXxxXO;
        this.f35173oOoXoXO = f35162IXxxXO;
        this.f35174ooOOo0oXI = Float.MIN_VALUE;
        this.f35176x0XOIxOo = Float.MIN_VALUE;
        this.f35172oO = null;
        this.f35177x0xO0oo = null;
        this.f35171oIX0oI = null;
        this.f35166II0xO0 = t;
        this.f35164I0Io = t;
        this.f35175oxoX = null;
        this.f35169X0o0xo = null;
        this.f35170XO = null;
        this.f35168Oxx0IOOO = Float.MIN_VALUE;
        this.f35165II0XooXoX = Float.valueOf(Float.MAX_VALUE);
    }
}
