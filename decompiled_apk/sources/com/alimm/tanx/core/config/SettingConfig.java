package com.alimm.tanx.core.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.Serializable;

/* loaded from: classes.dex */
public class SettingConfig implements Serializable {

    @JSONField(serialize = false)
    private static final int MAX_TITLE_SIZE = 28;

    @JSONField(serialize = false)
    private static final int MIN_TITLE_SIZE = 5;
    private String TAG = "SettingConfig";
    private boolean nightSwitch = false;
    private boolean customTitleSizeSwitch = false;
    private boolean customTextSizeDpSwitch = true;
    private int customTitleSize = -1;

    @JSONField(serialize = false)
    public void clearTitleSize() {
        LogUtils.d(this.TAG, "clearTitleSize：");
        this.customTitleSizeSwitch = false;
        this.customTextSizeDpSwitch = true;
        this.customTitleSize = -1;
    }

    public int getCustomTitleSize() {
        return this.customTitleSize;
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig getNightConfig() {
        return this;
    }

    public boolean isCustomTextSizeDpSwitch() {
        return this.customTextSizeDpSwitch;
    }

    public boolean isCustomTitleSizeSwitch() {
        LogUtils.d(this.TAG, "isCustomTitleSizeSwitch：" + this.customTitleSizeSwitch);
        return this.customTitleSizeSwitch;
    }

    public boolean isNightSwitch() {
        return this.nightSwitch;
    }

    public void setCustomTextSizeDpSwitch(boolean z) {
        this.customTextSizeDpSwitch = z;
    }

    public void setCustomTitleSize(int i) {
        this.customTitleSize = i;
    }

    public void setCustomTitleSizeSwitch(boolean z) {
        this.customTitleSizeSwitch = z;
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig setDefaultConfig(String str, String str2) {
        return this;
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig setNightConfig(String str, String str2) {
        return this;
    }

    public void setNightSwitch(boolean z) {
        LogUtils.d(this.TAG, "setNightSwitch：");
        this.nightSwitch = z;
    }

    @JSONField(serialize = false)
    public void setTitleSize(int i) {
        LogUtils.d(this.TAG, "setTitleSize：" + i);
        this.customTitleSizeSwitch = true;
        this.customTextSizeDpSwitch = false;
        this.customTitleSize = i;
        if (i < 5) {
            this.customTitleSize = 5;
        } else if (i > 28) {
            this.customTitleSize = 28;
        }
    }

    @JSONField(serialize = false)
    public void setTitleSizeDp(int i) {
        LogUtils.d(this.TAG, "setTitleSizeDp：" + i);
        this.customTitleSizeSwitch = true;
        this.customTextSizeDpSwitch = true;
        this.customTitleSize = i;
        if (i < 5) {
            this.customTitleSize = 5;
        } else if (i > 28) {
            this.customTitleSize = 28;
        }
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig setDefaultConfig() {
        return setDefaultConfig("", "");
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig setNightConfig() {
        return setNightConfig("", "");
    }
}
