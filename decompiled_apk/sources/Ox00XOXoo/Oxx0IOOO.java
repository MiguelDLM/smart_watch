package Ox00XOXoo;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public abstract class Oxx0IOOO<T> implements xoIox<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final TypeVariable<Class<Oxx0IOOO>> f2751I0Io = Oxx0IOOO.class.getTypeParameters()[0];

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f2752II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Type f2753oIX0oI;

    public Oxx0IOOO() {
        Map<TypeVariable<?>, Type> xxX2 = xxIXOIIO.xxX(getClass(), Oxx0IOOO.class);
        TypeVariable<Class<Oxx0IOOO>> typeVariable = f2751I0Io;
        Type type = (Type) xoIxX.xo0x(xxX2.get(typeVariable), "%s does not assign type parameter %s", getClass(), xxIXOIIO.I0oOoX(typeVariable));
        this.f2753oIX0oI = type;
        this.f2752II0xO0 = String.format("%s<%s>", Oxx0IOOO.class.getSimpleName(), xxIXOIIO.XoX(type));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Oxx0IOOO)) {
            return false;
        }
        return xxIXOIIO.ooOOo0oXI(this.f2753oIX0oI, ((Oxx0IOOO) obj).f2753oIX0oI);
    }

    @Override // Ox00XOXoo.xoIox
    public Type getType() {
        return this.f2753oIX0oI;
    }

    public int hashCode() {
        return this.f2753oIX0oI.hashCode() | 592;
    }

    public String toString() {
        return this.f2752II0xO0;
    }
}
