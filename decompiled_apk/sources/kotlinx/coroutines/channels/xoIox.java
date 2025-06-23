package kotlinx.coroutines.channels;

import com.facebook.internal.AnalyticsEvents;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.o0;
import kotlinx.coroutines.OX00O0xII;

@XO0OX.Oxx0IOOO
/* loaded from: classes6.dex */
public final class xoIox<T> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Object f29892oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final II0xO0 f29891II0xO0 = new II0xO0(null);

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final I0Io f29890I0Io = new I0Io();

    /* loaded from: classes6.dex */
    public static class I0Io {
        @OXOo.OOXIXo
        public String toString() {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED;
        }
    }

    @OX00O0xII
    /* loaded from: classes6.dex */
    public static final class II0xO0 {
        public /* synthetic */ II0xO0(IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        @OX00O0xII
        public final <E> Object I0Io(E e) {
            return xoIox.I0Io(e);
        }

        @OXOo.OOXIXo
        @OX00O0xII
        public final <E> Object II0xO0() {
            return xoIox.I0Io(xoIox.f29890I0Io);
        }

        @OXOo.OOXIXo
        @OX00O0xII
        public final <E> Object oIX0oI(@OXOo.oOoXoXO Throwable th) {
            return xoIox.I0Io(new oIX0oI(th));
        }

        public II0xO0() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI extends I0Io {

        /* renamed from: oIX0oI, reason: collision with root package name */
        @XO0OX.XO
        @OXOo.oOoXoXO
        public final Throwable f29893oIX0oI;

        public oIX0oI(@OXOo.oOoXoXO Throwable th) {
            this.f29893oIX0oI = th;
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if ((obj instanceof oIX0oI) && IIX0o.Oxx0IOOO(this.f29893oIX0oI, ((oIX0oI) obj).f29893oIX0oI)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Throwable th = this.f29893oIX0oI;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.xoIox.I0Io
        @OXOo.OOXIXo
        public String toString() {
            return "Closed(" + this.f29893oIX0oI + HexStringBuilder.COMMENT_END_CHAR;
        }
    }

    @o0
    public /* synthetic */ xoIox(Object obj) {
        this.f29892oIX0oI = obj;
    }

    @OXOo.OOXIXo
    @o0
    public static <T> Object I0Io(@OXOo.oOoXoXO Object obj) {
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.oOoXoXO
    public static final T II0XooXoX(Object obj) {
        if (obj instanceof I0Io) {
            return null;
        }
        return obj;
    }

    public static final /* synthetic */ xoIox II0xO0(Object obj) {
        return new xoIox(obj);
    }

    public static final boolean OOXIXo(Object obj) {
        return obj instanceof oIX0oI;
    }

    @o0
    public static /* synthetic */ void Oxx0IOOO() {
    }

    public static final boolean X0o0xo(Object obj, Object obj2) {
        return IIX0o.Oxx0IOOO(obj, obj2);
    }

    @OXOo.oOoXoXO
    public static final Throwable XO(Object obj) {
        oIX0oI oix0oi;
        if (obj instanceof oIX0oI) {
            oix0oi = (oIX0oI) obj;
        } else {
            oix0oi = null;
        }
        if (oix0oi == null) {
            return null;
        }
        return oix0oi.f29893oIX0oI;
    }

    public static final boolean oOoXoXO(Object obj) {
        return obj instanceof I0Io;
    }

    public static final boolean ooOOo0oXI(Object obj) {
        return !(obj instanceof I0Io);
    }

    public static boolean oxoX(Object obj, Object obj2) {
        return (obj2 instanceof xoIox) && IIX0o.Oxx0IOOO(obj, ((xoIox) obj2).oO());
    }

    @OXOo.OOXIXo
    public static String x0XOIxOo(Object obj) {
        if (obj instanceof oIX0oI) {
            return ((oIX0oI) obj).toString();
        }
        return "Value(" + obj + HexStringBuilder.COMMENT_END_CHAR;
    }

    public static int xoIox(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T xxIXOIIO(Object obj) {
        Throwable th;
        if (!(obj instanceof I0Io)) {
            return obj;
        }
        if ((obj instanceof oIX0oI) && (th = ((oIX0oI) obj).f29893oIX0oI) != null) {
            throw th;
        }
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + obj).toString());
    }

    public boolean equals(Object obj) {
        return oxoX(this.f29892oIX0oI, obj);
    }

    public int hashCode() {
        return xoIox(this.f29892oIX0oI);
    }

    public final /* synthetic */ Object oO() {
        return this.f29892oIX0oI;
    }

    @OXOo.OOXIXo
    public String toString() {
        return x0XOIxOo(this.f29892oIX0oI);
    }
}
