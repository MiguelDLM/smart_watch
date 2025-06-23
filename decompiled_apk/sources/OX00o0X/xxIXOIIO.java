package OX00o0X;

import fi.iki.elonen.NanoHTTPD;
import java.awt.BorderLayout;
import java.text.MessageFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/* loaded from: classes6.dex */
public class xxIXOIIO extends JPanel implements ListSelectionListener {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final org.apache.log4j.x0xO0oo f1980I0Io;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static /* synthetic */ Class f1981X0o0xo;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final MessageFormat f1982oxoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final JEditorPane f1983II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final IXxxXO f1984oIX0oI;

    static {
        Class cls = f1981X0o0xo;
        if (cls == null) {
            cls = oIX0oI("org.apache.log4j.chainsaw.DetailPanel");
            f1981X0o0xo = cls;
        }
        f1980I0Io = org.apache.log4j.x0xO0oo.xo0x(cls);
        f1982oxoX = new MessageFormat("<b>Time:</b> <code>{0,time,medium}</code>&nbsp;&nbsp;<b>Priority:</b> <code>{1}</code>&nbsp;&nbsp;<b>Thread:</b> <code>{2}</code>&nbsp;&nbsp;<b>NDC:</b> <code>{3}</code><br><b>Logger:</b> <code>{4}</code><br><b>Location:</b> <code>{5}</code><br><b>Message:</b><pre>{6}</pre><b>Throwable:</b><pre>{7}</pre>");
    }

    public xxIXOIIO(JTable jTable, IXxxXO iXxxXO) {
        this.f1984oIX0oI = iXxxXO;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Details: "));
        JEditorPane jEditorPane = new JEditorPane();
        this.f1983II0xO0 = jEditorPane;
        jEditorPane.setEditable(false);
        jEditorPane.setContentType(NanoHTTPD.MIME_HTML);
        add(new JScrollPane(jEditorPane), "Center");
        jTable.getSelectionModel().addListSelectionListener(this);
    }

    public static String I0Io(xoIox xoiox) {
        String[] Oxx0IOOO2 = xoiox.Oxx0IOOO();
        if (Oxx0IOOO2 == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : Oxx0IOOO2) {
            stringBuffer.append(str);
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public static /* synthetic */ Class oIX0oI(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public final String II0xO0(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '\"') {
                if (charAt != '&') {
                    if (charAt != '<') {
                        if (charAt != '>') {
                            stringBuffer.append(charAt);
                        } else {
                            stringBuffer.append("&gt;");
                        }
                    } else {
                        stringBuffer.append("&lt;");
                    }
                } else {
                    stringBuffer.append("&amp;");
                }
            } else {
                stringBuffer.append("&quot;");
            }
        }
        return stringBuffer.toString();
    }

    public void oxoX(ListSelectionEvent listSelectionEvent) {
        if (listSelectionEvent.getValueIsAdjusting()) {
            return;
        }
        ListSelectionModel listSelectionModel = (ListSelectionModel) listSelectionEvent.getSource();
        if (listSelectionModel.isSelectionEmpty()) {
            this.f1983II0xO0.setText("Nothing selected");
            return;
        }
        xoIox ooOOo0oXI2 = this.f1984oIX0oI.ooOOo0oXI(listSelectionModel.getMinSelectionIndex());
        this.f1983II0xO0.setText(f1982oxoX.format(new Object[]{new Date(ooOOo0oXI2.II0XooXoX()), ooOOo0oXI2.X0o0xo(), II0xO0(ooOOo0oXI2.XO()), II0xO0(ooOOo0oXI2.oxoX()), II0xO0(ooOOo0oXI2.oIX0oI()), II0xO0(ooOOo0oXI2.II0xO0()), II0xO0(ooOOo0oXI2.I0Io()), II0xO0(I0Io(ooOOo0oXI2))}));
        this.f1983II0xO0.setCaretPosition(0);
    }
}
