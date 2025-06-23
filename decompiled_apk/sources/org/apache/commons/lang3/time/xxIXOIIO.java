package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public abstract class xxIXOIIO<F extends Format> {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final ConcurrentMap<oIX0oI, String> f32918I0Io = new ConcurrentHashMap(7);

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f32919II0xO0 = -1;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final ConcurrentMap<oIX0oI, F> f32920oIX0oI = new ConcurrentHashMap(7);

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f32921II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final Object[] f32922oIX0oI;

        public oIX0oI(Object... objArr) {
            this.f32922oIX0oI = objArr;
        }

        public boolean equals(Object obj) {
            return Arrays.equals(this.f32922oIX0oI, ((oIX0oI) obj).f32922oIX0oI);
        }

        public int hashCode() {
            if (this.f32921II0xO0 == 0) {
                int i = 0;
                for (Object obj : this.f32922oIX0oI) {
                    if (obj != null) {
                        i = (i * 7) + obj.hashCode();
                    }
                }
                this.f32921II0xO0 = i;
            }
            return this.f32921II0xO0;
        }
    }

    public static String Oxx0IOOO(Integer num, Integer num2, Locale locale) {
        DateFormat dateTimeInstance;
        oIX0oI oix0oi = new oIX0oI(num, num2, locale);
        ConcurrentMap<oIX0oI, String> concurrentMap = f32918I0Io;
        String str = concurrentMap.get(oix0oi);
        if (str == null) {
            try {
                if (num == null) {
                    dateTimeInstance = DateFormat.getTimeInstance(num2.intValue(), locale);
                } else if (num2 == null) {
                    dateTimeInstance = DateFormat.getDateInstance(num.intValue(), locale);
                } else {
                    dateTimeInstance = DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale);
                }
                String pattern = ((SimpleDateFormat) dateTimeInstance).toPattern();
                String putIfAbsent = concurrentMap.putIfAbsent(oix0oi, pattern);
                if (putIfAbsent != null) {
                    return putIfAbsent;
                }
                return pattern;
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("No date time pattern for locale: " + locale);
            }
        }
        return str;
    }

    public F I0Io(int i, int i2, TimeZone timeZone, Locale locale) {
        return oxoX(Integer.valueOf(i), Integer.valueOf(i2), timeZone, locale);
    }

    public F II0XooXoX(int i, TimeZone timeZone, Locale locale) {
        return oxoX(null, Integer.valueOf(i), timeZone, locale);
    }

    public F II0xO0(int i, TimeZone timeZone, Locale locale) {
        return oxoX(Integer.valueOf(i), null, timeZone, locale);
    }

    public F X0o0xo() {
        return I0Io(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public F XO(String str, TimeZone timeZone, Locale locale) {
        xoIxX.xo0x(str, "pattern must not be null", new Object[0]);
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        oIX0oI oix0oi = new oIX0oI(str, timeZone, locale);
        F f = this.f32920oIX0oI.get(oix0oi);
        if (f == null) {
            F oIX0oI2 = oIX0oI(str, timeZone, locale);
            F putIfAbsent = this.f32920oIX0oI.putIfAbsent(oix0oi, oIX0oI2);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
            return oIX0oI2;
        }
        return f;
    }

    public abstract F oIX0oI(String str, TimeZone timeZone, Locale locale);

    public final F oxoX(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return XO(Oxx0IOOO(num, num2, locale), timeZone, locale);
    }
}
