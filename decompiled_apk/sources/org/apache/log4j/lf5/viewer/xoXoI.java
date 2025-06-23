package org.apache.log4j.lf5.viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/* loaded from: classes6.dex */
public class xoXoI implements ActionListener {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ IoOoX f33442oIX0oI;

    public xoXoI(IoOoX ioOoX) {
        this.f33442oIX0oI = ioOoX;
    }

    public void oIX0oI(ActionEvent actionEvent) {
        this.f33442oIX0oI.xOoOIoI(JOptionPane.showInputDialog(this.f33442oIX0oI.f33371oIX0oI, "Sort by this NDC: ", "Sort Log Records by NDC", 3));
        this.f33442oIX0oI.XIXIxO();
        this.f33442oIX0oI.f33375oxoX.oxoX().x0xO0oo();
        this.f33442oIX0oI.XXoOx0();
    }
}
