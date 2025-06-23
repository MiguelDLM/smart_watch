package com.baidu.navisdk.ugc.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.j;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.c0;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.common.n0;
import com.baidu.navisdk.util.common.o0;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class d extends f implements View.OnClickListener {
    private static final String l = m0.j().f() + "/ugc_camera_temp.jpg";
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private Activity g;
    private com.baidu.navisdk.ugc.listener.b h;
    private com.baidu.navisdk.ugc.video.a i;
    private int j;
    private com.baidu.navisdk.ugc.listener.c k;

    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            d.this.a((com.baidu.navisdk.ugc.listener.b) null);
            d.this.i = null;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements o0.b {
        public b() {
        }

        @Override // com.baidu.navisdk.util.common.o0.b
        public void a(int i, boolean z, ArrayList<String> arrayList) {
            String str;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("clickRecordVideo onPermissionResult, requestCode: ");
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
                gVar.e("UgcModule_PicDialog", sb.toString());
            }
            if (i != 3005) {
                return;
            }
            if (z) {
                d.this.g();
            } else {
                d.this.dismiss();
                d.this.a(arrayList);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements o0.b {
        public c() {
        }

        @Override // com.baidu.navisdk.util.common.o0.b
        public void a(int i, boolean z, ArrayList<String> arrayList) {
            String str;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
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
                gVar.e("UgcModule_PicDialog", sb.toString());
            }
            if (i == 3004) {
                if (z) {
                    d.this.c();
                } else {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "没有照相机权限，请打开后重试");
                    d.this.dismiss();
                }
            }
        }
    }

    public d(Activity activity, int i, int i2) {
        super(activity, R.style.BNDialog);
        boolean z;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = null;
        if ((i & 256) == 256 && !com.baidu.navisdk.ugc.video.c.d() && (i = i ^ 256) == 0) {
            i = 16;
        }
        this.g = activity;
        this.j = i;
        if (i2 != 1) {
            z = true;
        } else {
            z = false;
        }
        this.f8029a = z;
        if ((i != 1 || i2 == 5) && i != 16 && i != 256) {
            View inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_ugc_report_pic_choose_dialog, null);
            if (inflate == null) {
                return;
            }
            this.f = (TextView) inflate.findViewById(R.id.choose_video_btn);
            this.c = (TextView) inflate.findViewById(R.id.choose_camera_btn);
            this.d = (TextView) inflate.findViewById(R.id.choose_album_btn);
            this.e = (TextView) inflate.findViewById(R.id.choose_pic_cancel_btn);
            if ((i & 256) != 256 || !j.d()) {
                this.f.setVisibility(8);
                inflate.findViewById(R.id.choose_video_line).setVisibility(8);
            }
            if ((i & 1) != 1) {
                this.c.setVisibility(8);
                inflate.findViewById(R.id.choose_camera_line).setVisibility(8);
            }
            if ((i & 16) != 16) {
                this.d.setVisibility(8);
                inflate.findViewById(R.id.choose_camera_line).setVisibility(8);
            }
            setContentView(inflate);
            e();
            Window window = getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setGravity(80);
                return;
            }
            return;
        }
        b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Intent intent = new Intent();
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", a(new File(l)));
        if (this.g != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_PicDialog", "goToCapture");
            }
            try {
                this.g.startActivityForResult(intent, 4098);
                com.baidu.navisdk.ugc.listener.c cVar = this.k;
                if (cVar != null) {
                    cVar.a(true);
                }
            } catch (Exception e) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
                if (gVar2.c()) {
                    gVar2.c("UgcModule_PicDialog", "goToCapture exception: " + e.toString());
                }
            }
        }
    }

    private boolean d() {
        if (n0.a(getContext(), "android.permission.CAMERA") && n0.a(getContext(), "android.permission.RECORD_AUDIO")) {
            return true;
        }
        return false;
    }

    private void e() {
        TextView textView = this.c;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        TextView textView3 = this.e;
        if (textView3 != null) {
            textView3.setOnClickListener(this);
        }
        TextView textView4 = this.f;
        if (textView4 != null) {
            textView4.setOnClickListener(this);
        }
        setOnDismissListener(new a());
    }

    private void f() {
        if (!n0.a(getContext(), "android.permission.CAMERA")) {
            o0.b().a(3004, new c());
        } else {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.baidu.navisdk.ugc.video.a aVar = this.i;
        if (aVar != null) {
            aVar.a(this.g, 4105);
        }
    }

    public boolean a(int i) {
        return i == 4105 || i == 4098 || i == 4100;
    }

    @Override // com.baidu.navisdk.ugc.dialog.f, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.baidu.navisdk.ugc.listener.c cVar = this.k;
        if (cVar != null) {
            cVar.a(false);
            this.k = null;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_PicDialog", "dismiss: ");
            gVar.f();
        }
        this.g = null;
        this.h = null;
        this.i = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.choose_camera_btn) {
            b(1);
            return;
        }
        if (id == R.id.choose_album_btn) {
            b(16);
        } else if (id == R.id.choose_pic_cancel_btn) {
            dismiss();
        } else if (id == R.id.choose_video_btn) {
            b(256);
        }
    }

    @Override // com.baidu.navisdk.ugc.dialog.f, android.app.Dialog
    public void show() {
        super.show();
    }

    private void b(int i) {
        if (i == 1) {
            f();
        } else if (i == 16) {
            b();
        } else {
            if (i != 256) {
                return;
            }
            a();
        }
    }

    private void b() {
        if (this.g != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_PicDialog", "gallery: ");
            }
            com.baidu.navisdk.ugc.listener.c cVar = this.k;
            if (cVar != null) {
                cVar.a(true);
            }
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            Activity activity = this.g;
            if (activity != null) {
                activity.startActivityForResult(intent, 4100);
            }
        }
    }

    public void a(com.baidu.navisdk.ugc.listener.b bVar) {
        this.h = bVar;
    }

    public void a(com.baidu.navisdk.ugc.listener.c cVar) {
        this.k = cVar;
    }

    public void a(com.baidu.navisdk.ugc.video.a aVar) {
        if ((this.j & 256) == 256) {
            this.i = aVar;
        }
    }

    private void a() {
        if (!d()) {
            o0.b().a(3005, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, new b());
        } else {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() == 2) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_record_video_auth_tip));
        } else if ("android.permission.RECORD_AUDIO".equals(arrayList.get(0))) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "没有麦克风权限，请打开后重试");
        } else {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "没有照相机权限，请打开后重试");
        }
    }

    public void a(int i, int i2, Intent intent) {
        com.baidu.navisdk.ugc.video.a aVar;
        c0.a aVar2 = null;
        if (i == 4100) {
            if (i2 == -1 && intent != null) {
                try {
                    aVar2 = c0.a(this.g.getContentResolver(), intent.getData());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (aVar2 != null) {
                com.baidu.navisdk.ugc.listener.b bVar = this.h;
                if (bVar != null) {
                    bVar.a(aVar2);
                    return;
                }
                return;
            }
            com.baidu.navisdk.ugc.listener.b bVar2 = this.h;
            if (bVar2 != null) {
                bVar2.a("异常");
                return;
            }
            return;
        }
        if (i != 4098) {
            if (i != 4105 || (aVar = this.i) == null) {
                return;
            }
            aVar.a(i2, intent);
            return;
        }
        if (i2 == -1) {
            try {
                String str = l;
                aVar2 = c0.a(this.g.getContentResolver(), a(new File(str)), str);
            } catch (Exception e2) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.c()) {
                    gVar.c("UgcModule_PicDialog", "carema result exception:" + e2.toString());
                }
            }
        }
        if (aVar2 != null) {
            com.baidu.navisdk.ugc.listener.b bVar3 = this.h;
            if (bVar3 != null) {
                bVar3.a(aVar2);
                return;
            }
            return;
        }
        com.baidu.navisdk.ugc.listener.b bVar4 = this.h;
        if (bVar4 != null) {
            bVar4.a("异常");
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
}
