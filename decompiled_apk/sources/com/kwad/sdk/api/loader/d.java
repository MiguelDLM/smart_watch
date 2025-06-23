package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

/* loaded from: classes11.dex */
public final class d {

    /* loaded from: classes11.dex */
    public static class a extends Application {
        private final Context anu;

        public a(Context context) {
            this.anu = context;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final Context getApplicationContext() {
            return this.anu;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final ApplicationInfo getApplicationInfo() {
            return this.anu.getApplicationInfo();
        }
    }

    public static Context aK(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return context;
        }
        if (!applicationContext.getClassLoader().equals(context.getClassLoader())) {
            return new a(context);
        }
        return context.getApplicationContext();
    }
}
