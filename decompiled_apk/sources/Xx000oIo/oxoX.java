package Xx000oIo;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.FileUtils;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.PickVisualMediaRequestKt;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bestmafen.androidbase.io.Location;
import com.blankj.utilcode.util.LogUtils;
import com.garmin.fit.X0xOO;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.initializer.IXxxXO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nCrop.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Crop.kt\ncom/bestmafen/androidbase/function/Crop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,271:1\n1#2:272\n1855#3,2:273\n*S KotlinDebug\n*F\n+ 1 Crop.kt\ncom/bestmafen/androidbase/function/Crop\n*L\n148#1:273,2\n*E\n"})
/* loaded from: classes8.dex */
public final class oxoX {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f4188Oxx0IOOO = 253;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f4189X0o0xo = 255;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f4190XO = 254;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f4191oxoX = new oIX0oI(null);

    /* renamed from: I0Io, reason: collision with root package name */
    @oOoXoXO
    public ActivityResultLauncher<PickVisualMediaRequest> f4192I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final II0xO0 f4193II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final Object f4194oIX0oI;

    /* loaded from: classes8.dex */
    public interface II0xO0 {
        void II0xO0(@OOXIXo Uri uri);

        @OOXIXo
        Uri getResult();

        @OOXIXo
        Uri oIX0oI();
    }

    /* loaded from: classes8.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public oxoX(@OOXIXo Object mCaller, @OOXIXo II0xO0 mCropListener) {
        IIX0o.x0xO0oo(mCaller, "mCaller");
        IIX0o.x0xO0oo(mCropListener, "mCropListener");
        this.f4194oIX0oI = mCaller;
        this.f4193II0xO0 = mCropListener;
        if (oxoX(mCaller)) {
        } else {
            throw new IllegalArgumentException("Caller must be Activity or Fragment");
        }
    }

    public static /* synthetic */ void II0XooXoX(oxoX oxox, int i, int i2, Intent intent, double d, double d2, int i3, int i4, int i5, Object obj) {
        double d3;
        double d4;
        int i6;
        int i7;
        if ((i5 & 8) != 0) {
            d3 = 1.0d;
        } else {
            d3 = d;
        }
        if ((i5 & 16) != 0) {
            d4 = 1.0d;
        } else {
            d4 = d2;
        }
        if ((i5 & 32) != 0) {
            i6 = X0xOO.f13583O0o0;
        } else {
            i6 = i3;
        }
        if ((i5 & 64) != 0) {
            i7 = X0xOO.f13583O0o0;
        } else {
            i7 = i4;
        }
        oxox.Oxx0IOOO(i, i2, intent, d3, d4, i6, i7);
    }

    public static final void Oo(Oox.oOoXoXO oooxoxo, oxoX this$0, Uri uri) {
        IIX0o.x0xO0oo(this$0, "this$0");
        LogUtils.d("pickMedia result:" + uri);
        if (uri != null) {
            if (oooxoxo == null) {
                II0XooXoX(this$0, 254, -1, new Intent().setData(uri), XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0, 0, 120, null);
            } else {
                oooxoxo.invoke(uri);
            }
        }
    }

