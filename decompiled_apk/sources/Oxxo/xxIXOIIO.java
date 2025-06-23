package Oxxo;

import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;

/* loaded from: classes6.dex */
public class xxIXOIIO extends DefaultMutableTreeNode {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f3167oIX0oI = true;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f3165II0xO0 = 0;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f3164I0Io = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f3168oxoX = false;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f3166X0o0xo = false;

    public xxIXOIIO(String str) {
        setUserObject(str);
    }

    public void I0Io() {
        xxIXOIIO parent = getParent();
        if (parent == null) {
            return;
        }
        parent.II0xO0();
    }

    public int II0XooXoX() {
        return XO() + X0o0xo();
    }

    public void II0xO0() {
        this.f3164I0Io++;
        I0Io();
    }

    public void IXxxXO(boolean z) {
        if (z != this.f3167oIX0oI) {
            this.f3167oIX0oI = z;
        }
    }

    public int OOXIXo() {
        return Oxx0IOOO().hashCode();
    }

    public void Oo(boolean z) {
        this.f3166X0o0xo = z;
    }

    public String Oxx0IOOO() {
        return (String) getUserObject();
    }

    public String Oxx0xo() {
        return Oxx0IOOO();
    }

    public int X0o0xo() {
        return this.f3165II0xO0;
    }

    public int XO() {
        return this.f3164I0Io;
    }

    public void oIX0oI() {
        this.f3165II0xO0++;
        I0Io();
    }

    public void oO() {
        Enumeration children = children();
        while (children.hasMoreElements()) {
            xxIXOIIO xxixoiio = (xxIXOIIO) children.nextElement();
            xxixoiio.IXxxXO(true);
            xxixoiio.oO();
        }
    }

    public boolean oOoXoXO() {
        return this.f3167oIX0oI;
    }

    public void ooOOo0oXI() {
        this.f3165II0xO0 = 0;
        this.f3164I0Io = 0;
        this.f3166X0o0xo = false;
        this.f3168oxoX = false;
    }

    public boolean oxoX(Object obj) {
        if ((obj instanceof xxIXOIIO) && Oxx0IOOO().toLowerCase().equals(((xxIXOIIO) obj).Oxx0IOOO().toLowerCase())) {
            return true;
        }
        return false;
    }

    public void x0XOIxOo() {
        Enumeration children = children();
        while (children.hasMoreElements()) {
            xxIXOIIO xxixoiio = (xxIXOIIO) children.nextElement();
            xxixoiio.IXxxXO(false);
            xxixoiio.x0XOIxOo();
        }
    }

    public void x0xO0oo(boolean z) {
        this.f3168oxoX = z;
    }

    public boolean xoIox() {
        return this.f3166X0o0xo;
    }

    public boolean xxIXOIIO() {
        return this.f3168oxoX;
    }
}
