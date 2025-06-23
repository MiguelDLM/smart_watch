package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import com.kuaishou.weapon.p0.g;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes8.dex */
public final class Validate {

    @OXOo.OOXIXo
    private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";

    @OXOo.OOXIXo
    private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";

    @OXOo.OOXIXo
    public static final String CUSTOM_TAB_REDIRECT_URI_PREFIX = "fbconnect://cct.";

    @OXOo.OOXIXo
    private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";

    @OXOo.OOXIXo
    public static final Validate INSTANCE = new Validate();

    @OXOo.OOXIXo
    private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";

    @OXOo.OOXIXo
    private static final String TAG;

    static {
        String name = Validate.class.getName();
        IIX0o.oO(name, "Validate::class.java.name");
        TAG = name;
    }

    private Validate() {
    }

    @XO0OX.x0XOIxOo
    public static final void containsNoNullOrEmpty(@OXOo.OOXIXo Collection<String> container, @OXOo.OOXIXo String name) {
        boolean z;
        IIX0o.x0xO0oo(container, "container");
        IIX0o.x0xO0oo(name, "name");
        for (String str : container) {
            if (str != null) {
                if (str.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException(("Container '" + name + "' cannot contain empty values").toString());
                }
            } else {
                throw new NullPointerException("Container '" + name + "' cannot contain null values");
            }
        }
    }

    @XO0OX.x0XOIxOo
    public static final <T> void containsNoNulls(@OXOo.OOXIXo Collection<? extends T> container, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(container, "container");
        IIX0o.x0xO0oo(name, "name");
        Iterator<? extends T> it = container.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("Container '" + name + "' cannot contain null values");
            }
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String hasAppID() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        if (applicationId != null) {
            return applicationId;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.");
    }

    @XO0OX.x0XOIxOo
    public static final boolean hasBluetoothPermission(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (hasPermission(context, "android.permission.BLUETOOTH") && hasPermission(context, "android.permission.BLUETOOTH_ADMIN")) {
            return true;
        }
        return false;
    }

    @XO0OX.x0XOIxOo
    public static final boolean hasChangeWifiStatePermission(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        return hasPermission(context, "android.permission.CHANGE_WIFI_STATE");
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String hasClientToken() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String clientToken = FacebookSdk.getClientToken();
        if (clientToken != null) {
            return clientToken;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token. Please follow https://developers.facebook.com/docs/android/getting-started/#client-access-token to get the token and fill it in AndroidManifest.xml");
    }

    @XO0OX.x0XOIxOo
    public static final void hasContentProvider(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        String hasAppID = hasAppID();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String XIxXXX0x02 = IIX0o.XIxXXX0x0(CONTENT_PROVIDER_BASE, hasAppID);
            if (packageManager.resolveContentProvider(XIxXXX0x02, 0) == null) {
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format(CONTENT_PROVIDER_NOT_FOUND_REASON, Arrays.copyOf(new Object[]{XIxXXX0x02}, 1));
                IIX0o.oO(format, "java.lang.String.format(format, *args)");
                throw new IllegalStateException(format.toString());
            }
        }
    }

