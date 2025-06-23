package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

import com.google.firebase.crashlytics.buildtools.Buildtools;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DebugAbbrevEntry;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.CompilationUnitContext;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.CompileUnitAttributeProcessor;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.DefaultAttributesReader;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.DefaultNamedRangesResolver;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.FileContext;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.MissingSectionNamedRangesResolver;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.NamedRangesAttributeProcessor;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.NamedRangesResolver;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.ReferenceBytesConverter;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.SkipAttributesReader;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.DebugElfSectionHeaders;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfSectionHeader;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.II0xO0;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Collections2;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Lists;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Sets;
import com.google.firebase.crashlytics.buildtools.utils.io.ByteReader;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes10.dex */
public class DwarfDataParser {
    private static final NamedRangesResolver MISSING_SECTION_RESOLVER = new MissingSectionNamedRangesResolver();
    private static final Set<DWTag> RELEVANT_TAGS = Sets.newHashSet(DWTag.SUBPROGRAM, DWTag.INLINED_SUBROUTINE);
    private final ByteOrder byteOrder;
    private final ByteReader byteReader;
    private final DebugElfSectionHeaders debugHeaders;
    private final boolean isDebugFeatureFlagEnabled;

    public DwarfDataParser(ByteReader byteReader, ByteOrder byteOrder, DebugElfSectionHeaders debugElfSectionHeaders, boolean z) {
        this.byteReader = byteReader;
        this.byteOrder = byteOrder;
        this.debugHeaders = debugElfSectionHeaders;
        this.isDebugFeatureFlagEnabled = z;
    }

    private static List<NamedRange> interleave(NamedRange namedRange, Collection<NamedRange> collection) {
        if (collection.isEmpty()) {
            return Lists.newArrayList(namedRange);
        }
        ArrayList newArrayList = Lists.newArrayList();
        long longValue = namedRange.start.longValue();
        long longValue2 = namedRange.end.longValue();
        for (NamedRange namedRange2 : Ordering.natural().immutableSortedCopy(collection)) {
            long longValue3 = namedRange2.end.longValue();
            if (namedRange2.start.longValue() > longValue) {
                newArrayList.add(new NamedRange(namedRange.name, Long.valueOf(longValue), namedRange2.start));
            }
            newArrayList.add(namedRange2);
            longValue = namedRange2.end.longValue();
            longValue2 = longValue3;
        }
        if (longValue2 < namedRange.end.longValue()) {
            newArrayList.add(new NamedRange(namedRange.name, Long.valueOf(longValue2), namedRange.end));
        }
        return newArrayList;
    }

    private static List<NamedRange> interleaveRanges(List<NamedRange> list, List<NamedRange> list2) {
        if (list.isEmpty()) {
            return list2;
        }
        LinkedList newLinkedList = Lists.newLinkedList();
        for (NamedRange namedRange : list) {
            newLinkedList.addAll(interleave(namedRange, Collections2.filter(list2, isChildOf(namedRange))));
        }
        return newLinkedList;
    }

