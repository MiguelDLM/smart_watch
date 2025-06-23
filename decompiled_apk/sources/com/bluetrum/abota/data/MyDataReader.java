package com.bluetrum.abota.data;

import androidx.annotation.NonNull;
import com.bluetrum.abota.time.Timber;
import com.bluetrum.fota.manager.DataReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;

/* loaded from: classes8.dex */
public class MyDataReader implements DataReader {
    private final String filePath;
    private RandomAccessFile randomAccessFile;

    public MyDataReader(@NonNull String str) {
        this.filePath = str;
    }

    @Override // com.bluetrum.fota.manager.DataReader
    public void close() throws IOException {
        Timber.d("close", new Object[0]);
        RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile != null) {
            randomAccessFile.close();
            this.randomAccessFile = null;
        }
    }

    @Override // com.bluetrum.fota.manager.DataReader
    @NonNull
    public byte[] getHash() throws IOException {
        Timber.d("getHash", new Object[0]);
        long filePointer = this.randomAccessFile.getFilePointer();
        byte[] bArr = new byte[1024];
        this.randomAccessFile.seek(0L);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            int read = this.randomAccessFile.read(bArr);
            while (read > 0) {
                messageDigest.update(bArr, 0, read);
                read = this.randomAccessFile.read(bArr);
            }
            this.randomAccessFile.seek(filePointer);
            byte[] bArr2 = new byte[4];
            System.arraycopy(messageDigest.digest(), 0, bArr2, 0, 4);
            return bArr2;
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[]{-1, -1, -1, -1};
        }
    }

    @Override // com.bluetrum.fota.manager.DataReader
    public int getSize() throws IOException {
        Timber.d("getSize", new Object[0]);
        Timber.d("fileLength: %d", Long.valueOf((int) this.randomAccessFile.length()));
        return (int) this.randomAccessFile.length();
    }

    @Override // com.bluetrum.fota.manager.DataReader
    public void open() throws IOException {
        Timber.d("open", new Object[0]);
        this.randomAccessFile = new RandomAccessFile(this.filePath, "r");
    }

    @Override // com.bluetrum.fota.manager.DataReader
    public int read(int i, byte[] bArr, int i2, int i3) throws IOException {
        Timber.d("read: srcPos=%d, dstPos=%d, length=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        long filePointer = this.randomAccessFile.getFilePointer();
        this.randomAccessFile.seek(i);
        int read = this.randomAccessFile.read(bArr, i2, i3);
        this.randomAccessFile.seek(filePointer);
        return read;
    }
}
