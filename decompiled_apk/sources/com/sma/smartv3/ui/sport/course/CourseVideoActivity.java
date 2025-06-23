package com.sma.smartv3.ui.sport.course;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
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
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.CourseDetails;
import com.sma.smartv3.model.ProgressMarkers;
import com.sma.smartv3.ui.sport.course.CourseVideoActivity;
import com.sma.smartv3.view.VideoSeekBar;
import com.sma.smartv3.view.text.PFMedium;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nCourseVideoActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CourseVideoActivity.kt\ncom/sma/smartv3/ui/sport/course/CourseVideoActivity\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,321:1\n36#2:322\n1549#3:323\n1620#3,3:324\n1864#3,3:327\n*S KotlinDebug\n*F\n+ 1 CourseVideoActivity.kt\ncom/sma/smartv3/ui/sport/course/CourseVideoActivity\n*L\n103#1:322\n215#1:323\n215#1:324,3\n230#1:327,3\n*E\n"})
/* loaded from: classes12.dex */
public final class CourseVideoActivity extends BaseActivity implements Player.Listener, View.OnClickListener {
    private boolean isPlay;

    @OXOo.oOoXoXO
    private CourseDetails mCourseDetails;
    private ExoPlayer mPlayer;

    @OXOo.oOoXoXO
    private Timer mTimer;

    @OXOo.OOXIXo
    private final String TAG = "CourseVideoActivity";

