package org.apache.commons.lang3.time;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    @Deprecated
    public static final FastDateFormat f32883I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @Deprecated
    public static final FastDateFormat f32884II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final FastDateFormat f32885II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final FastDateFormat f32886OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @Deprecated
    public static final FastDateFormat f32887Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @Deprecated
    public static final FastDateFormat f32888X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static final FastDateFormat f32889XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final TimeZone f32890oIX0oI = II0XooXoX.oIX0oI();

    /* renamed from: oO, reason: collision with root package name */
    public static final FastDateFormat f32891oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @Deprecated
    public static final FastDateFormat f32892oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final FastDateFormat f32893ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final FastDateFormat f32894oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @Deprecated
    public static final FastDateFormat f32895x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    @Deprecated
    public static final FastDateFormat f32896xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @Deprecated
    public static final FastDateFormat f32897xxIXOIIO;

    static {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance(com.sma.smartv3.util.xoIox.f24708oo);
        f32885II0xO0 = fastDateFormat;
        f32883I0Io = fastDateFormat;
        FastDateFormat fastDateFormat2 = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ssZZ");
        f32894oxoX = fastDateFormat2;
        f32888X0o0xo = fastDateFormat2;
        FastDateFormat fastDateFormat3 = FastDateFormat.getInstance("yyyy-MM-dd");
        f32889XO = fastDateFormat3;
        f32887Oxx0IOOO = fastDateFormat3;
        f32884II0XooXoX = FastDateFormat.getInstance("yyyy-MM-ddZZ");
        f32897xxIXOIIO = FastDateFormat.getInstance("'T'HH:mm:ss");
        f32896xoIox = FastDateFormat.getInstance("'T'HH:mm:ssZZ");
        FastDateFormat fastDateFormat4 = FastDateFormat.getInstance(com.sma.smartv3.util.xoIox.f24709oo0xXOI0I);
        f32886OOXIXo = fastDateFormat4;
        f32892oOoXoXO = fastDateFormat4;
        FastDateFormat fastDateFormat5 = FastDateFormat.getInstance("HH:mm:ssZZ");
        f32893ooOOo0oXI = fastDateFormat5;
        f32895x0XOIxOo = fastDateFormat5;
        f32891oO = FastDateFormat.getInstance("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
    }

    public static String I0Io(long j, String str, TimeZone timeZone) {
        return oOoXoXO(new Date(j), str, timeZone, null);
    }

    public static String II0XooXoX(Calendar calendar, String str, TimeZone timeZone, Locale locale) {
        return FastDateFormat.getInstance(str, timeZone, locale).format(calendar);
    }

    public static String II0xO0(long j, String str, Locale locale) {
        return oOoXoXO(new Date(j), str, null, locale);
    }

    public static String OOXIXo(Date date, String str, TimeZone timeZone) {
        return oOoXoXO(date, str, timeZone, null);
    }

    public static String Oxx0IOOO(Calendar calendar, String str, TimeZone timeZone) {
        return II0XooXoX(calendar, str, timeZone, null);
    }

    public static String X0o0xo(Calendar calendar, String str) {
        return II0XooXoX(calendar, str, null, null);
    }

    public static String XO(Calendar calendar, String str, Locale locale) {
        return II0XooXoX(calendar, str, null, locale);
    }

    public static String oIX0oI(long j, String str) {
        return oOoXoXO(new Date(j), str, null, null);
    }

    public static String oO(Date date, String str) {
        return oOoXoXO(date, str, f32890oIX0oI, null);
    }

    public static String oOoXoXO(Date date, String str, TimeZone timeZone, Locale locale) {
        return FastDateFormat.getInstance(str, timeZone, locale).format(date);
    }

    public static String ooOOo0oXI(long j, String str) {
        return oOoXoXO(new Date(j), str, f32890oIX0oI, null);
    }

    public static String oxoX(long j, String str, TimeZone timeZone, Locale locale) {
        return oOoXoXO(new Date(j), str, timeZone, locale);
    }

    public static String x0XOIxOo(long j, String str, Locale locale) {
        return oOoXoXO(new Date(j), str, f32890oIX0oI, locale);
    }

    public static String x0xO0oo(Date date, String str, Locale locale) {
        return oOoXoXO(date, str, f32890oIX0oI, locale);
    }

    public static String xoIox(Date date, String str, Locale locale) {
        return oOoXoXO(date, str, null, locale);
    }

    public static String xxIXOIIO(Date date, String str) {
        return oOoXoXO(date, str, null, null);
    }
}
