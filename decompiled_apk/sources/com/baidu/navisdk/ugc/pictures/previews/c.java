package com.baidu.navisdk.ugc.pictures.previews;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.utils.f;
import com.baidu.navisdk.ui.widget.dialog.BNDialog;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.s;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.widget.photoview.PhotoView;
import com.bumptech.glide.Glide;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public final class c implements View.OnClickListener {
    private static WeakReference<c> l;

    /* renamed from: a, reason: collision with root package name */
    private PhotoView f8214a;
    private TextView b;
    private ImageView c;
    private LinearLayout d;
    private Activity e;
    private BNDialog f;
    private com.baidu.navisdk.ugc.listener.c g;
    private e h;
    private String i;
    private com.baidu.navisdk.ugc.dialog.e j;
    private boolean k = true;

    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (c.this.k) {
                com.baidu.navisdk.asr.d.B().b(true);
            }
            c.this.j = null;
            c.this.a();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnShowListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            com.baidu.navisdk.framework.b.a();
            c.this.k = com.baidu.navisdk.asr.d.B().q();
            com.baidu.navisdk.asr.d.B().b(false);
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.pictures.previews.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0389c implements BNDialog.OnNaviClickListener {
        public C0389c() {
        }

        @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog.OnNaviClickListener
        public void onClick() {
            c.this.a();
            if (c.this.h != null) {
                try {
                    s.a(c.this.i);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                c.this.i = null;
                c.this.h.a(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            c.this.f = null;
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(String str);
    }

    public c(e eVar) {
        this.h = eVar;
    }

    private void d() {
        Activity activity = this.e;
        if (activity != null && !activity.isFinishing()) {
            BNDialog bNDialog = new BNDialog(this.e);
            this.f = bNDialog;
            bNDialog.setTitle("提示");
            this.f.setContentMessage("确认要删除吗？");
            this.f.setFirstBtnText("取消");
            this.f.setSecondBtnText("确认");
            this.f.setOnSecondBtnClickListener(new C0389c());
            this.f.setOnDismissListener(new d());
            BNDialog bNDialog2 = this.f;
            if (bNDialog2 != null && !bNDialog2.isShowing()) {
                this.f.show();
            }
        }
    }

    public static c e() {
        WeakReference<c> weakReference = l;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back_preview_pic) {
            a();
        } else if (id == R.id.delete_preview_pic) {
            d();
        }
    }

    private void b(int i) {
        ImageView imageView = this.c;
        if (imageView == null) {
            return;
        }
        if (i == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            this.c.setImageResource(i);
        }
    }

    public void c() {
        BNDialog bNDialog = this.f;
        if (bNDialog != null && bNDialog.isShowing()) {
            this.f.dismiss();
            this.f = null;
        }
        a();
        this.f8214a = null;
        this.d = null;
        this.g = null;
        this.h = null;
    }

    public void a(com.baidu.navisdk.ugc.listener.c cVar) {
        this.g = cVar;
    }

    public boolean b() {
        com.baidu.navisdk.ugc.dialog.e eVar = this.j;
        return eVar != null && eVar.isShowing();
    }

    public void a(e eVar, com.baidu.navisdk.ugc.listener.c cVar) {
        this.h = eVar;
        this.g = cVar;
    }

    public void a(Activity activity, String str, int i) {
        if (activity != null && !TextUtils.isEmpty(str)) {
            if (this.j != null) {
                return;
            }
            l = new WeakReference<>(this);
            com.baidu.navisdk.ugc.listener.c cVar = this.g;
            if (cVar != null) {
                cVar.a(true);
            }
            this.i = str;
            if (this.d == null) {
                this.d = (LinearLayout) JarUtils.inflate(activity, R.layout.nsdk_layout_ugc_preview_pic, null);
            }
            LinearLayout linearLayout = this.d;
            if (linearLayout != null) {
                linearLayout.findViewById(R.id.back_preview_pic).setOnClickListener(this);
                LinearLayout linearLayout2 = this.d;
                int i2 = R.id.delete_preview_pic;
                linearLayout2.findViewById(i2).setOnClickListener(this);
                this.d.setOnClickListener(this);
                if (this.b == null) {
                    this.b = (TextView) this.d.findViewById(R.id.textView2);
                }
                if (this.c == null) {
                    this.c = (ImageView) this.d.findViewById(i2);
                }
                if (this.f8214a == null) {
                    this.f8214a = (PhotoView) this.d.findViewById(R.id.iv_preview_pic);
                }
                a(i, str);
                a(i);
                com.baidu.navisdk.ugc.dialog.e eVar = new com.baidu.navisdk.ugc.dialog.e(activity, this.d, i);
                this.j = eVar;
                eVar.setOnDismissListener(new a());
                this.j.setOnShowListener(new b());
                this.j.show();
                this.e = activity;
                return;
            }
            return;
        }
        g gVar = g.UGC;
        if (gVar.c()) {
            gVar.c("UgcModule_PicDialog", "UgcSinglePreviewPicController showPic activity == null || parent == null || TextUtils.isEmpty(localPath)");
        }
    }

    private void a(int i, String str) {
        PhotoView photoView = this.f8214a;
        if (photoView == null) {
            return;
        }
        if (i != 4) {
            photoView.setZoomable(false);
            f.c.a(str, (ImageView) this.f8214a, true);
        } else {
            photoView.setZoomable(true);
            Glide.with(this.f8214a.getContext()).load(str).into(this.f8214a);
        }
    }

    private void a(int i) {
        if (i != 4) {
            a("预览");
            b(R.drawable.bnav_ugc_preview_delete_icon);
        } else {
            a("图片");
            b(0);
        }
    }

    private void a(String str) {
        if (this.b == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.b.setText(str);
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
    }

    public void a() {
        this.e = null;
        PhotoView photoView = this.f8214a;
        if (photoView != null) {
            photoView.setImageDrawable(null);
        }
        com.baidu.navisdk.ugc.dialog.e eVar = this.j;
        if (eVar != null) {
            eVar.dismiss();
            this.j = null;
        }
        com.baidu.navisdk.ugc.listener.c cVar = this.g;
        if (cVar != null) {
            cVar.a(false);
        }
        l = null;
    }
}
