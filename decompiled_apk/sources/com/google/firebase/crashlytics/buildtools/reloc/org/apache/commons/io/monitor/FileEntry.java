package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.monitor;

import java.io.File;
import java.io.Serializable;

/* loaded from: classes10.dex */
public class FileEntry implements Serializable {
    static final FileEntry[] EMPTY_ENTRIES = new FileEntry[0];
    private static final long serialVersionUID = -2505664948818681153L;
    private FileEntry[] children;
    private boolean directory;
    private boolean exists;
    private final File file;
    private long lastModified;
    private long length;
    private String name;
    private final FileEntry parent;

    public FileEntry(File file) {
        this(null, file);
    }

    public FileEntry[] getChildren() {
        FileEntry[] fileEntryArr = this.children;
        if (fileEntryArr == null) {
            return EMPTY_ENTRIES;
        }
        return fileEntryArr;
    }

    public File getFile() {
        return this.file;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public long getLength() {
        return this.length;
    }

    public int getLevel() {
        FileEntry fileEntry = this.parent;
        if (fileEntry == null) {
            return 0;
        }
        return fileEntry.getLevel() + 1;
    }

    public String getName() {
        return this.name;
    }

    public FileEntry getParent() {
        return this.parent;
    }

    public boolean isDirectory() {
        return this.directory;
    }

    public boolean isExists() {
        return this.exists;
    }

    public FileEntry newChildInstance(File file) {
        return new FileEntry(this, file);
    }

    public boolean refresh(File file) {
        boolean z;
        long j;
        boolean z2 = this.exists;
        long j2 = this.lastModified;
        boolean z3 = this.directory;
        long j3 = this.length;
        this.name = file.getName();
        boolean exists = file.exists();
        this.exists = exists;
        if (exists && file.isDirectory()) {
            z = true;
        } else {
            z = false;
        }
        this.directory = z;
        long j4 = 0;
        if (this.exists) {
            j = file.lastModified();
        } else {
            j = 0;
        }
        this.lastModified = j;
        if (this.exists && !this.directory) {
            j4 = file.length();
        }
        this.length = j4;
        if (this.exists == z2 && this.lastModified == j2 && this.directory == z3 && j4 == j3) {
            return false;
        }
        return true;
    }

    public void setChildren(FileEntry[] fileEntryArr) {
        this.children = fileEntryArr;
    }

    public void setDirectory(boolean z) {
        this.directory = z;
    }

    public void setExists(boolean z) {
        this.exists = z;
    }

    public void setLastModified(long j) {
        this.lastModified = j;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public FileEntry(FileEntry fileEntry, File file) {
        if (file != null) {
            this.file = file;
            this.parent = fileEntry;
            this.name = file.getName();
            return;
        }
        throw new IllegalArgumentException("File is missing");
    }
}
