package com.sma.smartv3.ui.me;

import android.content.Intent;
import com.bestmafen.androidbase.io.Location;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ZipUtils;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import com.sma.smartv3.model.AppUser;
import java.io.File;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes11.dex */
public final class DeveloperGsensor2Activity$share$1$1 extends Lambda implements Oox.oIX0oI<kotlin.oXIO0o0XI> {
    final /* synthetic */ DeveloperGsensor2Activity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeveloperGsensor2Activity$share$1$1(DeveloperGsensor2Activity developerGsensor2Activity) {
        super(0);
        this.this$0 = developerGsensor2Activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(File zipTo, DeveloperGsensor2Activity this$0) {
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo;
        kotlin.jvm.internal.IIX0o.x0xO0oo(zipTo, "$zipTo");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", "Share DB And Log");
        intent.putExtra("android.intent.extra.STREAM", X00IoxXI.oIX0oI.f3233oIX0oI.oxoX(zipTo));
        intent.setType("*/*");
        this$0.startActivity(Intent.createChooser(intent, "Share DB And Log"));
        i0X0x0oIo = this$0.mLoadingPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
    }

    @Override // Oox.oIX0oI
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
        invoke2();
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AppUser appUser;
        String mNow;
        final File shareFile;
        DeveloperGsensor2Activity developerGsensor2Activity = this.this$0;
        StringBuilder sb = new StringBuilder();
        appUser = this.this$0.mAppUser;
        sb.append(appUser.getNickname());
        sb.append("-db&log-");
        mNow = this.this$0.getMNow();
        sb.append(mNow);
        sb.append(OTAManager.OTA_ZIP_SUFFIX);
        shareFile = developerGsensor2Activity.getShareFile(sb.toString());
        FileUtils.createOrExistsFile(shareFile);
        try {
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            ZipUtils.zipFiles(CollectionsKt__CollectionsKt.X00IoxXI(X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.INTERNAL, X00IoxXI.II0xO0.f3231II0xO0.II0xO0(), null, 4, null), com.sma.smartv3.initializer.IXxxXO.X00IoxXI(oix0oi), com.sma.smartv3.initializer.IXxxXO.Xx000oIo(oix0oi)), shareFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        final DeveloperGsensor2Activity developerGsensor2Activity2 = this.this$0;
        developerGsensor2Activity2.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.me.Xo0
            @Override // java.lang.Runnable
            public final void run() {
                DeveloperGsensor2Activity$share$1$1.invoke$lambda$1(shareFile, developerGsensor2Activity2);
            }
        });
    }
}
