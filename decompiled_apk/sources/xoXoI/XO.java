package xoXoI;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public abstract class XO<T> extends xoIox<T> {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final T f35159X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final Interpolator f35160XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public final T f35161oxoX;

    public XO(T t, T t2) {
        this(t, t2, new LinearInterpolator());
    }

    public abstract T X0o0xo(T t, T t2, float f);

    @Override // xoXoI.xoIox
    public T oIX0oI(II0xO0<T> iI0xO0) {
        return X0o0xo(this.f35161oxoX, this.f35159X0o0xo, this.f35160XO.getInterpolation(iI0xO0.X0o0xo()));
    }

    public XO(T t, T t2, Interpolator interpolator) {
        this.f35161oxoX = t;
        this.f35159X0o0xo = t2;
        this.f35160XO = interpolator;
    }
}
