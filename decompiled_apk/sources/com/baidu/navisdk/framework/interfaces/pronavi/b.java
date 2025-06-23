package com.baidu.navisdk.framework.interfaces.pronavi;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;

/* loaded from: classes7.dex */
public abstract class b implements com.baidu.navisdk.framework.interfaces.i, com.baidu.navisdk.framework.interfaces.h {
    public abstract i C();

    @Override // com.baidu.navisdk.framework.interfaces.i
    public abstract View a(Activity activity, Bundle bundle, View view);

    public abstract void a(ViewModelStore viewModelStore, LifecycleOwner lifecycleOwner);

    public abstract n b0();

    public abstract boolean onBackPressed();

    @Override // com.baidu.navisdk.framework.interfaces.i
    public abstract void onConfigurationChanged(Configuration configuration);

    @Override // com.baidu.navisdk.framework.interfaces.i
    public abstract void onDestroy();

    @Override // com.baidu.navisdk.framework.interfaces.i
    public abstract void onPause();

    @Override // com.baidu.navisdk.framework.interfaces.i
    public abstract void onResume();

    @Override // com.baidu.navisdk.framework.interfaces.i
    public abstract void onStart();

    @Override // com.baidu.navisdk.framework.interfaces.i
    public abstract void onStop();

    public abstract boolean v0();

    public abstract boolean x0();

    public abstract boolean y0();
}
