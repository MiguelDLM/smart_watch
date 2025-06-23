package com.sma.smartv3.otherdevice.charge;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.google.gson.Gson;
import com.sma.smartv3.biz.AISparkChainManager;
import com.sma.smartv3.biz.voice.RecordingManager;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AISpeech;
import com.sma.smartv3.model.LanguageTranslationData;
import com.sma.smartv3.model.LanguageTranslationKt;
import com.sma.smartv3.model.LeftAndRightPlayControl;
import com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity;
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

@kotlin.jvm.internal.XX({"SMAP\nBinauralTranslationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinauralTranslationActivity.kt\ncom/sma/smartv3/otherdevice/charge/BinauralTranslationActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,722:1\n87#2,7:723\n94#2,3:731\n70#2,7:734\n97#2:741\n173#2,7:746\n180#2,3:754\n143#2,7:757\n183#2:764\n173#2,7:765\n180#2,3:773\n143#2,7:776\n183#2:783\n1#3:730\n1#3:753\n1#3:772\n86#4,2:742\n86#4,2:744\n86#4,2:784\n86#4,2:786\n*S KotlinDebug\n*F\n+ 1 BinauralTranslationActivity.kt\ncom/sma/smartv3/otherdevice/charge/BinauralTranslationActivity\n*L\n501#1:723,7\n501#1:731,3\n501#1:734,7\n501#1:741\n655#1:746,7\n655#1:754,3\n655#1:757,7\n655#1:764\n660#1:765,7\n660#1:773,3\n660#1:776,7\n660#1:783\n501#1:730\n655#1:753\n660#1:772\n531#1:742,2\n532#1:744,2\n675#1:784,2\n690#1:786,2\n*E\n"})
/* loaded from: classes12.dex */
public final class BinauralTranslationActivity extends BaseTranslationActivity {

    @OXOo.OOXIXo
    private final MicrosoftSDKManage.I0Io binauralMicrosoftCallBack;
    private MultiItemTypeAdapter<AISpeech> mAdapter;
    private int mVoiceType;

    @OXOo.oOoXoXO
    private xOOxIO popTip;

