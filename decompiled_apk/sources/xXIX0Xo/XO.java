package xXIX0Xo;

import java.io.InputStream;
import java.net.URL;

/* loaded from: classes6.dex */
public class XO {
    public static URL II0xO0(Object obj, X0o0xo x0o0xo) {
        ClassLoader classLoader = obj.getClass().getClassLoader();
        if (classLoader != null) {
            return classLoader.getResource(x0o0xo.I0Io());
        }
        return ClassLoader.getSystemResource(x0o0xo.I0Io());
    }

    public static InputStream oIX0oI(Object obj, X0o0xo x0o0xo) {
        ClassLoader classLoader = obj.getClass().getClassLoader();
        if (classLoader != null) {
            return classLoader.getResourceAsStream(x0o0xo.I0Io());
        }
        return ClassLoader.getSystemResourceAsStream(x0o0xo.I0Io());
    }
}
