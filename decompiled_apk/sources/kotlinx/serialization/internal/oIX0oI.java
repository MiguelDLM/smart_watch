package kotlinx.serialization.internal;

import java.util.Iterator;

@kotlinx.serialization.XO
/* loaded from: classes6.dex */
public abstract class oIX0oI<Element, Collection, Builder> implements kotlinx.serialization.Oxx0IOOO<Collection> {
    public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
        this();
    }

    public static /* synthetic */ void x0XOIxOo(oIX0oI oix0oi, xIXoO0Xx.oxoX oxox, int i, Object obj, boolean z, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 8) != 0) {
                z = true;
            }
            oix0oi.ooOOo0oXI(oxox, i, obj, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
    }

    public abstract void II0XooXoX(Builder builder, int i);

    @Override // kotlinx.serialization.Oxx0xo
    public abstract void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX iI0XooXoX, Collection collection);

    @kotlinx.serialization.XO
    public final Collection OOXIXo(@OXOo.OOXIXo xIXoO0Xx.XO decoder, @OXOo.oOoXoXO Collection collection) {
        Builder XO2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        if (collection == null || (XO2 = x0xO0oo(collection)) == null) {
            XO2 = XO();
        }
        int Oxx0IOOO2 = Oxx0IOOO(XO2);
        xIXoO0Xx.oxoX beginStructure = decoder.beginStructure(oIX0oI());
        if (!beginStructure.decodeSequentially()) {
            while (true) {
                int decodeElementIndex = beginStructure.decodeElementIndex(oIX0oI());
                if (decodeElementIndex == -1) {
                    break;
                }
                x0XOIxOo(this, beginStructure, Oxx0IOOO2 + decodeElementIndex, XO2, false, 8, null);
            }
        } else {
            oOoXoXO(beginStructure, XO2, Oxx0IOOO2, oO(beginStructure, XO2));
        }
        beginStructure.endStructure(oIX0oI());
        return Oo(XO2);
    }

    public abstract Collection Oo(Builder builder);

    public abstract int Oxx0IOOO(Builder builder);

    public abstract Builder XO();

    public final int oO(xIXoO0Xx.oxoX oxox, Builder builder) {
        int decodeCollectionSize = oxox.decodeCollectionSize(oIX0oI());
        II0XooXoX(builder, decodeCollectionSize);
        return decodeCollectionSize;
    }

    public abstract void oOoXoXO(@OXOo.OOXIXo xIXoO0Xx.oxoX oxox, Builder builder, int i, int i2);

    public abstract void ooOOo0oXI(@OXOo.OOXIXo xIXoO0Xx.oxoX oxox, int i, Builder builder, boolean z);

    @Override // kotlinx.serialization.I0Io
    public Collection oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        return OOXIXo(decoder, null);
    }

    public abstract Builder x0xO0oo(Collection collection);

    public abstract int xoIox(Collection collection);

    @OXOo.OOXIXo
    public abstract Iterator<Element> xxIXOIIO(Collection collection);

    public oIX0oI() {
    }
}
