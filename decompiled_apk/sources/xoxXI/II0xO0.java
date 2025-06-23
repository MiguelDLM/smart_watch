package xoxXI;

import java.time.Instant;

/* loaded from: classes9.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final long f35193oIX0oI = 631065600000L;

    public static String II0xO0(String str) {
        Instant parse;
        Instant minusMillis;
        long epochSecond;
        try {
            parse = Instant.parse(str);
            minusMillis = parse.minusMillis(631065600000L);
            epochSecond = minusMillis.getEpochSecond();
            return String.valueOf(epochSecond);
        } catch (Exception unused) {
            return str;
        }
    }

    public static String oIX0oI(long j) {
        Instant ofEpochMilli;
        String instant;
        ofEpochMilli = Instant.ofEpochMilli((j * 1000) + 631065600000L);
        instant = ofEpochMilli.toString();
        return instant;
    }
}
