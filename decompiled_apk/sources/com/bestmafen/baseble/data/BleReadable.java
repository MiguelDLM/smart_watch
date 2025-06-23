package com.bestmafen.baseble.data;

import OI0.oIX0oI;
import OXOo.OOXIXo;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.szabh.smable3.component.BleConstsKt;
import com.szabh.smable3.entity.BleWatchFaceId;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.OX00O0xII;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.oxoX;

@XX({"SMAP\nBleReadable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,322:1\n222#1,4:329\n1639#2,6:323\n13384#2,3:333\n*S KotlinDebug\n*F\n+ 1 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n234#1:329,4\n190#1:323,6\n244#1:333,3\n*E\n"})
/* loaded from: classes8.dex */
public class BleReadable extends BleByteArray {
    private static final byte BYTE0 = 0;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @XX({"SMAP\nBleReadable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable$Companion\n*L\n1#1,322:1\n277#1,5:323\n*S KotlinDebug\n*F\n+ 1 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable$Companion\n*L\n295#1:323,5\n*E\n"})
    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ List ofList$default(Companion companion, byte[] bytes, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                i2 = 0;
            }
            if ((i4 & 8) != 0) {
                i3 = bytes.length;
            }
            IIX0o.x0xO0oo(bytes, "bytes");
            ArrayList arrayList = new ArrayList();
            int i5 = (i3 - i2) / i;
            if (i5 > 0) {
                int i6 = 0;
                while (i6 < i5) {
                    Companion companion2 = BleReadable.Companion;
                    int i7 = (i * i6) + i2;
                    i6++;
                    byte[] xxOXOOoIX2 = ooOOo0oXI.xxOXOOoIX(bytes, i7, (i * i6) + i2);
                    int length = xxOXOOoIX2.length;
                    IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                    Object newInstance = BleReadable.class.newInstance();
                    BleReadable bleReadable = (BleReadable) newInstance;
                    bleReadable.setMBytes(ooOOo0oXI.xxOXOOoIX(xxOXOOoIX2, 0, length));
                    bleReadable.decode();
                    IIX0o.oO(newInstance, "also(...)");
                    arrayList.add(bleReadable);
                }
            }
            return arrayList;
        }

        public static /* synthetic */ BleReadable ofObject$default(Companion companion, byte[] bytes, int i, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bytes.length;
            }
            IIX0o.x0xO0oo(bytes, "bytes");
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            Object newInstance = BleReadable.class.newInstance();
            BleReadable bleReadable = (BleReadable) newInstance;
            bleReadable.setMBytes(ooOOo0oXI.xxOXOOoIX(bytes, i, i2));
            bleReadable.decode();
            IIX0o.oO(newInstance, "also(...)");
            return bleReadable;
        }

        public static /* synthetic */ SimpleDateFormat timeFormat$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "yyyy/MM/dd HH:mm:ss";
            }
            return companion.timeFormat(str);
        }

        public final long millisToTime(long j) {
            return ((j + TimeZone.getDefault().getOffset(System.currentTimeMillis())) / 1000) - BleConstsKt.DATA_EPOCH;
        }

        public final /* synthetic */ <T extends BleReadable> List<T> ofList(byte[] bytes, int i, int i2, int i3) {
            IIX0o.x0xO0oo(bytes, "bytes");
            ArrayList arrayList = new ArrayList();
            int i4 = (i3 - i2) / i;
            if (i4 > 0) {
                int i5 = 0;
                while (i5 < i4) {
                    Companion companion = BleReadable.Companion;
                    int i6 = (i * i5) + i2;
                    i5++;
                    byte[] xxOXOOoIX2 = ooOOo0oXI.xxOXOOoIX(bytes, i6, (i * i5) + i2);
                    int length = xxOXOOoIX2.length;
                    IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                    Object newInstance = BleReadable.class.newInstance();
                    BleReadable bleReadable = (BleReadable) newInstance;
                    bleReadable.setMBytes(ooOOo0oXI.xxOXOOoIX(xxOXOOoIX2, 0, length));
                    bleReadable.decode();
                    IIX0o.oO(newInstance, "also(...)");
                    arrayList.add(bleReadable);
                }
            }
            return arrayList;
        }

        public final /* synthetic */ <T extends BleReadable> T ofObject(byte[] bytes, int i, int i2) {
            IIX0o.x0xO0oo(bytes, "bytes");
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            Object newInstance = BleReadable.class.newInstance();
            T t = (T) newInstance;
            t.setMBytes(ooOOo0oXI.xxOXOOoIX(bytes, i, i2));
            t.decode();
            IIX0o.oO(newInstance, "also(...)");
            return t;
        }

        @OOXIXo
        public final SimpleDateFormat timeFormat(@OOXIXo String pattern) {
            IIX0o.x0xO0oo(pattern, "pattern");
            return new SimpleDateFormat(pattern, Locale.ENGLISH);
        }

        public final long timeToMillis(int i) {
            return ((i + BleConstsKt.DATA_EPOCH) * 1000) - TimeZone.getDefault().getOffset(System.currentTimeMillis());
        }

        private Companion() {
        }
    }

    public BleReadable() {
        super(null, null, 3, null);
    }

    public static /* synthetic */ double readDouble$default(BleReadable bleReadable, ByteOrder byteOrder, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                byteOrder = bleReadable.getMByteOrder();
            }
            return bleReadable.readDouble(byteOrder);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readDouble");
    }

    public static /* synthetic */ float readFloat$default(BleReadable bleReadable, ByteOrder byteOrder, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                byteOrder = bleReadable.getMByteOrder();
            }
            return bleReadable.readFloat(byteOrder);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readFloat");
    }

    public static /* synthetic */ short readInt16$default(BleReadable bleReadable, ByteOrder byteOrder, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                byteOrder = bleReadable.getMByteOrder();
            }
            return bleReadable.readInt16(byteOrder);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readInt16");
    }

    public static /* synthetic */ int readInt24$default(BleReadable bleReadable, ByteOrder byteOrder, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                byteOrder = bleReadable.getMByteOrder();
            }
            return bleReadable.readInt24(byteOrder);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readInt24");
    }

    public static /* synthetic */ int readInt32$default(BleReadable bleReadable, ByteOrder byteOrder, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                byteOrder = bleReadable.getMByteOrder();
            }
            return bleReadable.readInt32(byteOrder);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readInt32");
    }

    public static /* synthetic */ long readInt64$default(BleReadable bleReadable, ByteOrder byteOrder, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                byteOrder = bleReadable.getMByteOrder();
            }
            return bleReadable.readInt64(byteOrder);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readInt64");
    }

    public static /* synthetic */ String readString$default(BleReadable bleReadable, int i, Charset charset, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                charset = Charset.defaultCharset();
                IIX0o.oO(charset, "defaultCharset(...)");
            }
            return bleReadable.readString(i, charset);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readString");
    }

    public static /* synthetic */ String readStringUtil$default(BleReadable bleReadable, byte b, Charset charset, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                charset = Charset.defaultCharset();
                IIX0o.oO(charset, "defaultCharset(...)");
            }
            return bleReadable.readStringUtil(b, charset);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readStringUtil");
    }

    public static /* synthetic */ char readUInt16$default(BleReadable bleReadable, ByteOrder byteOrder, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                byteOrder = bleReadable.getMByteOrder();
            }
            return bleReadable.readUInt16(byteOrder);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readUInt16");
    }

    public static /* synthetic */ long readUInt32$default(BleReadable bleReadable, ByteOrder byteOrder, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                byteOrder = bleReadable.getMByteOrder();
            }
            return bleReadable.readUInt32(byteOrder);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readUInt32");
    }

    @CallSuper
    public void decode() {
        resetOffset();
    }

    public final boolean readBoolean() {
        if (readIntN(1) == 1) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final byte[] readBytes(int i) {
        if (i < 0) {
            oIX0oI.f1507oIX0oI.oIX0oI("readBytes error length = " + i + TokenParser.SP);
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = readInt8();
        }
        return bArr;
    }

    @OOXIXo
    public final byte[] readBytesUtil(byte b) {
        byte[] mBytes = getMBytes();
        if (mBytes != null) {
            int length = mBytes.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte b2 = mBytes[i];
                int i3 = i2 + 1;
                if (i2 >= getMPositions()[0] && b2 == b) {
                    byte[] readBytes = readBytes(i2 - getMPositions()[0]);
                    skip(8);
                    return readBytes;
                }
                i++;
                i2 = i3;
            }
        }
        return new byte[0];
    }

    public final double readDouble(@OOXIXo ByteOrder order) {
        IIX0o.x0xO0oo(order, "order");
        return Double.longBitsToDouble(readInt64(order));
    }

    public final float readFloat(@OOXIXo ByteOrder order) {
        IIX0o.x0xO0oo(order, "order");
        return Float.intBitsToFloat(readInt32(order));
    }

    public final short readInt16(@OOXIXo ByteOrder order) {
        byte readInt8;
        byte readInt82;
        IIX0o.x0xO0oo(order, "order");
        if (IIX0o.Oxx0IOOO(order, ByteOrder.BIG_ENDIAN)) {
            readInt82 = readInt8();
            readInt8 = readInt8();
        } else {
            readInt8 = readInt8();
            readInt82 = readInt8();
        }
        return (short) (((readInt82 & 255) << 8) | (readInt8 & 255));
    }

    public final int readInt24(@OOXIXo ByteOrder order) {
        char readUInt16;
        char readUInt8;
        IIX0o.x0xO0oo(order, "order");
        if (IIX0o.Oxx0IOOO(order, ByteOrder.BIG_ENDIAN)) {
            readUInt8 = readUInt8();
            readUInt16 = readUInt16(order);
        } else {
            readUInt16 = readUInt16(order);
            readUInt8 = readUInt8();
        }
        return readUInt16 | (readUInt8 << 16);
    }

    public final int readInt32(@OOXIXo ByteOrder order) {
        short readInt16;
        short s;
        IIX0o.x0xO0oo(order, "order");
        if (IIX0o.Oxx0IOOO(order, ByteOrder.BIG_ENDIAN)) {
            readInt16 = readInt16(order);
            s = readInt16(order);
        } else {
            short readInt162 = readInt16(order);
            readInt16 = readInt16(order);
            s = readInt162;
        }
        return (s & OX00O0xII.f29066Oxx0xo) | ((readInt16 & OX00O0xII.f29066Oxx0xo) << 16);
    }

    public final long readInt64(@OOXIXo ByteOrder order) {
        int readInt32;
        int i;
        IIX0o.x0xO0oo(order, "order");
        if (IIX0o.Oxx0IOOO(order, ByteOrder.BIG_ENDIAN)) {
            readInt32 = readInt32(order);
            i = readInt32(order);
        } else {
            int readInt322 = readInt32(order);
            readInt32 = readInt32(order);
            i = readInt322;
        }
        return ((readInt32 & BleWatchFaceId.WATCHFACE_ID_INVALID) << 32) | (BleWatchFaceId.WATCHFACE_ID_INVALID & i);
    }

    public final byte readInt8() {
        return readIntN(8);
    }

    public final byte readIntN(@IntRange(from = 1, to = 8) int i) {
        int i2;
        if (i < 1 || i > 8 || outOfRange(i)) {
            return (byte) 0;
        }
        if (getMPositions()[1] + i <= 8) {
            byte[] mBytes = getMBytes();
            IIX0o.ooOOo0oXI(mBytes);
            i2 = (mBytes[getMPositions()[0]] >> ((8 - getMPositions()[1]) - i)) & (((2 << i) >> 1) - 1);
        } else {
            byte[] mBytes2 = getMBytes();
            IIX0o.ooOOo0oXI(mBytes2);
            int i3 = (mBytes2[getMPositions()[0]] & (((2 << (8 - getMPositions()[1])) >> 1) - 1)) << ((getMPositions()[1] + i) - 8);
            byte[] mBytes3 = getMBytes();
            IIX0o.ooOOo0oXI(mBytes3);
            i2 = ((mBytes3[getMPositions()[0] + 1] & 255) >> ((16 - getMPositions()[1]) - i)) | i3;
        }
        skip(i);
        return (byte) i2;
    }

    public final /* synthetic */ <T extends BleReadable> List<T> readList(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i; i3++) {
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            BleReadable bleReadable = (BleReadable) BleReadable.class.newInstance();
            bleReadable.setMBytes(readBytes(i2));
            bleReadable.decode();
            IIX0o.ooOOo0oXI(bleReadable);
            arrayList.add(bleReadable);
        }
        return arrayList;
    }

    public final /* synthetic */ <T extends BleReadable> T readObject(int i) {
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) BleReadable.class.newInstance();
        t.setMBytes(readBytes(i));
        t.decode();
        IIX0o.ooOOo0oXI(t);
        return t;
    }

    @OOXIXo
    public final String readString(int i, @OOXIXo Charset charset) {
        String str;
        int i2;
        IIX0o.x0xO0oo(charset, "charset");
        try {
            byte[] readBytes = readBytes(i);
            int i3 = 0;
            if (!IIX0o.Oxx0IOOO(charset, oxoX.f29581II0xO0) && !IIX0o.Oxx0IOOO(charset, oxoX.f29584XO)) {
                if (!IIX0o.Oxx0IOOO(charset, oxoX.f29579I0Io) && !IIX0o.Oxx0IOOO(charset, oxoX.f29586oxoX) && !IIX0o.Oxx0IOOO(charset, oxoX.f29583X0o0xo)) {
                    return "";
                }
                int i4 = i / 2;
                while (true) {
                    if (i3 < i4) {
                        i2 = i3 * 2;
                        if (readBytes[i2] == 0 && readBytes[i2 + 1] == 0) {
                            break;
                        }
                        i3++;
                    } else {
                        i2 = -1;
                        break;
                    }
                }
                if (i2 == -1) {
                    str = new String(readBytes, charset);
                } else {
                    byte[] copyOf = Arrays.copyOf(readBytes, i2);
                    IIX0o.oO(copyOf, "copyOf(...)");
                    str = new String(copyOf, charset);
                }
                return str;
            }
            int length = readBytes.length;
            while (true) {
                if (i3 < length) {
                    if (readBytes[i3] == 0) {
                        break;
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 == -1) {
                str = new String(readBytes, charset);
            } else {
                byte[] copyOf2 = Arrays.copyOf(readBytes, i3);
                IIX0o.oO(copyOf2, "copyOf(...)");
                str = new String(copyOf2, charset);
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @OOXIXo
    public final String readStringUtil(byte b, @OOXIXo Charset charset) {
        IIX0o.x0xO0oo(charset, "charset");
        byte[] readBytesUtil = readBytesUtil(b);
        if (readBytesUtil.length == 0) {
            return "";
        }
        return new String(readBytesUtil, charset);
    }

    public final char readUInt16(@OOXIXo ByteOrder order) {
        IIX0o.x0xO0oo(order, "order");
        return (char) readInt16(order);
    }

    public final long readUInt32(@OOXIXo ByteOrder order) {
        IIX0o.x0xO0oo(order, "order");
        return readInt32(order) & BleWatchFaceId.WATCHFACE_ID_INVALID;
    }

    public final char readUInt8() {
        return (char) (readIntN(8) & 255);
    }
}
