package com.alimm.tanx.core.web.cache.config;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.a;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.HashSet;
import o0oIxXOx.XIxXXX0x0;

public class CacheExtensionConfig {
    private static final HashSet NO_CACH = new HashSet() {
        {
            add("mp4");
            add("mp3");
            add("ogg");
            add("avi");
            add("wmv");
            add("flv");
            add("rmvb");
            add("3gp");
        }
    };
    private static final HashSet STATIC = new HashSet() {
        {
            add("js");
            add("ico");
            add("css");
            add("png");
            add("jpg");
            add("jpeg");
            add("gif");
            add("bmp");
            add("ttf");
            add("woff");
            add("woff2");
            add("otf");
            add("eot");
            add("svg");
            add(XIxXXX0x0.f20806xoXoI);
            add("swf");
            add("txt");
            add("text");
            add("conf");
            add("webp");
        }
    };
    private final HashSet no_cache = new HashSet(NO_CACH);
    private final HashSet statics = new HashSet(STATIC);

    private static void add(HashSet hashSet, String str) {
        if (!TextUtils.isEmpty(str)) {
            hashSet.add(str.replace(FileUtils.FILE_EXTENSION_SEPARATOR, "").toLowerCase().trim());
        }
    }

    public static void addGlobalExtension(String str) {
        add(STATIC, str);
    }

    private static void remove(HashSet hashSet, String str) {
        if (!TextUtils.isEmpty(str)) {
            hashSet.remove(str.replace(FileUtils.FILE_EXTENSION_SEPARATOR, "").toLowerCase().trim());
        }
    }

    public static void removeGlobalExtension(String str) {
        remove(STATIC, str);
    }

    public CacheExtensionConfig addExtension(String str) {
        add(this.statics, str);
        return this;
    }

    public boolean canCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.toLowerCase().trim();
        if (STATIC.contains(trim)) {
            return true;
        }
        return this.statics.contains(trim);
    }

    public void clearAll() {
        clearDiskExtension();
    }

    public void clearDiskExtension() {
        this.statics.clear();
    }

    public boolean isHtml(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.toLowerCase().contains(a.f) || str.toLowerCase().contains("htm")) {
            return true;
        }
        return false;
    }

    public boolean isMedia(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (NO_CACH.contains(str)) {
            return true;
        }
        return this.no_cache.contains(str.toLowerCase().trim());
    }

    public CacheExtensionConfig removeExtension(String str) {
        remove(this.statics, str);
        return this;
    }
}
