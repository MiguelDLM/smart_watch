package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.KVariance;
import org.apache.log4j.spi.LocationInfo;

@kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
/* loaded from: classes6.dex */
public final class TypeReference implements kotlin.reflect.Oxx0xo {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f29304IIXOooo = 2;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f29305OxxIIOOXO = 1;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29306oI0IIXIo = new oIX0oI(null);

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f29307xoXoI = 4;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final kotlin.reflect.Oxx0xo f29308IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<kotlin.reflect.OxxIIOOXO> f29309Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final int f29310Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.reflect.Oxx0IOOO f29311XO;

    /* loaded from: classes6.dex */
    public /* synthetic */ class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f29312oIX0oI;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f29312oIX0oI = iArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    @kotlin.oxxXoxO(version = "1.6")
    public TypeReference(@OXOo.OOXIXo kotlin.reflect.Oxx0IOOO classifier, @OXOo.OOXIXo List<kotlin.reflect.OxxIIOOXO> arguments, @OXOo.oOoXoXO kotlin.reflect.Oxx0xo oxx0xo, int i) {
        IIX0o.x0xO0oo(classifier, "classifier");
        IIX0o.x0xO0oo(arguments, "arguments");
        this.f29311XO = classifier;
        this.f29309Oo = arguments;
        this.f29308IXxxXO = oxx0xo;
        this.f29310Oxx0xo = i;
    }

    @kotlin.oxxXoxO(version = "1.6")
    public static /* synthetic */ void XI0IXoo() {
    }

    @kotlin.oxxXoxO(version = "1.6")
    public static /* synthetic */ void xxX() {
    }

    @Override // kotlin.reflect.Oxx0xo
    @OXOo.OOXIXo
    public kotlin.reflect.Oxx0IOOO IXxxXO() {
        return this.f29311XO;
    }

    public final String O0xOxO(Class<?> cls) {
        if (IIX0o.Oxx0IOOO(cls, boolean[].class)) {
            return "kotlin.BooleanArray";
        }
        if (IIX0o.Oxx0IOOO(cls, char[].class)) {
            return "kotlin.CharArray";
        }
        if (IIX0o.Oxx0IOOO(cls, byte[].class)) {
            return "kotlin.ByteArray";
        }
        if (IIX0o.Oxx0IOOO(cls, short[].class)) {
            return "kotlin.ShortArray";
        }
        if (IIX0o.Oxx0IOOO(cls, int[].class)) {
            return "kotlin.IntArray";
        }
        if (IIX0o.Oxx0IOOO(cls, float[].class)) {
            return "kotlin.FloatArray";
        }
        if (IIX0o.Oxx0IOOO(cls, long[].class)) {
            return "kotlin.LongArray";
        }
        if (IIX0o.Oxx0IOOO(cls, double[].class)) {
            return "kotlin.DoubleArray";
        }
        return kotlinx.serialization.internal.OxxIIOOXO.f30670oIX0oI;
    }

    public final int X0IIOO() {
        return this.f29310Oxx0xo;
    }

    @OXOo.oOoXoXO
    public final kotlin.reflect.Oxx0xo XIxXXX0x0() {
        return this.f29308IXxxXO;
    }

