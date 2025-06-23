package com.sma.smartv3.biz.voice;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.RomUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.O0IxXx;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.video.VideoSize;
import com.sma.smartv3.biz.AISparkChainManager;
import com.sma.smartv3.biz.VoiceService;
import com.sma.smartv3.biz.voice.RecordingManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AISpeech;
import com.sma.smartv3.model.AITranslation;
import com.sma.smartv3.model.LanguageTranslationData;
import com.sma.smartv3.model.LanguageTranslationKt;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.entity.Languages;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nRecordingManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordingManager.kt\ncom/sma/smartv3/biz/voice/RecordingManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,517:1\n1#2:518\n*E\n"})
/* loaded from: classes12.dex */
public final class RecordingManager {

    @OXOo.OOXIXo
    public static final Companion Companion;

    @OXOo.OOXIXo
    private static volatile RecordingManager instance;

    @OXOo.oOoXoXO
    private AudioManager audioManager;
    private boolean isRecording;
    private boolean isStartTimers;

    @OXOo.oOoXoXO
    private AudioRecord mAudioRecord;
    private int mBufferSize;
    private boolean mIsStream;

    @OXOo.OOXIXo
    private final RecordingManager$mTimerTask$1 mTimerTask;

    @OXOo.OOXIXo
    private final MediaItem mTipItem;

    @OXOo.OOXIXo
    private final X0IIOO mTipPlayer$delegate;
    private boolean playEnded;

    @OXOo.oOoXoXO
    private ExoPlayer player;

    @OXOo.oOoXoXO
    private OnRecordingCallback recordingCallback;

    @OXOo.OOXIXo
    private final String TAG = "RecordingManager";

    @OXOo.OOXIXo
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final RecordingManager getInstance() {
            return RecordingManager.instance;
        }

        public final void setInstance(@OXOo.OOXIXo RecordingManager recordingManager) {
            IIX0o.x0xO0oo(recordingManager, "<set-?>");
            RecordingManager.instance = recordingManager;
        }

