package com.facebook.messenger;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.bolts.AppLinks;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.messenger.MessengerThreadParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes8.dex */
public class MessengerUtils {
    public static final String EXTRA_APP_ID = "com.facebook.orca.extra.APPLICATION_ID";
    public static final String EXTRA_EXTERNAL_URI = "com.facebook.orca.extra.EXTERNAL_URI";
    public static final String EXTRA_IS_COMPOSE = "com.facebook.orca.extra.IS_COMPOSE";
    public static final String EXTRA_IS_REPLY = "com.facebook.orca.extra.IS_REPLY";
    public static final String EXTRA_METADATA = "com.facebook.orca.extra.METADATA";
    public static final String EXTRA_PARTICIPANTS = "com.facebook.orca.extra.PARTICIPANTS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.orca.extra.PROTOCOL_VERSION";
    public static final String EXTRA_REPLY_TOKEN_KEY = "com.facebook.orca.extra.REPLY_TOKEN";
    public static final String EXTRA_THREAD_TOKEN_KEY = "com.facebook.orca.extra.THREAD_TOKEN";
    public static final String ORCA_THREAD_CATEGORY_20150314 = "com.facebook.orca.category.PLATFORM_THREAD_20150314";
    public static final String PACKAGE_NAME = "com.facebook.orca";
    public static final int PROTOCOL_VERSION_20150314 = 20150314;
    private static final String TAG = "MessengerUtils";

    public static void finishShareToMessenger(Activity activity, ShareToMessengerParams shareToMessengerParams) {
        Intent intent = activity.getIntent();
        Set<String> categories = intent.getCategories();
        if (categories == null) {
            activity.setResult(0, null);
            activity.finish();
            return;
        }
        if (categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
            Bundle appLinkExtras = AppLinks.getAppLinkExtras(intent);
            Intent intent2 = new Intent();
            if (categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
                intent2.putExtra(EXTRA_PROTOCOL_VERSION, PROTOCOL_VERSION_20150314);
                intent2.putExtra(EXTRA_THREAD_TOKEN_KEY, appLinkExtras.getString(EXTRA_THREAD_TOKEN_KEY));
                intent2.setDataAndType(shareToMessengerParams.uri, shareToMessengerParams.mimeType);
                intent2.setFlags(1);
                intent2.putExtra(EXTRA_APP_ID, FacebookSdk.getApplicationId());
                intent2.putExtra(EXTRA_METADATA, shareToMessengerParams.metaData);
                intent2.putExtra(EXTRA_EXTERNAL_URI, shareToMessengerParams.externalUri);
                activity.setResult(-1, intent2);
                activity.finish();
                return;
            }
            throw new RuntimeException();
        }
        activity.setResult(0, null);
        activity.finish();
    }

    private static Set<Integer> getAllAvailableProtocolVersions(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        HashSet hashSet = new HashSet();
        Cursor query = contentResolver.query(Uri.parse("content://com.facebook.orca.provider.MessengerPlatformProvider/versions"), new String[]{"version"}, null, null, null);
        if (query != null) {
            try {
                int columnIndex = query.getColumnIndex("version");
                while (query.moveToNext()) {
                    hashSet.add(Integer.valueOf(query.getInt(columnIndex)));
                }
            } finally {
                query.close();
            }
        }
        return hashSet;
    }

    public static MessengerThreadParams getMessengerThreadParamsForIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(MessengerUtils.class)) {
            return null;
        }
        try {
            Set<String> categories = intent.getCategories();
            if (categories == null || !categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
                return null;
            }
            Bundle appLinkExtras = AppLinks.getAppLinkExtras(intent);
            String string = appLinkExtras.getString(EXTRA_THREAD_TOKEN_KEY);
            String string2 = appLinkExtras.getString(EXTRA_METADATA);
            String string3 = appLinkExtras.getString(EXTRA_PARTICIPANTS);
            boolean z = appLinkExtras.getBoolean(EXTRA_IS_REPLY);
            boolean z2 = appLinkExtras.getBoolean(EXTRA_IS_COMPOSE);
            MessengerThreadParams.Origin origin = MessengerThreadParams.Origin.UNKNOWN;
            if (z) {
                origin = MessengerThreadParams.Origin.REPLY_FLOW;
            } else if (z2) {
                origin = MessengerThreadParams.Origin.COMPOSE_FLOW;
            }
            return new MessengerThreadParams(origin, string, string2, parseParticipants(string3));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerUtils.class);
            return null;
        }
    }

    public static boolean hasMessengerInstalled(Context context) {
        return FacebookSignatureValidator.validateSignature(context, "com.facebook.orca");
    }

    public static void openMessengerInPlayStore(Context context) {
        if (CrashShieldHandler.isObjectCrashing(MessengerUtils.class)) {
            return;
        }
        try {
            try {
                startViewUri(context, "market://details?id=com.facebook.orca");
            } catch (ActivityNotFoundException unused) {
                startViewUri(context, "http://play.google.com/store/apps/details?id=com.facebook.orca");
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerUtils.class);
        }
    }

    private static List<String> parseParticipants(String s) {
        if (s != null && s.length() != 0) {
            String[] split = s.split(",");
            ArrayList arrayList = new ArrayList();
            for (String str : split) {
                arrayList.add(str.trim());
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public static void shareToMessenger(Activity activity, int requestCode, ShareToMessengerParams shareToMessengerParams) {
        if (CrashShieldHandler.isObjectCrashing(MessengerUtils.class)) {
            return;
        }
        try {
            if (!hasMessengerInstalled(activity)) {
                openMessengerInPlayStore(activity);
            } else if (getAllAvailableProtocolVersions(activity).contains(Integer.valueOf(PROTOCOL_VERSION_20150314))) {
                shareToMessenger20150314(activity, requestCode, shareToMessengerParams);
            } else {
                openMessengerInPlayStore(activity);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerUtils.class);
        }
    }

    private static void shareToMessenger20150314(Activity activity, int requestCode, ShareToMessengerParams shareToMessengerParams) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setFlags(1);
            intent.setPackage("com.facebook.orca");
            intent.putExtra("android.intent.extra.STREAM", shareToMessengerParams.uri);
            intent.setType(shareToMessengerParams.mimeType);
            String applicationId = FacebookSdk.getApplicationId();
            if (applicationId != null) {
                intent.putExtra(EXTRA_PROTOCOL_VERSION, PROTOCOL_VERSION_20150314);
                intent.putExtra(EXTRA_APP_ID, applicationId);
                intent.putExtra(EXTRA_METADATA, shareToMessengerParams.metaData);
                intent.putExtra(EXTRA_EXTERNAL_URI, shareToMessengerParams.externalUri);
            }
            activity.startActivityForResult(intent, requestCode);
        } catch (ActivityNotFoundException unused) {
            activity.startActivity(activity.getPackageManager().getLaunchIntentForPackage("com.facebook.orca"));
        }
    }

    private static void startViewUri(Context context, String uri) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(uri)));
    }
}
