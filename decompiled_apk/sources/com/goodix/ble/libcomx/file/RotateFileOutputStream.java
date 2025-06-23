package com.goodix.ble.libcomx.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes9.dex */
public class RotateFileOutputStream extends OutputStream {
    private final boolean append;
    public long fileSize;
    private FileOutputStream fos;
    private final File outputFile;
    private final File[] rotateFiles;
    public boolean splitBytes;
    private long writtenSize;

    public RotateFileOutputStream(File file, int i, int i2) throws IOException {
        this(file, i, i2, true);
    }

    private void rotate() throws IOException {
        FileOutputStream fileOutputStream = this.fos;
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        if (this.rotateFiles[0].exists() && !this.rotateFiles[0].delete()) {
            System.out.println("RotateFile: Failed to delete file: " + this.rotateFiles[0].getCanonicalPath());
            return;
        }
        int i = 1;
        while (true) {
            File[] fileArr = this.rotateFiles;
            if (i < fileArr.length) {
                if (fileArr[i].exists()) {
                    File[] fileArr2 = this.rotateFiles;
                    if (!fileArr2[i].renameTo(fileArr2[i - 1]) && !this.rotateFiles[i].delete()) {
                        System.out.println("RotateFile: Failed to delete file: " + this.rotateFiles[i].getCanonicalPath());
                    }
                }
                i++;
            } else {
                this.fos = new FileOutputStream(this.outputFile, this.append);
                this.writtenSize = 0L;
                return;
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.fos.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.fos.flush();
    }

    public void setSplitBytes(boolean z) {
        this.splitBytes = z;
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        try {
            if (this.writtenSize + 1 > this.fileSize) {
                rotate();
                this.fos.write(i);
                this.writtenSize++;
            } else {
                this.fos.write(i);
                this.writtenSize++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void write0(byte[] bArr, int i, int i2) throws IOException {
        if (this.writtenSize >= this.fileSize) {
            rotate();
        }
        if (this.splitBytes) {
            long j = this.writtenSize;
            long j2 = i2 + j;
            long j3 = this.fileSize;
            if (j2 > j3) {
                int i3 = (int) (j3 - j);
                int i4 = i2 - i3;
                this.fos.write(bArr, i, i3);
                this.writtenSize += i3;
                if (i4 > 0) {
                    write0(bArr, i + i3, i4);
                    return;
                }
                return;
            }
        }
        this.fos.write(bArr, i, i2);
        this.writtenSize += i2;
    }

    public RotateFileOutputStream(File file, int i, int i2, boolean z) throws IOException {
        String str;
        this.splitBytes = true;
        this.append = z;
        this.fileSize = i2;
        this.outputFile = file;
        i = i <= 0 ? 4 : i;
        this.rotateFiles = new File[i + 1];
        String path = file.getPath();
        if (i < 10) {
            str = "%s.%d";
        } else if (i < 100) {
            str = "%s.%02d";
        } else {
            str = "%s.%03d";
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.rotateFiles[i3] = new File(String.format(str, path, Integer.valueOf(i - i3)));
        }
        this.rotateFiles[i] = this.outputFile;
        this.fos = new FileOutputStream(this.outputFile, z);
        if (z && file.exists()) {
            long length = file.length();
            this.writtenSize = length;
            if (length >= this.fileSize) {
                rotate();
                return;
            }
            return;
        }
        this.fos = new FileOutputStream(this.outputFile, z);
        this.writtenSize = 0L;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write0(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        write0(bArr, i, i2);
    }
}
