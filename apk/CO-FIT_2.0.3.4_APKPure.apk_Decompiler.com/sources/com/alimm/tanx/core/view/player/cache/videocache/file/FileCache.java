package com.alimm.tanx.core.view.player.cache.videocache.file;

import com.alimm.tanx.core.view.player.cache.videocache.Cache;
import com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileCache implements Cache {
    private static final String TEMP_POSTFIX = ".download";
    private RandomAccessFile dataFile;
    private final DiskUsage diskUsage;
    public File file;

    public FileCache(File file2) throws ProxyCacheException {
        this(file2, new UnlimitedDiskUsage());
    }

    private boolean isTempFile(File file2) {
        return file2.getName().endsWith(TEMP_POSTFIX);
    }

    public synchronized void append(byte[] bArr, int i) throws ProxyCacheException {
        try {
            if (!isCompleted()) {
                this.dataFile.seek(available());
                this.dataFile.write(bArr, 0, i);
            } else {
                throw new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
            }
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[]{Integer.valueOf(i), this.dataFile, Integer.valueOf(bArr.length)}), e);
        }
    }

    public synchronized long available() throws ProxyCacheException {
        try {
        } catch (IOException e) {
            throw new ProxyCacheException("Error reading length of file " + this.file, e);
        }
        return (long) ((int) this.dataFile.length());
    }

    public synchronized void close() throws ProxyCacheException {
        try {
            this.dataFile.close();
            this.diskUsage.touch(this.file);
        } catch (IOException e) {
            throw new ProxyCacheException("Error closing file " + this.file, e);
        }
    }

    public synchronized void complete() throws ProxyCacheException {
        if (!isCompleted()) {
            close();
            File file2 = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
            if (this.file.renameTo(file2)) {
                this.file = file2;
                try {
                    this.dataFile = new RandomAccessFile(this.file, "r");
                    this.diskUsage.touch(this.file);
                } catch (IOException e) {
                    throw new ProxyCacheException("Error opening " + this.file + " as disc cache", e);
                }
            } else {
                throw new ProxyCacheException("Error renaming file " + this.file + " to " + file2 + " for completion!");
            }
        }
    }

    public File getFile() {
        return this.file;
    }

    public synchronized boolean isCompleted() {
        return !isTempFile(this.file);
    }

    public synchronized int read(byte[] bArr, long j, int i) throws ProxyCacheException {
        try {
            this.dataFile.seek(j);
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(available()), Integer.valueOf(bArr.length)}), e);
        }
        return this.dataFile.read(bArr, 0, i);
    }

    public FileCache(File file2, DiskUsage diskUsage2) throws ProxyCacheException {
        File file3;
        if (diskUsage2 != null) {
            try {
                this.diskUsage = diskUsage2;
                Files.makeDir(file2.getParentFile());
                boolean exists = file2.exists();
                if (exists) {
                    file3 = file2;
                } else {
                    File parentFile = file2.getParentFile();
                    file3 = new File(parentFile, file2.getName() + TEMP_POSTFIX);
                }
                this.file = file3;
                this.dataFile = new RandomAccessFile(this.file, exists ? "r" : "rw");
            } catch (IOException e) {
                throw new ProxyCacheException("Error using file " + file2 + " as disc cache", e);
            }
        } else {
            throw new NullPointerException();
        }
    }
}
