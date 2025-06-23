package OX00o0X;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import org.apache.log4j.OxxIIOOXO;

/* loaded from: classes6.dex */
public class oIX0oI implements ActionListener {

    /* renamed from: I0Io, reason: collision with root package name */
    public final /* synthetic */ II0XooXoX f1949I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ JComboBox f1950II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ IXxxXO f1951oIX0oI;

    public oIX0oI(II0XooXoX iI0XooXoX, IXxxXO iXxxXO, JComboBox jComboBox) {
        this.f1949I0Io = iI0XooXoX;
        this.f1951oIX0oI = iXxxXO;
        this.f1950II0xO0 = jComboBox;
    }

    public void oIX0oI(ActionEvent actionEvent) {
        this.f1951oIX0oI.OxxIIOOXO((OxxIIOOXO) this.f1950II0xO0.getSelectedItem());
    }
}
