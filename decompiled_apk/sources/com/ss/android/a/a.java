package com.ss.android.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes12.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private final RandomAccessFile f25919a;

    public a(File file) throws FileNotFoundException {
        this.f25919a = new RandomAccessFile(file, "r");
    }

    @Override // com.ss.android.a.b
    public long a() throws IOException {
        return this.f25919a.length();
    }

    @Override // com.ss.android.a.b
    public void b() throws IOException {
        this.f25919a.close();
    }

    @Override // com.ss.android.a.b
    public int a(byte[] bArr, int i, int i2) throws IOException {
        return this.f25919a.read(bArr, i, i2);
    }

    @Override // com.ss.android.a.b
    public void a(long j, long j2) throws IOException {
        this.f25919a.seek(j);
    }
}
