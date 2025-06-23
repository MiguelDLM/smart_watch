package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class DateUtils {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final long f32817I0Io = 3600000;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f32818II0XooXoX = 2;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final long f32819II0xO0 = 60000;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f32820OOXIXo = 5;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f32821Oxx0IOOO = 1;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f32822X0o0xo = 1001;

    /* renamed from: XO, reason: collision with root package name */
    public static final int[][] f32823XO = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final long f32824oIX0oI = 1000;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f32825oOoXoXO = 6;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final long f32826oxoX = 86400000;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f32827xoIox = 4;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f32828xxIXOIIO = 3;

    /* loaded from: classes6.dex */
    public enum ModifyType {
        TRUNCATE,
        ROUND,
        CEILING
    }

    /* loaded from: classes6.dex */
    public static class oIX0oI implements Iterator<Calendar> {

        /* renamed from: Oo, reason: collision with root package name */
        public final Calendar f32829Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final Calendar f32830XO;

        public oIX0oI(Calendar calendar, Calendar calendar2) {
            this.f32830XO = calendar2;
            this.f32829Oo = calendar;
            calendar.add(5, -1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f32829Oo.before(this.f32830XO);
        }

        @Override // java.util.Iterator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Calendar next() {
            if (!this.f32829Oo.equals(this.f32830XO)) {
                this.f32829Oo.add(5, 1);
                return (Calendar) this.f32829Oo.clone();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static Date I0Io(Date date, int i) {
        return oIX0oI(date, 11, i);
    }

    public static int I0X0x0oIo(Date date, Date date2, int i) {
        return xXOx(date, i).compareTo(xXOx(date2, i));
    }

    public static Date I0oOoX(Date date, int i) {
        return xII(date, 1, i);
    }

    public static Date II0XooXoX(Date date, int i) {
        return oIX0oI(date, 3, i);
    }

    public static Date II0xO0(Date date, int i) {
        return oIX0oI(date, 5, i);
    }

    public static void IIX0o(Calendar calendar, int i, ModifyType modifyType) {
        boolean z;
        int i2;
        boolean z2;
        char c;
        boolean z3;
        if (calendar.get(1) <= 280000000) {
            if (i == 14) {
                return;
            }
            Date time = calendar.getTime();
            long time2 = time.getTime();
            int i3 = calendar.get(14);
            ModifyType modifyType2 = ModifyType.TRUNCATE;
            if (modifyType2 == modifyType || i3 < 500) {
                time2 -= i3;
            }
            if (i == 13) {
                z = true;
            } else {
                z = false;
            }
            int i4 = calendar.get(13);
            if (!z && (modifyType2 == modifyType || i4 < 30)) {
                time2 -= i4 * 1000;
            }
            if (i == 12) {
                z = true;
            }
            int i5 = calendar.get(12);
            if (!z && (modifyType2 == modifyType || i5 < 30)) {
                time2 -= i5 * 60000;
            }
            if (time.getTime() != time2) {
                time.setTime(time2);
                calendar.setTime(time);
            }
            boolean z4 = false;
            for (int[] iArr : f32823XO) {
                for (int i6 : iArr) {
                    if (i6 == i) {
                        if (modifyType == ModifyType.CEILING || (modifyType == ModifyType.ROUND && z4)) {
                            if (i == 1001) {
                                if (calendar.get(5) == 1) {
                                    calendar.add(5, 15);
                                    return;
                                } else {
                                    calendar.add(5, -15);
                                    calendar.add(2, 1);
                                    return;
                                }
                            }
                            if (i == 9) {
                                if (calendar.get(11) == 0) {
                                    calendar.add(11, 12);
                                    return;
                                } else {
                                    calendar.add(11, -12);
                                    calendar.add(5, 1);
                                    return;
                                }
                            }
                            calendar.add(iArr[0], 1);
                            return;
                        }
                        return;
                    }
                }
                if (i != 9) {
                    if (i == 1001 && iArr[0] == 5) {
                        int i7 = calendar.get(5);
                        int i8 = i7 - 1;
                        i2 = i8 >= 15 ? i7 - 16 : i8;
                        if (i2 > 7) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        z2 = true;
                    }
                    i2 = 0;
                    z2 = false;
                } else {
                    if (iArr[0] == 11) {
                        int i9 = calendar.get(11);
                        if (i9 >= 12) {
                            i9 -= 12;
                        }
                        int i10 = i9;
                        if (i10 >= 6) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        i2 = i10;
                        z2 = true;
                    }
                    i2 = 0;
                    z2 = false;
                }
                if (!z2) {
                    c = 0;
                    int actualMinimum = calendar.getActualMinimum(iArr[0]);
                    int actualMaximum = calendar.getActualMaximum(iArr[0]);
                    int i11 = calendar.get(iArr[0]) - actualMinimum;
                    if (i11 > (actualMaximum - actualMinimum) / 2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z4 = z3;
                    i2 = i11;
                } else {
                    c = 0;
                }
                if (i2 != 0) {
                    int i12 = iArr[c];
                    calendar.set(i12, calendar.get(i12) - i2);
                }
            }
            throw new IllegalArgumentException("The field " + i + " is not supported");
        }
        throw new ArithmeticException("Calendar value too large for accurate calculations");
    }

    public static long IIXOooo(Date date, int i) {
        return x0XOIxOo(date, i, TimeUnit.MINUTES);
    }

    public static Date IO(Date date, int i) {
        XoI0Ixx0(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        IIX0o(calendar, i, ModifyType.ROUND);
        return calendar.getTime();
    }

    public static long IXxxXO(Date date, int i) {
        return x0XOIxOo(date, i, TimeUnit.HOURS);
    }

    public static Date Io(Date date, int i) {
        return xII(date, 12, i);
    }

    public static Date IoOoX(String str, String... strArr) throws ParseException {
        return oo(str, null, strArr);
    }

    public static boolean O0xOxO(Date date, Date date2) {
        if (date != null && date2 != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            return OxI(calendar, calendar2);
        }
        throw ooXIXxIX();
    }

    public static Date OI0(Date date, int i) {
        return xII(date, 14, i);
    }

    public static Date OOXIXo(Object obj, int i) {
        if (obj != null) {
            if (obj instanceof Date) {
                return oOoXoXO((Date) obj, i);
            }
            if (obj instanceof Calendar) {
                return xoIox((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not find ceiling of for type: " + obj.getClass());
        }
        throw ooXIXxIX();
    }

    public static long Oo(Calendar calendar, int i) {
        return ooOOo0oXI(calendar, i, TimeUnit.HOURS);
    }

    public static boolean OxI(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            if (calendar.get(0) != calendar2.get(0) || calendar.get(1) != calendar2.get(1) || calendar.get(6) != calendar2.get(6)) {
                return false;
            }
            return true;
        }
        throw ooXIXxIX();
    }

    public static Date Oxx0IOOO(Date date, int i) {
        return oIX0oI(date, 13, i);
    }

    public static long Oxx0xo(Calendar calendar, int i) {
        return ooOOo0oXI(calendar, i, TimeUnit.MILLISECONDS);
    }

    public static long OxxIIOOXO(Calendar calendar, int i) {
        return ooOOo0oXI(calendar, i, TimeUnit.MINUTES);
    }

    public static Date X00IoxXI(Object obj, int i) {
        if (obj != null) {
            if (obj instanceof Date) {
                return IO((Date) obj, i);
            }
            if (obj instanceof Calendar) {
                return Xx000oIo((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not round " + obj);
        }
        throw ooXIXxIX();
    }

    public static boolean X0IIOO(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            if (calendar.getTime().getTime() == calendar2.getTime().getTime()) {
                return true;
            }
            return false;
        }
        throw ooXIXxIX();
    }

    public static Date X0o0xo(Date date, int i) {
        return oIX0oI(date, 12, i);
    }

    public static boolean XI0IXoo(Date date, Date date2) {
        if (date != null && date2 != null) {
            if (date.getTime() == date2.getTime()) {
                return true;
            }
            return false;
        }
        throw ooXIXxIX();
    }

    public static boolean XIxXXX0x0(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            if (calendar.get(14) != calendar2.get(14) || calendar.get(13) != calendar2.get(13) || calendar.get(12) != calendar2.get(12) || calendar.get(11) != calendar2.get(11) || calendar.get(6) != calendar2.get(6) || calendar.get(1) != calendar2.get(1) || calendar.get(0) != calendar2.get(0) || calendar.getClass() != calendar2.getClass()) {
                return false;
            }
            return true;
        }
        throw ooXIXxIX();
    }

    public static Date XO(Date date, int i) {
        return oIX0oI(date, 2, i);
    }

    public static Date XOxIOxOx(Date date, int i) {
        return xII(date, 11, i);
    }

    public static Date XX(Date date, int i) {
        return xII(date, 13, i);
    }

    public static int XX0(Calendar calendar, Calendar calendar2, int i) {
        return oxXx0IX(calendar, i).compareTo(oxXx0IX(calendar2, i));
    }

    public static boolean Xo0(Date date, Date date2, int i) {
        if (I0X0x0oIo(date, date2, i) == 0) {
            return true;
        }
        return false;
    }

    public static void XoI0Ixx0(Date date) {
        xoIxX.xo0x(date, "The date must not be null", new Object[0]);
    }

    public static Calendar XoX(Date date, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        return calendar;
    }

    public static Calendar Xx000oIo(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            IIX0o(calendar2, i, ModifyType.ROUND);
            return calendar2;
        }
        throw ooXIXxIX();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0007. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d A[LOOP:0: B:20:0x0077->B:22:0x007d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0087 A[LOOP:1: B:24:0x0081->B:26:0x0087, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Iterator<java.util.Calendar> XxX0x0xxx(java.util.Calendar r8, int r9) {
        /*
            if (r8 == 0) goto L91
            r0 = -1
            r1 = 5
            r2 = 2
            r3 = 1
            r4 = 7
            switch(r9) {
                case 1: goto L42;
                case 2: goto L42;
                case 3: goto L42;
                case 4: goto L42;
                case 5: goto L26;
                case 6: goto L26;
                default: goto La;
            }
        La:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "The range style "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = " is not valid."
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r8.<init>(r9)
            throw r8
        L26:
            java.util.Calendar r8 = oxXx0IX(r8, r2)
            java.lang.Object r5 = r8.clone()
            java.util.Calendar r5 = (java.util.Calendar) r5
            r5.add(r2, r3)
            r5.add(r1, r0)
            r6 = 6
            if (r9 != r6) goto L3d
            r6 = r5
            r5 = r8
        L3b:
            r8 = 1
            goto L67
        L3d:
            r6 = r5
            r2 = 1
            r5 = r8
            r8 = 7
            goto L67
        L42:
            java.util.Calendar r5 = oxXx0IX(r8, r1)
            java.util.Calendar r6 = oxXx0IX(r8, r1)
            if (r9 == r2) goto L3b
            r2 = 3
            if (r9 == r2) goto L61
            r7 = 4
            if (r9 == r7) goto L55
            r8 = 7
            r2 = 1
            goto L67
        L55:
            int r9 = r8.get(r4)
            int r9 = r9 - r2
            int r8 = r8.get(r4)
            int r8 = r8 + r2
            r2 = r9
            goto L67
        L61:
            int r2 = r8.get(r4)
            int r8 = r2 + (-1)
        L67:
            if (r2 >= r3) goto L6b
            int r2 = r2 + 7
        L6b:
            if (r2 <= r4) goto L6f
            int r2 = r2 + (-7)
        L6f:
            if (r8 >= r3) goto L73
            int r8 = r8 + 7
        L73:
            if (r8 <= r4) goto L77
            int r8 = r8 + (-7)
        L77:
            int r9 = r5.get(r4)
            if (r9 == r2) goto L81
            r5.add(r1, r0)
            goto L77
        L81:
            int r9 = r6.get(r4)
            if (r9 == r8) goto L8b
            r6.add(r1, r3)
            goto L81
        L8b:
            org.apache.commons.lang3.time.DateUtils$oIX0oI r8 = new org.apache.commons.lang3.time.DateUtils$oIX0oI
            r8.<init>(r5, r6)
            return r8
        L91:
            java.lang.IllegalArgumentException r8 = ooXIXxIX()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.XxX0x0xxx(java.util.Calendar, int):java.util.Iterator");
    }

    public static Date o0(Date date, int i) {
        return xII(date, 2, i);
    }

    public static long o00(Date date, int i) {
        return x0XOIxOo(date, i, TimeUnit.SECONDS);
    }

    public static long oI0IIXIo(Date date, int i) {
        return x0XOIxOo(date, i, TimeUnit.MILLISECONDS);
    }

    public static Date oIX0oI(Date date, int i, int i2) {
        XoI0Ixx0(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(i, i2);
        return calendar.getTime();
    }

    public static long oO(Calendar calendar, int i) {
        return ooOOo0oXI(calendar, i, TimeUnit.DAYS);
    }

    public static Date oOXoIIIo(String str, Locale locale, String[] strArr, boolean z) throws ParseException {
        if (str != null && strArr != null) {
            TimeZone timeZone = TimeZone.getDefault();
            if (locale == null) {
                locale = Locale.getDefault();
            }
            ParsePosition parsePosition = new ParsePosition(0);
            Calendar calendar = Calendar.getInstance(timeZone, locale);
            calendar.setLenient(z);
            for (String str2 : strArr) {
                FastDateParser fastDateParser = new FastDateParser(str2, timeZone, locale);
                calendar.clear();
                try {
                    if (fastDateParser.parse(str, parsePosition, calendar) && parsePosition.getIndex() == str.length()) {
                        return calendar.getTime();
                    }
                } catch (IllegalArgumentException unused) {
                }
                parsePosition.setIndex(0);
            }
            throw new ParseException("Unable to parse the date: " + str, -1);
        }
        throw new IllegalArgumentException("Date and Patterns must not be null");
    }

    public static Date oOoXoXO(Date date, int i) {
        XoI0Ixx0(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        IIX0o(calendar, i, ModifyType.CEILING);
        return calendar.getTime();
    }

    public static boolean oX(Calendar calendar, Calendar calendar2, int i) {
        if (XX0(calendar, calendar2, i) == 0) {
            return true;
        }
        return false;
    }

    public static Date oo(String str, Locale locale, String... strArr) throws ParseException {
        return oOXoIIIo(str, locale, strArr, false);
    }

    public static Date oo0xXOI0I(String str, String... strArr) throws ParseException {
        return xI(str, null, strArr);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0031. Please report as an issue. */
    public static long ooOOo0oXI(Calendar calendar, int i, TimeUnit timeUnit) {
        int i2;
        long convert;
        if (calendar != null) {
            TimeUnit timeUnit2 = TimeUnit.DAYS;
            if (timeUnit == timeUnit2) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i != 1) {
                if (i != 2) {
                    convert = 0;
                } else {
                    convert = timeUnit.convert(calendar.get(5) - i2, timeUnit2);
                }
            } else {
                convert = timeUnit.convert(calendar.get(6) - i2, timeUnit2);
            }
            if (i == 1 || i == 2 || i == 5 || i == 6) {
                convert += timeUnit.convert(calendar.get(11), TimeUnit.HOURS);
            } else {
                switch (i) {
                    case 11:
                        break;
                    case 12:
                        convert += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
                    case 13:
                        return convert + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
                    case 14:
                        return convert;
                    default:
                        throw new IllegalArgumentException("The fragment " + i + " is not supported");
                }
            }
            convert += timeUnit.convert(calendar.get(12), TimeUnit.MINUTES);
            convert += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
            return convert + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
        }
        throw ooXIXxIX();
    }

    public static IllegalArgumentException ooXIXxIX() {
        return new IllegalArgumentException("The date must not be null");
    }

    public static Calendar oxXx0IX(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            IIX0o(calendar2, i, ModifyType.TRUNCATE);
            return calendar2;
        }
        throw ooXIXxIX();
    }

    public static Date oxoX(Date date, int i) {
        return oIX0oI(date, 14, i);
    }

    public static Calendar oxxXoxO(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static long x0XOIxOo(Date date, int i, TimeUnit timeUnit) {
        XoI0Ixx0(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return ooOOo0oXI(calendar, i, timeUnit);
    }

    public static Date x0o(Date date, int i) {
        return xII(date, 5, i);
    }

    public static long x0xO0oo(Date date, int i) {
        return x0XOIxOo(date, i, TimeUnit.DAYS);
    }

    public static Date xI(String str, Locale locale, String... strArr) throws ParseException {
        return oOXoIIIo(str, locale, strArr, true);
    }

    public static Date xII(Date date, int i, int i2) {
        XoI0Ixx0(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTime(date);
        calendar.set(i, i2);
        return calendar.getTime();
    }

    public static Date xXOx(Date date, int i) {
        XoI0Ixx0(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        IIX0o(calendar, i, ModifyType.TRUNCATE);
        return calendar.getTime();
    }

    public static Iterator<Calendar> xXxxox0I(Date date, int i) {
        XoI0Ixx0(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return XxX0x0xxx(calendar, i);
    }

    public static Date xo0x(Object obj, int i) {
        if (obj != null) {
            if (obj instanceof Date) {
                return xXOx((Date) obj, i);
            }
            if (obj instanceof Calendar) {
                return oxXx0IX((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not truncate " + obj);
        }
        throw ooXIXxIX();
    }

    public static Calendar xoIox(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            IIX0o(calendar2, i, ModifyType.CEILING);
            return calendar2;
        }
        throw ooXIXxIX();
    }

    public static long xoXoI(Calendar calendar, int i) {
        return ooOOo0oXI(calendar, i, TimeUnit.SECONDS);
    }

    public static Date xxIXOIIO(Date date, int i) {
        return oIX0oI(date, 1, i);
    }

    public static Iterator<?> xxX(Object obj, int i) {
        if (obj != null) {
            if (obj instanceof Date) {
                return xXxxox0I((Date) obj, i);
            }
            if (obj instanceof Calendar) {
                return XxX0x0xxx((Calendar) obj, i);
            }
            throw new ClassCastException("Could not iterate based on " + obj);
        }
        throw ooXIXxIX();
    }
}
