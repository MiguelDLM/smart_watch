package jxl.read.biff;

/* loaded from: classes6.dex */
public class oOo extends OoIXo.Xx000oIo {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28388OOXIXo = XxIIOXIXx.X0o0xo.Oxx0IOOO(oOo.class);

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final II0xO0 f28389oOoXoXO = new II0xO0();

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f28390I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f28391II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f28392Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f28393X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f28394XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f28395oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f28396xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f28397xxIXOIIO;

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    public oOo(xoxXI xoxxi) {
        super(xoxxi);
        byte[] I0Io2 = xoxxi.I0Io();
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28390I0Io = (I0Io3 & 512) != 0;
        this.f28395oxoX = (I0Io3 & 2) != 0;
        this.f28394XO = (I0Io3 & 8) != 0;
        this.f28393X0o0xo = (I0Io3 & 16) != 0;
        this.f28392Oxx0IOOO = (I0Io3 & 256) != 0;
        this.f28391II0XooXoX = (I0Io3 & 2048) != 0;
        this.f28397xxIXOIIO = OoIXo.oo0xXOI0I.I0Io(I0Io2[10], I0Io2[11]);
        this.f28396xoIox = OoIXo.oo0xXOI0I.I0Io(I0Io2[12], I0Io2[13]);
    }

    public int I0X0x0oIo() {
        return this.f28396xoIox;
    }

    public boolean O0Xx() {
        return this.f28390I0Io;
    }

    public boolean XX0() {
        return this.f28392Oxx0IOOO;
    }

    public boolean Xo0() {
        return this.f28395oxoX;
    }

    public boolean XoI0Ixx0() {
        return this.f28391II0XooXoX;
    }

    public int oX() {
        return this.f28397xxIXOIIO;
    }

    public boolean xXOx() {
        return this.f28394XO;
    }

    public boolean xo0x() {
        return this.f28393X0o0xo;
    }

    public oOo(xoxXI xoxxi, II0xO0 iI0xO0) {
        super(xoxxi);
        byte[] I0Io2 = xoxxi.I0Io();
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28390I0Io = (I0Io3 & 512) != 0;
        this.f28395oxoX = (I0Io3 & 2) != 0;
        this.f28394XO = (I0Io3 & 8) != 0;
        this.f28393X0o0xo = (I0Io3 & 16) != 0;
        this.f28392Oxx0IOOO = (I0Io3 & 256) != 0;
        this.f28391II0XooXoX = (I0Io3 & 2048) != 0;
    }
}
