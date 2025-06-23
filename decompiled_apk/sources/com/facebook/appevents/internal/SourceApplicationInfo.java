package com.facebook.appevents.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.bolts.AppLinks;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class SourceApplicationInfo {

    @OOXIXo
    private static final String CALL_APPLICATION_PACKAGE_KEY = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String OPENED_BY_APP_LINK_KEY = "com.facebook.appevents.SourceApplicationInfo.openedByApplink";

    @OOXIXo
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";

    @oOoXoXO
    private final String callingApplicationPackage;
    private final boolean isOpenedByAppLink;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        public final void clearSavedSourceApplicationInfoFromDisk() {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            edit.remove(SourceApplicationInfo.CALL_APPLICATION_PACKAGE_KEY);
            edit.remove(SourceApplicationInfo.OPENED_BY_APP_LINK_KEY);
            edit.apply();
        }

        @x0XOIxOo
        @oOoXoXO
        public final SourceApplicationInfo getStoredSourceApplicatioInfo() {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            IIXOooo iIXOooo = null;
            if (!defaultSharedPreferences.contains(SourceApplicationInfo.CALL_APPLICATION_PACKAGE_KEY)) {
                return null;
            }
            return new SourceApplicationInfo(defaultSharedPreferences.getString(SourceApplicationInfo.CALL_APPLICATION_PACKAGE_KEY, null), defaultSharedPreferences.getBoolean(SourceApplicationInfo.OPENED_BY_APP_LINK_KEY, false), iIXOooo);
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class Factory {

        @OOXIXo
        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @x0XOIxOo
        @oOoXoXO
        public static final SourceApplicationInfo create(@OOXIXo Activity activity) {
            String str;
            IIX0o.x0xO0oo(activity, "activity");
            ComponentName callingActivity = activity.getCallingActivity();
            IIXOooo iIXOooo = null;
            if (callingActivity != null) {
                str = callingActivity.getPackageName();
                if (IIX0o.Oxx0IOOO(str, activity.getPackageName())) {
                    return null;
                }
            } else {
                str = "";
            }
            Intent intent = activity.getIntent();
            boolean z = false;
            if (intent != null && !intent.getBooleanExtra(SourceApplicationInfo.SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, false)) {
                intent.putExtra(SourceApplicationInfo.SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
                AppLinks appLinks = AppLinks.INSTANCE;
                Bundle appLinkData = AppLinks.getAppLinkData(intent);
                if (appLinkData != null) {
                    Bundle bundle = appLinkData.getBundle("referer_app_link");
                    if (bundle != null) {
                        str = bundle.getString("package");
                    }
                    z = true;
                }
            }
            if (intent != null) {
                intent.putExtra(SourceApplicationInfo.SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
            }
            return new SourceApplicationInfo(str, z, iIXOooo);
        }
    }

    public /* synthetic */ SourceApplicationInfo(String str, boolean z, IIXOooo iIXOooo) {
        this(str, z);
    }

    @x0XOIxOo
    public static final void clearSavedSourceApplicationInfoFromDisk() {
        Companion.clearSavedSourceApplicationInfoFromDisk();
    }

    @x0XOIxOo
    @oOoXoXO
    public static final SourceApplicationInfo getStoredSourceApplicatioInfo() {
        return Companion.getStoredSourceApplicatioInfo();
    }

    @oOoXoXO
    public final String getCallingApplicationPackage() {
        return this.callingApplicationPackage;
    }

    public final boolean isOpenedByAppLink() {
        return this.isOpenedByAppLink;
    }

    @OOXIXo
    public String toString() {
        String str;
        if (this.isOpenedByAppLink) {
            str = "Applink";
        } else {
            str = "Unclassified";
        }
        if (this.callingApplicationPackage != null) {
            return str + HexStringBuilder.COMMENT_BEGIN_CHAR + ((Object) this.callingApplicationPackage) + HexStringBuilder.COMMENT_END_CHAR;
        }
        return str;
    }

    public final void writeSourceApplicationInfoToDisk() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.putString(CALL_APPLICATION_PACKAGE_KEY, this.callingApplicationPackage);
        edit.putBoolean(OPENED_BY_APP_LINK_KEY, this.isOpenedByAppLink);
        edit.apply();
    }

    private SourceApplicationInfo(String str, boolean z) {
        this.callingApplicationPackage = str;
        this.isOpenedByAppLink = z;
    }
}
