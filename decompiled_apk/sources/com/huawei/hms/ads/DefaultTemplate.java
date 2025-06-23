package com.huawei.hms.ads;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class DefaultTemplate implements Serializable {
    private static final String INVALID_ID = "-1";
    private static final long serialVersionUID = 3193003283515036853L;
    private String defTptId;
    private Integer tptFcCtl;

    public String Code() {
        return this.defTptId;
    }

    public boolean I() {
        return (TextUtils.isEmpty(this.defTptId) || "-1".equals(this.defTptId)) ? false : true;
    }

    public Integer V() {
        return this.tptFcCtl;
    }

    public void Code(Integer num) {
        this.tptFcCtl = num;
    }

    public void Code(String str) {
        this.defTptId = str;
    }
}
