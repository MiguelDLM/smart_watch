package OoOoXO0;

/* loaded from: classes6.dex */
public class xxIXOIIO implements ooOOo0oXI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ boolean f2675II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ OOXIXo f2676oIX0oI;

    public xxIXOIIO(OOXIXo oOXIXo, boolean z) {
        this.f2676oIX0oI = oOXIXo;
        this.f2675II0xO0 = z;
    }

    @Override // OoOoXO0.oOoXoXO
    public void connectionLost(Throwable th) {
        if (this.f2675II0xO0) {
            this.f2676oIX0oI.f2617IXxxXO.xo0x(true);
            this.f2676oIX0oI.f2619OxI = true;
            this.f2676oIX0oI.X0IIOO();
        }
    }

    @Override // OoOoXO0.oOoXoXO
    public void deliveryComplete(XO xo2) {
    }

    @Override // OoOoXO0.ooOOo0oXI
    public void connectComplete(boolean z, String str) {
    }

    @Override // OoOoXO0.oOoXoXO
    public void messageArrived(String str, Oxx0xo oxx0xo) throws Exception {
    }
}