    public static /* synthetic */ void XO(oxoX oxox, Uri uri, double d, double d2, int i, int i2, int i3, Object obj) {
        double d3;
        int i4;
        double d4 = 1.0d;
        if ((i3 & 2) != 0) {
            d3 = 1.0d;
        } else {
            d3 = d;
        }
        if ((i3 & 4) == 0) {
            d4 = d2;
        }
        int i5 = i3 & 8;
        int i6 = X0xOO.f13583O0o0;
        if (i5 != 0) {
            i4 = X0xOO.f13583O0o0;
        } else {
            i4 = i;
        }
        if ((i3 & 16) == 0) {
            i6 = i2;
        }
        oxox.X0o0xo(uri, d3, d4, i4, i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void oO(oxoX oxox, FragmentActivity fragmentActivity, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        oxox.ooOOo0oXI(fragmentActivity, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void x0XOIxOo(oxoX oxox, Fragment fragment, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        oxox.oOoXoXO(fragment, oooxoxo);
    }

    public static final void x0xO0oo(Oox.oOoXoXO oooxoxo, oxoX this$0, Uri uri) {
        IIX0o.x0xO0oo(this$0, "this$0");
        LogUtils.d("pickMedia result:" + uri);
        if (uri != null) {
            if (oooxoxo == null) {
                II0XooXoX(this$0, 254, -1, new Intent().setData(uri), XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0, 0, 120, null);
            } else {
                oooxoxo.invoke(uri);
            }
        }
    }

    public final void I0Io() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
            intent.addFlags(2);
        }
        intent.putExtra("output", this.f4193II0xO0.oIX0oI());
        IXxxXO(this.f4194oIX0oI, intent, 255);
    }

    public final void IXxxXO(Object obj, Intent intent, int i) {
        try {
            if (obj instanceof Activity) {
                ((Activity) obj).startActivityForResult(intent, i);
            } else {
                IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
                ((Fragment) obj).startActivityForResult(intent, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void OOXIXo() {
        ActivityResultLauncher<PickVisualMediaRequest> activityResultLauncher = this.f4192I0Io;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(PickVisualMediaRequestKt.PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE));
        }
    }

    public final void Oxx0IOOO(int i, int i2, @oOoXoXO Intent intent, double d, double d2, int i3, int i4) {
        LogUtils.d("onActivityResult " + i + TokenParser.SP + i2 + TokenParser.SP + d + TokenParser.SP + d2 + TokenParser.SP + i3 + TokenParser.SP + i4);
        if (i2 == -1) {
            switch (i) {
                case 253:
                    II0xO0 iI0xO0 = this.f4193II0xO0;
                    iI0xO0.II0xO0(iI0xO0.getResult());
                    return;
                case 254:
                    IIX0o.ooOOo0oXI(intent);
                    X0o0xo(intent.getData(), d, d2, i3, i4);
                    return;
                case 255:
                    X0o0xo(this.f4193II0xO0.oIX0oI(), d, d2, i3, i4);
                    return;
                default:
                    return;
            }
        }
    }

    @RequiresApi(29)
    @oOoXoXO
    public final File Oxx0xo(@OOXIXo Context context, @OOXIXo Uri uri, @OOXIXo Uri toFileUri) {
        InputStream inputStream;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(uri, "uri");
        IIX0o.x0xO0oo(toFileUri, "toFileUri");
        LogUtils.d("uriToFileQ -> uri = " + uri + " , toFileUri = " + toFileUri);
        String scheme = uri.getScheme();
        if (scheme != null) {
            int hashCode = scheme.hashCode();
            if (hashCode != 3143036) {
                if (hashCode == 951530617 && scheme.equals("content")) {
                    inputStream = context.getContentResolver().openInputStream(uri);
                }
            } else if (scheme.equals("file")) {
                inputStream = new FileInputStream(uri.getPath());
            }
            if (inputStream != null || !IIX0o.Oxx0IOOO(toFileUri.getScheme(), "file")) {
                return null;
            }
            String path = toFileUri.getPath();
            if (path != null) {
                File file = new File(path);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                FileUtils.copy(inputStream, fileOutputStream);
                fileOutputStream.close();
                inputStream.close();
                return file;
            }
            throw new IllegalArgumentException("Required value was null.");
        }
        inputStream = null;
        if (inputStream != null) {
        }
        return null;
    }

    public final void X0o0xo(@oOoXoXO Uri uri, double d, double d2, int i, int i2) {
        LogUtils.d("crop -> pic = " + uri);
        Intent intent = new Intent("com.android.camera.action.CROP");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            intent.addFlags(1);
            intent.addFlags(2);
        }
        intent.putExtra("crop", "true");
        intent.putExtra("scale", "true");
        intent.putExtra("scaleUpIfNeeded", true);
        if (d == d2) {
            intent.putExtra("aspectX", (int) d);
            intent.putExtra("aspectY", (int) d2);
        } else {
            intent.putExtra("aspectX", i);
            intent.putExtra("aspectY", i2);
        }
        intent.putExtra("outputX", i);
        intent.putExtra("outputY", i2);
        intent.putExtra("return-data", false);
        if (i3 >= 29) {
            Object obj = this.f4194oIX0oI;
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type android.content.Context");
            IIX0o.ooOOo0oXI(uri);
            Uri fromFile = Uri.fromFile(xxIXOIIO());
            IIX0o.oO(fromFile, "fromFile(...)");
            File Oxx0xo2 = Oxx0xo((Context) obj, uri, fromFile);
            Context context = (Context) this.f4194oIX0oI;
            String str = ((Context) this.f4194oIX0oI).getPackageName() + ".fileprovider";
            IIX0o.ooOOo0oXI(Oxx0xo2);
            Uri uriForFile = FileProvider.getUriForFile(context, str, Oxx0xo2);
            LogUtils.d("pic.scheme  = " + uri.getScheme());
            if (IIX0o.Oxx0IOOO(uri.getScheme(), "file")) {
                intent.setDataAndType(FileProvider.getUriForFile((Context) this.f4194oIX0oI, ((Context) this.f4194oIX0oI).getPackageName() + ".fileprovider", new File(uri.getPath())), "image/*");
            } else {
                intent.setDataAndType(uriForFile, "image/*");
            }
            File Oxx0xo3 = Oxx0xo((Context) this.f4194oIX0oI, uri, this.f4193II0xO0.getResult());
            Context context2 = (Context) this.f4194oIX0oI;
            String str2 = ((Context) this.f4194oIX0oI).getPackageName() + ".fileprovider";
            IIX0o.ooOOo0oXI(Oxx0xo3);
            Uri uriForFile2 = FileProvider.getUriForFile(context2, str2, Oxx0xo3);
            intent.putExtra("output", uriForFile2);
            List<ResolveInfo> queryIntentActivities = ((Context) this.f4194oIX0oI).getPackageManager().queryIntentActivities(intent, 65536);
            IIX0o.oO(queryIntentActivities, "queryIntentActivities(...)");
            Iterator<T> it = queryIntentActivities.iterator();
            while (it.hasNext()) {
                String str3 = ((ResolveInfo) it.next()).activityInfo.packageName;
                ((Context) this.f4194oIX0oI).grantUriPermission(str3, uriForFile, 3);
                ((Context) this.f4194oIX0oI).grantUriPermission(str3, uriForFile2, 3);
                LogUtils.d("crop  grantUriPermission " + uriForFile + " to " + str3);
            }
        } else {
            intent.setDataAndType(uri, "image/*");
            intent.putExtra("output", this.f4193II0xO0.getResult());
        }
        IXxxXO(this.f4194oIX0oI, intent, 253);
    }

    public final void oOoXoXO(@OOXIXo Fragment caller, @oOoXoXO final Oox.oOoXoXO<? super Uri, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(caller, "caller");
        this.f4192I0Io = caller.registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: Xx000oIo.II0xO0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                oxoX.Oo(Oox.oOoXoXO.this, this, (Uri) obj);
            }
        });
    }

    public final void ooOOo0oXI(@OOXIXo FragmentActivity caller, @oOoXoXO final Oox.oOoXoXO<? super Uri, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(caller, "caller");
        this.f4192I0Io = caller.registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: Xx000oIo.I0Io
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                oxoX.x0xO0oo(Oox.oOoXoXO.this, this, (Uri) obj);
            }
        });
    }

    public final boolean oxoX(Object obj) {
        if (!(obj instanceof Activity) && !(obj instanceof Fragment)) {
            return false;
        }
        return true;
    }

    public final void xoIox() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.setType("image/*");
        IXxxXO(this.f4194oIX0oI, intent, 254);
    }

    public final File xxIXOIIO() {
        File oIX0oI2 = X00IoxXI.oIX0oI.f3233oIX0oI.oIX0oI(Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0(IXxxXO.f20835I0Io), "output.png");
        com.blankj.utilcode.util.FileUtils.createOrExistsFile(oIX0oI2);
        return oIX0oI2;
    }
}
