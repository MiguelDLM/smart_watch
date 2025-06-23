package com.google.firebase.crashlytics.buildtools.ndk.internal.elf;

/* loaded from: classes10.dex */
public class ElfSectionHeader {
    public static final int SHT_DYNAMIC = 6;
    public static final int SHT_DYNSYM = 11;
    public static final int SHT_HASH = 5;
    public static final int SHT_NOBITS = 8;
    public static final int SHT_NOTE = 7;
    public static final int SHT_NULL = 0;
    public static final int SHT_PROGBITS = 1;
    public static final int SHT_REL = 9;
    public static final int SHT_RELA = 4;
    public static final int SHT_SHLIB = 10;
    public static final int SHT_STRTAB = 3;
    public static final int SHT_SYMTAB = 2;
    public long shAddr;
    public long shAddrAlign;
    public long shEntSize;
    public long shFlags;
    public int shInfo;
    public int shLink;
    public int shName;
    public String shNameString;
    public long shOffset;
    public long shSize;
    public int shType;
}
