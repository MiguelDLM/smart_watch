package com.bytedance.pangle.util.b;

import com.bytedance.pangle.util.b.b.d;
import com.bytedance.pangle.util.g;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    final d f10627a;
    final com.bytedance.pangle.util.b.a.b b = new com.bytedance.pangle.util.b.a.b();

    public a(d dVar) {
        this.f10627a = dVar;
    }

    public static void a(File file) {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    public static void a(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j, long j2, String str) {
        g.a(randomAccessFile, randomAccessFile2, j, j + j2, str);
    }
}
