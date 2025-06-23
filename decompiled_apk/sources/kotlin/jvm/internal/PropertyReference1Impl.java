package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;

/* loaded from: classes6.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    public PropertyReference1Impl(kotlin.reflect.II0XooXoX iI0XooXoX, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((Oxx0xo) iI0XooXoX).oI0IIXIo(), str, str2, !(iI0XooXoX instanceof kotlin.reflect.oxoX) ? 1 : 0);
    }

    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public PropertyReference1Impl(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public PropertyReference1Impl(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
