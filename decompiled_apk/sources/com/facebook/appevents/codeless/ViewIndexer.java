package com.facebook.appevents.codeless;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.annotation.RestrictTo;
import com.baidu.ar.statistic.StatisticConstants;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class ViewIndexer {

    @OOXIXo
    private static final String APP_VERSION_PARAM = "app_version";

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String PLATFORM_PARAM = "platform";

    @OOXIXo
    private static final String REQUEST_TYPE = "request_type";

    @OOXIXo
    private static final String SUCCESS = "success";

    @OOXIXo
    private static final String TAG;

    @OOXIXo
    private static final String TREE_PARAM = "tree";

    @oOoXoXO
    private static ViewIndexer instance;

    @OOXIXo
    private final WeakReference<Activity> activityReference;

    @oOoXoXO
    private Timer indexingTimer;

    @oOoXoXO
    private String previousDigest;

    @OOXIXo
    private final Handler uiThreadHandler;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildAppIndexingRequest$lambda-0, reason: not valid java name */
        public static final void m156buildAppIndexingRequest$lambda0(GraphResponse it) {
            IIX0o.x0xO0oo(it, "it");
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, ViewIndexer.access$getTAG$cp(), "App index sent to FB!");
        }

        @x0XOIxOo
        @oOoXoXO
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final GraphRequest buildAppIndexingRequest(@oOoXoXO String str, @oOoXoXO AccessToken accessToken, @oOoXoXO String str2, @OOXIXo String requestType) {
            IIX0o.x0xO0oo(requestType, "requestType");
            if (str == null) {
                return null;
            }
            GraphRequest.Companion companion = GraphRequest.Companion;
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format(Locale.US, "%s/app_indexing", Arrays.copyOf(new Object[]{str2}, 1));
            IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
            GraphRequest newPostRequest = companion.newPostRequest(accessToken, format, null, null);
            Bundle parameters = newPostRequest.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            parameters.putString(ViewIndexer.TREE_PARAM, str);
            AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
            parameters.putString("app_version", AppEventUtility.getAppVersion());
            parameters.putString("platform", "android");
            parameters.putString(ViewIndexer.REQUEST_TYPE, requestType);
            if (IIX0o.Oxx0IOOO(requestType, Constants.APP_INDEXING)) {
                CodelessManager codelessManager = CodelessManager.INSTANCE;
                parameters.putString(Constants.DEVICE_SESSION_ID, CodelessManager.getCurrentDeviceSessionID$facebook_core_release());
            }
            newPostRequest.setParameters(parameters);
            newPostRequest.setCallback(new GraphRequest.Callback() { // from class: com.facebook.appevents.codeless.Oxx0IOOO
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    ViewIndexer.Companion.m156buildAppIndexingRequest$lambda0(graphResponse);
                }
            });
            return newPostRequest;
        }

        @x0XOIxOo
        public final void sendToServerUnityInstance(@OOXIXo String tree) {
            IIX0o.x0xO0oo(tree, "tree");
            ViewIndexer access$getInstance$cp = ViewIndexer.access$getInstance$cp();
            if (access$getInstance$cp != null) {
                ViewIndexer.access$sendToServer(access$getInstance$cp, tree);
            }
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class ScreenshotTaker implements Callable<String> {

        @OOXIXo
        private final WeakReference<View> rootView;

        public ScreenshotTaker(@OOXIXo View rootView) {
            IIX0o.x0xO0oo(rootView, "rootView");
            this.rootView = new WeakReference<>(rootView);
        }

        @Override // java.util.concurrent.Callable
        @OOXIXo
        public String call() {
            View view = this.rootView.get();
            if (view != null && view.getWidth() != 0 && view.getHeight() != 0) {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                view.draw(new Canvas(createBitmap));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                IIX0o.oO(encodeToString, "encodeToString(outputStream.toByteArray(), Base64.NO_WRAP)");
                return encodeToString;
            }
            return "";
        }
    }

    static {
        String canonicalName = ViewIndexer.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "";
        }
        TAG = canonicalName;
    }

    public ViewIndexer(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        this.activityReference = new WeakReference<>(activity);
        this.previousDigest = null;
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        instance = this;
    }

    public static final /* synthetic */ WeakReference access$getActivityReference$p(ViewIndexer viewIndexer) {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return null;
        }
        try {
            return viewIndexer.activityReference;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
            return null;
        }
    }

    public static final /* synthetic */ ViewIndexer access$getInstance$cp() {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
            return null;
        }
    }

    public static final /* synthetic */ Handler access$getUiThreadHandler$p(ViewIndexer viewIndexer) {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return null;
        }
        try {
            return viewIndexer.uiThreadHandler;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$sendToServer(ViewIndexer viewIndexer, String str) {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return;
        }
        try {
            viewIndexer.sendToServer(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
        }
    }

    @x0XOIxOo
    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final GraphRequest buildAppIndexingRequest(@oOoXoXO String str, @oOoXoXO AccessToken accessToken, @oOoXoXO String str2, @OOXIXo String str3) {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return null;
        }
        try {
            return Companion.buildAppIndexingRequest(str, accessToken, str2, str3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: schedule$lambda-0, reason: not valid java name */
    public static final void m154schedule$lambda0(ViewIndexer this$0, TimerTask indexingTask) {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(indexingTask, "$indexingTask");
            try {
                Timer timer = this$0.indexingTimer;
                if (timer != null) {
                    timer.cancel();
                }
                this$0.previousDigest = null;
                Timer timer2 = new Timer();
                timer2.scheduleAtFixedRate(indexingTask, 0L, 1000L);
                this$0.indexingTimer = timer2;
            } catch (Exception e) {
                Log.e(TAG, "Error scheduling indexing job", e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
        }
    }

    private final void sendToServer(final String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.codeless.XO
                @Override // java.lang.Runnable
                public final void run() {
                    ViewIndexer.m155sendToServer$lambda1(str, this);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendToServer$lambda-1, reason: not valid java name */
    public static final void m155sendToServer$lambda1(String tree, ViewIndexer this$0) {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(tree, "$tree");
            IIX0o.x0xO0oo(this$0, "this$0");
            Utility utility = Utility.INSTANCE;
            String md5hash = Utility.md5hash(tree);
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            if (md5hash != null && IIX0o.Oxx0IOOO(md5hash, this$0.previousDigest)) {
                return;
            }
            Companion companion = Companion;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            this$0.processRequest(companion.buildAppIndexingRequest(tree, currentAccessToken, FacebookSdk.getApplicationId(), Constants.APP_INDEXING), md5hash);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
        }
    }

    @x0XOIxOo
    public static final void sendToServerUnityInstance(@OOXIXo String str) {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return;
        }
        try {
            Companion.sendToServerUnityInstance(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
        }
    }

    public final void processRequest(@oOoXoXO GraphRequest graphRequest, @oOoXoXO String str) {
        if (CrashShieldHandler.isObjectCrashing(this) || graphRequest == null) {
            return;
        }
        try {
            GraphResponse executeAndWait = graphRequest.executeAndWait();
            try {
                JSONObject jSONObject = executeAndWait.getJSONObject();
                if (jSONObject != null) {
                    if (IIX0o.Oxx0IOOO("true", jSONObject.optString("success"))) {
                        Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "Successfully send UI component tree to server");
                        this.previousDigest = str;
                    }
                    if (jSONObject.has(Constants.APP_INDEXING_ENABLED)) {
                        boolean z = jSONObject.getBoolean(Constants.APP_INDEXING_ENABLED);
                        CodelessManager codelessManager = CodelessManager.INSTANCE;
                        CodelessManager.updateAppIndexing$facebook_core_release(z);
                        return;
                    }
                    return;
                }
                Log.e(TAG, IIX0o.XIxXXX0x0("Error sending UI component tree to Facebook: ", executeAndWait.getError()));
            } catch (JSONException e) {
                Log.e(TAG, "Error decoding server response.", e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void schedule() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            final TimerTask timerTask = new TimerTask() { // from class: com.facebook.appevents.codeless.ViewIndexer$schedule$indexingTask$1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    try {
                        Activity activity = (Activity) ViewIndexer.access$getActivityReference$p(ViewIndexer.this).get();
                        AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                        View rootView = AppEventUtility.getRootView(activity);
                        if (activity != null && rootView != null) {
                            String simpleName = activity.getClass().getSimpleName();
                            IIX0o.oO(simpleName, "activity.javaClass.simpleName");
                            CodelessManager codelessManager = CodelessManager.INSTANCE;
                            if (!CodelessManager.getIsAppIndexingEnabled$facebook_core_release()) {
                                return;
                            }
                            InternalSettings internalSettings = InternalSettings.INSTANCE;
                            if (InternalSettings.isUnityApp()) {
                                UnityReflection unityReflection = UnityReflection.INSTANCE;
                                UnityReflection.captureViewHierarchy();
                                return;
                            }
                            FutureTask futureTask = new FutureTask(new ViewIndexer.ScreenshotTaker(rootView));
                            ViewIndexer.access$getUiThreadHandler$p(ViewIndexer.this).post(futureTask);
                            String str = "";
                            try {
                                str = (String) futureTask.get(1L, TimeUnit.SECONDS);
                            } catch (Exception e) {
                                Log.e(ViewIndexer.access$getTAG$cp(), "Failed to take screenshot.", e);
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(ViewHierarchyConstants.SCREEN_NAME_KEY, simpleName);
                                jSONObject.put(StatisticConstants.SCREENSHOT, str);
                                JSONArray jSONArray = new JSONArray();
                                ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                                jSONArray.put(ViewHierarchy.getDictionaryOfView(rootView));
                                jSONObject.put(ViewHierarchyConstants.VIEW_KEY, jSONArray);
                            } catch (JSONException unused) {
                                Log.e(ViewIndexer.access$getTAG$cp(), "Failed to create JSONObject");
                            }
                            String jSONObject2 = jSONObject.toString();
                            IIX0o.oO(jSONObject2, "viewTree.toString()");
                            ViewIndexer.access$sendToServer(ViewIndexer.this, jSONObject2);
                        }
                    } catch (Exception e2) {
                        Log.e(ViewIndexer.access$getTAG$cp(), "UI Component tree indexing failure!", e2);
                    }
                }
            };
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.codeless.X0o0xo
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewIndexer.m154schedule$lambda0(ViewIndexer.this, timerTask);
                    }
                });
            } catch (RejectedExecutionException e) {
                Log.e(TAG, "Error scheduling indexing job", e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void unschedule() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (this.activityReference.get() == null) {
                return;
            }
            try {
                Timer timer = this.indexingTimer;
                if (timer != null) {
                    timer.cancel();
                }
                this.indexingTimer = null;
            } catch (Exception e) {
                Log.e(TAG, "Error unscheduling indexing job", e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
