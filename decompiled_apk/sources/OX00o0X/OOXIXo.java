package OX00o0X;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/* loaded from: classes6.dex */
public class OOXIXo extends AbstractAction {

    /* renamed from: I0Io, reason: collision with root package name */
    public static /* synthetic */ Class f1922I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final OOXIXo f1923II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final org.apache.log4j.x0xO0oo f1924oIX0oI;

    static {
        Class cls = f1922I0Io;
        if (cls == null) {
            cls = II0xO0("org.apache.log4j.chainsaw.ExitAction");
            f1922I0Io = cls;
        }
        f1924oIX0oI = org.apache.log4j.x0xO0oo.xo0x(cls);
        f1923II0xO0 = new OOXIXo();
    }

    public static /* synthetic */ Class II0xO0(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public void oIX0oI(ActionEvent actionEvent) {
        f1924oIX0oI.oo0xXOI0I("shutting down");
        System.exit(0);
    }
}
