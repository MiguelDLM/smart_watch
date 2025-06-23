package kotlinx.serialization.internal;

@kotlinx.serialization.XO
/* loaded from: classes6.dex */
public abstract class IoOoo extends TaggedDecoder<String> {
    @OXOo.OOXIXo
    public final String O0xOxO(@OXOo.OOXIXo String nestedName) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(nestedName, "nestedName");
        String IXxxXO2 = IXxxXO();
        if (IXxxXO2 == null) {
            IXxxXO2 = "";
        }
        return xoXoI(IXxxXO2, nestedName);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    @OXOo.OOXIXo
    /* renamed from: OxI, reason: merged with bridge method [inline-methods] */
    public final String Oxx0xo(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO xo2, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xo2, "<this>");
        return O0xOxO(o00(xo2, i));
    }

    @OXOo.OOXIXo
    public String o00(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return descriptor.Oxx0IOOO(i);
    }

    @OXOo.OOXIXo
    public String xoXoI(@OXOo.OOXIXo String parentName, @OXOo.OOXIXo String childName) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(parentName, "parentName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(childName, "childName");
        if (parentName.length() != 0) {
            return parentName + '.' + childName;
        }
        return childName;
    }
}
