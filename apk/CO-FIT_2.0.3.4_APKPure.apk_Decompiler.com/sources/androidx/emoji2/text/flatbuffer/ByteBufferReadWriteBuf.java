package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferReadWriteBuf implements ReadWriteBuf {
    private final ByteBuffer buffer;

    public ByteBufferReadWriteBuf(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public byte[] data() {
        return this.buffer.array();
    }

    public byte get(int i) {
        return this.buffer.get(i);
    }

    public boolean getBoolean(int i) {
        if (get(i) != 0) {
            return true;
        }
        return false;
    }

    public double getDouble(int i) {
        return this.buffer.getDouble(i);
    }

    public float getFloat(int i) {
        return this.buffer.getFloat(i);
    }

    public int getInt(int i) {
        return this.buffer.getInt(i);
    }

    public long getLong(int i) {
        return this.buffer.getLong(i);
    }

    public short getShort(int i) {
        return this.buffer.getShort(i);
    }

    public String getString(int i, int i2) {
        return Utf8Safe.decodeUtf8Buffer(this.buffer, i, i2);
    }

    public int limit() {
        return this.buffer.limit();
    }

    public void put(byte[] bArr, int i, int i2) {
        this.buffer.put(bArr, i, i2);
    }

    public void putBoolean(boolean z) {
        this.buffer.put(z ? (byte) 1 : 0);
    }

    public void putDouble(double d) {
        this.buffer.putDouble(d);
    }

    public void putFloat(float f) {
        this.buffer.putFloat(f);
    }

    public void putInt(int i) {
        this.buffer.putInt(i);
    }

    public void putLong(long j) {
        this.buffer.putLong(j);
    }

    public void putShort(short s) {
        this.buffer.putShort(s);
    }

    public boolean requestCapacity(int i) {
        if (i <= this.buffer.limit()) {
            return true;
        }
        return false;
    }

    public void set(int i, byte b) {
        requestCapacity(i + 1);
        this.buffer.put(i, b);
    }

    public void setBoolean(int i, boolean z) {
        set(i, z ? (byte) 1 : 0);
    }

    public void setDouble(int i, double d) {
        requestCapacity(i + 8);
        this.buffer.putDouble(i, d);
    }

    public void setFloat(int i, float f) {
        requestCapacity(i + 4);
        this.buffer.putFloat(i, f);
    }

    public void setInt(int i, int i2) {
        requestCapacity(i + 4);
        this.buffer.putInt(i, i2);
    }

    public void setLong(int i, long j) {
        requestCapacity(i + 8);
        this.buffer.putLong(i, j);
    }

    public void setShort(int i, short s) {
        requestCapacity(i + 2);
        this.buffer.putShort(i, s);
    }

    public int writePosition() {
        return this.buffer.position();
    }

    public void put(byte b) {
        this.buffer.put(b);
    }

    public void set(int i, byte[] bArr, int i2, int i3) {
        requestCapacity((i3 - i2) + i);
        int position = this.buffer.position();
        this.buffer.position(i);
        this.buffer.put(bArr, i2, i3);
        this.buffer.position(position);
    }
}
