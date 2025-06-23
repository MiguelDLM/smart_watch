package com.tenmeter.smlibrary.activity;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.garmin.fit.OxXXx0X;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import com.sma.smartv3.network.GetGameDetail;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.listener.IDownloadLister;
import com.tenmeter.smlibrary.manager.CacheDirectoryManager;
import com.tenmeter.smlibrary.server.H5GameServer;
import com.tenmeter.smlibrary.utils.DownloadTask;
import com.tenmeter.smlibrary.utils.ExecutorUtil;
import com.tenmeter.smlibrary.utils.FileUtils;
import com.tenmeter.smlibrary.utils.KLog;
import com.tenmeter.smlibrary.utils.MD5;
import com.tenmeter.smlibrary.utils.PreferencesUtils;
import com.tenmeter.smlibrary.utils.SMGameClient;
import com.tenmeter.smlibrary.utils.Utils;
import com.tenmeter.smlibrary.utils.ZipUtils;
import com.tenmeter.smlibrary.utils.launcher.ActivityLauncher;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class SMGameH5Activity extends FragmentActivity {
    protected ImageView backImg;
    protected View loadingBg;
    protected FrameLayout loadingLayout;
    protected View loadingProgressBg;
    protected View portraitLoadingBg;
    protected FrameLayout portraitLoadingLayout;
    protected View portraitLoadingProgressBg;
    private DownloadTask task;
    protected TextView tv_data;
    protected TextView tv_portraitProgress;
    protected TextView tv_progress;
    protected ImageView vv_loading_hulu;
    protected ImageView vv_loading_hulu_portrait;
    protected WebView wb_common;
    SMGameInfo game = null;
    H5GameServer myServer = null;
    private int oldProgress = 0;
    private int huluMarginLeft = 0;
    private int screenWidth = 0;

    /* renamed from: com.tenmeter.smlibrary.activity.SMGameH5Activity$6, reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass6 implements IDownloadLister {
        public AnonymousClass6() {
        }

        @Override // com.tenmeter.smlibrary.listener.IDownloadLister
        public void onError(String str) {
            SMGameH5Activity.this.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.6.2
                @Override // java.lang.Runnable
                public void run() {
                }
            });
            KLog.i("onDownloadSuccess:....... ..................文件下载失败.............................." + str);
        }

        @Override // com.tenmeter.smlibrary.listener.IDownloadLister
        public void onFinish(String str) {
            SMGameH5Activity.this.changeProgress(100);
            if (SMGameH5Activity.this.game.getVertical() == 2) {
                SMGameH5Activity.this.tv_progress.setText("99%");
            } else {
                SMGameH5Activity.this.tv_portraitProgress.setText("99%");
            }
            KLog.i("onDownloadSuccess:....... ..................文件下载成功..............................");
            new Thread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.6.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ZipUtils.UnZipFolder(CacheDirectoryManager.getExternCacheFileRootPath(SMGameH5Activity.this) + "/h5-game-" + SMGameH5Activity.this.game.getGid() + HelpFormatter.DEFAULT_OPT_PREFIX + MD5.getStringMD5(SMGameH5Activity.this.game.getResourceUrl()) + OTAManager.OTA_ZIP_SUFFIX, CacheDirectoryManager.getExternCacheFileRootPath(SMGameH5Activity.this) + "/game" + SMGameH5Activity.this.game.getGid());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    SMGameH5Activity.this.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.6.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SMGameH5Activity.this.initSettings();
                            SMGameH5Activity sMGameH5Activity = SMGameH5Activity.this;
                            PreferencesUtils.setH5GameResourceURL(sMGameH5Activity, sMGameH5Activity.game.getGid(), MD5.getStringMD5(SMGameH5Activity.this.game.getResourceUrl()));
                        }
                    });
                }
            }).start();
        }

        @Override // com.tenmeter.smlibrary.listener.IDownloadLister
        public void onProgress(long j, int i) {
            SMGameH5Activity.this.changeProgress(i);
        }

        @Override // com.tenmeter.smlibrary.listener.IDownloadLister
        public void onStart() {
        }
    }

    /* loaded from: classes13.dex */
    public class MyWebViewClient extends WebViewClient {
        private MyWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeProgress(final int i) {
        runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.7
            @Override // java.lang.Runnable
            public void run() {
                if (i >= SMGameH5Activity.this.oldProgress) {
                    SMGameH5Activity.this.oldProgress = i;
                    int i2 = 99;
                    if (SMGameH5Activity.this.game.getVertical() == 2) {
                        TextView textView = SMGameH5Activity.this.tv_progress;
                        StringBuilder sb = new StringBuilder();
                        int i3 = i;
                        if (i3 != 100) {
                            i2 = i3;
                        }
                        sb.append(i2);
                        sb.append("%");
                        textView.setText(sb.toString());
                        SMGameH5Activity.this.loadingProgressBg.post(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                float dimensionPixelSize = (SMGameH5Activity.this.screenWidth - SMGameH5Activity.this.getResources().getDimensionPixelSize(R.dimen.sm_sdk_px_200)) / 100.0f;
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SMGameH5Activity.this.loadingProgressBg.getLayoutParams();
                                float dimensionPixelSize2 = SMGameH5Activity.this.getResources().getDimensionPixelSize(R.dimen.sm_sdk_px_26);
                                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                int i4 = i;
                                int i5 = 99;
                                if (i4 == 100) {
                                    i4 = 99;
                                }
                                layoutParams.width = (int) (dimensionPixelSize2 + (i4 * dimensionPixelSize));
                                SMGameH5Activity.this.loadingProgressBg.setLayoutParams(layoutParams);
                                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) SMGameH5Activity.this.vv_loading_hulu.getLayoutParams();
                                float f = SMGameH5Activity.this.huluMarginLeft;
                                AnonymousClass7 anonymousClass72 = AnonymousClass7.this;
                                int i6 = i;
                                if (i6 != 100) {
                                    i5 = i6;
                                }
                                layoutParams2.leftMargin = (int) (f + (dimensionPixelSize * i5));
                                SMGameH5Activity.this.vv_loading_hulu.setLayoutParams(layoutParams2);
                            }
                        });
                    } else {
                        TextView textView2 = SMGameH5Activity.this.tv_portraitProgress;
                        StringBuilder sb2 = new StringBuilder();
                        int i4 = i;
                        if (i4 != 100) {
                            i2 = i4;
                        }
                        sb2.append(i2);
                        sb2.append("%");
                        textView2.setText(sb2.toString());
                        SMGameH5Activity.this.portraitLoadingBg.post(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.7.2
                            @Override // java.lang.Runnable
                            public void run() {
                                float dimensionPixelSize = (SMGameH5Activity.this.screenWidth - SMGameH5Activity.this.getResources().getDimensionPixelSize(R.dimen.sm_sdk_px_80)) / 100.0f;
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SMGameH5Activity.this.portraitLoadingProgressBg.getLayoutParams();
                                float dimensionPixelSize2 = SMGameH5Activity.this.getResources().getDimensionPixelSize(R.dimen.sm_sdk_px_26);
                                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                int i5 = i;
                                int i6 = 99;
                                if (i5 == 100) {
                                    i5 = 99;
                                }
                                layoutParams.width = (int) (dimensionPixelSize2 + (i5 * dimensionPixelSize));
                                SMGameH5Activity.this.portraitLoadingProgressBg.setLayoutParams(layoutParams);
                                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) SMGameH5Activity.this.vv_loading_hulu_portrait.getLayoutParams();
                                float f = SMGameH5Activity.this.huluMarginLeft;
                                AnonymousClass7 anonymousClass72 = AnonymousClass7.this;
                                int i7 = i;
                                if (i7 != 100) {
                                    i6 = i7;
                                }
                                layoutParams2.leftMargin = (int) (f + (dimensionPixelSize * i6));
                                SMGameH5Activity.this.vv_loading_hulu_portrait.setLayoutParams(layoutParams2);
                            }
                        });
                    }
                }
                KLog.i("progress:.......==" + i + "..................oneProgress*progress..............................oneProgress*progress==");
            }
        });
    }

    @SuppressLint({"WrongConstant"})
    private boolean fixOrientation() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isTranslucentOrFloating() {
        Exception e;
        boolean z;
        Method method;
        try {
            TypedArray obtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            z = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        try {
            method.setAccessible(false);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return z;
        }
        return z;
    }

    private void onGlobalLayout(final boolean z) {
        this.backImg.setVisibility(0);
        if (this.game.getVertical() == 2) {
            this.loadingLayout.setVisibility(0);
            this.loadingLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (SMGameH5Activity.this.game.getVertical() == 2) {
                        SMGameH5Activity sMGameH5Activity = SMGameH5Activity.this;
                        sMGameH5Activity.screenWidth = sMGameH5Activity.loadingLayout.getWidth();
                        SMGameH5Activity sMGameH5Activity2 = SMGameH5Activity.this;
                        sMGameH5Activity2.huluMarginLeft = ((FrameLayout.LayoutParams) sMGameH5Activity2.vv_loading_hulu.getLayoutParams()).leftMargin;
                        SMGameH5Activity sMGameH5Activity3 = SMGameH5Activity.this;
                        sMGameH5Activity3.vv_loading_hulu.setBackground(ContextCompat.getDrawable(sMGameH5Activity3, R.drawable.anim_huluhan_run));
                        final Drawable background = SMGameH5Activity.this.vv_loading_hulu.getBackground();
                        ExecutorUtil.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SMGameH5Activity.this.vv_loading_hulu.post(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.3.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Drawable drawable = background;
                                        if (drawable instanceof AnimationDrawable) {
                                            ((AnimationDrawable) drawable).start();
                                        }
                                    }
                                });
                            }
                        });
                    }
                    if (z) {
                        SMGameH5Activity.this.processDownLoad();
                    } else {
                        SMGameH5Activity.this.processLoading();
                    }
                    SMGameH5Activity.this.loadingLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        } else {
            this.portraitLoadingLayout.setVisibility(0);
            this.portraitLoadingLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.4
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    SMGameH5Activity sMGameH5Activity = SMGameH5Activity.this;
                    sMGameH5Activity.screenWidth = sMGameH5Activity.portraitLoadingLayout.getWidth();
                    SMGameH5Activity.this.portraitLoadingLayout.setVisibility(0);
                    SMGameH5Activity sMGameH5Activity2 = SMGameH5Activity.this;
                    sMGameH5Activity2.huluMarginLeft = ((FrameLayout.LayoutParams) sMGameH5Activity2.vv_loading_hulu_portrait.getLayoutParams()).leftMargin;
                    SMGameH5Activity sMGameH5Activity3 = SMGameH5Activity.this;
                    sMGameH5Activity3.vv_loading_hulu_portrait.setBackground(ContextCompat.getDrawable(sMGameH5Activity3, R.drawable.anim_huluhan_run));
                    final Drawable background = SMGameH5Activity.this.vv_loading_hulu_portrait.getBackground();
                    ExecutorUtil.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SMGameH5Activity.this.vv_loading_hulu_portrait.post(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.4.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Drawable drawable = background;
                                    if (drawable instanceof AnimationDrawable) {
                                        ((AnimationDrawable) drawable).start();
                                    }
                                }
                            });
                        }
                    });
                    if (z) {
                        SMGameH5Activity.this.processDownLoad();
                    } else {
                        SMGameH5Activity.this.processLoading();
                    }
                    SMGameH5Activity.this.portraitLoadingLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDownLoad() {
        CacheDirectoryManager.getExternCacheFileRootPath(this);
        this.game.getGid();
        MD5.getStringMD5(this.game.getResourceUrl());
        FileUtils.delete(new File(CacheDirectoryManager.getExternCacheFileRootPath(this) + "/game" + this.game.getGid()));
        DownloadTask downloadTask = new DownloadTask(this.game.getResourceUrl(), CacheDirectoryManager.getExternCacheFileRootPath(this) + "/h5-game-" + this.game.getGid() + HelpFormatter.DEFAULT_OPT_PREFIX + MD5.getStringMD5(this.game.getResourceUrl()) + OTAManager.OTA_ZIP_SUFFIX, 20, new AnonymousClass6());
        this.task = downloadTask;
        downloadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processLoading() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 99);
        ofInt.setDuration(2500L);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SMGameH5Activity.this.changeProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.start();
    }

    private void processUpdate() {
        if (!"".equals(PreferencesUtils.getH5GameResourceURL(this, this.game.getGid())) && !MD5.getStringMD5(this.game.getResourceUrl()).equals(PreferencesUtils.getH5GameResourceURL(this, this.game.getGid()))) {
            FileUtils.delete(new File(CacheDirectoryManager.getExternCacheFileRootPath(this) + "/h5-game-" + this.game.getGid() + HelpFormatter.DEFAULT_OPT_PREFIX + PreferencesUtils.getH5GameResourceURL(this, this.game.getGid()) + OTAManager.OTA_ZIP_SUFFIX));
        }
        PreferencesUtils.setH5GameResourceURL(this, this.game.getGid(), "");
        onGlobalLayout(true);
    }

    private void requestPermission() {
        SMGameClient.getInstance().comGameStart(this.game.getGid(), null);
        if (!MD5.getStringMD5(this.game.getResourceUrl()).equals(PreferencesUtils.getH5GameResourceURL(this, this.game.getGid()))) {
            processUpdate();
            return;
        }
        if (FileUtils.isFolderExist(CacheDirectoryManager.getExternCacheFileRootPath(this) + "/game" + this.game.getGid())) {
            initSettings();
            onGlobalLayout(false);
        } else {
            processUpdate();
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    @SuppressLint({"RestrictedApi"})
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            if (keyEvent.getAction() == 1) {
                onBackPressed();
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    public void hideBottomUIMenu() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.systemUiVisibility = OxXXx0X.f13007O0;
        window.setAttributes(attributes);
    }

    @SuppressLint({"JavascriptInterface"})
    public void initSettings() {
        this.wb_common.requestFocus(130);
        this.wb_common.setWebViewClient(new MyWebViewClient());
        this.wb_common.setWebChromeClient(new WebChromeClient() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.2
            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                try {
                    return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                } catch (Exception unused) {
                    return super.getDefaultVideoPoster();
                }
            }

            @Override // android.webkit.WebChromeClient
            @Nullable
            public View getVideoLoadingProgressView() {
                FrameLayout frameLayout = new FrameLayout(SMGameH5Activity.this);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                return frameLayout;
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                callback.invoke(str, true, false);
            }

            @Override // android.webkit.WebChromeClient
            public void onPermissionRequest(final PermissionRequest permissionRequest) {
                if (permissionRequest == null) {
                    permissionRequest.deny();
                }
                if (permissionRequest.getResources() == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (String str : permissionRequest.getResources()) {
                    if (str.equals("android.webkit.resource.VIDEO_CAPTURE")) {
                        arrayList.add("android.permission.CAMERA");
                    } else if (str.equals("android.webkit.resource.AUDIO_CAPTURE")) {
                        arrayList.add("android.permission.RECORD_AUDIO");
                        arrayList.add("android.permission.MODIFY_AUDIO_SETTINGS");
                    }
                }
                if (arrayList.isEmpty()) {
                    permissionRequest.deny();
                } else {
                    ActivityLauncher.getInstance().requestMultiplePermissions(SMGameH5Activity.this.getActivityResultRegistry()).launch((String[]) arrayList.toArray(new String[arrayList.size()]), new ActivityResultCallback<Map<String, Boolean>>() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.2.2
                        @Override // androidx.activity.result.ActivityResultCallback
                        public void onActivityResult(Map<String, Boolean> map) {
                            if (map.containsValue(Boolean.FALSE)) {
                                permissionRequest.deny();
                            } else {
                                PermissionRequest permissionRequest2 = permissionRequest;
                                permissionRequest2.grant(permissionRequest2.getResources());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    SMGameH5Activity.this.loadingLayout.postDelayed(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SMGameH5Activity.this.game.getVertical() == 2) {
                                SMGameH5Activity.this.loadingLayout.setVisibility(8);
                            } else {
                                SMGameH5Activity.this.portraitLoadingLayout.setVisibility(8);
                            }
                            SMGameH5Activity.this.backImg.setVisibility(8);
                        }
                    }, 5000L);
                }
            }
        });
        WebSettings settings = this.wb_common.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowFileAccess(true);
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setLoadWithOverviewMode(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setCacheMode(2);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setBlockNetworkImage(false);
        settings.setSavePassword(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(true);
        this.wb_common.addJavascriptInterface(this, "wjsb");
        if (Build.VERSION.SDK_INT > 21) {
            this.wb_common.getSettings().setMixedContentMode(0);
        }
        if (this.myServer == null) {
            try {
                this.myServer = new H5GameServer(this);
                this.wb_common.loadUrl("http://127.0.0.1:" + this.myServer.getListeningPort() + "/index.html");
                return;
            } catch (IOException e) {
                finish();
                e.printStackTrace();
                return;
            }
        }
        this.wb_common.loadUrl("http://127.0.0.1:" + this.myServer.getListeningPort() + "/index.html");
    }

    @JavascriptInterface
    public void jsCloseGSensor(int i) {
        if (SMGameClient.getInstance().getGameGSonsorListener() != null) {
            SMGameClient.getInstance().getGameGSonsorListener().closeGSensor(i);
        }
    }

    @JavascriptInterface
    public void jsCloseGame() {
        if (SMGameClient.getInstance().getGameGSonsorListener() != null) {
            SMGameClient.getInstance().getGameGSonsorListener().closeGame();
        }
        finish();
    }

    @JavascriptInterface
    public String jsGetGameInfo() {
        SMGameClient.getInstance().getUserInfo().getHeadImage();
        SMGameClient.getInstance().getUserInfo().getUserNickname();
        long uid = SMGameClient.getInstance().getUserInfo().getUid();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", SMGameClient.getInstance().getUserInfo().getUserToken());
            jSONObject.put("uid", uid + "");
            jSONObject.put(GetGameDetail.GAME_ID, this.game.getGid());
            jSONObject.put("serverUrl", SMGameClient.getInstance().getUserInfo().getServerUrl());
            jSONObject.put("joinRaceId", 0);
            jSONObject.put("otpToken", "");
            jSONObject.put("roomId", 0);
            jSONObject.put("name", SMGameClient.getInstance().getUserInfo().getUserNickname());
            jSONObject.put(TtmlNode.TAG_HEAD, SMGameClient.getInstance().getUserInfo().getHeadImage());
            if (SMGameClient.getInstance().getGameInfoExpand().size() > 0) {
                for (String str : SMGameClient.getInstance().getGameInfoExpand().keySet()) {
                    jSONObject.put(str, SMGameClient.getInstance().getGameInfoExpand().get(str));
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String jsGetP1Data() {
        String headImage = SMGameClient.getInstance().getUserInfo().getHeadImage();
        String userNickname = SMGameClient.getInstance().getUserInfo().getUserNickname();
        return "{\"userId\":" + SMGameClient.getInstance().getUserInfo().getUid() + ",\"name\":\"" + userNickname + "\", \"head\":\"" + headImage + "\", \"mac\":\"\"}";
    }

    @JavascriptInterface
    public void jsHideLoading() {
    }

    @JavascriptInterface
    public void jsOpenGSensor(int i) {
        KLog.i("jsOpenGSensor+++++++++++++++++++++");
        if (SMGameClient.getInstance().getGameGSonsorListener() != null) {
            SMGameClient.getInstance().getGameGSonsorListener().openGSensor(i);
        }
    }

    @JavascriptInterface
    public void jsVirtualKeys(int i) {
        if (SMGameClient.getInstance().getGameGSonsorListener() != null) {
            SMGameClient.getInstance().getGameGSonsorListener().jsVirtualKeys(i);
        }
    }

    @JavascriptInterface
    public void jsloadingFinish() {
        this.loadingLayout.postDelayed(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.8
            @Override // java.lang.Runnable
            public void run() {
                if (SMGameH5Activity.this.game.getVertical() == 2) {
                    SMGameH5Activity.this.loadingLayout.setVisibility(8);
                } else {
                    SMGameH5Activity.this.portraitLoadingLayout.setVisibility(8);
                }
                SMGameH5Activity.this.backImg.setVisibility(8);
            }
        }, 100L);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (SMGameClient.getInstance().getGameGSonsorListener() != null) {
            SMGameClient.getInstance().getGameGSonsorListener().closeGame();
        }
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i = 1;
        if (bundle != null) {
            Utils.relaunchApp(this, true);
        }
        if (getIntent().getExtras().getParcelable("game") != null) {
            this.game = (SMGameInfo) getIntent().getExtras().getParcelable("game");
        } else {
            Toast.makeText(this, "game不能为null", 1).show();
            finish();
        }
        if (Build.VERSION.SDK_INT == 26 && isTranslucentOrFloating()) {
            KLog.i("onCreate fixOrientation when Oreo, result = " + fixOrientation());
        }
        super.onCreate(bundle);
        if (this.game.getVertical() == 2) {
            i = 0;
        }
        setRequestedOrientation(i);
        try {
            H5GameServer.WEB_ROOT = CacheDirectoryManager.getExternCacheFileRootPath(this) + "/game" + this.game.getGid();
            this.myServer = new H5GameServer(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utils.setActivity(this);
        Utils.hideVirtualButton();
        getWindow().addFlags(128);
        hideBottomUIMenu();
        setContentView(R.layout.activity_sm_sdk_game_h5);
        this.wb_common = (WebView) findViewById(R.id.wb_common);
        this.tv_data = (TextView) findViewById(R.id.tv_data);
        this.tv_progress = (TextView) findViewById(R.id.tv_progress);
        this.tv_portraitProgress = (TextView) findViewById(R.id.tv_progress_portrait);
        this.loadingLayout = (FrameLayout) findViewById(R.id.fl_loading);
        this.portraitLoadingLayout = (FrameLayout) findViewById(R.id.fl_loading_portrait);
        this.loadingBg = findViewById(R.id.vv_loading_one);
        this.loadingProgressBg = findViewById(R.id.vv_loading_two);
        this.portraitLoadingBg = findViewById(R.id.vv_loading_one_portrait);
        this.portraitLoadingProgressBg = findViewById(R.id.vv_loading_two_portrait);
        this.vv_loading_hulu = (ImageView) findViewById(R.id.vv_loading_hulu);
        this.vv_loading_hulu_portrait = (ImageView) findViewById(R.id.vv_loading_hulu_portrait);
        ImageView imageView = (ImageView) findViewById(R.id.iv_cancel);
        this.backImg = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SMGameH5Activity.this.task != null) {
                    SMGameH5Activity.this.task.cancelDownload();
                }
                if (SMGameClient.getInstance().getGameGSonsorListener() != null) {
                    SMGameClient.getInstance().getGameGSonsorListener().closeGame();
                }
                SMGameH5Activity.this.finish();
            }
        });
        SMGameClient.getInstance().setWebView(this.wb_common);
        SMGameClient.getInstance().setTextData(this.tv_data);
        requestPermission();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            DownloadTask downloadTask = this.task;
            if (downloadTask != null) {
                downloadTask.cancel(true);
                this.task = null;
            }
            SMGameClient.getInstance().setWebView(null);
            SMGameClient.getInstance().setTextData(null);
            this.wb_common.destroy();
            H5GameServer h5GameServer = this.myServer;
            if (h5GameServer != null) {
                h5GameServer.closeAllConnections();
                this.myServer = null;
                H5GameServer.WEB_ROOT = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.wb_common.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 2068) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                KLog.e("request permission error");
                return;
            }
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.wb_common.onResume();
    }

    @JavascriptInterface
    public void reqCalorieBurned() {
        if (SMGameClient.getInstance().getCalGSensor() != null) {
            SMGameClient.getInstance().getCalGSensor().reqCalorieBurned();
        }
    }

    @JavascriptInterface
    public void reqGameAgain() {
    }

    @JavascriptInterface
    public void reqGameStatus(String str) {
        KLog.w("reqGameStatus" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                int optInt = jSONObject.optInt("code");
                if (SMGameClient.getInstance().getGameStatusListener() != null) {
                    SMGameClient.getInstance().getGameStatusListener().gameStatus(optInt);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public void reqVibrate(JSONObject jSONObject) {
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (Build.VERSION.SDK_INT == 26 && isTranslucentOrFloating()) {
            KLog.i("avoid calling setRequestedOrientation when Oreo.");
        } else {
            super.setRequestedOrientation(i);
        }
    }
}
