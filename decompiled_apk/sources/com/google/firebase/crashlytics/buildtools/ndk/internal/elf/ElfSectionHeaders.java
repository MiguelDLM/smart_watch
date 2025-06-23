package com.google.firebase.crashlytics.buildtools.ndk.internal.elf;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterables;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class ElfSectionHeaders {
    public static final String SECTION_DEBUG_ABBREV = ".debug_abbrev";
    public static final String SECTION_DEBUG_INFO = ".debug_info";
    public static final String SECTION_DEBUG_LINE = ".debug_line";
    public static final String SECTION_DEBUG_RANGES = ".debug_ranges";
    public static final String SECTION_DEBUG_STR = ".debug_str";
    private final Map<String, ElfSectionHeader> _nameIndex;
    private final List<ElfSectionHeader> _sectionHeaders;

    public ElfSectionHeaders(List<ElfSectionHeader> list) {
        this._sectionHeaders = list;
        this._nameIndex = indexByName(list);
    }

    private static Map<String, ElfSectionHeader> indexByName(List<ElfSectionHeader> list) {
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        for (ElfSectionHeader elfSectionHeader : list) {
            newLinkedHashMap.put(elfSectionHeader.shNameString, elfSectionHeader);
        }
        return newLinkedHashMap;
    }

    public Optional<ElfSectionHeader> findHeader(Predicate<ElfSectionHeader> predicate) {
        return Iterables.tryFind(this._sectionHeaders, predicate);
    }

    public Optional<ElfSectionHeader> getHeaderByIndex(int i) {
        if (i >= 0 && i < this._sectionHeaders.size()) {
            return Optional.of(this._sectionHeaders.get(i));
        }
        return Optional.absent();
    }

    public Optional<ElfSectionHeader> getHeaderByName(String str) {
        return Optional.fromNullable(this._nameIndex.get(str));
    }

    public List<ElfSectionHeader> getList() {
        return this._sectionHeaders;
    }

    public boolean hasDebugInfo() {
        return getHeaderByName(SECTION_DEBUG_INFO).isPresent();
    }
}
