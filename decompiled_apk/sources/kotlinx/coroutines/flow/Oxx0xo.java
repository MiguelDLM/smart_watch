package kotlinx.coroutines.flow;

/* loaded from: classes6.dex */
public interface Oxx0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f30128oIX0oI = oIX0oI.f30131oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ oIX0oI f30131oIX0oI = new oIX0oI();

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.OOXIXo
        public static final Oxx0xo f30130II0xO0 = new OxxIIOOXO();

        /* renamed from: I0Io, reason: collision with root package name */
        @OXOo.OOXIXo
        public static final Oxx0xo f30129I0Io = new StartedLazily();

        public static /* synthetic */ Oxx0xo II0xO0(oIX0oI oix0oi, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = 0;
            }
            if ((i & 2) != 0) {
                j2 = Long.MAX_VALUE;
            }
            return oix0oi.oIX0oI(j, j2);
        }

        @OXOo.OOXIXo
        public final Oxx0xo I0Io() {
            return f30130II0xO0;
        }

        @OXOo.OOXIXo
        public final Oxx0xo oIX0oI(long j, long j2) {
            return new StartedWhileSubscribed(j, j2);
        }

        @OXOo.OOXIXo
        public final Oxx0xo oxoX() {
            return f30129I0Io;
        }
    }

    @OXOo.OOXIXo
    X0o0xo<SharingCommand> oIX0oI(@OXOo.OOXIXo IIXOooo<Integer> iIXOooo);
}
