package com.google.firebase.crashlytics.buildtools.ndk.internal.elf;

import com.google.firebase.crashlytics.buildtools.Buildtools;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DebugLineEntry;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DwarfDataParser;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.NamedRanges;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Charsets;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.II0xO0;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Lists;
import com.google.firebase.crashlytics.buildtools.utils.io.ByteReader;
import com.google.firebase.crashlytics.buildtools.utils.io.RandomAccessFileInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes10.dex */
public class ElfDataParser {
    private static final String[] ARM_ARCH = {"Pre-v4", "4", "4T", "5T", "5TE", "5TEJ", "6", "6KZ", "6T2", "6K", "7", "6-M", "6S-M", "7E-M", "8"};
    private static final String ARM_ATTR_PUBLIC_SECTION = "aeabi";
    private static final int ARM_ATTR_TAG_FILE_ATTRIBUTES = 1;
    private static final String ELF_NOTE_GNU = "GNU";
    private static final long NT_GNU_BUILD_ID = 3;
    private static final int SHT_ARM_ATTRIBUTES = 1879048195;
    private ByteOrder _byteOrder;
    private final ByteReader _fileReader;
    private int _wordSize;

    /* loaded from: classes10.dex */
    public interface ContentHandler {
        void endProcessingSymbols();

        void processArmVersion(String str);

        void processBuildId(byte[] bArr);

        void processDebugInfoCompilationUnit(NamedRanges namedRanges, List<DebugLineEntry> list);

        void processElfHeader(ElfFileHeader elfFileHeader);

        void processElfSymbols(List<ElfSymbol> list);

        void processSectionHeaders(ElfSectionHeaders elfSectionHeaders);

        void startProcessingSymbols();
    }

    /* loaded from: classes10.dex */
    public static class ElfNote {
        public final byte[] desc;
        public final String name;
        public final long type;

        public ElfNote(String str, long j, byte[] bArr) {
            this.name = str;
            this.type = j;
            this.desc = bArr;
        }
    }

    /* loaded from: classes10.dex */
    public static final class NullContentHandler implements ContentHandler {
        private NullContentHandler() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.ContentHandler
        public void endProcessingSymbols() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.ContentHandler
        public void processArmVersion(String str) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.ContentHandler
        public void processBuildId(byte[] bArr) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.ContentHandler
        public void processDebugInfoCompilationUnit(NamedRanges namedRanges, List<DebugLineEntry> list) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.ContentHandler
        public void processElfHeader(ElfFileHeader elfFileHeader) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.ContentHandler
        public void processElfSymbols(List<ElfSymbol> list) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.ContentHandler
        public void processSectionHeaders(ElfSectionHeaders elfSectionHeaders) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.ContentHandler
        public void startProcessingSymbols() {
        }
    }

    public ElfDataParser(ByteReader byteReader) {
        this._fileReader = byteReader;
    }

    private Optional<String> findArmVersionInSection(ByteReader byteReader, long j) throws IOException {
        while (j > 0) {
            byte readByte = byteReader.readByte();
            long readInt = byteReader.readInt(4);
            if (readInt <= j) {
                j -= readInt;
                long j2 = readInt - 5;
                if (readByte == 1) {
                    return findArmVersionInSubSection(byteReader, j2);
                }
                byteReader.seek(byteReader.getCurrentOffset() + j2);
            } else {
                throw new IOException(String.format("Subsection size %d is greater than parent section size %d.", Long.valueOf(readInt), Long.valueOf(j)));
            }
        }
        Buildtools.logD("Crashlytics did not find an ARM file attributes subsection.");
        return Optional.absent();
    }

    private Optional<String> findArmVersionInSubSection(ByteReader byteReader, long j) throws IOException {
        long currentOffset = byteReader.getCurrentOffset() + j;
        while (byteReader.getCurrentOffset() < currentOffset) {
            int readULEB128 = byteReader.readULEB128();
            if (readULEB128 != 4 && readULEB128 != 5) {
                if (readULEB128 != 6) {
                    if (readULEB128 != 32 && readULEB128 != 65 && readULEB128 != 67) {
                        byteReader.readULEB128();
                    }
                } else {
                    return Optional.of(ARM_ARCH[byteReader.readULEB128()]);
                }
            }
            byteReader.readNullTerminatedString(Charsets.UTF_8);
        }
        Buildtools.logD("Crashlytics did not find an ARM architecture field.");
        return Optional.absent();
    }

    private Optional<byte[]> getGnuBuildId(ElfSectionHeaders elfSectionHeaders) throws IOException {
        return readGnuBuildIdNote(elfSectionHeaders).transform(new Function<ElfNote, byte[]>() { // from class: com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function, java.util.function.Function
            public byte[] apply(ElfNote elfNote) {
                return elfNote.desc;
            }
        });
    }

