package com.baidu.navisdk.framework.interfaces;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

/* loaded from: classes7.dex */
public interface i {
    View a(Activity activity, Bundle bundle, View view);

    void a(Context context, Bundle bundle);

    void onActivityResult(int i, int i2, Intent intent);

    void onConfigurationChanged(Configuration configuration);

    void onDestroy();

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
