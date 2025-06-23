package O0IxXx;

import com.octopus.ad.internal.b.p;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes11.dex */
public class oOoXoXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f1236I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f1237II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final ExecutorService f1238oIX0oI = Executors.newSingleThreadExecutor();

    /* loaded from: classes11.dex */
    public class II0xO0 implements Callable<Boolean> {
        public II0xO0() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            return Boolean.valueOf(oOoXoXO.this.XO());
        }
    }

    public oOoXoXO(String str, int i) {
        this.f1237II0xO0 = (String) ooOOo0oXI.oIX0oI(str);
        this.f1236I0Io = i;
    }

    public boolean I0Io(int i, int i2) {
        boolean z;
        boolean z2;
        if (i >= 1) {
            z = true;
        } else {
            z = false;
        }
        ooOOo0oXI.I0Io(z);
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        ooOOo0oXI.I0Io(z2);
        int i3 = 0;
        while (i3 < i) {
            try {
            } catch (InterruptedException e) {
                e = e;
                com.octopus.ad.internal.utilities.oIX0oI.X0o0xo(com.octopus.ad.internal.utilities.oIX0oI.f18706x0xO0oo, "Error pinging server due to unexpected error", e);
            } catch (ExecutionException e2) {
                e = e2;
                com.octopus.ad.internal.utilities.oIX0oI.X0o0xo(com.octopus.ad.internal.utilities.oIX0oI.f18706x0xO0oo, "Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18706x0xO0oo, "Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            }
            if (((Boolean) this.f1238oIX0oI.submit(new II0xO0()).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i3++;
            i2 *= 2;
        }
        String format = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i3), Integer.valueOf(i2 / 2), oIX0oI());
        com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18706x0xO0oo, format + new p(format));
        return false;
    }

    public void II0xO0(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    public final String Oxx0IOOO() {
        return String.format(Locale.US, "http://%s:%d/%s", this.f1237II0xO0, Integer.valueOf(this.f1236I0Io), "ping");
    }

    public boolean X0o0xo(String str) {
        return "ping".equals(str);
    }

    public final boolean XO() throws p {
        xoIox xoiox = new xoIox(Oxx0IOOO());
        try {
            try {
                byte[] bytes = "ping ok".getBytes();
                xoiox.a(0L);
                byte[] bArr = new byte[bytes.length];
                xoiox.a(bArr);
                boolean equals = Arrays.equals(bytes, bArr);
                com.octopus.ad.internal.utilities.oIX0oI.IIXOooo(com.octopus.ad.internal.utilities.oIX0oI.f18706x0xO0oo, "Ping response: `" + new String(bArr) + "`, pinged? " + equals);
                return equals;
            } catch (p e) {
                com.octopus.ad.internal.utilities.oIX0oI.X0o0xo(com.octopus.ad.internal.utilities.oIX0oI.f18706x0xO0oo, "Error reading ping response", e);
                xoiox.b();
                return false;
            }
        } finally {
            xoiox.b();
        }
    }

    public final List<Proxy> oIX0oI() {
        try {
            return ProxySelector.getDefault().select(new URI(Oxx0IOOO()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }
}
