package o0oIxXOx;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.lang3.xXOx;
import org.xml.sax.InputSource;

/* loaded from: classes6.dex */
public final class IIX0o extends oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final IIX0o f31151I0Io = new IIX0o();

    @Override // o0oIxXOx.OxxIIOOXO
    public String lookup(String str) {
        Path path;
        InputStream newInputStream;
        if (str == null) {
            return null;
        }
        String[] split = str.split(oIX0oI.f31186II0xO0);
        if (split.length == 2) {
            String str2 = split[0];
            String O0o02 = xXOx.O0o0(str, 58);
            try {
                path = Paths.get(str2, new String[0]);
                newInputStream = Files.newInputStream(path, new OpenOption[0]);
                try {
                    String evaluate = XPathFactory.newInstance().newXPath().evaluate(O0o02, new InputSource(newInputStream));
                    if (newInputStream != null) {
                        newInputStream.close();
                    }
                    return evaluate;
                } finally {
                }
            } catch (Exception e) {
                throw oOoXoXO.II0xO0(e, "Error looking up XML document [%s] and XPath [%s].", str2, O0o02);
            }
        } else {
            throw oOoXoXO.oIX0oI("Bad XML key format [%s]; expected format is DocumentPath:XPath.", str);
        }
    }
}
