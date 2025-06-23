package com.baidu.navisdk.framework.lifecycle;

import OXOo.oOoXoXO;
import android.os.Looper;
import androidx.lifecycle.MediatorLiveData;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class a<T> extends MediatorLiveData<T> {
    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(@oOoXoXO T t) {
        Looper mainLooper = Looper.getMainLooper();
        IIX0o.oO(mainLooper, "Looper.getMainLooper()");
        if (mainLooper.getThread() == Thread.currentThread()) {
            super.setValue(t);
        } else {
            postValue(t);
        }
    }
}
