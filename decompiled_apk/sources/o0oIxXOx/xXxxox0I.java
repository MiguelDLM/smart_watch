package o0oIxXOx;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import org.apache.commons.lang3.xXOx;

/* loaded from: classes6.dex */
public final class xXxxox0I extends oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final xXxxox0I f31203I0Io = new xXxxox0I();

    @Override // o0oIxXOx.OxxIIOOXO
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(oIX0oI.f31186II0xO0);
        if (split.length >= 2) {
            String str2 = split[0];
            String O0o02 = xXOx.O0o0(str, 58);
            try {
                URL url = new URL(O0o02);
                StringWriter stringWriter = new StringWriter(8192);
                char[] cArr = new char[8192];
                BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream, str2);
                    while (true) {
                        try {
                            int read = inputStreamReader.read(cArr);
                            if (-1 != read) {
                                stringWriter.write(cArr, 0, read);
                            } else {
                                inputStreamReader.close();
                                bufferedInputStream.close();
                                return stringWriter.toString();
                            }
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } finally {
                    }
                }
            } catch (Exception e) {
                throw oOoXoXO.II0xO0(e, "Error looking up URL [%s] with Charset [%s].", O0o02, str2);
            }
        } else {
            throw oOoXoXO.oIX0oI("Bad URL key format [%s]; expected format is DocumentPath:Key.", str);
        }
    }
}
