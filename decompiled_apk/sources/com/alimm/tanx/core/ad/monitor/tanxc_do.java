package com.alimm.tanx.core.ad.monitor;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.constant.AdConstants;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.ExposureConfigBean;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.TanxCountDownTimer;

/* loaded from: classes.dex */
public class tanxc_do implements ViewTreeObserver.OnPreDrawListener, ITanxAdMonitor {
    private long tanxc_break;
    protected volatile boolean tanxc_byte;
    protected float tanxc_case;
    private long tanxc_catch;
    protected long tanxc_char;
    private final int tanxc_class;
    protected TanxAdView tanxc_do;
    protected boolean tanxc_else;
    protected boolean tanxc_for;
    protected Rect tanxc_goto;
    protected ITanxExposureCallback tanxc_if;
    protected boolean tanxc_int;
    protected String tanxc_long;
    protected boolean tanxc_new;
    private volatile TanxCountDownTimer tanxc_this;
    protected volatile boolean tanxc_try;
    private long tanxc_void;

    public tanxc_do(TanxAdView tanxAdView, ITanxExposureCallback iTanxExposureCallback, int i) {
        this.tanxc_for = false;
        this.tanxc_int = true;
        this.tanxc_try = false;
        this.tanxc_byte = false;
        this.tanxc_else = true;
        this.tanxc_break = 500L;
        this.tanxc_catch = 0L;
        this.tanxc_goto = new Rect();
        this.tanxc_long = "";
        this.tanxc_do = tanxAdView;
        this.tanxc_if = iTanxExposureCallback;
        this.tanxc_class = i;
        tanxc_if();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_break() {
        try {
            LogUtils.d("TanxAdMonitor", "cancelTimer");
            if (!OrangeManager.getInstance().getCommonSwitch("useRealTimeExposer")) {
                LogUtils.d("TanxAdMonitor", "cancelTimer 开关关闭");
            } else if (this.tanxc_this != null) {
                this.tanxc_this.cancel();
                this.tanxc_this = null;
            }
        } catch (Exception e) {
            LogUtils.e("TanxAdMonitor", "cancelTimer", e);
        }
    }

    private void tanxc_long() {
        try {
            LogUtils.d("TanxAdMonitor", "initTimer  init");
            if (!OrangeManager.getInstance().getCommonSwitch("useRealTimeExposer")) {
                LogUtils.d("TanxAdMonitor", "initTimer 开关关闭");
            } else {
                if (this.tanxc_this != null) {
                    return;
                }
                LogUtils.d("TanxAdMonitor", "initTimer  init start");
                final long j = 180000;
                final long j2 = 200;
                this.tanxc_this = new TanxCountDownTimer(j, j2) { // from class: com.alimm.tanx.core.ad.monitor.TanxAdMonitor$1
                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onFinish() {
                        LogUtils.d("TanxAdMonitor", "initTimer - onFinish");
                    }

                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onTick(long j3) {
                        LogUtils.d("TanxAdMonitor", "initTimer  onTick exposureCompleted: " + tanxc_do.this.tanxc_byte + " isOnExposure: " + tanxc_do.this.tanxc_try);
                        if (tanxc_do.this.tanxc_byte) {
                            tanxc_do.this.tanxc_break();
                        } else if (tanxc_do.this.tanxc_try) {
                            tanxc_do.this.onPreDraw();
                        }
                    }
                };
            }
        } catch (Exception e) {
            LogUtils.e("TanxAdMonitor", "initTimer", e);
        }
    }

    private void tanxc_this() {
        try {
            LogUtils.d("TanxAdMonitor", "startTimer");
            if (!OrangeManager.getInstance().getCommonSwitch("useRealTimeExposer")) {
                LogUtils.d("TanxAdMonitor", "startTimer 开关关闭");
                return;
            }
            if (this.tanxc_byte) {
                LogUtils.d("TanxAdMonitor", "startTimer 已经曝光，不再重复启动");
                return;
            }
            tanxc_long();
            if (this.tanxc_this != null) {
                if (this.tanxc_this.isPaused()) {
                    LogUtils.d("TanxAdMonitor", "startTimer resume");
                    this.tanxc_this.resume();
                    return;
                } else {
                    LogUtils.d("TanxAdMonitor", "startTimer start");
                    this.tanxc_this.start();
                    return;
                }
            }
            LogUtils.d("TanxAdMonitor", "startTimer tanxExposureCheckTimer为空");
        } catch (Exception e) {
            LogUtils.e("TanxAdMonitor", "startTimer", e);
        }
    }

    private void tanxc_void() {
        try {
            LogUtils.d("TanxAdMonitor", "stopTimer");
            if (!OrangeManager.getInstance().getCommonSwitch("useRealTimeExposer")) {
                LogUtils.d("TanxAdMonitor", "stopTimer 开关关闭");
            } else if (this.tanxc_this != null) {
                this.tanxc_this.pause();
            }
        } catch (Exception e) {
            LogUtils.e("TanxAdMonitor", "stopTimer", e);
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onAttachedToWindow() {
        this.tanxc_for = true;
        this.tanxc_do.getViewTreeObserver().addOnPreDrawListener(this);
        tanxc_long();
        LogUtils.d("TanxAdMonitor_Lifecycle", "广告onAttachedToWindow");
    }

    @Override // com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onDetachedFromWindow() {
        this.tanxc_for = false;
        this.tanxc_do.getViewTreeObserver().removeOnPreDrawListener(this);
        LogUtils.d("TanxAdMonitor_Lifecycle", "广告onDetachedFromWindow");
        tanxc_new();
        tanxc_break();
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean z;
        if (this.tanxc_do.getLocalVisibleRect(this.tanxc_goto) && this.tanxc_do.isShown()) {
            z = true;
        } else {
            z = false;
        }
        LogUtils.i("TanxAdMonitor", "onPreDraw isVisible->" + z + " showRatio：" + this.tanxc_case);
        if (!z) {
            tanxc_new();
            return true;
        }
        if (this.tanxc_case > 0.0f) {
            if (Math.abs(this.tanxc_goto.height()) > this.tanxc_do.getHeight() * this.tanxc_case && Math.abs(this.tanxc_goto.width()) > this.tanxc_do.getWidth() * this.tanxc_case) {
                LogUtils.i("TanxAdMonitor", "满足曝光面积");
                tanxc_for();
            } else {
                tanxc_new();
            }
        } else {
            tanxc_for();
        }
        return true;
    }

    @Override // com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onVisibilityAggregated(boolean z) {
        this.tanxc_new = z;
        if (!z) {
            LogUtils.d("TanxAdMonitor_Lifecycle", "广告变为不可见");
            tanxc_new();
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onWindowFocusChanged(boolean z) {
        this.tanxc_int = z;
        LogUtils.d("TanxAdMonitor_Lifecycle", "广告焦点发生变化，onWindowFocusChanged=" + z);
        tanxc_new();
        if (z) {
            onPreDraw();
        }
    }

    public void tanxc_byte() {
        this.tanxc_try = true;
        this.tanxc_void = System.currentTimeMillis();
    }

    public void tanxc_case() {
        this.tanxc_try = false;
    }

    public boolean tanxc_char() {
        String str;
        LogUtils.d("TanxAdMonitor-Cover", "checkCover开始计算遮挡比例,adType:" + this.tanxc_class);
        ExposureConfigBean exposureConfigBean = OrangeManager.getInstance().getExposureConfigBean(this.tanxc_class);
        boolean z = true;
        if (exposureConfigBean != null && exposureConfigBean.checkCoverSwitch) {
            if (System.currentTimeMillis() - this.tanxc_catch < this.tanxc_break) {
                LogUtils.d("TanxAdMonitor-Cover", "checkCover时间间隔条件触发熔断，直接返回coverBoolean：" + this.tanxc_else);
                return this.tanxc_else;
            }
            this.tanxc_catch = System.currentTimeMillis();
            if (!this.tanxc_byte) {
                long currentTimeMillis = System.currentTimeMillis();
                float tanxc_else = tanxc_else();
                if (tanxc_else > 1.0f - this.tanxc_case) {
                    z = false;
                }
                this.tanxc_else = z;
                LogUtils.d("TanxAdMonitor-Cover", "checkCover-coverFloat:" + tanxc_else + ",coverBoolean:" + this.tanxc_else + ",耗时：" + (System.currentTimeMillis() - currentTimeMillis));
            } else {
                LogUtils.d("TanxAdMonitor-Cover", "checkCover-已经曝光，不再计算遮挡比例");
                this.tanxc_else = true;
            }
            return this.tanxc_else;
        }
        StringBuilder sb = new StringBuilder();
        if (exposureConfigBean == null) {
            str = "exposureConfigBean==null";
        } else {
            str = "checkCoverSwitch为false";
        }
        sb.append(str);
        sb.append("，终止检测。adType:");
        sb.append(this.tanxc_class);
        LogUtils.d("TanxAdMonitor-Cover", sb.toString());
        return true;
    }

    public float tanxc_else() {
        if (this.tanxc_do.getVisibility() != 0) {
            return 1.0f;
        }
        View view = this.tanxc_do;
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return 1.0f;
        }
        int measuredHeight = (this.tanxc_do.getMeasuredHeight() * this.tanxc_do.getMeasuredWidth()) - (rect.width() * rect.height());
        float f = 0.0f;
        while (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.getVisibility() != 0) {
                return 1.0f;
            }
            int tanxc_do = tanxc_do(view, viewGroup);
            while (true) {
                tanxc_do++;
                if (tanxc_do < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(tanxc_do);
                    if (childAt.getVisibility() != 0) {
                        break;
                    }
                    Rect rect2 = new Rect();
                    this.tanxc_do.getGlobalVisibleRect(rect2);
                    Rect rect3 = new Rect();
                    childAt.getGlobalVisibleRect(rect3);
                    if (rect3.intersect(rect2)) {
                        f = Math.max(f, ((rect3.width() * rect3.height()) + measuredHeight) / ((rect2.width() * rect2.height()) * 1.0f));
                    }
                }
            }
            view = viewGroup;
        }
        return Math.round(f * 100.0f) / 100.0f;
    }

    public void tanxc_for() {
        boolean z;
        if (this.tanxc_do.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        this.tanxc_new = z;
        LogUtils.i("TanxAdMonitor", "tryStartExposure 尝试开始曝光计时，相关数据：attachedWindow=" + this.tanxc_for + "; hasWindowFocus" + this.tanxc_int + "; visibilityAggregated" + this.tanxc_new + "; isOnExposure=" + this.tanxc_try);
        if (this.tanxc_for && this.tanxc_int && this.tanxc_new && tanxc_char()) {
            if (!this.tanxc_try) {
                tanxc_byte();
                LogUtils.i("TanxAdMonitor", "开始曝光计时showTime:" + this.tanxc_char);
            }
            tanxc_int();
        }
        tanxc_this();
    }

    public boolean tanxc_goto() {
        return this.tanxc_for;
    }

    public void tanxc_if() {
        ExposureConfigBean exposureConfigBean = OrangeManager.getInstance().getExposureConfigBean(this.tanxc_class);
        if (exposureConfigBean == null) {
            tanxc_do();
        } else {
            this.tanxc_case = exposureConfigBean.showRatio;
            this.tanxc_char = exposureConfigBean.showTime;
        }
        if (this.tanxc_long.equals(AdConstants.PID_STYLE_NEW_REWARD_ID) || this.tanxc_long.equals(AdConstants.PID_STYLE_ORDER_REWARD_ID) || this.tanxc_long.equals(AdConstants.PID_STYLE_OPEN_TAO_BAO_REWARD_ID)) {
            LogUtils.d("TanxAdMonitor", "新激励浏览直接曝光 adType=" + this.tanxc_class + " pidStyleId=" + this.tanxc_long);
            tanxc_try();
            tanxc_do(0L);
        }
    }

    public void tanxc_int() {
        if (this.tanxc_char == 0) {
            tanxc_case();
            tanxc_try();
            tanxc_do(0L);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.tanxc_void;
        LogUtils.i("TanxAdMonitor", "tryExposure 曝光时长=" + currentTimeMillis + " showTime=" + this.tanxc_char);
        if (currentTimeMillis > this.tanxc_char) {
            tanxc_try();
            LogUtils.i("TanxAdMonitor", "tryExposure 广告曝光成功，曝光时长=" + currentTimeMillis);
        }
    }

    public void tanxc_new() {
        if (this.tanxc_try) {
            tanxc_case();
            long currentTimeMillis = System.currentTimeMillis() - this.tanxc_void;
            LogUtils.i("TanxAdMonitor", "停止曝光,曝光时长=" + currentTimeMillis + " showTime=" + this.tanxc_char);
            if (currentTimeMillis > this.tanxc_char && tanxc_char()) {
                tanxc_try();
                tanxc_do(currentTimeMillis);
                LogUtils.i("TanxAdMonitor", "广告曝光总时长=" + currentTimeMillis);
            }
        }
        tanxc_void();
    }

    public void tanxc_try() {
        if (!this.tanxc_byte) {
            this.tanxc_byte = true;
            ITanxExposureCallback iTanxExposureCallback = this.tanxc_if;
            if (iTanxExposureCallback != null) {
                iTanxExposureCallback.exposure();
            }
        }
    }

    public void tanxc_do() {
        this.tanxc_case = 0.5f;
        this.tanxc_char = 1000L;
    }

    public void tanxc_do(long j) {
        ITanxExposureCallback iTanxExposureCallback = this.tanxc_if;
        if (iTanxExposureCallback != null) {
            iTanxExposureCallback.exposureTime(j);
        }
    }

    private int tanxc_do(View view, ViewGroup viewGroup) {
        int i = 0;
        while (i < viewGroup.getChildCount() && viewGroup.getChildAt(i) != view) {
            i++;
        }
        return i;
    }

    public tanxc_do(TanxAdView tanxAdView, ITanxExposureCallback iTanxExposureCallback, int i, String str) {
        this.tanxc_for = false;
        this.tanxc_int = true;
        this.tanxc_try = false;
        this.tanxc_byte = false;
        this.tanxc_else = true;
        this.tanxc_break = 500L;
        this.tanxc_catch = 0L;
        this.tanxc_goto = new Rect();
        this.tanxc_long = "";
        this.tanxc_do = tanxAdView;
        this.tanxc_if = iTanxExposureCallback;
        this.tanxc_class = i;
        if (!TextUtils.isEmpty(str)) {
            this.tanxc_long = str;
        }
        tanxc_if();
    }
}
