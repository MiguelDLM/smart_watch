package oxOIoIx;

import android.app.Activity;
import android.content.Intent;
import me.devilsen.czxing.code.BarcodeFormat;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public II0xO0 f33561II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public I0Io f33562oIX0oI;

    /* loaded from: classes6.dex */
    public interface I0Io {
        void oIX0oI(Activity activity, String str, BarcodeFormat barcodeFormat);
    }

    /* loaded from: classes6.dex */
    public interface II0xO0 {
        void II0xO0(int i, Intent intent);

        void oIX0oI(Activity activity);
    }

    /* renamed from: oxOIoIx.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1140oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final oIX0oI f33563oIX0oI = new oIX0oI();
    }

    public static oIX0oI oIX0oI() {
        return C1140oIX0oI.f33563oIX0oI;
    }

    public I0Io I0Io() {
        return this.f33562oIX0oI;
    }

    public II0xO0 II0xO0() {
        return this.f33561II0xO0;
    }

    public void X0o0xo(I0Io i0Io) {
        this.f33562oIX0oI = i0Io;
    }

    public void oxoX(II0xO0 iI0xO0) {
        this.f33561II0xO0 = iI0xO0;
    }
}
