package Ox00XOXoo;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.text.XIxXXX0x0;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class xxIXOIIO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final WildcardType f2759oIX0oI = oX().I0Io(Object.class).build();

    /* loaded from: classes6.dex */
    public static final class I0Io implements ParameterizedType {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final Type[] f2760IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final Type f2761Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final Class<?> f2762XO;

        public boolean equals(Object obj) {
            if (obj != this && (!(obj instanceof ParameterizedType) || !xxIXOIIO.oOoXoXO(this, (ParameterizedType) obj))) {
                return false;
            }
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f2760IXxxXO.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f2761Oo;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f2762XO;
        }

        public int hashCode() {
            return ((((this.f2762XO.hashCode() | 1136) << 4) | Objects.hashCode(this.f2761Oo)) << 8) | Arrays.hashCode(this.f2760IXxxXO);
        }

        public String toString() {
            return xxIXOIIO.XoX(this);
        }

        public I0Io(Class<?> cls, Type type, Type[] typeArr) {
            this.f2762XO = cls;
            this.f2761Oo = type;
            this.f2760IXxxXO = (Type[]) Arrays.copyOf(typeArr, typeArr.length, Type[].class);
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0 implements GenericArrayType {

        /* renamed from: XO, reason: collision with root package name */
        public final Type f2763XO;

        public boolean equals(Object obj) {
            if (obj != this && (!(obj instanceof GenericArrayType) || !xxIXOIIO.OOXIXo(this, (GenericArrayType) obj))) {
                return false;
            }
            return true;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f2763XO;
        }

        public int hashCode() {
            return this.f2763XO.hashCode() | 1072;
        }

        public String toString() {
            return xxIXOIIO.XoX(this);
        }

        public II0xO0(Type type) {
            this.f2763XO = type;
        }
    }

    /* loaded from: classes6.dex */
    public static final class X0o0xo implements WildcardType {

        /* renamed from: Oo, reason: collision with root package name */
        public final Type[] f2764Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final Type[] f2765XO;

        public boolean equals(Object obj) {
            if (obj != this && (!(obj instanceof WildcardType) || !xxIXOIIO.x0XOIxOo(this, (WildcardType) obj))) {
                return false;
            }
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return (Type[]) this.f2764Oo.clone();
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return (Type[]) this.f2765XO.clone();
        }

        public int hashCode() {
            return ((Arrays.hashCode(this.f2765XO) | 18688) << 8) | Arrays.hashCode(this.f2764Oo);
        }

        public String toString() {
            return xxIXOIIO.XoX(this);
        }

        public X0o0xo(Type[] typeArr, Type[] typeArr2) {
            Type[] typeArr3 = org.apache.commons.lang3.oxoX.f32771xoXoI;
            this.f2765XO = (Type[]) ObjectUtils.oI0IIXIo(typeArr, typeArr3);
            this.f2764Oo = (Type[]) ObjectUtils.oI0IIXIo(typeArr2, typeArr3);
        }
    }

    /* loaded from: classes6.dex */
    public static class oxoX implements org.apache.commons.lang3.builder.oIX0oI<WildcardType> {

        /* renamed from: Oo, reason: collision with root package name */
        public Type[] f2766Oo;

        /* renamed from: XO, reason: collision with root package name */
        public Type[] f2767XO;

        public oxoX I0Io(Type... typeArr) {
            this.f2767XO = typeArr;
            return this;
        }

        public oxoX II0xO0(Type... typeArr) {
            this.f2766Oo = typeArr;
            return this;
        }

        @Override // org.apache.commons.lang3.builder.oIX0oI
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public WildcardType build() {
            return new X0o0xo(this.f2767XO, this.f2766Oo);
        }

        public oxoX() {
        }
    }

    public static Type I0X0x0oIo(Map<TypeVariable<?>, Type> map, Type type) {
        if (map == null) {
            map = Collections.emptyMap();
        }
        if (II0XooXoX(type)) {
            if (type instanceof TypeVariable) {
                return I0X0x0oIo(map, map.get(type));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getOwnerType() != null) {
                    HashMap hashMap = new HashMap(map);
                    hashMap.putAll(XI0IXoo(parameterizedType));
                    map = hashMap;
                }
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    Type I0X0x0oIo2 = I0X0x0oIo(map, actualTypeArguments[i]);
                    if (I0X0x0oIo2 != null) {
                        actualTypeArguments[i] = I0X0x0oIo2;
                    }
                }
                return Io(parameterizedType.getOwnerType(), (Class) parameterizedType.getRawType(), actualTypeArguments);
            }
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return oX().I0Io(xXOx(map, wildcardType.getUpperBounds())).II0xO0(xXOx(map, wildcardType.getLowerBounds())).build();
            }
        }
        return type;
    }

    public static String I0oOoX(TypeVariable<?> typeVariable) {
        xoIxX.xo0x(typeVariable, "var is null", new Object[0]);
        StringBuilder sb = new StringBuilder();
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            Class<?> cls = (Class) genericDeclaration;
            while (cls.getEnclosingClass() != null) {
                sb.insert(0, cls.getSimpleName()).insert(0, '.');
                cls = cls.getEnclosingClass();
            }
            sb.insert(0, cls.getName());
        } else if (genericDeclaration instanceof Type) {
            sb.append(XoX((Type) genericDeclaration));
        } else {
            sb.append(genericDeclaration);
        }
        sb.append(':');
        sb.append(oxXx0IX(typeVariable));
        return sb.toString();
    }

    public static boolean II0XooXoX(Type type) {
        if (type instanceof TypeVariable) {
            return true;
        }
        if (type instanceof Class) {
            if (((Class) type).getTypeParameters().length > 0) {
                return true;
            }
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (II0XooXoX(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (!(type instanceof WildcardType)) {
            return false;
        }
        WildcardType wildcardType = (WildcardType) type;
        if (II0XooXoX(xoXoI(wildcardType)[0]) || II0XooXoX(o00(wildcardType)[0])) {
            return true;
        }
        return false;
    }

    public static boolean IIX0o(Type type, Class<?> cls) {
        if (type == null) {
            if (cls == null || !cls.isPrimitive()) {
                return true;
            }
            return false;
        }
        if (cls == null) {
            return false;
        }
        if (cls.equals(type)) {
            return true;
        }
        if (type instanceof Class) {
            return ClassUtils.IO((Class) type, cls);
        }
        if (type instanceof ParameterizedType) {
            return IIX0o(OxI((ParameterizedType) type), cls);
        }
        if (type instanceof TypeVariable) {
            for (Type type2 : ((TypeVariable) type).getBounds()) {
                if (IIX0o(type2, cls)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            if (cls.equals(Object.class)) {
                return true;
            }
            if (cls.isArray() && IIX0o(((GenericArrayType) type).getGenericComponentType(), cls.getComponentType())) {
                return true;
            }
            return false;
        }
        if (type instanceof WildcardType) {
            return false;
        }
        throw new IllegalStateException("found an unhandled type: " + type);
    }

    public static Type[] IIXOooo(TypeVariable<?> typeVariable) {
        xoIxX.xo0x(typeVariable, "typeVariable is null", new Object[0]);
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length == 0) {
            return new Type[]{Object.class};
        }
        return xII(bounds);
    }

    public static <T> void IO(Class<T> cls, ParameterizedType parameterizedType, Map<TypeVariable<?>, Type> map) {
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            IO(cls, (ParameterizedType) ownerType, map);
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeVariable<Class<?>>[] typeParameters = OxI(parameterizedType).getTypeParameters();
        List asList = Arrays.asList(cls.getTypeParameters());
        for (int i = 0; i < actualTypeArguments.length; i++) {
            TypeVariable<Class<?>> typeVariable = typeParameters[i];
            Type type = actualTypeArguments[i];
            if (asList.contains(type) && map.containsKey(typeVariable)) {
                map.put((TypeVariable) type, map.get(typeVariable));
            }
        }
    }

    public static GenericArrayType IXxxXO(Type type) {
        return new II0xO0((Type) xoIxX.xo0x(type, "componentType is null", new Object[0]));
    }

    public static final ParameterizedType Io(Type type, Class<?> cls, Type... typeArr) {
        boolean z;
        boolean z2;
        xoIxX.xo0x(cls, "raw class is null", new Object[0]);
        if (cls.getEnclosingClass() == null) {
            if (type == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            xoIxX.XI0IXoo(z2, "no owner allowed for top-level %s", cls);
            type = null;
        } else if (type == null) {
            type = cls.getEnclosingClass();
        } else {
            xoIxX.XI0IXoo(IIX0o(type, cls.getEnclosingClass()), "%s is invalid owner type for parameterized %s", type, cls);
        }
        xoIxX.Xx000oIo(typeArr, "null type argument at index %s", new Object[0]);
        if (cls.getTypeParameters().length == typeArr.length) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "invalid number of type parameters specified: expected %d, got %d", Integer.valueOf(cls.getTypeParameters().length), Integer.valueOf(typeArr.length));
        return new I0Io(cls, type, typeArr);
    }

    public static boolean IoOoX(Type type, TypeVariable<?> typeVariable, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (typeVariable == null) {
            return false;
        }
        if (typeVariable.equals(type)) {
            return true;
        }
        if (type instanceof TypeVariable) {
            for (Type type2 : IIXOooo((TypeVariable) type)) {
                if (IoOoX(type2, typeVariable, map)) {
                    return true;
                }
            }
        }
        if ((type instanceof Class) || (type instanceof ParameterizedType) || (type instanceof GenericArrayType) || (type instanceof WildcardType)) {
            return false;
        }
        throw new IllegalStateException("found an unhandled type: " + type);
    }

    public static <T> xoIox<T> O0Xx(final Type type) {
        return new xoIox() { // from class: Ox00XOXoo.II0XooXoX
            @Override // Ox00XOXoo.xoIox
            public final Type getType() {
                Type X00IoxXI2;
                X00IoxXI2 = xxIXOIIO.X00IoxXI(type);
                return X00IoxXI2;
            }
        };
    }

    public static Class<?> O0xOxO(Type type, Type type2) {
        Map<TypeVariable<?>, Type> xxX2;
        Type type3;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return OxI((ParameterizedType) type);
        }
        if (type instanceof TypeVariable) {
            if (type2 == null) {
                return null;
            }
            GenericDeclaration genericDeclaration = ((TypeVariable) type).getGenericDeclaration();
            if (!(genericDeclaration instanceof Class) || (xxX2 = xxX(type2, (Class) genericDeclaration)) == null || (type3 = xxX2.get(type)) == null) {
                return null;
            }
            return O0xOxO(type3, type2);
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(O0xOxO(((GenericArrayType) type).getGenericComponentType(), type2), 0).getClass();
        }
        if (type instanceof WildcardType) {
            return null;
        }
        throw new IllegalArgumentException("unknown type: " + type);
    }

    public static final ParameterizedType OI0(Type type, Class<?> cls, Map<TypeVariable<?>, Type> map) {
        xoIxX.xo0x(cls, "raw class is null", new Object[0]);
        xoIxX.xo0x(map, "typeArgMappings is null", new Object[0]);
        return Io(type, cls, x0xO0oo(map, cls.getTypeParameters()));
    }

    public static boolean OOXIXo(GenericArrayType genericArrayType, Type type) {
        if ((type instanceof GenericArrayType) && ooOOo0oXI(genericArrayType.getGenericComponentType(), ((GenericArrayType) type).getGenericComponentType())) {
            return true;
        }
        return false;
    }

    public static int[] Oo(ParameterizedType parameterizedType) {
        Type[] typeArr = (Type[]) Arrays.copyOf(parameterizedType.getActualTypeArguments(), parameterizedType.getActualTypeArguments().length);
        int[] iArr = new int[0];
        for (int i = 0; i < typeArr.length; i++) {
            Type type = typeArr[i];
            if ((type instanceof TypeVariable) && xxIXOIIO((TypeVariable) type, parameterizedType)) {
                iArr = org.apache.commons.lang3.oxoX.xoIox(iArr, i);
            }
        }
        return iArr;
    }

    public static Class<?> OxI(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        if (rawType instanceof Class) {
            return (Class) rawType;
        }
        throw new IllegalStateException("Wait... What!? Type of rawType: " + rawType);
    }

    public static String Oxx0IOOO(Class<?> cls) {
        if (cls.isArray()) {
            return XoX(cls.getComponentType()) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder();
        if (cls.getEnclosingClass() != null) {
            sb.append(Oxx0IOOO(cls.getEnclosingClass()));
            sb.append('.');
            sb.append(cls.getSimpleName());
        } else {
            sb.append(cls.getName());
        }
        if (cls.getTypeParameters().length > 0) {
            sb.append(XIxXXX0x0.f29542X0o0xo);
            X0o0xo(sb, ", ", cls.getTypeParameters());
            sb.append(XIxXXX0x0.f29545XO);
        }
        return sb.toString();
    }

    public static String Oxx0xo(GenericArrayType genericArrayType) {
        return String.format("%s[]", XoX(genericArrayType.getGenericComponentType()));
    }

    public static Type OxxIIOOXO(Class<?> cls, Class<?> cls2) {
        Class<?> cls3;
        if (cls2.isInterface()) {
            Type type = null;
            for (Type type2 : cls.getGenericInterfaces()) {
                if (type2 instanceof ParameterizedType) {
                    cls3 = OxI((ParameterizedType) type2);
                } else if (type2 instanceof Class) {
                    cls3 = (Class) type2;
                } else {
                    throw new IllegalStateException("Unexpected generic interface type found: " + type2);
                }
                if (IIX0o(cls3, cls2) && oo0xXOI0I(type, cls3)) {
                    type = type2;
                }
            }
            if (type != null) {
                return type;
            }
        }
        return cls.getGenericSuperclass();
    }

    public static Map<TypeVariable<?>, Type> X0IIOO(Class<?> cls, Class<?> cls2, Map<TypeVariable<?>, Type> map) {
        HashMap hashMap;
        if (!IIX0o(cls, cls2)) {
            return null;
        }
        if (cls.isPrimitive()) {
            if (cls2.isPrimitive()) {
                return new HashMap();
            }
            cls = ClassUtils.oxxXoxO(cls);
        }
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        if (cls2.equals(cls)) {
            return hashMap;
        }
        return XxX0x0xxx(OxxIIOOXO(cls, cls2), cls2, hashMap);
    }

    public static <T> StringBuilder X0o0xo(StringBuilder sb, String str, T... tArr) {
        xoIxX.XX(xoIxX.oOXoIIIo(tArr));
        if (tArr.length > 0) {
            sb.append(oxxXoxO(tArr[0]));
            for (int i = 1; i < tArr.length; i++) {
                sb.append(str);
                sb.append(oxxXoxO(tArr[i]));
            }
        }
        return sb;
    }

    public static Map<TypeVariable<?>, Type> XI0IXoo(ParameterizedType parameterizedType) {
        return XIxXXX0x0(parameterizedType, OxI(parameterizedType), null);
    }

    public static Map<TypeVariable<?>, Type> XIxXXX0x0(ParameterizedType parameterizedType, Class<?> cls, Map<TypeVariable<?>, Type> map) {
        Map hashMap;
        Object orDefault;
        Class<?> OxI2 = OxI(parameterizedType);
        if (!IIX0o(OxI2, cls)) {
            return null;
        }
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            ParameterizedType parameterizedType2 = (ParameterizedType) ownerType;
            hashMap = XIxXXX0x0(parameterizedType2, OxI(parameterizedType2), map);
        } else if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeVariable<Class<?>>[] typeParameters = OxI2.getTypeParameters();
        for (int i = 0; i < typeParameters.length; i++) {
            Type type = actualTypeArguments[i];
            TypeVariable<Class<?>> typeVariable = typeParameters[i];
            orDefault = hashMap.getOrDefault(type, type);
            hashMap.put(typeVariable, orDefault);
        }
        if (cls.equals(OxI2)) {
            return hashMap;
        }
        return XxX0x0xxx(OxxIIOOXO(OxI2, cls), cls, hashMap);
    }

    public static void XO(StringBuilder sb, int[] iArr, Type[] typeArr) {
        for (int i = 0; i < iArr.length; i++) {
            sb.append(XIxXXX0x0.f29542X0o0xo);
            X0o0xo(sb, ", ", typeArr[i].toString()).append(XIxXXX0x0.f29545XO);
        }
        Type[] typeArr2 = (Type[]) org.apache.commons.lang3.oxoX.XIOOI(typeArr, iArr);
        if (typeArr2.length > 0) {
            sb.append(XIxXXX0x0.f29542X0o0xo);
            X0o0xo(sb, ", ", typeArr2).append(XIxXXX0x0.f29545XO);
        }
    }

    public static final ParameterizedType XOxIOxOx(Class<?> cls, Type... typeArr) {
        return Io(null, cls, typeArr);
    }

    public static Type XX(Type type, Map<TypeVariable<?>, Type> map) {
        if ((type instanceof TypeVariable) && map != null) {
            Type type2 = map.get(type);
            if (type2 != null) {
                return type2;
            }
            throw new IllegalArgumentException("missing assignment type for type variable " + type);
        }
        return type;
    }

    public static Type XX0(TypeVariable<?> typeVariable, Map<TypeVariable<?>, Type> map) {
        Type type;
        while (true) {
            type = map.get(typeVariable);
            if (!(type instanceof TypeVariable) || type.equals(typeVariable)) {
                break;
            }
            typeVariable = (TypeVariable) type;
        }
        return type;
    }

    public static String Xo0(WildcardType wildcardType) {
        StringBuilder sb = new StringBuilder();
        sb.append('?');
        Type[] lowerBounds = wildcardType.getLowerBounds();
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (lowerBounds.length <= 1 && (lowerBounds.length != 1 || lowerBounds[0] == null)) {
            if (upperBounds.length > 1 || (upperBounds.length == 1 && !Object.class.equals(upperBounds[0]))) {
                sb.append(" extends ");
                X0o0xo(sb, " & ", upperBounds);
            }
        } else {
            sb.append(" super ");
            X0o0xo(sb, " & ", lowerBounds);
        }
        return sb.toString();
    }

    public static <T> xoIox<T> XoI0Ixx0(Class<T> cls) {
        return O0Xx(cls);
    }

    public static String XoX(Type type) {
        xoIxX.oxXx0IX(type);
        if (type instanceof Class) {
            return Oxx0IOOO((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return o0((ParameterizedType) type);
        }
        if (type instanceof WildcardType) {
            return Xo0((WildcardType) type);
        }
        if (type instanceof TypeVariable) {
            return oxXx0IX((TypeVariable) type);
        }
        if (type instanceof GenericArrayType) {
            return Oxx0xo((GenericArrayType) type);
        }
        throw new IllegalArgumentException(ObjectUtils.X0IIOO(type));
    }

    public static boolean Xx000oIo(Object obj, Type type) {
        if (type == null) {
            return false;
        }
        if (obj == null) {
            if ((type instanceof Class) && ((Class) type).isPrimitive()) {
                return false;
            }
            return true;
        }
        return oo(obj.getClass(), type, null);
    }

    public static Map<TypeVariable<?>, Type> XxX0x0xxx(Type type, Class<?> cls, Map<TypeVariable<?>, Type> map) {
        if (type instanceof Class) {
            return X0IIOO((Class) type, cls, map);
        }
        if (type instanceof ParameterizedType) {
            return XIxXXX0x0((ParameterizedType) type, cls, map);
        }
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (cls.isArray()) {
                cls = cls.getComponentType();
            }
            return XxX0x0xxx(genericComponentType, cls, map);
        }
        int i = 0;
        if (type instanceof WildcardType) {
            Type[] o002 = o00((WildcardType) type);
            int length = o002.length;
            while (i < length) {
                Type type2 = o002[i];
                if (IIX0o(type2, cls)) {
                    return XxX0x0xxx(type2, cls, map);
                }
                i++;
            }
            return null;
        }
        if (type instanceof TypeVariable) {
            Type[] IIXOooo2 = IIXOooo((TypeVariable) type);
            int length2 = IIXOooo2.length;
            while (i < length2) {
                Type type3 = IIXOooo2[i];
                if (IIX0o(type3, cls)) {
                    return XxX0x0xxx(type3, cls, map);
                }
                i++;
            }
            return null;
        }
        throw new IllegalStateException("found an unhandled type: " + type);
    }

    public static String o0(ParameterizedType parameterizedType) {
        StringBuilder sb = new StringBuilder();
        Type ownerType = parameterizedType.getOwnerType();
        Class cls = (Class) parameterizedType.getRawType();
        if (ownerType == null) {
            sb.append(cls.getName());
        } else {
            if (ownerType instanceof Class) {
                sb.append(((Class) ownerType).getName());
            } else {
                sb.append(ownerType.toString());
            }
            sb.append('.');
            sb.append(cls.getSimpleName());
        }
        int[] Oo2 = Oo(parameterizedType);
        if (Oo2.length > 0) {
            XO(sb, Oo2, parameterizedType.getActualTypeArguments());
        } else {
            sb.append(XIxXXX0x0.f29542X0o0xo);
            X0o0xo(sb, ", ", parameterizedType.getActualTypeArguments()).append(XIxXXX0x0.f29545XO);
        }
        return sb.toString();
    }

    public static Type[] o00(WildcardType wildcardType) {
        xoIxX.xo0x(wildcardType, "wildcardType is null", new Object[0]);
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length == 0) {
            return new Type[]{Object.class};
        }
        return xII(upperBounds);
    }

    public static Type oI0IIXIo(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return null;
            }
            return cls.getComponentType();
        }
        if (!(type instanceof GenericArrayType)) {
            return null;
        }
        return ((GenericArrayType) type).getGenericComponentType();
    }

    public static boolean oO(Type[] typeArr, Type[] typeArr2) {
        if (typeArr.length != typeArr2.length) {
            return false;
        }
        for (int i = 0; i < typeArr.length; i++) {
            if (!ooOOo0oXI(typeArr[i], typeArr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean oOXoIIIo(Type type, WildcardType wildcardType, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (wildcardType == null) {
            return false;
        }
        if (wildcardType.equals(type)) {
            return true;
        }
        Type[] o002 = o00(wildcardType);
        Type[] xoXoI2 = xoXoI(wildcardType);
        if (type instanceof WildcardType) {
            WildcardType wildcardType2 = (WildcardType) type;
            Type[] o003 = o00(wildcardType2);
            Type[] xoXoI3 = xoXoI(wildcardType2);
            for (Type type2 : o002) {
                Type XX2 = XX(type2, map);
                for (Type type3 : o003) {
                    if (!oo(type3, XX2, map)) {
                        return false;
                    }
                }
            }
            for (Type type4 : xoXoI2) {
                Type XX3 = XX(type4, map);
                for (Type type5 : xoXoI3) {
                    if (!oo(XX3, type5, map)) {
                        return false;
                    }
                }
            }
            return true;
        }
        for (Type type6 : o002) {
            if (!oo(type, XX(type6, map), map)) {
                return false;
            }
        }
        for (Type type7 : xoXoI2) {
            if (!oo(XX(type7, map), type, map)) {
                return false;
            }
        }
        return true;
    }

    public static boolean oOoXoXO(ParameterizedType parameterizedType, Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType2 = (ParameterizedType) type;
            if (ooOOo0oXI(parameterizedType.getRawType(), parameterizedType2.getRawType()) && ooOOo0oXI(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType())) {
                return oO(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
            }
            return false;
        }
        return false;
    }

    public static oxoX oX() {
        return new oxoX();
    }

    public static boolean oo(Type type, Type type2, Map<TypeVariable<?>, Type> map) {
        if (type2 != null && !(type2 instanceof Class)) {
            if (type2 instanceof ParameterizedType) {
                return xI(type, (ParameterizedType) type2, map);
            }
            if (type2 instanceof GenericArrayType) {
                return ooXIXxIX(type, (GenericArrayType) type2, map);
            }
            if (type2 instanceof WildcardType) {
                return oOXoIIIo(type, (WildcardType) type2, map);
            }
            if (type2 instanceof TypeVariable) {
                return IoOoX(type, (TypeVariable) type2, map);
            }
            throw new IllegalStateException("found an unhandled type: " + type2);
        }
        return IIX0o(type, (Class) type2);
    }

    public static boolean oo0xXOI0I(Type type, Type type2) {
        return oo(type, type2, null);
    }

    public static boolean ooOOo0oXI(Type type, Type type2) {
        if (Objects.equals(type, type2)) {
            return true;
        }
        if (type instanceof ParameterizedType) {
            return oOoXoXO((ParameterizedType) type, type2);
        }
        if (type instanceof GenericArrayType) {
            return OOXIXo((GenericArrayType) type, type2);
        }
        if (type instanceof WildcardType) {
            return x0XOIxOo((WildcardType) type, type2);
        }
        return false;
    }

    public static boolean ooXIXxIX(Type type, GenericArrayType genericArrayType, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (genericArrayType == null) {
            return false;
        }
        if (genericArrayType.equals(type)) {
            return true;
        }
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray() && oo(cls.getComponentType(), genericComponentType, map)) {
                return true;
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return oo(((GenericArrayType) type).getGenericComponentType(), genericComponentType, map);
        }
        if (type instanceof WildcardType) {
            for (Type type2 : o00((WildcardType) type)) {
                if (oo0xXOI0I(type2, genericArrayType)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof TypeVariable) {
            for (Type type3 : IIXOooo((TypeVariable) type)) {
                if (oo0xXOI0I(type3, genericArrayType)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof ParameterizedType) {
            return false;
        }
        throw new IllegalStateException("found an unhandled type: " + type);
    }

    public static String oxXx0IX(TypeVariable<?> typeVariable) {
        StringBuilder sb = new StringBuilder(typeVariable.getName());
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length > 0 && (bounds.length != 1 || !Object.class.equals(bounds[0]))) {
            sb.append(" extends ");
            X0o0xo(sb, " & ", typeVariable.getBounds());
        }
        return sb.toString();
    }

    public static <T> String oxxXoxO(T t) {
        if (t instanceof Type) {
            return XoX((Type) t);
        }
        return t.toString();
    }

    public static boolean x0XOIxOo(WildcardType wildcardType, Type type) {
        if (!(type instanceof WildcardType)) {
            return false;
        }
        WildcardType wildcardType2 = (WildcardType) type;
        if (!oO(xoXoI(wildcardType), xoXoI(wildcardType2)) || !oO(o00(wildcardType), o00(wildcardType2))) {
            return false;
        }
        return true;
    }

    public static final ParameterizedType x0o(Class<?> cls, Map<TypeVariable<?>, Type> map) {
        xoIxX.xo0x(cls, "raw class is null", new Object[0]);
        xoIxX.xo0x(map, "typeArgMappings is null", new Object[0]);
        return Io(null, cls, x0xO0oo(map, cls.getTypeParameters()));
    }

    public static Type[] x0xO0oo(Map<TypeVariable<?>, Type> map, TypeVariable<?>[] typeVariableArr) {
        Type[] typeArr = new Type[typeVariableArr.length];
        int length = typeVariableArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            TypeVariable<?> typeVariable = typeVariableArr[i];
            xoIxX.XI0IXoo(map.containsKey(typeVariable), "missing argument mapping for %s", XoX(typeVariable));
            typeArr[i2] = map.get(typeVariable);
            i++;
            i2++;
        }
        return typeArr;
    }

    public static boolean xI(Type type, ParameterizedType parameterizedType, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (parameterizedType == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class<?> OxI2 = OxI(parameterizedType);
        Map<TypeVariable<?>, Type> XxX0x0xxx2 = XxX0x0xxx(type, OxI2, null);
        if (XxX0x0xxx2 == null) {
            return false;
        }
        if (XxX0x0xxx2.isEmpty()) {
            return true;
        }
        Map<TypeVariable<?>, Type> XIxXXX0x02 = XIxXXX0x0(parameterizedType, OxI2, map);
        for (TypeVariable<?> typeVariable : XIxXXX0x02.keySet()) {
            Type XX02 = XX0(typeVariable, XIxXXX0x02);
            Type XX03 = XX0(typeVariable, XxX0x0xxx2);
            if (XX02 != null || !(XX03 instanceof Class)) {
                if (XX03 != null && !XX02.equals(XX03) && (!(XX02 instanceof WildcardType) || !oo(XX03, XX02, map))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Type[] xII(Type[] typeArr) {
        xoIxX.xo0x(typeArr, "null value specified for bounds array", new Object[0]);
        if (typeArr.length < 2) {
            return typeArr;
        }
        HashSet hashSet = new HashSet(typeArr.length);
        for (Type type : typeArr) {
            int length = typeArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    Type type2 = typeArr[i];
                    if (type == type2 || !oo(type2, type, null)) {
                        i++;
                    }
                } else {
                    hashSet.add(type);
                    break;
                }
            }
        }
        return (Type[]) hashSet.toArray(org.apache.commons.lang3.oxoX.f32771xoXoI);
    }

    public static Type[] xXOx(Map<TypeVariable<?>, Type> map, Type[] typeArr) {
        int i = 0;
        while (i < typeArr.length) {
            Type I0X0x0oIo2 = I0X0x0oIo(map, typeArr[i]);
            if (I0X0x0oIo2 == null) {
                typeArr = (Type[]) org.apache.commons.lang3.oxoX.ooO0oXxI(typeArr, i);
                i--;
            } else {
                typeArr[i] = I0X0x0oIo2;
            }
            i++;
        }
        return typeArr;
    }

    public static boolean xXxxox0I(Type type) {
        if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
            return false;
        }
        return true;
    }

    public static boolean xo0x(Map<TypeVariable<?>, Type> map) {
        xoIxX.xo0x(map, "typeVarAssigns is null", new Object[0]);
        for (Map.Entry<TypeVariable<?>, Type> entry : map.entrySet()) {
            TypeVariable<?> key = entry.getKey();
            Type value = entry.getValue();
            for (Type type : IIXOooo(key)) {
                if (!oo(value, XX(type, map), map)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Map<TypeVariable<?>, Type> xoIox(Class<?> cls, ParameterizedType parameterizedType) {
        xoIxX.xo0x(cls, "cls is null", new Object[0]);
        xoIxX.xo0x(parameterizedType, "superType is null", new Object[0]);
        Class<?> OxI2 = OxI(parameterizedType);
        if (!IIX0o(cls, OxI2)) {
            return null;
        }
        if (cls.equals(OxI2)) {
            return XIxXXX0x0(parameterizedType, OxI2, null);
        }
        Type OxxIIOOXO2 = OxxIIOOXO(cls, OxI2);
        if (OxxIIOOXO2 instanceof Class) {
            return xoIox((Class) OxxIIOOXO2, parameterizedType);
        }
        ParameterizedType parameterizedType2 = (ParameterizedType) OxxIIOOXO2;
        Map<TypeVariable<?>, Type> xoIox2 = xoIox(OxI(parameterizedType2), parameterizedType);
        IO(cls, parameterizedType2, xoIox2);
        return xoIox2;
    }

    public static Type[] xoXoI(WildcardType wildcardType) {
        xoIxX.xo0x(wildcardType, "wildcardType is null", new Object[0]);
        Type[] lowerBounds = wildcardType.getLowerBounds();
        if (lowerBounds.length == 0) {
            return new Type[]{null};
        }
        return lowerBounds;
    }

    public static boolean xxIXOIIO(TypeVariable<?> typeVariable, ParameterizedType parameterizedType) {
        return org.apache.commons.lang3.oxoX.xo0x(typeVariable.getBounds(), parameterizedType);
    }

    public static Map<TypeVariable<?>, Type> xxX(Type type, Class<?> cls) {
        return XxX0x0xxx(type, cls, null);
    }

    public static /* synthetic */ Type X00IoxXI(Type type) {
        return type;
    }
}
