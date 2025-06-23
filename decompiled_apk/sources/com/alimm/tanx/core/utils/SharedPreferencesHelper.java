package com.alimm.tanx.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.utils.ThreadUtils;

/* loaded from: classes.dex */
public class SharedPreferencesHelper implements NotConfused {
    public static final String KEY_DEBUG_URL_SWITCH = "KEY_DEBUG_URL_SWITCH";
    public static final String KEY_ENCRYPT_SWITCH = "KEY_ENCRYPT_SWITCH";
    public static final String KEY_HTTPS_SWITCH = "KEY_HTTPS_SWITCH";
    public static final String KEY_ORANGE = "KEY_ORANGE";
    public static final String KEY_SETTING = "KEY_SETTING";
    public static final String KEY_SPLASH_AD_COUNT = "key_splash_ad_count";
    public static final String KEY_SPLASH_COVER = "KEY_SPLASH_COVER";
    public static final String KEY_SPLASH_COVER_H_RATIO = "key_splash_cover_h_ratio";
    public static final String KEY_SPLASH_COVER_TIME = "key_splash_cover_time";
    public static final String KEY_SPLASH_COVER_TIME_DURATION = "key_splash_cover_time_duration";
    public static final String KEY_SPLASH_COVER_W_RATIO = "key_splash_cover_w_ratio";
    public static final String KEY_SPLASH_PRELOAD_SWITCH = "KEY_SPLASH_PRELOAD_SWITCH";
    public static final String REWARD_URL = "RewardUrl";
    private static final String TAG = "SharedPreferencesHelper";
    private static SharedPreferencesHelper mInstance;
    private final SharedPreferences mPrefs;

    private SharedPreferencesHelper(Context context) {
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferencesHelper getInstance() {
        return getInstance(TanxCoreSdk.getApplication());
    }

    public boolean getBoolean(String str, Boolean bool) {
        return this.mPrefs.getBoolean(str, bool.booleanValue());
    }

    public boolean getDebugUrlBoolean() {
        boolean z = this.mPrefs.getBoolean(KEY_DEBUG_URL_SWITCH, false);
        LogUtils.d2print(TAG, "now deBugUrl Switch ->" + z);
        return z;
    }

    public boolean getEncryptBoolean() {
        boolean z = getBoolean(KEY_ENCRYPT_SWITCH, Boolean.TRUE);
        LogUtils.d(TAG, "now encryptSwitch ->" + z);
        return z;
    }

    public float getFloat(String str) {
        return this.mPrefs.getFloat(str, 0.0f);
    }

    public boolean getHttpsBoolean() {
        boolean z = getBoolean(KEY_HTTPS_SWITCH, Boolean.FALSE);
        LogUtils.d2print(TAG, "now httpsSwitch ->" + z);
        return z;
    }

    public int getInt(String str) {
        return this.mPrefs.getInt(str, 0);
    }

    public boolean getSplashPreloadBoolean() {
        boolean z = getBoolean(KEY_SPLASH_PRELOAD_SWITCH, Boolean.TRUE);
        LogUtils.d(TAG, "now splashPreload ->" + z);
        return z;
    }

    public String getString(String str) {
        return this.mPrefs.getString(str, "");
    }

    public boolean isOpenSplashCover() {
        return this.mPrefs.getBoolean(KEY_SPLASH_COVER, false);
    }

    public void putBoolean(final String str, final Boolean bool) {
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Object>() { // from class: com.alimm.tanx.core.utils.SharedPreferencesHelper.5
            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public Object doInBackground() throws Throwable {
                SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
                edit.putBoolean(str, bool.booleanValue());
                edit.apply();
                return null;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public void onSuccess(Object obj) {
            }
        });
    }

    public void putDebugUrlBoolean(final boolean z) {
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Object>() { // from class: com.alimm.tanx.core.utils.SharedPreferencesHelper.4
            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public Object doInBackground() throws Throwable {
                SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
                edit.putBoolean(SharedPreferencesHelper.KEY_DEBUG_URL_SWITCH, z);
                edit.apply();
                return null;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public void onSuccess(Object obj) {
            }
        });
    }

    public void putEncryptBoolean(boolean z) {
        putBoolean(KEY_ENCRYPT_SWITCH, Boolean.valueOf(z));
    }

    public void putFloat(final String str, final float f) {
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Object>() { // from class: com.alimm.tanx.core.utils.SharedPreferencesHelper.2
            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public Object doInBackground() throws Throwable {
                SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
                edit.putFloat(str, f);
                edit.apply();
                return null;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public void onSuccess(Object obj) {
            }
        });
    }

    public void putHttpsBoolean(boolean z) {
        putBoolean(KEY_HTTPS_SWITCH, Boolean.valueOf(z));
    }

    public void putInt(final String str, final Integer num) {
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Object>() { // from class: com.alimm.tanx.core.utils.SharedPreferencesHelper.3
            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public Object doInBackground() throws Throwable {
                SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
                edit.putInt(str, num.intValue());
                edit.apply();
                return null;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public void onSuccess(Object obj) {
            }
        });
    }

    public void putSplashPreloadBoolean(boolean z) {
        putBoolean(KEY_SPLASH_PRELOAD_SWITCH, Boolean.valueOf(z));
    }

    public void putString(final String str, final String str2) {
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Object>() { // from class: com.alimm.tanx.core.utils.SharedPreferencesHelper.1
            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public Object doInBackground() throws Throwable {
                SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
                edit.putString(str, str2);
                edit.apply();
                return null;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public void onSuccess(Object obj) {
            }
        });
    }

    public void switchSplashCover(boolean z) {
        SharedPreferences.Editor edit = this.mPrefs.edit();
        edit.putBoolean(KEY_SPLASH_COVER, z);
        edit.apply();
    }

    public static SharedPreferencesHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (SharedPreferencesHelper.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new SharedPreferencesHelper(context);
                    }
                } finally {
                }
            }
        }
        return mInstance;
    }

    public int getInt(String str, int i) {
        return this.mPrefs.getInt(str, i);
    }
}
