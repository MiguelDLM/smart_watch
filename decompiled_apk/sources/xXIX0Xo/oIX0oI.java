package xXIX0Xo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f34664I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Locale f34665II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public TimeZone f34666oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public DateFormat f34667oxoX;

    public oIX0oI() {
        this.f34666oIX0oI = null;
        this.f34665II0xO0 = null;
        this.f34664I0Io = null;
        this.f34667oxoX = null;
        oIX0oI();
    }

    public String I0Io(Date date, String str) {
        DateFormat oxoX2 = oxoX();
        boolean z = oxoX2 instanceof SimpleDateFormat;
        DateFormat dateFormat = oxoX2;
        if (z) {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) oxoX2.clone();
            simpleDateFormat.applyPattern(str);
            dateFormat = simpleDateFormat;
        }
        return dateFormat.format(date);
    }

    public synchronized TimeZone II0XooXoX() {
        TimeZone timeZone = this.f34666oIX0oI;
        if (timeZone == null) {
            return TimeZone.getDefault();
        }
        return timeZone;
    }

    public String II0xO0(Date date) {
        return oxoX().format(date);
    }

    public synchronized void OOXIXo(DateFormat dateFormat) {
        this.f34667oxoX = dateFormat;
    }

    public synchronized String Oxx0IOOO() {
        return this.f34664I0Io;
    }

    public synchronized Locale X0o0xo() {
        Locale locale = this.f34665II0xO0;
        if (locale == null) {
            return Locale.getDefault();
        }
        return locale;
    }

    public synchronized String XO() {
        return this.f34664I0Io;
    }

    public final synchronized void oIX0oI() {
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(0, 0, X0o0xo());
        this.f34667oxoX = dateTimeInstance;
        dateTimeInstance.setTimeZone(II0XooXoX());
        String str = this.f34664I0Io;
        if (str != null) {
            ((SimpleDateFormat) this.f34667oxoX).applyPattern(str);
        }
    }

    public synchronized void oO(TimeZone timeZone) {
        this.f34666oIX0oI = timeZone;
        oIX0oI();
    }

    public synchronized void oOoXoXO(Locale locale) {
        this.f34665II0xO0 = locale;
        oIX0oI();
    }

    public synchronized void ooOOo0oXI(String str) {
        this.f34664I0Io = str;
        oIX0oI();
    }

    public synchronized DateFormat oxoX() {
        return this.f34667oxoX;
    }

    public synchronized void x0XOIxOo(String str) {
        this.f34664I0Io = str;
        oIX0oI();
    }

    public Date xoIox(String str, String str2) throws ParseException {
        DateFormat oxoX2 = oxoX();
        boolean z = oxoX2 instanceof SimpleDateFormat;
        DateFormat dateFormat = oxoX2;
        if (z) {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) oxoX2.clone();
            simpleDateFormat.applyPattern(str2);
            dateFormat = simpleDateFormat;
        }
        return dateFormat.parse(str);
    }

    public Date xxIXOIIO(String str) throws ParseException {
        return oxoX().parse(str);
    }

    public oIX0oI(TimeZone timeZone) {
        this.f34665II0xO0 = null;
        this.f34664I0Io = null;
        this.f34667oxoX = null;
        this.f34666oIX0oI = timeZone;
        oIX0oI();
    }

    public oIX0oI(Locale locale) {
        this.f34666oIX0oI = null;
        this.f34664I0Io = null;
        this.f34667oxoX = null;
        this.f34665II0xO0 = locale;
        oIX0oI();
    }

    public oIX0oI(String str) {
        this.f34666oIX0oI = null;
        this.f34665II0xO0 = null;
        this.f34667oxoX = null;
        this.f34664I0Io = str;
        oIX0oI();
    }

    public oIX0oI(TimeZone timeZone, Locale locale) {
        this.f34664I0Io = null;
        this.f34667oxoX = null;
        this.f34666oIX0oI = timeZone;
        this.f34665II0xO0 = locale;
        oIX0oI();
    }

    public oIX0oI(TimeZone timeZone, String str) {
        this.f34665II0xO0 = null;
        this.f34667oxoX = null;
        this.f34666oIX0oI = timeZone;
        this.f34664I0Io = str;
        oIX0oI();
    }

    public oIX0oI(Locale locale, String str) {
        this.f34666oIX0oI = null;
        this.f34667oxoX = null;
        this.f34665II0xO0 = locale;
        this.f34664I0Io = str;
        oIX0oI();
    }

    public oIX0oI(TimeZone timeZone, Locale locale, String str) {
        this.f34667oxoX = null;
        this.f34666oIX0oI = timeZone;
        this.f34665II0xO0 = locale;
        this.f34664I0Io = str;
        oIX0oI();
    }
}
