package com.iflytek.sparkchain.core.its;

import com.iflytek.sparkchain.core.its.ITS;

/* loaded from: classes10.dex */
public interface ITSCallbacks {
    void onError(ITS.ITSError iTSError, Object obj);

    void onResult(ITS.ITSResult iTSResult, Object obj);
}
