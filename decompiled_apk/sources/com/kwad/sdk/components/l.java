package com.kwad.sdk.components;

import android.content.Intent;

/* loaded from: classes11.dex */
public interface l {
    void a(o oVar);

    void callTKBridge(String str);

    void callbackDismiss();

    void callbackPageStatus(boolean z, String str);

    String getClassName();

    Intent getIntent();

    String getTemplateString();

    String getUrl();

    String getViewKey();
}
