package com.baidu.navisdk.ui.routeguide.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.utils.c;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class d extends RecyclerView.Adapter<c> {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f9160a;
    private HashMap<String, e> b;
    private b c;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f9161a;

        public a(c cVar) {
            this.f9161a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.c.a(view, this.f9161a.getAdapterPosition());
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(View view, int i);
    }

    /* loaded from: classes8.dex */
    public class c extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        TextView f9162a;

        public c(d dVar, TextView textView) {
            super(textView);
            this.f9162a = textView;
        }
    }

    public d(c.f1<String, e> f1Var) {
        this.f9160a = new ArrayList<>();
        new HashMap();
        this.b = f1Var;
        this.f9160a = f1Var.f9155a;
    }

    public ArrayList<String> b() {
        return this.f9160a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return b().size();
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new c(this, (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nsdk_layout_rg_mapmode_debug_text, viewGroup, false));
    }

    public HashMap<String, e> a() {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i) {
        cVar.f9162a.setText(b().get(i));
        if (this.c != null) {
            cVar.f9162a.setOnClickListener(new a(cVar));
        }
    }
}
