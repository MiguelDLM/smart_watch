package com.alimm.tanx.core.utils;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.constant.AdConstants;
import com.alimm.tanx.core.constant.TanxAdTemplateId;

/* loaded from: classes.dex */
public class tanxc_if {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int tanxc_do(BidInfo bidInfo) {
        char c;
        if (bidInfo != null && !TextUtils.isEmpty(bidInfo.getTemplateId())) {
            String templateId = bidInfo.getTemplateId();
            templateId.hashCode();
            switch (templateId.hashCode()) {
                case 1958016183:
                    if (templateId.equals(TanxAdTemplateId.SPLASH_ID)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1958016437:
                    if (templateId.equals(TanxAdTemplateId.FEED_PIC_16_9)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1958016459:
                    if (templateId.equals(TanxAdTemplateId.FEED_VIDEO_16_9)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1958018138:
                    if (templateId.equals(TanxAdTemplateId.FEED_VIDEO_9_16)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1958018202:
                    if (templateId.equals(TanxAdTemplateId.REWARD_VIDEO)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1958020093:
                    if (templateId.equals(TanxAdTemplateId.REWARD_WATCH)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1958020157:
                    if (templateId.equals(TanxAdTemplateId.FEED_PIC_9_16)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1958020249:
                    if (templateId.equals(TanxAdTemplateId.TABLE_ID)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return 1;
                case 1:
                    return 10;
                case 2:
                    return 11;
                case 3:
                    return 13;
                case 4:
                case 5:
                    if (bidInfo.getTemplateConf() != null && !TextUtils.isEmpty(bidInfo.getTemplateConf().getPidStyleId())) {
                        String pidStyleId = bidInfo.getTemplateConf().getPidStyleId();
                        if (pidStyleId.equals(AdConstants.PID_STYLE_REWARD_VIDEO_ID)) {
                            return 30;
                        }
                        if (pidStyleId.equals(AdConstants.PID_STYLE_REWARD_ID)) {
                            return 31;
                        }
                        if (pidStyleId.equals(AdConstants.PID_STYLE_NEW_REWARD_ID) || pidStyleId.equals(AdConstants.PID_STYLE_ORDER_REWARD_ID) || pidStyleId.equals(AdConstants.PID_STYLE_OPEN_TAO_BAO_REWARD_ID)) {
                            return 32;
                        }
                    }
                    break;
                case 6:
                    return 12;
                case 7:
                    return 20;
            }
        }
        return -1;
    }
}
