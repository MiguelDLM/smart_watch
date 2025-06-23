package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import XXO0.oIX0oI;
import java.io.File;
import java.io.Serializable;

/* loaded from: classes10.dex */
public class SizeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 7388077430788600069L;
    private final boolean acceptLarger;
    private final long size;

    public SizeFileFilter(long j) {
        this(j, true);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter.AbstractFileFilter, com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean z;
        if (file.length() < this.size) {
            z = true;
        } else {
            z = false;
        }
        if (this.acceptLarger) {
            if (z) {
                return false;
            }
            return true;
        }
        return z;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        String str;
        if (this.acceptLarger) {
            str = ">=";
        } else {
            str = "<";
        }
        return super.toString() + oIX0oI.I0Io.f4096II0xO0 + str + this.size + oIX0oI.I0Io.f4095I0Io;
    }

    public SizeFileFilter(long j, boolean z) {
        if (j >= 0) {
            this.size = j;
            this.acceptLarger = z;
            return;
        }
        throw new IllegalArgumentException("The size must be non-negative");
    }
}
