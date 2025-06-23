package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.FeedBackDialog;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_if;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.image.ImageManager;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.image.util.ScaleMode;
import com.alimm.tanx.core.image.util.TanxDrawable;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxRewardUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.TanxCountDownTimer;
import java.util.List;
import java.util.Map;

public class RewardPortraitActivity extends Activity implements NotConfused {
    private final int SLIDE_CALCULATE_INTERVAL = 5;
    private final String TAG = "RewardPortraitActivity";
    /* access modifiers changed from: private */
    public tanxc_if errorPopupWindow;
    private ExitRetentionDialog exitRetentionDialog;
    private FeedBackDialog feedBackDialog;
    /* access modifiers changed from: private */
    public LinearLayout flWeb;
    private volatile boolean isFront = false;
    volatile boolean isHsUt = false;
    private boolean isSendRewardArrived = false;
    /* access modifiers changed from: private */
    public ImageView ivAdLogo;
    private ImageView ivVoice;
    private volatile int lastWebViewSlideDistance = 0;
    private LinearLayout llRewardVideoPlay;
    /* access modifiers changed from: private */
    public TanxRewardAdView mAdView;
    /* access modifiers changed from: private */
    public TanxCountDownTimer mCountDownTimer;
    /* access modifiers changed from: private */
    public ITanxRewardVideoAd mTanxAd;
    private volatile int nowCalculateNoSlide = 0;
    private int nowVoiceRes = R.mipmap.ic_voice;
    /* access modifiers changed from: private */
    public volatile int nowWebViewSlideDistance = 0;
    private String reqID;
    /* access modifiers changed from: private */
    public RewardWebViewUtil.RewardInterface rewardInterface;
    /* access modifiers changed from: private */
    public volatile boolean startTimerSwitch = false;
    /* access modifiers changed from: private */
    public tanxc_new tanxRewardVideoExpressAd;
    /* access modifiers changed from: private */
    public volatile boolean timerFinishSwitch = false;
    /* access modifiers changed from: private */
    public TextView tvRewardCountDownTxt;
    /* access modifiers changed from: private */
    public TextView tvRewardVideoCountDown;
    private RewardWebViewUtil webViewUtil;

    public static /* synthetic */ int access$1404(RewardPortraitActivity rewardPortraitActivity) {
        int i = rewardPortraitActivity.nowCalculateNoSlide + 1;
        rewardPortraitActivity.nowCalculateNoSlide = i;
        return i;
    }

    /* access modifiers changed from: private */
    public void adCloseUpload() {
        ITanxRewardVideoAd iTanxRewardVideoAd = this.mTanxAd;
        if (iTanxRewardVideoAd != null && iTanxRewardVideoAd.getBidInfo() != null && this.mTanxAd.getBidInfo().getEventTrack() != null) {
            InteractionUpload instance = InteractionUpload.getInstance();
            List<NewTrackItem> eventTrack = this.mTanxAd.getBidInfo().getEventTrack();
            InteractionUpload.getInstance();
            instance.uploadInteraction(eventTrack, 3);
        }
    }

