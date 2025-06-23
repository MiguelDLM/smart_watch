package com.sma.smartv3.otherdevice.charge;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.biz.AISparkChainManager;
import com.sma.smartv3.biz.voice.DcsTtsPlayer;
import com.sma.smartv3.biz.voice.RecordingManager;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.AIRecordsDao;
import com.sma.smartv3.db.entity.AIRecords;
import com.sma.smartv3.model.AIFunctionType;
import com.sma.smartv3.model.AISpeech;
import com.sma.smartv3.model.AITranslation;
import com.sma.smartv3.model.LanguageTranslationData;
import com.sma.smartv3.model.LanguageTranslationKt;
import com.sma.smartv3.model.LeftAndRightPlayControl;
import com.sma.smartv3.model.ViewModelMain;
import com.sma.smartv3.otherdevice.charge.BaseTranslationActivity;
import com.sma.smartv3.util.MicrosoftSDKManage;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleVoice;
import com.szabh.smable3.entity.Languages;
import java.io.Serializable;
import java.util.List;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nBaseTranslationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseTranslationActivity.kt\ncom/sma/smartv3/otherdevice/charge/BaseTranslationActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,768:1\n90#2:769\n90#2:770\n86#2,2:809\n86#2,2:811\n86#2,2:813\n86#2,2:815\n173#3,7:771\n180#3,3:779\n143#3,7:782\n183#3:789\n173#3,7:790\n180#3,3:798\n143#3,7:801\n183#3:808\n1#4:778\n1#4:797\n*S KotlinDebug\n*F\n+ 1 BaseTranslationActivity.kt\ncom/sma/smartv3/otherdevice/charge/BaseTranslationActivity\n*L\n184#1:769\n186#1:770\n352#1:809,2\n366#1:811,2\n400#1:813,2\n401#1:815,2\n333#1:771,7\n333#1:779,3\n333#1:782,7\n333#1:789\n338#1:790,7\n338#1:798,3\n338#1:801,7\n338#1:808\n333#1:778\n338#1:797\n*E\n"})
/* loaded from: classes12.dex */
public class BaseTranslationActivity extends BaseActivity {
    private long elapsedTime;
    private boolean isAddListData;
    private boolean isAppSend;
    private boolean isEndTranslation;
    private boolean isStartAnalysis;
    private boolean isSteam;
    private boolean isSupportTransfer;

    @OXOo.oOoXoXO
    private AIRecords mAIRecords;

    @OXOo.oOoXoXO
    private LanguageTranslationData mCacheLanguage;
    public List<LanguageTranslationData> mLanguageTranslationList;
    public LanguageTranslationData mLeftLanguage;
    public LanguageTranslationData mRightLanguage;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.oI0IIXIo popCountdownPopup;
    private long startTime;

