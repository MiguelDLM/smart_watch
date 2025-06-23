package o0oIxXOx;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* loaded from: classes6.dex */
public final class Oxx0xo extends oIX0oI {

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Oxx0xo f31156oxoX = new Oxx0xo();

    /* renamed from: I0Io, reason: collision with root package name */
    public final String f31157I0Io;

    public Oxx0xo() {
        this(null);
    }

    public String II0XooXoX(String str, String str2) {
        return Oxx0IOOO(str).getString(str2);
    }

    public ResourceBundle Oxx0IOOO(String str) {
        return ResourceBundle.getBundle(str);
    }

    @Override // o0oIxXOx.OxxIIOOXO
    public String lookup(String str) {
        boolean z;
        String str2;
        if (str == null) {
            return null;
        }
        String[] split = str.split(oIX0oI.f31186II0xO0);
        int length = split.length;
        String str3 = this.f31157I0Io;
        if (str3 == null) {
            z = true;
        } else {
            z = false;
        }
        if (z && length != 2) {
            throw oOoXoXO.oIX0oI("Bad resource bundle key format [%s]; expected format is BundleName:KeyName.", str);
        }
        if (str3 != null && length != 1) {
            throw oOoXoXO.oIX0oI("Bad resource bundle key format [%s]; expected format is KeyName.", str);
        }
        if (z) {
            str3 = split[0];
        }
        if (z) {
            str2 = split[1];
        } else {
            str2 = split[0];
        }
        try {
            return II0XooXoX(str3, str2);
        } catch (MissingResourceException unused) {
            return null;
        } catch (Exception e) {
            throw oOoXoXO.II0xO0(e, "Error looking up resource bundle [%s] and key [%s].", str3, str2);
        }
    }

    public String toString() {
        return super.toString() + " [bundleName=" + this.f31157I0Io + "]";
    }

    public Oxx0xo(String str) {
        this.f31157I0Io = str;
    }
}
