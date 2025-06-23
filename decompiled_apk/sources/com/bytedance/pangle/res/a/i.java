package com.bytedance.pangle.res.a;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;

/* loaded from: classes8.dex */
public final class i extends FilterInputStream implements DataInput {
    public i(e eVar) {
        super(eVar);
    }

    private static int a(byte b, byte b2, byte b3, byte b4) {
        return (b << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255);
    }

    private byte b() {
        int read = ((FilterInputStream) this).in.read();
        if (-1 != read) {
            return (byte) read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        if (readUnsignedByte() != 0) {
            return true;
        }
        return false;
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) {
        d.a(this, bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final int readInt() {
        byte b = b();
        byte b2 = b();
        return a(b(), b(), b2, b);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public final long readLong() {
        byte b = b();
        byte b2 = b();
        byte b3 = b();
        byte b4 = b();
        byte b5 = b();
        return ((b() & 255) << 56) | ((b() & 255) << 48) | ((b() & 255) << 40) | ((b5 & 255) << 32) | ((b4 & 255) << 24) | ((b3 & 255) << 16) | ((b2 & 255) << 8) | (b & 255);
    }

    @Override // java.io.DataInput
    public final short readShort() {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        return new DataInputStream(((FilterInputStream) this).in).readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        int read = ((FilterInputStream) this).in.read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        return a((byte) 0, (byte) 0, b(), b());
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        return (int) ((FilterInputStream) this).in.skip(i);
    }

    public final e a() {
        return (e) ((FilterInputStream) this).in;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        d.a(this, bArr, 0, bArr.length);
    }
}
