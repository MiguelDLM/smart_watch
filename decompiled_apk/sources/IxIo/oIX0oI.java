package IxIo;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

/* loaded from: classes13.dex */
public final class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final HashMap<String, HandlerThread> f1097oIX0oI = new HashMap<>();

    public static Looper II0xO0() {
        return oIX0oI("tanx_exposer_sdk").getLooper();
    }

    public static HandlerThread oIX0oI(String str) {
        HandlerThread handlerThread;
        HashMap<String, HandlerThread> hashMap = f1097oIX0oI;
        synchronized (hashMap) {
            try {
                handlerThread = hashMap.get(str);
                if (handlerThread != null && handlerThread.getLooper() == null) {
                    hashMap.remove(str);
                    handlerThread = null;
                }
                if (handlerThread == null) {
                    handlerThread = new HandlerThread(str);
                    handlerThread.start();
                    hashMap.put(str, handlerThread);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return handlerThread;
    }
}
