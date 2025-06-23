package com.google.firebase.crashlytics.buildtools.buildids;

import com.google.firebase.crashlytics.buildtools.Buildtools;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DebugLineEntry;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.NamedRanges;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfFileHeader;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfSectionHeaders;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfSymbol;
import com.google.firebase.crashlytics.buildtools.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/* loaded from: classes10.dex */
public class BuildIdInfoCollector {

    /* loaded from: classes10.dex */
    public class BuildIdInfoContentHandler implements ElfDataParser.ContentHandler {
        private String _arch;
        private String _buildId;
        private String _libraryName;

        public BuildIdInfoContentHandler(String str) {
            this._libraryName = str;
        }

        @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.ContentHandler
        public void endProcessingSymbols() {
        }

        public Optional<BuildIdInfo> optionalBuildInfo() {
            Optional<BuildIdInfo> empty;
            Optional<BuildIdInfo> of;
            String str = this._buildId;
            if (str != null) {
                of = Optional.of(new BuildIdInfo(this._libraryName, this._arch, str));
                return of;
            }
            empty = Optional.empty();
            return empty;
        }

        @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.ContentHandler
        public void processArmVersion(String str) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.ContentHandler
        public void processBuildId(byte[] bArr) {
            this._buildId = BuildIdInfoCollector.getBuildIdBytesToString(bArr);
        }

        @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.ContentHandler
        public void processDebugInfoCompilationUnit(NamedRanges namedRanges, List<DebugLineEntry> list) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.elf.ElfDataParser.ContentHandler
        public void processElfHeader(ElfFileHeader elfFileHeader) {
            this._arch = EMachine.getMachineName(elfFileHeader.eMachine);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static String getBuildIdBytesToString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x", Integer.valueOf(b & 255)));
        }
        return sb.toString();
    }

    private Optional<BuildIdInfo> getBuildIdInfo(File file) {
        BuildIdInfoContentHandler buildIdInfoContentHandler = new BuildIdInfoContentHandler(file.getName());
        try {
            ElfDataParser.parse(file, buildIdInfoContentHandler, false);
        } catch (IOException | ArithmeticException | NegativeArraySizeException e) {
            Buildtools.getLogger().logD("Unable to parse binary: " + file.getPath() + " - " + e.getMessage());
        }
        return buildIdInfoContentHandler.optionalBuildInfo();
    }

    public List<BuildIdInfo> collect(File file) {
        final ArrayList arrayList = new ArrayList();
        Iterator<File> it = FileUtils.listFiles(file).iterator();
        while (it.hasNext()) {
            getBuildIdInfo(it.next()).ifPresent(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.buildids.II0xO0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    arrayList.add((BuildIdInfo) obj);
                }
            });
        }
        return arrayList;
    }
}
