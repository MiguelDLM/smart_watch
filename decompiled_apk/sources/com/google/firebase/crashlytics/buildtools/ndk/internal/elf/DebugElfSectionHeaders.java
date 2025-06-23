package com.google.firebase.crashlytics.buildtools.ndk.internal.elf;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional;

/* loaded from: classes10.dex */
public class DebugElfSectionHeaders {
    public final ElfSectionHeader debugAbbrev;
    public final ElfSectionHeader debugInfo;
    public final ElfSectionHeader debugLine;
    public final ElfSectionHeader debugRanges;
    public final ElfSectionHeader debugStr;

    public DebugElfSectionHeaders(ElfSectionHeader elfSectionHeader, ElfSectionHeader elfSectionHeader2, ElfSectionHeader elfSectionHeader3, ElfSectionHeader elfSectionHeader4, ElfSectionHeader elfSectionHeader5) {
        this.debugInfo = elfSectionHeader;
        this.debugAbbrev = elfSectionHeader2;
        this.debugStr = elfSectionHeader3;
        this.debugRanges = elfSectionHeader5;
        this.debugLine = elfSectionHeader4;
    }

    public static Optional<DebugElfSectionHeaders> from(ElfSectionHeaders elfSectionHeaders) {
        Optional<ElfSectionHeader> headerByName = elfSectionHeaders.getHeaderByName(ElfSectionHeaders.SECTION_DEBUG_INFO);
        Optional<ElfSectionHeader> headerByName2 = elfSectionHeaders.getHeaderByName(ElfSectionHeaders.SECTION_DEBUG_ABBREV);
        Optional<ElfSectionHeader> headerByName3 = elfSectionHeaders.getHeaderByName(ElfSectionHeaders.SECTION_DEBUG_STR);
        Optional<ElfSectionHeader> headerByName4 = elfSectionHeaders.getHeaderByName(ElfSectionHeaders.SECTION_DEBUG_RANGES);
        Optional<ElfSectionHeader> headerByName5 = elfSectionHeaders.getHeaderByName(ElfSectionHeaders.SECTION_DEBUG_LINE);
        if (headerByName.isPresent() && headerByName2.isPresent() && headerByName3.isPresent() && headerByName5.isPresent()) {
            return Optional.of(new DebugElfSectionHeaders(headerByName.get(), headerByName2.get(), headerByName3.get(), headerByName5.get(), headerByName4.orNull()));
        }
        return Optional.absent();
    }
}
