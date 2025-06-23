package x0XOIxOo;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class oIX0oI<K, A> {

    /* renamed from: I0Io, reason: collision with root package name */
    public final oxoX<K> f33967I0Io;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @Nullable
    public xoXoI.xoIox<A> f33971X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final List<II0xO0> f33973oIX0oI = new ArrayList(1);

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f33969II0xO0 = false;

    /* renamed from: oxoX, reason: collision with root package name */
    public float f33974oxoX = 0.0f;

    /* renamed from: XO, reason: collision with root package name */
    @Nullable
    public A f33972XO = null;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public float f33970Oxx0IOOO = -1.0f;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public float f33968II0XooXoX = -1.0f;

    /* loaded from: classes.dex */
    public static final class I0Io<T> implements oxoX<T> {
        public I0Io() {
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public boolean I0Io(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public float II0xO0() {
            return 0.0f;
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public float X0o0xo() {
            return 1.0f;
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public boolean isEmpty() {
            return true;
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public xoXoI.oIX0oI<T> oIX0oI() {
            throw new IllegalStateException("not implemented");
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public boolean oxoX(float f) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface II0xO0 {
        void oxoX();
    }

    /* loaded from: classes.dex */
    public static final class X0o0xo<T> implements oxoX<T> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final List<? extends xoXoI.oIX0oI<T>> f33977oIX0oI;

        /* renamed from: I0Io, reason: collision with root package name */
        public xoXoI.oIX0oI<T> f33975I0Io = null;

        /* renamed from: oxoX, reason: collision with root package name */
        public float f33978oxoX = -1.0f;

        /* renamed from: II0xO0, reason: collision with root package name */
        @NonNull
        public xoXoI.oIX0oI<T> f33976II0xO0 = XO(0.0f);

        public X0o0xo(List<? extends xoXoI.oIX0oI<T>> list) {
            this.f33977oIX0oI = list;
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public boolean I0Io(float f) {
            xoXoI.oIX0oI<T> oix0oi = this.f33975I0Io;
            xoXoI.oIX0oI<T> oix0oi2 = this.f33976II0xO0;
            if (oix0oi == oix0oi2 && this.f33978oxoX == f) {
                return true;
            }
            this.f33975I0Io = oix0oi2;
            this.f33978oxoX = f;
            return false;
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public float II0xO0() {
            return this.f33977oIX0oI.get(0).X0o0xo();
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public float X0o0xo() {
            return this.f33977oIX0oI.get(r0.size() - 1).II0xO0();
        }

        public final xoXoI.oIX0oI<T> XO(float f) {
            List<? extends xoXoI.oIX0oI<T>> list = this.f33977oIX0oI;
            xoXoI.oIX0oI<T> oix0oi = list.get(list.size() - 1);
            if (f >= oix0oi.X0o0xo()) {
                return oix0oi;
            }
            for (int size = this.f33977oIX0oI.size() - 2; size >= 1; size--) {
                xoXoI.oIX0oI<T> oix0oi2 = this.f33977oIX0oI.get(size);
                if (this.f33976II0xO0 != oix0oi2 && oix0oi2.oIX0oI(f)) {
                    return oix0oi2;
                }
            }
            return this.f33977oIX0oI.get(0);
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public boolean isEmpty() {
            return false;
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        @NonNull
        public xoXoI.oIX0oI<T> oIX0oI() {
            return this.f33976II0xO0;
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public boolean oxoX(float f) {
            if (this.f33976II0xO0.oIX0oI(f)) {
                return !this.f33976II0xO0.II0XooXoX();
            }
            this.f33976II0xO0 = XO(f);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class XO<T> implements oxoX<T> {

        /* renamed from: II0xO0, reason: collision with root package name */
        public float f33979II0xO0 = -1.0f;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @NonNull
        public final xoXoI.oIX0oI<T> f33980oIX0oI;

        public XO(List<? extends xoXoI.oIX0oI<T>> list) {
            this.f33980oIX0oI = list.get(0);
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public boolean I0Io(float f) {
            if (this.f33979II0xO0 == f) {
                return true;
            }
            this.f33979II0xO0 = f;
            return false;
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public float II0xO0() {
            return this.f33980oIX0oI.X0o0xo();
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public float X0o0xo() {
            return this.f33980oIX0oI.II0xO0();
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public boolean isEmpty() {
            return false;
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public xoXoI.oIX0oI<T> oIX0oI() {
            return this.f33980oIX0oI;
        }

        @Override // x0XOIxOo.oIX0oI.oxoX
        public boolean oxoX(float f) {
            return !this.f33980oIX0oI.II0XooXoX();
        }
    }

    /* loaded from: classes.dex */
    public interface oxoX<T> {
        boolean I0Io(float f);

        @FloatRange(from = XIXIX.OOXIXo.f3760XO, to = 1.0d)
        float II0xO0();

        @FloatRange(from = XIXIX.OOXIXo.f3760XO, to = 1.0d)
        float X0o0xo();

        boolean isEmpty();

        xoXoI.oIX0oI<T> oIX0oI();

        boolean oxoX(float f);
    }

    public oIX0oI(List<? extends xoXoI.oIX0oI<K>> list) {
        this.f33967I0Io = oO(list);
    }

    public static <T> oxoX<T> oO(List<? extends xoXoI.oIX0oI<T>> list) {
        if (list.isEmpty()) {
            return new I0Io();
        }
        if (list.size() == 1) {
            return new XO(list);
        }
        return new X0o0xo(list);
    }

    @FloatRange(from = XIXIX.OOXIXo.f3760XO, to = 1.0d)
    public float I0Io() {
        if (this.f33968II0XooXoX == -1.0f) {
            this.f33968II0XooXoX = this.f33967I0Io.X0o0xo();
        }
        return this.f33968II0XooXoX;
    }

    public A II0XooXoX() {
        A xxIXOIIO2;
        float X0o0xo2 = X0o0xo();
        if (this.f33971X0o0xo == null && this.f33967I0Io.I0Io(X0o0xo2)) {
            return this.f33972XO;
        }
        xoXoI.oIX0oI<K> II0xO02 = II0xO0();
        Interpolator interpolator = II0xO02.f35169X0o0xo;
        if (interpolator != null && II0xO02.f35170XO != null) {
            xxIXOIIO2 = xoIox(II0xO02, X0o0xo2, interpolator.getInterpolation(X0o0xo2), II0xO02.f35170XO.getInterpolation(X0o0xo2));
        } else {
            xxIXOIIO2 = xxIXOIIO(II0xO02, oxoX());
        }
        this.f33972XO = xxIXOIIO2;
        return xxIXOIIO2;
    }

    public xoXoI.oIX0oI<K> II0xO0() {
        com.airbnb.lottie.X0o0xo.oIX0oI("BaseKeyframeAnimation#getCurrentKeyframe");
        xoXoI.oIX0oI<K> oIX0oI2 = this.f33967I0Io.oIX0oI();
        com.airbnb.lottie.X0o0xo.II0xO0("BaseKeyframeAnimation#getCurrentKeyframe");
        return oIX0oI2;
    }

    public void OOXIXo() {
        for (int i = 0; i < this.f33973oIX0oI.size(); i++) {
            this.f33973oIX0oI.get(i).oxoX();
        }
    }

    @FloatRange(from = XIXIX.OOXIXo.f3760XO, to = 1.0d)
    public final float Oxx0IOOO() {
        if (this.f33970Oxx0IOOO == -1.0f) {
            this.f33970Oxx0IOOO = this.f33967I0Io.II0xO0();
        }
        return this.f33970Oxx0IOOO;
    }

    public float X0o0xo() {
        if (this.f33969II0xO0) {
            return 0.0f;
        }
        xoXoI.oIX0oI<K> II0xO02 = II0xO0();
        if (II0xO02.II0XooXoX()) {
            return 0.0f;
        }
        return (this.f33974oxoX - II0xO02.X0o0xo()) / (II0xO02.II0xO0() - II0xO02.X0o0xo());
    }

    public float XO() {
        return this.f33974oxoX;
    }

    public void oIX0oI(II0xO0 iI0xO0) {
        this.f33973oIX0oI.add(iI0xO0);
    }

    public void oOoXoXO() {
        this.f33969II0xO0 = true;
    }

    public void ooOOo0oXI(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.f33967I0Io.isEmpty()) {
            return;
        }
        if (f < Oxx0IOOO()) {
            f = Oxx0IOOO();
        } else if (f > I0Io()) {
            f = I0Io();
        }
        if (f == this.f33974oxoX) {
            return;
        }
        this.f33974oxoX = f;
        if (this.f33967I0Io.oxoX(f)) {
            OOXIXo();
        }
    }

    public float oxoX() {
        xoXoI.oIX0oI<K> II0xO02 = II0xO0();
        if (II0xO02.II0XooXoX()) {
            return 0.0f;
        }
        return II0xO02.f35175oxoX.getInterpolation(X0o0xo());
    }

    public void x0XOIxOo(@Nullable xoXoI.xoIox<A> xoiox) {
        xoXoI.xoIox<A> xoiox2 = this.f33971X0o0xo;
        if (xoiox2 != null) {
            xoiox2.I0Io(null);
        }
        this.f33971X0o0xo = xoiox;
        if (xoiox != null) {
            xoiox.I0Io(this);
        }
    }

    public A xoIox(xoXoI.oIX0oI<K> oix0oi, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public abstract A xxIXOIIO(xoXoI.oIX0oI<K> oix0oi, float f);
}
