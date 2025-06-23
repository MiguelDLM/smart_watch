package Ox0XO;

/* loaded from: classes6.dex */
public abstract class x0xO0oo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static x0xO0oo f2963oIX0oI;

    public static final String II0xO0(int i) {
        if (f2963oIX0oI == null) {
            if (oOoXoXO.I0Io("java.util.ResourceBundle")) {
                try {
                    f2963oIX0oI = (x0xO0oo) oI0IIXIo.class.newInstance();
                } catch (Exception unused) {
                    return "";
                }
            } else if (oOoXoXO.I0Io("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog")) {
                try {
                    f2963oIX0oI = (x0xO0oo) Class.forName("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog").newInstance();
                } catch (Exception unused2) {
                    return "";
                }
            }
        }
        return f2963oIX0oI.oIX0oI(i);
    }

    public abstract String oIX0oI(int i);
}
