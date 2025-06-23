package com.jd.ad.sdk.jad_gp;

import androidx.annotation.NonNull;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes10.dex */
public final class jad_an {
    public static final AtomicReference<byte[]> jad_an = new AtomicReference<>();

    /* renamed from: com.jd.ad.sdk.jad_gp.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0684jad_an extends InputStream {

        @NonNull
        public final ByteBuffer jad_an;
        public int jad_bo = -1;

        public C0684jad_an(@NonNull ByteBuffer byteBuffer) {
            this.jad_an = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.jad_an.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.jad_bo = this.jad_an.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.jad_an.hasRemaining()) {
                return this.jad_an.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            int i = this.jad_bo;
            if (i == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.jad_an.position(i);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (!this.jad_an.hasRemaining()) {
                return -1L;
            }
            long min = Math.min(j, this.jad_an.remaining());
            this.jad_an.position((int) (r0.position() + min));
            return min;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i, int i2) {
            if (!this.jad_an.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, this.jad_an.remaining());
            this.jad_an.get(bArr, i, min);
            return min;
        }
    }

    /* loaded from: classes10.dex */
    public static final class jad_bo {
        public final int jad_an;
        public final int jad_bo;
        public final byte[] jad_cp;

        public jad_bo(@NonNull byte[] bArr, int i, int i2) {
            this.jad_cp = bArr;
            this.jad_an = i;
            this.jad_bo = i2;
        }
    }

    @NonNull
    public static ByteBuffer jad_an(@NonNull File file) {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                fileChannel = randomAccessFile.getChannel();
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                return load;
            } catch (Throwable th) {
                th = th;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    @NonNull
    public static ByteBuffer jad_an(@NonNull InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = jad_an.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read < 0) {
                jad_an.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return jad_an(ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
            }
            byteArrayOutputStream.write(andSet, 0, read);
        }
    }

    public static ByteBuffer jad_an(ByteBuffer byteBuffer) {
        return (ByteBuffer) byteBuffer.position(0);
    }

    public static void jad_an(@NonNull ByteBuffer byteBuffer, @NonNull File file) {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
                fileChannel.write(byteBuffer);
                fileChannel.force(false);
                fileChannel.close();
                randomAccessFile.close();
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }
}
