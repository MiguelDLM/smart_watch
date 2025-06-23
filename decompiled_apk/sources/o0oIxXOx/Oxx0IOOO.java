package o0oIxXOx;

import java.util.Date;
import org.apache.commons.lang3.time.FastDateFormat;

/* loaded from: classes6.dex */
public final class Oxx0IOOO extends oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Oxx0IOOO f31155I0Io = new Oxx0IOOO();

    public final String Oxx0IOOO(long j, String str) {
        FastDateFormat fastDateFormat;
        if (str != null) {
            try {
                fastDateFormat = FastDateFormat.getInstance(str);
            } catch (Exception e) {
                throw oOoXoXO.II0xO0(e, "Invalid date format: [%s]", str);
            }
        } else {
            fastDateFormat = null;
        }
        if (fastDateFormat == null) {
            fastDateFormat = FastDateFormat.getInstance();
        }
        return fastDateFormat.format(new Date(j));
    }

    @Override // o0oIxXOx.OxxIIOOXO
    public String lookup(String str) {
        return Oxx0IOOO(System.currentTimeMillis(), str);
    }
}
