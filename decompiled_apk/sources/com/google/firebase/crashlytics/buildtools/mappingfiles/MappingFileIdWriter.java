package com.google.firebase.crashlytics.buildtools.mappingfiles;

import com.google.firebase.crashlytics.buildtools.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class MappingFileIdWriter {
    public static final String MAPPING_FILE_ID_RESOURCE_FILENAME = "com_google_firebase_crashlytics_mappingfileid.xml";
    private final File resourceFile;

    public MappingFileIdWriter(File file) {
        this.resourceFile = file;
    }

    public void writeMappingFileId(String str) throws IOException {
        try {
            InputStream createResourceFileStream = XmlResourceUtils.createResourceFileStream(str);
            if (this.resourceFile.getParentFile() != null) {
                FileUtils.verifyDirectory(this.resourceFile.getParentFile());
            }
            FileUtils.writeInputStreamToFile(createResourceFileStream, this.resourceFile);
        } catch (Exception e) {
            throw new IOException("Crashlytics could not create: " + this.resourceFile, e);
        }
    }
}
