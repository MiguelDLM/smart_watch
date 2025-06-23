package com.google.firebase.crashlytics.buildtools.ndk;

import com.google.firebase.crashlytics.buildtools.ndk.internal.CodeMappingException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOCase;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter.IOFileFilter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter.SuffixFileFilter;
import java.io.File;
import java.io.IOException;

/* loaded from: classes10.dex */
public interface NativeSymbolGenerator {
    public static final String LIB_PREFIX = "lib";
    public static final IOFileFilter SO_FILE_FILTER;
    public static final String[] SYMBOL_FILE_SUFFIXES;

    static {
        String[] strArr = {".so", ".symbols"};
        SYMBOL_FILE_SUFFIXES = strArr;
        SO_FILE_FILTER = new SuffixFileFilter(strArr, IOCase.INSENSITIVE);
    }

    File generateSymbols(File file, File file2) throws IOException, CodeMappingException;
}
