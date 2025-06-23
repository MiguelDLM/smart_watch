package oO0IXx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public abstract class OxxIIOOXO implements xxX, com.univocity.parsers.common.Oxx0IOOO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Map<Class, Oxx0IOOO> f31887II0xO0 = new HashMap();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Oxx0IOOO[] f31888oIX0oI;

    /* loaded from: classes13.dex */
    public class oIX0oI extends Oxx0IOOO {

        /* renamed from: x0xO0oo, reason: collision with root package name */
        public final /* synthetic */ Class f31890x0xO0oo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public oIX0oI(Class cls, Class cls2) {
            super(cls);
            this.f31890x0xO0oo = cls2;
        }

        @Override // oO0IXx.Oxx0IOOO
        public void xII(Object obj, com.univocity.parsers.common.oO oOVar) {
            OxxIIOOXO.this.II0xO0(this.f31890x0xO0oo, obj, oOVar);
        }
    }

    public OxxIIOOXO(Class... clsArr) {
        com.univocity.parsers.common.I0Io.x0xO0oo("Bean types", clsArr);
        this.f31888oIX0oI = new Oxx0IOOO[clsArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            Class cls = clsArr[i];
            this.f31888oIX0oI[i] = new oIX0oI(cls, cls);
            this.f31887II0xO0.put(cls, this.f31888oIX0oI[i]);
        }
    }

    public <T> Oxx0IOOO<T> I0Io(Class<T> cls) {
        Oxx0IOOO<T> oxx0IOOO = this.f31887II0xO0.get(cls);
        if (oxx0IOOO != null) {
            return oxx0IOOO;
        }
        throw new IllegalArgumentException("No processor of type '" + cls.getName() + "' is available. Supported types are: " + this.f31887II0xO0.keySet());
    }

    public abstract void II0xO0(Class<?> cls, Object obj, com.univocity.parsers.common.oO oOVar);

    @Override // com.univocity.parsers.common.Oxx0IOOO
    public void X0o0xo(Class<?> cls, xXo.Oxx0IOOO... oxx0IOOOArr) {
        int i = 0;
        while (true) {
            Oxx0IOOO[] oxx0IOOOArr2 = this.f31888oIX0oI;
            if (i < oxx0IOOOArr2.length) {
                oxx0IOOOArr2[i].X0o0xo(cls, oxx0IOOOArr);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // oO0IXx.xxX
    public void XO(com.univocity.parsers.common.oO oOVar) {
        int i = 0;
        while (true) {
            Oxx0IOOO[] oxx0IOOOArr = this.f31888oIX0oI;
            if (i < oxx0IOOOArr.length) {
                oxx0IOOOArr[i].XO(oOVar);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.univocity.parsers.common.Oxx0IOOO
    public OXIOoo0X0.OOXIXo<Integer> oIX0oI(xXo.Oxx0IOOO... oxx0IOOOArr) {
        ArrayList arrayList = new ArrayList(this.f31888oIX0oI.length);
        int i = 0;
        while (true) {
            Oxx0IOOO[] oxx0IOOOArr2 = this.f31888oIX0oI;
            if (i < oxx0IOOOArr2.length) {
                arrayList.add(oxx0IOOOArr2[i].oIX0oI(oxx0IOOOArr));
                i++;
            } else {
                return new OXIOoo0X0.OOXIXo<>(arrayList);
            }
        }
    }

    @Override // oO0IXx.xxX
    public void oO(com.univocity.parsers.common.oO oOVar) {
        int i = 0;
        while (true) {
            Oxx0IOOO[] oxx0IOOOArr = this.f31888oIX0oI;
            if (i < oxx0IOOOArr.length) {
                oxx0IOOOArr[i].oO(oOVar);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.univocity.parsers.common.Oxx0IOOO
    public OXIOoo0X0.OOXIXo<String> oxoX(xXo.Oxx0IOOO... oxx0IOOOArr) {
        ArrayList arrayList = new ArrayList(this.f31888oIX0oI.length);
        int i = 0;
        while (true) {
            Oxx0IOOO[] oxx0IOOOArr2 = this.f31888oIX0oI;
            if (i < oxx0IOOOArr2.length) {
                arrayList.add(oxx0IOOOArr2[i].oxoX(oxx0IOOOArr));
                i++;
            } else {
                return new OXIOoo0X0.OOXIXo<>(arrayList);
            }
        }
    }

    @Override // oO0IXx.xxX
    public final void x0XOIxOo(String[] strArr, com.univocity.parsers.common.oO oOVar) {
        int i = 0;
        while (true) {
            Oxx0IOOO[] oxx0IOOOArr = this.f31888oIX0oI;
            if (i < oxx0IOOOArr.length) {
                oxx0IOOOArr[i].x0XOIxOo(strArr, oOVar);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.univocity.parsers.common.Oxx0IOOO
    public void x0xO0oo(xXo.Oxx0IOOO... oxx0IOOOArr) {
        int i = 0;
        while (true) {
            Oxx0IOOO[] oxx0IOOOArr2 = this.f31888oIX0oI;
            if (i < oxx0IOOOArr2.length) {
                oxx0IOOOArr2[i].x0xO0oo(oxx0IOOOArr);
                i++;
            } else {
                return;
            }
        }
    }
}
