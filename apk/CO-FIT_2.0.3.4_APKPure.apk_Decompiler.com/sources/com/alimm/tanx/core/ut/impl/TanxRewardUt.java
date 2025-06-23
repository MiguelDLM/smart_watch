package com.alimm.tanx.core.ut.impl;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import java.util.Map;

public class TanxRewardUt extends TanxBaseUt {
    public static void utCloseAdVideoProgress(ITanxAd iTanxAd, long j) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (iTanxAd != null) {
            if (iTanxAd.getAdSlot() != null) {
                str6 = iTanxAd.getAdSlot().getPid();
            } else {
                str6 = "";
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str5 = iTanxAd.getBidInfo().getCreativeId();
                str4 = iTanxAd.getBidInfo().getTemplateId();
                str = iTanxAd.getBidInfo().getSessionId();
            } else {
                str5 = "";
                str4 = str5;
                str = str4;
            }
            str3 = str6;
            str2 = requestId;
        } else {
            str5 = "";
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str2, str5, str4);
        buildArgs.put("progress", j + "");
        AdUtConstants adUtConstants = AdUtConstants.CLOSE_AD_VIDEO_PROGRESS;
        String str7 = adUtConstants.arg1;
        TanxBaseUt.send(str7, adUtConstants.eventId, str3, str2, 0, str7, buildArgs, str);
    }

    public static void utFeedbackPopImp(ITanxAd iTanxAd) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "";
        if (iTanxAd != null) {
            if (iTanxAd.getAdSlot() != null) {
                str6 = iTanxAd.getAdSlot().getPid();
            } else {
                str6 = str7;
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                String creativeId = iTanxAd.getBidInfo().getCreativeId();
                str5 = iTanxAd.getBidInfo().getTemplateId();
                String sessionId = iTanxAd.getBidInfo().getSessionId();
                if (iTanxAd.getBidInfo().getTemplateConf() != null && TextUtils.isEmpty(iTanxAd.getBidInfo().getTemplateConf().getPidStyleId())) {
                    str7 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                }
                str2 = str7;
                str4 = str6;
                str3 = requestId;
                str7 = creativeId;
                str = sessionId;
            } else {
                str5 = str7;
                str2 = str5;
                str = str2;
                str4 = str6;
                str3 = requestId;
            }
        } else {
            str5 = str7;
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str4, str3, str7, str5);
        AdUtConstants adUtConstants = AdUtConstants.FEEDBACK_POP_IMP;
        String str8 = adUtConstants.arg1;
        TanxBaseUt.send(str8, adUtConstants.eventId, str4, str3, 0, str8, str2, "", buildArgs, str);
    }

    public static void utIsRewardValid(ITanxAd iTanxAd, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "";
        if (iTanxAd != null) {
            if (iTanxAd.getAdSlot() != null) {
                str5 = iTanxAd.getAdSlot().getPid();
            } else {
                str5 = str6;
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str6 = iTanxAd.getBidInfo().getCreativeId();
                str4 = iTanxAd.getBidInfo().getTemplateId();
                str = iTanxAd.getBidInfo().getSessionId();
            } else {
                str4 = str6;
                str = str4;
            }
            str3 = str5;
            str2 = requestId;
        } else {
            str4 = str6;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str2, str6, str4);
        AdUtConstants adUtConstants = AdUtConstants.IS_REWARD_VALID;
        String str7 = adUtConstants.arg1;
        TanxBaseUt.send(str7, adUtConstants.eventId, str3, str2, i, str7, buildArgs, str);
    }

    public static void utPlayEndClickTime(ITanxAd iTanxAd, long j, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (iTanxAd != null) {
            if (iTanxAd.getAdSlot() != null) {
                str6 = iTanxAd.getAdSlot().getPid();
            } else {
                str6 = "";
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str5 = iTanxAd.getBidInfo().getCreativeId();
                str4 = iTanxAd.getBidInfo().getTemplateId();
                str3 = str6;
                str2 = requestId;
                str = iTanxAd.getBidInfo().getSessionId();
            } else {
                str5 = "";
                str4 = str5;
                str = str4;
                str3 = str6;
                str2 = requestId;
            }
        } else {
            str5 = "";
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str2, str5, str4);
        buildArgs.put("time", j + "");
        buildArgs.put("clickType", i + "");
        AdUtConstants adUtConstants = AdUtConstants.PLAY_END_CLICK_TIME;
        String str7 = adUtConstants.arg1;
        TanxBaseUt.send(str7, adUtConstants.eventId, str3, str2, 0, str7, buildArgs, str);
    }

    public static void utSavePopCancel(ITanxAd iTanxAd) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "";
        if (iTanxAd != null) {
            if (iTanxAd.getAdSlot() != null) {
                str6 = iTanxAd.getAdSlot().getPid();
            } else {
                str6 = str7;
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                String creativeId = iTanxAd.getBidInfo().getCreativeId();
                str5 = iTanxAd.getBidInfo().getTemplateId();
                String sessionId = iTanxAd.getBidInfo().getSessionId();
                if (iTanxAd.getBidInfo().getTemplateConf() != null && TextUtils.isEmpty(iTanxAd.getBidInfo().getTemplateConf().getPidStyleId())) {
                    str7 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                }
                str2 = str7;
                str4 = str6;
                str3 = requestId;
                str7 = creativeId;
                str = sessionId;
            } else {
                str5 = str7;
                str2 = str5;
                str = str2;
                str4 = str6;
                str3 = requestId;
            }
        } else {
            str5 = str7;
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str4, str3, str7, str5);
        AdUtConstants adUtConstants = AdUtConstants.SAVE_POP_CANCEL;
        String str8 = adUtConstants.arg1;
        TanxBaseUt.send(str8, adUtConstants.eventId, str4, str3, 0, str8, str2, "", buildArgs, str);
    }

    public static void utSavePopImp(ITanxAd iTanxAd) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "";
        if (iTanxAd != null) {
            if (iTanxAd.getAdSlot() != null) {
                str6 = iTanxAd.getAdSlot().getPid();
            } else {
                str6 = str7;
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                String creativeId = iTanxAd.getBidInfo().getCreativeId();
                str5 = iTanxAd.getBidInfo().getTemplateId();
                String sessionId = iTanxAd.getBidInfo().getSessionId();
                if (iTanxAd.getBidInfo().getTemplateConf() != null && TextUtils.isEmpty(iTanxAd.getBidInfo().getTemplateConf().getPidStyleId())) {
                    str7 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                }
                str2 = str7;
                str4 = str6;
                str3 = requestId;
                str7 = creativeId;
                str = sessionId;
            } else {
                str5 = str7;
                str2 = str5;
                str = str2;
                str4 = str6;
                str3 = requestId;
            }
        } else {
            str5 = str7;
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str4, str3, str7, str5);
        AdUtConstants adUtConstants = AdUtConstants.SAVE_POP_IMP;
        String str8 = adUtConstants.arg1;
        TanxBaseUt.send(str8, adUtConstants.eventId, str4, str3, 0, str8, str2, "", buildArgs, str);
    }

    public static void utSavePopPresist(ITanxAd iTanxAd) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "";
        if (iTanxAd != null) {
            if (iTanxAd.getAdSlot() != null) {
                str6 = iTanxAd.getAdSlot().getPid();
            } else {
                str6 = str7;
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                String creativeId = iTanxAd.getBidInfo().getCreativeId();
                str5 = iTanxAd.getBidInfo().getTemplateId();
                String sessionId = iTanxAd.getBidInfo().getSessionId();
                if (iTanxAd.getBidInfo().getTemplateConf() != null && !TextUtils.isEmpty(iTanxAd.getBidInfo().getTemplateConf().getPidStyleId())) {
                    str7 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                }
                str2 = str7;
                str4 = str6;
                str3 = requestId;
                str7 = creativeId;
                str = sessionId;
            } else {
                str5 = str7;
                str2 = str5;
                str = str2;
                str4 = str6;
                str3 = requestId;
            }
        } else {
            str5 = str7;
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str4, str3, str7, str5);
        AdUtConstants adUtConstants = AdUtConstants.SAVE_POP_PRESIST;
        String str8 = adUtConstants.arg1;
        TanxBaseUt.send(str8, adUtConstants.eventId, str4, str3, 0, str8, str2, "", buildArgs, str);
    }

    public static void utViewDraw(ITanxAd iTanxAd, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (iTanxAd != null) {
            if (iTanxAd.getAdSlot() != null) {
                str6 = iTanxAd.getAdSlot().getPid();
            } else {
                str6 = "";
            }
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                String creativeId = iTanxAd.getBidInfo().getCreativeId();
                String templateId = iTanxAd.getBidInfo().getTemplateId();
                str = iTanxAd.getBidInfo().getSessionId();
                str3 = creativeId;
                str5 = str6;
                str4 = requestId;
                str2 = templateId;
            } else {
                str3 = "";
                str2 = str3;
                str = str2;
                str5 = str6;
                str4 = requestId;
            }
        } else {
            str5 = "";
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        utViewDraw(str5, str4, str3, str2, i, str);
    }

    public static void utViewDraw(BidInfo bidInfo, TanxAdSlot tanxAdSlot, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String pid = tanxAdSlot != null ? tanxAdSlot.getPid() : "";
        if (tanxAdSlot != null) {
            str = tanxAdSlot.getReqId();
        } else {
            str = "";
        }
        if (bidInfo != null) {
            String creativeId = bidInfo.getCreativeId();
            String templateId = bidInfo.getTemplateId();
            str2 = bidInfo.getSessionId();
            str3 = templateId;
            str4 = creativeId;
        } else {
            str4 = "";
            str3 = str4;
            str2 = str3;
        }
        utViewDraw(pid, str, str4, str3, i, str2);
    }

    public static void utViewDraw(String str, String str2, String str3, String str4, int i, String str5) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, str3, str4);
        buildArgs.put("is_suc", i + "");
        int i2 = i == 1 ? 0 : 1;
        AdUtConstants adUtConstants = AdUtConstants.REWARD_VIDEO_VIEW_CREATE;
        String str6 = adUtConstants.arg1;
        TanxBaseUt.send(str6, adUtConstants.eventId, str, str2, i2, str6, buildArgs, str5);
    }
}
