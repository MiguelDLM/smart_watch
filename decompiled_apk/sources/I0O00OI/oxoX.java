package I0O00OI;

import XO0.Oxx0IOOO;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes6.dex */
public class oxoX implements I0Io {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Handler f68oIX0oI = new Handler(Looper.getMainLooper());

    /* renamed from: II0xO0, reason: collision with root package name */
    public II0xO0 f67II0xO0 = new II0xO0();

    /* loaded from: classes6.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Object f70Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oxx0IOOO f71XO;

        public oIX0oI(Oxx0IOOO oxx0IOOO, Object obj) {
            this.f71XO = oxx0IOOO;
            this.f70Oo = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            oxoX.this.f67II0xO0.oIX0oI(this.f71XO, this.f70Oo);
        }
    }

    @Override // I0O00OI.I0Io
    public void oIX0oI(Oxx0IOOO oxx0IOOO, Object obj) {
        this.f68oIX0oI.post(new oIX0oI(oxx0IOOO, obj));
    }
}
