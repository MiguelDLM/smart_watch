package com.google.firebase.crashlytics.buildtools.ndk.internal.elf;

/* loaded from: classes10.dex */
public class ElfSymbol {
    public static final int STB_GLOBAL = 1;
    public static final int STB_LOCAL = 0;
    public static final int STB_WEAK = 2;
    public static final int STT_FILE = 4;
    public static final int STT_FUNC = 2;
    public static final int STT_NOTYPE = 0;
    public static final int STT_OBJECT = 1;
    public static final int STT_SECTION = 3;
    public byte stInfo;
    public int stName;
    public String stNameString;
    public byte stOther;
    public short stShndx;
    public long stSize;
    public long stValue;
}
