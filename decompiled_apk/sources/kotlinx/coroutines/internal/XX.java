package kotlinx.coroutines.internal;

/* loaded from: classes6.dex */
public final /* synthetic */ class XX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f30283oIX0oI = Runtime.getRuntime().availableProcessors();

    @OXOo.oOoXoXO
    public static final String II0xO0(@OXOo.OOXIXo String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static final int oIX0oI() {
        return f30283oIX0oI;
    }
}
