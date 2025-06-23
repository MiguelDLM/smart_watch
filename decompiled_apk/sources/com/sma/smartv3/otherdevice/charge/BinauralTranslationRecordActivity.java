package com.sma.smartv3.otherdevice.charge;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.io.Location;
import com.blankj.utilcode.util.ClipboardUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AISpeech;
import com.sma.smartv3.pop.Oxx;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Ref;

@kotlin.jvm.internal.XX({"SMAP\nBinauralTranslationRecordActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinauralTranslationRecordActivity.kt\ncom/sma/smartv3/otherdevice/charge/BinauralTranslationRecordActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,280:1\n1549#2:281\n1620#2,3:282\n*S KotlinDebug\n*F\n+ 1 BinauralTranslationRecordActivity.kt\ncom/sma/smartv3/otherdevice/charge/BinauralTranslationRecordActivity\n*L\n198#1:281\n198#1:282,3\n*E\n"})
/* loaded from: classes12.dex */
public final class BinauralTranslationRecordActivity extends BaseActivity {
    private boolean isPlaying;
    private MultiItemTypeAdapter<AISpeech> mAdapter;

    @OXOo.oOoXoXO
    private Oxx mTranslationDetailPopup;

    @OXOo.OOXIXo
    private final String TAG = "BinauralTranslationRecordActivity";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleCenter$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BinauralTranslationRecordActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BinauralTranslationRecordActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rv$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$rv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) BinauralTranslationRecordActivity.this.findViewById(R.id.rv);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO img_record_play$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$img_record_play$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BinauralTranslationRecordActivity.this.findViewById(R.id.img_record_play);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv_currentTime$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$tv_currentTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BinauralTranslationRecordActivity.this.findViewById(R.id.tv_currentTime);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO seekbar$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SeekBar>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$seekbar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final SeekBar invoke() {
            return (SeekBar) BinauralTranslationRecordActivity.this.findViewById(R.id.seekbar);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv_totalTime$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$tv_totalTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BinauralTranslationRecordActivity.this.findViewById(R.id.tv_totalTime);
        }
    });

    @OXOo.OOXIXo
    private ArrayList<AISpeech> aiSpeechList = new ArrayList<>();

    @OXOo.OOXIXo
    private Handler mHandler = new Handler(Looper.getMainLooper());

    @OXOo.OOXIXo
    private final kotlin.X0IIOO pcmAudioPlayer$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<oo00.XO>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$pcmAudioPlayer$2
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final oo00.XO invoke() {
            return new oo00.XO(VoiceManager.INSTANCE.getMPcmFile(), 0, 0, 0, 14, null);
        }
    });

    @OXOo.OOXIXo
    private String audioTotalTime = "";

    /* JADX INFO: Access modifiers changed from: private */
    public final oo00.XO getPcmAudioPlayer() {
        return (oo00.XO) this.pcmAudioPlayer$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(final BinauralTranslationRecordActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (!this$0.isPlaying) {
            this$0.isPlaying = true;
            this$0.getImg_record_play().setImageResource(R.drawable.ic_record_stop);
            this$0.getPcmAudioPlayer().II0XooXoX(this$0.getSeekbar().getProgress());
            this$0.getPcmAudioPlayer().xoIox();
            this$0.getPcmAudioPlayer().xxIXOIIO(new Oox.oOoXoXO<Integer, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$initView$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Integer num) {
                    invoke(num.intValue());
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(int i) {
                    String updatePlayTime;
                    oo00.XO pcmAudioPlayer;
                    String updatePlayTime2;
                    TextView tv_currentTime = BinauralTranslationRecordActivity.this.getTv_currentTime();
                    updatePlayTime = BinauralTranslationRecordActivity.this.updatePlayTime(i);
                    tv_currentTime.setText(updatePlayTime);
                    BinauralTranslationRecordActivity.this.getSeekbar().setProgress(i);
                    pcmAudioPlayer = BinauralTranslationRecordActivity.this.getPcmAudioPlayer();
                    if (pcmAudioPlayer.oxoX() == i) {
                        BinauralTranslationRecordActivity.this.isPlaying = false;
                        BinauralTranslationRecordActivity.this.getImg_record_play().setImageResource(R.drawable.ic_record_play);
                        TextView tv_currentTime2 = BinauralTranslationRecordActivity.this.getTv_currentTime();
                        updatePlayTime2 = BinauralTranslationRecordActivity.this.updatePlayTime(0);
                        tv_currentTime2.setText(updatePlayTime2);
                        BinauralTranslationRecordActivity.this.getSeekbar().setProgress(0);
                    }
                }
            });
            return;
        }
        this$0.isPlaying = false;
        this$0.getImg_record_play().setImageResource(R.drawable.ic_record_play);
        this$0.getPcmAudioPlayer().X0o0xo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String updatePlayTime(int i) {
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf((i % 3600) / 60), Integer.valueOf(i % 60)}, 2));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String updateTimerText(long j) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " updateTimerText " + j);
        long j2 = (long) 3600000;
        int i = (int) (j / j2);
        long j3 = (long) 60000;
        int i2 = (int) ((j % j2) / j3);
        long j4 = 1000;
        int i3 = (int) ((j % j3) / j4);
        int i4 = (int) ((j % j4) / 10);
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%02d:%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 4));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return format;
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

    @OXOo.OOXIXo
    public final String getAudioTotalTime() {
        return this.audioTotalTime;
    }

    public final ImageView getImg_record_play() {
        return (ImageView) this.img_record_play$delegate.getValue();
    }

    public final RecyclerView getRv() {
        return (RecyclerView) this.rv$delegate.getValue();
    }

    public final SeekBar getSeekbar() {
        return (SeekBar) this.seekbar$delegate.getValue();
    }

    public final TextView getTv_currentTime() {
        return (TextView) this.tv_currentTime$delegate.getValue();
    }

    public final TextView getTv_totalTime() {
        return (TextView) this.tv_totalTime$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        Serializable mArg3 = getMArg3();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type java.util.ArrayList<com.sma.smartv3.model.AISpeech>{ kotlin.collections.TypeAliasesKt.ArrayList<com.sma.smartv3.model.AISpeech> }");
        this.aiSpeechList = (ArrayList) mArg3;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " initView " + VoiceManager.INSTANCE.getMPcmFile().length());
        getAbhTitleCenter().setVisibility(0);
        getAbhTitleCenter().setText(getString(R.string.recording_details));
        getTv_currentTime().setText(updatePlayTime(0));
        this.audioTotalTime = updatePlayTime(getPcmAudioPlayer().oxoX());
        getTv_totalTime().setText(this.audioTotalTime);
        getSeekbar().setMax(getPcmAudioPlayer().oxoX());
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ai_answer_more_icon);
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        final ArrayList<AISpeech> arrayList = this.aiSpeechList;
        this.mAdapter = new MultiItemTypeAdapter<AISpeech>(this, arrayList) { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$initView$1

            /* loaded from: classes12.dex */
            public static final class oIX0oI implements oo.xoXoI<AISpeech> {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ BinauralTranslationRecordActivity f20970oIX0oI;

                public oIX0oI(BinauralTranslationRecordActivity binauralTranslationRecordActivity) {
                    this.f20970oIX0oI = binauralTranslationRecordActivity;
                }

                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_binaural_record;
                }

                @Override // oo.xoXoI
                /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                public boolean oIX0oI(@OXOo.oOoXoXO AISpeech aISpeech, int i) {
                    return true;
                }

                @Override // oo.xoXoI
                /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo AISpeech mAISpeech, int i) {
                    String updateTimerText;
                    String updateTimerText2;
                    int i2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(mAISpeech, "mAISpeech");
                    holder.setText(R.id.tv_original, mAISpeech.getText());
                    StringBuilder sb = new StringBuilder();
                    updateTimerText = this.f20970oIX0oI.updateTimerText(mAISpeech.getStartTime());
                    sb.append(updateTimerText);
                    sb.append(" - ");
                    updateTimerText2 = this.f20970oIX0oI.updateTimerText(mAISpeech.getEndTime());
                    sb.append(updateTimerText2);
                    holder.setText(R.id.tv_time, sb.toString());
                    TextView textView = (TextView) holder.getView(R.id.tv_translated);
                    textView.setText(mAISpeech.getDst());
                    if (mAISpeech.getDst().length() > 0) {
                        i2 = 0;
                    } else {
                        i2 = 8;
                    }
                    textView.setVisibility(i2);
                }
            }

            {
                addItemViewDelegate(0, new oIX0oI(this));
            }
        };
        getRv().setLayoutManager(new LinearLayoutManager(this, 1, false));
        RecyclerView rv = getRv();
        MultiItemTypeAdapter<AISpeech> multiItemTypeAdapter = this.mAdapter;
        if (multiItemTypeAdapter == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
            multiItemTypeAdapter = null;
        }
        rv.setAdapter(multiItemTypeAdapter);
        getImg_record_play().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.XIxXXX0x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BinauralTranslationRecordActivity.initView$lambda$0(BinauralTranslationRecordActivity.this, view);
            }
        });
        getSeekbar().setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$initView$3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(@OXOo.oOoXoXO SeekBar seekBar, int i, boolean z) {
                String updatePlayTime;
                if (z) {
                    TextView tv_currentTime = BinauralTranslationRecordActivity.this.getTv_currentTime();
                    updatePlayTime = BinauralTranslationRecordActivity.this.updatePlayTime(i);
                    tv_currentTime.setText(updatePlayTime);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(@OXOo.oOoXoXO SeekBar seekBar) {
                oo00.XO pcmAudioPlayer;
                BinauralTranslationRecordActivity.this.isPlaying = false;
                BinauralTranslationRecordActivity.this.getImg_record_play().setImageResource(R.drawable.ic_record_play);
                pcmAudioPlayer = BinauralTranslationRecordActivity.this.getPcmAudioPlayer();
                pcmAudioPlayer.X0o0xo();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(@OXOo.oOoXoXO SeekBar seekBar) {
                oo00.XO pcmAudioPlayer;
                oo00.XO pcmAudioPlayer2;
                oo00.XO pcmAudioPlayer3;
                BinauralTranslationRecordActivity.this.isPlaying = true;
                BinauralTranslationRecordActivity.this.getImg_record_play().setImageResource(R.drawable.ic_record_stop);
                pcmAudioPlayer = BinauralTranslationRecordActivity.this.getPcmAudioPlayer();
                pcmAudioPlayer.II0XooXoX(BinauralTranslationRecordActivity.this.getSeekbar().getProgress());
                pcmAudioPlayer2 = BinauralTranslationRecordActivity.this.getPcmAudioPlayer();
                pcmAudioPlayer2.xoIox();
                pcmAudioPlayer3 = BinauralTranslationRecordActivity.this.getPcmAudioPlayer();
                final BinauralTranslationRecordActivity binauralTranslationRecordActivity = BinauralTranslationRecordActivity.this;
                pcmAudioPlayer3.xxIXOIIO(new Oox.oOoXoXO<Integer, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$initView$3$onStopTrackingTouch$1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Integer num) {
                        invoke(num.intValue());
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }

                    public final void invoke(int i) {
                        String updatePlayTime;
                        oo00.XO pcmAudioPlayer4;
                        String updatePlayTime2;
                        TextView tv_currentTime = BinauralTranslationRecordActivity.this.getTv_currentTime();
                        updatePlayTime = BinauralTranslationRecordActivity.this.updatePlayTime(i);
                        tv_currentTime.setText(updatePlayTime);
                        BinauralTranslationRecordActivity.this.getSeekbar().setProgress(i);
                        pcmAudioPlayer4 = BinauralTranslationRecordActivity.this.getPcmAudioPlayer();
                        if (pcmAudioPlayer4.oxoX() == i) {
                            BinauralTranslationRecordActivity.this.isPlaying = false;
                            BinauralTranslationRecordActivity.this.getImg_record_play().setImageResource(R.drawable.ic_record_play);
                            TextView tv_currentTime2 = BinauralTranslationRecordActivity.this.getTv_currentTime();
                            updatePlayTime2 = BinauralTranslationRecordActivity.this.updatePlayTime(0);
                            tv_currentTime2.setText(updatePlayTime2);
                            BinauralTranslationRecordActivity.this.getSeekbar().setProgress(0);
                        }
                    }
                });
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_binaural_translation_record;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getPcmAudioPlayer().OOXIXo();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        showDeleteTipPopup();
    }

    public final void setAudioTotalTime(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.audioTotalTime = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v8, types: [T, java.lang.String] */
    public final void showDeleteTipPopup() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        String updateTimerText = updateTimerText(this.aiSpeechList.get(0).getStartTime());
        ArrayList<AISpeech> arrayList = this.aiSpeechList;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(arrayList, 10));
        for (AISpeech aISpeech : arrayList) {
            objectRef.element = ((String) objectRef.element) + aISpeech.getText() + '\n' + aISpeech.getDst() + '\n';
            arrayList2.add(kotlin.oXIO0o0XI.f29392oIX0oI);
        }
        if (this.mTranslationDetailPopup == null) {
            final File mPcmFile = VoiceManager.INSTANCE.getMPcmFile();
            Oxx oxx = new Oxx(getMContext());
            oxx.Io(getString(R.string.action_details) + ": " + this.audioTotalTime);
            oxx.XX(getString(R.string.file_size_title_tip) + ": " + FileUtils.getSize(mPcmFile));
            oxx.oxxXoxO(getString(R.string.number_of_words) + ": " + ((String) objectRef.element).length());
            oxx.o0(getString(R.string.create_time_tip) + ": " + updateTimerText);
            oxx.I0oOoX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$showDeleteTipPopup$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i) {
                    Activity mContext;
                    if (i == 1) {
                        ClipboardUtils.copyText(objectRef.element);
                        ToastUtils.showLong(R.string.copied);
                    } else if (i == 2) {
                        final BinauralTranslationRecordActivity binauralTranslationRecordActivity = this;
                        final Ref.ObjectRef<String> objectRef2 = objectRef;
                        xoIXOxX.II0xO0.I0Io(true, false, null, null, 0, new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$showDeleteTipPopup$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                BinauralTranslationRecordActivity.this.exportTextToFile(objectRef2.element);
                            }
                        }, 30, null);
                    } else if (i == 3) {
                        mContext = this.getMContext();
                        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(mContext, 0, 2, null);
                        final File file = mPcmFile;
                        final BinauralTranslationRecordActivity binauralTranslationRecordActivity2 = this;
                        xoI0Ixx0.IoOoX(R.string.weather_del_file);
                        xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$showDeleteTipPopup$2$1$2$1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // Oox.oIX0oI
                            @OXOo.OOXIXo
                            public final Boolean invoke() {
                                return Boolean.TRUE;
                            }
                        });
                        xoI0Ixx0.x0o(R.string.delete, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationRecordActivity$showDeleteTipPopup$2$1$2$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // Oox.oIX0oI
                            @OXOo.OOXIXo
                            public final Boolean invoke() {
                                file.delete();
                                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24609XIXIxO, null, 2, null);
                                ToastUtils.showLong(R.string.delete_success);
                                binauralTranslationRecordActivity2.finish();
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
