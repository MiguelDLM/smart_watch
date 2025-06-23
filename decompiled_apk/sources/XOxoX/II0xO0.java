package XOxoX;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes13.dex */
public class II0xO0 {
    public static String oIX0oI(long j, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return new SimpleDateFormat(str).format(calendar.getTime());
    }
}
