package com.baidu.navisdk.ugc.eventdetails.view;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.ugc.eventdetails.model.c;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class g implements com.baidu.navisdk.ugc.eventdetails.interfaces.a {
    private com.baidu.navisdk.ugc.pictures.previews.c A;

    /* renamed from: a, reason: collision with root package name */
    private View f8169a;
    private ConstraintLayout b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private View f;
    private TextView g;
    private TextView h;
    private ImageView i;
    private View j;
    private View k;
    private BNRCEventDetailLabelsView l;
    private View m;
    private TextView n;
    private ImageView o;
    private ViewGroup p;
    private View q;
    private TextView r;
    private ImageView s;
    private View t;
    private TextView u;
    private ImageView v;
    private View w;
    private TextView x;
    private TextView y;
    private View z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.A == null) {
                g.this.A = new com.baidu.navisdk.ugc.pictures.previews.c(null);
            }
            Object tag = view.getTag(R.id.view_tag_first);
            if (tag != null && (tag instanceof String)) {
                g.this.A.a(com.baidu.navisdk.framework.a.c().b(), (String) tag, 4);
            }
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.a
    public void b(View.OnClickListener onClickListener) {
        View view = this.z;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.a
    public void onDestroy() {
        com.baidu.navisdk.ugc.pictures.previews.c cVar = this.A;
        if (cVar != null) {
            cVar.c();
        }
        j.b(this.c);
        j.b(this.o);
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.a
    public View a(Context context) {
        View inflate = JarUtils.inflate(context, R.layout.nsdk_layout_ugc_detail_outline_fixed, null);
        this.f8169a = inflate;
        if (inflate == null) {
            return null;
        }
        this.b = (ConstraintLayout) inflate.findViewById(R.id.layout_event_type);
        this.c = (ImageView) this.f8169a.findViewById(R.id.ic_event_type);
        this.d = (TextView) this.f8169a.findViewById(R.id.tv_event_type);
        this.e = (TextView) this.f8169a.findViewById(R.id.tv_event_time_stamp);
        this.f = this.f8169a.findViewById(R.id.view_avoid_congestion);
        this.g = (TextView) this.f8169a.findViewById(R.id.tv_event_address_and_distance);
        this.h = (TextView) this.f8169a.findViewById(R.id.tv_ugc_details_congestion_time);
        ImageView imageView = (ImageView) this.f8169a.findViewById(R.id.ugc_event_details_realistic_img);
        this.i = imageView;
        imageView.setOnClickListener(new a());
        this.j = this.f8169a.findViewById(R.id.ugc_event_details_realistic_img_container);
        this.k = this.f8169a.findViewById(R.id.ugc_event_details_content_layout);
        this.l = (BNRCEventDetailLabelsView) this.f8169a.findViewById(R.id.ugc_detail_labels_view);
        this.m = this.f8169a.findViewById(R.id.layout_pgc_source);
        this.n = (TextView) this.f8169a.findViewById(R.id.tv_event_reporter_pgc_name);
        this.o = (ImageView) this.f8169a.findViewById(R.id.iv_event_reporter_pgc_icon);
        this.p = (ViewGroup) this.f8169a.findViewById(R.id.nsdk_layout_ugc_useful_new);
        this.q = this.f8169a.findViewById(R.id.view_useful);
        this.r = (TextView) this.f8169a.findViewById(R.id.tv_useful);
        this.s = (ImageView) this.f8169a.findViewById(R.id.iv_useful);
        this.t = this.f8169a.findViewById(R.id.view_useless);
        this.u = (TextView) this.f8169a.findViewById(R.id.tv_useless);
        this.v = (ImageView) this.f8169a.findViewById(R.id.iv_useless);
        this.w = this.f8169a.findViewById(R.id.btn_container_new);
        this.x = (TextView) this.f8169a.findViewById(R.id.report_open);
        this.y = (TextView) this.f8169a.findViewById(R.id.try_to_avoid);
        this.z = this.f8169a.findViewById(R.id.ugc_detail_close_icon);
        return this.f8169a;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.a
    public void a(com.baidu.navisdk.ugc.eventdetails.model.b bVar, Context context) {
        String str;
        ImageView imageView;
        if (bVar == null) {
            return;
        }
        int i = bVar.f8067a;
        if (i > 0 && (imageView = this.c) != null) {
            imageView.setImageResource(i);
        } else if (this.c != null) {
            if (TextUtils.isEmpty(bVar.b)) {
                this.c.setVisibility(8);
                a();
            } else {
                try {
                    this.c.setVisibility(0);
                    if (context != null) {
                        ImageLoader.with(context).load(bVar.b).into(this.c);
                    } else {
                        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                        if (gVar.c()) {
                            gVar.c("BNUgcFixedPanel", "updateData context == null");
                        }
                        com.baidu.navisdk.ugc.utils.d.a(bVar.c, this.c, bVar.b);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    this.c.setVisibility(8);
                    a();
                }
            }
        }
        if (this.d != null) {
            if (TextUtils.isEmpty(bVar.d)) {
                this.d.setVisibility(8);
            } else {
                this.d.setText(bVar.d);
            }
        }
        if (this.e != null) {
            if (TextUtils.isEmpty(bVar.e)) {
                this.e.setVisibility(8);
            } else {
                this.e.setText(bVar.e);
            }
        }
        ImageView imageView2 = this.i;
        if (imageView2 != null && this.j != null) {
            imageView2.setTag(R.id.view_tag_first, bVar.f);
            if (!TextUtils.isEmpty(bVar.f)) {
                ImageLoader.with(context).load(bVar.f).into(this.i);
                this.j.setVisibility(0);
                this.i.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
        }
        View view = this.f;
        if (view != null) {
            view.setVisibility(8);
        }
        if (!bVar.g) {
            ViewGroup viewGroup = this.p;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
        } else {
            ViewGroup viewGroup2 = this.p;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(0);
            }
            View view2 = this.q;
            if (view2 != null) {
                view2.setVisibility(4);
            }
            View view3 = this.t;
            if (view3 != null) {
                view3.setVisibility(4);
            }
            View view4 = this.w;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            TextView textView = this.x;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.y;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
        if (!TextUtils.isEmpty(bVar.h) && !TextUtils.isEmpty(bVar.i)) {
            str = bVar.h + " · " + bVar.i;
        } else if (!TextUtils.isEmpty(bVar.h)) {
            str = bVar.h;
        } else {
            str = !TextUtils.isEmpty(bVar.i) ? bVar.i : null;
        }
        if (this.g != null) {
            if (TextUtils.isEmpty(str)) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                this.g.setText(str);
            }
        }
        TextView textView3 = this.h;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        BNRCEventDetailLabelsView bNRCEventDetailLabelsView = this.l;
        if (bNRCEventDetailLabelsView != null) {
            boolean a2 = bNRCEventDetailLabelsView.a(bVar.k);
            View view5 = this.k;
            if (view5 != null) {
                view5.setVisibility(a2 ? 0 : 8);
            }
        }
        c.d dVar = bVar.l;
        if (dVar != null) {
            if (this.n != null) {
                if (TextUtils.isEmpty(dVar.f8071a)) {
                    View view6 = this.m;
                    if (view6 != null) {
                        view6.setVisibility(8);
                    }
                } else {
                    View view7 = this.m;
                    if (view7 != null) {
                        view7.setVisibility(0);
                    }
                    this.n.setText(Html.fromHtml(bVar.l.f8071a));
                }
            }
            if (this.o != null) {
                int b = bVar.l.b();
                if (b > 0) {
                    this.o.setImageDrawable(com.baidu.navisdk.ui.util.b.f(b));
                    return;
                } else {
                    this.o.setVisibility(8);
                    return;
                }
            }
            return;
        }
        View view8 = this.m;
        if (view8 != null) {
            view8.setVisibility(8);
        }
    }

    private void a() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.b);
        constraintSet.connect(this.d.getId(), 1, 0, 1);
        constraintSet.applyTo(this.b);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.setMarginStart(0);
        layoutParams.setMargins(0, 0, 0, 0);
        this.d.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.a
    public void a(View.OnClickListener onClickListener) {
        TextView textView = this.y;
        if (textView != null) {
            if (onClickListener == null) {
                View view = this.w;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            textView.setOnClickListener(onClickListener);
        }
    }
}
