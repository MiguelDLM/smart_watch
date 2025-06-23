package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.f;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes13.dex */
public class e implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private BufferedOutputStream f26400a;
    private FileDescriptor b;
    private RandomAccessFile c;

    public e(File file, int i) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.c = randomAccessFile;
            this.b = randomAccessFile.getFD();
            if (i > 0) {
                if (i < 8192) {
                    i = 8192;
                } else if (i > 131072) {
                    i = 131072;
                }
                this.f26400a = new BufferedOutputStream(new FileOutputStream(this.c.getFD()), i);
                return;
            }
            this.f26400a = new BufferedOutputStream(new FileOutputStream(this.c.getFD()));
        } catch (IOException e) {
            throw new BaseException(1039, e);
        }
    }

    public void a(byte[] bArr, int i, int i2) throws IOException {
        this.f26400a.write(bArr, i, i2);
    }

    public void b() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f26400a;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void c() throws IOException {
        FileDescriptor fileDescriptor = this.b;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        f.a(this.c, this.f26400a);
    }

    public void a() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f26400a;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.b;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void b(long j) throws IOException {
        this.c.setLength(j);
    }

    public void a(long j) throws IOException {
        this.c.seek(j);
    }
}
