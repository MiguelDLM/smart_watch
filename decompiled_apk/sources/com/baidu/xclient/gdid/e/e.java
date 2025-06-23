package com.baidu.xclient.gdid.e;

import java.io.File;
import java.io.FileFilter;

/* loaded from: classes8.dex */
public class e implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.getName().matches("^cpu\\d+");
    }
}
