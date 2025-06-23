package Oxxo;

import java.awt.event.MouseEvent;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

/* loaded from: classes6.dex */
public class Oxx0IOOO extends JTree {

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f3131II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public X0o0xo f3132oIX0oI;

    public Oxx0IOOO(X0o0xo x0o0xo) {
        super(x0o0xo);
        this.f3131II0xO0 = false;
        this.f3132oIX0oI = x0o0xo;
        X0o0xo();
    }

    public X0o0xo I0Io() {
        return this.f3132oIX0oI;
    }

    public void II0xO0() {
        if (this.f3131II0xO0) {
            return;
        }
        this.f3131II0xO0 = true;
        expandPath(new TreePath(this.f3132oIX0oI.XO().getPath()));
    }

    public void X0o0xo() {
        putClientProperty("JTree.lineStyle", "Angled");
        OxxIIOOXO oxxIIOOXO = new OxxIIOOXO();
        setEditable(true);
        setCellRenderer(oxxIIOOXO);
        setCellEditor(new II0XooXoX(this, new OxxIIOOXO(), new Oxx0xo(this.f3132oIX0oI)));
        setShowsRootHandles(true);
        setToolTipText("");
        oIX0oI();
    }

    public void oIX0oI() {
        this.f3132oIX0oI.addTreeModelListener(new XO(this));
    }

    public String oxoX(MouseEvent mouseEvent) {
        try {
            return super.getToolTipText(mouseEvent);
        } catch (Exception unused) {
            return "";
        }
    }

    public Oxx0IOOO() {
        this.f3131II0xO0 = false;
        X0o0xo x0o0xo = new X0o0xo(new xxIXOIIO(XXooOOI.oIX0oI.f4126xxIXOIIO));
        this.f3132oIX0oI = x0o0xo;
        setModel(x0o0xo);
        X0o0xo();
    }
}
