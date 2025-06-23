package com.google.firebase.crashlytics.buildtools.api;

import com.google.firebase.crashlytics.buildtools.AppBuildInfo;
import com.google.firebase.crashlytics.buildtools.Buildtools;
import com.google.firebase.crashlytics.buildtools.Obfuscator;
import com.google.firebase.crashlytics.buildtools.exception.ZeroByteFileException;
import com.google.firebase.crashlytics.buildtools.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.text.oIX0oI;

/* loaded from: classes10.dex */
public class FirebaseMappingFileService implements MappingFileService {
    private static final String MAPPING_UPLOAD_REQUEST_FORMAT = "%s/v1/project/-/app/%s/upload/java/%s";
    private final WebApi webApi;

    public FirebaseMappingFileService(WebApi webApi) {
        this.webApi = webApi;
    }

    private static File getMappingBuildDir(File file) throws IOException {
        File file2 = new File(file, ".crashlytics-mappings-tmp");
        FileUtils.verifyDirectory(file2);
        return file2;
    }

    @Override // com.google.firebase.crashlytics.buildtools.api.MappingFileService
    public void uploadMappingFile(File file, String str, AppBuildInfo appBuildInfo, Obfuscator obfuscator) throws IOException {
        if (file.length() != 0) {
            File file2 = new File(getMappingBuildDir(appBuildInfo.getBuildDir()), str + ".gz");
            Buildtools.logD("Zipping mapping file: " + file + oIX0oI.f33048oxoX + file2);
            FileUtils.gZipFile(file, file2);
            this.webApi.uploadFile(new URL(String.format(MAPPING_UPLOAD_REQUEST_FORMAT, this.webApi.getCodeMappingApiUrl(), appBuildInfo.getGoogleAppId(), str)), file2);
            file2.delete();
            return;
        }
        throw new ZeroByteFileException(String.format("Mapping file '%s' is zero bytes, skipping upload.", file.getAbsolutePath()));
    }
}
