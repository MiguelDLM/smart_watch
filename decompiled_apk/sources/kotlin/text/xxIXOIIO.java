package kotlin.text;

import XXO0.oIX0oI;
import kotlin.jvm.internal.IIX0o;
import kotlin.o0;
import kotlin.oXIO0o0XI;
import kotlin.oxxXoxO;

@kotlin.IXxxXO
@oxxXoxO(version = "1.9")
/* loaded from: classes6.dex */
public final class xxIXOIIO {

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final xxIXOIIO f29590X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final xxIXOIIO f29591XO;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final I0Io f29592oxoX = new I0Io(null);

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oxoX f29593I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final II0xO0 f29594II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final boolean f29595oIX0oI;

    /* loaded from: classes6.dex */
    public static final class I0Io {
        public /* synthetic */ I0Io(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final xxIXOIIO II0xO0() {
            return xxIXOIIO.f29591XO;
        }

        @OXOo.OOXIXo
        public final xxIXOIIO oIX0oI() {
            return xxIXOIIO.f29590X0o0xo;
        }

        public I0Io() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        @OXOo.OOXIXo
        public final String f29598I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final int f29599II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        @OXOo.OOXIXo
        public final String f29600X0o0xo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final String f29601XO;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final int f29602oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        @OXOo.OOXIXo
        public final String f29603oxoX;

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        @OXOo.OOXIXo
        public static final C1110II0xO0 f29597Oxx0IOOO = new C1110II0xO0(null);

        /* renamed from: II0XooXoX, reason: collision with root package name */
        @OXOo.OOXIXo
        public static final II0xO0 f29596II0XooXoX = new II0xO0(Integer.MAX_VALUE, Integer.MAX_VALUE, "  ", "", "", "");

        /* renamed from: kotlin.text.xxIXOIIO$II0xO0$II0xO0, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1110II0xO0 {
            public /* synthetic */ C1110II0xO0(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            @OXOo.OOXIXo
            public final II0xO0 oIX0oI() {
                return II0xO0.f29596II0XooXoX;
            }

            public C1110II0xO0() {
            }
        }

        /* loaded from: classes6.dex */
        public static final class oIX0oI {

            /* renamed from: I0Io, reason: collision with root package name */
            @OXOo.OOXIXo
            public String f29604I0Io;

            /* renamed from: II0xO0, reason: collision with root package name */
            public int f29605II0xO0;

            /* renamed from: X0o0xo, reason: collision with root package name */
            @OXOo.OOXIXo
            public String f29606X0o0xo;

            /* renamed from: XO, reason: collision with root package name */
            @OXOo.OOXIXo
            public String f29607XO;

            /* renamed from: oIX0oI, reason: collision with root package name */
            public int f29608oIX0oI;

            /* renamed from: oxoX, reason: collision with root package name */
            @OXOo.OOXIXo
            public String f29609oxoX;

            public oIX0oI() {
                C1110II0xO0 c1110II0xO0 = II0xO0.f29597Oxx0IOOO;
                this.f29608oIX0oI = c1110II0xO0.oIX0oI().Oxx0IOOO();
                this.f29605II0xO0 = c1110II0xO0.oIX0oI().XO();
                this.f29604I0Io = c1110II0xO0.oIX0oI().II0XooXoX();
                this.f29609oxoX = c1110II0xO0.oIX0oI().oxoX();
                this.f29606X0o0xo = c1110II0xO0.oIX0oI().I0Io();
                this.f29607XO = c1110II0xO0.oIX0oI().X0o0xo();
            }

            @OXOo.OOXIXo
            public final String I0Io() {
                return this.f29609oxoX;
            }

            public final void II0XooXoX(@OXOo.OOXIXo String value) {
                IIX0o.x0xO0oo(value, "value");
                if (!StringsKt__StringsKt.xXo(value, '\n', false, 2, null) && !StringsKt__StringsKt.xXo(value, '\r', false, 2, null)) {
                    this.f29606X0o0xo = value;
                    return;
                }
                throw new IllegalArgumentException("LF and CR characters are prohibited in bytePrefix, but was " + value);
            }

            @OXOo.OOXIXo
            public final String II0xO0() {
                return this.f29606X0o0xo;
            }

            public final void OOXIXo(int i) {
                if (i > 0) {
                    this.f29605II0xO0 = i;
                    return;
                }
                throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerGroup, but was " + i);
            }

            @OXOo.OOXIXo
            public final String Oxx0IOOO() {
                return this.f29604I0Io;
            }

            public final int X0o0xo() {
                return this.f29605II0xO0;
            }

            public final int XO() {
                return this.f29608oIX0oI;
            }

            @OXOo.OOXIXo
            public final II0xO0 oIX0oI() {
                return new II0xO0(this.f29608oIX0oI, this.f29605II0xO0, this.f29604I0Io, this.f29609oxoX, this.f29606X0o0xo, this.f29607XO);
            }

            public final void oOoXoXO(int i) {
                if (i > 0) {
                    this.f29608oIX0oI = i;
                    return;
                }
                throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerLine, but was " + i);
            }

            public final void ooOOo0oXI(@OXOo.OOXIXo String str) {
                IIX0o.x0xO0oo(str, "<set-?>");
                this.f29604I0Io = str;
            }

            @OXOo.OOXIXo
            public final String oxoX() {
                return this.f29607XO;
            }

            public final void xoIox(@OXOo.OOXIXo String value) {
                IIX0o.x0xO0oo(value, "value");
                if (!StringsKt__StringsKt.xXo(value, '\n', false, 2, null) && !StringsKt__StringsKt.xXo(value, '\r', false, 2, null)) {
                    this.f29607XO = value;
                    return;
                }
                throw new IllegalArgumentException("LF and CR characters are prohibited in byteSuffix, but was " + value);
            }

            public final void xxIXOIIO(@OXOo.OOXIXo String value) {
                IIX0o.x0xO0oo(value, "value");
                if (!StringsKt__StringsKt.xXo(value, '\n', false, 2, null) && !StringsKt__StringsKt.xXo(value, '\r', false, 2, null)) {
                    this.f29609oxoX = value;
                    return;
                }
                throw new IllegalArgumentException("LF and CR characters are prohibited in byteSeparator, but was " + value);
            }
        }

        public II0xO0(int i, int i2, @OXOo.OOXIXo String groupSeparator, @OXOo.OOXIXo String byteSeparator, @OXOo.OOXIXo String bytePrefix, @OXOo.OOXIXo String byteSuffix) {
            IIX0o.x0xO0oo(groupSeparator, "groupSeparator");
            IIX0o.x0xO0oo(byteSeparator, "byteSeparator");
            IIX0o.x0xO0oo(bytePrefix, "bytePrefix");
            IIX0o.x0xO0oo(byteSuffix, "byteSuffix");
            this.f29602oIX0oI = i;
            this.f29599II0xO0 = i2;
            this.f29598I0Io = groupSeparator;
            this.f29603oxoX = byteSeparator;
            this.f29600X0o0xo = bytePrefix;
            this.f29601XO = byteSuffix;
        }

        @OXOo.OOXIXo
        public final String I0Io() {
            return this.f29600X0o0xo;
        }

        @OXOo.OOXIXo
        public final String II0XooXoX() {
            return this.f29598I0Io;
        }

        @OXOo.OOXIXo
        public final StringBuilder II0xO0(@OXOo.OOXIXo StringBuilder sb, @OXOo.OOXIXo String indent) {
            IIX0o.x0xO0oo(sb, "sb");
            IIX0o.x0xO0oo(indent, "indent");
            sb.append(indent);
            sb.append("bytesPerLine = ");
            sb.append(this.f29602oIX0oI);
            IIX0o.oO(sb, "append(...)");
            sb.append(",");
            IIX0o.oO(sb, "append(...)");
            sb.append('\n');
            IIX0o.oO(sb, "append(...)");
            sb.append(indent);
            sb.append("bytesPerGroup = ");
            sb.append(this.f29599II0xO0);
            IIX0o.oO(sb, "append(...)");
            sb.append(",");
            IIX0o.oO(sb, "append(...)");
            sb.append('\n');
            IIX0o.oO(sb, "append(...)");
            sb.append(indent);
            sb.append("groupSeparator = \"");
            sb.append(this.f29598I0Io);
            IIX0o.oO(sb, "append(...)");
            sb.append("\",");
            IIX0o.oO(sb, "append(...)");
            sb.append('\n');
            IIX0o.oO(sb, "append(...)");
            sb.append(indent);
            sb.append("byteSeparator = \"");
            sb.append(this.f29603oxoX);
            IIX0o.oO(sb, "append(...)");
            sb.append("\",");
            IIX0o.oO(sb, "append(...)");
            sb.append('\n');
            IIX0o.oO(sb, "append(...)");
            sb.append(indent);
            sb.append("bytePrefix = \"");
            sb.append(this.f29600X0o0xo);
            IIX0o.oO(sb, "append(...)");
            sb.append("\",");
            IIX0o.oO(sb, "append(...)");
            sb.append('\n');
            IIX0o.oO(sb, "append(...)");
            sb.append(indent);
            sb.append("byteSuffix = \"");
            sb.append(this.f29601XO);
            sb.append("\"");
            return sb;
        }

        public final int Oxx0IOOO() {
            return this.f29602oIX0oI;
        }

        @OXOo.OOXIXo
        public final String X0o0xo() {
            return this.f29601XO;
        }

        public final int XO() {
            return this.f29599II0xO0;
        }

        @OXOo.OOXIXo
        public final String oxoX() {
            return this.f29603oxoX;
        }

        @OXOo.OOXIXo
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BytesHexFormat(");
            IIX0o.oO(sb, "append(...)");
            sb.append('\n');
            IIX0o.oO(sb, "append(...)");
            StringBuilder II0xO02 = II0xO0(sb, OIII0O.OOXIXo.f1567xI);
            II0xO02.append('\n');
            IIX0o.oO(II0xO02, "append(...)");
            sb.append(oIX0oI.I0Io.f4095I0Io);
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "toString(...)");
            return sb2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        @OXOo.oOoXoXO
        public oxoX.oIX0oI f29610I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.oOoXoXO
        public II0xO0.oIX0oI f29611II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public boolean f29612oIX0oI = xxIXOIIO.f29592oxoX.oIX0oI().X0o0xo();

        @o0
        public oIX0oI() {
        }

        @OXOo.OOXIXo
        public final II0xO0.oIX0oI I0Io() {
            if (this.f29611II0xO0 == null) {
                this.f29611II0xO0 = new II0xO0.oIX0oI();
            }
            II0xO0.oIX0oI oix0oi = this.f29611II0xO0;
            IIX0o.ooOOo0oXI(oix0oi);
            return oix0oi;
        }

        @xx0o0O.XO
        public final void II0xO0(Oox.oOoXoXO<? super II0xO0.oIX0oI, oXIO0o0XI> builderAction) {
            IIX0o.x0xO0oo(builderAction, "builderAction");
            builderAction.invoke(I0Io());
        }

        public final void Oxx0IOOO(boolean z) {
            this.f29612oIX0oI = z;
        }

        public final boolean X0o0xo() {
            return this.f29612oIX0oI;
        }

        @xx0o0O.XO
        public final void XO(Oox.oOoXoXO<? super oxoX.oIX0oI, oXIO0o0XI> builderAction) {
            IIX0o.x0xO0oo(builderAction, "builderAction");
            builderAction.invoke(oxoX());
        }

        @OXOo.OOXIXo
        @o0
        public final xxIXOIIO oIX0oI() {
            II0xO0 oIX0oI2;
            oxoX oIX0oI3;
            boolean z = this.f29612oIX0oI;
            II0xO0.oIX0oI oix0oi = this.f29611II0xO0;
            if (oix0oi == null || (oIX0oI2 = oix0oi.oIX0oI()) == null) {
                oIX0oI2 = II0xO0.f29597Oxx0IOOO.oIX0oI();
            }
            oxoX.oIX0oI oix0oi2 = this.f29610I0Io;
            if (oix0oi2 == null || (oIX0oI3 = oix0oi2.oIX0oI()) == null) {
                oIX0oI3 = oxoX.f29614oxoX.oIX0oI();
            }
            return new xxIXOIIO(z, oIX0oI2, oIX0oI3);
        }

        @OXOo.OOXIXo
        public final oxoX.oIX0oI oxoX() {
            if (this.f29610I0Io == null) {
                this.f29610I0Io = new oxoX.oIX0oI();
            }
            oxoX.oIX0oI oix0oi = this.f29610I0Io;
            IIX0o.ooOOo0oXI(oix0oi);
            return oix0oi;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oxoX {

        /* renamed from: I0Io, reason: collision with root package name */
        public final boolean f29615I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.OOXIXo
        public final String f29616II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OXOo.OOXIXo
        public final String f29617oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        @OXOo.OOXIXo
        public static final II0xO0 f29614oxoX = new II0xO0(null);

        /* renamed from: X0o0xo, reason: collision with root package name */
        @OXOo.OOXIXo
        public static final oxoX f29613X0o0xo = new oxoX("", "", false);

        /* loaded from: classes6.dex */
        public static final class II0xO0 {
            public /* synthetic */ II0xO0(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            @OXOo.OOXIXo
            public final oxoX oIX0oI() {
                return oxoX.f29613X0o0xo;
            }

            public II0xO0() {
            }
        }

        /* loaded from: classes6.dex */
        public static final class oIX0oI {

            /* renamed from: I0Io, reason: collision with root package name */
            public boolean f29618I0Io;

            /* renamed from: II0xO0, reason: collision with root package name */
            @OXOo.OOXIXo
            public String f29619II0xO0;

            /* renamed from: oIX0oI, reason: collision with root package name */
            @OXOo.OOXIXo
            public String f29620oIX0oI;

            public oIX0oI() {
                II0xO0 iI0xO0 = oxoX.f29614oxoX;
                this.f29620oIX0oI = iI0xO0.oIX0oI().I0Io();
                this.f29619II0xO0 = iI0xO0.oIX0oI().X0o0xo();
                this.f29618I0Io = iI0xO0.oIX0oI().oxoX();
            }

            public final boolean I0Io() {
                return this.f29618I0Io;
            }

            @OXOo.OOXIXo
            public final String II0xO0() {
                return this.f29620oIX0oI;
            }

            public final void Oxx0IOOO(@OXOo.OOXIXo String value) {
                IIX0o.x0xO0oo(value, "value");
                if (!StringsKt__StringsKt.xXo(value, '\n', false, 2, null) && !StringsKt__StringsKt.xXo(value, '\r', false, 2, null)) {
                    this.f29619II0xO0 = value;
                    return;
                }
                throw new IllegalArgumentException("LF and CR characters are prohibited in suffix, but was " + value);
            }

            public final void X0o0xo(@OXOo.OOXIXo String value) {
                IIX0o.x0xO0oo(value, "value");
                if (!StringsKt__StringsKt.xXo(value, '\n', false, 2, null) && !StringsKt__StringsKt.xXo(value, '\r', false, 2, null)) {
                    this.f29620oIX0oI = value;
                    return;
                }
                throw new IllegalArgumentException("LF and CR characters are prohibited in prefix, but was " + value);
            }

            public final void XO(boolean z) {
                this.f29618I0Io = z;
            }

            @OXOo.OOXIXo
            public final oxoX oIX0oI() {
                return new oxoX(this.f29620oIX0oI, this.f29619II0xO0, this.f29618I0Io);
            }

            @OXOo.OOXIXo
            public final String oxoX() {
                return this.f29619II0xO0;
            }
        }

        public oxoX(@OXOo.OOXIXo String prefix, @OXOo.OOXIXo String suffix, boolean z) {
            IIX0o.x0xO0oo(prefix, "prefix");
            IIX0o.x0xO0oo(suffix, "suffix");
            this.f29617oIX0oI = prefix;
            this.f29616II0xO0 = suffix;
            this.f29615I0Io = z;
        }

        @OXOo.OOXIXo
        public final String I0Io() {
            return this.f29617oIX0oI;
        }

        @OXOo.OOXIXo
        public final StringBuilder II0xO0(@OXOo.OOXIXo StringBuilder sb, @OXOo.OOXIXo String indent) {
            IIX0o.x0xO0oo(sb, "sb");
            IIX0o.x0xO0oo(indent, "indent");
            sb.append(indent);
            sb.append("prefix = \"");
            sb.append(this.f29617oIX0oI);
            IIX0o.oO(sb, "append(...)");
            sb.append("\",");
            IIX0o.oO(sb, "append(...)");
            sb.append('\n');
            IIX0o.oO(sb, "append(...)");
            sb.append(indent);
            sb.append("suffix = \"");
            sb.append(this.f29616II0xO0);
            IIX0o.oO(sb, "append(...)");
            sb.append("\",");
            IIX0o.oO(sb, "append(...)");
            sb.append('\n');
            IIX0o.oO(sb, "append(...)");
            sb.append(indent);
            sb.append("removeLeadingZeros = ");
            sb.append(this.f29615I0Io);
            return sb;
        }

        @OXOo.OOXIXo
        public final String X0o0xo() {
            return this.f29616II0xO0;
        }

        public final boolean oxoX() {
            return this.f29615I0Io;
        }

        @OXOo.OOXIXo
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberHexFormat(");
            IIX0o.oO(sb, "append(...)");
            sb.append('\n');
            IIX0o.oO(sb, "append(...)");
            StringBuilder II0xO02 = II0xO0(sb, OIII0O.OOXIXo.f1567xI);
            II0xO02.append('\n');
            IIX0o.oO(II0xO02, "append(...)");
            sb.append(oIX0oI.I0Io.f4095I0Io);
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "toString(...)");
            return sb2;
        }
    }

    static {
        II0xO0.C1110II0xO0 c1110II0xO0 = II0xO0.f29597Oxx0IOOO;
        II0xO0 oIX0oI2 = c1110II0xO0.oIX0oI();
        oxoX.II0xO0 iI0xO0 = oxoX.f29614oxoX;
        f29590X0o0xo = new xxIXOIIO(false, oIX0oI2, iI0xO0.oIX0oI());
        f29591XO = new xxIXOIIO(true, c1110II0xO0.oIX0oI(), iI0xO0.oIX0oI());
    }

    public xxIXOIIO(boolean z, @OXOo.OOXIXo II0xO0 bytes, @OXOo.OOXIXo oxoX number) {
        IIX0o.x0xO0oo(bytes, "bytes");
        IIX0o.x0xO0oo(number, "number");
        this.f29595oIX0oI = z;
        this.f29594II0xO0 = bytes;
        this.f29593I0Io = number;
    }

    @OXOo.OOXIXo
    public final II0xO0 I0Io() {
        return this.f29594II0xO0;
    }

    public final boolean X0o0xo() {
        return this.f29595oIX0oI;
    }

    @OXOo.OOXIXo
    public final oxoX oxoX() {
        return this.f29593I0Io;
    }

    @OXOo.OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HexFormat(");
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        sb.append("    upperCase = ");
        sb.append(this.f29595oIX0oI);
        IIX0o.oO(sb, "append(...)");
        sb.append(",");
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        sb.append("    bytes = BytesHexFormat(");
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        StringBuilder II0xO02 = this.f29594II0xO0.II0xO0(sb, "        ");
        II0xO02.append('\n');
        IIX0o.oO(II0xO02, "append(...)");
        sb.append("    ),");
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        sb.append("    number = NumberHexFormat(");
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        StringBuilder II0xO03 = this.f29593I0Io.II0xO0(sb, "        ");
        II0xO03.append('\n');
        IIX0o.oO(II0xO03, "append(...)");
        sb.append("    )");
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        sb.append(oIX0oI.I0Io.f4095I0Io);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }
}
