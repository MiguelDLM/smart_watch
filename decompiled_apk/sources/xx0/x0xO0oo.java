package xx0;

import android.util.Log;

/* loaded from: classes13.dex */
public final class x0xO0oo extends OOXIXo {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final x0xO0oo f35246Oxx0xo = new x0xO0oo();

    @Override // xx0.OOXIXo
    public void XO(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8) {
                        if (i != 16) {
                            if (i == 32) {
                                Log.e(str, str2, th);
                                return;
                            }
                            return;
                        }
                        Log.e(str, str2, th);
                        return;
                    }
                    Log.w(str, str2, th);
                    return;
                }
                Log.i(str, str2, th);
                return;
            }
            Log.d(str, str2, th);
            return;
        }
        Log.v(str, str2, th);
    }
}
