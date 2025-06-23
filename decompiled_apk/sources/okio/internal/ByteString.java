package okio.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import okio.Base64;
import okio.Buffer;
import okio.SegmentedByteString;
import okio._JvmPlatformKt;
import org.apache.commons.lang3.xXOx;

@xxIXOIIO(name = "-ByteString")
@XX({"SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/internal/-ByteString\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Utf8.kt\nokio/Utf8\n*L\n1#1,363:1\n131#1,2:369\n133#1,9:372\n68#2:364\n74#2:365\n74#2:367\n74#2:368\n68#2:396\n74#2:408\n1#3:366\n1#3:371\n212#4,7:381\n122#4:388\n219#4,5:389\n122#4:394\n226#4:395\n228#4:397\n397#4,2:398\n122#4:400\n400#4,6:401\n127#4:407\n406#4:409\n122#4:410\n407#4,13:411\n122#4:424\n422#4:425\n122#4:426\n425#4:427\n230#4,3:428\n440#4,3:431\n122#4:434\n443#4:435\n127#4:436\n446#4,10:437\n127#4:447\n456#4:448\n122#4:449\n457#4,4:450\n127#4:454\n461#4:455\n122#4:456\n462#4,14:457\n122#4:471\n477#4,2:472\n122#4:474\n481#4:475\n122#4:476\n484#4:477\n234#4,3:478\n500#4,3:481\n122#4:484\n503#4:485\n127#4:486\n506#4,2:487\n127#4:489\n510#4,10:490\n127#4:500\n520#4:501\n122#4:502\n521#4,4:503\n127#4:507\n525#4:508\n122#4:509\n526#4,4:510\n127#4:514\n530#4:515\n122#4:516\n531#4,15:517\n122#4:532\n547#4,2:533\n122#4:535\n550#4,2:536\n122#4:538\n554#4:539\n122#4:540\n557#4:541\n241#4:542\n122#4:543\n242#4,5:544\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/internal/-ByteString\n*L\n329#1:369,2\n329#1:372,9\n67#1:364\n68#1:365\n258#1:367\n259#1:368\n348#1:396\n348#1:408\n329#1:371\n348#1:381,7\n353#1:388\n348#1:389,5\n353#1:394\n348#1:395\n348#1:397\n348#1:398,2\n353#1:400\n348#1:401,6\n348#1:407\n348#1:409\n353#1:410\n348#1:411,13\n353#1:424\n348#1:425\n353#1:426\n348#1:427\n348#1:428,3\n348#1:431,3\n353#1:434\n348#1:435\n348#1:436\n348#1:437,10\n348#1:447\n348#1:448\n353#1:449\n348#1:450,4\n348#1:454\n348#1:455\n353#1:456\n348#1:457,14\n353#1:471\n348#1:472,2\n353#1:474\n348#1:475\n353#1:476\n348#1:477\n348#1:478,3\n348#1:481,3\n353#1:484\n348#1:485\n348#1:486\n348#1:487,2\n348#1:489\n348#1:490,10\n348#1:500\n348#1:501\n353#1:502\n348#1:503,4\n348#1:507\n348#1:508\n353#1:509\n348#1:510,4\n348#1:514\n348#1:515\n353#1:516\n348#1:517,15\n353#1:532\n348#1:533,2\n353#1:535\n348#1:536,2\n353#1:538\n348#1:539\n353#1:540\n348#1:541\n348#1:542\n353#1:543\n348#1:544,5\n*E\n"})
/* renamed from: okio.internal.-ByteString */
/* loaded from: classes6.dex */
public final class ByteString {

