package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
@com.huawei.openalliance.ad.annotations.b
/* loaded from: classes10.dex */
public class FeedbackInfo implements Serializable {
    private static final long serialVersionUID = 30456300;
    private long id;
    private String label;
    private int type;

    @com.huawei.openalliance.ad.annotations.b
    public String Code() {
        return this.label;
    }

    public long I() {
        return this.id;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int V() {
        return this.type;
    }

    public boolean Z() {
        int i;
        return !TextUtils.isEmpty(this.label) && ((i = this.type) == 1 || i == 2 || i == 3);
    }

    public void Code(int i) {
        this.type = i;
    }

    public void Code(long j) {
        this.id = j;
    }

    public void Code(String str) {
        this.label = str;
    }
}
