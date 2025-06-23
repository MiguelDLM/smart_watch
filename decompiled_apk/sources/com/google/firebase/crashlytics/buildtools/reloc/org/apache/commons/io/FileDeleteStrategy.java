package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io;

import java.io.File;
import java.io.IOException;

/* loaded from: classes10.dex */
public class FileDeleteStrategy {
    private final String name;
    public static final FileDeleteStrategy NORMAL = new FileDeleteStrategy("Normal");
    public static final FileDeleteStrategy FORCE = new ForceFileDeleteStrategy();

    /* loaded from: classes10.dex */
    public static class ForceFileDeleteStrategy extends FileDeleteStrategy {
        public ForceFileDeleteStrategy() {
            super("Force");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.FileDeleteStrategy
        public boolean doDelete(File file) throws IOException {
            FileUtils.forceDelete(file);
            return true;
        }
    }

    public FileDeleteStrategy(String str) {
        this.name = str;
    }

    public void delete(File file) throws IOException {
        if (file.exists() && !doDelete(file)) {
            throw new IOException("Deletion failed: " + file);
        }
    }

    public boolean deleteQuietly(File file) {
        if (file != null && file.exists()) {
            try {
                return doDelete(file);
            } catch (IOException unused) {
                return false;
            }
        }
        return true;
    }

    public boolean doDelete(File file) throws IOException {
        return file.delete();
    }

    public String toString() {
        return "FileDeleteStrategy[" + this.name + "]";
    }
}
