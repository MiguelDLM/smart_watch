package com.alimm.tanx.ui;

import com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker;
import com.alimm.tanx.ui.ut.AdUtAnalytics;
import java.util.Map;

/* loaded from: classes.dex */
public class tanxu_for implements ITanxUserTracker {
    public tanxu_for(TanxThirdInstanceDefault tanxThirdInstanceDefault) {
    }

    @Override // com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker
    public void track(String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        AdUtAnalytics.getInstance().track(str, str2, str3, i, i2, str4, str5, str6, map, str7);
    }
}
