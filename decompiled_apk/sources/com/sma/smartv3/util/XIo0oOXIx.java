package com.sma.smartv3.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Pair;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.QrcodeTypeInfo;
import com.szabh.smable3.entity.BleQrcode;
import com.szabh.smable3.entity.BleQrcode2;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.oXIO0o0XI;
import me.devilsen.czxing.code.BarcodeFormat;
import me.devilsen.czxing.code.CodeResult;
import oxOIoIx.oIX0oI;

@kotlin.jvm.internal.XX({"SMAP\nQrcodeUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QrcodeUtils.kt\ncom/sma/smartv3/util/QrcodeUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,214:1\n13309#2,2:215\n1864#3,3:217\n*S KotlinDebug\n*F\n+ 1 QrcodeUtils.kt\ncom/sma/smartv3/util/QrcodeUtils\n*L\n71#1:215,2\n195#1:217,3\n*E\n"})
/* loaded from: classes12.dex */
public final class XIo0oOXIx {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static IIoX0OoI.oIX0oI f24333I0Io = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f24334II0xO0 = 4;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final XIo0oOXIx f24335oIX0oI = new XIo0oOXIx();

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static IIoX0OoI.II0xO0 f24336oxoX;

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements oIX0oI.II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO<String, oXIO0o0XI> f24337II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Context f24338oIX0oI;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(Context context, Oox.oOoXoXO<? super String, oXIO0o0XI> oooxoxo) {
            this.f24338oIX0oI = context;
            this.f24337II0xO0 = oooxoxo;
        }

