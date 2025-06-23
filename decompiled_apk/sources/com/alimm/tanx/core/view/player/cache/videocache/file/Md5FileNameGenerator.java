package com.alimm.tanx.core.view.player.cache.videocache.file;

import android.text.TextUtils;
import com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes.dex */
public class Md5FileNameGenerator implements FileNameGenerator {
    private static final int MAX_EXTENSION_LENGTH = 4;

    private String getExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(47);
        if (lastIndexOf != -1 && lastIndexOf > lastIndexOf2 && lastIndexOf + 6 > str.length()) {
            return str.substring(lastIndexOf + 1, str.length());
        }
        return "";
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.file.FileNameGenerator
    public String generate(String str) {
        String extension = getExtension(str);
        String computeMD5 = ProxyCacheUtils.computeMD5(str);
        if (!TextUtils.isEmpty(extension)) {
            return computeMD5 + FileUtils.FILE_EXTENSION_SEPARATOR + extension;
        }
        return computeMD5;
    }
}
