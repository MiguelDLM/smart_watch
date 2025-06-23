package oO0IXx;

import java.util.Collections;
import java.util.List;

/* loaded from: classes13.dex */
public class Oxx0xo implements Cloneable {

    /* renamed from: XO, reason: collision with root package name */
    public Object[] f31886XO = null;

    /* renamed from: Oo, reason: collision with root package name */
    public List<Object[]> f31885Oo = Collections.emptyList();

    public List<Object[]> I0Io() {
        return this.f31885Oo;
    }

    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public Oxx0xo clone() {
        try {
            return (Oxx0xo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.getMessage());
        }
    }

    public void X0o0xo(List<Object[]> list) {
        this.f31885Oo = list;
    }

    public void XO(Object[] objArr) {
        this.f31886XO = objArr;
    }

    public void oIX0oI() {
        this.f31885Oo = Collections.emptyList();
        this.f31886XO = null;
    }

    public Object[] oxoX() {
        return this.f31886XO;
    }
}