    private void adCloseUtAndUpload() {
        RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_if(2);
        }
        adCloseUpload();
    }

    private void bindMonitor() {
        this.mTanxAd.bindRewardVideoAdView(this.mAdView, new ITanxInteractionListener<ITanxRewardVideoAd>() {
            public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxAd iTanxAd) {
                tanxc_do();
            }

            public void tanxc_do() {
                LogUtils.d("RewardPortraitActivity", "onAdClicked");
            }

            /* renamed from: tanxc_do */
            public void onAdShow(ITanxRewardVideoAd iTanxRewardVideoAd) {
                LogUtils.d("RewardPortraitActivity", "onAdShow");
                if (RewardPortraitActivity.this.tanxRewardVideoExpressAd != null && RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() != null) {
                    RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onAdShow(iTanxRewardVideoAd);
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
            tanxc_new tanxc_new = (tanxc_new) tanxc_if.tanxc_do.get(this.reqID);
            this.tanxRewardVideoExpressAd = tanxc_new;
            if (tanxc_new == null) {
                return false;
            }
            this.mTanxAd = tanxc_new.tanxc_if;
            return true;
        } catch (Exception e) {
            LogUtils.e(e);
            return false;
        }
    }

    private long getTimeCount() {
        try {
            ITanxRewardVideoAd iTanxRewardVideoAd = this.mTanxAd;
            if (iTanxRewardVideoAd == null || iTanxRewardVideoAd.getBidInfo() == null || this.mTanxAd.getBidInfo().getTemplateConf() == null || TextUtils.isEmpty(this.mTanxAd.getBidInfo().getTemplateConf().getCountDown())) {
                return 30;
            }
            return Long.parseLong(this.mTanxAd.getBidInfo().getTemplateConf().getCountDown()) / 1000;
        } catch (Exception e) {
            LogUtils.e(e);
            return 30;
        }
    }

    private void init() {
        this.llRewardVideoPlay = (LinearLayout) findViewById(R.id.ll_reward_video_play);
        this.ivVoice = (ImageView) findViewById(R.id.iv_voice);
        this.ivAdLogo = (ImageView) findViewById(R.id.iv_ad_logo);
        this.mAdView = (TanxRewardAdView) findViewById(R.id.root_view);
        this.flWeb = (LinearLayout) findViewById(R.id.fl_reward_video_portrait_wb);
        this.tvRewardVideoCountDown = (TextView) findViewById(R.id.tv_reward_count_down);
        this.tvRewardCountDownTxt = (TextView) findViewById(R.id.tv_reward_count_down_txt);
        TextView textView = this.tvRewardVideoCountDown;
        textView.setText(getTimeCount() + "s");
    }

    private void initView() {
        initWeb();
        ITanxRewardVideoAd iTanxRewardVideoAd = this.mTanxAd;
        if (iTanxRewardVideoAd != null && iTanxRewardVideoAd.getBidInfo() != null && this.mTanxAd.getBidInfo().getCreativeItem() != null && !TextUtils.isEmpty(this.mTanxAd.getBidInfo().getCreativeItem().getAdvLogo())) {
            final ImageConfig build = ImageManager.with(this.ivAdLogo.getContext()).url(this.mTanxAd.getBidInfo().getCreativeItem().getAdvLogo()).scaleMode(ScaleMode.FIT_CENTER).build();
            ImageManager.getLoader().load(build, new ImageConfig.ImageBitmapCallback() {
                public void onFailure(String str) {
                    RewardPortraitActivity.this.ivAdLogo.setVisibility(8);
                }

                public void onSuccess(Bitmap bitmap) {
                    RewardPortraitActivity.this.ivAdLogo.setImageBitmap(bitmap);
                    RewardPortraitActivity.this.ivAdLogo.setVisibility(0);
                    RewardPortraitActivity.this.ivAdLogo.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
                }
            });
        }
    }

    private void initWeb() {
        this.webViewUtil = new RewardWebViewUtil();
        this.rewardInterface = new RewardWebViewUtil.RewardInterface() {
            public void adClose() {
                RewardPortraitActivity.this.adCloseUpload();
                RewardPortraitActivity.this.finish();
            }

            public void adSkip(boolean z) {
                if (!(RewardPortraitActivity.this.tanxRewardVideoExpressAd == null || RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() == null)) {
                    RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onSkippedVideo();
                }
                if (z) {
                    RewardPortraitActivity.this.adCloseUpload();
                    RewardPortraitActivity.this.finish();
                }
            }

            public long getCurrentTime() {
                return 0;
            }

            public String getPlayState() {
                return null;
            }

            public long getTotalTime() {
                return 0;
            }

            public void h5NotifyDrawSuccess() {
                LogUtils.d("RewardPortraitActivity", "h5NotifyDrawSuccess");
                RewardPortraitActivity.this.flWeb.post(new Runnable() {
                    public void run() {
                        if (RewardPortraitActivity.this.errorPopupWindow != null && RewardPortraitActivity.this.errorPopupWindow.tanxc_do()) {
                            RewardPortraitActivity.this.errorPopupWindow.tanxc_if();
                        }
                    }
                });
            }

            public void onScroll(int i, int i2) {
                int unused = RewardPortraitActivity.this.nowWebViewSlideDistance = i2;
                RewardPortraitActivity.this.startTimer();
            }

            public void setPlayer(Boolean bool, Boolean bool2) {
            }

            public void webDrawStatus(boolean z) {
                if (z) {
                    RewardPortraitActivity.this.mTanxAd.onResourceLoadSuccess();
                    LogUtils.d("utLog", "utViewDraw");
                    TanxRewardUt.utViewDraw(RewardPortraitActivity.this.mTanxAd, 1);
                    return;
                }
                RewardPortraitActivity.this.showErrorDialog();
                if (!RewardPortraitActivity.this.isHsUt) {
                    TanxBaseUt.utErrorCode(RewardPortraitActivity.this.mTanxAd, UtErrorCode.CRASH_H5_ERROR);
                    RewardPortraitActivity.this.isHsUt = true;
                }
            }

            public void webError(int i, String str) {
                LogUtils.e("RewardPortraitActivity", "webError: cmd :" + i + " msg:" + str);
                RewardPortraitActivity.this.showErrorDialog();
            }

            public void webNotifyCountDown(int i, int i2) {
            }
        };
        this.webViewUtil.tanxc_do(this.flWeb, this.mTanxAd.getBidInfo(), this.mTanxAd.getAdSlot(), this.tanxRewardVideoExpressAd, this.rewardInterface);
    }

    /* access modifiers changed from: private */
    public boolean isDialogShow() {
        ExitRetentionDialog exitRetentionDialog2 = this.exitRetentionDialog;
        if (exitRetentionDialog2 != null && exitRetentionDialog2.isShowing()) {
            return true;
        }
        FeedBackDialog feedBackDialog2 = this.feedBackDialog;
        if (feedBackDialog2 == null || !feedBackDialog2.isShowing()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean isSlide() {
        if (this.lastWebViewSlideDistance == this.nowWebViewSlideDistance) {
            return false;
        }
        this.lastWebViewSlideDistance = this.nowWebViewSlideDistance;
        this.nowCalculateNoSlide = 0;
        return true;
    }

    /* access modifiers changed from: private */
    public void rewardArrived() {
        try {
            LogUtils.d("RewardPortraitActivity", "开始判断发奖 isSendRewardArrived:" + this.isSendRewardArrived);
            if (!this.isSendRewardArrived) {
                LogUtils.d("RewardPortraitActivity", "触发发奖");
                this.isSendRewardArrived = true;
                TanxRewardUt.utIsRewardValid(this.mTanxAd, 0);
                this.tanxRewardVideoExpressAd.tanxc_for().onVideoComplete();
                this.tanxRewardVideoExpressAd.tanxc_for().onRewardArrived(true, 0, (Map<String, Object>) null);
            }
        } catch (Exception e) {
            LogUtils.e("RewardPortraitActivity", e);
        }
    }

    /* access modifiers changed from: private */
    public void showErrorDialog() {
        if (this.errorPopupWindow == null) {
            this.errorPopupWindow = new tanxc_if(this);
        }
        this.flWeb.postDelayed(new Runnable() {
            public void run() {
                RewardPortraitActivity.this.errorPopupWindow.tanxc_do(RewardPortraitActivity.this.mAdView, new View.OnClickListener() {
                    public void onClick(View view) {
                        RewardPortraitActivity.this.errorPopupWindow.tanxc_if();
                        RewardPortraitActivity.this.finish();
                    }
                });
            }
        }, 200);
    }

    private void showExitRetentionDialog() {
        ITanxRewardVideoAd iTanxRewardVideoAd;
        if (this.isSendRewardArrived || (iTanxRewardVideoAd = this.mTanxAd) == null || iTanxRewardVideoAd.getBidInfo() == null || this.mTanxAd.getBidInfo().getTemplateConf() == null || (!TextUtils.isEmpty(this.mTanxAd.getBidInfo().getTemplateConf().getBackPop()) && this.mTanxAd.getBidInfo().getTemplateConf().getBackPop().equals("0"))) {
            RewardWebViewUtil.RewardInterface rewardInterface2 = this.rewardInterface;
            if (rewardInterface2 != null) {
                rewardInterface2.adClose();
            }
            finish();
            return;
        }
        ExitRetentionDialog exitRetentionDialog2 = new ExitRetentionDialog(this, R.style.CommonDialog);
        this.exitRetentionDialog = exitRetentionDialog2;
        exitRetentionDialog2.setClickCallBack(new ExitRetentionDialog.ClickCallBack() {
            public void continueClick() {
                TanxRewardUt.utSavePopPresist(RewardPortraitActivity.this.tanxRewardVideoExpressAd);
            }

            public void exitClick() {
                TanxRewardUt.utSavePopCancel(RewardPortraitActivity.this.tanxRewardVideoExpressAd);
                if (RewardPortraitActivity.this.rewardInterface != null) {
                    RewardPortraitActivity.this.rewardInterface.adClose();
                }
                RewardPortraitActivity.this.finish();
            }
        });
        this.exitRetentionDialog.show();
        TanxRewardUt.utSavePopImp(this.tanxRewardVideoExpressAd);
    }

    /* access modifiers changed from: private */
    public void startTimer() {
        if (this.timerFinishSwitch || isDialogShow() || !isSlide() || !this.isFront) {
            return;
        }
        if (this.startTimerSwitch) {
            TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
            if (tanxCountDownTimer != null && tanxCountDownTimer.isPaused()) {
                LogUtils.d("startTimer", "倒计时resume()");
                this.mCountDownTimer.resume();
                return;
            }
            return;
        }
        this.mCountDownTimer = new TanxCountDownTimer(1000 * getTimeCount(), 1000) {
            public void onFinish() {
                LogUtils.d("startTimer", "onFinish");
                RewardPortraitActivity.this.tvRewardVideoCountDown.setVisibility(8);
                RewardPortraitActivity.this.tvRewardCountDownTxt.setText("已领取");
                RewardPortraitActivity.this.rewardArrived();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) RewardPortraitActivity.this.tvRewardCountDownTxt.getLayoutParams();
                marginLayoutParams.leftMargin = (int) TypedValue.applyDimension(1, 8.0f, RewardPortraitActivity.this.getResources().getDisplayMetrics());
                RewardPortraitActivity.this.tvRewardCountDownTxt.setLayoutParams(marginLayoutParams);
                boolean unused = RewardPortraitActivity.this.timerFinishSwitch = true;
                boolean unused2 = RewardPortraitActivity.this.startTimerSwitch = false;
            }

            public void onTick(long j) {
                if (RewardPortraitActivity.this.isDialogShow()) {
                    RewardPortraitActivity.this.mCountDownTimer.pause();
                }
                if (!RewardPortraitActivity.this.isSlide() && RewardPortraitActivity.access$1404(RewardPortraitActivity.this) >= 5) {
                    RewardPortraitActivity.this.mCountDownTimer.pause();
                }
                int round = Math.round(((float) j) / 1000.0f);
                if (RewardPortraitActivity.this.tvRewardVideoCountDown != null) {
                    TextView access$1500 = RewardPortraitActivity.this.tvRewardVideoCountDown;
                    access$1500.setText(round + "s");
                }
                LogUtils.d("startTimer", round + "");
            }
        };
        LogUtils.d("startTimer", "启动倒计时");
        this.mCountDownTimer.start();
        this.startTimerSwitch = true;
    }

    private void timerCancel(boolean z) {
        try {
            LogUtils.e("RewardPortraitActivity", "adCloseTimerCancel");
            if (z) {
                TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
                if (tanxCountDownTimer != null) {
                    tanxCountDownTimer.cancel();
                    this.mCountDownTimer = null;
                }
                this.startTimerSwitch = false;
                return;
            }
            TanxCountDownTimer tanxCountDownTimer2 = this.mCountDownTimer;
            if (tanxCountDownTimer2 != null) {
                tanxCountDownTimer2.pause();
            }
        } catch (Exception e) {
            LogUtils.e("timerCancel", e);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ll_reward_video_feed_back) {
            FeedBackDialog feedBackDialog2 = new FeedBackDialog(this, R.style.CommonDialog, this.mTanxAd);
            this.feedBackDialog = feedBackDialog2;
            feedBackDialog2.show();
            TanxRewardUt.utFeedbackPopImp(this.tanxRewardVideoExpressAd);
        } else if (id == R.id.iv_voice) {
            int i = this.nowVoiceRes;
            int i2 = R.mipmap.ic_voice;
            if (i == i2) {
                i2 = R.mipmap.ic_mute;
            }
            this.ivVoice.setImageResource(i2);
            this.nowVoiceRes = i2;
        } else if (id == R.id.ll_reward_video_play) {
            this.llRewardVideoPlay.setVisibility(8);
        } else if (id == R.id.btn_pre_load_h5) {
            this.mCountDownTimer.cancel();
            this.mCountDownTimer.resume();
        } else if (id == R.id.btn_send_play_state) {
            RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_do("2123");
            }
        } else if (id == R.id.btn_send_audio) {
            RewardWebViewUtil rewardWebViewUtil2 = this.webViewUtil;
            if (rewardWebViewUtil2 != null) {
                rewardWebViewUtil2.tanxc_do(0);
            }
        } else if (id == R.id.btn_force_close) {
            adCloseUtAndUpload();
            finish();
        } else if (id == R.id.iv_force_close) {
            adCloseUtAndUpload();
            finish();
        } else if (id == R.id.ll_reward_video_ad_count_down) {
            showExitRetentionDialog();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_reward_portrait);
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
            tanxc_if.tanxc_do(this.reqID);
            tanxc_new tanxc_new = this.tanxRewardVideoExpressAd;
            if (!(tanxc_new == null || tanxc_new.tanxc_for() == null)) {
                this.tanxRewardVideoExpressAd.tanxc_for().onAdClose();
            }
            RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_if();
            }
            timerCancel(true);
        } catch (Exception e) {
            LogUtils.e("RewardPortraitActivity", LogUtils.getStackTraceMessage(e));
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "RewardPortraitActivity", LogUtils.getStackTraceMessage(e), "");
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return true;
    }

    public void onPause() {
        LogUtils.d("RewardPortraitActivity", "onPause");
        super.onPause();
        this.isFront = false;
        timerCancel(false);
        if (this.webViewUtil != null) {
            LogUtils.d("RewardPortraitActivity", "webViewUtil onPause");
            this.webViewUtil.tanxc_for();
        }
    }

    public void onResume() {
        super.onResume();
        this.isFront = true;
        RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_int();
        }
    }
}
