package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.VisibleForTesting;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.common.R;
import com.facebook.internal.WebDialog;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginTargetApp;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class WebDialog extends Dialog {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int BACKGROUND_GRAY = -872415232;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_THEME = R.style.com_facebook_activity_theme;
    public static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;

    @OXOo.OOXIXo
    private static final String DISPLAY_TOUCH = "touch";

    @OXOo.OOXIXo
    private static final String LOG_TAG = "FacebookSDK.WebDialog";
    private static final int MAX_PADDING_SCREEN_HEIGHT = 1280;
    private static final int MAX_PADDING_SCREEN_WIDTH = 800;
    private static final double MIN_SCALE_FACTOR = 0.5d;
    private static final int NO_PADDING_SCREEN_HEIGHT = 800;
    private static final int NO_PADDING_SCREEN_WIDTH = 480;

    @OXOo.OOXIXo
    private static final String PLATFORM_DIALOG_PATH_REGEX = "^/(v\\d+\\.\\d+/)??dialog/.*";

    @OXOo.oOoXoXO
    private static InitCallback initCallback;
    private static volatile int webDialogTheme;

    @OXOo.oOoXoXO
    private FrameLayout contentFrameLayout;

    @OXOo.oOoXoXO
    private ImageView crossImageView;

    @OXOo.OOXIXo
    private String expectedRedirectUrl;
    private boolean isDetached;
    private boolean isListenerCalled;
    private boolean isPageFinished;

    @OXOo.oOoXoXO
    private OnCompleteListener onCompleteListener;

    @OXOo.oOoXoXO
    private ProgressDialog spinner;

    @OXOo.oOoXoXO
    private UploadStagingResourcesTask uploadTask;

    @OXOo.oOoXoXO
    private String url;

    @OXOo.oOoXoXO
    private WebView webView;

    @OXOo.oOoXoXO
    private WindowManager.LayoutParams windowParams;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        public final int getWebDialogTheme() {
            Validate validate = Validate.INSTANCE;
            Validate.sdkInitialized();
            return WebDialog.webDialogTheme;
        }

        @XO0OX.x0XOIxOo
        public final void initDefaultTheme(@OXOo.oOoXoXO Context context) {
            Bundle bundle;
            if (context == null) {
                return;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo == null) {
                    bundle = null;
                } else {
                    bundle = applicationInfo.metaData;
                }
                if (bundle != null && WebDialog.webDialogTheme == 0) {
                    setWebDialogTheme(applicationInfo.metaData.getInt(FacebookSdk.WEB_DIALOG_THEME));
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final WebDialog newInstance(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle, int i, @OXOo.oOoXoXO OnCompleteListener onCompleteListener) {
            IIX0o.x0xO0oo(context, "context");
            WebDialog.initDefaultTheme(context);
            return new WebDialog(context, str, bundle, i, LoginTargetApp.FACEBOOK, onCompleteListener, null);
        }

        @XO0OX.x0XOIxOo
        public final void setInitCallback(@OXOo.oOoXoXO InitCallback initCallback) {
            WebDialog.initCallback = initCallback;
        }

        @XO0OX.x0XOIxOo
        public final void setWebDialogTheme(int i) {
            if (i == 0) {
                i = WebDialog.DEFAULT_THEME;
            }
            WebDialog.webDialogTheme = i;
        }

        private Companion() {
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final WebDialog newInstance(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle, int i, @OXOo.OOXIXo LoginTargetApp targetApp, @OXOo.oOoXoXO OnCompleteListener onCompleteListener) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(targetApp, "targetApp");
            WebDialog.initDefaultTheme(context);
            return new WebDialog(context, str, bundle, i, targetApp, onCompleteListener, null);
        }
    }

    /* loaded from: classes8.dex */
    public final class DialogWebViewClient extends WebViewClient {
        final /* synthetic */ WebDialog this$0;

        public DialogWebViewClient(WebDialog this$0) {
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@OXOo.OOXIXo WebView view, @OXOo.OOXIXo String url) {
            ProgressDialog progressDialog;
            IIX0o.x0xO0oo(view, "view");
            IIX0o.x0xO0oo(url, "url");
            super.onPageFinished(view, url);
            if (!this.this$0.isDetached && (progressDialog = this.this$0.spinner) != null) {
                progressDialog.dismiss();
            }
            FrameLayout frameLayout = this.this$0.contentFrameLayout;
            if (frameLayout != null) {
                frameLayout.setBackgroundColor(0);
            }
            WebView webView = this.this$0.getWebView();
            if (webView != null) {
                webView.setVisibility(0);
            }
            ImageView imageView = this.this$0.crossImageView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            this.this$0.isPageFinished = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@OXOo.OOXIXo WebView view, @OXOo.OOXIXo String url, @OXOo.oOoXoXO Bitmap bitmap) {
            ProgressDialog progressDialog;
            IIX0o.x0xO0oo(view, "view");
            IIX0o.x0xO0oo(url, "url");
            Utility utility = Utility.INSTANCE;
            Utility.logd(WebDialog.LOG_TAG, IIX0o.XIxXXX0x0("Webview loading URL: ", url));
            super.onPageStarted(view, url, bitmap);
            if (!this.this$0.isDetached && (progressDialog = this.this$0.spinner) != null) {
                progressDialog.show();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@OXOo.OOXIXo WebView view, int i, @OXOo.OOXIXo String description, @OXOo.OOXIXo String failingUrl) {
            IIX0o.x0xO0oo(view, "view");
            IIX0o.x0xO0oo(description, "description");
            IIX0o.x0xO0oo(failingUrl, "failingUrl");
            super.onReceivedError(view, i, description, failingUrl);
            this.this$0.sendErrorToListener(new FacebookDialogException(description, i, failingUrl));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(@OXOo.OOXIXo WebView view, @OXOo.OOXIXo SslErrorHandler handler, @OXOo.OOXIXo SslError error) {
            IIX0o.x0xO0oo(view, "view");
            IIX0o.x0xO0oo(handler, "handler");
            IIX0o.x0xO0oo(error, "error");
            super.onReceivedSslError(view, handler, error);
            handler.cancel();
            this.this$0.sendErrorToListener(new FacebookDialogException(null, -11, null));
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00ba  */
        @Override // android.webkit.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean shouldOverrideUrlLoading(@OXOo.OOXIXo android.webkit.WebView r6, @OXOo.OOXIXo java.lang.String r7) {
            /*
                Method dump skipped, instructions count: 252
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WebDialog.DialogWebViewClient.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }
    }

    /* loaded from: classes8.dex */
    public interface InitCallback {
        void onInit(@OXOo.oOoXoXO WebView webView);
    }

    /* loaded from: classes8.dex */
    public interface OnCompleteListener {
        void onComplete(@OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO FacebookException facebookException);
    }

    /* loaded from: classes8.dex */
    public final class UploadStagingResourcesTask extends AsyncTask<Void, Void, String[]> {

        @OXOo.OOXIXo
        private final String action;

        @OXOo.OOXIXo
        private Exception[] exceptions;

        @OXOo.OOXIXo
        private final Bundle parameters;
        final /* synthetic */ WebDialog this$0;

        public UploadStagingResourcesTask(@OXOo.OOXIXo WebDialog this$0, @OXOo.OOXIXo String action, Bundle parameters) {
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(action, "action");
            IIX0o.x0xO0oo(parameters, "parameters");
            this.this$0 = this$0;
            this.action = action;
            this.parameters = parameters;
            this.exceptions = new Exception[0];
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: doInBackground$lambda-0, reason: not valid java name */
        public static final void m218doInBackground$lambda0(String[] results, int i, UploadStagingResourcesTask this$0, CountDownLatch latch, GraphResponse response) {
            FacebookRequestError error;
            String str;
            IIX0o.x0xO0oo(results, "$results");
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(latch, "$latch");
            IIX0o.x0xO0oo(response, "response");
            try {
                error = response.getError();
                str = "Error staging photo.";
            } catch (Exception e) {
                this$0.exceptions[i] = e;
            }
            if (error != null) {
                String errorMessage = error.getErrorMessage();
                if (errorMessage != null) {
                    str = errorMessage;
                }
                throw new FacebookGraphResponseException(response, str);
            }
            JSONObject jSONObject = response.getJSONObject();
            if (jSONObject != null) {
                String optString = jSONObject.optString("uri");
                if (optString != null) {
                    results[i] = optString;
                    latch.countDown();
                    return;
                }
                throw new FacebookException("Error staging photo.");
            }
            throw new FacebookException("Error staging photo.");
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ String[] doInBackground(Void[] voidArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return doInBackground2(voidArr);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(String[] strArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                onPostExecute2(strArr);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }

        @OXOo.oOoXoXO
        /* renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public String[] doInBackground2(@OXOo.OOXIXo Void... p0) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                IIX0o.x0xO0oo(p0, "p0");
                String[] stringArray = this.parameters.getStringArray(ShareConstants.WEB_DIALOG_PARAM_MEDIA);
                if (stringArray == null) {
                    return null;
                }
                final String[] strArr = new String[stringArray.length];
                this.exceptions = new Exception[stringArray.length];
                final CountDownLatch countDownLatch = new CountDownLatch(stringArray.length);
                ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
                try {
                    int length = stringArray.length - 1;
                    if (length >= 0) {
                        final int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            if (isCancelled()) {
                                Iterator it = concurrentLinkedQueue.iterator();
                                while (it.hasNext()) {
                                    ((GraphRequestAsyncTask) it.next()).cancel(true);
                                }
                                return null;
                            }
                            Uri uri = Uri.parse(stringArray[i]);
                            Utility utility = Utility.INSTANCE;
                            if (Utility.isWebUri(uri)) {
                                strArr[i] = uri.toString();
                                countDownLatch.countDown();
                            } else {
                                GraphRequest.Callback callback = new GraphRequest.Callback() { // from class: com.facebook.internal.X0IIOO
                                    @Override // com.facebook.GraphRequest.Callback
                                    public final void onCompleted(GraphResponse graphResponse) {
                                        WebDialog.UploadStagingResourcesTask.m218doInBackground$lambda0(strArr, i, this, countDownLatch, graphResponse);
                                    }
                                };
                                ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
                                IIX0o.oO(uri, "uri");
                                concurrentLinkedQueue.add(ShareInternalUtility.newUploadStagingResourceWithImageRequest(currentAccessToken, uri, callback).executeAsync());
                            }
                            if (i2 > length) {
                                break;
                            }
                            i = i2;
                        }
                    }
                    countDownLatch.await();
                    return strArr;
                } catch (Exception unused) {
                    Iterator it2 = concurrentLinkedQueue.iterator();
                    while (it2.hasNext()) {
                        ((GraphRequestAsyncTask) it2.next()).cancel(true);
                    }
                    return null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        /* renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        public void onPostExecute2(@OXOo.oOoXoXO String[] strArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                ProgressDialog progressDialog = this.this$0.spinner;
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                Exception[] excArr = this.exceptions;
                int length = excArr.length;
                int i = 0;
                while (i < length) {
                    Exception exc = excArr[i];
                    i++;
                    if (exc != null) {
                        this.this$0.sendErrorToListener(exc);
                        return;
                    }
                }
                if (strArr == null) {
                    this.this$0.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                    return;
                }
                List oI0IIXIo2 = kotlin.collections.ooOOo0oXI.oI0IIXIo(strArr);
                if (oI0IIXIo2.contains(null)) {
                    this.this$0.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                    return;
                }
                Utility utility = Utility.INSTANCE;
                Utility.putJSONValueInBundle(this.parameters, ShareConstants.WEB_DIALOG_PARAM_MEDIA, new JSONArray((Collection) oI0IIXIo2));
                ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
                String dialogAuthority = ServerProtocol.getDialogAuthority();
                StringBuilder sb = new StringBuilder();
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                sb.append(FacebookSdk.getGraphApiVersion());
                sb.append("/dialog/");
                sb.append(this.action);
                Uri buildUri = Utility.buildUri(dialogAuthority, sb.toString(), this.parameters);
                this.this$0.url = buildUri.toString();
                ImageView imageView = this.this$0.crossImageView;
                if (imageView != null) {
                    this.this$0.setUpWebView((imageView.getDrawable().getIntrinsicWidth() / 2) + 1);
                    return;
                }
                throw new IllegalStateException("Required value was null.");
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* loaded from: classes8.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginTargetApp.valuesCustom().length];
            iArr[LoginTargetApp.INSTAGRAM.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ WebDialog(Context context, String str, Bundle bundle, int i, LoginTargetApp loginTargetApp, OnCompleteListener onCompleteListener, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(context, str, bundle, i, loginTargetApp, onCompleteListener);
    }

    private final void createCrossImage() {
        ImageView imageView = new ImageView(getContext());
        this.crossImageView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.internal.OxI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebDialog.m215createCrossImage$lambda5(WebDialog.this, view);
            }
        });
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.com_facebook_close);
        ImageView imageView2 = this.crossImageView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
        ImageView imageView3 = this.crossImageView;
        if (imageView3 != null) {
            imageView3.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createCrossImage$lambda-5, reason: not valid java name */
    public static final void m215createCrossImage$lambda5(WebDialog this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.cancel();
    }

    private final int getScaledSize(int i, float f, int i2, int i3) {
        int i4 = (int) (i / f);
        return (int) (i * (i4 <= i2 ? 1.0d : i4 >= i3 ? 0.5d : (((i3 - i4) / (i3 - i2)) * 0.5d) + 0.5d));
    }

    @XO0OX.x0XOIxOo
    public static final int getWebDialogTheme() {
        return Companion.getWebDialogTheme();
    }

    @XO0OX.x0XOIxOo
    public static final void initDefaultTheme(@OXOo.oOoXoXO Context context) {
        Companion.initDefaultTheme(context);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final WebDialog newInstance(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle, int i, @OXOo.oOoXoXO OnCompleteListener onCompleteListener) {
        return Companion.newInstance(context, str, bundle, i, onCompleteListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-4, reason: not valid java name */
    public static final void m216onCreate$lambda4(WebDialog this$0, DialogInterface dialogInterface) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.cancel();
    }

    @XO0OX.x0XOIxOo
    public static final void setInitCallback(@OXOo.oOoXoXO InitCallback initCallback2) {
        Companion.setInitCallback(initCallback2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled"})
    public final void setUpWebView(int i) {
        WebSettings settings;
        WebSettings settings2;
        LinearLayout linearLayout = new LinearLayout(getContext());
        final Context context = getContext();
        this.webView = new WebView(context) { // from class: com.facebook.internal.WebDialog$setUpWebView$1
            @Override // android.webkit.WebView, android.view.View
            public void onWindowFocusChanged(boolean z) {
                try {
                    super.onWindowFocusChanged(z);
                } catch (NullPointerException unused) {
                }
            }
        };
        InitCallback initCallback2 = initCallback;
        if (initCallback2 != null) {
            initCallback2.onInit(getWebView());
        }
        WebView webView = this.webView;
        if (webView != null) {
            webView.setVerticalScrollBarEnabled(false);
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setHorizontalScrollBarEnabled(false);
        }
        WebView webView3 = this.webView;
        if (webView3 != null) {
            webView3.setWebViewClient(new DialogWebViewClient(this));
        }
        WebView webView4 = this.webView;
        WebSettings webSettings = null;
        if (webView4 == null) {
            settings = null;
        } else {
            settings = webView4.getSettings();
        }
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
        }
        WebView webView5 = this.webView;
        if (webView5 != null) {
            String str = this.url;
            if (str != null) {
                webView5.loadUrl(str);
            } else {
                throw new IllegalStateException("Required value was null.");
            }
        }
        WebView webView6 = this.webView;
        if (webView6 != null) {
            webView6.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        WebView webView7 = this.webView;
        if (webView7 != null) {
            webView7.setVisibility(4);
        }
        WebView webView8 = this.webView;
        if (webView8 == null) {
            settings2 = null;
        } else {
            settings2 = webView8.getSettings();
        }
        if (settings2 != null) {
            settings2.setSavePassword(false);
        }
        WebView webView9 = this.webView;
        if (webView9 != null) {
            webSettings = webView9.getSettings();
        }
        if (webSettings != null) {
            webSettings.setSaveFormData(false);
        }
        WebView webView10 = this.webView;
        if (webView10 != null) {
            webView10.setFocusable(true);
        }
        WebView webView11 = this.webView;
        if (webView11 != null) {
            webView11.setFocusableInTouchMode(true);
        }
        WebView webView12 = this.webView;
        if (webView12 != null) {
            webView12.setOnTouchListener(new View.OnTouchListener() { // from class: com.facebook.internal.o00
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean m217setUpWebView$lambda7;
                    m217setUpWebView$lambda7 = WebDialog.m217setUpWebView$lambda7(view, motionEvent);
                    return m217setUpWebView$lambda7;
                }
            });
        }
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.webView);
        linearLayout.setBackgroundColor(BACKGROUND_GRAY);
        FrameLayout frameLayout = this.contentFrameLayout;
        if (frameLayout != null) {
            frameLayout.addView(linearLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpWebView$lambda-7, reason: not valid java name */
    public static final boolean m217setUpWebView$lambda7(View view, MotionEvent motionEvent) {
        if (!view.hasFocus()) {
            view.requestFocus();
            return false;
        }
        return false;
    }

    @XO0OX.x0XOIxOo
    public static final void setWebDialogTheme(int i) {
        Companion.setWebDialogTheme(i);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.onCompleteListener != null && !this.isListenerCalled) {
            sendErrorToListener(new FacebookOperationCanceledException());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        ProgressDialog progressDialog;
        WebView webView = this.webView;
        if (webView != null) {
            webView.stopLoading();
        }
        if (!this.isDetached && (progressDialog = this.spinner) != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        super.dismiss();
    }

    @OXOo.oOoXoXO
    public final OnCompleteListener getOnCompleteListener() {
        return this.onCompleteListener;
    }

    @OXOo.oOoXoXO
    public final WebView getWebView() {
        return this.webView;
    }

    public final boolean isListenerCalled() {
        return this.isListenerCalled;
    }

    public final boolean isPageFinished() {
        return this.isPageFinished;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        WindowManager.LayoutParams layoutParams;
        IBinder iBinder;
        Window window;
        WindowManager.LayoutParams attributes;
        IBinder iBinder2;
        this.isDetached = false;
        Utility utility = Utility.INSTANCE;
        Context context = getContext();
        IIX0o.oO(context, "context");
        if (Utility.mustFixWindowParamsForAutofill(context) && (layoutParams = this.windowParams) != null) {
            IBinder iBinder3 = null;
            if (layoutParams == null) {
                iBinder = null;
            } else {
                iBinder = layoutParams.token;
            }
            if (iBinder == null) {
                if (layoutParams != null) {
                    Activity ownerActivity = getOwnerActivity();
                    if (ownerActivity == null) {
                        window = null;
                    } else {
                        window = ownerActivity.getWindow();
                    }
                    if (window == null || (attributes = window.getAttributes()) == null) {
                        iBinder2 = null;
                    } else {
                        iBinder2 = attributes.token;
                    }
                    layoutParams.token = iBinder2;
                }
                WindowManager.LayoutParams layoutParams2 = this.windowParams;
                if (layoutParams2 != null) {
                    iBinder3 = layoutParams2.token;
                }
                Utility.logd(LOG_TAG, IIX0o.XIxXXX0x0("Set token on onAttachedToWindow(): ", iBinder3));
            }
        }
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    public void onCreate(@OXOo.oOoXoXO Bundle bundle) {
        super.onCreate(bundle);
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.spinner = progressDialog;
        progressDialog.requestWindowFeature(1);
        ProgressDialog progressDialog2 = this.spinner;
        if (progressDialog2 != null) {
            progressDialog2.setMessage(getContext().getString(R.string.com_facebook_loading));
        }
        ProgressDialog progressDialog3 = this.spinner;
        if (progressDialog3 != null) {
            progressDialog3.setCanceledOnTouchOutside(false);
        }
        ProgressDialog progressDialog4 = this.spinner;
        if (progressDialog4 != null) {
            progressDialog4.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.facebook.internal.O0xOxO
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    WebDialog.m216onCreate$lambda4(WebDialog.this, dialogInterface);
                }
            });
        }
        requestWindowFeature(1);
        this.contentFrameLayout = new FrameLayout(getContext());
        resize();
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(16);
        }
        createCrossImage();
        if (this.url != null) {
            ImageView imageView = this.crossImageView;
            if (imageView != null) {
                setUpWebView((imageView.getDrawable().getIntrinsicWidth() / 2) + 1);
            } else {
                throw new IllegalStateException("Required value was null.");
            }
        }
        FrameLayout frameLayout = this.contentFrameLayout;
        if (frameLayout != null) {
            frameLayout.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
        }
        FrameLayout frameLayout2 = this.contentFrameLayout;
        if (frameLayout2 != null) {
            setContentView(frameLayout2);
            return;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.isDetached = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @OXOo.OOXIXo KeyEvent event) {
        Boolean valueOf;
        IIX0o.x0xO0oo(event, "event");
        if (i == 4) {
            WebView webView = this.webView;
            if (webView != null) {
                if (webView == null) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(webView.canGoBack());
                }
                if (IIX0o.Oxx0IOOO(valueOf, Boolean.TRUE)) {
                    WebView webView2 = this.webView;
                    if (webView2 != null) {
                        webView2.goBack();
                        return true;
                    }
                    return true;
                }
            }
            cancel();
        }
        return super.onKeyDown(i, event);
    }

    @Override // android.app.Dialog
    public void onStart() {
        AsyncTask.Status status;
        super.onStart();
        UploadStagingResourcesTask uploadStagingResourcesTask = this.uploadTask;
        if (uploadStagingResourcesTask != null) {
            if (uploadStagingResourcesTask == null) {
                status = null;
            } else {
                status = uploadStagingResourcesTask.getStatus();
            }
            if (status == AsyncTask.Status.PENDING) {
                UploadStagingResourcesTask uploadStagingResourcesTask2 = this.uploadTask;
                if (uploadStagingResourcesTask2 != null) {
                    uploadStagingResourcesTask2.execute(new Void[0]);
                }
                ProgressDialog progressDialog = this.spinner;
                if (progressDialog != null) {
                    progressDialog.show();
                    return;
                }
                return;
            }
        }
        resize();
    }

    @Override // android.app.Dialog
    public void onStop() {
        UploadStagingResourcesTask uploadStagingResourcesTask = this.uploadTask;
        if (uploadStagingResourcesTask != null) {
            uploadStagingResourcesTask.cancel(true);
            ProgressDialog progressDialog = this.spinner;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
        super.onStop();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowAttributesChanged(@OXOo.OOXIXo WindowManager.LayoutParams params) {
        IIX0o.x0xO0oo(params, "params");
        if (params.token == null) {
            this.windowParams = params;
        }
        super.onWindowAttributesChanged(params);
    }

    @OXOo.OOXIXo
    @VisibleForTesting(otherwise = 4)
    public Bundle parseResponseUri(@OXOo.oOoXoXO String str) {
        Uri parse = Uri.parse(str);
        Utility utility = Utility.INSTANCE;
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
        parseUrlQueryString.putAll(Utility.parseUrlQueryString(parse.getFragment()));
        return parseUrlQueryString;
    }

    public final void resize() {
        int i;
        Object systemService = getContext().getSystemService("window");
        if (systemService != null) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (i2 < i3) {
                i = i2;
            } else {
                i = i3;
            }
            if (i2 < i3) {
                i2 = i3;
            }
            int min = Math.min(getScaledSize(i, displayMetrics.density, NO_PADDING_SCREEN_WIDTH, 800), displayMetrics.widthPixels);
            int min2 = Math.min(getScaledSize(i2, displayMetrics.density, 800, 1280), displayMetrics.heightPixels);
            Window window = getWindow();
            if (window != null) {
                window.setLayout(min, min2);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final void sendErrorToListener(@OXOo.oOoXoXO Throwable th) {
        FacebookException facebookException;
        if (this.onCompleteListener != null && !this.isListenerCalled) {
            this.isListenerCalled = true;
            if (th instanceof FacebookException) {
                facebookException = (FacebookException) th;
            } else {
                facebookException = new FacebookException(th);
            }
            OnCompleteListener onCompleteListener = this.onCompleteListener;
            if (onCompleteListener != null) {
                onCompleteListener.onComplete(null, facebookException);
            }
            dismiss();
        }
    }

    public final void sendSuccessToListener(@OXOo.oOoXoXO Bundle bundle) {
        OnCompleteListener onCompleteListener = this.onCompleteListener;
        if (onCompleteListener != null && !this.isListenerCalled) {
            this.isListenerCalled = true;
            if (onCompleteListener != null) {
                onCompleteListener.onComplete(bundle, null);
            }
            dismiss();
        }
    }

    public final void setExpectedRedirectUrl(@OXOo.OOXIXo String expectedRedirectUrl) {
        IIX0o.x0xO0oo(expectedRedirectUrl, "expectedRedirectUrl");
        this.expectedRedirectUrl = expectedRedirectUrl;
    }

    public final void setOnCompleteListener(@OXOo.oOoXoXO OnCompleteListener onCompleteListener) {
        this.onCompleteListener = onCompleteListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebDialog(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String url) {
        this(context, url, Companion.getWebDialogTheme());
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(url, "url");
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final WebDialog newInstance(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle, int i, @OXOo.OOXIXo LoginTargetApp loginTargetApp, @OXOo.oOoXoXO OnCompleteListener onCompleteListener) {
        return Companion.newInstance(context, str, bundle, i, loginTargetApp, onCompleteListener);
    }

    private WebDialog(Context context, String str, int i) {
        super(context, i == 0 ? Companion.getWebDialogTheme() : i);
        this.expectedRedirectUrl = ServerProtocol.DIALOG_REDIRECT_URI;
        this.url = str;
    }

    private WebDialog(Context context, String str, Bundle bundle, int i, LoginTargetApp loginTargetApp, OnCompleteListener onCompleteListener) {
        super(context, i == 0 ? Companion.getWebDialogTheme() : i);
        Uri buildUri;
        String str2 = ServerProtocol.DIALOG_REDIRECT_URI;
        this.expectedRedirectUrl = ServerProtocol.DIALOG_REDIRECT_URI;
        bundle = bundle == null ? new Bundle() : bundle;
        Utility utility = Utility.INSTANCE;
        str2 = Utility.isChromeOS(context) ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : str2;
        this.expectedRedirectUrl = str2;
        bundle.putString("redirect_uri", str2);
        bundle.putString(ServerProtocol.DIALOG_PARAM_DISPLAY, "touch");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format(Locale.ROOT, "android-%s", Arrays.copyOf(new Object[]{FacebookSdk.getSdkVersion()}, 1));
        IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
        bundle.putString("sdk", format);
        this.onCompleteListener = onCompleteListener;
        if (IIX0o.Oxx0IOOO(str, "share") && bundle.containsKey(ShareConstants.WEB_DIALOG_PARAM_MEDIA)) {
            this.uploadTask = new UploadStagingResourcesTask(this, str, bundle);
            return;
        }
        if (WhenMappings.$EnumSwitchMapping$0[loginTargetApp.ordinal()] == 1) {
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            buildUri = Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), ServerProtocol.INSTAGRAM_OAUTH_PATH, bundle);
        } else {
            ServerProtocol serverProtocol2 = ServerProtocol.INSTANCE;
            buildUri = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + ((Object) str), bundle);
        }
        this.url = buildUri.toString();
    }

    /* loaded from: classes8.dex */
    public static class Builder {

        @OXOo.oOoXoXO
        private AccessToken accessToken;

        @OXOo.oOoXoXO
        private String action;

        @OXOo.oOoXoXO
        private String applicationId;

        @OXOo.oOoXoXO
        private Context context;

        @OXOo.oOoXoXO
        private OnCompleteListener listener;

        @OXOo.oOoXoXO
        private Bundle parameters;
        private int theme;

        public Builder(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String action, @OXOo.oOoXoXO Bundle bundle) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(action, "action");
            AccessToken.Companion companion = AccessToken.Companion;
            this.accessToken = companion.getCurrentAccessToken();
            if (!companion.isCurrentAccessTokenActive()) {
                Utility utility = Utility.INSTANCE;
                String metadataApplicationId = Utility.getMetadataApplicationId(context);
                if (metadataApplicationId != null) {
                    this.applicationId = metadataApplicationId;
                } else {
                    throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
            }
            finishInit(context, action, bundle);
        }

        private final void finishInit(Context context, String str, Bundle bundle) {
            this.context = context;
            this.action = str;
            if (bundle != null) {
                this.parameters = bundle;
            } else {
                this.parameters = new Bundle();
            }
        }

        @OXOo.oOoXoXO
        public WebDialog build() {
            String applicationId;
            AccessToken accessToken = this.accessToken;
            if (accessToken != null) {
                Bundle bundle = this.parameters;
                String str = null;
                if (bundle != null) {
                    if (accessToken == null) {
                        applicationId = null;
                    } else {
                        applicationId = accessToken.getApplicationId();
                    }
                    bundle.putString("app_id", applicationId);
                }
                Bundle bundle2 = this.parameters;
                if (bundle2 != null) {
                    AccessToken accessToken2 = this.accessToken;
                    if (accessToken2 != null) {
                        str = accessToken2.getToken();
                    }
                    bundle2.putString("access_token", str);
                }
            } else {
                Bundle bundle3 = this.parameters;
                if (bundle3 != null) {
                    bundle3.putString("app_id", this.applicationId);
                }
            }
            Companion companion = WebDialog.Companion;
            Context context = this.context;
            if (context != null) {
                return companion.newInstance(context, this.action, this.parameters, this.theme, this.listener);
            }
            throw new IllegalStateException("Required value was null.");
        }

        @OXOo.oOoXoXO
        public final String getApplicationId() {
            return this.applicationId;
        }

        @OXOo.oOoXoXO
        public final Context getContext() {
            return this.context;
        }

        @OXOo.oOoXoXO
        public final OnCompleteListener getListener() {
            return this.listener;
        }

        @OXOo.oOoXoXO
        public final Bundle getParameters() {
            return this.parameters;
        }

        public final int getTheme() {
            return this.theme;
        }

        @OXOo.OOXIXo
        public final Builder setOnCompleteListener(@OXOo.oOoXoXO OnCompleteListener onCompleteListener) {
            this.listener = onCompleteListener;
            return this;
        }

        @OXOo.OOXIXo
        public final Builder setTheme(int i) {
            this.theme = i;
            return this;
        }

        public Builder(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.OOXIXo String action, @OXOo.oOoXoXO Bundle bundle) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(action, "action");
            if (str == null) {
                Utility utility = Utility.INSTANCE;
                str = Utility.getMetadataApplicationId(context);
            }
            Validate validate = Validate.INSTANCE;
            this.applicationId = Validate.notNullOrEmpty(str, "applicationId");
            finishInit(context, action, bundle);
        }
    }
}
