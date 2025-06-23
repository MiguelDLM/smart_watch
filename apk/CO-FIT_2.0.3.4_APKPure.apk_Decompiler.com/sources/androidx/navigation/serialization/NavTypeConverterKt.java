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

public final class NavTypeConverterKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|45) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.navigation.serialization.InternalType[] r0 = androidx.navigation.serialization.InternalType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.INT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.BOOL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.LONG     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.STRING     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.STRING_NULLABLE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.ENUM     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.INT_NULLABLE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.BOOL_NULLABLE     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.DOUBLE_NULLABLE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.FLOAT_NULLABLE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.LONG_NULLABLE     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.INT_ARRAY     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.BOOL_ARRAY     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.DOUBLE_ARRAY     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.FLOAT_ARRAY     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.LONG_ARRAY     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.ARRAY     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.LIST     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.ENUM_NULLABLE     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.serialization.NavTypeConverterKt.WhenMappings.<clinit>():void");
        }
    }

    private static final Class<?> getClass(XO xo2) {
        String IIOIX2 = OxI.IIOIX(xo2.xxIXOIIO(), LocationInfo.NA, "", false, 4, (Object) null);
        try {
            Class<?> cls = Class.forName(IIOIX2);
            IIX0o.oO(cls, "forName(className)");
            return cls;
        } catch (ClassNotFoundException unused) {
            while (StringsKt__StringsKt.o00xOoIO(IIOIX2, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, (Object) null)) {
                IIOIX2 = new Regex("(\\.+)(?!.*\\.)").replace((CharSequence) IIOIX2, "\\$");
                Class<?> cls2 = Class.forName(IIOIX2);
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

    public static final boolean matchKType(@OOXIXo XO xo2, @OOXIXo Oxx0xo oxx0xo) {
        IIX0o.x0xO0oo(xo2, "<this>");
        IIX0o.x0xO0oo(oxx0xo, "kType");
        if (xo2.I0Io() != oxx0xo.ooOOo0oXI()) {
            return false;
        }
        Oxx0IOOO<Object> x0xO0oo2 = OxxIIOOXO.x0xO0oo(oxx0xo);
        if (x0xO0oo2 != null) {
            return IIX0o.Oxx0IOOO(xo2, x0xO0oo2.oIX0oI());
        }
        throw new IllegalStateException("Custom serializers declared directly on a class field via @Serializable(with = ...) is currently not supported by safe args for both custom types and third-party types. Please use @Serializable or @Serializable(with = ...) on the class or object declaration.");
    }

    private static final InternalType toInternalType(XO xo2) {
        String IIOIX2 = OxI.IIOIX(xo2.xxIXOIIO(), LocationInfo.NA, "", false, 4, (Object) null);
        if (IIX0o.Oxx0IOOO(xo2.oIX0oI(), II0XooXoX.II0xO0.f20330oIX0oI)) {
            if (xo2.I0Io()) {
                return InternalType.ENUM_NULLABLE;
            }
            return InternalType.ENUM;
        } else if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.Int")) {
            if (xo2.I0Io()) {
                return InternalType.INT_NULLABLE;
            }
            return InternalType.INT;
        } else if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.Boolean")) {
            if (xo2.I0Io()) {
                return InternalType.BOOL_NULLABLE;
            }
            return InternalType.BOOL;
        } else if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.Double")) {
            if (xo2.I0Io()) {
                return InternalType.DOUBLE_NULLABLE;
            }
            return InternalType.DOUBLE;
        } else if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.Double")) {
            return InternalType.DOUBLE;
        } else {
            if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.Float")) {
                if (xo2.I0Io()) {
                    return InternalType.FLOAT_NULLABLE;
                }
                return InternalType.FLOAT;
            } else if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.Long")) {
                if (xo2.I0Io()) {
                    return InternalType.LONG_NULLABLE;
                }
                return InternalType.LONG;
            } else if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.String")) {
                if (xo2.I0Io()) {
                    return InternalType.STRING_NULLABLE;
                }
                return InternalType.STRING;
            } else if (IIX0o.Oxx0IOOO(IIOIX2, "kotlin.IntArray")) {
                return InternalType.INT_ARRAY;
            } else {
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
                if (IIX0o.Oxx0IOOO(IIOIX2, kotlinx.serialization.internal.OxxIIOOXO.f20433oIX0oI)) {
                    return InternalType.ARRAY;
                }
                if (OxI.IOOoXo0Ix(IIOIX2, kotlinx.serialization.internal.OxxIIOOXO.f20430II0xO0, false, 2, (Object) null)) {
                    return InternalType.LIST;
                }
                return InternalType.UNKNOWN;
            }
        }
    }
}