    @OXOo.OOXIXo
    private final X0IIOO mPlayerView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PlayerView>() { // from class: com.sma.smartv3.ui.sport.course.CourseVideoActivity$mPlayerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PlayerView invoke() {
            return (PlayerView) CourseVideoActivity.this.findViewById(R.id.player_view);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mControllerView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.course.CourseVideoActivity$mControllerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return CourseVideoActivity.this.findViewById(R.id.course_controller_layout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseMaxTime$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.CourseVideoActivity$mCourseMaxTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) CourseVideoActivity.this.findViewById(R.id.course_video_max_time);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseCurTime$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.CourseVideoActivity$mCourseCurTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) CourseVideoActivity.this.findViewById(R.id.course_video_cur_time);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseSeekBar$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<VideoSeekBar>() { // from class: com.sma.smartv3.ui.sport.course.CourseVideoActivity$mCourseSeekBar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final VideoSeekBar invoke() {
            return (VideoSeekBar) CourseVideoActivity.this.findViewById(R.id.course_seek_bar);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mTvOnBack$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.course.CourseVideoActivity$mTvOnBack$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CourseVideoActivity.this.findViewById(R.id.tv_on_back);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mTvOnPlay$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.course.CourseVideoActivity$mTvOnPlay$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CourseVideoActivity.this.findViewById(R.id.tv_on_play);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mTvHintTitle$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.course.CourseVideoActivity$mTvHintTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CourseVideoActivity.this.findViewById(R.id.tv_hint_title);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseNext$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.CourseVideoActivity$mCourseNext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) CourseVideoActivity.this.findViewById(R.id.course_next);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCoursePlay$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.CourseVideoActivity$mCoursePlay$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) CourseVideoActivity.this.findViewById(R.id.course_play);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCoursePrevious$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.CourseVideoActivity$mCoursePrevious$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) CourseVideoActivity.this.findViewById(R.id.course_previous);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseLockScreen$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.CourseVideoActivity$mCourseLockScreen$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) CourseVideoActivity.this.findViewById(R.id.course_lock_screen);
        }
    });

    @OXOo.OOXIXo
    private final TimerTask task = new oIX0oI();

    @OXOo.OOXIXo
    private final List<Integer> mActionIndex = new ArrayList();
    private boolean isShowView = true;

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends TimerTask {
        public oIX0oI() {
        }

        public static final void II0xO0(CourseVideoActivity this$0) {
            IIX0o.x0xO0oo(this$0, "this$0");
            PFMedium mCourseCurTime = this$0.getMCourseCurTime();
            ExoPlayer exoPlayer = this$0.mPlayer;
            ExoPlayer exoPlayer2 = null;
            if (exoPlayer == null) {
                IIX0o.XOxIOxOx("mPlayer");
                exoPlayer = null;
            }
            long j = 1000;
            mCourseCurTime.setText(com.sma.smartv3.util.xoIox.IoOoo((int) (exoPlayer.getCurrentPosition() / j)));
            PFMedium mCourseMaxTime = this$0.getMCourseMaxTime();
            ExoPlayer exoPlayer3 = this$0.mPlayer;
            if (exoPlayer3 == null) {
                IIX0o.XOxIOxOx("mPlayer");
                exoPlayer3 = null;
            }
            mCourseMaxTime.setText(com.sma.smartv3.util.xoIox.IoOoo((int) (exoPlayer3.getDuration() / j)));
            VideoSeekBar mCourseSeekBar = this$0.getMCourseSeekBar();
            ExoPlayer exoPlayer4 = this$0.mPlayer;
            if (exoPlayer4 == null) {
                IIX0o.XOxIOxOx("mPlayer");
                exoPlayer4 = null;
            }
            mCourseSeekBar.setProgress((int) (exoPlayer4.getCurrentPosition() / j));
            VideoSeekBar mCourseSeekBar2 = this$0.getMCourseSeekBar();
            ExoPlayer exoPlayer5 = this$0.mPlayer;
            if (exoPlayer5 == null) {
                IIX0o.XOxIOxOx("mPlayer");
            } else {
                exoPlayer2 = exoPlayer5;
            }
            mCourseSeekBar2.setMax((int) (exoPlayer2.getDuration() / j));
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            final CourseVideoActivity courseVideoActivity = CourseVideoActivity.this;
            courseVideoActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.sport.course.oI0IIXIo
                @Override // java.lang.Runnable
                public final void run() {
                    CourseVideoActivity.oIX0oI.II0xO0(CourseVideoActivity.this);
                }
            });
        }
    }

    private final void completeCourse() {
    }

    private final View getMControllerView() {
        return (View) this.mControllerView$delegate.getValue();
    }

    private final PlayerView getMPlayerView() {
        return (PlayerView) this.mPlayerView$delegate.getValue();
    }

    public final void curPlayAction(boolean z) {
        initActionIndex();
        ExoPlayer exoPlayer = this.mPlayer;
        ExoPlayer exoPlayer2 = null;
        if (exoPlayer == null) {
            IIX0o.XOxIOxOx("mPlayer");
            exoPlayer = null;
        }
        long currentPosition = exoPlayer.getCurrentPosition() / 1000;
        int i = -1;
        int i2 = 0;
        for (Object obj : this.mActionIndex) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            int intValue = ((Number) obj).intValue();
            LogUtils.d(this.TAG + "  mActionIndex 执行--?> " + i2 + TokenParser.SP + intValue);
            if (z) {
                if (intValue > currentPosition && i == -1) {
                    i = i2;
                }
            } else if (intValue <= currentPosition) {
                i = i2 - 1;
            }
            i2 = i3;
        }
        if (i == -1) {
            if (z) {
                completeCourse();
                return;
            }
            ExoPlayer exoPlayer3 = this.mPlayer;
            if (exoPlayer3 == null) {
                IIX0o.XOxIOxOx("mPlayer");
            } else {
                exoPlayer2 = exoPlayer3;
            }
            exoPlayer2.seekTo(0L);
            return;
        }
        ExoPlayer exoPlayer4 = this.mPlayer;
        if (exoPlayer4 == null) {
            IIX0o.XOxIOxOx("mPlayer");
        } else {
            exoPlayer2 = exoPlayer4;
        }
        exoPlayer2.seekTo(this.mActionIndex.get(i).longValue() * 1000);
    }

    public final PFMedium getMCourseCurTime() {
        return (PFMedium) this.mCourseCurTime$delegate.getValue();
    }

    public final ImageView getMCourseLockScreen() {
        return (ImageView) this.mCourseLockScreen$delegate.getValue();
    }

    public final PFMedium getMCourseMaxTime() {
        return (PFMedium) this.mCourseMaxTime$delegate.getValue();
    }

    public final ImageView getMCourseNext() {
        return (ImageView) this.mCourseNext$delegate.getValue();
    }

    public final ImageView getMCoursePlay() {
        return (ImageView) this.mCoursePlay$delegate.getValue();
    }

    public final ImageView getMCoursePrevious() {
        return (ImageView) this.mCoursePrevious$delegate.getValue();
    }

    public final VideoSeekBar getMCourseSeekBar() {
        return (VideoSeekBar) this.mCourseSeekBar$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity
    public int getMStatusStyle() {
        return 1;
    }

    @OXOo.oOoXoXO
    public final Timer getMTimer() {
        return this.mTimer;
    }

    public final TextView getMTvHintTitle() {
        return (TextView) this.mTvHintTitle$delegate.getValue();
    }

    public final TextView getMTvOnBack() {
        return (TextView) this.mTvOnBack$delegate.getValue();
    }

    public final TextView getMTvOnPlay() {
        return (TextView) this.mTvOnPlay$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final TimerTask getTask() {
        return this.task;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        this.mCourseDetails = (CourseDetails) getMArg3();
    }

    public final void initActionIndex() {
        List<ProgressMarkers> list;
        if (this.mActionIndex.size() == 0) {
            CourseDetails courseDetails = this.mCourseDetails;
            if (courseDetails != null) {
                list = courseDetails.getProgressMarkers();
            } else {
                list = null;
            }
            if (list != null) {
                List<ProgressMarkers> list2 = list;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
                for (ProgressMarkers progressMarkers : list2) {
                    LogUtils.d(this.TAG + " 当前下标  ---> ???  = " + progressMarkers.getOffset());
                    arrayList.add(Boolean.valueOf(this.mActionIndex.add(Integer.valueOf(Integer.parseInt(progressMarkers.getOffset())))));
                }
            }
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        String str;
        TextView textView = (TextView) findViewById(R.id.abh_title_center);
        CourseDetails courseDetails = this.mCourseDetails;
        String str2 = null;
        if (courseDetails != null) {
            str = courseDetails.getCourseName();
        } else {
            str = null;
        }
        textView.setText(str);
        setRequestedOrientation(0);
        getMPlayerView().setKeepScreenOn(true);
        ExoPlayer build = new ExoPlayer.Builder(this).build();
        IIX0o.oO(build, "build(...)");
        this.mPlayer = build;
        PlayerView mPlayerView = getMPlayerView();
        ExoPlayer exoPlayer = this.mPlayer;
        if (exoPlayer == null) {
            IIX0o.XOxIOxOx("mPlayer");
            exoPlayer = null;
        }
        mPlayerView.setPlayer(exoPlayer);
        ExoPlayer exoPlayer2 = this.mPlayer;
        if (exoPlayer2 == null) {
            IIX0o.XOxIOxOx("mPlayer");
            exoPlayer2 = null;
        }
        exoPlayer2.addListener(this);
        getMPlayerView().setUseController(false);
        ExoPlayer exoPlayer3 = this.mPlayer;
        if (exoPlayer3 == null) {
            IIX0o.XOxIOxOx("mPlayer");
            exoPlayer3 = null;
        }
        String mArg0 = getMArg0();
        IIX0o.ooOOo0oXI(mArg0);
        exoPlayer3.setMediaItem(MediaItem.fromUri(Uri.fromFile(new File(mArg0))));
        ExoPlayer exoPlayer4 = this.mPlayer;
        if (exoPlayer4 == null) {
            IIX0o.XOxIOxOx("mPlayer");
            exoPlayer4 = null;
        }
        exoPlayer4.prepare();
        ExoPlayer exoPlayer5 = this.mPlayer;
        if (exoPlayer5 == null) {
            IIX0o.XOxIOxOx("mPlayer");
            exoPlayer5 = null;
        }
        exoPlayer5.play();
        initActionIndex();
        getMCourseSeekBar().setRulerCount(this.mActionIndex);
        getMCourseSeekBar().setEnabled(false);
        PFMedium mCourseCurTime = getMCourseCurTime();
        ExoPlayer exoPlayer6 = this.mPlayer;
        if (exoPlayer6 == null) {
            IIX0o.XOxIOxOx("mPlayer");
            exoPlayer6 = null;
        }
        mCourseCurTime.setText(String.valueOf(exoPlayer6.getCurrentPosition() / 1000));
        PFMedium mCourseMaxTime = getMCourseMaxTime();
        CourseDetails courseDetails2 = this.mCourseDetails;
        if (courseDetails2 != null) {
            str2 = courseDetails2.getCourseTime();
        }
        mCourseMaxTime.setText(String.valueOf(str2));
        getMCourseNext().setOnClickListener(this);
        getMCoursePlay().setOnClickListener(this);
        getMCoursePrevious().setOnClickListener(this);
        getMCourseLockScreen().setOnClickListener(this);
        getMPlayerView().setOnClickListener(this);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColors(CollectionsKt___CollectionsKt.o0Oox0xox(CollectionsKt__CollectionsKt.X00IoxXI(Integer.valueOf(Color.parseColor("#21201F")), 0, Integer.valueOf(Color.parseColor("#21201F")))));
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        getMControllerView().setBackground(gradientDrawable);
        Timer timer = new Timer();
        this.mTimer = timer;
        timer.schedule(this.task, 0L, 1000L);
    }

    public final boolean isShowView() {
        return this.isShowView;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_course_video;
    }

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

    public final void onBack(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@OXOo.oOoXoXO View view) {
        Integer num;
        int i = 0;
        LogUtils.d(this.TAG + " 点击了监听 isPlay " + this.isPlay);
        ExoPlayer exoPlayer = null;
        if (view != null) {
            num = Integer.valueOf(view.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.course_next) {
            curPlayAction(true);
            return;
        }
        if (num != null && num.intValue() == R.id.course_play) {
            if (this.isPlay) {
                ExoPlayer exoPlayer2 = this.mPlayer;
                if (exoPlayer2 == null) {
                    IIX0o.XOxIOxOx("mPlayer");
                } else {
                    exoPlayer = exoPlayer2;
                }
                exoPlayer.pause();
                getMCoursePlay().setImageResource(R.drawable.icon_course_play);
                getMTvOnBack().setVisibility(0);
                getMTvOnPlay().setVisibility(0);
                getMTvHintTitle().setVisibility(0);
            } else {
                ExoPlayer exoPlayer3 = this.mPlayer;
                if (exoPlayer3 == null) {
                    IIX0o.XOxIOxOx("mPlayer");
                } else {
                    exoPlayer = exoPlayer3;
                }
                exoPlayer.play();
                getMCoursePlay().setImageResource(R.drawable.icon_course_pause);
                getMTvOnBack().setVisibility(8);
                getMTvOnPlay().setVisibility(8);
                getMTvHintTitle().setVisibility(8);
            }
            this.isPlay = !this.isPlay;
            return;
        }
        if (num != null && num.intValue() == R.id.course_previous) {
            curPlayAction(false);
            return;
        }
        if ((num == null || num.intValue() != R.id.course_lock_screen) && num != null && num.intValue() == R.id.player_view) {
            this.isShowView = !this.isShowView;
            View mControllerView = getMControllerView();
            if (!this.isShowView) {
                i = 8;
            }
            mControllerView.setVisibility(i);
        }
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@OXOo.oOoXoXO Bundle bundle) {
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onCues(CueGroup cueGroup) {
        O0IxXx.oxoX(this, cueGroup);
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ExoPlayer exoPlayer = this.mPlayer;
        ExoPlayer exoPlayer2 = null;
        if (exoPlayer == null) {
            IIX0o.XOxIOxOx("mPlayer");
            exoPlayer = null;
        }
        exoPlayer.removeListener(this);
        ExoPlayer exoPlayer3 = this.mPlayer;
        if (exoPlayer3 == null) {
            IIX0o.XOxIOxOx("mPlayer");
        } else {
            exoPlayer2 = exoPlayer3;
        }
        exoPlayer2.release();
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
    public /* synthetic */ void onEvents(Player player, Player.Events events) {
        O0IxXx.II0XooXoX(this, player, events);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onIsLoadingChanged(boolean z) {
        O0IxXx.xxIXOIIO(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onIsPlayingChanged(boolean z) {
        O0IxXx.xoIox(this, z);
        LogUtils.d(this.TAG + " onIsPlayingChanged  isPlaying = " + z);
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
    public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
        O0IxXx.ooOOo0oXI(this, mediaItem, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        O0IxXx.x0XOIxOo(this, mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onMetadata(Metadata metadata) {
        O0IxXx.oO(this, metadata);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        getMPlayerView().onPause();
    }

    public final void onPlay(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        ExoPlayer exoPlayer = this.mPlayer;
        if (exoPlayer == null) {
            IIX0o.XOxIOxOx("mPlayer");
            exoPlayer = null;
        }
        exoPlayer.play();
        getMCoursePlay().setImageResource(R.drawable.icon_course_pause);
        this.isPlay = !this.isPlay;
        getMTvOnBack().setVisibility(8);
        getMTvOnPlay().setVisibility(8);
        getMTvHintTitle().setVisibility(8);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayWhenReadyChanged(boolean z, int i) {
        O0IxXx.x0xO0oo(this, z, i);
        LogUtils.d(this.TAG + " onPlayWhenReadyChanged");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        O0IxXx.Oo(this, playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlaybackStateChanged(int i) {
        O0IxXx.IXxxXO(this, i);
        LogUtils.d(this.TAG + " onPlaybackStateChanged playbackState = " + i);
        if (i == 4) {
            completeCourse();
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
        O0IxXx.Oxx0xo(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayerError(@OXOo.OOXIXo PlaybackException error) {
        IIX0o.x0xO0oo(error, "error");
        O0IxXx.oI0IIXIo(this, error);
        error.getCause();
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getMPlayerView().onResume();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onSeekBackIncrementChanged(long j) {
        O0IxXx.XI0IXoo(this, j);
        LogUtils.d(this.TAG + " onSeekBackIncrementChanged " + j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onSeekForwardIncrementChanged(long j) {
        O0IxXx.XIxXXX0x0(this, j);
        LogUtils.d(this.TAG + " onSeekForwardIncrementChanged " + j);
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
        O0IxXx.IIX0o(this, i, i2);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
        O0IxXx.ooXIXxIX(this, timeline, i);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
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

    public final void setMTimer(@OXOo.oOoXoXO Timer timer) {
        this.mTimer = timer;
    }

    public final void setShowView(boolean z) {
        this.isShowView = z;
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onCues(List list) {
        O0IxXx.X0o0xo(this, list);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        O0IxXx.OxI(this, positionInfo, positionInfo2, i);
    }
}
