package com.sma.smartv3.ui.sport;

import android.app.KeyguardManager;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.view.SlideLockView;

/* loaded from: classes12.dex */
public final class SportScreenLockActivity extends BaseSportOnGoingActivity {

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements SlideLockView.I0Io {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.view.SlideLockView.I0Io
        public void oIX0oI() {
            SportScreenLockActivity.this.finish();
        }
    }

    private final void setFullScreen() {
        getWindow().getDecorView().setSystemUiVisibility(5890);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        setFullScreen();
        if (Build.VERSION.SDK_INT >= 27) {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
            Object systemService = getSystemService("keyguard");
            kotlin.jvm.internal.IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
            ((KeyguardManager) systemService).requestDismissKeyguard(this, null);
            return;
        }
        getWindow().addFlags(4194304);
        getWindow().addFlags(524288);
        getWindow().addFlags(2097152);
    }

    @Override // com.sma.smartv3.ui.sport.BaseSportOnGoingActivity, com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.sma.smartv3.ui.sport.BaseSportOnGoingActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getCountdownRl().setVisibility(8);
        getScreenLockRl().setVisibility(0);
        getSportRunPanel().setVisibility(8);
        getSportProcess().setVisibility(0);
        getMapPanel().setVisibility(8);
        getSlideLockView().Oo(new oIX0oI());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @OXOo.OOXIXo KeyEvent event) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(event, "event");
        int keyCode = event.getKeyCode();
        if (keyCode == 4 || keyCode == 82) {
            return true;
        }
        return super.onKeyDown(i, event);
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24658xXOx)
    public final void onUserPresent(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onUserPresent");
        finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            setFullScreen();
        }
    }
}
