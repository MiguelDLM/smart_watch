package O0IoXXOx;

import O0IoXXOx.XO;
import java.io.IOException;
import java.io.Reader;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes6.dex */
public class oxoX implements XO.oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ XO f1193II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ Reader f1194oIX0oI;

    public oxoX(XO xo2, Reader reader) {
        this.f1193II0xO0 = xo2;
        this.f1194oIX0oI = reader;
    }

    @Override // O0IoXXOx.XO.oIX0oI
    public Document oIX0oI(DocumentBuilder documentBuilder) throws SAXException, IOException {
        InputSource inputSource = new InputSource(this.f1194oIX0oI);
        inputSource.setSystemId("dummy://log4j.dtd");
        return documentBuilder.parse(inputSource);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("reader [");
        stringBuffer.append(this.f1194oIX0oI.toString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
