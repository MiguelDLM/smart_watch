package OI0;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.ServiceLoader;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class I0Io {
    public static /* synthetic */ String I0Io(String str, int i, Charset charset, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            charset = Charset.defaultCharset();
            IIX0o.oO(charset, "defaultCharset(...)");
        }
        return II0xO0(str, i, charset);
    }

    @OOXIXo
    public static final String II0xO0(@OOXIXo String input, int i, @OOXIXo Charset charSet) {
        IIX0o.x0xO0oo(input, "input");
        IIX0o.x0xO0oo(charSet, "charSet");
        byte[] bytes = input.getBytes(charSet);
        IIX0o.oO(bytes, "getBytes(...)");
        if (bytes.length <= i) {
            return input;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < i && i3 < input.length()) {
            byte[] bytes2 = String.valueOf(input.charAt(i3)).getBytes(charSet);
            IIX0o.oO(bytes2, "getBytes(...)");
            i2 += bytes2.length;
            if (i2 > i) {
                break;
            }
            i3++;
        }
        while (i3 > 0 && i2 > i) {
            i3--;
            byte[] bytes3 = String.valueOf(input.charAt(i3)).getBytes(charSet);
            IIX0o.oO(bytes3, "getBytes(...)");
            i2 -= bytes3.length;
        }
        String substring = input.substring(0, i3);
        IIX0o.oO(substring, "substring(...)");
        return substring;
    }

    @oOoXoXO
    public static final Class<?> oIX0oI(@OOXIXo String className) {
        IIX0o.x0xO0oo(className, "className");
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(Class.class).iterator();
            while (it.hasNext()) {
                Class<?> cls = (Class) it.next();
                if (IIX0o.Oxx0IOOO(cls.getName(), className)) {
                    return cls;
                }
            }
            return null;
        }
    }
}
