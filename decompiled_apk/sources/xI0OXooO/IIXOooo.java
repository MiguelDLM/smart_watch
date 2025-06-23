package xI0OXooO;

import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class IIXOooo<R> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final CharSequence f34123II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final OxxIIOOXO<R> f34124oIX0oI;

    public IIXOooo(OxxIIOOXO<R> oxxIIOOXO, CharSequence charSequence) {
        boolean z;
        if (oxxIIOOXO != null) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "The edit distance may not be null.", new Object[0]);
        this.f34124oIX0oI = oxxIIOOXO;
        this.f34123II0xO0 = charSequence;
    }

    public OxxIIOOXO<R> I0Io() {
        return this.f34124oIX0oI;
    }

    public CharSequence II0xO0() {
        return this.f34123II0xO0;
    }

    public R oIX0oI(CharSequence charSequence) {
        return this.f34124oIX0oI.oIX0oI(this.f34123II0xO0, charSequence);
    }
}