    @XO0OX.x0XOIxOo
    public static final boolean hasCustomTabRedirectActivity(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String redirectURI) {
        List<ResolveInfo> list;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(redirectURI, "redirectURI");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(redirectURI));
            list = packageManager.queryIntentActivities(intent, 64);
        } else {
            list = null;
        }
        if (list == null) {
            return false;
        }
        Iterator<ResolveInfo> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (!IIX0o.Oxx0IOOO(activityInfo.name, "com.facebook.CustomTabActivity") || !IIX0o.Oxx0IOOO(activityInfo.packageName, context.getPackageName())) {
                return false;
            }
            z = true;
        }
        return z;
    }

    @XO0OX.x0XOIxOo
    public static final void hasFacebookActivity(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        hasFacebookActivity(context, true);
    }

    @XO0OX.x0XOIxOo
    public static final void hasInternetPermissions(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        hasInternetPermissions(context, true);
    }

    @XO0OX.x0XOIxOo
    public static final boolean hasLocationPermission(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (!hasPermission(context, g.h) && !hasPermission(context, g.g)) {
            return false;
        }
        return true;
    }

    @XO0OX.x0XOIxOo
    public static final boolean hasPermission(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String permission) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(permission, "permission");
        if (context.checkCallingOrSelfPermission(permission) == 0) {
            return true;
        }
        return false;
    }

    @XO0OX.x0XOIxOo
    public static final boolean hasWiFiPermission(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        return hasPermission(context, g.d);
    }

    @XO0OX.x0XOIxOo
    public static final <T> void notEmpty(@OXOo.OOXIXo Collection<? extends T> container, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(container, "container");
        IIX0o.x0xO0oo(name, "name");
        if (container.isEmpty()) {
            throw new IllegalArgumentException(("Container '" + name + "' cannot be empty").toString());
        }
    }

    @XO0OX.x0XOIxOo
    public static final <T> void notEmptyAndContainsNoNulls(@OXOo.OOXIXo Collection<? extends T> container, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(container, "container");
        IIX0o.x0xO0oo(name, "name");
        containsNoNulls(container, name);
        notEmpty(container, name);
    }

    @XO0OX.x0XOIxOo
    public static final void notNull(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        if (obj != null) {
            return;
        }
        throw new NullPointerException("Argument '" + name + "' cannot be null");
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String notNullOrEmpty(@OXOo.oOoXoXO String str, @OXOo.OOXIXo String name) {
        boolean z;
        IIX0o.x0xO0oo(name, "name");
        if (str != null && str.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return str;
        }
        throw new IllegalArgumentException(("Argument '" + name + "' cannot be null or empty").toString());
    }

    @XO0OX.x0XOIxOo
    public static final void oneOf(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo String name, @OXOo.OOXIXo Object... values) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(values, "values");
        int length = values.length;
        int i = 0;
        while (i < length) {
            Object obj2 = values[i];
            i++;
            if (IIX0o.Oxx0IOOO(obj2, obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("Argument '" + name + "' was not one of the allowed values");
    }

    @XO0OX.x0XOIxOo
    public static final void runningOnUiThread() {
        if (IIX0o.Oxx0IOOO(Looper.getMainLooper(), Looper.myLooper())) {
        } else {
            throw new FacebookException("This method should be called from the UI thread");
        }
    }

    @XO0OX.x0XOIxOo
    public static final void sdkInitialized() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isInitialized()) {
        } else {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @XO0OX.x0XOIxOo
    @android.annotation.SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void hasFacebookActivity(@OXOo.OOXIXo android.content.Context r3, boolean r4) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            android.content.pm.PackageManager r0 = r3.getPackageManager()
            if (r0 == 0) goto L18
            android.content.ComponentName r1 = new android.content.ComponentName
            java.lang.String r2 = "com.facebook.FacebookActivity"
            r1.<init>(r3, r2)
            r3 = 1
            android.content.pm.ActivityInfo r3 = r0.getActivityInfo(r1, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L18
            goto L19
        L18:
            r3 = 0
        L19:
            if (r3 != 0) goto L2b
            java.lang.String r3 = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info."
            if (r4 != 0) goto L25
            java.lang.String r4 = com.facebook.internal.Validate.TAG
            android.util.Log.w(r4, r3)
            goto L2b
        L25:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            r4.<init>(r3)
            throw r4
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Validate.hasFacebookActivity(android.content.Context, boolean):void");
    }

    @XO0OX.x0XOIxOo
    public static final void hasInternetPermissions(@OXOo.OOXIXo Context context, boolean z) {
        IIX0o.x0xO0oo(context, "context");
        if (context.checkCallingOrSelfPermission(g.f18396a) == -1) {
            if (!z) {
                Log.w(TAG, NO_INTERNET_PERMISSION_REASON);
                return;
            }
            throw new IllegalStateException(NO_INTERNET_PERMISSION_REASON);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void notEmpty(@OXOo.OOXIXo String arg, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(arg, "arg");
        IIX0o.x0xO0oo(name, "name");
        if (arg.length() > 0) {
            return;
        }
        throw new IllegalArgumentException(("Argument '" + name + "' cannot be empty").toString());
    }
}
