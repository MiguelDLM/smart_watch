package kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.Iterator;

@kotlin.jvm.internal.XX({"SMAP\nPluginGeneratedSerialDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginGeneratedSerialDescriptor.kt\nkotlinx/serialization/internal/PluginGeneratedSerialDescriptorKt\n+ 2 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n159#2:135\n159#2:139\n1789#3,3:136\n1789#3,3:140\n*S KotlinDebug\n*F\n+ 1 PluginGeneratedSerialDescriptor.kt\nkotlinx/serialization/internal/PluginGeneratedSerialDescriptorKt\n*L\n128#1:135\n129#1:139\n128#1:136,3\n129#1:140,3\n*E\n"})
/* loaded from: classes6.dex */
public final class OOXIxO0 {
    public static final int II0xO0(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO xo2, @OXOo.OOXIXo kotlinx.serialization.descriptors.XO[] typeParams) {
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xo2, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(typeParams, "typeParams");
        int hashCode = (xo2.xxIXOIIO().hashCode() * 31) + Arrays.hashCode(typeParams);
        Iterable<kotlinx.serialization.descriptors.XO> oIX0oI2 = kotlinx.serialization.descriptors.Oxx0IOOO.oIX0oI(xo2);
        Iterator<kotlinx.serialization.descriptors.XO> it = oIX0oI2.iterator();
        int i2 = 1;
        int i3 = 1;
        while (true) {
            int i4 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i5 = i3 * 31;
            String xxIXOIIO2 = it.next().xxIXOIIO();
            if (xxIXOIIO2 != null) {
                i4 = xxIXOIIO2.hashCode();
            }
            i3 = i5 + i4;
        }
        Iterator<kotlinx.serialization.descriptors.XO> it2 = oIX0oI2.iterator();
        while (it2.hasNext()) {
            int i6 = i2 * 31;
            kotlinx.serialization.descriptors.II0XooXoX oIX0oI3 = it2.next().oIX0oI();
            if (oIX0oI3 != null) {
                i = oIX0oI3.hashCode();
            } else {
                i = 0;
            }
            i2 = i6 + i;
        }
        return (((hashCode * 31) + i3) * 31) + i2;
    }

    public static final /* synthetic */ <SD extends kotlinx.serialization.descriptors.XO> boolean oIX0oI(SD sd, Object obj, Oox.oOoXoXO<? super SD, Boolean> typeParamsAreEqual) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sd, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(typeParamsAreEqual, "typeParamsAreEqual");
        if (sd == obj) {
            return true;
        }
        kotlin.jvm.internal.IIX0o.OxI(3, "SD");
        if (!(obj instanceof kotlinx.serialization.descriptors.XO)) {
            return false;
        }
        kotlinx.serialization.descriptors.XO xo2 = (kotlinx.serialization.descriptors.XO) obj;
        if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(sd.xxIXOIIO(), xo2.xxIXOIIO()) || !typeParamsAreEqual.invoke(obj).booleanValue() || sd.XO() != xo2.XO()) {
            return false;
        }
        int XO2 = sd.XO();
        for (int i = 0; i < XO2; i++) {
            if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(sd.X0o0xo(i).xxIXOIIO(), xo2.X0o0xo(i).xxIXOIIO()) || !kotlin.jvm.internal.IIX0o.Oxx0IOOO(sd.X0o0xo(i).oIX0oI(), xo2.X0o0xo(i).oIX0oI())) {
                return false;
            }
        }
        return true;
    }
}
