package org.apache.log4j.helpers;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public abstract class X0o0xo extends org.apache.log4j.x0XOIxOo {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f33252II0XooXoX = "NULL";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f33253OOXIXo = "TimeZone";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f33254xoIox = "DateFormat";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f33255xxIXOIIO = "RELATIVE";

    /* renamed from: I0Io, reason: collision with root package name */
    public FieldPosition f33256I0Io = new FieldPosition(0);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public Date f33257Oxx0IOOO = new Date();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f33258X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public DateFormat f33259XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f33260oxoX;

    public void II0XooXoX(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
        if (this.f33259XO != null) {
            this.f33257Oxx0IOOO.setTime(loggingEvent.timeStamp);
            this.f33259XO.format(this.f33257Oxx0IOOO, stringBuffer, this.f33256I0Io);
            stringBuffer.append(TokenParser.SP);
        }
    }

    public String OOXIXo() {
        return this.f33260oxoX;
    }

    @Override // org.apache.log4j.x0XOIxOo, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
        DateFormat dateFormat;
        oOoXoXO(this.f33258X0o0xo);
        String str = this.f33260oxoX;
        if (str != null && (dateFormat = this.f33259XO) != null) {
            dateFormat.setTimeZone(TimeZone.getTimeZone(str));
        }
    }

    public void oO(String str, String str2) {
        if (str.equalsIgnoreCase(f33254xoIox)) {
            this.f33258X0o0xo = str2.toUpperCase();
        } else if (str.equalsIgnoreCase(f33253OOXIXo)) {
            this.f33260oxoX = str2;
        }
    }

    public void oOoXoXO(String str) {
        if (str != null) {
            this.f33258X0o0xo = str;
        }
        ooOOo0oXI(this.f33258X0o0xo, TimeZone.getDefault());
    }

    public void ooOOo0oXI(String str, TimeZone timeZone) {
        if (str == null) {
            this.f33259XO = null;
            return;
        }
        if (str.equalsIgnoreCase(f33252II0XooXoX)) {
            this.f33259XO = null;
            return;
        }
        if (str.equalsIgnoreCase(f33255xxIXOIIO)) {
            this.f33259XO = new RelativeTimeDateFormat();
            return;
        }
        if (str.equalsIgnoreCase(AbsoluteTimeDateFormat.ABS_TIME_DATE_FORMAT)) {
            this.f33259XO = new AbsoluteTimeDateFormat(timeZone);
            return;
        }
        if (str.equalsIgnoreCase(AbsoluteTimeDateFormat.DATE_AND_TIME_DATE_FORMAT)) {
            this.f33259XO = new DateTimeDateFormat(timeZone);
        } else {
            if (str.equalsIgnoreCase(AbsoluteTimeDateFormat.ISO8601_DATE_FORMAT)) {
                this.f33259XO = new ISO8601DateFormat(timeZone);
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            this.f33259XO = simpleDateFormat;
            simpleDateFormat.setTimeZone(timeZone);
        }
    }

    public void x0XOIxOo(DateFormat dateFormat, TimeZone timeZone) {
        this.f33259XO = dateFormat;
        dateFormat.setTimeZone(timeZone);
    }

    public void x0xO0oo(String str) {
        this.f33260oxoX = str;
    }

    public String[] xoIox() {
        return new String[]{f33254xoIox, f33253OOXIXo};
    }

    public String xxIXOIIO() {
        return this.f33258X0o0xo;
    }
}
