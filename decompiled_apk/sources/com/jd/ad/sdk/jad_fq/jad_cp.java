package com.jd.ad.sdk.jad_fq;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes10.dex */
public final class jad_cp {
    public static final Charset jad_an = Charset.forName("US-ASCII");

    static {
        Charset.forName("UTF-8");
    }

    public static void jad_an(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                jad_an(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }
}
