package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.a.a;
import java.io.Serializable;

@KsJson
/* loaded from: classes11.dex */
public class AdLabelImpl extends a implements Serializable {
    private static final long serialVersionUID = -4055679938174214490L;
    public String channel;
    public long cpmBidFloor;
    public String historyTitle;
    public String postTitle;
    public String prevTitle;
    public int thirdAge;
    public int thirdGender;
    public String thirdInterest;

    public boolean isAdLabelAppInfoInValid() {
        if (TextUtils.isEmpty(this.prevTitle) && TextUtils.isEmpty(this.postTitle) && TextUtils.isEmpty(this.channel) && TextUtils.isEmpty(this.historyTitle)) {
            return true;
        }
        return false;
    }

    public boolean isUserInfoVaild() {
        if (this.thirdAge == 0 && this.thirdGender == 0 && TextUtils.isEmpty(this.thirdInterest)) {
            return true;
        }
        return false;
    }
}
