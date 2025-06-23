package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import XXO0.oIX0oI;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

/* loaded from: classes10.dex */
public class AgeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -2132740084016138541L;
    private final boolean acceptOlder;
    private final long cutoff;

    public AgeFileFilter(long j) {
        this(j, true);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter.AbstractFileFilter, com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean isFileNewer = FileUtils.isFileNewer(file, this.cutoff);
        if (this.acceptOlder) {
            if (!isFileNewer) {
                return true;
            }
            return false;
        }
        return isFileNewer;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        String str;
        if (this.acceptOlder) {
            str = "<=";
        } else {
            str = ">";
        }
        return super.toString() + oIX0oI.I0Io.f4096II0xO0 + str + this.cutoff + oIX0oI.I0Io.f4095I0Io;
    }

    public AgeFileFilter(long j, boolean z) {
        this.acceptOlder = z;
        this.cutoff = j;
    }

    public AgeFileFilter(Date date) {
        this(date, true);
    }

    public AgeFileFilter(Date date, boolean z) {
        this(date.getTime(), z);
    }

    public AgeFileFilter(File file) {
        this(file, true);
    }

    public AgeFileFilter(File file, boolean z) {
        this(file.lastModified(), z);
    }
}
