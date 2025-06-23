package OoOoXO0;

/* loaded from: classes6.dex */
public class xoIox implements I0Io {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ OOXIXo f2664oIX0oI;

    public xoIox(OOXIXo oOXIXo) {
        this.f2664oIX0oI = oOXIXo;
    }

    @Override // OoOoXO0.I0Io
    public void onFailure(II0XooXoX iI0XooXoX, Throwable th) {
        int i;
        int i2;
        int i3;
        OOXIXo.f2609X0IIOO.OOXIXo(OOXIXo.f2608O0xOxO, "attemptReconnect", "502", new Object[]{iI0XooXoX.getClient().getClientId()});
        i = OOXIXo.f2607IIX0o;
        if (i < 128000) {
            i3 = OOXIXo.f2607IIX0o;
            OOXIXo.f2607IIX0o = i3 * 2;
        }
        OOXIXo oOXIXo = this.f2664oIX0oI;
        i2 = OOXIXo.f2607IIX0o;
        oOXIXo.OxI(i2);
    }

    @Override // OoOoXO0.I0Io
    public void onSuccess(II0XooXoX iI0XooXoX) {
        OOXIXo.f2609X0IIOO.OOXIXo(OOXIXo.f2608O0xOxO, "attemptReconnect", "501", new Object[]{iI0XooXoX.getClient().getClientId()});
        this.f2664oIX0oI.f2617IXxxXO.xo0x(false);
        this.f2664oIX0oI.XI0IXoo();
    }
}
