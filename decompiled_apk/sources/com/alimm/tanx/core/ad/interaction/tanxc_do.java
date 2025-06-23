package com.alimm.tanx.core.ad.interaction;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class tanxc_do {
    private AdClickHandler tanxc_do;
    private Map<String, String> tanxc_if;

    /* renamed from: com.alimm.tanx.core.ad.interaction.tanxc_do$tanxc_do, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0103tanxc_do {
        private static final tanxc_do tanxc_do = new tanxc_do(0);
    }

    public /* synthetic */ tanxc_do(byte b) {
        this();
    }

    public static tanxc_do tanxc_do() {
        return C0103tanxc_do.tanxc_do;
    }

    private tanxc_do() {
        this.tanxc_if = new ConcurrentHashMap(16);
        this.tanxc_do = new AdClickHandler();
    }

    public void tanxc_do(Context context, AdClickInfo adClickInfo, boolean z) {
        tanxc_do(context, adClickInfo, false, z);
    }

    public void tanxc_do(Context context, AdClickInfo adClickInfo, boolean z, boolean z2) {
        this.tanxc_if.clear();
        this.tanxc_do.handleClickAndUt(context, adClickInfo, z, z2);
    }

    public void tanxc_do(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.tanxc_if.put(str, str2);
    }

    public String tanxc_do(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.tanxc_if.remove(str);
        return str;
    }
}
