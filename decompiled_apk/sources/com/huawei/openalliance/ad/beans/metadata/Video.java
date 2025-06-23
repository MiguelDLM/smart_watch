package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.b;

@DataKeep
/* loaded from: classes10.dex */
public class Video {
    private int maxDuration;

    public Video() {
    }

    public int Code() {
        return this.maxDuration;
    }

    @b
    public Video(int i) {
        this.maxDuration = i;
    }

    public void Code(int i) {
        this.maxDuration = i;
    }
}
