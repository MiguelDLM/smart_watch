package com.alimm.tanx.core.web.cache.utils;

import android.text.TextUtils;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import okio.ByteString;
import okio.GzipSource;
import okio.Okio;

/* loaded from: classes.dex */
public class OKHttpFile {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_METADATA = 0;

    public static InputStream getCacheFile(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String hex = ByteString.encodeUtf8(str.toString()).md5().hex();
        String absolutePath = file.getAbsolutePath();
        StringBuilder sb = new StringBuilder();
        sb.append(hex);
        sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
        boolean z = false;
        sb.append(0);
        File file2 = new File(absolutePath, sb.toString());
        File file3 = new File(file.getAbsolutePath(), hex + FileUtils.FILE_EXTENSION_SEPARATOR + 1);
        if (file2.exists() && file3.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file2), 1024);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (readLine.contains("Content-Encoding") && readLine.contains("gzip")) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                FileInputStream fileInputStream = new FileInputStream(file3);
                if (!z) {
                    return fileInputStream;
                }
                return Okio.buffer(new GzipSource(Okio.source(file3))).inputStream();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
