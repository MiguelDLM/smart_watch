package com.tenmeter.smlibrary.listener;

import com.tenmeter.smlibrary.entity.SMPOPResultBean;

/* loaded from: classes13.dex */
public interface IPopResultCallback {
    void onError(String str);

    void onSuccessFul(SMPOPResultBean sMPOPResultBean);
}
