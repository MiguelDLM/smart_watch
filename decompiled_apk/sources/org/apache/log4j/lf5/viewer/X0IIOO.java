package org.apache.log4j.lf5.viewer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/* loaded from: classes6.dex */
public class X0IIOO implements ActionListener {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ IoOoX f33390oIX0oI;

    public X0IIOO(IoOoX ioOoX) {
        this.f33390oIX0oI = ioOoX;
    }

    public void oIX0oI(ActionEvent actionEvent) {
        String str = (String) ((JComboBox) actionEvent.getSource()).getSelectedItem();
        this.f33390oIX0oI.f33375oxoX.II0XooXoX(new Font(str, 0, this.f33390oIX0oI.f33374ooOOo0oXI));
        this.f33390oIX0oI.f33376x0XOIxOo = str;
    }
}