        @Override // oxOIoIx.oIX0oI.II0xO0
        public void II0xO0(int i, @OXOo.OOXIXo Intent data) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
            if (i == 4) {
                try {
                    Uri data2 = data.getData();
                    if (data2 == null) {
                        return;
                    }
                    String[] strArr = {"_data"};
                    Cursor query = this.f24338oIX0oI.getContentResolver().query(data2, strArr, null, null, null);
                    if (query == null) {
                        return;
                    }
                    query.moveToFirst();
                    String string = query.getString(query.getColumnIndex(strArr[0]));
                    query.close();
                    Bitmap X0o0xo2 = oI00o.oxoX.X0o0xo(string);
                    XIo0oOXIx xIo0oOXIx = XIo0oOXIx.f24335oIX0oI;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(X0o0xo2);
                    String xxIXOIIO2 = xIo0oOXIx.xxIXOIIO(X0o0xo2);
                    if (xxIXOIIO2 == null) {
                        Oox.oOoXoXO<String, oXIO0o0XI> oooxoxo = this.f24337II0xO0;
                        if (oooxoxo != null) {
                            oooxoxo.invoke(null);
                        }
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("Scan -> no result");
                        ToastUtils.showLong(R.string.qrcode_failed);
                        return;
                    }
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("Scan -> result:" + xxIXOIIO2);
                    Oox.oOoXoXO<String, oXIO0o0XI> oooxoxo2 = this.f24337II0xO0;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(xxIXOIIO2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Oox.oOoXoXO<String, oXIO0o0XI> oooxoxo3 = this.f24337II0xO0;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(null);
                    }
                    ToastUtils.showLong(R.string.qrcode_failed);
                }
            }
        }

        @Override // oxOIoIx.oIX0oI.II0xO0
        public void oIX0oI(@OXOo.OOXIXo Activity activity) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
            activity.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void OOXIXo(XIo0oOXIx xIo0oOXIx, Context context, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            oooxoxo = null;
        }
        xIo0oOXIx.xoIox(context, z, oooxoxo);
    }

    public static final void oOoXoXO(final Oox.oOoXoXO oooxoxo, Activity activity, final String str, BarcodeFormat barcodeFormat) {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.util.x0xO
            @Override // java.lang.Runnable
            public final void run() {
                XIo0oOXIx.ooOOo0oXI(str, oooxoxo);
            }
        });
    }

    public static final void ooOOo0oXI(String str, Oox.oOoXoXO oooxoxo) {
        LogUtils.d("Scan -> result:" + str);
        if (oooxoxo != null) {
            oooxoxo.invoke(str);
        }
    }

    public final void I0Io(@OXOo.OOXIXo String content, int i, int i2, @OXOo.OOXIXo File savePath) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        kotlin.jvm.internal.IIX0o.x0xO0oo(savePath, "savePath");
        Bitmap II0XooXoX2 = new IIoX0OoI.II0xO0().II0XooXoX(content, i, i2, BarcodeFormat.QR_CODE);
        if (II0XooXoX2 != null) {
            ImageUtils.save(II0XooXoX2, savePath, Bitmap.CompressFormat.JPEG);
        }
    }

    @OXOo.OOXIXo
    public final byte[] II0XooXoX(@OXOo.OOXIXo List<QrcodeTypeInfo> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        byte[] bArr = new byte[list.size() * 512];
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            QrcodeTypeInfo qrcodeTypeInfo = (QrcodeTypeInfo) obj;
            byte[] byteArray = new BleQrcode2(0, qrcodeTypeInfo.getName(), qrcodeTypeInfo.getWidth(), qrcodeTypeInfo.getData(), 1, null).toByteArray();
            System.arraycopy(byteArray, 0, bArr, i * 512, byteArray.length);
            i = i2;
        }
        return bArr;
    }

    @OXOo.oOoXoXO
    public final byte[] Oxx0IOOO(@OXOo.OOXIXo String content, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        Pair<Integer, byte[]> XO2 = XO(content);
        if (XO2 != null) {
            Object first = XO2.first;
            kotlin.jvm.internal.IIX0o.oO(first, "first");
            int intValue = ((Number) first).intValue();
            Object second = XO2.second;
            kotlin.jvm.internal.IIX0o.oO(second, "second");
            return new BleQrcode(intValue, i, (byte[]) second).toByteArray();
        }
        return null;
    }

    @OXOo.oOoXoXO
    public final IIoX0OoI.II0xO0 X0o0xo() {
        if (f24336oxoX == null) {
            f24336oxoX = new IIoX0OoI.II0xO0();
        }
        return f24336oxoX;
    }

    @OXOo.oOoXoXO
    public final Pair<Integer, byte[]> XO(@OXOo.OOXIXo String content) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        IIoX0OoI.II0xO0 X0o0xo2 = X0o0xo();
        if (X0o0xo2 != null) {
            return X0o0xo2.xxIXOIIO(content, BarcodeFormat.QR_CODE);
        }
        return null;
    }

    @OXOo.oOoXoXO
    public final IIoX0OoI.oIX0oI oxoX() {
        if (f24333I0Io == null) {
            f24333I0Io = new IIoX0OoI.oIX0oI();
            File file = new File(Utils.getApp().getExternalCacheDir(), "Assets/wc");
            String path = new File(file, "detect.prototxt").getPath();
            String path2 = new File(file, "detect.caffemodel").getPath();
            String path3 = new File(file, "sr.prototxt").getPath();
            String path4 = new File(file, "sr.caffemodel").getPath();
            IIoX0OoI.oIX0oI oix0oi = f24333I0Io;
            if (oix0oi != null) {
                oix0oi.oOoXoXO(path, path2, path3, path4);
            }
        }
        return f24333I0Io;
    }

    public final void xoIox(@OXOo.OOXIXo Context context, boolean z, @OXOo.oOoXoXO final Oox.oOoXoXO<? super String, oXIO0o0XI> oooxoxo) {
        String[] list;
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        File file = new File(context.getExternalCacheDir(), "Assets/wc");
        String path = new File(file, "detect.prototxt").getPath();
        String path2 = new File(file, "detect.caffemodel").getPath();
        String path3 = new File(file, "sr.prototxt").getPath();
        String path4 = new File(file, "sr.caffemodel").getPath();
        if (!FileUtils.isFileExists(path) && (list = context.getAssets().list("wc")) != null) {
            for (String str : list) {
                InputStream open = context.getAssets().open("wc" + IOUtils.DIR_SEPARATOR_UNIX + str);
                kotlin.jvm.internal.IIX0o.oO(open, "open(...)");
                FileIOUtils.writeFileFromIS(new File(file, str), open);
            }
        }
        Resources resources = context.getResources();
        OxIxx0.II0xO0.oIX0oI(context).XO(oI00o.II0xO0.II0xO0(context, 240.0f)).II0XooXoX(resources.getColor(R.color.light)).IXxxXO(CollectionsKt__CollectionsKt.X00IoxXI(Integer.valueOf(resources.getColor(R.color.scan_side)), Integer.valueOf(resources.getColor(R.color.scan_partial)), Integer.valueOf(resources.getColor(R.color.scan_middle)))).oxoX(BarcodeFormat.QR_CODE).OxxIIOOXO("").IIXOooo(z).oI0IIXIo("").ooOOo0oXI("").OOXIXo("").oOoXoXO(R.drawable.ic_highlight_blue_open_24dp).xoIox(R.drawable.ic_highlight_white_close_24dp).II0xO0(path, path2).o00(path3, path4).I0Io(false).x0xO0oo(new oIX0oI(context, oooxoxo)).Oo(new oIX0oI.I0Io() { // from class: com.sma.smartv3.util.OO0x0xX
            @Override // oxOIoIx.oIX0oI.I0Io
            public final void oIX0oI(Activity activity, String str2, BarcodeFormat barcodeFormat) {
                XIo0oOXIx.oOoXoXO(Oox.oOoXoXO.this, activity, str2, barcodeFormat);
            }
        }).xoXoI();
    }

    @OXOo.oOoXoXO
    public final String xxIXOIIO(@OXOo.OOXIXo Bitmap bitmap) {
        List<CodeResult> list;
        CodeResult codeResult;
        kotlin.jvm.internal.IIX0o.x0xO0oo(bitmap, "bitmap");
        IIoX0OoI.oIX0oI oxoX2 = oxoX();
        if (oxoX2 != null) {
            list = oxoX2.II0xO0(bitmap);
        } else {
            list = null;
        }
        if (list == null || (codeResult = (CodeResult) CollectionsKt___CollectionsKt.OIoxIx(list, 0)) == null) {
            return null;
        }
        return codeResult.getText();
    }
}
