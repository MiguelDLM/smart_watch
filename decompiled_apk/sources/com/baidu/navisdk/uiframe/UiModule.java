package com.baidu.navisdk.uiframe;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.uiframe.framework.a;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public abstract class UiModule<C extends com.baidu.navisdk.uiframe.framework.a> extends Func<C> implements ViewModelStoreOwner {
    protected ViewGroup j;
    protected View k;
    protected volatile boolean l;
    protected int m;
    private ViewModelStore n;

    public UiModule(@NonNull C c) {
        super(c);
    }

    @IdRes
    public int a(int i) {
        return -1;
    }

    public View b(int i, @Nullable View view) {
        return null;
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.framework.func.BaseFunc
    public final void create() {
        if (!this.l) {
            b(this.k, this.j);
        }
        super.create();
        s();
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.framework.func.BaseFunc
    public final void destroy() {
        super.destroy();
        ViewModelStore viewModelStore = this.n;
        if (viewModelStore != null) {
            viewModelStore.clear();
        }
        this.l = false;
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        if (this.n == null) {
            this.n = new ViewModelStore();
        }
        return this.n;
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
    }

    public boolean p() {
        return Func.a.f6808a;
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public final void pause() {
        super.pause();
    }

    @IdRes
    public int q() {
        return -1;
    }

    public ViewGroup r() {
        return this.j;
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public final void resume() {
        super.resume();
    }

    public void s() {
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public final void start() {
        super.start();
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public final void stop() {
        super.stop();
    }

    public String[] t() {
        return new String[0];
    }

    public boolean u() {
        return false;
    }

    public void v() {
        g gVar = g.NAV_RESULT;
        if (gVar.d()) {
            gVar.e(this.g, "onPostUiInit!");
        }
    }

    public String[] w() {
        return new String[0];
    }

    public ViewGroup a(int i, @Nullable View view) {
        return null;
    }

    public final void b(@Nullable View view, @Nullable ViewGroup viewGroup) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.g, this.g + "::Lifecycle: preloadFunc");
        }
        if (this.l) {
            return;
        }
        synchronized (this.b) {
            try {
                if (!this.l) {
                    if (LogUtil.LOGGABLE) {
                        c("onPreload");
                    }
                    a(view, viewGroup);
                    this.l = true;
                    if (LogUtil.LOGGABLE) {
                        b("onPreload");
                    }
                }
            } finally {
            }
        }
    }

    public void a(Configuration configuration) {
    }

    public void a(@Nullable View view, @Nullable ViewGroup viewGroup) {
    }

    public void a(int i, int i2, Intent intent) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e(this.g, "onActivityResult: " + i + "," + i2);
        }
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @Nullable
    public h a(@NonNull com.baidu.navisdk.apicenter.a aVar) {
        return super.a(aVar);
    }
}
