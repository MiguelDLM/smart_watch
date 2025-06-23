package kotlinx.coroutines.internal;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.coroutines.CoroutineContext;

@kotlin.o0
/* loaded from: classes6.dex */
public final class XoX implements CoroutineContext.II0xO0<oxxXoxO<?>> {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ThreadLocal<?> f30288XO;

    public XoX(@OXOo.OOXIXo ThreadLocal<?> threadLocal) {
        this.f30288XO = threadLocal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ XoX I0Io(XoX xoX2, ThreadLocal threadLocal, int i, Object obj) {
        if ((i & 1) != 0) {
            threadLocal = xoX2.f30288XO;
        }
        return xoX2.II0xO0(threadLocal);
    }

    @OXOo.OOXIXo
    public final XoX II0xO0(@OXOo.OOXIXo ThreadLocal<?> threadLocal) {
        return new XoX(threadLocal);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof XoX) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f30288XO, ((XoX) obj).f30288XO);
    }

    public int hashCode() {
        return this.f30288XO.hashCode();
    }

    public final ThreadLocal<?> oIX0oI() {
        return this.f30288XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f30288XO + HexStringBuilder.COMMENT_END_CHAR;
    }
}
