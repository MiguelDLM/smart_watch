package com.kwad.components.ad.reward;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes11.dex */
public final class a {
    private final Set<com.kwad.components.ad.reward.e.j> oh;

    /* renamed from: com.kwad.components.ad.reward.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0752a {
        private static final a ol = new a(0);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a eY() {
        return C0752a.ol;
    }

    private void fa() {
        if (this.oh.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.oh.iterator();
        while (it.hasNext()) {
            it.next().bY();
        }
    }

    private static boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public final void b(com.kwad.components.ad.reward.e.j jVar) {
        this.oh.remove(jVar);
    }

    public final void c(final PlayableSource playableSource, @Nullable final com.kwad.components.ad.reward.e.n nVar) {
        if (isMainThread()) {
            b(playableSource, nVar);
        } else {
            bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.reward.a.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    a.this.b(playableSource, nVar);
                }
            });
        }
    }

    public final void eZ() {
        if (isMainThread()) {
            fa();
        } else {
            bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.reward.a.2
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    a.this.eZ();
                }
            });
        }
    }

    private a() {
        this.oh = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        if (this.oh.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.oh.iterator();
        while (it.hasNext()) {
            it.next().a(playableSource, nVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.j jVar) {
        if (jVar != null) {
            this.oh.add(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PlayableSource playableSource) {
        if (this.oh.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.oh.iterator();
        while (it.hasNext()) {
            it.next().bZ();
        }
    }

    public final void a(PlayableSource playableSource) {
        c(playableSource, null);
    }

    public final void b(final PlayableSource playableSource) {
        if (isMainThread()) {
            c(playableSource);
        } else {
            bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.reward.a.3
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    a.this.c(playableSource);
                }
            });
        }
    }
}
