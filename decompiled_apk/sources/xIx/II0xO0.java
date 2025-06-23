package xIx;

import com.tanx.exposer.achieve.AdMonitorType;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes13.dex */
public final class II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final boolean f34306I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final XoOxI0ox.oIX0oI f34307II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final boolean f34308II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final String f34309OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final x0oxIIIX.oxoX f34310Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final List<AdMonitorType> f34311X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final xIOXX.II0xO0 f34312XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f34313oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final int f34314oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public final String f34315xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f34316xxIXOIIO;

    /* loaded from: classes13.dex */
    public static class oIX0oI {

        /* renamed from: II0XooXoX, reason: collision with root package name */
        public XoOxI0ox.oIX0oI f34318II0XooXoX;

        /* renamed from: OOXIXo, reason: collision with root package name */
        public String f34320OOXIXo;

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public final x0oxIIIX.oIX0oI f34321Oxx0IOOO;

        /* renamed from: XO, reason: collision with root package name */
        public final xIOXX.oIX0oI f34323XO;

        /* renamed from: oOoXoXO, reason: collision with root package name */
        public boolean f34325oOoXoXO;

        /* renamed from: xoIox, reason: collision with root package name */
        public String f34327xoIox;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f34324oIX0oI = x0oxIIIX.II0xO0.oIX0oI();

        /* renamed from: II0xO0, reason: collision with root package name */
        public boolean f34319II0xO0 = true;

        /* renamed from: I0Io, reason: collision with root package name */
        public boolean f34317I0Io = true;

        /* renamed from: oxoX, reason: collision with root package name */
        public int f34326oxoX = 5;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public List<AdMonitorType> f34322X0o0xo = Arrays.asList(AdMonitorType.CLICK, AdMonitorType.EXPOSE, AdMonitorType.INTERACT, AdMonitorType.INTERACT_DEDUPLICATION);

        /* renamed from: xxIXOIIO, reason: collision with root package name */
        public boolean f34328xxIXOIIO = false;

        public oIX0oI(xIOXX.oIX0oI oix0oi, x0oxIIIX.oIX0oI oix0oi2) {
            this.f34323XO = oix0oi;
            this.f34321Oxx0IOOO = oix0oi2;
        }

        public II0xO0 II0XooXoX() {
            return new II0xO0(this);
        }

        public oIX0oI Oxx0IOOO(boolean z) {
            this.f34319II0xO0 = z;
            return this;
        }

        public oIX0oI X0o0xo(int i) {
            this.f34324oIX0oI = i;
            return this;
        }

        public oIX0oI XO(String str, String str2) {
            this.f34327xoIox = str;
            this.f34320OOXIXo = str2;
            return this;
        }

        public oIX0oI ooOOo0oXI(boolean z) {
            this.f34317I0Io = z;
            return this;
        }

        public oIX0oI xoIox(boolean z) {
            this.f34325oOoXoXO = z;
            return this;
        }
    }

    public II0xO0(oIX0oI oix0oi) {
        int i = oix0oi.f34324oIX0oI;
        this.f34313oIX0oI = i;
        this.f34308II0xO0 = oix0oi.f34319II0xO0;
        this.f34306I0Io = oix0oi.f34317I0Io;
        this.f34314oxoX = oix0oi.f34326oxoX;
        this.f34311X0o0xo = oix0oi.f34322X0o0xo;
        this.f34312XO = new xIOXX.II0xO0(oix0oi.f34323XO);
        this.f34310Oxx0IOOO = new x0oxIIIX.oxoX(oix0oi.f34321Oxx0IOOO);
        this.f34307II0XooXoX = oix0oi.f34318II0XooXoX;
        this.f34316xxIXOIIO = oix0oi.f34328xxIXOIIO;
        this.f34315xoIox = oix0oi.f34327xoIox;
        this.f34309OOXIXo = oix0oi.f34320OOXIXo;
        XOxoX.oIX0oI.X0o0xo(oix0oi.f34325oOoXoXO);
        x0oxIIIX.II0xO0.II0xO0(i);
    }

    public String I0Io() {
        return this.f34315xoIox;
    }

    public xIOXX.oIX0oI II0XooXoX() {
        return this.f34312XO;
    }

    public boolean II0xO0() {
        return this.f34316xxIXOIIO;
    }

    public boolean Oxx0IOOO() {
        return this.f34306I0Io;
    }

    public String X0o0xo() {
        return this.f34309OOXIXo;
    }

    public int XO() {
        return this.f34314oxoX;
    }

    public List<AdMonitorType> oIX0oI() {
        return this.f34311X0o0xo;
    }

    public boolean oxoX() {
        return this.f34308II0xO0;
    }

    public XoOxI0ox.oIX0oI xoIox() {
        return this.f34307II0XooXoX;
    }

    public x0oxIIIX.oxoX xxIXOIIO() {
        return this.f34310Oxx0IOOO;
    }
}
