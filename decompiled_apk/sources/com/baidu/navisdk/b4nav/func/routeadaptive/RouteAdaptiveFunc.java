package com.baidu.navisdk.b4nav.func.routeadaptive;

import android.graphics.Rect;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.b4nav.func.routeadaptive.a;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.framework.data.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class RouteAdaptiveFunc<R extends com.baidu.navisdk.b4nav.func.routeadaptive.a> extends CoreFunc<R> {
    private final MutableLiveData<b> m;
    private final List<Rect> n;

    /* loaded from: classes7.dex */
    public class a implements Observer<b> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable b bVar) {
            int i;
            if (bVar != null && (bVar.a() instanceof List) && ((List) bVar.a()).size() == 0) {
                i = 0;
            } else {
                i = 300;
            }
            RouteAdaptiveFunc routeAdaptiveFunc = RouteAdaptiveFunc.this;
            routeAdaptiveFunc.a(((com.baidu.navisdk.b4nav.func.routeadaptive.a) routeAdaptiveFunc.p()).d(), ((com.baidu.navisdk.b4nav.func.routeadaptive.a) RouteAdaptiveFunc.this.p()).c(), i);
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc
    public void b(boolean z) {
        super.b(z);
        if (com.baidu.navisdk.module.init.a.a()) {
            r();
            s();
        }
        ((com.baidu.navisdk.b4nav.func.routeadaptive.a) this.j).a(false);
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        this.m.observe(this, new a());
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "RouteAdaptiveFunc";
    }

    public void r() {
        com.baidu.navisdk.module.viewbound.a.e().b();
    }

    public void s() {
        com.baidu.navisdk.module.viewbound.a.e().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(boolean z, List<Rect> list, int i) {
        if (z) {
            if (list == null) {
                list = ((com.baidu.navisdk.b4nav.func.routeadaptive.a) p()).b();
            }
            if (!this.n.equals(list) || i == -1) {
                this.n.clear();
                this.n.addAll(list);
                ArrayList<Bundle> arrayList = new ArrayList<>();
                Iterator<Rect> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(a(0, it.next()));
                }
                a(arrayList, i);
            }
        }
    }

    public Bundle a(int i, Rect rect) {
        return com.baidu.navisdk.module.viewbound.a.e().a(i, rect);
    }

    public boolean a(ArrayList<Bundle> arrayList, int i) {
        return BNMapController.getInstance().setUIViewBound(arrayList, i);
    }
}
