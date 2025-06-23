package O0IoXXOx;

import java.io.InputStream;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/* loaded from: classes6.dex */
public class Oxx0IOOO implements EntityResolver {
    @Override // org.xml.sax.EntityResolver
    public InputSource resolveEntity(String str, String str2) {
        if (!str2.endsWith("log4j.dtd")) {
            return null;
        }
        Class<?> cls = getClass();
        InputStream resourceAsStream = cls.getResourceAsStream("/org/apache/log4j/xml/log4j.dtd");
        if (resourceAsStream == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not find [log4j.dtd]. Used [");
            stringBuffer.append(cls.getClassLoader());
            stringBuffer.append("] class loader in the search.");
            org.apache.log4j.helpers.xxIXOIIO.I0Io(stringBuffer.toString());
            return null;
        }
        return new InputSource(resourceAsStream);
    }
}
