package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class x0XOIxOo {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f33292IIXOooo = 2001;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f33293IXxxXO = 1002;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static /* synthetic */ Class f33294O0xOxO = null;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f33295OOXIXo = 1;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f33296Oo = 1001;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f33297OxI = 2004;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f33298Oxx0xo = 1003;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f33299OxxIIOOXO = 2000;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f33300o00 = 2003;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f33301oI0IIXIo = 1004;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f33302oO = 5;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f33303oOoXoXO = 2;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f33304ooOOo0oXI = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f33305x0XOIxOo = 4;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f33306x0xO0oo = 1000;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f33307xoIox = 0;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f33308xoXoI = 2002;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final char f33309xxIXOIIO = '%';

    /* renamed from: I0Io, reason: collision with root package name */
    public int f33310I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f33311II0XooXoX;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public ooOOo0oXI f33314X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public ooOOo0oXI f33315XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f33317oxoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public StringBuffer f33312II0xO0 = new StringBuffer(32);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public org.apache.log4j.helpers.Oxx0IOOO f33313Oxx0IOOO = new org.apache.log4j.helpers.Oxx0IOOO();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f33316oIX0oI = 0;

    /* loaded from: classes6.dex */
    public class I0Io extends II0XooXoX {

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public final /* synthetic */ x0XOIxOo f33318Oxx0IOOO;

        public I0Io(x0XOIxOo x0xoixoo, org.apache.log4j.helpers.Oxx0IOOO oxx0IOOO, int i) {
            super(oxx0IOOO, i);
            this.f33318Oxx0IOOO = x0xoixoo;
        }

        @Override // org.apache.log4j.helpers.x0XOIxOo.II0XooXoX
        public String oxoX(LoggingEvent loggingEvent) {
            return loggingEvent.getLocationInformation().getClassName();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class II0XooXoX extends ooOOo0oXI {

        /* renamed from: XO, reason: collision with root package name */
        public int f33319XO;

        public II0XooXoX(org.apache.log4j.helpers.Oxx0IOOO oxx0IOOO, int i) {
            super(oxx0IOOO);
            this.f33319XO = i;
        }

        @Override // org.apache.log4j.helpers.ooOOo0oXI
        public String oIX0oI(LoggingEvent loggingEvent) {
            String oxoX2 = oxoX(loggingEvent);
            if (this.f33319XO <= 0) {
                return oxoX2;
            }
            int length = oxoX2.length();
            int i = length - 1;
            for (int i2 = this.f33319XO; i2 > 0; i2--) {
                i = oxoX2.lastIndexOf(46, i - 1);
                if (i == -1) {
                    return oxoX2;
                }
            }
            return oxoX2.substring(i + 1, length);
        }

        public abstract String oxoX(LoggingEvent loggingEvent);
    }

    /* loaded from: classes6.dex */
    public class II0xO0 extends II0XooXoX {

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public final /* synthetic */ x0XOIxOo f33320Oxx0IOOO;

        public II0xO0(x0XOIxOo x0xoixoo, org.apache.log4j.helpers.Oxx0IOOO oxx0IOOO, int i) {
            super(oxx0IOOO, i);
            this.f33320Oxx0IOOO = x0xoixoo;
        }

        @Override // org.apache.log4j.helpers.x0XOIxOo.II0XooXoX
        public String oxoX(LoggingEvent loggingEvent) {
            return loggingEvent.getLoggerName();
        }
    }

    /* loaded from: classes6.dex */
    public static class Oxx0IOOO extends ooOOo0oXI {

        /* renamed from: XO, reason: collision with root package name */
        public String f33321XO;

        public Oxx0IOOO(org.apache.log4j.helpers.Oxx0IOOO oxx0IOOO, String str) {
            super(oxx0IOOO);
            this.f33321XO = str;
        }

        @Override // org.apache.log4j.helpers.ooOOo0oXI
        public String oIX0oI(LoggingEvent loggingEvent) {
            Object mdc = loggingEvent.getMDC(this.f33321XO);
            if (mdc == null) {
                return null;
            }
            return mdc.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static class X0o0xo extends ooOOo0oXI {

        /* renamed from: XO, reason: collision with root package name */
        public String f33322XO;

        public X0o0xo(String str) {
            this.f33322XO = str;
        }

        @Override // org.apache.log4j.helpers.ooOOo0oXI
        public final void II0xO0(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
            stringBuffer.append(this.f33322XO);
        }

        @Override // org.apache.log4j.helpers.ooOOo0oXI
        public String oIX0oI(LoggingEvent loggingEvent) {
            return this.f33322XO;
        }
    }

    /* loaded from: classes6.dex */
    public class XO extends ooOOo0oXI {

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public final /* synthetic */ x0XOIxOo f33323Oxx0IOOO;

        /* renamed from: XO, reason: collision with root package name */
        public int f33324XO;

        public XO(x0XOIxOo x0xoixoo, org.apache.log4j.helpers.Oxx0IOOO oxx0IOOO, int i) {
            super(oxx0IOOO);
            this.f33323Oxx0IOOO = x0xoixoo;
            this.f33324XO = i;
        }

        @Override // org.apache.log4j.helpers.ooOOo0oXI
        public String oIX0oI(LoggingEvent loggingEvent) {
            LocationInfo locationInformation = loggingEvent.getLocationInformation();
            switch (this.f33324XO) {
                case 1000:
                    return locationInformation.fullInfo;
                case 1001:
                    return locationInformation.getMethodName();
                case 1002:
                default:
                    return null;
                case 1003:
                    return locationInformation.getLineNumber();
                case 1004:
                    return locationInformation.getFileName();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class oIX0oI extends ooOOo0oXI {

        /* renamed from: XO, reason: collision with root package name */
        public int f33325XO;

        public oIX0oI(org.apache.log4j.helpers.Oxx0IOOO oxx0IOOO, int i) {
            super(oxx0IOOO);
            this.f33325XO = i;
        }

        @Override // org.apache.log4j.helpers.ooOOo0oXI
        public String oIX0oI(LoggingEvent loggingEvent) {
            switch (this.f33325XO) {
                case 2000:
                    return Long.toString(loggingEvent.timeStamp - LoggingEvent.getStartTime());
                case 2001:
                    return loggingEvent.getThreadName();
                case 2002:
                    return loggingEvent.getLevel().toString();
                case 2003:
                    return loggingEvent.getNDC();
                case 2004:
                    return loggingEvent.getRenderedMessage();
                default:
                    return null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class oxoX extends ooOOo0oXI {

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public Date f33326Oxx0IOOO;

        /* renamed from: XO, reason: collision with root package name */
        public DateFormat f33327XO;

        public oxoX(org.apache.log4j.helpers.Oxx0IOOO oxx0IOOO, DateFormat dateFormat) {
            super(oxx0IOOO);
            this.f33326Oxx0IOOO = new Date();
            this.f33327XO = dateFormat;
        }

        @Override // org.apache.log4j.helpers.ooOOo0oXI
        public String oIX0oI(LoggingEvent loggingEvent) {
            this.f33326Oxx0IOOO.setTime(loggingEvent.timeStamp);
            try {
                return this.f33327XO.format(this.f33326Oxx0IOOO);
            } catch (Exception e) {
                xxIXOIIO.oxoX("Error occured while converting date.", e);
                return null;
            }
        }
    }

    public x0XOIxOo(String str) {
        this.f33311II0XooXoX = str;
        this.f33310I0Io = str.length();
    }

    public static /* synthetic */ Class I0Io(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public final void II0xO0(ooOOo0oXI ooooo0oxi) {
        if (this.f33314X0o0xo == null) {
            this.f33315XO = ooooo0oxi;
            this.f33314X0o0xo = ooooo0oxi;
        } else {
            this.f33315XO.f33285oIX0oI = ooooo0oxi;
            this.f33315XO = ooooo0oxi;
        }
    }

    public ooOOo0oXI Oxx0IOOO() {
        this.f33317oxoX = 0;
        while (true) {
            int i = this.f33317oxoX;
            if (i >= this.f33310I0Io) {
                break;
            }
            String str = this.f33311II0XooXoX;
            this.f33317oxoX = i + 1;
            char charAt = str.charAt(i);
            int i2 = this.f33316oIX0oI;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 == 5) {
                                this.f33312II0xO0.append(charAt);
                                if (charAt >= '0' && charAt <= '9') {
                                    org.apache.log4j.helpers.Oxx0IOOO oxx0IOOO = this.f33313Oxx0IOOO;
                                    oxx0IOOO.f33250II0xO0 = (oxx0IOOO.f33250II0xO0 * 10) + (charAt - '0');
                                } else {
                                    XO(charAt);
                                    this.f33316oIX0oI = 0;
                                }
                            }
                        } else {
                            this.f33312II0xO0.append(charAt);
                            if (charAt >= '0' && charAt <= '9') {
                                org.apache.log4j.helpers.Oxx0IOOO oxx0IOOO2 = this.f33313Oxx0IOOO;
                                oxx0IOOO2.f33251oIX0oI = (oxx0IOOO2.f33251oIX0oI * 10) + (charAt - '0');
                            } else if (charAt == '.') {
                                this.f33316oIX0oI = 3;
                            } else {
                                XO(charAt);
                            }
                        }
                    } else {
                        this.f33312II0xO0.append(charAt);
                        if (charAt >= '0' && charAt <= '9') {
                            this.f33313Oxx0IOOO.f33250II0xO0 = charAt - '0';
                            this.f33316oIX0oI = 5;
                        } else {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("Error occured in position ");
                            stringBuffer.append(this.f33317oxoX);
                            stringBuffer.append(".\n Was expecting digit, instead got char \"");
                            stringBuffer.append(charAt);
                            stringBuffer.append("\".");
                            xxIXOIIO.I0Io(stringBuffer.toString());
                            this.f33316oIX0oI = 0;
                        }
                    }
                } else {
                    this.f33312II0xO0.append(charAt);
                    if (charAt != '-') {
                        if (charAt != '.') {
                            if (charAt >= '0' && charAt <= '9') {
                                this.f33313Oxx0IOOO.f33251oIX0oI = charAt - '0';
                                this.f33316oIX0oI = 4;
                            } else {
                                XO(charAt);
                            }
                        } else {
                            this.f33316oIX0oI = 3;
                        }
                    } else {
                        this.f33313Oxx0IOOO.f33249I0Io = true;
                    }
                }
            } else {
                int i3 = this.f33317oxoX;
                if (i3 == this.f33310I0Io) {
                    this.f33312II0xO0.append(charAt);
                } else if (charAt == '%') {
                    char charAt2 = this.f33311II0XooXoX.charAt(i3);
                    if (charAt2 != '%') {
                        if (charAt2 != 'n') {
                            if (this.f33312II0xO0.length() != 0) {
                                II0xO0(new X0o0xo(this.f33312II0xO0.toString()));
                            }
                            this.f33312II0xO0.setLength(0);
                            this.f33312II0xO0.append(charAt);
                            this.f33316oIX0oI = 1;
                            this.f33313Oxx0IOOO.II0xO0();
                        } else {
                            this.f33312II0xO0.append(org.apache.log4j.x0XOIxOo.f33503oIX0oI);
                            this.f33317oxoX++;
                        }
                    } else {
                        this.f33312II0xO0.append(charAt);
                        this.f33317oxoX++;
                    }
                } else {
                    this.f33312II0xO0.append(charAt);
                }
            }
        }
        if (this.f33312II0xO0.length() != 0) {
            II0xO0(new X0o0xo(this.f33312II0xO0.toString()));
        }
        return this.f33314X0o0xo;
    }

    public int X0o0xo() {
        NumberFormatException e;
        int i;
        String oxoX2 = oxoX();
        if (oxoX2 == null) {
            return 0;
        }
        try {
            i = Integer.parseInt(oxoX2);
            if (i <= 0) {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Precision option (");
                    stringBuffer.append(oxoX2);
                    stringBuffer.append(") isn't a positive integer.");
                    xxIXOIIO.I0Io(stringBuffer.toString());
                    return 0;
                } catch (NumberFormatException e2) {
                    e = e2;
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Category option \"");
                    stringBuffer2.append(oxoX2);
                    stringBuffer2.append("\" not a decimal integer.");
                    xxIXOIIO.oxoX(stringBuffer2.toString(), e);
                    return i;
                }
            }
        } catch (NumberFormatException e3) {
            e = e3;
            i = 0;
        }
        return i;
    }

    public void XO(char c) {
        ooOOo0oXI i0Io;
        ooOOo0oXI oxx0IOOO;
        DateFormat dateFormat;
        if (c != 'C') {
            if (c != 'F') {
                if (c != 'X') {
                    if (c != 'p') {
                        if (c != 'r') {
                            if (c != 't') {
                                if (c != 'x') {
                                    if (c != 'L') {
                                        if (c != 'M') {
                                            if (c != 'c') {
                                                if (c != 'd') {
                                                    if (c != 'l') {
                                                        if (c != 'm') {
                                                            StringBuffer stringBuffer = new StringBuffer();
                                                            stringBuffer.append("Unexpected char [");
                                                            stringBuffer.append(c);
                                                            stringBuffer.append("] at position ");
                                                            stringBuffer.append(this.f33317oxoX);
                                                            stringBuffer.append(" in conversion patterrn.");
                                                            xxIXOIIO.I0Io(stringBuffer.toString());
                                                            i0Io = new X0o0xo(this.f33312II0xO0.toString());
                                                            this.f33312II0xO0.setLength(0);
                                                        } else {
                                                            i0Io = new oIX0oI(this.f33313Oxx0IOOO, 2004);
                                                            this.f33312II0xO0.setLength(0);
                                                        }
                                                    } else {
                                                        i0Io = new XO(this, this.f33313Oxx0IOOO, 1000);
                                                        this.f33312II0xO0.setLength(0);
                                                    }
                                                } else {
                                                    String oxoX2 = oxoX();
                                                    if (oxoX2 == null) {
                                                        oxoX2 = AbsoluteTimeDateFormat.ISO8601_DATE_FORMAT;
                                                    }
                                                    if (oxoX2.equalsIgnoreCase(AbsoluteTimeDateFormat.ISO8601_DATE_FORMAT)) {
                                                        dateFormat = new ISO8601DateFormat();
                                                    } else if (oxoX2.equalsIgnoreCase(AbsoluteTimeDateFormat.ABS_TIME_DATE_FORMAT)) {
                                                        dateFormat = new AbsoluteTimeDateFormat();
                                                    } else if (oxoX2.equalsIgnoreCase(AbsoluteTimeDateFormat.DATE_AND_TIME_DATE_FORMAT)) {
                                                        dateFormat = new DateTimeDateFormat();
                                                    } else {
                                                        try {
                                                            dateFormat = new SimpleDateFormat(oxoX2);
                                                        } catch (IllegalArgumentException e) {
                                                            StringBuffer stringBuffer2 = new StringBuffer();
                                                            stringBuffer2.append("Could not instantiate SimpleDateFormat with ");
                                                            stringBuffer2.append(oxoX2);
                                                            xxIXOIIO.oxoX(stringBuffer2.toString(), e);
                                                            Class cls = f33294O0xOxO;
                                                            if (cls == null) {
                                                                cls = I0Io("java.text.DateFormat");
                                                                f33294O0xOxO = cls;
                                                            }
                                                            dateFormat = (DateFormat) oOoXoXO.XO("org.apache.log4j.helpers.ISO8601DateFormat", cls, null);
                                                        }
                                                    }
                                                    oxx0IOOO = new oxoX(this.f33313Oxx0IOOO, dateFormat);
                                                    this.f33312II0xO0.setLength(0);
                                                }
                                            } else {
                                                i0Io = new II0xO0(this, this.f33313Oxx0IOOO, X0o0xo());
                                                this.f33312II0xO0.setLength(0);
                                            }
                                        } else {
                                            i0Io = new XO(this, this.f33313Oxx0IOOO, 1001);
                                            this.f33312II0xO0.setLength(0);
                                        }
                                    } else {
                                        i0Io = new XO(this, this.f33313Oxx0IOOO, 1003);
                                        this.f33312II0xO0.setLength(0);
                                    }
                                } else {
                                    i0Io = new oIX0oI(this.f33313Oxx0IOOO, 2003);
                                    this.f33312II0xO0.setLength(0);
                                }
                            } else {
                                i0Io = new oIX0oI(this.f33313Oxx0IOOO, 2001);
                                this.f33312II0xO0.setLength(0);
                            }
                        } else {
                            i0Io = new oIX0oI(this.f33313Oxx0IOOO, 2000);
                            this.f33312II0xO0.setLength(0);
                        }
                    } else {
                        i0Io = new oIX0oI(this.f33313Oxx0IOOO, 2002);
                        this.f33312II0xO0.setLength(0);
                    }
                } else {
                    oxx0IOOO = new Oxx0IOOO(this.f33313Oxx0IOOO, oxoX());
                    this.f33312II0xO0.setLength(0);
                }
                i0Io = oxx0IOOO;
            } else {
                i0Io = new XO(this, this.f33313Oxx0IOOO, 1004);
                this.f33312II0xO0.setLength(0);
            }
        } else {
            i0Io = new I0Io(this, this.f33313Oxx0IOOO, X0o0xo());
            this.f33312II0xO0.setLength(0);
        }
        oIX0oI(i0Io);
    }

    public void oIX0oI(ooOOo0oXI ooooo0oxi) {
        this.f33312II0xO0.setLength(0);
        II0xO0(ooooo0oxi);
        this.f33316oIX0oI = 0;
        this.f33313Oxx0IOOO.II0xO0();
    }

    public String oxoX() {
        int indexOf;
        int i;
        int i2 = this.f33317oxoX;
        if (i2 < this.f33310I0Io && this.f33311II0XooXoX.charAt(i2) == '{' && (indexOf = this.f33311II0XooXoX.indexOf(125, this.f33317oxoX)) > (i = this.f33317oxoX)) {
            String substring = this.f33311II0XooXoX.substring(i + 1, indexOf);
            this.f33317oxoX = indexOf + 1;
            return substring;
        }
        return null;
    }
}
