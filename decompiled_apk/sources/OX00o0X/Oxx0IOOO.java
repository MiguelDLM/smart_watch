package OX00o0X;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/* loaded from: classes6.dex */
public class Oxx0IOOO implements ActionListener {

    /* renamed from: I0Io, reason: collision with root package name */
    public final /* synthetic */ II0XooXoX f1925I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ JButton f1926II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ IXxxXO f1927oIX0oI;

    public Oxx0IOOO(II0XooXoX iI0XooXoX, IXxxXO iXxxXO, JButton jButton) {
        this.f1925I0Io = iI0XooXoX;
        this.f1927oIX0oI = iXxxXO;
        this.f1926II0xO0 = jButton;
    }

    public void oIX0oI(ActionEvent actionEvent) {
        String str;
        this.f1927oIX0oI.xoXoI();
        JButton jButton = this.f1926II0xO0;
        if (this.f1927oIX0oI.x0xO0oo()) {
            str = "Resume";
        } else {
            str = "Pause";
        }
        jButton.setText(str);
    }
}
