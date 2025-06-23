package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.Arrays;
import java.util.Collections;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.reflect.KVariance;

/* loaded from: classes6.dex */
public class IO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final kotlin.reflect.oxoX[] f29279I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f29280II0xO0 = " (Kotlin reflection is not available)";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final xII f29281oIX0oI;

    static {
        xII xii = null;
        try {
            xii = (xII) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (xii == null) {
            xii = new xII();
        }
        f29281oIX0oI = xii;
        f29279I0Io = new kotlin.reflect.oxoX[0];
    }

    public static kotlin.reflect.xxIXOIIO I0Io(FunctionReference functionReference) {
        return f29281oIX0oI.I0Io(functionReference);
    }

    public static kotlin.reflect.II0XooXoX II0XooXoX(Class cls, String str) {
        return f29281oIX0oI.XO(cls, str);
    }

    public static kotlin.reflect.oxoX II0xO0(Class cls, String str) {
        return f29281oIX0oI.II0xO0(cls, str);
    }

    public static kotlin.reflect.IXxxXO IIXOooo(PropertyReference2 propertyReference2) {
        return f29281oIX0oI.oO(propertyReference2);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.Oxx0xo IXxxXO(kotlin.reflect.Oxx0IOOO oxx0IOOO) {
        return f29281oIX0oI.Oxx0xo(oxx0IOOO, Collections.emptyList(), true);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static void O0xOxO(kotlin.reflect.oI0IIXIo oi0iixio, kotlin.reflect.Oxx0xo... oxx0xoArr) {
        f29281oIX0oI.IXxxXO(oi0iixio, ArraysKt___ArraysKt.IoXOX(oxx0xoArr));
    }

    public static kotlin.reflect.oOoXoXO OOXIXo(MutablePropertyReference1 mutablePropertyReference1) {
        return f29281oIX0oI.xxIXOIIO(mutablePropertyReference1);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.Oxx0xo Oo(Class cls, kotlin.reflect.OxxIIOOXO... oxxIIOOXOArr) {
        return f29281oIX0oI.Oxx0xo(oxoX(cls), ArraysKt___ArraysKt.IoXOX(oxxIIOOXOArr), true);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static void OxI(kotlin.reflect.oI0IIXIo oi0iixio, kotlin.reflect.Oxx0xo oxx0xo) {
        f29281oIX0oI.IXxxXO(oi0iixio, Collections.singletonList(oxx0xo));
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.II0XooXoX Oxx0IOOO(Class cls) {
        return f29281oIX0oI.XO(cls, "");
    }

    @kotlin.oxxXoxO(version = "1.6")
    public static kotlin.reflect.Oxx0xo Oxx0xo(kotlin.reflect.Oxx0xo oxx0xo, kotlin.reflect.Oxx0xo oxx0xo2) {
        return f29281oIX0oI.oOoXoXO(oxx0xo, oxx0xo2);
    }

    public static kotlin.reflect.x0xO0oo OxxIIOOXO(PropertyReference1 propertyReference1) {
        return f29281oIX0oI.x0XOIxOo(propertyReference1);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.Oxx0xo X0IIOO(Class cls) {
        return f29281oIX0oI.Oxx0xo(oxoX(cls), Collections.emptyList(), false);
    }

    public static kotlin.reflect.oxoX X0o0xo(Class cls, String str) {
        return f29281oIX0oI.X0o0xo(cls, str);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.Oxx0xo XI0IXoo(Class cls, kotlin.reflect.OxxIIOOXO oxxIIOOXO) {
        return f29281oIX0oI.Oxx0xo(oxoX(cls), Collections.singletonList(oxxIIOOXO), false);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.Oxx0xo XIxXXX0x0(Class cls, kotlin.reflect.OxxIIOOXO oxxIIOOXO, kotlin.reflect.OxxIIOOXO oxxIIOOXO2) {
        return f29281oIX0oI.Oxx0xo(oxoX(cls), Arrays.asList(oxxIIOOXO, oxxIIOOXO2), false);
    }

    public static kotlin.reflect.oxoX[] XO(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return f29279I0Io;
        }
        kotlin.reflect.oxoX[] oxoxArr = new kotlin.reflect.oxoX[length];
        for (int i = 0; i < length; i++) {
            oxoxArr[i] = oxoX(clsArr[i]);
        }
        return oxoxArr;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.Oxx0xo XxX0x0xxx(kotlin.reflect.Oxx0IOOO oxx0IOOO) {
        return f29281oIX0oI.Oxx0xo(oxx0IOOO, Collections.emptyList(), false);
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static String o00(Lambda lambda) {
        return f29281oIX0oI.Oo(lambda);
    }

    public static kotlin.reflect.oO oI0IIXIo(PropertyReference0 propertyReference0) {
        return f29281oIX0oI.ooOOo0oXI(propertyReference0);
    }

    public static kotlin.reflect.oxoX oIX0oI(Class cls) {
        return f29281oIX0oI.oIX0oI(cls);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.Oxx0xo oO(Class cls, kotlin.reflect.OxxIIOOXO oxxIIOOXO) {
        return f29281oIX0oI.Oxx0xo(oxoX(cls), Collections.singletonList(oxxIIOOXO), true);
    }

    public static kotlin.reflect.ooOOo0oXI oOoXoXO(MutablePropertyReference2 mutablePropertyReference2) {
        return f29281oIX0oI.xoIox(mutablePropertyReference2);
    }

    @kotlin.oxxXoxO(version = "1.6")
    public static kotlin.reflect.Oxx0xo ooOOo0oXI(kotlin.reflect.Oxx0xo oxx0xo) {
        return f29281oIX0oI.OOXIXo(oxx0xo);
    }

    public static kotlin.reflect.oxoX oxoX(Class cls) {
        return f29281oIX0oI.oxoX(cls);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.Oxx0xo x0XOIxOo(Class cls) {
        return f29281oIX0oI.Oxx0xo(oxoX(cls), Collections.emptyList(), true);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.Oxx0xo x0xO0oo(Class cls, kotlin.reflect.OxxIIOOXO oxxIIOOXO, kotlin.reflect.OxxIIOOXO oxxIIOOXO2) {
        return f29281oIX0oI.Oxx0xo(oxoX(cls), Arrays.asList(oxxIIOOXO, oxxIIOOXO2), true);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.oI0IIXIo xXxxox0I(Object obj, String str, KVariance kVariance, boolean z) {
        return f29281oIX0oI.oI0IIXIo(obj, str, kVariance, z);
    }

    public static kotlin.reflect.OOXIXo xoIox(MutablePropertyReference0 mutablePropertyReference0) {
        return f29281oIX0oI.II0XooXoX(mutablePropertyReference0);
    }

    @kotlin.oxxXoxO(version = "1.3")
    public static String xoXoI(XIxXXX0x0 xIxXXX0x0) {
        return f29281oIX0oI.x0xO0oo(xIxXXX0x0);
    }

    @kotlin.oxxXoxO(version = "1.6")
    public static kotlin.reflect.Oxx0xo xxIXOIIO(kotlin.reflect.Oxx0xo oxx0xo) {
        return f29281oIX0oI.Oxx0IOOO(oxx0xo);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.Oxx0xo xxX(Class cls, kotlin.reflect.OxxIIOOXO... oxxIIOOXOArr) {
        return f29281oIX0oI.Oxx0xo(oxoX(cls), ArraysKt___ArraysKt.IoXOX(oxxIIOOXOArr), false);
    }
}