    @OXOo.OOXIXo
    private final String TAG = "BinauralTranslationActivity";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return BinauralTranslationActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv_time$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$tv_time$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BinauralTranslationActivity.this.findViewById(R.id.tv_time);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO img_recording_status$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$img_recording_status$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BinauralTranslationActivity.this.findViewById(R.id.img_recording_status);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO img_play$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$img_play$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BinauralTranslationActivity.this.findViewById(R.id.img_play);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv_tip$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$tv_tip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BinauralTranslationActivity.this.findViewById(R.id.tv_tip);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO record_line$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WaveformView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$record_line$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final WaveformView invoke() {
            return (WaveformView) BinauralTranslationActivity.this.findViewById(R.id.record_line);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ll_top_select_language$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$ll_top_select_language$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) BinauralTranslationActivity.this.findViewById(R.id.ll_top_select_language);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO img_change_big$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$img_change_big$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BinauralTranslationActivity.this.findViewById(R.id.img_change_big);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ll_left_language$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$ll_left_language$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) BinauralTranslationActivity.this.findViewById(R.id.ll_left_language);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ll_right_language$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$ll_right_language$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) BinauralTranslationActivity.this.findViewById(R.id.ll_right_language);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv_left_select_language$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$tv_left_select_language$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BinauralTranslationActivity.this.findViewById(R.id.tv_left_select_language);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv_right_select_language$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$tv_right_select_language$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BinauralTranslationActivity.this.findViewById(R.id.tv_right_select_language);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rv$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$rv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) BinauralTranslationActivity.this.findViewById(R.id.rv);
        }
    });

    @OXOo.OOXIXo
    private ArrayList<AISpeech> aiSpeechList = new ArrayList<>();

    @kotlin.jvm.internal.XX({"SMAP\nBinauralTranslationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinauralTranslationActivity.kt\ncom/sma/smartv3/otherdevice/charge/BinauralTranslationActivity$binauralMicrosoftCallBack$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,722:1\n1549#2:723\n1620#2,3:724\n766#2:727\n857#2,2:728\n1549#2:730\n1620#2,3:731\n766#2:734\n857#2,2:735\n1549#2:737\n1620#2,3:738\n766#2:741\n857#2,2:742\n1549#2:744\n1620#2,3:745\n766#2:748\n857#2,2:749\n*S KotlinDebug\n*F\n+ 1 BinauralTranslationActivity.kt\ncom/sma/smartv3/otherdevice/charge/BinauralTranslationActivity$binauralMicrosoftCallBack$1\n*L\n117#1:723\n117#1:724,3\n118#1:727\n118#1:728,2\n182#1:730\n182#1:731,3\n183#1:734\n183#1:735,2\n213#1:737\n213#1:738,3\n214#1:741\n214#1:742,2\n278#1:744\n278#1:745,3\n279#1:748\n279#1:749,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI implements MicrosoftSDKManage.I0Io {
        public oIX0oI() {
        }

        public static final void I0Io(BinauralTranslationActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            if (this$0.aiSpeechList.size() > 0) {
                this$0.getRv().smoothScrollToPosition(this$0.aiSpeechList.size() - 1);
            }
        }

        public static final void oxoX(BinauralTranslationActivity this$0) {
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
            oix0oi.oIX0oI(BinauralTranslationActivity.this.TAG + "  sendTranslate  onIdentifyResults status = " + i + " content = " + str + TokenParser.SP);
            int i2 = 0;
            if (i != 1) {
                if (i == 2) {
                    oix0oi.oIX0oI(BinauralTranslationActivity.this.TAG + "  sendTranslate  onIdentifyResults content = " + str);
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
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(BinauralTranslationActivity.this.TAG + "  sendTranslate  onIdentifyResults parts = " + arrayList2);
                    int size = arrayList2.size();
                    int i3 = 0;
                    while (i3 < size) {
                        int i4 = i3 + 1;
                        if (BinauralTranslationActivity.this.aiSpeechList.size() < i4) {
                            AISpeech aISpeech = new AISpeech((String) arrayList2.get(i3), null, 2, 0, null, null, null, 0L, 0L, 506, null);
                            if (kotlin.text.OxI.oX0I0O(LanguageTranslationKt.detectLanguage(aISpeech.getText()), BinauralTranslationActivity.this.getMLeftLanguage().getAsrLanguage(), true)) {
                                aISpeech.setLanguageModel(0);
                                aISpeech.setLang(BinauralTranslationActivity.this.getMLeftLanguage().getRtasrLanguage());
                                aISpeech.setTargetLang(BinauralTranslationActivity.this.getMRightLanguage().getRtasrLanguage());
                                aISpeech.setTtsVoiceName(BinauralTranslationActivity.this.getMRightLanguage().getTtsViuceName());
                            } else {
                                aISpeech.setLanguageModel(1);
                                aISpeech.setLang(BinauralTranslationActivity.this.getMRightLanguage().getRtasrLanguage());
                                aISpeech.setTargetLang(BinauralTranslationActivity.this.getMLeftLanguage().getRtasrLanguage());
                                aISpeech.setTtsVoiceName(BinauralTranslationActivity.this.getMLeftLanguage().getTtsViuceName());
                            }
                            BinauralTranslationActivity.this.aiSpeechList.add(aISpeech);
                            if (i3 > 0) {
                                ((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3)).setStartTime(((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3 - 1)).getEndTime());
                            } else {
                                aISpeech.setStartTime(0L);
                            }
                            ((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3)).setEndTime(System.currentTimeMillis() - BinauralTranslationActivity.this.getStartTime());
                            BinauralTranslationActivity binauralTranslationActivity = BinauralTranslationActivity.this;
                            binauralTranslationActivity.binauralSendTranslationResultInput((AISpeech) binauralTranslationActivity.aiSpeechList.get(i3), i3);
                        }
                        if (BinauralTranslationActivity.this.aiSpeechList.size() == i4 && ((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3)).getStatus() == 1) {
                            OI0.oIX0oI oix0oi2 = OI0.oIX0oI.f1507oIX0oI;
                            StringBuilder sb = new StringBuilder();
                            sb.append(BinauralTranslationActivity.this.TAG);
                            sb.append("  sendTranslate  onIdentifyResults istrue = ");
                            if (BinauralTranslationActivity.this.aiSpeechList.size() == i4 && ((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3)).getStatus() == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            sb.append(z);
                            oix0oi2.oIX0oI(sb.toString());
                            Object obj2 = BinauralTranslationActivity.this.aiSpeechList.get(i3);
                            kotlin.jvm.internal.IIX0o.oO(obj2, "get(...)");
                            AISpeech aISpeech2 = (AISpeech) obj2;
                            aISpeech2.setText((String) arrayList2.get(i3));
                            aISpeech2.setStatus(2);
                            if (kotlin.text.OxI.oX0I0O(LanguageTranslationKt.detectLanguage(aISpeech2.getText()), BinauralTranslationActivity.this.getMLeftLanguage().getAsrLanguage(), true)) {
                                aISpeech2.setLanguageModel(0);
                                aISpeech2.setLang(BinauralTranslationActivity.this.getMLeftLanguage().getRtasrLanguage());
                                aISpeech2.setTargetLang(BinauralTranslationActivity.this.getMRightLanguage().getRtasrLanguage());
                                aISpeech2.setTtsVoiceName(BinauralTranslationActivity.this.getMRightLanguage().getTtsViuceName());
                            } else {
                                aISpeech2.setLanguageModel(1);
                                aISpeech2.setLang(BinauralTranslationActivity.this.getMRightLanguage().getRtasrLanguage());
                                aISpeech2.setTargetLang(BinauralTranslationActivity.this.getMLeftLanguage().getRtasrLanguage());
                                aISpeech2.setTtsVoiceName(BinauralTranslationActivity.this.getMLeftLanguage().getTtsViuceName());
                            }
                            if (i3 > 0) {
                                ((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3)).setStartTime(((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3 - 1)).getEndTime());
                            } else {
                                aISpeech2.setStartTime(0L);
                            }
                            ((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3)).setEndTime(System.currentTimeMillis() - BinauralTranslationActivity.this.getStartTime());
                            oix0oi2.oIX0oI(BinauralTranslationActivity.this.TAG + "  sendTranslate  onIdentifyResults aiSpeechList " + BinauralTranslationActivity.this.aiSpeechList);
                            BinauralTranslationActivity binauralTranslationActivity2 = BinauralTranslationActivity.this;
                            binauralTranslationActivity2.binauralSendTranslationResultInput((AISpeech) binauralTranslationActivity2.aiSpeechList.get(i3), i3);
                        }
                        i3 = i4;
                    }
                }
            } else {
                oix0oi.oIX0oI(BinauralTranslationActivity.this.TAG + "  sendTranslate  onIdentifyResults content = " + str);
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
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(BinauralTranslationActivity.this.TAG + "  sendTranslate  onIdentifyResults parts = " + arrayList4);
                int size2 = arrayList4.size();
                while (i2 < size2) {
                    int i5 = i2 + 1;
                    if (BinauralTranslationActivity.this.aiSpeechList.size() < i5) {
                        BinauralTranslationActivity.this.aiSpeechList.add(new AISpeech((String) arrayList4.get(i2), null, 1, 0, null, null, null, 0L, 0L, 506, null));
                    }
                    if (BinauralTranslationActivity.this.aiSpeechList.size() == i5) {
                        ((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i2)).setText((String) arrayList4.get(i2));
                    }
                    i2 = i5;
                }
            }
            MultiItemTypeAdapter multiItemTypeAdapter = BinauralTranslationActivity.this.mAdapter;
            if (multiItemTypeAdapter == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                multiItemTypeAdapter = null;
            }
            multiItemTypeAdapter.notifyDataSetChanged();
            Handler mHandler = BinauralTranslationActivity.this.getMHandler();
            final BinauralTranslationActivity binauralTranslationActivity3 = BinauralTranslationActivity.this;
            mHandler.postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.o00
                @Override // java.lang.Runnable
                public final void run() {
                    BinauralTranslationActivity.oIX0oI.I0Io(BinauralTranslationActivity.this);
                }
            }, 50L);
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onIdentifyResultsDetectedLanguage(int i, @OXOo.OOXIXo String str, @OXOo.OOXIXo String detectedLanguage) {
            boolean z;
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "str");
            kotlin.jvm.internal.IIX0o.x0xO0oo(detectedLanguage, "detectedLanguage");
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            oix0oi.oIX0oI(BinauralTranslationActivity.this.TAG + "  sendTranslate  onIdentifyResults status = " + i + " content = " + str + TokenParser.SP);
            int i2 = 0;
            if (i != 1) {
                if (i == 2) {
                    oix0oi.oIX0oI(BinauralTranslationActivity.this.TAG + "  sendTranslate  onIdentifyResults content = " + str);
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
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(BinauralTranslationActivity.this.TAG + "  sendTranslate  onIdentifyResults parts = " + arrayList2);
                    int size = arrayList2.size();
                    int i3 = 0;
                    while (i3 < size) {
                        int i4 = i3 + 1;
                        if (BinauralTranslationActivity.this.aiSpeechList.size() < i4) {
                            AISpeech aISpeech = new AISpeech((String) arrayList2.get(i3), null, 2, 0, null, null, null, 0L, 0L, 506, null);
                            if (kotlin.text.OxI.oX0I0O(detectedLanguage, BinauralTranslationActivity.this.getMLeftLanguage().getAsrLanguage(), true)) {
                                aISpeech.setLanguageModel(0);
                                aISpeech.setLang(BinauralTranslationActivity.this.getMLeftLanguage().getRtasrLanguage());
                                aISpeech.setTargetLang(BinauralTranslationActivity.this.getMRightLanguage().getRtasrLanguage());
                                aISpeech.setTtsVoiceName(BinauralTranslationActivity.this.getMRightLanguage().getTtsViuceName());
                            } else {
                                aISpeech.setLanguageModel(1);
                                aISpeech.setLang(BinauralTranslationActivity.this.getMRightLanguage().getRtasrLanguage());
                                aISpeech.setTargetLang(BinauralTranslationActivity.this.getMLeftLanguage().getRtasrLanguage());
                                aISpeech.setTtsVoiceName(BinauralTranslationActivity.this.getMLeftLanguage().getTtsViuceName());
                            }
                            BinauralTranslationActivity.this.aiSpeechList.add(aISpeech);
                            if (i3 > 0) {
                                ((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3)).setStartTime(((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3 - 1)).getEndTime());
                            } else {
                                aISpeech.setStartTime(0L);
                            }
                            ((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3)).setEndTime(System.currentTimeMillis() - BinauralTranslationActivity.this.getStartTime());
                            BinauralTranslationActivity binauralTranslationActivity = BinauralTranslationActivity.this;
                            binauralTranslationActivity.binauralSendTranslationResultInput((AISpeech) binauralTranslationActivity.aiSpeechList.get(i3), i3);
                        }
                        if (BinauralTranslationActivity.this.aiSpeechList.size() == i4 && ((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3)).getStatus() == 1) {
                            OI0.oIX0oI oix0oi2 = OI0.oIX0oI.f1507oIX0oI;
                            StringBuilder sb = new StringBuilder();
                            sb.append(BinauralTranslationActivity.this.TAG);
                            sb.append("  sendTranslate  onIdentifyResults istrue = ");
                            if (BinauralTranslationActivity.this.aiSpeechList.size() == i4 && ((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3)).getStatus() == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            sb.append(z);
                            oix0oi2.oIX0oI(sb.toString());
                            Object obj2 = BinauralTranslationActivity.this.aiSpeechList.get(i3);
                            kotlin.jvm.internal.IIX0o.oO(obj2, "get(...)");
                            AISpeech aISpeech2 = (AISpeech) obj2;
                            aISpeech2.setText((String) arrayList2.get(i3));
                            aISpeech2.setStatus(2);
                            if (kotlin.text.OxI.oX0I0O(detectedLanguage, BinauralTranslationActivity.this.getMLeftLanguage().getAsrLanguage(), true)) {
                                aISpeech2.setLanguageModel(0);
                                aISpeech2.setLang(BinauralTranslationActivity.this.getMLeftLanguage().getRtasrLanguage());
                                aISpeech2.setTargetLang(BinauralTranslationActivity.this.getMRightLanguage().getRtasrLanguage());
                                aISpeech2.setTtsVoiceName(BinauralTranslationActivity.this.getMRightLanguage().getTtsViuceName());
                            } else {
                                aISpeech2.setLanguageModel(1);
                                aISpeech2.setLang(BinauralTranslationActivity.this.getMRightLanguage().getRtasrLanguage());
                                aISpeech2.setTargetLang(BinauralTranslationActivity.this.getMLeftLanguage().getRtasrLanguage());
                                aISpeech2.setTtsVoiceName(BinauralTranslationActivity.this.getMLeftLanguage().getTtsViuceName());
                            }
                            if (i3 > 0) {
                                ((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3)).setStartTime(((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3 - 1)).getEndTime());
                            } else {
                                aISpeech2.setStartTime(0L);
                            }
                            ((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i3)).setEndTime(System.currentTimeMillis() - BinauralTranslationActivity.this.getStartTime());
                            oix0oi2.oIX0oI(BinauralTranslationActivity.this.TAG + "  sendTranslate  onIdentifyResults aiSpeechList " + BinauralTranslationActivity.this.aiSpeechList);
                            BinauralTranslationActivity binauralTranslationActivity2 = BinauralTranslationActivity.this;
                            binauralTranslationActivity2.binauralSendTranslationResultInput((AISpeech) binauralTranslationActivity2.aiSpeechList.get(i3), i3);
                        }
                        i3 = i4;
                    }
                }
            } else {
                oix0oi.oIX0oI(BinauralTranslationActivity.this.TAG + "  sendTranslate  onIdentifyResults content = " + str);
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
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(BinauralTranslationActivity.this.TAG + "  sendTranslate  onIdentifyResults parts = " + arrayList4);
                int size2 = arrayList4.size();
                while (i2 < size2) {
                    int i5 = i2 + 1;
                    if (BinauralTranslationActivity.this.aiSpeechList.size() < i5) {
                        BinauralTranslationActivity.this.aiSpeechList.add(new AISpeech((String) arrayList4.get(i2), null, 1, 0, null, null, null, 0L, 0L, 506, null));
                    }
                    if (BinauralTranslationActivity.this.aiSpeechList.size() == i5) {
                        ((AISpeech) BinauralTranslationActivity.this.aiSpeechList.get(i2)).setText((String) arrayList4.get(i2));
                    }
                    i2 = i5;
                }
            }
            MultiItemTypeAdapter multiItemTypeAdapter = BinauralTranslationActivity.this.mAdapter;
            if (multiItemTypeAdapter == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                multiItemTypeAdapter = null;
            }
            multiItemTypeAdapter.notifyDataSetChanged();
            Handler mHandler = BinauralTranslationActivity.this.getMHandler();
            final BinauralTranslationActivity binauralTranslationActivity3 = BinauralTranslationActivity.this;
            mHandler.postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.xoXoI
                @Override // java.lang.Runnable
                public final void run() {
                    BinauralTranslationActivity.oIX0oI.oxoX(BinauralTranslationActivity.this);
                }
            }, 50L);
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onStartTransmission() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BinauralTranslationActivity.this.TAG + " onStartTransmission ");
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onStopTransmission() {
        }
    }

    public BinauralTranslationActivity() {
        setMAIRecordsType(2);
        this.binauralMicrosoftCallBack = new oIX0oI();
        this.mVoiceType = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void binauralSendTranslationResultInput(AISpeech aISpeech, int i) {
        String text;
        setStartAnalysis(false);
        setMRecyclerViewAutoRefresh(true);
        if (aISpeech != null && (text = aISpeech.getText()) != null && text.length() > 0 && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(aISpeech.getText(), getString(R.string.request_error))) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " binauralSendTranslationResultInput ===> str = " + aISpeech.getText() + " , targetLang = " + aISpeech.getTargetLang());
            MicrosoftSDKManage.II0xO0 iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
            iI0xO0.oIX0oI().xoIxX();
            iI0xO0.oIX0oI().oXxOI0oIx(aISpeech.getText(), aISpeech.getTargetLang(), new BinauralTranslationActivity$binauralSendTranslationResultInput$1(aISpeech, this));
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
    public static final void endVoice$lambda$10(BinauralTranslationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        ToastUtils.showShort(this$0.getString(R.string.not_record_data), new Object[0]);
    }

    private final ImageView getImg_change_big() {
        return (ImageView) this.img_change_big$delegate.getValue();
    }

    private final ImageView getImg_play() {
        return (ImageView) this.img_play$delegate.getValue();
    }

    private final ImageView getImg_recording_status() {
        return (ImageView) this.img_recording_status$delegate.getValue();
    }

    private final LinearLayout getLl_left_language() {
        return (LinearLayout) this.ll_left_language$delegate.getValue();
    }

    private final LinearLayout getLl_right_language() {
        return (LinearLayout) this.ll_right_language$delegate.getValue();
    }

    private final LinearLayout getLl_top_select_language() {
        return (LinearLayout) this.ll_top_select_language$delegate.getValue();
    }

    private final WaveformView getRecord_line() {
        return (WaveformView) this.record_line$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView getRv() {
        return (RecyclerView) this.rv$delegate.getValue();
    }

    private final TextView getTv_left_select_language() {
        return (TextView) this.tv_left_select_language$delegate.getValue();
    }

    private final TextView getTv_right_select_language() {
        return (TextView) this.tv_right_select_language$delegate.getValue();
    }

    private final TextView getTv_time() {
        return (TextView) this.tv_time$delegate.getValue();
    }

    private final TextView getTv_tip() {
        return (TextView) this.tv_tip$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecord$lambda$8(BinauralTranslationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (RecordingManager.Companion.getInstance().isRecording()) {
            this$0.endVoice();
        } else {
            this$0.startVoice();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BinauralTranslationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startRotateAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(BinauralTranslationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.popTip == null) {
            xOOxIO xooxio = new xOOxIO(this$0);
            xooxio.oo0xXOI0I(Boolean.valueOf(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24376IxX00, false)));
            xooxio.xXxxox0I().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.otherdevice.charge.IIXOooo
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    BinauralTranslationActivity.initView$lambda$3$lambda$2$lambda$1(compoundButton, z);
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
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24376IxX00, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(BinauralTranslationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.popTip == null) {
            xOOxIO xooxio = new xOOxIO(this$0);
            xooxio.oo0xXOI0I(Boolean.valueOf(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24376IxX00, false)));
            xooxio.xXxxox0I().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.otherdevice.charge.OxxIIOOXO
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    BinauralTranslationActivity.initView$lambda$6$lambda$5$lambda$4(compoundButton, z);
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
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24376IxX00, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(BinauralTranslationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startRotateAnimation();
    }

    private final void preConnect() {
        MicrosoftSDKManage.xI0oxI00(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI(), getArsLanguage(), true, getTtsVoiceName(), getTtsTargetLang(), false, null, CollectionsKt__CollectionsKt.XOxIOxOx(getMLeftLanguage().getAsrLanguage(), getMRightLanguage().getAsrLanguage()), false, 160, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startRecordingBinaural() {
        if (ProductManager.f20544oIX0oI.XI0IXoo()) {
            MicrosoftSDKManage.II0xO0 iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
            MicrosoftSDKManage.IIX0(iI0xO0.oIX0oI(), this.binauralMicrosoftCallBack, null, 2, null);
            MicrosoftSDKManage.oxIIX0o(iI0xO0.oIX0oI(), false, 1, null);
        }
        View rootView = getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        showCountdownPopup(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startRotateAnimation$lambda$11(RotateAnimation rotateAnimation, BinauralTranslationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(rotateAnimation, "$rotateAnimation");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        rotateAnimation.cancel();
        this$0.getMTransformLanguageImg().clearAnimation();
        this$0.setSwitchRotateAnimation(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVoice$lambda$9(BinauralTranslationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.aiSpeechList.clear();
        kotlin.collections.OxI.xOoOIoI(this$0.aiSpeechList, new Oox.oOoXoXO<AISpeech, Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$startVoice$1$1
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
        VoiceManager.INSTANCE.setMListener(new Oox.IXxxXO<Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$addVoiceListener$1
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
                        if (i2 == 3 && BinauralTranslationActivity.this.getMVoiceType() == 0) {
                            BinauralTranslationActivity.this.setMVoiceType(i2);
                            BinauralTranslationActivity.this.endVoice();
                            MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().X0xxXX0();
                        }
                    } else if (BinauralTranslationActivity.this.getMVoiceType() == 0) {
                        BinauralTranslationActivity.this.setMVoiceType(i2);
                        BinauralTranslationActivity.this.endVoice();
                    }
                } else if (BinauralTranslationActivity.this.getMVoiceType() != 0) {
                    BinauralTranslationActivity.this.setMVoiceType(i2);
                    VoiceManager.INSTANCE.setLanguageType(BinauralTranslationActivity.this.getArsLanguage(), BinauralTranslationActivity.this.getTtsVoiceName());
                    BinauralTranslationActivity.this.startVoice();
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
        RecordingManager.Companion companion = RecordingManager.Companion;
        if (companion.getInstance().isRecording()) {
            setStartTime(System.currentTimeMillis());
            getImg_recording_status().setVisibility(0);
            getRecord_line().setVisibility(8);
            companion.getInstance().setRecording(true);
            Glide.with(getMContext()).asGif().load(Integer.valueOf(R.drawable.pop_recording_animation_img)).into(getImg_recording_status());
            setElapsedTime(0L);
            getMHandler().postDelayed(getRunnable(), getUpdateInterval());
        }
    }

    public final void endVoice() {
        RecordingManager.Companion.getInstance().setRecording(false);
        getImg_play().setImageResource(R.drawable.ic_binaural_start);
        getTv_tip().setText(R.string.click_start_recording);
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
        getMHandler().postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.ooOOo0oXI
            @Override // java.lang.Runnable
            public final void run() {
                BinauralTranslationActivity.endVoice$lambda$10(BinauralTranslationActivity.this);
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
        getImg_play().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.x0XOIxOo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BinauralTranslationActivity.initRecord$lambda$8(BinauralTranslationActivity.this, view);
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
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        xo0.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24483xX, true);
        final ArrayList<AISpeech> arrayList = this.aiSpeechList;
        this.mAdapter = new MultiItemTypeAdapter<AISpeech>(this, arrayList) { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$initView$1

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
                          (wrap:android.view.View$OnClickListener:0x0042: CONSTRUCTOR (r4v0 'mAISpeech' com.sma.smartv3.model.AISpeech A[DONT_INLINE]) A[MD:(com.sma.smartv3.model.AISpeech):void (m), WRAPPED] (LINE:67) call: com.sma.smartv3.otherdevice.charge.XI0IXoo.<init>(com.sma.smartv3.model.AISpeech):void type: CONSTRUCTOR)
                         VIRTUAL call: com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder.setOnClickListener(int, android.view.View$OnClickListener):com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder A[MD:(int, android.view.View$OnClickListener):com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder (m)] (LINE:70) in method: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$initView$1.II0xO0.X0o0xo(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.AISpeech, int):void, file: classes12.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.otherdevice.charge.XI0IXoo, state: NOT_LOADED
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
                        com.sma.smartv3.otherdevice.charge.XI0IXoo r5 = new com.sma.smartv3.otherdevice.charge.XI0IXoo
                        r5.<init>(r4)
                        r3.setOnClickListener(r0, r5)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$initView$1.II0xO0.I0Io(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.AISpeech, int):void");
                }
            }

            /* loaded from: classes12.dex */
            public static final class oIX0oI implements oo.xoXoI<AISpeech> {
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
                          (wrap:android.view.View$OnClickListener:0x0042: CONSTRUCTOR (r4v0 'mAISpeech' com.sma.smartv3.model.AISpeech A[DONT_INLINE]) A[MD:(com.sma.smartv3.model.AISpeech):void (m), WRAPPED] (LINE:67) call: com.sma.smartv3.otherdevice.charge.X0IIOO.<init>(com.sma.smartv3.model.AISpeech):void type: CONSTRUCTOR)
                         VIRTUAL call: com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder.setOnClickListener(int, android.view.View$OnClickListener):com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder A[MD:(int, android.view.View$OnClickListener):com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder (m)] (LINE:70) in method: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$initView$1.oIX0oI.X0o0xo(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.AISpeech, int):void, file: classes12.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.otherdevice.charge.X0IIOO, state: NOT_LOADED
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
                        com.sma.smartv3.otherdevice.charge.X0IIOO r5 = new com.sma.smartv3.otherdevice.charge.X0IIOO
                        r5.<init>(r4)
                        r3.setOnClickListener(r0, r5)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$initView$1.oIX0oI.I0Io(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.AISpeech, int):void");
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
        getMTransformLanguageImg().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.oO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BinauralTranslationActivity.initView$lambda$0(BinauralTranslationActivity.this, view);
            }
        });
        getMTransformLanguageLeftTv().setText(getMLeftLanguage().getName());
        getMTransformLanguageRightTv().setText(getMRightLanguage().getName());
        getTv_left_select_language().setText(getMLeftLanguage().getName());
        getTv_right_select_language().setText(getMRightLanguage().getName());
        VoiceManager.INSTANCE.setActivityData(true);
        if (productManager.XI0IXoo()) {
            MicrosoftSDKManage.IIX0(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI(), this.binauralMicrosoftCallBack, null, 2, null);
        }
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.x0xO0oo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BinauralTranslationActivity.initView$lambda$3(BinauralTranslationActivity.this, view);
            }
        });
        getAbhTitleCenter().setVisibility(8);
        if (!xo0.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24376IxX00, false)) {
            getRootView().post(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.IXxxXO
                @Override // java.lang.Runnable
                public final void run() {
                    BinauralTranslationActivity.initView$lambda$6(BinauralTranslationActivity.this);
                }
            });
        }
        getImg_change_big().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.Oxx0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BinauralTranslationActivity.initView$lambda$7(BinauralTranslationActivity.this, view);
            }
        });
        initRecord();
        if (ProductManager.xOOxIO(productManager, null, 1, null)) {
            addVoiceListener();
        }
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_binaural_translation;
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
                        getTv_right_select_language().setText(getMRightLanguage().getName());
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
                getTv_left_select_language().setText(getMLeftLanguage().getName());
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
            case R.id.ll_left_language /* 2131365908 */:
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
            case R.id.ll_right_language /* 2131365943 */:
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
        oOXoIIIo.X0o0xo.II0xO0(permission, string, string2, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.BinauralTranslationActivity$permission$1
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
                    BinauralTranslationActivity.this.startRecordingBinaural();
                }
            }
        });
    }

    public final void setMVoiceType(int i) {
        this.mVoiceType = i;
    }

    public final void setPopTip(@OXOo.oOoXoXO xOOxIO xooxio) {
        this.popTip = xooxio;
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
            getImg_change_big().startAnimation(rotateAnimation);
            getMTransformLanguageLeftTv().setText(text2);
            getMTransformLanguageRightTv().setText(text);
            getTv_left_select_language().setText(text2);
            getTv_right_select_language().setText(text);
            setMCacheLanguage(getMLeftLanguage());
            setMLeftLanguage(getMRightLanguage());
            LanguageTranslationData mCacheLanguage = getMCacheLanguage();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(mCacheLanguage);
            setMRightLanguage(mCacheLanguage);
            com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
            xo0.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24365IOoo + '_' + LanguageTranslationData.class.getName(), new Gson().toJson(getMLeftLanguage()));
            xo0.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24442oIIxXoo + '_' + LanguageTranslationData.class.getName(), new Gson().toJson(getMRightLanguage()));
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24627oI, null, 2, null);
            getMHandler().postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.oI0IIXIo
                @Override // java.lang.Runnable
                public final void run() {
                    BinauralTranslationActivity.startRotateAnimation$lambda$11(rotateAnimation, this);
                }
            }, 500L);
        }
    }

    public final void startVoice() {
        RecordingManager.Companion.getInstance().setRecording(true);
        getLl_top_select_language().setVisibility(8);
        getMHandler().postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.oOoXoXO
            @Override // java.lang.Runnable
            public final void run() {
                BinauralTranslationActivity.startVoice$lambda$9(BinauralTranslationActivity.this);
            }
        }, 500L);
        AISparkChainManager.f19871oIX0oI.xXOx(true);
        getImg_play().setImageResource(R.drawable.ic_binaural_stop);
        getTv_tip().setText(R.string.click_stop_recording);
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
