package com.tenmeter.smlibrary.utils.videocache;

import android.content.Context;
import android.os.Environment;
import com.tenmeter.smlibrary.utils.KLog;
import java.io.File;

/* loaded from: classes13.dex */
final class StorageUtils {
    private static final String INDIVIDUAL_DIR_NAME = "video-cache";

    private static File getCacheDirectory(Context context, boolean z) {
        String str;
        File file;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        if (z && "mounted".equals(str)) {
            file = getExternalCacheDir(context);
        } else {
            file = null;
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file == null) {
            String str2 = "/data/data/" + context.getPackageName() + "/cache/";
            KLog.e("Can't define system cache directory! '" + str2 + "%s' will be used.");
            return new File(str2);
        }
        return file;
    }

    private static File getExternalCacheDir(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (!file.exists() && !file.mkdirs()) {
            KLog.e("Unable to create external cache directory");
            return null;
        }
        return file;
    }

    public static File getIndividualCacheDirectory(Context context) {
        return new File(getCacheDirectory(context, true), "video-cache");
    }
}
