package com.baidu.platform.comapi.walknavi.e.a.g;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
class i implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        if (Pattern.matches("cpu[0-9]", file.getName())) {
            return true;
        }
        return false;
    }
}
