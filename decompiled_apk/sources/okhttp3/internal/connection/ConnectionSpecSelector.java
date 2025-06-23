package okhttp3.internal.connection;

import OXOo.OOXIXo;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.IIX0o;
import okhttp3.ConnectionSpec;

/* loaded from: classes6.dex */
public final class ConnectionSpecSelector {

    @OOXIXo
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(@OOXIXo List<ConnectionSpec> connectionSpecs) {
        IIX0o.x0xO0oo(connectionSpecs, "connectionSpecs");
        this.connectionSpecs = connectionSpecs;
    }

    private final boolean isFallbackPossible(SSLSocket sSLSocket) {
        int size = this.connectionSpecs.size();
        for (int i = this.nextModeIndex; i < size; i++) {
            if (this.connectionSpecs.get(i).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    @OOXIXo
    public final ConnectionSpec configureSecureSocket(@OOXIXo SSLSocket sslSocket) throws IOException {
        ConnectionSpec connectionSpec;
        IIX0o.x0xO0oo(sslSocket, "sslSocket");
        int i = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i < size) {
                connectionSpec = this.connectionSpecs.get(i);
                if (connectionSpec.isCompatible(sslSocket)) {
                    this.nextModeIndex = i + 1;
                    break;
                }
                i++;
            } else {
                connectionSpec = null;
                break;
            }
        }
        if (connectionSpec != null) {
            this.isFallbackPossible = isFallbackPossible(sslSocket);
            connectionSpec.apply$okhttp(sslSocket, this.isFallback);
            return connectionSpec;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.isFallback);
        sb.append(", modes=");
        sb.append(this.connectionSpecs);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        IIX0o.ooOOo0oXI(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        IIX0o.oO(arrays, "toString(this)");
        sb.append(arrays);
        throw new UnknownServiceException(sb.toString());
    }

    public final boolean connectionFailed(@OOXIXo IOException e) {
        IIX0o.x0xO0oo(e, "e");
        this.isFallback = true;
        if (this.isFallbackPossible && !(e instanceof ProtocolException) && !(e instanceof InterruptedIOException) && ((!(e instanceof SSLHandshakeException) || !(e.getCause() instanceof CertificateException)) && !(e instanceof SSLPeerUnverifiedException) && (e instanceof SSLException))) {
            return true;
        }
        return false;
    }
}
