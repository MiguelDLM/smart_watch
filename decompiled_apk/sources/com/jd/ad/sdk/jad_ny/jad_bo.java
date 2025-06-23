package com.jd.ad.sdk.jad_ny;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* loaded from: classes10.dex */
public class jad_bo implements FilenameFilter {
    public final /* synthetic */ Pattern jad_an;

    public jad_bo(Pattern pattern) {
        this.jad_an = pattern;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return this.jad_an.matcher(str).matches();
    }
}
