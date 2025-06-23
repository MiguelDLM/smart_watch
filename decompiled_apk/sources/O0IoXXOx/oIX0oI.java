package O0IoXXOx;

import O0IoXXOx.XO;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/* loaded from: classes6.dex */
public class oIX0oI implements XO.oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ XO f1191II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ String f1192oIX0oI;

    public oIX0oI(XO xo2, String str) {
        this.f1191II0xO0 = xo2;
        this.f1192oIX0oI = str;
    }

    @Override // O0IoXXOx.XO.oIX0oI
    public Document oIX0oI(DocumentBuilder documentBuilder) throws SAXException, IOException {
        return documentBuilder.parse(new File(this.f1192oIX0oI));
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file [");
        stringBuffer.append(this.f1192oIX0oI);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
