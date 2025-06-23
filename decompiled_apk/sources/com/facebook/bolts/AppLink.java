package com.facebook.bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class AppLink {

    @OXOo.OOXIXo
    private final Uri sourceUrl;

    @OXOo.OOXIXo
    private final List<Target> targets;

    @OXOo.OOXIXo
    private final Uri webUrl;

    /* loaded from: classes8.dex */
    public static final class Target {

        @OXOo.OOXIXo
        private final String appName;

        @OXOo.OOXIXo
        private final String className;

        @OXOo.OOXIXo
        private final String packageName;

        @OXOo.OOXIXo
        private final Uri url;

        public Target(@OXOo.OOXIXo String packageName, @OXOo.OOXIXo String className, @OXOo.OOXIXo Uri url, @OXOo.OOXIXo String appName) {
            IIX0o.x0xO0oo(packageName, "packageName");
            IIX0o.x0xO0oo(className, "className");
            IIX0o.x0xO0oo(url, "url");
            IIX0o.x0xO0oo(appName, "appName");
            this.packageName = packageName;
            this.className = className;
            this.url = url;
            this.appName = appName;
        }

        @OXOo.OOXIXo
        public final String getAppName() {
            return this.appName;
        }

        @OXOo.OOXIXo
        public final String getClassName() {
            return this.className;
        }

        @OXOo.OOXIXo
        public final String getPackageName() {
            return this.packageName;
        }

        @OXOo.OOXIXo
        public final Uri getUrl() {
            return this.url;
        }
    }

    public AppLink(@OXOo.OOXIXo Uri sourceUrl, @OXOo.oOoXoXO List<Target> list, @OXOo.OOXIXo Uri webUrl) {
        IIX0o.x0xO0oo(sourceUrl, "sourceUrl");
        IIX0o.x0xO0oo(webUrl, "webUrl");
        this.sourceUrl = sourceUrl;
        this.webUrl = webUrl;
        this.targets = list == null ? CollectionsKt__CollectionsKt.ooXIXxIX() : list;
    }

    @OXOo.OOXIXo
    public final Uri getSourceUrl() {
        return this.sourceUrl;
    }

    @OXOo.OOXIXo
    public final List<Target> getTargets() {
        List<Target> unmodifiableList = Collections.unmodifiableList(this.targets);
        IIX0o.oO(unmodifiableList, "unmodifiableList(field)");
        return unmodifiableList;
    }

    @OXOo.OOXIXo
    public final Uri getWebUrl() {
        return this.webUrl;
    }
}
