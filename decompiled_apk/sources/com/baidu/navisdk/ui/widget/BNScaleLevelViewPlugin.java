package com.baidu.navisdk.ui.widget;

import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes8.dex */
public class BNScaleLevelViewPlugin {
    private static final int DEFAULT_DELAY_TIME = 1000;
    private long mSwitchModeDelayTime;
    private f mSwitchModeTask;
    private int mode;
    private SwitchModeCallback modeCallback;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface ScaleViewMode {
        public static final int LOGO = 1;
        public static final int NORMAL = 2;
    }

    /* loaded from: classes8.dex */
    public interface SwitchModeCallback {
        void switchMode(int i);
    }

    public BNScaleLevelViewPlugin(SwitchModeCallback switchModeCallback) {
        this.mode = 2;
        this.mSwitchModeDelayTime = 1000L;
        this.modeCallback = switchModeCallback;
    }

    private void cancelTask() {
        if (this.mSwitchModeTask != null) {
            c.a().a((g) this.mSwitchModeTask, true);
        }
    }

    private void checkSwitchModeDelayTime() {
        if (this.mSwitchModeDelayTime < 0) {
            this.mSwitchModeDelayTime = 1000L;
        }
    }

    private f getSwitchModeTask() {
        if (this.mSwitchModeTask == null) {
            this.mSwitchModeTask = new f("BNScaleLevelView-Task", null) { // from class: com.baidu.navisdk.ui.widget.BNScaleLevelViewPlugin.1
                @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
                public Object execute() {
                    BNScaleLevelViewPlugin bNScaleLevelViewPlugin = BNScaleLevelViewPlugin.this;
                    bNScaleLevelViewPlugin.switchMode(bNScaleLevelViewPlugin.mode);
                    return null;
                }
            };
        }
        return this.mSwitchModeTask;
    }

    private void submitTask() {
        checkSwitchModeDelayTime();
        c.a().a(getSwitchModeTask(), new e(9, 0), this.mSwitchModeDelayTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchMode(int i) {
        SwitchModeCallback switchModeCallback = this.modeCallback;
        if (switchModeCallback != null) {
            switchModeCallback.switchMode(i);
        }
    }

    public void release() {
        if (this.mSwitchModeTask != null) {
            c.a().a((g) this.mSwitchModeTask, true);
        }
        this.modeCallback = null;
    }

    public void setSwitchModeCallback(SwitchModeCallback switchModeCallback) {
        this.modeCallback = switchModeCallback;
    }

    public void setSwitchModeDelayTime(long j) {
        this.mSwitchModeDelayTime = j;
    }

    public void switchScaleViewMode(int i) {
        this.mode = i;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("switchScaleViewMode", "newMode:" + i);
        }
        if (this.mSwitchModeDelayTime > 0) {
            cancelTask();
            if (i == 2) {
                switchMode(2);
                return;
            } else {
                submitTask();
                return;
            }
        }
        switchMode(i);
    }

    public BNScaleLevelViewPlugin(SwitchModeCallback switchModeCallback, long j) {
        this.mode = 2;
        this.modeCallback = switchModeCallback;
        this.mSwitchModeDelayTime = j;
    }
}
