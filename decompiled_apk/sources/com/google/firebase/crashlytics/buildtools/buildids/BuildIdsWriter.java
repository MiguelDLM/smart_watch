package com.google.firebase.crashlytics.buildtools.buildids;

import com.google.firebase.crashlytics.buildtools.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes10.dex */
public class BuildIdsWriter {
    public static final String BUILD_IDS_RESOURCE_FILENAME = "com_google_firebase_crashlytics_build_ids.xml";
    private final File resourceFile;

    public BuildIdsWriter(File file) {
        this.resourceFile = file;
    }

    public void writeBuildIds(List<BuildIdInfo> list) throws IOException {
        try {
            InputStream createResourceFileStream = XmlResourceUtils.createResourceFileStream(list);
            if (this.resourceFile.getParentFile() != null) {
                FileUtils.verifyDirectory(this.resourceFile.getParentFile());
            }
            FileUtils.writeInputStreamToFile(createResourceFileStream, this.resourceFile);
        } catch (Exception e) {
            throw new IOException("Crashlytics could not create: " + this.resourceFile, e);
        }
    }
}
