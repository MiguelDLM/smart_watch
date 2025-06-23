package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.a;
import com.baidu.navisdk.j;
import com.baidu.navisdk.module.asr.i;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNVoiceBtn extends RelativeLayout {
    private static final int MSG_START_ANIM = 1;
    private static final int MSG_STOP_ANIM = 2;
    private static final String TAG = "BNVoiceBtn";
    private boolean isCurrentOnStatus;
    private boolean isOffAnimDoing;
    private boolean isOnAnimDoing;
    private boolean mAnimated;
    private AnimationDrawable mAwakeDrawable;
    private XDVoiceBtnCallback mBtnCallback;
    private AnimationDrawable mForbidAwakeDrawable;
    private Handler mHandler;
    private ImageView mImageView;

    /* loaded from: classes8.dex */
    public interface XDVoiceBtnCallback {
        boolean isAllowedBtnShow();

        boolean isSwitchOn();
    }

    public BNVoiceBtn(Context context) {
        this(context, null);
    }

    private void initView() {
        JarUtils.inflate(a.c().a(), R.layout.bnav_xd_voice_btn, this);
        this.mImageView = (ImageView) findViewById(R.id.bnav_xd_imageview);
    }

    private boolean isHasRecordAudioPermission() {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                checkSelfPermission = getContext().checkSelfPermission("android.permission.RECORD_AUDIO");
                if (checkSelfPermission == 0) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                g gVar = g.ASR;
                if (gVar.d()) {
                    gVar.e(TAG, "isHasRecordAudioPermission() error, e =" + e.toString());
                }
                return false;
            }
        }
        return true;
    }

    private boolean isSwitchOn() {
        XDVoiceBtnCallback xDVoiceBtnCallback = this.mBtnCallback;
        if (xDVoiceBtnCallback == null) {
            return false;
        }
        return xDVoiceBtnCallback.isSwitchOn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWakeUpAniInner() {
        try {
            if (isSwitchOn()) {
                if (this.mAwakeDrawable == null) {
                    this.mAwakeDrawable = (AnimationDrawable) getContext().getResources().getDrawable(R.drawable.nsdk_xd_voice_entry_awake_animation);
                }
                this.mImageView.setImageDrawable(this.mAwakeDrawable);
                if (!j.c()) {
                    this.mAwakeDrawable.start();
                }
                this.isOnAnimDoing = true;
                this.isOffAnimDoing = false;
                this.isCurrentOnStatus = true;
                return;
            }
            if (this.mForbidAwakeDrawable == null) {
                this.mForbidAwakeDrawable = (AnimationDrawable) getContext().getResources().getDrawable(R.drawable.nsdk_xd_voice_entry_forbid_awake_animation);
            }
            this.mImageView.setImageDrawable(this.mForbidAwakeDrawable);
            if (!j.c()) {
                this.mForbidAwakeDrawable.start();
            }
            this.isOnAnimDoing = false;
            this.isOffAnimDoing = true;
            this.isCurrentOnStatus = false;
        } catch (Exception e) {
            g gVar = g.ASR;
            if (gVar.c()) {
                gVar.c(TAG, "startWakeUpAniInner(), e = " + e);
            }
        }
    }

    private void startWakeupAni() {
        if (this.mAnimated) {
            return;
        }
        this.mAnimated = true;
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDrawableStatus() {
        int i;
        if (isSwitchOn()) {
            i = R.drawable.nsdk_voice_awake_icon_00016;
            this.isCurrentOnStatus = true;
        } else {
            i = R.drawable.nsdk_voice_forbid_awake_icon_00026;
            this.isCurrentOnStatus = false;
        }
        this.mImageView.setImageDrawable(getContext().getResources().getDrawable(i));
    }

    public boolean isAllowedBtnShow() {
        XDVoiceBtnCallback xDVoiceBtnCallback = this.mBtnCallback;
        if (xDVoiceBtnCallback == null) {
            return false;
        }
        return xDVoiceBtnCallback.isAllowedBtnShow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        boolean z;
        super.onDetachedFromWindow();
        boolean z2 = true;
        if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
            z = true;
        } else {
            z = false;
        }
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
        } else {
            z2 = z;
        }
        if (z2) {
            stopAni();
        }
    }

    public void setBtnCallback(XDVoiceBtnCallback xDVoiceBtnCallback) {
        this.mBtnCallback = xDVoiceBtnCallback;
    }

    public void startAni() {
        if (isAllowedBtnShow()) {
            startWakeupAni();
        } else {
            stopAni();
            setVisibility(8);
        }
    }

    public void stopAni() {
        if (this.mAwakeDrawable != null) {
            if (!j.c()) {
                this.mAwakeDrawable.stop();
            }
            this.mAwakeDrawable = null;
            this.isOnAnimDoing = false;
        }
        if (this.mForbidAwakeDrawable != null) {
            if (!j.c()) {
                this.mForbidAwakeDrawable.stop();
            }
            this.mForbidAwakeDrawable = null;
            this.isOffAnimDoing = false;
        }
        updateDrawableStatus();
    }

    public void updateStatus() {
        if (getVisibility() == 0 && isAllowedBtnShow()) {
            boolean isSwitchOn = isSwitchOn();
            if (this.mAnimated && !this.isOnAnimDoing && !this.isOffAnimDoing) {
                if (this.isCurrentOnStatus != isSwitchOn) {
                    i.b(TAG, new Runnable() { // from class: com.baidu.navisdk.ui.widget.BNVoiceBtn.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BNVoiceBtn.this.updateDrawableStatus();
                        }
                    });
                }
            } else {
                this.mHandler.removeMessages(1);
                this.mHandler.sendEmptyMessage(1);
            }
        }
    }

    public BNVoiceBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public BNVoiceBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isOnAnimDoing = false;
        this.isOffAnimDoing = false;
        this.isCurrentOnStatus = true;
        this.mHandler = new com.baidu.navisdk.util.worker.loop.a() { // from class: com.baidu.navisdk.ui.widget.BNVoiceBtn.1
            @Override // com.baidu.navisdk.util.worker.loop.a
            public void onMessage(Message message) {
                g gVar = g.ASR;
                if (gVar.d()) {
                    gVar.e(BNVoiceBtn.TAG, "onMessage :" + message.what);
                }
                int i2 = message.what;
                if (i2 == 1) {
                    BNVoiceBtn.this.startWakeUpAniInner();
                    BNVoiceBtn.this.mHandler.removeMessages(2);
                    BNVoiceBtn.this.mHandler.sendEmptyMessageDelayed(2, 9000L);
                } else if (i2 == 2) {
                    BNVoiceBtn.this.stopAni();
                }
            }
        };
        initView();
    }
}
