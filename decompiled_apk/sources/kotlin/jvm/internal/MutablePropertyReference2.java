package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;
import kotlin.reflect.IXxxXO;
import kotlin.reflect.ooOOo0oXI;

/* loaded from: classes6.dex */
public abstract class MutablePropertyReference2 extends MutablePropertyReference implements kotlin.reflect.ooOOo0oXI {
    public MutablePropertyReference2() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.I0Io computeReflected() {
        return IO.oOoXoXO(this);
    }

    @Override // kotlin.reflect.IXxxXO
    @kotlin.oxxXoxO(version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((kotlin.reflect.ooOOo0oXI) getReflected()).getDelegate(obj, obj2);
    }

    @Override // Oox.x0xO0oo
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public MutablePropertyReference2(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @Override // kotlin.reflect.x0XOIxOo, kotlin.reflect.oO
    public IXxxXO.II0xO0 getGetter() {
        return ((kotlin.reflect.ooOOo0oXI) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.xoIox, kotlin.reflect.OOXIXo
    public ooOOo0oXI.II0xO0 getSetter() {
        return ((kotlin.reflect.ooOOo0oXI) getReflected()).getSetter();
    }
}
