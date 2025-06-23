package org.apache.log4j.lf5.viewer;

import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HTTP;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.LogRecord;

/* loaded from: classes6.dex */
public class IoOoX {

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final String f33352XIxXXX0x0 = "Detailed";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Dimension f33357IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f33363Oxx0xo;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Oxxo.Oxx0IOOO f33366X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f33368XO;

    /* renamed from: o00, reason: collision with root package name */
    public List f33369o00;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public JFrame f33371oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public JComboBox f33373oOoXoXO;

    /* renamed from: oxoX, reason: collision with root package name */
    public o0 f33375oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public JLabel f33378xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public List f33379xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public JScrollPane f33380xxIXOIIO;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f33355II0xO0 = 550;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f33353I0Io = 500;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f33362Oxx0IOOO = "";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public LogLevel f33354II0XooXoX = LogLevel.DEBUG;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public Object f33359OOXIXo = new Object();

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f33374ooOOo0oXI = 10;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public String f33376x0XOIxOo = "Dialog";

    /* renamed from: oO, reason: collision with root package name */
    public String f33372oO = f33352XIxXXX0x0;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public boolean f33377x0xO0oo = false;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f33360Oo = true;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public List f33370oI0IIXIo = new Vector();

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Map f33364OxxIIOOXO = new HashMap();

    /* renamed from: IIXOooo, reason: collision with root package name */
    public Map f33356IIXOooo = new HashMap();

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f33361OxI = false;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public XXooOOI.oIX0oI f33358O0xOxO = null;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public XXooOOI.II0xO0 f33365X0IIOO = null;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public File f33367XI0IXoo = null;

    /* loaded from: classes6.dex */
    public class oIX0oI extends WindowAdapter {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public IoOoX f33382oIX0oI;

        public oIX0oI(IoOoX ioOoX) {
            this.f33382oIX0oI = ioOoX;
        }

        public void oIX0oI(WindowEvent windowEvent) {
            this.f33382oIX0oI.Ioxxx();
        }
    }

    public IoOoX(List list) {
        this.f33363Oxx0xo = false;
        this.f33369o00 = null;
        this.f33379xoXoI = list;
        this.f33369o00 = LogTableColumn.getLogTableColumns();
        String property = System.getProperty("monitor.exit");
        if ((property == null ? "false" : property).trim().toLowerCase().equals("true")) {
            this.f33363Oxx0xo = true;
        }
        I0oOIX();
        this.f33371oIX0oI.addWindowListener(new oIX0oI(this));
    }

