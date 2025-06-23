package Oxxo;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.TreePath;

/* loaded from: classes6.dex */
public class II0XooXoX extends DefaultTreeCellEditor {

    /* renamed from: II0xO0, reason: collision with root package name */
    public Icon f3125II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public OxxIIOOXO f3126oIX0oI;

    public II0XooXoX(JTree jTree, OxxIIOOXO oxxIIOOXO, Oxx0xo oxx0xo) {
        super(jTree, oxxIIOOXO, oxx0xo);
        this.f3125II0xO0 = null;
        this.f3126oIX0oI = oxxIIOOXO;
        oxxIIOOXO.setIcon((Icon) null);
        oxxIIOOXO.setLeafIcon((Icon) null);
        oxxIIOOXO.setOpenIcon((Icon) null);
        oxxIIOOXO.setClosedIcon((Icon) null);
        ((DefaultTreeCellEditor) this).editingIcon = null;
    }

    public boolean I0Io(MouseEvent mouseEvent) {
        TreePath pathForLocation = ((DefaultTreeCellEditor) this).tree.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
        if (pathForLocation == null) {
            return false;
        }
        Rectangle rowBounds = ((DefaultTreeCellEditor) this).tree.getRowBounds(((DefaultTreeCellEditor) this).lastRow);
        Dimension II0xO02 = this.f3126oIX0oI.II0xO0();
        rowBounds.translate(((DefaultTreeCellEditor) this).offset + II0xO02.width, II0xO02.height);
        rowBounds.contains(mouseEvent.getPoint());
        return true;
    }

    public void II0xO0(JTree jTree, Object obj, boolean z, boolean z2, boolean z3, int i) {
        ((DefaultTreeCellEditor) this).offset = 0;
    }

    public boolean oIX0oI(EventObject eventObject) {
        return false;
    }

    public boolean oxoX(EventObject eventObject) {
        return false;
    }
}
