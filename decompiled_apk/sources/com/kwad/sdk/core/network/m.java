package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public abstract class m<R extends n, T extends NormalResultData> extends a<R> {
    private static final String TAG = "NormalNetworking";

    @Nullable
    private g<R, T> mListener = null;

    private void onRequest(@NonNull g<R, T> gVar) {
        this.mListener = gVar;
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    public abstract T createResponseData();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.a
    public void fetchImpl() {
        n nVar = (n) createRequest();
        c cVar = null;
        try {
            String url = nVar.getUrl();
            if (nVar.getMethod().equals("POST")) {
                cVar = com.kwad.sdk.g.yy().doPost(url, nVar.getHeader(), nVar.getBody());
            } else {
                cVar = com.kwad.sdk.g.yy().doGet(url, nVar.getHeader());
            }
            if (cVar != null && cVar.code == 200) {
                com.kwad.sdk.core.e.c.d(TAG, "normal request success:" + cVar.code);
            } else {
                com.kwad.sdk.core.e.c.d(TAG, "normal request failed");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            if (0 == 0) {
                cVar = new c();
            }
            cVar.code = -1;
            cVar.awD = e;
        }
        onResponse((m<R, T>) nVar, cVar);
    }

    public void parseResponse(T t, c cVar) {
        t.parseResponse(cVar);
    }

    public void request(@NonNull g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            gVar.onError(null, e.awP.errorCode, bo.t(th));
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r, c cVar) {
        if (this.mListener == null) {
            return;
        }
        if (cVar.Ew()) {
            T createResponseData = createResponseData();
            parseResponse(createResponseData, cVar);
            this.mListener.onSuccess(r, createResponseData);
        } else {
            g<R, T> gVar = this.mListener;
            int i = cVar.code;
            Exception exc = cVar.awD;
            gVar.onError(r, i, exc != null ? exc.getMessage() : "");
        }
    }
}
