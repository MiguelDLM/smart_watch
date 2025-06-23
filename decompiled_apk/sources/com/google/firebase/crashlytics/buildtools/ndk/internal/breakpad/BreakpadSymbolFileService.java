package com.google.firebase.crashlytics.buildtools.ndk.internal.breakpad;

import com.google.firebase.crashlytics.buildtools.Buildtools;
import com.google.firebase.crashlytics.buildtools.api.FirebaseSymbolFileService;
import java.io.File;
import java.io.IOException;

/* loaded from: classes10.dex */
public class BreakpadSymbolFileService extends FirebaseSymbolFileService {
    private static final String BREAKPAD_UPLOAD_REQUEST_FORMAT = "%s/v1/project/-/app/%s/upload/breakpad/%s";

    public BreakpadSymbolFileService() {
        super(BREAKPAD_UPLOAD_REQUEST_FORMAT);
    }

    @Override // com.google.firebase.crashlytics.buildtools.api.FirebaseSymbolFileService
    public String extractUuid(File file) throws IOException {
        BreakpadRecords createFromBreakpadFile = BreakpadRecords.createFromBreakpadFile(file);
        String codeId = createFromBreakpadFile.getCodeId();
        if (codeId == null) {
            Buildtools.logD("Could not find valid INFO record for Breakpad file. Using MODULE ID instead.");
            return createFromBreakpadFile.getModuleId();
        }
        return codeId;
    }
}
