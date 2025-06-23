package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import com.alimm.tanx.core.utils.LogUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class tanxc_if {
    public static LinkedHashMap<String, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if> tanxc_do = new RewardGlobal$1(3);
    public static volatile tanxc_try tanxc_if;

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
