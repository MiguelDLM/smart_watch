package kotlinx.coroutines.flow;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.XX;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@XX({"SMAP\nSharingStarted.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharingStarted.kt\nkotlinx/coroutines/flow/StartedWhileSubscribed\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,209:1\n1#2:210\n*E\n"})
/* loaded from: classes6.dex */
public final class StartedWhileSubscribed implements Oxx0xo {

    /* renamed from: I0Io, reason: collision with root package name */
    public final long f30147I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final long f30148II0xO0;

    public StartedWhileSubscribed(long j, long j2) {
        this.f30148II0xO0 = j;
        this.f30147I0Io = j2;
        if (j >= 0) {
            if (j2 >= 0) {
                return;
            }
            throw new IllegalArgumentException(("replayExpiration(" + j2 + " ms) cannot be negative").toString());
        }
        throw new IllegalArgumentException(("stopTimeout(" + j + " ms) cannot be negative").toString());
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
            if (this.f30148II0xO0 == startedWhileSubscribed.f30148II0xO0 && this.f30147I0Io == startedWhileSubscribed.f30147I0Io) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return (androidx.collection.oIX0oI.oIX0oI(this.f30148II0xO0) * 31) + androidx.collection.oIX0oI.oIX0oI(this.f30147I0Io);
    }

    @Override // kotlinx.coroutines.flow.Oxx0xo
    @OXOo.OOXIXo
    public X0o0xo<SharingCommand> oIX0oI(@OXOo.OOXIXo IIXOooo<Integer> iIXOooo) {
        return Oxx0IOOO.Xo0(Oxx0IOOO.xoxXI(Oxx0IOOO.oXxx000(iIXOooo, new StartedWhileSubscribed$command$1(this, null)), new StartedWhileSubscribed$command$2(null)));
    }

    @OXOo.OOXIXo
    public String toString() {
        List xoIox2 = kotlin.collections.oI0IIXIo.xoIox(2);
        if (this.f30148II0xO0 > 0) {
            xoIox2.add("stopTimeout=" + this.f30148II0xO0 + "ms");
        }
        if (this.f30147I0Io < Long.MAX_VALUE) {
            xoIox2.add("replayExpiration=" + this.f30147I0Io + "ms");
        }
        return "SharingStarted.WhileSubscribed(" + CollectionsKt___CollectionsKt.OoIXo(kotlin.collections.oI0IIXIo.oIX0oI(xoIox2), null, null, null, 0, null, null, 63, null) + HexStringBuilder.COMMENT_END_CHAR;
    }
}
