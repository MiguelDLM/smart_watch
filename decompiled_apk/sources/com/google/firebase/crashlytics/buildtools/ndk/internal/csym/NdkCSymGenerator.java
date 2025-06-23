package com.google.firebase.crashlytics.buildtools.ndk.internal.csym;

import O0X.oIX0oI;
import com.google.firebase.crashlytics.buildtools.Buildtools;
import com.google.firebase.crashlytics.buildtools.ndk.NativeSymbolGenerator;
import com.google.firebase.crashlytics.buildtools.ndk.internal.CodeMappingException;
import com.google.firebase.crashlytics.buildtools.utils.FileUtils;
import java.io.File;
import java.io.IOException;

/* loaded from: classes10.dex */
public class NdkCSymGenerator implements NativeSymbolGenerator {
    public static final String CSYM_SUFFIX = ".cSYM";

    public File generateSymbolFileFromFile(File file, File file2, CSymFactory cSymFactory, CSymFileWriter cSymFileWriter) throws IOException, CodeMappingException {
        Buildtools.logD("Generating native symbol file from: " + file);
        if (file != null && file.isFile()) {
            FileUtils.verifyDirectory(file2);
            try {
                CSym createCSymFromFile = cSymFactory.createCSymFromFile(file);
                if (createCSymFromFile.getUUID() == null || createCSymFromFile.getUUID().equals("")) {
                    Buildtools.logD("Crashlytics could not generate a UUID for " + file + ", skipping.");
                }
                if (createCSymFromFile.getSymbols().isEmpty()) {
                    Buildtools.logD("Crashlytics found no symbols for " + file + ", skipping.");
                    return null;
                }
                File file3 = new File(file2, oIX0oI.oIX0oI(file.getName(), createCSymFromFile.getArchitecture(), createCSymFromFile.getUUID()) + CSYM_SUFFIX);
                cSymFileWriter.writeCSymFile(createCSymFromFile, file3);
                return file3;
            } catch (CSymException e) {
                throw new CodeMappingException(e);
            }
        }
        throw new CodeMappingException("Specified path is not a file: " + file);
    }

    @Override // com.google.firebase.crashlytics.buildtools.ndk.NativeSymbolGenerator
    public File generateSymbols(File file, File file2) throws IOException, CodeMappingException {
        return generateSymbolFileFromFile(file, file2, new ElfCSymFactory(true), new StandardCSymFileWriter());
    }
}
