package androidx.navigation.serialization;

import OXOo.OOXIXo;
import androidx.navigation.NavType;
import androidx.navigation.serialization.InternalNavType;
import com.tenmeter.smlibrary.utils.FileUtils;
import kotlin.jvm.internal.IIX0o;
import kotlin.reflect.Oxx0xo;
import kotlin.text.OxI;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.serialization.Oxx0IOOO;
import kotlinx.serialization.OxxIIOOXO;
import kotlinx.serialization.descriptors.II0XooXoX;
import kotlinx.serialization.descriptors.XO;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes.dex */
public final class NavTypeConverterKt {

    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InternalType.values().length];
            try {
                iArr[InternalType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InternalType.BOOL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InternalType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InternalType.LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[InternalType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[InternalType.STRING_NULLABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[InternalType.ENUM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[InternalType.INT_NULLABLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[InternalType.BOOL_NULLABLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[InternalType.DOUBLE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[InternalType.DOUBLE_NULLABLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[InternalType.FLOAT_NULLABLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[InternalType.LONG_NULLABLE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[InternalType.INT_ARRAY.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[InternalType.BOOL_ARRAY.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[InternalType.DOUBLE_ARRAY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[InternalType.FLOAT_ARRAY.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[InternalType.LONG_ARRAY.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[InternalType.ARRAY.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[InternalType.LIST.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[InternalType.ENUM_NULLABLE.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final Class<?> getClass(XO xo2) {
        String IIOIX2 = OxI.IIOIX(xo2.xxIXOIIO(), LocationInfo.NA, "", false, 4, null);
        try {
            Class<?> cls = Class.forName(IIOIX2);
            IIX0o.oO(cls, "forName(className)");
            return cls;
        } catch (ClassNotFoundException unused) {
            if (StringsKt__StringsKt.o00xOoIO(IIOIX2, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, null)) {
                Class<?> cls2 = Class.forName(new Regex("(\\.+)(?!.*\\.)").replace(IIOIX2, "\\$"));
                IIX0o.oO(cls2, "forName(className)");
                return cls2;
            }
            throw new IllegalArgumentException("Cannot find class with name \"" + xo2.xxIXOIIO() + "\". Ensure that the serialName for this argument is the default fully qualified name");
        }
    }

    @OOXIXo
    public static final NavType<?> getNavType(@OOXIXo XO xo2) {
        NavType<?> enumListType;
        IIX0o.x0xO0oo(xo2, "<this>");
        InternalType internalType = toInternalType(xo2);
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[internalType.ordinal()]) {
            case 1:
                return NavType.IntType;
            case 2:
                return NavType.BoolType;
            case 3:
                return NavType.FloatType;
            case 4:
                return NavType.LongType;
            case 5:
                return InternalNavType.INSTANCE.getStringNonNullableType();
            case 6:
                return NavType.StringType;
            case 7:
                NavType<?> parseSerializableOrParcelableType$navigation_common_release = NavType.Companion.parseSerializableOrParcelableType$navigation_common_release(getClass(xo2), false);
                if (parseSerializableOrParcelableType$navigation_common_release == null) {
                    return UNKNOWN.INSTANCE;
                }
                return parseSerializableOrParcelableType$navigation_common_release;
            case 8:
                return InternalNavType.INSTANCE.getIntNullableType();
            case 9:
                return InternalNavType.INSTANCE.getBoolNullableType();
            case 10:
                return InternalNavType.INSTANCE.getDoubleType();
            case 11:
                return InternalNavType.INSTANCE.getDoubleNullableType();
            case 12:
                return InternalNavType.INSTANCE.getFloatNullableType();
            case 13:
                return InternalNavType.INSTANCE.getLongNullableType();
            case 14:
                return NavType.IntArrayType;
            case 15:
                return NavType.BoolArrayType;
            case 16:
                return InternalNavType.INSTANCE.getDoubleArrayType();
            case 17:
                return NavType.FloatArrayType;
            case 18:
                return NavType.LongArrayType;
            case 19:
                if (toInternalType(xo2.X0o0xo(0)) == InternalType.STRING) {
                    return NavType.StringArrayType;
                }
                return UNKNOWN.INSTANCE;
            case 20:
                switch (iArr[toInternalType(xo2.X0o0xo(0)).ordinal()]) {
                    case 1:
                        return NavType.IntListType;
                    case 2:
                        return NavType.BoolListType;
                    case 3:
                        return NavType.FloatListType;
                    case 4:
                        return NavType.LongListType;
                    case 5:
                        return NavType.StringListType;
                    case 6:
                        return InternalNavType.INSTANCE.getStringNullableListType();
                    case 7:
                        Class<?> cls = getClass(xo2.X0o0xo(0));
                        IIX0o.x0XOIxOo(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.Enum<*>>");
                        enumListType = new InternalNavType.EnumListType<>(cls);
                        break;
                    default:
                        return UNKNOWN.INSTANCE;
                }
            case 21:
                Class<?> cls2 = getClass(xo2);
                if (Enum.class.isAssignableFrom(cls2)) {
                    IIX0o.x0XOIxOo(cls2, "null cannot be cast to non-null type java.lang.Class<kotlin.Enum<*>?>");
                    enumListType = new InternalNavType.EnumNullableType<>(cls2);
                    break;
                } else {
                    return UNKNOWN.INSTANCE;
                }
            default:
                return UNKNOWN.INSTANCE;
        }
        return enumListType;
    }

    public static final boolean matchKType(@OOXIXo XO xo2, @OOXIXo Oxx0xo kType) {
        IIX0o.x0xO0oo(xo2, "<this>");
        IIX0o.x0xO0oo(kType, "kType");
        if (xo2.I0Io() != kType.ooOOo0oXI()) {
            return false;
        }
        Oxx0IOOO<Object> x0xO0oo2 = OxxIIOOXO.x0xO0oo(kType);
        if (x0xO0oo2 != null) {
            return IIX0o.Oxx0IOOO(xo2, x0xO0oo2.oIX0oI());
        }
        throw new IllegalStateException("Custom serializers declared directly on a class field via @Serializable(with = ...) is currently not supported by safe args for both custom types and third-party types. Please use @Serializable or @Serializable(with = ...) on the class or object declaration.");
    }

    private static final InternalType toInternalType(XO xo2) {
        String IIOIX2 = OxI.IIOIX(xo2.xxIXOIIO(), LocationInfo.NA, "", false, 4, null);
        if (IIX0o.Oxx0IOOO(xo2.oIX0oI(), II0XooXoX.II0xO0.f30567oIX0oI)) {
            if (xo2.I0Io()) {
                return InternalType.ENUM_NULLABLE;
            }
            return InternalType.ENUM;
        }
        if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.Int")) {
            if (xo2.I0Io()) {
                return InternalType.INT_NULLABLE;
            }
            return InternalType.INT;
        }
        if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.Boolean")) {
            if (xo2.I0Io()) {
                return InternalType.BOOL_NULLABLE;
            }
            return InternalType.BOOL;
        }
        if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.Double")) {
            if (xo2.I0Io()) {
                return InternalType.DOUBLE_NULLABLE;
            }
            return InternalType.DOUBLE;
        }
        if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.Double")) {
            return InternalType.DOUBLE;
        }
        if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.Float")) {
            if (xo2.I0Io()) {
                return InternalType.FLOAT_NULLABLE;
            }
            return InternalType.FLOAT;
        }
        if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.Long")) {
            if (xo2.I0Io()) {
                return InternalType.LONG_NULLABLE;
            }
            return InternalType.LONG;
        }
        if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.String")) {
            if (xo2.I0Io()) {
                return InternalType.STRING_NULLABLE;
            }
            return InternalType.STRING;
        }
        if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.IntArray")) {
            return InternalType.INT_ARRAY;
        }
        if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.DoubleArray")) {
            return InternalType.DOUBLE_ARRAY;
        }
        if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.BooleanArray")) {
            return InternalType.BOOL_ARRAY;
        }
        if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.FloatArray")) {
            return InternalType.FLOAT_ARRAY;
        }
        if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.LongArray")) {
            return InternalType.LONG_ARRAY;
        }
        if (IIX0o.Oxx0IOOO(IIOIX2, kotlinx.serialization.internal.OxxIIOOXO.f30670oIX0oI)) {
            return InternalType.ARRAY;
        }
        if (OxI.IOOoXo0Ix(IIOIX2, kotlinx.serialization.internal.OxxIIOOXO.f30667II0xO0, false, 2, null)) {
            return InternalType.LIST;
        }
        return InternalType.UNKNOWN;
    }
}
