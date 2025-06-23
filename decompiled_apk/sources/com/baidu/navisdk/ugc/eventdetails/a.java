package com.baidu.navisdk.ugc.eventdetails;

import OXOo.OOXIXo;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.navisdk.ugc.eventdetails.view.f;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class a extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    private final MutableLiveData<f.n> f8041a = new MutableLiveData<>();

    @OOXIXo
    public final MutableLiveData<f.n> a() {
        return this.f8041a;
    }

    public final void a(@OOXIXo f.n state) {
        IIX0o.x0xO0oo(state, "state");
        this.f8041a.setValue(state);
    }
}
