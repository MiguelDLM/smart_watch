package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.FeedBackDialog;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxPlayerError;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxRewardUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.TanxCountDownTimer;
import com.alimm.tanx.core.utils.VideoCacheManager;
import com.alimm.tanx.core.view.player.VideoScaleMode;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.alimm.tanx.core.view.player.core.PlayerBufferingState;
import com.alimm.tanx.core.view.player.core.PlayerState;
import com.alimm.tanx.core.view.player.ui.TanxPlayerView;
import java.util.List;
import java.util.Map;

public class RewardVideoPortraitActivity extends Activity implements NotConfused {
    private final String TAG = "RewardVideoPortraitActivity";
    /* access modifiers changed from: private */
    public Button btnForceClose;
    private FrameLayout flVideo;
    private LinearLayout flWeb;
    /* access modifiers changed from: private */
    public boolean h5Pause = false;
    private boolean isFirstDraw = true;
    private volatile boolean isFront = false;
    volatile boolean isHsUt = false;
    private boolean isSendRewardArrived = false;
    private ImageView ivAdLogo;
    /* access modifiers changed from: private */
    public ImageView ivForceClose;
    private ImageView ivVoice;
    private LinearLayout llRewardVideoPlay;
    private TanxRewardVideoAdView mAdView;
    private TanxCountDownTimer mCountDownTimer;
    /* access modifiers changed from: private */
    public ITanxRewardVideoAd mTanxAd;
    /* access modifiers changed from: private */
    public long nowCurrentPosition = 0;
    /* access modifiers changed from: private */
    public String nowPlayerState = "ready";
    private int nowVoiceRes = R.mipmap.ic_voice;
    private ViewStub operationButton;
    private ITanxPlayer player;
    /* access modifiers changed from: private */
    public TanxPlayerView playerView;
    private String reqID;
    /* access modifiers changed from: private */
    public volatile boolean startTimerSwitch = false;
    /* access modifiers changed from: private */
    public tanxc_new tanxRewardVideoExpressAd;
    /* access modifiers changed from: private */
    public long totalTime = 0;
    private RewardWebViewUtil webViewUtil;

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
                    TanxPlayerView tanxPlayerView = this.playerView;
                    if (!(tanxPlayerView == null || tanxPlayerView.getState() == null)) {
                        if (this.playerView.getState() != PlayerState.COMPLETED) {
                            if (this.playerView.getState() == PlayerState.END) {
                            }
                        }
                        LogUtils.d("adCloseStartTimer", "启动强制关闭倒计时");
                        AnonymousClass3 r3 = new TanxCountDownTimer(10000, 1000) {
                            public void onFinish() {
                                LogUtils.d("adCloseStartTimer", "onFinish");
                                boolean unused = RewardVideoPortraitActivity.this.startTimerSwitch = false;
                            }

                            public void onTick(long j) {
                                int round = Math.round(((float) j) / 1000.0f);
                                if (round <= 1) {
                                    RewardVideoPortraitActivity.this.btnForceClose.post(new Runnable() {
                                        public void run() {
                                            RewardVideoPortraitActivity.this.btnForceClose.setVisibility(0);
                                        }
                                    });
                                }
                                LogUtils.d("adCloseStartTimer", round + "");
                            }
                        };
                        this.mCountDownTimer = r3;
                        r3.start();
                        this.startTimerSwitch = true;
                        return;
                    }
                    String str = "";
                    if (this.playerView != null) {
                        str = str + this.playerView.getState();
                    }
                    LogUtils.d("adCloseStartTimer", "不满足启动条件playerView.getState():" + str);
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
                LogUtils.d("RewardVideoPortraitActivity", "onAdClicked");
            }

            /* renamed from: tanxc_do */
            public void onAdShow(ITanxRewardVideoAd iTanxRewardVideoAd) {
                LogUtils.d("RewardVideoPortraitActivity", "onAdShow");
                if (RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd != null && RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() != null) {
                    RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onAdShow(iTanxRewardVideoAd);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: dispatchBufferingState */
    public void lambda$initVideo$8(PlayerBufferingState playerBufferingState) {
        String str;
        if (TextUtils.isEmpty(tanxc_do.tanxc_do(playerBufferingState))) {
            str = this.nowPlayerState;
        } else {
            str = tanxc_do.tanxc_do(playerBufferingState);
        }
        this.nowPlayerState = str;
        LogUtils.d("RewardVideoPortraitActivity", "nowPlayerState:" + this.nowPlayerState);
        RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_do(tanxc_do.tanxc_do(playerBufferingState));
        }
        if (playerBufferingState != PlayerBufferingState.BUFFERING_START && playerBufferingState == PlayerBufferingState.BUFFERING_END) {
            timerCancel();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dispatchStateChange */
    public void lambda$initVideo$7(ITanxPlayer iTanxPlayer, PlayerState playerState) {
        try {
            String tanxc_do = tanxc_do.tanxc_do(playerState);
            if (TextUtils.isEmpty(tanxc_do)) {
                tanxc_do = this.nowPlayerState;
            }
            this.nowPlayerState = tanxc_do;
            LogUtils.d("RewardVideoPortraitActivity", "nowPlayerState:" + this.nowPlayerState);
            RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_do(tanxc_do.tanxc_do(playerState));
            }
            if (playerState == PlayerState.STARTED) {
                if (this.isFirstDraw) {
                    LogUtils.d("utLog", "utViewDraw");
                    TanxRewardUt.utViewDraw(this.mTanxAd, 1);
                }
                this.isFirstDraw = false;
                timerCancel();
                ITanxRewardVideoAd iTanxRewardVideoAd = this.mTanxAd;
                if (iTanxRewardVideoAd != null) {
                    iTanxRewardVideoAd.onResourceLoadSuccess();
                }
            }
            if (playerState == PlayerState.COMPLETED || playerState == PlayerState.END) {
                videoCompleteAndRewardArrived();
            }
        } catch (Exception e) {
            LogUtils.e("RewardVideoPortraitActivity", e);
        }
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

    private void init() {
        this.llRewardVideoPlay = (LinearLayout) findViewById(R.id.ll_reward_video_play);
        this.ivVoice = (ImageView) findViewById(R.id.iv_voice);
        this.ivForceClose = (ImageView) findViewById(R.id.iv_force_close);
        this.mAdView = (TanxRewardVideoAdView) findViewById(R.id.root_view);
        this.flVideo = (FrameLayout) findViewById(R.id.fl_video);
        this.flWeb = (LinearLayout) findViewById(R.id.fl_reward_video_portrait_wb);
        this.btnForceClose = (Button) findViewById(R.id.btn_force_close);
    }

    private void initVideo() {
        try {
            TanxPlayerView tanxPlayerView = new TanxPlayerView(this);
            this.playerView = tanxPlayerView;
            this.flVideo.addView(tanxPlayerView, 0, new FrameLayout.LayoutParams(-1, -1, 17));
            ITanxPlayer create = TanxCoreManager.getInstance().getTanxCoreInstanceConfig().getTanxPlayer().create();
            this.player = create;
            this.playerView.setTanxPlayer(create);
            this.playerView.setDataSource(this.mTanxAd.getBidInfo().getCreativeItem().getVideo());
            this.playerView.setVideoScaleMode(VideoScaleMode.FIT_CENTER);
            this.playerView.setCover(this.mTanxAd.getBidInfo().getCreativeItem().getImageUrl());
            LogUtils.d("RewardVideoPortraitActivity", this.mTanxAd.getBidInfo().getCreativeItem().getVideo());
            this.playerView.prepare();
            if (this.tanxRewardVideoExpressAd.tanxc_do.mute) {
                this.playerView.mute();
            } else {
                this.playerView.resumeVolume();
            }
            this.playerView.setOnVideoStateChangeListener(new oIX0oI(this));
            this.playerView.setOnVideoBufferingListener(new II0xO0(this));
            this.playerView.setOnVideoErrorListener(new I0Io(this));
        } catch (Exception e) {
            LogUtils.d("RewardVideoPortraitActivity", "initVideo()-" + LogUtils.getStackTraceMessage(e));
            TanxRewardUt.utViewDraw(this.mTanxAd, 0);
        }
    }

    private void initView() {
        initVideo();
        initWeb();
    }

    private void initWeb() {
        RewardWebViewUtil rewardWebViewUtil = new RewardWebViewUtil();
        this.webViewUtil = rewardWebViewUtil;
        rewardWebViewUtil.tanxc_do(this.flWeb, this.mTanxAd.getBidInfo(), this.mTanxAd.getAdSlot(), this.tanxRewardVideoExpressAd, new RewardWebViewUtil.RewardInterface() {
            public void adClose() {
                RewardVideoPortraitActivity.this.adCloseUpload();
                RewardVideoPortraitActivity.this.finish();
            }

            public void adSkip(boolean z) {
                if (!(RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd == null || RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() == null)) {
                    RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onSkippedVideo();
                }
                if (z) {
                    RewardVideoPortraitActivity.this.adCloseUpload();
                    RewardVideoPortraitActivity.this.finish();
                } else if (RewardVideoPortraitActivity.this.playerView != null) {
                    RewardVideoPortraitActivity.this.playerView.stop();
                }
            }

            public long getCurrentTime() {
                if (RewardVideoPortraitActivity.this.playerView == null) {
                    return 0;
                }
                RewardVideoPortraitActivity rewardVideoPortraitActivity = RewardVideoPortraitActivity.this;
                long unused = rewardVideoPortraitActivity.nowCurrentPosition = (long) (rewardVideoPortraitActivity.playerView.getCurrentPosition() / 1000);
                LogUtils.d("RewardVideoPortraitActivity", "当前视频进度：" + RewardVideoPortraitActivity.this.nowCurrentPosition);
                return RewardVideoPortraitActivity.this.nowCurrentPosition;
            }

            public String getPlayState() {
                return RewardVideoPortraitActivity.this.nowPlayerState;
            }

            public long getTotalTime() {
                if (RewardVideoPortraitActivity.this.playerView == null) {
                    return 0;
                }
                RewardVideoPortraitActivity rewardVideoPortraitActivity = RewardVideoPortraitActivity.this;
                long unused = rewardVideoPortraitActivity.totalTime = (long) (rewardVideoPortraitActivity.playerView.getDuration() / 1000);
                return RewardVideoPortraitActivity.this.totalTime;
            }

            public void h5NotifyDrawSuccess() {
                RewardVideoPortraitActivity.this.ivForceClose.post(new Runnable() {
                    public void run() {
                        RewardVideoPortraitActivity.this.ivForceClose.setVisibility(8);
                    }
                });
            }

            public void onScroll(int i, int i2) {
            }

            public void setPlayer(Boolean bool, Boolean bool2) {
                if (RewardVideoPortraitActivity.this.playerView != null) {
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_do.mute = true;
                            RewardVideoPortraitActivity.this.playerView.mute();
                        } else {
                            RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_do.mute = false;
                            RewardVideoPortraitActivity.this.playerView.resumeVolume();
                        }
                    }
                    if (bool2 == null) {
                        return;
                    }
                    if (bool2.booleanValue()) {
                        boolean unused = RewardVideoPortraitActivity.this.h5Pause = true;
                        RewardVideoPortraitActivity.this.playerView.pause();
                        return;
                    }
                    boolean unused2 = RewardVideoPortraitActivity.this.h5Pause = false;
                    RewardVideoPortraitActivity.this.playerView.start();
                }
            }

            public void webDrawStatus(boolean z) {
                if (!z && !RewardVideoPortraitActivity.this.isHsUt) {
                    TanxBaseUt.utErrorCode(RewardVideoPortraitActivity.this.mTanxAd, UtErrorCode.CRASH_H5_ERROR);
                    RewardVideoPortraitActivity.this.isHsUt = true;
                }
            }

            public void webError(int i, String str) {
                LogUtils.e("RewardVideoPortraitActivity", "激励视频：webError: cmd :" + i + " msg:" + str);
            }

            public void webNotifyCountDown(int i, int i2) {
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initVideo$9(ITanxPlayer iTanxPlayer, TanxPlayerError tanxPlayerError) {
        LogUtils.e("playerView", (Exception) tanxPlayerError);
        tanxc_new tanxc_new = this.tanxRewardVideoExpressAd;
        if (!(tanxc_new == null || tanxc_new.tanxc_for() == null)) {
            this.tanxRewardVideoExpressAd.tanxc_for().onVideoError(tanxPlayerError);
        }
        TanxRewardUt.utViewDraw(this.mTanxAd, 0);
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$timerCancel$10() {
        this.btnForceClose.setVisibility(8);
    }

    private void timerCancel() {
        try {
            LogUtils.e("RewardVideoPortraitActivity", "adCloseTimerCancel");
            TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
            if (tanxCountDownTimer != null) {
                tanxCountDownTimer.cancel();
                this.mCountDownTimer = null;
            }
            this.btnForceClose.post(new oxoX(this));
            this.startTimerSwitch = false;
        } catch (Exception e) {
            LogUtils.e("timerCancel", e);
        }
    }

    private void videoCompleteAndRewardArrived() {
        adCloseStartTimer();
        LogUtils.d("RewardVideoPortraitActivity", "开始判断发奖 totalTime：" + this.totalTime + "  nowCurrentPosition：" + this.nowCurrentPosition + "  isSendRewardArrived:" + this.isSendRewardArrived);
        if (!this.isSendRewardArrived) {
            long j = this.totalTime;
            if (j > 0 && j - this.nowCurrentPosition <= 1) {
                LogUtils.d("RewardVideoPortraitActivity", "触发发奖");
                this.isSendRewardArrived = true;
                TanxRewardUt.utIsRewardValid(this.mTanxAd, 0);
                this.tanxRewardVideoExpressAd.tanxc_for().onVideoComplete();
                this.tanxRewardVideoExpressAd.tanxc_for().onRewardArrived(true, 0, (Map<String, Object>) null);
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ll_reward_video_feed_back) {
            new FeedBackDialog(this, R.style.CommonDialog, this.mTanxAd).show();
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
        } else if (id == R.id.iv_close) {
            this.mTanxAd.click("", "");
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
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_reward_video_portrait);
        if (!getIntentData()) {
            LogUtils.d("RewardVideoPortraitActivity", "getIntentData数据有问题。");
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
            TanxPlayerView tanxPlayerView = this.playerView;
            if (tanxPlayerView != null) {
                TanxRewardUt.utCloseAdVideoProgress(this.mTanxAd, (long) tanxPlayerView.getCurrentPosition());
                this.playerView.release();
            }
            VideoCacheManager.getInstance().clearThis((ITanxAd) this.tanxRewardVideoExpressAd);
            tanxc_if.tanxc_do(this.reqID);
            tanxc_new tanxc_new = this.tanxRewardVideoExpressAd;
            if (!(tanxc_new == null || tanxc_new.tanxc_for() == null)) {
                this.tanxRewardVideoExpressAd.tanxc_for().onAdClose();
            }
            RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_if();
            }
            timerCancel();
        } catch (Exception e) {
            LogUtils.e("RewardVideoPortraitActivity", LogUtils.getStackTraceMessage(e));
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "RewardVideoPortraitActivity", LogUtils.getStackTraceMessage(e), "");
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.btnForceClose.getVisibility() != 0) {
            return true;
        }
        adCloseUtAndUpload();
        return super.onKeyUp(i, keyEvent);
    }

    public void onPause() {
        LogUtils.d("RewardVideoPortraitActivity", "onPause");
        super.onPause();
        this.isFront = false;
        timerCancel();
        if (this.playerView != null) {
            LogUtils.d("RewardVideoPortraitActivity", "playerView onPause");
            this.playerView.pause();
        }
        if (this.webViewUtil != null) {
            LogUtils.d("RewardVideoPortraitActivity", "webViewUtil onPause");
            this.webViewUtil.tanxc_for();
        }
    }

    public void onResume() {
        super.onResume();
        this.isFront = true;
        TanxPlayerView tanxPlayerView = this.playerView;
        if (tanxPlayerView != null && tanxPlayerView.getState() == PlayerState.PAUSED && !this.h5Pause) {
            this.playerView.start();
        }
        RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_int();
        }
        adCloseStartTimer();
    }
}
