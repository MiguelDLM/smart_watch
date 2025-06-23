package com.alimm.tanx.core.ad.ad.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback;
import com.alimm.tanx.core.ad.monitor.tanxc_for;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.request.TanxPlayerError;
import com.alimm.tanx.core.ut.impl.TanxRewardUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.PlayerListManager;
import com.alimm.tanx.core.utils.TanxCountDownTimer;
import com.alimm.tanx.core.utils.VideoCacheManager;
import com.alimm.tanx.core.view.feed.ITanxFeedCacheContext;
import com.alimm.tanx.core.view.player.VideoScaleMode;
import com.alimm.tanx.core.view.player.cache.VideoGetSizeManager;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.alimm.tanx.core.view.player.core.OnVideoBufferingListener;
import com.alimm.tanx.core.view.player.core.OnVideoErrorListener;
import com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener;
import com.alimm.tanx.core.view.player.core.PlayerBufferingState;
import com.alimm.tanx.core.view.player.core.PlayerState;
import com.alimm.tanx.core.view.player.ui.TanxPlayerView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FeedVideoManager implements ITanxVideoView, NotConfused, ITanxFeedCacheContext {
    private static final String TAG = "FeedVideoManager";
    private final ITanxFeedAd iTanxFeedAd;
    private ITanxFeedVideoAdListener iTanxFeedVideoAdListener;
    private ITanxFeedVideoMonitorCallback iTanxFeedVideoMonitorCallback;
    private ITanxPlayer player;
    private volatile TanxCountDownTimer tanxCountDownTimer;
    private final com.alimm.tanx.core.view.feed.tanxc_do tanxFeedVideoViewCache;
    private TanxVideoView tanxVideoView;
    private int duration = 0;
    private int nowCurrentCount = 0;
    private boolean nowViewAttach = false;
    private final long defaultVideoSize = 52428800;
    private boolean isPlayed = false;
    private boolean nowMute = false;
    private volatile boolean isShow = false;
    private volatile boolean video3SReportCompleted = false;

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$7, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] tanxc_do;

        static {
            int[] iArr = new int[PlayerState.values().length];
            tanxc_do = iArr;
            try {
                iArr[PlayerState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                tanxc_do[PlayerState.PREPARED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                tanxc_do[PlayerState.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public FeedVideoManager(ITanxFeedAd iTanxFeedAd, com.alimm.tanx.core.view.feed.tanxc_do tanxc_doVar, Context context) {
        this.tanxFeedVideoViewCache = tanxc_doVar;
        this.iTanxFeedAd = iTanxFeedAd;
        initVideoView(context);
        LogUtils.d(TAG, iTanxFeedAd.getBidInfo().getCreativeItem().getVideo());
    }

    private void autoPlayCheck() {
        LogUtils.d(TAG, "autoPlayCheck");
        if (this.isPlayed) {
            playItem(true);
            return;
        }
        if (this.iTanxFeedAd.getAdSlot().getVideoParam() != null && this.iTanxFeedAd.getAdSlot().getVideoParam().mute) {
            mute();
        }
        if (this.iTanxFeedAd.getAdSlot().isNotAutoPlay()) {
            LogUtils.d(TAG, "媒体设置不自动播放");
            playItem(false);
            return;
        }
        if (this.iTanxFeedAd.getAdSlot().isPlayUnderWifi()) {
            LogUtils.d(TAG, "媒体设置wifi下自动播放 NetworkType" + NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey());
            if (NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey() == 1) {
                playItem(true);
                return;
            }
            LogUtils.d(TAG, "当前非wifi环境只准备，不自动播放");
            this.player.setPlayWhenReady(false);
            playItem(false);
            return;
        }
        playItem(true);
    }

    private void callBackAndSetUi(PlayerState playerState) {
        if (this.tanxVideoView != null) {
            PlayerState playerState2 = PlayerState.STARTED;
            if (playerState == playerState2) {
                this.iTanxFeedVideoAdListener.onVideoAdStartPlay(this.iTanxFeedAd);
            } else if (playerState != PlayerState.PAUSED && playerState != PlayerState.STOPPED) {
                if (playerState == PlayerState.COMPLETED || playerState == PlayerState.END) {
                    this.iTanxFeedVideoAdListener.onVideoComplete();
                }
            } else {
                this.iTanxFeedVideoAdListener.onVideoAdPaused(this.iTanxFeedAd);
            }
            if (playerState != PlayerState.IDLE && playerState != PlayerState.INITIALIZED && playerState != PlayerState.ERROR && playerState != PlayerState.PAUSED && playerState != PlayerState.STOPPED) {
                if (playerState == PlayerState.PREPARING) {
                    this.tanxVideoView.setLoadingType();
                    return;
                }
                if (playerState != PlayerState.COMPLETED && playerState != PlayerState.END && playerState != playerState2) {
                    if (playerState == PlayerState.PREPARED) {
                        LogUtils.d(TAG, "onStateChangeTest " + this.player.getState().name());
                        ITanxPlayer iTanxPlayer = this.player;
                        if (iTanxPlayer != null && iTanxPlayer.getState() != playerState2) {
                            this.tanxVideoView.setPauseType();
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.tanxVideoView.setPlayType();
                return;
            }
            this.tanxVideoView.setPauseType();
        }
    }

    private void cancelVideoProgress() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("cancelVideoProgress played:");
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            str = tanxVideoView.getState().name();
        } else {
            str = "";
        }
        sb.append(str);
        LogUtils.d(TAG, sb.toString());
        try {
            if (this.tanxCountDownTimer != null) {
                this.tanxCountDownTimer.cancel();
                this.tanxCountDownTimer = null;
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "cancelVideoProgress", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void correctTimer(Long l, TanxVideoView tanxVideoView) {
        int round;
        if (tanxVideoView != null) {
            if (l == null) {
                if (tanxVideoView.getDuration() - tanxVideoView.getCurrentPosition() > 0 && this.tanxCountDownTimer != null) {
                    this.tanxCountDownTimer.updateTime(tanxVideoView.getDuration() - tanxVideoView.getCurrentPosition());
                    this.tanxCountDownTimer.resume();
                    return;
                }
                return;
            }
            int round2 = Math.round(((float) l.longValue()) / 1000.0f);
            if (tanxVideoView.getCurrentPosition() > 0 && (round = Math.round((tanxVideoView.getDuration() - tanxVideoView.getCurrentPosition()) / 1000.0f)) > 1 && Math.abs(round - round2) > 1 && this.tanxCountDownTimer != null) {
                this.tanxCountDownTimer.updateTime(tanxVideoView.getDuration() - tanxVideoView.getCurrentPosition());
                this.tanxCountDownTimer.resume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exposeVideo3s(long j, long j2) {
        ITanxFeedAd iTanxFeedAd;
        try {
            if (!this.video3SReportCompleted && (iTanxFeedAd = this.iTanxFeedAd) != null && iTanxFeedAd.getBidInfo() != null && this.iTanxFeedAd.getBidInfo().getEventTrack() != null) {
                LogUtils.d(TAG, "exposeVideo3s start current:" + j + " duration:" + j2);
                BidInfo bidInfo = this.iTanxFeedAd.getBidInfo();
                ArrayList arrayList = new ArrayList();
                if (bidInfo != null && bidInfo.getEventTrack() != null && bidInfo.getEventTrack().size() > 0) {
                    for (int i = 0; i < bidInfo.getEventTrack().size(); i++) {
                        NewTrackItem newTrackItem = bidInfo.getEventTrack().get(i);
                        if (newTrackItem != null && newTrackItem.getType() == 2 && newTrackItem.getTime() != -1) {
                            int i2 = (int) (j2 - j);
                            LogUtils.d(TAG, "exposeVideo3s startTime:" + i2 + " newTrackItem.getTime():" + newTrackItem.getTime());
                            if (i2 == newTrackItem.getTime()) {
                                arrayList.addAll(bidInfo.getEventTrack().get(i).getUrl());
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    ExposeManager.tanxc_do().tanxc_do(bidInfo, this.iTanxFeedAd.getAdSlot().getReqId(), this.iTanxFeedAd.getAdSlot().getPid(), arrayList);
                    this.video3SReportCompleted = true;
                } else {
                    LogUtils.d(TAG, "exposeVideo3s urls 为空，不调用上报");
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, e);
        }
    }

    private TanxPlayerView getVideoView() {
        try {
            if (this.tanxVideoView == null) {
                initVideoView(TanxCoreSdk.getApplication());
            }
            this.tanxVideoView.setiTanxFeedVideoAdListener(this.iTanxFeedVideoAdListener);
        } catch (Exception e) {
            LogUtils.d(TAG, "getVideoView()-" + LogUtils.getStackTraceMessage(e));
            TanxRewardUt.utViewDraw(this.iTanxFeedAd, 0);
        }
        return this.tanxVideoView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initState(PlayerState playerState) {
        playCheck(playerState);
        setVideoProgress(playerState, false);
        callBackAndSetUi(playerState);
    }

    private void initVideoProgress() {
        try {
            if (this.tanxCountDownTimer != null) {
                return;
            }
            TanxVideoView tanxVideoView = this.tanxVideoView;
            if (tanxVideoView != null) {
                this.duration = tanxVideoView.getDuration();
            }
            LogUtils.d(TAG, "initVideoProgress duration" + this.duration + "");
            if (this.tanxCountDownTimer == null) {
                this.tanxCountDownTimer = new TanxCountDownTimer(this.duration, 1000L) { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.6
                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onFinish() {
                        try {
                            if (FeedVideoManager.this.iTanxFeedAd.getAdSlot().getVideoParam().looping) {
                                LogUtils.d(FeedVideoManager.TAG, "onFinish - tanxVideoView.getState()：" + FeedVideoManager.this.tanxVideoView.getState());
                                FeedVideoManager feedVideoManager = FeedVideoManager.this;
                                feedVideoManager.initState(feedVideoManager.tanxVideoView.getState());
                            }
                        } catch (Exception e) {
                            LogUtils.e(e);
                        }
                        LogUtils.d(FeedVideoManager.TAG, "initVideoProgress - onFinish");
                    }

                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onTick(long j) {
                        if (FeedVideoManager.this.tanxVideoView != null && FeedVideoManager.this.tanxVideoView.getState() != PlayerState.STARTED) {
                            FeedVideoManager.this.stopVideoProgress();
                        }
                        FeedVideoManager.this.correctTimer(Long.valueOf(j), FeedVideoManager.this.tanxVideoView);
                        FeedVideoManager.this.nowCurrentCount = Math.round(((float) j) / 1000.0f);
                        int round = Math.round(FeedVideoManager.this.duration / 1000.0f);
                        long j2 = round;
                        FeedVideoManager.this.iTanxFeedVideoAdListener.onProgressUpdate(FeedVideoManager.this.nowCurrentCount, j2);
                        FeedVideoManager.this.exposeVideo3s(r1.nowCurrentCount, j2);
                        LogUtils.d(FeedVideoManager.TAG, "initVideoProgress nowCurrentCount：" + FeedVideoManager.this.nowCurrentCount + " duration：" + round + " millisUntilFinished:" + j);
                        if (round - FeedVideoManager.this.nowCurrentCount > 1) {
                            FeedVideoManager.this.isPlayed = true;
                        }
                    }
                };
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "initVideoProgress", e);
        }
    }

    private void initVideoView(Context context) {
        try {
            TanxVideoView tanxc_do = this.tanxFeedVideoViewCache.tanxc_do(this, context);
            this.tanxVideoView = tanxc_do;
            tanxc_do.setTanxAd(this.iTanxFeedAd);
            ITanxPlayer create = TanxCoreManager.getInstance().getTanxCoreInstanceConfig().getTanxPlayer().create();
            this.player = create;
            create.setLooping(this.iTanxFeedAd.getAdSlot().getVideoParam().looping);
            ITanxFeedVideoMonitorCallback iTanxFeedVideoMonitorCallback = new ITanxFeedVideoMonitorCallback() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.1
                @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
                public void attach() {
                    LogUtils.d(FeedVideoManager.TAG, "attach ");
                    FeedVideoManager.this.startPlay(true);
                    FeedVideoManager.this.iTanxFeedVideoAdListener.onVideoLoad(FeedVideoManager.this.iTanxFeedAd);
                    FeedVideoManager.this.nowViewAttach = true;
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
                public void detached() {
                    String str;
                    try {
                        FeedVideoManager.this.isShow = false;
                        FeedVideoManager.this.nowViewAttach = false;
                        StringBuilder sb = new StringBuilder();
                        sb.append("detached:");
                        if (FeedVideoManager.this.tanxVideoView != null && FeedVideoManager.this.tanxVideoView.getState() != null) {
                            str = FeedVideoManager.this.tanxVideoView.getState().name();
                        } else {
                            str = "tanxVideoView为空";
                        }
                        sb.append(str);
                        LogUtils.d(FeedVideoManager.TAG, sb.toString());
                        FeedVideoManager.this.stop();
                        FeedVideoManager.this.iTanxFeedVideoMonitorCallback = null;
                    } catch (Exception e) {
                        LogUtils.e(e);
                    }
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void exposure() {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void exposureTime(long j) {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void onMonitor(Map<String, Object> map) {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
                public void remove() {
                    FeedVideoManager.this.isShow = false;
                    FeedVideoManager.this.stop();
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
                public void show() {
                    FeedVideoManager.this.isShow = true;
                    FeedVideoManager.this.startPlay(true);
                }
            };
            this.iTanxFeedVideoMonitorCallback = iTanxFeedVideoMonitorCallback;
            final tanxc_for tanxc_forVar = new tanxc_for(this.tanxVideoView, iTanxFeedVideoMonitorCallback);
            this.tanxVideoView.setAdMonitor(tanxc_forVar);
            this.tanxVideoView.setOnVideoStateChangeListener(new OnVideoStateChangeListener() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.2
                @Override // com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener
                public void onStateChange(ITanxPlayer iTanxPlayer, PlayerState playerState) {
                    LogUtils.d(FeedVideoManager.TAG, "onStateChange state " + playerState.name() + " url:" + iTanxPlayer.getUrl() + "  adMonitor.getAttachedWindow():" + tanxc_forVar.tanxc_goto() + ", isAttach:" + FeedVideoManager.this.isAttach());
                    FeedVideoManager.this.initState(playerState);
                }
            });
            this.tanxVideoView.setOnVideoBufferingListener(new OnVideoBufferingListener() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.3
                @Override // com.alimm.tanx.core.view.player.core.OnVideoBufferingListener
                public void OnBufferStateChanged(PlayerBufferingState playerBufferingState) {
                }
            });
            this.tanxVideoView.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.4
                @Override // com.alimm.tanx.core.view.player.core.OnVideoErrorListener
                public boolean onError(ITanxPlayer iTanxPlayer, TanxPlayerError tanxPlayerError) {
                    FeedVideoManager.this.iTanxFeedVideoAdListener.onVideoError(tanxPlayerError);
                    TanxRewardUt.utViewDraw(FeedVideoManager.this.iTanxFeedAd, 0);
                    return false;
                }
            });
            this.tanxVideoView.setPlayClickListener(new View.OnClickListener() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FeedVideoManager.this.play();
                }
            });
        } catch (Exception e) {
            LogUtils.d(TAG, "initVideoView()-" + LogUtils.getStackTraceMessage(e));
            TanxRewardUt.utViewDraw(this.iTanxFeedAd, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAttach() {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView == null || tanxVideoView.getWindowToken() == null) {
            return false;
        }
        return true;
    }

    private void playCheck(PlayerState playerState) {
        if (playerState.equals(PlayerState.STARTED) && !this.nowViewAttach) {
            stop();
        }
    }

    private void playItem(boolean z) {
        LogUtils.d(TAG, "playItem");
        if (this.tanxVideoView != null) {
            LogUtils.d(TAG, "playItem isIdle:" + this.tanxVideoView.getState() + "， isStart:" + z + "， isShow:" + this.isShow);
            int i = AnonymousClass7.tanxc_do[this.tanxVideoView.getState().ordinal()];
            if (i != 1) {
                if (i != 2 && i != 3) {
                    this.tanxVideoView.showCoverView(false);
                } else {
                    this.tanxVideoView.showCoverView(true);
                }
            } else {
                if (!z || !this.isShow) {
                    this.player.setPlayWhenReady(false);
                }
                this.tanxVideoView.prepare();
            }
            if (z && this.isShow) {
                LogUtils.d(TAG, "先暂停所有视频，再起播当前视频");
                PlayerListManager.getInstance().stopOtherPlayer(this.iTanxFeedAd);
                this.player.setPlayWhenReady(true);
                this.tanxVideoView.prepare();
                this.tanxVideoView.start();
            }
        }
    }

    private void setVideoProgress(PlayerState playerState, boolean z) {
        if (playerState == PlayerState.STARTED) {
            startVideoProgress(z);
        } else {
            stopVideoProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay(boolean z) {
        LogUtils.d(TAG, "startPlay fromAttach：" + z);
        if (videoSizeCheck(this.iTanxFeedAd)) {
            if (this.tanxVideoView != null) {
                LogUtils.d(TAG, "startPlay tanxVideoView.getState()：" + this.tanxVideoView.getState().name());
                if (this.tanxVideoView.getState().equals(PlayerState.COMPLETED)) {
                    return;
                }
                if (this.tanxVideoView.getState().equals(PlayerState.ERROR)) {
                    this.tanxVideoView.reset();
                }
                if (this.tanxVideoView.getState().equals(PlayerState.IDLE)) {
                    this.tanxVideoView.setTanxPlayer(this.player);
                    this.tanxVideoView.setDataSource(this.iTanxFeedAd.getBidInfo().getCreativeItem().getVideo());
                    this.tanxVideoView.setVideoScaleMode(VideoScaleMode.FIT_CENTER);
                    this.tanxVideoView.setCover(this.iTanxFeedAd.getBidInfo().getCreativeItem().getImageUrl());
                    if (z) {
                        autoPlayCheck();
                    } else {
                        playItem(true);
                    }
                } else if (z) {
                    autoPlayCheck();
                } else {
                    playItem(true);
                }
                this.iTanxFeedAd.onResourceLoadSuccess();
                return;
            }
            return;
        }
        LogUtils.e(TAG, "视频体积超限");
        this.iTanxFeedVideoAdListener.onError(new TanxError(this.iTanxFeedAd.getRequestId(), "视频超限"));
    }

    private synchronized void startVideoProgress(boolean z) {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("startVideoProgress played:");
            TanxVideoView tanxVideoView = this.tanxVideoView;
            if (tanxVideoView != null) {
                str = tanxVideoView.getState().name();
            } else {
                str = "";
            }
            sb.append(str);
            LogUtils.d(TAG, sb.toString());
            try {
                initVideoProgress();
                if (this.tanxCountDownTimer.isPaused() && this.tanxVideoView.getState() == PlayerState.STARTED) {
                    correctTimer(null, this.tanxVideoView);
                } else {
                    ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
                    if (iTanxFeedAd != null && iTanxFeedAd.getAdSlot() != null && this.iTanxFeedAd.getAdSlot().getVideoParam() != null && ((this.iTanxFeedAd.getAdSlot().getVideoParam().looping || z) && this.tanxCountDownTimer.getNowType() == 4)) {
                        this.tanxCountDownTimer.updateTime(this.tanxVideoView.getDuration() - this.tanxVideoView.getCurrentPosition());
                        this.tanxCountDownTimer.finishReStart();
                    } else {
                        this.tanxCountDownTimer.start();
                    }
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "startVideoProgress", e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null && tanxVideoView.getState() != null && !this.tanxVideoView.getState().equals(PlayerState.COMPLETED)) {
            this.tanxVideoView.stop();
            stopVideoProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVideoProgress() {
        String str;
        TanxVideoView tanxVideoView;
        StringBuilder sb = new StringBuilder();
        sb.append("stopVideoProgress played:");
        TanxVideoView tanxVideoView2 = this.tanxVideoView;
        if (tanxVideoView2 != null) {
            str = tanxVideoView2.getState().name();
        } else {
            str = "";
        }
        sb.append(str);
        LogUtils.d(TAG, sb.toString());
        try {
            if (this.tanxCountDownTimer != null && (tanxVideoView = this.tanxVideoView) != null && tanxVideoView.getState() != PlayerState.STARTED) {
                this.tanxCountDownTimer.pause();
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "startVideoProgress", e);
        }
    }

    private boolean videoSizeCheck(ITanxFeedAd iTanxFeedAd) {
        long j;
        Long l;
        if (iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null || iTanxFeedAd.getBidInfo().getCreativeItem() == null || TextUtils.isEmpty(iTanxFeedAd.getBidInfo().getCreativeItem().getVideo())) {
            return true;
        }
        LinkedHashMap<String, Long> linkedHashMap = VideoGetSizeManager.mCachedVideoSizeMap;
        long j2 = 0;
        if (linkedHashMap != null && (l = linkedHashMap.get(iTanxFeedAd.getBidInfo().getCreativeItem().getVideo())) != null) {
            j2 = l.longValue();
        }
        if (OrangeManager.getInstance().getThreshold(OrangeManager.FEED_VIDEO_MAX_SIZE) > -1) {
            j = OrangeManager.getInstance().getThreshold(OrangeManager.FEED_VIDEO_MAX_SIZE) * 1048576;
        } else {
            j = 52428800;
        }
        if (j2 <= j) {
            return true;
        }
        return false;
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void destroy() {
        LogUtils.d(TAG, "destroy");
        if (this.tanxVideoView != null) {
            LogUtils.d(TAG, "destroy tanxVideoView置空");
            this.tanxVideoView.release();
            this.tanxVideoView = null;
        }
        VideoCacheManager.getInstance().clearThis(this.iTanxFeedAd);
        cancelVideoProgress();
    }

    public String getSessionId() {
        ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd != null && iTanxFeedAd.getBidInfo() != null) {
            return this.iTanxFeedAd.getBidInfo().getSessionId();
        }
        return "null";
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public View getVideoAdView(ITanxFeedVideoAdListener iTanxFeedVideoAdListener) {
        this.iTanxFeedVideoAdListener = iTanxFeedVideoAdListener;
        return getVideoView();
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public boolean isMute() {
        return this.nowMute;
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void mute() {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.mute();
            this.nowMute = true;
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void pause() {
        stop();
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void play() {
        startPlay(false);
    }

    @Override // com.alimm.tanx.core.view.feed.ITanxFeedCacheContext
    public View remove() {
        LogUtils.d(TAG, "remove");
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.release();
        }
        this.tanxVideoView = null;
        return tanxVideoView;
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void replay() {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.replay();
            setVideoProgress(this.tanxVideoView.getState(), true);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void resumeVolume() {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.resumeVolume();
            this.nowMute = false;
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void setVolume(int i) {
        boolean z;
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.setVolume(i);
            if (i <= 0) {
                z = true;
            } else {
                z = false;
            }
            this.nowMute = z;
        }
    }
}
