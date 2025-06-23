package com.facebook.applinks;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.bolts.AppLink;
import com.facebook.bolts.AppLinkResolver;
import com.facebook.bolts.Continuation;
import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class FacebookAppLinkResolver implements AppLinkResolver {
    private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
    private static final String APP_LINK_KEY = "app_links";
    private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
    private static final String APP_LINK_TARGET_CLASS_KEY = "class";
    private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
    private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
    private static final String APP_LINK_TARGET_URL_KEY = "url";
    private static final String APP_LINK_WEB_TARGET_KEY = "web";
    private final HashMap<Uri, AppLink> cachedAppLinks = new HashMap<>();

    public static /* synthetic */ AppLink.Target access$000(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class)) {
            return null;
        }
        try {
            return getAndroidTargetFromJson(jSONObject);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookAppLinkResolver.class);
            return null;
        }
    }

    public static /* synthetic */ Uri access$100(Uri uri, JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class)) {
            return null;
        }
        try {
            return getWebFallbackUriFromJson(uri, jSONObject);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookAppLinkResolver.class);
            return null;
        }
    }

    public static /* synthetic */ HashMap access$200(FacebookAppLinkResolver facebookAppLinkResolver) {
        if (CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class)) {
            return null;
        }
        try {
            return facebookAppLinkResolver.cachedAppLinks;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookAppLinkResolver.class);
            return null;
        }
    }

    private static AppLink.Target getAndroidTargetFromJson(JSONObject targetJson) {
        Uri uri;
        if (CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class)) {
            return null;
        }
        try {
            String tryGetStringFromJson = tryGetStringFromJson(targetJson, APP_LINK_TARGET_PACKAGE_KEY, null);
            if (tryGetStringFromJson == null) {
                return null;
            }
            String tryGetStringFromJson2 = tryGetStringFromJson(targetJson, "class", null);
            String tryGetStringFromJson3 = tryGetStringFromJson(targetJson, "app_name", null);
            String tryGetStringFromJson4 = tryGetStringFromJson(targetJson, "url", null);
            if (tryGetStringFromJson4 != null) {
                uri = Uri.parse(tryGetStringFromJson4);
            } else {
                uri = null;
            }
            return new AppLink.Target(tryGetStringFromJson, tryGetStringFromJson2, uri, tryGetStringFromJson3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookAppLinkResolver.class);
            return null;
        }
    }

    private static Uri getWebFallbackUriFromJson(Uri sourceUrl, JSONObject urlData) {
        Uri uri = null;
        if (CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class)) {
            return null;
        }
        try {
            JSONObject jSONObject = urlData.getJSONObject("web");
            if (!tryGetBooleanFromJson(jSONObject, APP_LINK_TARGET_SHOULD_FALLBACK_KEY, true)) {
                return null;
            }
            String tryGetStringFromJson = tryGetStringFromJson(jSONObject, "url", null);
            if (tryGetStringFromJson != null) {
                uri = Uri.parse(tryGetStringFromJson);
            }
            if (uri != null) {
                return uri;
            }
            return sourceUrl;
        } catch (JSONException unused) {
            return sourceUrl;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookAppLinkResolver.class);
            return null;
        }
    }

    private static boolean tryGetBooleanFromJson(JSONObject json, String propertyName, boolean defaultValue) {
        if (CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class)) {
            return false;
        }
        try {
            return json.getBoolean(propertyName);
        } catch (JSONException unused) {
            return defaultValue;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookAppLinkResolver.class);
            return false;
        }
    }

    private static String tryGetStringFromJson(JSONObject json, String propertyName, String defaultValue) {
        if (CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class)) {
            return null;
        }
        try {
            return json.getString(propertyName);
        } catch (JSONException unused) {
            return defaultValue;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookAppLinkResolver.class);
            return null;
        }
    }

    @Override // com.facebook.bolts.AppLinkResolver
    public Task<AppLink> getAppLinkFromUrlInBackground(final Uri uri) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(uri);
            return getAppLinkFromUrlsInBackground(arrayList).onSuccess(new Continuation<Map<Uri, AppLink>, AppLink>() { // from class: com.facebook.applinks.FacebookAppLinkResolver.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.facebook.bolts.Continuation
                public AppLink then(Task<Map<Uri, AppLink>> resolveUrisTask) throws Exception {
                    return resolveUrisTask.getResult().get(uri);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public Task<Map<Uri, AppLink>> getAppLinkFromUrlsInBackground(List<Uri> uris) {
        AppLink appLink;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            final HashMap hashMap = new HashMap();
            final HashSet hashSet = new HashSet();
            StringBuilder sb = new StringBuilder();
            for (Uri uri : uris) {
                synchronized (this.cachedAppLinks) {
                    appLink = this.cachedAppLinks.get(uri);
                }
                if (appLink != null) {
                    hashMap.put(uri, appLink);
                } else {
                    if (!hashSet.isEmpty()) {
                        sb.append(',');
                    }
                    sb.append(uri.toString());
                    hashSet.add(uri);
                }
            }
            if (hashSet.isEmpty()) {
                return Task.forResult(hashMap);
            }
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            Bundle bundle = new Bundle();
            bundle.putString("ids", sb.toString());
            bundle.putString(GraphRequest.FIELDS_PARAM, String.format("%s.fields(%s,%s)", APP_LINK_KEY, "android", "web"));
            new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, null, new GraphRequest.Callback() { // from class: com.facebook.applinks.FacebookAppLinkResolver.2
                /* JADX WARN: Removed duplicated region for block: B:17:0x0034 A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #1 {all -> 0x0017, blocks: (B:6:0x0007, B:8:0x000d, B:10:0x001a, B:12:0x0020, B:14:0x0028, B:15:0x002e, B:17:0x0034, B:20:0x0045, B:22:0x0065, B:24:0x006f, B:26:0x0072, B:29:0x0075, B:30:0x0089, B:41:0x0097, B:46:0x0098), top: B:5:0x0007 }] */
                @Override // com.facebook.GraphRequest.Callback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onCompleted(com.facebook.GraphResponse r9) {
                    /*
                        r8 = this;
                        boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r8)
                        if (r0 == 0) goto L7
                        return
                    L7:
                        com.facebook.FacebookRequestError r0 = r9.getError()     // Catch: java.lang.Throwable -> L17
                        if (r0 == 0) goto L1a
                        com.facebook.bolts.TaskCompletionSource r9 = r2     // Catch: java.lang.Throwable -> L17
                        com.facebook.FacebookException r0 = r0.getException()     // Catch: java.lang.Throwable -> L17
                        r9.setError(r0)     // Catch: java.lang.Throwable -> L17
                        return
                    L17:
                        r9 = move-exception
                        goto La0
                    L1a:
                        org.json.JSONObject r9 = r9.getJSONObject()     // Catch: java.lang.Throwable -> L17
                        if (r9 != 0) goto L28
                        com.facebook.bolts.TaskCompletionSource r9 = r2     // Catch: java.lang.Throwable -> L17
                        java.util.Map r0 = r3     // Catch: java.lang.Throwable -> L17
                        r9.setResult(r0)     // Catch: java.lang.Throwable -> L17
                        return
                    L28:
                        java.util.HashSet r0 = r4     // Catch: java.lang.Throwable -> L17
                        java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L17
                    L2e:
                        boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L17
                        if (r1 == 0) goto L98
                        java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L17
                        android.net.Uri r1 = (android.net.Uri) r1     // Catch: java.lang.Throwable -> L17
                        java.lang.String r2 = r1.toString()     // Catch: java.lang.Throwable -> L17
                        boolean r2 = r9.has(r2)     // Catch: java.lang.Throwable -> L17
                        if (r2 != 0) goto L45
                        goto L2e
                    L45:
                        java.lang.String r2 = r1.toString()     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        org.json.JSONObject r2 = r9.getJSONObject(r2)     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        java.lang.String r3 = "app_links"
                        org.json.JSONObject r2 = r2.getJSONObject(r3)     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        java.lang.String r3 = "android"
                        org.json.JSONArray r3 = r2.getJSONArray(r3)     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        int r4 = r3.length()     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        r5.<init>(r4)     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        r6 = 0
                    L63:
                        if (r6 >= r4) goto L75
                        org.json.JSONObject r7 = r3.getJSONObject(r6)     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        com.facebook.bolts.AppLink$Target r7 = com.facebook.applinks.FacebookAppLinkResolver.access$000(r7)     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        if (r7 == 0) goto L72
                        r5.add(r7)     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                    L72:
                        int r6 = r6 + 1
                        goto L63
                    L75:
                        android.net.Uri r2 = com.facebook.applinks.FacebookAppLinkResolver.access$100(r1, r2)     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        com.facebook.bolts.AppLink r3 = new com.facebook.bolts.AppLink     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        r3.<init>(r1, r5, r2)     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        java.util.Map r2 = r3     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        r2.put(r1, r3)     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        com.facebook.applinks.FacebookAppLinkResolver r2 = com.facebook.applinks.FacebookAppLinkResolver.this     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        java.util.HashMap r2 = com.facebook.applinks.FacebookAppLinkResolver.access$200(r2)     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        monitor-enter(r2)     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                        com.facebook.applinks.FacebookAppLinkResolver r4 = com.facebook.applinks.FacebookAppLinkResolver.this     // Catch: java.lang.Throwable -> L95
                        java.util.HashMap r4 = com.facebook.applinks.FacebookAppLinkResolver.access$200(r4)     // Catch: java.lang.Throwable -> L95
                        r4.put(r1, r3)     // Catch: java.lang.Throwable -> L95
                        monitor-exit(r2)     // Catch: java.lang.Throwable -> L95
                        goto L2e
                    L95:
                        r1 = move-exception
                        monitor-exit(r2)     // Catch: java.lang.Throwable -> L95
                        throw r1     // Catch: java.lang.Throwable -> L17 org.json.JSONException -> L2e
                    L98:
                        com.facebook.bolts.TaskCompletionSource r9 = r2     // Catch: java.lang.Throwable -> L17
                        java.util.Map r0 = r3     // Catch: java.lang.Throwable -> L17
                        r9.setResult(r0)     // Catch: java.lang.Throwable -> L17
                        return
                    La0:
                        com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r9, r8)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.applinks.FacebookAppLinkResolver.AnonymousClass2.onCompleted(com.facebook.GraphResponse):void");
                }
            }).executeAsync();
            return taskCompletionSource.getTask();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
