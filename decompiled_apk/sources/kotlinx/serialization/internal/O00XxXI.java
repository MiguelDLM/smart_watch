package kotlinx.serialization.internal;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlinx.serialization.SerializationException;

@kotlin.jvm.internal.XX({"SMAP\nPlatform.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,182:1\n1#2:183\n37#3,2:184\n1789#4,3:186\n*S KotlinDebug\n*F\n+ 1 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n*L\n75#1:184,2\n159#1:186,3\n*E\n"})
/* loaded from: classes6.dex */
public final class O00XxXI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO[] f30643oIX0oI = new kotlinx.serialization.descriptors.XO[0];

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    @kotlin.o0
    public static final <T> kotlinx.serialization.Oxx0IOOO<T> I0Io(@OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<?> oxx0IOOO) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO;
    }

    @OXOo.OOXIXo
    public static final String II0XooXoX(@OXOo.OOXIXo String className) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(className, "className");
        return "Serializer for class '" + className + "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    @kotlin.o0
    public static final <T> kotlinx.serialization.I0Io<T> II0xO0(@OXOo.OOXIXo kotlinx.serialization.I0Io<?> i0Io) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(i0Io, "<this>");
        return i0Io;
    }

    @OXOo.OOXIXo
    public static final kotlin.reflect.Oxx0xo OOXIXo(@OXOo.OOXIXo kotlin.reflect.OxxIIOOXO oxxIIOOXO) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxxIIOOXO, "<this>");
        kotlin.reflect.Oxx0xo Oxx0IOOO2 = oxxIIOOXO.Oxx0IOOO();
        if (Oxx0IOOO2 != null) {
            return Oxx0IOOO2;
        }
        throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + oxxIIOOXO.Oxx0IOOO()).toString());
    }

    @OXOo.OOXIXo
    public static final kotlin.reflect.oxoX<Object> Oxx0IOOO(@OXOo.OOXIXo kotlin.reflect.Oxx0xo oxx0xo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxx0xo, "<this>");
        kotlin.reflect.Oxx0IOOO IXxxXO2 = oxx0xo.IXxxXO();
        if (IXxxXO2 instanceof kotlin.reflect.oxoX) {
            return (kotlin.reflect.oxoX) IXxxXO2;
        }
        if (IXxxXO2 instanceof kotlin.reflect.oI0IIXIo) {
            throw new IllegalArgumentException("Captured type parameter " + IXxxXO2 + " from generic non-reified function. Such functionality cannot be supported because " + IXxxXO2 + " is erased, either specify serializer explicitly or make calling function inline with reified " + IXxxXO2 + '.');
        }
        throw new IllegalArgumentException("Only KClass supported as classifier, got " + IXxxXO2);
    }

    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO[] X0o0xo(@OXOo.oOoXoXO List<? extends kotlinx.serialization.descriptors.XO> list) {
        kotlinx.serialization.descriptors.XO[] xoArr;
        List<? extends kotlinx.serialization.descriptors.XO> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            list = null;
        }
        if (list == null || (xoArr = (kotlinx.serialization.descriptors.XO[]) list.toArray(new kotlinx.serialization.descriptors.XO[0])) == null) {
            return f30643oIX0oI;
        }
        return xoArr;
    }

    public static final <T, K> int XO(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> selector) {
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            int i3 = i2 * 31;
            K invoke = selector.invoke(it.next());
            if (invoke != null) {
                i = invoke.hashCode();
            } else {
                i = 0;
            }
            i2 = i3 + i;
        }
        return i2;
    }

    @OXOo.OOXIXo
    public static final Set<String> oIX0oI(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO xo2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xo2, "<this>");
        if (xo2 instanceof x0XOIxOo) {
            return ((x0XOIxOo) xo2).II0xO0();
        }
        HashSet hashSet = new HashSet(xo2.XO());
        int XO2 = xo2.XO();
        for (int i = 0; i < XO2; i++) {
            hashSet.add(xo2.Oxx0IOOO(i));
        }
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    @kotlin.o0
    public static final <T> kotlinx.serialization.Oxx0xo<T> oxoX(@OXOo.OOXIXo kotlinx.serialization.Oxx0xo<?> oxx0xo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxx0xo, "<this>");
        return oxx0xo;
    }

    @OXOo.OOXIXo
    public static final Void xoIox(@OXOo.OOXIXo kotlin.reflect.oxoX<?> oxox) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxox, "<this>");
        throw new SerializationException(xxIXOIIO(oxox));
    }

    @OXOo.OOXIXo
    public static final String xxIXOIIO(@OXOo.OOXIXo kotlin.reflect.oxoX<?> oxox) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxox, "<this>");
        String xoXoI2 = oxox.xoXoI();
        if (xoXoI2 == null) {
            xoXoI2 = "<local class name not available>";
        }
        return II0XooXoX(xoXoI2);
    }
}
