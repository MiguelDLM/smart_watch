package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.l;

/* loaded from: classes7.dex */
public class CpuChannelResponse {
    private l mCpuChannelInfo;

    public CpuChannelResponse(l lVar) {
        this.mCpuChannelInfo = lVar;
    }

    public int getChannelId() {
        l lVar = this.mCpuChannelInfo;
        if (lVar != null) {
            return lVar.a();
        }
        return -1;
    }

    public String getChannelName() {
        l lVar = this.mCpuChannelInfo;
        if (lVar != null) {
            return lVar.b();
        }
        return "";
    }
}
