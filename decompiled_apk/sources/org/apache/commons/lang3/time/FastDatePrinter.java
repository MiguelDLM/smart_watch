package org.apache.commons.lang3.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes6.dex */
public class FastDatePrinter implements org.apache.commons.lang3.time.oxoX, Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    private static final int MAX_DIGITS = 10;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final ConcurrentMap<xxIXOIIO, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient XO[] mRules;
    private final TimeZone mTimeZone;

    /* loaded from: classes6.dex */
    public static class I0Io implements XO {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final int f32855oIX0oI;

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final I0Io f32853II0xO0 = new I0Io(3);

        /* renamed from: I0Io, reason: collision with root package name */
        public static final I0Io f32852I0Io = new I0Io(5);

        /* renamed from: oxoX, reason: collision with root package name */
        public static final I0Io f32854oxoX = new I0Io(6);

        public I0Io(int i) {
            this.f32855oIX0oI = i;
        }

        public static I0Io oxoX(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return f32854oxoX;
                    }
                    throw new IllegalArgumentException("invalid number of X");
                }
                return f32852I0Io;
            }
            return f32853II0xO0;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(15) + calendar.get(16);
            if (i == 0) {
                appendable.append("Z");
                return;
            }
            if (i < 0) {
                appendable.append('-');
                i = -i;
            } else {
                appendable.append('+');
            }
            int i2 = i / 3600000;
            FastDatePrinter.appendDigits(appendable, i2);
            int i3 = this.f32855oIX0oI;
            if (i3 < 5) {
                return;
            }
            if (i3 == 6) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i / 60000) - (i2 * 60));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return this.f32855oIX0oI;
        }
    }

    /* loaded from: classes6.dex */
    public static class II0XooXoX implements XO {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final String[] f32856II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final int f32857oIX0oI;

        public II0XooXoX(int i, String[] strArr) {
            this.f32857oIX0oI = i;
            this.f32856II0xO0 = strArr;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.f32856II0xO0[calendar.get(this.f32857oIX0oI)]);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            int length = this.f32856II0xO0.length;
            int i = 0;
            while (true) {
                length--;
                if (length >= 0) {
                    int length2 = this.f32856II0xO0[length].length();
                    if (length2 > i) {
                        i = length2;
                    }
                } else {
                    return i;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class II0xO0 implements oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final oxoX f32858oIX0oI;

        public II0xO0(oxoX oxox) {
            this.f32858oIX0oI = oxox;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            int i = 7;
            int i2 = calendar.get(7);
            oxoX oxox = this.f32858oIX0oI;
            if (i2 != 1) {
                i = i2 - 1;
            }
            oxox.oIX0oI(appendable, i);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return this.f32858oIX0oI.II0xO0();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.oxoX
        public void oIX0oI(Appendable appendable, int i) throws IOException {
            this.f32858oIX0oI.oIX0oI(appendable, i);
        }
    }

    /* loaded from: classes6.dex */
    public static class IXxxXO implements oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final IXxxXO f32859oIX0oI = new IXxxXO();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            oIX0oI(appendable, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.oxoX
        public final void oIX0oI(Appendable appendable, int i) throws IOException {
            if (i >= 10) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                appendable.append((char) (i + 48));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class OOXIXo implements XO {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final boolean f32862oIX0oI;

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final OOXIXo f32861II0xO0 = new OOXIXo(true);

        /* renamed from: I0Io, reason: collision with root package name */
        public static final OOXIXo f32860I0Io = new OOXIXo(false);

        public OOXIXo(boolean z) {
            this.f32862oIX0oI = z;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(15) + calendar.get(16);
            if (i < 0) {
                appendable.append('-');
                i = -i;
            } else {
                appendable.append('+');
            }
            int i2 = i / 3600000;
            FastDatePrinter.appendDigits(appendable, i2);
            if (this.f32862oIX0oI) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i / 60000) - (i2 * 60));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return 5;
        }
    }

    /* loaded from: classes6.dex */
    public static class Oxx0IOOO implements XO {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final String f32863oIX0oI;

        public Oxx0IOOO(String str) {
            this.f32863oIX0oI = str;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.f32863oIX0oI);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return this.f32863oIX0oI.length();
        }
    }

    /* loaded from: classes6.dex */
    public static class Oxx0xo implements oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final int f32864oIX0oI;

        public Oxx0xo(int i) {
            this.f32864oIX0oI = i;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            oIX0oI(appendable, calendar.get(this.f32864oIX0oI));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return 4;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.oxoX
        public final void oIX0oI(Appendable appendable, int i) throws IOException {
            if (i < 10) {
                appendable.append((char) (i + 48));
            } else if (i < 100) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i, 1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class X0o0xo implements oxoX {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final int f32865II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final int f32866oIX0oI;

        public X0o0xo(int i, int i2) {
            if (i2 >= 3) {
                this.f32866oIX0oI = i;
                this.f32865II0xO0 = i2;
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            oIX0oI(appendable, calendar.get(this.f32866oIX0oI));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return this.f32865II0xO0;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.oxoX
        public final void oIX0oI(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendFullDigits(appendable, i, this.f32865II0xO0);
        }
    }

    /* loaded from: classes6.dex */
    public interface XO {
        void I0Io(Appendable appendable, Calendar calendar) throws IOException;

        int II0xO0();
    }

    /* loaded from: classes6.dex */
    public static class oI0IIXIo implements oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final oxoX f32867oIX0oI;

        public oI0IIXIo(oxoX oxox) {
            this.f32867oIX0oI = oxox;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            int weekYear;
            oxoX oxox = this.f32867oIX0oI;
            weekYear = calendar.getWeekYear();
            oxox.oIX0oI(appendable, weekYear);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return this.f32867oIX0oI.II0xO0();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.oxoX
        public void oIX0oI(Appendable appendable, int i) throws IOException {
            this.f32867oIX0oI.oIX0oI(appendable, i);
        }
    }

    /* loaded from: classes6.dex */
    public static class oIX0oI implements XO {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final char f32868oIX0oI;

        public oIX0oI(char c) {
            this.f32868oIX0oI = c;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.f32868oIX0oI);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return 1;
        }
    }

    /* loaded from: classes6.dex */
    public static class oO implements oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final int f32869oIX0oI;

        public oO(int i) {
            this.f32869oIX0oI = i;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            oIX0oI(appendable, calendar.get(this.f32869oIX0oI));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.oxoX
        public final void oIX0oI(Appendable appendable, int i) throws IOException {
            if (i < 100) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i, 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class oOoXoXO implements oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final oxoX f32870oIX0oI;

        public oOoXoXO(oxoX oxox) {
            this.f32870oIX0oI = oxox;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(10);
            if (i == 0) {
                i = calendar.getLeastMaximum(10) + 1;
            }
            this.f32870oIX0oI.oIX0oI(appendable, i);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return this.f32870oIX0oI.II0xO0();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.oxoX
        public void oIX0oI(Appendable appendable, int i) throws IOException {
            this.f32870oIX0oI.oIX0oI(appendable, i);
        }
    }

    /* loaded from: classes6.dex */
    public static class ooOOo0oXI implements oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final oxoX f32871oIX0oI;

        public ooOOo0oXI(oxoX oxox) {
            this.f32871oIX0oI = oxox;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(11);
            if (i == 0) {
                i = calendar.getMaximum(11) + 1;
            }
            this.f32871oIX0oI.oIX0oI(appendable, i);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return this.f32871oIX0oI.II0xO0();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.oxoX
        public void oIX0oI(Appendable appendable, int i) throws IOException {
            this.f32871oIX0oI.oIX0oI(appendable, i);
        }
    }

    /* loaded from: classes6.dex */
    public interface oxoX extends XO {
        void oIX0oI(Appendable appendable, int i) throws IOException;
    }

    /* loaded from: classes6.dex */
    public static class x0XOIxOo implements oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final x0XOIxOo f32872oIX0oI = new x0XOIxOo();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            oIX0oI(appendable, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.oxoX
        public final void oIX0oI(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendDigits(appendable, i);
        }
    }

    /* loaded from: classes6.dex */
    public static class x0xO0oo implements oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final x0xO0oo f32873oIX0oI = new x0xO0oo();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            oIX0oI(appendable, calendar.get(1) % 100);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.oxoX
        public final void oIX0oI(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendDigits(appendable, i);
        }
    }

    /* loaded from: classes6.dex */
    public static class xoIox implements XO {

        /* renamed from: I0Io, reason: collision with root package name */
        public final String f32874I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final int f32875II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final Locale f32876oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final String f32877oxoX;

        public xoIox(TimeZone timeZone, Locale locale, int i) {
            this.f32876oIX0oI = locale;
            this.f32875II0xO0 = i;
            this.f32874I0Io = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i, locale);
            this.f32877oxoX = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i, locale);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public void I0Io(Appendable appendable, Calendar calendar) throws IOException {
            TimeZone timeZone = calendar.getTimeZone();
            if (calendar.get(16) == 0) {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, false, this.f32875II0xO0, this.f32876oIX0oI));
            } else {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, true, this.f32875II0xO0, this.f32876oIX0oI));
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.XO
        public int II0xO0() {
            return Math.max(this.f32874I0Io.length(), this.f32877oxoX.length());
        }
    }

    /* loaded from: classes6.dex */
    public static class xxIXOIIO {

        /* renamed from: I0Io, reason: collision with root package name */
        public final Locale f32878I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final int f32879II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final TimeZone f32880oIX0oI;

        public xxIXOIIO(TimeZone timeZone, boolean z, int i, Locale locale) {
            this.f32880oIX0oI = timeZone;
            if (z) {
                this.f32879II0xO0 = Integer.MIN_VALUE | i;
            } else {
                this.f32879II0xO0 = i;
            }
            this.f32878I0Io = locale;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof xxIXOIIO)) {
                return false;
            }
            xxIXOIIO xxixoiio = (xxIXOIIO) obj;
            if (this.f32880oIX0oI.equals(xxixoiio.f32880oIX0oI) && this.f32879II0xO0 == xxixoiio.f32879II0xO0 && this.f32878I0Io.equals(xxixoiio.f32878I0Io)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f32879II0xO0 * 31) + this.f32878I0Io.hashCode()) * 31) + this.f32880oIX0oI.hashCode();
        }
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendDigits(Appendable appendable, int i) throws IOException {
        appendable.append((char) ((i / 10) + 48));
        appendable.append((char) ((i % 10) + 48));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendFullDigits(Appendable appendable, int i, int i2) throws IOException {
        int i3;
        if (i < 10000) {
            if (i < 1000) {
                if (i < 100) {
                    if (i < 10) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                } else {
                    i3 = 3;
                }
            } else {
                i3 = 4;
            }
            for (int i4 = i2 - i3; i4 > 0; i4--) {
                appendable.append('0');
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            appendable.append((char) ((i / 1000) + 48));
                            i %= 1000;
                        } else {
                            return;
                        }
                    }
                    if (i >= 100) {
                        appendable.append((char) ((i / 100) + 48));
                        i %= 100;
                    } else {
                        appendable.append('0');
                    }
                }
                if (i >= 10) {
                    appendable.append((char) ((i / 10) + 48));
                    i %= 10;
                } else {
                    appendable.append('0');
                }
            }
            appendable.append((char) (i + 48));
            return;
        }
        char[] cArr = new char[10];
        int i5 = 0;
        while (i != 0) {
            cArr[i5] = (char) ((i % 10) + 48);
            i /= 10;
            i5++;
        }
        while (i5 < i2) {
            appendable.append('0');
            i2--;
        }
        while (true) {
            i5--;
            if (i5 >= 0) {
                appendable.append(cArr[i5]);
            } else {
                return;
            }
        }
    }

    private String applyRulesToString(Calendar calendar) {
        return ((StringBuilder) applyRules(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    public static String getTimeZoneDisplay(TimeZone timeZone, boolean z, int i, Locale locale) {
        xxIXOIIO xxixoiio = new xxIXOIIO(timeZone, z, i, locale);
        ConcurrentMap<xxIXOIIO, String> concurrentMap = cTimeZoneDisplayCache;
        String str = concurrentMap.get(xxixoiio);
        if (str == null) {
            String displayName = timeZone.getDisplayName(z, i, locale);
            String putIfAbsent = concurrentMap.putIfAbsent(xxixoiio, displayName);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
            return displayName;
        }
        return str;
    }

    private void init() {
        int i = 0;
        XO[] xoArr = (XO[]) parsePattern().toArray(new XO[0]);
        this.mRules = xoArr;
        int length = xoArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.mRules[length].II0xO0();
            } else {
                this.mMaxLengthEstimate = i;
                return;
            }
        }
    }

    private Calendar newCalendar() {
        return Calendar.getInstance(this.mTimeZone, this.mLocale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    @Deprecated
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return (StringBuffer) applyRules(calendar, (Calendar) stringBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        if (!this.mPattern.equals(fastDatePrinter.mPattern) || !this.mTimeZone.equals(fastDatePrinter.mTimeZone) || !this.mLocale.equals(fastDatePrinter.mLocale)) {
            return false;
        }
        return true;
    }

    @Override // org.apache.commons.lang3.time.oxoX
    @Deprecated
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        sb.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public String getPattern() {
        return this.mPattern;
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0053. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0056. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0059. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [org.apache.commons.lang3.time.FastDatePrinter$xoIox] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v5, types: [org.apache.commons.lang3.time.FastDatePrinter$oxoX] */
    /* JADX WARN: Type inference failed for: r11v53 */
    /* JADX WARN: Type inference failed for: r11v54 */
    /* JADX WARN: Type inference failed for: r11v55 */
    /* JADX WARN: Type inference failed for: r11v56 */
    /* JADX WARN: Type inference failed for: r11v57 */
    /* JADX WARN: Type inference failed for: r11v58 */
    /* JADX WARN: Type inference failed for: r11v59 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v60 */
    /* JADX WARN: Type inference failed for: r11v61 */
    /* JADX WARN: Type inference failed for: r11v62 */
    /* JADX WARN: Type inference failed for: r11v63 */
    /* JADX WARN: Type inference failed for: r11v64 */
    /* JADX WARN: Type inference failed for: r11v65 */
    /* JADX WARN: Type inference failed for: r11v66 */
    /* JADX WARN: Type inference failed for: r11v67 */
    /* JADX WARN: Type inference failed for: r11v68 */
    /* JADX WARN: Type inference failed for: r11v69 */
    /* JADX WARN: Type inference failed for: r11v70 */
    /* JADX WARN: Type inference failed for: r11v71 */
    /* JADX WARN: Type inference failed for: r11v72 */
    /* JADX WARN: Type inference failed for: r11v73 */
    /* JADX WARN: Type inference failed for: r11v74 */
    /* JADX WARN: Type inference failed for: r11v75 */
    /* JADX WARN: Type inference failed for: r11v76 */
    /* JADX WARN: Type inference failed for: r11v77 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.Object] */
    public List<XO> parsePattern() {
        ?? r11;
        XO oxx0IOOO;
        XO iI0xO0;
        String[] strArr;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            int[] iArr = {i2};
            String parseToken = parseToken(this.mPattern, iArr);
            int i3 = iArr[i];
            int length2 = parseToken.length();
            if (length2 != 0) {
                char charAt = parseToken.charAt(i);
                if (charAt != 'y') {
                    if (charAt != 'z') {
                        switch (charAt) {
                            case '\'':
                                String substring = parseToken.substring(1);
                                if (substring.length() == 1) {
                                    oxx0IOOO = new oIX0oI(substring.charAt(0));
                                } else {
                                    oxx0IOOO = new Oxx0IOOO(substring);
                                }
                                r11 = oxx0IOOO;
                                break;
                            case 'K':
                                r11 = selectNumberRule(10, length2);
                                break;
                            case 'M':
                                if (length2 >= 4) {
                                    r11 = new II0XooXoX(2, months);
                                    break;
                                } else if (length2 == 3) {
                                    r11 = new II0XooXoX(2, shortMonths);
                                    break;
                                } else if (length2 == 2) {
                                    r11 = x0XOIxOo.f32872oIX0oI;
                                    break;
                                } else {
                                    r11 = IXxxXO.f32859oIX0oI;
                                    break;
                                }
                            case 'S':
                                r11 = selectNumberRule(14, length2);
                                break;
                            case 'a':
                                r11 = new II0XooXoX(9, amPmStrings);
                                break;
                            case 'd':
                                r11 = selectNumberRule(5, length2);
                                break;
                            case 'h':
                                r11 = new oOoXoXO(selectNumberRule(10, length2));
                                break;
                            case 'k':
                                r11 = new ooOOo0oXI(selectNumberRule(11, length2));
                                break;
                            case 'm':
                                r11 = selectNumberRule(12, length2);
                                break;
                            case 's':
                                r11 = selectNumberRule(13, length2);
                                break;
                            case 'u':
                                iI0xO0 = new II0xO0(selectNumberRule(7, length2));
                                r11 = iI0xO0;
                                break;
                            case 'w':
                                r11 = selectNumberRule(3, length2);
                                break;
                            default:
                                switch (charAt) {
                                    case 'D':
                                        r11 = selectNumberRule(6, length2);
                                        break;
                                    case 'E':
                                        if (length2 < 4) {
                                            strArr = shortWeekdays;
                                        } else {
                                            strArr = weekdays;
                                        }
                                        iI0xO0 = new II0XooXoX(7, strArr);
                                        r11 = iI0xO0;
                                        break;
                                    case 'F':
                                        r11 = selectNumberRule(8, length2);
                                        break;
                                    case 'G':
                                        r11 = new II0XooXoX(0, eras);
                                        break;
                                    case 'H':
                                        r11 = selectNumberRule(11, length2);
                                        break;
                                    default:
                                        switch (charAt) {
                                            case 'W':
                                                r11 = selectNumberRule(4, length2);
                                                break;
                                            case 'X':
                                                r11 = I0Io.oxoX(length2);
                                                break;
                                            case 'Y':
                                                break;
                                            case 'Z':
                                                if (length2 == 1) {
                                                    r11 = OOXIXo.f32860I0Io;
                                                    break;
                                                } else if (length2 == 2) {
                                                    r11 = I0Io.f32854oxoX;
                                                    break;
                                                } else {
                                                    r11 = OOXIXo.f32861II0xO0;
                                                    break;
                                                }
                                            default:
                                                throw new IllegalArgumentException("Illegal pattern component: " + parseToken);
                                        }
                                }
                        }
                    } else if (length2 >= 4) {
                        r11 = new xoIox(this.mTimeZone, this.mLocale, 1);
                    } else {
                        r11 = new xoIox(this.mTimeZone, this.mLocale, 0);
                        arrayList.add(r11);
                        i2 = i3 + 1;
                        i = 0;
                    }
                    arrayList.add(r11);
                    i2 = i3 + 1;
                    i = 0;
                }
                if (length2 == 2) {
                    r11 = x0xO0oo.f32873oIX0oI;
                } else {
                    r11 = selectNumberRule(1, Math.max(length2, 4));
                }
                if (charAt == 'Y') {
                    r11 = new oI0IIXIo(r11);
                }
                arrayList.add(r11);
                i2 = i3 + 1;
                i = 0;
            } else {
                return arrayList;
            }
        }
        return arrayList;
    }

    public String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb.append(charAt);
            while (true) {
                int i2 = i + 1;
                if (i2 >= length || str.charAt(i2) != charAt) {
                    break;
                }
                sb.append(charAt);
                i = i2;
            }
        } else {
            sb.append('\'');
            boolean z = false;
            while (i < length) {
                char charAt2 = str.charAt(i);
                if (charAt2 == '\'') {
                    int i3 = i + 1;
                    if (i3 < length && str.charAt(i3) == '\'') {
                        sb.append(charAt2);
                        i = i3;
                    } else {
                        z = !z;
                    }
                } else {
                    if (!z && ((charAt2 >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
                        i--;
                        break;
                    }
                    sb.append(charAt2);
                }
                i++;
            }
        }
        iArr[0] = i;
        return sb.toString();
    }

    public oxoX selectNumberRule(int i, int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return new X0o0xo(i, i2);
            }
            return new oO(i);
        }
        return new Oxx0xo(i);
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
    }

    private <B extends Appendable> B applyRules(Calendar calendar, B b) {
        try {
            for (XO xo2 : this.mRules) {
                xo2.I0Io(b, calendar);
            }
        } catch (IOException e) {
            IO0xX.I0Io.O0xOxO(e);
        }
        return b;
    }

    public String format(Object obj) {
        if (obj instanceof Date) {
            return format((Date) obj);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        sb.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public String format(long j) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return applyRulesToString(newCalendar);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public String format(Date date) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRulesToString(newCalendar);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public String format(Calendar calendar) {
        return ((StringBuilder) format(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public StringBuffer format(long j, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return (StringBuffer) applyRules(newCalendar, (Calendar) stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return (StringBuffer) applyRules(newCalendar, (Calendar) stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return format(calendar.getTime(), stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public <B extends Appendable> B format(long j, B b) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return (B) applyRules(newCalendar, (Calendar) b);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public <B extends Appendable> B format(Date date, B b) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return (B) applyRules(newCalendar, (Calendar) b);
    }

    @Override // org.apache.commons.lang3.time.oxoX
    public <B extends Appendable> B format(Calendar calendar, B b) {
        if (!calendar.getTimeZone().equals(this.mTimeZone)) {
            calendar = (Calendar) calendar.clone();
            calendar.setTimeZone(this.mTimeZone);
        }
        return (B) applyRules(calendar, (Calendar) b);
    }
}
