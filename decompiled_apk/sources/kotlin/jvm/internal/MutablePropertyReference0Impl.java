package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;

/* loaded from: classes6.dex */
public class MutablePropertyReference0Impl extends MutablePropertyReference0 {
    public MutablePropertyReference0Impl(kotlin.reflect.II0XooXoX iI0XooXoX, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((Oxx0xo) iI0XooXoX).oI0IIXIo(), str, str2, !(iI0XooXoX instanceof kotlin.reflect.oxoX) ? 1 : 0);
    }

    @Override // kotlin.reflect.oO
    public Object get() {
        return getGetter().call(new Object[0]);
    }

    @Override // kotlin.reflect.OOXIXo
    public void set(Object obj) {
        getSetter().call(obj);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public MutablePropertyReference0Impl(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public MutablePropertyReference0Impl(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
