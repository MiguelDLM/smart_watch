package com.kwad.sdk.crash.utils;

import java.io.File;
import java.io.IOException;

/* loaded from: classes11.dex */
public class FileExistsException extends IOException {
    private static final long serialVersionUID = 1;

    public FileExistsException() {
    }

    public FileExistsException(String str) {
        super(str);
    }

    public FileExistsException(File file) {
        super("File " + file + " already exists");
    }
}
