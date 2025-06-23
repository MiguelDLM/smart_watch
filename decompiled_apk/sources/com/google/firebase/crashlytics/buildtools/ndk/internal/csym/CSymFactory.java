package com.google.firebase.crashlytics.buildtools.ndk.internal.csym;

import java.io.File;
import java.io.IOException;

/* loaded from: classes10.dex */
public interface CSymFactory {
    CSym createCSymFromFile(File file) throws CSymException, IOException;
}
