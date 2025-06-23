package O0xO0;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;
import xx0o0O.XO;

@XX({"SMAP\nCancellationException.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellationException.kt\nkotlin/coroutines/cancellation/CancellationExceptionKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
/* loaded from: classes6.dex */
public final class oIX0oI {
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final CancellationException II0xO0(Throwable th) {
        String str;
        if (th != null) {
            str = th.toString();
        } else {
            str = null;
        }
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final CancellationException oIX0oI(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static /* synthetic */ void I0Io() {
    }
}
