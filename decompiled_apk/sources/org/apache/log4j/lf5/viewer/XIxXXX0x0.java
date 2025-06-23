package org.apache.log4j.lf5.viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import org.apache.log4j.lf5.LogLevel;

/* loaded from: classes6.dex */
public class XIxXXX0x0 implements ActionListener {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ IoOoX f33395oIX0oI;

    public XIxXXX0x0(IoOoX ioOoX) {
        this.f33395oIX0oI = ioOoX;
    }

    public void oIX0oI(ActionEvent actionEvent) {
        this.f33395oIX0oI.oXIO0o0XI((LogLevel) ((JComboBox) actionEvent.getSource()).getSelectedItem());
    }
}
