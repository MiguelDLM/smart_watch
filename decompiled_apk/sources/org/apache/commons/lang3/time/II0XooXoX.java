package org.apache.commons.lang3.time;

import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class II0XooXoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final Pattern f32882oIX0oI = Pattern.compile("^(?:(?i)GMT)?([+-])?(\\d\\d?)?(:?(\\d\\d?))?$");

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final TimeZone f32881II0xO0 = new GmtTimeZone(false, 0, 0);

    public static TimeZone I0Io(String str) {
        TimeZone II0xO02 = II0xO0(str);
        if (II0xO02 != null) {
            return II0xO02;
        }
        return TimeZone.getTimeZone(str);
    }

    public static TimeZone II0xO0(String str) {
        if (!"Z".equals(str) && !"UTC".equals(str)) {
            Matcher matcher = f32882oIX0oI.matcher(str);
            if (matcher.matches()) {
                int oxoX2 = oxoX(matcher.group(2));
                int oxoX3 = oxoX(matcher.group(4));
                if (oxoX2 == 0 && oxoX3 == 0) {
                    return f32881II0xO0;
                }
                return new GmtTimeZone(X0o0xo(matcher.group(1)), oxoX2, oxoX3);
            }
            return null;
        }
        return f32881II0xO0;
    }

    public static boolean X0o0xo(String str) {
        if (str == null || str.charAt(0) != '-') {
            return false;
        }
        return true;
    }

    public static TimeZone oIX0oI() {
        return f32881II0xO0;
    }

    public static int oxoX(String str) {
        if (str != null) {
            return Integer.parseInt(str);
        }
        return 0;
    }
}