    @OOXIXo
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int codePointIndexToCharIndex(byte[] bArr, int i) {
        int i2;
        byte b;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int length = bArr.length;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        loop0: while (i8 < length) {
            byte b2 = bArr[i8];
            if (b2 >= 0) {
                int i11 = i10 + 1;
                if (i10 == i) {
                    return i9;
                }
                if ((b2 != 10 && b2 != 13 && ((b2 >= 0 && b2 < 32) || (Byte.MAX_VALUE <= b2 && b2 < 160))) || b2 == 65533) {
                    return -1;
                }
                if (b2 < 65536) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                i9 += i2;
                i8++;
                while (true) {
                    i10 = i11;
                    if (i8 < length && (b = bArr[i8]) >= 0) {
                        i8++;
                        i11 = i10 + 1;
                        if (i10 == i) {
                            return i9;
                        }
                        if ((b == 10 || b == 13 || ((b < 0 || b >= 32) && (Byte.MAX_VALUE > b || b >= 160))) && b != 65533) {
                            if (b < 65536) {
                                i3 = 1;
                            } else {
                                i3 = 2;
                            }
                            i9 += i3;
                        }
                    }
                }
            } else if ((b2 >> 5) == -2) {
                int i12 = i8 + 1;
                if (length <= i12) {
                    if (i10 != i) {
                        return -1;
                    }
                    return i9;
                }
                byte b3 = bArr[i12];
                if ((b3 & 192) == 128) {
                    int i13 = (b2 << 6) ^ (b3 ^ 3968);
                    if (i13 < 128) {
                        if (i10 != i) {
                            return -1;
                        }
                        return i9;
                    }
                    int i14 = i10 + 1;
                    if (i10 == i) {
                        return i9;
                    }
                    if ((i13 != 10 && i13 != 13 && ((i13 >= 0 && i13 < 32) || (127 <= i13 && i13 < 160))) || i13 == 65533) {
                        return -1;
                    }
                    if (i13 < 65536) {
                        i4 = 1;
                    } else {
                        i4 = 2;
                    }
                    i9 += i4;
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    i8 += 2;
                    i10 = i14;
                } else {
                    if (i10 != i) {
                        return -1;
                    }
                    return i9;
                }
            } else {
                if ((b2 >> 4) == -2) {
                    int i15 = i8 + 2;
                    if (length <= i15) {
                        if (i10 != i) {
                            return -1;
                        }
                        return i9;
                    }
                    byte b4 = bArr[i8 + 1];
                    if ((b4 & 192) == 128) {
                        byte b5 = bArr[i15];
                        if ((b5 & 192) == 128) {
                            int i16 = (b2 << 12) ^ ((b5 ^ (-123008)) ^ (b4 << 6));
                            if (i16 < 2048) {
                                if (i10 != i) {
                                    return -1;
                                }
                                return i9;
                            }
                            if (55296 <= i16 && i16 < 57344) {
                                if (i10 != i) {
                                    return -1;
                                }
                                return i9;
                            }
                            i5 = i10 + 1;
                            if (i10 == i) {
                                return i9;
                            }
                            if ((i16 != 10 && i16 != 13 && ((i16 >= 0 && i16 < 32) || (127 <= i16 && i16 < 160))) || i16 == 65533) {
                                return -1;
                            }
                            if (i16 < 65536) {
                                i7 = 1;
                            } else {
                                i7 = 2;
                            }
                            i9 += i7;
                            oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
                            i8 += 3;
                        } else {
                            if (i10 != i) {
                                return -1;
                            }
                            return i9;
                        }
                    } else {
                        if (i10 != i) {
                            return -1;
                        }
                        return i9;
                    }
                } else if ((b2 >> 3) == -2) {
                    int i17 = i8 + 3;
                    if (length <= i17) {
                        if (i10 != i) {
                            return -1;
                        }
                        return i9;
                    }
                    byte b6 = bArr[i8 + 1];
                    if ((b6 & 192) == 128) {
                        byte b7 = bArr[i8 + 2];
                        if ((b7 & 192) == 128) {
                            byte b8 = bArr[i17];
                            if ((b8 & 192) == 128) {
                                int i18 = (b2 << 18) ^ (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << 12));
                                if (i18 > 1114111) {
                                    if (i10 != i) {
                                        return -1;
                                    }
                                    return i9;
                                }
                                if (55296 <= i18 && i18 < 57344) {
                                    if (i10 != i) {
                                        return -1;
                                    }
                                    return i9;
                                }
                                if (i18 < 65536) {
                                    if (i10 != i) {
                                        return -1;
                                    }
                                    return i9;
                                }
                                i5 = i10 + 1;
                                if (i10 == i) {
                                    return i9;
                                }
                                if ((i18 != 10 && i18 != 13 && ((i18 >= 0 && i18 < 32) || (127 <= i18 && i18 < 160))) || i18 == 65533) {
                                    return -1;
                                }
                                if (i18 < 65536) {
                                    i6 = 1;
                                } else {
                                    i6 = 2;
                                }
                                i9 += i6;
                                oXIO0o0XI oxio0o0xi3 = oXIO0o0XI.f29392oIX0oI;
                                i8 += 4;
                            } else {
                                if (i10 != i) {
                                    return -1;
                                }
                                return i9;
                            }
                        } else {
                            if (i10 != i) {
                                return -1;
                            }
                            return i9;
                        }
                    } else {
                        if (i10 != i) {
                            return -1;
                        }
                        return i9;
                    }
                } else {
                    if (i10 != i) {
                        return -1;
                    }
                    return i9;
                }
                i10 = i5;
            }
        }
        return i9;
    }

    @OOXIXo
    public static final String commonBase64(@OOXIXo okio.ByteString byteString) {
        IIX0o.x0xO0oo(byteString, "<this>");
        return Base64.encodeBase64$default(byteString.getData$okio(), null, 1, null);
    }

    @OOXIXo
    public static final String commonBase64Url(@OOXIXo okio.ByteString byteString) {
        IIX0o.x0xO0oo(byteString, "<this>");
        return Base64.encodeBase64(byteString.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@OOXIXo okio.ByteString byteString, @OOXIXo okio.ByteString other) {
        IIX0o.x0xO0oo(byteString, "<this>");
        IIX0o.x0xO0oo(other, "other");
        int size = byteString.size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            int i2 = byteString.getByte(i) & 255;
            int i3 = other.getByte(i) & 255;
            if (i2 != i3) {
                if (i2 < i3) {
                    return -1;
                }
                return 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size < size2) {
            return -1;
        }
        return 1;
    }

    public static final void commonCopyInto(@OOXIXo okio.ByteString byteString, int i, @OOXIXo byte[] target, int i2, int i3) {
        IIX0o.x0xO0oo(byteString, "<this>");
        IIX0o.x0xO0oo(target, "target");
        ooOOo0oXI.O00XxXI(byteString.getData$okio(), target, i2, i, i3 + i);
    }

    @oOoXoXO
    public static final okio.ByteString commonDecodeBase64(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new okio.ByteString(decodeBase64ToArray);
        }
        return null;
    }

    @OOXIXo
    public static final okio.ByteString commonDecodeHex(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((decodeHexDigit(str.charAt(i2)) << 4) + decodeHexDigit(str.charAt(i2 + 1)));
            }
            return new okio.ByteString(bArr);
        }
        throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
    }

    @OOXIXo
    public static final okio.ByteString commonEncodeUtf8(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        okio.ByteString byteString = new okio.ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(@OOXIXo okio.ByteString byteString, @OOXIXo okio.ByteString suffix) {
        IIX0o.x0xO0oo(byteString, "<this>");
        IIX0o.x0xO0oo(suffix, "suffix");
        return byteString.rangeEquals(byteString.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEquals(@OOXIXo okio.ByteString byteString, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof okio.ByteString) {
            okio.ByteString byteString2 = (okio.ByteString) obj;
            if (byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@OOXIXo okio.ByteString byteString, int i) {
        IIX0o.x0xO0oo(byteString, "<this>");
        return byteString.getData$okio()[i];
    }

    public static final int commonGetSize(@OOXIXo okio.ByteString byteString) {
        IIX0o.x0xO0oo(byteString, "<this>");
        return byteString.getData$okio().length;
    }

    public static final int commonHashCode(@OOXIXo okio.ByteString byteString) {
        IIX0o.x0xO0oo(byteString, "<this>");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    @OOXIXo
    public static final String commonHex(@OOXIXo okio.ByteString byteString) {
        IIX0o.x0xO0oo(byteString, "<this>");
        char[] cArr = new char[byteString.getData$okio().length * 2];
        int i = 0;
        for (byte b : byteString.getData$okio()) {
            int i2 = i + 1;
            cArr[i] = getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i += 2;
            cArr[i2] = getHEX_DIGIT_CHARS()[b & 15];
        }
        return OxI.I0xX0(cArr);
    }

    public static final int commonIndexOf(@OOXIXo okio.ByteString byteString, @OOXIXo byte[] other, int i) {
        IIX0o.x0xO0oo(byteString, "<this>");
        IIX0o.x0xO0oo(other, "other");
        int length = byteString.getData$okio().length - other.length;
        int max = Math.max(i, 0);
        if (max <= length) {
            while (!SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), max, other, 0, other.length)) {
                if (max != length) {
                    max++;
                } else {
                    return -1;
                }
            }
            return max;
        }
        return -1;
    }

    @OOXIXo
    public static final byte[] commonInternalArray(@OOXIXo okio.ByteString byteString) {
        IIX0o.x0xO0oo(byteString, "<this>");
        return byteString.getData$okio();
    }

    public static final int commonLastIndexOf(@OOXIXo okio.ByteString byteString, @OOXIXo okio.ByteString other, int i) {
        IIX0o.x0xO0oo(byteString, "<this>");
        IIX0o.x0xO0oo(other, "other");
        return byteString.lastIndexOf(other.internalArray$okio(), i);
    }

    @OOXIXo
    public static final okio.ByteString commonOf(@OOXIXo byte[] data) {
        IIX0o.x0xO0oo(data, "data");
        byte[] copyOf = Arrays.copyOf(data, data.length);
        IIX0o.oO(copyOf, "copyOf(this, size)");
        return new okio.ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(@OOXIXo okio.ByteString byteString, int i, @OOXIXo okio.ByteString other, int i2, int i3) {
        IIX0o.x0xO0oo(byteString, "<this>");
        IIX0o.x0xO0oo(other, "other");
        return other.rangeEquals(i2, byteString.getData$okio(), i, i3);
    }

    public static final boolean commonStartsWith(@OOXIXo okio.ByteString byteString, @OOXIXo okio.ByteString prefix) {
        IIX0o.x0xO0oo(byteString, "<this>");
        IIX0o.x0xO0oo(prefix, "prefix");
        return byteString.rangeEquals(0, prefix, 0, prefix.size());
    }

    @OOXIXo
    public static final okio.ByteString commonSubstring(@OOXIXo okio.ByteString byteString, int i, int i2) {
        IIX0o.x0xO0oo(byteString, "<this>");
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(byteString, i2);
        if (i >= 0) {
            if (resolveDefaultParameter <= byteString.getData$okio().length) {
                if (resolveDefaultParameter - i >= 0) {
                    if (i == 0 && resolveDefaultParameter == byteString.getData$okio().length) {
                        return byteString;
                    }
                    return new okio.ByteString(ooOOo0oXI.xxOXOOoIX(byteString.getData$okio(), i, resolveDefaultParameter));
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + HexStringBuilder.COMMENT_END_CHAR).toString());
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    @OOXIXo
    public static final okio.ByteString commonToAsciiLowercase(@OOXIXo okio.ByteString byteString) {
        IIX0o.x0xO0oo(byteString, "<this>");
        for (int i = 0; i < byteString.getData$okio().length; i++) {
            byte b = byteString.getData$okio()[i];
            if (b >= 65 && b <= 90) {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                IIX0o.oO(copyOf, "copyOf(this, size)");
                copyOf[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b2 = copyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        copyOf[i2] = (byte) (b2 + 32);
                    }
                }
                return new okio.ByteString(copyOf);
            }
        }
        return byteString;
    }

    @OOXIXo
    public static final okio.ByteString commonToAsciiUppercase(@OOXIXo okio.ByteString byteString) {
        IIX0o.x0xO0oo(byteString, "<this>");
        for (int i = 0; i < byteString.getData$okio().length; i++) {
            byte b = byteString.getData$okio()[i];
            if (b >= 97 && b <= 122) {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                IIX0o.oO(copyOf, "copyOf(this, size)");
                copyOf[i] = (byte) (b - 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b2 = copyOf[i2];
                    if (b2 >= 97 && b2 <= 122) {
                        copyOf[i2] = (byte) (b2 - 32);
                    }
                }
                return new okio.ByteString(copyOf);
            }
        }
        return byteString;
    }

    @OOXIXo
    public static final byte[] commonToByteArray(@OOXIXo okio.ByteString byteString) {
        IIX0o.x0xO0oo(byteString, "<this>");
        byte[] data$okio = byteString.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        IIX0o.oO(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @OOXIXo
    public static final okio.ByteString commonToByteString(@OOXIXo byte[] bArr, int i, int i2) {
        IIX0o.x0xO0oo(bArr, "<this>");
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(bArr, i2);
        SegmentedByteString.checkOffsetAndCount(bArr.length, i, resolveDefaultParameter);
        return new okio.ByteString(ooOOo0oXI.xxOXOOoIX(bArr, i, resolveDefaultParameter + i));
    }

    @OOXIXo
    public static final String commonToString(@OOXIXo okio.ByteString byteString) {
        okio.ByteString byteString2 = byteString;
        IIX0o.x0xO0oo(byteString2, "<this>");
        if (byteString.getData$okio().length != 0) {
            int codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
            if (codePointIndexToCharIndex == -1) {
                if (byteString.getData$okio().length <= 64) {
                    return "[hex=" + byteString.hex() + ']';
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[size=");
                sb.append(byteString.getData$okio().length);
                sb.append(" hex=");
                int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(byteString2, 64);
                if (resolveDefaultParameter <= byteString.getData$okio().length) {
                    if (resolveDefaultParameter >= 0) {
                        if (resolveDefaultParameter != byteString.getData$okio().length) {
                            byteString2 = new okio.ByteString(ooOOo0oXI.xxOXOOoIX(byteString.getData$okio(), 0, resolveDefaultParameter));
                        }
                        sb.append(byteString2.hex());
                        sb.append("…]");
                        return sb.toString();
                    }
                    throw new IllegalArgumentException("endIndex < beginIndex");
                }
                throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + HexStringBuilder.COMMENT_END_CHAR).toString());
            }
            String utf8 = byteString.utf8();
            String substring = utf8.substring(0, codePointIndexToCharIndex);
            IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String IIOIX2 = OxI.IIOIX(OxI.IIOIX(OxI.IIOIX(substring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), xXOx.f32950X0o0xo, "\\r", false, 4, null);
            if (codePointIndexToCharIndex < utf8.length()) {
                return "[size=" + byteString.getData$okio().length + " text=" + IIOIX2 + "…]";
            }
            return "[text=" + IIOIX2 + ']';
        }
        return "[size=0]";
    }

    @OOXIXo
    public static final String commonUtf8(@OOXIXo okio.ByteString byteString) {
        IIX0o.x0xO0oo(byteString, "<this>");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio == null) {
            String utf8String = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
            byteString.setUtf8$okio(utf8String);
            return utf8String;
        }
        return utf8$okio;
    }

    public static final void commonWrite(@OOXIXo okio.ByteString byteString, @OOXIXo Buffer buffer, int i, int i2) {
        IIX0o.x0xO0oo(byteString, "<this>");
        IIX0o.x0xO0oo(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i, i2);
    }

    public static final int decodeHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' <= c && c < 'G') {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    @OOXIXo
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }

    public static final boolean commonEndsWith(@OOXIXo okio.ByteString byteString, @OOXIXo byte[] suffix) {
        IIX0o.x0xO0oo(byteString, "<this>");
        IIX0o.x0xO0oo(suffix, "suffix");
        return byteString.rangeEquals(byteString.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonLastIndexOf(@OOXIXo okio.ByteString byteString, @OOXIXo byte[] other, int i) {
        IIX0o.x0xO0oo(byteString, "<this>");
        IIX0o.x0xO0oo(other, "other");
        for (int min = Math.min(SegmentedByteString.resolveDefaultParameter(byteString, i), byteString.getData$okio().length - other.length); -1 < min; min--) {
            if (SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(@OOXIXo okio.ByteString byteString, int i, @OOXIXo byte[] other, int i2, int i3) {
        IIX0o.x0xO0oo(byteString, "<this>");
        IIX0o.x0xO0oo(other, "other");
        return i >= 0 && i <= byteString.getData$okio().length - i3 && i2 >= 0 && i2 <= other.length - i3 && SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), i, other, i2, i3);
    }

    public static final boolean commonStartsWith(@OOXIXo okio.ByteString byteString, @OOXIXo byte[] prefix) {
        IIX0o.x0xO0oo(byteString, "<this>");
        IIX0o.x0xO0oo(prefix, "prefix");
        return byteString.rangeEquals(0, prefix, 0, prefix.length);
    }
}
