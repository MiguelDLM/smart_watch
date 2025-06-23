package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import org.apache.log4j.spi.LocationInfo;

@kotlin.IXxxXO
@XX({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/WildcardTypeImpl\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,230:1\n26#2:231\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/WildcardTypeImpl\n*L\n163#1:231\n*E\n"})
/* loaded from: classes6.dex */
public final class OxI implements WildcardType, IIXOooo {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29395IXxxXO = new oIX0oI(null);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final OxI f29396Oxx0xo = new OxI(null, null);

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Type f29397Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Type f29398XO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final OxI oIX0oI() {
            return OxI.f29396Oxx0xo;
        }

        public oIX0oI() {
        }
    }

    public OxI(@OXOo.oOoXoXO Type type, @OXOo.oOoXoXO Type type2) {
        this.f29398XO = type;
        this.f29397Oo = type2;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    @OXOo.OOXIXo
    public Type[] getLowerBounds() {
        Type type = this.f29397Oo;
        if (type == null) {
            return new Type[0];
        }
        return new Type[]{type};
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.IIXOooo
    @OXOo.OOXIXo
    public String getTypeName() {
        String xoIox2;
        String xoIox3;
        if (this.f29397Oo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("? super ");
            xoIox3 = TypesJVMKt.xoIox(this.f29397Oo);
            sb.append(xoIox3);
            return sb.toString();
        }
        Type type = this.f29398XO;
        if (type != null && !IIX0o.Oxx0IOOO(type, Object.class)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("? extends ");
            xoIox2 = TypesJVMKt.xoIox(this.f29398XO);
            sb2.append(xoIox2);
            return sb2.toString();
        }
        return LocationInfo.NA;
    }

    @Override // java.lang.reflect.WildcardType
    @OXOo.OOXIXo
    public Type[] getUpperBounds() {
        Type type = this.f29398XO;
        if (type == null) {
            type = Object.class;
        }
        return new Type[]{type};
    }

    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    @OXOo.OOXIXo
    public String toString() {
        return getTypeName();
    }
}
