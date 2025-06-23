package com.baidu.navisdk.ugc.module;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.baidu.navisdk.j;
import com.baidu.navisdk.ugc.listener.b;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.c0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.common.n0;
import com.baidu.navisdk.util.common.o0;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public final class a {
    private static final String b = m0.j().f() + "/ugc_camera_temp.jpg";

    /* renamed from: a, reason: collision with root package name */
    private b f8205a;

    /* renamed from: com.baidu.navisdk.ugc.module.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0387a implements o0.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f8206a;

        public C0387a(Activity activity) {
            this.f8206a = activity;
        }

        @Override // com.baidu.navisdk.util.common.o0.b
        public void a(int i, boolean z, ArrayList<String> arrayList) {
            String str;
            g gVar = g.UGC;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("openCamera onPermissionResult, requestCode: ");
                sb.append(i);
                sb.append(",accepted: ");
                sb.append(z);
                sb.append(", deniedPermissions: ");
                if (arrayList != null) {
                    str = arrayList.toString();
                } else {
                    str = "null";
                }
                sb.append(str);
                gVar.e("CameraFunc", sb.toString());
            }
            if (i == 3004) {
                if (z) {
                    a.this.b(this.f8206a);
                    return;
                }
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "没有照相机权限，请打开后重试");
                if (a.this.f8205a != null) {
                    a.this.f8205a.a("没有权限");
                }
            }
        }
    }

    public a(b bVar) {
        this.f8205a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", a(new File(b)));
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("CameraFunc", "goToCapture");
        }
        try {
            activity.startActivityForResult(intent, 4098);
        } catch (Exception e) {
            if (g.UGC.c()) {
                g.UGC.c("CameraFunc", "goToCapture exception: " + e.toString());
            }
        }
    }

    public boolean a(int i) {
        return i == 4098;
    }

    public void a(Activity activity) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("CameraFunc", "openCamera(), activity = " + activity);
        }
        if (activity == null) {
            return;
        }
        if (!n0.a(activity, "android.permission.CAMERA")) {
            o0.b().a(3004, new C0387a(activity));
            return;
        }
        b(activity);
        if (gVar.d()) {
            gVar.e("CameraFunc", "openCamera(), activity = " + activity);
        }
    }

    private Uri a(File file) {
        String str;
        if (Build.VERSION.SDK_INT >= 24) {
            if (j.d()) {
                str = com.baidu.navisdk.framework.a.c().a().getPackageName() + ".provider";
            } else {
                str = com.baidu.navisdk.framework.a.c().a().getPackageName() + ".bnav_provider";
            }
            return FileProvider.getUriForFile(com.baidu.navisdk.framework.a.c().a(), str, file);
        }
        return Uri.fromFile(file);
    }

    public void a(int i, int i2, Intent intent, Activity activity) {
        if (i == 4098) {
            c0.a aVar = null;
            if (i2 == -1) {
                try {
                    String str = b;
                    aVar = c0.a(activity.getContentResolver(), a(new File(str)), str, ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels());
                } catch (Exception e) {
                    g gVar = g.UGC;
                    if (gVar.c()) {
                        gVar.c("CameraFunc", "carema result exception: " + e.toString());
                    }
                }
            }
            if (aVar != null) {
                b bVar = this.f8205a;
                if (bVar != null) {
                    bVar.a(aVar);
                    return;
                }
                return;
            }
            b bVar2 = this.f8205a;
            if (bVar2 != null) {
                bVar2.a("异常");
            }
        }
    }

    public void a() {
        this.f8205a = null;
    }
}
