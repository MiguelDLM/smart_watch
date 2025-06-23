package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

/* loaded from: classes10.dex */
public class DebugLineHeader {
    public final boolean defaultIsStatement;
    public final long headerLength;
    public final byte lineBase;
    public final byte lineRange;
    public final byte maximumOperationsPerInstruction;
    public final byte minInstructionLength;
    public final byte opcodeBase;
    public final byte[] standardOpcodeLengths;
    public final long unitLength;
    public final int version;

    public DebugLineHeader(long j, int i, long j2, byte b, byte b2, boolean z, byte b3, byte b4, byte b5, byte[] bArr) {
        this.unitLength = j;
        this.version = i;
        this.headerLength = j2;
        this.minInstructionLength = b;
        this.maximumOperationsPerInstruction = b2;
        this.defaultIsStatement = z;
        this.lineBase = b3;
        this.lineRange = b4;
        this.opcodeBase = b5;
        this.standardOpcodeLengths = bArr;
    }
}
