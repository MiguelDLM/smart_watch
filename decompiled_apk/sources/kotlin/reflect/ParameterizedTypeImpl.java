package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@kotlin.IXxxXO
@XX({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/ParameterizedTypeImpl\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,230:1\n37#2,2:231\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/ParameterizedTypeImpl\n*L\n190#1:231,2\n*E\n"})
/* loaded from: classes6.dex */
public final class ParameterizedTypeImpl implements ParameterizedType, IIXOooo {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Type[] f29404IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Type f29405Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Class<?> f29406XO;

    public ParameterizedTypeImpl(@OXOo.OOXIXo Class<?> rawType, @OXOo.oOoXoXO Type type, @OXOo.OOXIXo List<? extends Type> typeArguments) {
        IIX0o.x0xO0oo(rawType, "rawType");
        IIX0o.x0xO0oo(typeArguments, "typeArguments");
        this.f29406XO = rawType;
        this.f29405Oo = type;
        this.f29404IXxxXO = (Type[]) typeArguments.toArray(new Type[0]);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (IIX0o.Oxx0IOOO(this.f29406XO, parameterizedType.getRawType()) && IIX0o.Oxx0IOOO(this.f29405Oo, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    @OXOo.OOXIXo
    public Type[] getActualTypeArguments() {
        return this.f29404IXxxXO;
    }

    @Override // java.lang.reflect.ParameterizedType
    @OXOo.oOoXoXO
    public Type getOwnerType() {
        return this.f29405Oo;
    }

    @Override // java.lang.reflect.ParameterizedType
    @OXOo.OOXIXo
    public Type getRawType() {
        return this.f29406XO;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.IIXOooo
    @OXOo.OOXIXo
    public String getTypeName() {
        String xoIox2;
        boolean z;
        String xoIox3;
        StringBuilder sb = new StringBuilder();
        Type type = this.f29405Oo;
        if (type != null) {
            xoIox3 = TypesJVMKt.xoIox(type);
            sb.append(xoIox3);
            sb.append("$");
            sb.append(this.f29406XO.getSimpleName());
        } else {
            xoIox2 = TypesJVMKt.xoIox(this.f29406XO);
            sb.append(xoIox2);
        }
        Type[] typeArr = this.f29404IXxxXO;
        if (typeArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            ArraysKt___ArraysKt.ooX0XXOI(typeArr, sb, null, "<", ">", 0, null, ParameterizedTypeImpl$getTypeName$1$1.INSTANCE, 50, null);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    public int hashCode() {
        int i;
        int hashCode = this.f29406XO.hashCode();
        Type type = this.f29405Oo;
        if (type != null) {
            i = type.hashCode();
        } else {
            i = 0;
        }
        return (hashCode ^ i) ^ Arrays.hashCode(getActualTypeArguments());
    }

    @OXOo.OOXIXo
    public String toString() {
        return getTypeName();
    }
}
