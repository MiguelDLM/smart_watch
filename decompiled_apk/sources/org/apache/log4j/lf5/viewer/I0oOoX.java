package org.apache.log4j.lf5.viewer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.apache.log4j.lf5.LogLevel;

/* loaded from: classes6.dex */
public class I0oOoX extends DefaultTableCellRenderer {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f33344oIX0oI = true;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Color f33343II0xO0 = new Color(230, 230, 230);

    public Component II0xO0(JTable jTable, Object obj, boolean z, boolean z2, int i, int i2) {
        if (i % 2 == 0) {
            setBackground(this.f33343II0xO0);
        } else {
            setBackground(Color.white);
        }
        setForeground(oIX0oI(jTable.getModel().II0XooXoX(i).getLevel()));
        return super.getTableCellRendererComponent(jTable, obj, z, z2, i, i2);
    }

    public Color oIX0oI(LogLevel logLevel) {
        return (Color) LogLevel.getLogLevelColorMap().get(logLevel);
    }
}
