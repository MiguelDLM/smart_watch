package x0xO0oo;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class XO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final XO f34088II0xO0 = new XO();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final LruCache<String, com.airbnb.lottie.Oxx0IOOO> f34089oIX0oI = new LruCache<>(20);

    @VisibleForTesting
    public XO() {
    }

    public static XO I0Io() {
        return f34088II0xO0;
    }

    @Nullable
    public com.airbnb.lottie.Oxx0IOOO II0xO0(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f34089oIX0oI.get(str);
    }

    public void X0o0xo(int i) {
        this.f34089oIX0oI.resize(i);
    }

    public void oIX0oI() {
        this.f34089oIX0oI.evictAll();
    }

    public void oxoX(@Nullable String str, com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
        if (str == null) {
            return;
        }
        this.f34089oIX0oI.put(str, oxx0IOOO);
    }
}
