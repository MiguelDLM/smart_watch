package com.miguelcatalan.materialsearchview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public class II0xO0 extends BaseAdapter implements Filterable {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Drawable f18512IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public String[] f18513Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public LayoutInflater f18514Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public ArrayList<String> f18515XO = new ArrayList<>();

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f18516oI0IIXIo;

    /* renamed from: com.miguelcatalan.materialsearchview.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0889II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public ImageView f18518II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public TextView f18519oIX0oI;

        public C0889II0xO0(View view) {
            this.f18519oIX0oI = (TextView) view.findViewById(R.id.suggestion_text);
            if (II0xO0.this.f18512IXxxXO != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.suggestion_icon);
                this.f18518II0xO0 = imageView;
                imageView.setImageDrawable(II0xO0.this.f18512IXxxXO);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI extends Filter {
        public oIX0oI() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (!TextUtils.isEmpty(charSequence)) {
                ArrayList arrayList = new ArrayList();
                for (String str : II0xO0.this.f18513Oo) {
                    if (str.toLowerCase().startsWith(charSequence.toString().toLowerCase())) {
                        arrayList.add(str);
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            Object obj = filterResults.values;
            if (obj != null) {
                II0xO0.this.f18515XO = (ArrayList) obj;
                II0xO0.this.notifyDataSetChanged();
            }
        }
    }

    public II0xO0(Context context, String[] strArr) {
        this.f18514Oxx0xo = LayoutInflater.from(context);
        this.f18513Oo = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18515XO.size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new oIX0oI();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f18515XO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0889II0xO0 c0889II0xO0;
        if (view == null) {
            view = this.f18514Oxx0xo.inflate(R.layout.suggest_item, viewGroup, false);
            c0889II0xO0 = new C0889II0xO0(view);
            view.setTag(c0889II0xO0);
        } else {
            c0889II0xO0 = (C0889II0xO0) view.getTag();
        }
        c0889II0xO0.f18519oIX0oI.setText((String) getItem(i));
        if (this.f18516oI0IIXIo) {
            c0889II0xO0.f18519oIX0oI.setSingleLine();
            c0889II0xO0.f18519oIX0oI.setEllipsize(TextUtils.TruncateAt.END);
        }
        return view;
    }

    public II0xO0(Context context, String[] strArr, Drawable drawable, boolean z) {
        this.f18514Oxx0xo = LayoutInflater.from(context);
        this.f18513Oo = strArr;
        this.f18512IXxxXO = drawable;
        this.f18516oI0IIXIo = z;
    }
}