    public final String XO(kotlin.reflect.OxxIIOOXO oxxIIOOXO) {
        TypeReference typeReference;
        String valueOf;
        if (oxxIIOOXO.II0XooXoX() == null) {
            return "*";
        }
        kotlin.reflect.Oxx0xo Oxx0IOOO2 = oxxIIOOXO.Oxx0IOOO();
        if (Oxx0IOOO2 instanceof TypeReference) {
            typeReference = (TypeReference) Oxx0IOOO2;
        } else {
            typeReference = null;
        }
        if (typeReference == null || (valueOf = typeReference.oI0IIXIo(true)) == null) {
            valueOf = String.valueOf(oxxIIOOXO.Oxx0IOOO());
        }
        int i = II0xO0.f29312oIX0oI[oxxIIOOXO.II0XooXoX().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return "out " + valueOf;
                }
                throw new NoWhenBranchMatchedException();
            }
            return "in " + valueOf;
        }
        return valueOf;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (IIX0o.Oxx0IOOO(IXxxXO(), typeReference.IXxxXO()) && IIX0o.Oxx0IOOO(getArguments(), typeReference.getArguments()) && IIX0o.Oxx0IOOO(this.f29308IXxxXO, typeReference.f29308IXxxXO) && this.f29310Oxx0xo == typeReference.f29310Oxx0xo) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.II0xO0
    @OXOo.OOXIXo
    public List<Annotation> getAnnotations() {
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @Override // kotlin.reflect.Oxx0xo
    @OXOo.OOXIXo
    public List<kotlin.reflect.OxxIIOOXO> getArguments() {
        return this.f29309Oo;
    }

    public int hashCode() {
        return (((IXxxXO().hashCode() * 31) + getArguments().hashCode()) * 31) + this.f29310Oxx0xo;
    }

    public final String oI0IIXIo(boolean z) {
        kotlin.reflect.oxoX oxox;
        String name;
        String OoIXo2;
        kotlin.reflect.Oxx0IOOO IXxxXO2 = IXxxXO();
        Class<?> cls = null;
        if (IXxxXO2 instanceof kotlin.reflect.oxoX) {
            oxox = (kotlin.reflect.oxoX) IXxxXO2;
        } else {
            oxox = null;
        }
        if (oxox != null) {
            cls = XO0OX.II0xO0.X0o0xo(oxox);
        }
        if (cls == null) {
            name = IXxxXO().toString();
        } else if ((this.f29310Oxx0xo & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (cls.isArray()) {
            name = O0xOxO(cls);
        } else if (z && cls.isPrimitive()) {
            kotlin.reflect.Oxx0IOOO IXxxXO3 = IXxxXO();
            IIX0o.x0XOIxOo(IXxxXO3, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = XO0OX.II0xO0.Oxx0IOOO((kotlin.reflect.oxoX) IXxxXO3).getName();
        } else {
            name = cls.getName();
        }
        String str = "";
        if (getArguments().isEmpty()) {
            OoIXo2 = "";
        } else {
            OoIXo2 = CollectionsKt___CollectionsKt.OoIXo(getArguments(), ", ", "<", ">", 0, null, new Oox.oOoXoXO<kotlin.reflect.OxxIIOOXO, CharSequence>() { // from class: kotlin.jvm.internal.TypeReference$asString$args$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final CharSequence invoke(@OXOo.OOXIXo kotlin.reflect.OxxIIOOXO it) {
                    String XO2;
                    IIX0o.x0xO0oo(it, "it");
                    XO2 = TypeReference.this.XO(it);
                    return XO2;
                }
            }, 24, null);
        }
        if (ooOOo0oXI()) {
            str = LocationInfo.NA;
        }
        String str2 = name + OoIXo2 + str;
        kotlin.reflect.Oxx0xo oxx0xo = this.f29308IXxxXO;
        if (oxx0xo instanceof TypeReference) {
            String oI0IIXIo2 = ((TypeReference) oxx0xo).oI0IIXIo(true);
            if (!IIX0o.Oxx0IOOO(oI0IIXIo2, str2)) {
                if (IIX0o.Oxx0IOOO(oI0IIXIo2, str2 + '?')) {
                    return str2 + OoIXo.oOoXoXO.f2346I0Io;
                }
                return HexStringBuilder.COMMENT_BEGIN_CHAR + str2 + ".." + oI0IIXIo2 + HexStringBuilder.COMMENT_END_CHAR;
            }
            return str2;
        }
        return str2;
    }

    @Override // kotlin.reflect.Oxx0xo
    public boolean ooOOo0oXI() {
        if ((this.f29310Oxx0xo & 1) != 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public String toString() {
        return oI0IIXIo(false) + IO.f29280II0xO0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypeReference(@OXOo.OOXIXo kotlin.reflect.Oxx0IOOO classifier, @OXOo.OOXIXo List<kotlin.reflect.OxxIIOOXO> arguments, boolean z) {
        this(classifier, arguments, null, z ? 1 : 0);
        IIX0o.x0xO0oo(classifier, "classifier");
        IIX0o.x0xO0oo(arguments, "arguments");
    }
}
