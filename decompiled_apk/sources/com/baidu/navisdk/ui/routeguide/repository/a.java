package com.baidu.navisdk.ui.routeguide.repository;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public abstract class a {
    public <T> void a(MutableLiveData<T> mutableLiveData, T t) {
        if (mutableLiveData == null) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGBaseRepository", "notifyDataChange liveData == null: " + t);
                return;
            }
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            mutableLiveData.setValue(t);
        } else {
            mutableLiveData.postValue(t);
        }
    }
}
