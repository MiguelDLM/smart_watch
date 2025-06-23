package com.google.firebase.crashlytics.buildtools.api;

import java.io.File;
import java.io.IOException;

/* loaded from: classes10.dex */
public interface SymbolFileService {
    void uploadNativeSymbolFile(WebApi webApi, File file, String str) throws IOException;
}
