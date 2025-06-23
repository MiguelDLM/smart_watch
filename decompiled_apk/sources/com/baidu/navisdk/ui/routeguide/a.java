package com.baidu.navisdk.ui.routeguide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import com.baidu.navisdk.framework.interfaces.pronavi.i;
import com.baidu.navisdk.framework.interfaces.pronavi.n;
import com.baidu.navisdk.ui.routeguide.control.x;

/* loaded from: classes8.dex */
public class a extends com.baidu.navisdk.framework.interfaces.pronavi.a {
    @Override // com.baidu.navisdk.framework.interfaces.pronavi.b
    public i C() {
        return b.V().l();
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void a(Context context, Bundle bundle) {
        b.V().a(context, bundle);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.b
    public n b0() {
        return b.V().r();
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onActivityResult(int i, int i2, Intent intent) {
        b.V().a(i, i2, intent);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.b
    public boolean onBackPressed() {
        b.V().J();
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.b, com.baidu.navisdk.framework.interfaces.i
    public void onConfigurationChanged(Configuration configuration) {
        b.V().a(configuration);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.b, com.baidu.navisdk.framework.interfaces.i
    public void onDestroy() {
        b.V().K();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.b, com.baidu.navisdk.framework.interfaces.i
    public void onPause() {
        b.V().M();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.b, com.baidu.navisdk.framework.interfaces.i
    public void onResume() {
        b.V().N();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.b, com.baidu.navisdk.framework.interfaces.i
    public void onStart() {
        b.V().O();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.b, com.baidu.navisdk.framework.interfaces.i
    public void onStop() {
        b.V().P();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.b
    public boolean v0() {
        return x.b().T();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.b
    public boolean x0() {
        return b.W();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.b
    public boolean y0() {
        return x.b().s2();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.b
    public void a(ViewModelStore viewModelStore, LifecycleOwner lifecycleOwner) {
        b.V().a(viewModelStore, lifecycleOwner);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.b, com.baidu.navisdk.framework.interfaces.i
    public View a(Activity activity, Bundle bundle, View view) {
        return b.V().a(activity, bundle, view);
    }
}
