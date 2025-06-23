package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.hms.ads.DefaultTemplate;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.ee;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.beans.metadata.CtrlExt;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: classes10.dex */
public class c {
    private static final String Code = "AdDataUtil";
    private static final int V = 30459301;

    private static String Code(Context context, AdContentData adContentData) {
        String str;
        int j = adContentData.j();
        if (j == 0) {
            return null;
        }
        PromoteInfo z = adContentData.z();
        if (j == 10) {
            if (z != null && z.getType() == 2 && !TextUtils.isEmpty(z.getName())) {
                return context.getResources().getString(R.string.hiad_wechat_mini_spec, z.getName());
            }
            String string = context.getResources().getString(R.string.hiad_wechat_mini_spec, "");
            if (string == null) {
                return null;
            }
            return string.trim();
        }
        if (j == 11) {
            return context.getResources().getString(R.string.hiad_share_wx);
        }
        if (z != null) {
            str = z.getName();
            if (z.getType() == 1) {
                boolean isEmpty = TextUtils.isEmpty(str);
                Resources resources = context.getResources();
                if (!isEmpty) {
                    return resources.getString(R.string.hiad_fast_app_spec, str);
                }
                String string2 = resources.getString(R.string.hiad_fast_app_spec, "");
                if (string2 == null) {
                    return null;
                }
                return string2.trim();
            }
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        AppInfo y = adContentData.y();
        if (y == null) {
            return null;
        }
        return (TextUtils.isEmpty(y.L()) || !g.Code(context, y.Code())) ? str : y.L();
    }

    public static String Code(Context context, AdContentData adContentData, int i) {
        if (context == null || adContentData == null) {
            return null;
        }
        String Code2 = Code(context, adContentData);
        if (TextUtils.isEmpty(Code2)) {
            return null;
        }
        Resources resources = context.getResources();
        return i == 0 ? resources.getString(R.string.hiad_touch_jump_to, Code2) : resources.getString(R.string.hiad_jump_to, Code2);
    }

    public static boolean Code() {
        String Code2 = com.huawei.hms.ads.g.Code();
        return !TextUtils.isEmpty(Code2) && 30461200 <= Integer.parseInt(Code2);
    }

    private static boolean Code(int i, String str) {
        com.huawei.hms.ads.uiengine.d V2 = com.huawei.hms.ads.g.V();
        if (V2 != null) {
            try {
                return V2.Code(str, i, null);
            } catch (Throwable th) {
                fb.V(Code, "check valid err: %s", th.getClass().getSimpleName());
            }
        }
        return false;
    }

    public static boolean Code(Context context, DefaultTemplate defaultTemplate, String str, int i) {
        String str2;
        if (context == null) {
            return false;
        }
        String Code2 = com.huawei.hms.ads.g.Code();
        if (TextUtils.isEmpty(Code2) || V > Integer.parseInt(Code2)) {
            str2 = "uiengine not support";
        } else if (defaultTemplate == null || !defaultTemplate.I()) {
            str2 = "data is invalid";
        } else {
            if (Code(i, defaultTemplate.Code())) {
                if (defaultTemplate.V() == null) {
                    fb.V(Code, "isShowV2Tpt, no fcCtl");
                    return true;
                }
                Integer V2 = defaultTemplate.V();
                int intValue = V2.intValue();
                int I = ee.Code(context).I(str);
                fb.V(Code, "isShowV2Tpt, tptFcCtl = %s, showTimes = %s", V2, Integer.valueOf(I));
                return intValue > I;
            }
            str2 = "templateId is invalid";
        }
        fb.V(Code, str2);
        return false;
    }

    public static boolean Code(CtrlExt ctrlExt) {
        if (ctrlExt == null) {
            return false;
        }
        return "1".equals(ctrlExt.Code());
    }

    public static boolean Code(CtrlExt ctrlExt, Integer num) {
        return Code(ctrlExt) && Code(num);
    }

    public static boolean Code(Integer num) {
        if (num == null) {
            return false;
        }
        int intValue = num.intValue();
        if (intValue != 1 && intValue != 2 && intValue != 6) {
            switch (intValue) {
                case 12:
                case 13:
                case 14:
                case 15:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
