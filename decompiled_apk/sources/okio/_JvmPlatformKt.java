package okio;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.xxX;

/* loaded from: classes6.dex */
public final class _JvmPlatformKt {
    @OXOo.OOXIXo
    public static final byte[] asUtf8ToByteArray(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        byte[] bytes = str.getBytes(kotlin.text.oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @OXOo.OOXIXo
    public static final ReentrantLock newLock() {
        return new ReentrantLock();
    }

    @OXOo.OOXIXo
    public static final String toUtf8String(@OXOo.OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<this>");
        return new String(bArr, kotlin.text.oxoX.f29581II0xO0);
    }

    public static final <T> T withLock(@OXOo.OOXIXo ReentrantLock reentrantLock, @OXOo.OOXIXo Oox.oIX0oI<? extends T> action) {
        IIX0o.x0xO0oo(reentrantLock, "<this>");
        IIX0o.x0xO0oo(action, "action");
        reentrantLock.lock();
        try {
            return action.invoke();
        } finally {
            xxX.oxoX(1);
            reentrantLock.unlock();
            xxX.I0Io(1);
        }
    }
}
