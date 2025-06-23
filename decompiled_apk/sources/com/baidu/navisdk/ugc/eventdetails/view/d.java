package com.baidu.navisdk.ugc.eventdetails.view;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.eventdetails.model.c;
import com.baidu.navisdk.ugc.pictures.previews.b;
import com.baidu.navisdk.ugc.pictures.show.UgcDetailShowPicLayout;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes8.dex */
public class d extends b implements UgcDetailShowPicLayout.a {
    private UgcDetailShowPicLayout A0;
    private com.baidu.navisdk.ugc.pictures.previews.b B0;

    /* renamed from: x0, reason: collision with root package name */
    private View f8142x0;
    private View y0;
    private View z0;

    public d(Context context, int i, com.baidu.navisdk.ugc.eventdetails.model.a aVar, com.baidu.navisdk.ugc.eventdetails.control.a aVar2) {
        super(context, i, aVar, aVar2);
        com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.7", t() + "", aVar.f() + "", null);
    }

    private void u() {
        if (this.A0 != null) {
            String[] strArr = this.f8112a.k().U;
            if (strArr != null && strArr.length != 0) {
                this.A0.b(ScreenUtil.getInstance().getWidthPixels());
                this.A0.setListener(this);
                this.A0.setVisibility(0);
                this.A0.a(strArr);
                return;
            }
            this.A0.setVisibility(8);
        }
    }

    private void v() {
        int g = this.q0.g();
        if (g != 0) {
            if (g != 1) {
                if (g != 2) {
                    if (g == 3) {
                        View view = this.y0;
                        if (view != null) {
                            view.setOnClickListener(this);
                        }
                        View view2 = this.z0;
                        if (view2 != null) {
                            view2.setOnClickListener(this);
                            return;
                        }
                        return;
                    }
                    return;
                }
                View view3 = this.z0;
                if (view3 != null) {
                    view3.setOnClickListener(this);
                }
                View view4 = this.y0;
                if (view4 != null) {
                    view4.setVisibility(8);
                    return;
                }
                return;
            }
            View view5 = this.y0;
            if (view5 != null) {
                view5.setOnClickListener(this);
            }
            View view6 = this.z0;
            if (view6 != null) {
                view6.setVisibility(8);
                return;
            }
            return;
        }
        View view7 = this.f8142x0;
        if (view7 != null) {
            view7.setVisibility(8);
        }
    }

