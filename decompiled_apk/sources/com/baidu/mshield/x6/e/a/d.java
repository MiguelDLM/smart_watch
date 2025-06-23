package com.baidu.mshield.x6.e.a;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class d implements FileFilter {
    public d(c cVar) {
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        if (Pattern.matches("cpu[0-9]", file.getName())) {
            return true;
        }
        return false;
    }
}
