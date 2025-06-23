package com.jd.ad.sdk.fdt.utils;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.UUID;

/* loaded from: classes10.dex */
public class UUIDUtils {
    public static String uuid() {
        return UUID.randomUUID().toString().replace(HelpFormatter.DEFAULT_OPT_PREFIX, "");
    }
}
