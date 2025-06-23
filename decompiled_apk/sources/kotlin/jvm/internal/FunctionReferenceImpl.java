package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;

/* loaded from: classes6.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i, kotlin.reflect.II0XooXoX iI0XooXoX, String str, String str2) {
        super(i, CallableReference.NO_RECEIVER, ((Oxx0xo) iI0XooXoX).oI0IIXIo(), str, str2, !(iI0XooXoX instanceof kotlin.reflect.oxoX) ? 1 : 0);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public FunctionReferenceImpl(int i, Class cls, String str, String str2, int i2) {
        super(i, CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public FunctionReferenceImpl(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(i, obj, cls, str, str2, i2);
    }
}
