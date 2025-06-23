package com.kwad.components.core.l;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public class a extends com.kwad.sdk.mvp.a {
    public List<com.kwad.components.core.l.a.a> MU = new ArrayList();

    @NonNull
    private final b<?> MV;

    @NonNull
    public final Context mContext;

    @NonNull
    public final View mRootView;

    public a(b<?> bVar) {
        this.MV = bVar;
        this.mContext = bVar.mContext;
        this.mRootView = bVar.mRootView;
    }

    @Deprecated
    public final Activity getActivity() {
        return this.MV.getActivity();
    }

    public final void hq() {
        this.MV.finish();
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.MU.clear();
    }
}
