package XoOxI0ox;

/* loaded from: classes13.dex */
public class II0xO0 implements XoOxI0ox.oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public XoOxI0ox.oIX0oI f4165oIX0oI;

    /* loaded from: classes13.dex */
    public static class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static II0xO0 f4166oIX0oI = new II0xO0();
    }

    public static II0xO0 I0Io() {
        return oIX0oI.f4166oIX0oI;
    }

    @Override // XoOxI0ox.oIX0oI
    public void II0xO0(String str, String str2, String str3, String str4, String str5) {
        XOxoX.oIX0oI.oxoX(str, str2, str3, str4, str5);
        XoOxI0ox.oIX0oI oix0oi = this.f4165oIX0oI;
        if (oix0oi != null) {
            oix0oi.II0xO0(str, str2, str3, str4, str5);
        }
    }

    @Override // XoOxI0ox.oIX0oI
    public void oIX0oI(String str, String str2, String str3) {
        XOxoX.oIX0oI.oxoX("KeyMonitor", str, str2, str3);
        XoOxI0ox.oIX0oI oix0oi = this.f4165oIX0oI;
        if (oix0oi != null) {
            oix0oi.oIX0oI(str, str2, str3);
        }
    }

    public void oxoX(XoOxI0ox.oIX0oI oix0oi) {
        this.f4165oIX0oI = oix0oi;
    }
}
