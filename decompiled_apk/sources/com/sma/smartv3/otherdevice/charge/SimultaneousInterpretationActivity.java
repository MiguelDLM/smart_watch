package com.sma.smartv3.otherdevice.charge;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.sma.smartv3.biz.voice.RecordingManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.AIRecords;
import com.sma.smartv3.model.AIFunctionType;
import com.sma.smartv3.otherdevice.charge.SimultaneousInterpretationActivity;
import com.sma.smartv3.pop.OooI;
import java.util.Timer;
import java.util.TimerTask;

@kotlin.jvm.internal.XX({"SMAP\nSimultaneousInterpretationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimultaneousInterpretationActivity.kt\ncom/sma/smartv3/otherdevice/charge/SimultaneousInterpretationActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,278:1\n69#2,3:279\n72#2,5:283\n1#3:282\n*S KotlinDebug\n*F\n+ 1 SimultaneousInterpretationActivity.kt\ncom/sma/smartv3/otherdevice/charge/SimultaneousInterpretationActivity\n*L\n126#1:279,3\n126#1:283,5\n126#1:282\n*E\n"})
/* loaded from: classes12.dex */
public final class SimultaneousInterpretationActivity extends BaseTranslationActivity {

    @OXOo.oOoXoXO
    private AnimationDrawable mAnimationDrawable;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.I0X0x0oIo mLoadPopup;

    @OXOo.oOoXoXO
    private OooI mTranslationSavePopup;
    private int recordingTime;

    @OXOo.oOoXoXO
    private Timer timer;

