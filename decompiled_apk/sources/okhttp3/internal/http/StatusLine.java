package okhttp3.internal.http;

import OXOo.OOXIXo;
import XO0OX.XO;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.OxI;
import okhttp3.Protocol;
import okhttp3.Response;

/* loaded from: classes6.dex */
public final class StatusLine {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;

    @XO
    public final int code;

    @OOXIXo
    @XO
    public final String message;

    @OOXIXo
    @XO
    public final Protocol protocol;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final StatusLine get(@OOXIXo Response response) {
            IIX0o.x0xO0oo(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        @OOXIXo
        public final StatusLine parse(@OOXIXo String statusLine) throws IOException {
            Protocol protocol;
            int i;
            String str;
            IIX0o.x0xO0oo(statusLine, "statusLine");
            if (OxI.IOOoXo0Ix(statusLine, "HTTP/1.", false, 2, null)) {
                i = 9;
                if (statusLine.length() >= 9 && statusLine.charAt(8) == ' ') {
                    int charAt = statusLine.charAt(7) - '0';
                    if (charAt != 0) {
                        if (charAt == 1) {
                            protocol = Protocol.HTTP_1_1;
                        } else {
                            throw new ProtocolException("Unexpected status line: " + statusLine);
                        }
                    } else {
                        protocol = Protocol.HTTP_1_0;
                    }
                } else {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
            } else if (OxI.IOOoXo0Ix(statusLine, "ICY ", false, 2, null)) {
                protocol = Protocol.HTTP_1_0;
                i = 4;
            } else {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            int i2 = i + 3;
            if (statusLine.length() >= i2) {
                try {
                    String substring = statusLine.substring(i, i2);
                    IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    int parseInt = Integer.parseInt(substring);
                    if (statusLine.length() > i2) {
                        if (statusLine.charAt(i2) == ' ') {
                            str = statusLine.substring(i + 4);
                            IIX0o.oO(str, "this as java.lang.String).substring(startIndex)");
                        } else {
                            throw new ProtocolException("Unexpected status line: " + statusLine);
                        }
                    } else {
                        str = "";
                    }
                    return new StatusLine(protocol, parseInt, str);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
            }
            throw new ProtocolException("Unexpected status line: " + statusLine);
        }

        private Companion() {
        }
    }

    public StatusLine(@OOXIXo Protocol protocol, int i, @OOXIXo String message) {
        IIX0o.x0xO0oo(protocol, "protocol");
        IIX0o.x0xO0oo(message, "message");
        this.protocol = protocol;
        this.code = i;
        this.message = message;
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(TokenParser.SP);
        sb.append(this.code);
        sb.append(TokenParser.SP);
        sb.append(this.message);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
