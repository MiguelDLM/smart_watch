package com.alimm.tanx.core.ad.ad.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ITanxAd;
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
import com.alimm.tanx.core.view.feed.tanxc_do;
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

public class FeedVideoManager implements ITanxVideoView, NotConfused, ITanxFeedCacheContext {
    private static final String TAG = "FeedVideoManager";
    private final long defaultVideoSize = 52428800;
    /* access modifiers changed from: private */
    public int duration = 0;
    /* access modifiers changed from: private */
    public final ITanxFeedAd iTanxFeedAd;
    /* access modifiers changed from: private */
    public ITanxFeedVideoAdListener iTanxFeedVideoAdListener;
    /* access modifiers changed from: private */
    public ITanxFeedVideoMonitorCallback iTanxFeedVideoMonitorCallback;
    /* access modifiers changed from: private */
    public boolean isPlayed = false;
    /* access modifiers changed from: private */
    public volatile boolean isShow = false;
    /* access modifiers changed from: private */
    public int nowCurrentCount = 0;
    private boolean nowMute = false;
    /* access modifiers changed from: private */
    public boolean nowViewAttach = false;
    private ITanxPlayer player;
    private volatile TanxCountDownTimer tanxCountDownTimer;
    private final tanxc_do tanxFeedVideoViewCache;
    /* access modifiers changed from: private */
    public TanxVideoView tanxVideoView;
    private volatile boolean video3SReportCompleted = false;

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$7  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] tanxc_do;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.alimm.tanx.core.view.player.core.PlayerState[] r0 = com.alimm.tanx.core.view.player.core.PlayerState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                tanxc_do = r0
                com.alimm.tanx.core.view.player.core.PlayerState r1 = com.alimm.tanx.core.view.player.core.PlayerState.IDLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = tanxc_do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alimm.tanx.core.view.player.core.PlayerState r1 = com.alimm.tanx.core.view.player.core.PlayerState.PREPARED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = tanxc_do     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alimm.tanx.core.view.player.core.PlayerState r1 = com.alimm.tanx.core.view.player.core.PlayerState.PAUSED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.AnonymousClass7.<clinit>():void");
        }
    }

    public FeedVideoManager(ITanxFeedAd iTanxFeedAd2, tanxc_do tanxc_do, Context context) {
        this.tanxFeedVideoViewCache = tanxc_do;
        this.iTanxFeedAd = iTanxFeedAd2;
        initVideoView(context);
        LogUtils.d(TAG, iTanxFeedAd2.getBidInfo().getCreativeItem().getVideo());
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
        } else if (this.iTanxFeedAd.getAdSlot().isPlayUnderWifi()) {
            LogUtils.d(TAG, "媒体设置wifi下自动播放 NetworkType" + NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey());
            if (NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey() == 1) {
                playItem(true);
                return;
            }
            LogUtils.d(TAG, "当前非wifi环境只准备，不自动播放");
            this.player.setPlayWhenReady(false);
            playItem(false);
        } else {
            playItem(true);
        }
    }

    private void callBackAndSetUi(PlayerState playerState) {
        if (this.tanxVideoView != null) {
            PlayerState playerState2 = PlayerState.STARTED;
            if (playerState == playerState2) {
                this.iTanxFeedVideoAdListener.onVideoAdStartPlay(this.iTanxFeedAd);
            } else if (playerState == PlayerState.PAUSED || playerState == PlayerState.STOPPED) {
                this.iTanxFeedVideoAdListener.onVideoAdPaused(this.iTanxFeedAd);
            } else if (playerState == PlayerState.COMPLETED || playerState == PlayerState.END) {
                this.iTanxFeedVideoAdListener.onVideoComplete();
            }
            if (playerState == PlayerState.IDLE || playerState == PlayerState.INITIALIZED || playerState == PlayerState.ERROR || playerState == PlayerState.PAUSED || playerState == PlayerState.STOPPED) {
                this.tanxVideoView.setPauseType();
            } else if (playerState == PlayerState.PREPARING) {
                this.tanxVideoView.setLoadingType();
            } else if (playerState == PlayerState.COMPLETED || playerState == PlayerState.END || playerState == playerState2) {
                this.tanxVideoView.setPlayType();
            } else if (playerState == PlayerState.PREPARED) {
                LogUtils.d(TAG, "onStateChangeTest " + this.player.getState().name());
                ITanxPlayer iTanxPlayer = this.player;
                if (iTanxPlayer != null && iTanxPlayer.getState() != playerState2) {
                    this.tanxVideoView.setPauseType();
                }
            }
        }
    }

    private void cancelVideoProgress() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("cancelVideoProgress played:");
        TanxVideoView tanxVideoView2 = this.tanxVideoView;
        if (tanxVideoView2 != null) {
            str = tanxVideoView2.getState().name();
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
            LogUtils.e(TAG, "cancelVideoProgress", (Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    public void correctTimer(Long l, TanxVideoView tanxVideoView2) {
        int round;
        if (tanxVideoView2 == null) {
            return;
        }
        if (l != null) {
            int round2 = Math.round(((float) l.longValue()) / 1000.0f);
            if (tanxVideoView2.getCurrentPosition() > 0 && (round = Math.round(((float) (tanxVideoView2.getDuration() - tanxVideoView2.getCurrentPosition())) / 1000.0f)) > 1 && Math.abs(round - round2) > 1 && this.tanxCountDownTimer != null) {
                this.tanxCountDownTimer.updateTime((long) (tanxVideoView2.getDuration() - tanxVideoView2.getCurrentPosition()));
                this.tanxCountDownTimer.resume();
            }
        } else if (tanxVideoView2.getDuration() - tanxVideoView2.getCurrentPosition() > 0 && this.tanxCountDownTimer != null) {
            this.tanxCountDownTimer.updateTime((long) (tanxVideoView2.getDuration() - tanxVideoView2.getCurrentPosition()));
            this.tanxCountDownTimer.resume();
        }
    }

    /* access modifiers changed from: private */
    public void exposeVideo3s(long j, long j2) {
        ITanxFeedAd iTanxFeedAd2;
        try {
            if (!this.video3SReportCompleted && (iTanxFeedAd2 = this.iTanxFeedAd) != null && iTanxFeedAd2.getBidInfo() != null && this.iTanxFeedAd.getBidInfo().getEventTrack() != null) {
                LogUtils.d(TAG, "exposeVideo3s start current:" + j + " duration:" + j2);
                BidInfo bidInfo = this.iTanxFeedAd.getBidInfo();
                ArrayList arrayList = new ArrayList();
                if (!(bidInfo == null || bidInfo.getEventTrack() == null || bidInfo.getEventTrack().size() <= 0)) {
                    for (int i = 0; i < bidInfo.getEventTrack().size(); i++) {
                        NewTrackItem newTrackItem = bidInfo.getEventTrack().get(i);
                        if (!(newTrackItem == null || newTrackItem.getType() != 2 || newTrackItem.getTime() == -1)) {
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
                    return;
                }
                LogUtils.d(TAG, "exposeVideo3s urls 为空，不调用上报");
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

    /* access modifiers changed from: private */
    public void initState(PlayerState playerState) {
        playCheck(playerState);
        setVideoProgress(playerState, false);
        callBackAndSetUi(playerState);
    }

    private void initVideoProgress() {
        try {
            if (this.tanxCountDownTimer == null) {
                TanxVideoView tanxVideoView2 = this.tanxVideoView;
                if (tanxVideoView2 != null) {
                    this.duration = tanxVideoView2.getDuration();
                }
                LogUtils.d(TAG, "initVideoProgress duration" + this.duration + "");
                if (this.tanxCountDownTimer == null) {
                    this.tanxCountDownTimer = new TanxCountDownTimer((long) this.duration, 1000) {
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

                        public void onTick(long j) {
                            if (!(FeedVideoManager.this.tanxVideoView == null || FeedVideoManager.this.tanxVideoView.getState() == PlayerState.STARTED)) {
                                FeedVideoManager.this.stopVideoProgress();
                            }
                            FeedVideoManager.this.correctTimer(Long.valueOf(j), FeedVideoManager.this.tanxVideoView);
                            int unused = FeedVideoManager.this.nowCurrentCount = Math.round(((float) j) / 1000.0f);
                            int round = Math.round(((float) FeedVideoManager.this.duration) / 1000.0f);
                            long j2 = (long) round;
                            FeedVideoManager.this.iTanxFeedVideoAdListener.onProgressUpdate((long) FeedVideoManager.this.nowCurrentCount, j2);
                            FeedVideoManager feedVideoManager = FeedVideoManager.this;
                            feedVideoManager.exposeVideo3s((long) feedVideoManager.nowCurrentCount, j2);
                            LogUtils.d(FeedVideoManager.TAG, "initVideoProgress nowCurrentCount：" + FeedVideoManager.this.nowCurrentCount + " duration：" + round + " millisUntilFinished:" + j);
                            if (round - FeedVideoManager.this.nowCurrentCount > 1) {
                                boolean unused2 = FeedVideoManager.this.isPlayed = true;
                            }
                        }
                    };
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "initVideoProgress", (Throwable) e);
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
            AnonymousClass1 r3 = new ITanxFeedVideoMonitorCallback() {
                public void attach() {
                    LogUtils.d(FeedVideoManager.TAG, "attach ");
                    FeedVideoManager.this.startPlay(true);
                    FeedVideoManager.this.iTanxFeedVideoAdListener.onVideoLoad(FeedVideoManager.this.iTanxFeedAd);
                    boolean unused = FeedVideoManager.this.nowViewAttach = true;
                }

                public void detached() {
                    String str;
                    try {
                        boolean unused = FeedVideoManager.this.isShow = false;
                        boolean unused2 = FeedVideoManager.this.nowViewAttach = false;
                        StringBuilder sb = new StringBuilder();
                        sb.append("detached:");
                        if (FeedVideoManager.this.tanxVideoView == null || FeedVideoManager.this.tanxVideoView.getState() == null) {
                            str = "tanxVideoView为空";
                        } else {
                            str = FeedVideoManager.this.tanxVideoView.getState().name();
                        }
                        sb.append(str);
                        LogUtils.d(FeedVideoManager.TAG, sb.toString());
                        FeedVideoManager.this.stop();
                        ITanxFeedVideoMonitorCallback unused3 = FeedVideoManager.this.iTanxFeedVideoMonitorCallback = null;
                    } catch (Exception e) {
                        LogUtils.e(e);
                    }
                }

                public void exposure() {
                }

                public void exposureTime(long j) {
                }

                public void onMonitor(Map<String, Object> map) {
                }

                public void remove() {
                    boolean unused = FeedVideoManager.this.isShow = false;
                    FeedVideoManager.this.stop();
                }

                public void show() {
                    boolean unused = FeedVideoManager.this.isShow = true;
                    FeedVideoManager.this.startPlay(true);
                }
            };
            this.iTanxFeedVideoMonitorCallback = r3;
            final tanxc_for tanxc_for = new tanxc_for(this.tanxVideoView, r3);
            this.tanxVideoView.setAdMonitor(tanxc_for);
            this.tanxVideoView.setOnVideoStateChangeListener(new OnVideoStateChangeListener() {
                public void onStateChange(ITanxPlayer iTanxPlayer, PlayerState playerState) {
                    LogUtils.d(FeedVideoManager.TAG, "onStateChange state " + playerState.name() + " url:" + iTanxPlayer.getUrl() + "  adMonitor.getAttachedWindow():" + tanxc_for.tanxc_goto() + ", isAttach:" + FeedVideoManager.this.isAttach());
                    FeedVideoManager.this.initState(playerState);
                }
            });
            this.tanxVideoView.setOnVideoBufferingListener(new OnVideoBufferingListener() {
                public void OnBufferStateChanged(PlayerBufferingState playerBufferingState) {
                }
            });
            this.tanxVideoView.setOnVideoErrorListener(new OnVideoErrorListener() {
                public boolean onError(ITanxPlayer iTanxPlayer, TanxPlayerError tanxPlayerError) {
                    FeedVideoManager.this.iTanxFeedVideoAdListener.onVideoError(tanxPlayerError);
                    TanxRewardUt.utViewDraw(FeedVideoManager.this.iTanxFeedAd, 0);
                    return false;
                }
            });
            this.tanxVideoView.setPlayClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    FeedVideoManager.this.play();
                }
            });
        } catch (Exception e) {
            LogUtils.d(TAG, "initVideoView()-" + LogUtils.getStackTraceMessage(e));
            TanxRewardUt.utViewDraw(this.iTanxFeedAd, 0);
        }
    }

    /* access modifiers changed from: private */
    public boolean isAttach() {
        TanxVideoView tanxVideoView2 = this.tanxVideoView;
        if (tanxVideoView2 == null || tanxVideoView2.getWindowToken() == null) {
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
            if (i == 1) {
                if (!z || !this.isShow) {
                    this.player.setPlayWhenReady(false);
                }
                this.tanxVideoView.prepare();
            } else if (i == 2 || i == 3) {
                this.tanxVideoView.showCoverView(true);
            } else {
                this.tanxVideoView.showCoverView(false);
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

    /* access modifiers changed from: private */
    public void startPlay(boolean z) {
        LogUtils.d(TAG, "startPlay fromAttach：" + z);
        if (!videoSizeCheck(this.iTanxFeedAd)) {
            LogUtils.e(TAG, "视频体积超限");
            this.iTanxFeedVideoAdListener.onError(new TanxError(this.iTanxFeedAd.getRequestId(), "视频超限"));
        } else if (this.tanxVideoView != null) {
            LogUtils.d(TAG, "startPlay tanxVideoView.getState()：" + this.tanxVideoView.getState().name());
            if (!this.tanxVideoView.getState().equals(PlayerState.COMPLETED)) {
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
            }
        }
    }

    private synchronized void startVideoProgress(boolean z) {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("startVideoProgress played:");
            TanxVideoView tanxVideoView2 = this.tanxVideoView;
            if (tanxVideoView2 != null) {
                str = tanxVideoView2.getState().name();
            } else {
                str = "";
            }
            sb.append(str);
            LogUtils.d(TAG, sb.toString());
            initVideoProgress();
            if (!this.tanxCountDownTimer.isPaused() || this.tanxVideoView.getState() != PlayerState.STARTED) {
                ITanxFeedAd iTanxFeedAd2 = this.iTanxFeedAd;
                if (iTanxFeedAd2 == null || iTanxFeedAd2.getAdSlot() == null || this.iTanxFeedAd.getAdSlot().getVideoParam() == null || ((!this.iTanxFeedAd.getAdSlot().getVideoParam().looping && !z) || this.tanxCountDownTimer.getNowType() != 4)) {
                    this.tanxCountDownTimer.start();
                } else {
                    this.tanxCountDownTimer.updateTime((long) (this.tanxVideoView.getDuration() - this.tanxVideoView.getCurrentPosition()));
                    this.tanxCountDownTimer.finishReStart();
                }
            } else {
                correctTimer((Long) null, this.tanxVideoView);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "startVideoProgress", (Throwable) e);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public void stop() {
        TanxVideoView tanxVideoView2 = this.tanxVideoView;
        if (tanxVideoView2 != null && tanxVideoView2.getState() != null && !this.tanxVideoView.getState().equals(PlayerState.COMPLETED)) {
            this.tanxVideoView.stop();
            stopVideoProgress();
        }
    }

    /* access modifiers changed from: private */
    public void stopVideoProgress() {
        String str;
        TanxVideoView tanxVideoView2;
        StringBuilder sb = new StringBuilder();
        sb.append("stopVideoProgress played:");
        TanxVideoView tanxVideoView3 = this.tanxVideoView;
        if (tanxVideoView3 != null) {
            str = tanxVideoView3.getState().name();
        } else {
            str = "";
        }
        sb.append(str);
        LogUtils.d(TAG, sb.toString());
        try {
            if (this.tanxCountDownTimer != null && (tanxVideoView2 = this.tanxVideoView) != null && tanxVideoView2.getState() != PlayerState.STARTED) {
                this.tanxCountDownTimer.pause();
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "startVideoProgress", (Throwable) e);
        }
    }

    private boolean videoSizeCheck(ITanxFeedAd iTanxFeedAd2) {
        long j;
        Long l;
        if (iTanxFeedAd2 == null || iTanxFeedAd2.getBidInfo() == null || iTanxFeedAd2.getBidInfo().getCreativeItem() == null || TextUtils.isEmpty(iTanxFeedAd2.getBidInfo().getCreativeItem().getVideo())) {
            return true;
        }
        LinkedHashMap<String, Long> linkedHashMap = VideoGetSizeManager.mCachedVideoSizeMap;
        long j2 = 0;
        if (!(linkedHashMap == null || (l = linkedHashMap.get(iTanxFeedAd2.getBidInfo().getCreativeItem().getVideo())) == null)) {
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

    public void destroy() {
        LogUtils.d(TAG, "destroy");
        if (this.tanxVideoView != null) {
            LogUtils.d(TAG, "destroy tanxVideoView置空");
            this.tanxVideoView.release();
            this.tanxVideoView = null;
        }
        VideoCacheManager.getInstance().clearThis((ITanxAd) this.iTanxFeedAd);
        cancelVideoProgress();
    }

    public String getSessionId() {
        ITanxFeedAd iTanxFeedAd2 = this.iTanxFeedAd;
        if (iTanxFeedAd2 == null || iTanxFeedAd2.getBidInfo() == null) {
            return "null";
        }
        return this.iTanxFeedAd.getBidInfo().getSessionId();
    }

    public View getVideoAdView(ITanxFeedVideoAdListener iTanxFeedVideoAdListener2) {
        this.iTanxFeedVideoAdListener = iTanxFeedVideoAdListener2;
        return getVideoView();
    }

    public boolean isMute() {
        return this.nowMute;
    }

    public void mute() {
        TanxVideoView tanxVideoView2 = this.tanxVideoView;
        if (tanxVideoView2 != null) {
            tanxVideoView2.mute();
            this.nowMute = true;
        }
    }

    public void pause() {
        stop();
    }

    public void play() {
        startPlay(false);
    }

    public View remove() {
        LogUtils.d(TAG, "remove");
        TanxVideoView tanxVideoView2 = this.tanxVideoView;
        if (tanxVideoView2 != null) {
            tanxVideoView2.release();
        }
        this.tanxVideoView = null;
        return tanxVideoView2;
    }

    public void replay() {
        TanxVideoView tanxVideoView2 = this.tanxVideoView;
        if (tanxVideoView2 != null) {
            tanxVideoView2.replay();
            setVideoProgress(this.tanxVideoView.getState(), true);
        }
    }

    public void resumeVolume() {
        TanxVideoView tanxVideoView2 = this.tanxVideoView;
        if (tanxVideoView2 != null) {
            tanxVideoView2.resumeVolume();
            this.nowMute = false;
        }
    }

    public void setVolume(int i) {
        boolean z;
        TanxVideoView tanxVideoView2 = this.tanxVideoView;
        if (tanxVideoView2 != null) {
            tanxVideoView2.setVolume(i);
            if (i <= 0) {
                z = true;
            } else {
                z = false;
            }
            this.nowMute = z;
        }
    }
}
