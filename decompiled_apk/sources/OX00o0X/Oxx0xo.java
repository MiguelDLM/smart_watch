package OX00o0X;

import XXO0.oIX0oI;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.StringTokenizer;
import org.apache.log4j.Level;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes6.dex */
public class Oxx0xo extends DefaultHandler {

    /* renamed from: oO, reason: collision with root package name */
    public static final String f1928oO = "log4j:throwable";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f1929oOoXoXO = "log4j:event";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f1930ooOOo0oXI = "log4j:message";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final String f1931x0XOIxOo = "log4j:NDC";

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final String f1932x0xO0oo = "log4j:locationInfo";

    /* renamed from: I0Io, reason: collision with root package name */
    public long f1933I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f1934II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f1935II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final StringBuffer f1936OOXIXo = new StringBuffer();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f1937Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f1938X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f1939XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final IXxxXO f1940oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public Level f1941oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public String f1942xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String[] f1943xxIXOIIO;

    public Oxx0xo(IXxxXO iXxxXO) {
        this.f1940oIX0oI = iXxxXO;
    }

    public final void I0Io() {
        this.f1933I0Io = 0L;
        this.f1941oxoX = null;
        this.f1938X0o0xo = null;
        this.f1939XO = null;
        this.f1937Oxx0IOOO = null;
        this.f1934II0XooXoX = null;
        this.f1943xxIXOIIO = null;
        this.f1942xoIox = null;
    }

    public int II0xO0() {
        return this.f1935II0xO0;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        this.f1936OOXIXo.append(String.valueOf(cArr, i, i2));
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (f1929oOoXoXO.equals(str3)) {
            oIX0oI();
            I0Io();
            return;
        }
        if (f1931x0XOIxOo.equals(str3)) {
            this.f1939XO = this.f1936OOXIXo.toString();
            return;
        }
        if (f1930ooOOo0oXI.equals(str3)) {
            this.f1934II0XooXoX = this.f1936OOXIXo.toString();
            return;
        }
        if (f1928oO.equals(str3)) {
            StringTokenizer stringTokenizer = new StringTokenizer(this.f1936OOXIXo.toString(), "\n\t");
            String[] strArr = new String[stringTokenizer.countTokens()];
            this.f1943xxIXOIIO = strArr;
            if (strArr.length > 0) {
                strArr[0] = stringTokenizer.nextToken();
                int i = 1;
                while (true) {
                    String[] strArr2 = this.f1943xxIXOIIO;
                    if (i < strArr2.length) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("\t");
                        stringBuffer.append(stringTokenizer.nextToken());
                        strArr2[i] = stringBuffer.toString();
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void oIX0oI() {
        this.f1940oIX0oI.Oxx0IOOO(new xoIox(this.f1933I0Io, this.f1941oxoX, this.f1938X0o0xo, this.f1939XO, this.f1937Oxx0IOOO, this.f1934II0XooXoX, this.f1943xxIXOIIO, this.f1942xoIox));
        this.f1935II0xO0++;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        this.f1935II0xO0 = 0;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f1936OOXIXo.setLength(0);
        if (f1929oOoXoXO.equals(str3)) {
            this.f1937Oxx0IOOO = attributes.getValue("thread");
            this.f1933I0Io = Long.parseLong(attributes.getValue("timestamp"));
            this.f1938X0o0xo = attributes.getValue("logger");
            this.f1941oxoX = Level.toLevel(attributes.getValue("level"));
            return;
        }
        if (f1932x0xO0oo.equals(str3)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(attributes.getValue(O0IoXXOx.XO.f1157IXxxXO));
            stringBuffer.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            stringBuffer.append(attributes.getValue("method"));
            stringBuffer.append(oIX0oI.I0Io.f4096II0xO0);
            stringBuffer.append(attributes.getValue("file"));
            stringBuffer.append(":");
            stringBuffer.append(attributes.getValue("line"));
            stringBuffer.append(oIX0oI.I0Io.f4095I0Io);
            this.f1942xoIox = stringBuffer.toString();
        }
    }
}
