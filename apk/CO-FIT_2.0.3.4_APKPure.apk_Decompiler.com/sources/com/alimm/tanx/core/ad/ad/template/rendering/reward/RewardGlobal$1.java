package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if;
import java.util.LinkedHashMap;
import java.util.Map;

public class RewardGlobal$1 extends LinkedHashMap<String, tanxc_if> {
    public RewardGlobal$1(int i) {
        super(i);
    }

    public boolean removeEldestEntry(Map.Entry<String, tanxc_if> entry) {
        if (tanxc_if.tanxc_do.size() > 3) {
            return true;
        }
        return false;
    }
}
