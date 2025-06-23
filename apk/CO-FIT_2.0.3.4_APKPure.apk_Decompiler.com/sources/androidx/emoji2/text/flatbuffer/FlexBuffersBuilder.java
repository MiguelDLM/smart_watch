package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.FlexBuffers;
import com.garmin.fit.O0Xx;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class FlexBuffersBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8 = 0;
    /* access modifiers changed from: private */
    public final ReadWriteBuf bb;
    private boolean finished;
    private final int flags;
    private Comparator<Value> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<Value> stack;
    private final HashMap<String, Integer> stringPool;

    public static class Value {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final double dValue;
        long iValue;
        int key;
        final int minBitWidth;
        final int type;

        public Value(int i, int i2, int i3, long j) {
            this.key = i;
            this.type = i2;
            this.minBitWidth = i3;
            this.iValue = j;
            this.dValue = Double.MIN_VALUE;
        }

        public static Value blob(int i, int i2, int i3, int i4) {
            return new Value(i, i3, i4, (long) i2);
        }

        public static Value bool(int i, boolean z) {
            long j;
            if (z) {
                j = 1;
            } else {
                j = 0;
            }
            return new Value(i, 26, 0, j);
        }

        /* access modifiers changed from: private */
        public int elemWidth(int i, int i2) {
            return elemWidth(this.type, this.minBitWidth, this.iValue, i, i2);
        }

        public static Value float32(int i, float f) {
            return new Value(i, 3, 2, (double) f);
        }

        public static Value float64(int i, double d) {
            return new Value(i, 3, 3, d);
        }

        public static Value int16(int i, int i2) {
            return new Value(i, 1, 1, (long) i2);
        }

        public static Value int32(int i, int i2) {
            return new Value(i, 1, 2, (long) i2);
        }

        public static Value int64(int i, long j) {
            return new Value(i, 1, 3, j);
        }

        public static Value int8(int i, int i2) {
            return new Value(i, 1, 0, (long) i2);
        }

        private static byte packedType(int i, int i2) {
            return (byte) (i | (i2 << 2));
        }

        /* access modifiers changed from: private */
        public static int paddingBytes(int i, int i2) {
            return ((~i) + 1) & (i2 - 1);
        }

        /* access modifiers changed from: private */
        public byte storedPackedType() {
            return storedPackedType(0);
        }

        private int storedWidth(int i) {
            if (FlexBuffers.isTypeInline(this.type)) {
                return Math.max(this.minBitWidth, i);
            }
            return this.minBitWidth;
        }

        public static Value uInt16(int i, int i2) {
            return new Value(i, 2, 1, (long) i2);
        }

        public static Value uInt32(int i, int i2) {
            return new Value(i, 2, 2, (long) i2);
        }

        public static Value uInt64(int i, long j) {
            return new Value(i, 2, 3, j);
        }

        public static Value uInt8(int i, int i2) {
            return new Value(i, 2, 0, (long) i2);
        }

        /* access modifiers changed from: private */
        public static int elemWidth(int i, int i2, long j, int i3, int i4) {
            if (FlexBuffers.isTypeInline(i)) {
                return i2;
            }
            for (int i5 = 1; i5 <= 32; i5 *= 2) {
                int widthUInBits = FlexBuffersBuilder.widthUInBits((long) ((int) (((long) ((paddingBytes(i3, i5) + i3) + (i4 * i5))) - j)));
                if ((1 << widthUInBits) == ((long) i5)) {
                    return widthUInBits;
                }
            }
            return 3;
        }

        /* access modifiers changed from: private */
        public byte storedPackedType(int i) {
            return packedType(storedWidth(i), this.type);
        }

        public Value(int i, int i2, int i3, double d) {
            this.key = i;
            this.type = i2;
            this.minBitWidth = i3;
            this.dValue = d;
            this.iValue = Long.MIN_VALUE;
        }
    }

    public FlexBuffersBuilder(int i) {
        this((ReadWriteBuf) new ArrayReadWriteBuf(i), 1);
    }

    private int align(int i) {
        int i2 = 1 << i;
        int access$100 = Value.paddingBytes(this.bb.writePosition(), i2);
        while (true) {
            int i3 = access$100 - 1;
            if (access$100 == 0) {
                return i2;
            }
            this.bb.put((byte) 0);
            access$100 = i3;
        }
    }

    private Value createKeyVector(int i, int i2) {
        long j = (long) i2;
        int max = Math.max(0, widthUInBits(j));
        int i3 = i;
        while (i3 < this.stack.size()) {
            i3++;
            max = Math.max(max, Value.elemWidth(4, 0, (long) this.stack.get(i3).key, this.bb.writePosition(), i3));
        }
        int align = align(max);
        writeInt(j, align);
        int writePosition = this.bb.writePosition();
        while (i < this.stack.size()) {
            int i4 = this.stack.get(i).key;
            writeOffset((long) this.stack.get(i).key, align);
            i++;
        }
        return new Value(-1, FlexBuffers.toTypedVector(4, 0), max, (long) writePosition);
    }

    private Value createVector(int i, int i2, int i3, boolean z, boolean z2, Value value) {
        int i4;
        int i5;
        Value value2 = value;
        int i6 = i3;
        long j = (long) i6;
        int max = Math.max(0, widthUInBits(j));
        if (value2 != null) {
            max = Math.max(max, value2.elemWidth(this.bb.writePosition(), 0));
            i4 = 3;
        } else {
            i4 = 1;
        }
        int i7 = 4;
        int i8 = max;
        for (int i9 = i2; i9 < this.stack.size(); i9++) {
            i8 = Math.max(i8, this.stack.get(i9).elemWidth(this.bb.writePosition(), i9 + i4));
            int i10 = i2;
            if (z && i9 == i10) {
                i7 = this.stack.get(i9).type;
                if (!FlexBuffers.isTypedVectorElementType(i7)) {
                    throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                }
            }
        }
        int i11 = i2;
        int align = align(i8);
        if (value2 != null) {
            writeOffset(value2.iValue, align);
            writeInt(1 << value2.minBitWidth, align);
        }
        if (!z2) {
            writeInt(j, align);
        }
        int writePosition = this.bb.writePosition();
        for (int i12 = i11; i12 < this.stack.size(); i12++) {
            writeAny(this.stack.get(i12), align);
        }
        if (!z) {
            while (i11 < this.stack.size()) {
                this.bb.put(this.stack.get(i11).storedPackedType(i8));
                i11++;
            }
        }
        if (value2 != null) {
            i5 = 9;
        } else if (z) {
            if (!z2) {
                i6 = 0;
            }
            i5 = FlexBuffers.toTypedVector(i7, i6);
        } else {
            i5 = 10;
        }
        return new Value(i, i5, i8, (long) writePosition);
    }

    private int putKey(String str) {
        if (str == null) {
            return -1;
        }
        int writePosition = this.bb.writePosition();
        if ((this.flags & 1) != 0) {
            Integer num = this.keyPool.get(str);
            if (num != null) {
                return num.intValue();
            }
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.bb.put(bytes, 0, bytes.length);
            this.bb.put((byte) 0);
            this.keyPool.put(str, Integer.valueOf(writePosition));
            return writePosition;
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        this.bb.put(bytes2, 0, bytes2.length);
        this.bb.put((byte) 0);
        this.keyPool.put(str, Integer.valueOf(writePosition));
        return writePosition;
    }

    public static int widthUInBits(long j) {
        if (j <= ((long) FlexBuffers.Unsigned.byteToUnsignedInt((byte) -1))) {
            return 0;
        }
        if (j <= ((long) FlexBuffers.Unsigned.shortToUnsignedInt(-1))) {
            return 1;
        }
        if (j <= FlexBuffers.Unsigned.intToUnsignedLong(-1)) {
            return 2;
        }
        return 3;
    }

    private void writeAny(Value value, int i) {
        int i2 = value.type;
        if (!(i2 == 0 || i2 == 1 || i2 == 2)) {
            if (i2 == 3) {
                writeDouble(value.dValue, i);
                return;
            } else if (i2 != 26) {
                writeOffset(value.iValue, i);
                return;
            }
        }
        writeInt(value.iValue, i);
    }

    private Value writeBlob(int i, byte[] bArr, int i2, boolean z) {
        int widthUInBits = widthUInBits((long) bArr.length);
        writeInt((long) bArr.length, align(widthUInBits));
        int writePosition = this.bb.writePosition();
        this.bb.put(bArr, 0, bArr.length);
        if (z) {
            this.bb.put((byte) 0);
        }
        return Value.blob(i, writePosition, i2, widthUInBits);
    }

    private void writeDouble(double d, int i) {
        if (i == 4) {
            this.bb.putFloat((float) d);
        } else if (i == 8) {
            this.bb.putDouble(d);
        }
    }

    private void writeInt(long j, int i) {
        if (i == 1) {
            this.bb.put((byte) ((int) j));
        } else if (i == 2) {
            this.bb.putShort((short) ((int) j));
        } else if (i == 4) {
            this.bb.putInt((int) j);
        } else if (i == 8) {
            this.bb.putLong(j);
        }
    }

    private void writeOffset(long j, int i) {
        writeInt((long) ((int) (((long) this.bb.writePosition()) - j)), i);
    }

    private Value writeString(int i, String str) {
        return writeBlob(i, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public int endMap(String str, int i) {
        int putKey = putKey(str);
        ArrayList<Value> arrayList = this.stack;
        Collections.sort(arrayList.subList(i, arrayList.size()), this.keyComparator);
        int i2 = i;
        Value createVector = createVector(putKey, i2, this.stack.size() - i, false, false, createKeyVector(i, this.stack.size() - i));
        while (this.stack.size() > i) {
            ArrayList<Value> arrayList2 = this.stack;
            arrayList2.remove(arrayList2.size() - 1);
        }
        this.stack.add(createVector);
        return (int) createVector.iValue;
    }

    public int endVector(String str, int i, boolean z, boolean z2) {
        Value createVector = createVector(putKey(str), i, this.stack.size() - i, z, z2, (Value) null);
        while (this.stack.size() > i) {
            ArrayList<Value> arrayList = this.stack;
            arrayList.remove(arrayList.size() - 1);
        }
        this.stack.add(createVector);
        return (int) createVector.iValue;
    }

    public ByteBuffer finish() {
        int align = align(this.stack.get(0).elemWidth(this.bb.writePosition(), 0));
        writeAny(this.stack.get(0), align);
        this.bb.put(this.stack.get(0).storedPackedType());
        this.bb.put((byte) align);
        this.finished = true;
        return ByteBuffer.wrap(this.bb.data(), 0, this.bb.writePosition());
    }

    public ReadWriteBuf getBuffer() {
        return this.bb;
    }

    public int putBlob(byte[] bArr) {
        return putBlob((String) null, bArr);
    }

    public void putBoolean(boolean z) {
        putBoolean((String) null, z);
    }

    public void putFloat(float f) {
        putFloat((String) null, f);
    }

    public void putInt(int i) {
        putInt((String) null, i);
    }

    public int putString(String str) {
        return putString((String) null, str);
    }

    public void putUInt(int i) {
        putUInt((String) null, (long) i);
    }

    public void putUInt64(BigInteger bigInteger) {
        putUInt64((String) null, bigInteger.longValue());
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    private void putUInt64(String str, long j) {
        this.stack.add(Value.uInt64(putKey(str), j));
    }

    public int putBlob(String str, byte[] bArr) {
        Value writeBlob = writeBlob(putKey(str), bArr, 25, false);
        this.stack.add(writeBlob);
        return (int) writeBlob.iValue;
    }

    public void putBoolean(String str, boolean z) {
        this.stack.add(Value.bool(putKey(str), z));
    }

    public void putFloat(String str, float f) {
        this.stack.add(Value.float32(putKey(str), f));
    }

    public void putInt(String str, int i) {
        putInt(str, (long) i);
    }

    public int putString(String str, String str2) {
        long j;
        int putKey = putKey(str);
        if ((this.flags & 2) != 0) {
            Integer num = this.stringPool.get(str2);
            if (num == null) {
                Value writeString = writeString(putKey, str2);
                this.stringPool.put(str2, Integer.valueOf((int) writeString.iValue));
                this.stack.add(writeString);
                j = writeString.iValue;
            } else {
                this.stack.add(Value.blob(putKey, num.intValue(), 5, widthUInBits((long) str2.length())));
                return num.intValue();
            }
        } else {
            Value writeString2 = writeString(putKey, str2);
            this.stack.add(writeString2);
            j = writeString2.iValue;
        }
        return (int) j;
    }

    public void putUInt(long j) {
        putUInt((String) null, j);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer byteBuffer, int i) {
        this((ReadWriteBuf) new ArrayReadWriteBuf(byteBuffer.array()), i);
    }

    private void putUInt(String str, long j) {
        Value value;
        int putKey = putKey(str);
        int widthUInBits = widthUInBits(j);
        if (widthUInBits == 0) {
            value = Value.uInt8(putKey, (int) j);
        } else if (widthUInBits == 1) {
            value = Value.uInt16(putKey, (int) j);
        } else if (widthUInBits == 2) {
            value = Value.uInt32(putKey, (int) j);
        } else {
            value = Value.uInt64(putKey, j);
        }
        this.stack.add(value);
    }

    public void putFloat(double d) {
        putFloat((String) null, d);
    }

    public void putInt(String str, long j) {
        int putKey = putKey(str);
        if (-128 <= j && j <= 127) {
            this.stack.add(Value.int8(putKey, (int) j));
        } else if (-32768 <= j && j <= 32767) {
            this.stack.add(Value.int16(putKey, (int) j));
        } else if (O0Xx.f30774xXxxox0I > j || j > 2147483647L) {
            this.stack.add(Value.int64(putKey, j));
        } else {
            this.stack.add(Value.int32(putKey, (int) j));
        }
    }

    public FlexBuffersBuilder(ReadWriteBuf readWriteBuf, int i) {
        this.stack = new ArrayList<>();
        this.keyPool = new HashMap<>();
        this.stringPool = new HashMap<>();
        this.finished = false;
        this.keyComparator = new Comparator<Value>() {
            public int compare(Value value, Value value2) {
                byte b;
                byte b2;
                int i = value.key;
                int i2 = value2.key;
                do {
                    b = FlexBuffersBuilder.this.bb.get(i);
                    b2 = FlexBuffersBuilder.this.bb.get(i2);
                    if (b == 0) {
                        return b - b2;
                    }
                    i++;
                    i2++;
                } while (b == b2);
                return b - b2;
            }
        };
        this.bb = readWriteBuf;
        this.flags = i;
    }

    public void putFloat(String str, double d) {
        this.stack.add(Value.float64(putKey(str), d));
    }

    public void putInt(long j) {
        putInt((String) null, j);
    }

    public FlexBuffersBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }
}
