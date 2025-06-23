package com.baidu.navisdk.module.trucknavi;

import com.baidu.navisdk.h;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.text.DecimalFormat;

/* loaded from: classes7.dex */
public final class c {
    public static String a() {
        return com.baidu.navisdk.module.trucknavi.logic.plate.c.g().b();
    }

    public static void b() {
        h.a(3);
    }

    public static String a(float f) {
        String format = new DecimalFormat("0.#").format(b(f));
        return format.indexOf(FileUtils.FILE_EXTENSION_SEPARATOR) > 0 ? format.replaceAll("0+?$", "").replaceAll("[.]$", "") : format;
    }

    public static float b(float f) {
        return Math.round(f / 100.0f) / 10.0f;
    }
}
