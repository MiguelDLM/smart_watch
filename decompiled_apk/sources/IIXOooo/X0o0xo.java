package IIXOooo;

import android.util.Log;
import com.airbnb.lottie.ooOOo0oXI;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class X0o0xo implements ooOOo0oXI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final Set<String> f311oIX0oI = new HashSet();

    @Override // com.airbnb.lottie.ooOOo0oXI
    public void I0Io(String str, Throwable th) {
        Set<String> set = f311oIX0oI;
        if (set.contains(str)) {
            return;
        }
        Log.w(com.airbnb.lottie.X0o0xo.f4819II0xO0, str, th);
        set.add(str);
    }

    @Override // com.airbnb.lottie.ooOOo0oXI
    public void II0xO0(String str, Throwable th) {
        if (com.airbnb.lottie.X0o0xo.f4824oIX0oI) {
            Log.d(com.airbnb.lottie.X0o0xo.f4819II0xO0, str, th);
        }
    }

    @Override // com.airbnb.lottie.ooOOo0oXI
    public void X0o0xo(String str) {
        oxoX(str, null);
    }

    @Override // com.airbnb.lottie.ooOOo0oXI
    public void oIX0oI(String str) {
        I0Io(str, null);
    }

    @Override // com.airbnb.lottie.ooOOo0oXI
    public void oxoX(String str, Throwable th) {
        if (com.airbnb.lottie.X0o0xo.f4824oIX0oI) {
            Log.d(com.airbnb.lottie.X0o0xo.f4819II0xO0, str, th);
        }
    }
}
