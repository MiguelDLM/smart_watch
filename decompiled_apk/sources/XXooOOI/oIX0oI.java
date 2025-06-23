package XXooOOI;

import Oxxo.IIXOooo;
import Oxxo.Oxx0IOOO;
import Oxxo.X0o0xo;
import Oxxo.xxIXOIIO;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.lang3.XX0;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.LogLevelFormatException;
import org.apache.log4j.lf5.viewer.IoOoX;
import org.apache.log4j.lf5.viewer.LogTableColumn;
import org.apache.log4j.lf5.viewer.LogTableColumnFormatException;
import org.apache.log4j.lf5.viewer.o0;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f4112I0Io = "lf5_configuration.xml";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f4113II0XooXoX = "category";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f4114OOXIXo = "colorlevel";

    /* renamed from: Oo, reason: collision with root package name */
    public static final String f4115Oo = "searchtext";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f4116Oxx0IOOO = "expanded";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f4117X0o0xo = "path";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f4118XO = "selected";

    /* renamed from: oO, reason: collision with root package name */
    public static final String f4119oO = "blue";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f4120oOoXoXO = "color";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f4121ooOOo0oXI = "red";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f4122oxoX = "name";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final String f4123x0XOIxOo = "green";

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final String f4124x0xO0oo = "column";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f4125xoIox = "level";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f4126xxIXOIIO = "Categories";

    /* renamed from: II0xO0, reason: collision with root package name */
    public o0 f4127II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public IoOoX f4128oIX0oI;

    public oIX0oI(IoOoX ioOoX, o0 o0Var) {
        this.f4128oIX0oI = ioOoX;
        this.f4127II0xO0 = o0Var;
        xoIox();
    }

    public static String X0IIOO(TreePath treePath) {
        StringBuffer stringBuffer = new StringBuffer();
        Object[] path = treePath.getPath();
        for (int i = 1; i < path.length; i++) {
            xxIXOIIO xxixoiio = (xxIXOIIO) path[i];
            if (i > 1) {
                stringBuffer.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            }
            stringBuffer.append(xxixoiio.Oxx0IOOO());
        }
        return stringBuffer.toString();
    }

    public void I0Io() {
        try {
            File file = new File(II0XooXoX());
            if (file.exists()) {
                file.delete();
            }
        } catch (SecurityException unused) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot delete ");
            stringBuffer.append(II0XooXoX());
            stringBuffer.append(" because a security violation occured.");
            printStream.println(stringBuffer.toString());
        }
    }

    public String II0XooXoX() {
        String property = System.getProperty(XX0.f32529II0xO0);
        String property2 = System.getProperty("file.separator");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(property);
        stringBuffer.append(property2);
        stringBuffer.append("lf5");
        stringBuffer.append(property2);
        stringBuffer.append(f4112I0Io);
        return stringBuffer.toString();
    }

    public void II0xO0() {
        Oxx0IOOO o02 = this.f4128oIX0oI.o0();
        for (int rowCount = o02.getRowCount() - 1; rowCount > 0; rowCount--) {
            o02.collapseRow(rowCount);
        }
    }

    public void IIXOooo(Document document) {
        String xxIXOIIO2;
        Node item = document.getElementsByTagName(f4115Oo).item(0);
        if (item != null && (xxIXOIIO2 = xxIXOIIO(item.getAttributes(), "name")) != null && !xxIXOIIO2.equals("")) {
            this.f4128oIX0oI.IIX0(xxIXOIIO2);
        }
    }

    public void IXxxXO(Document document) {
        NodeList elementsByTagName = document.getElementsByTagName("level");
        Map oxxXoxO2 = this.f4128oIX0oI.oxxXoxO();
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            NamedNodeMap attributes = elementsByTagName.item(i).getAttributes();
            try {
                ((JCheckBoxMenuItem) oxxXoxO2.get(LogLevel.valueOf(xxIXOIIO(attributes, "name")))).setSelected(xxIXOIIO(attributes, f4118XO).equalsIgnoreCase("true"));
            } catch (LogLevelFormatException unused) {
            }
        }
    }

    public void O0xOxO(String str) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(II0XooXoX()));
            printWriter.print(str);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void OOXIXo(StringBuffer stringBuffer) {
        stringBuffer.append("<configuration>\r\n");
    }

    public final void Oo(Map map, StringBuffer stringBuffer) {
        stringBuffer.append("\t<loglevels>\r\n");
        for (LogLevel logLevel : map.keySet()) {
            X0o0xo(logLevel.getLabel(), ((JCheckBoxMenuItem) map.get(logLevel)).isSelected(), stringBuffer);
        }
        stringBuffer.append("\t</loglevels>\r\n");
    }

    public void OxI() {
        Enumeration breadthFirstEnumeration = this.f4128oIX0oI.o0().I0Io().XO().breadthFirstEnumeration();
        while (breadthFirstEnumeration.hasMoreElements()) {
            ((xxIXOIIO) breadthFirstEnumeration.nextElement()).IXxxXO(true);
        }
    }

    public final void Oxx0IOOO(xxIXOIIO xxixoiio, TreePath treePath, StringBuffer stringBuffer) {
        Oxx0IOOO o02 = this.f4128oIX0oI.o0();
        stringBuffer.append("\t<");
        stringBuffer.append("category");
        stringBuffer.append(" ");
        stringBuffer.append("name");
        stringBuffer.append("=\"");
        stringBuffer.append(xxixoiio.Oxx0IOOO());
        stringBuffer.append("\" ");
        stringBuffer.append("path");
        stringBuffer.append("=\"");
        stringBuffer.append(X0IIOO(treePath));
        stringBuffer.append("\" ");
        stringBuffer.append(f4116Oxx0IOOO);
        stringBuffer.append("=\"");
        stringBuffer.append(o02.isExpanded(treePath));
        stringBuffer.append("\" ");
        stringBuffer.append(f4118XO);
        stringBuffer.append("=\"");
        stringBuffer.append(xxixoiio.oOoXoXO());
        stringBuffer.append("\"/>\r\n");
    }

    public final void Oxx0xo(String str, StringBuffer stringBuffer) {
        stringBuffer.append("\t<");
        stringBuffer.append(f4115Oo);
        stringBuffer.append(" ");
        stringBuffer.append("name");
        stringBuffer.append("=\"");
        stringBuffer.append(str);
        stringBuffer.append("\"");
        stringBuffer.append("/>\r\n");
    }

    public void OxxIIOOXO(Document document) {
        Node item;
        NodeList elementsByTagName = document.getElementsByTagName(f4124x0xO0oo);
        Map xo0x2 = this.f4128oIX0oI.xo0x();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < elementsByTagName.getLength() && (item = elementsByTagName.item(i)) != null; i++) {
            NamedNodeMap attributes = item.getAttributes();
            try {
                LogTableColumn valueOf = LogTableColumn.valueOf(xxIXOIIO(attributes, "name"));
                JCheckBoxMenuItem jCheckBoxMenuItem = (JCheckBoxMenuItem) xo0x2.get(valueOf);
                jCheckBoxMenuItem.setSelected(xxIXOIIO(attributes, f4118XO).equalsIgnoreCase("true"));
                if (jCheckBoxMenuItem.isSelected()) {
                    arrayList.add(valueOf);
                }
            } catch (LogTableColumnFormatException unused) {
            }
            if (arrayList.isEmpty()) {
                this.f4127II0xO0.Oxx0IOOO();
            } else {
                this.f4127II0xO0.xxIXOIIO(arrayList);
            }
        }
    }

    public final void X0o0xo(String str, boolean z, StringBuffer stringBuffer) {
        stringBuffer.append("\t\t<");
        stringBuffer.append("level");
        stringBuffer.append(" ");
        stringBuffer.append("name");
        stringBuffer.append("=\"");
        stringBuffer.append(str);
        stringBuffer.append("\" ");
        stringBuffer.append(f4118XO);
        stringBuffer.append("=\"");
        stringBuffer.append(z);
        stringBuffer.append("\"/>\r\n");
    }

    public final void XO(String str, boolean z, StringBuffer stringBuffer) {
        stringBuffer.append("\t\t<");
        stringBuffer.append(f4124x0xO0oo);
        stringBuffer.append(" ");
        stringBuffer.append("name");
        stringBuffer.append("=\"");
        stringBuffer.append(str);
        stringBuffer.append("\" ");
        stringBuffer.append(f4118XO);
        stringBuffer.append("=\"");
        stringBuffer.append(z);
        stringBuffer.append("\"/>\r\n");
    }

    public void o00() {
        xxIXOIIO XO2 = this.f4128oIX0oI.o0().I0Io().XO();
        StringBuffer stringBuffer = new StringBuffer(2048);
        oOoXoXO(stringBuffer);
        OOXIXo(stringBuffer);
        Oxx0xo(this.f4128oIX0oI.I0X0x0oIo(), stringBuffer);
        Oo(this.f4128oIX0oI.oxxXoxO(), stringBuffer);
        oO(this.f4128oIX0oI.oxxXoxO(), LogLevel.getLogLevelColorMap(), stringBuffer);
        oI0IIXIo(LogTableColumn.getLogTableColumns(), stringBuffer);
        x0XOIxOo(XO2, stringBuffer);
        oIX0oI(stringBuffer);
        O0xOxO(stringBuffer.toString());
    }

    public final void oI0IIXIo(List list, StringBuffer stringBuffer) {
        stringBuffer.append("\t<logtablecolumns>\r\n");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LogTableColumn logTableColumn = (LogTableColumn) it.next();
            XO(logTableColumn.getLabel(), this.f4128oIX0oI.XoI0Ixx0(logTableColumn).isSelected(), stringBuffer);
        }
        stringBuffer.append("\t</logtablecolumns>\r\n");
    }

    public final void oIX0oI(StringBuffer stringBuffer) {
        stringBuffer.append("</configuration>\r\n");
    }

    public final void oO(Map map, Map map2, StringBuffer stringBuffer) {
        stringBuffer.append("\t<loglevelcolors>\r\n");
        for (LogLevel logLevel : map.keySet()) {
            oxoX(logLevel.getLabel(), (Color) map2.get(logLevel), stringBuffer);
        }
        stringBuffer.append("\t</loglevelcolors>\r\n");
    }

    public final void oOoXoXO(StringBuffer stringBuffer) {
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [boolean] */
    public void ooOOo0oXI(Document document) {
        Oxx0IOOO o02 = this.f4128oIX0oI.o0();
        X0o0xo I0Io2 = o02.I0Io();
        NodeList elementsByTagName = document.getElementsByTagName("category");
        ?? equalsIgnoreCase = xxIXOIIO(elementsByTagName.item(0).getAttributes(), "name").equalsIgnoreCase(f4126xxIXOIIO);
        for (int length = elementsByTagName.getLength() - 1; length >= equalsIgnoreCase; length--) {
            NamedNodeMap attributes = elementsByTagName.item(length).getAttributes();
            xxIXOIIO II0xO02 = I0Io2.II0xO0(new IIXOooo(xxIXOIIO(attributes, "path")));
            II0xO02.IXxxXO(xxIXOIIO(attributes, f4118XO).equalsIgnoreCase("true"));
            xxIXOIIO(attributes, f4116Oxx0IOOO).equalsIgnoreCase("true");
            o02.expandPath(I0Io2.Oxx0IOOO(II0xO02));
        }
    }

    public final void oxoX(String str, Color color, StringBuffer stringBuffer) {
        stringBuffer.append("\t\t<");
        stringBuffer.append(f4114OOXIXo);
        stringBuffer.append(" ");
        stringBuffer.append("name");
        stringBuffer.append("=\"");
        stringBuffer.append(str);
        stringBuffer.append("\" ");
        stringBuffer.append(f4121ooOOo0oXI);
        stringBuffer.append("=\"");
        stringBuffer.append(color.getRed());
        stringBuffer.append("\" ");
        stringBuffer.append(f4123x0XOIxOo);
        stringBuffer.append("=\"");
        stringBuffer.append(color.getGreen());
        stringBuffer.append("\" ");
        stringBuffer.append(f4119oO);
        stringBuffer.append("=\"");
        stringBuffer.append(color.getBlue());
        stringBuffer.append("\"/>\r\n");
    }

    public final void x0XOIxOo(xxIXOIIO xxixoiio, StringBuffer stringBuffer) {
        X0o0xo I0Io2 = this.f4128oIX0oI.o0().I0Io();
        Enumeration breadthFirstEnumeration = xxixoiio.breadthFirstEnumeration();
        while (breadthFirstEnumeration.hasMoreElements()) {
            xxIXOIIO xxixoiio2 = (xxIXOIIO) breadthFirstEnumeration.nextElement();
            Oxx0IOOO(xxixoiio2, I0Io2.Oxx0IOOO(xxixoiio2), stringBuffer);
        }
    }

    public void x0xO0oo(Document document) {
        Node item;
        NodeList elementsByTagName = document.getElementsByTagName(f4114OOXIXo);
        LogLevel.getLogLevelColorMap();
        for (int i = 0; i < elementsByTagName.getLength() && (item = elementsByTagName.item(i)) != null; i++) {
            NamedNodeMap attributes = item.getAttributes();
            try {
                LogLevel valueOf = LogLevel.valueOf(xxIXOIIO(attributes, "name"));
                Color color = new Color(Integer.parseInt(xxIXOIIO(attributes, f4121ooOOo0oXI)), Integer.parseInt(xxIXOIIO(attributes, f4123x0XOIxOo)), Integer.parseInt(xxIXOIIO(attributes, f4119oO)));
                if (valueOf != null) {
                    valueOf.setLogLevelColorMap(valueOf, color);
                }
            } catch (LogLevelFormatException unused) {
            }
        }
    }

    public void xoIox() {
        File file = new File(II0XooXoX());
        if (file.exists()) {
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
                IIXOooo(parse);
                ooOOo0oXI(parse);
                IXxxXO(parse);
                x0xO0oo(parse);
                OxxIIOOXO(parse);
            } catch (Exception e) {
                PrintStream printStream = System.err;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unable process configuration file at ");
                stringBuffer.append(II0XooXoX());
                stringBuffer.append(". Error Message=");
                stringBuffer.append(e.getMessage());
                printStream.println(stringBuffer.toString());
            }
        }
    }

    public void xoXoI() {
        I0Io();
        II0xO0();
        OxI();
    }

    public String xxIXOIIO(NamedNodeMap namedNodeMap, String str) {
        return namedNodeMap.getNamedItem(str).getNodeValue();
    }
}
