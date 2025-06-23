package org.apache.commons.lang3.time;

import androidx.exifinterface.media.ExifInterface;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.xXOx;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f32911oIX0oI = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final Object f32907II0xO0 = "y";

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Object f32905I0Io = "M";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Object f32912oxoX = "d";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final Object f32909X0o0xo = com.sma.smartv3.util.xoIox.f24717xXxxox0I;

    /* renamed from: XO, reason: collision with root package name */
    public static final Object f32910XO = "m";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final Object f32908Oxx0IOOO = "s";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final Object f32906II0XooXoX = ExifInterface.LATITUDE_SOUTH;

    public static String I0Io(long j, String str, boolean z) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        xoIxX.IXxxXO(0L, Long.MAX_VALUE, j, "durationMillis must not be negative");
        oIX0oI[] xoIox2 = xoIox(str);
        if (oIX0oI.oIX0oI(xoIox2, f32912oxoX)) {
            long j8 = j / 86400000;
            j2 = j - (86400000 * j8);
            j3 = j8;
        } else {
            j2 = j;
            j3 = 0;
        }
        if (oIX0oI.oIX0oI(xoIox2, f32909X0o0xo)) {
            long j9 = j2 / 3600000;
            j2 -= 3600000 * j9;
            j4 = j9;
        } else {
            j4 = 0;
        }
        if (oIX0oI.oIX0oI(xoIox2, f32910XO)) {
            long j10 = j2 / 60000;
            j2 -= 60000 * j10;
            j5 = j10;
        } else {
            j5 = 0;
        }
        if (oIX0oI.oIX0oI(xoIox2, f32908Oxx0IOOO)) {
            long j11 = j2 / 1000;
            j7 = j2 - (1000 * j11);
            j6 = j11;
        } else {
            j6 = 0;
            j7 = j2;
        }
        return oIX0oI(xoIox2, 0L, 0L, j3, j4, j5, j6, j7, z);
    }

    public static String II0XooXoX(long j, long j2, String str, boolean z, TimeZone timeZone) {
        boolean z2;
        int i = 0;
        if (j <= j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        xoIxX.XI0IXoo(z2, "startMillis must not be greater than endMillis", new Object[0]);
        oIX0oI[] xoIox2 = xoIox(str);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(j));
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(new Date(j2));
        int i2 = calendar2.get(14) - calendar.get(14);
        int i3 = calendar2.get(13) - calendar.get(13);
        int i4 = calendar2.get(12) - calendar.get(12);
        int i5 = calendar2.get(11) - calendar.get(11);
        int i6 = calendar2.get(5) - calendar.get(5);
        int i7 = calendar2.get(2) - calendar.get(2);
        int i8 = calendar2.get(1) - calendar.get(1);
        while (i2 < 0) {
            i2 += 1000;
            i3--;
        }
        while (i3 < 0) {
            i3 += 60;
            i4--;
        }
        while (i4 < 0) {
            i4 += 60;
            i5--;
        }
        while (i5 < 0) {
            i5 += 24;
            i6--;
        }
        if (oIX0oI.oIX0oI(xoIox2, f32905I0Io)) {
            while (i6 < 0) {
                i6 += calendar.getActualMaximum(5);
                i7--;
                calendar.add(2, 1);
            }
            while (i7 < 0) {
                i7 += 12;
                i8--;
            }
            if (!oIX0oI.oIX0oI(xoIox2, f32907II0xO0) && i8 != 0) {
                while (i8 != 0) {
                    i7 += i8 * 12;
                    i8 = 0;
                }
            }
        } else {
            if (!oIX0oI.oIX0oI(xoIox2, f32907II0xO0)) {
                int i9 = calendar2.get(1);
                if (i7 < 0) {
                    i9--;
                }
                while (calendar.get(1) != i9) {
                    int actualMaximum = i6 + (calendar.getActualMaximum(6) - calendar.get(6));
                    if ((calendar instanceof GregorianCalendar) && calendar.get(2) == 1 && calendar.get(5) == 29) {
                        actualMaximum++;
                    }
                    calendar.add(1, 1);
                    i6 = actualMaximum + calendar.get(6);
                }
                i8 = 0;
            }
            while (calendar.get(2) != calendar2.get(2)) {
                i6 += calendar.getActualMaximum(5);
                calendar.add(2, 1);
            }
            i7 = 0;
            while (i6 < 0) {
                i6 += calendar.getActualMaximum(5);
                i7--;
                calendar.add(2, 1);
            }
        }
        if (!oIX0oI.oIX0oI(xoIox2, f32912oxoX)) {
            i5 += i6 * 24;
            i6 = 0;
        }
        if (!oIX0oI.oIX0oI(xoIox2, f32909X0o0xo)) {
            i4 += i5 * 60;
            i5 = 0;
        }
        if (!oIX0oI.oIX0oI(xoIox2, f32910XO)) {
            i3 += i4 * 60;
            i4 = 0;
        }
        if (!oIX0oI.oIX0oI(xoIox2, f32908Oxx0IOOO)) {
            i2 += i3 * 1000;
        } else {
            i = i3;
        }
        return oIX0oI(xoIox2, i8, i7, i6, i5, i4, i, i2, z);
    }

    public static String II0xO0(long j, String str) {
        return I0Io(j, str, true);
    }

    public static String OOXIXo(long j, boolean z, int i) {
        String l = Long.toString(j);
        if (z) {
            return xXOx.OO0(l, i, '0');
        }
        return l;
    }

    public static String Oxx0IOOO(long j, long j2, String str) {
        return II0XooXoX(j, j2, str, true, TimeZone.getDefault());
    }

    public static String X0o0xo(long j) {
        return I0Io(j, f32911oIX0oI, false);
    }

    public static String XO(long j, boolean z, boolean z2) {
        String II0xO02 = II0xO0(j, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z) {
            II0xO02 = " " + II0xO02;
            String IxIo2 = xXOx.IxIo(II0xO02, " 0 days", "");
            if (IxIo2.length() != II0xO02.length()) {
                String IxIo3 = xXOx.IxIo(IxIo2, " 0 hours", "");
                if (IxIo3.length() != IxIo2.length()) {
                    II0xO02 = xXOx.IxIo(IxIo3, " 0 minutes", "");
                    if (II0xO02.length() != II0xO02.length()) {
                        II0xO02 = xXOx.IxIo(II0xO02, " 0 seconds", "");
                    }
                } else {
                    II0xO02 = IxIo2;
                }
            }
            if (!II0xO02.isEmpty()) {
                II0xO02 = II0xO02.substring(1);
            }
        }
        if (z2) {
            String IxIo4 = xXOx.IxIo(II0xO02, " 0 seconds", "");
            if (IxIo4.length() != II0xO02.length()) {
                II0xO02 = xXOx.IxIo(IxIo4, " 0 minutes", "");
                if (II0xO02.length() != IxIo4.length()) {
                    String IxIo5 = xXOx.IxIo(II0xO02, " 0 hours", "");
                    if (IxIo5.length() != II0xO02.length()) {
                        II0xO02 = xXOx.IxIo(IxIo5, " 0 days", "");
                    }
                } else {
                    II0xO02 = IxIo4;
                }
            }
        }
        return xXOx.IxIo(xXOx.IxIo(xXOx.IxIo(xXOx.IxIo(" " + II0xO02, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String oIX0oI(oIX0oI[] oix0oiArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z) {
        int i;
        int i2;
        long j8;
        oIX0oI[] oix0oiArr2 = oix0oiArr;
        long j9 = j7;
        StringBuilder sb = new StringBuilder();
        int length = oix0oiArr2.length;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < length) {
            oIX0oI oix0oi = oix0oiArr2[i3];
            Object I0Io2 = oix0oi.I0Io();
            int II0xO02 = oix0oi.II0xO0();
            if (I0Io2 instanceof StringBuilder) {
                sb.append(I0Io2.toString());
                j8 = j9;
                i2 = length;
                i = i3;
            } else {
                if (I0Io2.equals(f32907II0xO0)) {
                    sb.append(OOXIXo(j, z, II0xO02));
                } else if (I0Io2.equals(f32905I0Io)) {
                    sb.append(OOXIXo(j2, z, II0xO02));
                } else if (I0Io2.equals(f32912oxoX)) {
                    i = i3;
                    sb.append(OOXIXo(j3, z, II0xO02));
                    j8 = j9;
                    i2 = length;
                    z2 = false;
                } else {
                    i = i3;
                    if (I0Io2.equals(f32909X0o0xo)) {
                        i2 = length;
                        sb.append(OOXIXo(j4, z, II0xO02));
                    } else {
                        i2 = length;
                        if (I0Io2.equals(f32910XO)) {
                            sb.append(OOXIXo(j5, z, II0xO02));
                        } else {
                            if (I0Io2.equals(f32908Oxx0IOOO)) {
                                sb.append(OOXIXo(j6, z, II0xO02));
                                j8 = j7;
                                z2 = true;
                            } else if (I0Io2.equals(f32906II0XooXoX)) {
                                if (z2) {
                                    int i4 = 3;
                                    if (z) {
                                        i4 = Math.max(3, II0xO02);
                                    }
                                    j8 = j7;
                                    sb.append(OOXIXo(j8, true, i4));
                                } else {
                                    j8 = j7;
                                    sb.append(OOXIXo(j8, z, II0xO02));
                                }
                                z2 = false;
                            } else {
                                j8 = j7;
                            }
                            i3 = i + 1;
                            j9 = j8;
                            length = i2;
                            oix0oiArr2 = oix0oiArr;
                        }
                    }
                    j8 = j9;
                    z2 = false;
                    i3 = i + 1;
                    j9 = j8;
                    length = i2;
                    oix0oiArr2 = oix0oiArr;
                }
                j8 = j9;
                i2 = length;
                i = i3;
                z2 = false;
            }
            i3 = i + 1;
            j9 = j8;
            length = i2;
            oix0oiArr2 = oix0oiArr;
        }
        return sb.toString();
    }

    public static String oxoX(long j) {
        return II0xO0(j, "HH:mm:ss.SSS");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.apache.commons.lang3.time.X0o0xo.oIX0oI[] xoIox(java.lang.String r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r9.length()
            r0.<init>(r1)
            r1 = 0
            r2 = 0
            r5 = r2
            r6 = r5
            r3 = 0
            r4 = 0
        Lf:
            int r7 = r9.length()
            if (r3 >= r7) goto L9f
            char r7 = r9.charAt(r3)
            r8 = 39
            if (r4 == 0) goto L24
            if (r7 == r8) goto L24
            r5.append(r7)
            goto L9b
        L24:
            if (r7 == r8) goto L6b
            r8 = 72
            if (r7 == r8) goto L68
            r8 = 77
            if (r7 == r8) goto L65
            r8 = 83
            if (r7 == r8) goto L62
            r8 = 100
            if (r7 == r8) goto L5f
            r8 = 109(0x6d, float:1.53E-43)
            if (r7 == r8) goto L5c
            r8 = 115(0x73, float:1.61E-43)
            if (r7 == r8) goto L59
            r8 = 121(0x79, float:1.7E-43)
            if (r7 == r8) goto L56
            if (r5 != 0) goto L51
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            org.apache.commons.lang3.time.X0o0xo$oIX0oI r8 = new org.apache.commons.lang3.time.X0o0xo$oIX0oI
            r8.<init>(r5)
            r0.add(r8)
        L51:
            r5.append(r7)
        L54:
            r7 = r2
            goto L80
        L56:
            java.lang.Object r7 = org.apache.commons.lang3.time.X0o0xo.f32907II0xO0
            goto L80
        L59:
            java.lang.Object r7 = org.apache.commons.lang3.time.X0o0xo.f32908Oxx0IOOO
            goto L80
        L5c:
            java.lang.Object r7 = org.apache.commons.lang3.time.X0o0xo.f32910XO
            goto L80
        L5f:
            java.lang.Object r7 = org.apache.commons.lang3.time.X0o0xo.f32912oxoX
            goto L80
        L62:
            java.lang.Object r7 = org.apache.commons.lang3.time.X0o0xo.f32906II0XooXoX
            goto L80
        L65:
            java.lang.Object r7 = org.apache.commons.lang3.time.X0o0xo.f32905I0Io
            goto L80
        L68:
            java.lang.Object r7 = org.apache.commons.lang3.time.X0o0xo.f32909X0o0xo
            goto L80
        L6b:
            if (r4 == 0) goto L71
            r5 = r2
            r7 = r5
            r4 = 0
            goto L80
        L71:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            org.apache.commons.lang3.time.X0o0xo$oIX0oI r4 = new org.apache.commons.lang3.time.X0o0xo$oIX0oI
            r4.<init>(r5)
            r0.add(r4)
            r4 = 1
            goto L54
        L80:
            if (r7 == 0) goto L9b
            if (r6 == 0) goto L92
            java.lang.Object r5 = r6.I0Io()
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L92
            r6.oxoX()
            goto L9a
        L92:
            org.apache.commons.lang3.time.X0o0xo$oIX0oI r6 = new org.apache.commons.lang3.time.X0o0xo$oIX0oI
            r6.<init>(r7)
            r0.add(r6)
        L9a:
            r5 = r2
        L9b:
            int r3 = r3 + 1
            goto Lf
        L9f:
            if (r4 != 0) goto Laa
            org.apache.commons.lang3.time.X0o0xo$oIX0oI[] r9 = new org.apache.commons.lang3.time.X0o0xo.oIX0oI[r1]
            java.lang.Object[] r9 = r0.toArray(r9)
            org.apache.commons.lang3.time.X0o0xo$oIX0oI[] r9 = (org.apache.commons.lang3.time.X0o0xo.oIX0oI[]) r9
            return r9
        Laa:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unmatched quote in format: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.X0o0xo.xoIox(java.lang.String):org.apache.commons.lang3.time.X0o0xo$oIX0oI[]");
    }

    public static String xxIXOIIO(long j, long j2) {
        return II0XooXoX(j, j2, f32911oIX0oI, false, TimeZone.getDefault());
    }

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f32913II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final Object f32914oIX0oI;

        public oIX0oI(Object obj) {
            this.f32914oIX0oI = obj;
            this.f32913II0xO0 = 1;
        }

        public static boolean oIX0oI(oIX0oI[] oix0oiArr, Object obj) {
            for (oIX0oI oix0oi : oix0oiArr) {
                if (oix0oi.I0Io() == obj) {
                    return true;
                }
            }
            return false;
        }

        public Object I0Io() {
            return this.f32914oIX0oI;
        }

        public int II0xO0() {
            return this.f32913II0xO0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof oIX0oI)) {
                return false;
            }
            oIX0oI oix0oi = (oIX0oI) obj;
            if (this.f32914oIX0oI.getClass() != oix0oi.f32914oIX0oI.getClass() || this.f32913II0xO0 != oix0oi.f32913II0xO0) {
                return false;
            }
            Object obj2 = this.f32914oIX0oI;
            if (obj2 instanceof StringBuilder) {
                return obj2.toString().equals(oix0oi.f32914oIX0oI.toString());
            }
            if (obj2 instanceof Number) {
                return obj2.equals(oix0oi.f32914oIX0oI);
            }
            if (obj2 != oix0oi.f32914oIX0oI) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f32914oIX0oI.hashCode();
        }

        public void oxoX() {
            this.f32913II0xO0++;
        }

        public String toString() {
            return xXOx.OXXoIoXI(this.f32914oIX0oI.toString(), this.f32913II0xO0);
        }

        public oIX0oI(Object obj, int i) {
            this.f32914oIX0oI = obj;
            this.f32913II0xO0 = i;
        }
    }
}
