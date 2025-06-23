package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

/* loaded from: classes10.dex */
public class DebugLineEntry {
    public static final String formatString = "Address: 0x%s, File: %s, Line: %s";
    public final long address;
    public final String file;
    public final long lineNumber;

    public DebugLineEntry(long j, String str, long j2) {
        this.address = j;
        this.file = str;
        this.lineNumber = j2;
    }

    public String toString() {
        return String.format(formatString, this.file, Long.valueOf(this.lineNumber), Long.toHexString(this.address));
    }
}
