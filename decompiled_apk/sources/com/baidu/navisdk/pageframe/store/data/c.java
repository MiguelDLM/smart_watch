package com.baidu.navisdk.pageframe.store.data;

import OXOo.oOoXoXO;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.navisdk.uiframe.framework.a;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public class c<T extends com.baidu.navisdk.uiframe.framework.a> extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    @oOoXoXO
    private T f7631a;

    @oOoXoXO
    public final T a() {
        return this.f7631a;
    }

    public void b() {
        this.f7631a = null;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        b();
    }

    public void a(@oOoXoXO T t) {
        this.f7631a = t;
    }

    public final <T> void a(@oOoXoXO MutableLiveData<T> mutableLiveData, T t) {
        if (mutableLiveData == null) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(getClass().getSimpleName(), "notifyDataChange liveData == null: " + t);
                return;
            }
            return;
        }
        if (IIX0o.Oxx0IOOO(Looper.getMainLooper(), Looper.myLooper())) {
            mutableLiveData.setValue(t);
        } else {
            mutableLiveData.postValue(t);
        }
    }
}