    private void w() {
        int i;
        ViewGroup.LayoutParams layoutParams;
        int i2;
        Spanned spanned = null;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        for (c.d dVar : this.f8112a.k().B()) {
            if (dVar != null && !dVar.c() && ((i2 = dVar.b) == 0 || i2 == 1)) {
                spanned = Html.fromHtml(dVar.f8071a);
                if (this.K != null) {
                    if (TextUtils.isEmpty(spanned)) {
                        this.K.setVisibility(8);
                    } else {
                        this.K.setText(spanned);
                    }
                }
                TextView textView = this.K;
                if (textView != null && textView.getVisibility() == 0) {
                    ImageView imageView = this.L;
                    if (imageView != null && dVar.b == 1) {
                        imageView.setVisibility(0);
                        this.L.setImageDrawable(com.baidu.navisdk.ui.util.b.f(dVar.b()));
                        z = true;
                    }
                    if (this.M != null && !TextUtils.isEmpty(dVar.c)) {
                        this.M.setText(Html.fromHtml(dVar.c));
                        this.M.setVisibility(0);
                        z2 = true;
                    }
                }
            }
        }
        TextView textView2 = this.K;
        if (textView2 != null && textView2.getVisibility() != 0) {
            return;
        }
        if (!z && !z2 && spanned != null && !TextUtils.isEmpty(spanned) && spanned.length() < 16) {
            return;
        }
        if (!z && z2 && spanned != null && !TextUtils.isEmpty(spanned) && spanned.length() < 12) {
            return;
        }
        if (z && !z2 && spanned != null && !TextUtils.isEmpty(spanned) && spanned.length() < 12) {
            return;
        }
        View view = this.b;
        if (view != null) {
            i3 = view.getMeasuredWidth();
        }
        int paddingLeft = (i3 - this.J.getPaddingLeft()) - this.J.getPaddingRight();
        TextView textView3 = this.K;
        int a2 = j.a(textView3, textView3.getText().toString());
        ImageView imageView2 = this.L;
        if (imageView2 != null && imageView2.getVisibility() == 0) {
            i = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_14dp) + a2;
        } else {
            i = a2;
        }
        TextView textView4 = this.M;
        if (textView4 != null && textView4.getVisibility() == 0) {
            TextView textView5 = this.M;
            i += j.a(textView5, textView5.getText().toString());
        }
        TextView textView6 = this.v;
        if (textView6 != null && textView6.getVisibility() == 0) {
            TextView textView7 = this.v;
            i = i + j.a(textView7, textView7.getText().toString()) + JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp);
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("BNTruckUgcEventDetailsView", "updateUgcUserInfo totalWidth: " + paddingLeft + ", contentWidth:" + i);
        }
        if (i > paddingLeft && (layoutParams = this.K.getLayoutParams()) != null) {
            layoutParams.width = a2 - (i - paddingLeft);
        }
    }

    @Override // com.baidu.navisdk.ugc.pictures.show.UgcDetailShowPicLayout.a
    public void a(int i, String[] strArr) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("BNTruckUgcEventDetailsView", "onClickPic(), index = " + i + " ,picPathArray = " + Arrays.toString(strArr));
        }
        if (this.B0 == null) {
            this.B0 = new com.baidu.navisdk.ugc.pictures.previews.b();
        }
        ArrayList<String> arrayList = new ArrayList<>(strArr.length);
        Collections.addAll(arrayList, strArr);
        this.B0.a((b.e) null, this);
        this.B0.a(this.f8112a.d(), arrayList, 2, i, false);
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.b, com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void b(Context context, int i) {
        super.b(context, i);
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.b
    public void f(boolean z) {
        int i;
        super.f(z);
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.a", t() + "", this.q0.f() + "", i + "");
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.b
    public void j() {
        super.j();
        this.f8142x0 = this.o.findViewById(R.id.event_detail_bottom_btn_layout);
        this.y0 = this.o.findViewById(R.id.truck_ugc_add_via);
        this.z0 = this.o.findViewById(R.id.truck_ugc_goto_here);
        this.A0 = (UgcDetailShowPicLayout) this.o.findViewById(R.id.ugc_detail_show_pic_layout);
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.b
    @LayoutRes
    public int k() {
        return R.layout.nsdk_layout_truck_ugc_detail_outline;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.b
    public void n() {
        super.n();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.truck_ugc_add_via) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.8", t() + "", this.q0.f() + "", "1");
            this.f8112a.f(3);
            return;
        }
        if (id == R.id.truck_ugc_goto_here) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.8", t() + "", this.q0.f() + "", "2");
            this.f8112a.f(4);
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.b, com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onDestroy() {
        super.onDestroy();
        UgcDetailShowPicLayout ugcDetailShowPicLayout = this.A0;
        if (ugcDetailShowPicLayout != null) {
            ugcDetailShowPicLayout.a();
            this.A0 = null;
        }
        com.baidu.navisdk.ugc.pictures.previews.b bVar = this.B0;
        if (bVar != null) {
            bVar.b();
            this.B0 = null;
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.b
    public boolean q() {
        return false;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.b
    public void r() {
        v();
        super.r();
        if (this.u != null) {
            if (TextUtils.isEmpty(this.f8112a.k().V)) {
                this.u.setText(this.f8112a.k().y());
            } else {
                this.u.setText(this.f8112a.k().V);
            }
        }
        u();
        w();
    }

    public int t() {
        int i = this.q0.g;
        if (i == 1) {
            return 3;
        }
        if (i != 3) {
            if (i != 8) {
                return 0;
            }
            return 2;
        }
        return 1;
    }
}
