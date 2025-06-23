package okhttp3.internal.http2;

import OXOo.OOXIXo;
import XO0OX.XO;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.OxI;
import okhttp3.internal.Util;
import okio.ByteString;

/* loaded from: classes6.dex */
public final class Http2 {

    @OOXIXo
    private static final String[] BINARY;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    @OOXIXo
    public static final Http2 INSTANCE = new Http2();

    @OOXIXo
    @XO
    public static final ByteString CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    @OOXIXo
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    @OOXIXo
    private static final String[] FLAGS = new String[64];

    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            IIX0o.oO(binaryString, "toBinaryString(it)");
            strArr[i] = OxI.oXO0oOx0(Util.format("%8s", binaryString), TokenParser.SP, '0', false, 4, null);
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i2 = iArr[0];
        strArr2[i2 | 8] = strArr2[i2] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr2[i3];
            int i5 = iArr[0];
            String[] strArr3 = FLAGS;
            int i6 = i5 | i4;
            strArr3[i6] = strArr3[i5] + '|' + strArr3[i4];
            strArr3[i6 | 8] = strArr3[i5] + '|' + strArr3[i4] + "|PADDED";
        }
        int length = FLAGS.length;
        for (int i7 = 0; i7 < length; i7++) {
            String[] strArr4 = FLAGS;
            if (strArr4[i7] == null) {
                strArr4[i7] = BINARY[i7];
            }
        }
    }

    private Http2() {
    }

    @OOXIXo
    public final String formatFlags(int i, int i2) {
        String str;
        if (i2 == 0) {
            return "";
        }
        if (i != 2 && i != 3) {
            if (i != 4 && i != 6) {
                if (i != 7 && i != 8) {
                    String[] strArr = FLAGS;
                    if (i2 < strArr.length) {
                        str = strArr[i2];
                        IIX0o.ooOOo0oXI(str);
                    } else {
                        str = BINARY[i2];
                    }
                    String str2 = str;
                    if (i == 5 && (i2 & 4) != 0) {
                        return OxI.IIOIX(str2, "HEADERS", "PUSH_PROMISE", false, 4, null);
                    }
                    if (i == 0 && (i2 & 32) != 0) {
                        return OxI.IIOIX(str2, "PRIORITY", "COMPRESSED", false, 4, null);
                    }
                    return str2;
                }
            } else {
                if (i2 == 1) {
                    return "ACK";
                }
                return BINARY[i2];
            }
        }
        return BINARY[i2];
    }

    @OOXIXo
    public final String formattedType$okhttp(int i) {
        String[] strArr = FRAME_NAMES;
        if (i < strArr.length) {
            return strArr[i];
        }
        return Util.format("0x%02x", Integer.valueOf(i));
    }

    @OOXIXo
    public final String frameLog(boolean z, int i, int i2, int i3, int i4) {
        String str;
        String formattedType$okhttp = formattedType$okhttp(i3);
        String formatFlags = formatFlags(i3, i4);
        if (z) {
            str = "<<";
        } else {
            str = ">>";
        }
        return Util.format("%s 0x%08x %5d %-13s %s", str, Integer.valueOf(i), Integer.valueOf(i2), formattedType$okhttp, formatFlags);
    }
}
