package com.sma.smartv3.util;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.blankj.utilcode.util.Utils;
import com.sma.smartv3.co_fit.R;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* loaded from: classes12.dex */
public final class Ioxxx {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static IWXAPI f24256II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Ioxxx f24257oIX0oI = new Ioxxx();

    public static /* synthetic */ void II0XooXoX(Ioxxx ioxxx, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        ioxxx.Oxx0IOOO(str, i);
    }

    public static /* synthetic */ void xoIox(Ioxxx ioxxx, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        ioxxx.xxIXOIIO(str, i);
    }

    public final boolean I0Io() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    public final String II0xO0(String str) {
        return str + System.currentTimeMillis();
    }

    public final void OOXIXo(@OXOo.oOoXoXO IWXAPI iwxapi) {
        f24256II0xO0 = iwxapi;
    }

    public final void Oxx0IOOO(@OXOo.OOXIXo String imagePath, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(imagePath, "imagePath");
        if (f24256II0xO0 == null) {
            f24256II0xO0 = WXAPIFactory.createWXAPI(Utils.getApp(), UtilsKt.oI0IIXIo(R.string.we_chat_app_id), false);
        }
        WXImageObject wXImageObject = new WXImageObject();
        if (oxoX() && I0Io()) {
            Application app = Utils.getApp();
            kotlin.jvm.internal.IIX0o.oO(app, "getApp(...)");
            wXImageObject.imagePath = XO(app, new File(imagePath));
        } else {
            wXImageObject.imagePath = imagePath;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        Bitmap decodeFile = BitmapFactory.decodeFile(imagePath);
        if (decodeFile.getHeight() > decodeFile.getWidth()) {
            decodeFile = Bitmap.createBitmap(decodeFile, 0, (decodeFile.getHeight() - decodeFile.getWidth()) / 2, decodeFile.getWidth(), (int) (decodeFile.getWidth() * 0.7d));
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, decodeFile.getWidth() / 20, decodeFile.getHeight() / 20, true);
        kotlin.jvm.internal.IIX0o.oO(createScaledBitmap, "createScaledBitmap(...)");
        decodeFile.recycle();
        wXMediaMessage.thumbData = oIX0oI(createScaledBitmap, true);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = II0xO0("img");
        req.message = wXMediaMessage;
        req.scene = i;
        IWXAPI iwxapi = f24256II0xO0;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(iwxapi);
        iwxapi.sendReq(req);
    }

    @OXOo.oOoXoXO
    public final IWXAPI X0o0xo() {
        return f24256II0xO0;
    }

    @OXOo.oOoXoXO
    public final String XO(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO File file) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        if (file != null && file.exists()) {
            Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
            kotlin.jvm.internal.IIX0o.oO(uriForFile, "getUriForFile(...)");
            context.grantUriPermission("com.tencent.mm", uriForFile, 1);
            return uriForFile.toString();
        }
        return null;
    }

    public final byte[] oIX0oI(Bitmap bitmap, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        if (z) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        kotlin.jvm.internal.IIX0o.oO(byteArray, "toByteArray(...)");
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArray;
    }

    public final boolean oxoX() {
        IWXAPI iwxapi = f24256II0xO0;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(iwxapi);
        if (iwxapi.getWXAppSupportAPI() >= 654314752) {
            return true;
        }
        return false;
    }

    public final void xxIXOIIO(@OXOo.OOXIXo String text, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
        if (f24256II0xO0 == null) {
            f24256II0xO0 = WXAPIFactory.createWXAPI(Utils.getApp(), UtilsKt.oI0IIXIo(R.string.we_chat_app_id), false);
        }
        WXTextObject wXTextObject = new WXTextObject();
        wXTextObject.text = text;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = text;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = II0xO0("text");
        req.message = wXMediaMessage;
        req.scene = i;
        IWXAPI iwxapi = f24256II0xO0;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(iwxapi);
        iwxapi.sendReq(req);
    }
}
