package com.sma.smartv3.ui.me;

import android.os.Handler;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.ToastUtils;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import com.sma.smartv3.biz.UploadFileManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import java.io.File;
import java.util.Date;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* loaded from: classes11.dex */
public final class AboutActivity$onUploadLog$2$1 extends Lambda implements Oox.oIX0oI<Boolean> {
    final /* synthetic */ Ref.ObjectRef<AppUser> $appUser;
    final /* synthetic */ Ref.ObjectRef<String> $identity;
    final /* synthetic */ FrameLayout $shareView;
    final /* synthetic */ com.sma.smartv3.pop.XoI0Ixx0 $this_apply;
    final /* synthetic */ AboutActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AboutActivity$onUploadLog$2$1(AboutActivity aboutActivity, Ref.ObjectRef<AppUser> objectRef, Ref.ObjectRef<String> objectRef2, com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0, FrameLayout frameLayout) {
        super(0);
        this.this$0 = aboutActivity;
        this.$appUser = objectRef;
        this.$identity = objectRef2;
        this.$this_apply = xoI0Ixx0;
        this.$shareView = frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void invoke$lambda$2(Ref.ObjectRef appUser, Ref.ObjectRef identity, AboutActivity this$0, com.sma.smartv3.pop.XoI0Ixx0 this_apply, FrameLayout shareView) {
        File genLogZipFile;
        kotlin.jvm.internal.IIX0o.x0xO0oo(appUser, "$appUser");
        kotlin.jvm.internal.IIX0o.x0xO0oo(identity, "$identity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_apply, "$this_apply");
        kotlin.jvm.internal.IIX0o.x0xO0oo(shareView, "$shareView");
        genLogZipFile = this$0.genLogZipFile(((AppUser) appUser.element).getNickname() + '_' + com.sma.smartv3.util.xoIox.OO0x0xX().format(new Date()) + '_' + ((String) identity.element) + OTAManager.OTA_ZIP_SUFFIX);
        if (genLogZipFile != null) {
            UploadFileManager.f20210oIX0oI.X0o0xo((String) identity.element, genLogZipFile, new AboutActivity$onUploadLog$2$1$2$1$1(genLogZipFile, this$0, this_apply, shareView));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // Oox.oIX0oI
    @OXOo.OOXIXo
    public final Boolean invoke() {
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo;
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2;
        if (UploadFileManager.f20210oIX0oI.oxoX()) {
            i0X0x0oIo = this.this$0.mLoadingPopup;
            if (i0X0x0oIo == null) {
                AboutActivity aboutActivity = this.this$0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3 = new com.sma.smartv3.pop.I0X0x0oIo(this.this$0);
                String string = this.this$0.getString(R.string.upload_waiting_tip);
                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                i0X0x0oIo3.IIX0o(string);
                aboutActivity.mLoadingPopup = i0X0x0oIo3;
            }
            i0X0x0oIo2 = this.this$0.mLoadingPopup;
            if (i0X0x0oIo2 != null) {
                i0X0x0oIo2.IIXOooo();
            }
            Handler handler = new Handler();
            final Ref.ObjectRef<AppUser> objectRef = this.$appUser;
            final Ref.ObjectRef<String> objectRef2 = this.$identity;
            final AboutActivity aboutActivity2 = this.this$0;
            final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = this.$this_apply;
            final FrameLayout frameLayout = this.$shareView;
            handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.II0xO0
                @Override // java.lang.Runnable
                public final void run() {
                    AboutActivity$onUploadLog$2$1.invoke$lambda$2(Ref.ObjectRef.this, objectRef2, aboutActivity2, xoI0Ixx0, frameLayout);
                }
            }, 3000L);
            return Boolean.TRUE;
        }
        ToastUtils.showLong(this.this$0.getString(R.string.upload_limit_tip, 30), new Object[0]);
        return Boolean.TRUE;
    }
}
