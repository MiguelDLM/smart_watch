package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

import com.google.firebase.crashlytics.buildtools.utils.io.ByteReader;
import java.io.IOException;

/* loaded from: classes10.dex */
public class SpecialOpcode implements DebugLineOpcode {
    private final int _opcode;

    public SpecialOpcode(int i) {
        this._opcode = i;
    }

    @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DebugLineOpcode
    public boolean process(DebugLineContext debugLineContext, ByteReader byteReader) throws IOException {
        int i = this._opcode;
        DebugLineHeader debugLineHeader = debugLineContext.header;
        int i2 = i - debugLineHeader.opcodeBase;
        byte b = debugLineHeader.lineRange;
        byte b2 = debugLineHeader.minInstructionLength;
        DebugLineRegisters debugLineRegisters = debugLineContext.reg;
        int i3 = debugLineRegisters.opIndex;
        byte b3 = debugLineHeader.maximumOperationsPerInstruction;
        int i4 = debugLineHeader.lineBase + (i2 % b);
        debugLineRegisters.opIndex = (i3 + (i2 / b)) % b3;
        debugLineRegisters.address += b2 * ((i3 + r2) / b3);
        debugLineRegisters.line += i4;
        debugLineRegisters.isBasicBlock = false;
        return true;
    }
}
