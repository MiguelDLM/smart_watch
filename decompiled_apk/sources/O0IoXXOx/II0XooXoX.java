package O0IoXXOx;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

/* loaded from: classes6.dex */
public class II0XooXoX implements ErrorHandler {
    public static void oIX0oI(String str, SAXParseException sAXParseException) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(sAXParseException.getLineNumber());
        stringBuffer.append(" and column ");
        stringBuffer.append(sAXParseException.getColumnNumber());
        org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO(stringBuffer.toString());
        org.apache.log4j.helpers.xxIXOIIO.II0XooXoX(sAXParseException.getMessage(), sAXParseException.getException());
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) {
        oIX0oI("Continuable parsing error ", sAXParseException);
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) {
        oIX0oI("Fatal parsing error ", sAXParseException);
    }

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) {
        oIX0oI("Parsing warning ", sAXParseException);
    }
}
