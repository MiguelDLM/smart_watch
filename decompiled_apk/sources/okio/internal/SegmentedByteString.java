package okio.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.IXxxXO;
import XO0OX.xxIXOIIO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import okio.Buffer;
import okio.ByteString;
import okio.C1189SegmentedByteString;
import okio.Segment;

@xxIXOIIO(name = "-SegmentedByteString")
@XX({"SMAP\nSegmentedByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,250:1\n63#1,12:252\n85#1,14:264\n85#1,14:278\n85#1,14:292\n85#1,14:306\n63#1,12:320\n1#2:251\n*S KotlinDebug\n*F\n+ 1 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n*L\n147#1:252,12\n160#1:264,14\n182#1:278,14\n202#1:292,14\n219#1:306,14\n239#1:320,12\n*E\n"})
/* renamed from: okio.internal.-SegmentedByteString, reason: invalid class name */
/* loaded from: classes6.dex */
public final class SegmentedByteString {
    public static final int binarySearch(@OOXIXo int[] iArr, int i, int i2, int i3) {
        IIX0o.x0xO0oo(iArr, "<this>");
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else if (i6 > i) {
                i4 = i5 - 1;
            } else {
                return i5;
            }
        }
        return (-i2) - 1;
    }

    public static final void commonCopyInto(@OOXIXo C1189SegmentedByteString c1189SegmentedByteString, int i, @OOXIXo byte[] target, int i2, int i3) {
        int i4;
        IIX0o.x0xO0oo(c1189SegmentedByteString, "<this>");
        IIX0o.x0xO0oo(target, "target");
        long j = i3;
        okio.SegmentedByteString.checkOffsetAndCount(c1189SegmentedByteString.size(), i, j);
        okio.SegmentedByteString.checkOffsetAndCount(target.length, i2, j);
        int i5 = i3 + i;
        int segment = segment(c1189SegmentedByteString, i);
        while (i < i5) {
            if (segment == 0) {
                i4 = 0;
            } else {
                i4 = c1189SegmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i6 = c1189SegmentedByteString.getDirectory$okio()[segment] - i4;
            int i7 = c1189SegmentedByteString.getDirectory$okio()[c1189SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i5, i6 + i4) - i;
            int i8 = i7 + (i - i4);
            ooOOo0oXI.O00XxXI(c1189SegmentedByteString.getSegments$okio()[segment], target, i2, i8, i8 + min);
            i2 += min;
            i += min;
            segment++;
        }
    }

    public static final boolean commonEquals(@OOXIXo C1189SegmentedByteString c1189SegmentedByteString, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(c1189SegmentedByteString, "<this>");
        if (obj == c1189SegmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == c1189SegmentedByteString.size() && c1189SegmentedByteString.rangeEquals(0, byteString, 0, c1189SegmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@OOXIXo C1189SegmentedByteString c1189SegmentedByteString) {
        IIX0o.x0xO0oo(c1189SegmentedByteString, "<this>");
        return c1189SegmentedByteString.getDirectory$okio()[c1189SegmentedByteString.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(@OOXIXo C1189SegmentedByteString c1189SegmentedByteString) {
        IIX0o.x0xO0oo(c1189SegmentedByteString, "<this>");
        int hashCode$okio = c1189SegmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = c1189SegmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        while (i < length) {
            int i4 = c1189SegmentedByteString.getDirectory$okio()[length + i];
            int i5 = c1189SegmentedByteString.getDirectory$okio()[i];
            byte[] bArr = c1189SegmentedByteString.getSegments$okio()[i];
            int i6 = (i5 - i2) + i4;
            while (i4 < i6) {
                i3 = (i3 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i2 = i5;
        }
        c1189SegmentedByteString.setHashCode$okio(i3);
        return i3;
    }

    public static final byte commonInternalGet(@OOXIXo C1189SegmentedByteString c1189SegmentedByteString, int i) {
        int i2;
        IIX0o.x0xO0oo(c1189SegmentedByteString, "<this>");
        okio.SegmentedByteString.checkOffsetAndCount(c1189SegmentedByteString.getDirectory$okio()[c1189SegmentedByteString.getSegments$okio().length - 1], i, 1L);
        int segment = segment(c1189SegmentedByteString, i);
        if (segment == 0) {
            i2 = 0;
        } else {
            i2 = c1189SegmentedByteString.getDirectory$okio()[segment - 1];
        }
        return c1189SegmentedByteString.getSegments$okio()[segment][(i - i2) + c1189SegmentedByteString.getDirectory$okio()[c1189SegmentedByteString.getSegments$okio().length + segment]];
    }

    public static final boolean commonRangeEquals(@OOXIXo C1189SegmentedByteString c1189SegmentedByteString, int i, @OOXIXo ByteString other, int i2, int i3) {
        IIX0o.x0xO0oo(c1189SegmentedByteString, "<this>");
        IIX0o.x0xO0oo(other, "other");
        if (i < 0 || i > c1189SegmentedByteString.size() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int segment = segment(c1189SegmentedByteString, i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : c1189SegmentedByteString.getDirectory$okio()[segment - 1];
            int i6 = c1189SegmentedByteString.getDirectory$okio()[segment] - i5;
            int i7 = c1189SegmentedByteString.getDirectory$okio()[c1189SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i4, i6 + i5) - i;
            if (!other.rangeEquals(i2, c1189SegmentedByteString.getSegments$okio()[segment], i7 + (i - i5), min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }

    @OOXIXo
    public static final ByteString commonSubstring(@OOXIXo C1189SegmentedByteString c1189SegmentedByteString, int i, int i2) {
        IIX0o.x0xO0oo(c1189SegmentedByteString, "<this>");
        int resolveDefaultParameter = okio.SegmentedByteString.resolveDefaultParameter(c1189SegmentedByteString, i2);
        if (i >= 0) {
            if (resolveDefaultParameter <= c1189SegmentedByteString.size()) {
                int i3 = resolveDefaultParameter - i;
                if (i3 >= 0) {
                    if (i == 0 && resolveDefaultParameter == c1189SegmentedByteString.size()) {
                        return c1189SegmentedByteString;
                    }
                    if (i == resolveDefaultParameter) {
                        return ByteString.EMPTY;
                    }
                    int segment = segment(c1189SegmentedByteString, i);
                    int segment2 = segment(c1189SegmentedByteString, resolveDefaultParameter - 1);
                    byte[][] bArr = (byte[][]) ooOOo0oXI.IO0XoXxO(c1189SegmentedByteString.getSegments$okio(), segment, segment2 + 1);
                    int[] iArr = new int[bArr.length * 2];
                    int i4 = 0;
                    if (segment <= segment2) {
                        int i5 = segment;
                        int i6 = 0;
                        while (true) {
                            iArr[i6] = Math.min(c1189SegmentedByteString.getDirectory$okio()[i5] - i, i3);
                            int i7 = i6 + 1;
                            iArr[i6 + bArr.length] = c1189SegmentedByteString.getDirectory$okio()[c1189SegmentedByteString.getSegments$okio().length + i5];
                            if (i5 == segment2) {
                                break;
                            }
                            i5++;
                            i6 = i7;
                        }
                    }
                    if (segment != 0) {
                        i4 = c1189SegmentedByteString.getDirectory$okio()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i - i4);
                    return new C1189SegmentedByteString(bArr, iArr);
                }
                throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i).toString());
            }
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + c1189SegmentedByteString.size() + HexStringBuilder.COMMENT_END_CHAR).toString());
        }
        throw new IllegalArgumentException(("beginIndex=" + i + " < 0").toString());
    }

    @OOXIXo
    public static final byte[] commonToByteArray(@OOXIXo C1189SegmentedByteString c1189SegmentedByteString) {
        IIX0o.x0xO0oo(c1189SegmentedByteString, "<this>");
        byte[] bArr = new byte[c1189SegmentedByteString.size()];
        int length = c1189SegmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = c1189SegmentedByteString.getDirectory$okio()[length + i];
            int i5 = c1189SegmentedByteString.getDirectory$okio()[i];
            int i6 = i5 - i2;
            ooOOo0oXI.O00XxXI(c1189SegmentedByteString.getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public static final void commonWrite(@OOXIXo C1189SegmentedByteString c1189SegmentedByteString, @OOXIXo Buffer buffer, int i, int i2) {
        int i3;
        IIX0o.x0xO0oo(c1189SegmentedByteString, "<this>");
        IIX0o.x0xO0oo(buffer, "buffer");
        int i4 = i + i2;
        int segment = segment(c1189SegmentedByteString, i);
        while (i < i4) {
            if (segment == 0) {
                i3 = 0;
            } else {
                i3 = c1189SegmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i5 = c1189SegmentedByteString.getDirectory$okio()[segment] - i3;
            int i6 = c1189SegmentedByteString.getDirectory$okio()[c1189SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i4, i5 + i3) - i;
            int i7 = i6 + (i - i3);
            Segment segment2 = new Segment(c1189SegmentedByteString.getSegments$okio()[segment], i7, i7 + min, true, false);
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

    public static final void forEachSegment(@OOXIXo C1189SegmentedByteString c1189SegmentedByteString, @OOXIXo IXxxXO<? super byte[], ? super Integer, ? super Integer, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(c1189SegmentedByteString, "<this>");
        IIX0o.x0xO0oo(action, "action");
        int length = c1189SegmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = c1189SegmentedByteString.getDirectory$okio()[length + i];
            int i4 = c1189SegmentedByteString.getDirectory$okio()[i];
            action.invoke(c1189SegmentedByteString.getSegments$okio()[i], Integer.valueOf(i3), Integer.valueOf(i4 - i2));
            i++;
            i2 = i4;
        }
    }

    public static final int segment(@OOXIXo C1189SegmentedByteString c1189SegmentedByteString, int i) {
        IIX0o.x0xO0oo(c1189SegmentedByteString, "<this>");
        int binarySearch = binarySearch(c1189SegmentedByteString.getDirectory$okio(), i + 1, 0, c1189SegmentedByteString.getSegments$okio().length);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        return binarySearch;
    }

    private static final void forEachSegment(C1189SegmentedByteString c1189SegmentedByteString, int i, int i2, IXxxXO<? super byte[], ? super Integer, ? super Integer, oXIO0o0XI> iXxxXO) {
        int segment = segment(c1189SegmentedByteString, i);
        while (i < i2) {
            int i3 = segment == 0 ? 0 : c1189SegmentedByteString.getDirectory$okio()[segment - 1];
            int i4 = c1189SegmentedByteString.getDirectory$okio()[segment] - i3;
            int i5 = c1189SegmentedByteString.getDirectory$okio()[c1189SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i2, i4 + i3) - i;
            iXxxXO.invoke(c1189SegmentedByteString.getSegments$okio()[segment], Integer.valueOf(i5 + (i - i3)), Integer.valueOf(min));
            i += min;
            segment++;
        }
    }

    public static final boolean commonRangeEquals(@OOXIXo C1189SegmentedByteString c1189SegmentedByteString, int i, @OOXIXo byte[] other, int i2, int i3) {
        IIX0o.x0xO0oo(c1189SegmentedByteString, "<this>");
        IIX0o.x0xO0oo(other, "other");
        if (i < 0 || i > c1189SegmentedByteString.size() - i3 || i2 < 0 || i2 > other.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int segment = segment(c1189SegmentedByteString, i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : c1189SegmentedByteString.getDirectory$okio()[segment - 1];
            int i6 = c1189SegmentedByteString.getDirectory$okio()[segment] - i5;
            int i7 = c1189SegmentedByteString.getDirectory$okio()[c1189SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i4, i6 + i5) - i;
            if (!okio.SegmentedByteString.arrayRangeEquals(c1189SegmentedByteString.getSegments$okio()[segment], i7 + (i - i5), other, i2, min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }
}
