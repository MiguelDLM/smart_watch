package com.tenmeter.smlibrary.listener;

import com.tenmeter.smlibrary.entity.SMIconListParent;
import java.util.List;

/* loaded from: classes13.dex */
public interface IIconCallback {
    void onError(String str);

    void onSuccessFul(List<SMIconListParent> list);
}
