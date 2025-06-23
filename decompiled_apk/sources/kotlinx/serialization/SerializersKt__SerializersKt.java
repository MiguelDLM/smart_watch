package kotlinx.serialization;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlinx.serialization.internal.O00XxXI;
import kotlinx.serialization.internal.X00IoxXI;
import kotlinx.serialization.internal.o0xxxXXxX;
import kotlinx.serialization.internal.oOXoIIIo;
import kotlinx.serialization.internal.oxXx0IX;
import kotlinx.serialization.internal.xOOOX;
import kotlinx.serialization.internal.xXOx;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

@XX({"SMAP\nSerializers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Serializers.kt\nkotlinx/serialization/SerializersKt__SerializersKt\n+ 2 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,379:1\n79#2:380\n79#2:381\n79#2:387\n79#2:388\n1549#3:382\n1620#3,3:383\n1549#3:389\n1620#3,3:390\n1549#3:393\n1620#3,3:394\n1#4:386\n37#5,2:397\n*S KotlinDebug\n*F\n+ 1 Serializers.kt\nkotlinx/serialization/SerializersKt__SerializersKt\n*L\n35#1:380\n54#1:381\n211#1:387\n235#1:388\n190#1:382\n190#1:383,3\n246#1:389\n246#1:390,3\n248#1:393\n248#1:394,3\n313#1:397,2\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class SerializersKt__SerializersKt {
    @OXOo.OOXIXo
    @o0
    public static final Oxx0IOOO<?> I0Io(@OXOo.OOXIXo String forClass) {
        IIX0o.x0xO0oo(forClass, "forClass");
        throw new SerializationException(O00XxXI.II0XooXoX(forClass));
    }

    public static final /* synthetic */ <T> Oxx0IOOO<T> II0XooXoX() {
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        Oxx0IOOO<T> oxx0IOOO = (Oxx0IOOO<T>) OxxIIOOXO.xxIXOIIO(null);
        IIX0o.x0XOIxOo(oxx0IOOO, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return oxx0IOOO;
    }

    public static final Oxx0IOOO<? extends Object> II0xO0(kotlin.reflect.oxoX<Object> oxox, List<? extends Oxx0IOOO<Object>> list) {
        Oxx0IOOO[] oxx0IOOOArr = (Oxx0IOOO[]) list.toArray(new Oxx0IOOO[0]);
        return o0xxxXXxX.oxoX(oxox, (Oxx0IOOO[]) Arrays.copyOf(oxx0IOOOArr, oxx0IOOOArr.length));
    }

    @OXOo.oOoXoXO
    public static final Oxx0IOOO<Object> IXxxXO(@OXOo.OOXIXo kotlin.reflect.Oxx0xo type) {
        IIX0o.x0xO0oo(type, "type");
        return OxxIIOOXO.IXxxXO(SerializersModuleBuildersKt.oIX0oI(), type);
    }

    @OXOo.OOXIXo
    public static final Oxx0IOOO<Object> OOXIXo(@OXOo.OOXIXo kotlin.reflect.Oxx0xo type) {
        IIX0o.x0xO0oo(type, "type");
        return OxxIIOOXO.ooOOo0oXI(SerializersModuleBuildersKt.oIX0oI(), type);
    }

    @XO
    @OXOo.oOoXoXO
    public static final <T> Oxx0IOOO<T> Oo(@OXOo.OOXIXo kotlin.reflect.oxoX<T> oxox) {
        IIX0o.x0xO0oo(oxox, "<this>");
        Oxx0IOOO<T> II0xO02 = o0xxxXXxX.II0xO0(oxox);
        if (II0xO02 == null) {
            return xOOOX.II0xO0(oxox);
        }
        return II0xO02;
    }

    @OXOo.oOoXoXO
    public static final Oxx0IOOO<? extends Object> Oxx0IOOO(@OXOo.OOXIXo kotlin.reflect.oxoX<Object> oxox, @OXOo.OOXIXo List<? extends Oxx0IOOO<Object>> serializers, @OXOo.OOXIXo Oox.oIX0oI<? extends kotlin.reflect.Oxx0IOOO> elementClassifierIfArray) {
        IIX0o.x0xO0oo(oxox, "<this>");
        IIX0o.x0xO0oo(serializers, "serializers");
        IIX0o.x0xO0oo(elementClassifierIfArray, "elementClassifierIfArray");
        Oxx0IOOO<? extends Object> oIX0oI2 = oIX0oI(oxox, serializers, elementClassifierIfArray);
        if (oIX0oI2 == null) {
            return II0xO0(oxox, serializers);
        }
        return oIX0oI2;
    }

    @OXOo.oOoXoXO
    public static final Oxx0IOOO<Object> Oxx0xo(@OXOo.OOXIXo kotlinx.serialization.modules.X0o0xo x0o0xo, @OXOo.OOXIXo kotlin.reflect.Oxx0xo type) {
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.x0xO0oo(type, "type");
        return x0xO0oo(x0o0xo, type, false);
    }

    @OXOo.OOXIXo
    @o0
    public static final Oxx0IOOO<?> X0o0xo(@OXOo.OOXIXo kotlinx.serialization.modules.X0o0xo module, @OXOo.OOXIXo kotlin.reflect.oxoX<?> kClass, @OXOo.OOXIXo Oxx0IOOO<?>[] argSerializers) {
        IIX0o.x0xO0oo(module, "module");
        IIX0o.x0xO0oo(kClass, "kClass");
        IIX0o.x0xO0oo(argSerializers, "argSerializers");
        Oxx0IOOO<?> I0Io2 = module.I0Io(kClass, kotlin.collections.ooOOo0oXI.oI0IIXIo(argSerializers));
        if (I0Io2 != null) {
            return I0Io2;
        }
        O00XxXI.xoIox(kClass);
        throw new KotlinNothingValueException();
    }

    public static final <T> Oxx0IOOO<T> XO(Oxx0IOOO<T> oxx0IOOO, boolean z) {
        if (z) {
            return xx.oOoXoXO.IIXOooo(oxx0IOOO);
        }
        IIX0o.x0XOIxOo(oxx0IOOO, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return oxx0IOOO;
    }

    @OXOo.oOoXoXO
    public static final List<Oxx0IOOO<Object>> oI0IIXIo(@OXOo.OOXIXo kotlinx.serialization.modules.X0o0xo x0o0xo, @OXOo.OOXIXo List<? extends kotlin.reflect.Oxx0xo> typeArguments, boolean z) {
        ArrayList arrayList;
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.x0xO0oo(typeArguments, "typeArguments");
        if (z) {
            List<? extends kotlin.reflect.Oxx0xo> list = typeArguments;
            arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(OxxIIOOXO.ooOOo0oXI(x0o0xo, (kotlin.reflect.Oxx0xo) it.next()));
            }
        } else {
            List<? extends kotlin.reflect.Oxx0xo> list2 = typeArguments;
            arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                Oxx0IOOO<Object> IXxxXO2 = OxxIIOOXO.IXxxXO(x0o0xo, (kotlin.reflect.Oxx0xo) it2.next());
                if (IXxxXO2 == null) {
                    return null;
                }
                arrayList.add(IXxxXO2);
            }
        }
        return arrayList;
    }

    public static final Oxx0IOOO<? extends Object> oIX0oI(kotlin.reflect.oxoX<Object> oxox, List<? extends Oxx0IOOO<Object>> list, Oox.oIX0oI<? extends kotlin.reflect.Oxx0IOOO> oix0oi) {
        boolean Oxx0IOOO2;
        boolean Oxx0IOOO3;
        boolean Oxx0IOOO4;
        boolean Oxx0IOOO5;
        boolean Oxx0IOOO6;
        boolean Oxx0IOOO7;
        boolean Oxx0IOOO8;
        if (IIX0o.Oxx0IOOO(oxox, IO.oxoX(Collection.class))) {
            Oxx0IOOO2 = true;
        } else {
            Oxx0IOOO2 = IIX0o.Oxx0IOOO(oxox, IO.oxoX(List.class));
        }
        if (Oxx0IOOO2) {
            Oxx0IOOO3 = true;
        } else {
            Oxx0IOOO3 = IIX0o.Oxx0IOOO(oxox, IO.oxoX(List.class));
        }
        if (Oxx0IOOO3) {
            Oxx0IOOO4 = true;
        } else {
            Oxx0IOOO4 = IIX0o.Oxx0IOOO(oxox, IO.oxoX(ArrayList.class));
        }
        if (Oxx0IOOO4) {
            return new kotlinx.serialization.internal.XO(list.get(0));
        }
        if (IIX0o.Oxx0IOOO(oxox, IO.oxoX(HashSet.class))) {
            return new X00IoxXI(list.get(0));
        }
        if (IIX0o.Oxx0IOOO(oxox, IO.oxoX(Set.class))) {
            Oxx0IOOO5 = true;
        } else {
            Oxx0IOOO5 = IIX0o.Oxx0IOOO(oxox, IO.oxoX(Set.class));
        }
        if (Oxx0IOOO5) {
            Oxx0IOOO6 = true;
        } else {
            Oxx0IOOO6 = IIX0o.Oxx0IOOO(oxox, IO.oxoX(LinkedHashSet.class));
        }
        if (Oxx0IOOO6) {
            return new xXOx(list.get(0));
        }
        if (IIX0o.Oxx0IOOO(oxox, IO.oxoX(HashMap.class))) {
            return new oOXoIIIo(list.get(0), list.get(1));
        }
        if (IIX0o.Oxx0IOOO(oxox, IO.oxoX(Map.class))) {
            Oxx0IOOO7 = true;
        } else {
            Oxx0IOOO7 = IIX0o.Oxx0IOOO(oxox, IO.oxoX(Map.class));
        }
        if (Oxx0IOOO7) {
            Oxx0IOOO8 = true;
        } else {
            Oxx0IOOO8 = IIX0o.Oxx0IOOO(oxox, IO.oxoX(LinkedHashMap.class));
        }
        if (Oxx0IOOO8) {
            return new oxXx0IX(list.get(0), list.get(1));
        }
        if (IIX0o.Oxx0IOOO(oxox, IO.oxoX(Map.Entry.class))) {
            return xx.oOoXoXO.OOXIXo(list.get(0), list.get(1));
        }
        if (IIX0o.Oxx0IOOO(oxox, IO.oxoX(Pair.class))) {
            return xx.oOoXoXO.x0XOIxOo(list.get(0), list.get(1));
        }
        if (IIX0o.Oxx0IOOO(oxox, IO.oxoX(Triple.class))) {
            return xx.oOoXoXO.Oo(list.get(0), list.get(1), list.get(2));
        }
        if (o0xxxXXxX.x0xO0oo(oxox)) {
            kotlin.reflect.Oxx0IOOO invoke = oix0oi.invoke();
            IIX0o.x0XOIxOo(invoke, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            return xx.oOoXoXO.oIX0oI((kotlin.reflect.oxoX) invoke, list.get(0));
        }
        return null;
    }

    public static final Oxx0IOOO<Object> oO(kotlinx.serialization.modules.X0o0xo x0o0xo, kotlin.reflect.oxoX<Object> oxox, List<? extends Oxx0IOOO<Object>> list, boolean z) {
        Oxx0IOOO<? extends Object> oxx0IOOO;
        if (list.isEmpty()) {
            oxx0IOOO = OxxIIOOXO.oO(oxox);
            if (oxx0IOOO == null) {
                oxx0IOOO = kotlinx.serialization.modules.X0o0xo.oxoX(x0o0xo, oxox, null, 2, null);
            }
        } else {
            try {
                Oxx0IOOO<? extends Object> oxoX2 = OxxIIOOXO.oxoX(oxox, list, new Oox.oIX0oI<kotlin.reflect.Oxx0IOOO>() { // from class: kotlinx.serialization.SerializersKt__SerializersKt$serializerByKClassImpl$serializer$1
                    @Override // Oox.oIX0oI
                    @OXOo.oOoXoXO
                    public final kotlin.reflect.Oxx0IOOO invoke() {
                        throw new SerializationException("It is not possible to retrieve an array serializer using KClass alone, use KType instead or ArraySerializer factory");
                    }
                });
                if (oxoX2 == null) {
                    oxx0IOOO = x0o0xo.I0Io(oxox, list);
                } else {
                    oxx0IOOO = oxoX2;
                }
            } catch (IndexOutOfBoundsException e) {
                throw new SerializationException("Unable to retrieve a serializer, the number of passed type serializers differs from the actual number of generic parameters", e);
            }
        }
        if (oxx0IOOO == null) {
            return null;
        }
        return XO(oxx0IOOO, z);
    }

    public static final /* synthetic */ <T> Oxx0IOOO<T> oOoXoXO(kotlinx.serialization.modules.X0o0xo x0o0xo) {
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        Oxx0IOOO<T> oxx0IOOO = (Oxx0IOOO<T>) OxxIIOOXO.ooOOo0oXI(x0o0xo, null);
        IIX0o.x0XOIxOo(oxx0IOOO, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return oxx0IOOO;
    }

    @oxoX
    @OXOo.OOXIXo
    public static final Oxx0IOOO<Object> ooOOo0oXI(@OXOo.OOXIXo kotlinx.serialization.modules.X0o0xo x0o0xo, @OXOo.OOXIXo kotlin.reflect.oxoX<?> kClass, @OXOo.OOXIXo List<? extends Oxx0IOOO<?>> typeArgumentsSerializers, boolean z) {
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.x0xO0oo(kClass, "kClass");
        IIX0o.x0xO0oo(typeArgumentsSerializers, "typeArgumentsSerializers");
        Oxx0IOOO<Object> oO2 = oO(x0o0xo, kClass, typeArgumentsSerializers, z);
        if (oO2 != null) {
            return oO2;
        }
        o0xxxXXxX.Oo(kClass);
        throw new KotlinNothingValueException();
    }

    @OXOo.OOXIXo
    @o0
    public static final Oxx0IOOO<?> oxoX(@OXOo.OOXIXo kotlinx.serialization.modules.X0o0xo module, @OXOo.OOXIXo kotlin.reflect.oxoX<?> kClass) {
        IIX0o.x0xO0oo(module, "module");
        IIX0o.x0xO0oo(kClass, "kClass");
        Oxx0IOOO<?> oxoX2 = kotlinx.serialization.modules.X0o0xo.oxoX(module, kClass, null, 2, null);
        if (oxoX2 != null) {
            return oxoX2;
        }
        O00XxXI.xoIox(kClass);
        throw new KotlinNothingValueException();
    }

    @OXOo.OOXIXo
    public static final Oxx0IOOO<Object> x0XOIxOo(@OXOo.OOXIXo kotlinx.serialization.modules.X0o0xo x0o0xo, @OXOo.OOXIXo kotlin.reflect.Oxx0xo type) {
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.x0xO0oo(type, "type");
        Oxx0IOOO<Object> x0xO0oo2 = x0xO0oo(x0o0xo, type, true);
        if (x0xO0oo2 != null) {
            return x0xO0oo2;
        }
        o0xxxXXxX.Oo(O00XxXI.Oxx0IOOO(type));
        throw new KotlinNothingValueException();
    }

    public static final Oxx0IOOO<Object> x0xO0oo(kotlinx.serialization.modules.X0o0xo x0o0xo, kotlin.reflect.Oxx0xo oxx0xo, boolean z) {
        Oxx0IOOO<Object> oxx0IOOO;
        Oxx0IOOO<? extends Object> oxx0IOOO2;
        kotlin.reflect.oxoX<Object> Oxx0IOOO2 = O00XxXI.Oxx0IOOO(oxx0xo);
        boolean ooOOo0oXI2 = oxx0xo.ooOOo0oXI();
        List<kotlin.reflect.OxxIIOOXO> arguments = oxx0xo.getArguments();
        final ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(arguments, 10));
        Iterator<T> it = arguments.iterator();
        while (it.hasNext()) {
            arrayList.add(O00XxXI.OOXIXo((kotlin.reflect.OxxIIOOXO) it.next()));
        }
        if (arrayList.isEmpty()) {
            oxx0IOOO = SerializersCacheKt.oIX0oI(Oxx0IOOO2, ooOOo0oXI2);
        } else {
            Object II0xO02 = SerializersCacheKt.II0xO0(Oxx0IOOO2, arrayList, ooOOo0oXI2);
            if (Result.m293isFailureimpl(II0xO02)) {
                II0xO02 = null;
            }
            oxx0IOOO = (Oxx0IOOO) II0xO02;
        }
        if (oxx0IOOO != null) {
            return oxx0IOOO;
        }
        if (arrayList.isEmpty()) {
            oxx0IOOO2 = kotlinx.serialization.modules.X0o0xo.oxoX(x0o0xo, Oxx0IOOO2, null, 2, null);
        } else {
            List<Oxx0IOOO<Object>> Oxx0xo2 = OxxIIOOXO.Oxx0xo(x0o0xo, arrayList, z);
            if (Oxx0xo2 == null) {
                return null;
            }
            Oxx0IOOO<? extends Object> oxoX2 = OxxIIOOXO.oxoX(Oxx0IOOO2, Oxx0xo2, new Oox.oIX0oI<kotlin.reflect.Oxx0IOOO>() { // from class: kotlinx.serialization.SerializersKt__SerializersKt$serializerByKTypeImpl$contextualSerializer$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                @OXOo.oOoXoXO
                public final kotlin.reflect.Oxx0IOOO invoke() {
                    return arrayList.get(0).IXxxXO();
                }
            });
            if (oxoX2 == null) {
                oxx0IOOO2 = x0o0xo.I0Io(Oxx0IOOO2, Oxx0xo2);
            } else {
                oxx0IOOO2 = oxoX2;
            }
        }
        if (oxx0IOOO2 == null) {
            return null;
        }
        return XO(oxx0IOOO2, ooOOo0oXI2);
    }

    @oxoX
    @OXOo.OOXIXo
    public static final Oxx0IOOO<Object> xoIox(@OXOo.OOXIXo kotlin.reflect.oxoX<?> kClass, @OXOo.OOXIXo List<? extends Oxx0IOOO<?>> typeArgumentsSerializers, boolean z) {
        IIX0o.x0xO0oo(kClass, "kClass");
        IIX0o.x0xO0oo(typeArgumentsSerializers, "typeArgumentsSerializers");
        return OxxIIOOXO.oOoXoXO(SerializersModuleBuildersKt.oIX0oI(), kClass, typeArgumentsSerializers, z);
    }

    @OXOo.OOXIXo
    @XO
    public static final <T> Oxx0IOOO<T> xxIXOIIO(@OXOo.OOXIXo kotlin.reflect.oxoX<T> oxox) {
        IIX0o.x0xO0oo(oxox, "<this>");
        Oxx0IOOO<T> oO2 = OxxIIOOXO.oO(oxox);
        if (oO2 != null) {
            return oO2;
        }
        O00XxXI.xoIox(oxox);
        throw new KotlinNothingValueException();
    }
}
