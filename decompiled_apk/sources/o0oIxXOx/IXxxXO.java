package o0oIxXOx;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import org.apache.commons.lang3.xXOx;

/* loaded from: classes6.dex */
public final class IXxxXO extends oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final IXxxXO f31152I0Io = new IXxxXO();

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f31153oxoX = "::";

    public static String Oxx0IOOO(String str, String str2) {
        return oIX0oI.XO(str, f31153oxoX, str2);
    }

    @Override // o0oIxXOx.OxxIIOOXO
    public String lookup(String str) {
        Path path;
        InputStream newInputStream;
        if (str == null) {
            return null;
        }
        String[] split = str.split(f31153oxoX);
        if (split.length >= 2) {
            String str2 = split[0];
            String OIxI0O2 = xXOx.OIxI0O(str, f31153oxoX);
            try {
                Properties properties = new Properties();
                path = Paths.get(str2, new String[0]);
                newInputStream = Files.newInputStream(path, new OpenOption[0]);
                try {
                    properties.load(newInputStream);
                    if (newInputStream != null) {
                        newInputStream.close();
                    }
                    return properties.getProperty(OIxI0O2);
                } finally {
                }
            } catch (Exception e) {
                throw oOoXoXO.II0xO0(e, "Error looking up properties [%s] and key [%s].", str2, OIxI0O2);
            }
        } else {
            throw oOoXoXO.oIX0oI("Bad properties key format [%s]; expected format is %s.", str, Oxx0IOOO("DocumentPath", "Key"));
        }
    }
}
