package com.sma.smartv3.otherdevice.charge;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
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
import com.bumptech.glide.Glide;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.biz.AISparkChainManager;
import com.sma.smartv3.biz.voice.RecordingManager;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AISpeech;
import com.sma.smartv3.model.LanguageTranslationData;
import com.sma.smartv3.otherdevice.charge.LiveRecordingActivity;
import com.sma.smartv3.pop.xOOxIO;
import com.sma.smartv3.util.MicrosoftSDKManage;
import com.sma.smartv3.view.WaveformView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nLiveRecordingActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveRecordingActivity.kt\ncom/sma/smartv3/otherdevice/charge/LiveRecordingActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,431:1\n87#2,7:432\n94#2,3:440\n70#2,7:443\n97#2:450\n173#2,7:451\n180#2,3:459\n143#2,7:462\n183#2:469\n173#2,7:470\n180#2,3:478\n143#2,7:481\n183#2:488\n1#3:439\n1#3:458\n1#3:477\n*S KotlinDebug\n*F\n+ 1 LiveRecordingActivity.kt\ncom/sma/smartv3/otherdevice/charge/LiveRecordingActivity\n*L\n293#1:432,7\n293#1:440,3\n293#1:443,7\n293#1:450\n324#1:451,7\n324#1:459,3\n324#1:462,7\n324#1:469\n329#1:470,7\n329#1:478,3\n329#1:481,7\n329#1:488\n293#1:439\n324#1:458\n329#1:477\n*E\n"})
/* loaded from: classes12.dex */
public final class LiveRecordingActivity extends BaseTranslationActivity {

    @OXOo.OOXIXo
    private final MicrosoftSDKManage.I0Io binauralMicrosoftCallBack;
    private MultiItemTypeAdapter<AISpeech> mAdapter;
    private int mVoiceType;
    private xOOxIO popTip;

