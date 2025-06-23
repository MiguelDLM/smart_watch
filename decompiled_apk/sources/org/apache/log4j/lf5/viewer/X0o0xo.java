package org.apache.log4j.lf5.viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import org.apache.log4j.lf5.LogLevel;

/* loaded from: classes6.dex */
public class X0o0xo implements ActionListener {

    /* renamed from: I0Io, reason: collision with root package name */
    public final /* synthetic */ IoOoX f33391I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ LogLevel f33392II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ JMenuItem f33393oIX0oI;

    public X0o0xo(IoOoX ioOoX, JMenuItem jMenuItem, LogLevel logLevel) {
        this.f33391I0Io = ioOoX;
        this.f33393oIX0oI = jMenuItem;
        this.f33392II0xO0 = logLevel;
    }

    public void oIX0oI(ActionEvent actionEvent) {
        this.f33391I0Io.oxIIX0o(this.f33393oIX0oI, this.f33392II0xO0);
    }
}
