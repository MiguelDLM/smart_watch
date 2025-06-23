package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;
import kotlin.reflect.OOXIXo;
import kotlin.reflect.oO;

/* loaded from: classes6.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements kotlin.reflect.OOXIXo {
    public MutablePropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.I0Io computeReflected() {
        return IO.xoIox(this);
    }

    @Override // kotlin.reflect.oO
    @kotlin.oxxXoxO(version = "1.1")
    public Object getDelegate() {
        return ((kotlin.reflect.OOXIXo) getReflected()).getDelegate();
    }

    @Override // Oox.oIX0oI
    public Object invoke() {
        return get();
    }

    @kotlin.oxxXoxO(version = "1.1")
    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.x0XOIxOo, kotlin.reflect.oO
    public oO.II0xO0 getGetter() {
        return ((kotlin.reflect.OOXIXo) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.xoIox, kotlin.reflect.OOXIXo
    public OOXIXo.II0xO0 getSetter() {
        return ((kotlin.reflect.OOXIXo) getReflected()).getSetter();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