    @OXOo.OOXIXo
    private final String TAG = "LiveRecordingActivity";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.LiveRecordingActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return LiveRecordingActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv_time$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.LiveRecordingActivity$tv_time$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) LiveRecordingActivity.this.findViewById(R.id.tv_time);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO img_recording_status$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.LiveRecordingActivity$img_recording_status$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) LiveRecordingActivity.this.findViewById(R.id.img_recording_status);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO img_play$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.LiveRecordingActivity$img_play$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) LiveRecordingActivity.this.findViewById(R.id.img_play);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO record_line$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WaveformView>() { // from class: com.sma.smartv3.otherdevice.charge.LiveRecordingActivity$record_line$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final WaveformView invoke() {
            return (WaveformView) LiveRecordingActivity.this.findViewById(R.id.record_line);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rv$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.otherdevice.charge.LiveRecordingActivity$rv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) LiveRecordingActivity.this.findViewById(R.id.rv);
        }
    });

    @OXOo.OOXIXo
    private ArrayList<AISpeech> aiSpeechList = new ArrayList<>();

    @kotlin.jvm.internal.XX({"SMAP\nLiveRecordingActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveRecordingActivity.kt\ncom/sma/smartv3/otherdevice/charge/LiveRecordingActivity$binauralMicrosoftCallBack$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,431:1\n1549#2:432\n1620#2,3:433\n766#2:436\n857#2,2:437\n1549#2:439\n1620#2,3:440\n766#2:443\n857#2,2:444\n*S KotlinDebug\n*F\n+ 1 LiveRecordingActivity.kt\ncom/sma/smartv3/otherdevice/charge/LiveRecordingActivity$binauralMicrosoftCallBack$1\n*L\n90#1:432\n90#1:433,3\n91#1:436\n91#1:437,2\n133#1:439\n133#1:440,3\n134#1:443\n134#1:444,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI implements MicrosoftSDKManage.I0Io {
        public oIX0oI() {
        }

        public static final void II0xO0(LiveRecordingActivity this$0) {
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
            oix0oi.oIX0oI(LiveRecordingActivity.this.TAG + "  sendTranslate  onIdentifyResults status = " + i + " content = " + str + TokenParser.SP);
            int i2 = 0;
            if (i != 1) {
                if (i == 2) {
                    oix0oi.oIX0oI(LiveRecordingActivity.this.TAG + "  sendTranslate  onIdentifyResults content = " + str);
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
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(LiveRecordingActivity.this.TAG + "  sendTranslate  onIdentifyResults parts = " + arrayList2);
                    int size = arrayList2.size();
                    int i3 = 0;
                    while (i3 < size) {
                        int i4 = i3 + 1;
                        if (LiveRecordingActivity.this.aiSpeechList.size() < i4) {
                            AISpeech aISpeech = new AISpeech((String) arrayList2.get(i3), null, 2, 0, null, null, null, 0L, 0L, 506, null);
                            aISpeech.setLanguageModel(0);
                            aISpeech.setLang(LiveRecordingActivity.this.getMLeftLanguage().getRtasrLanguage());
                            aISpeech.setTargetLang(LiveRecordingActivity.this.getMLeftLanguage().getRtasrLanguage());
                            aISpeech.setTtsVoiceName(LiveRecordingActivity.this.getMLeftLanguage().getTtsViuceName());
                            LiveRecordingActivity.this.aiSpeechList.add(aISpeech);
                            if (i3 > 0) {
                                ((AISpeech) LiveRecordingActivity.this.aiSpeechList.get(i3)).setStartTime(((AISpeech) LiveRecordingActivity.this.aiSpeechList.get(i3 - 1)).getEndTime());
                            } else {
                                aISpeech.setStartTime(0L);
                            }
                            ((AISpeech) LiveRecordingActivity.this.aiSpeechList.get(i3)).setEndTime(System.currentTimeMillis() - LiveRecordingActivity.this.getStartTime());
                        }
                        if (LiveRecordingActivity.this.aiSpeechList.size() == i4 && ((AISpeech) LiveRecordingActivity.this.aiSpeechList.get(i3)).getStatus() == 1) {
                            OI0.oIX0oI oix0oi2 = OI0.oIX0oI.f1507oIX0oI;
                            StringBuilder sb = new StringBuilder();
                            sb.append(LiveRecordingActivity.this.TAG);
                            sb.append("  sendTranslate  onIdentifyResults istrue = ");
                            if (LiveRecordingActivity.this.aiSpeechList.size() == i4 && ((AISpeech) LiveRecordingActivity.this.aiSpeechList.get(i3)).getStatus() == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            sb.append(z);
                            oix0oi2.oIX0oI(sb.toString());
                            Object obj2 = LiveRecordingActivity.this.aiSpeechList.get(i3);
                            kotlin.jvm.internal.IIX0o.oO(obj2, "get(...)");
                            AISpeech aISpeech2 = (AISpeech) obj2;
                            aISpeech2.setText((String) arrayList2.get(i3));
                            aISpeech2.setStatus(2);
                            aISpeech2.setLanguageModel(0);
                            aISpeech2.setLang(LiveRecordingActivity.this.getMLeftLanguage().getRtasrLanguage());
                            aISpeech2.setTargetLang(LiveRecordingActivity.this.getMLeftLanguage().getRtasrLanguage());
                            aISpeech2.setTtsVoiceName(LiveRecordingActivity.this.getMLeftLanguage().getTtsViuceName());
                            if (i3 > 0) {
                                ((AISpeech) LiveRecordingActivity.this.aiSpeechList.get(i3)).setStartTime(((AISpeech) LiveRecordingActivity.this.aiSpeechList.get(i3 - 1)).getEndTime());
                            } else {
                                aISpeech2.setStartTime(0L);
                            }
                            ((AISpeech) LiveRecordingActivity.this.aiSpeechList.get(i3)).setEndTime(System.currentTimeMillis() - LiveRecordingActivity.this.getStartTime());
                        }
                        i3 = i4;
                    }
                }
            } else {
                oix0oi.oIX0oI(LiveRecordingActivity.this.TAG + "  sendTranslate  onIdentifyResults content = " + str);
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
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(LiveRecordingActivity.this.TAG + "  sendTranslate  onIdentifyResults parts = " + arrayList4);
                int size2 = arrayList4.size();
                while (i2 < size2) {
                    int i5 = i2 + 1;
                    if (LiveRecordingActivity.this.aiSpeechList.size() < i5) {
                        LiveRecordingActivity.this.aiSpeechList.add(new AISpeech((String) arrayList4.get(i2), null, 1, 0, null, null, null, 0L, 0L, 506, null));
                    }
                    if (LiveRecordingActivity.this.aiSpeechList.size() == i5) {
                        ((AISpeech) LiveRecordingActivity.this.aiSpeechList.get(i2)).setText((String) arrayList4.get(i2));
                    }
                    i2 = i5;
                }
            }
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(LiveRecordingActivity.this.TAG + "  aiSpeechList.size = " + LiveRecordingActivity.this.aiSpeechList.size());
            MultiItemTypeAdapter multiItemTypeAdapter = LiveRecordingActivity.this.mAdapter;
            if (multiItemTypeAdapter == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                multiItemTypeAdapter = null;
            }
            multiItemTypeAdapter.notifyDataSetChanged();
            Handler mHandler = LiveRecordingActivity.this.getMHandler();
            final LiveRecordingActivity liveRecordingActivity = LiveRecordingActivity.this;
            mHandler.postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.xoIxX
                @Override // java.lang.Runnable
                public final void run() {
                    LiveRecordingActivity.oIX0oI.II0xO0(LiveRecordingActivity.this);
                }
            }, 50L);
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onIdentifyResultsDetectedLanguage(int i, @OXOo.OOXIXo String str, @OXOo.OOXIXo String str2) {
            MicrosoftSDKManage.I0Io.oIX0oI.oIX0oI(this, i, str, str2);
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onStartTransmission() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(LiveRecordingActivity.this.TAG + " onStartTransmission ");
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onStopTransmission() {
        }
    }

    public LiveRecordingActivity() {
        setMAIRecordsType(2);
        this.binauralMicrosoftCallBack = new oIX0oI();
        this.mVoiceType = -1;
    }

    private final void clickDownRecording() {
        if (PermissionUtils.isGranted(PermissionConstants.MICROPHONE)) {
            startRecordingBinaural();
        } else {
            permission();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endVoice$lambda$5(LiveRecordingActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        ToastUtils.showShort(this$0.getString(R.string.not_record_data), new Object[0]);
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

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView getRv() {
        return (RecyclerView) this.rv$delegate.getValue();
    }

    private final TextView getTv_time() {
        return (TextView) this.tv_time$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecord$lambda$6(LiveRecordingActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (RecordingManager.Companion.getInstance().isRecording()) {
            this$0.endVoice();
        } else {
            this$0.startVoice();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(LiveRecordingActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        xOOxIO xooxio = new xOOxIO(this$0);
        xooxio.ooXIXxIX(this$0.getString(R.string.live_record_tip_1));
        xooxio.xI(this$0.getString(R.string.dialogue_tip_2));
        xooxio.IIX0o(Integer.valueOf(R.drawable.ic_live_record_tip));
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        xooxio.oo0xXOI0I(Boolean.valueOf(xo0.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24451oX0ooo0I0, false)));
        xooxio.xXxxox0I().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.otherdevice.charge.I0oOIX
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LiveRecordingActivity.initView$lambda$2$lambda$1$lambda$0(compoundButton, z);
            }
        });
        this$0.popTip = xooxio;
        if (!xo0.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24451oX0ooo0I0, false)) {
            xOOxIO xooxio2 = this$0.popTip;
            if (xooxio2 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("popTip");
                xooxio2 = null;
            }
            View rootView = this$0.getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xooxio2.xoXoI(rootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1$lambda$0(CompoundButton compoundButton, boolean z) {
        LogUtils.d("isChecked = " + z);
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24451oX0ooo0I0, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(LiveRecordingActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        xOOxIO xooxio = this$0.popTip;
        if (xooxio == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("popTip");
            xooxio = null;
        }
        View rootView = this$0.getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        xooxio.xoXoI(rootView);
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
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            showCountdownPopup(rootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVoice$lambda$4(LiveRecordingActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.aiSpeechList.clear();
        kotlin.collections.OxI.xOoOIoI(this$0.aiSpeechList, new Oox.oOoXoXO<AISpeech, Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.LiveRecordingActivity$startVoice$1$1
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
        VoiceManager.INSTANCE.setMListener(new Oox.IXxxXO<Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.LiveRecordingActivity$addVoiceListener$1
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
                        if (i2 == 3 && LiveRecordingActivity.this.getMVoiceType() == 0) {
                            LiveRecordingActivity.this.setMVoiceType(i2);
                            LiveRecordingActivity.this.endVoice();
                            MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().X0xxXX0();
                        }
                    } else if (LiveRecordingActivity.this.getMVoiceType() == 0) {
                        LiveRecordingActivity.this.setMVoiceType(i2);
                        LiveRecordingActivity.this.endVoice();
                    }
                } else if (LiveRecordingActivity.this.getMVoiceType() != 0) {
                    LiveRecordingActivity.this.setMVoiceType(i2);
                    VoiceManager.INSTANCE.setLanguageType(LiveRecordingActivity.this.getArsLanguage(), LiveRecordingActivity.this.getTtsVoiceName());
                    LiveRecordingActivity.this.startVoice();
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
        RecordingManager.Companion.getInstance().setRecording(true);
        Glide.with(getMContext()).asGif().load(Integer.valueOf(R.drawable.pop_recording_animation_img)).into(getImg_recording_status());
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
            return;
        }
        getMHandler().postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.XoI0Ixx0
            @Override // java.lang.Runnable
            public final void run() {
                LiveRecordingActivity.endVoice$lambda$5(LiveRecordingActivity.this);
            }
        }, 500L);
    }

    @OXOo.OOXIXo
    public final MicrosoftSDKManage.I0Io getBinauralMicrosoftCallBack() {
        return this.binauralMicrosoftCallBack;
    }

    public final int getMVoiceType() {
        return this.mVoiceType;
    }

    public final void initAdapter() {
        final ArrayList<AISpeech> arrayList = this.aiSpeechList;
        this.mAdapter = new MultiItemTypeAdapter<AISpeech>(this, arrayList) { // from class: com.sma.smartv3.otherdevice.charge.LiveRecordingActivity$initAdapter$1

            /* loaded from: classes12.dex */
            public static final class oIX0oI implements oo.xoXoI<AISpeech> {
                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_live_record;
                }

                @Override // oo.xoXoI
                /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                public boolean oIX0oI(@OXOo.oOoXoXO AISpeech aISpeech, int i) {
                    if (aISpeech == null || aISpeech.getLanguageModel() != 0) {
                        return false;
                    }
                    return true;
                }

                @Override // oo.xoXoI
                /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo AISpeech mAISpeech, int i) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(mAISpeech, "mAISpeech");
                    ((TextView) holder.getView(R.id.tv_original)).setText(mAISpeech.getText());
                }
            }

            {
                addItemViewDelegate(0, new oIX0oI());
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
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    public final void initRecord() {
        getImg_play().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.O0Xx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRecordingActivity.initRecord$lambda$6(LiveRecordingActivity.this, view);
            }
        });
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        setLangAndVoice();
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XI0IXoo()) {
            preConnect();
        }
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24483xX, true);
        getMTransformLanguageLeftTv().setText(getMLeftLanguage().getName());
        getMTransformLanguageRightTv().setText(getMRightLanguage().getName());
        getAbhTitleRight().setVisibility(0);
        getAbhTitleCenter().setVisibility(8);
        VoiceManager.INSTANCE.setActivityData(true);
        if (productManager.XI0IXoo()) {
            MicrosoftSDKManage.IIX0(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI(), this.binauralMicrosoftCallBack, null, 2, null);
        }
        getRootView().post(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.xoxXI
            @Override // java.lang.Runnable
            public final void run() {
                LiveRecordingActivity.initView$lambda$2(LiveRecordingActivity.this);
            }
        });
        getAbhTitleRight().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.IoOoo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRecordingActivity.initView$lambda$3(LiveRecordingActivity.this, view);
            }
        });
        initAdapter();
        initRecord();
        if (ProductManager.xOOxIO(productManager, null, 1, null)) {
            addVoiceListener();
        }
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_live_recording;
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
            case R.id.img_select /* 2131364722 */:
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
        oOXoIIIo.X0o0xo.II0xO0(permission, string, string2, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.LiveRecordingActivity$permission$1
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
                    LiveRecordingActivity.this.startRecordingBinaural();
                }
            }
        });
    }

    public final void setMVoiceType(int i) {
        this.mVoiceType = i;
    }

    public final void startVoice() {
        RecordingManager.Companion.getInstance().setRecording(true);
        getMHandler().postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.Xo0
            @Override // java.lang.Runnable
            public final void run() {
                LiveRecordingActivity.startVoice$lambda$4(LiveRecordingActivity.this);
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
