package com.kwad.components.offline.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;

/* loaded from: classes11.dex */
public class a implements com.kwad.components.core.n.a.c.a {
    private final IObiwanOfflineCompo adx;

    public a(@NonNull IObiwanOfflineCompo iObiwanOfflineCompo) {
        this.adx = iObiwanOfflineCompo;
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return a.class;
    }

    public final IObiwanLogcat getLog() {
        return this.adx.getLog();
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return this.adx.priority();
    }

    public final void updateConfigs() {
        this.adx.updateConfigs();
    }
}
