package com.tenmeter.smlibrary.listener;

import com.tenmeter.smlibrary.entity.SMGameUser;

/* loaded from: classes13.dex */
public interface IUserInfoCallback {
    void onError(String str);

    void onSuccessFul(SMGameUser sMGameUser);
}
