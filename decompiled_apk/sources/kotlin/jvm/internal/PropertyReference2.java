package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;
import kotlin.reflect.IXxxXO;

/* loaded from: classes6.dex */
public abstract class PropertyReference2 extends PropertyReference implements kotlin.reflect.IXxxXO {
    public PropertyReference2() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.I0Io computeReflected() {
        return IO.IIXOooo(this);
    }

    @Override // kotlin.reflect.IXxxXO
    @kotlin.oxxXoxO(version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((kotlin.reflect.IXxxXO) getReflected()).getDelegate(obj, obj2);
    }

    @Override // Oox.x0xO0oo
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public PropertyReference2(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @Override // kotlin.reflect.x0XOIxOo, kotlin.reflect.oO
    public IXxxXO.II0xO0 getGetter() {
        return ((kotlin.reflect.IXxxXO) getReflected()).getGetter();
    }
}
