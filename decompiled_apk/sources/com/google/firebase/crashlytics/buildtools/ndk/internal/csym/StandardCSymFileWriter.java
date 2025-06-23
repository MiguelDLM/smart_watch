package com.google.firebase.crashlytics.buildtools.ndk.internal.csym;

import java.io.File;
import java.io.IOException;

/* loaded from: classes10.dex */
public class StandardCSymFileWriter implements CSymFileWriter {
    @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.csym.CSymFileWriter
    public void writeCSymFile(CSym cSym, File file) throws IOException {
        CSymWriter.writeToTextFile(cSym, file);
    }
}