    private static Predicate<NamedRange> isChildOf(final NamedRange namedRange) {
        return new Predicate<NamedRange>() { // from class: com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DwarfDataParser.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate, java.util.function.Predicate
            public /* synthetic */ boolean test(Object obj) {
                return II0xO0.oIX0oI(this, obj);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate
            public boolean apply(NamedRange namedRange2) {
                return namedRange2 != null && NamedRange.this.contains(namedRange2);
            }
        };
    }

    private static List<NamedRange> processChildDebugInfoEntries(ByteReader byteReader, CompilationUnitContext compilationUnitContext, Map<Integer, DebugAbbrevEntry> map) throws IOException {
        LinkedList newLinkedList = Lists.newLinkedList();
        long j = compilationUnitContext.fileContext.debugSectionHeaders.debugInfo.shOffset;
        long currentOffset = byteReader.getCurrentOffset() - j;
        int readULEB128 = byteReader.readULEB128();
        long j2 = currentOffset;
        while (readULEB128 > 0) {
            DebugAbbrevEntry debugAbbrevEntry = map.get(Integer.valueOf(readULEB128));
            List<NamedRange> processDebugInfoEntry = processDebugInfoEntry(byteReader, compilationUnitContext, j2, debugAbbrevEntry.tag, debugAbbrevEntry.attributes);
            if (debugAbbrevEntry.hasChildren) {
                processDebugInfoEntry = interleaveRanges(processDebugInfoEntry, processChildDebugInfoEntries(byteReader, compilationUnitContext, map));
            }
            newLinkedList.addAll(processDebugInfoEntry);
            j2 = byteReader.getCurrentOffset() - j;
            readULEB128 = byteReader.readULEB128();
        }
        return newLinkedList;
    }

    private static CompilationUnitContext processCompilationUnit(ByteReader byteReader, FileContext fileContext, CompilationUnitContext.Header header, Map<Long, String> map, Map<Long, String> map2, Map<Integer, DebugAbbrevEntry> map3) throws IOException {
        DebugAbbrevEntry debugAbbrevEntry = map3.get(Integer.valueOf(byteReader.readULEB128()));
        CompilationUnitContext processCompilationUnitEntry = processCompilationUnitEntry(byteReader, fileContext, header, map, map2, debugAbbrevEntry.attributes);
        if (debugAbbrevEntry.hasChildren) {
            processCompilationUnitEntry.namedRanges.addAll(processChildDebugInfoEntries(byteReader, processCompilationUnitEntry, map3));
        }
        return processCompilationUnitEntry;
    }

    private static CompilationUnitContext processCompilationUnitEntry(ByteReader byteReader, FileContext fileContext, CompilationUnitContext.Header header, Map<Long, String> map, Map<Long, String> map2, List<DebugAbbrevEntry.Attribute> list) throws IOException {
        return new CompilationUnitContext(fileContext, header, map, map2, (CompilationUnitContext.EntryData) new DefaultAttributesReader(byteReader, header, fileContext.referenceBytesConverter, new CompileUnitAttributeProcessor(fileContext.referenceBytesConverter), fileContext.debugSectionHeaders.debugStr.shOffset).readAttributes(list));
    }

    private static List<NamedRange> processDebugInfoEntry(ByteReader byteReader, CompilationUnitContext compilationUnitContext, long j, DWTag dWTag, List<DebugAbbrevEntry.Attribute> list) throws IOException {
        NamedRangesResolver namedRangesResolver;
        if (!RELEVANT_TAGS.contains(dWTag)) {
            new SkipAttributesReader(byteReader, compilationUnitContext.header).readAttributes2(list);
            return Collections.emptyList();
        }
        ElfSectionHeader elfSectionHeader = compilationUnitContext.fileContext.debugSectionHeaders.debugRanges;
        if (elfSectionHeader != null) {
            namedRangesResolver = new DefaultNamedRangesResolver(byteReader, compilationUnitContext.header.addressSize, elfSectionHeader.shOffset);
        } else {
            namedRangesResolver = MISSING_SECTION_RESOLVER;
        }
        NamedRangesAttributeProcessor namedRangesAttributeProcessor = new NamedRangesAttributeProcessor(j, compilationUnitContext, namedRangesResolver);
        CompilationUnitContext.Header header = compilationUnitContext.header;
        FileContext fileContext = compilationUnitContext.fileContext;
        return (List) new DefaultAttributesReader(byteReader, header, fileContext.referenceBytesConverter, namedRangesAttributeProcessor, fileContext.debugSectionHeaders.debugStr.shOffset).readAttributes(list);
    }

    private static CompilationUnitContext readCompilationUnit(ByteReader byteReader, FileContext fileContext, boolean z) throws IOException {
        long j;
        int i;
        long currentOffset = byteReader.getCurrentOffset() - fileContext.debugSectionHeaders.debugInfo.shOffset;
        long readLong = byteReader.readLong(4);
        if (readLong == -1) {
            j = byteReader.readLong(8);
            i = 8;
        } else {
            j = readLong;
            i = 4;
        }
        return readCompilationUnit(byteReader, currentOffset, j, i, fileContext, z);
    }

    private static HashMap<Integer, DebugAbbrevEntry> readDebugAbbrevEntries(ByteReader byteReader, long j) throws IOException {
        boolean z;
        byteReader.seek(j);
        HashMap<Integer, DebugAbbrevEntry> newHashMap = Maps.newHashMap();
        while (true) {
            int readULEB128 = byteReader.readULEB128();
            if (readULEB128 != 0) {
                int readULEB1282 = byteReader.readULEB128();
                if (byteReader.readByte() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                newHashMap.put(Integer.valueOf(readULEB128), new DebugAbbrevEntry(readULEB128, readULEB1282, z, readDebugAbbrevEntryAttributes(byteReader)));
            } else {
                return newHashMap;
            }
        }
    }

    private static List<DebugAbbrevEntry.Attribute> readDebugAbbrevEntryAttributes(ByteReader byteReader) throws IOException {
        LinkedList newLinkedList = Lists.newLinkedList();
        while (true) {
            int readULEB128 = byteReader.readULEB128();
            int readULEB1282 = byteReader.readULEB128();
            if (readULEB128 == 0 && readULEB1282 == 0) {
                return newLinkedList;
            }
            newLinkedList.add(new DebugAbbrevEntry.Attribute(readULEB128, readULEB1282));
        }
    }

    private static List<DebugLineEntry> readDebugLineData(ByteReader byteReader, long j, int i) throws IOException {
        DebugLineStateMachine debugLineStateMachine = new DebugLineStateMachine();
        try {
            byteReader.seek(j);
            return debugLineStateMachine.runFromCurrentOffset(byteReader, i);
        } catch (DwarfException e) {
            Buildtools.logE("Could not parse debug data.", e);
            return Collections.emptyList();
        }
    }

    private static List<DebugLineEntry> readDebugLineDataAtIndex(ByteReader byteReader, int i, ElfSectionHeader elfSectionHeader, int i2) throws IOException {
        DebugLineStateMachine debugLineStateMachine = new DebugLineStateMachine();
        long j = elfSectionHeader.shOffset;
        long j2 = elfSectionHeader.shSize + j;
        try {
            byteReader.seek(j);
            return debugLineStateMachine.runForIndex(byteReader, i, j2, i2);
        } catch (DwarfException e) {
            Buildtools.logE("Could not parse debug data.", e);
            return Collections.emptyList();
        }
    }

    public void parse(ElfDataParser.ContentHandler contentHandler) throws IOException {
        List<DebugLineEntry> readDebugLineDataAtIndex;
        this.byteReader.seek(this.debugHeaders.debugInfo.shOffset);
        ElfSectionHeader elfSectionHeader = this.debugHeaders.debugInfo;
        long j = elfSectionHeader.shOffset + elfSectionHeader.shSize;
        FileContext fileContext = new FileContext(this.debugHeaders, new ReferenceBytesConverter(this.byteOrder));
        int i = 0;
        while (this.byteReader.getCurrentOffset() != j) {
            CompilationUnitContext readCompilationUnit = readCompilationUnit(this.byteReader, fileContext, this.isDebugFeatureFlagEnabled);
            int i2 = readCompilationUnit.header.addressSize;
            NamedRanges namedRanges = new NamedRanges(readCompilationUnit.namedRanges);
            long currentOffset = this.byteReader.getCurrentOffset();
            if (this.isDebugFeatureFlagEnabled) {
                Optional<Long> debugLineOffset = readCompilationUnit.getDebugLineOffset();
                if (debugLineOffset.isPresent()) {
                    readDebugLineDataAtIndex = readDebugLineData(this.byteReader, this.debugHeaders.debugLine.shOffset + debugLineOffset.get().longValue(), i2);
                } else {
                    readDebugLineDataAtIndex = Collections.emptyList();
                }
            } else {
                readDebugLineDataAtIndex = readDebugLineDataAtIndex(this.byteReader, i, this.debugHeaders.debugLine, i2);
            }
            contentHandler.processDebugInfoCompilationUnit(namedRanges, readDebugLineDataAtIndex);
            this.byteReader.seek(currentOffset);
            i++;
        }
    }

    private static CompilationUnitContext readCompilationUnit(ByteReader byteReader, long j, long j2, int i, FileContext fileContext, boolean z) throws IOException {
        long currentOffset = byteReader.getCurrentOffset() + j2;
        int readInt = byteReader.readInt(2);
        long readLong = byteReader.readLong(i);
        int readInt2 = byteReader.readInt(1);
        long currentOffset2 = byteReader.getCurrentOffset();
        CompilationUnitContext.Header header = new CompilationUnitContext.Header(j, j2, readInt, readLong, readInt2, i);
        TreeMap newTreeMap = Maps.newTreeMap();
        TreeMap newTreeMap2 = Maps.newTreeMap();
        if (z) {
            HashMap<Integer, DebugAbbrevEntry> readDebugAbbrevEntries = readDebugAbbrevEntries(byteReader, fileContext.debugSectionHeaders.debugAbbrev.shOffset + readLong);
            byteReader.seek(currentOffset2);
            return processCompilationUnit(byteReader, fileContext, header, newTreeMap, newTreeMap2, readDebugAbbrevEntries);
        }
        CompilationUnitContext compilationUnitContext = new CompilationUnitContext(fileContext, header, newTreeMap, newTreeMap2);
        byteReader.seek(currentOffset);
        return compilationUnitContext;
    }
}
