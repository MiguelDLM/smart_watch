package org.apache.log4j.lf5.viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/* loaded from: classes6.dex */
public class XI0IXoo implements ActionListener {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ IoOoX f33394oIX0oI;

    public XI0IXoo(IoOoX ioOoX) {
        this.f33394oIX0oI = ioOoX;
    }

    public void oIX0oI(ActionEvent actionEvent) {
        int intValue = Integer.valueOf((String) ((JComboBox) actionEvent.getSource()).getSelectedItem()).intValue();
        this.f33394oIX0oI.xOOOX(intValue);
        this.f33394oIX0oI.XIo0oOXIx();
        this.f33394oIX0oI.f33374ooOOo0oXI = intValue;
    }
}
