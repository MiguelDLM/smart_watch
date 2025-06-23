package com.baidu.vi;

import android.net.NetworkInfo;

/* loaded from: classes8.dex */
public class VNetworkInfo {
    public int state;
    public int type;
    public String typename;

    public VNetworkInfo(NetworkInfo networkInfo) {
        this.typename = networkInfo.getTypeName();
        this.type = networkInfo.getType();
        int i = i.f10221a[networkInfo.getState().ordinal()];
        if (i != 1) {
            if (i != 2) {
                this.state = 0;
                return;
            } else {
                this.state = 1;
                return;
            }
        }
        this.state = 2;
    }
}
