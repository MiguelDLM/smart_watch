package okio;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSegmentedByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SegmentedByteString.kt\nokio/SegmentedByteString\n+ 2 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n63#2,12:141\n63#2,12:153\n104#2,2:165\n106#2,26:168\n135#2,5:194\n142#2:199\n145#2,3:200\n63#2,8:203\n148#2,8:211\n71#2,4:219\n156#2:223\n63#2,12:224\n160#2:236\n85#2,10:237\n161#2,9:247\n95#2,4:256\n170#2,2:260\n179#2,4:262\n85#2,10:266\n183#2,3:276\n95#2,4:279\n186#2:283\n195#2,8:284\n85#2,10:292\n203#2,3:302\n95#2,4:305\n206#2:309\n215#2,5:310\n85#2,10:315\n220#2,3:325\n95#2,4:328\n223#2:332\n226#2,4:333\n234#2,6:337\n63#2,8:343\n240#2,7:351\n71#2,4:358\n247#2,2:362\n1#3:167\n*S KotlinDebug\n*F\n+ 1 SegmentedByteString.kt\nokio/SegmentedByteString\n*L\n54#1:141,12\n66#1:153,12\n78#1:165,2\n78#1:168,26\n80#1:194,5\n82#1:199\n84#1:200,3\n84#1:203,8\n84#1:211,8\n84#1:219,4\n84#1:223\n90#1:224,12\n96#1:236\n96#1:237,10\n96#1:247,9\n96#1:256,4\n96#1:260,2\n103#1:262,4\n103#1:266,10\n103#1:276,3\n103#1:279,4\n103#1:283\n110#1:284,8\n110#1:292,10\n110#1:302,3\n110#1:305,4\n110#1:309\n117#1:310,5\n117#1:315,10\n117#1:325,3\n117#1:328,4\n117#1:332\n131#1:333,4\n133#1:337,6\n133#1:343,8\n133#1:351,7\n133#1:358,4\n133#1:362,2\n78#1:167\n*E\n"})
/* renamed from: okio.SegmentedByteString, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C1189SegmentedByteString extends ByteString {

    @OXOo.OOXIXo
    private final transient int[] directory;

    @OXOo.OOXIXo
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1189SegmentedByteString(@OXOo.OOXIXo byte[][] segments, @OXOo.OOXIXo int[] directory) {
        super(ByteString.EMPTY.getData$okio());
        IIX0o.x0xO0oo(segments, "segments");
        IIX0o.x0xO0oo(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        IIX0o.x0XOIxOo(byteString, "null cannot be cast to non-null type java.lang.Object");
        return byteString;
    }

    @Override // okio.ByteString
    @OXOo.OOXIXo
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        IIX0o.oO(asReadOnlyBuffer, "asReadOnlyBuffer(...)");
        return asReadOnlyBuffer;
    }

    @Override // okio.ByteString
    @OXOo.OOXIXo
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    @OXOo.OOXIXo
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public void copyInto(int i, @OXOo.OOXIXo byte[] target, int i2, int i3) {
        int i4;
        IIX0o.x0xO0oo(target, "target");
        long j = i3;
        SegmentedByteString.checkOffsetAndCount(size(), i, j);
        SegmentedByteString.checkOffsetAndCount(target.length, i2, j);
        int i5 = i3 + i;
        int segment = okio.internal.SegmentedByteString.segment(this, i);
        while (i < i5) {
            if (segment == 0) {
                i4 = 0;
            } else {
                i4 = getDirectory$okio()[segment - 1];
            }
            int i6 = getDirectory$okio()[segment] - i4;
            int i7 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i5, i6 + i4) - i;
            int i8 = i7 + (i - i4);
            ooOOo0oXI.O00XxXI(getSegments$okio()[segment], target, i2, i8, i8 + min);
            i2 += min;
            i += min;
            segment++;
        }
    }

    @Override // okio.ByteString
    @OXOo.OOXIXo
    public ByteString digest$okio(@OXOo.OOXIXo String algorithm) {
        IIX0o.x0xO0oo(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory$okio()[length + i];
            int i4 = getDirectory$okio()[i];
            messageDigest.update(getSegments$okio()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] digest = messageDigest.digest();
        IIX0o.ooOOo0oXI(digest);
        return new ByteString(digest);
    }

    @Override // okio.ByteString
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @OXOo.OOXIXo
    public final int[] getDirectory$okio() {
        return this.directory;
    }

    @OXOo.OOXIXo
    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio == 0) {
            int length = getSegments$okio().length;
            int i = 0;
            int i2 = 1;
            int i3 = 0;
            while (i < length) {
                int i4 = getDirectory$okio()[length + i];
                int i5 = getDirectory$okio()[i];
                byte[] bArr = getSegments$okio()[i];
                int i6 = (i5 - i3) + i4;
                while (i4 < i6) {
                    i2 = (i2 * 31) + bArr[i4];
                    i4++;
                }
                i++;
                i3 = i5;
            }
            setHashCode$okio(i2);
            return i2;
        }
        return hashCode$okio;
    }

    @Override // okio.ByteString
    @OXOo.OOXIXo
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    @OXOo.OOXIXo
    public ByteString hmac$okio(@OXOo.OOXIXo String algorithm, @OXOo.OOXIXo ByteString key) {
        IIX0o.x0xO0oo(algorithm, "algorithm");
        IIX0o.x0xO0oo(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments$okio().length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = getDirectory$okio()[length + i];
                int i4 = getDirectory$okio()[i];
                mac.update(getSegments$okio()[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            byte[] doFinal = mac.doFinal();
            IIX0o.oO(doFinal, "doFinal(...)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // okio.ByteString
    public int indexOf(@OXOo.OOXIXo byte[] other, int i) {
        IIX0o.x0xO0oo(other, "other");
        return toByteString().indexOf(other, i);
    }

    @Override // okio.ByteString
    @OXOo.OOXIXo
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int i) {
        int i2;
        SegmentedByteString.checkOffsetAndCount(getDirectory$okio()[getSegments$okio().length - 1], i, 1L);
        int segment = okio.internal.SegmentedByteString.segment(this, i);
        if (segment == 0) {
            i2 = 0;
        } else {
            i2 = getDirectory$okio()[segment - 1];
        }
        return getSegments$okio()[segment][(i - i2) + getDirectory$okio()[getSegments$okio().length + segment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(@OXOo.OOXIXo byte[] other, int i) {
        IIX0o.x0xO0oo(other, "other");
        return toByteString().lastIndexOf(other, i);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, @OXOo.OOXIXo ByteString other, int i2, int i3) {
        IIX0o.x0xO0oo(other, "other");
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int segment = okio.internal.SegmentedByteString.segment(this, i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i6 = getDirectory$okio()[segment] - i5;
            int i7 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i4, i6 + i5) - i;
            if (!other.rangeEquals(i2, getSegments$okio()[segment], i7 + (i - i5), min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    @OXOo.OOXIXo
    public String string(@OXOo.OOXIXo Charset charset) {
        IIX0o.x0xO0oo(charset, "charset");
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    @OXOo.OOXIXo
    public ByteString substring(int i, int i2) {
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, i2);
        if (i >= 0) {
            if (resolveDefaultParameter <= size()) {
                int i3 = resolveDefaultParameter - i;
                if (i3 >= 0) {
                    if (i == 0 && resolveDefaultParameter == size()) {
                        return this;
                    }
                    if (i == resolveDefaultParameter) {
                        return ByteString.EMPTY;
                    }
                    int segment = okio.internal.SegmentedByteString.segment(this, i);
                    int segment2 = okio.internal.SegmentedByteString.segment(this, resolveDefaultParameter - 1);
                    byte[][] bArr = (byte[][]) ooOOo0oXI.IO0XoXxO(getSegments$okio(), segment, segment2 + 1);
                    int[] iArr = new int[bArr.length * 2];
                    int i4 = 0;
                    if (segment <= segment2) {
                        int i5 = segment;
                        int i6 = 0;
                        while (true) {
                            iArr[i6] = Math.min(getDirectory$okio()[i5] - i, i3);
                            int i7 = i6 + 1;
                            iArr[i6 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i5];
                            if (i5 == segment2) {
                                break;
                            }
                            i5++;
                            i6 = i7;
                        }
                    }
                    if (segment != 0) {
                        i4 = getDirectory$okio()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i - i4);
                    return new C1189SegmentedByteString(bArr, iArr);
                }
                throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i).toString());
            }
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + size() + HexStringBuilder.COMMENT_END_CHAR).toString());
        }
        throw new IllegalArgumentException(("beginIndex=" + i + " < 0").toString());
    }

    @Override // okio.ByteString
    @OXOo.OOXIXo
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    @OXOo.OOXIXo
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    @OXOo.OOXIXo
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory$okio()[length + i];
            int i5 = getDirectory$okio()[i];
            int i6 = i5 - i2;
            ooOOo0oXI.O00XxXI(getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // okio.ByteString
    @OXOo.OOXIXo
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(@OXOo.OOXIXo OutputStream out) throws IOException {
        IIX0o.x0xO0oo(out, "out");
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory$okio()[length + i];
            int i4 = getDirectory$okio()[i];
            out.write(getSegments$okio()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    @Override // okio.ByteString
    public void write$okio(@OXOo.OOXIXo Buffer buffer, int i, int i2) {
        int i3;
        IIX0o.x0xO0oo(buffer, "buffer");
        int i4 = i + i2;
        int segment = okio.internal.SegmentedByteString.segment(this, i);
        while (i < i4) {
            if (segment == 0) {
                i3 = 0;
            } else {
                i3 = getDirectory$okio()[segment - 1];
            }
            int i5 = getDirectory$okio()[segment] - i3;
            int i6 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i4, i5 + i3) - i;
            int i7 = i6 + (i - i3);
            Segment segment2 = new Segment(getSegments$okio()[segment], i7, i7 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                IIX0o.ooOOo0oXI(segment3);
                Segment segment4 = segment3.prev;
                IIX0o.ooOOo0oXI(segment4);
                segment4.push(segment2);
            }
            i += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + i2);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, @OXOo.OOXIXo byte[] other, int i2, int i3) {
        IIX0o.x0xO0oo(other, "other");
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > other.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int segment = okio.internal.SegmentedByteString.segment(this, i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i6 = getDirectory$okio()[segment] - i5;
            int i7 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i4, i6 + i5) - i;
            if (!SegmentedByteString.arrayRangeEquals(getSegments$okio()[segment], i7 + (i - i5), other, i2, min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }
}
