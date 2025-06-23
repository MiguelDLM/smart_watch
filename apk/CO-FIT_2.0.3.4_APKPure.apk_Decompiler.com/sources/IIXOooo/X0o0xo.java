package IIXOooo;

import android.util.Log;
import com.airbnb.lottie.ooOOo0oXI;
import java.util.HashSet;
import java.util.Set;

public class X0o0xo implements ooOOo0oXI {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final Set<String> f27oIX0oI = new HashSet();

    public void I0Io(String str, Throwable th) {
        Set<String> set = f27oIX0oI;
        if (!set.contains(str)) {
            Log.w(com.airbnb.lottie.X0o0xo.f825II0xO0, str, th);
            set.add(str);
        }
    }

    public void II0xO0(String str, Throwable th) {
        if (com.airbnb.lottie.X0o0xo.f830oIX0oI) {
            Log.d(com.airbnb.lottie.X0o0xo.f825II0xO0, str, th);
        }
    }

    public void X0o0xo(String str) {
        oxoX(str, (Throwable) null);
    }

    public void oIX0oI(String str) {
        I0Io(str, (Throwable) null);
    }

    public void oxoX(String str, Throwable th) {
        if (com.airbnb.lottie.X0o0xo.f830oIX0oI) {
            Log.d(com.airbnb.lottie.X0o0xo.f825II0xO0, str, th);
        }
    }
}
