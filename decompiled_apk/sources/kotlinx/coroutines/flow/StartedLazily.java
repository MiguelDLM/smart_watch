package kotlinx.coroutines.flow;

/* loaded from: classes6.dex */
public final class StartedLazily implements Oxx0xo {
    @Override // kotlinx.coroutines.flow.Oxx0xo
    @OXOo.OOXIXo
    public X0o0xo<SharingCommand> oIX0oI(@OXOo.OOXIXo IIXOooo<Integer> iIXOooo) {
        return Oxx0IOOO.O0X(new StartedLazily$command$1(iIXOooo, null));
    }

    @OXOo.OOXIXo
    public String toString() {
        return "SharingStarted.Lazily";
    }
}
