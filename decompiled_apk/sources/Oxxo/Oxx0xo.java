package Oxxo;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

/* loaded from: classes6.dex */
public class Oxx0xo extends oIX0oI {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public JCheckBox f3133II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public xxIXOIIO f3134Oxx0IOOO;

    /* renamed from: XO, reason: collision with root package name */
    public oI0IIXIo f3135XO;

    /* renamed from: xoIox, reason: collision with root package name */
    public JTree f3136xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public X0o0xo f3137xxIXOIIO;

    public Oxx0xo(X0o0xo x0o0xo) {
        oI0IIXIo oi0iixio = new oI0IIXIo();
        this.f3135XO = oi0iixio;
        JCheckBox oxoX2 = oi0iixio.oxoX();
        this.f3133II0XooXoX = oxoX2;
        this.f3137xxIXOIIO = x0o0xo;
        oxoX2.addActionListener(new xoIox(this));
        this.f3135XO.addMouseListener(new OOXIXo(this));
    }

    public JMenuItem IIXOooo(xxIXOIIO xxixoiio) {
        JMenuItem jMenuItem = new JMenuItem("Select All Descendant Categories");
        jMenuItem.addActionListener(new ooOOo0oXI(this, xxixoiio));
        return jMenuItem;
    }

    public JMenuItem IXxxXO(xxIXOIIO xxixoiio) {
        JMenuItem jMenuItem = new JMenuItem("Collapse All Descendant Categories");
        jMenuItem.addActionListener(new x0xO0oo(this, xxixoiio));
        return jMenuItem;
    }

    public Object O0xOxO(xxIXOIIO xxixoiio) {
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Category: ");
        stringBuffer.append(xxixoiio.Oxx0IOOO());
        arrayList.add(stringBuffer.toString());
        if (xxixoiio.xoIox()) {
            arrayList.add("Contains at least one fatal LogRecord.");
        }
        if (xxixoiio.xxIXOIIO()) {
            arrayList.add("Contains descendants with a fatal LogRecord.");
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("LogRecords in this category alone: ");
        stringBuffer2.append(xxixoiio.X0o0xo());
        arrayList.add(stringBuffer2.toString());
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("LogRecords in descendant categories: ");
        stringBuffer3.append(xxixoiio.XO());
        arrayList.add(stringBuffer3.toString());
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append("LogRecords in this category including descendants: ");
        stringBuffer4.append(xxixoiio.II0XooXoX());
        arrayList.add(stringBuffer4.toString());
        return arrayList.toArray();
    }

    public void Oo(xxIXOIIO xxixoiio) {
        Enumeration depthFirstEnumeration = xxixoiio.depthFirstEnumeration();
        while (depthFirstEnumeration.hasMoreElements()) {
            x0xO0oo((xxIXOIIO) depthFirstEnumeration.nextElement());
        }
    }

    public void OxI(xxIXOIIO xxixoiio) {
        Enumeration depthFirstEnumeration = xxixoiio.depthFirstEnumeration();
        while (depthFirstEnumeration.hasMoreElements()) {
            o00((xxIXOIIO) depthFirstEnumeration.nextElement());
        }
    }

    public JMenuItem Oxx0xo(xxIXOIIO xxixoiio) {
        JMenuItem jMenuItem = new JMenuItem("Expand All Descendant Categories");
        jMenuItem.addActionListener(new oO(this, xxixoiio));
        return jMenuItem;
    }

    public JMenuItem OxxIIOOXO() {
        JMenuItem jMenuItem = new JMenuItem("Remove All Empty Categories");
        jMenuItem.addActionListener(new IXxxXO(this));
        return jMenuItem;
    }

    public TreePath X0IIOO(xxIXOIIO xxixoiio) {
        return new TreePath(xxixoiio.getPath());
    }

    public int XI0IXoo() {
        Enumeration depthFirstEnumeration = this.f3137xxIXOIIO.XO().depthFirstEnumeration();
        int i = 0;
        while (depthFirstEnumeration.hasMoreElements()) {
            xxIXOIIO xxixoiio = (xxIXOIIO) depthFirstEnumeration.nextElement();
            if (xxixoiio.isLeaf() && xxixoiio.X0o0xo() == 0 && xxixoiio.getParent() != null) {
                this.f3137xxIXOIIO.removeNodeFromParent(xxixoiio);
                i++;
            }
        }
        return i;
    }

    public void XIxXXX0x0(xxIXOIIO xxixoiio, int i, int i2) {
        JPopupMenu jPopupMenu = new JPopupMenu();
        jPopupMenu.setSize(150, 400);
        if (xxixoiio.getParent() == null) {
            jPopupMenu.add(OxxIIOOXO());
            jPopupMenu.addSeparator();
        }
        jPopupMenu.add(IIXOooo(xxixoiio));
        jPopupMenu.add(xoXoI(xxixoiio));
        jPopupMenu.addSeparator();
        jPopupMenu.add(Oxx0xo(xxixoiio));
        jPopupMenu.add(IXxxXO(xxixoiio));
        jPopupMenu.addSeparator();
        jPopupMenu.add(oI0IIXIo(xxixoiio));
        jPopupMenu.show(this.f3135XO, i, i2);
    }

    @Override // Oxxo.oIX0oI
    public Object XO() {
        return this.f3134Oxx0IOOO.getUserObject();
    }

    public void o00(xxIXOIIO xxixoiio) {
        this.f3136xoIox.expandPath(X0IIOO(xxixoiio));
    }

    public JMenuItem oI0IIXIo(xxIXOIIO xxixoiio) {
        JMenuItem jMenuItem = new JMenuItem("Properties");
        jMenuItem.addActionListener(new oOoXoXO(this, xxixoiio));
        return jMenuItem;
    }

    public void x0xO0oo(xxIXOIIO xxixoiio) {
        this.f3136xoIox.collapsePath(X0IIOO(xxixoiio));
    }

    public JMenuItem xoXoI(xxIXOIIO xxixoiio) {
        JMenuItem jMenuItem = new JMenuItem("Deselect All Descendant Categories");
        jMenuItem.addActionListener(new x0XOIxOo(this, xxixoiio));
        return jMenuItem;
    }

    @Override // Oxxo.oIX0oI
    public Component xxIXOIIO(JTree jTree, Object obj, boolean z, boolean z2, boolean z3, int i) {
        this.f3134Oxx0IOOO = (xxIXOIIO) obj;
        this.f3136xoIox = jTree;
        return this.f3135XO.I0Io(jTree, obj, z, z2, z3, i, true);
    }

    public void xxX(xxIXOIIO xxixoiio) {
        JTree jTree = this.f3136xoIox;
        Object O0xOxO2 = O0xOxO(xxixoiio);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Category Properties: ");
        stringBuffer.append(xxixoiio.Oxx0IOOO());
        JOptionPane.showMessageDialog(jTree, O0xOxO2, stringBuffer.toString(), -1);
    }
}
