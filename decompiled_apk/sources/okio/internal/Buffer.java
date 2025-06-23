package okio.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import XO0OX.xxIXOIIO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaPeriodQueue;
import com.szabh.smable3.entity.BleWatchFaceId;
import java.io.EOFException;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.II0XooXoX;
import kotlin.text.XIxXXX0x0;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.C1189SegmentedByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio._JvmPlatformKt;

@xxIXOIIO(name = "-Buffer")
@XX({"SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/internal/-Buffer\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1730:1\n112#1,20:1753\n112#1,20:1786\n112#1:1806\n114#1,18:1808\n112#1,20:1826\n74#2:1731\n74#2:1732\n74#2:1733\n74#2:1734\n74#2:1735\n74#2:1736\n74#2:1737\n74#2:1738\n74#2:1739\n74#2:1740\n74#2:1741\n74#2:1742\n83#2:1743\n83#2:1744\n77#2:1745\n77#2:1746\n77#2:1747\n77#2:1748\n77#2:1749\n77#2:1750\n77#2:1751\n77#2:1752\n86#2:1773\n89#2:1775\n74#2:1776\n74#2:1777\n74#2:1778\n74#2:1779\n74#2:1780\n74#2:1781\n74#2:1782\n74#2:1783\n74#2:1784\n74#2:1785\n89#2:1807\n86#2:1846\n1#3:1774\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/internal/-Buffer\n*L\n415#1:1753,20\n1292#1:1786,20\n1323#1:1806\n1323#1:1808,18\n1357#1:1826,20\n178#1:1731\n202#1:1732\n321#1:1733\n326#1:1734\n349#1:1735\n350#1:1736\n351#1:1737\n352#1:1738\n358#1:1739\n359#1:1740\n360#1:1741\n361#1:1742\n385#1:1743\n386#1:1744\n392#1:1745\n393#1:1746\n394#1:1747\n395#1:1748\n396#1:1749\n397#1:1750\n398#1:1751\n399#1:1752\n427#1:1773\n888#1:1775\n906#1:1776\n908#1:1777\n912#1:1778\n914#1:1779\n918#1:1780\n920#1:1781\n924#1:1782\n926#1:1783\n946#1:1784\n949#1:1785\n1336#1:1807\n1676#1:1846\n*E\n"})
/* renamed from: okio.internal.-Buffer */
/* loaded from: classes6.dex */
public final class Buffer {

    @OOXIXo
    private static final byte[] HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray(II0XooXoX.f29508oIX0oI);
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(@OOXIXo okio.Buffer buffer) {
        IIX0o.x0xO0oo(buffer, "<this>");
        buffer.skip(buffer.size());
    }

    public static final void commonClose(@OOXIXo Buffer.UnsafeCursor unsafeCursor) {
        IIX0o.x0xO0oo(unsafeCursor, "<this>");
        if (unsafeCursor.buffer != null) {
            unsafeCursor.buffer = null;
            unsafeCursor.setSegment$okio(null);
            unsafeCursor.offset = -1L;
            unsafeCursor.data = null;
            unsafeCursor.start = -1;
            unsafeCursor.end = -1;
            return;
        }
        throw new IllegalStateException("not attached to a buffer");
    }

    public static final long commonCompleteSegmentByteCount(@OOXIXo okio.Buffer buffer) {
        IIX0o.x0xO0oo(buffer, "<this>");
        long size = buffer.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = buffer.head;
        IIX0o.ooOOo0oXI(segment);
        Segment segment2 = segment.prev;
        IIX0o.ooOOo0oXI(segment2);
        if (segment2.limit < 8192 && segment2.owner) {
            return size - (r2 - segment2.pos);
        }
        return size;
    }

    @OOXIXo
    public static final okio.Buffer commonCopy(@OOXIXo okio.Buffer buffer) {
        IIX0o.x0xO0oo(buffer, "<this>");
        okio.Buffer buffer2 = new okio.Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        IIX0o.ooOOo0oXI(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            IIX0o.ooOOo0oXI(segment3);
            IIX0o.ooOOo0oXI(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    @OOXIXo
    public static final okio.Buffer commonCopyTo(@OOXIXo okio.Buffer buffer, @OOXIXo okio.Buffer out, long j, long j2) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(out, "out");
        SegmentedByteString.checkOffsetAndCount(buffer.size(), j, j2);
        if (j2 == 0) {
            return buffer;
        }
        out.setSize$okio(out.size() + j2);
        Segment segment = buffer.head;
        while (true) {
            IIX0o.ooOOo0oXI(segment);
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            segment = segment.next;
        }
        while (j2 > 0) {
            IIX0o.ooOOo0oXI(segment);
            Segment sharedCopy = segment.sharedCopy();
            int i3 = sharedCopy.pos + ((int) j);
            sharedCopy.pos = i3;
            sharedCopy.limit = Math.min(i3 + ((int) j2), sharedCopy.limit);
            Segment segment2 = out.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                out.head = sharedCopy;
            } else {
                IIX0o.ooOOo0oXI(segment2);
                Segment segment3 = segment2.prev;
                IIX0o.ooOOo0oXI(segment3);
                segment3.push(sharedCopy);
            }
            j2 -= sharedCopy.limit - sharedCopy.pos;
            segment = segment.next;
            j = 0;
        }
        return buffer;
    }

    public static final boolean commonEquals(@OOXIXo okio.Buffer buffer, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (buffer == obj) {
            return true;
        }
        if (!(obj instanceof okio.Buffer)) {
            return false;
        }
        okio.Buffer buffer2 = (okio.Buffer) obj;
        if (buffer.size() != buffer2.size()) {
            return false;
        }
        if (buffer.size() == 0) {
            return true;
        }
        Segment segment = buffer.head;
        IIX0o.ooOOo0oXI(segment);
        Segment segment2 = buffer2.head;
        IIX0o.ooOOo0oXI(segment2);
        int i = segment.pos;
        int i2 = segment2.pos;
        long j = 0;
        while (j < buffer.size()) {
            long min = Math.min(segment.limit - i, segment2.limit - i2);
            long j2 = 0;
            while (j2 < min) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                j2++;
                i = i3;
                i2 = i4;
            }
            if (i == segment.limit) {
                segment = segment.next;
                IIX0o.ooOOo0oXI(segment);
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                IIX0o.ooOOo0oXI(segment2);
                i2 = segment2.pos;
            }
            j += min;
        }
        return true;
    }

