package com.baidu.navisdk.ugc.pictures.previews;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.dialog.BNDialog;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes8.dex */
public final class b implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private static WeakReference<b> l;

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f8209a;
    private Activity b;
    private BNDialog c;
    private com.baidu.navisdk.ugc.listener.c d;
    private e e;
    private com.baidu.navisdk.ugc.dialog.e f;
    private ArrayList<String> g;
    private int h = -1;
    private com.baidu.navisdk.ugc.pictures.previews.a i;
    private ViewPager j;
    private ViewPageIndicatorLayout k;

    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.f = null;
            b.this.b();
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.pictures.previews.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class DialogInterfaceOnShowListenerC0388b implements DialogInterface.OnShowListener {
        public DialogInterfaceOnShowListenerC0388b() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (b.this.h != 0 && b.this.j != null) {
                b.this.j.setCurrentItem(b.this.h, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements BNDialog.OnNaviClickListener {
        public c() {
        }

        @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog.OnNaviClickListener
        public void onClick() {
            b.this.c();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.c = null;
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(String str, int i);
    }

    public static b d() {
        WeakReference<b> weakReference = l;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void e() {
        Activity activity = this.b;
        if (activity != null && !activity.isFinishing()) {
            BNDialog bNDialog = new BNDialog(this.b);
            this.c = bNDialog;
            bNDialog.setTitle("提示");
            this.c.setContentMessage("确认要删除吗？");
            this.c.setFirstBtnText("取消");
            this.c.setSecondBtnText("确认");
            this.c.setOnSecondBtnClickListener(new c());
            this.c.setOnDismissListener(new d());
            BNDialog bNDialog2 = this.c;
            if (bNDialog2 != null && !bNDialog2.isShowing()) {
                this.c.show();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back_preview_pic) {
            b();
        } else if (id == R.id.delete_preview_pic) {
            e();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.h = i;
        ViewPageIndicatorLayout viewPageIndicatorLayout = this.k;
        if (viewPageIndicatorLayout != null) {
            viewPageIndicatorLayout.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int size = this.g.size();
        if (size == 1) {
            e eVar = this.e;
            if (eVar != null) {
                eVar.a(this.g.get(this.h), this.h);
            }
            b();
            return;
        }
        int i = this.h;
        String remove = this.g.remove(i);
        com.baidu.navisdk.ugc.pictures.previews.a aVar = this.i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
        if (i < size - 1) {
            this.h = i;
        } else {
            this.h = i - 1;
        }
        ViewPageIndicatorLayout viewPageIndicatorLayout = this.k;
        if (viewPageIndicatorLayout != null) {
            viewPageIndicatorLayout.b(i);
            this.k.a(this.h);
        }
        e eVar2 = this.e;
        if (eVar2 != null) {
            eVar2.a(remove, i);
        }
    }

    public void b() {
        this.b = null;
        BNDialog bNDialog = this.c;
        if (bNDialog != null && bNDialog.isShowing()) {
            this.c.dismiss();
            this.c = null;
        }
        com.baidu.navisdk.ugc.dialog.e eVar = this.f;
        if (eVar != null) {
            eVar.dismiss();
            this.f = null;
        }
        com.baidu.navisdk.ugc.listener.c cVar = this.d;
        if (cVar != null) {
            cVar.a(false);
        }
        ArrayList<String> arrayList = this.g;
        if (arrayList != null) {
            arrayList.clear();
            this.g = null;
        }
        ViewPageIndicatorLayout viewPageIndicatorLayout = this.k;
        if (viewPageIndicatorLayout != null) {
            viewPageIndicatorLayout.a();
            this.k = null;
        }
        l = null;
        this.j = null;
        this.f8209a = null;
        this.d = null;
        this.e = null;
        this.i = null;
        this.h = -1;
    }

    public void a(e eVar, com.baidu.navisdk.ugc.listener.c cVar) {
        this.e = eVar;
        this.d = cVar;
    }

    public void a(Activity activity, ArrayList<String> arrayList, int i, int i2, boolean z) {
        if (activity != null && arrayList != null && !arrayList.isEmpty()) {
            if (this.f != null) {
                return;
            }
            if (this.f8209a == null) {
                this.f8209a = (ViewGroup) JarUtils.inflate(activity, R.layout.nsdk_layout_ugc_mutil_preview_pic, null);
            }
            ViewGroup viewGroup = this.f8209a;
            if (viewGroup != null) {
                viewGroup.findViewById(R.id.back_preview_pic).setOnClickListener(this);
                View findViewById = this.f8209a.findViewById(R.id.delete_preview_pic);
                if (findViewById != null) {
                    if (z) {
                        findViewById.setOnClickListener(this);
                    } else {
                        findViewById.setVisibility(8);
                    }
                }
                this.f8209a.setOnClickListener(this);
                l = new WeakReference<>(this);
                com.baidu.navisdk.ugc.listener.c cVar = this.d;
                if (cVar != null) {
                    cVar.a(true);
                }
                this.g = arrayList;
                this.h = i2;
                g gVar = g.UGC;
                if (gVar.e()) {
                    gVar.g("UgcModule_PicDialogmutil", "showPic currentIndex: " + i2 + ", " + Arrays.toString(arrayList.toArray()));
                }
                this.j = (ViewPager) this.f8209a.findViewById(R.id.ugc_preview_pic_view_page);
                this.k = (ViewPageIndicatorLayout) this.f8209a.findViewById(R.id.ugc_preview_pic_indicator_layout);
                if (this.i == null) {
                    this.i = new com.baidu.navisdk.ugc.pictures.previews.a(activity, this.g, i2);
                }
                this.j.addOnPageChangeListener(this);
                this.j.setPageMargin(JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_8dp));
                this.j.setAdapter(this.i);
                this.k.a(this.g.size(), i2);
                com.baidu.navisdk.ugc.dialog.e eVar = new com.baidu.navisdk.ugc.dialog.e(activity, this.f8209a, i);
                this.f = eVar;
                eVar.setOnDismissListener(new a());
                this.f.setOnShowListener(new DialogInterfaceOnShowListenerC0388b());
                this.f.show();
                this.b = activity;
                return;
            }
            return;
        }
        g gVar2 = g.UGC;
        if (gVar2.c()) {
            gVar2.c("UgcModule_PicDialogmutil", " showPic activity == null|| arrayList == null || arrayList.isEmpty()");
        }
    }

    public boolean a() {
        com.baidu.navisdk.ugc.dialog.e eVar = this.f;
        return eVar != null && eVar.isShowing();
    }
}
