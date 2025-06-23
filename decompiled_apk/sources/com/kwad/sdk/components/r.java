package com.kwad.sdk.components;

import android.view.View;
import java.util.Map;

/* loaded from: classes11.dex */
public interface r {
    void a(j jVar);

    void a(p pVar);

    void a(String str, String str2, q qVar);

    void b(com.kwad.sdk.core.webview.c.g gVar);

    m bb(String str);

    void c(com.kwad.sdk.core.webview.c.a aVar);

    Object execute(String str);

    int getUniqId();

    View getView();

    void onDestroy();

    void setCustomEnv(Map<String, Object> map);
}
