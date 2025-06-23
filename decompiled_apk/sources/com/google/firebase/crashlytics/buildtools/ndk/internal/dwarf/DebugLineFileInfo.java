package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

/* loaded from: classes10.dex */
public class DebugLineFileInfo {
    public final String directory;
    public final int length;
    public final int modificationTime;
    public final String name;

    public DebugLineFileInfo(String str, String str2, int i, int i2) {
        this.name = str;
        this.directory = str2;
        this.modificationTime = i;
        this.length = i2;
    }
}
