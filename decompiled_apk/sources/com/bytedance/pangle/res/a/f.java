package com.bytedance.pangle.res.a;

import java.io.DataInput;

/* loaded from: classes8.dex */
public abstract class f implements DataInput {

    /* renamed from: a, reason: collision with root package name */
    public final i f10608a;

    public f(i iVar) {
        this.f10608a = iVar;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return this.f10608a.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return this.f10608a.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return this.f10608a.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return this.f10608a.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return this.f10608a.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) {
        this.f10608a.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int readInt() {
        return this.f10608a.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        return this.f10608a.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() {
        return this.f10608a.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() {
        return this.f10608a.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return this.f10608a.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return this.f10608a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return this.f10608a.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        return this.f10608a.skipBytes(i);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) {
        this.f10608a.readFully(bArr);
    }
}
