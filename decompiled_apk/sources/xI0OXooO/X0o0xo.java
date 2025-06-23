package xI0OXooO;

import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class X0o0xo<R> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final CharSequence f34126II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final oxoX<R> f34127oIX0oI;

    public X0o0xo(oxoX<R> oxox, CharSequence charSequence) {
        boolean z;
        if (oxox != null) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "The edit distance may not be null.", new Object[0]);
        this.f34127oIX0oI = oxox;
        this.f34126II0xO0 = charSequence;
    }

    public CharSequence I0Io() {
        return this.f34126II0xO0;
    }

    public oxoX<R> II0xO0() {
        return this.f34127oIX0oI;
    }

    public R oIX0oI(CharSequence charSequence) {
        return this.f34127oIX0oI.oIX0oI(this.f34126II0xO0, charSequence);
    }
}
