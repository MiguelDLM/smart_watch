package com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.g;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class a extends RecyclerView.Adapter<d> {

    /* renamed from: a, reason: collision with root package name */
    private Context f8796a;
    private c c;
    private List<String> b = new ArrayList();
    private int d = -1;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC0459a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8797a;

        public ViewOnClickListenerC0459a(int i) {
            this.f8797a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f8797a);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8798a;

        public b(int i) {
            this.f8798a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f8798a);
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(String str);
    }

    /* loaded from: classes8.dex */
    public static class d extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private TextView f8799a;

        public d(View view) {
            super(view);
            this.f8799a = (TextView) view.findViewById(R.id.name);
        }
    }

    public a(Context context) {
        this.f8796a = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    public void a(List<String> list) {
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public d onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = JarUtils.inflate(this.f8796a, R.layout.nsdk_layout_indoor_park_floor_filter_recycler_item, null);
        if (inflate == null) {
            return null;
        }
        inflate.setLayoutParams(new ViewGroup.LayoutParams(JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_42dp), JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_37dp)));
        return new d(inflate);
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(d dVar, int i) {
        if (dVar == null) {
            return;
        }
        if (i == 0) {
            if (this.d == i) {
                dVar.itemView.setBackgroundResource(R.drawable.nsdk_bmbar_up_bac_press);
            } else {
                dVar.itemView.setBackgroundResource(R.drawable.nsdk_bmbar_up_bac);
            }
        } else if (i == getItemCount() - 1) {
            if (this.d == i) {
                dVar.itemView.setBackgroundResource(R.drawable.nsdk_bmbar_down_bac_press);
            } else {
                dVar.itemView.setBackgroundResource(R.drawable.nsdk_bmbar_down_bac);
            }
        } else if (this.d == i) {
            dVar.itemView.setBackgroundResource(R.drawable.nsdk_bmbar_middle_bac_press);
        } else {
            dVar.itemView.setBackgroundResource(R.drawable.nsdk_bmbar_middle_bac);
        }
        if (this.d == i) {
            dVar.f8799a.setTextColor(-1);
        } else {
            dVar.f8799a.setTextColor(-13488081);
        }
        dVar.f8799a.setText(this.b.get(i));
        dVar.f8799a.setOnClickListener(new ViewOnClickListenerC0459a(i));
        dVar.itemView.setOnClickListener(new b(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (g.a()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("FastDoubleClick", "nearby search filter view,FastDoubleClick");
            }
        } else {
            this.d = i;
            c cVar = this.c;
            if (cVar != null) {
                cVar.a(this.b.get(i));
            }
            notifyDataSetChanged();
        }
    }

    public void a(String str) {
        if (l0.c(str)) {
            return;
        }
        int indexOf = this.b.indexOf(str);
        if (indexOf < 0) {
            indexOf = 0;
        }
        this.d = indexOf;
        notifyDataSetChanged();
    }
}
