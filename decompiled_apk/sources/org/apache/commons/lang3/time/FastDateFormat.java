package org.apache.commons.lang3.time;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public class FastDateFormat extends Format implements I0Io, oxoX {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final xxIXOIIO<FastDateFormat> cache = new oIX0oI();
    private static final long serialVersionUID = 2;
    private final FastDateParser parser;
    private final FastDatePrinter printer;

    /* loaded from: classes6.dex */
    public static class oIX0oI extends xxIXOIIO<FastDateFormat> {
        @Override // org.apache.commons.lang3.time.xxIXOIIO
        /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
        public FastDateFormat oIX0oI(String str, TimeZone timeZone, Locale locale) {
            return new FastDateFormat(str, timeZone, locale);
        }
    }

    public FastDateFormat(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, null);
    }

    public static FastDateFormat getDateInstance(int i) {
        return cache.II0xO0(i, null, null);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2) {
        return cache.I0Io(i, i2, null, null);
    }

    public static FastDateFormat getInstance() {
        return cache.X0o0xo();
    }

    public static FastDateFormat getTimeInstance(int i) {
        return cache.II0XooXoX(i, null, null);
    }

    @Deprecated
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.applyRules(calendar, stringBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateFormat)) {
            return false;
        }
        return this.printer.equals(((FastDateFormat) obj).printer);
    }

    @Override // java.text.Format, org.apache.commons.lang3.time.oxoX
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        stringBuffer.append(this.printer.format(obj));
        return stringBuffer;
    }

    @Override // org.apache.commons.lang3.time.I0Io, org.apache.commons.lang3.time.oxoX
    public Locale getLocale() {
        return this.printer.getLocale();
    }

    public int getMaxLengthEstimate() {
        return this.printer.getMaxLengthEstimate();
    }

    @Override // org.apache.commons.lang3.time.I0Io, org.apache.commons.lang3.time.oxoX
    public String getPattern() {
        return this.printer.getPattern();
    }

    @Override // org.apache.commons.lang3.time.I0Io, org.apache.commons.lang3.time.oxoX
    public TimeZone getTimeZone() {
        return this.printer.getTimeZone();
    }

    public int hashCode() {
        return this.printer.hashCode();
    }

    @Override // org.apache.commons.lang3.time.I0Io
    public Date parse(String str) throws ParseException {
        return this.parser.parse(str);
    }

    @Override // java.text.Format, org.apache.commons.lang3.time.I0Io
    public Object parseObject(String str, ParsePosition parsePosition) {
        return this.parser.parseObject(str, parsePosition);
    }

    public String toString() {
        return "FastDateFormat[" + this.printer.getPattern() + "," + this.printer.getLocale() + "," + this.printer.getTimeZone().getID() + "]";
    }

    public FastDateFormat(String str, TimeZone timeZone, Locale locale, Date date) {
        this.printer = new FastDatePrinter(str, timeZone, locale);
        this.parser = new FastDateParser(str, timeZone, locale, date);
    }

    public static FastDateFormat getDateInstance(int i, Locale locale) {
        return cache.II0xO0(i, null, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2, Locale locale) {
        return cache.I0Io(i, i2, null, locale);
    }

    public static FastDateFormat getInstance(String str) {
        return cache.XO(str, null, null);
    }

    public static FastDateFormat getTimeInstance(int i, Locale locale) {
        return cache.II0XooXoX(i, null, locale);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public String format(long j) {
        return this.printer.format(j);
    }

    @Override // org.apache.commons.lang3.time.I0Io
    public Date parse(String str, ParsePosition parsePosition) {
        return this.parser.parse(str, parsePosition);
    }

    public static FastDateFormat getDateInstance(int i, TimeZone timeZone) {
        return cache.II0xO0(i, timeZone, null);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2, TimeZone timeZone) {
        return getDateTimeInstance(i, i2, timeZone, null);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone) {
        return cache.XO(str, timeZone, null);
    }

    public static FastDateFormat getTimeInstance(int i, TimeZone timeZone) {
        return cache.II0XooXoX(i, timeZone, null);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public String format(Date date) {
        return this.printer.format(date);
    }

    @Override // org.apache.commons.lang3.time.I0Io
    public boolean parse(String str, ParsePosition parsePosition, Calendar calendar) {
        return this.parser.parse(str, parsePosition, calendar);
    }

    public static FastDateFormat getDateInstance(int i, TimeZone timeZone, Locale locale) {
        return cache.II0xO0(i, timeZone, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2, TimeZone timeZone, Locale locale) {
        return cache.I0Io(i, i2, timeZone, locale);
    }

    public static FastDateFormat getInstance(String str, Locale locale) {
        return cache.XO(str, null, locale);
    }

    public static FastDateFormat getTimeInstance(int i, TimeZone timeZone, Locale locale) {
        return cache.II0XooXoX(i, timeZone, locale);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public String format(Calendar calendar) {
        return this.printer.format(calendar);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone, Locale locale) {
        return cache.XO(str, timeZone, locale);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    @Deprecated
    public StringBuffer format(long j, StringBuffer stringBuffer) {
        return this.printer.format(j, stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    @Deprecated
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        return this.printer.format(date, stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    @Deprecated
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.format(calendar, stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public <B extends Appendable> B format(long j, B b) {
        return (B) this.printer.format(j, (long) b);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public <B extends Appendable> B format(Date date, B b) {
        return (B) this.printer.format(date, (Date) b);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public <B extends Appendable> B format(Calendar calendar, B b) {
        return (B) this.printer.format(calendar, (Calendar) b);
    }
}
