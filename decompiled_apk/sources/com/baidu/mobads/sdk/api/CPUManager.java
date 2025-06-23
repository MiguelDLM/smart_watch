package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.da;
import com.baidu.mobads.sdk.internal.db;

/* loaded from: classes7.dex */
public class CPUManager {
    private final Context mContext;
    private CPUDramaListener mDramaListener;

    public CPUManager(Context context) {
        this.mContext = context;
    }

    public CPUComponent loadDramaContent(CPUDramaRequestParams cPUDramaRequestParams, CPUDramaListener cPUDramaListener) {
        if (cPUDramaRequestParams == null) {
            if (cPUDramaListener != null) {
                cPUDramaListener.onContentFailed(-2, "请求失败，请检查请求参数是否为空");
                return null;
            }
            return null;
        }
        db dbVar = new db(this.mContext, cPUDramaRequestParams, cPUDramaListener);
        dbVar.a();
        return new da(dbVar);
    }

    public void showDramaDetailActivity(CPUDramaRequestParams cPUDramaRequestParams, CPUDramaResponse cPUDramaResponse, CPUDramaListener cPUDramaListener) {
        if (cPUDramaRequestParams == null) {
            if (cPUDramaListener != null) {
                cPUDramaListener.onContentFailed(-2, "请求失败，请检查请求参数是否为空");
                return;
            }
            return;
        }
        new db(this.mContext, cPUDramaRequestParams, cPUDramaResponse, cPUDramaListener).a();
    }
}
