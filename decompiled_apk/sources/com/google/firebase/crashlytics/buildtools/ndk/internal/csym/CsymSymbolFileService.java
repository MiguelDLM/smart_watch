package com.google.firebase.crashlytics.buildtools.ndk.internal.csym;

import com.google.firebase.crashlytics.buildtools.api.FirebaseSymbolFileService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes10.dex */
public class CsymSymbolFileService extends FirebaseSymbolFileService {
    private static final String CSYM_UPLOAD_REQUEST_FORMAT = "%s/v1/project/-/app/%s/upload/native/%s";

    public CsymSymbolFileService() {
        super(CSYM_UPLOAD_REQUEST_FORMAT);
    }

    private static String readCSymHeader(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            if (readLine != null && readLine.length() != 0) {
                return readLine;
            }
            throw new IOException("Could not read cSYM header for " + file.getPath());
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.api.FirebaseSymbolFileService
    public String extractUuid(File file) throws IOException {
        String[] split = readCSymHeader(file).split("\t");
        if (split.length == 8 && split[0].equals("code_mapping")) {
            return split[3];
        }
        throw new IOException("Invalid cSYM header for " + file.getAbsolutePath());
    }
}
