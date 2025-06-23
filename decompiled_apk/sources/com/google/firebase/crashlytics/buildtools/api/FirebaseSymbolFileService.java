package com.google.firebase.crashlytics.buildtools.api;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.FilenameUtils;
import com.google.firebase.crashlytics.buildtools.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/* loaded from: classes10.dex */
public abstract class FirebaseSymbolFileService implements SymbolFileService {
    private final String uploadRequestFormat;

    public FirebaseSymbolFileService(String str) {
        this.uploadRequestFormat = str;
    }

    public abstract String extractUuid(File file) throws IOException;

    @Override // com.google.firebase.crashlytics.buildtools.api.SymbolFileService
    public void uploadNativeSymbolFile(WebApi webApi, File file, String str) throws IOException {
        File file2;
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            file2 = new File(FilenameUtils.removeExtension(file.getName()) + ".gz");
        } else {
            file2 = new File(parentFile, FilenameUtils.removeExtension(file.getName()) + ".gz");
        }
        FileUtils.gZipFile(file, file2);
        webApi.uploadFile(new URL(String.format(this.uploadRequestFormat, webApi.getCodeMappingApiUrl(), str, extractUuid(file))), file2);
        file2.delete();
    }
}
