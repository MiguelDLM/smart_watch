package kotlinx.coroutines;

/* loaded from: classes6.dex */
public final class xoxXI extends ooOOo0oXI {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final I0oOIX f30491XO;

    public xoxXI(@OXOo.OOXIXo I0oOIX i0oOIX) {
        this.f30491XO = i0oOIX;
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Throwable th) {
        xoIox(th);
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "DisposeOnCancel[" + this.f30491XO + ']';
    }

    @Override // kotlinx.coroutines.x0XOIxOo
    public void xoIox(@OXOo.oOoXoXO Throwable th) {
        this.f30491XO.dispose();
    }
}
