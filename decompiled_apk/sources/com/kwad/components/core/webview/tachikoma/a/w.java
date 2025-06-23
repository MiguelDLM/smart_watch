package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public abstract class w implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c aaG;

    @NonNull
    private CopyOnWriteArrayList<com.kwad.sdk.core.b> aaH = new CopyOnWriteArrayList<>();

    public final void b(final com.kwad.sdk.core.b bVar) {
        if (this.aaG != null) {
            bo.runOnUiThread(new az() { // from class: com.kwad.components.core.webview.tachikoma.a.w.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    if (w.this.aaG != null) {
                        w.this.aaG.a(bVar);
                    }
                }
            });
        } else {
            this.aaH.add(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void onDestroy() {
        this.aaG = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.aaG = cVar;
        if (this.aaH.size() > 0) {
            Iterator<com.kwad.sdk.core.b> it = this.aaH.iterator();
            while (it.hasNext()) {
                com.kwad.sdk.core.b next = it.next();
                b(next);
                this.aaH.remove(next);
            }
        }
    }
}
