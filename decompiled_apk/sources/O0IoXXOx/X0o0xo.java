package O0IoXXOx;

import O0IoXXOx.XO;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes6.dex */
public class X0o0xo implements XO.oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ XO f1152II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ InputSource f1153oIX0oI;

    public X0o0xo(XO xo2, InputSource inputSource) {
        this.f1152II0xO0 = xo2;
        this.f1153oIX0oI = inputSource;
    }

    @Override // O0IoXXOx.XO.oIX0oI
    public Document oIX0oI(DocumentBuilder documentBuilder) throws SAXException, IOException {
        return documentBuilder.parse(this.f1153oIX0oI);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("input source [");
        stringBuffer.append(this.f1153oIX0oI.toString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