    private Optional<byte[]> getTextSectionHash(ElfSectionHeaders elfSectionHeaders) throws IOException {
        return readTextPage(elfSectionHeaders, 16).transform(new Function<byte[], byte[]>() { // from class: com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function, java.util.function.Function
            public byte[] apply(byte[] bArr) {
                byte[] bArr2 = new byte[16];
                for (int i = 0; i < bArr.length; i++) {
                    int i2 = i % 16;
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i]);
                }
                return bArr2;
            }
        });
    }

    private ElfFileIdent initializeReader() throws IOException {
        ByteOrder byteOrder;
        int i;
        ElfFileIdent readElfFileIdent = readElfFileIdent(this._fileReader);
        if (readElfFileIdent.isElf()) {
            if (readElfFileIdent.getDataEncoding() == 2) {
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            this._byteOrder = byteOrder;
            if (readElfFileIdent.getElfClass() == 2) {
                i = 8;
            } else {
                i = 4;
            }
            this._wordSize = i;
            this._fileReader.setByteOrder(this._byteOrder);
            return readElfFileIdent;
        }
        throw new IllegalArgumentException("Input is not a valid ELF file.");
    }

    private static long notePadding(long j) {
        return (j + 3) & (-4);
    }

    public static void parse(File file, ContentHandler contentHandler, boolean z) throws IOException {
        ByteReader byteReader = null;
        try {
            ByteReader byteReader2 = new ByteReader(new RandomAccessFileInputStream(file));
            try {
                new ElfDataParser(byteReader2).parse(contentHandler, z);
                byteReader2.close();
            } catch (Throwable th) {
                th = th;
                byteReader = byteReader2;
                if (byteReader != null) {
                    byteReader.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void parseElf(ElfFileIdent elfFileIdent, ContentHandler contentHandler, boolean z) throws IOException {
        ElfFileHeader readElfFileHeader = readElfFileHeader(this._fileReader, elfFileIdent, this._wordSize);
        contentHandler.processElfHeader(readElfFileHeader);
        ElfSectionHeaders readElfSectionHeaders = readElfSectionHeaders(this._fileReader, readElfFileHeader, this._wordSize);
        contentHandler.processSectionHeaders(readElfSectionHeaders);
        Optional<byte[]> buildId = getBuildId(readElfSectionHeaders);
        if (!buildId.isPresent()) {
            Buildtools.logD("Crashlytics could not find a build ID.");
            return;
        }
        contentHandler.processBuildId(buildId.get());
        Optional<String> readArmVersion = readArmVersion(readElfFileHeader, readElfSectionHeaders);
        if (readArmVersion.isPresent()) {
            contentHandler.processArmVersion(readArmVersion.get());
        }
        contentHandler.startProcessingSymbols();
        boolean hasDebugInfo = readElfSectionHeaders.hasDebugInfo();
        if (!z || !hasDebugInfo) {
            contentHandler.processElfSymbols(readElfSymbols(readElfSectionHeaders, elfFileIdent.getElfClass()));
        }
        Optional<DebugElfSectionHeaders> from = DebugElfSectionHeaders.from(readElfSectionHeaders);
        if (from.isPresent()) {
            new DwarfDataParser(this._fileReader, this._byteOrder, from.get(), z).parse(contentHandler);
        }
        contentHandler.endProcessingSymbols();
    }

    private Optional<String> readArmVersion(ElfFileHeader elfFileHeader, ElfSectionHeaders elfSectionHeaders) throws IOException {
        Optional<String> absent = Optional.absent();
        if (elfFileHeader.eMachine != 40) {
            return absent;
        }
        Optional<ElfSectionHeader> findHeader = elfSectionHeaders.findHeader(new Predicate<ElfSectionHeader>() { // from class: com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.5
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate, java.util.function.Predicate
            public /* synthetic */ boolean test(Object obj) {
                return II0xO0.oIX0oI(this, obj);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate
            public boolean apply(ElfSectionHeader elfSectionHeader) {
                return elfSectionHeader.shType == ElfDataParser.SHT_ARM_ATTRIBUTES;
            }
        });
        if (!findHeader.isPresent()) {
            return absent;
        }
        ElfSectionHeader elfSectionHeader = findHeader.get();
        return readArmVersion(elfSectionHeader.shOffset, elfSectionHeader.shSize);
    }

    private static ElfFileHeader readElfFileHeader(ByteReader byteReader, ElfFileIdent elfFileIdent, int i) throws IOException {
        byteReader.seek(16L);
        ElfFileHeader elfFileHeader = new ElfFileHeader(elfFileIdent);
        elfFileHeader.eType = byteReader.readInt(2);
        elfFileHeader.eMachine = byteReader.readInt(2);
        elfFileHeader.eVersion = byteReader.readLong(4);
        elfFileHeader.eEntry = byteReader.readLong(i);
        elfFileHeader.ePhoff = byteReader.readLong(i);
        elfFileHeader.eShoff = byteReader.readLong(i);
        elfFileHeader.eFlags = byteReader.readLong(4);
        elfFileHeader.eEhsize = byteReader.readInt(2);
        elfFileHeader.ePhentsize = byteReader.readInt(2);
        elfFileHeader.ePhnum = byteReader.readInt(2);
        elfFileHeader.eShentsize = byteReader.readInt(2);
        elfFileHeader.eShnum = byteReader.readInt(2);
        elfFileHeader.eShstrndx = byteReader.readInt(2);
        return elfFileHeader;
    }

    private static ElfFileIdent readElfFileIdent(ByteReader byteReader) throws IOException {
        byteReader.seek(0L);
        return new ElfFileIdent(byteReader.readBytes(16));
    }

    private ElfNote readElfNote(long j) throws IOException {
        this._fileReader.seek(j);
        long readLong = this._fileReader.readLong(4);
        long readLong2 = this._fileReader.readLong(4);
        long readLong3 = this._fileReader.readLong(4);
        String readNullTerminatedString = this._fileReader.readNullTerminatedString(Charsets.UTF_8);
        this._fileReader.readBytes((int) (notePadding(readLong) - readLong));
        return new ElfNote(readNullTerminatedString, readLong3, this._fileReader.readBytes((int) readLong2));
    }

    private static ElfSectionHeaders readElfSectionHeaders(ByteReader byteReader, ElfFileHeader elfFileHeader, int i) throws IOException {
        byteReader.seek(elfFileHeader.eShoff);
        ArrayList<ElfSectionHeader> newArrayListWithCapacity = Lists.newArrayListWithCapacity(elfFileHeader.eShnum);
        for (int i2 = 0; i2 < elfFileHeader.eShnum; i2++) {
            ElfSectionHeader elfSectionHeader = new ElfSectionHeader();
            elfSectionHeader.shName = byteReader.readInt(4);
            elfSectionHeader.shType = byteReader.readInt(4);
            elfSectionHeader.shFlags = byteReader.readLong(i);
            elfSectionHeader.shAddr = byteReader.readLong(i);
            elfSectionHeader.shOffset = byteReader.readLong(i);
            elfSectionHeader.shSize = byteReader.readLong(i);
            elfSectionHeader.shLink = byteReader.readInt(4);
            elfSectionHeader.shInfo = byteReader.readInt(4);
            elfSectionHeader.shAddrAlign = byteReader.readLong(i);
            elfSectionHeader.shEntSize = byteReader.readLong(i);
            newArrayListWithCapacity.add(elfSectionHeader);
        }
        ElfSectionHeader elfSectionHeader2 = (ElfSectionHeader) newArrayListWithCapacity.get(elfFileHeader.eShstrndx);
        byteReader.seek(elfSectionHeader2.shOffset);
        for (ElfSectionHeader elfSectionHeader3 : newArrayListWithCapacity) {
            byteReader.seek(elfSectionHeader2.shOffset + elfSectionHeader3.shName);
            elfSectionHeader3.shNameString = byteReader.readNullTerminatedString(Charsets.UTF_8);
        }
        return new ElfSectionHeaders(newArrayListWithCapacity);
    }

    private List<ElfSymbol> readElfSymbols(ElfSectionHeaders elfSectionHeaders, int i) throws IOException {
        LinkedList linkedList = new LinkedList();
        for (ElfSectionHeader elfSectionHeader : elfSectionHeaders.getList()) {
            if (elfSectionHeader.shType == 2) {
                linkedList.addAll(readElfSymbols(elfSectionHeader, elfSectionHeaders, i));
            }
        }
        return linkedList;
    }

    private Optional<ElfNote> readGnuBuildIdNote(ElfSectionHeaders elfSectionHeaders) throws IOException {
        Optional<ElfSectionHeader> findHeader = elfSectionHeaders.findHeader(new Predicate<ElfSectionHeader>() { // from class: com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.4
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate, java.util.function.Predicate
            public /* synthetic */ boolean test(Object obj) {
                return II0xO0.oIX0oI(this, obj);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate
            public boolean apply(ElfSectionHeader elfSectionHeader) {
                return elfSectionHeader.shNameString.equals(".note.gnu.build-id") && elfSectionHeader.shType == 7;
            }
        });
        if (findHeader.isPresent()) {
            ElfNote readElfNote = readElfNote(findHeader.get().shOffset);
            if (ELF_NOTE_GNU.equals(readElfNote.name) && 3 == readElfNote.type) {
                return Optional.of(readElfNote);
            }
        }
        return Optional.absent();
    }

    private List<ElfSymbol> readSymbolTable(long j, int i, long j2, int i2) throws IOException {
        this._fileReader.seek(j);
        ArrayList<ElfSymbol> arrayList = new ArrayList(i);
        for (int i3 = 0; i3 < i; i3++) {
            ElfSymbol elfSymbol = new ElfSymbol();
            if (i2 != 2) {
                elfSymbol.stName = this._fileReader.readInt(4);
                elfSymbol.stValue = this._fileReader.readLong(this._wordSize);
                elfSymbol.stSize = this._fileReader.readLong(this._wordSize);
                elfSymbol.stInfo = this._fileReader.readByte();
                elfSymbol.stOther = this._fileReader.readByte();
                elfSymbol.stShndx = this._fileReader.readShort(2);
            } else {
                elfSymbol.stName = this._fileReader.readInt(4);
                elfSymbol.stInfo = this._fileReader.readByte();
                elfSymbol.stOther = this._fileReader.readByte();
                elfSymbol.stShndx = this._fileReader.readShort(2);
                elfSymbol.stValue = this._fileReader.readLong(this._wordSize);
                elfSymbol.stSize = this._fileReader.readLong(this._wordSize);
            }
            arrayList.add(elfSymbol);
        }
        this._fileReader.seek(j2);
        for (ElfSymbol elfSymbol2 : arrayList) {
            this._fileReader.seek(elfSymbol2.stName + j2);
            elfSymbol2.stNameString = this._fileReader.readNullTerminatedString(Charsets.UTF_8);
        }
        return arrayList;
    }

    private Optional<byte[]> readTextPage(ElfSectionHeaders elfSectionHeaders, int i) throws IOException {
        Optional<ElfSectionHeader> findHeader = elfSectionHeaders.findHeader(new Predicate<ElfSectionHeader>() { // from class: com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.3
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate, java.util.function.Predicate
            public /* synthetic */ boolean test(Object obj) {
                return II0xO0.oIX0oI(this, obj);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate
            public boolean apply(ElfSectionHeader elfSectionHeader) {
                return elfSectionHeader.shNameString.equals(".text") && elfSectionHeader.shType == 1;
            }
        });
        if (findHeader.isPresent()) {
            this._fileReader.seek(findHeader.get().shOffset);
            return Optional.of(this._fileReader.readBytes((((((int) Math.min(r5.shSize, 4096L)) + i) - 1) / i) * i));
        }
        return Optional.absent();
    }

    public Optional<byte[]> getBuildId(ElfSectionHeaders elfSectionHeaders) throws IOException {
        Optional<byte[]> gnuBuildId = getGnuBuildId(elfSectionHeaders);
        if (!gnuBuildId.isPresent()) {
            return getTextSectionHash(elfSectionHeaders);
        }
        return gnuBuildId;
    }

    private List<ElfSymbol> readElfSymbols(ElfSectionHeader elfSectionHeader, ElfSectionHeaders elfSectionHeaders, int i) throws IOException {
        Optional<ElfSectionHeader> headerByIndex = elfSectionHeaders.getHeaderByIndex(elfSectionHeader.shLink);
        if (!headerByIndex.isPresent()) {
            return Collections.emptyList();
        }
        return readSymbolTable(elfSectionHeader.shOffset, ((int) elfSectionHeader.shSize) / ((int) elfSectionHeader.shEntSize), headerByIndex.get().shOffset, i);
    }

    public void parse(ContentHandler contentHandler) throws IOException {
        parse(contentHandler, false);
    }

    public void parse(ContentHandler contentHandler, boolean z) throws IOException {
        ElfFileIdent initializeReader = initializeReader();
        if (contentHandler == null) {
            contentHandler = new NullContentHandler();
        }
        parseElf(initializeReader, contentHandler, z);
    }

    private Optional<String> readArmVersion(long j, long j2) throws IOException {
        this._fileReader.seek(j);
        if (this._fileReader.readByte() == 65) {
            long j3 = j2 - 1;
            while (j3 > 0) {
                long readInt = this._fileReader.readInt(4);
                if (readInt <= j3) {
                    j3 -= readInt;
                    long length = (readInt - 4) - (r2.length() - 1);
                    if (this._fileReader.readNullTerminatedString(Charsets.UTF_8).equals(ARM_ATTR_PUBLIC_SECTION)) {
                        return findArmVersionInSection(this._fileReader, length);
                    }
                    ByteReader byteReader = this._fileReader;
                    byteReader.seek(byteReader.getCurrentOffset() + length);
                } else {
                    throw new IOException(String.format("Section size %d is greater than remaining data length %d.", Long.valueOf(readInt), Long.valueOf(j3)));
                }
            }
            Buildtools.logD("Crashlytics did not find an ARM public attributes subsection.");
            return Optional.absent();
        }
        throw new IllegalArgumentException(String.format("Invalid data found at offset %d.", Long.valueOf(j)));
    }
}
