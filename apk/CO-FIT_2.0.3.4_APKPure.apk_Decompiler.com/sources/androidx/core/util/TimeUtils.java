package androidx.core.util;

import androidx.annotation.RestrictTo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.io.PrintWriter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TimeUtils {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr = new char[24];
    private static final Object sFormatSync = new Object();

    private TimeUtils() {
    }

    private static int accumField(int i, int i2, boolean z, int i3) {
        if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        }
        if (i > 9 || (z && i3 >= 2)) {
            return i2 + 2;
        }
        if (z || i > 0) {
            return i2 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j, 0));
        }
    }

    private static int formatDurationLocked(long j, int i) {
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        boolean z2;
        int i7;
        boolean z3;
        int i8;
        boolean z4;
        int i9;
        int i10;
        boolean z5;
        boolean z6;
        boolean z7;
        int i11;
        long j2 = j;
        int i12 = i;
        if (sFormatStr.length < i12) {
            sFormatStr = new char[i12];
        }
        char[] cArr = sFormatStr;
        int i13 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i13 == 0) {
            int i14 = i12 - 1;
            while (i14 > 0) {
                cArr[0] = TokenParser.SP;
            }
            cArr[0] = '0';
            return 1;
        }
        if (i13 > 0) {
            c = '+';
        } else {
            j2 = -j2;
            c = '-';
        }
        int i15 = (int) (j2 % 1000);
        int floor = (int) Math.floor((double) (j2 / 1000));
        if (floor > 86400) {
            i2 = floor / 86400;
            floor -= 86400 * i2;
        } else {
            i2 = 0;
        }
        if (floor > 3600) {
            i3 = floor / 3600;
            floor -= i3 * 3600;
        } else {
            i3 = 0;
        }
        if (floor > 60) {
            int i16 = floor / 60;
            i4 = floor - (i16 * 60);
            i5 = i16;
        } else {
            i4 = floor;
            i5 = 0;
        }
        if (i12 != 0) {
            int accumField = accumField(i2, 1, false, 0);
            if (accumField > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            int accumField2 = accumField + accumField(i3, 1, z5, 2);
            if (accumField2 > 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            int accumField3 = accumField2 + accumField(i5, 1, z6, 2);
            if (accumField3 > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            int accumField4 = accumField3 + accumField(i4, 1, z7, 2);
            if (accumField4 > 0) {
                i11 = 3;
            } else {
                i11 = 0;
            }
            i6 = 0;
            for (int accumField5 = accumField4 + accumField(i15, 2, true, i11) + 1; accumField5 < i12; accumField5++) {
                cArr[i6] = TokenParser.SP;
                i6++;
            }
        } else {
            i6 = 0;
        }
        cArr[i6] = c;
        int i17 = i6 + 1;
        if (i12 != 0) {
            z = true;
        } else {
            z = false;
        }
        int i18 = i17;
        int printField = printField(cArr, i2, 'd', i17, false, 0);
        if (printField != i18) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z) {
            i7 = 2;
        } else {
            i7 = 0;
        }
        int printField2 = printField(cArr, i3, 'h', printField, z2, i7);
        if (printField2 != i18) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z) {
            i8 = 2;
        } else {
            i8 = 0;
        }
        int printField3 = printField(cArr, i5, 'm', printField2, z3, i8);
        if (printField3 != i18) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z) {
            i9 = 2;
        } else {
            i9 = 0;
        }
        int printField4 = printField(cArr, i4, 's', printField3, z4, i9);
        if (!z || printField4 == i18) {
            i10 = 0;
        } else {
            i10 = 3;
        }
        int printField5 = printField(cArr, i15, 'm', printField4, true, i10);
        cArr[printField5] = 's';
        return printField5 + 1;
    }

    private static int printField(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        if (!z && i <= 0) {
            return i2;
        }
        if ((!z || i3 < 3) && i <= 99) {
            i4 = i2;
        } else {
            int i5 = i / 100;
            cArr[i2] = (char) (i5 + 48);
            i4 = i2 + 1;
            i -= i5 * 100;
        }
        if ((z && i3 >= 2) || i > 9 || i2 != i4) {
            int i6 = i / 10;
            cArr[i4] = (char) (i6 + 48);
            i4++;
            i -= i6 * 10;
        }
        cArr[i4] = (char) (i + 48);
        cArr[i4 + 1] = c;
        return i4 + 2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, PrintWriter printWriter, int i) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j, i)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, PrintWriter printWriter) {
        formatDuration(j, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
        } else {
            formatDuration(j - j2, printWriter, 0);
        }
    }
}
