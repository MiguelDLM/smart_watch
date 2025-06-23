package org.apache.log4j.lf5.viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/* loaded from: classes6.dex */
public class IIXOooo implements ActionListener {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ IoOoX f33349oIX0oI;

    public IIXOooo(IoOoX ioOoX) {
        this.f33349oIX0oI = ioOoX;
    }

    public void oIX0oI(ActionEvent actionEvent) {
        this.f33349oIX0oI.Ox0O(JOptionPane.showInputDialog(this.f33349oIX0oI.f33371oIX0oI, "Find text: ", "Search Record Messages", 3));
        this.f33349oIX0oI.XOxIOxOx();
    }
}
