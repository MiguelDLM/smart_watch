package okio.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.EOFException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.XIxXXX0x0;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Timeout;

@xxIXOIIO(name = "-RealBufferedSource")
@XX({"SMAP\nRealBufferedSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSource.kt\nokio/internal/-RealBufferedSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 RealBufferedSource.kt\nokio/RealBufferedSource\n+ 4 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,402:1\n1#2:403\n62#3:404\n62#3:405\n62#3:406\n62#3:407\n62#3:408\n62#3:409\n62#3:410\n62#3:411\n62#3:412\n62#3:413\n62#3:414\n62#3:415\n62#3:416\n62#3:417\n62#3:418\n62#3:419\n62#3:420\n62#3:421\n62#3:422\n62#3:423\n62#3:424\n62#3:425\n62#3:426\n62#3:428\n62#3:429\n62#3:430\n62#3:431\n62#3:432\n62#3:433\n62#3:434\n62#3:435\n62#3:436\n62#3:437\n62#3:438\n62#3:439\n62#3:440\n62#3:441\n62#3:442\n62#3:443\n62#3:444\n62#3:445\n62#3:446\n62#3:447\n62#3:449\n62#3:450\n62#3:451\n62#3:452\n62#3:453\n62#3:454\n62#3:455\n62#3:456\n62#3:457\n62#3:458\n62#3:459\n62#3:460\n62#3:461\n62#3:462\n62#3:463\n62#3:464\n62#3:465\n62#3:466\n62#3:467\n62#3:468\n62#3:469\n62#3:470\n62#3:471\n62#3:472\n62#3:473\n62#3:474\n62#3:475\n89#4:427\n89#4:448\n*S KotlinDebug\n*F\n+ 1 RealBufferedSource.kt\nokio/internal/-RealBufferedSource\n*L\n41#1:404\n42#1:405\n46#1:406\n47#1:407\n52#1:408\n62#1:409\n63#1:410\n70#1:411\n74#1:412\n75#1:413\n80#1:414\n87#1:415\n94#1:416\n99#1:417\n107#1:418\n108#1:419\n113#1:420\n122#1:421\n123#1:422\n130#1:423\n136#1:424\n137#1:425\n141#1:426\n142#1:428\n150#1:429\n154#1:430\n159#1:431\n160#1:432\n163#1:433\n166#1:434\n167#1:435\n168#1:436\n174#1:437\n175#1:438\n180#1:439\n187#1:440\n188#1:441\n193#1:442\n201#1:443\n203#1:444\n204#1:445\n206#1:446\n209#1:447\n211#1:449\n219#1:450\n226#1:451\n231#1:452\n236#1:453\n241#1:454\n246#1:455\n251#1:456\n256#1:457\n264#1:458\n275#1:459\n283#1:460\n297#1:461\n304#1:462\n307#1:463\n308#1:464\n319#1:465\n324#1:466\n325#1:467\n338#1:468\n341#1:469\n342#1:470\n354#1:471\n357#1:472\n358#1:473\n383#1:474\n396#1:475\n141#1:427\n209#1:448\n*E\n"})
/* renamed from: okio.internal.-RealBufferedSource, reason: invalid class name */
/* loaded from: classes6.dex */
public final class RealBufferedSource {
    public static final void commonClose(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        if (realBufferedSource.closed) {
            return;
        }
        realBufferedSource.closed = true;
        realBufferedSource.source.close();
        realBufferedSource.bufferField.clear();
    }

    public static final boolean commonExhausted(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        if (!realBufferedSource.closed) {
            if (realBufferedSource.bufferField.exhausted() && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed");
    }

    public static final long commonIndexOf(@OOXIXo okio.RealBufferedSource realBufferedSource, byte b, long j, long j2) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed");
        }
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        while (j < j2) {
            long indexOf = realBufferedSource.bufferField.indexOf(b, j, j2);
            if (indexOf == -1) {
                long size = realBufferedSource.bufferField.size();
                if (size >= j2 || realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                    break;
                }
                j = Math.max(j, size);
            } else {
                return indexOf;
            }
        }
        return -1L;
    }

