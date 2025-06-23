package O0IxXx;

import android.text.TextUtils;
import com.octopus.ad.internal.b.p;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* loaded from: classes11.dex */
public class Oxx0IOOO extends x0XOIxOo {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public II0xO0 f1228OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public final IoXIXo.II0xO0 f1229xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final xoIox f1230xxIXOIIO;

    public Oxx0IOOO(xoIox xoiox, IoXIXo.II0xO0 iI0xO0) {
        super(xoiox, iI0xO0);
        this.f1229xoIox = iI0xO0;
        this.f1230xxIXOIIO = xoiox;
    }

    @Override // O0IxXx.x0XOIxOo
    public void I0Io(int i) {
        II0xO0 iI0xO0 = this.f1228OOXIXo;
        if (iI0xO0 != null) {
            iI0xO0.oIX0oI(this.f1229xoIox.f812II0xO0, this.f1230xxIXOIIO.XO(), i);
        }
    }

    public final void IIXOooo(OutputStream outputStream, long j) throws p, IOException {
        xoIox xoiox = new xoIox(this.f1230xxIXOIIO);
        try {
            xoiox.a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = xoiox.a(bArr);
                if (a2 != -1) {
                    outputStream.write(bArr, 0, a2);
                } else {
                    outputStream.flush();
                    xoiox.b();
                    return;
                }
            }
        } catch (Throwable th) {
            xoiox.b();
            throw th;
        }
    }

    public void IXxxXO(X0o0xo x0o0xo, Socket socket) throws IOException, p {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(OxxIIOOXO(x0o0xo).getBytes("UTF-8"));
        long j = x0o0xo.f1234II0xO0;
        if (oI0IIXIo(x0o0xo)) {
            Oxx0xo(bufferedOutputStream, j);
        } else {
            IIXOooo(bufferedOutputStream, j);
        }
    }

    public void Oo(II0xO0 iI0xO0) {
        this.f1228OOXIXo = iI0xO0;
    }

    public final void Oxx0xo(OutputStream outputStream, long j) throws p, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int oIX0oI2 = oIX0oI(bArr, j, 8192);
            if (oIX0oI2 != -1) {
                outputStream.write(bArr, 0, oIX0oI2);
                j += oIX0oI2;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    public final String OxxIIOOXO(X0o0xo x0o0xo) throws IOException, p {
        long a2;
        boolean z;
        long j;
        boolean z2;
        String str;
        String str2;
        String str3;
        String X0o0xo2 = this.f1230xxIXOIIO.X0o0xo();
        boolean isEmpty = TextUtils.isEmpty(X0o0xo2);
        if (this.f1229xoIox.d()) {
            a2 = this.f1229xoIox.a();
        } else {
            a2 = this.f1230xxIXOIIO.a();
        }
        if (a2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        boolean z3 = x0o0xo.f1233I0Io;
        if (z3) {
            j = a2 - x0o0xo.f1234II0xO0;
        } else {
            j = a2;
        }
        if (z && z3) {
            z2 = true;
        } else {
            z2 = false;
        }
        StringBuilder sb = new StringBuilder();
        if (x0o0xo.f1233I0Io) {
            str = "HTTP/1.1 206 PARTIAL CONTENT\n";
        } else {
            str = "HTTP/1.1 200 OK\n";
        }
        sb.append(str);
        sb.append("Accept-Ranges: bytes\n");
        String str4 = "";
        if (!z) {
            str2 = "";
        } else {
            str2 = x0xO0oo("Content-Length: %d\n", Long.valueOf(j));
        }
        sb.append(str2);
        if (!z2) {
            str3 = "";
        } else {
            str3 = x0xO0oo("Content-Range: bytes %d-%d/%d\n", Long.valueOf(x0o0xo.f1234II0xO0), Long.valueOf(a2 - 1), Long.valueOf(a2));
        }
        sb.append(str3);
        if (!isEmpty) {
            str4 = x0xO0oo("Content-Type: %s\n", X0o0xo2);
        }
        sb.append(str4);
        sb.append("\n");
        return sb.toString();
    }

    public final boolean oI0IIXIo(X0o0xo x0o0xo) throws p {
        boolean z;
        long a2 = this.f1230xxIXOIIO.a();
        if (a2 > 0) {
            z = true;
        } else {
            z = false;
        }
        long a3 = this.f1229xoIox.a();
        if (z && x0o0xo.f1233I0Io && ((float) x0o0xo.f1234II0xO0) > ((float) a3) + (((float) a2) * 0.2f)) {
            return false;
        }
        return true;
    }

    public final String x0xO0oo(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }
}
