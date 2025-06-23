package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* loaded from: classes6.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f29680oIX0oI;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            try {
                iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CoroutineStart.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f29680oIX0oI = iArr;
        }
    }

    @OX00O0xII
    public static /* synthetic */ void isLazy$annotations() {
    }

    @OX00O0xII
    public final <T> void invoke(@OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super T>, ? extends Object> oooxoxo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        int i = oIX0oI.f29680oIX0oI[ordinal()];
        if (i == 1) {
            o0xIoII.oIX0oI.I0Io(oooxoxo, i0Io);
            return;
        }
        if (i == 2) {
            kotlin.coroutines.X0o0xo.II0XooXoX(oooxoxo, i0Io);
        } else if (i == 3) {
            o0xIoII.II0xO0.oIX0oI(oooxoxo, i0Io);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isLazy() {
        if (this == LAZY) {
            return true;
        }
        return false;
    }

    @OX00O0xII
    public final <R, T> void invoke(@OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, R r, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        int i = oIX0oI.f29680oIX0oI[ordinal()];
        if (i == 1) {
            o0xIoII.oIX0oI.XO(x0xo0oo, r, i0Io, null, 4, null);
            return;
        }
        if (i == 2) {
            kotlin.coroutines.X0o0xo.xxIXOIIO(x0xo0oo, r, i0Io);
        } else if (i == 3) {
            o0xIoII.II0xO0.II0xO0(x0xo0oo, r, i0Io);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