    public void I0(int i) {
        if (i == -1) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f33368XO);
            stringBuffer.append(" not found.");
            JOptionPane.showMessageDialog(this.f33371oIX0oI, stringBuffer.toString(), "Text not found", 1);
            return;
        }
        I0Io.XO(i, this.f33375oxoX, this.f33380xxIXOIIO);
    }

    public void I0Io() {
        org.apache.log4j.lf5.viewer.oIX0oI oxoX2 = this.f33375oxoX.oxoX();
        oIX0oI(new xXxxox0I(this));
        oIX0oI(new IIX0o(this, oxoX2));
    }

    public String I0X0x0oIo() {
        return this.f33362Oxx0IOOO;
    }

    public void I0oOIX() {
        JFrame jFrame = new JFrame("LogFactor5");
        this.f33371oIX0oI = jFrame;
        jFrame.setDefaultCloseOperation(0);
        URL resource = getClass().getResource("/org/apache/log4j/lf5/viewer/images/lf5_small_icon.gif");
        if (resource != null) {
            this.f33371oIX0oI.setIconImage(new ImageIcon(resource).getImage());
        }
        OIOoIIOIx();
        JTextArea oO2 = oO();
        JScrollPane jScrollPane = new JScrollPane(oO2);
        o0 o0Var = new o0(oO2);
        this.f33375oxoX = o0Var;
        xx0X0(this.f33372oO, o0Var);
        this.f33375oxoX.II0XooXoX(new Font(this.f33376x0XOIxOo, 0, this.f33374ooOOo0oXI));
        JScrollPane jScrollPane2 = new JScrollPane(this.f33375oxoX);
        this.f33380xxIXOIIO = jScrollPane2;
        if (this.f33360Oo) {
            jScrollPane2.getVerticalScrollBar().addAdjustmentListener(new oxxXoxO());
        }
        JSplitPane jSplitPane = new JSplitPane();
        jSplitPane.setOneTouchExpandable(true);
        jSplitPane.setOrientation(0);
        jSplitPane.setLeftComponent(this.f33380xxIXOIIO);
        jSplitPane.setRightComponent(jScrollPane);
        jSplitPane.setDividerLocation(350);
        this.f33366X0o0xo = new Oxxo.Oxx0IOOO();
        this.f33375oxoX.oxoX().Oo(XI0IXoo());
        JScrollPane jScrollPane3 = new JScrollPane(this.f33366X0o0xo);
        jScrollPane3.setPreferredSize(new Dimension(130, 400));
        this.f33365X0IIOO = new XXooOOI.II0xO0();
        JSplitPane jSplitPane2 = new JSplitPane();
        jSplitPane2.setOneTouchExpandable(true);
        jSplitPane2.setRightComponent(jSplitPane);
        jSplitPane2.setLeftComponent(jScrollPane3);
        jSplitPane2.setDividerLocation(130);
        this.f33371oIX0oI.getRootPane().setJMenuBar(XxX0x0xxx());
        this.f33371oIX0oI.getContentPane().add(jSplitPane2, "Center");
        this.f33371oIX0oI.getContentPane().add(X00IoxXI(), "North");
        this.f33371oIX0oI.getContentPane().add(oOXoIIIo(), "South");
        IoOoo();
        I0Io();
        this.f33358O0xOxO = new XXooOOI.oIX0oI(this, this.f33375oxoX);
    }

    public int I0oOoX() {
        return this.f33375oxoX.getSelectionModel().getMinSelectionIndex();
    }

    public JMenuItem II0XooXoX() {
        JMenuItem jMenuItem = new JMenuItem("Show all LogLevels");
        jMenuItem.setMnemonic('s');
        jMenuItem.addActionListener(new xI(this));
        return jMenuItem;
    }

    public void II0xO0(LogRecord logRecord) {
        if (this.f33361OxI) {
            return;
        }
        SwingUtilities.invokeLater(new O0xOxO(this, logRecord));
    }

    public void IIX0(String str) {
        this.f33375oxoX.oxoX().Oo(IIX0o(str));
    }

    public org.apache.log4j.lf5.oxoX IIX0o(String str) {
        this.f33362Oxx0IOOO = str;
        return new XxX0x0xxx(this);
    }

    public JMenu IIXOooo() {
        JMenu jMenu = new JMenu("File");
        jMenu.setMnemonic('f');
        jMenu.add(oo0xXOI0I());
        jMenu.add(oo());
        jMenu.addSeparator();
        jMenu.add(xoIox());
        xxX(jMenu);
        jMenu.addSeparator();
        jMenu.add(OxxIIOOXO());
        return jMenu;
    }

    public void IIxOXoOo0(boolean z) {
        Iterator xXOx2 = xXOx();
        while (xXOx2.hasNext()) {
            oxXx0IX((LogTableColumn) xXOx2.next()).setSelected(z);
        }
    }

    public JMenu IO() {
        JMenu jMenu = new JMenu("View");
        jMenu.setMnemonic('v');
        Iterator xXOx2 = xXOx();
        while (xXOx2.hasNext()) {
            jMenu.add(oxXx0IX((LogTableColumn) xXOx2.next()));
        }
        jMenu.addSeparator();
        jMenu.add(xxIXOIIO());
        jMenu.add(xI());
        return jMenu;
    }

    public JMenu IXxxXO() {
        JMenu jMenu = new JMenu("Edit");
        jMenu.setMnemonic('e');
        jMenu.add(x0xO0oo());
        jMenu.add(Oo());
        jMenu.addSeparator();
        jMenu.add(oI0IIXIo());
        jMenu.add(Oxx0xo());
        return jMenu;
    }

    public boolean Io() {
        return this.f33363Oxx0xo;
    }

    public void IoIOOxIIo(int i) {
        if (this.f33371oIX0oI.isVisible()) {
            return;
        }
        SwingUtilities.invokeLater(new x0XOIxOo(this, i));
    }

    public JMenuItem IoOoX() {
        JMenuItem jMenuItem = new JMenuItem("Reset LogLevel Colors");
        jMenuItem.setMnemonic('r');
        jMenuItem.addActionListener(new oxoX(this));
        return jMenuItem;
    }

    public void IoOoo() {
        this.f33366X0o0xo.I0Io().oIX0oI(new ooXIXxIX(this));
    }

    public void Ioxxx() {
        ooOx(false);
        Oxx0IOOO();
    }

    public List IxIX0I() {
        ArrayList arrayList = new ArrayList();
        for (LogTableColumn logTableColumn : this.f33369o00) {
            if (oxXx0IX(logTableColumn).isSelected()) {
                arrayList.add(logTableColumn);
            }
        }
        return arrayList;
    }

    public void O0(String str) {
        JFrame jFrame = this.f33371oIX0oI;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(" - LogFactor5");
        jFrame.setTitle(stringBuffer.toString());
    }

    public void O00XxXI() {
        String Oxx0IOOO2 = new XOxIOxOx(OI0(), "Open URL", "URL:").Oxx0IOOO();
        if (Oxx0IOOO2 != null) {
            if (Oxx0IOOO2.indexOf("://") == -1) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(BNWebViewClient.URL_HTTP_PREFIX);
                stringBuffer.append(Oxx0IOOO2);
                Oxx0IOOO2 = stringBuffer.toString();
            }
            try {
                URL url = new URL(Oxx0IOOO2);
                if (OO(url)) {
                    this.f33365X0IIOO.oOoXoXO(url);
                    x0OIX00oO();
                }
            } catch (MalformedURLException unused) {
                new X00IoxXI(OI0(), "Error reading URL.");
            }
        }
    }

    public void O0X() {
        String Oxx0IOOO2 = new XOxIOxOx(OI0(), "Set Max Number of Records", "", 10).Oxx0IOOO();
        if (Oxx0IOOO2 != null) {
            try {
                oOo(Integer.parseInt(Oxx0IOOO2));
            } catch (NumberFormatException unused) {
                JFrame OI02 = OI0();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("'");
                stringBuffer.append(Oxx0IOOO2);
                stringBuffer.append("' is an invalid parameter.\nPlease try again.");
                new X00IoxXI(OI02, stringBuffer.toString());
                O0X();
            }
        }
    }

    public void O0Xx() {
        this.f33371oIX0oI.setVisible(false);
    }

    public JComboBox O0xOxO() {
        JComboBox jComboBox = new JComboBox();
        Iterator XoX2 = XoX();
        while (XoX2.hasNext()) {
            jComboBox.addItem(XoX2.next());
        }
        jComboBox.setSelectedItem(this.f33354II0XooXoX);
        jComboBox.addActionListener(new XIxXXX0x0(this));
        jComboBox.setMaximumSize(jComboBox.getPreferredSize());
        return jComboBox;
    }

    public JFrame OI0() {
        return this.f33371oIX0oI;
    }

    public void OIOoIIOIx() {
        this.f33371oIX0oI.setSize(this.f33355II0xO0, this.f33353I0Io);
        oxoX(this.f33371oIX0oI);
    }

    public boolean OO(URL url) {
        try {
            new xXIX0Xo.I0Io(url.openStream()).Oxx0IOOO(this);
            return true;
        } catch (IOException unused) {
            JFrame OI02 = OI0();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Error reading URL:");
            stringBuffer.append(url.getFile());
            new X00IoxXI(OI02, stringBuffer.toString());
            return false;
        }
    }

    public void OO0x0xX(JTextArea jTextArea) {
        String text = jTextArea.getText();
        jTextArea.setText("");
        jTextArea.setText(text);
    }

    public JMenuItem OOXIXo() {
        JMenuItem jMenuItem = new JMenuItem("Set Max Number of Records");
        jMenuItem.setMnemonic('m');
        jMenuItem.addActionListener(new Oxx0xo(this));
        return jMenuItem;
    }

    public void OOXIxO0(boolean z) {
        Iterator XoX2 = XoX();
        while (XoX2.hasNext()) {
            XX0((LogLevel) XoX2.next()).setSelected(z);
        }
    }

    public void OX00O0xII(int i) {
        X0o0xo(this.f33373oOoXoXO, i);
    }

    public JMenuItem Oo() {
        JMenuItem jMenuItem = new JMenuItem("Find Next");
        jMenuItem.setMnemonic('n');
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke("F3"));
        jMenuItem.addActionListener(new OxxIIOOXO(this));
        return jMenuItem;
    }

    public void OoO() {
    }

    public void Ox0O(String str) {
        this.f33368XO = str;
    }

    public JMenu OxI() {
        JMenu jMenu = new JMenu("Configure LogLevel Colors");
        jMenu.setMnemonic('c');
        Iterator XoX2 = XoX();
        while (XoX2.hasNext()) {
            jMenu.add(Xx000oIo((LogLevel) XoX2.next()));
        }
        return jMenu;
    }

    public void Oxx0IOOO() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        if (!this.f33363Oxx0xo) {
            stringBuffer.append("Are you sure you want to close the logging ");
            stringBuffer.append("console?\n");
            stringBuffer.append("(Note: This will not shut down the Virtual Machine,\n");
            stringBuffer.append("or the Swing event thread.)");
        } else {
            stringBuffer.append("Are you sure you want to exit?\n");
            stringBuffer.append("This will shut down the Virtual Machine.\n");
        }
        if (this.f33363Oxx0xo) {
            str = "Are you sure you want to exit?";
        } else {
            str = "Are you sure you want to dispose of the Logging Console?";
        }
        if (JOptionPane.showConfirmDialog(this.f33371oIX0oI, stringBuffer.toString(), str, 2, 3, (Icon) null) == 0) {
            xII();
        }
    }

    public JMenuItem Oxx0xo() {
        JMenuItem jMenuItem = new JMenuItem("Restore all NDCs");
        jMenuItem.setMnemonic('r');
        jMenuItem.addActionListener(new o00(this));
        return jMenuItem;
    }

    public JMenuItem OxxIIOOXO() {
        JMenuItem jMenuItem = new JMenuItem("Exit");
        jMenuItem.setMnemonic('x');
        jMenuItem.addActionListener(new oO(this));
        return jMenuItem;
    }

    public JToolBar X00IoxXI() {
        ImageIcon imageIcon;
        String[] fontList;
        JToolBar jToolBar = new JToolBar();
        jToolBar.putClientProperty("JToolBar.isRollover", Boolean.TRUE);
        JComboBox jComboBox = new JComboBox();
        JComboBox jComboBox2 = new JComboBox();
        this.f33373oOoXoXO = jComboBox2;
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        URL resource = classLoader.getResource("org/apache/log4j/lf5/viewer/images/channelexplorer_new.gif");
        if (resource != null) {
            imageIcon = new ImageIcon(resource);
        } else {
            imageIcon = null;
        }
        JButton jButton = new JButton("Clear Log Table");
        if (imageIcon != null) {
            jButton.setIcon(imageIcon);
        }
        jButton.setToolTipText("Clear Log Table.");
        jButton.addActionListener(new OxI(this));
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        if (this.f33377x0xO0oo) {
            fontList = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        } else {
            fontList = defaultToolkit.getFontList();
        }
        for (String str : fontList) {
            jComboBox.addItem(str);
        }
        jComboBox.setSelectedItem(this.f33376x0XOIxOo);
        jComboBox.addActionListener(new X0IIOO(this));
        jComboBox2.addItem("8");
        jComboBox2.addItem("9");
        jComboBox2.addItem("10");
        jComboBox2.addItem(com.tencent.connect.common.II0xO0.f26834o0IXXIx);
        jComboBox2.addItem(com.tencent.connect.common.II0xO0.f26773OO0);
        jComboBox2.addItem("16");
        jComboBox2.addItem("18");
        jComboBox2.addItem(com.tencent.connect.common.II0xO0.f26868oxOXxoXII);
        jComboBox2.setSelectedItem(String.valueOf(this.f33374ooOOo0oXI));
        jComboBox2.addActionListener(new XI0IXoo(this));
        jToolBar.add(new JLabel(" Font: "));
        jToolBar.add(jComboBox);
        jToolBar.add(jComboBox2);
        jToolBar.addSeparator();
        jToolBar.addSeparator();
        jToolBar.add(jButton);
        jButton.setAlignmentY(0.5f);
        jButton.setAlignmentX(0.5f);
        jComboBox.setMaximumSize(jComboBox.getPreferredSize());
        jComboBox2.setMaximumSize(jComboBox2.getPreferredSize());
        return jToolBar;
    }

    public JMenu X0IIOO() {
        JMenu jMenu = new JMenu("Log Level");
        jMenu.setMnemonic('l');
        Iterator XoX2 = XoX();
        while (XoX2.hasNext()) {
            jMenu.add(XX0((LogLevel) XoX2.next()));
        }
        jMenu.addSeparator();
        jMenu.add(II0XooXoX());
        jMenu.add(ooXIXxIX());
        jMenu.addSeparator();
        jMenu.add(OxI());
        jMenu.add(IoOoX());
        return jMenu;
    }

    public int X0o0xo(JComboBox jComboBox, int i) {
        int itemCount = jComboBox.getItemCount();
        Object itemAt = jComboBox.getItemAt(0);
        int parseInt = Integer.parseInt(String.valueOf(itemAt));
        for (int i2 = 0; i2 < itemCount; i2++) {
            Object itemAt2 = jComboBox.getItemAt(i2);
            int parseInt2 = Integer.parseInt(String.valueOf(itemAt2));
            if (parseInt < parseInt2 && parseInt2 <= i) {
                itemAt = itemAt2;
                parseInt = parseInt2;
            }
        }
        jComboBox.setSelectedItem(itemAt);
        return parseInt;
    }

    public org.apache.log4j.lf5.oxoX XI0IXoo() {
        return new xxX(this);
    }

    public void XI0oooXX() {
        this.f33358O0xOxO.o00();
    }

    public void XIXIX(int i, int i2) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (i > 0 && i < screenSize.width) {
            this.f33355II0xO0 = i;
        }
        if (i2 > 0 && i2 < screenSize.height) {
            this.f33353I0Io = i2;
        }
        OIOoIIOIx();
    }

    public void XIXIxO() {
        String str = this.f33362Oxx0IOOO;
        if (str != null && str.length() != 0) {
            this.f33375oxoX.oxoX().Oo(IIX0o(str));
        }
    }

    public void XIo0oOXIx() {
        OO0x0xX(this.f33375oxoX.f33403II0xO0);
    }

    public JCheckBoxMenuItem XIxXXX0x0(LogTableColumn logTableColumn) {
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem(logTableColumn.toString());
        jCheckBoxMenuItem.setSelected(true);
        jCheckBoxMenuItem.setMnemonic(logTableColumn.toString().charAt(0));
        jCheckBoxMenuItem.addActionListener(new Oxx0IOOO(this));
        return jCheckBoxMenuItem;
    }

    public void XO() {
        this.f33375oxoX.f33403II0xO0.setText("");
    }

    public void XOxIOxOx() {
        String str = this.f33368XO;
        if (str != null && str.length() != 0) {
            I0(x0o(I0oOoX(), str, this.f33375oxoX.oxoX().xxIXOIIO()));
        }
    }

    public xXIX0Xo.oIX0oI XX() {
        return this.f33375oxoX.I0Io();
    }

    public JCheckBoxMenuItem XX0(LogLevel logLevel) {
        JCheckBoxMenuItem jCheckBoxMenuItem = (JCheckBoxMenuItem) this.f33364OxxIIOOXO.get(logLevel);
        if (jCheckBoxMenuItem == null) {
            JCheckBoxMenuItem xXxxox0I2 = xXxxox0I(logLevel);
            this.f33364OxxIIOOXO.put(logLevel, xXxxox0I2);
            return xXxxox0I2;
        }
        return jCheckBoxMenuItem;
    }

    public void XX0xXo() {
        JFileChooser jFileChooser;
        if (this.f33367XI0IXoo == null) {
            jFileChooser = new JFileChooser();
        } else {
            jFileChooser = new JFileChooser(this.f33367XI0IXoo);
        }
        if (jFileChooser.showOpenDialog(this.f33371oIX0oI) == 0) {
            File selectedFile = jFileChooser.getSelectedFile();
            if (xoxXI(selectedFile)) {
                this.f33367XI0IXoo = jFileChooser.getSelectedFile();
                this.f33365X0IIOO.OOXIXo(selectedFile);
                x0OIX00oO();
            }
        }
    }

    public void XXoOx0() {
        this.f33378xoIox.setText(oX());
    }

    public String Xo0(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Displaying: ");
        stringBuffer.append(i);
        stringBuffer.append(" records out of a total of: ");
        stringBuffer.append(i2);
        stringBuffer.append(" records.");
        return stringBuffer.toString();
    }

    public JCheckBoxMenuItem XoI0Ixx0(LogTableColumn logTableColumn) {
        return oxXx0IX(logTableColumn);
    }

    public Iterator XoX() {
        return this.f33379xoXoI.iterator();
    }

    public JMenuItem Xx000oIo(LogLevel logLevel) {
        JMenuItem jMenuItem = new JMenuItem(logLevel.toString());
        jMenuItem.setMnemonic(logLevel.toString().charAt(0));
        jMenuItem.addActionListener(new X0o0xo(this, jMenuItem, logLevel));
        return jMenuItem;
    }

    public JMenuBar XxX0x0xxx() {
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(IIXOooo());
        jMenuBar.add(IXxxXO());
        jMenuBar.add(X0IIOO());
        jMenuBar.add(IO());
        jMenuBar.add(oOoXoXO());
        jMenuBar.add(xoXoI());
        return jMenuBar;
    }

    public Oxxo.Oxx0IOOO o0() {
        return this.f33366X0o0xo;
    }

    public JMenuItem o00() {
        JMenuItem jMenuItem = new JMenuItem("LogFactor5 Properties");
        jMenuItem.setMnemonic('l');
        jMenuItem.addActionListener(new oI0IIXIo(this));
        return jMenuItem;
    }

    public void o0oIxOo(String str) {
        JOptionPane.showMessageDialog(this.f33371oIX0oI, this.f33370oI0IIXIo.toArray(), str, -1);
    }

    public void o0xxxXXxX(ActionEvent actionEvent) {
        StringTokenizer stringTokenizer = new StringTokenizer(actionEvent.getActionCommand());
        String trim = stringTokenizer.nextToken().trim();
        String nextToken = stringTokenizer.nextToken("\n");
        try {
            int parseInt = Integer.parseInt(trim) - 1;
            new xXIX0Xo.I0Io(this.f33365X0IIOO.oxoX(parseInt)).Oxx0IOOO(this);
            this.f33365X0IIOO.xxIXOIIO(parseInt);
            x0OIX00oO();
        } catch (Exception unused) {
            JFrame OI02 = OI0();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unable to load file ");
            stringBuffer.append(nextToken);
            new X00IoxXI(OI02, stringBuffer.toString());
        }
    }

    public JMenuItem oI0IIXIo() {
        JMenuItem jMenuItem = new JMenuItem("Sort by NDC");
        jMenuItem.setMnemonic('s');
        jMenuItem.addActionListener(new xoXoI(this));
        return jMenuItem;
    }

    public void oIX0oI(Object obj) {
        this.f33370oI0IIXIo.add(obj);
    }

    public JTextArea oO() {
        JTextArea jTextArea = new JTextArea();
        jTextArea.setFont(new Font("Monospaced", 0, 14));
        jTextArea.setTabSize(3);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(false);
        return jTextArea;
    }

    public JPanel oOXoIIIo() {
        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel("No log records to display.");
        this.f33378xoIox = jLabel;
        jLabel.setHorizontalAlignment(2);
        jPanel.setBorder(BorderFactory.createEtchedBorder());
        jPanel.setLayout(new FlowLayout(0, 0, 0));
        jPanel.add(jLabel);
        return jPanel;
    }

    public void oOo(int i) {
        this.f33375oxoX.oxoX().IXxxXO(i);
    }

    public JMenu oOoXoXO() {
        JMenu jMenu = new JMenu("Configure");
        jMenu.setMnemonic('c');
        jMenu.add(x0XOIxOo());
        jMenu.add(ooOOo0oXI());
        jMenu.add(OOXIXo());
        return jMenu;
    }

    public String oX() {
        org.apache.log4j.lf5.viewer.oIX0oI oxoX2 = this.f33375oxoX.oxoX();
        return Xo0(oxoX2.OOXIXo(), oxoX2.oOoXoXO());
    }

    public void oXIO0o0XI(LogLevel logLevel) {
        if (logLevel != null && this.f33354II0XooXoX != logLevel) {
            this.f33354II0XooXoX = logLevel;
            this.f33375oxoX.oxoX().x0xO0oo();
            XXoOx0();
        }
    }

    public JMenuItem oo() {
        JMenuItem jMenuItem = new JMenuItem("Open URL...");
        jMenuItem.setMnemonic('u');
        jMenuItem.addActionListener(new OOXIXo(this));
        return jMenuItem;
    }

    public JMenuItem oo0xXOI0I() {
        JMenuItem jMenuItem = new JMenuItem("Open...");
        jMenuItem.setMnemonic('o');
        jMenuItem.addActionListener(new xoIox(this));
        return jMenuItem;
    }

    public JMenuItem ooOOo0oXI() {
        JMenuItem jMenuItem = new JMenuItem("Reset");
        jMenuItem.setMnemonic('r');
        jMenuItem.addActionListener(new IXxxXO(this));
        return jMenuItem;
    }

    public void ooOx(boolean z) {
        this.f33363Oxx0xo = z;
    }

    public JMenuItem ooXIXxIX() {
        JMenuItem jMenuItem = new JMenuItem("Hide all LogLevels");
        jMenuItem.setMnemonic('h');
        jMenuItem.addActionListener(new oo0xXOI0I(this));
        return jMenuItem;
    }

    public void ox() {
        this.f33358O0xOxO.xoXoI();
    }

    public void oxIIX0o(JMenuItem jMenuItem, LogLevel logLevel) {
        Color showDialog = JColorChooser.showDialog(this.f33371oIX0oI, "Choose LogLevel Color", jMenuItem.getForeground());
        if (showDialog != null) {
            logLevel.setLogLevelColorMap(logLevel, showDialog);
            this.f33375oxoX.oxoX().x0xO0oo();
        }
    }

    public JCheckBoxMenuItem oxXx0IX(LogTableColumn logTableColumn) {
        JCheckBoxMenuItem jCheckBoxMenuItem = (JCheckBoxMenuItem) this.f33356IIXOooo.get(logTableColumn);
        if (jCheckBoxMenuItem == null) {
            JCheckBoxMenuItem XIxXXX0x02 = XIxXXX0x0(logTableColumn);
            this.f33356IIXOooo.put(logTableColumn, XIxXXX0x02);
            return XIxXXX0x02;
        }
        return jCheckBoxMenuItem;
    }

    public void oxoX(JFrame jFrame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = jFrame.getSize();
        jFrame.setLocation((screenSize.width - size.width) / 2, (screenSize.height - size.height) / 2);
    }

    public Map oxxXoxO() {
        return this.f33364OxxIIOOXO;
    }

    public void x0OIX00oO() {
        JMenu menu = this.f33371oIX0oI.getJMenuBar().getMenu(0);
        menu.removeAll();
        menu.add(oo0xXOI0I());
        menu.add(oo());
        menu.addSeparator();
        menu.add(xoIox());
        xxX(menu);
        menu.addSeparator();
        menu.add(OxxIIOOXO());
    }

    public JMenuItem x0XOIxOo() {
        JMenuItem jMenuItem = new JMenuItem("Save");
        jMenuItem.setMnemonic('s');
        jMenuItem.addActionListener(new x0xO0oo(this));
        return jMenuItem;
    }

    public int x0o(int i, String str, List list) {
        int i2;
        if (i < 0) {
            i2 = 0;
        } else {
            i2 = i + 1;
        }
        int size = list.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (xoIxX((LogRecord) list.get(i3), str)) {
                return i3;
            }
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (xoIxX((LogRecord) list.get(i4), str)) {
                return i4;
            }
        }
        return -1;
    }

    public void x0xO(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException unused) {
        }
    }

    public JMenuItem x0xO0oo() {
        JMenuItem jMenuItem = new JMenuItem("Find");
        jMenuItem.setMnemonic('f');
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke("control F"));
        jMenuItem.addActionListener(new IIXOooo(this));
        return jMenuItem;
    }

    public JMenuItem xI() {
        JMenuItem jMenuItem = new JMenuItem("Hide all Columns");
        jMenuItem.setMnemonic('h');
        jMenuItem.addActionListener(new xxIXOIIO(this));
        return jMenuItem;
    }

    public void xI0oxI00() {
        IoIOOxIIo(0);
    }

    public void xII() {
        this.f33371oIX0oI.dispose();
        this.f33361OxI = true;
        if (this.f33363Oxx0xo) {
            System.exit(0);
        }
    }

    public void xOOOX(int i) {
        this.f33374ooOOo0oXI = i;
        xX0IIXIx0(this.f33375oxoX.f33403II0xO0, i);
        I0(0);
        xX0IIXIx0(this.f33375oxoX, i);
    }

    public void xOoOIoI(String str) {
        if (str == null) {
            this.f33362Oxx0IOOO = "";
        } else {
            this.f33362Oxx0IOOO = str;
        }
    }

    public void xX0IIXIx0(Component component, int i) {
        Font font = component.getFont();
        component.setFont(new Font(font.getFontName(), font.getStyle(), i));
    }

    public Iterator xXOx() {
        return this.f33369o00.iterator();
    }

    public JCheckBoxMenuItem xXxxox0I(LogLevel logLevel) {
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem(logLevel.toString());
        jCheckBoxMenuItem.setSelected(true);
        jCheckBoxMenuItem.setMnemonic(logLevel.toString().charAt(0));
        jCheckBoxMenuItem.addActionListener(new XO(this));
        return jCheckBoxMenuItem;
    }

    public Map xo0x() {
        return this.f33356IIXOooo;
    }

    public JMenuItem xoIox() {
        JMenuItem jMenuItem = new JMenuItem(HTTP.CONN_CLOSE);
        jMenuItem.setMnemonic('c');
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke("control Q"));
        jMenuItem.addActionListener(new oOoXoXO(this));
        return jMenuItem;
    }

    public boolean xoIxX(LogRecord logRecord, String str) {
        String message = logRecord.getMessage();
        String ndc = logRecord.getNDC();
        if ((message == null && ndc == null) || str == null) {
            return false;
        }
        if (message.toLowerCase().indexOf(str.toLowerCase()) == -1 && ndc.toLowerCase().indexOf(str.toLowerCase()) == -1) {
            return false;
        }
        return true;
    }

    public void xoO0xx0(xXIX0Xo.oIX0oI oix0oi) {
        this.f33375oxoX.XO(oix0oi);
    }

    public JMenu xoXoI() {
        JMenu jMenu = new JMenu("Help");
        jMenu.setMnemonic('h');
        jMenu.add(o00());
        return jMenu;
    }

    public boolean xoxXI(File file) {
        try {
            new xXIX0Xo.I0Io(file).Oxx0IOOO(this);
            return true;
        } catch (IOException unused) {
            JFrame OI02 = OI0();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Error reading ");
            stringBuffer.append(file.getName());
            new X00IoxXI(OI02, stringBuffer.toString());
            return false;
        }
    }

    public void xx0X0(String str, o0 o0Var) {
        if (f33352XIxXXX0x0.equals(str)) {
            o0Var.Oxx0IOOO();
            this.f33372oO = str;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append("does not match a supported view.");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public void xxIO() {
        this.f33365X0IIOO.xoIox();
        ooOx(true);
        Oxx0IOOO();
    }

    public JMenuItem xxIXOIIO() {
        JMenuItem jMenuItem = new JMenuItem("Show all Columns");
        jMenuItem.setMnemonic('s');
        jMenuItem.addActionListener(new II0XooXoX(this));
        return jMenuItem;
    }

    public void xxX(JMenu jMenu) {
        String[] Oxx0IOOO2 = this.f33365X0IIOO.Oxx0IOOO();
        if (Oxx0IOOO2 != null) {
            jMenu.addSeparator();
            int i = 0;
            while (i < Oxx0IOOO2.length) {
                StringBuffer stringBuffer = new StringBuffer();
                int i2 = i + 1;
                stringBuffer.append(i2);
                stringBuffer.append(" ");
                stringBuffer.append(Oxx0IOOO2[i]);
                JMenuItem jMenuItem = new JMenuItem(stringBuffer.toString());
                jMenuItem.setMnemonic(i2);
                jMenuItem.addActionListener(new ooOOo0oXI(this));
                jMenu.add(jMenuItem);
                i = i2;
            }
        }
    }
}
