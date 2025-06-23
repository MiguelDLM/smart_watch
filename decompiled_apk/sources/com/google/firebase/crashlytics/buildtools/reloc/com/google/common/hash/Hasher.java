package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Beta
@CanIgnoreReturnValue
/* loaded from: classes10.dex */
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    Hasher putBoolean(boolean z);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putBoolean(boolean z);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    Hasher putByte(byte b);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putByte(byte b);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    Hasher putBytes(ByteBuffer byteBuffer);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] bArr);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] bArr, int i, int i2);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(ByteBuffer byteBuffer);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr, int i, int i2);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    Hasher putChar(char c);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putChar(char c);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    Hasher putDouble(double d);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putDouble(double d);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    Hasher putFloat(float f);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putFloat(float f);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    Hasher putInt(int i);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putInt(int i);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    Hasher putLong(long j);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putLong(long j);

    <T> Hasher putObject(T t, Funnel<? super T> funnel);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    Hasher putShort(short s);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putShort(short s);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    Hasher putString(CharSequence charSequence, Charset charset);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putString(CharSequence charSequence, Charset charset);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    Hasher putUnencodedChars(CharSequence charSequence);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
