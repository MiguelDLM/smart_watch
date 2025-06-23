package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

import com.google.firebase.crashlytics.buildtools.utils.io.ByteReader;
import java.io.IOException;

/* loaded from: classes10.dex */
public class StandardOpcodeCopy implements DebugLineOpcode {
    @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DebugLineOpcode
    public boolean process(DebugLineContext debugLineContext, ByteReader byteReader) throws IOException {
        DebugLineRegisters debugLineRegisters = debugLineContext.reg;
        debugLineRegisters.discriminator = 0L;
        debugLineRegisters.isBasicBlock = false;
        debugLineRegisters.isPrologueEnd = false;
        debugLineRegisters.isEpilogueBegin = false;
        return true;
    }
}
