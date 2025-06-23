package Oxxo;

import java.awt.AWTEventMulticaster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import org.apache.log4j.lf5.LogRecord;

/* loaded from: classes6.dex */
public class X0o0xo extends DefaultTreeModel {

    /* renamed from: I0Io, reason: collision with root package name */
    public ActionEvent f3142I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public ActionListener f3143II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f3144oIX0oI;

    public X0o0xo(xxIXOIIO xxixoiio) {
        super(xxixoiio);
        this.f3144oIX0oI = true;
        this.f3143II0xO0 = null;
        this.f3142I0Io = new ActionEvent(this, 1001, "Nodes Selection changed");
    }

    public void I0Io(LogRecord logRecord) {
        IIXOooo iIXOooo = new IIXOooo(logRecord.getCategory());
        II0xO0(iIXOooo);
        xxIXOIIO oxoX2 = oxoX(iIXOooo);
        oxoX2.oIX0oI();
        if (this.f3144oIX0oI && logRecord.isFatal()) {
            xxIXOIIO[] pathToRoot = getPathToRoot(oxoX2);
            int length = pathToRoot.length;
            for (int i = 1; i < length - 1; i++) {
                xxIXOIIO xxixoiio = pathToRoot[i];
                xxixoiio.x0xO0oo(true);
                nodeChanged(xxixoiio);
            }
            oxoX2.Oo(true);
            nodeChanged(oxoX2);
        }
    }

    public boolean II0XooXoX(IIXOooo iIXOooo) {
        boolean z;
        xxIXOIIO xxixoiio = (xxIXOIIO) getRoot();
        boolean z2 = false;
        for (int i = 0; i < iIXOooo.X0o0xo(); i++) {
            II0xO0 II0xO02 = iIXOooo.II0xO0(i);
            Enumeration children = xxixoiio.children();
            while (true) {
                if (!children.hasMoreElements()) {
                    z2 = false;
                    z = false;
                    break;
                }
                xxIXOIIO xxixoiio2 = (xxIXOIIO) children.nextElement();
                if (xxixoiio2.Oxx0IOOO().toLowerCase().equals(II0xO02.oIX0oI().toLowerCase())) {
                    z2 = true;
                    if (xxixoiio2.oOoXoXO()) {
                        xxixoiio = xxixoiio2;
                    } else {
                        xxixoiio = xxixoiio2;
                        z2 = false;
                    }
                    z = true;
                }
            }
            if (!z2 || !z) {
                return false;
            }
        }
        return z2;
    }

    public xxIXOIIO II0xO0(IIXOooo iIXOooo) {
        xxIXOIIO xxixoiio;
        boolean z;
        xxIXOIIO xxixoiio2 = (xxIXOIIO) getRoot();
        for (int i = 0; i < iIXOooo.X0o0xo(); i++) {
            II0xO0 II0xO02 = iIXOooo.II0xO0(i);
            Enumeration children = xxixoiio2.children();
            while (true) {
                if (!children.hasMoreElements()) {
                    xxixoiio = xxixoiio2;
                    z = false;
                    break;
                }
                xxixoiio = (xxIXOIIO) children.nextElement();
                if (xxixoiio.Oxx0IOOO().toLowerCase().equals(II0xO02.oIX0oI().toLowerCase())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                xxixoiio2 = new xxIXOIIO(II0xO02.oIX0oI());
                insertNodeInto(xxixoiio2, xxixoiio, xxixoiio.getChildCount());
                xoIox(xxixoiio2);
            } else {
                xxixoiio2 = xxixoiio;
            }
        }
        return xxixoiio2;
    }

    public synchronized void OOXIXo(ActionListener actionListener) {
        this.f3143II0xO0 = AWTEventMulticaster.remove(this.f3143II0xO0, actionListener);
    }

    public TreePath Oxx0IOOO(xxIXOIIO xxixoiio) {
        if (xxixoiio == null) {
            return null;
        }
        return new TreePath(getPathToRoot(xxixoiio));
    }

    public xxIXOIIO X0o0xo(String str) {
        return oxoX(new IIXOooo(str));
    }

    public xxIXOIIO XO() {
        return (xxIXOIIO) getRoot();
    }

    public synchronized void oIX0oI(ActionListener actionListener) {
        this.f3143II0xO0 = AWTEventMulticaster.add(this.f3143II0xO0, actionListener);
    }

    public void oO(xxIXOIIO xxixoiio, boolean z) {
        if (xxixoiio.oOoXoXO() == z) {
            return;
        }
        if (z) {
            x0XOIxOo(xxixoiio, true);
        } else {
            ooOOo0oXI(xxixoiio, false);
        }
    }

    public void oOoXoXO() {
        Enumeration depthFirstEnumeration = XO().depthFirstEnumeration();
        while (depthFirstEnumeration.hasMoreElements()) {
            xxIXOIIO xxixoiio = (xxIXOIIO) depthFirstEnumeration.nextElement();
            xxixoiio.ooOOo0oXI();
            nodeChanged(xxixoiio);
        }
    }

    public void ooOOo0oXI(xxIXOIIO xxixoiio, boolean z) {
        Enumeration depthFirstEnumeration = xxixoiio.depthFirstEnumeration();
        while (depthFirstEnumeration.hasMoreElements()) {
            xxIXOIIO xxixoiio2 = (xxIXOIIO) depthFirstEnumeration.nextElement();
            if (xxixoiio2.oOoXoXO() != z) {
                xxixoiio2.IXxxXO(z);
                nodeChanged(xxixoiio2);
            }
        }
        xxIXOIIO();
    }

    public xxIXOIIO oxoX(IIXOooo iIXOooo) {
        xxIXOIIO xxixoiio;
        boolean z;
        xxIXOIIO xxixoiio2 = (xxIXOIIO) getRoot();
        int i = 0;
        while (i < iIXOooo.X0o0xo()) {
            II0xO0 II0xO02 = iIXOooo.II0xO0(i);
            Enumeration children = xxixoiio2.children();
            while (true) {
                if (!children.hasMoreElements()) {
                    xxixoiio = xxixoiio2;
                    z = false;
                    break;
                }
                xxixoiio = (xxIXOIIO) children.nextElement();
                if (xxixoiio.Oxx0IOOO().toLowerCase().equals(II0xO02.oIX0oI().toLowerCase())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return null;
            }
            i++;
            xxixoiio2 = xxixoiio;
        }
        return xxixoiio2;
    }

    public void x0XOIxOo(xxIXOIIO xxixoiio, boolean z) {
        xxIXOIIO[] pathToRoot = getPathToRoot(xxixoiio);
        int length = pathToRoot.length;
        for (int i = 1; i < length; i++) {
            xxIXOIIO xxixoiio2 = pathToRoot[i];
            if (xxixoiio2.oOoXoXO() != z) {
                xxixoiio2.IXxxXO(z);
                nodeChanged(xxixoiio2);
            }
        }
        xxIXOIIO();
    }

    public void xoIox(xxIXOIIO xxixoiio) {
        SwingUtilities.invokeLater(new oxoX(this, xxixoiio));
    }

    public void xxIXOIIO() {
        ActionListener actionListener = this.f3143II0xO0;
        if (actionListener != null) {
            actionListener.actionPerformed(this.f3142I0Io);
        }
    }
}
