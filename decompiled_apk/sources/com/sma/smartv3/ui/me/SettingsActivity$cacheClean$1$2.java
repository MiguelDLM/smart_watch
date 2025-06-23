package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.os.Handler;
import android.widget.TextView;
import com.blankj.utilcode.util.FileUtils;
import com.jieli.bluetooth_connect.util.JL_Log;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes11.dex */
public final class SettingsActivity$cacheClean$1$2 extends Lambda implements Oox.oIX0oI<Boolean> {
    final /* synthetic */ SettingsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsActivity$cacheClean$1$2(SettingsActivity settingsActivity) {
        super(0);
        this.this$0 = settingsActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(SettingsActivity this$0) {
        TextView cacheSize;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (!this$0.isFinishing()) {
            cacheSize = this$0.getCacheSize();
            cacheSize.setText("0KB");
            this$0.mCleaning = false;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // Oox.oIX0oI
    @OXOo.OOXIXo
    public final Boolean invoke() {
        Activity mContext;
        Activity mContext2;
        TextView cacheSize;
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        FileUtils.delete(com.sma.smartv3.initializer.IXxxXO.X00IoxXI(oix0oi));
        FileUtils.delete(com.sma.smartv3.initializer.IXxxXO.oOoXoXO(oix0oi));
        mContext = this.this$0.getMContext();
        FileUtils.delete(mContext.getCacheDir());
        com.sma.smartv3.util.ooXIXxIX.oIX0oI(this.this$0);
        mContext2 = this.this$0.getMContext();
        FileUtils.delete(JL_Log.getSaveLogPath(mContext2));
        FileUtils.delete(com.sma.smartv3.initializer.IXxxXO.Xx000oIo(oix0oi));
        com.sma.smartv3.util.Xo0.f24349oIX0oI.X0o0xo().clear();
        cacheSize = this.this$0.getCacheSize();
        cacheSize.setText(R.string.cache_cleaning);
        Handler handler = new Handler();
        final SettingsActivity settingsActivity = this.this$0;
        handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.xXo
            @Override // java.lang.Runnable
            public final void run() {
                SettingsActivity$cacheClean$1$2.invoke$lambda$0(SettingsActivity.this);
            }
        }, 10000L);
        return Boolean.TRUE;
    }
}
