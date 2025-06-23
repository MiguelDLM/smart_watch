package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor;

import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.NamedRange;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class CompilationUnitContext {
    public final Map<Long, String> abstractOriginMap;
    private final Long debugLineOffset;
    public final FileContext fileContext;
    public final Header header;
    private final Long lowPc;
    public final List<NamedRange> namedRanges;
    public final Map<Long, String> specificationMap;

    /* loaded from: classes10.dex */
    public static class EntryData {
        final Long lowPc;
        final Long stmtList;

        public EntryData(Long l, Long l2) {
            this.lowPc = l;
            this.stmtList = l2;
        }
    }

    /* loaded from: classes10.dex */
    public static class Header {
        public final long abbrevOffset;
        public final int addressSize;
        public final long length;
        public final long offset;
        public final int referenceSize;
        public final int version;

        public Header(long j, long j2, int i, long j3, int i2, int i3) {
            this.offset = j;
            this.length = j2;
            this.version = i;
            this.abbrevOffset = j3;
            this.addressSize = i2;
            this.referenceSize = i3;
        }
    }

    public CompilationUnitContext(FileContext fileContext, Header header, Map<Long, String> map, Map<Long, String> map2) {
        this(fileContext, header, map, map2, null, null);
    }

    public Optional<Long> getDebugLineOffset() {
        return Optional.of(this.debugLineOffset);
    }

    public long getLowPc() {
        return ((Long) Optional.of(this.lowPc).or((Optional) 0L)).longValue();
    }

    public CompilationUnitContext(FileContext fileContext, Header header, Map<Long, String> map, Map<Long, String> map2, EntryData entryData) {
        this(fileContext, header, map, map2, entryData.lowPc, entryData.stmtList);
    }

    private CompilationUnitContext(FileContext fileContext, Header header, Map<Long, String> map, Map<Long, String> map2, Long l, Long l2) {
        this.namedRanges = Lists.newLinkedList();
        this.fileContext = fileContext;
        this.header = header;
        this.specificationMap = map;
        this.abstractOriginMap = map2;
        this.lowPc = l;
        this.debugLineOffset = l2;
    }
}
