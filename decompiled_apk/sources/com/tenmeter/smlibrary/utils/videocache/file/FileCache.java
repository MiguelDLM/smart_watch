package com.tenmeter.smlibrary.utils.videocache.file;

import com.tenmeter.smlibrary.utils.videocache.Cache;
import com.tenmeter.smlibrary.utils.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes13.dex */
public class FileCache implements Cache {
    private static final String TEMP_POSTFIX = ".download";
    private RandomAccessFile dataFile;
    private final DiskUsage diskUsage;
    public File file;

    public FileCache(File file) throws ProxyCacheException {
        this(file, new UnlimitedDiskUsage());
    }

    private boolean isTempFile(File file) {
        return file.getName().endsWith(TEMP_POSTFIX);
    }

    @Override // com.tenmeter.smlibrary.utils.videocache.Cache
    public synchronized void append(byte[] bArr, int i) throws ProxyCacheException {
        try {
            if (!isCompleted()) {
                this.dataFile.seek(available());
                this.dataFile.write(bArr, 0, i);
            } else {
                throw new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
            }
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.dataFile, Integer.valueOf(bArr.length)), e);
        }
    }

    @Override // com.tenmeter.smlibrary.utils.videocache.Cache
    public synchronized long available() throws ProxyCacheException {
        try {
        } catch (IOException e) {
            throw new ProxyCacheException("Error reading length of file " + this.file, e);
        }
        return (int) this.dataFile.length();
    }

    @Override // com.tenmeter.smlibrary.utils.videocache.Cache
    public synchronized void close() throws ProxyCacheException {
        try {
            this.dataFile.close();
            this.diskUsage.touch(this.file);
        } catch (IOException e) {
            throw new ProxyCacheException("Error closing file " + this.file, e);
        }
    }

    @Override // com.tenmeter.smlibrary.utils.videocache.Cache
    public synchronized void complete() throws ProxyCacheException {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
        if (this.file.renameTo(file)) {
            this.file = file;
            try {
                this.dataFile = new RandomAccessFile(this.file, "r");
                this.diskUsage.touch(this.file);
                return;
            } catch (IOException e) {
                throw new ProxyCacheException("Error opening " + this.file + " as disc cache", e);
            }
        }
        throw new ProxyCacheException("Error renaming file " + this.file + " to " + file + " for completion!");
    }

    public File getFile() {
        return this.file;
    }

    @Override // com.tenmeter.smlibrary.utils.videocache.Cache
    public synchronized boolean isCompleted() {
        return !isTempFile(this.file);
    }

    @Override // com.tenmeter.smlibrary.utils.videocache.Cache
    public synchronized int read(byte[] bArr, long j, int i) throws ProxyCacheException {
        try {
            this.dataFile.seek(j);
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(available()), Integer.valueOf(bArr.length)), e);
        }
        return this.dataFile.read(bArr, 0, i);
    }

    public FileCache(File file, DiskUsage diskUsage) throws ProxyCacheException {
        File file2;
        try {
            if (diskUsage != null) {
                this.diskUsage = diskUsage;
                Files.makeDir(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    file2 = new File(file.getParentFile(), file.getName() + TEMP_POSTFIX);
                }
                this.file = file2;
                this.dataFile = new RandomAccessFile(this.file, exists ? "r" : "rw");
                return;
            }
            throw new NullPointerException();
        } catch (IOException e) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e);
        }
    }
}
