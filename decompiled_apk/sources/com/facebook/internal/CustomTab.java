package com.facebook.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.CustomTabPrefetchHelper;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public class CustomTab {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private Uri uri;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public Uri getURIForAction(@OXOo.OOXIXo String action, @OXOo.oOoXoXO Bundle bundle) {
            IIX0o.x0xO0oo(action, "action");
            Utility utility = Utility.INSTANCE;
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            String dialogAuthority = ServerProtocol.getDialogAuthority();
            StringBuilder sb = new StringBuilder();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            sb.append(FacebookSdk.getGraphApiVersion());
            sb.append("/dialog/");
            sb.append(action);
            return Utility.buildUri(dialogAuthority, sb.toString(), bundle);
        }

        private Companion() {
        }
    }

    public CustomTab(@OXOo.OOXIXo String action, @OXOo.oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(action, "action");
        this.uri = Companion.getURIForAction(action, bundle == null ? new Bundle() : bundle);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static Uri getURIForAction(@OXOo.OOXIXo String str, @OXOo.oOoXoXO Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(CustomTab.class)) {
            return null;
        }
        try {
            return Companion.getURIForAction(str, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CustomTab.class);
            return null;
        }
    }

    @OXOo.OOXIXo
    public final Uri getUri() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.uri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final boolean openCustomTab(@OXOo.OOXIXo Activity activity, @OXOo.oOoXoXO String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            IIX0o.x0xO0oo(activity, "activity");
            CustomTabsIntent build = new CustomTabsIntent.Builder(CustomTabPrefetchHelper.Companion.getPreparedSessionOnce()).build();
            build.intent.setPackage(str);
            try {
                build.launchUrl(activity, this.uri);
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public final void setUri(@OXOo.OOXIXo Uri uri) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(uri, "<set-?>");
            this.uri = uri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
