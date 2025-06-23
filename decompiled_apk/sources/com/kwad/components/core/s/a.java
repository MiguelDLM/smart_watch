package com.kwad.components.core.s;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.utils.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public class a {
    private static volatile a TH;
    private com.kwad.sdk.utils.h TD;
    private List<WeakReference<OfflineOnAudioConflictListener>> TE = new ArrayList();
    private boolean TF = false;
    private boolean TG = false;

    private a(@NonNull Context context) {
        init(context);
    }

    public static a as(@NonNull Context context) {
        if (TH == null) {
            synchronized (a.class) {
                try {
                    if (TH == null) {
                        TH = new a(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return TH;
    }

    private void init(Context context) {
        this.TF = false;
        com.kwad.sdk.utils.h hVar = new com.kwad.sdk.utils.h(context);
        this.TD = hVar;
        hVar.c(new h.a() { // from class: com.kwad.components.core.s.a.1
            @Override // com.kwad.sdk.utils.h.a
            public final void onAudioBeOccupied() {
                Iterator it = a.this.TE.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeOccupied();
                        } else {
                            it.remove();
                        }
                    }
                }
                a.a(a.this, true);
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void onAudioBeReleased() {
                Iterator it = a.this.TE.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeReleased();
                        } else {
                            it.remove();
                        }
                    }
                }
            }
        });
    }

    public final boolean aN(boolean z) {
        com.kwad.sdk.utils.h hVar = this.TD;
        if (hVar == null) {
            return false;
        }
        if (!z && this.TF) {
            return false;
        }
        this.TF = true;
        this.TG = false;
        return hVar.LM();
    }

    public final void b(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        Iterator<WeakReference<OfflineOnAudioConflictListener>> it = this.TE.iterator();
        while (it.hasNext()) {
            WeakReference<OfflineOnAudioConflictListener> next = it.next();
            if (next == null || next.get() == offlineOnAudioConflictListener) {
                it.remove();
            }
        }
    }

    public final boolean rA() {
        return this.TG;
    }

    public final boolean rB() {
        return this.TF;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.TG = true;
        return true;
    }

    public final void a(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        this.TE.add(new WeakReference<>(offlineOnAudioConflictListener));
    }
}
