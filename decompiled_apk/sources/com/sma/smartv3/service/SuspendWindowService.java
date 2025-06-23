package com.sma.smartv3.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.Observer;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.biz.AISparkChainManager;
import com.sma.smartv3.biz.voice.DcsTtsPlayer;
import com.sma.smartv3.biz.voice.RecordingManager;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AISpeech;
import com.sma.smartv3.model.AITranslation;
import com.sma.smartv3.model.LanguageTranslationData;
import com.sma.smartv3.model.LanguageTranslationKt;
import com.sma.smartv3.model.ViewModelMain;
import com.sma.smartv3.service.SuspendWindowService;
import com.sma.smartv3.ui.main.MainActivity;
import com.sma.smartv3.util.MicrosoftSDKManage;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.view.FloatFrameLayout;
import com.szabh.smable3.entity.BleVoice;
import com.szabh.smable3.entity.Languages;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XI0IXoo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nSuspendWindowService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuspendWindowService.kt\ncom/sma/smartv3/service/SuspendWindowService\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,1024:1\n90#2:1025\n90#2:1026\n470#3:1027\n*S KotlinDebug\n*F\n+ 1 SuspendWindowService.kt\ncom/sma/smartv3/service/SuspendWindowService\n*L\n445#1:1025\n449#1:1026\n856#1:1027\n*E\n"})
/* loaded from: classes12.dex */
public final class SuspendWindowService extends LifecycleService {
    public View bottom_line;
    private boolean broadcastCheckStatus;
    public CheckBox broadcast_check;
    public ClipboardManager clipboard;
    public FrameLayout fl_recording;

    @OXOo.oOoXoXO
    private FloatFrameLayout floatRootView;
    public ImageView img_close;
    public ImageView img_record;
    public ImageView img_record_show;
    public ImageView img_recording;
    public ImageView img_recording_animation;
    private boolean isAddListData;
    private boolean isEndTranslation;
    private boolean isShow;
    private boolean isShowRecordImg;
    private boolean isStartAnalysis;
    public View ll_hide_content;
    public LinearLayout ll_show_set;
    public List<LanguageTranslationData> mLanguageTranslationList;
    public LanguageTranslationData mLeftLanguage;
    public LanguageTranslationData mRightLanguage;
    private boolean onlyshowTranslate;
    public CheckBox original_check;
    public AnimationDrawable recordAnimation;
    public View rl_show_all;
    public View root;
    private boolean showOriginalTextStatus;
    private boolean translateCheckStatus;
    public CheckBox translate_check;
    public TextView tv_original_t;
    public TextView tv_translate;
    public TextView tv_translate_t;

    @OXOo.oOoXoXO
    private WindowManager windowManager;

    @OXOo.OOXIXo
    private final String TAG = "SuspendWindowService";

    @OXOo.OOXIXo
    private final String CHANNEL_ID = "recording_channel";
    private final int NOTIFICATION_ID = 101;

    @OXOo.OOXIXo
    private final Handler handle = new Handler(Looper.getMainLooper());

    @OXOo.OOXIXo
    private String mContentResult = "";

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
    private String mContent = "";

    @OXOo.OOXIXo
    private String mExtraInfo = "";

    @OXOo.OOXIXo
    private final MicrosoftSDKManage.I0Io microsoftCallBack = new X0o0xo();

    @OXOo.OOXIXo
    private final RecordingManager.OnRecordingCallback recordingCallBack = new XO();

    /* loaded from: classes12.dex */
    public static final class I0Io implements Runnable {
        public I0Io() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SuspendWindowService.this.showBg(false);
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f21588II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f21589oIX0oI;

        /* JADX WARN: Multi-variable type inference failed */
        public II0xO0() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ II0xO0 oxoX(II0xO0 iI0xO0, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = iI0xO0.f21589oIX0oI;
            }
            if ((i & 2) != 0) {
                str2 = iI0xO0.f21588II0xO0;
            }
            return iI0xO0.I0Io(str, str2);
        }

        @OXOo.OOXIXo
        public final II0xO0 I0Io(@OXOo.OOXIXo String mContent, @OXOo.OOXIXo String mExtraInfo) {
            IIX0o.x0xO0oo(mContent, "mContent");
            IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
            return new II0xO0(mContent, mExtraInfo);
        }

        public final void II0XooXoX(@OXOo.OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.f21588II0xO0 = str;
        }

        @OXOo.OOXIXo
        public final String II0xO0() {
            return this.f21588II0xO0;
        }

        public final void Oxx0IOOO(@OXOo.OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.f21589oIX0oI = str;
        }

        @OXOo.OOXIXo
        public final String X0o0xo() {
            return this.f21589oIX0oI;
        }

