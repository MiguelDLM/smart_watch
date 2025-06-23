package com.alimm.tanx.ui.ut;

import com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.orange.bean.OrangeUtBean;
import com.alimm.tanx.core.ut.bean.UtItemBean;
import com.alimm.tanx.core.ut.core.UserReportManager;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.TanxTestLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AdUtAnalytics implements ITanxUserTracker, NotConfused {
    private static final String TAG = "AdUtAnalytics";
    private static AdUtAnalytics sInstance;
    volatile int lastUtItemBeanHashCode = 0;

    private AdUtAnalytics() {
    }

    public static AdUtAnalytics getInstance() {
        if (sInstance == null) {
            synchronized (AdUtAnalytics.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new AdUtAnalytics();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public static boolean isOpen(String str) {
        Boolean bool;
        OrangeBean orangeBean = OrangeManager.getInstance().getOrangeBean();
        if (orangeBean != null) {
            OrangeUtBean orangeUtBean = orangeBean.ut;
            if (orangeUtBean != null && (bool = orangeUtBean.utSwitch) != null && !bool.booleanValue()) {
                return false;
            }
            HashMap<String, String> hashMap = orangeBean.commonSwitch;
            if (hashMap != null && hashMap.containsKey(str)) {
                return "true".equalsIgnoreCase(orangeBean.commonSwitch.get(str));
            }
            return true;
        }
        return true;
    }

    public synchronized void send(String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        LogUtils.d(TAG, "start—send-ut");
        try {
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.d(TAG, "send UT exception.", e);
        }
        if (!isOpen(str)) {
            LogUtils.d(TAG, "埋点开关为false，终止上报");
            return;
        }
        if (OrangeManager.getInstance().getOrangeBean() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(OrangeManager.getInstance().getOrangeBean().version);
            sb.append("");
            map.put("orangeVersion", sb.toString());
        }
        UtItemBean utItemBean = new UtItemBean(str3, str2, str, i, i2, str4, str5, str6, map, str7);
        int hashCode = utItemBean.hashCode();
        if (this.lastUtItemBeanHashCode != 0 && this.lastUtItemBeanHashCode == hashCode) {
            LogUtils.d(TAG, "Send UT End Duplicate Data");
        } else {
            UserReportManager.getInstance().send(utItemBean);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\nlastUtItemBean ");
            sb2.append(this.lastUtItemBeanHashCode);
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb3);
            sb4.append("\nutItemBean ");
            sb4.append(hashCode);
            String sb5 = sb4.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append("sendUtData:");
            sb6.append(utItemBean.toString());
            sb6.append(sb5);
            LogUtils.d(TAG, sb6.toString());
            this.lastUtItemBeanHashCode = hashCode;
        }
        TanxTestLog.sendLog(str, map);
    }

    @Override // com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker
    public void track(String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        send(str, str2, str3, i, i2, str4, str5, str6, map, str7);
    }
}
