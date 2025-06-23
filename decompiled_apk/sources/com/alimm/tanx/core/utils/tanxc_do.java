package com.alimm.tanx.core.utils;

import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.interaction.AdClickInfo;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import java.util.List;

/* loaded from: classes.dex */
public class tanxc_do {
    private String tanxc_byte;
    private String tanxc_case;
    private String tanxc_char;
    private String tanxc_else;
    private String tanxc_goto;
    private String tanxc_if;
    private String tanxc_int;
    private List<NewTrackItem> tanxc_long;
    private String tanxc_new;
    private String tanxc_try;
    private int tanxc_do = -1;
    private int tanxc_for = -1;

    public AdClickInfo tanxc_do(TanxAdSlot tanxAdSlot, BidInfo bidInfo, AdUtConstants adUtConstants) {
        return tanxc_do(tanxAdSlot, bidInfo, adUtConstants, null, null);
    }

    public AdClickInfo tanxc_do(TanxAdSlot tanxAdSlot, BidInfo bidInfo, AdUtConstants adUtConstants, String str, String str2) {
        if (tanxAdSlot != null) {
            this.tanxc_do = tanxAdSlot.getAdType();
            this.tanxc_byte = tanxAdSlot.getPid();
            this.tanxc_case = tanxAdSlot.getReqId();
        }
        if (bidInfo != null) {
            this.tanxc_char = bidInfo.getClickThroughUrl();
            this.tanxc_else = bidInfo.getDeepLinkUrl();
            this.tanxc_if = bidInfo.getCreativeId();
            this.tanxc_for = bidInfo.getOpenType();
            this.tanxc_int = bidInfo.getTemplateId();
            this.tanxc_new = bidInfo.getSessionId();
            this.tanxc_try = bidInfo.getTemplateConf() != null ? bidInfo.getTemplateConf().getPidStyleId() : null;
            this.tanxc_goto = bidInfo.getRawJsonStr();
            this.tanxc_long = bidInfo.getEventTrack();
        }
        return new AdClickInfo(this.tanxc_do, this.tanxc_if, this.tanxc_for, this.tanxc_int, this.tanxc_new, this.tanxc_try, this.tanxc_byte, this.tanxc_case, this.tanxc_char, this.tanxc_else, adUtConstants, str, str2, this.tanxc_goto, this.tanxc_long);
    }
}
