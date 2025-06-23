package androidx.room;

import OXOo.OOXIXo;
import androidx.room.InvalidationTracker;
import java.util.Set;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.Oxx0IOOO;

public final class CoroutinesRoom$Companion$createFlow$1$1$observer$1 extends InvalidationTracker.Observer {
    final /* synthetic */ Oxx0IOOO<oXIO0o0XI> $observerChannel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$createFlow$1$1$observer$1(String[] strArr, Oxx0IOOO<oXIO0o0XI> oxx0IOOO) {
        super(strArr);
        this.$observerChannel = oxx0IOOO;
    }

    public void onInvalidated(@OOXIXo Set<String> set) {
        this.$observerChannel.x0xO0oo(oXIO0o0XI.f19155oIX0oI);
    }
}
