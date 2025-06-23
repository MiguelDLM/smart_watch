package com.alibaba.aliagentsdk;

import II0XooXoX.XO;
import Oxx0IOOO.oIX0oI;
import android.content.Context;
import com.alibaba.aliagentsdk.api.IAliAgent;

public class AliAgentSdk {
    private static AliAgentSdk sInstance;
    private oIX0oI mAliAgent;
    private Context mContext;

    private AliAgentSdk() {
    }

    public static AliAgentSdk getInstance() {
        if (sInstance == null) {
            synchronized (AliAgentSdk.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new AliAgentSdk();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public IAliAgent getAgent() {
        if (this.mAliAgent == null) {
            this.mAliAgent = new oIX0oI(this.mContext);
        }
        return this.mAliAgent;
    }

    public void init(Context context, boolean z) {
        if (this.mAliAgent == null) {
            this.mContext = context;
        }
        XO.f13oIX0oI = !z;
    }
}
