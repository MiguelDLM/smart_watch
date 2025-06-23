package com.kwad.sdk.k.a;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public abstract class a implements c {
    protected List<c> aNY;
    protected boolean enabled;

    public a(boolean z) {
        this.enabled = z;
    }

    private List<c> getChildren() {
        return this.aNY;
    }

    @Override // com.kwad.sdk.k.a.c
    public final boolean bN(Context context) {
        if (!this.enabled) {
            return false;
        }
        List<c> children = getChildren();
        if (children != null && children.size() > 0) {
            Iterator<c> it = children.iterator();
            while (it.hasNext()) {
                if (it.next().bN(context)) {
                    return true;
                }
            }
            return false;
        }
        try {
            return bO(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean bO(Context context) {
        return false;
    }

    public a() {
        this.enabled = true;
    }
}
