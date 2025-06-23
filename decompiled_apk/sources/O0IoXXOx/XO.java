package O0IoXXOx;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Hashtable;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import org.apache.log4j.Level;
import org.apache.log4j.helpers.oOoXoXO;
import org.apache.log4j.oO;
import org.apache.log4j.x0XOIxOo;
import org.apache.log4j.x0xO0oo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes6.dex */
public class XO implements org.apache.log4j.spi.II0xO0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f1154II0XooXoX = "renderer";

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final String f1155IIX0o = "";

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final String f1156IIXOooo = "level";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final String f1157IXxxXO = "class";

    /* renamed from: IoOoX, reason: collision with root package name */
    public static /* synthetic */ Class f1158IoOoX = null;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final String f1159O0xOxO = "ref";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f1160OOXIXo = "param";

    /* renamed from: Oo, reason: collision with root package name */
    public static final String f1161Oo = "name";

    /* renamed from: OxI, reason: collision with root package name */
    public static final String f1162OxI = "errorHandler";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f1163Oxx0IOOO = "configuration";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final String f1164Oxx0xo = "value";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final String f1165OxxIIOOXO = "root-ref";

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final String f1166X0IIOO = "additivity";

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final String f1167XI0IXoo = "threshold";

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final String f1168XIxXXX0x0 = "configDebug";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f1169XO = "log4j:configuration";

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final String f1170XxX0x0xxx = "renderingClass";

    /* renamed from: o00, reason: collision with root package name */
    public static final String f1171o00 = "filter";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final String f1172oI0IIXIo = "root";

    /* renamed from: oO, reason: collision with root package name */
    public static final String f1173oO = "logger-ref";

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public static /* synthetic */ Class f1174oOXoIIIo = null;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f1175oOoXoXO = "layout";

    /* renamed from: oo, reason: collision with root package name */
    public static /* synthetic */ Class f1176oo = null;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static /* synthetic */ Class f1177oo0xXOI0I = null;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f1178ooOOo0oXI = "category";

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final Class[] f1179ooXIXxIX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final String f1180x0XOIxOo = "logger";

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final String f1181x0xO0oo = "categoryFactory";

    /* renamed from: xI, reason: collision with root package name */
    public static final String f1182xI = "javax.xml.parsers.DocumentBuilderFactory";

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final String f1183xXxxox0I = "renderedClass";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f1184xoIox = "appender-ref";

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final String f1185xoXoI = "priority";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f1186xxIXOIIO = "appender";

    /* renamed from: xxX, reason: collision with root package name */
    public static final String f1187xxX = "debug";

    /* renamed from: I0Io, reason: collision with root package name */
    public Hashtable f1188I0Io = new Hashtable();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public org.apache.log4j.spi.xxIXOIIO f1189X0o0xo;

    /* renamed from: oxoX, reason: collision with root package name */
    public Properties f1190oxoX;

    /* loaded from: classes6.dex */
    public interface oIX0oI {
        Document oIX0oI(DocumentBuilder documentBuilder) throws SAXException, IOException;
    }

    static {
        Class cls = f1177oo0xXOI0I;
        if (cls == null) {
            cls = II0xO0("java.lang.String");
            f1177oo0xXOI0I = cls;
        }
        f1179ooXIXxIX = new Class[]{cls};
    }

    public static void I0Io(String str) throws FactoryConfigurationError {
        new XO().OOXIXo(str, oO.XO());
    }

    public static /* synthetic */ Class II0xO0(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static void Oxx0IOOO(String str, long j) {
        xoIox xoiox = new xoIox(str);
        xoiox.I0Io(j);
        xoiox.start();
    }

    public static void X0o0xo(Element element) {
        new XO().oOoXoXO(element, oO.XO());
    }

    public static void XO(String str) {
        Oxx0IOOO(str, 60000L);
    }

    public static void oxoX(URL url) throws FactoryConfigurationError {
        new XO().oIX0oI(url, oO.XO());
    }

    public final void II0XooXoX(oIX0oI oix0oi, org.apache.log4j.spi.xxIXOIIO xxixoiio) throws FactoryConfigurationError {
        this.f1189X0o0xo = xxixoiio;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("System property is :");
            stringBuffer.append(oOoXoXO.X0o0xo(f1182xI, null));
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI("Standard DocumentBuilderFactory search succeded.");
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("DocumentBuilderFactory is: ");
            stringBuffer2.append(newInstance.getClass().getName());
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer2.toString());
            try {
                newInstance.setValidating(true);
                DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
                newDocumentBuilder.setErrorHandler(new II0XooXoX());
                newDocumentBuilder.setEntityResolver(new Oxx0IOOO());
                x0xO0oo(oix0oi.oIX0oI(newDocumentBuilder).getDocumentElement());
            } catch (Exception e) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Could not parse ");
                stringBuffer3.append(oix0oi.toString());
                stringBuffer3.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                org.apache.log4j.helpers.xxIXOIIO.oxoX(stringBuffer3.toString(), e);
            }
        } catch (FactoryConfigurationError e2) {
            org.apache.log4j.helpers.xxIXOIIO.II0xO0("Could not instantiate a DocumentBuilderFactory.", e2.getException());
            throw e2;
        }
    }

    public void IIXOooo(Element element, org.apache.log4j.oIX0oI oix0oi) {
        String XI0IXoo2 = XI0IXoo(element.getAttribute(f1157IXxxXO));
        Class cls = f1158IoOoX;
        if (cls == null) {
            cls = II0xO0("org.apache.log4j.spi.Filter");
            f1158IoOoX = cls;
        }
        org.apache.log4j.spi.XO xo2 = (org.apache.log4j.spi.XO) oOoXoXO.XO(XI0IXoo2, cls, null);
        if (xo2 != null) {
            org.apache.log4j.config.I0Io i0Io = new org.apache.log4j.config.I0Io(xo2);
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == 1) {
                    Element element2 = (Element) item;
                    if (element2.getTagName().equals(f1160OOXIXo)) {
                        X0IIOO(element2, i0Io);
                    }
                }
            }
            i0Io.oIX0oI();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Adding filter of type [");
            stringBuffer.append(xo2.getClass());
            stringBuffer.append("] to appender named [");
            stringBuffer.append(oix0oi.getName());
            stringBuffer.append("].");
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
            oix0oi.x0XOIxOo(xo2);
        }
    }

    public void IXxxXO(Element element) {
        x0xO0oo x0xo0oo;
        String XI0IXoo2 = XI0IXoo(element.getAttribute("name"));
        String XI0IXoo3 = XI0IXoo(element.getAttribute(f1157IXxxXO));
        if ("".equals(XI0IXoo3)) {
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI("Retreiving an instance of org.apache.log4j.Logger.");
            x0xo0oo = this.f1189X0o0xo.xxIXOIIO(XI0IXoo2);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Desired logger sub-class: [");
            stringBuffer.append(XI0IXoo3);
            stringBuffer.append(']');
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
            try {
                x0xo0oo = (x0xO0oo) org.apache.log4j.helpers.II0XooXoX.XO(XI0IXoo3).getMethod("getLogger", f1179ooXIXxIX).invoke(null, XI0IXoo2);
            } catch (Exception e) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Could not retrieve category [");
                stringBuffer2.append(XI0IXoo2);
                stringBuffer2.append("]. Reported error follows.");
                org.apache.log4j.helpers.xxIXOIIO.oxoX(stringBuffer2.toString(), e);
                return;
            }
        }
        synchronized (x0xo0oo) {
            boolean xoIox2 = oOoXoXO.xoIox(XI0IXoo(element.getAttribute(f1166X0IIOO)), true);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Setting [");
            stringBuffer3.append(x0xo0oo.xxX());
            stringBuffer3.append("] additivity to [");
            stringBuffer3.append(xoIox2);
            stringBuffer3.append("].");
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer3.toString());
            x0xo0oo.OI0(xoIox2);
            oI0IIXIo(element, x0xo0oo, false);
        }
    }

    public void O0xOxO(Element element) {
        x0xO0oo oO2 = this.f1189X0o0xo.oO();
        synchronized (oO2) {
            oI0IIXIo(element, oO2, true);
        }
    }

    public void OOXIXo(String str, org.apache.log4j.spi.xxIXOIIO xxixoiio) {
        II0XooXoX(new O0IoXXOx.oIX0oI(this, str), xxixoiio);
    }

    public org.apache.log4j.oIX0oI Oo(Element element) {
        String XI0IXoo2 = XI0IXoo(element.getAttribute(f1157IXxxXO));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Class name: [");
        stringBuffer.append(XI0IXoo2);
        stringBuffer.append(']');
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
        try {
            org.apache.log4j.oIX0oI oix0oi = (org.apache.log4j.oIX0oI) org.apache.log4j.helpers.II0XooXoX.XO(XI0IXoo2).newInstance();
            org.apache.log4j.config.I0Io i0Io = new org.apache.log4j.config.I0Io(oix0oi);
            oix0oi.setName(XI0IXoo(element.getAttribute("name")));
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == 1) {
                    Element element2 = (Element) item;
                    if (element2.getTagName().equals(f1160OOXIXo)) {
                        X0IIOO(element2, i0Io);
                    } else if (element2.getTagName().equals("layout")) {
                        oix0oi.oxoX(xoXoI(element2));
                    } else if (element2.getTagName().equals("filter")) {
                        IIXOooo(element2, oix0oi);
                    } else if (element2.getTagName().equals(f1162OxI)) {
                        OxxIIOOXO(element2, oix0oi);
                    } else if (element2.getTagName().equals(f1184xoIox)) {
                        String XI0IXoo3 = XI0IXoo(element2.getAttribute(f1159O0xOxO));
                        if (oix0oi instanceof org.apache.log4j.spi.oIX0oI) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("Attaching appender named [");
                            stringBuffer2.append(XI0IXoo3);
                            stringBuffer2.append("] to appender named [");
                            stringBuffer2.append(oix0oi.getName());
                            stringBuffer2.append("].");
                            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer2.toString());
                            ((org.apache.log4j.spi.oIX0oI) oix0oi).oIX0oI(oO(element2));
                        } else {
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append("Requesting attachment of appender named [");
                            stringBuffer3.append(XI0IXoo3);
                            stringBuffer3.append("] to appender named [");
                            stringBuffer3.append(oix0oi.getName());
                            stringBuffer3.append("] which does not implement org.apache.log4j.spi.AppenderAttachable.");
                            org.apache.log4j.helpers.xxIXOIIO.I0Io(stringBuffer3.toString());
                        }
                    }
                }
            }
            i0Io.oIX0oI();
            return oix0oi;
        } catch (Exception e) {
            org.apache.log4j.helpers.xxIXOIIO.oxoX("Could not create an Appender. Reported error follows.", e);
            return null;
        }
    }

    public void OxI(Element element) {
        String XI0IXoo2 = XI0IXoo(element.getAttribute(f1170XxX0x0xxx));
        String XI0IXoo3 = XI0IXoo(element.getAttribute(f1183xXxxox0I));
        org.apache.log4j.spi.xxIXOIIO xxixoiio = this.f1189X0o0xo;
        if (xxixoiio instanceof org.apache.log4j.spi.oOoXoXO) {
            Xxx0oXX.I0Io.oIX0oI((org.apache.log4j.spi.oOoXoXO) xxixoiio, XI0IXoo3, XI0IXoo2);
        }
    }

    public void Oxx0xo(Element element) {
        String XI0IXoo2 = XI0IXoo(element.getAttribute(f1157IXxxXO));
        if ("".equals(XI0IXoo2)) {
            org.apache.log4j.helpers.xxIXOIIO.I0Io("Category Factory tag class attribute not found.");
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI("No Category Factory configured.");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Desired category factory: [");
        stringBuffer.append(XI0IXoo2);
        stringBuffer.append(']');
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
        Class cls = f1174oOXoIIIo;
        if (cls == null) {
            cls = II0xO0("org.apache.log4j.spi.LoggerFactory");
            f1174oOXoIIIo = cls;
        }
        org.apache.log4j.config.I0Io i0Io = new org.apache.log4j.config.I0Io(oOoXoXO.XO(XI0IXoo2, cls, null));
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                if (element2.getTagName().equals(f1160OOXIXo)) {
                    X0IIOO(element2, i0Io);
                }
            }
        }
    }

    public void OxxIIOOXO(Element element, org.apache.log4j.oIX0oI oix0oi) {
        String XI0IXoo2 = XI0IXoo(element.getAttribute(f1157IXxxXO));
        Class cls = f1176oo;
        if (cls == null) {
            cls = II0xO0("org.apache.log4j.spi.ErrorHandler");
            f1176oo = cls;
        }
        org.apache.log4j.spi.X0o0xo x0o0xo = (org.apache.log4j.spi.X0o0xo) oOoXoXO.XO(XI0IXoo2, cls, null);
        if (x0o0xo != null) {
            x0o0xo.Oo(oix0oi);
            org.apache.log4j.config.I0Io i0Io = new org.apache.log4j.config.I0Io(x0o0xo);
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == 1) {
                    Element element2 = (Element) item;
                    String tagName = element2.getTagName();
                    if (tagName.equals(f1160OOXIXo)) {
                        X0IIOO(element2, i0Io);
                    } else if (tagName.equals(f1184xoIox)) {
                        x0o0xo.XO(oO(element2));
                    } else if (tagName.equals(f1173oO)) {
                        x0o0xo.II0xO0(this.f1189X0o0xo.xxIXOIIO(element2.getAttribute(f1159O0xOxO)));
                    } else if (tagName.equals(f1165OxxIIOOXO)) {
                        x0o0xo.II0xO0(this.f1189X0o0xo.oO());
                    }
                }
            }
            i0Io.oIX0oI();
            oix0oi.I0Io(x0o0xo);
        }
    }

    public void X0IIOO(Element element, org.apache.log4j.config.I0Io i0Io) {
        i0Io.xxIXOIIO(XI0IXoo(element.getAttribute("name")), XI0IXoo(oOoXoXO.I0Io(element.getAttribute("value"))));
    }

    public String XI0IXoo(String str) {
        try {
            return oOoXoXO.xxIXOIIO(str, this.f1190oxoX);
        } catch (IllegalArgumentException e) {
            org.apache.log4j.helpers.xxIXOIIO.II0XooXoX("Could not perform variable substitution.", e);
            return str;
        }
    }

    public void o00(Element element, x0xO0oo x0xo0oo, boolean z) {
        String xxX2 = x0xo0oo.xxX();
        if (z) {
            xxX2 = "root";
        }
        String XI0IXoo2 = XI0IXoo(element.getAttribute("value"));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Level value for ");
        stringBuffer.append(xxX2);
        stringBuffer.append(" is  [");
        stringBuffer.append(XI0IXoo2);
        stringBuffer.append("].");
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
        if (!org.apache.log4j.spi.II0xO0.f33489oIX0oI.equalsIgnoreCase(XI0IXoo2) && !"null".equalsIgnoreCase(XI0IXoo2)) {
            String XI0IXoo3 = XI0IXoo(element.getAttribute(f1157IXxxXO));
            if ("".equals(XI0IXoo3)) {
                x0xo0oo.o0(oOoXoXO.ooOOo0oXI(XI0IXoo2, Level.DEBUG));
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Desired Level sub-class: [");
                stringBuffer2.append(XI0IXoo3);
                stringBuffer2.append(']');
                org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer2.toString());
                try {
                    x0xo0oo.o0((Level) org.apache.log4j.helpers.II0XooXoX.XO(XI0IXoo3).getMethod("toLevel", f1179ooXIXxIX).invoke(null, XI0IXoo2));
                } catch (Exception e) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Could not create level [");
                    stringBuffer3.append(XI0IXoo2);
                    stringBuffer3.append("]. Reported error follows.");
                    org.apache.log4j.helpers.xxIXOIIO.oxoX(stringBuffer3.toString(), e);
                    return;
                }
            }
        } else if (z) {
            org.apache.log4j.helpers.xxIXOIIO.I0Io("Root level cannot be inherited. Ignoring directive.");
        } else {
            x0xo0oo.o0(null);
        }
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append(xxX2);
        stringBuffer4.append(" level set to ");
        stringBuffer4.append(x0xo0oo.XI0IXoo());
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer4.toString());
    }

    public void oI0IIXIo(Element element, x0xO0oo x0xo0oo, boolean z) {
        org.apache.log4j.config.I0Io i0Io = new org.apache.log4j.config.I0Io(x0xo0oo);
        x0xo0oo.oO();
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                String tagName = element2.getTagName();
                if (tagName.equals(f1184xoIox)) {
                    org.apache.log4j.oIX0oI oO2 = oO(element2);
                    String XI0IXoo2 = XI0IXoo(element2.getAttribute(f1159O0xOxO));
                    if (oO2 != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Adding appender named [");
                        stringBuffer.append(XI0IXoo2);
                        stringBuffer.append("] to category [");
                        stringBuffer.append(x0xo0oo.xxX());
                        stringBuffer.append("].");
                        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
                    } else {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Appender named [");
                        stringBuffer2.append(XI0IXoo2);
                        stringBuffer2.append("] not found.");
                        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer2.toString());
                    }
                    x0xo0oo.oIX0oI(oO2);
                } else if (tagName.equals("level")) {
                    o00(element2, x0xo0oo, z);
                } else if (tagName.equals("priority")) {
                    o00(element2, x0xo0oo, z);
                } else if (tagName.equals(f1160OOXIXo)) {
                    X0IIOO(element2, i0Io);
                }
            }
        }
        i0Io.oIX0oI();
    }

    @Override // org.apache.log4j.spi.II0xO0
    public void oIX0oI(URL url, org.apache.log4j.spi.xxIXOIIO xxixoiio) {
        II0XooXoX(new II0xO0(this, url), xxixoiio);
    }

    public org.apache.log4j.oIX0oI oO(Element element) {
        return x0XOIxOo(element.getOwnerDocument(), XI0IXoo(element.getAttribute(f1159O0xOxO)));
    }

    public void oOoXoXO(Element element, org.apache.log4j.spi.xxIXOIIO xxixoiio) {
        this.f1189X0o0xo = xxixoiio;
        x0xO0oo(element);
    }

    public void ooOOo0oXI(InputSource inputSource, org.apache.log4j.spi.xxIXOIIO xxixoiio) throws FactoryConfigurationError {
        if (inputSource.getSystemId() == null) {
            inputSource.setSystemId("dummy://log4j.dtd");
        }
        II0XooXoX(new X0o0xo(this, inputSource), xxixoiio);
    }

    public org.apache.log4j.oIX0oI x0XOIxOo(Document document, String str) {
        Element element;
        org.apache.log4j.oIX0oI oix0oi = (org.apache.log4j.oIX0oI) this.f1188I0Io.get(str);
        if (oix0oi != null) {
            return oix0oi;
        }
        NodeList elementsByTagName = document.getElementsByTagName(f1186xxIXOIIO);
        int i = 0;
        while (true) {
            if (i >= elementsByTagName.getLength()) {
                element = null;
                break;
            }
            Node item = elementsByTagName.item(i);
            if (str.equals(item.getAttributes().getNamedItem("name").getNodeValue())) {
                element = (Element) item;
                break;
            }
            i++;
        }
        if (element == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No appender named [");
            stringBuffer.append(str);
            stringBuffer.append("] could be found.");
            org.apache.log4j.helpers.xxIXOIIO.I0Io(stringBuffer.toString());
            return null;
        }
        org.apache.log4j.oIX0oI Oo2 = Oo(element);
        this.f1188I0Io.put(str, Oo2);
        return Oo2;
    }

    public void x0xO0oo(Element element) {
        String tagName = element.getTagName();
        if (!tagName.equals(f1169XO)) {
            if (tagName.equals(f1163Oxx0IOOO)) {
                org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("The <configuration> element has been deprecated.");
                org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("Use the <log4j:configuration> element instead.");
            } else {
                org.apache.log4j.helpers.xxIXOIIO.I0Io("DOM element is - not a <log4j:configuration> element.");
                return;
            }
        }
        String XI0IXoo2 = XI0IXoo(element.getAttribute("debug"));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("debug attribute= \"");
        stringBuffer.append(XI0IXoo2);
        stringBuffer.append("\".");
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
        if (!XI0IXoo2.equals("") && !XI0IXoo2.equals("null")) {
            org.apache.log4j.helpers.xxIXOIIO.X0o0xo(oOoXoXO.xoIox(XI0IXoo2, true));
        } else {
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI("Ignoring debug attribute.");
        }
        String XI0IXoo3 = XI0IXoo(element.getAttribute(f1168XIxXXX0x0));
        if (!XI0IXoo3.equals("") && !XI0IXoo3.equals("null")) {
            org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("The \"configDebug\" attribute is deprecated.");
            org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("Use the \"debug\" attribute instead.");
            org.apache.log4j.helpers.xxIXOIIO.X0o0xo(oOoXoXO.xoIox(XI0IXoo3, true));
        }
        String XI0IXoo4 = XI0IXoo(element.getAttribute("threshold"));
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Threshold =\"");
        stringBuffer2.append(XI0IXoo4);
        stringBuffer2.append("\".");
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer2.toString());
        if (!"".equals(XI0IXoo4) && !"null".equals(XI0IXoo4)) {
            this.f1189X0o0xo.oxoX(XI0IXoo4);
        }
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                if (element2.getTagName().equals(f1181x0xO0oo)) {
                    Oxx0xo(element2);
                }
            }
        }
        for (int i2 = 0; i2 < length; i2++) {
            Node item2 = childNodes.item(i2);
            if (item2.getNodeType() == 1) {
                Element element3 = (Element) item2;
                String tagName2 = element3.getTagName();
                if (!tagName2.equals("category") && !tagName2.equals("logger")) {
                    if (tagName2.equals("root")) {
                        O0xOxO(element3);
                    } else if (tagName2.equals(f1154II0XooXoX)) {
                        OxI(element3);
                    }
                } else {
                    IXxxXO(element3);
                }
            }
        }
    }

    public void xoIox(Reader reader, org.apache.log4j.spi.xxIXOIIO xxixoiio) throws FactoryConfigurationError {
        II0XooXoX(new oxoX(this, reader), xxixoiio);
    }

    public x0XOIxOo xoXoI(Element element) {
        String XI0IXoo2 = XI0IXoo(element.getAttribute(f1157IXxxXO));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Parsing layout of class: \"");
        stringBuffer.append(XI0IXoo2);
        stringBuffer.append("\"");
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
        try {
            x0XOIxOo x0xoixoo = (x0XOIxOo) org.apache.log4j.helpers.II0XooXoX.XO(XI0IXoo2).newInstance();
            org.apache.log4j.config.I0Io i0Io = new org.apache.log4j.config.I0Io(x0xoixoo);
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == 1) {
                    Element element2 = (Element) item;
                    if (element2.getTagName().equals(f1160OOXIXo)) {
                        X0IIOO(element2, i0Io);
                    }
                }
            }
            i0Io.oIX0oI();
            return x0xoixoo;
        } catch (Exception e) {
            org.apache.log4j.helpers.xxIXOIIO.oxoX("Could not create the Layout. Reported error follows.", e);
            return null;
        }
    }

    public void xxIXOIIO(InputStream inputStream, org.apache.log4j.spi.xxIXOIIO xxixoiio) throws FactoryConfigurationError {
        II0XooXoX(new I0Io(this, inputStream), xxixoiio);
    }
}
