package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;

/* loaded from: classes6.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(kotlin.reflect.II0XooXoX iI0XooXoX, String str, String str2) {
        super(((Oxx0xo) iI0XooXoX).oI0IIXIo(), str, str2, !(iI0XooXoX instanceof kotlin.reflect.oxoX) ? 1 : 0);
    }

    @Override // kotlin.reflect.IXxxXO
    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public PropertyReference2Impl(Class cls, String str, String str2, int i) {
        super(cls, str, str2, i);
    }
}
