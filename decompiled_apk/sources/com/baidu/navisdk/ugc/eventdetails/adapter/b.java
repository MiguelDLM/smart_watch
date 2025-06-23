package com.baidu.navisdk.ugc.eventdetails.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.eventdetails.model.e;
import com.baidu.navisdk.ugc.eventdetails.view.BNRCEventDetailLabelsView;
import com.baidu.navisdk.ugc.eventdetails.view.VideoWidget;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.PtrrvBaseAdapter;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.jar.JarUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class b extends PtrrvBaseAdapter<e> {

    /* renamed from: a, reason: collision with root package name */
    private Context f8046a;
    private ArrayList<e.a> b;
    private ArrayList<e.a> c;
    private ArrayList<e.a> d;
    private j e;
    private i f;
    private boolean g;
    private View h;
    private int i;
    private h j;
    private e.a k;
    private f l;
    private VideoWidget.a m;
    private boolean n;
    private com.baidu.navisdk.ugc.eventdetails.control.a o;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.n) {
                return;
            }
            if (!z.a(com.baidu.navisdk.framework.a.c().a())) {
                TipTool.onCreateToastDialog(b.this.f8046a, JarUtils.getResources().getString(R.string.ugc_network_unconnected));
            } else if (!b.this.o.c()) {
                b.this.n = true;
                b.this.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.eventdetails.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC0373b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e.a f8048a;
        final /* synthetic */ h b;

        public ViewOnClickListenerC0373b(e.a aVar, h hVar) {
            this.f8048a = aVar;
            this.b = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a(this.f8048a, this.b);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e.a f8049a;

        public c(e.a aVar) {
            this.f8049a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = (String) view.getTag();
            if (b.this.e != null) {
                b.this.e.a(true, str, this.f8049a.f);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2.4", b.this.o.m() + "", "2", null);
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8050a;

        static {
            int[] iArr = new int[i.values().length];
            f8050a = iArr;
            try {
                iArr[i.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8050a[i.LOADED_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8050a[i.LOADED_NO_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8050a[i.LOADED_HAS_DATA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8050a[i.INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends RecyclerView.ViewHolder {
        public e(b bVar, View view) {
            super(view);
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a(e.a aVar);
    }

    /* loaded from: classes8.dex */
    public class g extends e {

        /* renamed from: a, reason: collision with root package name */
        private TextView f8051a;

        public g(b bVar, View view) {
            super(bVar, view);
            this.f8051a = (TextView) view.findViewById(R.id.ugc_event_details_comment_num);
        }
    }

    /* loaded from: classes8.dex */
    public class h extends e {

        /* renamed from: a, reason: collision with root package name */
        private TextView f8052a;
        private ImageView b;
        private TextView c;
        private TextView d;
        private ImageView e;
        private TextView f;
        private View g;
        private ImageView h;
        private BNRCEventDetailLabelsView i;
        private View j;
        private TextView k;
        private VideoWidget l;

        public h(b bVar, View view) {
            super(bVar, view);
            this.f8052a = (TextView) view.findViewById(R.id.tv_reporter);
            this.b = (ImageView) view.findViewById(R.id.iv_ugc_detail_comment_user_level);
            this.c = (TextView) view.findViewById(R.id.tv_time_stamp);
            this.d = (TextView) view.findViewById(R.id.tv_ugc_detail_comment_label);
            this.e = (ImageView) view.findViewById(R.id.iv_ugc_comment_useful);
            this.f = (TextView) view.findViewById(R.id.tv_ugc_comment_useful_num);
            this.g = view.findViewById(R.id.ugc_comment_feedback_layout);
            this.h = (ImageView) view.findViewById(R.id.img_thumbnail);
            this.i = (BNRCEventDetailLabelsView) view.findViewById(R.id.ugc_detail_comment_labels_view);
            this.j = view.findViewById(R.id.label_divider);
            this.k = (TextView) view.findViewById(R.id.tv_event_description);
            VideoWidget videoWidget = (VideoWidget) view.findViewById(R.id.ugc_event_comment_video_layout);
            this.l = videoWidget;
            if (videoWidget != null) {
                videoWidget.setFrom(2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public enum i {
        INVALID,
        LOADING,
        LOADED_NO_DATA,
        LOADED_HAS_DATA,
        LOADED_FAILED
    }

    /* loaded from: classes8.dex */
    public interface j {
        void a(boolean z, String str, boolean z2);
    }

    /* loaded from: classes8.dex */
    public class k extends e {

        /* renamed from: a, reason: collision with root package name */
        private ViewGroup f8054a;
        private View b;

        public k(b bVar, View view) {
            super(bVar, view);
            this.f8054a = (ViewGroup) view.findViewById(R.id.comments_loading_container);
            this.b = view.findViewById(R.id.no_comments_prompt);
        }
    }

    /* loaded from: classes8.dex */
    public class l extends e {

        /* renamed from: a, reason: collision with root package name */
        private TextView f8055a;
        private LinearLayout b;

        public l(b bVar, View view) {
            super(bVar, view);
            this.f8055a = (TextView) view.findViewById(R.id.tv_ugc_detail_new_comment_num);
            this.b = (LinearLayout) view.findViewById(R.id.layout_ugc_detail_new_comment_loading);
        }
    }

    public b(Context context, com.baidu.navisdk.ugc.eventdetails.control.a aVar) {
        super(context);
        this.f = i.INVALID;
        this.g = false;
        this.n = false;
        this.f8046a = context;
        this.o = aVar;
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.PtrrvBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i2;
        ArrayList<e.a> arrayList = this.b;
        if (arrayList != null) {
            i2 = arrayList.size();
        } else {
            i2 = 0;
        }
        ArrayList<e.a> arrayList2 = this.c;
        if (arrayList2 != null) {
            i2 += arrayList2.size();
        }
        ArrayList<e.a> arrayList3 = this.d;
        if (arrayList3 != null) {
            i2 += arrayList3.size();
        }
        return i2 + 5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return 2;
        }
        if (i2 == 3) {
            return 3;
        }
        if (i2 == getItemCount() - 1) {
            return 5;
        }
        return 4;
    }

    public void b(boolean z) {
        this.g = z;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "setShowNoMoreCommentsFooter: showNoMoreCommentsFooter --> " + z);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.PtrrvBaseAdapter
    public e.a getItem(int i2) {
        ArrayList<e.a> arrayList = this.c;
        int size = arrayList != null ? arrayList.size() : 0;
        ArrayList<e.a> arrayList2 = this.d;
        int size2 = arrayList2 != null ? arrayList2.size() : 0;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "ugc details adapter getitem positon: " + i2 + ", topSize:" + size + ", goodSize:" + size2);
        }
        if (i2 < size2 && i2 >= 0) {
            return this.d.get(i2);
        }
        int i3 = i2 - size2;
        if (i3 < size && i3 >= 0) {
            return this.c.get(i3);
        }
        int i4 = i3 - size;
        ArrayList<e.a> arrayList3 = this.b;
        if (arrayList3 == null) {
            return null;
        }
        return arrayList3.get(i4);
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.PtrrvBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public e onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new e(this, this.h);
        }
        if (i2 == 1) {
            return new l(this, JarUtils.inflate(this.f8046a, R.layout.nsdk_layout_ugc_detail_new_comment_num, null));
        }
        if (i2 == 2) {
            return new k(this, JarUtils.inflate(this.f8046a, R.layout.nsdk_layout_ugc_detail_loading_container, null));
        }
        if (i2 == 3) {
            return new g(this, JarUtils.inflate(this.f8046a, R.layout.nsdk_layout_ugc_detail_comments_header, null));
        }
        if (i2 != 5) {
            return new h(this, JarUtils.inflate(this.f8046a, R.layout.nsdk_layout_ugc_detail_comment_item, null));
        }
        return new e(this, JarUtils.inflate(this.f8046a, R.layout.ugc_comments_ptr_footer_no_more_data, null));
    }

    public void a(ArrayList<e.a> arrayList, ArrayList<e.a> arrayList2, ArrayList<e.a> arrayList3) {
        if (arrayList != null) {
            this.b = arrayList;
        }
        this.c = arrayList2;
        this.d = arrayList3;
    }

    private void b(l lVar) {
        lVar.f8055a.setVisibility(8);
        lVar.b.setVisibility(0);
        View b = this.o.b(1);
        if (b != null) {
            if (b.getParent() != null && (b.getParent() instanceof ViewGroup)) {
                ((ViewGroup) b.getParent()).removeView(b);
            }
            int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_30dp);
            lVar.b.addView(b, 0, new ViewGroup.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        }
    }

    public void a(i iVar) {
        this.f = iVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "setCommentsLoadingState: commentsLoadingState --> " + iVar);
        }
    }

    public void a(j jVar) {
        this.e = jVar;
    }

    public void a(View view) {
        this.h = view;
    }

    public void a(int i2) {
        this.i = i2;
    }

    private void b(e.a aVar, h hVar) {
        RequestBuilder<Drawable> load = Glide.with(this.f8046a).load(aVar.e);
        int i2 = R.drawable.nsdk_rc_img_default_bg;
        load.error(i2).fallback(i2).into(hVar.h);
        if (hVar.h != null) {
            hVar.h.setClickable(true);
        }
    }

    public void a(f fVar) {
        this.l = fVar;
    }

    public void a(VideoWidget.a aVar) {
        this.m = aVar;
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.PtrrvBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(e eVar, int i2) {
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 1) {
            a((l) eVar);
            return;
        }
        if (itemViewType == 2) {
            a((k) eVar);
            return;
        }
        if (itemViewType == 3) {
            if (this.f == i.LOADED_HAS_DATA) {
                g gVar = (g) eVar;
                gVar.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_ugc_details_comment_heard_title_height)));
                gVar.itemView.setVisibility(0);
                gVar.f8051a.setText(JarUtils.getResources().getString(R.string.nsdk_string_ugc_user_comment_num, Integer.valueOf(this.o.k().d())));
                return;
            }
            eVar.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
            eVar.itemView.setVisibility(8);
            return;
        }
        if (itemViewType == 4) {
            a((h) eVar, i2);
            return;
        }
        if (itemViewType != 5) {
            return;
        }
        if (this.g) {
            eVar.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            eVar.itemView.findViewById(R.id.no_more_comments_container).setVisibility(0);
            eVar.itemView.findViewById(R.id.no_more_comments).setVisibility(0);
        } else {
            eVar.itemView.findViewById(R.id.no_more_comments_container).setVisibility(8);
            eVar.itemView.findViewById(R.id.no_more_comments).setVisibility(8);
        }
    }

    private void a(l lVar) {
        lVar.itemView.setMinimumHeight(ScreenUtil.getInstance().dip2px(8));
        lVar.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (!this.n) {
            lVar.b.setVisibility(8);
            int i2 = this.o.k().R;
            if (i2 > 0) {
                lVar.f8055a.setVisibility(0);
                lVar.f8055a.setText(JarUtils.getResources().getString(R.string.nsdk_string_ugc_detail_new_comment_num, Integer.valueOf(i2)));
                lVar.f8055a.setOnClickListener(new a());
                return;
            }
            lVar.f8055a.setVisibility(8);
            return;
        }
        b(lVar);
    }

    public void a() {
        this.n = false;
    }

    private void a(k kVar) {
        View b;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "handlerLoadState commentsLoadingState: " + this.f);
        }
        int i2 = d.f8050a[this.f.ordinal()];
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                kVar.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                kVar.f8054a.setVisibility(8);
                kVar.b.setVisibility(8);
                return;
            } else {
                int i3 = this.i;
                kVar.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, i3 > 0 ? i3 : -2));
                kVar.f8054a.setVisibility(8);
                kVar.b.setVisibility(0);
                return;
            }
        }
        int i4 = this.i;
        kVar.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, i4 > 0 ? i4 : -2));
        kVar.f8054a.setVisibility(0);
        kVar.b.setVisibility(8);
        kVar.f8054a.removeAllViews();
        if (this.f == i.LOADED_FAILED) {
            b = this.o.b(3);
        } else {
            b = this.o.b(1);
        }
        if (b != null) {
            if (b.getParent() != null && (b.getParent() instanceof ViewGroup)) {
                ((ViewGroup) b.getParent()).removeView(b);
            }
            kVar.f8054a.addView(b, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private void a(h hVar, int i2) {
        hVar.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        e.a item = getItem(i2 - 4);
        if (item != null) {
            TextView textView = hVar.f8052a;
            String str = item.c;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            int i3 = item.d;
            if (i3 == 1) {
                hVar.b.setVisibility(0);
                hVar.b.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_detail_user_level_1));
            } else if (i3 != 2) {
                hVar.b.setVisibility(8);
            } else {
                hVar.b.setVisibility(0);
                hVar.b.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_detail_user_level_2));
            }
            TextView textView2 = hVar.c;
            String str3 = item.f8075a;
            if (str3 == null) {
                str3 = "";
            }
            textView2.setText(str3);
            int i4 = item.r;
            if (i4 == 2) {
                hVar.d.setVisibility(0);
                hVar.d.setBackgroundResource(R.drawable.nsdk_ugc_event_detailes_comment_label_bg_premium);
                hVar.d.setText(R.string.nsdk_string_ugc_premium_comment);
            } else if (i4 == 1) {
                hVar.d.setVisibility(0);
                hVar.d.setBackgroundResource(R.drawable.nsdk_ugc_event_detailes_comment_label_bg_top);
                hVar.d.setText(R.string.nsdk_string_ugc_top_comment);
            } else {
                hVar.d.setVisibility(8);
            }
            hVar.e.setImageDrawable(item.o ? com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_comment_useful_selected) : com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_useful_normal));
            if (item.l > 0) {
                str2 = "" + item.l;
            }
            hVar.f.setText(str2);
            hVar.g.setOnClickListener(new ViewOnClickListenerC0373b(item, hVar));
            boolean a2 = hVar.i.a(item.h);
            if (!TextUtils.isEmpty(item.e)) {
                hVar.h.setVisibility(0);
                hVar.h.setTag(item.e);
                hVar.h.setOnClickListener(new c(item));
                hVar.h.setClickable(false);
                b(item, hVar);
            } else {
                hVar.h.setVisibility(8);
            }
            if (TextUtils.isEmpty(item.g)) {
                hVar.j.setVisibility(8);
                hVar.k.setVisibility(8);
            } else {
                if (a2) {
                    hVar.j.setVisibility(0);
                } else {
                    hVar.j.setVisibility(8);
                }
                hVar.k.setVisibility(0);
                hVar.k.setText(item.g);
            }
            hVar.itemView.setTag(item);
            e.b bVar = item.p;
            if (bVar == null || !bVar.d()) {
                hVar.l.setClickPlayVideoListener(null);
                hVar.l.a();
            } else {
                hVar.l.setClickPlayVideoListener(this.m);
                VideoWidget videoWidget = hVar.l;
                e.b bVar2 = item.p;
                videoWidget.a(bVar2.b, bVar2.f8076a, bVar2.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar, h hVar) {
        if (!z.a(com.baidu.navisdk.framework.a.c().a())) {
            TipTool.onCreateToastDialog(this.f8046a, JarUtils.getResources().getString(R.string.ugc_network_unconnected));
            return;
        }
        if (this.j != null) {
            return;
        }
        if (aVar.o) {
            TipTool.onCreateToastDialog(this.f8046a, JarUtils.getResources().getString(R.string.nsdk_string_ugc_evaluated));
            return;
        }
        this.j = hVar;
        this.k = aVar;
        if (aVar.q) {
            a(true);
            return;
        }
        f fVar = this.l;
        if (fVar != null) {
            fVar.a(aVar);
        }
    }

    public void a(boolean z) {
        Drawable f2;
        if (z) {
            e.a aVar = this.k;
            if (aVar != null) {
                aVar.o = true;
                aVar.l++;
            }
            h hVar = this.j;
            if (hVar != null) {
                Object tag = hVar.itemView.getTag();
                if ((tag instanceof e.a) && tag.equals(this.k)) {
                    ImageView imageView = this.j.e;
                    if (this.k.o) {
                        f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_comment_useful_selected);
                    } else {
                        f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_useful_normal);
                    }
                    imageView.setImageDrawable(f2);
                    String str = "";
                    if (this.k.l > 0) {
                        str = "" + this.k.l;
                    }
                    this.j.f.setText(str);
                }
            }
        }
        this.j = null;
        this.k = null;
    }
}
