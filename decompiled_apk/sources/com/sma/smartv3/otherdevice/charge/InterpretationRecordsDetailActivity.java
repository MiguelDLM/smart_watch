package com.sma.smartv3.otherdevice.charge;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.io.Location;
import com.blankj.utilcode.util.ClipboardUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.AIRecordsDao;
import com.sma.smartv3.db.entity.AIRecords;
import com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity;
import com.sma.smartv3.pop.Oxx;
import com.sma.smartv3.view.text.PFMedium;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

@kotlin.jvm.internal.XX({"SMAP\nInterpretationRecordsDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InterpretationRecordsDetailActivity.kt\ncom/sma/smartv3/otherdevice/charge/InterpretationRecordsDetailActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,292:1\n1#2:293\n*E\n"})
/* loaded from: classes12.dex */
public final class InterpretationRecordsDetailActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private AudioManager audioManager;
    private boolean isPlayAudio;

    @OXOo.oOoXoXO
    private AIRecords mAIRecords;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.IIX0o mEditPop;

    @OXOo.oOoXoXO
    private Oxx mTranslationDetailPopup;
    private int recordingTime;

    @OXOo.oOoXoXO
    private Timer timer;

    @OXOo.OOXIXo
    private final AIRecordsDao mRecordsDao = MyDb.INSTANCE.getMDatabase().aiRecordsDao();

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleCenter$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) InterpretationRecordsDetailActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) InterpretationRecordsDetailActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final String TAG = "InterpretationRecordsDetailActivity";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecordsTitle$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$mRecordsTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) InterpretationRecordsDetailActivity.this.findViewById(R.id.interpretation_records_title);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecordsTitleEditImg$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$mRecordsTitleEditImg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) InterpretationRecordsDetailActivity.this.findViewById(R.id.transform_title_edit_img);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecordsLanguage$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$mRecordsLanguage$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) InterpretationRecordsDetailActivity.this.findViewById(R.id.interpretation_records_language);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecordsToLanguage$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$mRecordsToLanguage$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) InterpretationRecordsDetailActivity.this.findViewById(R.id.interpretation_records_to_language);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecordsLocation$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$mRecordsLocation$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) InterpretationRecordsDetailActivity.this.findViewById(R.id.interpretation_records_location);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecordsTime$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$mRecordsTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) InterpretationRecordsDetailActivity.this.findViewById(R.id.interpretation_records_time);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecordsContent$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$mRecordsContent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) InterpretationRecordsDetailActivity.this.findViewById(R.id.interpretation_records_content);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecordsExtraInfo$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$mRecordsExtraInfo$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) InterpretationRecordsDetailActivity.this.findViewById(R.id.interpretation_records_extraInfo);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecordsAudioSeekBar$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ProgressBar>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$mRecordsAudioSeekBar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ProgressBar invoke() {
            return (ProgressBar) InterpretationRecordsDetailActivity.this.findViewById(R.id.interpretation_records_audio_seekbar);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecordsAudioDuration$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$mRecordsAudioDuration$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) InterpretationRecordsDetailActivity.this.findViewById(R.id.interpretation_records_audio_duration);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecordsPlayAudioBtn$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$mRecordsPlayAudioBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) InterpretationRecordsDetailActivity.this.findViewById(R.id.simultaneous_play_audio_icon);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecordsPlayVolumeBtn$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$mRecordsPlayVolumeBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) InterpretationRecordsDetailActivity.this.findViewById(R.id.simultaneous_play_audio_volume_icon);
        }
    });
    private boolean isOpenVolume = true;

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends TimerTask {
        public oIX0oI() {
        }

        public static final void II0xO0(InterpretationRecordsDetailActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.setRecordingTime(this$0.getRecordingTime() + 1);
            this$0.getMRecordsAudioSeekBar().setProgress(this$0.getRecordingTime());
            if (this$0.getRecordingTime() >= 13) {
                Timer timer = this$0.timer;
                if (timer != null) {
                    timer.cancel();
                }
                this$0.setPlayAudio(false);
                this$0.getMRecordsPlayAudioBtn().setImageResource(R.drawable.icon_run_start);
                com.sma.smartv3.util.xoxXI.f24733oIX0oI.xxIXOIIO();
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            final InterpretationRecordsDetailActivity interpretationRecordsDetailActivity = InterpretationRecordsDetailActivity.this;
            interpretationRecordsDetailActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.oX
                @Override // java.lang.Runnable
                public final void run() {
                    InterpretationRecordsDetailActivity.oIX0oI.II0xO0(InterpretationRecordsDetailActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(InterpretationRecordsDetailActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.showEditPopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(InterpretationRecordsDetailActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        boolean z = this$0.isPlayAudio;
        this$0.isPlayAudio = !z;
        if (!z) {
            this$0.getMRecordsPlayAudioBtn().setImageResource(R.drawable.icon_run_pause);
            try {
                AIRecords aIRecords = this$0.mAIRecords;
                if (aIRecords != null) {
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(aIRecords);
                    if (aIRecords.getMAudioPath().length() > 0) {
                        com.sma.smartv3.util.xoxXI xoxxi = com.sma.smartv3.util.xoxXI.f24733oIX0oI;
                        AIRecords aIRecords2 = this$0.mAIRecords;
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(aIRecords2);
                        com.sma.smartv3.util.xoxXI.X0o0xo(xoxxi, aIRecords2.getMAudioPath(), 0, 2, null);
                        this$0.recordingTime = 0;
                        Timer timer = this$0.timer;
                        if (timer != null) {
                            timer.cancel();
                        }
                        Timer timer2 = new Timer();
                        this$0.timer = timer2;
                        timer2.scheduleAtFixedRate(new oIX0oI(), 0L, 1000L);
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception e) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " play e = " + e);
                ToastUtils.showLong("音频文件已损坏", new Object[0]);
                return;
            }
        }
        this$0.getMRecordsPlayAudioBtn().setImageResource(R.drawable.icon_run_start);
        com.sma.smartv3.util.xoxXI.f24733oIX0oI.xxIXOIIO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(InterpretationRecordsDetailActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        boolean z = this$0.isOpenVolume;
        this$0.isOpenVolume = !z;
        if (!z) {
            com.sma.smartv3.util.xoxXI.f24733oIX0oI.Oxx0IOOO();
            this$0.getMRecordsPlayVolumeBtn().setImageResource(R.drawable.simultaneous_play_volume_icon);
            return;
        }
        Object systemService = this$0.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        com.sma.smartv3.util.xoxXI xoxxi = com.sma.smartv3.util.xoxXI.f24733oIX0oI;
        xoxxi.oIX0oI(streamVolume / streamMaxVolume);
        xoxxi.xoIox();
        this$0.getMRecordsPlayVolumeBtn().setImageResource(R.drawable.simultaneous_closure_volume_icon);
    }

    private final void showEditPopup() {
        String str;
        if (this.mEditPop == null) {
            com.sma.smartv3.pop.IIX0o iIX0o = new com.sma.smartv3.pop.IIX0o(getMContext(), 0, 2, null);
            iIX0o.xXxxox0I().setTextColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.line_color));
            iIX0o.xII(R.string.title);
            AIRecords aIRecords = this.mAIRecords;
            if (aIRecords == null || (str = aIRecords.getMAITitle()) == null) {
                str = "";
            }
            iIX0o.Xx000oIo(str);
            iIX0o.IO(new Oox.oOoXoXO<String, Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$showEditPopup$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final Boolean invoke(@OXOo.OOXIXo String text) {
                    AIRecords aIRecords2;
                    AIRecords aIRecords3;
                    AIRecordsDao aIRecordsDao;
                    AIRecords aIRecords4;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
                    if (!TextUtils.isEmpty(text)) {
                        InterpretationRecordsDetailActivity.this.getMRecordsTitle().setText(text);
                        aIRecords2 = InterpretationRecordsDetailActivity.this.mAIRecords;
                        if (aIRecords2 != null) {
                            aIRecords2.setMAITitle(text);
                        }
                        aIRecords3 = InterpretationRecordsDetailActivity.this.mAIRecords;
                        if (aIRecords3 != null) {
                            aIRecordsDao = InterpretationRecordsDetailActivity.this.mRecordsDao;
                            aIRecords4 = InterpretationRecordsDetailActivity.this.mAIRecords;
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(aIRecords4);
                            if (aIRecordsDao.update(aIRecords4) > 0) {
                                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24609XIXIxO, null, 2, null);
                            }
                        }
                    }
                    return Boolean.TRUE;
                }
            });
            this.mEditPop = iIX0o;
        }
        com.sma.smartv3.pop.IIX0o iIX0o2 = this.mEditPop;
        if (iIX0o2 != null) {
            iIX0o2.IIXOooo();
        }
    }

    public final void exportTextToFile(@OXOo.OOXIXo String textToExport) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(textToExport, "textToExport");
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        File oIX0oI2 = oix0oi.oIX0oI(Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0("share"), "record_text.txt");
        try {
            if (oIX0oI2.exists()) {
                oIX0oI2.delete();
            }
            FileUtils.createOrExistsFile(oIX0oI2);
            FileWriter fileWriter = new FileWriter(oIX0oI2);
            fileWriter.write(textToExport);
            fileWriter.close();
            Uri oxoX2 = oix0oi.oxoX(oIX0oI2);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", "Share txt");
            intent.putExtra("android.intent.extra.STREAM", oxoX2);
            intent.setType("*/*");
            intent.addFlags(268435456);
            startActivity(Intent.createChooser(intent, "Share txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final TextView getAbhTitleCenter() {
        return (TextView) this.abhTitleCenter$delegate.getValue();
    }

    public final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    public final PFMedium getMRecordsAudioDuration() {
        return (PFMedium) this.mRecordsAudioDuration$delegate.getValue();
    }

    public final ProgressBar getMRecordsAudioSeekBar() {
        return (ProgressBar) this.mRecordsAudioSeekBar$delegate.getValue();
    }

    public final PFMedium getMRecordsContent() {
        return (PFMedium) this.mRecordsContent$delegate.getValue();
    }

    public final PFMedium getMRecordsExtraInfo() {
        return (PFMedium) this.mRecordsExtraInfo$delegate.getValue();
    }

    public final PFMedium getMRecordsLanguage() {
        return (PFMedium) this.mRecordsLanguage$delegate.getValue();
    }

    public final PFMedium getMRecordsLocation() {
        return (PFMedium) this.mRecordsLocation$delegate.getValue();
    }

    public final ImageView getMRecordsPlayAudioBtn() {
        return (ImageView) this.mRecordsPlayAudioBtn$delegate.getValue();
    }

    public final ImageView getMRecordsPlayVolumeBtn() {
        return (ImageView) this.mRecordsPlayVolumeBtn$delegate.getValue();
    }

    public final PFMedium getMRecordsTime() {
        return (PFMedium) this.mRecordsTime$delegate.getValue();
    }

    public final PFMedium getMRecordsTitle() {
        return (PFMedium) this.mRecordsTitle$delegate.getValue();
    }

    public final ImageView getMRecordsTitleEditImg() {
        return (ImageView) this.mRecordsTitleEditImg$delegate.getValue();
    }

    public final PFMedium getMRecordsToLanguage() {
        return (PFMedium) this.mRecordsToLanguage$delegate.getValue();
    }

    public final int getRecordingTime() {
        return this.recordingTime;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        Serializable mArg3 = getMArg3();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.db.entity.AIRecords");
        this.mAIRecords = (AIRecords) mArg3;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @SuppressLint({"DiscouragedApi"})
    public void initView() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        getAbhTitleCenter().setText(getString(R.string.interpretation_record));
        int i = 0;
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ai_answer_more_icon);
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        PFMedium mRecordsTitle = getMRecordsTitle();
        AIRecords aIRecords = this.mAIRecords;
        String str8 = null;
        if (aIRecords != null) {
            str = aIRecords.getMAITitle();
        } else {
            str = null;
        }
        mRecordsTitle.setText(str);
        getMRecordsTitleEditImg().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.xXOx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterpretationRecordsDetailActivity.initView$lambda$1(InterpretationRecordsDetailActivity.this, view);
            }
        });
        PFMedium mRecordsLanguage = getMRecordsLanguage();
        AIRecords aIRecords2 = this.mAIRecords;
        if (aIRecords2 != null) {
            str2 = aIRecords2.getMTranslateLanguage();
        } else {
            str2 = null;
        }
        mRecordsLanguage.setText(str2);
        PFMedium mRecordsToLanguage = getMRecordsToLanguage();
        AIRecords aIRecords3 = this.mAIRecords;
        if (aIRecords3 != null) {
            str3 = aIRecords3.getMTranslateToLanguage();
        } else {
            str3 = null;
        }
        mRecordsToLanguage.setText(str3);
        PFMedium mRecordsLocation = getMRecordsLocation();
        AIRecords aIRecords4 = this.mAIRecords;
        if (aIRecords4 != null && (str4 = aIRecords4.getMLocation()) != null) {
            if (str4.length() == 0) {
                str4 = HelpFormatter.DEFAULT_OPT_PREFIX;
            }
        } else {
            str4 = null;
        }
        mRecordsLocation.setText(str4);
        PFMedium mRecordsTime = getMRecordsTime();
        AIRecords aIRecords5 = this.mAIRecords;
        if (aIRecords5 != null) {
            str5 = aIRecords5.getMLocalTime();
        } else {
            str5 = null;
        }
        mRecordsTime.setText(str5);
        PFMedium mRecordsContent = getMRecordsContent();
        AIRecords aIRecords6 = this.mAIRecords;
        if (aIRecords6 != null) {
            str6 = aIRecords6.getMContent();
        } else {
            str6 = null;
        }
        mRecordsContent.setText(str6);
        PFMedium mRecordsExtraInfo = getMRecordsExtraInfo();
        AIRecords aIRecords7 = this.mAIRecords;
        if (aIRecords7 != null) {
            str7 = aIRecords7.getMExtraInfo();
        } else {
            str7 = null;
        }
        mRecordsExtraInfo.setText(str7);
        ProgressBar mRecordsAudioSeekBar = getMRecordsAudioSeekBar();
        AIRecords aIRecords8 = this.mAIRecords;
        if (aIRecords8 != null) {
            i = aIRecords8.getMAudioDuration();
        }
        mRecordsAudioSeekBar.setMax(i);
        PFMedium mRecordsAudioDuration = getMRecordsAudioDuration();
        AIRecords aIRecords9 = this.mAIRecords;
        if (aIRecords9 != null) {
            str8 = com.sma.smartv3.util.xoIox.Io(aIRecords9.getMAudioDuration());
        }
        mRecordsAudioDuration.setText(str8);
        getMRecordsPlayAudioBtn().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.XX0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterpretationRecordsDetailActivity.initView$lambda$3(InterpretationRecordsDetailActivity.this, view);
            }
        });
        getMRecordsPlayVolumeBtn().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.I0X0x0oIo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterpretationRecordsDetailActivity.initView$lambda$4(InterpretationRecordsDetailActivity.this, view);
            }
        });
    }

    public final boolean isOpenVolume() {
        return this.isOpenVolume;
    }

    public final boolean isPlayAudio() {
        return this.isPlayAudio;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_interpretation_records_detail;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        showDeleteTipPopup();
    }

    public final void setOpenVolume(boolean z) {
        this.isOpenVolume = z;
    }

    public final void setPlayAudio(boolean z) {
        this.isPlayAudio = z;
    }

    public final void setRecordingTime(int i) {
        this.recordingTime = i;
    }

    public final void showDeleteTipPopup() {
        String str;
        int i;
        String mContent;
        if (this.mTranslationDetailPopup == null) {
            AIRecords aIRecords = this.mAIRecords;
            String str2 = null;
            if (aIRecords != null) {
                str = aIRecords.getMAudioPath();
            } else {
                str = null;
            }
            File file = new File(str);
            Oxx oxx = new Oxx(getMContext());
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.action_details));
            sb.append(": ");
            AIRecords aIRecords2 = this.mAIRecords;
            int i2 = 0;
            if (aIRecords2 != null) {
                i = aIRecords2.getMAudioDuration();
            } else {
                i = 0;
            }
            sb.append(com.sma.smartv3.util.xoIox.Io(i));
            oxx.Io(sb.toString());
            oxx.XX(getString(R.string.file_size_title_tip) + ": " + FileUtils.getSize(file));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getString(R.string.number_of_words));
            sb2.append(": ");
            AIRecords aIRecords3 = this.mAIRecords;
            if (aIRecords3 != null && (mContent = aIRecords3.getMContent()) != null) {
                i2 = mContent.length();
            }
            sb2.append(i2);
            oxx.oxxXoxO(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(getString(R.string.create_time_tip));
            sb3.append(": ");
            AIRecords aIRecords4 = this.mAIRecords;
            if (aIRecords4 != null) {
                str2 = aIRecords4.getMLocalTime();
            }
            sb3.append(str2);
            oxx.o0(sb3.toString());
            oxx.I0oOoX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$showDeleteTipPopup$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i3) {
                    AIRecords aIRecords5;
                    AIRecords aIRecords6;
                    String mContent2;
                    Activity mContext;
                    if (i3 == 1) {
                        aIRecords5 = InterpretationRecordsDetailActivity.this.mAIRecords;
                        ClipboardUtils.copyText(aIRecords5 != null ? aIRecords5.getMContent() : null);
                        ToastUtils.showLong(R.string.copied);
                    } else if (i3 == 2) {
                        aIRecords6 = InterpretationRecordsDetailActivity.this.mAIRecords;
                        if (aIRecords6 != null && (mContent2 = aIRecords6.getMContent()) != null && mContent2.length() > 0) {
                            final InterpretationRecordsDetailActivity interpretationRecordsDetailActivity = InterpretationRecordsDetailActivity.this;
                            xoIXOxX.II0xO0.I0Io(true, false, null, null, 0, new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$showDeleteTipPopup$1$1.1
                                {
                                    super(0);
                                }

                                @Override // Oox.oIX0oI
                                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                                    invoke2();
                                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    AIRecords aIRecords7;
                                    InterpretationRecordsDetailActivity interpretationRecordsDetailActivity2 = InterpretationRecordsDetailActivity.this;
                                    aIRecords7 = interpretationRecordsDetailActivity2.mAIRecords;
                                    String mContent3 = aIRecords7 != null ? aIRecords7.getMContent() : null;
                                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(mContent3);
                                    interpretationRecordsDetailActivity2.exportTextToFile(mContent3);
                                }
                            }, 30, null);
                        }
                    } else if (i3 == 3) {
                        mContext = InterpretationRecordsDetailActivity.this.getMContext();
                        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(mContext, 0, 2, null);
                        final InterpretationRecordsDetailActivity interpretationRecordsDetailActivity2 = InterpretationRecordsDetailActivity.this;
                        xoI0Ixx0.IoOoX(R.string.weather_del_file);
                        xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$showDeleteTipPopup$1$1$2$1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // Oox.oIX0oI
                            @OXOo.OOXIXo
                            public final Boolean invoke() {
                                return Boolean.TRUE;
                            }
                        });
                        xoI0Ixx0.x0o(R.string.delete, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsDetailActivity$showDeleteTipPopup$1$1$2$2
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // Oox.oIX0oI
                            @OXOo.OOXIXo
                            public final Boolean invoke() {
                                AIRecords aIRecords7;
                                AIRecords aIRecords8;
                                AIRecordsDao aIRecordsDao;
                                AIRecords aIRecords9;
                                aIRecords7 = InterpretationRecordsDetailActivity.this.mAIRecords;
                                if (aIRecords7 != null) {
                                    aIRecords7.setMIsSync(0);
                                }
                                aIRecords8 = InterpretationRecordsDetailActivity.this.mAIRecords;
                                if (aIRecords8 != null) {
                                    aIRecords8.setMIsDelete(1);
                                }
                                aIRecordsDao = InterpretationRecordsDetailActivity.this.mRecordsDao;
                                aIRecords9 = InterpretationRecordsDetailActivity.this.mAIRecords;
                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(aIRecords9);
                                aIRecordsDao.update(aIRecords9);
                                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24609XIXIxO, null, 2, null);
                                InterpretationRecordsDetailActivity.this.finish();
                                return Boolean.TRUE;
                            }
                        });
                        xoI0Ixx0.IIXOooo();
                    }
                    return Boolean.TRUE;
                }
            });
            this.mTranslationDetailPopup = oxx;
        }
        Oxx oxx2 = this.mTranslationDetailPopup;
        if (oxx2 != null) {
            oxx2.IIXOooo();
        }
    }
}
