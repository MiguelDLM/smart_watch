package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Charsets;
import com.google.firebase.crashlytics.buildtools.utils.io.ByteReader;
import java.io.IOException;

/* loaded from: classes10.dex */
public class ExtendedOpcodeDefineFile implements DebugLineOpcode {
    @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DebugLineOpcode
    public boolean process(DebugLineContext debugLineContext, ByteReader byteReader) throws IOException {
        debugLineContext.defineFile(byteReader.readNullTerminatedString(Charsets.UTF_8), byteReader.readULEB128(), byteReader.readULEB128(), byteReader.readULEB128());
        return false;
    }
}
