package com.sma.smartv3.ui.device;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.co_fit.R;
import java.io.File;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes12.dex */
public final class QrcodeSyncActivity$onActivityResult$1 extends Lambda implements Oox.oIX0oI<kotlin.oXIO0o0XI> {
    final /* synthetic */ Intent $data;
    final /* synthetic */ QrcodeSyncActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrcodeSyncActivity$onActivityResult$1(QrcodeSyncActivity qrcodeSyncActivity, Intent intent) {
        super(0);
        this.this$0 = qrcodeSyncActivity;
        this.$data = intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(QrcodeSyncActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this$0.mLoadingPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(QrcodeSyncActivity this$0) {
        com.sma.smartv3.pop.xx0X0 xx0x0;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        xx0x0 = this$0.mSelectPopup;
        if (xx0x0 != null) {
            xx0x0.dismiss();
        }
        this$0.showLoading();
    }

    @Override // Oox.oIX0oI
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
        invoke2();
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        try {
            File file = new File(com.sma.smartv3.initializer.IXxxXO.oo(X00IoxXI.oIX0oI.f3233oIX0oI), "qrtmp.jpg");
            ContentResolver contentResolver = this.this$0.getContentResolver();
            Intent intent = this.$data;
            ImageUtils.save(MediaStore.Images.Media.getBitmap(contentResolver, intent != null ? intent.getData() : null), file, Bitmap.CompressFormat.JPEG);
            Bitmap X0o0xo2 = oI00o.oxoX.X0o0xo(file.getPath());
            com.sma.smartv3.util.XIo0oOXIx xIo0oOXIx = com.sma.smartv3.util.XIo0oOXIx.f24335oIX0oI;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(X0o0xo2);
            String xxIXOIIO2 = xIo0oOXIx.xxIXOIIO(X0o0xo2);
            LogUtils.d("syncQrcode -> parseQrcodeResult:" + xxIXOIIO2);
            if (xxIXOIIO2 != null) {
                this.this$0.syncQrcode(xxIXOIIO2);
                return;
            }
            ToastUtils.showLong(R.string.qrcode_failed);
            final QrcodeSyncActivity qrcodeSyncActivity = this.this$0;
            qrcodeSyncActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.xIx
                @Override // java.lang.Runnable
                public final void run() {
                    QrcodeSyncActivity$onActivityResult$1.invoke$lambda$1(QrcodeSyncActivity.this);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            final QrcodeSyncActivity qrcodeSyncActivity2 = this.this$0;
            qrcodeSyncActivity2.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.oXO0oOx0
                @Override // java.lang.Runnable
                public final void run() {
                    QrcodeSyncActivity$onActivityResult$1.invoke$lambda$2(QrcodeSyncActivity.this);
                }
            });
        }
    }
}
