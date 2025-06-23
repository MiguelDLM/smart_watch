package com.kwad.sdk.api.core;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.loader.Wrapper;

@KsAdSdkDynamicApi
@Keep
/* loaded from: classes11.dex */
public class BaseSystemFragment extends Fragment {
    @KsAdSdkDynamicApi
    @Keep
    public final Activity getActivity2() {
        return super.getActivity();
    }

    @Override // android.app.Fragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public Context getContext() {
        return Wrapper.wrapContextIfNeed(super.getContext());
    }

    @Override // android.app.Fragment
    @KsAdSdkDynamicApi
    @Keep
    public void onAttach(Context context) {
        super.onAttach(Wrapper.wrapContextIfNeed(context));
    }

    @Override // android.app.Fragment
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        return Wrapper.wrapInflaterIfNeed(super.onGetLayoutInflater(bundle));
    }
}
