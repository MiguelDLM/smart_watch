package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;

/* loaded from: classes6.dex */
public final class I0oOoX implements kotlin.reflect.Oxx0xo {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.reflect.Oxx0xo f30624XO;

    public I0oOoX(@OXOo.OOXIXo kotlin.reflect.Oxx0xo origin) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(origin, "origin");
        this.f30624XO = origin;
    }

    @Override // kotlin.reflect.Oxx0xo
    @OXOo.oOoXoXO
    public kotlin.reflect.Oxx0IOOO IXxxXO() {
        return this.f30624XO.IXxxXO();
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        I0oOoX i0oOoX;
        kotlin.reflect.Oxx0xo oxx0xo;
        kotlin.reflect.Oxx0xo oxx0xo2;
        if (obj == null) {
            return false;
        }
        kotlin.reflect.Oxx0xo oxx0xo3 = this.f30624XO;
        kotlin.reflect.Oxx0IOOO oxx0IOOO = null;
        if (obj instanceof I0oOoX) {
            i0oOoX = (I0oOoX) obj;
        } else {
            i0oOoX = null;
        }
        if (i0oOoX != null) {
            oxx0xo = i0oOoX.f30624XO;
        } else {
            oxx0xo = null;
        }
        if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(oxx0xo3, oxx0xo)) {
            return false;
        }
        kotlin.reflect.Oxx0IOOO IXxxXO2 = IXxxXO();
        if (IXxxXO2 instanceof kotlin.reflect.oxoX) {
            if (obj instanceof kotlin.reflect.Oxx0xo) {
                oxx0xo2 = (kotlin.reflect.Oxx0xo) obj;
            } else {
                oxx0xo2 = null;
            }
            if (oxx0xo2 != null) {
                oxx0IOOO = oxx0xo2.IXxxXO();
            }
            if (oxx0IOOO != null && (oxx0IOOO instanceof kotlin.reflect.oxoX)) {
                return kotlin.jvm.internal.IIX0o.Oxx0IOOO(XO0OX.II0xO0.X0o0xo((kotlin.reflect.oxoX) IXxxXO2), XO0OX.II0xO0.X0o0xo((kotlin.reflect.oxoX) oxx0IOOO));
            }
        }
        return false;
    }

    @Override // kotlin.reflect.II0xO0
    @OXOo.OOXIXo
    public List<Annotation> getAnnotations() {
        return this.f30624XO.getAnnotations();
    }

    @Override // kotlin.reflect.Oxx0xo
    @OXOo.OOXIXo
    public List<kotlin.reflect.OxxIIOOXO> getArguments() {
        return this.f30624XO.getArguments();
    }

    public int hashCode() {
        return this.f30624XO.hashCode();
    }

    @Override // kotlin.reflect.Oxx0xo
    public boolean ooOOo0oXI() {
        return this.f30624XO.ooOOo0oXI();
    }

    @OXOo.OOXIXo
    public String toString() {
        return "KTypeWrapper: " + this.f30624XO;
    }
}
