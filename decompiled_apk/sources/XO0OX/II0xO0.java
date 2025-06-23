package XO0OX;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.lang.annotation.Annotation;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.oxxXoxO;

@xxIXOIIO(name = "JvmClassMappingKt")
/* loaded from: classes6.dex */
public final class II0xO0 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @OXOo.oOoXoXO
    public static final <T> Class<T> II0XooXoX(@OXOo.OOXIXo kotlin.reflect.oxoX<T> oxox) {
        IIX0o.x0xO0oo(oxox, "<this>");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.Oxx0xo) oxox).oI0IIXIo();
        if (cls.isPrimitive()) {
            IIX0o.x0XOIxOo(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    public static final <E extends Enum<E>> Class<E> II0xO0(Enum<E> r1) {
        IIX0o.x0xO0oo(r1, "<this>");
        Class<E> declaringClass = r1.getDeclaringClass();
        IIX0o.oO(declaringClass, "getDeclaringClass(...)");
        return declaringClass;
    }

    @OXOo.OOXIXo
    public static final <T> Class<T> Oxx0IOOO(@OXOo.OOXIXo kotlin.reflect.oxoX<T> oxox) {
        IIX0o.x0xO0oo(oxox, "<this>");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.Oxx0xo) oxox).oI0IIXIo();
        if (!cls.isPrimitive()) {
            IIX0o.x0XOIxOo(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    cls = (Class<T>) Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                    cls = (Class<T>) Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    cls = (Class<T>) Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    cls = (Class<T>) Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    cls = (Class<T>) Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    cls = (Class<T>) Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                    cls = (Class<T>) Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals(TypedValues.Custom.S_FLOAT)) {
                    cls = (Class<T>) Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    cls = (Class<T>) Short.class;
                    break;
                }
                break;
        }
        IIX0o.x0XOIxOo(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return cls;
    }

    @OXOo.OOXIXo
    @xxIXOIIO(name = "getJavaClass")
    public static final <T> Class<T> X0o0xo(@OXOo.OOXIXo kotlin.reflect.oxoX<T> oxox) {
        IIX0o.x0xO0oo(oxox, "<this>");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.Oxx0xo) oxox).oI0IIXIo();
        IIX0o.x0XOIxOo(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return cls;
    }

    @OXOo.OOXIXo
    public static final <T extends Annotation> kotlin.reflect.oxoX<? extends T> oIX0oI(@OXOo.OOXIXo T t) {
        IIX0o.x0xO0oo(t, "<this>");
        Class<? extends Annotation> annotationType = t.annotationType();
        IIX0o.oO(annotationType, "annotationType(...)");
        kotlin.reflect.oxoX<? extends T> xxIXOIIO2 = xxIXOIIO(annotationType);
        IIX0o.x0XOIxOo(xxIXOIIO2, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return xxIXOIIO2;
    }

    public static final /* synthetic */ boolean oOoXoXO(Object[] objArr) {
        IIX0o.x0xO0oo(objArr, "<this>");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }

    @OXOo.OOXIXo
    public static final <T> Class<T> oxoX(@OXOo.OOXIXo T t) {
        IIX0o.x0xO0oo(t, "<this>");
        Class<T> cls = (Class<T>) t.getClass();
        IIX0o.x0XOIxOo(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return cls;
    }

    @OXOo.OOXIXo
    @xxIXOIIO(name = "getRuntimeClassOfKClassInstance")
    public static final <T> Class<kotlin.reflect.oxoX<T>> xoIox(@OXOo.OOXIXo kotlin.reflect.oxoX<T> oxox) {
        IIX0o.x0xO0oo(oxox, "<this>");
        Class<kotlin.reflect.oxoX<T>> cls = (Class<kotlin.reflect.oxoX<T>>) oxox.getClass();
        IIX0o.x0XOIxOo(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return cls;
    }

    @OXOo.OOXIXo
    @xxIXOIIO(name = "getKotlinClass")
    public static final <T> kotlin.reflect.oxoX<T> xxIXOIIO(@OXOo.OOXIXo Class<T> cls) {
        IIX0o.x0xO0oo(cls, "<this>");
        return IO.oxoX(cls);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.7")
    public static /* synthetic */ void I0Io(Enum r0) {
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @XX(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void OOXIXo(kotlin.reflect.oxoX oxox) {
    }

    public static /* synthetic */ void XO(kotlin.reflect.oxoX oxox) {
    }
}
