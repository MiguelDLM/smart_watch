package com.baidu.ar;

import com.baidu.ar.bean.ARResource;
import java.util.HashMap;

/* loaded from: classes7.dex */
public interface ARCallback {
    void onCaseChange(boolean z);

    void onCaseCreated(ARResource aRResource);

    void onLuaMessage(HashMap<String, Object> hashMap);

    void onPause(boolean z);

    void onRelease(boolean z);

    void onReset(boolean z);

    void onResume(boolean z);

    void onSetup(boolean z);

    void onStateChange(int i, Object obj);

    void onStateError(int i, String str);
}