    public static final long commonIndexOfElement(@OOXIXo okio.RealBufferedSource realBufferedSource, @OOXIXo ByteString targetBytes, long j) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        IIX0o.x0xO0oo(targetBytes, "targetBytes");
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOfElement = realBufferedSource.bufferField.indexOfElement(targetBytes, j);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, size);
        }
    }

    @OOXIXo
    public static final BufferedSource commonPeek(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        return Okio.buffer(new PeekSource(realBufferedSource));
    }

    public static final boolean commonRangeEquals(@OOXIXo okio.RealBufferedSource realBufferedSource, long j, @OOXIXo ByteString bytes, int i, int i2) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        IIX0o.x0xO0oo(bytes, "bytes");
        if (!realBufferedSource.closed) {
            if (j < 0 || i < 0 || i2 < 0 || bytes.size() - i < i2) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = i3 + j;
                if (!realBufferedSource.request(1 + j2) || realBufferedSource.bufferField.getByte(j2) != bytes.getByte(i + i3)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    public static final long commonRead(@OOXIXo okio.RealBufferedSource realBufferedSource, @OOXIXo Buffer sink, long j) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        IIX0o.x0xO0oo(sink, "sink");
        if (j >= 0) {
            if (realBufferedSource.closed) {
                throw new IllegalStateException("closed");
            }
            if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1L;
            }
            return realBufferedSource.bufferField.read(sink, Math.min(j, realBufferedSource.bufferField.size()));
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
    }

    public static final long commonReadAll(@OOXIXo okio.RealBufferedSource realBufferedSource, @OOXIXo Sink sink) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        IIX0o.x0xO0oo(sink, "sink");
        long j = 0;
        while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) != -1) {
            long completeSegmentByteCount = realBufferedSource.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j += completeSegmentByteCount;
                sink.write(realBufferedSource.bufferField, completeSegmentByteCount);
            }
        }
        if (realBufferedSource.bufferField.size() > 0) {
            long size = j + realBufferedSource.bufferField.size();
            Buffer buffer = realBufferedSource.bufferField;
            sink.write(buffer, buffer.size());
            return size;
        }
        return j;
    }

    public static final byte commonReadByte(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        return realBufferedSource.bufferField.readByte();
    }

    @OOXIXo
    public static final byte[] commonReadByteArray(@OOXIXo okio.RealBufferedSource realBufferedSource, long j) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readByteArray(j);
    }

    @OOXIXo
    public static final ByteString commonReadByteString(@OOXIXo okio.RealBufferedSource realBufferedSource, long j) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readByteString(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("Expected a digit or '-' but was 0x");
        r1 = java.lang.Integer.toString(r8, kotlin.text.II0xO0.oIX0oI(kotlin.text.II0xO0.oIX0oI(16)));
        kotlin.jvm.internal.IIX0o.oO(r1, "toString(this, checkRadix(radix))");
        r0.append(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
    
        throw new java.lang.NumberFormatException(r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long commonReadDecimalLong(@OXOo.OOXIXo okio.RealBufferedSource r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r10, r0)
            r0 = 1
            r10.require(r0)
            r2 = 0
            r4 = r2
        Ld:
            long r6 = r4 + r0
            boolean r8 = r10.request(r6)
            if (r8 == 0) goto L5b
            okio.Buffer r8 = r10.bufferField
            byte r8 = r8.getByte(r4)
            r9 = 48
            if (r8 < r9) goto L23
            r9 = 57
            if (r8 <= r9) goto L2c
        L23:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L2e
            r4 = 45
            if (r8 == r4) goto L2c
            goto L2e
        L2c:
            r4 = r6
            goto Ld
        L2e:
            if (r9 == 0) goto L31
            goto L5b
        L31:
            java.lang.NumberFormatException r10 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected a digit or '-' but was 0x"
            r0.append(r1)
            r1 = 16
            int r1 = kotlin.text.II0xO0.oIX0oI(r1)
            int r1 = kotlin.text.II0xO0.oIX0oI(r1)
            java.lang.String r1 = java.lang.Integer.toString(r8, r1)
            java.lang.String r2 = "toString(this, checkRadix(radix))"
            kotlin.jvm.internal.IIX0o.oO(r1, r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L5b:
            okio.Buffer r10 = r10.bufferField
            long r0 = r10.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.RealBufferedSource.commonReadDecimalLong(okio.RealBufferedSource):long");
    }

    public static final void commonReadFully(@OOXIXo okio.RealBufferedSource realBufferedSource, @OOXIXo byte[] sink) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        IIX0o.x0xO0oo(sink, "sink");
        try {
            realBufferedSource.require(sink.length);
            realBufferedSource.bufferField.readFully(sink);
        } catch (EOFException e) {
            int i = 0;
            while (realBufferedSource.bufferField.size() > 0) {
                Buffer buffer = realBufferedSource.bufferField;
                int read = buffer.read(sink, i, (int) buffer.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                i += read;
            }
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        if (r0 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("Expected leading [0-9a-fA-F] character but was 0x");
        r1 = java.lang.Integer.toString(r2, kotlin.text.II0xO0.oIX0oI(kotlin.text.II0xO0.oIX0oI(16)));
        kotlin.jvm.internal.IIX0o.oO(r1, "toString(this, checkRadix(radix))");
        r0.append(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        throw new java.lang.NumberFormatException(r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long commonReadHexadecimalUnsignedLong(@OXOo.OOXIXo okio.RealBufferedSource r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
            r0 = 1
            r5.require(r0)
            r0 = 0
        Lb:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.request(r2)
            if (r2 == 0) goto L63
            okio.Buffer r2 = r5.bufferField
            long r3 = (long) r0
            byte r2 = r2.getByte(r3)
            r3 = 48
            if (r2 < r3) goto L23
            r3 = 57
            if (r2 <= r3) goto L34
        L23:
            r3 = 97
            if (r2 < r3) goto L2b
            r3 = 102(0x66, float:1.43E-43)
            if (r2 <= r3) goto L34
        L2b:
            r3 = 65
            if (r2 < r3) goto L36
            r3 = 70
            if (r2 <= r3) goto L34
            goto L36
        L34:
            r0 = r1
            goto Lb
        L36:
            if (r0 == 0) goto L39
            goto L63
        L39:
            java.lang.NumberFormatException r5 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            r1 = 16
            int r1 = kotlin.text.II0xO0.oIX0oI(r1)
            int r1 = kotlin.text.II0xO0.oIX0oI(r1)
            java.lang.String r1 = java.lang.Integer.toString(r2, r1)
            java.lang.String r2 = "toString(this, checkRadix(radix))"
            kotlin.jvm.internal.IIX0o.oO(r1, r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L63:
            okio.Buffer r5 = r5.bufferField
            long r0 = r5.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.RealBufferedSource.commonReadHexadecimalUnsignedLong(okio.RealBufferedSource):long");
    }

    public static final int commonReadInt(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readInt();
    }

    public static final int commonReadIntLe(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readIntLe();
    }

    public static final long commonReadLong(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLong();
    }

    public static final long commonReadLongLe(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLongLe();
    }

    public static final short commonReadShort(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShort();
    }

    public static final short commonReadShortLe(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShortLe();
    }

    @OOXIXo
    public static final String commonReadUtf8(@OOXIXo okio.RealBufferedSource realBufferedSource, long j) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readUtf8(j);
    }

    public static final int commonReadUtf8CodePoint(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        byte b = realBufferedSource.bufferField.getByte(0L);
        if ((b & 224) == 192) {
            realBufferedSource.require(2L);
        } else if ((b & 240) == 224) {
            realBufferedSource.require(3L);
        } else if ((b & 248) == 240) {
            realBufferedSource.require(4L);
        }
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }

    @oOoXoXO
    public static final String commonReadUtf8Line(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        long indexOf = realBufferedSource.indexOf((byte) 10);
        if (indexOf == -1) {
            if (realBufferedSource.bufferField.size() != 0) {
                return realBufferedSource.readUtf8(realBufferedSource.bufferField.size());
            }
            return null;
        }
        return Buffer.readUtf8Line(realBufferedSource.bufferField, indexOf);
    }

    @OOXIXo
    public static final String commonReadUtf8LineStrict(@OOXIXo okio.RealBufferedSource realBufferedSource, long j) {
        long j2;
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        if (j >= 0) {
            if (j == Long.MAX_VALUE) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = j + 1;
            }
            long indexOf = realBufferedSource.indexOf((byte) 10, 0L, j2);
            if (indexOf != -1) {
                return Buffer.readUtf8Line(realBufferedSource.bufferField, indexOf);
            }
            if (j2 < Long.MAX_VALUE && realBufferedSource.request(j2) && realBufferedSource.bufferField.getByte(j2 - 1) == 13 && realBufferedSource.request(1 + j2) && realBufferedSource.bufferField.getByte(j2) == 10) {
                return Buffer.readUtf8Line(realBufferedSource.bufferField, j2);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = realBufferedSource.bufferField;
            buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(realBufferedSource.bufferField.size(), j) + " content=" + buffer.readByteString().hex() + XIxXXX0x0.f29562xXxxox0I);
        }
        throw new IllegalArgumentException(("limit < 0: " + j).toString());
    }

    public static final boolean commonRequest(@OOXIXo okio.RealBufferedSource realBufferedSource, long j) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        if (j >= 0) {
            if (realBufferedSource.closed) {
                throw new IllegalStateException("closed");
            }
            while (realBufferedSource.bufferField.size() < j) {
                if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
    }

    public static final void commonRequire(@OOXIXo okio.RealBufferedSource realBufferedSource, long j) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        if (realBufferedSource.request(j)) {
        } else {
            throw new EOFException();
        }
    }

    public static final int commonSelect(@OOXIXo okio.RealBufferedSource realBufferedSource, @OOXIXo Options options) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        IIX0o.x0xO0oo(options, "options");
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            int selectPrefix = Buffer.selectPrefix(realBufferedSource.bufferField, options, true);
            if (selectPrefix != -2) {
                if (selectPrefix == -1) {
                    return -1;
                }
                realBufferedSource.bufferField.skip(options.getByteStrings$okio()[selectPrefix].size());
                return selectPrefix;
            }
        } while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) != -1);
        return -1;
    }

    public static final void commonSkip(@OOXIXo okio.RealBufferedSource realBufferedSource, long j) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        if (!realBufferedSource.closed) {
            while (j > 0) {
                if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, realBufferedSource.bufferField.size());
                realBufferedSource.bufferField.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final Timeout commonTimeout(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        return realBufferedSource.source.timeout();
    }

    @OOXIXo
    public static final String commonToString(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        return "buffer(" + realBufferedSource.source + HexStringBuilder.COMMENT_END_CHAR;
    }

    @OOXIXo
    public static final byte[] commonReadByteArray(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    @OOXIXo
    public static final ByteString commonReadByteString(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    @OOXIXo
    public static final String commonReadUtf8(@OOXIXo okio.RealBufferedSource realBufferedSource) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }

    public static final void commonReadFully(@OOXIXo okio.RealBufferedSource realBufferedSource, @OOXIXo Buffer sink, long j) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        IIX0o.x0xO0oo(sink, "sink");
        try {
            realBufferedSource.require(j);
            realBufferedSource.bufferField.readFully(sink, j);
        } catch (EOFException e) {
            sink.writeAll(realBufferedSource.bufferField);
            throw e;
        }
    }

    public static final long commonIndexOf(@OOXIXo okio.RealBufferedSource realBufferedSource, @OOXIXo ByteString bytes, long j) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        IIX0o.x0xO0oo(bytes, "bytes");
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOf = realBufferedSource.bufferField.indexOf(bytes, j);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, (size - bytes.size()) + 1);
        }
    }

    public static final int commonRead(@OOXIXo okio.RealBufferedSource realBufferedSource, @OOXIXo byte[] sink, int i, int i2) {
        IIX0o.x0xO0oo(realBufferedSource, "<this>");
        IIX0o.x0xO0oo(sink, "sink");
        long j = i2;
        SegmentedByteString.checkOffsetAndCount(sink.length, i, j);
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
            return -1;
        }
        return realBufferedSource.bufferField.read(sink, i, (int) Math.min(j, realBufferedSource.bufferField.size()));
    }
}
