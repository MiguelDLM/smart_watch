package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

/* loaded from: classes10.dex */
public class DebugLineRegisters {
    private boolean _defaultIsStatement;
    public long address;
    public long column;
    public long discriminator;
    public int file;
    public boolean isBasicBlock;
    public boolean isEndSequence;
    public boolean isEpilogueBegin;
    public boolean isPrologueEnd;
    public boolean isStatement;
    public long isa;
    public long line;
    public int opIndex;

    public DebugLineRegisters(boolean z) {
        this._defaultIsStatement = z;
        reset();
    }

    public void reset() {
        this.address = 0L;
        this.opIndex = 0;
        this.file = 1;
        this.line = 1L;
        this.column = 0L;
        this.isStatement = this._defaultIsStatement;
        this.isBasicBlock = false;
        this.isEndSequence = false;
        this.isPrologueEnd = false;
        this.isEpilogueBegin = false;
        this.isa = 0L;
        this.discriminator = 0L;
    }
}
