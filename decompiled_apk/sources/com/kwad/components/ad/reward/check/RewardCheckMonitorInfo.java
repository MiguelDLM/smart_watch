package com.kwad.components.ad.reward.check;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

@KsJson
/* loaded from: classes11.dex */
public class RewardCheckMonitorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int CHECK_TYPE_EXPOSURE = 1;
    public static final int CHECK_TYPE_REWARD = 2;
    public static final int ENVI_TYPE_NATIVE = 0;
    public static final int ENVI_TYPE_TK = 1;
    public static final int REQUEST_STATE_END = 2;
    public static final int REQUEST_STATE_START = 1;
    public static final long serialVersionUID = 1080394611500009098L;
    public int checkType;
    public int code;
    public long creativeId;
    public long dataLoadInterval;
    public int enviType;
    public long posId;
    public int requestStatus;

    public RewardCheckMonitorInfo setCheckType(int i) {
        this.checkType = i;
        return this;
    }

    public RewardCheckMonitorInfo setCode(int i) {
        this.code = i;
        return this;
    }

    public RewardCheckMonitorInfo setCreativeId(long j) {
        this.creativeId = j;
        return this;
    }

    public RewardCheckMonitorInfo setDataLoadInterval(long j) {
        this.dataLoadInterval = j;
        return this;
    }

    public RewardCheckMonitorInfo setEnviType(int i) {
        this.enviType = i;
        return this;
    }

    public RewardCheckMonitorInfo setRequestStatus(int i) {
        this.requestStatus = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardCheckMonitorInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }
}