        private Companion() {
        }
    }

    /* loaded from: classes12.dex */
    public interface OnRecordingCallback {

        /* loaded from: classes12.dex */
        public static final class DefaultImpls {
            public static void onRecordResultLanguage(@OXOo.OOXIXo OnRecordingCallback onRecordingCallback, @OXOo.oOoXoXO AISpeech aISpeech) {
            }
        }

        void onBeforeRecording();

        void onRecordResult(@OXOo.oOoXoXO AITranslation aITranslation);

        void onRecordResultError(@OXOo.OOXIXo String str);

        void onRecordResultLanguage(@OXOo.oOoXoXO AISpeech aISpeech);

        void onStartRecording();

        void onStopRecording();
    }

    /* loaded from: classes12.dex */
    public static final class ScoStateReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Intent intent) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(intent, "intent");
            if (IIX0o.Oxx0IOOO("android.media.ACTION_SCO_AUDIO_STATE_UPDATED", intent.getAction())) {
                int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0);
                if (intExtra != -1) {
                    if (intExtra != 0) {
                        if (intExtra != 1) {
                            if (intExtra == 2) {
                                OI0.oIX0oI.f1507oIX0oI.oIX0oI("RecordingManager SCO Audio State: CONNECTING");
                                return;
                            }
                            return;
                        } else {
                            OI0.oIX0oI.f1507oIX0oI.oIX0oI("RecordingManager SCO Audio State: CONNECTED");
                            RecordingManager.Companion.getInstance().setScoOnOpen();
                            return;
                        }
                    }
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("RecordingManager SCO Audio State: DISCONNECTED");
                    return;
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("RecordingManager SCO Audio State: ERROR");
            }
        }
    }

    static {
        RecordingManager recordingManager;
        Companion companion = new Companion(null);
        Companion = companion;
        synchronized (companion) {
            recordingManager = new RecordingManager();
            instance = recordingManager;
        }
        instance = recordingManager;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.sma.smartv3.biz.voice.RecordingManager$mTimerTask$1] */
    public RecordingManager() {
        MediaItem build = new MediaItem.Builder().setUri(Uri.parse("file:///android_asset/voice_start_audio.mp3")).build();
        IIX0o.oO(build, "build(...)");
        this.mTipItem = build;
        this.mTimerTask = new Runnable() { // from class: com.sma.smartv3.biz.voice.RecordingManager$mTimerTask$1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb = new StringBuilder();
                str = RecordingManager.this.TAG;
                sb.append(str);
                sb.append(" timeout to stop timer");
                oix0oi.oIX0oI(sb.toString());
                RecordingManager.this.setRecording(false);
                AISparkChainManager.f19871oIX0oI.ox();
                RecordingManager.this.closeBluetooth();
                DcsTtsPlayer.INSTANCE.stop();
                VoiceService.f20239Oo.oxoX();
            }
        };
        this.playEnded = true;
        this.mTipPlayer$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ExoPlayer>() { // from class: com.sma.smartv3.biz.voice.RecordingManager$mTipPlayer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.oOoXoXO
            public final ExoPlayer invoke() {
                ExoPlayer exoPlayer;
                ExoPlayer exoPlayer2;
                ExoPlayer exoPlayer3;
                ExoPlayer exoPlayer4;
                ExoPlayer exoPlayer5;
                ExoPlayer exoPlayer6;
                MediaItem mediaItem;
                exoPlayer = RecordingManager.this.player;
                if (exoPlayer == null) {
                    RecordingManager.this.player = new ExoPlayer.Builder(Utils.getApp()).build();
                }
                exoPlayer2 = RecordingManager.this.player;
                if (exoPlayer2 != null) {
                    mediaItem = RecordingManager.this.mTipItem;
                    exoPlayer2.setMediaItem(mediaItem);
                }
                exoPlayer3 = RecordingManager.this.player;
                if (exoPlayer3 != null) {
                    exoPlayer3.setPlaybackParameters(new PlaybackParameters(2.0f));
                }
                exoPlayer4 = RecordingManager.this.player;
                if (exoPlayer4 != null) {
                    final RecordingManager recordingManager = RecordingManager.this;
                    exoPlayer4.addListener(new Player.Listener() { // from class: com.sma.smartv3.biz.voice.RecordingManager$mTipPlayer$2.1
                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
                            O0IxXx.oIX0oI(this, audioAttributes);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onAudioSessionIdChanged(int i) {
                            O0IxXx.II0xO0(this, i);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
                            O0IxXx.I0Io(this, commands);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onCues(CueGroup cueGroup) {
                            O0IxXx.oxoX(this, cueGroup);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
                            O0IxXx.XO(this, deviceInfo);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
                            O0IxXx.Oxx0IOOO(this, i, z);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public void onEvents(@OXOo.OOXIXo Player player, @OXOo.OOXIXo Player.Events events) {
                            String str;
                            IIX0o.x0xO0oo(player, "player");
                            IIX0o.x0xO0oo(events, "events");
                            O0IxXx.II0XooXoX(this, player, events);
                            if (events.contains(11)) {
                                long currentPosition = player.getCurrentPosition();
                                long duration = player.getDuration();
                                if (duration >= currentPosition) {
                                    OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                                    StringBuilder sb = new StringBuilder();
                                    str = RecordingManager.this.TAG;
                                    sb.append(str);
                                    sb.append(" onEvents  events = ");
                                    sb.append(events);
                                    sb.append("  == 11   currentPosition = ");
                                    sb.append(currentPosition);
                                    sb.append("  duration = ");
                                    sb.append(duration);
                                    oix0oi.oIX0oI(sb.toString());
                                }
                            }
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onIsLoadingChanged(boolean z) {
                            O0IxXx.xxIXOIIO(this, z);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onIsPlayingChanged(boolean z) {
                            O0IxXx.xoIox(this, z);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onLoadingChanged(boolean z) {
                            O0IxXx.OOXIXo(this, z);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
                            O0IxXx.oOoXoXO(this, j);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem2, int i) {
                            O0IxXx.ooOOo0oXI(this, mediaItem2, i);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                            O0IxXx.x0XOIxOo(this, mediaMetadata);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onMetadata(Metadata metadata) {
                            O0IxXx.oO(this, metadata);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
                            O0IxXx.x0xO0oo(this, z, i);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                            O0IxXx.Oo(this, playbackParameters);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public void onPlaybackStateChanged(int i) {
                            String str;
                            x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "提示音播放状态 " + i);
                            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                            StringBuilder sb = new StringBuilder();
                            str = RecordingManager.this.TAG;
                            sb.append(str);
                            sb.append("  onPlaybackStateChanged ");
                            sb.append(i);
                            oix0oi.oIX0oI(sb.toString());
                            if (i == 4) {
                                RecordingManager.this.setPlayEnded(true);
                            }
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                            O0IxXx.Oxx0xo(this, i);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
                            O0IxXx.oI0IIXIo(this, playbackException);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
                            O0IxXx.OxxIIOOXO(this, playbackException);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
                            O0IxXx.IIXOooo(this, z, i);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
                            O0IxXx.xoXoI(this, mediaMetadata);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onPositionDiscontinuity(int i) {
                            O0IxXx.o00(this, i);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onRenderedFirstFrame() {
                            O0IxXx.O0xOxO(this);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onRepeatModeChanged(int i) {
                            O0IxXx.X0IIOO(this, i);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onSeekBackIncrementChanged(long j) {
                            O0IxXx.XI0IXoo(this, j);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
                            O0IxXx.XIxXXX0x0(this, j);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onSeekProcessed() {
                            O0IxXx.xxX(this);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
                            O0IxXx.XxX0x0xxx(this, z);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
                            O0IxXx.xXxxox0I(this, z);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
                            O0IxXx.IIX0o(this, i, i2);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                            O0IxXx.ooXIXxIX(this, timeline, i);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
                            O0IxXx.xI(this, trackSelectionParameters);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onTracksChanged(Tracks tracks) {
                            O0IxXx.oo0xXOI0I(this, tracks);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
                            O0IxXx.oo(this, videoSize);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onVolumeChanged(float f) {
                            O0IxXx.IoOoX(this, f);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onCues(List list) {
                            O0IxXx.X0o0xo(this, list);
                        }

                        @Override // com.google.android.exoplayer2.Player.Listener
                        public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
                            O0IxXx.OxI(this, positionInfo, positionInfo2, i);
                        }
                    });
                }
                exoPlayer5 = RecordingManager.this.player;
                if (exoPlayer5 != null) {
                    exoPlayer5.prepare();
                }
                exoPlayer6 = RecordingManager.this.player;
                return exoPlayer6;
            }
        });
    }

    private final void adjustSystemVolume(int i) {
        if (this.audioManager == null) {
            Object systemService = Utils.getApp().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            this.audioManager = (AudioManager) systemService;
        }
        AudioManager audioManager = this.audioManager;
        IIX0o.ooOOo0oXI(audioManager);
        int streamMaxVolume = (i * audioManager.getStreamMaxVolume(3)) / 100;
        AudioManager audioManager2 = this.audioManager;
        IIX0o.ooOOo0oXI(audioManager2);
        audioManager2.setStreamVolume(3, streamMaxVolume, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelTimer() {
        if (this.isStartTimers) {
            this.isStartTimers = false;
            this.mHandler.removeCallbacks(this.mTimerTask);
        }
    }

    private final ExoPlayer getMTipPlayer() {
        return (ExoPlayer) this.mTipPlayer$delegate.getValue();
    }

    private final void initialRecorder() {
        this.mBufferSize = AudioRecord.getMinBufferSize(16000, 16, 2);
        this.mAudioRecord = new AudioRecord(0, 16000, 16, 2, this.mBufferSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playStartTipVideo$lambda$1(RecordingManager this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.playTip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playTip$lambda$3(RecordingManager this$0) {
        ExoPlayer mTipPlayer;
        IIX0o.x0xO0oo(this$0, "this$0");
        ExoPlayer mTipPlayer2 = this$0.getMTipPlayer();
        if (mTipPlayer2 == null || !mTipPlayer2.isPlaying()) {
            x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "开始播放声音提示音");
            ExoPlayer mTipPlayer3 = this$0.getMTipPlayer();
            if ((mTipPlayer3 != null && mTipPlayer3.getPlaybackState() == 1) || ((mTipPlayer = this$0.getMTipPlayer()) != null && mTipPlayer.getPlaybackState() == 4)) {
                ExoPlayer mTipPlayer4 = this$0.getMTipPlayer();
                if (mTipPlayer4 != null) {
                    mTipPlayer4.setMediaItem(this$0.mTipItem);
                }
                ExoPlayer mTipPlayer5 = this$0.getMTipPlayer();
                if (mTipPlayer5 != null) {
                    mTipPlayer5.prepare();
                }
            }
            this$0.playEnded = false;
            ExoPlayer mTipPlayer6 = this$0.getMTipPlayer();
            if (mTipPlayer6 != null) {
                mTipPlayer6.play();
            }
        }
    }

    public static /* synthetic */ void realTimeASRend$default(RecordingManager recordingManager, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            if (ProductManager.xOOxIO(ProductManager.f20544oIX0oI, null, 1, null)) {
                i = 900;
            } else {
                i = 10000;
            }
        }
        if ((i3 & 2) != 0) {
            i2 = recordingManager.mBufferSize;
        }
        recordingManager.realTimeASRend(i, i2);
    }

    public static /* synthetic */ void realTimeASRing$default(RecordingManager recordingManager, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            if (ProductManager.xOOxIO(ProductManager.f20544oIX0oI, null, 1, null)) {
                i = 900;
            } else {
                i = 10000;
            }
        }
        if ((i3 & 4) != 0) {
            i2 = recordingManager.mBufferSize;
        }
        recordingManager.realTimeASRing(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recordAudio$lambda$2(RecordingManager this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.playTip();
    }

    public static /* synthetic */ void recordPermission$default(RecordingManager recordingManager, OnRecordingCallback onRecordingCallback, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        recordingManager.recordPermission(onRecordingCallback, z, z2, str);
    }

    public static /* synthetic */ void setOutputStream$default(RecordingManager recordingManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        recordingManager.setOutputStream(z);
    }

    private final void startTimer() {
        try {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " start timer");
            this.mHandler.removeCallbacks(this.mTimerTask);
            this.isStartTimers = true;
            this.mHandler.postDelayed(this.mTimerTask, 20000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void closeBluetooth() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " closeBluetooth");
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            audioManager.setBluetoothScoOn(false);
        }
        AudioManager audioManager2 = this.audioManager;
        if (audioManager2 != null) {
            audioManager2.stopBluetoothSco();
        }
        AudioManager audioManager3 = this.audioManager;
        if (audioManager3 != null) {
            audioManager3.setMode(0);
        }
    }

    public final boolean getPlayEnded() {
        return this.playEnded;
    }

    public final void init(@OXOo.OOXIXo Application mApp) {
        IIX0o.x0xO0oo(mApp, "mApp");
        if (this.audioManager == null) {
            Object systemService = Utils.getApp().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            this.audioManager = (AudioManager) systemService;
        }
        if (this.player == null || getMTipPlayer() == null) {
            ExoPlayer mTipPlayer = getMTipPlayer();
            if (mTipPlayer != null) {
                mTipPlayer.setMediaItem(this.mTipItem);
            }
            ExoPlayer mTipPlayer2 = getMTipPlayer();
            if (mTipPlayer2 != null) {
                mTipPlayer2.prepare();
            }
        }
    }

    public final boolean isRecording() {
        return this.isRecording;
    }

    public final void playStartTipVideo() {
        long j;
        Handler handler = this.mHandler;
        Runnable runnable = new Runnable() { // from class: com.sma.smartv3.biz.voice.II0XooXoX
            @Override // java.lang.Runnable
            public final void run() {
                RecordingManager.playStartTipVideo$lambda$1(RecordingManager.this);
            }
        };
        if (this.player == null) {
            j = 1300;
        } else {
            j = 1000;
        }
        handler.postDelayed(runnable, j);
    }

    public final void playTip() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " playTip playEnded = " + this.playEnded);
        if (!this.playEnded) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.sma.smartv3.biz.voice.Oxx0IOOO
            @Override // java.lang.Runnable
            public final void run() {
                RecordingManager.playTip$lambda$3(RecordingManager.this);
            }
        });
    }

    public final void realTimeASRend(int i, int i2) {
        if (ProductManager.f20544oIX0oI.oO0OX0()) {
            x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "科大讯飞去语音识别 , 读取结束 ---> ");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " realTimeSendASRData start query");
            AISparkChainManager.oo(AISparkChainManager.f19871oIX0oI, new byte[10], true, i2, null, false, i, null, null, 216, null);
        }
    }

    public final void realTimeASRing(@OXOo.OOXIXo byte[] bytes, int i, int i2) {
        String translationLanguageASRLanguage;
        String str;
        Object obj;
        IIX0o.x0xO0oo(bytes, "bytes");
        if (ProductManager.f20544oIX0oI.oO0OX0()) {
            AISparkChainManager aISparkChainManager = AISparkChainManager.f19871oIX0oI;
            VoiceManager voiceManager = VoiceManager.INSTANCE;
            if (!voiceManager.isSupportAIVoiceTranslation() && !voiceManager.isSupportEarPhoneVoiceTranslation()) {
                String language = Utils.getApp().getResources().getConfiguration().locale.getLanguage();
                if (IIX0o.Oxx0IOOO(language, Languages.DEFAULT_LANGUAGE_ZH)) {
                    str = "cn";
                    AISparkChainManager.oo(aISparkChainManager, bytes, false, i2, new xxxI.II0xO0<AITranslation>() { // from class: com.sma.smartv3.biz.voice.RecordingManager$realTimeASRing$1
                        @Override // xxxI.II0xO0
                        public void handleError(@OXOo.OOXIXo String error) {
                            String str2;
                            RecordingManager.OnRecordingCallback onRecordingCallback;
                            IIX0o.x0xO0oo(error, "error");
                            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                            StringBuilder sb = new StringBuilder();
                            str2 = RecordingManager.this.TAG;
                            sb.append(str2);
                            sb.append(" realTimeSendASRData handleError -> ");
                            sb.append(error);
                            oix0oi.oIX0oI(sb.toString());
                            RecordingManager.this.cancelTimer();
                            onRecordingCallback = RecordingManager.this.recordingCallback;
                            if (onRecordingCallback != null) {
                                onRecordingCallback.onRecordResultError(error);
                            }
                        }

                        @Override // xxxI.II0xO0
                        public void handleResponse(@OXOo.oOoXoXO AITranslation aITranslation) {
                            String str2;
                            RecordingManager.OnRecordingCallback onRecordingCallback;
                            StringBuilder sb = new StringBuilder();
                            sb.append("识别结果如下 ----> ");
                            sb.append(aITranslation != null ? aITranslation.getText() : null);
                            x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, sb.toString());
                            RecordingManager.this.cancelTimer();
                            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                            StringBuilder sb2 = new StringBuilder();
                            str2 = RecordingManager.this.TAG;
                            sb2.append(str2);
                            sb2.append(" realTimeSendASRData handleResponse -> ");
                            sb2.append(aITranslation != null ? aITranslation.getText() : null);
                            oix0oi.oIX0oI(sb2.toString());
                            onRecordingCallback = RecordingManager.this.recordingCallback;
                            if (onRecordingCallback != null) {
                                onRecordingCallback.onRecordResult(aITranslation);
                            }
                        }
                    }, false, i, str, null, 146, null);
                }
                Iterator<T> it = LanguageTranslationKt.getTranslationLanguageList().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (IIX0o.Oxx0IOOO(((LanguageTranslationData) obj).getRtasrLanguage(), language)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                LanguageTranslationData languageTranslationData = (LanguageTranslationData) obj;
                if (languageTranslationData == null || (translationLanguageASRLanguage = languageTranslationData.getRtasrLanguage()) == null) {
                    translationLanguageASRLanguage = Languages.DEFAULT_LANGUAGE;
                }
            } else if (voiceManager.isActivityData()) {
                translationLanguageASRLanguage = voiceManager.getMicrosoftLanguage();
            } else {
                translationLanguageASRLanguage = LanguageTranslationKt.getTranslationLanguageASRLanguage(Languages.INSTANCE.formatAISparkTargetLang(voiceManager.getMLanguage(), "cn"));
            }
            str = translationLanguageASRLanguage;
            AISparkChainManager.oo(aISparkChainManager, bytes, false, i2, new xxxI.II0xO0<AITranslation>() { // from class: com.sma.smartv3.biz.voice.RecordingManager$realTimeASRing$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    String str2;
                    RecordingManager.OnRecordingCallback onRecordingCallback;
                    IIX0o.x0xO0oo(error, "error");
                    OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                    StringBuilder sb = new StringBuilder();
                    str2 = RecordingManager.this.TAG;
                    sb.append(str2);
                    sb.append(" realTimeSendASRData handleError -> ");
                    sb.append(error);
                    oix0oi.oIX0oI(sb.toString());
                    RecordingManager.this.cancelTimer();
                    onRecordingCallback = RecordingManager.this.recordingCallback;
                    if (onRecordingCallback != null) {
                        onRecordingCallback.onRecordResultError(error);
                    }
                }

                @Override // xxxI.II0xO0
                public void handleResponse(@OXOo.oOoXoXO AITranslation aITranslation) {
                    String str2;
                    RecordingManager.OnRecordingCallback onRecordingCallback;
                    StringBuilder sb = new StringBuilder();
                    sb.append("识别结果如下 ----> ");
                    sb.append(aITranslation != null ? aITranslation.getText() : null);
                    x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, sb.toString());
                    RecordingManager.this.cancelTimer();
                    OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                    StringBuilder sb2 = new StringBuilder();
                    str2 = RecordingManager.this.TAG;
                    sb2.append(str2);
                    sb2.append(" realTimeSendASRData handleResponse -> ");
                    sb2.append(aITranslation != null ? aITranslation.getText() : null);
                    oix0oi.oIX0oI(sb2.toString());
                    onRecordingCallback = RecordingManager.this.recordingCallback;
                    if (onRecordingCallback != null) {
                        onRecordingCallback.onRecordResult(aITranslation);
                    }
                }
            }, false, i, str, null, 146, null);
        }
    }

    public final void recordAudio() {
        if (!this.isRecording) {
            OnRecordingCallback onRecordingCallback = this.recordingCallback;
            if (onRecordingCallback != null) {
                onRecordingCallback.onBeforeRecording();
            }
            setStartBluetooth();
            DcsTtsPlayer.INSTANCE.initSegmentation();
            x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "正在开启录音---->");
            this.isRecording = true;
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            initialRecorder();
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 10000;
            xoIXOxX.II0xO0.I0Io(true, false, null, null, 0, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.biz.voice.RecordingManager$recordAudio$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AudioRecord audioRecord;
                    RecordingManager.OnRecordingCallback onRecordingCallback2;
                    FileOutputStream fileOutputStream;
                    int i;
                    String str;
                    AudioRecord audioRecord2;
                    AudioRecord audioRecord3;
                    RecordingManager.OnRecordingCallback onRecordingCallback3;
                    AudioRecord audioRecord4;
                    String str2;
                    int i2;
                    FileOutputStream fileOutputStream2 = null;
                    if (ProductManager.xOOxIO(ProductManager.f20544oIX0oI, null, 1, null)) {
                        Ref.IntRef.this.element = 900;
                        this.playStartTipVideo();
                    }
                    try {
                        try {
                            audioRecord = this.mAudioRecord;
                            if (audioRecord != null) {
                                audioRecord.startRecording();
                            }
                            onRecordingCallback2 = this.recordingCallback;
                            if (onRecordingCallback2 != null) {
                                onRecordingCallback2.onStartRecording();
                            }
                            x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "正在录音，请说话---->");
                            fileOutputStream = new FileOutputStream(VoiceManager.INSTANCE.getMPcmFile());
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Exception e) {
                        e = e;
                    }
                    try {
                        i = this.mBufferSize;
                        byte[] bArr = new byte[i];
                        this.startRealTimeASR();
                        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                        StringBuilder sb = new StringBuilder();
                        str = this.TAG;
                        sb.append(str);
                        sb.append(" recording...  isRecording = ");
                        sb.append(this.isRecording());
                        oix0oi.oIX0oI(sb.toString());
                        while (this.isRecording()) {
                            audioRecord4 = this.mAudioRecord;
                            if (audioRecord4 != null) {
                                audioRecord4.read(bArr, 0, i);
                            }
                            fileOutputStream.write(bArr);
                            fileOutputStream.flush();
                            RecordingManager.realTimeASRing$default(this, bArr, Ref.IntRef.this.element, 0, 4, null);
                            OI0.oIX0oI oix0oi2 = OI0.oIX0oI.f1507oIX0oI;
                            StringBuilder sb2 = new StringBuilder();
                            str2 = this.TAG;
                            sb2.append(str2);
                            sb2.append(" recording...  isRecording = ");
                            sb2.append(this.isRecording());
                            sb2.append(" bytes = ");
                            sb2.append(i);
                            sb2.append(" mBufferSize= ");
                            i2 = this.mBufferSize;
                            sb2.append(i2);
                            oix0oi2.oIX0oI(sb2.toString());
                        }
                        audioRecord2 = this.mAudioRecord;
                        if (audioRecord2 != null) {
                            audioRecord2.stop();
                        }
                        audioRecord3 = this.mAudioRecord;
                        if (audioRecord3 != null) {
                            audioRecord3.release();
                        }
                        onRecordingCallback3 = this.recordingCallback;
                        if (onRecordingCallback3 != null) {
                            onRecordingCallback3.onStopRecording();
                        }
                        fileOutputStream.flush();
                        ProductManager productManager = ProductManager.f20544oIX0oI;
                        if (ProductManager.xOOxIO(productManager, null, 1, null)) {
                            DcsTtsPlayer.playAssetsFile$default(DcsTtsPlayer.INSTANCE, "voice_end_cycle_audio.mp3", true, null, 4, null);
                        }
                        if (productManager.oO0OX0()) {
                            RecordingManager.realTimeASRend$default(this, Ref.IntRef.this.element, 0, 2, null);
                        } else if (booleanRef.element) {
                            VoiceManager.INSTANCE.recognition();
                        }
                        booleanRef.element = false;
                        fileOutputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        this.setRecording(false);
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th;
                    }
                    this.setRecording(false);
                }
            }, 30, null);
            return;
        }
        if (ProductManager.xOOxIO(ProductManager.f20544oIX0oI, null, 1, null)) {
            this.mHandler.post(new Runnable() { // from class: com.sma.smartv3.biz.voice.XO
                @Override // java.lang.Runnable
                public final void run() {
                    RecordingManager.recordAudio$lambda$2(RecordingManager.this);
                }
            });
        }
        x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "正在录音，请说话---->");
    }

    public final void recordPermission(@OXOo.OOXIXo OnRecordingCallback callback, boolean z, boolean z2, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.x0xO0oo(name, "name");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " name:" + name + "  isOutputStream:" + z + "  resetCallBack:" + z2);
        setOutputStream(z);
        if (z2) {
            setRecordingCallback(callback);
        }
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.MICROPHONE, "android.permission.MODIFY_AUDIO_SETTINGS");
        IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.II0xO0(permission, UtilsKt.oI0IIXIo(R.string.microphone_explain_title), UtilsKt.oI0IIXIo(R.string.microphone_explain_content), new Oox.oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.voice.RecordingManager$recordPermission$1
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                IIX0o.x0xO0oo(it, "it");
                if (it == PermissionStatus.GRANTED) {
                    VoiceService.f20239Oo.II0xO0();
                }
            }
        });
    }

    public final void registerSCOReceiver(@OXOo.OOXIXo Application mApp) {
        IIX0o.x0xO0oo(mApp, "mApp");
        if (Build.VERSION.SDK_INT >= 34) {
            ContextCompat.registerReceiver(mApp, new ScoStateReceiver(), new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"), 2);
        } else {
            mApp.registerReceiver(new ScoStateReceiver(), new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        }
    }

    public final void setOutputStream(boolean z) {
        this.mIsStream = z;
    }

    public final void setPlayEnded(boolean z) {
        this.playEnded = z;
    }

    public final void setRecording(boolean z) {
        this.isRecording = z;
    }

    public final void setRecordingCallback(@OXOo.OOXIXo OnRecordingCallback callback) {
        IIX0o.x0xO0oo(callback, "callback");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.TAG + " setRecordingCallback1");
        if (this.recordingCallback != null) {
            this.recordingCallback = null;
        }
        oix0oi.oIX0oI(this.TAG + " setRecordingCallback2");
        this.recordingCallback = callback;
    }

    public final void setScoOnOpen() {
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            audioManager.setBluetoothScoOn(true);
        }
    }

    public final void setStartBluetooth() {
        boolean z;
        Integer num;
        Boolean bool;
        if (this.audioManager == null) {
            Object systemService = Utils.getApp().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            this.audioManager = (AudioManager) systemService;
        }
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            z = audioManager.isBluetoothScoOn();
        } else {
            z = false;
        }
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append(this.TAG);
        sb.append("  startBluetoothSco isRecordBluetooth = ");
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        sb.append(voiceManager.isRecordBluetooth());
        sb.append(" , isOn = ");
        sb.append(z);
        sb.append(", , mode = ");
        AudioManager audioManager2 = this.audioManager;
        Integer num2 = null;
        if (audioManager2 != null) {
            num = Integer.valueOf(audioManager2.getMode());
        } else {
            num = null;
        }
        sb.append(num);
        sb.append("  , isBluetoothScoOn = ");
        AudioManager audioManager3 = this.audioManager;
        if (audioManager3 != null) {
            bool = Boolean.valueOf(audioManager3.isBluetoothScoOn());
        } else {
            bool = null;
        }
        sb.append(bool);
        oix0oi.oIX0oI(sb.toString());
        if (voiceManager.isRecordBluetooth()) {
            if (!z) {
                if (RomUtils.isMeizu()) {
                    AudioManager audioManager4 = this.audioManager;
                    if (audioManager4 != null) {
                        audioManager4.setMode(3);
                    }
                } else {
                    AudioManager audioManager5 = this.audioManager;
                    if (audioManager5 != null) {
                        audioManager5.setMode(2);
                    }
                }
                AudioManager audioManager6 = this.audioManager;
                if (audioManager6 != null) {
                    audioManager6.setSpeakerphoneOn(false);
                }
                AudioManager audioManager7 = this.audioManager;
                if (audioManager7 != null) {
                    audioManager7.setMicrophoneMute(false);
                }
                AudioManager audioManager8 = this.audioManager;
                if (audioManager8 != null) {
                    audioManager8.startBluetoothSco();
                }
            }
        } else {
            AudioManager audioManager9 = this.audioManager;
            if (audioManager9 != null) {
                audioManager9.setMode(0);
            }
            AudioManager audioManager10 = this.audioManager;
            if (audioManager10 != null) {
                audioManager10.setBluetoothScoOn(false);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.TAG);
        sb2.append(" startBluetoothSco end  mode = ");
        AudioManager audioManager11 = this.audioManager;
        if (audioManager11 != null) {
            num2 = Integer.valueOf(audioManager11.getMode());
        }
        sb2.append(num2);
        oix0oi.oIX0oI(sb2.toString());
    }

    public final void startRealTimeASR() {
        AISparkChainManager.x0o(AISparkChainManager.f19871oIX0oI, 0, 1, null);
    }

    public final void startRecord() {
        recordAudio();
    }

    public final void stopRecording() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " stopRecording");
        if (this.isRecording) {
            this.isRecording = false;
        }
    }
}
