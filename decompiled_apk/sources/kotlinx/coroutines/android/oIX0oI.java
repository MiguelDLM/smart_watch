package kotlinx.coroutines.android;

import OXOo.OOXIXo;
import android.os.Looper;
import java.util.List;
import kotlinx.coroutines.internal.O0xOxO;
import kotlinx.coroutines.internal.XI0IXoo;
import kotlinx.coroutines.o0oIxOo;

/* loaded from: classes6.dex */
public final class oIX0oI implements XI0IXoo {
    @Override // kotlinx.coroutines.internal.XI0IXoo
    @OOXIXo
    public o0oIxOo I0Io(@OOXIXo List<? extends XI0IXoo> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new HandlerContext(XO.X0o0xo(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // kotlinx.coroutines.internal.XI0IXoo
    @OOXIXo
    public String II0xO0() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // kotlinx.coroutines.internal.XI0IXoo
    public int oIX0oI() {
        return O0xOxO.f30252xoIox;
    }
}
