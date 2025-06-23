package Oxxo;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;
import javax.swing.table.TableCellEditor;
import javax.swing.tree.TreeCellEditor;

/* loaded from: classes6.dex */
public class oIX0oI implements TableCellEditor, TreeCellEditor {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static /* synthetic */ Class f3146X0o0xo;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Object f3148II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public EventListenerList f3149oIX0oI = new EventListenerList();

    /* renamed from: I0Io, reason: collision with root package name */
    public ChangeEvent f3147I0Io = null;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f3150oxoX = 1;

    public static /* synthetic */ Class I0Io(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public Component II0XooXoX(JTable jTable, Object obj, boolean z, int i, int i2) {
        return null;
    }

    public void II0xO0() {
        oxoX();
    }

    public void OOXIXo(CellEditorListener cellEditorListener) {
        EventListenerList eventListenerList = this.f3149oIX0oI;
        Class cls = f3146X0o0xo;
        if (cls == null) {
            cls = I0Io("javax.swing.event.CellEditorListener");
            f3146X0o0xo = cls;
        }
        eventListenerList.remove(cls, cellEditorListener);
    }

    public int Oxx0IOOO() {
        return this.f3150oxoX;
    }

    public void X0o0xo() {
        Object[] listenerList = this.f3149oIX0oI.getListenerList();
        for (int length = listenerList.length - 2; length >= 0; length -= 2) {
            Object obj = listenerList[length];
            Class cls = f3146X0o0xo;
            if (cls == null) {
                cls = I0Io("javax.swing.event.CellEditorListener");
                f3146X0o0xo = cls;
            }
            if (obj == cls) {
                if (this.f3147I0Io == null) {
                    this.f3147I0Io = new ChangeEvent(this);
                }
                ((CellEditorListener) listenerList[length + 1]).editingStopped(this.f3147I0Io);
            }
        }
    }

    public Object XO() {
        return this.f3148II0xO0;
    }

    public void oIX0oI(CellEditorListener cellEditorListener) {
        EventListenerList eventListenerList = this.f3149oIX0oI;
        Class cls = f3146X0o0xo;
        if (cls == null) {
            cls = I0Io("javax.swing.event.CellEditorListener");
            f3146X0o0xo = cls;
        }
        eventListenerList.add(cls, cellEditorListener);
    }

    public boolean oO() {
        X0o0xo();
        return true;
    }

    public void oOoXoXO(Object obj) {
        this.f3148II0xO0 = obj;
    }

    public void ooOOo0oXI(int i) {
        this.f3150oxoX = i;
    }

    public void oxoX() {
        Object[] listenerList = this.f3149oIX0oI.getListenerList();
        for (int length = listenerList.length - 2; length >= 0; length -= 2) {
            Object obj = listenerList[length];
            Class cls = f3146X0o0xo;
            if (cls == null) {
                cls = I0Io("javax.swing.event.CellEditorListener");
                f3146X0o0xo = cls;
            }
            if (obj == cls) {
                if (this.f3147I0Io == null) {
                    this.f3147I0Io = new ChangeEvent(this);
                }
                ((CellEditorListener) listenerList[length + 1]).editingCanceled(this.f3147I0Io);
            }
        }
    }

    public boolean x0XOIxOo(EventObject eventObject) {
        if (xoIox(eventObject)) {
            if (eventObject == null || ((MouseEvent) eventObject).getClickCount() >= this.f3150oxoX) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean xoIox(EventObject eventObject) {
        return true;
    }

    public Component xxIXOIIO(JTree jTree, Object obj, boolean z, boolean z2, boolean z3, int i) {
        return null;
    }
}
