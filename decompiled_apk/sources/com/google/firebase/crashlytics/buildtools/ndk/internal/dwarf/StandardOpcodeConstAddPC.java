package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

import com.google.firebase.crashlytics.buildtools.utils.io.ByteReader;
import java.io.IOException;

/* loaded from: classes10.dex */
public class StandardOpcodeConstAddPC implements DebugLineOpcode {
    private static final int CONST_OPCODE = 255;

    @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DebugLineOpcode
    public boolean process(DebugLineContext debugLineContext, ByteReader byteReader) throws IOException {
        DebugLineHeader debugLineHeader = debugLineContext.header;
        debugLineContext.reg.address += ((255 - debugLineHeader.opcodeBase) / debugLineHeader.lineRange) * debugLineHeader.minInstructionLength;
        return false;
    }
}
