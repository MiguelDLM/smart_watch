package androidx.room;

import Oox.oOoXoXO;
import android.os.CancellationSignal;
import androidx.sqlite.db.SupportSQLiteCompat;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.oXIO0o0XI;

public final class CoroutinesRoom$Companion$execute$4$1 extends Lambda implements oOoXoXO<Throwable, oXIO0o0XI> {
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ kotlinx.coroutines.oXIO0o0XI $job;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$execute$4$1(CancellationSignal cancellationSignal, kotlinx.coroutines.oXIO0o0XI oxio0o0xi) {
        super(1);
        this.$cancellationSignal = cancellationSignal;
        this.$job = oxio0o0xi;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final void invoke(@OXOo.oOoXoXO Throwable th) {
        CancellationSignal cancellationSignal = this.$cancellationSignal;
        if (cancellationSignal != null) {
            SupportSQLiteCompat.Api16Impl.cancel(cancellationSignal);
        }
        oXIO0o0XI.oIX0oI.II0xO0(this.$job, (CancellationException) null, 1, (Object) null);
    }
}
