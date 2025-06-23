package okio;

import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import okio.ByteString;

@XO0OX.xxIXOIIO(name = "-Base64")
/* renamed from: okio.-Base64, reason: invalid class name */
/* loaded from: classes6.dex */
public final class Base64 {

    @OXOo.OOXIXo
    private static final byte[] BASE64;

    @OXOo.OOXIXo
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    @OXOo.oOoXoXO
    public static final byte[] decodeBase64ToArray(@OXOo.OOXIXo String str) {
        int i;
        char charAt;
        IIX0o.x0xO0oo(str, "<this>");
        int length = str.length();
        while (length > 0 && ((charAt = str.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i2 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt2 = str.charAt(i6);
            if ('A' <= charAt2 && charAt2 < '[') {
                i = charAt2 - 'A';
            } else if ('a' <= charAt2 && charAt2 < '{') {
                i = charAt2 - 'G';
            } else if ('0' <= charAt2 && charAt2 < ':') {
                i = charAt2 + 4;
            } else if (charAt2 != '+' && charAt2 != '-') {
                if (charAt2 != '/' && charAt2 != '_') {
                    if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                        return null;
                    }
                } else {
                    i = 63;
                }
            } else {
                i = 62;
            }
            i4 = (i4 << 6) | i;
            i3++;
            if (i3 % 4 == 0) {
                bArr[i5] = (byte) (i4 >> 16);
                int i7 = i5 + 2;
                bArr[i5 + 1] = (byte) (i4 >> 8);
                i5 += 3;
                bArr[i7] = (byte) i4;
            }
        }
        int i8 = i3 % 4;
        if (i8 == 1) {
            return null;
        }
        if (i8 != 2) {
            if (i8 == 3) {
                int i9 = i4 << 6;
                int i10 = i5 + 1;
                bArr[i5] = (byte) (i9 >> 16);
                i5 += 2;
                bArr[i10] = (byte) (i9 >> 8);
            }
        } else {
            bArr[i5] = (byte) ((i4 << 12) >> 16);
            i5++;
        }
        if (i5 == i2) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i5);
        IIX0o.oO(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    @OXOo.OOXIXo
    public static final String encodeBase64(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo byte[] map) {
        IIX0o.x0xO0oo(bArr, "<this>");
        IIX0o.x0xO0oo(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i + 2;
            byte b2 = bArr[i + 1];
            i += 3;
            byte b3 = bArr[i3];
            bArr2[i2] = map[(b & 255) >> 2];
            bArr2[i2 + 1] = map[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int i4 = i2 + 3;
            bArr2[i2 + 2] = map[((b2 & 15) << 2) | ((b3 & 255) >> 6)];
            i2 += 4;
            bArr2[i4] = map[b3 & Utf8.REPLACEMENT_BYTE];
        }
        int length2 = bArr.length - length;
        if (length2 != 1) {
            if (length2 == 2) {
                int i5 = i + 1;
                byte b4 = bArr[i];
                byte b5 = bArr[i5];
                bArr2[i2] = map[(b4 & 255) >> 2];
                bArr2[i2 + 1] = map[((b4 & 3) << 4) | ((b5 & 255) >> 4)];
                bArr2[i2 + 2] = map[(b5 & 15) << 2];
                bArr2[i2 + 3] = IIIxO.oIX0oI.f236II0XooXoX;
            }
        } else {
            byte b6 = bArr[i];
            bArr2[i2] = map[(b6 & 255) >> 2];
            bArr2[i2 + 1] = map[(b6 & 3) << 4];
            bArr2[i2 + 2] = IIIxO.oIX0oI.f236II0XooXoX;
            bArr2[i2 + 3] = IIIxO.oIX0oI.f236II0XooXoX;
        }
        return _JvmPlatformKt.toUtf8String(bArr2);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    @OXOo.OOXIXo
    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static /* synthetic */ void getBASE64$annotations() {
    }

    @OXOo.OOXIXo
    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }

    public static /* synthetic */ void getBASE64_URL_SAFE$annotations() {
    }
}
