package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.z;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes11.dex */
public final class u<T extends e, R extends com.kwad.sdk.core.network.f> implements Runnable {
    private static AtomicLong aAm = new AtomicLong(-1);
    protected final b<T, R> aAn;
    protected final AtomicInteger aAo;
    protected final l<T> ayz;
    protected final Context mContext;

    public u(Context context, l<T> lVar, b<T, R> bVar, AtomicInteger atomicInteger) {
        this.mContext = context;
        this.ayz = lVar;
        this.aAn = bVar;
        this.aAo = atomicInteger;
    }

    private void A(@NonNull List<T> list) {
        List d = z.d(list, 200);
        int size = d.size();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (int i = 0; i < size; i++) {
            this.aAn.a((List) d.get(i), atomicBoolean);
        }
    }

    private void FH() {
        long NG = bj.NG();
        if (NG >= aAm.get() * 2) {
            try {
                List<T> Fs = this.ayz.Fs();
                if (!Fs.isEmpty()) {
                    A(Fs);
                }
            } catch (OutOfMemoryError e) {
                aAm.set(NG);
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(e);
            } catch (Throwable th) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.aAo.get() <= 0 && ah.isNetworkConnected(this.mContext)) {
            FH();
        }
    }
}
