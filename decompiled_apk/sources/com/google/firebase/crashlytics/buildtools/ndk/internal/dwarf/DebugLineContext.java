package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class DebugLineContext {
    private final List<String> _directories = new ArrayList<String>() { // from class: com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DebugLineContext.1
        {
            add("");
        }
    };
    private final List<DebugLineFileInfo> _files = new ArrayList<DebugLineFileInfo>() { // from class: com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DebugLineContext.2
        {
            add(new DebugLineFileInfo("", "", 0, 0));
        }
    };
    public final DebugLineHeader header;
    public final int offsetSize;
    public final DebugLineRegisters reg;

    public DebugLineContext(DebugLineHeader debugLineHeader, DebugLineRegisters debugLineRegisters, int i) {
        this.header = debugLineHeader;
        this.reg = debugLineRegisters;
        this.offsetSize = i;
    }

    public void defineDirectory(String str) {
        this._directories.add(str);
    }

    public void defineFile(String str, int i, int i2, int i3) {
        this._files.add(new DebugLineFileInfo(str, this._directories.get(i), i2, i3));
    }

    public DebugLineFileInfo getFileInfo(int i) {
        return this._files.get(i);
    }
}
