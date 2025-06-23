package com.jieli.watchtesttool.tool.config;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.IntRange;

/* loaded from: classes10.dex */
public class ConfigHelper {
    private static final String KEY_ADJUST_BLE_MTU = "key_adjust_ble_mtu";
    private static final String KEY_ADV_FILTER_PREFIX = "key_adv_filter_prefix";
    private static final String KEY_BAN_AUTO_TEST = "key_ban_auto_test";
    private static final String KEY_FILTER_DEVICE = "key_filter_device";
    private static final String KEY_SPP_CONNECT_WAY = "key_spp_connect_way";
    private static final String KEY_TEMP_CONNECT_WAY = "key_temp_connect_way";
    private static final String KEY_TEST_FILE_BROWSE = "key_test_file_browse";
    private static final String KEY_TEST_FILE_TRANSFER = "key_test_file_transfer";
    private static final String KEY_TEST_MESSAGE_SYNC = "key_test_message_sync";
    private static final String KEY_TEST_OTA = "key_test_ota";
    private static final String KEY_TEST_SMALL_FILE_TRANSFER = "key_test_small_file_transfer";
    private static final String KEY_TEST_WATCH_OP = "key_test_watch_op";
    private static final String KEY_USE_DEVICE_AUTH = "key_use_device_auth";
    private static volatile ConfigHelper instance;
    private final SharedPreferences preferences;

    private ConfigHelper(Context context) {
        this.preferences = context.getSharedPreferences("watch_config_data", 0);
    }

    public static ConfigHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (ConfigHelper.class) {
                try {
                    if (instance == null) {
                        instance = new ConfigHelper(context);
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public String getAdvFilterPrefix() {
        return this.preferences.getString(KEY_ADV_FILTER_PREFIX, "");
    }

    public int getBleMtu() {
        return this.preferences.getInt(KEY_ADJUST_BLE_MTU, 509);
    }

    public SharedPreferences getPreferences() {
        return this.preferences;
    }

    public int getTempConnectWay() {
        return this.preferences.getInt(KEY_TEMP_CONNECT_WAY, -1);
    }

    public boolean isBanAutoTest() {
        return this.preferences.getBoolean(KEY_BAN_AUTO_TEST, true);
    }

    public boolean isFilterDevice() {
        return this.preferences.getBoolean(KEY_FILTER_DEVICE, true);
    }

    public boolean isSPPConnectWay() {
        return this.preferences.getBoolean(KEY_SPP_CONNECT_WAY, false);
    }

    public boolean isTestFileBrowse() {
        return this.preferences.getBoolean(KEY_TEST_FILE_BROWSE, false);
    }

    public boolean isTestFileTransfer() {
        return this.preferences.getBoolean(KEY_TEST_FILE_TRANSFER, true);
    }

    public boolean isTestMessageSync() {
        return this.preferences.getBoolean(KEY_TEST_MESSAGE_SYNC, false);
    }

    public boolean isTestOTA() {
        return this.preferences.getBoolean(KEY_TEST_OTA, true);
    }

    public boolean isTestSmallFileTransfer() {
        return this.preferences.getBoolean(KEY_TEST_SMALL_FILE_TRANSFER, false);
    }

    public boolean isTestWatchOp() {
        return this.preferences.getBoolean(KEY_TEST_WATCH_OP, true);
    }

    public boolean isUseDeviceAuth() {
        return this.preferences.getBoolean(KEY_USE_DEVICE_AUTH, true);
    }

    public void setAdvFilterPrefix(String str) {
        this.preferences.edit().putString(KEY_ADV_FILTER_PREFIX, str).apply();
    }

    public void setBanAutoTest(boolean z) {
        this.preferences.edit().putBoolean(KEY_BAN_AUTO_TEST, z).apply();
    }

    public void setBleMtu(@IntRange(from = 20, to = 514) int i) {
        this.preferences.edit().putInt(KEY_ADJUST_BLE_MTU, i).apply();
    }

    public void setFilterDevice(boolean z) {
        this.preferences.edit().putBoolean(KEY_FILTER_DEVICE, z).apply();
    }

    public void setSppConnectWay(boolean z) {
        this.preferences.edit().putBoolean(KEY_SPP_CONNECT_WAY, z).apply();
    }

    public void setTempConnectWay(int i) {
        SharedPreferences.Editor edit = this.preferences.edit();
        if (i < 0) {
            edit.remove(KEY_TEMP_CONNECT_WAY).apply();
        } else {
            edit.putInt(KEY_TEMP_CONNECT_WAY, i);
        }
        edit.apply();
    }

    public void setTestFileBrowse(boolean z) {
        this.preferences.edit().putBoolean(KEY_TEST_FILE_BROWSE, z).apply();
    }

    public void setTestFileTransfer(boolean z) {
        this.preferences.edit().putBoolean(KEY_TEST_FILE_TRANSFER, z).apply();
    }

    public void setTestMessageSync(boolean z) {
        this.preferences.edit().putBoolean(KEY_TEST_MESSAGE_SYNC, z).apply();
    }

    public void setTestOTA(boolean z) {
        this.preferences.edit().putBoolean(KEY_TEST_OTA, z).apply();
    }

    public void setTestSmallFileTransfer(boolean z) {
        this.preferences.edit().putBoolean(KEY_TEST_SMALL_FILE_TRANSFER, z).apply();
    }

    public void setTestWatchOp(boolean z) {
        this.preferences.edit().putBoolean(KEY_TEST_WATCH_OP, z).apply();
    }

    public void setUseDeviceAuth(boolean z) {
        this.preferences.edit().putBoolean(KEY_USE_DEVICE_AUTH, z).apply();
    }
}
