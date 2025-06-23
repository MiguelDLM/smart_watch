package O0O0Io00X;

import XxIIOXIXx.X0o0xo;
import java.io.PrintStream;

/* loaded from: classes6.dex */
public class II0xO0 extends X0o0xo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f1262II0xO0 = false;

    @Override // XxIIOXIXx.X0o0xo
    public void I0Io(Object obj) {
        PrintStream printStream = System.err;
        printStream.print("Error: ");
        printStream.println(obj);
    }

    @Override // XxIIOXIXx.X0o0xo
    public void II0xO0(Object obj, Throwable th) {
        if (!this.f1262II0xO0) {
            PrintStream printStream = System.out;
            printStream.print("Debug: ");
            printStream.println(obj);
            th.printStackTrace();
        }
    }

    @Override // XxIIOXIXx.X0o0xo
    public void X0o0xo(Object obj) {
        PrintStream printStream = System.err;
        printStream.print("Fatal: ");
        printStream.println(obj);
    }

    @Override // XxIIOXIXx.X0o0xo
    public void XO(Object obj, Throwable th) {
        PrintStream printStream = System.err;
        printStream.print("Fatal:  ");
        printStream.println(obj);
        th.printStackTrace();
    }

    @Override // XxIIOXIXx.X0o0xo
    public void oIX0oI(Object obj) {
        if (!this.f1262II0xO0) {
            PrintStream printStream = System.out;
            printStream.print("Debug: ");
            printStream.println(obj);
        }
    }

    @Override // XxIIOXIXx.X0o0xo
    public void oOoXoXO(boolean z) {
        this.f1262II0xO0 = z;
    }

    @Override // XxIIOXIXx.X0o0xo
    public void ooOOo0oXI(Object obj) {
        if (!this.f1262II0xO0) {
            PrintStream printStream = System.err;
            printStream.print("Warning:  ");
            printStream.println(obj);
        }
    }

    @Override // XxIIOXIXx.X0o0xo
    public void oxoX(Object obj, Throwable th) {
        PrintStream printStream = System.err;
        printStream.print("Error: ");
        printStream.println(obj);
        th.printStackTrace();
    }

    @Override // XxIIOXIXx.X0o0xo
    public void x0XOIxOo(Object obj, Throwable th) {
        if (!this.f1262II0xO0) {
            PrintStream printStream = System.err;
            printStream.print("Warning:  ");
            printStream.println(obj);
            th.printStackTrace();
        }
    }

    @Override // XxIIOXIXx.X0o0xo
    public void xoIox(Object obj, Throwable th) {
        if (!this.f1262II0xO0) {
            System.out.println(obj);
            th.printStackTrace();
        }
    }

    @Override // XxIIOXIXx.X0o0xo
    public void xxIXOIIO(Object obj) {
        if (!this.f1262II0xO0) {
            System.out.println(obj);
        }
    }

    @Override // XxIIOXIXx.X0o0xo
    public X0o0xo II0XooXoX(Class cls) {
        return this;
    }
}
