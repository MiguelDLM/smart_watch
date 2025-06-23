package org.apache.log4j.lf5;

import java.io.IOException;
import java.net.URL;
import org.apache.log4j.IIXOooo;
import org.apache.log4j.spi.xxIXOIIO;

/* loaded from: classes6.dex */
public class II0xO0 implements org.apache.log4j.spi.II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static /* synthetic */ Class f33341I0Io;

    public static void I0Io() throws IOException {
        Class cls = f33341I0Io;
        if (cls == null) {
            cls = II0xO0("org.apache.log4j.lf5.DefaultLF5Configurator");
            f33341I0Io = cls;
        }
        URL resource = cls.getResource("/org/apache/log4j/lf5/config/defaultconfig.properties");
        if (resource != null) {
            IIXOooo.oxoX(resource);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Error: Unable to open the resource");
        stringBuffer.append("/org/apache/log4j/lf5/config/defaultconfig.properties");
        throw new IOException(stringBuffer.toString());
    }

    public static /* synthetic */ Class II0xO0(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Override // org.apache.log4j.spi.II0xO0
    public void oIX0oI(URL url, xxIXOIIO xxixoiio) {
        throw new IllegalStateException("This class should NOT be instantiated!");
    }
}
