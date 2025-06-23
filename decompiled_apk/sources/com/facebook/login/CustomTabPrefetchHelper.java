package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class CustomTabPrefetchHelper extends CustomTabsServiceConnection {

    @OXOo.oOoXoXO
    private static CustomTabsClient client;

    @OXOo.oOoXoXO
    private static CustomTabsSession session;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final ReentrantLock lock = new ReentrantLock();

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void prepareSession() {
            CustomTabsClient customTabsClient;
            CustomTabPrefetchHelper.lock.lock();
            if (CustomTabPrefetchHelper.session == null && (customTabsClient = CustomTabPrefetchHelper.client) != null) {
                Companion companion = CustomTabPrefetchHelper.Companion;
                CustomTabPrefetchHelper.session = customTabsClient.newSession(null);
            }
            CustomTabPrefetchHelper.lock.unlock();
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final CustomTabsSession getPreparedSessionOnce() {
            CustomTabPrefetchHelper.lock.lock();
            CustomTabsSession customTabsSession = CustomTabPrefetchHelper.session;
            CustomTabPrefetchHelper.session = null;
            CustomTabPrefetchHelper.lock.unlock();
            return customTabsSession;
        }

        @XO0OX.x0XOIxOo
        public final void mayLaunchUrl(@OXOo.OOXIXo Uri url) {
            IIX0o.x0xO0oo(url, "url");
            prepareSession();
            CustomTabPrefetchHelper.lock.lock();
            CustomTabsSession customTabsSession = CustomTabPrefetchHelper.session;
            if (customTabsSession != null) {
                customTabsSession.mayLaunchUrl(url, null, null);
            }
            CustomTabPrefetchHelper.lock.unlock();
        }

        private Companion() {
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final CustomTabsSession getPreparedSessionOnce() {
        return Companion.getPreparedSessionOnce();
    }

    @XO0OX.x0XOIxOo
    public static final void mayLaunchUrl(@OXOo.OOXIXo Uri uri) {
        Companion.mayLaunchUrl(uri);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(@OXOo.OOXIXo ComponentName name, @OXOo.OOXIXo CustomTabsClient newClient) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(newClient, "newClient");
        newClient.warmup(0L);
        client = newClient;
        Companion.prepareSession();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(@OXOo.OOXIXo ComponentName componentName) {
        IIX0o.x0xO0oo(componentName, "componentName");
    }
}
