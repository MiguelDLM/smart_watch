package com.bestmafen.baseble.data;

import OI0.I0Io;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import X0.IIXOooo;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.XIxXXX0x0;

@XX({"SMAP\nBleWritable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleWritable.kt\ncom/bestmafen/baseble/data/BleWritable\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,256:1\n13316#2,2:257\n1855#3,2:259\n1855#3,2:261\n*S KotlinDebug\n*F\n+ 1 BleWritable.kt\ncom/bestmafen/baseble/data/BleWritable\n*L\n148#1:257,2\n152#1:259,2\n251#1:261,2\n*E\n"})
/* loaded from: classes8.dex */
public class BleWritable extends BleReadable implements BleBuffer {
    public static /* synthetic */ void writeBytes$default(BleWritable bleWritable, byte[] bArr, ByteOrder byteOrder, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                byteOrder = bleWritable.getMByteOrder();
            }
            bleWritable.writeBytes(bArr, byteOrder);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeBytes");
    }

    public static /* synthetic */ void writeDouble$default(BleWritable bleWritable, double d, ByteOrder byteOrder, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                byteOrder = bleWritable.getMByteOrder();
            }
            bleWritable.writeDouble(d, byteOrder);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeDouble");
    }

    public static /* synthetic */ void writeFloat$default(BleWritable bleWritable, float f, ByteOrder byteOrder, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                byteOrder = bleWritable.getMByteOrder();
            }
            bleWritable.writeFloat(f, byteOrder);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeFloat");
    }

    public static /* synthetic */ void writeInt16$default(BleWritable bleWritable, int i, ByteOrder byteOrder, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                byteOrder = bleWritable.getMByteOrder();
            }
            bleWritable.writeInt16(i, byteOrder);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeInt16");
    }

    public static /* synthetic */ void writeInt24$default(BleWritable bleWritable, int i, ByteOrder byteOrder, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                byteOrder = bleWritable.getMByteOrder();
            }
            bleWritable.writeInt24(i, byteOrder);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeInt24");
    }

    public static /* synthetic */ void writeInt32$default(BleWritable bleWritable, int i, ByteOrder byteOrder, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                byteOrder = bleWritable.getMByteOrder();
            }
            bleWritable.writeInt32(i, byteOrder);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeInt32");
    }

    public static /* synthetic */ void writeLong$default(BleWritable bleWritable, long j, ByteOrder byteOrder, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                byteOrder = bleWritable.getMByteOrder();
            }
            bleWritable.writeLong(j, byteOrder);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeLong");
    }

    public static /* synthetic */ void writeString$default(BleWritable bleWritable, String str, Charset charset, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                charset = Charset.defaultCharset();
                IIX0o.oO(charset, "defaultCharset(...)");
            }
            bleWritable.writeString(str, charset);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeString");
    }

    public static /* synthetic */ void writeStringWithFix$default(BleWritable bleWritable, String str, int i, Charset charset, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                charset = Charset.defaultCharset();
                IIX0o.oO(charset, "defaultCharset(...)");
            }
            bleWritable.writeStringWithFix(str, i, charset);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeStringWithFix");
    }

    public static /* synthetic */ void writeStringWithLimit$default(BleWritable bleWritable, String str, int i, Charset charset, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                charset = Charset.defaultCharset();
                IIX0o.oO(charset, "defaultCharset(...)");
            }
            if ((i2 & 8) != 0) {
                z = false;
            }
            bleWritable.writeStringWithLimit(str, i, charset, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeStringWithLimit");
    }

    public static /* synthetic */ void writeStringWithMax$default(BleWritable bleWritable, String str, int i, Charset charset, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                charset = Charset.defaultCharset();
                IIX0o.oO(charset, "defaultCharset(...)");
            }
            bleWritable.writeStringWithMax(str, i, charset);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeStringWithMax");
    }

    public static /* synthetic */ void writeUInt32$default(BleWritable bleWritable, long j, ByteOrder byteOrder, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                byteOrder = bleWritable.getMByteOrder();
            }
            bleWritable.writeUInt32(j, byteOrder);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeUInt32");
    }

    @CallSuper
    public void encode() {
        resetOffset();
        setMBytes(new byte[getMLengthToWrite()]);
    }

    public int getMLengthToWrite() {
        return 0;
    }

    @Override // com.bestmafen.baseble.data.BleBuffer
    @OOXIXo
    public byte[] toByteArray() {
        encode();
        byte[] mBytes = getMBytes();
        IIX0o.ooOOo0oXI(mBytes);
        return mBytes;
    }

    public final void writeBoolean(boolean z) {
        writeIntN(z ? 1 : 0, 1);
    }

    public final void writeBytes(@oOoXoXO byte[] bArr, @OOXIXo ByteOrder order) {
        IIX0o.x0xO0oo(order, "order");
        if (bArr == null) {
            return;
        }
        if (IIX0o.Oxx0IOOO(order, ByteOrder.BIG_ENDIAN)) {
            for (byte b : bArr) {
                writeInt8(b);
            }
            return;
        }
        Iterator<T> it = ArraysKt___ArraysKt.ooXxX(bArr).iterator();
        while (it.hasNext()) {
            writeInt8(((Number) it.next()).byteValue());
        }
    }

    public final void writeDouble(double d, @OOXIXo ByteOrder order) {
        IIX0o.x0xO0oo(order, "order");
        writeLong(Double.doubleToLongBits(d), order);
    }

    public final void writeFloat(float f, @OOXIXo ByteOrder order) {
        IIX0o.x0xO0oo(order, "order");
        writeInt32(Float.floatToIntBits(f), order);
    }

    public final void writeInt16(int i, @OOXIXo ByteOrder order) {
        int i2;
        int i3;
        IIX0o.x0xO0oo(order, "order");
        if (IIX0o.Oxx0IOOO(order, ByteOrder.BIG_ENDIAN)) {
            i2 = (i >> 8) & 255;
            i3 = i & 255;
        } else {
            i2 = i & 255;
            i3 = (i >> 8) & 255;
        }
        writeInt8(i2);
        writeInt8(i3);
    }

    public final void writeInt24(int i, @OOXIXo ByteOrder order) {
        IIX0o.x0xO0oo(order, "order");
        if (IIX0o.Oxx0IOOO(order, ByteOrder.BIG_ENDIAN)) {
            writeInt16(i >> 8, order);
            writeInt8(i & 255);
        } else {
            writeInt16(65535 & i, order);
            writeInt8(i >> 16);
        }
    }

    public final void writeInt32(int i, @OOXIXo ByteOrder order) {
        IIX0o.x0xO0oo(order, "order");
        if (IIX0o.Oxx0IOOO(order, ByteOrder.BIG_ENDIAN)) {
            writeInt16(i >> 16, order);
            writeInt16(i & 65535, order);
        } else {
            writeInt16(i & 65535, order);
            writeInt16(i >> 16, order);
        }
    }

    public final void writeInt8(int i) {
        writeIntN(i, 8);
    }

    public final void writeIntN(int i, @IntRange(from = 1, to = 8) int i2) {
        if (i2 >= 1 && i2 <= 8 && !outOfRange(i2)) {
            int i3 = i & (((2 << i2) >> 1) - 1);
            if (getMPositions()[1] + i2 <= 8) {
                int i4 = 8 - (getMPositions()[1] + i2);
                byte[] mBytes = getMBytes();
                IIX0o.ooOOo0oXI(mBytes);
                int i5 = getMPositions()[0];
                byte[] mBytes2 = getMBytes();
                IIX0o.ooOOo0oXI(mBytes2);
                mBytes[i5] = (byte) (((byte) (i3 << i4)) | mBytes2[getMPositions()[0]]);
            } else {
                int i6 = (getMPositions()[1] + i2) - 8;
                byte[] mBytes3 = getMBytes();
                IIX0o.ooOOo0oXI(mBytes3);
                int i7 = getMPositions()[0];
                byte[] mBytes4 = getMBytes();
                IIX0o.ooOOo0oXI(mBytes4);
                mBytes3[i7] = (byte) (mBytes4[getMPositions()[0]] | ((byte) (i3 >> i6)));
                byte[] mBytes5 = getMBytes();
                IIX0o.ooOOo0oXI(mBytes5);
                int i8 = getMPositions()[0] + 1;
                byte[] mBytes6 = getMBytes();
                IIX0o.ooOOo0oXI(mBytes6);
                mBytes5[i8] = (byte) (((byte) ((i3 & (((2 << i6) >> 1) - 1)) << (8 - i6))) | mBytes6[getMPositions()[0] + 1]);
            }
            skip(i2);
        }
    }

    public final void writeList(@oOoXoXO List<? extends BleBuffer> list) {
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                writeObject((BleBuffer) it.next());
            }
        }
    }

    public final void writeLong(long j, @OOXIXo ByteOrder order) {
        IIX0o.x0xO0oo(order, "order");
        if (IIX0o.Oxx0IOOO(order, ByteOrder.BIG_ENDIAN)) {
            writeInt32((int) (j >> 32), order);
            writeInt32((int) j, order);
        } else {
            writeInt32((int) j, order);
            writeInt32((int) (j >> 32), order);
        }
    }

    public final void writeObject(@oOoXoXO BleBuffer bleBuffer) {
        if (bleBuffer == null) {
            return;
        }
        writeBytes$default(this, bleBuffer.toByteArray(), null, 2, null);
    }

    public final void writeString(@oOoXoXO String str, @OOXIXo Charset charSet) {
        IIX0o.x0xO0oo(charSet, "charSet");
        if (str != null && str.length() != 0) {
            byte[] bytes = str.getBytes(charSet);
            IIX0o.oO(bytes, "getBytes(...)");
            writeBytes$default(this, bytes, null, 2, null);
        }
    }

    public final void writeStringWithFix(@oOoXoXO String str, int i, @OOXIXo Charset charSet) {
        IIX0o.x0xO0oo(charSet, "charSet");
        if (str != null && str.length() != 0) {
            byte[] bytes = str.getBytes(charSet);
            IIX0o.oO(bytes, "getBytes(...)");
            writeBytes$default(this, ArraysKt___ArraysKt.oIoIxO0(bytes, IIXOooo.X00xOoXI(0, Math.min(bytes.length, i))), null, 2, null);
            if (bytes.length < i) {
                int length = i - bytes.length;
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    bArr[i2] = 0;
                }
                writeBytes$default(this, bArr, null, 2, null);
                return;
            }
            return;
        }
        skip(i * 8);
    }

    public final void writeStringWithLimit(@oOoXoXO String str, int i, @OOXIXo Charset charSet, boolean z) {
        byte[] bytes;
        IIX0o.x0xO0oo(charSet, "charSet");
        if (str != null && str.length() != 0) {
            byte[] bytes2 = str.getBytes(charSet);
            IIX0o.oO(bytes2, "getBytes(...)");
            if (bytes2.length <= i) {
                writeBytes$default(this, bytes2, null, 2, null);
                return;
            }
            if (z) {
                int length = str.length();
                do {
                    length--;
                    if (-1 < length) {
                        StringBuilder sb = new StringBuilder();
                        String substring = str.substring(0, length);
                        IIX0o.oO(substring, "substring(...)");
                        sb.append(substring);
                        sb.append(XIxXXX0x0.f29562xXxxox0I);
                        bytes = sb.toString().getBytes(charSet);
                        IIX0o.oO(bytes, "getBytes(...)");
                    } else {
                        return;
                    }
                } while (bytes.length > i);
                writeBytes$default(this, bytes, null, 2, null);
                return;
            }
            writeBytes$default(this, ArraysKt___ArraysKt.oIoIxO0(bytes2, IIXOooo.X00xOoXI(0, Math.min(bytes2.length, i))), null, 2, null);
        }
    }

    public final void writeStringWithMax(@OOXIXo String text, int i, @OOXIXo Charset charSet) {
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(charSet, "charSet");
        writeStringWithFix(I0Io.II0xO0(text, i - 1, charSet), i, charSet);
    }

    public final void writeUInt32(long j, @OOXIXo ByteOrder order) {
        IIX0o.x0xO0oo(order, "order");
        writeInt32((int) j, order);
    }
}