    @OXOo.OOXIXo
    private final String TAG = "BaseTranslationActivity";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleCenter$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.BaseTranslationActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BaseTranslationActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.BaseTranslationActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BaseTranslationActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final AIRecordsDao mRecordsDao = MyDb.INSTANCE.getMDatabase().aiRecordsDao();

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTransformLanguageLeftTv$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.BaseTranslationActivity$mTransformLanguageLeftTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BaseTranslationActivity.this.findViewById(R.id.dialogue_translation_left_tv);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTransformLanguageImg$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.BaseTranslationActivity$mTransformLanguageImg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BaseTranslationActivity.this.findViewById(R.id.transform_language_img);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTransformLanguageRightTv$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.BaseTranslationActivity$mTransformLanguageRightTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BaseTranslationActivity.this.findViewById(R.id.dialogue_translation_right_tv);
        }
    });
    private final int loadTimeOut = 255;
    private final int loadTimeOutToast = 254;
    private long delayTime = 3000;
    private final long updateInterval = 1000;

    @OXOo.OOXIXo
    private final Runnable runnable = new oxoX();

    @OXOo.OOXIXo
    private final oIX0oI countdownRunnable = new oIX0oI();

    @OXOo.OOXIXo
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.sma.smartv3.otherdevice.charge.oxoX
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean mHandler$lambda$1;
            mHandler$lambda$1 = BaseTranslationActivity.mHandler$lambda$1(BaseTranslationActivity.this, message);
            return mHandler$lambda$1;
        }
    });
    private int mAIRecordsType = 1;
    private boolean mRecyclerViewAutoRefresh = true;
    private boolean switchRotateAnimation = true;

    @OXOo.OOXIXo
    private final RecordingManager.OnRecordingCallback recordingCallBack = new I0Io();
    private int mAIFunctionType = AIFunctionType.AI_TRANSLATION.getType();

    @OXOo.OOXIXo
    private String lang = "cn";

    @OXOo.OOXIXo
    private String targetLang = Languages.DEFAULT_LANGUAGE;

    @OXOo.OOXIXo
    private String ttsTargetLang = Languages.DEFAULT_LANGUAGE;

    @OXOo.OOXIXo
    private String ttsVoiceName = "x4_enus_catherine_profnews";

    @OXOo.OOXIXo
    private String arsLanguage = "zh_cn";

    @OXOo.OOXIXo
    private String arsAccent = "mandarin";

    @OXOo.OOXIXo
    private String mContentResult = "";

    @OXOo.OOXIXo
    private final MicrosoftSDKManage.I0Io microsoftCallBack = new II0xO0();

    @kotlin.jvm.internal.XX({"SMAP\nBaseTranslationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseTranslationActivity.kt\ncom/sma/smartv3/otherdevice/charge/BaseTranslationActivity$recordingCallBack$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,768:1\n1#2:769\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class I0Io implements RecordingManager.OnRecordingCallback {
        public I0Io() {
        }

        public static final void I0Io(BaseTranslationActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.showRecordingPopup();
        }

        public static final void oxoX(BaseTranslationActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.disRecordingPopup();
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onBeforeRecording() {
            final BaseTranslationActivity baseTranslationActivity = BaseTranslationActivity.this;
            baseTranslationActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.xoIox
                @Override // java.lang.Runnable
                public final void run() {
                    BaseTranslationActivity.I0Io.I0Io(BaseTranslationActivity.this);
                }
            });
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onRecordResult(@OXOo.oOoXoXO AITranslation aITranslation) {
            String mContent;
            String str;
            if (aITranslation != null && aITranslation.getStatus() == 2) {
                DcsTtsPlayer.INSTANCE.stop();
                AIRecords mAIRecords = BaseTranslationActivity.this.getMAIRecords();
                if (mAIRecords != null) {
                    String obj = StringsKt__StringsKt.oIoIXxIO(aITranslation.getText()).toString();
                    BaseTranslationActivity baseTranslationActivity = BaseTranslationActivity.this;
                    if (obj.length() == 0) {
                        AIRecords mAIRecords2 = baseTranslationActivity.getMAIRecords();
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords2);
                        obj = mAIRecords2.getMContent();
                    }
                    mAIRecords.setMContent(obj);
                }
                AIRecords mAIRecords3 = BaseTranslationActivity.this.getMAIRecords();
                if (mAIRecords3 != null) {
                    String obj2 = StringsKt__StringsKt.oIoIXxIO(aITranslation.getDst()).toString();
                    BaseTranslationActivity baseTranslationActivity2 = BaseTranslationActivity.this;
                    if (obj2.length() == 0) {
                        AIRecords mAIRecords4 = baseTranslationActivity2.getMAIRecords();
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords4);
                        obj2 = mAIRecords4.getMExtraInfo();
                    }
                    mAIRecords3.setMExtraInfo(obj2);
                }
                BaseTranslationActivity.this.addList();
                BaseTranslationActivity.this.notifyView();
                AIRecords mAIRecords5 = BaseTranslationActivity.this.getMAIRecords();
                if (mAIRecords5 != null && (mContent = mAIRecords5.getMContent()) != null && mContent.length() > 0) {
                    BaseTranslationActivity baseTranslationActivity3 = BaseTranslationActivity.this;
                    AIRecords mAIRecords6 = baseTranslationActivity3.getMAIRecords();
                    if (mAIRecords6 != null) {
                        str = mAIRecords6.getMContent();
                    } else {
                        str = null;
                    }
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(str);
                    baseTranslationActivity3.sendTranslate(str);
                    return;
                }
                AIRecords mAIRecords7 = BaseTranslationActivity.this.getMAIRecords();
                if (mAIRecords7 != null) {
                    String string = BaseTranslationActivity.this.getString(R.string.recording_translate_error_tip);
                    kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                    mAIRecords7.setMContent(string);
                }
                AIRecords mAIRecords8 = BaseTranslationActivity.this.getMAIRecords();
                if (mAIRecords8 != null) {
                    mAIRecords8.setMExtraInfo("");
                }
                BaseTranslationActivity.this.upDataLastList();
                BaseTranslationActivity.this.notifyView();
                BaseTranslationActivity.this.saveDBRecord();
            }
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onRecordResultError(@OXOo.OOXIXo String error) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
            BaseTranslationActivity baseTranslationActivity = BaseTranslationActivity.this;
            String string = baseTranslationActivity.getString(R.string.speech_recognition_error);
            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
            String string2 = BaseTranslationActivity.this.getString(R.string.failed_in_translation);
            kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
            baseTranslationActivity.sendTranslationResult(string, string2);
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onRecordResultLanguage(@OXOo.oOoXoXO AISpeech aISpeech) {
            RecordingManager.OnRecordingCallback.DefaultImpls.onRecordResultLanguage(this, aISpeech);
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onStartRecording() {
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onStopRecording() {
            final BaseTranslationActivity baseTranslationActivity = BaseTranslationActivity.this;
            baseTranslationActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.OOXIXo
                @Override // java.lang.Runnable
                public final void run() {
                    BaseTranslationActivity.I0Io.oxoX(BaseTranslationActivity.this);
                }
            });
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements MicrosoftSDKManage.I0Io {
        public II0xO0() {
        }

        public static final void X0o0xo(BaseTranslationActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.setMContentResult("");
            this$0.showRecordingPopup();
        }

        public static final void XO(BaseTranslationActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            RecordingManager.Companion.getInstance().closeBluetooth();
            this$0.disRecordingPopup();
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            oix0oi.oIX0oI(this$0.TAG + "   onStopTransmission  isEndTranslation = " + this$0.isEndTranslation() + TokenParser.SP);
            if (this$0.isEndTranslation()) {
                boolean z = false;
                this$0.setEndTranslation(false);
                this$0.setAddListData(false);
                VoiceManager.INSTANCE.setSpeechRecRunning(false);
                if (this$0.getMContentResult().length() > 0) {
                    oix0oi.oIX0oI(this$0.TAG + "  sendTranslate onStopTransmission  content = " + this$0.getMContentResult() + TokenParser.SP);
                    this$0.sendTranslationResultInput(this$0.getMContentResult());
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this$0.TAG);
                sb.append("  sendTranslate onStopTransmission  content = ");
                if (this$0.getMContentResult().length() > 0) {
                    z = true;
                }
                sb.append(z);
                oix0oi.oIX0oI(sb.toString());
                DcsTtsPlayer.INSTANCE.stop();
                String string = this$0.getString(R.string.request_error);
                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                this$0.sendTranslationResultInput(string);
            }
        }

        public static final void oxoX(BaseTranslationActivity this$0, int i, String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "$str");
            if (!this$0.isAddListData()) {
                this$0.setAddListData(true);
                this$0.addList();
            }
            if (i == 1) {
                this$0.getMHandler().removeMessages(this$0.loadTimeOut);
                this$0.getMHandler().removeMessages(this$0.loadTimeOutToast);
                AIRecords mAIRecords = this$0.getMAIRecords();
                if (mAIRecords != null) {
                    mAIRecords.setMContent(str);
                }
                this$0.upDataLastList();
                this$0.notifyView();
            }
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onIdentifyResults(final int i, @OXOo.OOXIXo final String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "str");
            if (i == 2) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(BaseTranslationActivity.this.TAG + "  sendTranslate  onIdentifyResults content = " + str);
                BaseTranslationActivity.this.setMContentResult(str);
                BaseTranslationActivity.this.getMHandler().sendEmptyMessageDelayed(BaseTranslationActivity.this.loadTimeOut, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
            final BaseTranslationActivity baseTranslationActivity = BaseTranslationActivity.this;
            baseTranslationActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.Oxx0IOOO
                @Override // java.lang.Runnable
                public final void run() {
                    BaseTranslationActivity.II0xO0.oxoX(BaseTranslationActivity.this, i, str);
                }
            });
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onIdentifyResultsDetectedLanguage(int i, @OXOo.OOXIXo String str, @OXOo.OOXIXo String str2) {
            MicrosoftSDKManage.I0Io.oIX0oI.oIX0oI(this, i, str, str2);
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onStartTransmission() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BaseTranslationActivity.this.TAG + " onStartTransmission ");
            final BaseTranslationActivity baseTranslationActivity = BaseTranslationActivity.this;
            baseTranslationActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.II0XooXoX
                @Override // java.lang.Runnable
                public final void run() {
                    BaseTranslationActivity.II0xO0.X0o0xo(BaseTranslationActivity.this);
                }
            });
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onStopTransmission() {
            final BaseTranslationActivity baseTranslationActivity = BaseTranslationActivity.this;
            baseTranslationActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.xxIXOIIO
                @Override // java.lang.Runnable
                public final void run() {
                    BaseTranslationActivity.II0xO0.XO(BaseTranslationActivity.this);
                }
            });
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseTranslationActivity.this.delayTime -= BaseTranslationActivity.this.getUpdateInterval();
            if (BaseTranslationActivity.this.delayTime <= 0) {
                com.sma.smartv3.pop.oI0IIXIo oi0iixio = BaseTranslationActivity.this.popCountdownPopup;
                if (oi0iixio != null) {
                    oi0iixio.dismiss();
                }
                BaseTranslationActivity.this.delayTime = 3000L;
                com.sma.smartv3.pop.oI0IIXIo oi0iixio2 = BaseTranslationActivity.this.popCountdownPopup;
                if (oi0iixio2 != null) {
                    oi0iixio2.X0IIOO(String.valueOf(BaseTranslationActivity.this.delayTime / 1000));
                }
                BaseTranslationActivity.this.countdownEnd();
                return;
            }
            com.sma.smartv3.pop.oI0IIXIo oi0iixio3 = BaseTranslationActivity.this.popCountdownPopup;
            if (oi0iixio3 != null) {
                oi0iixio3.X0IIOO(String.valueOf(BaseTranslationActivity.this.delayTime / 1000));
            }
            BaseTranslationActivity.this.getMHandler().postDelayed(this, BaseTranslationActivity.this.getUpdateInterval());
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX implements Runnable {
        public oxoX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseTranslationActivity baseTranslationActivity = BaseTranslationActivity.this;
            baseTranslationActivity.setElapsedTime(baseTranslationActivity.getElapsedTime() + BaseTranslationActivity.this.getUpdateInterval());
            BaseTranslationActivity.this.updateTimerText();
            BaseTranslationActivity.this.getMHandler().postDelayed(this, BaseTranslationActivity.this.getUpdateInterval());
        }
    }

    private final void initLanguage() {
        setMLanguageTranslationList(LanguageTranslationKt.getTranslationLanguageList());
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils I0Io2 = xo0.I0Io();
        LanguageTranslationData languageTranslationData = (LanguageTranslationData) new Gson().fromJson(I0Io2.getString(com.sma.smartv3.util.XoI0Ixx0.f24365IOoo + '_' + LanguageTranslationData.class.getName()), LanguageTranslationData.class);
        if (languageTranslationData == null) {
            languageTranslationData = getMLanguageTranslationList().get(0);
        }
        setMLeftLanguage(languageTranslationData);
        SPUtils I0Io3 = xo0.I0Io();
        LanguageTranslationData languageTranslationData2 = (LanguageTranslationData) new Gson().fromJson(I0Io3.getString(com.sma.smartv3.util.XoI0Ixx0.f24442oIIxXoo + '_' + LanguageTranslationData.class.getName()), LanguageTranslationData.class);
        if (languageTranslationData2 == null) {
            languageTranslationData2 = getMLanguageTranslationList().get(1);
        }
        setMRightLanguage(languageTranslationData2);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " initLanguage mLeftLanguage = " + getMLeftLanguage() + " , mRightLanguage = " + getMRightLanguage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(BaseTranslationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startRotateAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mHandler$lambda$1(BaseTranslationActivity this$0, Message it) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
        int i = it.what;
        if (i == this$0.loadTimeOut) {
            this$0.stopRecording(true);
        } else if (i == this$0.loadTimeOutToast) {
            ToastUtils.showLong(this$0.getString(R.string.no_sound_recognized), new Object[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyView() {
        runOnUiThread(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.II0xO0
            @Override // java.lang.Runnable
            public final void run() {
                BaseTranslationActivity.notifyView$lambda$4(BaseTranslationActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyView$lambda$4(BaseTranslationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.notifyViewData();
    }

    private final void senAudioTextToDevice(BleVoice bleVoice) {
        BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.AUDIO_TEXT, BleKeyFlag.UPDATE, bleVoice, false, false, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendTranslationResultInput(final String str) {
        this.mHandler.removeMessages(this.loadTimeOut);
        this.mHandler.removeMessages(this.loadTimeOutToast);
        this.isStartAnalysis = false;
        this.mRecyclerViewAutoRefresh = true;
        if (str.length() > 0 && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(str, getString(R.string.request_error))) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("startAudioStreamInput ===> str = " + str + " , targetLang = " + this.targetLang);
            MicrosoftSDKManage.II0xO0 iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
            iI0xO0.oIX0oI().xoIxX();
            iI0xO0.oIX0oI().oXxOI0oIx(str, this.targetLang, new Oox.oOoXoXO<String, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.BaseTranslationActivity$sendTranslationResultInput$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(String str2) {
                    invoke2(str2);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo String it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    AIRecords mAIRecords = BaseTranslationActivity.this.getMAIRecords();
                    if (mAIRecords != null) {
                        String obj = StringsKt__StringsKt.oIoIXxIO(str).toString();
                        BaseTranslationActivity baseTranslationActivity = BaseTranslationActivity.this;
                        if (obj.length() == 0) {
                            AIRecords mAIRecords2 = baseTranslationActivity.getMAIRecords();
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords2);
                            obj = mAIRecords2.getMContent();
                        }
                        mAIRecords.setMContent(obj);
                    }
                    AIRecords mAIRecords3 = BaseTranslationActivity.this.getMAIRecords();
                    if (mAIRecords3 != null) {
                        String obj2 = StringsKt__StringsKt.oIoIXxIO(it).toString();
                        BaseTranslationActivity baseTranslationActivity2 = BaseTranslationActivity.this;
                        if (obj2.length() == 0) {
                            AIRecords mAIRecords4 = baseTranslationActivity2.getMAIRecords();
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords4);
                            obj2 = mAIRecords4.getMExtraInfo();
                        }
                        mAIRecords3.setMExtraInfo(obj2);
                    }
                    MicrosoftSDKManage oIX0oI2 = MicrosoftSDKManage.f24259Xx000oIo.oIX0oI();
                    AIRecords mAIRecords5 = BaseTranslationActivity.this.getMAIRecords();
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords5);
                    String mExtraInfo = mAIRecords5.getMExtraInfo();
                    AIRecords mAIRecords6 = BaseTranslationActivity.this.getMAIRecords();
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords6);
                    String ttsVoiceName = mAIRecords6.getTtsVoiceName();
                    LeftAndRightPlayControl leftAndRightPlayControl = LeftAndRightPlayControl.LEFT_AND_RIGHT;
                    AIRecords mAIRecords7 = BaseTranslationActivity.this.getMAIRecords();
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords7);
                    oIX0oI2.oo(mExtraInfo, ttsVoiceName, leftAndRightPlayControl, mAIRecords7.getMType() == 1 ? 8 : 2);
                    BaseTranslationActivity.this.setMContentResult("");
                    BaseTranslationActivity.this.upDataLastList();
                    BaseTranslationActivity.this.notifyView();
                    BaseTranslationActivity.this.saveDBRecord();
                }
            });
            return;
        }
        AIRecords aIRecords = this.mAIRecords;
        if (aIRecords != null) {
            String string = getString(R.string.recording_translate_error_tip);
            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
            aIRecords.setMContent(string);
        }
        AIRecords aIRecords2 = this.mAIRecords;
        if (aIRecords2 != null) {
            aIRecords2.setMExtraInfo("");
        }
        upDataLastList();
        notifyView();
        saveDBRecord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startRotateAnimation$lambda$3(RotateAnimation rotateAnimation, BaseTranslationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(rotateAnimation, "$rotateAnimation");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        rotateAnimation.cancel();
        this$0.getMTransformLanguageImg().clearAnimation();
        this$0.switchRotateAnimation = true;
    }

    public static /* synthetic */ void stopRecording$default(BaseTranslationActivity baseTranslationActivity, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            baseTranslationActivity.stopRecording(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopRecording");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void translateITS(String str, String str2, String str3) {
        AISparkChainManager.f19871oIX0oI.OOXIxO0(str, str2, str3, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.otherdevice.charge.BaseTranslationActivity$translateITS$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                AIRecords mAIRecords = BaseTranslationActivity.this.getMAIRecords();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords);
                String string = BaseTranslationActivity.this.getString(R.string.failed_in_translation);
                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                mAIRecords.setMExtraInfo(string);
                BaseTranslationActivity.this.upDataLastList();
                BaseTranslationActivity.this.notifyView();
                BaseTranslationActivity.this.saveDBRecord();
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str4) {
                if (str4 != null && str4.length() > 0) {
                    AIRecords mAIRecords = BaseTranslationActivity.this.getMAIRecords();
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords);
                    mAIRecords.setMExtraInfo(StringsKt__StringsKt.oIoIXxIO(str4).toString());
                    BaseTranslationActivity.this.upDataLastList();
                    BaseTranslationActivity.this.notifyView();
                    BaseTranslationActivity.this.saveDBRecord();
                    DcsTtsPlayer.play$default(DcsTtsPlayer.INSTANCE, str4, true, false, null, BaseTranslationActivity.this.getTtsVoiceName(), 12, null);
                    return;
                }
                AIRecords mAIRecords2 = BaseTranslationActivity.this.getMAIRecords();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords2);
                mAIRecords2.setMExtraInfo("translate error");
                BaseTranslationActivity.this.upDataLastList();
                BaseTranslationActivity.this.notifyView();
                BaseTranslationActivity.this.saveDBRecord();
            }
        });
    }

    public static /* synthetic */ void translateITS$default(BaseTranslationActivity baseTranslationActivity, String str, String str2, String str3, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str2 = baseTranslationActivity.lang;
            }
            if ((i & 4) != 0) {
                str3 = baseTranslationActivity.targetLang;
            }
            baseTranslationActivity.translateITS(str, str2, str3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translateITS");
    }

    public void addList() {
    }

    public final long addSendRecord(@OXOo.OOXIXo AIRecords mAIRecords) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mAIRecords, "mAIRecords");
        return this.mRecordsDao.insert(mAIRecords);
    }

    public final void closeBluetooth() {
        RecordingManager.Companion.getInstance().closeBluetooth();
    }

    public void countdownEnd() {
    }

    public void disRecordingPopup() {
    }

    public final TextView getAbhTitleCenter() {
        return (TextView) this.abhTitleCenter$delegate.getValue();
    }

    public final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final String getArsAccent() {
        return this.arsAccent;
    }

    @OXOo.OOXIXo
    public final String getArsLanguage() {
        return this.arsLanguage;
    }

    public final long getElapsedTime() {
        return this.elapsedTime;
    }

    @OXOo.OOXIXo
    public final String getLang() {
        return this.lang;
    }

    public final int getMAIFunctionType() {
        return this.mAIFunctionType;
    }

    @OXOo.oOoXoXO
    public final AIRecords getMAIRecords() {
        return this.mAIRecords;
    }

    public final int getMAIRecordsType() {
        return this.mAIRecordsType;
    }

    @OXOo.oOoXoXO
    public final LanguageTranslationData getMCacheLanguage() {
        return this.mCacheLanguage;
    }

    @OXOo.OOXIXo
    public final String getMContentResult() {
        return this.mContentResult;
    }

    @OXOo.OOXIXo
    public final Handler getMHandler() {
        return this.mHandler;
    }

    @OXOo.OOXIXo
    public final List<LanguageTranslationData> getMLanguageTranslationList() {
        List<LanguageTranslationData> list = this.mLanguageTranslationList;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("mLanguageTranslationList");
        return null;
    }

    @OXOo.OOXIXo
    public final LanguageTranslationData getMLeftLanguage() {
        LanguageTranslationData languageTranslationData = this.mLeftLanguage;
        if (languageTranslationData != null) {
            return languageTranslationData;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("mLeftLanguage");
        return null;
    }

    @OXOo.OOXIXo
    public final AIRecordsDao getMRecordsDao() {
        return this.mRecordsDao;
    }

    public final boolean getMRecyclerViewAutoRefresh() {
        return this.mRecyclerViewAutoRefresh;
    }

    @OXOo.OOXIXo
    public final LanguageTranslationData getMRightLanguage() {
        LanguageTranslationData languageTranslationData = this.mRightLanguage;
        if (languageTranslationData != null) {
            return languageTranslationData;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("mRightLanguage");
        return null;
    }

    public final ImageView getMTransformLanguageImg() {
        return (ImageView) this.mTransformLanguageImg$delegate.getValue();
    }

    public final TextView getMTransformLanguageLeftTv() {
        return (TextView) this.mTransformLanguageLeftTv$delegate.getValue();
    }

    public final TextView getMTransformLanguageRightTv() {
        return (TextView) this.mTransformLanguageRightTv$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final MicrosoftSDKManage.I0Io getMicrosoftCallBack() {
        return this.microsoftCallBack;
    }

    @OXOo.OOXIXo
    public final RecordingManager.OnRecordingCallback getRecordingCallBack() {
        return this.recordingCallBack;
    }

    @OXOo.OOXIXo
    public final Runnable getRunnable() {
        return this.runnable;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final boolean getSwitchRotateAnimation() {
        return this.switchRotateAnimation;
    }

    @OXOo.OOXIXo
    public final String getTargetLang() {
        return this.targetLang;
    }

    @OXOo.OOXIXo
    public final String getTtsTargetLang() {
        return this.ttsTargetLang;
    }

    @OXOo.OOXIXo
    public final String getTtsVoiceName() {
        return this.ttsVoiceName;
    }

    public final long getUpdateInterval() {
        return this.updateInterval;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        initLanguage();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getMTransformLanguageImg().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseTranslationActivity.initView$lambda$2(BaseTranslationActivity.this, view);
            }
        });
        getMTransformLanguageLeftTv().setText(getMLeftLanguage().getName());
        getMTransformLanguageRightTv().setText(getMRightLanguage().getName());
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        voiceManager.setActivityData(true);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XI0IXoo()) {
            MicrosoftSDKManage.IIX0(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI(), this.microsoftCallBack, null, 2, null);
        } else if (productManager.oO0OX0()) {
            RecordingManager.Companion.getInstance().setRecordingCallback(this.recordingCallBack);
        }
        voiceManager.setMListener(new BaseTranslationActivity$initView$2(this));
    }

    public final boolean isAddListData() {
        return this.isAddListData;
    }

    public final boolean isAppSend() {
        return this.isAppSend;
    }

    public final boolean isEndTranslation() {
        return this.isEndTranslation;
    }

    public final boolean isStartAnalysis() {
        return this.isStartAnalysis;
    }

    public final boolean isSteam() {
        return this.isSteam;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_ai_dialogue_translation;
    }

    public void notifyViewData() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
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
                    this.switchRotateAnimation = true;
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
            this.switchRotateAnimation = true;
            startRotateAnimation();
        }
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        DcsTtsPlayer.INSTANCE.stop();
        closeBluetooth();
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        voiceManager.setMListener(null);
        ViewModelMain viewModelMain = ViewModelMain.INSTANCE;
        Boolean value = viewModelMain.isShowSuspenWindow().getValue();
        Boolean bool = Boolean.TRUE;
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(value, bool)) {
            viewModelMain.isReSetList().postValue(bool);
            voiceManager.setActivityData(true);
        } else {
            voiceManager.setMicrosoftCallback();
            voiceManager.setActivityData(false);
        }
        com.sma.smartv3.pop.oI0IIXIo oi0iixio = this.popCountdownPopup;
        if (oi0iixio != null) {
            oi0iixio.dismiss();
        }
        RecordingManager.Companion.getInstance().closeBluetooth();
        stopRecording$default(this, false, 1, null);
        if (ProductManager.f20544oIX0oI.XI0IXoo()) {
            MicrosoftSDKManage.II0xO0 iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
            iI0xO0.oIX0oI().IO0XoXxO();
            iI0xO0.oIX0oI().x0OxxIOxX();
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public void onTranslationLanguage(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
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

    public void permission() {
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.MICROPHONE);
        kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
        String string = getString(R.string.microphone_explain_title);
        kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
        String string2 = getString(R.string.microphone_explain_content);
        kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
        oOXoIIIo.X0o0xo.II0xO0(permission, string, string2, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.BaseTranslationActivity$permission$1
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                PermissionStatus permissionStatus = PermissionStatus.GRANTED;
            }
        });
    }

    public final void removeCountdownPopup() {
        this.mHandler.removeCallbacks(this.countdownRunnable);
        com.sma.smartv3.pop.oI0IIXIo oi0iixio = this.popCountdownPopup;
        if (oi0iixio != null) {
            oi0iixio.dismiss();
        }
    }

    public void saveDBRecord() {
        String str;
        String mExtraInfo;
        AIRecords aIRecords = this.mAIRecords;
        String str2 = "null";
        if (aIRecords == null || (str = aIRecords.getMContent()) == null) {
            str = "null";
        }
        AIRecords aIRecords2 = this.mAIRecords;
        if (aIRecords2 != null && (mExtraInfo = aIRecords2.getMExtraInfo()) != null) {
            str2 = mExtraInfo;
        }
        sendTranslationResult(str, str2);
    }

    public final void sendTranslate(@OXOo.OOXIXo final String content) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + "  sendTranslate  content = " + content + " lang = " + this.lang + ", targetLang = " + this.targetLang);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XI0IXoo()) {
            sendTranslationResultInput(content);
            return;
        }
        if (productManager.oO0OX0()) {
            DcsTtsPlayer.INSTANCE.initSegmentation();
            xoIXOxX.II0xO0.I0Io(true, false, null, null, 0, new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.BaseTranslationActivity$sendTranslate$1
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
                    if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(BaseTranslationActivity.this.getLang(), "cn") && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(BaseTranslationActivity.this.getTargetLang(), "cn")) {
                        AISparkChainManager aISparkChainManager = AISparkChainManager.f19871oIX0oI;
                        final BaseTranslationActivity baseTranslationActivity = BaseTranslationActivity.this;
                        xxxI.II0xO0<String> iI0xO0 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.otherdevice.charge.BaseTranslationActivity$sendTranslate$1.1
                            @Override // xxxI.II0xO0
                            public void handleError(@OXOo.OOXIXo String error) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                                OI0.oIX0oI.f1507oIX0oI.II0xO0(BaseTranslationActivity.this.TAG + " handleError error = " + error);
                                AIRecords mAIRecords = BaseTranslationActivity.this.getMAIRecords();
                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords);
                                String string = BaseTranslationActivity.this.getString(R.string.failed_in_translation);
                                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                                mAIRecords.setMExtraInfo(string);
                                BaseTranslationActivity.this.upDataLastList();
                                BaseTranslationActivity.this.notifyView();
                                BaseTranslationActivity.this.saveDBRecord();
                            }

                            @Override // xxxI.II0xO0
                            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                            public void handleResponse(@OXOo.oOoXoXO String str) {
                                if (str != null && str.length() > 0) {
                                    BaseTranslationActivity baseTranslationActivity2 = BaseTranslationActivity.this;
                                    baseTranslationActivity2.translateITS(str, "cn", baseTranslationActivity2.getTargetLang());
                                    return;
                                }
                                AIRecords mAIRecords = BaseTranslationActivity.this.getMAIRecords();
                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords);
                                String string = BaseTranslationActivity.this.getString(R.string.failed_in_translation);
                                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                                mAIRecords.setMExtraInfo(string);
                                BaseTranslationActivity.this.upDataLastList();
                                BaseTranslationActivity.this.notifyView();
                                BaseTranslationActivity.this.saveDBRecord();
                            }
                        };
                        aISparkChainManager.OOXIxO0(content, BaseTranslationActivity.this.getLang(), "cn", iI0xO0);
                        return;
                    }
                    BaseTranslationActivity.translateITS$default(BaseTranslationActivity.this, content, null, null, 6, null);
                }
            }, 30, null);
            return;
        }
        AIRecords aIRecords = this.mAIRecords;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(aIRecords);
        aIRecords.setMExtraInfo("AI " + getString(R.string.earphone_key_turn_off_translation));
        upDataLastList();
        notifyView();
    }

    public final void sendTranslationResult(@OXOo.OOXIXo String inputText, @OXOo.OOXIXo String outputText) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(inputText, "inputText");
        kotlin.jvm.internal.IIX0o.x0xO0oo(outputText, "outputText");
        senAudioTextToDevice(new BleVoice(0, System.currentTimeMillis(), StringsKt__StringsKt.oIoIXxIO(inputText).toString(), 0, 8, null));
        senAudioTextToDevice(new BleVoice(1, System.currentTimeMillis(), StringsKt__StringsKt.oIoIXxIO(outputText).toString(), 0, 8, null));
    }

    public final void setAddListData(boolean z) {
        this.isAddListData = z;
    }

    public final void setAppSend(boolean z) {
        this.isAppSend = z;
    }

    public final void setArsAccent(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.arsAccent = str;
    }

    public final void setArsLanguage(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.arsLanguage = str;
    }

    public final void setElapsedTime(long j) {
        this.elapsedTime = j;
    }

    public final void setEndTranslation(boolean z) {
        this.isEndTranslation = z;
    }

    public final void setLang(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.lang = str;
    }

    public final void setLangAndVoice() {
        DcsTtsPlayer.INSTANCE.deleteReplayMusic();
        if (this.mAIRecordsType == 1) {
            this.lang = getMRightLanguage().getRtasrLanguage();
            this.isSupportTransfer = getMRightLanguage().isSupportTransfer();
            this.arsLanguage = getMRightLanguage().getAsrLanguage();
            this.arsAccent = getMRightLanguage().getAccent();
            this.targetLang = getMLeftLanguage().getRtasrLanguage();
            this.ttsVoiceName = getMLeftLanguage().getTtsViuceName();
            this.ttsTargetLang = getMLeftLanguage().getAsrLanguage();
            return;
        }
        this.lang = getMLeftLanguage().getRtasrLanguage();
        this.isSupportTransfer = getMLeftLanguage().isSupportTransfer();
        this.arsLanguage = getMLeftLanguage().getAsrLanguage();
        this.arsAccent = getMLeftLanguage().getAccent();
        this.targetLang = getMRightLanguage().getRtasrLanguage();
        this.ttsVoiceName = getMRightLanguage().getTtsViuceName();
        this.ttsTargetLang = getMRightLanguage().getAsrLanguage();
    }

    public final void setMAIFunctionType(int i) {
        this.mAIFunctionType = i;
    }

    public final void setMAIRecords(@OXOo.oOoXoXO AIRecords aIRecords) {
        this.mAIRecords = aIRecords;
    }

    public final void setMAIRecordsType(int i) {
        this.mAIRecordsType = i;
    }

    public final void setMCacheLanguage(@OXOo.oOoXoXO LanguageTranslationData languageTranslationData) {
        this.mCacheLanguage = languageTranslationData;
    }

    public final void setMContentResult(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.mContentResult = str;
    }

    public final void setMLanguageTranslationList(@OXOo.OOXIXo List<LanguageTranslationData> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<set-?>");
        this.mLanguageTranslationList = list;
    }

    public final void setMLeftLanguage(@OXOo.OOXIXo LanguageTranslationData languageTranslationData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(languageTranslationData, "<set-?>");
        this.mLeftLanguage = languageTranslationData;
    }

    public final void setMRecyclerViewAutoRefresh(boolean z) {
        this.mRecyclerViewAutoRefresh = z;
    }

    public final void setMRightLanguage(@OXOo.OOXIXo LanguageTranslationData languageTranslationData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(languageTranslationData, "<set-?>");
        this.mRightLanguage = languageTranslationData;
    }

    public final void setStartAnalysis(boolean z) {
        this.isStartAnalysis = z;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    public final void setSteam(boolean z) {
        this.isSteam = z;
    }

    public final void setSwitchRotateAnimation(boolean z) {
        this.switchRotateAnimation = z;
    }

    public final void setTargetLang(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.targetLang = str;
    }

    public final void setTtsTargetLang(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.ttsTargetLang = str;
    }

    public final void setTtsVoiceName(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.ttsVoiceName = str;
    }

    public final void showCountdownPopup(@OXOo.OOXIXo View rootView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(rootView, "rootView");
        this.delayTime = 3000L;
        if (this.popCountdownPopup == null) {
            com.sma.smartv3.pop.oI0IIXIo oi0iixio = new com.sma.smartv3.pop.oI0IIXIo(this);
            oi0iixio.X0IIOO(String.valueOf(this.delayTime / 1000));
            oi0iixio.x0xO0oo(false);
            this.popCountdownPopup = oi0iixio;
        }
        com.sma.smartv3.pop.oI0IIXIo oi0iixio2 = this.popCountdownPopup;
        if (oi0iixio2 != null) {
            oi0iixio2.xoXoI(rootView);
        }
        this.mHandler.postDelayed(this.countdownRunnable, this.updateInterval);
    }

    public void showRecordingPopup() {
    }

    public void startRecording() {
        this.mAIRecords = new AIRecords(0, 0L, null, this.mAIFunctionType, this.mAIRecordsType, "", null, 0, 0, 0, null, null, null, null, null, 0, this.ttsVoiceName, 65479, null);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XI0IXoo()) {
            if (!this.isStartAnalysis) {
                this.isEndTranslation = false;
                this.isStartAnalysis = true;
                MicrosoftSDKManage.O0(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI(), this.arsLanguage, true, this.ttsVoiceName, this.ttsTargetLang, false, null, 32, null);
                return;
            }
            return;
        }
        if (productManager.oO0OX0()) {
            RecordingManager.recordPermission$default(RecordingManager.Companion.getInstance(), this.recordingCallBack, false, false, this.TAG, 6, null);
        }
    }

    public void startRotateAnimation() {
        if (this.switchRotateAnimation) {
            getMTransformLanguageImg().clearAnimation();
            CharSequence text = getMTransformLanguageLeftTv().getText();
            CharSequence text2 = getMTransformLanguageRightTv().getText();
            final RotateAnimation rotateAnimation = new RotateAnimation(360.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(500L);
            rotateAnimation.setRepeatCount(-1);
            this.switchRotateAnimation = false;
            getMTransformLanguageImg().startAnimation(rotateAnimation);
            getMTransformLanguageLeftTv().setText(text2);
            getMTransformLanguageRightTv().setText(text);
            this.mCacheLanguage = getMLeftLanguage();
            setMLeftLanguage(getMRightLanguage());
            LanguageTranslationData languageTranslationData = this.mCacheLanguage;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(languageTranslationData);
            setMRightLanguage(languageTranslationData);
            com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
            xo0.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24365IOoo + '_' + LanguageTranslationData.class.getName(), new Gson().toJson(getMLeftLanguage()));
            xo0.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24442oIIxXoo + '_' + LanguageTranslationData.class.getName(), new Gson().toJson(getMRightLanguage()));
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24627oI, null, 2, null);
            this.mHandler.postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.oIX0oI
                @Override // java.lang.Runnable
                public final void run() {
                    BaseTranslationActivity.startRotateAnimation$lambda$3(rotateAnimation, this);
                }
            }, 500L);
        }
    }

    public final void stopRecording(boolean z) {
        if (ProductManager.f20544oIX0oI.XI0IXoo()) {
            if (z) {
                this.isEndTranslation = true;
                RecordingManager.Companion.getInstance().setRecording(false);
                MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().x0();
            }
            this.mHandler.removeMessages(this.loadTimeOut);
            this.mHandler.removeMessages(this.loadTimeOutToast);
            MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().x0OxxIOxX();
            return;
        }
        RecordingManager.Companion.getInstance().stopRecording();
    }

    public void upDataLastList() {
    }

    public void updateTimerText() {
    }
}
