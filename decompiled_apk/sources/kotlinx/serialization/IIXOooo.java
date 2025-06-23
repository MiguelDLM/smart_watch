package kotlinx.serialization;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlinx.serialization.internal.o0xxxXXxX;
import kotlinx.serialization.internal.xOOOX;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

@XX({"SMAP\nSerializersJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SerializersJvm.kt\nkotlinx/serialization/SerializersKt__SerializersJvmKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,201:1\n11065#2:202\n11400#2,3:203\n1549#3:206\n1620#3,3:207\n37#4,2:210\n1#5:212\n*S KotlinDebug\n*F\n+ 1 SerializersJvm.kt\nkotlinx/serialization/SerializersKt__SerializersJvmKt\n*L\n113#1:202\n113#1:203,3\n140#1:206\n140#1:207,3\n169#1:210,2\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class IIXOooo {
    public static final <T> Oxx0IOOO<T> I0Io(kotlinx.serialization.modules.X0o0xo x0o0xo, Class<T> cls, List<? extends Oxx0IOOO<Object>> list) {
        Oxx0IOOO[] oxx0IOOOArr = (Oxx0IOOO[]) list.toArray(new Oxx0IOOO[0]);
        Oxx0IOOO<T> I0Io2 = o0xxxXXxX.I0Io(cls, (Oxx0IOOO[]) Arrays.copyOf(oxx0IOOOArr, oxx0IOOOArr.length));
        if (I0Io2 != null) {
            return I0Io2;
        }
        kotlin.reflect.oxoX<T> xxIXOIIO2 = XO0OX.II0xO0.xxIXOIIO(cls);
        Oxx0IOOO<T> II0xO02 = xOOOX.II0xO0(xxIXOIIO2);
        if (II0xO02 == null) {
            return x0o0xo.I0Io(xxIXOIIO2, list);
        }
        return II0xO02;
    }

    @OXOo.oOoXoXO
    public static final Oxx0IOOO<Object> II0XooXoX(@OXOo.OOXIXo Type type) {
        IIX0o.x0xO0oo(type, "type");
        return OxxIIOOXO.Oo(SerializersModuleBuildersKt.oIX0oI(), type);
    }

    public static final Class<?> II0xO0(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            IIX0o.oO(rawType, "getRawType(...)");
            return II0xO0(rawType);
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            IIX0o.oO(upperBounds, "getUpperBounds(...)");
            Object XXOXXx = ArraysKt___ArraysKt.XXOXXx(upperBounds);
            IIX0o.oO(XXOXXx, "first(...)");
            return II0xO0((Type) XXOXXx);
        }
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            IIX0o.oO(genericComponentType, "getGenericComponentType(...)");
            return II0xO0(genericComponentType);
        }
        throw new IllegalArgumentException("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument " + type + " has type " + IO.oxoX(type.getClass()));
    }

    public static /* synthetic */ Oxx0IOOO Oxx0IOOO(kotlinx.serialization.modules.X0o0xo x0o0xo, Type type, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return XO(x0o0xo, type, z);
    }

    @OXOo.OOXIXo
    public static final Oxx0IOOO<Object> X0o0xo(@OXOo.OOXIXo kotlinx.serialization.modules.X0o0xo x0o0xo, @OXOo.OOXIXo Type type) {
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.x0xO0oo(type, "type");
        Oxx0IOOO<Object> XO2 = XO(x0o0xo, type, true);
        if (XO2 != null) {
            return XO2;
        }
        o0xxxXXxX.IXxxXO(II0xO0(type));
        throw new KotlinNothingValueException();
    }

    public static final Oxx0IOOO<Object> XO(kotlinx.serialization.modules.X0o0xo x0o0xo, Type type, boolean z) {
        ArrayList<Oxx0IOOO> arrayList;
        if (type instanceof GenericArrayType) {
            return oIX0oI(x0o0xo, (GenericArrayType) type, z);
        }
        if (type instanceof Class) {
            return xoIox(x0o0xo, (Class) type, z);
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            IIX0o.x0XOIxOo(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            Class cls = (Class) rawType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            IIX0o.ooOOo0oXI(actualTypeArguments);
            if (z) {
                arrayList = new ArrayList(actualTypeArguments.length);
                for (Type type2 : actualTypeArguments) {
                    IIX0o.ooOOo0oXI(type2);
                    arrayList.add(OxxIIOOXO.OOXIXo(x0o0xo, type2));
                }
            } else {
                arrayList = new ArrayList(actualTypeArguments.length);
                for (Type type3 : actualTypeArguments) {
                    IIX0o.ooOOo0oXI(type3);
                    Oxx0IOOO<Object> Oo2 = OxxIIOOXO.Oo(x0o0xo, type3);
                    if (Oo2 == null) {
                        return null;
                    }
                    arrayList.add(Oo2);
                }
            }
            if (Set.class.isAssignableFrom(cls)) {
                Oxx0IOOO<Object> oO2 = xx.oOoXoXO.oO((Oxx0IOOO) arrayList.get(0));
                IIX0o.x0XOIxOo(oO2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                return oO2;
            }
            if (!List.class.isAssignableFrom(cls) && !Collection.class.isAssignableFrom(cls)) {
                if (Map.class.isAssignableFrom(cls)) {
                    Oxx0IOOO<Object> oOoXoXO2 = xx.oOoXoXO.oOoXoXO((Oxx0IOOO) arrayList.get(0), (Oxx0IOOO) arrayList.get(1));
                    IIX0o.x0XOIxOo(oOoXoXO2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                    return oOoXoXO2;
                }
                if (Map.Entry.class.isAssignableFrom(cls)) {
                    Oxx0IOOO<Object> OOXIXo2 = xx.oOoXoXO.OOXIXo((Oxx0IOOO) arrayList.get(0), (Oxx0IOOO) arrayList.get(1));
                    IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                    return OOXIXo2;
                }
                if (Pair.class.isAssignableFrom(cls)) {
                    Oxx0IOOO<Object> x0XOIxOo2 = xx.oOoXoXO.x0XOIxOo((Oxx0IOOO) arrayList.get(0), (Oxx0IOOO) arrayList.get(1));
                    IIX0o.x0XOIxOo(x0XOIxOo2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                    return x0XOIxOo2;
                }
                if (Triple.class.isAssignableFrom(cls)) {
                    Oxx0IOOO<Object> Oo3 = xx.oOoXoXO.Oo((Oxx0IOOO) arrayList.get(0), (Oxx0IOOO) arrayList.get(1), (Oxx0IOOO) arrayList.get(2));
                    IIX0o.x0XOIxOo(Oo3, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                    return Oo3;
                }
                ArrayList arrayList2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(arrayList, 10));
                for (Oxx0IOOO oxx0IOOO : arrayList) {
                    IIX0o.x0XOIxOo(oxx0IOOO, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
                    arrayList2.add(oxx0IOOO);
                }
                return I0Io(x0o0xo, cls, arrayList2);
            }
            Oxx0IOOO<Object> xxIXOIIO2 = xx.oOoXoXO.xxIXOIIO((Oxx0IOOO) arrayList.get(0));
            IIX0o.x0XOIxOo(xxIXOIIO2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return xxIXOIIO2;
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            IIX0o.oO(upperBounds, "getUpperBounds(...)");
            Object XXOXXx = ArraysKt___ArraysKt.XXOXXx(upperBounds);
            IIX0o.oO(XXOXXx, "first(...)");
            return Oxx0IOOO(x0o0xo, (Type) XXOXXx, false, 2, null);
        }
        throw new IllegalArgumentException("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument " + type + " has type " + IO.oxoX(type.getClass()));
    }

    public static final Oxx0IOOO<Object> oIX0oI(kotlinx.serialization.modules.X0o0xo x0o0xo, GenericArrayType genericArrayType, boolean z) {
        Oxx0IOOO<Object> Oo2;
        kotlin.reflect.oxoX oxox;
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (genericComponentType instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) genericComponentType).getUpperBounds();
            IIX0o.oO(upperBounds, "getUpperBounds(...)");
            genericComponentType = (Type) ArraysKt___ArraysKt.XXOXXx(upperBounds);
        }
        IIX0o.ooOOo0oXI(genericComponentType);
        if (z) {
            Oo2 = OxxIIOOXO.OOXIXo(x0o0xo, genericComponentType);
        } else {
            Oo2 = OxxIIOOXO.Oo(x0o0xo, genericComponentType);
            if (Oo2 == null) {
                return null;
            }
        }
        if (genericComponentType instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) genericComponentType).getRawType();
            IIX0o.x0XOIxOo(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            oxox = XO0OX.II0xO0.xxIXOIIO((Class) rawType);
        } else if (genericComponentType instanceof kotlin.reflect.oxoX) {
            oxox = (kotlin.reflect.oxoX) genericComponentType;
        } else {
            throw new IllegalStateException("unsupported type in GenericArray: " + IO.oxoX(genericComponentType.getClass()));
        }
        IIX0o.x0XOIxOo(oxox, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        Oxx0IOOO<Object> oIX0oI2 = xx.oOoXoXO.oIX0oI(oxox, Oo2);
        IIX0o.x0XOIxOo(oIX0oI2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        return oIX0oI2;
    }

    @OXOo.OOXIXo
    public static final Oxx0IOOO<Object> oxoX(@OXOo.OOXIXo Type type) {
        IIX0o.x0xO0oo(type, "type");
        return OxxIIOOXO.OOXIXo(SerializersModuleBuildersKt.oIX0oI(), type);
    }

    public static final Oxx0IOOO<Object> xoIox(kotlinx.serialization.modules.X0o0xo x0o0xo, Class<?> cls, boolean z) {
        Oxx0IOOO<Object> Oo2;
        if (cls.isArray() && !cls.getComponentType().isPrimitive()) {
            Class<?> componentType = cls.getComponentType();
            IIX0o.oO(componentType, "getComponentType(...)");
            if (z) {
                Oo2 = OxxIIOOXO.OOXIXo(x0o0xo, componentType);
            } else {
                Oo2 = OxxIIOOXO.Oo(x0o0xo, componentType);
                if (Oo2 == null) {
                    return null;
                }
            }
            kotlin.reflect.oxoX xxIXOIIO2 = XO0OX.II0xO0.xxIXOIIO(componentType);
            IIX0o.x0XOIxOo(xxIXOIIO2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            Oxx0IOOO<Object> oIX0oI2 = xx.oOoXoXO.oIX0oI(xxIXOIIO2, Oo2);
            IIX0o.x0XOIxOo(oIX0oI2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return oIX0oI2;
        }
        IIX0o.x0XOIxOo(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
        return I0Io(x0o0xo, cls, CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    @OXOo.oOoXoXO
    public static final Oxx0IOOO<Object> xxIXOIIO(@OXOo.OOXIXo kotlinx.serialization.modules.X0o0xo x0o0xo, @OXOo.OOXIXo Type type) {
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.x0xO0oo(type, "type");
        return XO(x0o0xo, type, false);
    }
}