        @OXOo.OOXIXo
        public final String XO() {
            return this.f21588II0xO0;
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof II0xO0)) {
                return false;
            }
            II0xO0 iI0xO0 = (II0xO0) obj;
            return IIX0o.Oxx0IOOO(this.f21589oIX0oI, iI0xO0.f21589oIX0oI) && IIX0o.Oxx0IOOO(this.f21588II0xO0, iI0xO0.f21588II0xO0);
        }

        public int hashCode() {
            return (this.f21589oIX0oI.hashCode() * 31) + this.f21588II0xO0.hashCode();
        }

        @OXOo.OOXIXo
        public final String oIX0oI() {
            return this.f21589oIX0oI;
        }

        @OXOo.OOXIXo
        public String toString() {
            return "TranslateDate(mContent=" + this.f21589oIX0oI + ", mExtraInfo=" + this.f21588II0xO0 + HexStringBuilder.COMMENT_END_CHAR;
        }

        public II0xO0(@OXOo.OOXIXo String mContent, @OXOo.OOXIXo String mExtraInfo) {
            IIX0o.x0xO0oo(mContent, "mContent");
            IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
            this.f21589oIX0oI = mContent;
            this.f21588II0xO0 = mExtraInfo;
        }

        public /* synthetic */ II0xO0(String str, String str2, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
        }
    }

    /* loaded from: classes12.dex */
    public static final class Oxx0IOOO implements Observer, XI0IXoo {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO f21590XO;

        public Oxx0IOOO(Oox.oOoXoXO function) {
            IIX0o.x0xO0oo(function, "function");
            this.f21590XO = function;
        }

        public final boolean equals(@OXOo.oOoXoXO Object obj) {
            if ((obj instanceof Observer) && (obj instanceof XI0IXoo)) {
                return IIX0o.Oxx0IOOO(getFunctionDelegate(), ((XI0IXoo) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.XI0IXoo
        @OXOo.OOXIXo
        public final kotlin.IIXOooo<?> getFunctionDelegate() {
            return this.f21590XO;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21590XO.invoke(obj);
        }
    }

    /* loaded from: classes12.dex */
    public static final class X0o0xo implements MicrosoftSDKManage.I0Io {
        public X0o0xo() {
        }

        public static final void X0o0xo(SuspendWindowService this$0) {
            IIX0o.x0xO0oo(this$0, "this$0");
            this$0.setMContentResult("");
            this$0.showRecordingPopup();
        }

        public static final void XO(SuspendWindowService this$0) {
            IIX0o.x0xO0oo(this$0, "this$0");
            this$0.disRecordingPopup();
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            oix0oi.oIX0oI(this$0.TAG + "   onStopTransmission  isEndTranslation = " + this$0.isEndTranslation() + TokenParser.SP);
            boolean z = false;
            this$0.showRecordingPopup(false);
            if (this$0.isEndTranslation()) {
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
                IIX0o.oO(string, "getString(...)");
                this$0.sendTranslationResultInput(string);
            }
        }

        public static final void oxoX(int i, SuspendWindowService this$0, String str) {
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(str, "$str");
            if (i == 1) {
                this$0.setMContent(str);
                this$0.getTv_original_t().setText(str);
                this$0.getTv_original_t().setVisibility(0);
                if (!this$0.isAddListData()) {
                    this$0.setAddListData(true);
                }
            }
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onIdentifyResults(final int i, @OXOo.OOXIXo final String str) {
            IIX0o.x0xO0oo(str, "str");
            if (i == 2) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(SuspendWindowService.this.TAG + "  sendTranslate  onIdentifyResults content = " + str);
                SuspendWindowService.this.setMContentResult(str);
            }
            Handler handler = SuspendWindowService.this.handle;
            final SuspendWindowService suspendWindowService = SuspendWindowService.this;
            handler.post(new Runnable() { // from class: com.sma.smartv3.service.OxxIIOOXO
                @Override // java.lang.Runnable
                public final void run() {
                    SuspendWindowService.X0o0xo.oxoX(i, suspendWindowService, str);
                }
            });
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onIdentifyResultsDetectedLanguage(int i, @OXOo.OOXIXo String str, @OXOo.OOXIXo String str2) {
            MicrosoftSDKManage.I0Io.oIX0oI.oIX0oI(this, i, str, str2);
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onStartTransmission() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(SuspendWindowService.this.TAG + " onStartTransmission ");
            Handler handler = SuspendWindowService.this.handle;
            final SuspendWindowService suspendWindowService = SuspendWindowService.this;
            handler.post(new Runnable() { // from class: com.sma.smartv3.service.oI0IIXIo
                @Override // java.lang.Runnable
                public final void run() {
                    SuspendWindowService.X0o0xo.X0o0xo(SuspendWindowService.this);
                }
            });
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onStopTransmission() {
            Handler handler = SuspendWindowService.this.handle;
            final SuspendWindowService suspendWindowService = SuspendWindowService.this;
            handler.post(new Runnable() { // from class: com.sma.smartv3.service.IIXOooo
                @Override // java.lang.Runnable
                public final void run() {
                    SuspendWindowService.X0o0xo.XO(SuspendWindowService.this);
                }
            });
        }
    }

    /* loaded from: classes12.dex */
    public static final class XO implements RecordingManager.OnRecordingCallback {
        public XO() {
        }

        public static final void X0o0xo(SuspendWindowService this$0) {
            IIX0o.x0xO0oo(this$0, "this$0");
            this$0.showRecordingPopup();
        }

        public static final void XO(SuspendWindowService this$0) {
            IIX0o.x0xO0oo(this$0, "this$0");
            this$0.disRecordingPopup();
        }

        public static final void oxoX(SuspendWindowService this$0) {
            IIX0o.x0xO0oo(this$0, "this$0");
            this$0.showRecordingPopup();
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onBeforeRecording() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(SuspendWindowService.this.TAG + " onBeforeRecording ");
            Handler handler = SuspendWindowService.this.handle;
            final SuspendWindowService suspendWindowService = SuspendWindowService.this;
            handler.post(new Runnable() { // from class: com.sma.smartv3.service.xoXoI
                @Override // java.lang.Runnable
                public final void run() {
                    SuspendWindowService.XO.oxoX(SuspendWindowService.this);
                }
            });
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onRecordResult(@OXOo.oOoXoXO AITranslation aITranslation) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(SuspendWindowService.this.TAG + " onRecordResult result = " + aITranslation);
            if (aITranslation != null && aITranslation.getStatus() == 2) {
                DcsTtsPlayer.INSTANCE.stop();
                SuspendWindowService.this.setMContent(StringsKt__StringsKt.oIoIXxIO(aITranslation.getText()).toString());
                SuspendWindowService.this.setMExtraInfo(StringsKt__StringsKt.oIoIXxIO(aITranslation.getDst()).toString());
                if (SuspendWindowService.this.getMContent().length() > 0) {
                    SuspendWindowService suspendWindowService = SuspendWindowService.this;
                    suspendWindowService.sendTranslate(suspendWindowService.getMContent());
                }
            }
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onRecordResultError(@OXOo.OOXIXo String error) {
            IIX0o.x0xO0oo(error, "error");
            SuspendWindowService suspendWindowService = SuspendWindowService.this;
            String string = suspendWindowService.getString(R.string.speech_recognition_error);
            IIX0o.oO(string, "getString(...)");
            String string2 = SuspendWindowService.this.getString(R.string.failed_in_translation);
            IIX0o.oO(string2, "getString(...)");
            suspendWindowService.sendTranslationResult(string, string2);
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onRecordResultLanguage(@OXOo.oOoXoXO AISpeech aISpeech) {
            RecordingManager.OnRecordingCallback.DefaultImpls.onRecordResultLanguage(this, aISpeech);
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onStartRecording() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(SuspendWindowService.this.TAG + " onStartRecording ");
            Handler handler = SuspendWindowService.this.handle;
            final SuspendWindowService suspendWindowService = SuspendWindowService.this;
            handler.post(new Runnable() { // from class: com.sma.smartv3.service.o00
                @Override // java.lang.Runnable
                public final void run() {
                    SuspendWindowService.XO.X0o0xo(SuspendWindowService.this);
                }
            });
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onStopRecording() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(SuspendWindowService.this.TAG + " onStartRecording ");
            Handler handler = SuspendWindowService.this.handle;
            final SuspendWindowService suspendWindowService = SuspendWindowService.this;
            handler.post(new Runnable() { // from class: com.sma.smartv3.service.OxI
                @Override // java.lang.Runnable
                public final void run() {
                    SuspendWindowService.XO.XO(SuspendWindowService.this);
                }
            });
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements View.OnTouchListener {

        /* renamed from: IXxxXO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final String f21593IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        @OXOo.OOXIXo
        public final WindowManager f21594Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public int f21595Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final WindowManager.LayoutParams f21596XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public int f21597oI0IIXIo;

        public oIX0oI(@OXOo.OOXIXo WindowManager.LayoutParams wl, @OXOo.OOXIXo WindowManager windowManager) {
            IIX0o.x0xO0oo(wl, "wl");
            IIX0o.x0xO0oo(windowManager, "windowManager");
            this.f21596XO = wl;
            this.f21594Oo = windowManager;
            this.f21593IXxxXO = "ItemViewTouchListener";
        }

        @OXOo.OOXIXo
        public final WindowManager.LayoutParams II0xO0() {
            return this.f21596XO;
        }

        @OXOo.OOXIXo
        public final WindowManager oIX0oI() {
            return this.f21594Oo;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@OXOo.OOXIXo View view, @OXOo.OOXIXo MotionEvent motionEvent) {
            IIX0o.x0xO0oo(view, "view");
            IIX0o.x0xO0oo(motionEvent, "motionEvent");
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            oix0oi.oIX0oI(this.f21593IXxxXO + " onTouch event = " + motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    int rawX = (int) motionEvent.getRawX();
                    int rawY = (int) motionEvent.getRawY();
                    int i = this.f21597oI0IIXIo;
                    if (i != 0) {
                        int i2 = rawX - this.f21595Oxx0xo;
                        int i3 = rawY - i;
                        oix0oi.oIX0oI(this.f21593IXxxXO + " movedX = " + i2 + " , movedY = " + i3 + " , x = " + this.f21595Oxx0xo + " , y = " + this.f21597oI0IIXIo + " , nowX = " + rawX + " , nowY = " + rawY);
                        WindowManager.LayoutParams layoutParams = this.f21596XO;
                        layoutParams.x = layoutParams.x + i2;
                        layoutParams.y = layoutParams.y + i3;
                        WindowManager windowManager = this.f21594Oo;
                        if (windowManager != null) {
                            windowManager.updateViewLayout(view, layoutParams);
                        }
                    }
                    this.f21595Oxx0xo = rawX;
                    this.f21597oI0IIXIo = rawY;
                    return false;
                }
                return false;
            }
            this.f21595Oxx0xo = (int) motionEvent.getRawX();
            this.f21597oI0IIXIo = (int) motionEvent.getRawY();
            return false;
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX implements Runnable {
        public oxoX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SuspendWindowService.this.showBg(false);
        }
    }

    private final Notification buildNotification() {
        Notification build = new NotificationCompat.Builder(this, this.CHANNEL_ID).setSmallIcon(R.mipmap.ic_launcher).setContentTitle(getString(R.string.recording_services)).setContentText(getString(R.string.recording_in_the_background)).setOngoing(true).setPriority(1).setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) MainActivity.class), 67108864)).build();
        IIX0o.oO(build, "build(...)");
        return build;
    }

    private final void createNotificationChannel() {
        Object systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            androidx.media2.session.II0XooXoX.oIX0oI();
            NotificationChannel oIX0oI2 = androidx.media2.session.Oxx0IOOO.oIX0oI(this.CHANNEL_ID, getString(R.string.recording_services), 2);
            systemService = getSystemService(NotificationManager.class);
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(oIX0oI2);
            }
        }
    }

    private final void initLanguage() {
        setMLanguageTranslationList(LanguageTranslationKt.getTranslationLanguageList());
        Xo0 xo0 = Xo0.f24349oIX0oI;
        SPUtils I0Io2 = xo0.I0Io();
        LanguageTranslationData languageTranslationData = (LanguageTranslationData) new Gson().fromJson(I0Io2.getString(XoI0Ixx0.f24365IOoo + '_' + LanguageTranslationData.class.getName()), LanguageTranslationData.class);
        if (languageTranslationData == null) {
            languageTranslationData = getMLanguageTranslationList().get(0);
        }
        setMLeftLanguage(languageTranslationData);
        SPUtils I0Io3 = xo0.I0Io();
        LanguageTranslationData languageTranslationData2 = (LanguageTranslationData) new Gson().fromJson(I0Io3.getString(XoI0Ixx0.f24442oIIxXoo + '_' + LanguageTranslationData.class.getName()), LanguageTranslationData.class);
        if (languageTranslationData2 == null) {
            languageTranslationData2 = getMLanguageTranslationList().get(1);
        }
        setMRightLanguage(languageTranslationData2);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " initLanguage mLeftLanguage = " + getMLeftLanguage() + " , mRightLanguage = " + getMRightLanguage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$10(SuspendWindowService this$0, CompoundButton compoundButton, boolean z) {
        int i;
        IIX0o.x0xO0oo(this$0, "this$0");
        Log.d(this$0.TAG, "original_check: " + z);
        Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24384O0xxXxI, z);
        this$0.showOriginalTextStatus = z;
        this$0.setRecordText();
        CheckBox original_check = this$0.getOriginal_check();
        if (this$0.showOriginalTextStatus) {
            i = R.string.show_original_text;
        } else {
            i = R.string.show_translation_result;
        }
        original_check.setText(this$0.getString(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$11(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$12(SuspendWindowService this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.showBg(true);
        this$0.handle.postDelayed(new I0Io(), 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$13(SuspendWindowService this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.showBg(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(SuspendWindowService this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getTv_translate().setText(R.string.enter_content);
        this$0.getTv_original_t().setText("");
        this$0.getTv_translate_t().setText("");
        this$0.setLaunguage();
        StringBuilder sb = new StringBuilder();
        sb.append("isRecording = ");
        RecordingManager.Companion companion = RecordingManager.Companion;
        sb.append(companion.getInstance().isRecording());
        LogUtils.d(sb.toString());
        if (companion.getInstance().isRecording()) {
            this$0.stopRecording(true);
            DcsTtsPlayer.INSTANCE.stop();
        }
        this$0.showRecordingPopup(true);
        VoiceManager.INSTANCE.setRecordBluetooth(false);
        this$0.clickDownRecording(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(SuspendWindowService this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        StringBuilder sb = new StringBuilder();
        sb.append("isRecording = ");
        RecordingManager.Companion companion = RecordingManager.Companion;
        sb.append(companion.getInstance().isRecording());
        LogUtils.d(sb.toString());
        if (companion.getInstance().isRecording()) {
            this$0.stopRecording(true);
            DcsTtsPlayer.INSTANCE.stop();
        }
        this$0.showRecordingPopup(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(SuspendWindowService this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        Log.d(this$0.TAG, "img_close: ");
        Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24499xxxI, false);
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24573IXO, null, 2, null);
        ViewModelMain.INSTANCE.isShowSuspenWindow().postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(SuspendWindowService this$0, CompoundButton compoundButton, boolean z) {
        IIX0o.x0xO0oo(this$0, "this$0");
        Log.d(this$0.TAG, "translate_check: " + z);
        Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24378O00, z);
        this$0.translateCheckStatus = z;
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24581Ix00oIoI, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(SuspendWindowService this$0, CompoundButton compoundButton, boolean z) {
        IIX0o.x0xO0oo(this$0, "this$0");
        Log.d(this$0.TAG, "broadcast_check: " + z);
        Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24481xOOxIO, z);
        this$0.broadcastCheckStatus = z;
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24585O0IxXx, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendChainAiTranslationResultInput(final String str) {
        if (!this.translateCheckStatus) {
            this.handle.post(new Runnable() { // from class: com.sma.smartv3.service.xxIXOIIO
                @Override // java.lang.Runnable
                public final void run() {
                    SuspendWindowService.sendChainAiTranslationResultInput$lambda$15(SuspendWindowService.this, str);
                }
            });
            return;
        }
        AISparkChainManager aISparkChainManager = AISparkChainManager.f19871oIX0oI;
        aISparkChainManager.xXOx(true);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " sendChainAiTranslationResultInput str = " + str + " , lang = " + this.lang + " , targetLang = " + this.targetLang);
        this.mContent = StringsKt__StringsKt.oIoIXxIO(str).toString();
        if (!IIX0o.Oxx0IOOO(this.lang, "cn") && !IIX0o.Oxx0IOOO(this.targetLang, "cn")) {
            aISparkChainManager.OOXIxO0(str, this.lang, "cn", new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.service.SuspendWindowService$sendChainAiTranslationResultInput$2
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    OI0.oIX0oI.f1507oIX0oI.II0xO0(SuspendWindowService.this.TAG + " handleError error = " + error);
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO String str2) {
                    if (str2 != null && str2.length() > 0) {
                        SuspendWindowService suspendWindowService = SuspendWindowService.this;
                        suspendWindowService.translateITS(str2, "cn", suspendWindowService.getTargetLang());
                    }
                }
            });
            return;
        }
        LogUtils.d(this.TAG + " sendChainAiTranslationResultInput str = " + str + " , lang = " + this.lang + " , targetLang = " + this.targetLang);
        translateITS$default(this, str, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendChainAiTranslationResultInput$lambda$15(SuspendWindowService this$0, String str) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(str, "$str");
        this$0.getTv_translate_t().setVisibility(0);
        if (!this$0.onlyshowTranslate) {
            this$0.getClipboard().setPrimaryClip(ClipData.newPlainText("aura", str));
        }
        this$0.mContent = str;
        this$0.mExtraInfo = "";
        this$0.setRecordText();
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24579IoXIXo, new II0xO0(this$0.mContent, this$0.mExtraInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendTranslationResultInput(final String str) {
        if (!this.translateCheckStatus) {
            this.handle.post(new Runnable() { // from class: com.sma.smartv3.service.xoIox
                @Override // java.lang.Runnable
                public final void run() {
                    SuspendWindowService.sendTranslationResultInput$lambda$14(SuspendWindowService.this, str);
                }
            });
            return;
        }
        if (str.length() > 0 && !IIX0o.Oxx0IOOO(str, UtilsKt.oI0IIXIo(R.string.request_error))) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("startAudioStreamInput ===> str = " + str + " , targetLang = " + this.targetLang);
            MicrosoftSDKManage.II0xO0 iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
            iI0xO0.oIX0oI().xoIxX();
            iI0xO0.oIX0oI().oXxOI0oIx(str, this.targetLang, new Oox.oOoXoXO<String, oXIO0o0XI>() { // from class: com.sma.smartv3.service.SuspendWindowService$sendTranslationResultInput$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(String str2) {
                    invoke2(str2);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo String it) {
                    boolean z;
                    IIX0o.x0xO0oo(it, "it");
                    LogUtils.d(SuspendWindowService.this.TAG + " sendTranslationResultInput it = " + it);
                    SuspendWindowService.this.setMContent(StringsKt__StringsKt.oIoIXxIO(str).toString());
                    SuspendWindowService.this.setMExtraInfo(StringsKt__StringsKt.oIoIXxIO(it).toString());
                    com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24579IoXIXo, new SuspendWindowService.II0xO0(SuspendWindowService.this.getMContent(), SuspendWindowService.this.getMExtraInfo()));
                    SuspendWindowService.this.getTv_translate_t().setVisibility(0);
                    SuspendWindowService.this.setRecordText();
                    z = SuspendWindowService.this.onlyshowTranslate;
                    if (z) {
                        SuspendWindowService.this.getClipboard().setPrimaryClip(ClipData.newPlainText("aura", String.valueOf(SuspendWindowService.this.getMExtraInfo())));
                    } else {
                        SuspendWindowService.this.getClipboard().setPrimaryClip(ClipData.newPlainText("aura", SuspendWindowService.this.getMExtraInfo() + "\n(" + SuspendWindowService.this.getMContent() + HexStringBuilder.COMMENT_END_CHAR));
                    }
                    SuspendWindowService.this.voiceMicrosoft(it);
                    SuspendWindowService.this.saveDBRecord();
                    SuspendWindowService.this.sendTranslationResult();
                }
            });
            return;
        }
        this.mContent = "";
        this.mExtraInfo = "";
        getClipboard().setPrimaryClip(ClipData.newPlainText("aura", this.mContent));
        ToastUtils.showShort(getString(R.string.request_error), new Object[0]);
        saveDBRecord();
        sendTranslationResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendTranslationResultInput$lambda$14(SuspendWindowService this$0, String str) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(str, "$str");
        this$0.getTv_translate_t().setVisibility(0);
        if (str.length() > 0 && !IIX0o.Oxx0IOOO(str, UtilsKt.oI0IIXIo(R.string.request_error))) {
            this$0.mContent = str;
        } else {
            this$0.mContent = "";
        }
        if (!this$0.onlyshowTranslate) {
            this$0.getClipboard().setPrimaryClip(ClipData.newPlainText("aura", this$0.mContent));
        }
        this$0.mExtraInfo = "";
        this$0.setRecordText();
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24579IoXIXo, new II0xO0(this$0.mContent, this$0.mExtraInfo));
    }

    public static /* synthetic */ void stopRecording$default(SuspendWindowService suspendWindowService, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        suspendWindowService.stopRecording(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void translateITS(String str, String str2, String str3) {
        AISparkChainManager.f19871oIX0oI.OOXIxO0(str, str2, str3, new SuspendWindowService$translateITS$1(this));
    }

    public static /* synthetic */ void translateITS$default(SuspendWindowService suspendWindowService, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = suspendWindowService.lang;
        }
        if ((i & 4) != 0) {
            str3 = suspendWindowService.targetLang;
        }
        suspendWindowService.translateITS(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void voiceChainAi(String str) {
        if (this.broadcastCheckStatus) {
            DcsTtsPlayer dcsTtsPlayer = DcsTtsPlayer.INSTANCE;
            dcsTtsPlayer.initSegmentation();
            DcsTtsPlayer.play$default(dcsTtsPlayer, str, true, false, null, this.ttsVoiceName, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void voiceMicrosoft(String str) {
        if (this.broadcastCheckStatus) {
            MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().xI(str, this.ttsVoiceName);
        }
    }

    public final void bindView() {
        View view;
        View view2;
        View view3;
        ImageView imageView;
        AppCompatImageView appCompatImageView;
        CheckBox checkBox;
        CheckBox checkBox2;
        CheckBox checkBox3;
        View view4;
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        FrameLayout frameLayout;
        TextView textView3;
        ImageView imageView2;
        ImageView imageView3;
        FloatFrameLayout floatFrameLayout = this.floatRootView;
        ImageView imageView4 = null;
        if (floatFrameLayout != null) {
            view = floatFrameLayout.findViewById(R.id.root);
        } else {
            view = null;
        }
        IIX0o.ooOOo0oXI(view);
        setRoot(view);
        FloatFrameLayout floatFrameLayout2 = this.floatRootView;
        if (floatFrameLayout2 != null) {
            view2 = floatFrameLayout2.findViewById(R.id.rl_show_all);
        } else {
            view2 = null;
        }
        IIX0o.ooOOo0oXI(view2);
        setRl_show_all(view2);
        FloatFrameLayout floatFrameLayout3 = this.floatRootView;
        if (floatFrameLayout3 != null) {
            view3 = floatFrameLayout3.findViewById(R.id.ll_hide_content);
        } else {
            view3 = null;
        }
        IIX0o.ooOOo0oXI(view3);
        setLl_hide_content(view3);
        FloatFrameLayout floatFrameLayout4 = this.floatRootView;
        if (floatFrameLayout4 != null) {
            imageView = (ImageView) floatFrameLayout4.findViewById(R.id.img_record);
        } else {
            imageView = null;
        }
        IIX0o.ooOOo0oXI(imageView);
        setImg_record(imageView);
        FloatFrameLayout floatFrameLayout5 = this.floatRootView;
        if (floatFrameLayout5 != null) {
            appCompatImageView = (AppCompatImageView) floatFrameLayout5.findViewById(R.id.img_close);
        } else {
            appCompatImageView = null;
        }
        IIX0o.ooOOo0oXI(appCompatImageView);
        setImg_close(appCompatImageView);
        FloatFrameLayout floatFrameLayout6 = this.floatRootView;
        if (floatFrameLayout6 != null) {
            checkBox = (CheckBox) floatFrameLayout6.findViewById(R.id.translate_check);
        } else {
            checkBox = null;
        }
        IIX0o.ooOOo0oXI(checkBox);
        setTranslate_check(checkBox);
        FloatFrameLayout floatFrameLayout7 = this.floatRootView;
        if (floatFrameLayout7 != null) {
            checkBox2 = (CheckBox) floatFrameLayout7.findViewById(R.id.broadcast_check);
        } else {
            checkBox2 = null;
        }
        IIX0o.ooOOo0oXI(checkBox2);
        setBroadcast_check(checkBox2);
        FloatFrameLayout floatFrameLayout8 = this.floatRootView;
        if (floatFrameLayout8 != null) {
            checkBox3 = (CheckBox) floatFrameLayout8.findViewById(R.id.original_check);
        } else {
            checkBox3 = null;
        }
        IIX0o.ooOOo0oXI(checkBox3);
        setOriginal_check(checkBox3);
        FloatFrameLayout floatFrameLayout9 = this.floatRootView;
        if (floatFrameLayout9 != null) {
            view4 = floatFrameLayout9.findViewById(R.id.bottom_line);
        } else {
            view4 = null;
        }
        IIX0o.ooOOo0oXI(view4);
        setBottom_line(view4);
        FloatFrameLayout floatFrameLayout10 = this.floatRootView;
        if (floatFrameLayout10 != null) {
            textView = (TextView) floatFrameLayout10.findViewById(R.id.tv_translate_t);
        } else {
            textView = null;
        }
        IIX0o.ooOOo0oXI(textView);
        setTv_translate_t(textView);
        FloatFrameLayout floatFrameLayout11 = this.floatRootView;
        if (floatFrameLayout11 != null) {
            textView2 = (TextView) floatFrameLayout11.findViewById(R.id.tv_translate);
        } else {
            textView2 = null;
        }
        IIX0o.ooOOo0oXI(textView2);
        setTv_translate(textView2);
        FloatFrameLayout floatFrameLayout12 = this.floatRootView;
        if (floatFrameLayout12 != null) {
            linearLayout = (LinearLayout) floatFrameLayout12.findViewById(R.id.ll_show_set);
        } else {
            linearLayout = null;
        }
        IIX0o.ooOOo0oXI(linearLayout);
        setLl_show_set(linearLayout);
        FloatFrameLayout floatFrameLayout13 = this.floatRootView;
        if (floatFrameLayout13 != null) {
            frameLayout = (FrameLayout) floatFrameLayout13.findViewById(R.id.fl_recording);
        } else {
            frameLayout = null;
        }
        IIX0o.ooOOo0oXI(frameLayout);
        setFl_recording(frameLayout);
        FloatFrameLayout floatFrameLayout14 = this.floatRootView;
        if (floatFrameLayout14 != null) {
            textView3 = (TextView) floatFrameLayout14.findViewById(R.id.tv_original_t);
        } else {
            textView3 = null;
        }
        IIX0o.ooOOo0oXI(textView3);
        setTv_original_t(textView3);
        FloatFrameLayout floatFrameLayout15 = this.floatRootView;
        if (floatFrameLayout15 != null) {
            imageView2 = (ImageView) floatFrameLayout15.findViewById(R.id.img_recording_animation);
        } else {
            imageView2 = null;
        }
        IIX0o.ooOOo0oXI(imageView2);
        setImg_recording_animation(imageView2);
        FloatFrameLayout floatFrameLayout16 = this.floatRootView;
        if (floatFrameLayout16 != null) {
            imageView3 = (ImageView) floatFrameLayout16.findViewById(R.id.img_recording);
        } else {
            imageView3 = null;
        }
        IIX0o.ooOOo0oXI(imageView3);
        setImg_recording(imageView3);
        FloatFrameLayout floatFrameLayout17 = this.floatRootView;
        if (floatFrameLayout17 != null) {
            imageView4 = (ImageView) floatFrameLayout17.findViewById(R.id.img_record_show);
        }
        IIX0o.ooOOo0oXI(imageView4);
        setImg_record_show(imageView4);
    }

    public final void clickDownRecording(int i) {
        if (PermissionUtils.isGranted(PermissionConstants.MICROPHONE)) {
            DcsTtsPlayer.INSTANCE.deleteReplayMusic();
            startRecording();
        } else {
            permission();
        }
    }

    public final void disRecordingPopup() {
        showRecordingPopup(false);
    }

    @OXOo.OOXIXo
    public final String getArsAccent() {
        return this.arsAccent;
    }

    @OXOo.OOXIXo
    public final String getArsLanguage() {
        return this.arsLanguage;
    }

    @OXOo.OOXIXo
    public final View getBottom_line() {
        View view = this.bottom_line;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("bottom_line");
        return null;
    }

    @OXOo.OOXIXo
    public final CheckBox getBroadcast_check() {
        CheckBox checkBox = this.broadcast_check;
        if (checkBox != null) {
            return checkBox;
        }
        IIX0o.XOxIOxOx("broadcast_check");
        return null;
    }

    @OXOo.OOXIXo
    public final ClipboardManager getClipboard() {
        ClipboardManager clipboardManager = this.clipboard;
        if (clipboardManager != null) {
            return clipboardManager;
        }
        IIX0o.XOxIOxOx("clipboard");
        return null;
    }

    @OXOo.OOXIXo
    public final FrameLayout getFl_recording() {
        FrameLayout frameLayout = this.fl_recording;
        if (frameLayout != null) {
            return frameLayout;
        }
        IIX0o.XOxIOxOx("fl_recording");
        return null;
    }

    @OXOo.OOXIXo
    public final ImageView getImg_close() {
        ImageView imageView = this.img_close;
        if (imageView != null) {
            return imageView;
        }
        IIX0o.XOxIOxOx("img_close");
        return null;
    }

    @OXOo.OOXIXo
    public final ImageView getImg_record() {
        ImageView imageView = this.img_record;
        if (imageView != null) {
            return imageView;
        }
        IIX0o.XOxIOxOx("img_record");
        return null;
    }

    @OXOo.OOXIXo
    public final ImageView getImg_record_show() {
        ImageView imageView = this.img_record_show;
        if (imageView != null) {
            return imageView;
        }
        IIX0o.XOxIOxOx("img_record_show");
        return null;
    }

    @OXOo.OOXIXo
    public final ImageView getImg_recording() {
        ImageView imageView = this.img_recording;
        if (imageView != null) {
            return imageView;
        }
        IIX0o.XOxIOxOx("img_recording");
        return null;
    }

    @OXOo.OOXIXo
    public final ImageView getImg_recording_animation() {
        ImageView imageView = this.img_recording_animation;
        if (imageView != null) {
            return imageView;
        }
        IIX0o.XOxIOxOx("img_recording_animation");
        return null;
    }

    @OXOo.OOXIXo
    public final String getLang() {
        return this.lang;
    }

    @OXOo.OOXIXo
    public final View getLl_hide_content() {
        View view = this.ll_hide_content;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("ll_hide_content");
        return null;
    }

    @OXOo.OOXIXo
    public final LinearLayout getLl_show_set() {
        LinearLayout linearLayout = this.ll_show_set;
        if (linearLayout != null) {
            return linearLayout;
        }
        IIX0o.XOxIOxOx("ll_show_set");
        return null;
    }

    @OXOo.OOXIXo
    public final String getMContent() {
        return this.mContent;
    }

    @OXOo.OOXIXo
    public final String getMContentResult() {
        return this.mContentResult;
    }

    @OXOo.OOXIXo
    public final String getMExtraInfo() {
        return this.mExtraInfo;
    }

    @OXOo.OOXIXo
    public final List<LanguageTranslationData> getMLanguageTranslationList() {
        List<LanguageTranslationData> list = this.mLanguageTranslationList;
        if (list != null) {
            return list;
        }
        IIX0o.XOxIOxOx("mLanguageTranslationList");
        return null;
    }

    @OXOo.OOXIXo
    public final LanguageTranslationData getMLeftLanguage() {
        LanguageTranslationData languageTranslationData = this.mLeftLanguage;
        if (languageTranslationData != null) {
            return languageTranslationData;
        }
        IIX0o.XOxIOxOx("mLeftLanguage");
        return null;
    }

    @OXOo.OOXIXo
    public final LanguageTranslationData getMRightLanguage() {
        LanguageTranslationData languageTranslationData = this.mRightLanguage;
        if (languageTranslationData != null) {
            return languageTranslationData;
        }
        IIX0o.XOxIOxOx("mRightLanguage");
        return null;
    }

    @OXOo.OOXIXo
    public final MicrosoftSDKManage.I0Io getMicrosoftCallBack() {
        return this.microsoftCallBack;
    }

    @OXOo.OOXIXo
    public final CheckBox getOriginal_check() {
        CheckBox checkBox = this.original_check;
        if (checkBox != null) {
            return checkBox;
        }
        IIX0o.XOxIOxOx("original_check");
        return null;
    }

    @OXOo.OOXIXo
    public final AnimationDrawable getRecordAnimation() {
        AnimationDrawable animationDrawable = this.recordAnimation;
        if (animationDrawable != null) {
            return animationDrawable;
        }
        IIX0o.XOxIOxOx("recordAnimation");
        return null;
    }

    @OXOo.OOXIXo
    public final RecordingManager.OnRecordingCallback getRecordingCallBack() {
        return this.recordingCallBack;
    }

    @OXOo.OOXIXo
    public final View getRl_show_all() {
        View view = this.rl_show_all;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("rl_show_all");
        return null;
    }

    @OXOo.OOXIXo
    public final View getRoot() {
        View view = this.root;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("root");
        return null;
    }

    @OXOo.OOXIXo
    public final String getTargetLang() {
        return this.targetLang;
    }

    @OXOo.OOXIXo
    public final CheckBox getTranslate_check() {
        CheckBox checkBox = this.translate_check;
        if (checkBox != null) {
            return checkBox;
        }
        IIX0o.XOxIOxOx("translate_check");
        return null;
    }

    @OXOo.OOXIXo
    public final String getTtsTargetLang() {
        return this.ttsTargetLang;
    }

    @OXOo.OOXIXo
    public final String getTtsVoiceName() {
        return this.ttsVoiceName;
    }

    @OXOo.OOXIXo
    public final TextView getTv_original_t() {
        TextView textView = this.tv_original_t;
        if (textView != null) {
            return textView;
        }
        IIX0o.XOxIOxOx("tv_original_t");
        return null;
    }

    @OXOo.OOXIXo
    public final TextView getTv_translate() {
        TextView textView = this.tv_translate;
        if (textView != null) {
            return textView;
        }
        IIX0o.XOxIOxOx("tv_translate");
        return null;
    }

    @OXOo.OOXIXo
    public final TextView getTv_translate_t() {
        TextView textView = this.tv_translate_t;
        if (textView != null) {
            return textView;
        }
        IIX0o.XOxIOxOx("tv_translate_t");
        return null;
    }

    public final void initObserve() {
        ViewModelMain viewModelMain = ViewModelMain.INSTANCE;
        viewModelMain.isShowSuspenWindow().observe(this, new Oxx0IOOO(new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.service.SuspendWindowService$initObserve$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                invoke2(bool);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                boolean z;
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("isShowSuspenWindow: " + bool);
                z = SuspendWindowService.this.isShow;
                if (IIX0o.Oxx0IOOO(Boolean.valueOf(z), bool)) {
                    return;
                }
                IIX0o.ooOOo0oXI(bool);
                if (!bool.booleanValue()) {
                    SuspendWindowService.this.handle.removeCallbacksAndMessages(null);
                    SuspendWindowService.this.isShow = false;
                    SuspendWindowService.this.stopSelf();
                } else {
                    SuspendWindowService.this.showWindow();
                    SuspendWindowService.this.isShow = true;
                }
            }
        }));
        viewModelMain.isReSetList().observe(this, new Oxx0IOOO(new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.service.SuspendWindowService$initObserve$1$2
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                invoke2(bool);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                IIX0o.ooOOo0oXI(bool);
                if (bool.booleanValue()) {
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("isReSetList: " + bool);
                    SuspendWindowService.this.setMicrosoftCallback();
                }
            }
        }));
    }

    public final void initViedo() {
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        voiceManager.setActivityData(true);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XI0IXoo()) {
            MicrosoftSDKManage.II0xO0 iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
            iI0xO0.oIX0oI().OOXIxO0();
            iI0xO0.oIX0oI().O0X(this.microsoftCallBack, this.TAG);
        } else if (productManager.oO0OX0()) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " initViedo");
            RecordingManager.Companion.getInstance().setRecordingCallback(this.recordingCallBack);
        }
        voiceManager.setMListener(new SuspendWindowService$initViedo$1(this));
    }

    public final void initView() {
        int i;
        Xo0 xo0 = Xo0.f24349oIX0oI;
        this.translateCheckStatus = xo0.oIX0oI().getBoolean(XoI0Ixx0.f24378O00, true);
        this.broadcastCheckStatus = xo0.oIX0oI().getBoolean(XoI0Ixx0.f24481xOOxIO, true);
        this.showOriginalTextStatus = xo0.oIX0oI().getBoolean(XoI0Ixx0.f24384O0xxXxI, false);
        this.onlyshowTranslate = xo0.oIX0oI().getBoolean(XoI0Ixx0.f24464oxOXxoXII, false);
        Drawable background = getImg_recording_animation().getBackground();
        IIX0o.x0XOIxOo(background, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        setRecordAnimation((AnimationDrawable) background);
        initLanguage();
        setLaunguage();
        showBg(true);
        initViedo();
        this.handle.postDelayed(new oxoX(), 3000L);
        if (this.isShowRecordImg) {
            getImg_record().setVisibility(0);
        } else {
            getImg_record().setVisibility(8);
        }
        getImg_record().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.service.OOXIXo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuspendWindowService.initView$lambda$3(SuspendWindowService.this, view);
            }
        });
        getImg_recording().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.service.ooOOo0oXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuspendWindowService.initView$lambda$4(SuspendWindowService.this, view);
            }
        });
        getImg_close().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.service.x0XOIxOo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuspendWindowService.initView$lambda$5(SuspendWindowService.this, view);
            }
        });
        getTranslate_check().setChecked(this.translateCheckStatus);
        getTranslate_check().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.service.oO
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SuspendWindowService.initView$lambda$6(SuspendWindowService.this, compoundButton, z);
            }
        });
        getTranslate_check().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.service.x0xO0oo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuspendWindowService.initView$lambda$7(view);
            }
        });
        getBroadcast_check().setChecked(this.broadcastCheckStatus);
        getBroadcast_check().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.service.oxoX
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SuspendWindowService.initView$lambda$8(SuspendWindowService.this, compoundButton, z);
            }
        });
        getBroadcast_check().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.service.X0o0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuspendWindowService.initView$lambda$9(view);
            }
        });
        String string = getString(R.string.enter_content);
        IIX0o.oO(string, "getString(...)");
        this.mContent = string;
        getOriginal_check().setChecked(this.showOriginalTextStatus);
        CheckBox original_check = getOriginal_check();
        if (this.showOriginalTextStatus) {
            i = R.string.show_original_text;
        } else {
            i = R.string.show_translation_result;
        }
        original_check.setText(getString(i));
        getOriginal_check().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.service.XO
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SuspendWindowService.initView$lambda$10(SuspendWindowService.this, compoundButton, z);
            }
        });
        getOriginal_check().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.service.Oxx0IOOO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuspendWindowService.initView$lambda$11(view);
            }
        });
        getLl_show_set().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.service.II0XooXoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuspendWindowService.initView$lambda$12(SuspendWindowService.this, view);
            }
        });
        getImg_record_show().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.service.oOoXoXO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuspendWindowService.initView$lambda$13(SuspendWindowService.this, view);
            }
        });
        Object systemService = getSystemService("clipboard");
        IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        setClipboard((ClipboardManager) systemService);
    }

    public final boolean isAddListData() {
        return this.isAddListData;
    }

    public final boolean isEndTranslation() {
        return this.isEndTranslation;
    }

    public final boolean isStartAnalysis() {
        return this.isStartAnalysis;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        initObserve();
        createNotificationChannel();
        LogUtils.d("onCreate: ");
        XO0.II0xO0.oxoX().x0XOIxOo(this);
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        LogUtils.d("onDestroy");
        if (Build.VERSION.SDK_INT >= 24) {
            stopForeground(1);
        } else {
            stopForeground(true);
        }
        this.handle.removeCallbacksAndMessages(null);
        XO0.II0xO0.oxoX().IIXOooo(this);
        FloatFrameLayout floatFrameLayout = this.floatRootView;
        if (floatFrameLayout != null) {
            WindowManager windowManager = this.windowManager;
            if (windowManager != null) {
                windowManager.removeView(floatFrameLayout);
            }
            this.isShow = false;
            getRecordAnimation().stop();
        }
        DcsTtsPlayer.INSTANCE.stop();
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        voiceManager.setMListener(null);
        voiceManager.setMicrosoftCallback();
        RecordingManager.Companion.getInstance().closeBluetooth();
        voiceManager.setActivityData(false);
        stopRecording$default(this, false, 1, null);
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24627oI)
    public final void onLanguageChange(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " onLanguageChange event = " + data);
        initLanguage();
        setLaunguage();
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24670xxOXOOoIX)
    public final void onOnlyShowTranslation(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        this.onlyshowTranslate = Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24464oxOXxoXII, false);
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(@OXOo.oOoXoXO Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        Notification buildNotification = buildNotification();
        if (Build.VERSION.SDK_INT >= 30) {
            startForeground(this.NOTIFICATION_ID, buildNotification, 128);
            return 1;
        }
        startForeground(this.NOTIFICATION_ID, buildNotification);
        return 1;
    }

    public final void permission() {
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.MICROPHONE);
        IIX0o.oO(permission, "permission(...)");
        String string = getString(R.string.microphone_explain_title);
        IIX0o.oO(string, "getString(...)");
        String string2 = getString(R.string.microphone_explain_content);
        IIX0o.oO(string2, "getString(...)");
        oOXoIIIo.X0o0xo.II0xO0(permission, string, string2, new Oox.oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.service.SuspendWindowService$permission$1
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                IIX0o.x0xO0oo(it, "it");
                PermissionStatus permissionStatus = PermissionStatus.GRANTED;
            }
        });
    }

    public void saveDBRecord() {
    }

    public final void sendTranslate(@OXOo.OOXIXo final String content) {
        IIX0o.x0xO0oo(content, "content");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + "  sendTranslate  content = " + content + " lang = " + this.lang + ", targetLang = " + this.targetLang);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XI0IXoo()) {
            sendTranslationResultInput(content);
        } else if (productManager.oO0OX0()) {
            xoIXOxX.II0xO0.I0Io(true, false, null, null, 0, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.service.SuspendWindowService$sendTranslate$1
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
                    SuspendWindowService.this.sendChainAiTranslationResultInput(content);
                }
            }, 30, null);
        }
    }

    public final void sendTranslationResult() {
        String str = this.mContent;
        if (str == null) {
            str = "null";
        }
        String str2 = this.mExtraInfo;
        sendTranslationResult(str, str2 != null ? str2 : "null");
    }

    public final void setAddListData(boolean z) {
        this.isAddListData = z;
    }

    public final void setArsAccent(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.arsAccent = str;
    }

    public final void setArsLanguage(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.arsLanguage = str;
    }

    public final void setBottom_line(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.bottom_line = view;
    }

    public final void setBroadcast_check(@OXOo.OOXIXo CheckBox checkBox) {
        IIX0o.x0xO0oo(checkBox, "<set-?>");
        this.broadcast_check = checkBox;
    }

    public final void setClipboard(@OXOo.OOXIXo ClipboardManager clipboardManager) {
        IIX0o.x0xO0oo(clipboardManager, "<set-?>");
        this.clipboard = clipboardManager;
    }

    public final void setEndTranslation(boolean z) {
        this.isEndTranslation = z;
    }

    public final void setFl_recording(@OXOo.OOXIXo FrameLayout frameLayout) {
        IIX0o.x0xO0oo(frameLayout, "<set-?>");
        this.fl_recording = frameLayout;
    }

    public final void setImg_close(@OXOo.OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.img_close = imageView;
    }

    public final void setImg_record(@OXOo.OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.img_record = imageView;
    }

    public final void setImg_record_show(@OXOo.OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.img_record_show = imageView;
    }

    public final void setImg_recording(@OXOo.OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.img_recording = imageView;
    }

    public final void setImg_recording_animation(@OXOo.OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.img_recording_animation = imageView;
    }

    public final void setLang(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.lang = str;
    }

    public final void setLaunguage() {
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        voiceManager.setActivityData(true);
        this.lang = getMLeftLanguage().getRtasrLanguage();
        this.arsLanguage = getMLeftLanguage().getAsrLanguage();
        this.arsAccent = getMLeftLanguage().getAccent();
        this.targetLang = getMRightLanguage().getRtasrLanguage();
        this.ttsVoiceName = getMRightLanguage().getTtsViuceName();
        this.ttsTargetLang = getMRightLanguage().getAsrLanguage();
        voiceManager.setLanguageType(this.arsLanguage, this.ttsVoiceName);
    }

    public final void setLl_hide_content(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.ll_hide_content = view;
    }

    public final void setLl_show_set(@OXOo.OOXIXo LinearLayout linearLayout) {
        IIX0o.x0xO0oo(linearLayout, "<set-?>");
        this.ll_show_set = linearLayout;
    }

    public final void setMContent(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mContent = str;
    }

    public final void setMContentResult(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mContentResult = str;
    }

    public final void setMExtraInfo(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mExtraInfo = str;
    }

    public final void setMLanguageTranslationList(@OXOo.OOXIXo List<LanguageTranslationData> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mLanguageTranslationList = list;
    }

    public final void setMLeftLanguage(@OXOo.OOXIXo LanguageTranslationData languageTranslationData) {
        IIX0o.x0xO0oo(languageTranslationData, "<set-?>");
        this.mLeftLanguage = languageTranslationData;
    }

    public final void setMRightLanguage(@OXOo.OOXIXo LanguageTranslationData languageTranslationData) {
        IIX0o.x0xO0oo(languageTranslationData, "<set-?>");
        this.mRightLanguage = languageTranslationData;
    }

    public final void setMicrosoftCallback() {
        initViedo();
    }

    public final void setOriginal_check(@OXOo.OOXIXo CheckBox checkBox) {
        IIX0o.x0xO0oo(checkBox, "<set-?>");
        this.original_check = checkBox;
    }

    public final void setRecordAnimation(@OXOo.OOXIXo AnimationDrawable animationDrawable) {
        IIX0o.x0xO0oo(animationDrawable, "<set-?>");
        this.recordAnimation = animationDrawable;
    }

    public final void setRecordText() {
        if (this.showOriginalTextStatus) {
            if (this.mContent.length() == 0 || IIX0o.Oxx0IOOO(this.mContent, getString(R.string.request_error))) {
                getTv_translate_t().setText("");
                getTv_translate_t().setVisibility(8);
            } else {
                getTv_translate_t().setText(this.mContent);
            }
            getTv_translate().setText(this.mContent);
            return;
        }
        if (this.mExtraInfo.length() == 0) {
            getTv_translate_t().setVisibility(8);
        }
        getTv_translate_t().setText(this.mExtraInfo);
        getTv_translate().setText(this.mExtraInfo);
    }

    public final void setRl_show_all(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.rl_show_all = view;
    }

    public final void setRoot(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.root = view;
    }

    public final void setStartAnalysis(boolean z) {
        this.isStartAnalysis = z;
    }

    public final void setTargetLang(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.targetLang = str;
    }

    public final void setTranslate_check(@OXOo.OOXIXo CheckBox checkBox) {
        IIX0o.x0xO0oo(checkBox, "<set-?>");
        this.translate_check = checkBox;
    }

    public final void setTtsTargetLang(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.ttsTargetLang = str;
    }

    public final void setTtsVoiceName(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.ttsVoiceName = str;
    }

    public final void setTv_original_t(@OXOo.OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.tv_original_t = textView;
    }

    public final void setTv_translate(@OXOo.OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.tv_translate = textView;
    }

    public final void setTv_translate_t(@OXOo.OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.tv_translate_t = textView;
    }

    public final void showBg(boolean z) {
        if (z) {
            getRoot().setBackgroundColor(Color.parseColor("#B2000000"));
            getRl_show_all().setVisibility(0);
            getLl_hide_content().setVisibility(8);
        } else {
            getRoot().setBackgroundColor(0);
            getRl_show_all().setVisibility(8);
            getLl_hide_content().setVisibility(0);
        }
    }

    public final void showRecordingPopup(boolean z) {
        if (z) {
            getImg_record().setVisibility(8);
            getFl_recording().setVisibility(0);
            getTv_translate_t().setVisibility(8);
            getRecordAnimation().start();
            return;
        }
        if (this.isShowRecordImg) {
            getImg_record().setVisibility(0);
        }
        getFl_recording().setVisibility(8);
        getTv_original_t().setVisibility(8);
        CharSequence text = getTv_translate_t().getText();
        IIX0o.oO(text, "getText(...)");
        if (text.length() > 0) {
            getTv_translate_t().setVisibility(0);
        }
        getRecordAnimation().stop();
    }

    public final void showWindow() {
        int i;
        Display defaultDisplay;
        Log.d(this.TAG, "showWindow: ");
        Object systemService = getSystemService("window");
        IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = this.windowManager;
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            i = 2038;
        } else {
            i = 2003;
        }
        layoutParams.type = i;
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 8388659;
        layoutParams.x = 0;
        layoutParams.y = (displayMetrics.heightPixels * 2) / 3;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " outMetrics.heightPixels * 2 / 3 = " + ((displayMetrics.heightPixels * 2) / 3));
        LayoutInflater from = LayoutInflater.from(this);
        View view = null;
        if (from != null) {
            view = from.inflate(R.layout.floating_interface, (ViewGroup) null);
        }
        IIX0o.x0XOIxOo(view, "null cannot be cast to non-null type com.sma.smartv3.view.FloatFrameLayout");
        this.floatRootView = (FloatFrameLayout) view;
        bindView();
        initView();
        WindowManager windowManager2 = this.windowManager;
        if (windowManager2 != null) {
            FloatFrameLayout floatFrameLayout = this.floatRootView;
            if (floatFrameLayout != null) {
                IIX0o.ooOOo0oXI(windowManager2);
                floatFrameLayout.setOnTouchListener(new oIX0oI(layoutParams, windowManager2));
            }
            WindowManager windowManager3 = this.windowManager;
            if (windowManager3 != null) {
                windowManager3.addView(this.floatRootView, layoutParams);
            }
        }
    }

    public void startRecording() {
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XI0IXoo()) {
            LogUtils.d(this.TAG + TokenParser.SP + this.isStartAnalysis);
            this.isEndTranslation = false;
            this.isStartAnalysis = true;
            MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().Ox0O(this.arsLanguage, true, this.ttsVoiceName, this.ttsTargetLang, false, this.TAG);
            return;
        }
        if (productManager.oO0OX0()) {
            RecordingManager.recordPermission$default(RecordingManager.Companion.getInstance(), this.recordingCallBack, false, false, this.TAG, 6, null);
        }
    }

    public final void stopRecording(boolean z) {
        if (ProductManager.f20544oIX0oI.XI0IXoo()) {
            if (z) {
                this.isEndTranslation = true;
                RecordingManager.Companion.getInstance().setRecording(false);
                MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().x0();
            }
            MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().x0OxxIOxX();
            return;
        }
        RecordingManager.Companion.getInstance().stopRecording();
    }

    public final void sendTranslationResult(@OXOo.OOXIXo String inputText, @OXOo.OOXIXo String outputText) {
        IIX0o.x0xO0oo(inputText, "inputText");
        IIX0o.x0xO0oo(outputText, "outputText");
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        voiceManager.senAudioTextToDevice(new BleVoice(0, System.currentTimeMillis(), StringsKt__StringsKt.oIoIXxIO(inputText).toString(), 0, 8, null));
        voiceManager.senAudioTextToDevice(new BleVoice(1, System.currentTimeMillis(), StringsKt__StringsKt.oIoIXxIO(outputText).toString(), 0, 8, null));
    }

    public final void showRecordingPopup() {
        showRecordingPopup(true);
    }
}
