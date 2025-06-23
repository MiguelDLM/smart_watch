package com.baidu.navisdk.ui.routeguide.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.v;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import java.util.List;

/* loaded from: classes8.dex */
public class b extends RecyclerView.Adapter<a> {

    /* renamed from: a, reason: collision with root package name */
    private List<v.a> f8438a;
    private int b;
    private int c;
    private final int d;

    /* loaded from: classes8.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        TextView f8439a;
        TextView b;
        View c;

        public a(@NonNull b bVar, View view) {
            super(view);
            this.f8439a = (TextView) view.findViewById(R.id.bnav_remain_stall_text);
            this.b = (TextView) view.findViewById(R.id.bnav_floor);
            this.c = view.findViewById(R.id.bnav_progress);
        }

        public void a(v.a aVar) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.c.getLayoutParams();
            float a2 = aVar.a() / aVar.c();
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRemainStallAdapter", "itemData.getLeft()-->" + aVar.a() + ", itemData.getTotal() = " + aVar.c() + ", percent = " + a2);
            }
            if (a2 > 1.0f) {
                a2 = 1.0f;
            }
            layoutParams.matchConstraintPercentWidth = a2;
            this.c.setLayoutParams(layoutParams);
        }
    }

    public b(List<v.a> list) {
        this.f8438a = list;
        int e = com.baidu.navisdk.ui.util.b.e(R.dimen.navi_dimens_2dp);
        this.d = e;
        int e2 = com.baidu.navisdk.ui.util.b.e(R.dimen.navi_dimens_28dp);
        this.c = ScreenUtil.getInstance().getWidthPixels() - e2;
        this.b = ((ScreenUtil.getInstance().getHeightPixels() - com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().a()) - x.b().V()) - e2;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRemainStallAdapter", "marginWidth-->" + e);
            gVar.e("RGRemainStallAdapter", "getLandGuidePanelWidth-->" + x.b().V());
            gVar.e("RGRemainStallAdapter", "mVerticalRecyclerViewWidth-->" + this.c + ", mHorizonRecyclerViewWidth = " + this.b);
        }
    }

    public void a(List<v.a> list) {
        this.f8438a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<v.a> list = this.f8438a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(this, com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.ui.routeguide.b.V().c(), R.layout.nsdk_layout_rg_remain_stall_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        String str;
        int i2;
        v.a aVar2 = this.f8438a.get(i);
        TextView textView = aVar.f8439a;
        if (aVar2.a() <= 0) {
            str = "已满";
        } else {
            str = "空" + aVar2.a();
        }
        textView.setText(str);
        aVar.b.setText(aVar2.b());
        aVar.f8439a.setTextColor(aVar2.a() > 0 ? -16072814 : -45747);
        aVar.a(aVar2);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) aVar.itemView.getLayoutParams();
        boolean s2 = x.b().s2();
        if (s2) {
            i2 = this.c;
        } else {
            i2 = this.b;
        }
        if (this.f8438a.size() == 1) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        } else if (this.f8438a.size() == 2) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = (this.d + i2) / 2;
        } else if (this.f8438a.size() == 3) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = ((this.d * 2) + i2) / 3;
        } else if (this.f8438a.size() > 3) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = (((this.d * 2) + i2) / 3) - com.baidu.navisdk.ui.util.b.e(R.dimen.navi_dimens_5dp);
        }
        aVar.itemView.setLayoutParams(layoutParams);
        if (i != 0) {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = -this.d;
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 0;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRemainStallAdapter", "isOrientationPortrait-->" + s2 + ", recyclerViewWidth = " + i2 + ", params.width = " + ((ViewGroup.MarginLayoutParams) layoutParams).width);
        }
        aVar.itemView.setLayoutParams(layoutParams);
    }
}
