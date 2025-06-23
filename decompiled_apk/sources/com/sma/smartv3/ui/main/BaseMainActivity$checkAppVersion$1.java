package com.sma.smartv3.ui.main;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppVersion;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nBaseMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseMainActivity.kt\ncom/sma/smartv3/ui/main/BaseMainActivity$checkAppVersion$1\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,1362:1\n11#2,2:1363\n*S KotlinDebug\n*F\n+ 1 BaseMainActivity.kt\ncom/sma/smartv3/ui/main/BaseMainActivity$checkAppVersion$1\n*L\n484#1:1363,2\n*E\n"})
/* loaded from: classes12.dex */
public final class BaseMainActivity$checkAppVersion$1 extends Lambda implements Oox.oOoXoXO<AppVersion, oXIO0o0XI> {
    final /* synthetic */ BaseMainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMainActivity$checkAppVersion$1(BaseMainActivity baseMainActivity) {
        super(1);
        this.this$0 = baseMainActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(final BaseMainActivity this$0, final AppVersion appVersion) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(appVersion, "$appVersion");
        XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this$0, 0, 2, null);
        xoI0Ixx0.IoOoX(R.string.new_app_version_remind);
        xoI0Ixx0.x0xO0oo(false);
        if (appVersion.getFlag() == 1) {
            XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
        } else {
            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.upgrade_later), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$checkAppVersion$1$1$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
        }
        xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$checkAppVersion$1$1$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                oOXoIIIo.oIX0oI.xxX(BaseMainActivity.this, appVersion.getFileUrl());
                return Boolean.TRUE;
            }
        });
        RelativeLayout rootView = this$0.getRootView();
        IIX0o.oO(rootView, "<get-rootView>(...)");
        xoI0Ixx0.OxxIIOOXO(rootView);
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(AppVersion appVersion) {
        invoke2(appVersion);
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@OXOo.OOXIXo final AppVersion appVersion) {
        ImageView imageView;
        Handler handler;
        IIX0o.x0xO0oo(appVersion, "appVersion");
        Xo0.f24349oIX0oI.oIX0oI().put(AppVersion.class.getName(), new Gson().toJson(appVersion));
        imageView = this.this$0.ivRemind;
        if (imageView == null) {
            IIX0o.XOxIOxOx("ivRemind");
            imageView = null;
        }
        imageView.setVisibility(0);
        x0xO0oo.II0xO0(x0xO0oo.f24603X00IoxXI, null, 2, null);
        handler = this.this$0.mHandler;
        final BaseMainActivity baseMainActivity = this.this$0;
        handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.main.OOXIXo
            @Override // java.lang.Runnable
            public final void run() {
                BaseMainActivity$checkAppVersion$1.invoke$lambda$1(BaseMainActivity.this, appVersion);
            }
        }, 5000L);
    }
}
