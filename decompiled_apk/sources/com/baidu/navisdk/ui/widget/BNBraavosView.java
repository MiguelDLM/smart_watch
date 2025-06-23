package com.baidu.navisdk.ui.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import com.baidu.mapframework.braavos.BraavosConfiguration;
import com.baidu.mapframework.braavos.BraavosContextImpl;
import com.baidu.mapframework.braavos.BraavosWebView;
import com.baidu.mapframework.braavos.BraavosWebViewCore;
import com.baidu.mapframework.braavos.BraavosWebViewImpl;
import com.baidu.mapframework.braavos.CallbackContext;
import com.baidu.mapframework.braavos.ConfigXmlParser;
import com.baidu.mapframework.braavos.ModuleEntry;
import com.baidu.mapframework.braavos.ModuleManager;
import com.baidu.mapframework.braavos.core.DefaultWebView;
import com.baidu.mapframework.braavos.core.NestedScrollWebView;
import com.baidu.mapframework.braavos.event.IMessageBinder;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class BNBraavosView extends FrameLayout implements IMessageBinder {
    public static final String TAG = "BNBraavosView";
    private static ExecutorService sExecutorService = new ThreadPoolExecutor(0, 128, 5, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.baidu.navisdk.ui.widget.BNBraavosView.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, BNBraavosView.TAG);
        }
    });
    protected BraavosWebView appView;
    protected BraavosContextImpl braavosContext;
    protected boolean isCreated;
    protected boolean keepRunning;
    public String launchUrl;
    protected ArrayList<ModuleEntry> pluginEntries;
    protected BraavosConfiguration preferences;
    private int scrollOffset;
    private int touchOffset;

    public BNBraavosView(Context context) {
        super(context);
        this.keepRunning = true;
        onCreateView();
    }

    public View createViews() {
        this.appView.getView().setId(100);
        this.appView.getView().requestFocusFromTouch();
        this.appView.getView().setOverScrollMode(2);
        return this.appView.getView();
    }

    public void destroy() {
        BraavosWebView braavosWebView = this.appView;
        if (braavosWebView != null) {
            braavosWebView.handleDestroy();
            this.isCreated = false;
            this.appView = null;
        }
    }

    public void dispatchMessage(String str, JSONArray jSONArray, CallbackContext callbackContext) {
    }

    public DefaultWebView getWebView() {
        BraavosWebView braavosWebView = this.appView;
        if (braavosWebView != null) {
            return braavosWebView.getView();
        }
        return null;
    }

    public void init() {
        this.appView = makeWebView();
        createViews();
        if (!this.appView.isInitialized()) {
            this.appView.init(this.braavosContext, this.pluginEntries, this.preferences);
        }
        this.appView.setBinder(this);
        this.braavosContext.onBraavosInit(this.appView.getModuleManager());
        this.appView.getView();
    }

    public void loadConfig(Activity activity) {
        ConfigXmlParser configXmlParser = new ConfigXmlParser();
        configXmlParser.parse(activity);
        this.preferences = configXmlParser.getPreferences();
        this.launchUrl = configXmlParser.getLaunchUrl();
        this.pluginEntries = configXmlParser.getPluginEntries();
    }

    public void loadUrl(String str) {
        if (this.appView == null && !this.isCreated) {
            init();
        }
        this.keepRunning = this.preferences.getBoolean("KeepRunning", true);
        BraavosWebView braavosWebView = this.appView;
        if (braavosWebView != null) {
            braavosWebView.loadUrlIntoView(str, true);
        }
    }

    public BraavosContextImpl makeBraavosContext() {
        return new BraavosContextImpl((Activity) getContext(), sExecutorService) { // from class: com.baidu.navisdk.ui.widget.BNBraavosView.2
            public Object onMessage(String str, Object obj) {
                return BNBraavosView.this.onMessage(str, obj);
            }
        };
    }

    public BraavosWebView makeWebView() {
        return new BraavosWebViewImpl(makeWebViewCore());
    }

    public BraavosWebViewCore makeWebViewCore() {
        return BraavosWebViewImpl.createWebViewCore(new NestedScrollWebView(getContext()), this.preferences);
    }

    public void notifyJSRuntime(String str, JSONObject jSONObject) {
        try {
            if (getWebView() != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(NotificationCompat.CATEGORY_EVENT, str);
                if (jSONObject != null) {
                    jSONObject2.put(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject);
                }
                getWebView().evaluateJavascript("(function(){BMAP_CWN(" + jSONObject2.toString() + ");})();", (ValueCallback) null);
            }
        } catch (Exception unused) {
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.braavosContext.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onBackPressed() {
        BraavosWebView braavosWebView = this.appView;
        if (braavosWebView != null && braavosWebView.canGoBack()) {
            return this.appView.backHistory();
        }
        return false;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        ModuleManager moduleManager;
        super.onConfigurationChanged(configuration);
        BraavosWebView braavosWebView = this.appView;
        if (braavosWebView != null && (moduleManager = braavosWebView.getModuleManager()) != null) {
            moduleManager.onConfigurationChanged(configuration);
        }
    }

    public void onCreateView() {
        if (!this.isCreated || this.appView == null) {
            this.isCreated = true;
            loadConfig((Activity) getContext());
            this.braavosContext = makeBraavosContext();
            init();
        }
        addView(this.appView.getView());
    }

    public Object onMessage(String str, Object obj) {
        if ("onReceivedError".equals(str)) {
            JSONObject jSONObject = (JSONObject) obj;
            try {
                onReceivedError(jSONObject.getInt("errorCode"), jSONObject.getString("description"), jSONObject.getString("url"));
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void onPause() {
        Log.d(TAG, "Paused the activity.");
        if (getWebView() != null) {
            getWebView().setOnPause();
        }
        BraavosWebView braavosWebView = this.appView;
        if (braavosWebView != null) {
            braavosWebView.handlePause(this.keepRunning);
        }
    }

    public void onReceivedError(int i, String str, String str2) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            this.braavosContext.onRequestPermissionResult(i, strArr, iArr);
        } catch (JSONException e) {
            Log.d(TAG, "JSONException: Parameters fed into the method are not valid");
            e.printStackTrace();
        }
    }

    public void onResume() {
        Log.d(TAG, "Resumed the activity.");
        if (this.appView == null) {
            return;
        }
        if (getWebView() != null) {
            getWebView().setOnResume();
        }
        this.appView.handleResume(this.keepRunning);
    }

    public void onStart() {
        Log.d(TAG, "Started the activity.");
        BraavosWebView braavosWebView = this.appView;
        if (braavosWebView == null) {
            return;
        }
        braavosWebView.handleStart();
    }

    public void onStop() {
        Log.d(TAG, "Stopped the activity.");
        BraavosWebView braavosWebView = this.appView;
        if (braavosWebView == null) {
            return;
        }
        braavosWebView.handleStop();
    }

    public void resetScrollPos() {
        if (getWebView() != null && getWebView().getScrollY() != 0) {
            getWebView().stopNestedScroll();
            getWebView().flingScroll(0, 0);
            getWebView().scrollTo(0, 0);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        BraavosWebView braavosWebView = this.appView;
        if (braavosWebView != null && braavosWebView.getView() != null) {
            this.appView.getView().scrollTo(i, i2);
        }
    }

    public void setScrollValue(int i, int i2, int i3) {
        this.scrollOffset = (i2 - i) + i3;
        this.touchOffset = i;
    }

    public void updateOffset() {
        if (getWebView() != null) {
            getWebView().setScrollOffset(this.scrollOffset, this.touchOffset);
        }
    }

    public BNBraavosView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.keepRunning = true;
        onCreateView();
    }

    public BNBraavosView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.keepRunning = true;
        onCreateView();
    }

    @TargetApi(21)
    public BNBraavosView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.keepRunning = true;
        onCreateView();
    }
}
