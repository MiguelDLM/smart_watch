package com.tenmeter.smlibrary.listener;

import com.tenmeter.smlibrary.entity.SMGameListParent;
import java.util.List;

/* loaded from: classes13.dex */
public interface IGameListForTypeCallback {
    void onError(String str);

    void onSuccessFul(List<SMGameListParent> list);
}
