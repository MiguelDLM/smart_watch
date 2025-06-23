package com.sma.smartv3.otherdevice.charge;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.biz.AISparkChainManager;
import com.sma.smartv3.biz.voice.RecordingManager;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AISpeech;
import com.sma.smartv3.model.LanguageTranslationData;
import com.sma.smartv3.model.LeftAndRightPlayControl;
import com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity;
import com.sma.smartv3.pop.xOOxIO;
import com.sma.smartv3.util.MicrosoftSDKManage;
import com.sma.smartv3.view.WaveformView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nNewSimultaneousInterpretationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewSimultaneousInterpretationActivity.kt\ncom/sma/smartv3/otherdevice/charge/NewSimultaneousInterpretationActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,638:1\n87#2,7:639\n94#2,3:647\n70#2,7:650\n97#2:657\n173#2,7:662\n180#2,3:670\n143#2,7:673\n183#2:680\n173#2,7:681\n180#2,3:689\n143#2,7:692\n183#2:699\n1#3:646\n1#3:669\n1#3:688\n86#4,2:658\n86#4,2:660\n86#4,2:700\n86#4,2:702\n*S KotlinDebug\n*F\n+ 1 NewSimultaneousInterpretationActivity.kt\ncom/sma/smartv3/otherdevice/charge/NewSimultaneousInterpretationActivity\n*L\n404#1:639,7\n404#1:647,3\n404#1:650,7\n404#1:657\n573#1:662,7\n573#1:670,3\n573#1:673,7\n573#1:680\n578#1:681,7\n578#1:689,3\n578#1:692,7\n578#1:699\n404#1:646\n573#1:669\n578#1:688\n434#1:658,2\n435#1:660,2\n592#1:700,2\n606#1:702,2\n*E\n"})
/* loaded from: classes12.dex */
public final class NewSimultaneousInterpretationActivity extends BaseTranslationActivity {

    @OXOo.OOXIXo
    private final MicrosoftSDKManage.I0Io binauralMicrosoftCallBack;
    private MultiItemTypeAdapter<AISpeech> mAdapter;

    @OXOo.oOoXoXO
    private AnimationDrawable mAnimationDrawable;
    private int mVoiceType;

    @OXOo.oOoXoXO
    private xOOxIO popTip;

