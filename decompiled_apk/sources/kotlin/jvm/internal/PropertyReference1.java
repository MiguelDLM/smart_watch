package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;
import kotlin.reflect.x0xO0oo;

/* loaded from: classes6.dex */
public abstract class PropertyReference1 extends PropertyReference implements kotlin.reflect.x0xO0oo {
    public PropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.I0Io computeReflected() {
        return IO.OxxIIOOXO(this);
    }

    @Override // kotlin.reflect.x0xO0oo
    @kotlin.oxxXoxO(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((kotlin.reflect.x0xO0oo) getReflected()).getDelegate(obj);
    }

    @Override // Oox.oOoXoXO
    public Object invoke(Object obj) {
        return get(obj);
    }

    @kotlin.oxxXoxO(version = "1.1")
    public PropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.x0XOIxOo, kotlin.reflect.oO
    public x0xO0oo.II0xO0 getGetter() {
        return ((kotlin.reflect.x0xO0oo) getReflected()).getGetter();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public PropertyReference1(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
