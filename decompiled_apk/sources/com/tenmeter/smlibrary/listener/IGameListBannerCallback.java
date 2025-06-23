package com.tenmeter.smlibrary.listener;

import com.tenmeter.smlibrary.entity.SMGameListBannerParent;
import java.util.List;

/* loaded from: classes13.dex */
public interface IGameListBannerCallback {
    void onError(String str);

    void onSuccessFul(List<SMGameListBannerParent> list);
}
