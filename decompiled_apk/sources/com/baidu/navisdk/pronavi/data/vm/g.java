package com.baidu.navisdk.pronavi.data.vm;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import androidx.lifecycle.MutableLiveData;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class g extends com.baidu.navisdk.pronavi.base.b {
    private final X0IIOO b = XIxXXX0x0.oIX0oI(a.f7711a);

    /* loaded from: classes7.dex */
    public static final class a extends Lambda implements oIX0oI<MutableLiveData<Integer>> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f7711a = new a();

        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final MutableLiveData<Integer> invoke() {
            return new MutableLiveData<>(0);
        }
    }

    private final MutableLiveData<Integer> d() {
        return (MutableLiveData) this.b.getValue();
    }

    public final void a(int i) {
        d().setValue(Integer.valueOf(i));
    }

    @OOXIXo
    public final MutableLiveData<Integer> c() {
        return d();
    }
}
