package com.facebook.bolts;

import android.content.Intent;
import android.os.Bundle;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class AppLinks {

    @OXOo.OOXIXo
    public static final AppLinks INSTANCE = new AppLinks();

    @OXOo.OOXIXo
    public static final String KEY_NAME_APPLINK_DATA = "al_applink_data";

    @OXOo.OOXIXo
    public static final String KEY_NAME_EXTRAS = "extras";

    private AppLinks() {
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Bundle getAppLinkData(@OXOo.OOXIXo Intent intent) {
        IIX0o.x0xO0oo(intent, "intent");
        return intent.getBundleExtra(KEY_NAME_APPLINK_DATA);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Bundle getAppLinkExtras(@OXOo.OOXIXo Intent intent) {
        IIX0o.x0xO0oo(intent, "intent");
        Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData == null) {
            return null;
        }
        return appLinkData.getBundle("extras");
    }
}
