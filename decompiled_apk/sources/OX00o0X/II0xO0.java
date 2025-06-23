package OX00o0X;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/* loaded from: classes6.dex */
public class II0xO0 implements DocumentListener {

    /* renamed from: I0Io, reason: collision with root package name */
    public final /* synthetic */ II0XooXoX f1900I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ JTextField f1901II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ IXxxXO f1902oIX0oI;

    public II0xO0(II0XooXoX iI0XooXoX, IXxxXO iXxxXO, JTextField jTextField) {
        this.f1900I0Io = iI0XooXoX;
        this.f1902oIX0oI = iXxxXO;
        this.f1901II0xO0 = jTextField;
    }

    public void I0Io(DocumentEvent documentEvent) {
        this.f1902oIX0oI.IIXOooo(this.f1901II0xO0.getText());
    }

    public void II0xO0(DocumentEvent documentEvent) {
        this.f1902oIX0oI.IIXOooo(this.f1901II0xO0.getText());
    }

    public void oIX0oI(DocumentEvent documentEvent) {
        this.f1902oIX0oI.IIXOooo(this.f1901II0xO0.getText());
    }
}
