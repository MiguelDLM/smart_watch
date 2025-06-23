package kotlinx.coroutines.debug.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.io.Serializable;
import java.lang.Thread;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.o0;
import kotlinx.coroutines.IO;
import kotlinx.coroutines.X00IoxXI;

@o0
/* loaded from: classes6.dex */
public final class DebuggerInfo implements Serializable {

    @oOoXoXO
    private final Long coroutineId;

    @oOoXoXO
    private final String dispatcher;

    @OOXIXo
    private final List<StackTraceElement> lastObservedStackTrace;

    @oOoXoXO
    private final String lastObservedThreadName;

    @oOoXoXO
    private final String lastObservedThreadState;

    @oOoXoXO
    private final String name;
    private final long sequenceNumber;

    @OOXIXo
    private final String state;

    public DebuggerInfo(@OOXIXo DebugCoroutineInfoImpl debugCoroutineInfoImpl, @OOXIXo CoroutineContext coroutineContext) {
        Long l;
        String str;
        String str2;
        String str3;
        Thread.State state;
        X00IoxXI x00IoxXI = (X00IoxXI) coroutineContext.get(X00IoxXI.f29749Oo);
        if (x00IoxXI != null) {
            l = Long.valueOf(x00IoxXI.X0IIOO());
        } else {
            l = null;
        }
        this.coroutineId = l;
        kotlin.coroutines.oxoX oxox = (kotlin.coroutines.oxoX) coroutineContext.get(kotlin.coroutines.oxoX.f29196Oxx0IOOO);
        if (oxox != null) {
            str = oxox.toString();
        } else {
            str = null;
        }
        this.dispatcher = str;
        IO io2 = (IO) coroutineContext.get(IO.f29691Oo);
        if (io2 != null) {
            str2 = io2.getName();
        } else {
            str2 = null;
        }
        this.name = str2;
        this.state = debugCoroutineInfoImpl.Oxx0IOOO();
        Thread thread = debugCoroutineInfoImpl.lastObservedThread;
        if (thread != null && (state = thread.getState()) != null) {
            str3 = state.toString();
        } else {
            str3 = null;
        }
        this.lastObservedThreadState = str3;
        Thread thread2 = debugCoroutineInfoImpl.lastObservedThread;
        this.lastObservedThreadName = thread2 != null ? thread2.getName() : null;
        this.lastObservedStackTrace = debugCoroutineInfoImpl.II0XooXoX();
        this.sequenceNumber = debugCoroutineInfoImpl.f29914II0xO0;
    }

    @oOoXoXO
    public final Long getCoroutineId() {
        return this.coroutineId;
    }

    @oOoXoXO
    public final String getDispatcher() {
        return this.dispatcher;
    }

    @OOXIXo
    public final List<StackTraceElement> getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    @oOoXoXO
    public final String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    @oOoXoXO
    public final String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    @oOoXoXO
    public final String getName() {
        return this.name;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    @OOXIXo
    public final String getState() {
        return this.state;
    }
}