    @OXOo.OOXIXo
    private final String TAG = "BinauralTranslationActivity";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return NewSimultaneousInterpretationActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv_time$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$tv_time$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) NewSimultaneousInterpretationActivity.this.findViewById(R.id.tv_time);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO img_recording_status$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$img_recording_status$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) NewSimultaneousInterpretationActivity.this.findViewById(R.id.img_recording_status);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO img_play$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$img_play$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) NewSimultaneousInterpretationActivity.this.findViewById(R.id.img_play);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO record_line$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WaveformView>() { // from class: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$record_line$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final WaveformView invoke() {
            return (WaveformView) NewSimultaneousInterpretationActivity.this.findViewById(R.id.record_line);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO img_broadcast$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$img_broadcast$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) NewSimultaneousInterpretationActivity.this.findViewById(R.id.img_broadcast);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO img_direction$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$img_direction$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) NewSimultaneousInterpretationActivity.this.findViewById(R.id.img_direction);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rv$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$rv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) NewSimultaneousInterpretationActivity.this.findViewById(R.id.rv);
        }
    });

    @OXOo.OOXIXo
    private ArrayList<AISpeech> aiSpeechList = new ArrayList<>();
    private boolean isCanBroadCast = true;

    @kotlin.jvm.internal.XX({"SMAP\nNewSimultaneousInterpretationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewSimultaneousInterpretationActivity.kt\ncom/sma/smartv3/otherdevice/charge/NewSimultaneousInterpretationActivity$binauralMicrosoftCallBack$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,638:1\n1549#2:639\n1620#2,3:640\n766#2:643\n857#2,2:644\n1549#2:646\n1620#2,3:647\n766#2:650\n857#2,2:651\n*S KotlinDebug\n*F\n+ 1 NewSimultaneousInterpretationActivity.kt\ncom/sma/smartv3/otherdevice/charge/NewSimultaneousInterpretationActivity$binauralMicrosoftCallBack$1\n*L\n114#1:639\n114#1:640,3\n115#1:643\n115#1:644,2\n164#1:646\n164#1:647,3\n165#1:650\n165#1:651,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI implements MicrosoftSDKManage.I0Io {
        public oIX0oI() {
        }

        public static final void II0xO0(NewSimultaneousInterpretationActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            if (this$0.aiSpeechList.size() > 0) {
                this$0.getRv().smoothScrollToPosition(this$0.aiSpeechList.size() - 1);
            }
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onIdentifyResults(int i, @OXOo.OOXIXo String str) {
            boolean z;
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "str");
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            oix0oi.oIX0oI(NewSimultaneousInterpretationActivity.this.TAG + "  sendTranslate  onIdentifyResults status = " + i + " content = " + str + TokenParser.SP);
            int i2 = 0;
            if (i != 1) {
                if (i == 2) {
                    oix0oi.oIX0oI(NewSimultaneousInterpretationActivity.this.TAG + "  sendTranslate  onIdentifyResults content = " + str);
                    List<String> split = new Regex("[*]+").split(str, 0);
                    ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(split, 10));
                    Iterator<T> it = split.iterator();
                    while (it.hasNext()) {
                        arrayList.add(StringsKt__StringsKt.oIoIXxIO((String) it.next()).toString());
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : arrayList) {
                        if (((String) obj).length() > 0) {
                            arrayList2.add(obj);
                        }
                    }
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(NewSimultaneousInterpretationActivity.this.TAG + "  sendTranslate  onIdentifyResults parts = " + arrayList2);
                    int size = arrayList2.size();
                    int i3 = 0;
                    while (i3 < size) {
                        int i4 = i3 + 1;
                        if (NewSimultaneousInterpretationActivity.this.aiSpeechList.size() < i4) {
                            AISpeech aISpeech = new AISpeech((String) arrayList2.get(i3), null, 2, 0, null, null, null, 0L, 0L, 506, null);
                            aISpeech.setLanguageModel(0);
                            aISpeech.setLang(NewSimultaneousInterpretationActivity.this.getMLeftLanguage().getRtasrLanguage());
                            aISpeech.setTargetLang(NewSimultaneousInterpretationActivity.this.getMLeftLanguage().getRtasrLanguage());
                            aISpeech.setTtsVoiceName(NewSimultaneousInterpretationActivity.this.getMLeftLanguage().getTtsViuceName());
                            NewSimultaneousInterpretationActivity.this.aiSpeechList.add(aISpeech);
                            if (i3 > 0) {
                                ((AISpeech) NewSimultaneousInterpretationActivity.this.aiSpeechList.get(i3)).setStartTime(((AISpeech) NewSimultaneousInterpretationActivity.this.aiSpeechList.get(i3 - 1)).getEndTime());
                            } else {
                                aISpeech.setStartTime(0L);
                            }
                            ((AISpeech) NewSimultaneousInterpretationActivity.this.aiSpeechList.get(i3)).setEndTime(System.currentTimeMillis() - NewSimultaneousInterpretationActivity.this.getStartTime());
                            NewSimultaneousInterpretationActivity newSimultaneousInterpretationActivity = NewSimultaneousInterpretationActivity.this;
                            newSimultaneousInterpretationActivity.binauralSendTranslationResultInput((AISpeech) newSimultaneousInterpretationActivity.aiSpeechList.get(i3), i3);
                        }
                        if (NewSimultaneousInterpretationActivity.this.aiSpeechList.size() == i4 && ((AISpeech) NewSimultaneousInterpretationActivity.this.aiSpeechList.get(i3)).getStatus() == 1) {
                            OI0.oIX0oI oix0oi2 = OI0.oIX0oI.f1507oIX0oI;
                            StringBuilder sb = new StringBuilder();
                            sb.append(NewSimultaneousInterpretationActivity.this.TAG);
                            sb.append("  sendTranslate  onIdentifyResults istrue = ");
                            if (NewSimultaneousInterpretationActivity.this.aiSpeechList.size() == i4 && ((AISpeech) NewSimultaneousInterpretationActivity.this.aiSpeechList.get(i3)).getStatus() == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            sb.append(z);
                            oix0oi2.oIX0oI(sb.toString());
                            Object obj2 = NewSimultaneousInterpretationActivity.this.aiSpeechList.get(i3);
                            kotlin.jvm.internal.IIX0o.oO(obj2, "get(...)");
                            AISpeech aISpeech2 = (AISpeech) obj2;
                            aISpeech2.setText((String) arrayList2.get(i3));
                            aISpeech2.setStatus(2);
                            aISpeech2.setLanguageModel(0);
                            aISpeech2.setLang(NewSimultaneousInterpretationActivity.this.getMLeftLanguage().getRtasrLanguage());
                            aISpeech2.setTargetLang(NewSimultaneousInterpretationActivity.this.getMLeftLanguage().getRtasrLanguage());
                            aISpeech2.setTtsVoiceName(NewSimultaneousInterpretationActivity.this.getMLeftLanguage().getTtsViuceName());
                            if (i3 > 0) {
                                ((AISpeech) NewSimultaneousInterpretationActivity.this.aiSpeechList.get(i3)).setStartTime(((AISpeech) NewSimultaneousInterpretationActivity.this.aiSpeechList.get(i3 - 1)).getEndTime());
                            } else {
                                aISpeech2.setStartTime(0L);
                            }
                            ((AISpeech) NewSimultaneousInterpretationActivity.this.aiSpeechList.get(i3)).setEndTime(System.currentTimeMillis() - NewSimultaneousInterpretationActivity.this.getStartTime());
                            oix0oi2.oIX0oI(NewSimultaneousInterpretationActivity.this.TAG + "  sendTranslate  onIdentifyResults aiSpeechList " + NewSimultaneousInterpretationActivity.this.aiSpeechList);
                            NewSimultaneousInterpretationActivity newSimultaneousInterpretationActivity2 = NewSimultaneousInterpretationActivity.this;
                            newSimultaneousInterpretationActivity2.binauralSendTranslationResultInput((AISpeech) newSimultaneousInterpretationActivity2.aiSpeechList.get(i3), i3);
                        }
                        i3 = i4;
                    }
                }
            } else {
                oix0oi.oIX0oI(NewSimultaneousInterpretationActivity.this.TAG + "  sendTranslate  onIdentifyResults content = " + str);
                List<String> split2 = new Regex("[*]+").split(str, 0);
                ArrayList arrayList3 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(split2, 10));
                Iterator<T> it2 = split2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(StringsKt__StringsKt.oIoIXxIO((String) it2.next()).toString());
                }
                ArrayList arrayList4 = new ArrayList();
                for (Object obj3 : arrayList3) {
                    if (((String) obj3).length() > 0) {
                        arrayList4.add(obj3);
                    }
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(NewSimultaneousInterpretationActivity.this.TAG + "  sendTranslate  onIdentifyResults parts = " + arrayList4);
                int size2 = arrayList4.size();
                while (i2 < size2) {
                    int i5 = i2 + 1;
                    if (NewSimultaneousInterpretationActivity.this.aiSpeechList.size() < i5) {
                        NewSimultaneousInterpretationActivity.this.aiSpeechList.add(new AISpeech((String) arrayList4.get(i2), null, 1, 0, null, null, null, 0L, 0L, 506, null));
                    }
                    if (NewSimultaneousInterpretationActivity.this.aiSpeechList.size() == i5) {
                        ((AISpeech) NewSimultaneousInterpretationActivity.this.aiSpeechList.get(i2)).setText((String) arrayList4.get(i2));
                    }
                    i2 = i5;
                }
            }
            MultiItemTypeAdapter multiItemTypeAdapter = NewSimultaneousInterpretationActivity.this.mAdapter;
            if (multiItemTypeAdapter == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                multiItemTypeAdapter = null;
            }
            multiItemTypeAdapter.notifyDataSetChanged();
            Handler mHandler = NewSimultaneousInterpretationActivity.this.getMHandler();
            final NewSimultaneousInterpretationActivity newSimultaneousInterpretationActivity3 = NewSimultaneousInterpretationActivity.this;
            mHandler.postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.IIxOXoOo0
                @Override // java.lang.Runnable
                public final void run() {
                    NewSimultaneousInterpretationActivity.oIX0oI.II0xO0(NewSimultaneousInterpretationActivity.this);
                }
            }, 50L);
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onIdentifyResultsDetectedLanguage(int i, @OXOo.OOXIXo String str, @OXOo.OOXIXo String detectedLanguage) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "str");
            kotlin.jvm.internal.IIX0o.x0xO0oo(detectedLanguage, "detectedLanguage");
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onStartTransmission() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(NewSimultaneousInterpretationActivity.this.TAG + " onStartTransmission ");
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onStopTransmission() {
        }
    }

    public NewSimultaneousInterpretationActivity() {
        setMAIRecordsType(1);
        this.binauralMicrosoftCallBack = new oIX0oI();
        this.mVoiceType = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void binauralSendTranslationResultInput(AISpeech aISpeech, int i) {
        String text;
        setStartAnalysis(false);
        setMRecyclerViewAutoRefresh(true);
        if (aISpeech != null && (text = aISpeech.getText()) != null && text.length() > 0 && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(aISpeech.getText(), getString(R.string.request_error))) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " binauralSendTranslationResultInput ===> str = " + aISpeech.getText() + " , targetLang = " + getTargetLang());
            MicrosoftSDKManage.II0xO0 iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
            iI0xO0.oIX0oI().xoIxX();
            iI0xO0.oIX0oI().oXxOI0oIx(aISpeech.getText(), aISpeech.getTargetLang(), new NewSimultaneousInterpretationActivity$binauralSendTranslationResultInput$1(aISpeech, this));
        }
    }

    private final void clickDownRecording() {
        if (PermissionUtils.isGranted(PermissionConstants.MICROPHONE)) {
            startRecordingBinaural();
        } else {
            permission();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endVoice$lambda$10(NewSimultaneousInterpretationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        ToastUtils.showShort(this$0.getString(R.string.not_record_data), new Object[0]);
    }

    private final ImageView getImg_broadcast() {
        return (ImageView) this.img_broadcast$delegate.getValue();
    }

    private final ImageView getImg_direction() {
        return (ImageView) this.img_direction$delegate.getValue();
    }

    private final ImageView getImg_play() {
        return (ImageView) this.img_play$delegate.getValue();
    }

    private final ImageView getImg_recording_status() {
        return (ImageView) this.img_recording_status$delegate.getValue();
    }

    private final WaveformView getRecord_line() {
        return (WaveformView) this.record_line$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView getRv() {
        return (RecyclerView) this.rv$delegate.getValue();
    }

    private final TextView getTv_time() {
        return (TextView) this.tv_time$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecord$lambda$8(NewSimultaneousInterpretationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (RecordingManager.Companion.getInstance().isRecording()) {
            this$0.endVoice();
        } else {
            this$0.startVoice();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(NewSimultaneousInterpretationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startRotateAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(NewSimultaneousInterpretationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.popTip == null) {
            xOOxIO xooxio = new xOOxIO(this$0);
            xooxio.ooXIXxIX(this$0.getString(R.string.simultaneous_tip_1));
            xooxio.xI(this$0.getString(R.string.simultaneous_tip_2));
            xooxio.IIX0o(Integer.valueOf(R.drawable.ic_simultan_tip));
            xooxio.oo0xXOI0I(Boolean.valueOf(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24420XO0o, false)));
            xooxio.xXxxox0I().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.otherdevice.charge.XX0xXo
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    NewSimultaneousInterpretationActivity.initView$lambda$3$lambda$2$lambda$1(compoundButton, z);
                }
            });
            this$0.popTip = xooxio;
        }
        xOOxIO xooxio2 = this$0.popTip;
        if (xooxio2 != null) {
            View rootView = this$0.getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xooxio2.xoXoI(rootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2$lambda$1(CompoundButton compoundButton, boolean z) {
        LogUtils.d("isChecked = " + z);
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24420XO0o, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(NewSimultaneousInterpretationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.popTip == null) {
            xOOxIO xooxio = new xOOxIO(this$0);
            xooxio.ooXIXxIX(this$0.getString(R.string.simultaneous_tip_1));
            xooxio.xI(this$0.getString(R.string.simultaneous_tip_2));
            xooxio.IIX0o(Integer.valueOf(R.drawable.ic_simultan_tip));
            xooxio.oo0xXOI0I(Boolean.valueOf(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24420XO0o, false)));
            xooxio.xXxxox0I().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.otherdevice.charge.Ioxxx
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    NewSimultaneousInterpretationActivity.initView$lambda$6$lambda$5$lambda$4(compoundButton, z);
                }
            });
            this$0.popTip = xooxio;
        }
        xOOxIO xooxio2 = this$0.popTip;
        if (xooxio2 != null) {
            View rootView = this$0.getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xooxio2.xoXoI(rootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6$lambda$5$lambda$4(CompoundButton compoundButton, boolean z) {
        LogUtils.d("isChecked = " + z);
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24420XO0o, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(NewSimultaneousInterpretationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.isCanBroadCast) {
            this$0.getImg_broadcast().setImageResource(R.drawable.ic_simultan_broadcast_close);
        } else {
            this$0.getImg_broadcast().setImageResource(R.drawable.ic_simultan_broadcast_open);
        }
        this$0.isCanBroadCast = !this$0.isCanBroadCast;
    }

    private final void preConnect() {
        MicrosoftSDKManage.xI0oxI00(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI(), getArsLanguage(), true, getTtsVoiceName(), getTtsTargetLang(), false, null, CollectionsKt__CollectionsKt.XOxIOxOx(getMLeftLanguage().getAsrLanguage(), getMRightLanguage().getAsrLanguage()), false, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startRecordingBinaural() {
        if (ProductManager.f20544oIX0oI.XI0IXoo()) {
            MicrosoftSDKManage.II0xO0 iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
            MicrosoftSDKManage.IIX0(iI0xO0.oIX0oI(), this.binauralMicrosoftCallBack, null, 2, null);
            iI0xO0.oIX0oI().IoIOOxIIo(false);
        }
        View rootView = getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        showCountdownPopup(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startRotateAnimation$lambda$11(RotateAnimation rotateAnimation, NewSimultaneousInterpretationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(rotateAnimation, "$rotateAnimation");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        rotateAnimation.cancel();
        this$0.getMTransformLanguageImg().clearAnimation();
        this$0.setSwitchRotateAnimation(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVoice$lambda$9(NewSimultaneousInterpretationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.aiSpeechList.clear();
        kotlin.collections.OxI.xOoOIoI(this$0.aiSpeechList, new Oox.oOoXoXO<AISpeech, Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$startVoice$1$1
            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo AISpeech it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                return Boolean.TRUE;
            }
        });
        MultiItemTypeAdapter<AISpeech> multiItemTypeAdapter = this$0.mAdapter;
        if (multiItemTypeAdapter == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
            multiItemTypeAdapter = null;
        }
        multiItemTypeAdapter.notifyDataSetChanged();
    }

    public final void addVoiceListener() {
        VoiceManager.INSTANCE.setMListener(new Oox.IXxxXO<Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$addVoiceListener$1
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3) {
                return invoke(num.intValue(), num2.intValue(), num3.intValue());
            }

            @OXOo.OOXIXo
            public final Boolean invoke(int i, int i2, int i3) {
                if (i2 != 0) {
                    if (i2 != 2) {
                        if (i2 == 3 && NewSimultaneousInterpretationActivity.this.getMVoiceType() == 0) {
                            NewSimultaneousInterpretationActivity.this.setMVoiceType(i2);
                            NewSimultaneousInterpretationActivity.this.endVoice();
                            MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().X0xxXX0();
                        }
                    } else if (NewSimultaneousInterpretationActivity.this.getMVoiceType() == 0) {
                        NewSimultaneousInterpretationActivity.this.setMVoiceType(i2);
                        NewSimultaneousInterpretationActivity.this.endVoice();
                    }
                } else if (NewSimultaneousInterpretationActivity.this.getMVoiceType() != 0) {
                    NewSimultaneousInterpretationActivity.this.setMVoiceType(i2);
                    VoiceManager.INSTANCE.setLanguageType(NewSimultaneousInterpretationActivity.this.getArsLanguage(), NewSimultaneousInterpretationActivity.this.getTtsVoiceName());
                    NewSimultaneousInterpretationActivity.this.startVoice();
                }
                return Boolean.TRUE;
            }
        });
    }

    public final void binauralStopRecording() {
        if (ProductManager.f20544oIX0oI.XI0IXoo()) {
            closeBluetooth();
            MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().x0OxxIOxX();
        } else {
            RecordingManager.Companion.getInstance().stopRecording();
        }
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void countdownEnd() {
        super.countdownEnd();
        setStartTime(System.currentTimeMillis());
        getImg_recording_status().setVisibility(0);
        getRecord_line().setVisibility(8);
        if (this.mAnimationDrawable == null) {
            Drawable drawable = getResources().getDrawable(R.drawable.audio_play_animation_list);
            kotlin.jvm.internal.IIX0o.x0XOIxOo(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            this.mAnimationDrawable = (AnimationDrawable) drawable;
        }
        getImg_recording_status().setImageDrawable(this.mAnimationDrawable);
        AnimationDrawable animationDrawable = this.mAnimationDrawable;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        setElapsedTime(0L);
        getMHandler().postDelayed(getRunnable(), getUpdateInterval());
    }

    public final void endVoice() {
        RecordingManager.Companion.getInstance().setRecording(false);
        getImg_play().setImageResource(R.drawable.ic_binaural_start);
        getImg_recording_status().setVisibility(4);
        getRecord_line().setVisibility(8);
        binauralStopRecording();
        getMHandler().removeCallbacks(getRunnable());
        removeCountdownPopup();
        setElapsedTime(0L);
        updateTimerText();
        finish();
        if (this.aiSpeechList.size() > 0) {
            ArrayList<AISpeech> arrayList = this.aiSpeechList;
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", null);
            bundle.putParcelable("mArg2", null);
            bundle.putSerializable("mArg3", arrayList);
            Intent intent = new Intent(this, (Class<?>) BinauralTranslationRecordActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            getMHandler().postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.x0xO
                @Override // java.lang.Runnable
                public final void run() {
                    NewSimultaneousInterpretationActivity.endVoice$lambda$10(NewSimultaneousInterpretationActivity.this);
                }
            }, 500L);
        }
        AnimationDrawable animationDrawable = this.mAnimationDrawable;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    @OXOo.OOXIXo
    public final MicrosoftSDKManage.I0Io getBinauralMicrosoftCallBack() {
        return this.binauralMicrosoftCallBack;
    }

    @OXOo.oOoXoXO
    public final AnimationDrawable getMAnimationDrawable() {
        return this.mAnimationDrawable;
    }

    public final int getMVoiceType() {
        return this.mVoiceType;
    }

    @OXOo.oOoXoXO
    public final xOOxIO getPopTip() {
        return this.popTip;
    }

    public final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    public final void initRecord() {
        getImg_play().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.xxIO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewSimultaneousInterpretationActivity.initRecord$lambda$8(NewSimultaneousInterpretationActivity.this, view);
            }
        });
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        setLangAndVoice();
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XI0IXoo()) {
            preConnect();
        }
        getImg_direction().setVisibility(0);
        getMTransformLanguageImg().setVisibility(8);
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        xo0.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24483xX, true);
        final ArrayList<AISpeech> arrayList = this.aiSpeechList;
        this.mAdapter = new MultiItemTypeAdapter<AISpeech>(this, arrayList) { // from class: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$initView$1

            /* loaded from: classes12.dex */
            public static final class II0xO0 implements oo.xoXoI<AISpeech> {
                /* JADX INFO: Access modifiers changed from: private */
                public static final void XO(AISpeech mAISpeech, View view) {
                    LeftAndRightPlayControl leftAndRightPlayControl;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(mAISpeech, "$mAISpeech");
                    MicrosoftSDKManage oIX0oI2 = MicrosoftSDKManage.f24259Xx000oIo.oIX0oI();
                    String dst = mAISpeech.getDst();
                    String ttsVoiceName = mAISpeech.getTtsVoiceName();
                    if (mAISpeech.getLanguageModel() == 0) {
                        leftAndRightPlayControl = LeftAndRightPlayControl.RIGHT;
                    } else {
                        leftAndRightPlayControl = LeftAndRightPlayControl.LEFT;
                    }
                    MicrosoftSDKManage.IoOoX(oIX0oI2, dst, ttsVoiceName, leftAndRightPlayControl, 0, 8, null);
                }

                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_binaural_right;
                }

                @Override // oo.xoXoI
                /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
                public boolean oIX0oI(@OXOo.oOoXoXO AISpeech aISpeech, int i) {
                    if (aISpeech == null || aISpeech.getLanguageModel() != 1) {
                        return false;
                    }
                    return true;
                }

                @Override // oo.xoXoI
                /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo final AISpeech mAISpeech, int i) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(mAISpeech, "mAISpeech");
                    TextView textView = (TextView) holder.getView(R.id.tv_original);
                    TextView textView2 = (TextView) holder.getView(R.id.tv_translated);
                    textView.setText(mAISpeech.getText());
                    textView2.setText(mAISpeech.getDst());
                    if (mAISpeech.getDst().length() > 0) {
                        holder.setVisible(R.id.iv_play, true);
                    } else {
                        holder.setVisible(R.id.iv_play, false);
                    }
                    holder.setOnClickListener(R.id.iv_play, 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0045: INVOKE 
                          (r3v0 'holder' com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder)
                          (wrap:int:SGET  A[WRAPPED] com.sma.smartv3.co_fit.R.id.iv_play int)
                          (wrap:android.view.View$OnClickListener:0x0042: CONSTRUCTOR (r4v0 'mAISpeech' com.sma.smartv3.model.AISpeech A[DONT_INLINE]) A[MD:(com.sma.smartv3.model.AISpeech):void (m), WRAPPED] (LINE:67) call: com.sma.smartv3.otherdevice.charge.OX00O0xII.<init>(com.sma.smartv3.model.AISpeech):void type: CONSTRUCTOR)
                         VIRTUAL call: com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder.setOnClickListener(int, android.view.View$OnClickListener):com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder A[MD:(int, android.view.View$OnClickListener):com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder (m)] (LINE:70) in method: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$initView$1.II0xO0.X0o0xo(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.AISpeech, int):void, file: classes12.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.otherdevice.charge.OX00O0xII, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        java.lang.String r5 = "holder"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r5)
                        java.lang.String r5 = "mAISpeech"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r5)
                        r5 = 2131368401(0x7f0a19d1, float:1.835675E38)
                        android.view.View r5 = r3.getView(r5)
                        android.widget.TextView r5 = (android.widget.TextView) r5
                        r0 = 2131371607(0x7f0a2657, float:1.8363254E38)
                        android.view.View r0 = r3.getView(r0)
                        android.widget.TextView r0 = (android.widget.TextView) r0
                        java.lang.String r1 = r4.getText()
                        r5.setText(r1)
                        java.lang.String r5 = r4.getDst()
                        r0.setText(r5)
                        java.lang.String r5 = r4.getDst()
                        int r5 = r5.length()
                        r0 = 2131365043(0x7f0a0cb3, float:1.834994E38)
                        if (r5 <= 0) goto L3c
                        r5 = 1
                        r3.setVisible(r0, r5)
                        goto L40
                    L3c:
                        r5 = 0
                        r3.setVisible(r0, r5)
                    L40:
                        com.sma.smartv3.otherdevice.charge.OX00O0xII r5 = new com.sma.smartv3.otherdevice.charge.OX00O0xII
                        r5.<init>(r4)
                        r3.setOnClickListener(r0, r5)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$initView$1.II0xO0.I0Io(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.AISpeech, int):void");
                }
            }

            /* loaded from: classes12.dex */
            public static final class oIX0oI implements oo.xoXoI<AISpeech> {
                /* JADX INFO: Access modifiers changed from: private */
                public static final void XO(AISpeech mAISpeech, View view) {
                    LeftAndRightPlayControl leftAndRightPlayControl;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(mAISpeech, "$mAISpeech");
                    MicrosoftSDKManage oIX0oI2 = MicrosoftSDKManage.f24259Xx000oIo.oIX0oI();
                    String dst = mAISpeech.getDst();
                    String ttsVoiceName = mAISpeech.getTtsVoiceName();
                    if (mAISpeech.getLanguageModel() == 0) {
                        leftAndRightPlayControl = LeftAndRightPlayControl.RIGHT;
                    } else {
                        leftAndRightPlayControl = LeftAndRightPlayControl.LEFT;
                    }
                    MicrosoftSDKManage.IoOoX(oIX0oI2, dst, ttsVoiceName, leftAndRightPlayControl, 0, 8, null);
                }

                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_binaural_left;
                }

                @Override // oo.xoXoI
                /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
                public boolean oIX0oI(@OXOo.oOoXoXO AISpeech aISpeech, int i) {
                    if (aISpeech == null || aISpeech.getLanguageModel() != 0) {
                        return false;
                    }
                    return true;
                }

                @Override // oo.xoXoI
                /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo final AISpeech mAISpeech, int i) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(mAISpeech, "mAISpeech");
                    TextView textView = (TextView) holder.getView(R.id.tv_original);
                    TextView textView2 = (TextView) holder.getView(R.id.tv_translated);
                    textView.setText(mAISpeech.getText());
                    textView2.setText(mAISpeech.getDst());
                    if (mAISpeech.getDst().length() > 0) {
                        holder.setVisible(R.id.iv_play, true);
                    } else {
                        holder.setVisible(R.id.iv_play, false);
                    }
                    holder.setOnClickListener(R.id.iv_play, 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0045: INVOKE 
                          (r3v0 'holder' com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder)
                          (wrap:int:SGET  A[WRAPPED] com.sma.smartv3.co_fit.R.id.iv_play int)
                          (wrap:android.view.View$OnClickListener:0x0042: CONSTRUCTOR (r4v0 'mAISpeech' com.sma.smartv3.model.AISpeech A[DONT_INLINE]) A[MD:(com.sma.smartv3.model.AISpeech):void (m), WRAPPED] (LINE:67) call: com.sma.smartv3.otherdevice.charge.xoO0xx0.<init>(com.sma.smartv3.model.AISpeech):void type: CONSTRUCTOR)
                         VIRTUAL call: com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder.setOnClickListener(int, android.view.View$OnClickListener):com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder A[MD:(int, android.view.View$OnClickListener):com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder (m)] (LINE:70) in method: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$initView$1.oIX0oI.X0o0xo(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.AISpeech, int):void, file: classes12.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.otherdevice.charge.xoO0xx0, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        java.lang.String r5 = "holder"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r5)
                        java.lang.String r5 = "mAISpeech"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r5)
                        r5 = 2131368401(0x7f0a19d1, float:1.835675E38)
                        android.view.View r5 = r3.getView(r5)
                        android.widget.TextView r5 = (android.widget.TextView) r5
                        r0 = 2131371607(0x7f0a2657, float:1.8363254E38)
                        android.view.View r0 = r3.getView(r0)
                        android.widget.TextView r0 = (android.widget.TextView) r0
                        java.lang.String r1 = r4.getText()
                        r5.setText(r1)
                        java.lang.String r5 = r4.getDst()
                        r0.setText(r5)
                        java.lang.String r5 = r4.getDst()
                        int r5 = r5.length()
                        r0 = 2131365043(0x7f0a0cb3, float:1.834994E38)
                        if (r5 <= 0) goto L3c
                        r5 = 1
                        r3.setVisible(r0, r5)
                        goto L40
                    L3c:
                        r5 = 0
                        r3.setVisible(r0, r5)
                    L40:
                        com.sma.smartv3.otherdevice.charge.xoO0xx0 r5 = new com.sma.smartv3.otherdevice.charge.xoO0xx0
                        r5.<init>(r4)
                        r3.setOnClickListener(r0, r5)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$initView$1.oIX0oI.I0Io(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.AISpeech, int):void");
                }
            }

            {
                addItemViewDelegate(0, new oIX0oI());
                addItemViewDelegate(1, new II0xO0());
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
        getMTransformLanguageImg().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.o0xxxXXxX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewSimultaneousInterpretationActivity.initView$lambda$0(NewSimultaneousInterpretationActivity.this, view);
            }
        });
        getMTransformLanguageLeftTv().setText(getMLeftLanguage().getName());
        getMTransformLanguageRightTv().setText(getMRightLanguage().getName());
        VoiceManager.INSTANCE.setActivityData(true);
        if (productManager.XI0IXoo()) {
            MicrosoftSDKManage.IIX0(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI(), this.binauralMicrosoftCallBack, null, 2, null);
        }
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.O00XxXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewSimultaneousInterpretationActivity.initView$lambda$3(NewSimultaneousInterpretationActivity.this, view);
            }
        });
        getAbhTitleCenter().setVisibility(8);
        if (!xo0.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24420XO0o, false)) {
            getRootView().post(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.XI0oooXX
                @Override // java.lang.Runnable
                public final void run() {
                    NewSimultaneousInterpretationActivity.initView$lambda$6(NewSimultaneousInterpretationActivity.this);
                }
            });
        }
        ImageView img_broadcast = getImg_broadcast();
        if (this.isCanBroadCast) {
            i = R.drawable.ic_simultan_broadcast_open;
        } else {
            i = R.drawable.ic_simultan_broadcast_close;
        }
        img_broadcast.setImageResource(i);
        getImg_broadcast().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.OOXIxO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewSimultaneousInterpretationActivity.initView$lambda$7(NewSimultaneousInterpretationActivity.this, view);
            }
        });
        initRecord();
        if (ProductManager.xOOxIO(productManager, null, 1, null)) {
            addVoiceListener();
        }
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_new_simultaneous_interpretation;
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        Serializable serializable;
        Serializable serializable2;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i != 0) {
                if (i == 1) {
                    if (intent != null) {
                        serializable2 = intent.getSerializableExtra("language");
                    } else {
                        serializable2 = null;
                    }
                    kotlin.jvm.internal.IIX0o.x0XOIxOo(serializable2, "null cannot be cast to non-null type com.sma.smartv3.model.LanguageTranslationData");
                    LanguageTranslationData languageTranslationData = (LanguageTranslationData) serializable2;
                    if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(getMLeftLanguage().getName(), languageTranslationData.getName())) {
                        setMRightLanguage(languageTranslationData);
                        getMTransformLanguageRightTv().setText(getMRightLanguage().getName());
                        com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24442oIIxXoo + '_' + LanguageTranslationData.class.getName(), new Gson().toJson(getMRightLanguage()));
                        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24627oI, null, 2, null);
                        return;
                    }
                    setSwitchRotateAnimation(true);
                    startRotateAnimation();
                    return;
                }
                return;
            }
            if (intent != null) {
                serializable = intent.getSerializableExtra("language");
            } else {
                serializable = null;
            }
            kotlin.jvm.internal.IIX0o.x0XOIxOo(serializable, "null cannot be cast to non-null type com.sma.smartv3.model.LanguageTranslationData");
            LanguageTranslationData languageTranslationData2 = (LanguageTranslationData) serializable;
            if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(languageTranslationData2.getName(), getMRightLanguage().getName())) {
                setMLeftLanguage(languageTranslationData2);
                getMTransformLanguageLeftTv().setText(getMLeftLanguage().getName());
                com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24365IOoo + '_' + LanguageTranslationData.class.getName(), new Gson().toJson(getMLeftLanguage()));
                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24627oI, null, 2, null);
                return;
            }
            setSwitchRotateAnimation(true);
            startRotateAnimation();
        }
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity, com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        RecordingManager.Companion.getInstance().setRecording(false);
        BaseTranslationActivity.stopRecording$default(this, false, 1, null);
        getMHandler().removeCallbacks(getRunnable());
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24483xX, false);
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24627oI)
    public final void onLanguageChange(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " onLanguageChange event = " + data);
        setLangAndVoice();
        if (ProductManager.f20544oIX0oI.XI0IXoo()) {
            preConnect();
        }
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void onTranslationLanguage(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (RecordingManager.Companion.getInstance().isRecording()) {
            ToastUtils.showLong(getString(R.string.recording_tip), new Object[0]);
            return;
        }
        switch (view.getId()) {
            case R.id.dialogue_translation_left_tv /* 2131364027 */:
                LanguageTranslationData mLeftLanguage = getMLeftLanguage();
                Bundle bundle = new Bundle();
                bundle.putString("mArg0", null);
                bundle.putParcelable("mArg2", null);
                bundle.putSerializable("mArg3", mLeftLanguage);
                Intent intent = new Intent(this, (Class<?>) ChooseLanguageActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
                return;
            case R.id.dialogue_translation_right_tv /* 2131364028 */:
                LanguageTranslationData mRightLanguage = getMRightLanguage();
                Bundle bundle2 = new Bundle();
                bundle2.putString("mArg0", null);
                bundle2.putParcelable("mArg2", null);
                bundle2.putSerializable("mArg3", mRightLanguage);
                Intent intent2 = new Intent(this, (Class<?>) ChooseLanguageActivity.class);
                intent2.putExtras(bundle2);
                startActivityForResult(intent2, 1);
                return;
            default:
                return;
        }
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void permission() {
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.MICROPHONE);
        kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
        String string = getString(R.string.microphone_explain_title);
        kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
        String string2 = getString(R.string.microphone_explain_content);
        kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
        oOXoIIIo.X0o0xo.II0xO0(permission, string, string2, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.NewSimultaneousInterpretationActivity$permission$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                if (it == PermissionStatus.GRANTED) {
                    NewSimultaneousInterpretationActivity.this.startRecordingBinaural();
                }
            }
        });
    }

    public final void setMAnimationDrawable(@OXOo.oOoXoXO AnimationDrawable animationDrawable) {
        this.mAnimationDrawable = animationDrawable;
    }

    public final void setMVoiceType(int i) {
        this.mVoiceType = i;
    }

    public final void setPopTip(@OXOo.oOoXoXO xOOxIO xooxio) {
        this.popTip = xooxio;
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void startRecording() {
        clickDownRecording();
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void startRotateAnimation() {
        if (getSwitchRotateAnimation()) {
            getMTransformLanguageImg().clearAnimation();
            CharSequence text = getMTransformLanguageLeftTv().getText();
            CharSequence text2 = getMTransformLanguageRightTv().getText();
            final RotateAnimation rotateAnimation = new RotateAnimation(360.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(500L);
            rotateAnimation.setRepeatCount(-1);
            setSwitchRotateAnimation(false);
            getMTransformLanguageImg().startAnimation(rotateAnimation);
            getMTransformLanguageLeftTv().setText(text2);
            getMTransformLanguageRightTv().setText(text);
            setMCacheLanguage(getMLeftLanguage());
            setMLeftLanguage(getMRightLanguage());
            LanguageTranslationData mCacheLanguage = getMCacheLanguage();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(mCacheLanguage);
            setMRightLanguage(mCacheLanguage);
            com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
            xo0.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24365IOoo + '_' + LanguageTranslationData.class.getName(), new Gson().toJson(getMLeftLanguage()));
            xo0.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24442oIIxXoo + '_' + LanguageTranslationData.class.getName(), new Gson().toJson(getMRightLanguage()));
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24627oI, null, 2, null);
            getMHandler().postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.XIo0oOXIx
                @Override // java.lang.Runnable
                public final void run() {
                    NewSimultaneousInterpretationActivity.startRotateAnimation$lambda$11(rotateAnimation, this);
                }
            }, 500L);
        }
    }

    public final void startVoice() {
        RecordingManager.Companion.getInstance().setRecording(true);
        getMHandler().postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.OO0x0xX
            @Override // java.lang.Runnable
            public final void run() {
                NewSimultaneousInterpretationActivity.startVoice$lambda$9(NewSimultaneousInterpretationActivity.this);
            }
        }, 500L);
        AISparkChainManager.f19871oIX0oI.xXOx(true);
        getImg_play().setImageResource(R.drawable.ic_binaural_stop);
        VoiceManager.INSTANCE.setRecordBluetooth(false);
        setLangAndVoice();
        clickDownRecording();
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void updateTimerText() {
        long j = 3600000;
        int elapsedTime = (int) (getElapsedTime() / j);
        long elapsedTime2 = getElapsedTime() % j;
        long j2 = 60000;
        int i = (int) (elapsedTime2 / j2);
        int elapsedTime3 = (int) ((getElapsedTime() % j2) / 1000);
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(elapsedTime), Integer.valueOf(i), Integer.valueOf(elapsedTime3)}, 3));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        getTv_time().setText(format);
    }
}
