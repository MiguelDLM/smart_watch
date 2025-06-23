package com.google.firebase.crashlytics.buildtools.ndk.internal.elf;

/* loaded from: classes10.dex */
public final class ElfFileHeader {
    private ElfFileIdent _ident;
    public int eEhsize;
    public long eEntry;
    public long eFlags;
    public int eMachine;
    public int ePhentsize;
    public int ePhnum;
    public long ePhoff;
    public int eShentsize;
    public int eShnum;
    public long eShoff;
    public int eShstrndx;
    public int eType;
    public long eVersion;

    public ElfFileHeader(ElfFileIdent elfFileIdent) {
        this._ident = elfFileIdent;
    }

    public ElfFileIdent getElfFileIdent() {
        return this._ident;
    }
}
