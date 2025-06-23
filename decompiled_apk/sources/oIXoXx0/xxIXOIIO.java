package oIXoXx0;

import com.tenmeter.smlibrary.utils.DateFormatUtils;

/* loaded from: classes6.dex */
public final class xxIXOIIO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final OoIXo.o00 f31723I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final OoIXo.o00 f31724II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final OoIXo.o00 f31725II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final OoIXo.o00 f31726OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final OoIXo.o00 f31727Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final OoIXo.o00 f31728X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static final OoIXo.o00 f31729XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final OoIXo.o00 f31730oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final OoIXo.o00 f31731oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final OoIXo.o00 f31732ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final OoIXo.o00 f31733oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final OoIXo.o00 f31734xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final OoIXo.o00 f31735xxIXOIIO;

    static {
        oIX0oI oix0oi = new oIX0oI(14, "M/d/yy");
        f31730oIX0oI = oix0oi;
        f31725II0xO0 = oix0oi;
        f31723I0Io = new oIX0oI(15, "d-MMM-yy");
        f31733oxoX = new oIX0oI(16, "d-MMM");
        f31728X0o0xo = new oIX0oI(17, "MMM-yy");
        f31729XO = new oIX0oI(18, com.sma.smartv3.util.xoIox.f24681II0xO0);
        f31727Oxx0IOOO = new oIX0oI(19, "h:mm:ss a");
        f31724II0XooXoX = new oIX0oI(20, "H:mm");
        f31735xxIXOIIO = new oIX0oI(21, "H:mm:ss");
        f31734xoIox = new oIX0oI(22, "M/d/yy H:mm");
        f31726OOXIXo = new oIX0oI(45, DateFormatUtils.MM_SS);
        f31731oOoXoXO = new oIX0oI(46, "H:mm:ss");
        f31732ooOOo0oXI = new oIX0oI(47, "H:mm:ss");
    }

    /* loaded from: classes6.dex */
    public static class oIX0oI implements OoIXo.o00 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public String f31736II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f31737oIX0oI;

        public oIX0oI(int i, String str) {
            this.f31737oIX0oI = i;
            this.f31736II0xO0 = str;
        }

        @Override // OoIXo.o00
        public int OxI() {
            return this.f31737oIX0oI;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if ((obj instanceof oIX0oI) && this.f31737oIX0oI == ((oIX0oI) obj).f31737oIX0oI) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f31737oIX0oI;
        }

        @Override // OoIXo.o00
        public boolean isInitialized() {
            return true;
        }

        public String oIX0oI() {
            return this.f31736II0xO0;
        }

        @Override // OoIXo.o00
        public boolean xII() {
            return true;
        }

        @Override // OoIXo.o00
        public void initialize(int i) {
        }
    }
}
