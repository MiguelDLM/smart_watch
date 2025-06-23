package O0IoXXOx;

import O0IoXXOx.XO;
import java.io.IOException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/* loaded from: classes6.dex */
public class II0xO0 implements XO.oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ XO f1150II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ URL f1151oIX0oI;

    public II0xO0(XO xo2, URL url) {
        this.f1150II0xO0 = xo2;
        this.f1151oIX0oI = url;
    }

    @Override // O0IoXXOx.XO.oIX0oI
    public Document oIX0oI(DocumentBuilder documentBuilder) throws SAXException, IOException {
        return documentBuilder.parse(this.f1151oIX0oI.toString());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("url [");
        stringBuffer.append(this.f1151oIX0oI.toString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
