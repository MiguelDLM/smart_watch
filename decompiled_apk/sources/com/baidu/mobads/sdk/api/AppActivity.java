package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.bu;
import com.baidu.mobads.sdk.internal.bv;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class AppActivity extends Activity {
    private static Activity activity;
    public static String activityName;
    private static boolean canShowWhenLock;
    private ClassLoader mLoader;
    private IActivityImpl mProxyActivity;
    private static ActionBarColorTheme mSActionBarColorTheme = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
    private static boolean mIsShowActionBarTitle = true;

    public static void canLpShowWhenLocked(boolean z) {
        canShowWhenLock = z;
    }

    public static Activity getActivity() {
        return activity;
    }

    public static Class<?> getActivityClass() {
        if (!TextUtils.isEmpty(activityName)) {
            try {
                return Class.forName(activityName);
            } catch (Exception e) {
                bv.a().c(e);
            }
        }
        return AppActivity.class;
    }

    public static boolean getLpShowWhenLocked() {
        return canShowWhenLock;
    }

    public static boolean isAnti() {
        return !TextUtils.isEmpty(activityName);
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            mSActionBarColorTheme = actionBarColorTheme;
        }
    }

    public static void setActivityName(String str) {
        activityName = str;
    }

    public static void setIsShowActionBarTitle(boolean z) {
        mIsShowActionBarTitle = z;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            z = iActivityImpl.dispatchKeyEvent(keyEvent);
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            z = iActivityImpl.dispatchTouchEvent(motionEvent);
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Class<?> a2;
        activity = this;
        super.onCreate(bundle);
        Intent intent = getIntent();
        try {
            ClassLoader a3 = bu.a(this);
            this.mLoader = a3;
            if (intent != null) {
                intent.setExtrasClassLoader(a3);
            }
            String str = "";
            if (intent != null) {
                str = intent.getStringExtra("activityImplName");
            }
            Object obj = null;
            if (!TextUtils.isEmpty(str) && (a2 = av.a(str, this.mLoader)) != null) {
                try {
                    obj = a2.getConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (obj != null) {
                this.mProxyActivity = (IActivityImpl) obj;
            }
            if (this.mProxyActivity != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("bar_close_color", mSActionBarColorTheme.mCloseColor);
                    jSONObject.put("bar_pro_color", mSActionBarColorTheme.mProgressColor);
                    jSONObject.put("bar_title_color", mSActionBarColorTheme.mTitleColor);
                    jSONObject.put("bar_bg_color", mSActionBarColorTheme.mBackgroundColor);
                    jSONObject.put("showWhenLocked", canShowWhenLock);
                    jSONObject.put("isShowActionBarTit", mIsShowActionBarTitle);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.mProxyActivity.setLpBussParam(jSONObject);
                this.mProxyActivity.setActivity(this);
                if (intent != null) {
                    this.mProxyActivity.onCreate(bundle);
                }
            }
        } catch (Exception e2) {
            bv.a().c(e2);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDestroy();
        }
        super.onDestroy();
        activity = null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            z = iActivityImpl.onKeyDown(i, keyEvent);
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z;
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            z = iActivityImpl.onKeyUp(i, keyEvent);
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onNewIntent(intent);
        }
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStart();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            z = iActivityImpl.onTouchEvent(motionEvent);
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(i, i2);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.overridePendingTransition(i, i2);
        }
    }
}
