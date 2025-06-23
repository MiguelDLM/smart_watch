package com.ss.android.socialbase.appdownloader.f.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes13.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private InputStream f26185a;
    private boolean b;
    private int c;

    public d() {
    }

    public final void a(InputStream inputStream, boolean z) {
        this.f26185a = inputStream;
        this.b = z;
        this.c = 0;
    }

    public final int b() throws IOException {
        return a(4);
    }

    public final void c(int i) throws IOException {
        if (i > 0) {
            long j = i;
            long skip = this.f26185a.skip(j);
            this.c = (int) (this.c + skip);
            if (skip != j) {
                throw new EOFException();
            }
        }
    }

    public d(InputStream inputStream, boolean z) {
        a(inputStream, z);
    }

    public final int[] b(int i) throws IOException {
        int[] iArr = new int[i];
        a(iArr, 0, i);
        return iArr;
    }

    public final void a() {
        InputStream inputStream = this.f26185a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            a(null, false);
        }
    }

    public final void c() throws IOException {
        c(4);
    }

    public final int a(int i) throws IOException {
        if (i >= 0 && i <= 4) {
            int i2 = 0;
            if (this.b) {
                for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                    int read = this.f26185a.read();
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.c++;
                    i2 |= read << i3;
                }
                return i2;
            }
            int i4 = i * 8;
            int i5 = 0;
            while (i2 != i4) {
                int read2 = this.f26185a.read();
                if (read2 == -1) {
                    throw new EOFException();
                }
                this.c++;
                i5 |= read2 << i2;
                i2 += 8;
            }
            return i5;
        }
        throw new IllegalArgumentException();
    }

    public final void a(int[] iArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            iArr[i] = b();
            i2--;
            i++;
        }
    }
}
