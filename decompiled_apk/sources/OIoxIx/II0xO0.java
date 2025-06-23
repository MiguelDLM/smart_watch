package OIoxIx;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public class II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static II0xO0 f1660II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Map<String, oIX0oI> f1661oIX0oI = new HashMap();

    public static II0xO0 oxoX() {
        if (f1660II0xO0 == null) {
            f1660II0xO0 = new II0xO0();
        }
        return f1660II0xO0;
    }

    public void I0Io(oIX0oI oix0oi) {
        this.f1661oIX0oI.put(oix0oi.XO(), oix0oi);
    }

    public void II0xO0() {
        this.f1661oIX0oI.clear();
    }

    public oIX0oI oIX0oI(String str) {
        return this.f1661oIX0oI.get(str);
    }
}
