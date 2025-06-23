package com.kwad.components.core.n.b.a;

import android.content.Context;
import com.kwad.components.offline.api.core.network.INetworkChangeListener;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.bo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class i implements INetworkManager {
    private List<INetworkChangeListener> No = new CopyOnWriteArrayList();
    private NetworkMonitor.a Np;

    private void ao(final Context context) {
        if (this.Np != null) {
            return;
        }
        this.Np = new NetworkMonitor.a() { // from class: com.kwad.components.core.n.b.a.i.1
            @Override // com.kwad.sdk.core.NetworkMonitor.a
            public final void a(NetworkMonitor.NetworkState networkState) {
                bo.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.n.b.a.i.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        int networkType = i.this.getNetworkType(context);
                        Iterator it = i.this.No.iterator();
                        while (it.hasNext()) {
                            ((INetworkChangeListener) it.next()).networkChange(networkType);
                        }
                    }
                });
            }
        };
        NetworkMonitor.getInstance().a(context, this.Np);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void addNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        if (iNetworkChangeListener != null) {
            ao(context);
            this.No.add(iNetworkChangeListener);
        }
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final int getNetworkType(Context context) {
        return ah.cx(context);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void removeNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        this.No.remove(iNetworkChangeListener);
    }
}
