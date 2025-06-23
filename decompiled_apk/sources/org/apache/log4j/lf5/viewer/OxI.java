package org.apache.log4j.lf5.viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.log4j.lf5.LogRecord;

/* loaded from: classes6.dex */
public class OxI implements ActionListener {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ IoOoX f33386oIX0oI;

    public OxI(IoOoX ioOoX) {
        this.f33386oIX0oI = ioOoX;
    }

    public void oIX0oI(ActionEvent actionEvent) {
        this.f33386oIX0oI.f33375oxoX.oIX0oI();
        this.f33386oIX0oI.f33366X0o0xo.I0Io().oOoXoXO();
        this.f33386oIX0oI.XXoOx0();
        this.f33386oIX0oI.XO();
        LogRecord.resetSequenceNumber();
    }
}
