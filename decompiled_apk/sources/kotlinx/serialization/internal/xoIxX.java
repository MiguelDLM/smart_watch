package kotlinx.serialization.internal;

@kotlinx.serialization.XO
/* loaded from: classes6.dex */
public abstract class xoIxX extends oxIIX0o<String> {
    @OXOo.OOXIXo
    public String IIXOooo(@OXOo.OOXIXo String parentName, @OXOo.OOXIXo String childName) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(parentName, "parentName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(childName, "childName");
        if (parentName.length() != 0) {
            return parentName + '.' + childName;
        }
        return childName;
    }

    @OXOo.OOXIXo
    public final String OxI(@OXOo.OOXIXo String nestedName) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(nestedName, "nestedName");
        String IXxxXO2 = IXxxXO();
        if (IXxxXO2 == null) {
            IXxxXO2 = "";
        }
        return IIXOooo(IXxxXO2, nestedName);
    }

    @Override // kotlinx.serialization.internal.oxIIX0o
    @OXOo.OOXIXo
    /* renamed from: o00, reason: merged with bridge method [inline-methods] */
    public final String Oxx0xo(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO xo2, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xo2, "<this>");
        return OxI(xoXoI(xo2, i));
    }

    @OXOo.OOXIXo
    public String xoXoI(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return descriptor.Oxx0IOOO(i);
    }
}
