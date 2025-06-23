package kotlinx.serialization.descriptors;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.serialization.internal.oXIO0o0XI;

@XX({"SMAP\nContextAware.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextAware.kt\nkotlinx/serialization/descriptors/ContextAwareKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,111:1\n1#2:112\n1549#3:113\n1620#3,3:114\n*S KotlinDebug\n*F\n+ 1 ContextAware.kt\nkotlinx/serialization/descriptors/ContextAwareKt\n*L\n76#1:113\n76#1:114,3\n*E\n"})
/* loaded from: classes6.dex */
public final class II0xO0 {
    @kotlinx.serialization.oxoX
    @oOoXoXO
    public static final XO I0Io(@OOXIXo kotlinx.serialization.modules.X0o0xo x0o0xo, @OOXIXo XO descriptor) {
        kotlinx.serialization.Oxx0IOOO oxoX2;
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.x0xO0oo(descriptor, "descriptor");
        kotlin.reflect.oxoX<?> oIX0oI2 = oIX0oI(descriptor);
        if (oIX0oI2 == null || (oxoX2 = kotlinx.serialization.modules.X0o0xo.oxoX(x0o0xo, oIX0oI2, null, 2, null)) == null) {
            return null;
        }
        return oxoX2.oIX0oI();
    }

    @kotlinx.serialization.oxoX
    public static /* synthetic */ void II0xO0(XO xo2) {
    }

    @OOXIXo
    public static final XO X0o0xo(@OOXIXo XO xo2, @OOXIXo kotlin.reflect.oxoX<?> context) {
        IIX0o.x0xO0oo(xo2, "<this>");
        IIX0o.x0xO0oo(context, "context");
        return new I0Io(xo2, context);
    }

    @oOoXoXO
    public static final kotlin.reflect.oxoX<?> oIX0oI(@OOXIXo XO xo2) {
        IIX0o.x0xO0oo(xo2, "<this>");
        if (xo2 instanceof I0Io) {
            return ((I0Io) xo2).f30565II0xO0;
        }
        if (xo2 instanceof oXIO0o0XI) {
            return oIX0oI(((oXIO0o0XI) xo2).OOXIXo());
        }
        return null;
    }

    @kotlinx.serialization.oxoX
    @OOXIXo
    public static final List<XO> oxoX(@OOXIXo kotlinx.serialization.modules.X0o0xo x0o0xo, @OOXIXo XO descriptor) {
        List list;
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.x0xO0oo(descriptor, "descriptor");
        kotlin.reflect.oxoX<?> oIX0oI2 = oIX0oI(descriptor);
        if (oIX0oI2 == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        Map<kotlin.reflect.oxoX<?>, kotlinx.serialization.Oxx0IOOO<?>> map = ((kotlinx.serialization.modules.oxoX) x0o0xo).f30793II0xO0.get(oIX0oI2);
        if (map != null) {
            list = map.values();
        } else {
            list = null;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        Collection<kotlinx.serialization.Oxx0IOOO<?>> collection = list;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlinx.serialization.Oxx0IOOO) it.next()).oIX0oI());
        }
        return arrayList;
    }
}
