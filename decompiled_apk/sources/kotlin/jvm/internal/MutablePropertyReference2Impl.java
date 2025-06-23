package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;

/* loaded from: classes6.dex */
public class MutablePropertyReference2Impl extends MutablePropertyReference2 {
    public MutablePropertyReference2Impl(kotlin.reflect.II0XooXoX iI0XooXoX, String str, String str2) {
        super(((Oxx0xo) iI0XooXoX).oI0IIXIo(), str, str2, !(iI0XooXoX instanceof kotlin.reflect.oxoX) ? 1 : 0);
    }

    @Override // kotlin.reflect.IXxxXO
    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }

    @Override // kotlin.reflect.ooOOo0oXI
    public void set(Object obj, Object obj2, Object obj3) {
        getSetter().call(obj, obj2, obj3);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public MutablePropertyReference2Impl(Class cls, String str, String str2, int i) {
        super(cls, str, str2, i);
    }
}
