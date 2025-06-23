package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

import com.google.firebase.crashlytics.buildtools.utils.io.ByteReader;
import java.io.IOException;

/* loaded from: classes10.dex */
public class ExtendedOpcodeEndSequence implements DebugLineOpcode {
    @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DebugLineOpcode
    public boolean process(DebugLineContext debugLineContext, ByteReader byteReader) throws IOException {
        debugLineContext.reg.isEndSequence = true;
        return false;
    }
}
