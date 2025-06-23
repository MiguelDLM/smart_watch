package com.kwad.components.offline.api.core.network;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.adapter.NetworkingAdapter;
import com.kwad.components.offline.api.core.network.adapter.RequestAdapter;
import com.kwad.components.offline.api.core.network.adapter.RequestListenerAdapter;
import com.kwad.components.offline.api.core.network.adapter.ResultDataAdapter;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.network.l;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public abstract class OfflineCompoNetworking<R extends IOfflineCompoRequest, T extends CommonOfflineCompoResultData> implements IOfflineCompoNetworking<R, T> {
    private l<RequestAdapter<R>, ResultDataAdapter<T>> mNetworking = new NetworkingAdapter(this);

    public static <DATA extends CommonOfflineCompoResultData> DATA parseData(String str, DATA data) {
        data.parseJson(new JSONObject(str));
        return data;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public void cancel() {
        this.mNetworking.cancel();
    }

    public abstract T createResponseData();

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public boolean enableMonitorReport() {
        return true;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public boolean isPostByJson() {
        return true;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public void onResponse(R r, c cVar) {
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public void request(@NonNull IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mNetworking.request(new RequestListenerAdapter(iOfflineCompoRequestListener));
    }

    @NonNull
    public T parseData(String str) {
        return (T) parseData(str, createResponseData());
    }
}
