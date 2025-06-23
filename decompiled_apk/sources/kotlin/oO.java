package kotlin;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

/* loaded from: classes6.dex */
public class oO {
    public static /* synthetic */ void I0Io(Throwable th) {
    }

    @xx0o0O.XO
    public static final void II0XooXoX(Throwable th, PrintWriter writer) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(th, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(writer, "writer");
        th.printStackTrace(writer);
    }

    @OXOo.OOXIXo
    public static final StackTraceElement[] II0xO0(@OXOo.OOXIXo Throwable th) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(th, "<this>");
        StackTraceElement[] stackTrace = th.getStackTrace();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(stackTrace);
        return stackTrace;
    }

    @xx0o0O.XO
    public static final void Oxx0IOOO(Throwable th, PrintStream stream) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(th, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(stream, "stream");
        th.printStackTrace(stream);
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static /* synthetic */ void X0o0xo(Throwable th) {
    }

    @xx0o0O.XO
    public static final void XO(Throwable th) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(th, "<this>");
        th.printStackTrace();
    }

    @oxxXoxO(version = "1.1")
    @xx0o0O.X0o0xo
    public static void oIX0oI(@OXOo.OOXIXo Throwable th, @OXOo.OOXIXo Throwable exception) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(th, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(exception, "exception");
        if (th != exception) {
            xx0o0O.ooOOo0oXI.f35291oIX0oI.oIX0oI(th, exception);
        }
    }

    @OXOo.OOXIXo
    public static final List<Throwable> oxoX(@OXOo.OOXIXo Throwable th) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(th, "<this>");
        return xx0o0O.ooOOo0oXI.f35291oIX0oI.oxoX(th);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static String xxIXOIIO(@OXOo.OOXIXo Throwable th) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        kotlin.jvm.internal.IIX0o.oO(stringWriter2, "toString(...)");
        return stringWriter2;
    }
}
