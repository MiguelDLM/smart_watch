package IOI;

import java.time.DateTimeException;
import java.time.ZoneOffset;

/* loaded from: classes6.dex */
public final class OooI {
    public static /* synthetic */ o0IXXIx II0xO0(Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        return oIX0oI(num, num2, num3);
    }

    @OXOo.OOXIXo
    public static final o0IXXIx oIX0oI(@OXOo.oOoXoXO Integer num, @OXOo.oOoXoXO Integer num2, @OXOo.oOoXoXO Integer num3) {
        o0IXXIx o0ixxix;
        ZoneOffset ofTotalSeconds;
        ZoneOffset ofHoursMinutesSeconds;
        int i;
        ZoneOffset ofHoursMinutesSeconds2;
        int i2 = 0;
        try {
            if (num != null) {
                int intValue = num.intValue();
                if (num2 != null) {
                    i = num2.intValue();
                } else {
                    i = 0;
                }
                if (num3 != null) {
                    i2 = num3.intValue();
                }
                ofHoursMinutesSeconds2 = ZoneOffset.ofHoursMinutesSeconds(intValue, i, i2);
                kotlin.jvm.internal.IIX0o.oO(ofHoursMinutesSeconds2, "ofHoursMinutesSeconds(...)");
                o0ixxix = new o0IXXIx(ofHoursMinutesSeconds2);
            } else if (num2 != null) {
                int intValue2 = num2.intValue() / 60;
                int intValue3 = num2.intValue() % 60;
                if (num3 != null) {
                    i2 = num3.intValue();
                }
                ofHoursMinutesSeconds = ZoneOffset.ofHoursMinutesSeconds(intValue2, intValue3, i2);
                kotlin.jvm.internal.IIX0o.oO(ofHoursMinutesSeconds, "ofHoursMinutesSeconds(...)");
                o0ixxix = new o0IXXIx(ofHoursMinutesSeconds);
            } else {
                if (num3 != null) {
                    i2 = num3.intValue();
                }
                ofTotalSeconds = ZoneOffset.ofTotalSeconds(i2);
                kotlin.jvm.internal.IIX0o.oO(ofTotalSeconds, "ofTotalSeconds(...)");
                o0ixxix = new o0IXXIx(ofTotalSeconds);
            }
            return o0ixxix;
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
