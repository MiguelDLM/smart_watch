package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@CanIgnoreReturnValue
/* loaded from: classes10.dex */
abstract class AbstractByteHasher extends AbstractHasher {
    private final ByteBuffer scratch = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    public abstract void update(byte b);

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.AbstractHasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.Hasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    public Hasher putByte(byte b) {
        update(b);
        return this;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.AbstractHasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.Hasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    public Hasher putChar(char c) {
        this.scratch.putChar(c);
        return update(2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.AbstractHasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.Hasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    public Hasher putInt(int i) {
        this.scratch.putInt(i);
        return update(4);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.AbstractHasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.Hasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    public Hasher putLong(long j) {
        this.scratch.putLong(j);
        return update(8);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.AbstractHasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.Hasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    public Hasher putShort(short s) {
        this.scratch.putShort(s);
        return update(2);
    }

    public void update(byte[] bArr, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            update(bArr[i3]);
        }
    }

    public void update(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            update(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
        } else {
            for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
                update(byteBuffer.get());
            }
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.AbstractHasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.Hasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    public Hasher putBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        update(bArr);
        return this;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.AbstractHasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.Hasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    public Hasher putBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        update(bArr, i, i2);
        return this;
    }

    private Hasher update(int i) {
        try {
            update(this.scratch.array(), 0, i);
            return this;
        } finally {
            this.scratch.clear();
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.AbstractHasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.Hasher, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    public Hasher putBytes(ByteBuffer byteBuffer) {
        update(byteBuffer);
        return this;
    }
}
