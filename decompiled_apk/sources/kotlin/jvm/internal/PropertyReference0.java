package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;
import kotlin.reflect.oO;

/* loaded from: classes6.dex */
public abstract class PropertyReference0 extends PropertyReference implements kotlin.reflect.oO {
    public PropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.I0Io computeReflected() {
        return IO.oI0IIXIo(this);
    }

    @Override // kotlin.reflect.oO
    @kotlin.oxxXoxO(version = "1.1")
    public Object getDelegate() {
        return ((kotlin.reflect.oO) getReflected()).getDelegate();
    }

    @Override // Oox.oIX0oI
    public Object invoke() {
        return get();
    }

    @kotlin.oxxXoxO(version = "1.1")
    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.x0XOIxOo, kotlin.reflect.oO
    public oO.II0xO0 getGetter() {
        return ((kotlin.reflect.oO) getReflected()).getGetter();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public PropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
