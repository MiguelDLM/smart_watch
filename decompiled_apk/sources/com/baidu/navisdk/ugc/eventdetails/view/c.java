package com.baidu.navisdk.ugc.eventdetails.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class c implements com.baidu.navisdk.ugc.eventdetails.interfaces.a {
    private com.baidu.navisdk.ugc.pictures.previews.c A;

    /* renamed from: a, reason: collision with root package name */
    private View f8140a;
    private ImageView b;
    private TextView c;
    private View d;
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
            if (c.this.A == null) {
                c.this.A = new com.baidu.navisdk.ugc.pictures.previews.c(null);
            }
            Object tag = view.getTag(R.id.view_tag_first);
            if (tag != null && (tag instanceof String)) {
                c.this.A.a(com.baidu.navisdk.framework.a.c().b(), (String) tag, 4);
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
        j.b(this.b);
        j.b(this.o);
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.a
    public View a(Context context) {
        View inflate = JarUtils.inflate(context, R.layout.nsdk_layout_traffic_light_detail_fixed, null);
        this.f8140a = inflate;
        if (inflate == null) {
            return null;
        }
        this.b = (ImageView) inflate.findViewById(R.id.ic_event_type);
        this.c = (TextView) this.f8140a.findViewById(R.id.tv_event_type);
        this.d = this.f8140a.findViewById(R.id.details_event_type_line);
        this.e = (TextView) this.f8140a.findViewById(R.id.tv_event_time_stamp);
        this.f = this.f8140a.findViewById(R.id.view_avoid_congestion);
        this.g = (TextView) this.f8140a.findViewById(R.id.tv_event_address_and_distance);
        this.h = (TextView) this.f8140a.findViewById(R.id.tv_ugc_details_congestion_time);
        ImageView imageView = (ImageView) this.f8140a.findViewById(R.id.ugc_event_details_realistic_img);
        this.i = imageView;
        imageView.setOnClickListener(new a());
        this.j = this.f8140a.findViewById(R.id.ugc_event_details_realistic_img_container);
        this.k = this.f8140a.findViewById(R.id.ugc_event_details_content_layout);
        this.l = (BNRCEventDetailLabelsView) this.f8140a.findViewById(R.id.ugc_detail_labels_view);
        this.m = this.f8140a.findViewById(R.id.layout_pgc_source);
        this.n = (TextView) this.f8140a.findViewById(R.id.tv_event_reporter_pgc_name);
        this.o = (ImageView) this.f8140a.findViewById(R.id.iv_event_reporter_pgc_icon);
        this.p = (ViewGroup) this.f8140a.findViewById(R.id.nsdk_layout_ugc_useful_new);
        this.q = this.f8140a.findViewById(R.id.view_useful);
        this.r = (TextView) this.f8140a.findViewById(R.id.tv_useful);
        this.s = (ImageView) this.f8140a.findViewById(R.id.iv_useful);
        this.t = this.f8140a.findViewById(R.id.view_useless);
        this.u = (TextView) this.f8140a.findViewById(R.id.tv_useless);
        this.v = (ImageView) this.f8140a.findViewById(R.id.iv_useless);
        this.w = this.f8140a.findViewById(R.id.btn_container_new);
        this.x = (TextView) this.f8140a.findViewById(R.id.report_open);
        this.y = (TextView) this.f8140a.findViewById(R.id.try_to_avoid);
        this.z = this.f8140a.findViewById(R.id.ugc_detail_close_icon);
        return this.f8140a;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c0  */
    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.baidu.navisdk.ugc.eventdetails.model.b r8, android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ugc.eventdetails.view.c.a(com.baidu.navisdk.ugc.eventdetails.model.b, android.content.Context):void");
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
