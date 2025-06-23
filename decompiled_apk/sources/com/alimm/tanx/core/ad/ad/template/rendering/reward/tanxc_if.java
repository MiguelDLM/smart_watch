package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import com.alimm.tanx.core.utils.LogUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class tanxc_if {
    public static LinkedHashMap<String, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if> tanxc_do;
    public static volatile tanxc_try tanxc_if;

    static {
        final int i = 3;
        tanxc_do = new LinkedHashMap<String, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if>(i) { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardGlobal$1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if> entry) {
                if (tanxc_if.tanxc_do.size() > 3) {
                    return true;
                }
                return false;
            }
        };
    }

    public static void tanxc_do() {
        try {
            tanxc_if = null;
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    public static void tanxc_do(String str) {
        try {
            Iterator<String> it = tanxc_do.keySet().iterator();
            while (it.hasNext()) {
                if (it.next().equalsIgnoreCase(str)) {
                    it.remove();
                    return;
                }
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }
}
