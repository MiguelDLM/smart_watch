package com.sma.smartv3.ui.sport;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.UriUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.text.PFMedium;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@kotlin.jvm.internal.XX({"SMAP\nMapShareActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapShareActivity.kt\ncom/sma/smartv3/ui/sport/MapShareActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n*L\n1#1,310:1\n1#2:311\n1#2:319\n1#2:338\n173#3,7:312\n180#3,3:320\n143#3,7:323\n183#3:330\n173#3,7:331\n180#3,3:339\n143#3,7:342\n183#3:349\n*S KotlinDebug\n*F\n+ 1 MapShareActivity.kt\ncom/sma/smartv3/ui/sport/MapShareActivity\n*L\n258#1:319\n262#1:338\n258#1:312,7\n258#1:320,3\n258#1:323,7\n258#1:330\n262#1:331,7\n262#1:339,3\n262#1:342,7\n262#1:349\n*E\n"})
/* loaded from: classes12.dex */
public final class MapShareActivity extends BaseActivity {
    public static final int CODE_CARD_IMAGE = 2;
    public static final int CODE_LONG_IMAGE = 1;
    public static final int CODE_VIDEO = 3;

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    @OXOo.OOXIXo
    private File mIntentFile;

    @OXOo.OOXIXo
    private File mIntentFileVideo;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleCenter$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.MapShareActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) MapShareActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO shareMapImage$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.MapShareActivity$shareMapImage$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) MapShareActivity.this.findViewById(R.id.share_map_image);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO shareMapWxLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.MapShareActivity$shareMapWxLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return MapShareActivity.this.findViewById(R.id.share_map_wx_pyq_layout);
        }
    });

    @OXOo.OOXIXo
    private final SimpleDateFormat mFormat = com.sma.smartv3.util.xoIox.x0o();
    private int mActivityType = 1;

    @OXOo.OOXIXo
    private String mIntentType = "image/*";

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public MapShareActivity() {
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        this.mIntentFile = com.sma.smartv3.initializer.IXxxXO.oxXx0IX(oix0oi);
        this.mIntentFileVideo = com.sma.smartv3.initializer.IXxxXO.oxXx0IX(oix0oi);
    }

    private final boolean copyMp4File() {
        try {
            File x0xO2 = com.sma.smartv3.initializer.IXxxXO.x0xO(X00IoxXI.oIX0oI.f3233oIX0oI, "MapVideo" + getMArg1() + '_' + Utils.getApp().getResources().getConfiguration().locale.getLanguage() + ".mp4");
            if (!FileUtils.copy(this.mIntentFileVideo, x0xO2)) {
                return false;
            }
            FileUtils.notifySystemToScan(x0xO2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00bd A[Catch: all -> 0x00a1, TRY_ENTER, TryCatch #0 {all -> 0x00a1, blocks: (B:11:0x007f, B:13:0x0095, B:14:0x00a6, B:21:0x00bd, B:22:0x00c8), top: B:7:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d9 A[Catch: IOException -> 0x00b6, TRY_ENTER, TryCatch #2 {IOException -> 0x00b6, blocks: (B:15:0x00af, B:24:0x00d9, B:25:0x00dc), top: B:7:0x006a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void shareFile(java.lang.String r8, android.graphics.Bitmap r9, java.lang.String r10) {
        /*
            r7 = this;
            X00IoxXI.oIX0oI r0 = X00IoxXI.oIX0oI.f3233oIX0oI
            java.io.File r0 = com.sma.smartv3.initializer.IXxxXO.x0xO(r0, r8)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            r3 = 2132021723(0x7f1411db, float:1.9681845E38)
            r4 = 0
            if (r1 >= r2) goto L23
            android.graphics.Bitmap$CompressFormat r8 = android.graphics.Bitmap.CompressFormat.JPEG
            com.blankj.utilcode.util.ImageUtils.save(r9, r0, r8)
            com.blankj.utilcode.util.FileUtils.notifySystemToScan(r0)
            java.lang.String r8 = r7.getString(r3)
            java.lang.Object[] r9 = new java.lang.Object[r4]
            com.blankj.utilcode.util.ToastUtils.showLong(r8, r9)
            goto Ldf
        L23:
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r1 = "_display_name"
            r0.put(r1, r8)
            java.lang.String r8 = "mime_type"
            r0.put(r8, r10)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = android.os.Environment.DIRECTORY_DCIM
            r8.append(r10)
            r10 = 47
            r8.append(r10)
            java.lang.String r10 = com.blankj.utilcode.util.AppUtils.getAppName()
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.lang.String r10 = "relative_path"
            r0.put(r10, r8)
            r8 = 1
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r10 = "is_pending"
            r0.put(r10, r8)
            android.app.Application r8 = com.blankj.utilcode.util.Utils.getApp()
            android.content.ContentResolver r8 = r8.getContentResolver()
            android.net.Uri r1 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            android.net.Uri r8 = r8.insert(r1, r0)
            r1 = 0
            if (r8 == 0) goto L7e
            android.app.Application r2 = com.blankj.utilcode.util.Utils.getApp()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            java.io.OutputStream r2 = r2.openOutputStream(r8)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            goto L7f
        L79:
            r8 = move-exception
            goto Le0
        L7b:
            r10 = move-exception
            r2 = r1
            goto Lbb
        L7e:
            r2 = r1
        L7f:
            android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r2)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            r6 = 100
            r9.compress(r5, r6, r2)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            r0.clear()     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            r0.put(r10, r5)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            if (r8 == 0) goto La6
            android.app.Application r10 = com.blankj.utilcode.util.Utils.getApp()     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            r10.update(r8, r0, r1, r1)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            goto La6
        La1:
            r8 = move-exception
            r1 = r2
            goto Le0
        La4:
            r10 = move-exception
            goto Lbb
        La6:
            java.lang.String r10 = r7.getString(r3)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            com.blankj.utilcode.util.ToastUtils.showLong(r10, r0)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            r2.close()     // Catch: java.io.IOException -> Lb6
            r9.recycle()     // Catch: java.io.IOException -> Lb6
            goto Ldf
        Lb6:
            r8 = move-exception
            r8.printStackTrace()
            goto Ldf
        Lbb:
            if (r8 == 0) goto Lc8
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()     // Catch: java.lang.Throwable -> La1
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> La1
            r0.delete(r8, r1, r1)     // Catch: java.lang.Throwable -> La1
        Lc8:
            r10.printStackTrace()     // Catch: java.lang.Throwable -> La1
            r8 = 2132018524(0x7f14055c, float:1.9675357E38)
            java.lang.String r8 = r7.getString(r8)     // Catch: java.lang.Throwable -> La1
            java.lang.Object[] r10 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> La1
            com.blankj.utilcode.util.ToastUtils.showLong(r8, r10)     // Catch: java.lang.Throwable -> La1
            if (r2 == 0) goto Ldc
            r2.close()     // Catch: java.io.IOException -> Lb6
        Ldc:
            r9.recycle()     // Catch: java.io.IOException -> Lb6
        Ldf:
            return
        Le0:
            if (r1 == 0) goto Le8
            r1.close()     // Catch: java.io.IOException -> Le6
            goto Le8
        Le6:
            r9 = move-exception
            goto Lec
        Le8:
            r9.recycle()     // Catch: java.io.IOException -> Le6
            goto Lef
        Lec:
            r9.printStackTrace()
        Lef:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.sport.MapShareActivity.shareFile(java.lang.String, android.graphics.Bitmap, java.lang.String):void");
    }

    public static /* synthetic */ void shareFile$default(MapShareActivity mapShareActivity, String str, Bitmap bitmap, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "image/*";
        }
        mapShareActivity.shareFile(str, bitmap, str2);
    }

    public final PFMedium getAbhTitleCenter() {
        return (PFMedium) this.abhTitleCenter$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final File getMIntentFile() {
        return this.mIntentFile;
    }

    @OXOo.OOXIXo
    public final File getMIntentFileVideo() {
        return this.mIntentFileVideo;
    }

    @OXOo.OOXIXo
    public final String getMIntentType() {
        return this.mIntentType;
    }

    public final ImageView getShareMapImage() {
        return (ImageView) this.shareMapImage$delegate.getValue();
    }

    public final View getShareMapWxLayout() {
        return (View) this.shareMapWxLayout$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    public final void initBitmap() {
        Bitmap decodeFile = BitmapFactory.decodeFile(this.mIntentFile.getAbsolutePath());
        ViewGroup.LayoutParams layoutParams = getShareMapImage().getLayoutParams();
        layoutParams.height = decodeFile.getHeight();
        getShareMapImage().setLayoutParams(layoutParams);
        Glide.with((FragmentActivity) this).load(decodeFile).into(getShareMapImage());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (!projectManager.oXxx000()) {
            findViewById(R.id.share_map_image_ll2).setVisibility(0);
            findViewById(R.id.share_map_video_ll2).setVisibility(0);
            findViewById(R.id.share_map_btn_ll).setVisibility(8);
        }
        getAbhTitleCenter().setText(getString(R.string.share));
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(getMArg0(), "1")) {
            findViewById(R.id.share_map_video_ll).setVisibility(4);
            findViewById(R.id.share_map_video_ll2).setVisibility(8);
        } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(getMArg0(), "3")) {
            this.mActivityType = 3;
            this.mIntentType = "video/*";
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            this.mIntentFileVideo = new File(com.sma.smartv3.initializer.IXxxXO.XoX(oix0oi), "mapVideo" + getMArg1() + '_' + Utils.getApp().getResources().getConfiguration().locale.getLanguage() + ".mp4");
            this.mIntentFile = com.sma.smartv3.initializer.IXxxXO.oxXx0IX(oix0oi);
            videoHideView();
        }
        initBitmap();
        if (!projectManager.oXxx000()) {
            findViewById(R.id.share_map_wx_layout).setVisibility(8);
            findViewById(R.id.share_map_wx_pyq_layout).setVisibility(8);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_share_map;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            this.mActivityType = i;
            LogUtils.d("onActivityResult requestCode=" + i);
            String str = "image/*";
            if (i != 2) {
                if (i != 3) {
                    this.mIntentFile = com.sma.smartv3.initializer.IXxxXO.oxXx0IX(X00IoxXI.oIX0oI.f3233oIX0oI);
                } else {
                    X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                    this.mIntentFileVideo = new File(com.sma.smartv3.initializer.IXxxXO.XoX(oix0oi), "mapVideo" + getMArg1() + '_' + Utils.getApp().getResources().getConfiguration().locale.getLanguage() + ".mp4");
                    this.mIntentFile = com.sma.smartv3.initializer.IXxxXO.oxXx0IX(oix0oi);
                    videoHideView();
                    str = "video/*";
                }
            } else {
                this.mIntentFile = com.sma.smartv3.initializer.IXxxXO.xo0x(X00IoxXI.oIX0oI.f3233oIX0oI);
                findViewById(R.id.share_map_btn_ll).setVisibility(8);
                findViewById(R.id.share_map_image_ll2).setVisibility(8);
                findViewById(R.id.share_map_video_ll2).setVisibility(8);
            }
            this.mIntentType = str;
            initBitmap();
        }
    }

    public final void onSaveImage(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mActivityType == 3) {
            if (copyMp4File()) {
                ToastUtils.showLong(getString(R.string.success_save), new Object[0]);
                return;
            } else {
                ToastUtils.showLong(getString(R.string.fail), new Object[0]);
                return;
            }
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(this.mIntentFile.getPath());
        String str = this.mFormat.format(new Date()) + ".jpg";
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(decodeFile);
        shareFile$default(this, str, decodeFile, (String) null, 4, (Object) null);
    }

    public final void onShareCardImage(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        int mArg1 = getMArg1();
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", mArg1);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) ShareCardActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 2);
    }

    public final void onShareMore(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", "");
        if (this.mActivityType == 3) {
            intent.putExtra("android.intent.extra.STREAM", UriUtils.file2Uri(this.mIntentFileVideo));
        } else {
            intent.putExtra("android.intent.extra.STREAM", UriUtils.file2Uri(this.mIntentFile));
        }
        intent.setType(this.mIntentType);
        Intent createChooser = Intent.createChooser(intent, "");
        kotlin.jvm.internal.IIX0o.oO(createChooser, "createChooser(...)");
        createChooser.addFlags(268435456);
        startActivity(createChooser);
    }

    public final void onShareVideo(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        int mArg1 = getMArg1();
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", mArg1);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) ShareVideoActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 3);
    }

    public final void onShareWeChat(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
        if (this.mActivityType == 3) {
            shareFile$default(this, componentName, this.mIntentFileVideo, (String) null, 4, (Object) null);
            return;
        }
        com.sma.smartv3.util.Ioxxx ioxxx = com.sma.smartv3.util.Ioxxx.f24257oIX0oI;
        String absolutePath = this.mIntentFile.getAbsolutePath();
        kotlin.jvm.internal.IIX0o.oO(absolutePath, "getAbsolutePath(...)");
        com.sma.smartv3.util.Ioxxx.II0XooXoX(ioxxx, absolutePath, 0, 2, null);
    }

    public final void onShareWechatMoments(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI");
        if (this.mActivityType == 3) {
            copyMp4File();
            ComponentName componentName2 = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setComponent(componentName2);
            startActivity(intent);
            return;
        }
        shareFile$default(this, componentName, (File) null, (String) null, 6, (Object) null);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void setMIntentFile(@OXOo.OOXIXo File file) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(file, "<set-?>");
        this.mIntentFile = file;
    }

    public final void setMIntentFileVideo(@OXOo.OOXIXo File file) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(file, "<set-?>");
        this.mIntentFileVideo = file;
    }

    public final void setMIntentType(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.mIntentType = str;
    }

    public final void videoHideView() {
        findViewById(R.id.share_map_btn_ll).setVisibility(8);
        findViewById(R.id.share_map_wx_layout).setVisibility(8);
        findViewById(R.id.share_map_wx_pyq_layout).setVisibility(8);
        findViewById(R.id.share_map_image_ll2).setVisibility(8);
        findViewById(R.id.share_map_video_ll2).setVisibility(8);
    }

    public static /* synthetic */ void shareFile$default(MapShareActivity mapShareActivity, ComponentName componentName, File file, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            file = mapShareActivity.mIntentFile;
        }
        if ((i & 4) != 0) {
            str = mapShareActivity.mIntentType;
        }
        mapShareActivity.shareFile(componentName, file, str);
    }

    public final void shareFile(@OXOo.OOXIXo ComponentName comp, @OXOo.OOXIXo File mFile, @OXOo.OOXIXo String mType) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(comp, "comp");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mFile, "mFile");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mType, "mType");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", "");
        intent.putExtra("android.intent.extra.STREAM", UriUtils.file2Uri(mFile));
        intent.setType(mType);
        intent.setComponent(comp);
        Intent createChooser = Intent.createChooser(intent, "");
        kotlin.jvm.internal.IIX0o.oO(createChooser, "createChooser(...)");
        createChooser.addFlags(268435456);
        startActivity(createChooser);
    }
}
