package com.baidu.navisdk.ugc.report.ui.innavi.mayi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.utils.k;
import com.baidu.navisdk.util.jar.JarUtils;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class a extends RecyclerView.Adapter<c> {

    /* renamed from: a, reason: collision with root package name */
    private Context f8295a;
    private int b;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> c;
    private b d;

    /* renamed from: com.baidu.navisdk.ugc.report.ui.innavi.mayi.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC0397a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8296a;

        public ViewOnClickListenerC0397a(int i) {
            this.f8296a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.d != null && a.this.c != null) {
                a.this.d.onItemClick(((com.baidu.navisdk.ugc.report.data.datarepository.b) a.this.c.get(this.f8296a)).b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void onItemClick(int i);
    }

    /* loaded from: classes8.dex */
    public static class c extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private View f8297a;
        private ImageView b;
        private TextView c;

        public c(View view) {
            super(view);
            this.f8297a = view;
            this.b = (ImageView) view.findViewById(R.id.ugc_report_navi_mayi_item_iv);
            this.c = (TextView) view.findViewById(R.id.ugc_report_navi_mayi_item_tv);
        }
    }

    public a(Context context, int i, ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList, b bVar) {
        this.f8295a = context;
        this.b = i;
        this.c = arrayList;
        this.d = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = this.c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i) {
        com.baidu.navisdk.ugc.report.data.datarepository.b bVar = this.c.get(i);
        com.baidu.navisdk.ugc.utils.d.a(bVar.b, cVar.b);
        cVar.c.setText(bVar.f8246a);
        cVar.f8297a.setOnClickListener(new ViewOnClickListenerC0397a(i));
        k.a(cVar.f8297a, cVar.b, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate;
        if (this.b == 1) {
            inflate = JarUtils.inflate(this.f8295a, R.layout.nsdk_layout_ugc_report_navi_mayi_recycler_item, null);
        } else {
            inflate = JarUtils.inflate(this.f8295a, R.layout.nsdk_layout_ugc_report_navi_mayi_recycler_item_land, null);
        }
        return new c(inflate);
    }
}
