package okio.internal;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.EOFException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;

@xxIXOIIO(name = "-RealBufferedSink")
@XX({"SMAP\nRealBufferedSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSink.kt\nokio/internal/-RealBufferedSink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 RealBufferedSink.kt\nokio/RealBufferedSink\n*L\n1#1,219:1\n1#2:220\n51#3:221\n51#3:222\n51#3:223\n51#3:224\n51#3:225\n51#3:226\n51#3:227\n51#3:228\n51#3:229\n51#3:230\n51#3:231\n51#3:232\n51#3:233\n51#3:234\n51#3:235\n51#3:236\n51#3:237\n51#3:238\n51#3:239\n51#3:240\n51#3:241\n51#3:242\n51#3:243\n51#3:244\n51#3:245\n51#3:246\n51#3:247\n*S KotlinDebug\n*F\n+ 1 RealBufferedSink.kt\nokio/internal/-RealBufferedSink\n*L\n35#1:221\n41#1:222\n51#1:223\n57#1:224\n67#1:225\n73#1:226\n79#1:227\n89#1:228\n96#1:229\n107#1:230\n117#1:231\n123#1:232\n129#1:233\n135#1:234\n141#1:235\n147#1:236\n153#1:237\n159#1:238\n165#1:239\n171#1:240\n172#1:241\n178#1:242\n179#1:243\n185#1:244\n186#1:245\n198#1:246\n199#1:247\n*E\n"})
/* renamed from: okio.internal.-RealBufferedSink, reason: invalid class name */
/* loaded from: classes6.dex */
public final class RealBufferedSink {
    public static final void commonClose(@OOXIXo okio.RealBufferedSink realBufferedSink) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            return;
        }
        try {
            if (realBufferedSink.bufferField.size() > 0) {
                Sink sink = realBufferedSink.sink;
                Buffer buffer = realBufferedSink.bufferField;
                sink.write(buffer, buffer.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            realBufferedSink.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        realBufferedSink.closed = true;
        if (th == null) {
        } else {
            throw th;
        }
    }

    @OOXIXo
    public static final BufferedSink commonEmit(@OOXIXo okio.RealBufferedSink realBufferedSink) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            long size = realBufferedSink.bufferField.size();
            if (size > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, size);
            }
            return realBufferedSink;
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonEmitCompleteSegments(@OOXIXo okio.RealBufferedSink realBufferedSink) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            long completeSegmentByteCount = realBufferedSink.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, completeSegmentByteCount);
            }
            return realBufferedSink;
        }
        throw new IllegalStateException("closed");
    }

    public static final void commonFlush(@OOXIXo okio.RealBufferedSink realBufferedSink) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            if (realBufferedSink.bufferField.size() > 0) {
                Sink sink = realBufferedSink.sink;
                Buffer buffer = realBufferedSink.bufferField;
                sink.write(buffer, buffer.size());
            }
            realBufferedSink.sink.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final Timeout commonTimeout(@OOXIXo okio.RealBufferedSink realBufferedSink) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        return realBufferedSink.sink.timeout();
    }

    @OOXIXo
    public static final String commonToString(@OOXIXo okio.RealBufferedSink realBufferedSink) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        return "buffer(" + realBufferedSink.sink + HexStringBuilder.COMMENT_END_CHAR;
    }

    public static final void commonWrite(@OOXIXo okio.RealBufferedSink realBufferedSink, @OOXIXo Buffer source, long j) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        IIX0o.x0xO0oo(source, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(source, j);
            realBufferedSink.emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public static final long commonWriteAll(@OOXIXo okio.RealBufferedSink realBufferedSink, @OOXIXo Source source) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        IIX0o.x0xO0oo(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(realBufferedSink.bufferField, 8192L);
            if (read != -1) {
                j += read;
                realBufferedSink.emitCompleteSegments();
            } else {
                return j;
            }
        }
    }

    @OOXIXo
    public static final BufferedSink commonWriteByte(@OOXIXo okio.RealBufferedSink realBufferedSink, int i) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeByte(i);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWriteDecimalLong(@OOXIXo okio.RealBufferedSink realBufferedSink, long j) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeDecimalLong(j);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWriteHexadecimalUnsignedLong(@OOXIXo okio.RealBufferedSink realBufferedSink, long j) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeHexadecimalUnsignedLong(j);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWriteInt(@OOXIXo okio.RealBufferedSink realBufferedSink, int i) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeInt(i);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWriteIntLe(@OOXIXo okio.RealBufferedSink realBufferedSink, int i) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeIntLe(i);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWriteLong(@OOXIXo okio.RealBufferedSink realBufferedSink, long j) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeLong(j);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWriteLongLe(@OOXIXo okio.RealBufferedSink realBufferedSink, long j) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeLongLe(j);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWriteShort(@OOXIXo okio.RealBufferedSink realBufferedSink, int i) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeShort(i);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWriteShortLe(@OOXIXo okio.RealBufferedSink realBufferedSink, int i) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeShortLe(i);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWriteUtf8(@OOXIXo okio.RealBufferedSink realBufferedSink, @OOXIXo String string) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        IIX0o.x0xO0oo(string, "string");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(string);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWriteUtf8CodePoint(@OOXIXo okio.RealBufferedSink realBufferedSink, int i) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8CodePoint(i);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWrite(@OOXIXo okio.RealBufferedSink realBufferedSink, @OOXIXo ByteString byteString) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        IIX0o.x0xO0oo(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWriteUtf8(@OOXIXo okio.RealBufferedSink realBufferedSink, @OOXIXo String string, int i, int i2) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        IIX0o.x0xO0oo(string, "string");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(string, i, i2);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWrite(@OOXIXo okio.RealBufferedSink realBufferedSink, @OOXIXo ByteString byteString, int i, int i2) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        IIX0o.x0xO0oo(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString, i, i2);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWrite(@OOXIXo okio.RealBufferedSink realBufferedSink, @OOXIXo byte[] source) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        IIX0o.x0xO0oo(source, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(source);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWrite(@OOXIXo okio.RealBufferedSink realBufferedSink, @OOXIXo byte[] source, int i, int i2) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        IIX0o.x0xO0oo(source, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(source, i, i2);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @OOXIXo
    public static final BufferedSink commonWrite(@OOXIXo okio.RealBufferedSink realBufferedSink, @OOXIXo Source source, long j) {
        IIX0o.x0xO0oo(realBufferedSink, "<this>");
        IIX0o.x0xO0oo(source, "source");
        while (j > 0) {
            long read = source.read(realBufferedSink.bufferField, j);
            if (read != -1) {
                j -= read;
                realBufferedSink.emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return realBufferedSink;
    }
}