    @OXOo.OOXIXo
    private final String TAG = "SimultaneousInterpretationActivity";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTopLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.SimultaneousInterpretationActivity$mTopLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return SimultaneousInterpretationActivity.this.findViewById(R.id.simultaneous_interpretation_top_layout);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTopTv$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.SimultaneousInterpretationActivity$mTopTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) SimultaneousInterpretationActivity.this.findViewById(R.id.simultaneous_interpretation_top_tv);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mBtnTv$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.SimultaneousInterpretationActivity$mBtnTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) SimultaneousInterpretationActivity.this.findViewById(R.id.simultaneous_interpretation_btn_tv);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mAudioPlayImg$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.SimultaneousInterpretationActivity$mAudioPlayImg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) SimultaneousInterpretationActivity.this.findViewById(R.id.simultaneous_interpretation_audio_play_img);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mAudioPlayTime$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.SimultaneousInterpretationActivity$mAudioPlayTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) SimultaneousInterpretationActivity.this.findViewById(R.id.simultaneous_interpretation_audio_play_time);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mPlayAudioBtn$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.SimultaneousInterpretationActivity$mPlayAudioBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) SimultaneousInterpretationActivity.this.findViewById(R.id.simultaneous_interpretation_play_btn);
        }
    });
    private boolean isFirstTranslation = true;
    private boolean isFirstIdentifySuccess = true;
    private boolean isFirstTranslateSuccess = true;

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends TimerTask {
        public oIX0oI() {
        }

        public static final void II0xO0(SimultaneousInterpretationActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.setRecordingTime(this$0.getRecordingTime() + 1);
            this$0.getMAudioPlayTime().setText(com.sma.smartv3.util.xoIox.Io(this$0.getRecordingTime()));
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Handler mHandler = SimultaneousInterpretationActivity.this.getMHandler();
            final SimultaneousInterpretationActivity simultaneousInterpretationActivity = SimultaneousInterpretationActivity.this;
            mHandler.post(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.oOo
                @Override // java.lang.Runnable
                public final void run() {
                    SimultaneousInterpretationActivity.oIX0oI.II0xO0(SimultaneousInterpretationActivity.this);
                }
            });
        }
    }

    public SimultaneousInterpretationActivity() {
        setMAIFunctionType(AIFunctionType.SIMULTANEOUS_INTERPRETATION.getType());
        setMAIRecordsType(2);
        setSteam(true);
        setAppSend(true);
    }

    private final void clickDownRecording() {
        if (PermissionUtils.isGranted(PermissionConstants.MICROPHONE)) {
            setLangAndVoice();
            startRecording();
        } else {
            permission();
        }
    }

    private final void endRecording(boolean z) {
        getMPlayAudioBtn().setImageResource(R.drawable.simultaneous_play_icon);
        getMAudioPlayTime().setText(com.sma.smartv3.util.xoIox.Io(0));
        AnimationDrawable animationDrawable = this.mAnimationDrawable;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        stopRecording(z);
        if (!z) {
            showLoadPopup();
            getMHandler().postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.XIXIX
                @Override // java.lang.Runnable
                public final void run() {
                    SimultaneousInterpretationActivity.endRecording$lambda$0(SimultaneousInterpretationActivity.this);
                }
            }, 3000L);
        }
    }

    public static /* synthetic */ void endRecording$default(SimultaneousInterpretationActivity simultaneousInterpretationActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        simultaneousInterpretationActivity.endRecording(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endRecording$lambda$0(SimultaneousInterpretationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this$0.mLoadPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
        this$0.showSaveDialog();
    }

    private final ImageView getMAudioPlayImg() {
        return (ImageView) this.mAudioPlayImg$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getMAudioPlayTime() {
        return (TextView) this.mAudioPlayTime$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getMBtnTv() {
        return (TextView) this.mBtnTv$delegate.getValue();
    }

    private final ImageView getMPlayAudioBtn() {
        return (ImageView) this.mPlayAudioBtn$delegate.getValue();
    }

    private final View getMTopLayout() {
        return (View) this.mTopLayout$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getMTopTv() {
        return (TextView) this.mTopTv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(SimultaneousInterpretationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (RecordingManager.Companion.getInstance().isRecording()) {
            this$0.endRecording(true);
        } else {
            this$0.clickDownRecording();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(SimultaneousInterpretationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.isFirstTranslation) {
            this$0.clickDownRecording();
        }
    }

    private final void setViewLayoutParams(TextView textView, int i) {
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            if (textView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).gravity = i;
            }
            textView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadPopup() {
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this.mLoadPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
        if (this.mLoadPopup == null) {
            this.mLoadPopup = new com.sma.smartv3.pop.I0X0x0oIo(this);
        }
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2 = this.mLoadPopup;
        if (i0X0x0oIo2 != null) {
            i0X0x0oIo2.IIXOooo();
        }
    }

    private final void showSaveDialog() {
        sendTranslationResult(getMTopTv().getText().toString(), getMBtnTv().getText().toString());
        OooI oooI = this.mTranslationSavePopup;
        if (oooI != null) {
            oooI.dismiss();
        }
        if (this.mTranslationSavePopup == null) {
            OooI oooI2 = new OooI(this);
            oooI2.Xx000oIo(getMLeftLanguage().getName());
            oooI2.xII(getMRightLanguage().getName());
            oooI2.IO(com.sma.smartv3.util.xoIox.Io(this.recordingTime));
            oooI2.X00IoxXI(new SimultaneousInterpretationActivity$showSaveDialog$1$1(this));
            this.mTranslationSavePopup = oooI2;
        }
        OooI oooI3 = this.mTranslationSavePopup;
        if (oooI3 != null) {
            oooI3.IIXOooo();
        }
    }

    @SuppressLint({"DiscouragedApi"})
    private final void startAudioRecording() {
        getMTopTv().setText(getString(R.string.in_the_recording));
        getMPlayAudioBtn().setImageResource(R.drawable.simultaneous_pause_icon);
        if (this.mAnimationDrawable == null) {
            Drawable drawable = getResources().getDrawable(R.drawable.audio_play_animation_list);
            kotlin.jvm.internal.IIX0o.x0XOIxOo(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            this.mAnimationDrawable = (AnimationDrawable) drawable;
        }
        getMAudioPlayImg().setImageDrawable(this.mAnimationDrawable);
        AnimationDrawable animationDrawable = this.mAnimationDrawable;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        this.recordingTime = 0;
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.timer = timer2;
        timer2.scheduleAtFixedRate(new oIX0oI(), 0L, 1000L);
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void disRecordingPopup() {
        super.disRecordingPopup();
        endRecording$default(this, false, 1, null);
    }

    @OXOo.oOoXoXO
    public final AnimationDrawable getMAnimationDrawable() {
        return this.mAnimationDrawable;
    }

    public final int getRecordingTime() {
        return this.recordingTime;
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity, com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        super.init(bundle);
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getAbhTitleCenter().setText(getString(R.string.simultaneous_interpretation));
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.icon_simultaneous_right_img);
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        getMPlayAudioBtn().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.xX0IIXIx0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimultaneousInterpretationActivity.initView$lambda$1(SimultaneousInterpretationActivity.this, view);
            }
        });
        getMTopLayout().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.xOOOX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimultaneousInterpretationActivity.initView$lambda$2(SimultaneousInterpretationActivity.this, view);
            }
        });
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_simultaneous_interpretation;
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void notifyViewData() {
        String mExtraInfo;
        String mContent;
        String str;
        super.notifyViewData();
        AIRecords mAIRecords = getMAIRecords();
        String str2 = null;
        if (mAIRecords != null && (mContent = mAIRecords.getMContent()) != null && mContent.length() > 0) {
            if (this.isFirstIdentifySuccess) {
                TextView mTopTv = getMTopTv();
                kotlin.jvm.internal.IIX0o.oO(mTopTv, "<get-mTopTv>(...)");
                setViewLayoutParams(mTopTv, 3);
                getMTopTv().setGravity(3);
            }
            TextView mTopTv2 = getMTopTv();
            AIRecords mAIRecords2 = getMAIRecords();
            if (mAIRecords2 != null) {
                str = mAIRecords2.getMContent();
            } else {
                str = null;
            }
            mTopTv2.setText(str);
        }
        AIRecords mAIRecords3 = getMAIRecords();
        if (mAIRecords3 != null && (mExtraInfo = mAIRecords3.getMExtraInfo()) != null && mExtraInfo.length() > 0) {
            if (this.isFirstTranslateSuccess) {
                TextView mBtnTv = getMBtnTv();
                kotlin.jvm.internal.IIX0o.oO(mBtnTv, "<get-mBtnTv>(...)");
                setViewLayoutParams(mBtnTv, 3);
            }
            TextView mBtnTv2 = getMBtnTv();
            AIRecords mAIRecords4 = getMAIRecords();
            if (mAIRecords4 != null) {
                str2 = mAIRecords4.getMExtraInfo();
            }
            mBtnTv2.setText(str2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.isFirstTranslation) {
            getMTopTv().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) InterpretationRecordsActivity.class));
    }

    public final void setMAnimationDrawable(@OXOo.oOoXoXO AnimationDrawable animationDrawable) {
        this.mAnimationDrawable = animationDrawable;
    }

    public final void setRecordingTime(int i) {
        this.recordingTime = i;
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void startRecording() {
        if (this.isFirstTranslation) {
            this.isFirstTranslation = false;
            getMTopTv().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        startAudioRecording();
        super.startRecording();
    }
}
