package O0IxXx;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.octopus.ad.internal.b.p;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes11.dex */
public final class xxIXOIIO {

    /* renamed from: I0Io, reason: collision with root package name */
    public volatile Oxx0IOOO f1254I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f1255II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final II0xO0 f1256X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final I0Io f1257XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final AtomicInteger f1258oIX0oI = new AtomicInteger(0);

    /* renamed from: oxoX, reason: collision with root package name */
    public final List<II0xO0> f1259oxoX;

    /* loaded from: classes11.dex */
    public static final class oIX0oI extends Handler implements II0xO0 {

        /* renamed from: Oo, reason: collision with root package name */
        public final List<II0xO0> f1260Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final String f1261XO;

        public oIX0oI(String str, List<II0xO0> list) {
            super(Looper.getMainLooper());
            this.f1261XO = str;
            this.f1260Oo = list;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator<II0xO0> it = this.f1260Oo.iterator();
            while (it.hasNext()) {
                it.next().oIX0oI((File) message.obj, this.f1261XO, message.arg1);
            }
        }

        @Override // O0IxXx.II0xO0
        public void oIX0oI(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }
    }

    public xxIXOIIO(String str, I0Io i0Io) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f1259oxoX = copyOnWriteArrayList;
        this.f1255II0xO0 = (String) ooOOo0oXI.oIX0oI(str);
        this.f1257XO = (I0Io) ooOOo0oXI.oIX0oI(i0Io);
        this.f1256X0o0xo = new oIX0oI(str, copyOnWriteArrayList);
    }

    public void I0Io(X0o0xo x0o0xo, Socket socket) throws p, IOException {
        oxoX();
        try {
            this.f1258oIX0oI.incrementAndGet();
            this.f1254I0Io.IXxxXO(x0o0xo, socket);
        } finally {
            XO();
        }
    }

    public void II0xO0(II0xO0 iI0xO0) {
        this.f1259oxoX.add(iI0xO0);
    }

    public final Oxx0IOOO Oxx0IOOO() throws p {
        String str = this.f1255II0xO0;
        I0Io i0Io = this.f1257XO;
        Oxx0IOOO oxx0IOOO = new Oxx0IOOO(new xoIox(str, i0Io.f1203oxoX, i0Io.f1201X0o0xo), new IoXIXo.II0xO0(this.f1257XO.oIX0oI(this.f1255II0xO0), this.f1257XO.f1199I0Io));
        oxx0IOOO.Oo(this.f1256X0o0xo);
        return oxx0IOOO;
    }

    public void X0o0xo(II0xO0 iI0xO0) {
        this.f1259oxoX.remove(iI0xO0);
    }

    public final synchronized void XO() {
        if (this.f1258oIX0oI.decrementAndGet() <= 0) {
            this.f1254I0Io.II0xO0();
            this.f1254I0Io = null;
        }
    }

    public int oIX0oI() {
        return this.f1258oIX0oI.get();
    }

    public final synchronized void oxoX() throws p {
        Oxx0IOOO oxx0IOOO;
        try {
            if (this.f1254I0Io == null) {
                oxx0IOOO = Oxx0IOOO();
            } else {
                oxx0IOOO = this.f1254I0Io;
            }
            this.f1254I0Io = oxx0IOOO;
        } catch (Throwable th) {
            throw th;
        }
    }
}
