package com.alimm.tanx.core.ad.ad.template.rendering.table.screen;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.FeedBackDialog;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_if;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.TanxRewardAdView;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeBean;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView;
import com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxTableScreenUt;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.TanxCountDownTimer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableScreenPortraitActivity extends Activity implements NotConfused {
    private final String TAG = "RewardPortraitActivity";
    /* access modifiers changed from: private */
    public long adStartTime = 0;
    private Button btnForceClose;
    /* access modifiers changed from: private */
    public tanxc_if errorPopupWindow;
    private LinearLayout flWeb;
    private volatile boolean isFront = false;
    /* access modifiers changed from: private */
    public volatile boolean isH5Ut = false;
    private ImageView ivAdLogo;
    /* access modifiers changed from: private */
    public ImageView ivForceClose;
    private ImageView ivVoice;
    private LinearLayout llRewardVideoPlay;
    /* access modifiers changed from: private */
    public TanxRewardAdView mAdView;
    private BidInfo mBidInfo;
    private TanxCountDownTimer mCountDownTimer;
    public long mShakeStartTime;
    /* access modifiers changed from: private */
    public ShakeView mShakeView;
    /* access modifiers changed from: private */
    public ITanxTableScreenAd mTanxAd;
    private long nowExposureTime = 0;
    private ViewStub operationButton;
    private String reqID;
    private RelativeLayout rlShake;
    private volatile boolean startTimerSwitch = false;
    /* access modifiers changed from: private */
    public tanxc_if tanxTableScreenExpressAd;
    private final boolean webCountDownOver = false;
    private TableScreenWebViewUtil webViewUtil;

    private void adCloseStartTimer() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("startTimer - startSwitch:");
        sb.append(this.startTimerSwitch);
        sb.append("  btnForceClose.Visibility：");
        if (this.btnForceClose.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        sb.append(" isFront：");
        sb.append(this.isFront);
        LogUtils.d("adCloseStartTimer", sb.toString());
        try {
            if (this.isFront && !this.startTimerSwitch) {
                if (this.btnForceClose.getVisibility() != 0) {
                    LogUtils.d("adCloseStartTimer", "不满足启动条件 webCountDownOverfalse");
                    return;
                }
            }
            LogUtils.d("adCloseStartTimer", "return");
        } catch (Exception e) {
            LogUtils.e("adCloseStartTimer", e);
        }
    }

    /* access modifiers changed from: private */
    public void adCloseUpload() {
        ITanxTableScreenAd iTanxTableScreenAd = this.mTanxAd;
        if (iTanxTableScreenAd != null && iTanxTableScreenAd.getBidInfo() != null && this.mTanxAd.getBidInfo().getEventTrack() != null) {
            InteractionUpload instance = InteractionUpload.getInstance();
            List<NewTrackItem> eventTrack = this.mTanxAd.getBidInfo().getEventTrack();
            InteractionUpload.getInstance();
            instance.uploadInteraction(eventTrack, 3);
        }
    }

    private void adCloseUtAndUpload() {
        adCloseUpload();
    }

    private void addInteractionView(@NonNull ViewGroup viewGroup) {
        this.mShakeStartTime = SystemClock.elapsedRealtime();
        showNativeShakeView(viewGroup);
        addShakeViewUt(this.mBidInfo, "table_add_interaction_view", (Map<String, String>) null);
    }

    public static void addShakeViewUt(BidInfo bidInfo, String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        TanxBaseUt.shake(str, bidInfo, (HashMap<String, Object>) null);
    }

    private void bindMonitor() {
        this.mTanxAd.bindTableScreenAdView(this.mAdView, new ITanxInteractionListener<ITanxTableScreenAd>() {
            public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxAd iTanxAd) {
                tanxc_do();
            }

            public void tanxc_do() {
                LogUtils.d("RewardPortraitActivity", "onAdClicked");
                if (TableScreenPortraitActivity.this.mTanxAd != null && TableScreenPortraitActivity.this.mTanxAd.getAdSlot() != null && TableScreenPortraitActivity.this.mTanxAd.getAdSlot().isClickAdClose()) {
                    TableScreenPortraitActivity.this.finish();
                }
            }

            /* renamed from: tanxc_do */
            public void onAdShow(ITanxTableScreenAd iTanxTableScreenAd) {
                LogUtils.d("RewardPortraitActivity", "onAdShow");
                if (TableScreenPortraitActivity.this.tanxTableScreenExpressAd != null && TableScreenPortraitActivity.this.tanxTableScreenExpressAd.tanxc_for() != null) {
                    TableScreenPortraitActivity.this.tanxTableScreenExpressAd.tanxc_for().onAdShow(iTanxTableScreenAd);
                }
            }
        });
    }

    private boolean getIntentData() {
        try {
            String stringExtra = getIntent().getStringExtra("REQ_ID");
            this.reqID = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                return false;
            }
            tanxc_if tanxc_if = (tanxc_if) com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_do.get(this.reqID);
            this.tanxTableScreenExpressAd = tanxc_if;
            if (tanxc_if == null) {
                return false;
            }
            this.mTanxAd = tanxc_if.tanxc_do;
            return true;
        } catch (Exception e) {
            LogUtils.e(e);
            return false;
        }
    }

    private void init() {
        this.llRewardVideoPlay = (LinearLayout) findViewById(R.id.ll_reward_video_play);
        this.ivVoice = (ImageView) findViewById(R.id.iv_voice);
        this.ivForceClose = (ImageView) findViewById(R.id.iv_force_close);
        this.mAdView = (TanxRewardAdView) findViewById(R.id.root_view);
        this.flWeb = (LinearLayout) findViewById(R.id.fl_reward_video_portrait_wb);
        this.rlShake = (RelativeLayout) findViewById(R.id.rl_shake);
        this.btnForceClose = (Button) findViewById(R.id.btn_force_close);
    }

    /* access modifiers changed from: private */
    public void initShake() {
        ITanxTableScreenAd iTanxTableScreenAd = this.mTanxAd;
        if (iTanxTableScreenAd != null) {
            this.mBidInfo = iTanxTableScreenAd.getBidInfo();
        }
        BidInfo bidInfo = this.mBidInfo;
        if (bidInfo != null && bidInfo.getInteractType2Shake()) {
            addInteractionView(this.rlShake);
        }
    }

    private void initView() {
        initWeb();
    }

    private void initWeb() {
        TableScreenWebViewUtil tableScreenWebViewUtil = new TableScreenWebViewUtil();
        this.webViewUtil = tableScreenWebViewUtil;
        tableScreenWebViewUtil.tanxc_do(this.flWeb, this.mTanxAd.getBidInfo(), this.mTanxAd.getAdSlot(), this.tanxTableScreenExpressAd, new TableScreenWebViewUtil.TableScreenInterface() {
            public void adClose() {
                TableScreenPortraitActivity.this.adCloseUpload();
                TableScreenPortraitActivity.this.finish();
            }

            public void adSkip(boolean z) {
            }

            public void h5NotifyDrawSuccess() {
                TableScreenPortraitActivity.this.ivForceClose.post(new Runnable() {
                    public void run() {
                        TableScreenPortraitActivity.this.initShake();
                        if (TableScreenPortraitActivity.this.errorPopupWindow != null && TableScreenPortraitActivity.this.errorPopupWindow.tanxc_do()) {
                            TableScreenPortraitActivity.this.errorPopupWindow.tanxc_if();
                        }
                        TableScreenPortraitActivity.this.ivForceClose.setVisibility(8);
                    }
                });
                long unused = TableScreenPortraitActivity.this.adStartTime = System.currentTimeMillis();
            }

            public void webDrawStatus(boolean z) {
                if (z) {
                    LogUtils.d("utLog", "utViewDraw");
                    TanxTableScreenUt.utViewDraw(TableScreenPortraitActivity.this.mTanxAd, 1);
                    return;
                }
                TanxTableScreenUt.utViewDraw(TableScreenPortraitActivity.this.mTanxAd, 0);
                if (!TableScreenPortraitActivity.this.isH5Ut) {
                    TanxBaseUt.utErrorCode(TableScreenPortraitActivity.this.mTanxAd, UtErrorCode.CRASH_H5_ERROR);
                    boolean unused = TableScreenPortraitActivity.this.isH5Ut = true;
                }
                TableScreenPortraitActivity.this.showErrorDialog();
            }

            public void webError(int i, String str) {
                LogUtils.e("RewardPortraitActivity", "webError: cmd :" + i + " msg:" + str);
                TableScreenPortraitActivity.this.showErrorDialog();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$timerCancel$6() {
        this.btnForceClose.setVisibility(8);
    }

    private void rewardArrived(int i, int i2) {
    }

    private void sendInteractionViewShowExpose() {
        HashMap hashMap = new HashMap();
        hashMap.put("table_add_interaction_view_time", String.valueOf(SystemClock.elapsedRealtime() - this.mShakeStartTime));
        TanxBaseUt.shake("add_interaction_view_time", (BidInfo) null, hashMap);
    }

    /* access modifiers changed from: private */
    public void showErrorDialog() {
        if (this.errorPopupWindow == null) {
            this.errorPopupWindow = new tanxc_if(this);
        }
        this.flWeb.postDelayed(new Runnable() {
            public void run() {
                TableScreenPortraitActivity.this.errorPopupWindow.tanxc_do(TableScreenPortraitActivity.this.mAdView, new View.OnClickListener() {
                    public void onClick(View view) {
                        TableScreenPortraitActivity.this.errorPopupWindow.tanxc_if();
                        TableScreenPortraitActivity.this.finish();
                    }
                });
            }
        }, 200);
    }

    private void showNativeShakeView(@NonNull ViewGroup viewGroup) {
        ShakeBean shakeBean;
        LogUtils.d("RewardPortraitActivity", "tableShowNativeShakeView");
        BidInfo bidInfo = this.mBidInfo;
        if (bidInfo == null || bidInfo.getTemplateConf() == null) {
            shakeBean = null;
        } else {
            shakeBean = new ShakeBean().build(this.mBidInfo.getTemplateConf());
        }
        if (this.mShakeView == null) {
            this.mShakeView = new ShakeView(this, "摇一摇跳转详情", shakeBean);
        }
        this.rlShake.setVisibility(0);
        this.mShakeView.setClickable(false);
        this.mShakeView.setOnTouchListener((View.OnTouchListener) null);
        this.mShakeView.load(new InteractiveCallback() {
            public void destroy(String str) {
                TanxCommonUt.utShakeDestroy(TableScreenPortraitActivity.this.mTanxAd, str);
            }

            public void onShake() {
                LogUtils.d("RewardPortraitActivity", "tableShowNativeShakeView 互动成功摇一摇跳转");
                TableScreenPortraitActivity tableScreenPortraitActivity = TableScreenPortraitActivity.this;
                tableScreenPortraitActivity.mShakeView.getClass();
                tableScreenPortraitActivity.onGestureInteractionEnd(true, 1, true);
            }
        }, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DimenUtil.dp2px(this, 280.0f));
        layoutParams.gravity = 80;
        viewGroup.addView(this.mShakeView, layoutParams);
        sendInteractionViewShowExpose();
    }

    private void timerCancel() {
        try {
            LogUtils.e("RewardPortraitActivity", "adCloseTimerCancel");
            TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
            if (tanxCountDownTimer != null) {
                tanxCountDownTimer.cancel();
                this.mCountDownTimer = null;
            }
            this.btnForceClose.post(new oIX0oI(this));
            this.startTimerSwitch = false;
        } catch (Exception e) {
            LogUtils.e("timerCancel", e);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ll_reward_video_feed_back) {
            new FeedBackDialog(this, R.style.CommonDialog, this.mTanxAd).show();
        } else if (id == R.id.ll_reward_video_play) {
            this.llRewardVideoPlay.setVisibility(8);
        } else if (id == R.id.iv_close) {
            finish();
        } else if (id == R.id.btn_pre_load_h5) {
            this.mCountDownTimer.cancel();
            this.mCountDownTimer.resume();
        } else if (id == R.id.btn_force_close) {
            adCloseUtAndUpload();
            finish();
        } else if (id == R.id.iv_force_close) {
            adCloseUtAndUpload();
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_table_screen_portrait);
        if (!getIntentData()) {
            LogUtils.d("RewardPortraitActivity", "getIntentData数据有问题。");
            finish();
            return;
        }
        init();
        initView();
        bindMonitor();
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_do(this.reqID);
            tanxc_if tanxc_if = this.tanxTableScreenExpressAd;
            if (!(tanxc_if == null || tanxc_if.tanxc_for() == null)) {
                this.tanxTableScreenExpressAd.tanxc_for().onAdClose();
            }
            TableScreenWebViewUtil tableScreenWebViewUtil = this.webViewUtil;
            if (tableScreenWebViewUtil != null) {
                tableScreenWebViewUtil.tanxc_if();
            }
            timerCancel();
            long j = this.nowExposureTime;
            if (j > 0) {
                TanxTableScreenUt.utRewardExposureTime(this.mTanxAd, j);
            }
        } catch (Exception e) {
            LogUtils.e("RewardPortraitActivity", LogUtils.getStackTraceMessage(e));
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "RewardPortraitActivity", LogUtils.getStackTraceMessage(e), "");
        }
    }

    public void onGestureInteractionEnd(boolean z, int i, boolean z2) {
        ITanxTableScreenAd iTanxTableScreenAd;
        long currentTimeMillis = System.currentTimeMillis();
        TableScreenWebViewUtil tableScreenWebViewUtil = this.webViewUtil;
        tableScreenWebViewUtil.getClass();
        if (currentTimeMillis - tableScreenWebViewUtil.tanxc_do >= 500) {
            this.webViewUtil.tanxc_do = System.currentTimeMillis();
            tanxc_if tanxc_if = this.tanxTableScreenExpressAd;
            if (tanxc_if != null && (iTanxTableScreenAd = tanxc_if.tanxc_do) != null) {
                iTanxTableScreenAd.shake();
                if (this.tanxTableScreenExpressAd.tanxc_for() != null) {
                    this.tanxTableScreenExpressAd.tanxc_for().onAdShake();
                    return;
                }
                return;
            }
            return;
        }
        LogUtils.d("RewardPortraitActivity", "mClickedOnce = true");
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        Button button;
        if (i != 4 || (button = this.btnForceClose) == null || button.getVisibility() != 0) {
            return true;
        }
        adCloseUtAndUpload();
        return super.onKeyUp(i, keyEvent);
    }

    public void onPause() {
        LogUtils.d("RewardPortraitActivity", "onPause");
        super.onPause();
        this.isFront = false;
        timerCancel();
        if (this.webViewUtil != null) {
            LogUtils.d("RewardPortraitActivity", "webViewUtil onPause");
            this.webViewUtil.tanxc_for();
        }
        if (this.adStartTime > 0) {
            this.nowExposureTime += System.currentTimeMillis() - this.adStartTime;
        }
    }

    public void onResume() {
        super.onResume();
        this.isFront = true;
        TableScreenWebViewUtil tableScreenWebViewUtil = this.webViewUtil;
        if (tableScreenWebViewUtil != null) {
            tableScreenWebViewUtil.tanxc_int();
        }
        adCloseStartTimer();
        if (this.adStartTime > 0) {
            this.adStartTime = System.currentTimeMillis();
        }
    }
}
