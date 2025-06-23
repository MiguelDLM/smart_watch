package IoxX;

import java.util.prefs.AbstractPreferences;
import java.util.prefs.BackingStoreException;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final C0025oIX0oI f898II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final oIX0oI f899oIX0oI;

    static {
        oIX0oI oix0oi = new oIX0oI();
        f899oIX0oI = oix0oi;
        f898II0xO0 = new C0025oIX0oI();
    }

    public static String II0xO0(byte[] bArr) {
        C0025oIX0oI c0025oIX0oI = f898II0xO0;
        c0025oIX0oI.putByteArray("aKey", bArr);
        return c0025oIX0oI.oIX0oI();
    }

    public static String oIX0oI(String str) {
        C0025oIX0oI c0025oIX0oI = f898II0xO0;
        c0025oIX0oI.putByteArray("akey", str.getBytes());
        return c0025oIX0oI.oIX0oI();
    }

    /* renamed from: IoxX.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0025oIX0oI extends AbstractPreferences {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f901oIX0oI;

        public C0025oIX0oI() {
            super(null, "");
            this.f901oIX0oI = null;
        }

        @Override // java.util.prefs.AbstractPreferences
        public AbstractPreferences childSpi(String str) {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        public String[] childrenNamesSpi() throws BackingStoreException {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        public String getSpi(String str) {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        public String[] keysSpi() throws BackingStoreException {
            return null;
        }

        public String oIX0oI() {
            return this.f901oIX0oI;
        }

        @Override // java.util.prefs.AbstractPreferences
        public void putSpi(String str, String str2) {
            this.f901oIX0oI = str2;
        }

        @Override // java.util.prefs.AbstractPreferences
        public void flushSpi() throws BackingStoreException {
        }

        @Override // java.util.prefs.AbstractPreferences
        public void removeNodeSpi() throws BackingStoreException {
        }

        @Override // java.util.prefs.AbstractPreferences
        public void syncSpi() throws BackingStoreException {
        }

        @Override // java.util.prefs.AbstractPreferences
        public void removeSpi(String str) {
        }
    }
}
