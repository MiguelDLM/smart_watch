package xII;

import OXOo.OOXIXo;
import com.bestmafen.baseble.connector.AbsBleConnector;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public abstract class oIX0oI {

    @OOXIXo
    public static final C1150oIX0oI Companion = new C1150oIX0oI(null);
    public static final int DEFAULT_PACKET_SIZE = 20;
    public AbsBleConnector mAbsBleConnector;
    private int mPacketSize = 20;

    /* renamed from: xII.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1150oIX0oI {
        public /* synthetic */ C1150oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public C1150oIX0oI() {
        }
    }

    public abstract void dequeueMessage();

    public abstract void dequeueWritePacket();

    public abstract void enqueueMessage(@OOXIXo II0xO0 iI0xO0);

    @OOXIXo
    public final AbsBleConnector getMAbsBleConnector() {
        AbsBleConnector absBleConnector = this.mAbsBleConnector;
        if (absBleConnector != null) {
            return absBleConnector;
        }
        IIX0o.XOxIOxOx("mAbsBleConnector");
        return null;
    }

    public final int getMPacketSize() {
        return this.mPacketSize;
    }

    public abstract void reset();

    public final void setMAbsBleConnector(@OOXIXo AbsBleConnector absBleConnector) {
        IIX0o.x0xO0oo(absBleConnector, "<set-?>");
        this.mAbsBleConnector = absBleConnector;
    }

    public final void setMPacketSize(int i) {
        this.mPacketSize = i;
    }
}
