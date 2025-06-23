package IxIo;

import android.os.Handler;

/* loaded from: classes13.dex */
public class II0xO0 {

    /* loaded from: classes13.dex */
    public static class oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Runnable f1096XO;

        public oIX0oI(Runnable runnable) {
            this.f1096XO = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f1096XO.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void oIX0oI(Runnable runnable, long j) {
        new Handler(IxIo.oIX0oI.II0xO0()).postDelayed(new oIX0oI(runnable), j);
    }
}
