package x0xO0oo;

/* loaded from: classes.dex */
public class Oxx0IOOO {

    /* renamed from: oxoX, reason: collision with root package name */
    public static String f34084oxoX = "\r";

    /* renamed from: I0Io, reason: collision with root package name */
    public final float f34085I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final float f34086II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f34087oIX0oI;

    public Oxx0IOOO(String str, float f, float f2) {
        this.f34087oIX0oI = str;
        this.f34085I0Io = f2;
        this.f34086II0xO0 = f;
    }

    public boolean oIX0oI(String str) {
        if (this.f34087oIX0oI.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f34087oIX0oI.endsWith(f34084oxoX)) {
            String str2 = this.f34087oIX0oI;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
