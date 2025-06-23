package com.baidu.navisdk.debug;

import com.baidu.navisdk.util.common.g;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.File;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

/* loaded from: classes7.dex */
public class c {
    public static String[] a(String[] strArr, long j, long j2) {
        if (strArr == null) {
            return null;
        }
        Arrays.sort(strArr);
        g gVar = g.EYE_SPY;
        if (gVar.d()) {
            gVar.e("getSubInTime arrays " + Arrays.toString(strArr));
            gVar.e("getSubInTime start-end " + j + HelpFormatter.DEFAULT_OPT_PREFIX + j2);
        }
        if (j < 0) {
            j = 0;
        }
        if (j2 <= 0) {
            j2 = System.currentTimeMillis();
        }
        Date date = new Date(j);
        Date date2 = new Date(j2);
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        while (i3 < strArr.length) {
            try {
                Date a2 = a(strArr[i3]);
                if (i < 0 && a2.compareTo(date) >= 0) {
                    i = i3 == 0 ? 0 : i3 - 1;
                }
                if (a2.compareTo(date2) < 0) {
                    i2 = i3 + 1;
                }
            } catch (Exception e) {
                g gVar2 = g.EYE_SPY;
                if (gVar2.c()) {
                    gVar2.c("getSubInTime error " + e.toString());
                }
            }
            i3++;
        }
        g gVar3 = g.EYE_SPY;
        if (gVar3.d()) {
            gVar3.e("getSubInTime index " + i + HelpFormatter.DEFAULT_OPT_PREFIX + i2);
        }
        if (i < 0 || i2 < 0) {
            return null;
        }
        return (String[]) Arrays.copyOfRange(strArr, i, i2);
    }

    public static Date a(String str) throws ParseException {
        if (str.startsWith("nav_core")) {
            return a.b.parse(str.substring(9));
        }
        if (str.startsWith("nav_all")) {
            return a.b.parse(str.substring(8));
        }
        throw new ParseException("start is error" + str, -1);
    }

    public static String[] a(String[] strArr, long j) {
        int length = strArr.length;
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2--) {
            i = (int) (i + new File(strArr[i2]).length());
            if (i > j) {
                return (String[]) Arrays.copyOfRange(strArr, i2 + 1, length);
            }
        }
        return strArr;
    }
}
