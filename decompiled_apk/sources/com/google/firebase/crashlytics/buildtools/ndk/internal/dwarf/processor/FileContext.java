package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor;

import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.DebugElfSectionHeaders;

/* loaded from: classes10.dex */
public class FileContext {
    public final DebugElfSectionHeaders debugSectionHeaders;
    public final ReferenceBytesConverter referenceBytesConverter;

    public FileContext(DebugElfSectionHeaders debugElfSectionHeaders, ReferenceBytesConverter referenceBytesConverter) {
        this.debugSectionHeaders = debugElfSectionHeaders;
        this.referenceBytesConverter = referenceBytesConverter;
    }
}
