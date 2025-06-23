package com.kwad.components.core.n.a.d;

import android.content.Context;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.r;

/* loaded from: classes11.dex */
public interface c extends com.kwad.sdk.components.a {
    r a(Context context, String str, int i, int i2, boolean z);

    StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i);

    String getJsBaseDir(Context context, String str);

    ITkOfflineCompo.TKState getState();

    void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i, TKDownloadListener tKDownloadListener);

    void onDestroy();
}