    public static final long commonExpandBuffer(@OOXIXo Buffer.UnsafeCursor unsafeCursor, int i) {
        IIX0o.x0xO0oo(unsafeCursor, "<this>");
        if (i > 0) {
            if (i <= 8192) {
                okio.Buffer buffer = unsafeCursor.buffer;
                if (buffer != null) {
                    if (unsafeCursor.readWrite) {
                        long size = buffer.size();
                        Segment writableSegment$okio = buffer.writableSegment$okio(i);
                        int i2 = 8192 - writableSegment$okio.limit;
                        writableSegment$okio.limit = 8192;
                        long j = i2;
                        buffer.setSize$okio(size + j);
                        unsafeCursor.setSegment$okio(writableSegment$okio);
                        unsafeCursor.offset = size;
                        unsafeCursor.data = writableSegment$okio.data;
                        unsafeCursor.start = 8192 - i2;
                        unsafeCursor.end = 8192;
                        return j;
                    }
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
                throw new IllegalStateException("not attached to a buffer");
            }
            throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i).toString());
        }
        throw new IllegalArgumentException(("minByteCount <= 0: " + i).toString());
    }

    public static final byte commonGet(@OOXIXo okio.Buffer buffer, long j) {
        IIX0o.x0xO0oo(buffer, "<this>");
        SegmentedByteString.checkOffsetAndCount(buffer.size(), j, 1L);
        Segment segment = buffer.head;
        if (segment != null) {
            if (buffer.size() - j < j) {
                long size = buffer.size();
                while (size > j) {
                    segment = segment.prev;
                    IIX0o.ooOOo0oXI(segment);
                    size -= segment.limit - segment.pos;
                }
                IIX0o.ooOOo0oXI(segment);
                return segment.data[(int) ((segment.pos + j) - size)];
            }
            long j2 = 0;
            while (true) {
                long j3 = (segment.limit - segment.pos) + j2;
                if (j3 <= j) {
                    segment = segment.next;
                    IIX0o.ooOOo0oXI(segment);
                    j2 = j3;
                } else {
                    IIX0o.ooOOo0oXI(segment);
                    return segment.data[(int) ((segment.pos + j) - j2)];
                }
            }
        } else {
            IIX0o.ooOOo0oXI(null);
            throw null;
        }
    }

    public static final int commonHashCode(@OOXIXo okio.Buffer buffer) {
        IIX0o.x0xO0oo(buffer, "<this>");
        Segment segment = buffer.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
            IIX0o.ooOOo0oXI(segment);
        } while (segment != buffer.head);
        return i;
    }

    public static final long commonIndexOf(@OOXIXo okio.Buffer buffer, byte b, long j, long j2) {
        Segment segment;
        int i;
        IIX0o.x0xO0oo(buffer, "<this>");
        long j3 = 0;
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("size=" + buffer.size() + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        if (j2 > buffer.size()) {
            j2 = buffer.size();
        }
        if (j == j2 || (segment = buffer.head) == null) {
            return -1L;
        }
        if (buffer.size() - j < j) {
            j3 = buffer.size();
            while (j3 > j) {
                segment = segment.prev;
                IIX0o.ooOOo0oXI(segment);
                j3 -= segment.limit - segment.pos;
            }
            while (j3 < j2) {
                byte[] bArr = segment.data;
                int min = (int) Math.min(segment.limit, (segment.pos + j2) - j3);
                i = (int) ((segment.pos + j) - j3);
                while (i < min) {
                    if (bArr[i] != b) {
                        i++;
                    }
                }
                j3 += segment.limit - segment.pos;
                segment = segment.next;
                IIX0o.ooOOo0oXI(segment);
                j = j3;
            }
            return -1L;
        }
        while (true) {
            long j4 = (segment.limit - segment.pos) + j3;
            if (j4 > j) {
                break;
            }
            segment = segment.next;
            IIX0o.ooOOo0oXI(segment);
            j3 = j4;
        }
        while (j3 < j2) {
            byte[] bArr2 = segment.data;
            int min2 = (int) Math.min(segment.limit, (segment.pos + j2) - j3);
            i = (int) ((segment.pos + j) - j3);
            while (i < min2) {
                if (bArr2[i] != b) {
                    i++;
                }
            }
            j3 += segment.limit - segment.pos;
            segment = segment.next;
            IIX0o.ooOOo0oXI(segment);
            j = j3;
        }
        return -1L;
        return (i - segment.pos) + j3;
    }

    public static final long commonIndexOfElement(@OOXIXo okio.Buffer buffer, @OOXIXo ByteString targetBytes, long j) {
        int i;
        int i2;
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(targetBytes, "targetBytes");
        long j2 = 0;
        if (j >= 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                return -1L;
            }
            if (buffer.size() - j < j) {
                j2 = buffer.size();
                while (j2 > j) {
                    segment = segment.prev;
                    IIX0o.ooOOo0oXI(segment);
                    j2 -= segment.limit - segment.pos;
                }
                if (targetBytes.size() == 2) {
                    byte b = targetBytes.getByte(0);
                    byte b2 = targetBytes.getByte(1);
                    while (j2 < buffer.size()) {
                        byte[] bArr = segment.data;
                        i = (int) ((segment.pos + j) - j2);
                        int i3 = segment.limit;
                        while (i < i3) {
                            byte b3 = bArr[i];
                            if (b3 != b && b3 != b2) {
                                i++;
                            }
                            i2 = segment.pos;
                        }
                        j2 += segment.limit - segment.pos;
                        segment = segment.next;
                        IIX0o.ooOOo0oXI(segment);
                        j = j2;
                    }
                } else {
                    byte[] internalArray$okio = targetBytes.internalArray$okio();
                    while (j2 < buffer.size()) {
                        byte[] bArr2 = segment.data;
                        i = (int) ((segment.pos + j) - j2);
                        int i4 = segment.limit;
                        while (i < i4) {
                            byte b4 = bArr2[i];
                            for (byte b5 : internalArray$okio) {
                                if (b4 == b5) {
                                    i2 = segment.pos;
                                }
                            }
                            i++;
                        }
                        j2 += segment.limit - segment.pos;
                        segment = segment.next;
                        IIX0o.ooOOo0oXI(segment);
                        j = j2;
                    }
                }
                return -1L;
            }
            while (true) {
                long j3 = (segment.limit - segment.pos) + j2;
                if (j3 > j) {
                    break;
                }
                segment = segment.next;
                IIX0o.ooOOo0oXI(segment);
                j2 = j3;
            }
            if (targetBytes.size() == 2) {
                byte b6 = targetBytes.getByte(0);
                byte b7 = targetBytes.getByte(1);
                while (j2 < buffer.size()) {
                    byte[] bArr3 = segment.data;
                    i = (int) ((segment.pos + j) - j2);
                    int i5 = segment.limit;
                    while (i < i5) {
                        byte b8 = bArr3[i];
                        if (b8 != b6 && b8 != b7) {
                            i++;
                        }
                        i2 = segment.pos;
                    }
                    j2 += segment.limit - segment.pos;
                    segment = segment.next;
                    IIX0o.ooOOo0oXI(segment);
                    j = j2;
                }
            } else {
                byte[] internalArray$okio2 = targetBytes.internalArray$okio();
                while (j2 < buffer.size()) {
                    byte[] bArr4 = segment.data;
                    i = (int) ((segment.pos + j) - j2);
                    int i6 = segment.limit;
                    while (i < i6) {
                        byte b9 = bArr4[i];
                        for (byte b10 : internalArray$okio2) {
                            if (b9 == b10) {
                                i2 = segment.pos;
                            }
                        }
                        i++;
                    }
                    j2 += segment.limit - segment.pos;
                    segment = segment.next;
                    IIX0o.ooOOo0oXI(segment);
                    j = j2;
                }
            }
            return -1L;
            return (i - i2) + j2;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
    }

    public static final int commonNext(@OOXIXo Buffer.UnsafeCursor unsafeCursor) {
        long j;
        IIX0o.x0xO0oo(unsafeCursor, "<this>");
        long j2 = unsafeCursor.offset;
        okio.Buffer buffer = unsafeCursor.buffer;
        IIX0o.ooOOo0oXI(buffer);
        if (j2 != buffer.size()) {
            long j3 = unsafeCursor.offset;
            if (j3 == -1) {
                j = 0;
            } else {
                j = j3 + (unsafeCursor.end - unsafeCursor.start);
            }
            return unsafeCursor.seek(j);
        }
        throw new IllegalStateException("no more bytes");
    }

    public static final boolean commonRangeEquals(@OOXIXo okio.Buffer buffer, long j, @OOXIXo ByteString bytes, int i, int i2) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(bytes, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || buffer.size() - j < i2 || bytes.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (buffer.getByte(i3 + j) != bytes.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(@OOXIXo okio.Buffer buffer, @OOXIXo byte[] sink) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(sink, "sink");
        return buffer.read(sink, 0, sink.length);
    }

    public static final long commonReadAll(@OOXIXo okio.Buffer buffer, @OOXIXo Sink sink) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    @OOXIXo
    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(@OOXIXo okio.Buffer buffer, @OOXIXo Buffer.UnsafeCursor unsafeCursor) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer == null) {
            resolveDefaultParameter.buffer = buffer;
            resolveDefaultParameter.readWrite = true;
            return resolveDefaultParameter;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public static final byte commonReadByte(@OOXIXo okio.Buffer buffer) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (buffer.size() != 0) {
            Segment segment = buffer.head;
            IIX0o.ooOOo0oXI(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            int i3 = i + 1;
            byte b = segment.data[i];
            buffer.setSize$okio(buffer.size() - 1);
            if (i3 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i3;
            }
            return b;
        }
        throw new EOFException();
    }

    @OOXIXo
    public static final byte[] commonReadByteArray(@OOXIXo okio.Buffer buffer) {
        IIX0o.x0xO0oo(buffer, "<this>");
        return buffer.readByteArray(buffer.size());
    }

    @OOXIXo
    public static final ByteString commonReadByteString(@OOXIXo okio.Buffer buffer) {
        IIX0o.x0xO0oo(buffer, "<this>");
        return buffer.readByteString(buffer.size());
    }

    public static final long commonReadDecimalLong(@OOXIXo okio.Buffer buffer) {
        int i;
        String str;
        IIX0o.x0xO0oo(buffer, "<this>");
        if (buffer.size() != 0) {
            int i2 = 0;
            long j = 0;
            long j2 = -7;
            boolean z = false;
            boolean z2 = false;
            do {
                Segment segment = buffer.head;
                IIX0o.ooOOo0oXI(segment);
                byte[] bArr = segment.data;
                int i3 = segment.pos;
                int i4 = segment.limit;
                while (i3 < i4) {
                    byte b = bArr[i3];
                    if (b >= 48 && b <= 57) {
                        int i5 = 48 - b;
                        if (j >= -922337203685477580L && (j != -922337203685477580L || i5 >= j2)) {
                            j = (j * 10) + i5;
                        } else {
                            okio.Buffer writeByte = new okio.Buffer().writeDecimalLong(j).writeByte((int) b);
                            if (!z) {
                                writeByte.readByte();
                            }
                            throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
                        }
                    } else if (b == 45 && i2 == 0) {
                        j2--;
                        z = true;
                    } else {
                        z2 = true;
                        break;
                    }
                    i3++;
                    i2++;
                }
                if (i3 == i4) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i3;
                }
                if (z2) {
                    break;
                }
            } while (buffer.head != null);
            buffer.setSize$okio(buffer.size() - i2);
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            if (i2 < i) {
                if (buffer.size() != 0) {
                    if (z) {
                        str = "Expected a digit";
                    } else {
                        str = "Expected a digit or '-'";
                    }
                    throw new NumberFormatException(str + " but was 0x" + SegmentedByteString.toHexString(buffer.getByte(0L)));
                }
                throw new EOFException();
            }
            if (!z) {
                return -j;
            }
            return j;
        }
        throw new EOFException();
    }

    public static final void commonReadFully(@OOXIXo okio.Buffer buffer, @OOXIXo byte[] sink) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(sink, "sink");
        int i = 0;
        while (i < sink.length) {
            int read = buffer.read(sink, i, sink.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac A[EDGE_INSN: B:40:0x00ac->B:37:0x00ac BREAK  A[LOOP:0: B:4:0x0012->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long commonReadHexadecimalUnsignedLong(@OXOo.OOXIXo okio.Buffer r15) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r15, r0)
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lb6
            r0 = 0
            r4 = r2
            r1 = 0
        L12:
            okio.Segment r6 = r15.head
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L1d:
            if (r8 >= r9) goto L98
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L2c
            r11 = 57
            if (r10 > r11) goto L2c
            int r11 = r10 + (-48)
            goto L41
        L2c:
            r11 = 97
            if (r10 < r11) goto L37
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L37
            int r11 = r10 + (-87)
            goto L41
        L37:
            r11 = 65
            if (r10 < r11) goto L79
            r11 = 70
            if (r10 > r11) goto L79
            int r11 = r10 + (-55)
        L41:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L51
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L1d
        L51:
            okio.Buffer r15 = new okio.Buffer
            r15.<init>()
            okio.Buffer r15 = r15.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r15 = r15.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r15 = r15.readUtf8()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L79:
            if (r0 == 0) goto L7d
            r1 = 1
            goto L98
        L7d:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = okio.SegmentedByteString.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L98:
            if (r8 != r9) goto La4
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto La6
        La4:
            r6.pos = r8
        La6:
            if (r1 != 0) goto Lac
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L12
        Lac:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Lb6:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.Buffer.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final int commonReadInt(@OOXIXo okio.Buffer buffer) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (buffer.size() >= 4) {
            Segment segment = buffer.head;
            IIX0o.ooOOo0oXI(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 4) {
                return (buffer.readByte() & 255) | ((buffer.readByte() & 255) << 24) | ((buffer.readByte() & 255) << 16) | ((buffer.readByte() & 255) << 8);
            }
            byte[] bArr = segment.data;
            int i3 = i + 3;
            int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
            int i5 = i + 4;
            int i6 = (bArr[i3] & 255) | i4;
            buffer.setSize$okio(buffer.size() - 4);
            if (i5 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i5;
            }
            return i6;
        }
        throw new EOFException();
    }

    public static final long commonReadLong(@OOXIXo okio.Buffer buffer) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (buffer.size() >= 8) {
            Segment segment = buffer.head;
            IIX0o.ooOOo0oXI(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 8) {
                return ((buffer.readInt() & BleWatchFaceId.WATCHFACE_ID_INVALID) << 32) | (BleWatchFaceId.WATCHFACE_ID_INVALID & buffer.readInt());
            }
            byte[] bArr = segment.data;
            int i3 = i + 7;
            long j = ((bArr[i + 3] & 255) << 32) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
            int i4 = i + 8;
            long j2 = j | (bArr[i3] & 255);
            buffer.setSize$okio(buffer.size() - 8);
            if (i4 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return j2;
        }
        throw new EOFException();
    }

    public static final short commonReadShort(@OOXIXo okio.Buffer buffer) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (buffer.size() >= 2) {
            Segment segment = buffer.head;
            IIX0o.ooOOo0oXI(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 2) {
                return (short) ((buffer.readByte() & 255) | ((buffer.readByte() & 255) << 8));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = (bArr[i] & 255) << 8;
            int i5 = i + 2;
            int i6 = (bArr[i3] & 255) | i4;
            buffer.setSize$okio(buffer.size() - 2);
            if (i5 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i5;
            }
            return (short) i6;
        }
        throw new EOFException();
    }

    @OOXIXo
    public static final Buffer.UnsafeCursor commonReadUnsafe(@OOXIXo okio.Buffer buffer, @OOXIXo Buffer.UnsafeCursor unsafeCursor) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer == null) {
            resolveDefaultParameter.buffer = buffer;
            resolveDefaultParameter.readWrite = false;
            return resolveDefaultParameter;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    @OOXIXo
    public static final String commonReadUtf8(@OOXIXo okio.Buffer buffer, long j) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (j >= 0 && j <= 2147483647L) {
            if (buffer.size() >= j) {
                if (j == 0) {
                    return "";
                }
                Segment segment = buffer.head;
                IIX0o.ooOOo0oXI(segment);
                int i = segment.pos;
                if (i + j > segment.limit) {
                    return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j), 0, 0, 3, null);
                }
                int i2 = (int) j;
                String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i, i + i2);
                segment.pos += i2;
                buffer.setSize$okio(buffer.size() - j);
                if (segment.pos == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                return commonToUtf8String;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j).toString());
    }

    public static final int commonReadUtf8CodePoint(@OOXIXo okio.Buffer buffer) {
        int i;
        int i2;
        int i3;
        IIX0o.x0xO0oo(buffer, "<this>");
        if (buffer.size() != 0) {
            byte b = buffer.getByte(0L);
            if ((b & 128) == 0) {
                i = b & Byte.MAX_VALUE;
                i2 = 1;
                i3 = 0;
            } else if ((b & 224) == 192) {
                i = b & 31;
                i2 = 2;
                i3 = 128;
            } else if ((b & 240) == 224) {
                i = b & 15;
                i2 = 3;
                i3 = 2048;
            } else if ((b & 248) == 240) {
                i = b & 7;
                i2 = 4;
                i3 = 65536;
            } else {
                buffer.skip(1L);
                return 65533;
            }
            long j = i2;
            if (buffer.size() >= j) {
                for (int i4 = 1; i4 < i2; i4++) {
                    long j2 = i4;
                    byte b2 = buffer.getByte(j2);
                    if ((b2 & 192) == 128) {
                        i = (i << 6) | (b2 & Utf8.REPLACEMENT_BYTE);
                    } else {
                        buffer.skip(j2);
                        return 65533;
                    }
                }
                buffer.skip(j);
                if (i > 1114111) {
                    return 65533;
                }
                if ((55296 <= i && i < 57344) || i < i3) {
                    return 65533;
                }
                return i;
            }
            throw new EOFException("size < " + i2 + ": " + buffer.size() + " (to read code point prefixed 0x" + SegmentedByteString.toHexString(b) + HexStringBuilder.COMMENT_END_CHAR);
        }
        throw new EOFException();
    }

    @oOoXoXO
    public static final String commonReadUtf8Line(@OOXIXo okio.Buffer buffer) {
        IIX0o.x0xO0oo(buffer, "<this>");
        long indexOf = buffer.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    @OOXIXo
    public static final String commonReadUtf8LineStrict(@OOXIXo okio.Buffer buffer, long j) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long indexOf = buffer.indexOf((byte) 10, 0L, j2);
            if (indexOf != -1) {
                return readUtf8Line(buffer, indexOf);
            }
            if (j2 < buffer.size() && buffer.getByte(j2 - 1) == 13 && buffer.getByte(j2) == 10) {
                return readUtf8Line(buffer, j2);
            }
            okio.Buffer buffer2 = new okio.Buffer();
            buffer.copyTo(buffer2, 0L, Math.min(32, buffer.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), j) + " content=" + buffer2.readByteString().hex() + XIxXXX0x0.f29562xXxxox0I);
        }
        throw new IllegalArgumentException(("limit < 0: " + j).toString());
    }

    public static final long commonResizeBuffer(@OOXIXo Buffer.UnsafeCursor unsafeCursor, long j) {
        IIX0o.x0xO0oo(unsafeCursor, "<this>");
        okio.Buffer buffer = unsafeCursor.buffer;
        if (buffer != null) {
            if (unsafeCursor.readWrite) {
                long size = buffer.size();
                if (j <= size) {
                    if (j >= 0) {
                        long j2 = size - j;
                        while (true) {
                            if (j2 <= 0) {
                                break;
                            }
                            Segment segment = buffer.head;
                            IIX0o.ooOOo0oXI(segment);
                            Segment segment2 = segment.prev;
                            IIX0o.ooOOo0oXI(segment2);
                            int i = segment2.limit;
                            long j3 = i - segment2.pos;
                            if (j3 <= j2) {
                                buffer.head = segment2.pop();
                                SegmentPool.recycle(segment2);
                                j2 -= j3;
                            } else {
                                segment2.limit = i - ((int) j2);
                                break;
                            }
                        }
                        unsafeCursor.setSegment$okio(null);
                        unsafeCursor.offset = j;
                        unsafeCursor.data = null;
                        unsafeCursor.start = -1;
                        unsafeCursor.end = -1;
                    } else {
                        throw new IllegalArgumentException(("newSize < 0: " + j).toString());
                    }
                } else if (j > size) {
                    long j4 = j - size;
                    boolean z = true;
                    for (long j5 = 0; j4 > j5; j5 = 0) {
                        Segment writableSegment$okio = buffer.writableSegment$okio(1);
                        int min = (int) Math.min(j4, 8192 - writableSegment$okio.limit);
                        writableSegment$okio.limit += min;
                        j4 -= min;
                        if (z) {
                            unsafeCursor.setSegment$okio(writableSegment$okio);
                            unsafeCursor.offset = size;
                            unsafeCursor.data = writableSegment$okio.data;
                            int i2 = writableSegment$okio.limit;
                            unsafeCursor.start = i2 - min;
                            unsafeCursor.end = i2;
                            z = false;
                        }
                    }
                }
                buffer.setSize$okio(j);
                return size;
            }
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        }
        throw new IllegalStateException("not attached to a buffer");
    }

    public static final int commonSeek(@OOXIXo Buffer.UnsafeCursor unsafeCursor, long j) {
        Segment segment;
        IIX0o.x0xO0oo(unsafeCursor, "<this>");
        okio.Buffer buffer = unsafeCursor.buffer;
        if (buffer != null) {
            if (j >= -1 && j <= buffer.size()) {
                if (j != -1 && j != buffer.size()) {
                    long size = buffer.size();
                    Segment segment2 = buffer.head;
                    long j2 = 0;
                    if (unsafeCursor.getSegment$okio() != null) {
                        long j3 = unsafeCursor.offset;
                        int i = unsafeCursor.start;
                        IIX0o.ooOOo0oXI(unsafeCursor.getSegment$okio());
                        long j4 = j3 - (i - r9.pos);
                        if (j4 > j) {
                            segment = segment2;
                            segment2 = unsafeCursor.getSegment$okio();
                            size = j4;
                        } else {
                            segment = unsafeCursor.getSegment$okio();
                            j2 = j4;
                        }
                    } else {
                        segment = segment2;
                    }
                    if (size - j > j - j2) {
                        while (true) {
                            IIX0o.ooOOo0oXI(segment);
                            int i2 = segment.limit;
                            int i3 = segment.pos;
                            if (j < (i2 - i3) + j2) {
                                break;
                            }
                            j2 += i2 - i3;
                            segment = segment.next;
                        }
                    } else {
                        while (size > j) {
                            IIX0o.ooOOo0oXI(segment2);
                            segment2 = segment2.prev;
                            IIX0o.ooOOo0oXI(segment2);
                            size -= segment2.limit - segment2.pos;
                        }
                        j2 = size;
                        segment = segment2;
                    }
                    if (unsafeCursor.readWrite) {
                        IIX0o.ooOOo0oXI(segment);
                        if (segment.shared) {
                            Segment unsharedCopy = segment.unsharedCopy();
                            if (buffer.head == segment) {
                                buffer.head = unsharedCopy;
                            }
                            segment = segment.push(unsharedCopy);
                            Segment segment3 = segment.prev;
                            IIX0o.ooOOo0oXI(segment3);
                            segment3.pop();
                        }
                    }
                    unsafeCursor.setSegment$okio(segment);
                    unsafeCursor.offset = j;
                    IIX0o.ooOOo0oXI(segment);
                    unsafeCursor.data = segment.data;
                    int i4 = segment.pos + ((int) (j - j2));
                    unsafeCursor.start = i4;
                    int i5 = segment.limit;
                    unsafeCursor.end = i5;
                    return i5 - i4;
                }
                unsafeCursor.setSegment$okio(null);
                unsafeCursor.offset = j;
                unsafeCursor.data = null;
                unsafeCursor.start = -1;
                unsafeCursor.end = -1;
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + buffer.size());
        }
        throw new IllegalStateException("not attached to a buffer");
    }

    public static final int commonSelect(@OOXIXo okio.Buffer buffer, @OOXIXo Options options) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(options, "options");
        int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(@OOXIXo okio.Buffer buffer, long j) {
        IIX0o.x0xO0oo(buffer, "<this>");
        while (j > 0) {
            Segment segment = buffer.head;
            if (segment != null) {
                int min = (int) Math.min(j, segment.limit - segment.pos);
                long j2 = min;
                buffer.setSize$okio(buffer.size() - j2);
                j -= j2;
                int i = segment.pos + min;
                segment.pos = i;
                if (i == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @OOXIXo
    public static final ByteString commonSnapshot(@OOXIXo okio.Buffer buffer) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (buffer.size() <= 2147483647L) {
            return buffer.snapshot((int) buffer.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + buffer.size()).toString());
    }

    @OOXIXo
    public static final Segment commonWritableSegment(@OOXIXo okio.Buffer buffer, int i) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (i >= 1 && i <= 8192) {
            Segment segment = buffer.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                buffer.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            IIX0o.ooOOo0oXI(segment);
            Segment segment2 = segment.prev;
            IIX0o.ooOOo0oXI(segment2);
            if (segment2.limit + i > 8192 || !segment2.owner) {
                return segment2.push(SegmentPool.take());
            }
            return segment2;
        }
        throw new IllegalArgumentException("unexpected capacity");
    }

    @OOXIXo
    public static final okio.Buffer commonWrite(@OOXIXo okio.Buffer buffer, @OOXIXo ByteString byteString, int i, int i2) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static /* synthetic */ okio.Buffer commonWrite$default(okio.Buffer buffer, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.size();
        }
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static final long commonWriteAll(@OOXIXo okio.Buffer buffer, @OOXIXo Source source) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(buffer, 8192L);
            if (read != -1) {
                j += read;
            } else {
                return j;
            }
        }
    }

    @OOXIXo
    public static final okio.Buffer commonWriteByte(@OOXIXo okio.Buffer buffer, int i) {
        IIX0o.x0xO0oo(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        writableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    @OOXIXo
    public static final okio.Buffer commonWriteDecimalLong(@OOXIXo okio.Buffer buffer, long j) {
        boolean z;
        IIX0o.x0xO0oo(buffer, "<this>");
        if (j == 0) {
            return buffer.writeByte(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return buffer.writeUtf8("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j < 100000000) {
            if (j < 10000) {
                if (j < 100) {
                    if (j >= 10) {
                        i = 2;
                    }
                } else if (j < 1000) {
                    i = 3;
                } else {
                    i = 4;
                }
            } else if (j < 1000000) {
                if (j < 100000) {
                    i = 5;
                } else {
                    i = 6;
                }
            } else if (j < 10000000) {
                i = 7;
            } else {
                i = 8;
            }
        } else if (j < MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US) {
            if (j < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                if (j < C.NANOS_PER_SECOND) {
                    i = 9;
                } else {
                    i = 10;
                }
            } else if (j < 100000000000L) {
                i = 11;
            } else {
                i = 12;
            }
        } else if (j < 1000000000000000L) {
            if (j < 10000000000000L) {
                i = 13;
            } else if (j < 100000000000000L) {
                i = 14;
            } else {
                i = 15;
            }
        } else if (j < 100000000000000000L) {
            if (j < 10000000000000000L) {
                i = 16;
            } else {
                i = 17;
            }
        } else if (j < 1000000000000000000L) {
            i = 18;
        } else {
            i = 19;
        }
        if (z) {
            i++;
        }
        Segment writableSegment$okio = buffer.writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit + i;
        while (j != 0) {
            long j2 = 10;
            i2--;
            bArr[i2] = getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        writableSegment$okio.limit += i;
        buffer.setSize$okio(buffer.size() + i);
        return buffer;
    }

    @OOXIXo
    public static final okio.Buffer commonWriteHexadecimalUnsignedLong(@OOXIXo okio.Buffer buffer, long j) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (j == 0) {
            return buffer.writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
        Segment writableSegment$okio = buffer.writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment$okio.limit += i;
        buffer.setSize$okio(buffer.size() + i);
        return buffer;
    }

    @OOXIXo
    public static final okio.Buffer commonWriteInt(@OOXIXo okio.Buffer buffer, int i) {
        IIX0o.x0xO0oo(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        writableSegment$okio.limit = i2 + 4;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    @OOXIXo
    public static final okio.Buffer commonWriteLong(@OOXIXo okio.Buffer buffer, long j) {
        IIX0o.x0xO0oo(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i = writableSegment$okio.limit;
        bArr[i] = (byte) ((j >>> 56) & 255);
        bArr[i + 1] = (byte) ((j >>> 48) & 255);
        bArr[i + 2] = (byte) ((j >>> 40) & 255);
        bArr[i + 3] = (byte) ((j >>> 32) & 255);
        bArr[i + 4] = (byte) ((j >>> 24) & 255);
        bArr[i + 5] = (byte) ((j >>> 16) & 255);
        bArr[i + 6] = (byte) ((j >>> 8) & 255);
        bArr[i + 7] = (byte) (j & 255);
        writableSegment$okio.limit = i + 8;
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    @OOXIXo
    public static final okio.Buffer commonWriteShort(@OOXIXo okio.Buffer buffer, int i) {
        IIX0o.x0xO0oo(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        writableSegment$okio.limit = i2 + 2;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    @OOXIXo
    public static final okio.Buffer commonWriteUtf8(@OOXIXo okio.Buffer buffer, @OOXIXo String string, int i, int i2) {
        char charAt;
        char c;
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(string, "string");
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 <= string.length()) {
                    while (i < i2) {
                        char charAt2 = string.charAt(i);
                        if (charAt2 < 128) {
                            Segment writableSegment$okio = buffer.writableSegment$okio(1);
                            byte[] bArr = writableSegment$okio.data;
                            int i3 = writableSegment$okio.limit - i;
                            int min = Math.min(i2, 8192 - i3);
                            int i4 = i + 1;
                            bArr[i + i3] = (byte) charAt2;
                            while (true) {
                                i = i4;
                                if (i >= min || (charAt = string.charAt(i)) >= 128) {
                                    break;
                                }
                                i4 = i + 1;
                                bArr[i + i3] = (byte) charAt;
                            }
                            int i5 = writableSegment$okio.limit;
                            int i6 = (i3 + i) - i5;
                            writableSegment$okio.limit = i5 + i6;
                            buffer.setSize$okio(buffer.size() + i6);
                        } else {
                            if (charAt2 < 2048) {
                                Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                                byte[] bArr2 = writableSegment$okio2.data;
                                int i7 = writableSegment$okio2.limit;
                                bArr2[i7] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i7 + 1] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio2.limit = i7 + 2;
                                buffer.setSize$okio(buffer.size() + 2);
                            } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                                int i8 = i + 1;
                                if (i8 < i2) {
                                    c = string.charAt(i8);
                                } else {
                                    c = 0;
                                }
                                if (charAt2 <= 56319 && 56320 <= c && c < 57344) {
                                    int i9 = (((charAt2 & 1023) << 10) | (c & 1023)) + 65536;
                                    Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
                                    byte[] bArr3 = writableSegment$okio3.data;
                                    int i10 = writableSegment$okio3.limit;
                                    bArr3[i10] = (byte) ((i9 >> 18) | 240);
                                    bArr3[i10 + 1] = (byte) (((i9 >> 12) & 63) | 128);
                                    bArr3[i10 + 2] = (byte) (((i9 >> 6) & 63) | 128);
                                    bArr3[i10 + 3] = (byte) ((i9 & 63) | 128);
                                    writableSegment$okio3.limit = i10 + 4;
                                    buffer.setSize$okio(buffer.size() + 4);
                                    i += 2;
                                } else {
                                    buffer.writeByte(63);
                                    i = i8;
                                }
                            } else {
                                Segment writableSegment$okio4 = buffer.writableSegment$okio(3);
                                byte[] bArr4 = writableSegment$okio4.data;
                                int i11 = writableSegment$okio4.limit;
                                bArr4[i11] = (byte) ((charAt2 >> '\f') | 224);
                                bArr4[i11 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr4[i11 + 2] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio4.limit = i11 + 3;
                                buffer.setSize$okio(buffer.size() + 3);
                            }
                            i++;
                        }
                    }
                    return buffer;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + string.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
    }

    @OOXIXo
    public static final okio.Buffer commonWriteUtf8CodePoint(@OOXIXo okio.Buffer buffer, int i) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (i < 128) {
            buffer.writeByte(i);
        } else if (i < 2048) {
            Segment writableSegment$okio = buffer.writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i2 = writableSegment$okio.limit;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            writableSegment$okio.limit = i2 + 2;
            buffer.setSize$okio(buffer.size() + 2);
        } else if (55296 <= i && i < 57344) {
            buffer.writeByte(63);
        } else if (i < 65536) {
            Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i3 = writableSegment$okio2.limit;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            writableSegment$okio2.limit = i3 + 3;
            buffer.setSize$okio(buffer.size() + 3);
        } else if (i <= 1114111) {
            Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
            byte[] bArr3 = writableSegment$okio3.data;
            int i4 = writableSegment$okio3.limit;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            writableSegment$okio3.limit = i4 + 4;
            buffer.setSize$okio(buffer.size() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.toHexString(i));
        }
        return buffer;
    }

    @OOXIXo
    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static /* synthetic */ void getHEX_DIGIT_BYTES$annotations() {
    }

    public static final boolean rangeEquals(@OOXIXo Segment segment, int i, @OOXIXo byte[] bytes, int i2, int i3) {
        IIX0o.x0xO0oo(segment, "segment");
        IIX0o.x0xO0oo(bytes, "bytes");
        int i4 = segment.limit;
        byte[] bArr = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                IIX0o.ooOOo0oXI(segment);
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i = segment.pos;
                i4 = segment.limit;
            }
            if (bArr[i] != bytes[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @OOXIXo
    public static final String readUtf8Line(@OOXIXo okio.Buffer buffer, long j) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (j > 0) {
            long j2 = j - 1;
            if (buffer.getByte(j2) == 13) {
                String readUtf8 = buffer.readUtf8(j2);
                buffer.skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j);
        buffer.skip(1L);
        return readUtf82;
    }

    public static final <T> T seek(@OOXIXo okio.Buffer buffer, long j, @OOXIXo x0xO0oo<? super Segment, ? super Long, ? extends T> lambda) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(lambda, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return lambda.invoke(null, -1L);
        }
        if (buffer.size() - j < j) {
            long size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                IIX0o.ooOOo0oXI(segment);
                size -= segment.limit - segment.pos;
            }
            return lambda.invoke(segment, Long.valueOf(size));
        }
        long j2 = 0;
        while (true) {
            long j3 = (segment.limit - segment.pos) + j2;
            if (j3 <= j) {
                segment = segment.next;
                IIX0o.ooOOo0oXI(segment);
                j2 = j3;
            } else {
                return lambda.invoke(segment, Long.valueOf(j2));
            }
        }
    }

    public static final int selectPrefix(@OOXIXo okio.Buffer buffer, @OOXIXo Options options, boolean z) {
        int i;
        int i2;
        boolean z2;
        Segment segment;
        int i3;
        int i4;
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(options, "options");
        Segment segment2 = buffer.head;
        if (segment2 == null) {
            if (z) {
                return -2;
            }
            return -1;
        }
        byte[] bArr = segment2.data;
        int i5 = segment2.pos;
        int i6 = segment2.limit;
        int[] trie$okio = options.getTrie$okio();
        Segment segment3 = segment2;
        int i7 = 0;
        int i8 = -1;
        loop0: while (true) {
            int i9 = i7 + 1;
            int i10 = trie$okio[i7];
            int i11 = i7 + 2;
            int i12 = trie$okio[i9];
            if (i12 != -1) {
                i8 = i12;
            }
            if (segment3 == null) {
                break;
            }
            if (i10 < 0) {
                int i13 = i11 + (i10 * (-1));
                while (true) {
                    int i14 = i5 + 1;
                    int i15 = i11 + 1;
                    if ((bArr[i5] & 255) != trie$okio[i11]) {
                        return i8;
                    }
                    if (i15 == i13) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (i14 == i6) {
                        IIX0o.ooOOo0oXI(segment3);
                        Segment segment4 = segment3.next;
                        IIX0o.ooOOo0oXI(segment4);
                        i4 = segment4.pos;
                        byte[] bArr2 = segment4.data;
                        i3 = segment4.limit;
                        if (segment4 == segment2) {
                            if (!z2) {
                                break loop0;
                            }
                            bArr = bArr2;
                            segment = null;
                        } else {
                            segment = segment4;
                            bArr = bArr2;
                        }
                    } else {
                        segment = segment3;
                        i3 = i6;
                        i4 = i14;
                    }
                    if (z2) {
                        i2 = trie$okio[i15];
                        i = i4;
                        i6 = i3;
                        segment3 = segment;
                        break;
                    }
                    i5 = i4;
                    i6 = i3;
                    segment3 = segment;
                    i11 = i15;
                }
            } else {
                i = i5 + 1;
                int i16 = bArr[i5] & 255;
                int i17 = i11 + i10;
                while (i11 != i17) {
                    if (i16 == trie$okio[i11]) {
                        i2 = trie$okio[i11 + i10];
                        if (i == i6) {
                            segment3 = segment3.next;
                            IIX0o.ooOOo0oXI(segment3);
                            i = segment3.pos;
                            bArr = segment3.data;
                            i6 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                    } else {
                        i11++;
                    }
                }
                return i8;
            }
            if (i2 >= 0) {
                return i2;
            }
            i7 = -i2;
            i5 = i;
        }
        if (z) {
            return -2;
        }
        return i8;
    }

    public static /* synthetic */ int selectPrefix$default(okio.Buffer buffer, Options options, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final int commonRead(@OOXIXo okio.Buffer buffer, @OOXIXo byte[] sink, int i, int i2) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(sink, "sink");
        SegmentedByteString.checkOffsetAndCount(sink.length, i, i2);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        byte[] bArr = segment.data;
        int i3 = segment.pos;
        ooOOo0oXI.O00XxXI(bArr, sink, i, i3, i3 + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - min);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @OOXIXo
    public static final byte[] commonReadByteArray(@OOXIXo okio.Buffer buffer, long j) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (buffer.size() >= j) {
            byte[] bArr = new byte[(int) j];
            buffer.readFully(bArr);
            return bArr;
        }
        throw new EOFException();
    }

    @OOXIXo
    public static final ByteString commonReadByteString(@OOXIXo okio.Buffer buffer, long j) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (buffer.size() < j) {
            throw new EOFException();
        }
        if (j >= 4096) {
            ByteString snapshot = buffer.snapshot((int) j);
            buffer.skip(j);
            return snapshot;
        }
        return new ByteString(buffer.readByteArray(j));
    }

    @OOXIXo
    public static final okio.Buffer commonWrite(@OOXIXo okio.Buffer buffer, @OOXIXo byte[] source) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(source, "source");
        return buffer.write(source, 0, source.length);
    }

    @OOXIXo
    public static final okio.Buffer commonWrite(@OOXIXo okio.Buffer buffer, @OOXIXo byte[] source, int i, int i2) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(source, "source");
        long j = i2;
        SegmentedByteString.checkOffsetAndCount(source.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int min = Math.min(i3 - i, 8192 - writableSegment$okio.limit);
            int i4 = i + min;
            ooOOo0oXI.O00XxXI(source, writableSegment$okio.data, writableSegment$okio.limit, i, i4);
            writableSegment$okio.limit += min;
            i = i4;
        }
        buffer.setSize$okio(buffer.size() + j);
        return buffer;
    }

    public static final void commonReadFully(@OOXIXo okio.Buffer buffer, @OOXIXo okio.Buffer sink, long j) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(sink, "sink");
        if (buffer.size() >= j) {
            sink.write(buffer, j);
        } else {
            sink.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    @OOXIXo
    public static final ByteString commonSnapshot(@OOXIXo okio.Buffer buffer, int i) {
        IIX0o.x0xO0oo(buffer, "<this>");
        if (i == 0) {
            return ByteString.EMPTY;
        }
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0L, i);
        Segment segment = buffer.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            IIX0o.ooOOo0oXI(segment);
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i4];
        int[] iArr = new int[i4 * 2];
        Segment segment2 = buffer.head;
        int i7 = 0;
        while (i2 < i) {
            IIX0o.ooOOo0oXI(segment2);
            bArr[i7] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = segment2.pos;
            segment2.shared = true;
            i7++;
            segment2 = segment2.next;
        }
        return new C1189SegmentedByteString(bArr, iArr);
    }

    @OOXIXo
    public static final okio.Buffer commonWrite(@OOXIXo okio.Buffer buffer, @OOXIXo Source source, long j) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(source, "source");
        while (j > 0) {
            long read = source.read(buffer, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return buffer;
    }

    public static final long commonRead(@OOXIXo okio.Buffer buffer, @OOXIXo okio.Buffer sink, long j) {
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (buffer.size() == 0) {
            return -1L;
        }
        if (j > buffer.size()) {
            j = buffer.size();
        }
        sink.write(buffer, j);
        return j;
    }

    public static final void commonWrite(@OOXIXo okio.Buffer buffer, @OOXIXo okio.Buffer source, long j) {
        Segment segment;
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(source, "source");
        if (source != buffer) {
            SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j);
            while (j > 0) {
                Segment segment2 = source.head;
                IIX0o.ooOOo0oXI(segment2);
                int i = segment2.limit;
                IIX0o.ooOOo0oXI(source.head);
                if (j < i - r1.pos) {
                    Segment segment3 = buffer.head;
                    if (segment3 != null) {
                        IIX0o.ooOOo0oXI(segment3);
                        segment = segment3.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((segment.limit + j) - (segment.shared ? 0 : segment.pos) <= 8192) {
                            Segment segment4 = source.head;
                            IIX0o.ooOOo0oXI(segment4);
                            segment4.writeTo(segment, (int) j);
                            source.setSize$okio(source.size() - j);
                            buffer.setSize$okio(buffer.size() + j);
                            return;
                        }
                    }
                    Segment segment5 = source.head;
                    IIX0o.ooOOo0oXI(segment5);
                    source.head = segment5.split((int) j);
                }
                Segment segment6 = source.head;
                IIX0o.ooOOo0oXI(segment6);
                long j2 = segment6.limit - segment6.pos;
                source.head = segment6.pop();
                Segment segment7 = buffer.head;
                if (segment7 == null) {
                    buffer.head = segment6;
                    segment6.prev = segment6;
                    segment6.next = segment6;
                } else {
                    IIX0o.ooOOo0oXI(segment7);
                    Segment segment8 = segment7.prev;
                    IIX0o.ooOOo0oXI(segment8);
                    segment8.push(segment6).compact();
                }
                source.setSize$okio(source.size() - j2);
                buffer.setSize$okio(buffer.size() + j2);
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    public static final long commonIndexOf(@OOXIXo okio.Buffer buffer, @OOXIXo ByteString bytes, long j) {
        long j2;
        long j3 = j;
        IIX0o.x0xO0oo(buffer, "<this>");
        IIX0o.x0xO0oo(bytes, "bytes");
        if (bytes.size() <= 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j4 = 0;
        if (j3 >= 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                return -1L;
            }
            if (buffer.size() - j3 < j3) {
                j4 = buffer.size();
                while (j4 > j3) {
                    segment = segment.prev;
                    IIX0o.ooOOo0oXI(segment);
                    j4 -= segment.limit - segment.pos;
                }
                byte[] internalArray$okio = bytes.internalArray$okio();
                byte b = internalArray$okio[0];
                int size = bytes.size();
                long size2 = (buffer.size() - size) + 1;
                while (j4 < size2) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min(segment.limit, (segment.pos + size2) - j4);
                    for (int i = (int) ((segment.pos + j3) - j4); i < min; i++) {
                        if (bArr[i] == b && rangeEquals(segment, i + 1, internalArray$okio, 1, size)) {
                            j2 = i - segment.pos;
                        }
                    }
                    j4 += segment.limit - segment.pos;
                    segment = segment.next;
                    IIX0o.ooOOo0oXI(segment);
                    j3 = j4;
                }
                return -1L;
            }
            while (true) {
                long j5 = (segment.limit - segment.pos) + j4;
                if (j5 > j3) {
                    break;
                }
                segment = segment.next;
                IIX0o.ooOOo0oXI(segment);
                j4 = j5;
            }
            byte[] internalArray$okio2 = bytes.internalArray$okio();
            byte b2 = internalArray$okio2[0];
            int size3 = bytes.size();
            long size4 = (buffer.size() - size3) + 1;
            while (j4 < size4) {
                byte[] bArr2 = segment.data;
                long j6 = j3;
                int min2 = (int) Math.min(segment.limit, (segment.pos + size4) - j4);
                for (int i2 = (int) ((segment.pos + j6) - j4); i2 < min2; i2++) {
                    if (bArr2[i2] == b2 && rangeEquals(segment, i2 + 1, internalArray$okio2, 1, size3)) {
                        j2 = i2 - segment.pos;
                    }
                }
                j4 += segment.limit - segment.pos;
                segment = segment.next;
                IIX0o.ooOOo0oXI(segment);
                j3 = j4;
            }
            return -1L;
            return j2 + j4;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j3).toString());
    }
}
