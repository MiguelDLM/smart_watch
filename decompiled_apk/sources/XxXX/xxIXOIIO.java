package XxXX;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.params.HttpParams;

@TargetApi(17)
/* loaded from: classes13.dex */
public class xxIXOIIO implements LayeredSocketFactory {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final HostnameVerifier f4233II0xO0 = new StrictHostnameVerifier();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public SSLCertificateSocketFactory f4234oIX0oI = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(0, null);

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) throws IOException {
        socket.connect(new InetSocketAddress(str, i));
        return socket;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        return new Socket();
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public boolean isSecure(Socket socket) throws IllegalArgumentException {
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).isConnected();
        }
        return false;
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        xx0.xxIXOIIO.IXxxXO("SNISocketFactory", "createSocket " + socket.toString() + " host:" + str + " port:" + i + " autoClose:" + z);
        SSLSocket sSLSocket = (SSLSocket) this.f4234oIX0oI.createSocket(socket, str, i, z);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        xx0.xxIXOIIO.IXxxXO("SNISocketFactory", "Setting SNI hostname");
        this.f4234oIX0oI.setHostname(sSLSocket, str);
        if (f4233II0xO0.verify(str, sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }
}
