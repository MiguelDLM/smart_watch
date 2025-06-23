package org.apache.commons.lang3.time;

import XXO0.oIX0oI;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class FastDateParser implements org.apache.commons.lang3.time.I0Io, Serializable {
    private static final OOXIXo ABBREVIATED_YEAR_STRATEGY;
    private static final OOXIXo DAY_OF_MONTH_STRATEGY;
    private static final OOXIXo DAY_OF_WEEK_IN_MONTH_STRATEGY;
    private static final OOXIXo DAY_OF_WEEK_STRATEGY;
    private static final OOXIXo DAY_OF_YEAR_STRATEGY;
    private static final OOXIXo HOUR12_STRATEGY;
    private static final OOXIXo HOUR24_OF_DAY_STRATEGY;
    private static final OOXIXo HOUR_OF_DAY_STRATEGY;
    private static final OOXIXo HOUR_STRATEGY;
    static final Locale JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
    private static final OOXIXo LITERAL_YEAR_STRATEGY;
    private static final Comparator<String> LONGER_FIRST_LOWERCASE;
    private static final OOXIXo MILLISECOND_STRATEGY;
    private static final OOXIXo MINUTE_STRATEGY;
    private static final OOXIXo NUMBER_MONTH_STRATEGY;
    private static final OOXIXo SECOND_STRATEGY;
    private static final OOXIXo WEEK_OF_MONTH_STRATEGY;
    private static final OOXIXo WEEK_OF_YEAR_STRATEGY;
    private static final ConcurrentMap<Locale, OOXIXo>[] caches;
    private static final long serialVersionUID = 3;
    private final int century;
    private final Locale locale;
    private final String pattern;
    private transient List<oOoXoXO> patterns;
    private final int startYear;
    private final TimeZone timeZone;

    /* loaded from: classes6.dex */
    public static class I0Io extends xxIXOIIO {
        public I0Io(int i) {
            super(i);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.xxIXOIIO
        public int I0Io(FastDateParser fastDateParser, int i) {
            if (i == 7) {
                return 1;
            }
            return 1 + i;
        }
    }

    /* loaded from: classes6.dex */
    public static class II0XooXoX extends xoIox {

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final OOXIXo f32832II0xO0 = new II0XooXoX("(Z|(?:[+-]\\d{2}))");

        /* renamed from: I0Io, reason: collision with root package name */
        public static final OOXIXo f32831I0Io = new II0XooXoX("(Z|(?:[+-]\\d{2}\\d{2}))");

        /* renamed from: oxoX, reason: collision with root package name */
        public static final OOXIXo f32833oxoX = new II0XooXoX("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");

        public II0XooXoX(String str) {
            super(null);
            I0Io(str);
        }

        public static OOXIXo Oxx0IOOO(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return f32833oxoX;
                    }
                    throw new IllegalArgumentException("invalid number of X");
                }
                return f32831I0Io;
            }
            return f32832II0xO0;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.xoIox
        public void X0o0xo(FastDateParser fastDateParser, Calendar calendar, String str) {
            calendar.setTimeZone(org.apache.commons.lang3.time.II0XooXoX.II0xO0(str));
        }
    }

    /* loaded from: classes6.dex */
    public static class II0xO0 extends xxIXOIIO {
        public II0xO0(int i) {
            super(i);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.xxIXOIIO
        public int I0Io(FastDateParser fastDateParser, int i) {
            return i - 1;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class OOXIXo {
        public OOXIXo() {
        }

        public abstract boolean II0xO0(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i);

        public boolean oIX0oI() {
            return false;
        }

        public /* synthetic */ OOXIXo(oIX0oI oix0oi) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class Oxx0IOOO extends OOXIXo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final String f32834oIX0oI;

        public Oxx0IOOO(String str) {
            super(null);
            this.f32834oIX0oI = str;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.OOXIXo
        public boolean II0xO0(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            for (int i2 = 0; i2 < this.f32834oIX0oI.length(); i2++) {
                int index = parsePosition.getIndex() + i2;
                if (index == str.length()) {
                    parsePosition.setErrorIndex(index);
                    return false;
                }
                if (this.f32834oIX0oI.charAt(i2) != str.charAt(index)) {
                    parsePosition.setErrorIndex(index);
                    return false;
                }
            }
            parsePosition.setIndex(this.f32834oIX0oI.length() + parsePosition.getIndex());
            return true;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.OOXIXo
        public boolean oIX0oI() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public static class X0o0xo extends xxIXOIIO {
        public X0o0xo(int i) {
            super(i);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.xxIXOIIO
        public int I0Io(FastDateParser fastDateParser, int i) {
            if (i == 12) {
                return 0;
            }
            return i;
        }
    }

    /* loaded from: classes6.dex */
    public static class XO extends xoIox {

        /* renamed from: I0Io, reason: collision with root package name */
        public final Locale f32835I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final int f32836II0xO0;

        /* renamed from: oxoX, reason: collision with root package name */
        public final Map<String, Integer> f32837oxoX;

        public XO(int i, Calendar calendar, Locale locale) {
            super(null);
            this.f32836II0xO0 = i;
            this.f32835I0Io = locale;
            StringBuilder sb = new StringBuilder();
            sb.append("((?iu)");
            this.f32837oxoX = FastDateParser.appendDisplayNames(calendar, locale, i, sb);
            sb.setLength(sb.length() - 1);
            sb.append(oIX0oI.I0Io.f4095I0Io);
            oxoX(sb);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.xoIox
        public void X0o0xo(FastDateParser fastDateParser, Calendar calendar, String str) {
            String lowerCase = str.toLowerCase(this.f32835I0Io);
            Integer num = this.f32837oxoX.get(lowerCase);
            if (num == null) {
                num = this.f32837oxoX.get(lowerCase + '.');
            }
            calendar.set(this.f32836II0xO0, num.intValue());
        }
    }

    /* loaded from: classes6.dex */
    public static class oIX0oI extends xxIXOIIO {
        public oIX0oI(int i) {
            super(i);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.xxIXOIIO
        public int I0Io(FastDateParser fastDateParser, int i) {
            if (i < 100) {
                return fastDateParser.adjustYear(i);
            }
            return i;
        }
    }

    /* loaded from: classes6.dex */
    public static class oOoXoXO {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final int f32838II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final OOXIXo f32839oIX0oI;

        public oOoXoXO(OOXIXo oOXIXo, int i) {
            this.f32839oIX0oI = oOXIXo;
            this.f32838II0xO0 = i;
        }

        public int oIX0oI(ListIterator<oOoXoXO> listIterator) {
            if (!this.f32839oIX0oI.oIX0oI() || !listIterator.hasNext()) {
                return 0;
            }
            OOXIXo oOXIXo = listIterator.next().f32839oIX0oI;
            listIterator.previous();
            if (!oOXIXo.oIX0oI()) {
                return 0;
            }
            return this.f32838II0xO0;
        }
    }

    /* loaded from: classes6.dex */
    public class ooOOo0oXI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f32841II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final Calendar f32842oIX0oI;

        public ooOOo0oXI(Calendar calendar) {
            this.f32842oIX0oI = calendar;
        }

        public final oOoXoXO I0Io() {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            while (this.f32841II0xO0 < FastDateParser.this.pattern.length()) {
                char charAt = FastDateParser.this.pattern.charAt(this.f32841II0xO0);
                if (!z && FastDateParser.isFormatLetter(charAt)) {
                    break;
                }
                if (charAt == '\'') {
                    int i = this.f32841II0xO0 + 1;
                    this.f32841II0xO0 = i;
                    if (i == FastDateParser.this.pattern.length() || FastDateParser.this.pattern.charAt(this.f32841II0xO0) != '\'') {
                        z = !z;
                    }
                }
                this.f32841II0xO0++;
                sb.append(charAt);
            }
            if (!z) {
                String sb2 = sb.toString();
                return new oOoXoXO(new Oxx0IOOO(sb2), sb2.length());
            }
            throw new IllegalArgumentException("Unterminated quote");
        }

        public final oOoXoXO II0xO0(char c) {
            int i = this.f32841II0xO0;
            do {
                int i2 = this.f32841II0xO0 + 1;
                this.f32841II0xO0 = i2;
                if (i2 >= FastDateParser.this.pattern.length()) {
                    break;
                }
            } while (FastDateParser.this.pattern.charAt(this.f32841II0xO0) == c);
            int i3 = this.f32841II0xO0 - i;
            return new oOoXoXO(FastDateParser.this.getStrategy(c, i3, this.f32842oIX0oI), i3);
        }

        public oOoXoXO oIX0oI() {
            if (this.f32841II0xO0 >= FastDateParser.this.pattern.length()) {
                return null;
            }
            char charAt = FastDateParser.this.pattern.charAt(this.f32841II0xO0);
            if (FastDateParser.isFormatLetter(charAt)) {
                return II0xO0(charAt);
            }
            return I0Io();
        }
    }

    /* loaded from: classes6.dex */
    public static class oxoX extends xxIXOIIO {
        public oxoX(int i) {
            super(i);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.xxIXOIIO
        public int I0Io(FastDateParser fastDateParser, int i) {
            if (i == 24) {
                return 0;
            }
            return i;
        }
    }

    /* loaded from: classes6.dex */
    public static class x0XOIxOo extends xoIox {

        /* renamed from: X0o0xo, reason: collision with root package name */
        public static final String f32843X0o0xo = "GMT[+-]\\d{1,2}:\\d{2}";

        /* renamed from: XO, reason: collision with root package name */
        public static final int f32844XO = 0;

        /* renamed from: oxoX, reason: collision with root package name */
        public static final String f32845oxoX = "[+-]\\d{4}";

        /* renamed from: I0Io, reason: collision with root package name */
        public final Map<String, oIX0oI> f32846I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final Locale f32847II0xO0;

        /* loaded from: classes6.dex */
        public static class oIX0oI {

            /* renamed from: II0xO0, reason: collision with root package name */
            public int f32848II0xO0;

            /* renamed from: oIX0oI, reason: collision with root package name */
            public TimeZone f32849oIX0oI;

            public oIX0oI(TimeZone timeZone, boolean z) {
                int i;
                this.f32849oIX0oI = timeZone;
                if (z) {
                    i = timeZone.getDSTSavings();
                } else {
                    i = 0;
                }
                this.f32848II0xO0 = i;
            }
        }

        public x0XOIxOo(Locale locale) {
            super(null);
            this.f32846I0Io = new HashMap();
            this.f32847II0xO0 = locale;
            StringBuilder sb = new StringBuilder();
            sb.append("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
            TreeSet<String> treeSet = new TreeSet(FastDateParser.LONGER_FIRST_LOWERCASE);
            for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
                String str = strArr[0];
                if (!str.equalsIgnoreCase(org.apache.commons.lang3.time.xoIox.f32917oIX0oI)) {
                    TimeZone timeZone = TimeZone.getTimeZone(str);
                    oIX0oI oix0oi = new oIX0oI(timeZone, false);
                    oIX0oI oix0oi2 = oix0oi;
                    for (int i = 1; i < strArr.length; i++) {
                        if (i != 3) {
                            if (i == 5) {
                                oix0oi2 = oix0oi;
                            }
                        } else {
                            oix0oi2 = new oIX0oI(timeZone, true);
                        }
                        String str2 = strArr[i];
                        if (str2 != null) {
                            String lowerCase = str2.toLowerCase(locale);
                            if (treeSet.add(lowerCase)) {
                                this.f32846I0Io.put(lowerCase, oix0oi2);
                            }
                        }
                    }
                }
            }
            for (String str3 : treeSet) {
                sb.append('|');
                FastDateParser.simpleQuote(sb, str3);
            }
            sb.append(oIX0oI.I0Io.f4095I0Io);
            oxoX(sb);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.xoIox
        public void X0o0xo(FastDateParser fastDateParser, Calendar calendar, String str) {
            TimeZone II0xO02 = org.apache.commons.lang3.time.II0XooXoX.II0xO0(str);
            if (II0xO02 != null) {
                calendar.setTimeZone(II0xO02);
                return;
            }
            String lowerCase = str.toLowerCase(this.f32847II0xO0);
            oIX0oI oix0oi = this.f32846I0Io.get(lowerCase);
            if (oix0oi == null) {
                oix0oi = this.f32846I0Io.get(lowerCase + '.');
            }
            calendar.set(16, oix0oi.f32848II0xO0);
            calendar.set(15, oix0oi.f32849oIX0oI.getRawOffset());
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class xoIox extends OOXIXo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public Pattern f32850oIX0oI;

        public xoIox() {
            super(null);
        }

        public void I0Io(String str) {
            this.f32850oIX0oI = Pattern.compile(str);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.OOXIXo
        public boolean II0xO0(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            Matcher matcher = this.f32850oIX0oI.matcher(str.substring(parsePosition.getIndex()));
            if (!matcher.lookingAt()) {
                parsePosition.setErrorIndex(parsePosition.getIndex());
                return false;
            }
            parsePosition.setIndex(parsePosition.getIndex() + matcher.end(1));
            X0o0xo(fastDateParser, calendar, matcher.group(1));
            return true;
        }

        public abstract void X0o0xo(FastDateParser fastDateParser, Calendar calendar, String str);

        @Override // org.apache.commons.lang3.time.FastDateParser.OOXIXo
        public boolean oIX0oI() {
            return false;
        }

        public void oxoX(StringBuilder sb) {
            I0Io(sb.toString());
        }

        public /* synthetic */ xoIox(oIX0oI oix0oi) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class xxIXOIIO extends OOXIXo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final int f32851oIX0oI;

        public xxIXOIIO(int i) {
            super(null);
            this.f32851oIX0oI = i;
        }

        public int I0Io(FastDateParser fastDateParser, int i) {
            return i;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.OOXIXo
        public boolean II0xO0(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            int index = parsePosition.getIndex();
            int length = str.length();
            if (i == 0) {
                while (index < length && Character.isWhitespace(str.charAt(index))) {
                    index++;
                }
                parsePosition.setIndex(index);
            } else {
                int i2 = i + index;
                if (length > i2) {
                    length = i2;
                }
            }
            while (index < length && Character.isDigit(str.charAt(index))) {
                index++;
            }
            if (parsePosition.getIndex() == index) {
                parsePosition.setErrorIndex(index);
                return false;
            }
            int parseInt = Integer.parseInt(str.substring(parsePosition.getIndex(), index));
            parsePosition.setIndex(index);
            calendar.set(this.f32851oIX0oI, I0Io(fastDateParser, parseInt));
            return true;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.OOXIXo
        public boolean oIX0oI() {
            return true;
        }
    }

    static {
        Comparator<String> reverseOrder;
        reverseOrder = Comparator.reverseOrder();
        LONGER_FIRST_LOWERCASE = reverseOrder;
        caches = new ConcurrentMap[17];
        ABBREVIATED_YEAR_STRATEGY = new oIX0oI(1);
        NUMBER_MONTH_STRATEGY = new II0xO0(2);
        LITERAL_YEAR_STRATEGY = new xxIXOIIO(1);
        WEEK_OF_YEAR_STRATEGY = new xxIXOIIO(3);
        WEEK_OF_MONTH_STRATEGY = new xxIXOIIO(4);
        DAY_OF_YEAR_STRATEGY = new xxIXOIIO(6);
        DAY_OF_MONTH_STRATEGY = new xxIXOIIO(5);
        DAY_OF_WEEK_STRATEGY = new I0Io(7);
        DAY_OF_WEEK_IN_MONTH_STRATEGY = new xxIXOIIO(8);
        HOUR_OF_DAY_STRATEGY = new xxIXOIIO(11);
        HOUR24_OF_DAY_STRATEGY = new oxoX(11);
        HOUR12_STRATEGY = new X0o0xo(10);
        HOUR_STRATEGY = new xxIXOIIO(10);
        MINUTE_STRATEGY = new xxIXOIIO(12);
        SECOND_STRATEGY = new xxIXOIIO(13);
        MILLISECOND_STRATEGY = new xxIXOIIO(14);
    }

    public FastDateParser(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int adjustYear(int i) {
        int i2 = this.century + i;
        if (i < this.startYear) {
            return i2 + 100;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Integer> appendDisplayNames(Calendar calendar, Locale locale, int i, StringBuilder sb) {
        HashMap hashMap = new HashMap();
        Map<String, Integer> displayNames = calendar.getDisplayNames(i, 0, locale);
        TreeSet treeSet = new TreeSet(LONGER_FIRST_LOWERCASE);
        for (Map.Entry<String, Integer> entry : displayNames.entrySet()) {
            String lowerCase = entry.getKey().toLowerCase(locale);
            if (treeSet.add(lowerCase)) {
                hashMap.put(lowerCase, entry.getValue());
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            simpleQuote(sb, (String) it.next()).append('|');
        }
        return hashMap;
    }

    private static ConcurrentMap<Locale, OOXIXo> getCache(int i) {
        ConcurrentMap<Locale, OOXIXo> concurrentMap;
        ConcurrentMap<Locale, OOXIXo>[] concurrentMapArr = caches;
        synchronized (concurrentMapArr) {
            try {
                if (concurrentMapArr[i] == null) {
                    concurrentMapArr[i] = new ConcurrentHashMap(3);
                }
                concurrentMap = concurrentMapArr[i];
            } catch (Throwable th) {
                throw th;
            }
        }
        return concurrentMap;
    }

    private OOXIXo getLocaleSpecificStrategy(int i, Calendar calendar) {
        ConcurrentMap<Locale, OOXIXo> cache = getCache(i);
        OOXIXo oOXIXo = cache.get(this.locale);
        if (oOXIXo == null) {
            if (i == 15) {
                oOXIXo = new x0XOIxOo(this.locale);
            } else {
                oOXIXo = new XO(i, calendar, this.locale);
            }
            OOXIXo putIfAbsent = cache.putIfAbsent(this.locale, oOXIXo);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
        }
        return oOXIXo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0009. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000c. Please report as an issue. */
    public OOXIXo getStrategy(char c, int i, Calendar calendar) {
        if (c != 'y') {
            if (c != 'z') {
                switch (c) {
                    case 'D':
                        return DAY_OF_YEAR_STRATEGY;
                    case 'E':
                        return getLocaleSpecificStrategy(7, calendar);
                    case 'F':
                        return DAY_OF_WEEK_IN_MONTH_STRATEGY;
                    case 'G':
                        return getLocaleSpecificStrategy(0, calendar);
                    case 'H':
                        return HOUR_OF_DAY_STRATEGY;
                    default:
                        switch (c) {
                            case 'K':
                                return HOUR_STRATEGY;
                            case 'M':
                                if (i >= 3) {
                                    return getLocaleSpecificStrategy(2, calendar);
                                }
                                return NUMBER_MONTH_STRATEGY;
                            case 'S':
                                return MILLISECOND_STRATEGY;
                            case 'a':
                                return getLocaleSpecificStrategy(9, calendar);
                            case 'd':
                                return DAY_OF_MONTH_STRATEGY;
                            case 'h':
                                return HOUR12_STRATEGY;
                            case 'k':
                                return HOUR24_OF_DAY_STRATEGY;
                            case 'm':
                                return MINUTE_STRATEGY;
                            case 's':
                                return SECOND_STRATEGY;
                            case 'u':
                                return DAY_OF_WEEK_STRATEGY;
                            case 'w':
                                return WEEK_OF_YEAR_STRATEGY;
                            default:
                                switch (c) {
                                    case 'W':
                                        return WEEK_OF_MONTH_STRATEGY;
                                    case 'X':
                                        return II0XooXoX.Oxx0IOOO(i);
                                    case 'Y':
                                        break;
                                    case 'Z':
                                        if (i == 2) {
                                            return II0XooXoX.f32833oxoX;
                                        }
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Format '" + c + "' not supported");
                                }
                        }
                }
            }
            return getLocaleSpecificStrategy(15, calendar);
        }
        if (i > 2) {
            return LITERAL_YEAR_STRATEGY;
        }
        return ABBREVIATED_YEAR_STRATEGY;
    }

    private void init(Calendar calendar) {
        this.patterns = new ArrayList();
        ooOOo0oXI ooooo0oxi = new ooOOo0oXI(calendar);
        while (true) {
            oOoXoXO oIX0oI2 = ooooo0oxi.oIX0oI();
            if (oIX0oI2 == null) {
                return;
            } else {
                this.patterns.add(oIX0oI2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isFormatLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(Calendar.getInstance(this.timeZone, this.locale));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static StringBuilder simpleQuote(StringBuilder sb, String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '$' && charAt != '.' && charAt != '?' && charAt != '^' && charAt != '[' && charAt != '\\' && charAt != '{' && charAt != '|') {
                switch (charAt) {
                }
                sb.append(charAt);
            }
            sb.append('\\');
            sb.append(charAt);
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.append('?');
        }
        return sb;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser) obj;
        if (!this.pattern.equals(fastDateParser.pattern) || !this.timeZone.equals(fastDateParser.timeZone) || !this.locale.equals(fastDateParser.locale)) {
            return false;
        }
        return true;
    }

    @Override // org.apache.commons.lang3.time.I0Io, org.apache.commons.lang3.time.oxoX
    public Locale getLocale() {
        return this.locale;
    }

    @Override // org.apache.commons.lang3.time.I0Io, org.apache.commons.lang3.time.oxoX
    public String getPattern() {
        return this.pattern;
    }

    @Override // org.apache.commons.lang3.time.I0Io, org.apache.commons.lang3.time.oxoX
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public int hashCode() {
        return this.pattern.hashCode() + ((this.timeZone.hashCode() + (this.locale.hashCode() * 13)) * 13);
    }

    @Override // org.apache.commons.lang3.time.I0Io
    public Date parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = parse(str, parsePosition);
        if (parse != null) {
            return parse;
        }
        if (this.locale.equals(JAPANESE_IMPERIAL)) {
            throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\nUnparseable date: \"" + str, parsePosition.getErrorIndex());
        }
        throw new ParseException("Unparseable date: " + str, parsePosition.getErrorIndex());
    }

    @Override // org.apache.commons.lang3.time.I0Io
    public Object parseObject(String str) throws ParseException {
        return parse(str);
    }

    public String toString() {
        return "FastDateParser[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + "]";
    }

    public FastDateParser(String str, TimeZone timeZone, Locale locale, Date date) {
        int i;
        this.pattern = str;
        this.timeZone = timeZone;
        this.locale = locale;
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        if (date != null) {
            calendar.setTime(date);
            i = calendar.get(1);
        } else if (locale.equals(JAPANESE_IMPERIAL)) {
            i = 0;
        } else {
            calendar.setTime(new Date());
            i = calendar.get(1) - 80;
        }
        int i2 = (i / 100) * 100;
        this.century = i2;
        this.startYear = i - i2;
        init(calendar);
    }

    @Override // org.apache.commons.lang3.time.I0Io
    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    @Override // org.apache.commons.lang3.time.I0Io
    public Date parse(String str, ParsePosition parsePosition) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        calendar.clear();
        if (parse(str, parsePosition, calendar)) {
            return calendar.getTime();
        }
        return null;
    }

    @Override // org.apache.commons.lang3.time.I0Io
    public boolean parse(String str, ParsePosition parsePosition, Calendar calendar) {
        ListIterator<oOoXoXO> listIterator = this.patterns.listIterator();
        while (listIterator.hasNext()) {
            oOoXoXO next = listIterator.next();
            if (!next.f32839oIX0oI.II0xO0(this, calendar, str, parsePosition, next.oIX0oI(listIterator))) {
                return false;
            }
        }
        return true;
    }
}
