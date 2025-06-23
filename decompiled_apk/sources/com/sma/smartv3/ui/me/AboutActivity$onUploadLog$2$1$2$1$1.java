package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.IntentUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.permission.PermissionHelper;
import java.io.File;

/* loaded from: classes11.dex */
public final class AboutActivity$onUploadLog$2$1$2$1$1 implements xxxI.II0xO0<String> {

    /* renamed from: I0Io, reason: collision with root package name */
    public final /* synthetic */ com.sma.smartv3.pop.XoI0Ixx0 f23109I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ AboutActivity f23110II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ File f23111oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f23112oxoX;

    public AboutActivity$onUploadLog$2$1$2$1$1(File file, AboutActivity aboutActivity, com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0, FrameLayout frameLayout) {
        this.f23111oIX0oI = file;
        this.f23110II0xO0 = aboutActivity;
        this.f23109I0Io = xoI0Ixx0;
        this.f23112oxoX = frameLayout;
    }

    public static final void I0Io(com.sma.smartv3.pop.XoI0Ixx0 this_apply, final AboutActivity this$0, final FrameLayout shareView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_apply, "$this_apply");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(shareView, "$shareView");
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this_apply.Oxx0IOOO(), 0, 2, null);
        xoI0Ixx0.IoOoX(R.string.upload_successful);
        xoI0Ixx0.xI(Integer.valueOf(R.string.share_log_tip));
        xoI0Ixx0.x0xO0oo(false);
        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
        xoI0Ixx0.x0o(R.string.share, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.AboutActivity$onUploadLog$2$1$2$1$1$handleResponse$1$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                Activity mContext;
                PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
                mContext = AboutActivity.this.getMContext();
                final FrameLayout frameLayout = shareView;
                final AboutActivity aboutActivity = AboutActivity.this;
                permissionHelper.II0xO0(mContext, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.AboutActivity$onUploadLog$2$1$2$1$1$handleResponse$1$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }

                    public final void invoke(boolean z) {
                        File save2Album;
                        if (!z || (save2Album = ImageUtils.save2Album(ImageUtils.view2Bitmap(frameLayout), Bitmap.CompressFormat.JPEG)) == null) {
                            return;
                        }
                        aboutActivity.startActivity(Intent.createChooser(IntentUtils.getShareImageIntent(save2Album), "Share Log"));
                    }
                });
                return Boolean.TRUE;
            }
        });
        xoI0Ixx0.IIXOooo();
    }

    @Override // xxxI.II0xO0
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public void handleResponse(@OXOo.oOoXoXO String str) {
        FileUtils.delete(this.f23111oIX0oI);
        this.f23110II0xO0.dismissLoadPopup();
        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24359IIX0, System.currentTimeMillis());
        final AboutActivity aboutActivity = this.f23110II0xO0;
        final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = this.f23109I0Io;
        final FrameLayout frameLayout = this.f23112oxoX;
        aboutActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.me.I0Io
            @Override // java.lang.Runnable
            public final void run() {
                AboutActivity$onUploadLog$2$1$2$1$1.I0Io(com.sma.smartv3.pop.XoI0Ixx0.this, aboutActivity, frameLayout);
            }
        });
    }

    @Override // xxxI.II0xO0
    public void handleError(@OXOo.OOXIXo String error) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
        FileUtils.delete(this.f23111oIX0oI);
        this.f23110II0xO0.dismissLoadPopup();
        ToastUtils.showLong(this.f23110II0xO0.getString(R.string.upload_failed), new Object[0]);
    }
}
