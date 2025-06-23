package org.apache.log4j;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class II0XooXoX extends OOXIXo {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f33141IIXOooo = -1;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f33142O0xOxO = 3;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f33143OxI = 2;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f33144X0IIOO = 4;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f33145XI0IXoo = 5;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final TimeZone f33146XIxXXX0x0 = TimeZone.getTimeZone(org.apache.commons.lang3.time.xoIox.f32917oIX0oI);

    /* renamed from: o00, reason: collision with root package name */
    public static final int f33147o00 = 1;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f33148xoXoI = 0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Date f33149IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public long f33150Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public SimpleDateFormat f33151Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f33152OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public RollingCalendar f33153oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public String f33154oO;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public String f33155x0xO0oo;

    public II0XooXoX() {
        this.f33154oO = "'.'yyyy-MM-dd";
        this.f33150Oo = System.currentTimeMillis() - 1;
        this.f33149IXxxXO = new Date();
        this.f33153oI0IIXIo = new RollingCalendar();
        this.f33152OxxIIOOXO = -1;
    }

    public int I0oOoX() {
        RollingCalendar rollingCalendar = new RollingCalendar(f33146XIxXXX0x0, Locale.ENGLISH);
        Date date = new Date(0L);
        if (this.f33154oO != null) {
            for (int i = 0; i <= 5; i++) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f33154oO);
                simpleDateFormat.setTimeZone(f33146XIxXXX0x0);
                String format = simpleDateFormat.format(date);
                rollingCalendar.setType(i);
                String format2 = simpleDateFormat.format(new Date(rollingCalendar.getNextCheckMillis(date)));
                if (format != null && format2 != null && !format.equals(format2)) {
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }

    public void XoX(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("Unknown periodicity for appender [");
                                stringBuffer.append(this.f33157II0xO0);
                                stringBuffer.append("].");
                                org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO(stringBuffer.toString());
                                return;
                            }
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("Appender [");
                            stringBuffer2.append(this.f33157II0xO0);
                            stringBuffer2.append("] to be rolled at start of every month.");
                            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer2.toString());
                            return;
                        }
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append("Appender [");
                        stringBuffer3.append(this.f33157II0xO0);
                        stringBuffer3.append("] to be rolled at start of week.");
                        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer3.toString());
                        return;
                    }
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("Appender [");
                    stringBuffer4.append(this.f33157II0xO0);
                    stringBuffer4.append("] to be rolled at midnight.");
                    org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer4.toString());
                    return;
                }
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("Appender [");
                stringBuffer5.append(this.f33157II0xO0);
                stringBuffer5.append("] to be rolled at midday and midnight.");
                org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer5.toString());
                return;
            }
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("Appender [");
            stringBuffer6.append(this.f33157II0xO0);
            stringBuffer6.append("] to be rolled on top of every hour.");
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer6.toString());
            return;
        }
        StringBuffer stringBuffer7 = new StringBuffer();
        stringBuffer7.append("Appender [");
        stringBuffer7.append(this.f33157II0xO0);
        stringBuffer7.append("] to be rolled every minute.");
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer7.toString());
    }

    @Override // org.apache.log4j.OOXIXo, org.apache.log4j.X0IIOO, org.apache.log4j.II0xO0, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
        super.oI0IIXIo();
        if (this.f33154oO != null && this.f33188oOoXoXO != null) {
            this.f33149IXxxXO.setTime(System.currentTimeMillis());
            this.f33151Oxx0xo = new SimpleDateFormat(this.f33154oO);
            int I0oOoX2 = I0oOoX();
            XoX(I0oOoX2);
            this.f33153oI0IIXIo.setType(I0oOoX2);
            File file = new File(this.f33188oOoXoXO);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f33188oOoXoXO);
            stringBuffer.append(this.f33151Oxx0xo.format(new Date(file.lastModified())));
            this.f33155x0xO0oo = stringBuffer.toString();
            return;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Either File or DatePattern options are not set for appender [");
        stringBuffer2.append(this.f33157II0xO0);
        stringBuffer2.append("].");
        org.apache.log4j.helpers.xxIXOIIO.I0Io(stringBuffer2.toString());
    }

    @Override // org.apache.log4j.X0IIOO
    public void oo0xXOI0I(LoggingEvent loggingEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= this.f33150Oo) {
            this.f33149IXxxXO.setTime(currentTimeMillis);
            this.f33150Oo = this.f33153oI0IIXIo.getNextCheckMillis(this.f33149IXxxXO);
            try {
                oxXx0IX();
            } catch (IOException e) {
                org.apache.log4j.helpers.xxIXOIIO.oxoX("rollOver() failed.", e);
            }
        }
        super.oo0xXOI0I(loggingEvent);
    }

    public void oxXx0IX() throws IOException {
        if (this.f33154oO == null) {
            this.f33162oxoX.error("Missing DatePattern option in rollOver().");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f33188oOoXoXO);
        stringBuffer.append(this.f33151Oxx0xo.format(this.f33149IXxxXO));
        String stringBuffer2 = stringBuffer.toString();
        if (this.f33155x0xO0oo.equals(stringBuffer2)) {
            return;
        }
        oOXoIIIo();
        File file = new File(this.f33155x0xO0oo);
        if (file.exists()) {
            file.delete();
        }
        if (new File(this.f33188oOoXoXO).renameTo(file)) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(this.f33188oOoXoXO);
            stringBuffer3.append(org.apache.commons.text.oIX0oI.f33048oxoX);
            stringBuffer3.append(this.f33155x0xO0oo);
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer3.toString());
        } else {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Failed to rename [");
            stringBuffer4.append(this.f33188oOoXoXO);
            stringBuffer4.append("] to [");
            stringBuffer4.append(this.f33155x0xO0oo);
            stringBuffer4.append("].");
            org.apache.log4j.helpers.xxIXOIIO.I0Io(stringBuffer4.toString());
        }
        try {
            o0(this.f33188oOoXoXO, false, this.f33189ooOOo0oXI, this.f33190x0XOIxOo);
        } catch (IOException unused) {
            org.apache.log4j.spi.X0o0xo x0o0xo = this.f33162oxoX;
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("setFile(");
            stringBuffer5.append(this.f33188oOoXoXO);
            stringBuffer5.append(", false) call failed.");
            x0o0xo.error(stringBuffer5.toString());
        }
        this.f33155x0xO0oo = stringBuffer2;
    }

    public String oxxXoxO() {
        return this.f33154oO;
    }

    public void xo0x(String str) {
        this.f33154oO = str;
    }

    public II0XooXoX(x0XOIxOo x0xoixoo, String str, String str2) throws IOException {
        super(x0xoixoo, str, true);
        this.f33154oO = "'.'yyyy-MM-dd";
        this.f33150Oo = System.currentTimeMillis() - 1;
        this.f33149IXxxXO = new Date();
        this.f33153oI0IIXIo = new RollingCalendar();
        this.f33152OxxIIOOXO = -1;
        this.f33154oO = str2;
        oI0IIXIo();
    }
}
