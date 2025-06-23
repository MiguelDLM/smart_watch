package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes11.dex */
public final class b {
    private final Set<com.kwad.components.ad.reward.e.l> om;

    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: oo, reason: collision with root package name */
        private static final b f18440oo = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b fc() {
        return a.f18440oo;
    }

    private void fd() {
        if (this.om.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.l> it = this.om.iterator();
        while (it.hasNext()) {
            it.next().onRewardVerify();
        }
    }

    private static boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public final void a(com.kwad.components.ad.reward.e.l lVar) {
        if (lVar != null) {
            this.om.add(lVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.l lVar) {
        this.om.remove(lVar);
    }

    public final void notifyRewardVerify() {
        if (isMainThread()) {
            fd();
        } else {
            bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.reward.b.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    b.this.notifyRewardVerify();
                }
            });
        }
    }

    private b() {
        this.om = new HashSet();
    }
}
