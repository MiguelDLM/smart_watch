package kotlin.enums;

import OXOo.OOXIXo;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes6.dex */
public final class EnumEntriesSerializationProxy<E extends Enum<E>> implements Serializable {

    @OOXIXo
    private static final oIX0oI Companion = new oIX0oI(null);
    private static final long serialVersionUID = 0;

    @OOXIXo
    private final Class<E> c;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public EnumEntriesSerializationProxy(@OOXIXo E[] entries) {
        IIX0o.x0xO0oo(entries, "entries");
        Class<E> cls = (Class<E>) entries.getClass().getComponentType();
        IIX0o.ooOOo0oXI(cls);
        this.c = cls;
    }

    private final Object readResolve() {
        E[] enumConstants = this.c.getEnumConstants();
        IIX0o.oO(enumConstants, "getEnumConstants(...)");
        return I0Io.I0Io(enumConstants);
    }
}
