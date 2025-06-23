package com.baidu.navisdk.module.newguide.settings.customguideui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class a extends RecyclerView.Adapter<c> {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.baidu.navisdk.module.newguide.settings.customguideui.b> f7236a;
    private b b;
    private Context c;

    /* renamed from: com.baidu.navisdk.module.newguide.settings.customguideui.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0251a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f7237a;

        public C0251a(c cVar) {
            this.f7237a = cVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            a.this.a(this.f7237a, z);
            if (a.this.b != null) {
                a.this.b.a(this.f7237a.getAdapterPosition(), z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i, boolean z);
    }

    /* loaded from: classes7.dex */
    public static class c extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        TextView f7238a;
        CheckBox b;
        ImageView c;

        public c(View view) {
            super(view);
            this.f7238a = (TextView) view.findViewById(R.id.custom_item_text);
            this.b = (CheckBox) view.findViewById(R.id.custom_item_image);
            this.c = (ImageView) view.findViewById(R.id.custom_item_stroke);
        }
    }

    public a(ArrayList<com.baidu.navisdk.module.newguide.settings.customguideui.b> arrayList, Context context) {
        new ArrayList();
        this.f7236a = arrayList;
        this.c = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f7236a.size();
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new c(com.baidu.navisdk.ui.util.b.a(this.c, R.layout.nsdk_custom_guide_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ImageRecyclerView", "此处进入了onBindViewHolder方法");
            gVar.e("ImageRecyclerView before : ", this.f7236a.get(i).toString());
        }
        cVar.f7238a.setText(this.f7236a.get(i).c());
        cVar.b.setButtonDrawable(this.f7236a.get(i).b());
        boolean a2 = this.f7236a.get(i).a();
        a(cVar, a2);
        cVar.b.setChecked(a2);
        cVar.b.setOnCheckedChangeListener(new C0251a(cVar));
    }

    public void a(c cVar, boolean z) {
        if (z) {
            cVar.c.setVisibility(0);
        } else {
            cVar.c.setVisibility(4);
        }
    }
}
