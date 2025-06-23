package com.kwad.library.b.c;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.kwad.sdk.utils.s;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class c extends ContextThemeWrapper implements b {
    private final ContextThemeWrapper ajE;
    private Resources.Theme ajF;
    private int ajG;
    private String ajH;

    public c(ContextThemeWrapper contextThemeWrapper, String str) {
        super(contextThemeWrapper, 0);
        this.ajE = contextThemeWrapper;
        this.ajH = str;
        try {
            Object callMethod = s.callMethod(contextThemeWrapper, "getThemeResId", new Object[0]);
            if (callMethod != null) {
                this.ajG = ((Integer) callMethod).intValue();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return a.i(this.ajE.getApplicationContext(), this.ajH);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.ajE;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return a.a(super.getClassLoader(), this.ajH);
    }

    @Override // com.kwad.library.b.c.b
    public final Context getDelegatedContext() {
        return this.ajE;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return a.a(this.ajE.getResources(), this.ajH);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return a.wrapSystemService(this.ajE.getSystemService(str), str, this);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme;
        try {
            theme = super.getTheme();
        } catch (Exception e) {
            e.printStackTrace();
            theme = null;
        }
        Resources.Theme theme2 = this.ajF;
        if (theme2 == null || theme2 == theme) {
            this.ajF = a.a(theme, theme2, this.ajG, this.ajH);
        }
        return this.ajF;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.ajE.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.ajG = i;
        super.setTheme(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.ajE.unregisterComponentCallbacks(componentCallbacks);
    }
}
