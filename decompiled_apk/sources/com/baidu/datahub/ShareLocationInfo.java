package com.baidu.datahub;

import com.baidu.datahub.protocol.ShareLocationInfoProtocol;

/* loaded from: classes7.dex */
public class ShareLocationInfo {
    private ShareLocationInfoProtocol info = null;
    private long timestamp = 0;

    public ShareLocationInfoProtocol getInfo() {
        return this.info;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setInfo(ShareLocationInfoProtocol shareLocationInfoProtocol) {
        this.info = shareLocationInfoProtocol;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
