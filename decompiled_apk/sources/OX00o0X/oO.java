package OX00o0X;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.awt.Dimension;
import java.io.IOException;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import org.apache.log4j.IIXOooo;

/* loaded from: classes6.dex */
public class oO extends JFrame {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final org.apache.log4j.x0xO0oo f1952I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f1953II0xO0 = "chainsaw.port";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f1954oIX0oI = 4445;

    /* renamed from: oxoX, reason: collision with root package name */
    public static /* synthetic */ Class f1955oxoX;

    static {
        Class cls = f1955oxoX;
        if (cls == null) {
            cls = oIX0oI("org.apache.log4j.chainsaw.Main");
            f1955oxoX = cls;
        }
        f1952I0Io = org.apache.log4j.x0xO0oo.xo0x(cls);
    }

    public oO() {
        super("CHAINSAW - Log4J Log Viewer");
        IXxxXO iXxxXO = new IXxxXO();
        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);
        JMenu jMenu = new JMenu("File");
        jMenuBar.add(jMenu);
        try {
            oOoXoXO oooxoxo = new oOoXoXO(this, iXxxXO);
            JMenuItem jMenuItem = new JMenuItem("Load file...");
            jMenu.add(jMenuItem);
            jMenuItem.addActionListener(oooxoxo);
        } catch (Exception e) {
            f1952I0Io.oo("Unable to create the action to load XML files", e);
            JOptionPane.showMessageDialog(this, "Unable to create a XML parser - unable to load XML events.", "CHAINSAW", 0);
        } catch (NoClassDefFoundError e2) {
            f1952I0Io.oo("Missing classes for XML parser", e2);
            JOptionPane.showMessageDialog(this, "XML parser not in classpath - unable to load XML events.", "CHAINSAW", 0);
        }
        JMenuItem jMenuItem2 = new JMenuItem("Exit");
        jMenu.add(jMenuItem2);
        jMenuItem2.addActionListener(OOXIXo.f1923II0xO0);
        getContentPane().add(new II0XooXoX(iXxxXO), "North");
        JTable jTable = new JTable(iXxxXO);
        jTable.setSelectionMode(0);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBorder(BorderFactory.createTitledBorder("Events: "));
        jScrollPane.setPreferredSize(new Dimension(900, 300));
        xxIXOIIO xxixoiio = new xxIXOIIO(jTable, iXxxXO);
        xxixoiio.setPreferredSize(new Dimension(900, 300));
        getContentPane().add(new JSplitPane(0, jScrollPane, xxixoiio), "Center");
        addWindowListener(new x0XOIxOo(this));
        pack();
        setVisible(true);
        oxoX(iXxxXO);
    }

    public static void I0Io(String[] strArr) {
        II0xO0();
        new oO();
    }

    public static void II0xO0() {
        Properties properties = new Properties();
        properties.setProperty(IIXOooo.f33175xoIox, "DEBUG, A1");
        properties.setProperty("log4j.appender.A1", "org.apache.log4j.ConsoleAppender");
        properties.setProperty("log4j.appender.A1.layout", "org.apache.log4j.TTCCLayout");
        IIXOooo.X0o0xo(properties);
    }

    public static /* synthetic */ Class oIX0oI(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public final void oxoX(IXxxXO iXxxXO) {
        int parseInt;
        String property = System.getProperty(f1953II0xO0);
        try {
            if (property != null) {
                try {
                    parseInt = Integer.parseInt(property);
                } catch (NumberFormatException unused) {
                    org.apache.log4j.x0xO0oo x0xo0oo = f1952I0Io;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unable to parse chainsaw.port property with value ");
                    stringBuffer.append(property);
                    stringBuffer.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                    x0xo0oo.Oo(stringBuffer.toString());
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Unable to parse port number from '");
                    stringBuffer2.append(property);
                    stringBuffer2.append("', quitting.");
                    JOptionPane.showMessageDialog(this, stringBuffer2.toString(), "CHAINSAW", 0);
                    System.exit(1);
                }
                new ooOOo0oXI(iXxxXO, parseInt).start();
                return;
            }
            new ooOOo0oXI(iXxxXO, parseInt).start();
            return;
        } catch (IOException e) {
            f1952I0Io.IXxxXO("Unable to connect to socket server, quiting", e);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Unable to create socket on port ");
            stringBuffer3.append(parseInt);
            stringBuffer3.append(", quitting.");
            JOptionPane.showMessageDialog(this, stringBuffer3.toString(), "CHAINSAW", 0);
            System.exit(1);
            return;
        }
        parseInt = f1954oIX0oI;
    }
}
