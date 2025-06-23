package OX00o0X;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* loaded from: classes6.dex */
public class oOoXoXO extends AbstractAction {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final org.apache.log4j.x0xO0oo f1956X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static /* synthetic */ Class f1957XO;

    /* renamed from: I0Io, reason: collision with root package name */
    public final XMLReader f1958I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final JFileChooser f1959II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final JFrame f1960oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final Oxx0xo f1961oxoX;

    static {
        Class cls = f1957XO;
        if (cls == null) {
            cls = II0xO0("org.apache.log4j.chainsaw.LoadXMLAction");
            f1957XO = cls;
        }
        f1956X0o0xo = org.apache.log4j.x0xO0oo.xo0x(cls);
    }

    public oOoXoXO(JFrame jFrame, IXxxXO iXxxXO) throws SAXException, ParserConfigurationException {
        JFileChooser jFileChooser = new JFileChooser();
        this.f1959II0xO0 = jFileChooser;
        jFileChooser.setMultiSelectionEnabled(false);
        jFileChooser.setFileSelectionMode(0);
        this.f1960oIX0oI = jFrame;
        Oxx0xo oxx0xo = new Oxx0xo(iXxxXO);
        this.f1961oxoX = oxx0xo;
        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        this.f1958I0Io = xMLReader;
        xMLReader.setContentHandler(oxx0xo);
    }

    public static /* synthetic */ Class II0xO0(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public final int I0Io(String str) throws SAXException, IOException {
        int II0xO02;
        synchronized (this.f1958I0Io) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<?xml version=\"1.0\" standalone=\"yes\"?>\n");
            stringBuffer.append("<!DOCTYPE log4j:eventSet ");
            stringBuffer.append("[<!ENTITY data SYSTEM \"file:///");
            stringBuffer.append(str);
            stringBuffer.append("\">]>\n");
            stringBuffer.append("<log4j:eventSet xmlns:log4j=\"Claira\">\n");
            stringBuffer.append("&data;\n");
            stringBuffer.append("</log4j:eventSet>\n");
            this.f1958I0Io.parse(new InputSource(new StringReader(stringBuffer.toString())));
            II0xO02 = this.f1961oxoX.II0xO0();
        }
        return II0xO02;
    }

    public void oIX0oI(ActionEvent actionEvent) {
        org.apache.log4j.x0xO0oo x0xo0oo = f1956X0o0xo;
        x0xo0oo.oo0xXOI0I("load file called");
        if (this.f1959II0xO0.showOpenDialog(this.f1960oIX0oI) == 0) {
            x0xo0oo.oo0xXOI0I("Need to load a file");
            File selectedFile = this.f1959II0xO0.getSelectedFile();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("loading the contents of ");
            stringBuffer.append(selectedFile.getAbsolutePath());
            x0xo0oo.oo0xXOI0I(stringBuffer.toString());
            try {
                int I0Io2 = I0Io(selectedFile.getAbsolutePath());
                JFrame jFrame = this.f1960oIX0oI;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Loaded ");
                stringBuffer2.append(I0Io2);
                stringBuffer2.append(" events.");
                JOptionPane.showMessageDialog(jFrame, stringBuffer2.toString(), "CHAINSAW", 1);
            } catch (Exception e) {
                f1956X0o0xo.oxXx0IX("caught an exception loading the file", e);
                JFrame jFrame2 = this.f1960oIX0oI;
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Error parsing file - ");
                stringBuffer3.append(e.getMessage());
                JOptionPane.showMessageDialog(jFrame2, stringBuffer3.toString(), "CHAINSAW", 0);
            }
        }
    }
}
