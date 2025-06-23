package I0O00OI;

import XO0.Oxx0IOOO;
import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes6.dex */
public class oIX0oI implements I0Io {

    /* renamed from: II0xO0, reason: collision with root package name */
    public I0Io f60II0xO0 = new I0O00OI.II0xO0();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public II0xO0 f61oIX0oI;

    /* loaded from: classes6.dex */
    public class II0xO0 extends HandlerThread {

        /* renamed from: XO, reason: collision with root package name */
        public Handler f63XO;

        public II0xO0(String str) {
            super(str);
        }

        public void oIX0oI(Runnable runnable) {
            Handler handler = this.f63XO;
            if (handler != null) {
                handler.post(runnable);
                return;
            }
            throw new NullPointerException("mAsyncHandler == null, please call start() first.");
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            super.start();
            this.f63XO = new Handler(getLooper());
        }
    }

    /* renamed from: I0O00OI.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0000oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Object f65Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oxx0IOOO f66XO;

        public RunnableC0000oIX0oI(Oxx0IOOO oxx0IOOO, Object obj) {
            this.f66XO = oxx0IOOO;
            this.f65Oo = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            oIX0oI.this.f60II0xO0.oIX0oI(this.f66XO, this.f65Oo);
        }
    }

    public oIX0oI() {
        II0xO0 iI0xO0 = new II0xO0(oIX0oI.class.getSimpleName());
        this.f61oIX0oI = iI0xO0;
        iI0xO0.start();
    }

    @Override // I0O00OI.I0Io
    public void oIX0oI(Oxx0IOOO oxx0IOOO, Object obj) {
        this.f61oIX0oI.oIX0oI(new RunnableC0000oIX0oI(oxx0IOOO, obj));
    }
}
