package com.alimm.tanx.core.web.cache;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DynamicCacheLoader {
    private static volatile DynamicCacheLoader INSTANCE;

    public static DynamicCacheLoader getInstance() {
        if (INSTANCE == null) {
            synchronized (DynamicCacheLoader.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new DynamicCacheLoader();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return INSTANCE;
    }

    public File getResByUrl(File file, String str) {
        String urlPath = getUrlPath(str);
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    File resByUrl = getResByUrl(file2, str);
                    if (resByUrl != null) {
                        return resByUrl;
                    }
                } else if (urlPath.endsWith(file2.getName())) {
                    return file2;
                }
            }
            return null;
        } else if (urlPath.endsWith(file.getName())) {
            return file;
        } else {
            return null;
        }
    }

    public String getUrlPath(String str) {
        try {
            String path = new URL(str).getPath();
            if (!path.startsWith("/") || path.length() == 1) {
                return path;
            }
            return path.substring(1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        }
    }
}
