package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.List;
import kotlin.reflect.KVariance;

/* loaded from: classes6.dex */
public class xII {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f29373oIX0oI = "kotlin.jvm.functions.";

    public kotlin.reflect.xxIXOIIO I0Io(FunctionReference functionReference) {
        return functionReference;
    }

    public kotlin.reflect.OOXIXo II0XooXoX(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public kotlin.reflect.oxoX II0xO0(Class cls, String str) {
        return new oI0IIXIo(cls);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public void IXxxXO(kotlin.reflect.oI0IIXIo oi0iixio, List<kotlin.reflect.Oxx0xo> list) {
        ((oxXx0IX) oi0iixio).I0Io(list);
    }

    @kotlin.oxxXoxO(version = "1.6")
    public kotlin.reflect.Oxx0xo OOXIXo(kotlin.reflect.Oxx0xo oxx0xo) {
        TypeReference typeReference = (TypeReference) oxx0xo;
        return new TypeReference(oxx0xo.IXxxXO(), oxx0xo.getArguments(), typeReference.XIxXXX0x0(), typeReference.X0IIOO() | 4);
    }

    @kotlin.oxxXoxO(version = "1.1")
    public String Oo(Lambda lambda) {
        return x0xO0oo(lambda);
    }

    @kotlin.oxxXoxO(version = "1.6")
    public kotlin.reflect.Oxx0xo Oxx0IOOO(kotlin.reflect.Oxx0xo oxx0xo) {
        TypeReference typeReference = (TypeReference) oxx0xo;
        return new TypeReference(oxx0xo.IXxxXO(), oxx0xo.getArguments(), typeReference.XIxXXX0x0(), typeReference.X0IIOO() | 2);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public kotlin.reflect.Oxx0xo Oxx0xo(kotlin.reflect.Oxx0IOOO oxx0IOOO, List<kotlin.reflect.OxxIIOOXO> list, boolean z) {
        return new TypeReference(oxx0IOOO, list, z);
    }

    public kotlin.reflect.oxoX X0o0xo(Class cls, String str) {
        return new oI0IIXIo(cls);
    }

    public kotlin.reflect.II0XooXoX XO(Class cls, String str) {
        return new Xx000oIo(cls, str);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public kotlin.reflect.oI0IIXIo oI0IIXIo(Object obj, String str, KVariance kVariance, boolean z) {
        return new oxXx0IX(obj, str, kVariance, z);
    }

    public kotlin.reflect.oxoX oIX0oI(Class cls) {
        return new oI0IIXIo(cls);
    }

    public kotlin.reflect.IXxxXO oO(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    @kotlin.oxxXoxO(version = "1.6")
    public kotlin.reflect.Oxx0xo oOoXoXO(kotlin.reflect.Oxx0xo oxx0xo, kotlin.reflect.Oxx0xo oxx0xo2) {
        return new TypeReference(oxx0xo.IXxxXO(), oxx0xo.getArguments(), oxx0xo2, ((TypeReference) oxx0xo).X0IIOO());
    }

    public kotlin.reflect.oO ooOOo0oXI(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public kotlin.reflect.oxoX oxoX(Class cls) {
        return new oI0IIXIo(cls);
    }

    public kotlin.reflect.x0xO0oo x0XOIxOo(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    @kotlin.oxxXoxO(version = "1.3")
    public String x0xO0oo(XIxXXX0x0 xIxXXX0x0) {
        String obj = xIxXXX0x0.getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith(f29373oIX0oI)) {
            return obj.substring(21);
        }
        return obj;
    }

    public kotlin.reflect.ooOOo0oXI xoIox(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    public kotlin.reflect.oOoXoXO xxIXOIIO(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }
}
