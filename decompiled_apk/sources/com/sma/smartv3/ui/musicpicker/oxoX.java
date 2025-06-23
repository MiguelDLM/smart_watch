package com.sma.smartv3.ui.musicpicker;

import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.l4digital.fastscroll.FastScroller;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.musicpicker.MusicPicker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public class oxoX extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements FastScroller.xxIXOIIO, Filterable {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public I0Io f23703IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public List<com.sma.smartv3.ui.musicpicker.oIX0oI> f23704Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public String f23705Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public List<com.sma.smartv3.ui.musicpicker.oIX0oI> f23706XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public MusicPicker.Builder f23707oI0IIXIo;

    /* loaded from: classes11.dex */
    public interface I0Io {
        void oIX0oI(com.sma.smartv3.ui.musicpicker.oIX0oI music, int totalSelectedMusics);
    }

    /* loaded from: classes11.dex */
    public class II0xO0 extends Filter {
        public II0xO0() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence constraint) {
            List filteredResults;
            if (constraint.length() == 0) {
                filteredResults = oxoX.this.f23704Oo;
                oxoX.this.f23705Oxx0xo = null;
            } else {
                filteredResults = oxoX.this.getFilteredResults(constraint.toString().toLowerCase());
            }
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = filteredResults;
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence constraint, Filter.FilterResults results) {
            oxoX.this.f23706XO = (List) results.values;
            oxoX.this.notifyDataSetChanged();
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements View.OnClickListener {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ int f23710Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ com.sma.smartv3.ui.musicpicker.oIX0oI f23711XO;

        public oIX0oI(final com.sma.smartv3.ui.musicpicker.oIX0oI val$musicItem, final int val$i) {
            this.f23711XO = val$musicItem;
            this.f23710Oo = val$i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (oxoX.this.f23707oI0IIXIo.maxSelectCount != 0) {
                if (oxoX.this.oOoXoXO() > oxoX.this.f23707oI0IIXIo.maxSelectCount) {
                    return;
                }
                if (oxoX.this.oOoXoXO() == oxoX.this.f23707oI0IIXIo.maxSelectCount) {
                    oxoX oxox = oxoX.this;
                    if (((com.sma.smartv3.ui.musicpicker.oIX0oI) oxoX.this.f23706XO.get(oxox.getItemPosition(oxox.f23706XO, this.f23711XO.oOoXoXO()))).Oxx0xo()) {
                        oxoX.this.ooOOo0oXI(this.f23711XO.oOoXoXO());
                    } else {
                        return;
                    }
                } else {
                    oxoX.this.ooOOo0oXI(this.f23711XO.oOoXoXO());
                }
            } else {
                oxoX.this.ooOOo0oXI(this.f23711XO.oOoXoXO());
            }
            if (oxoX.this.f23703IXxxXO != null) {
                oxoX.this.f23703IXxxXO.oIX0oI(oxoX.this.xoIox(this.f23710Oo), oxoX.this.oOoXoXO());
            }
            oxoX.this.notifyDataSetChanged();
        }
    }

    /* renamed from: com.sma.smartv3.ui.musicpicker.oxoX$oxoX, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0976oxoX extends RecyclerView.ViewHolder {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public TextView f23712IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public TextView f23713Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public AppCompatCheckBox f23714Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final View f23715XO;

        public C0976oxoX(View view) {
            super(view);
            this.f23715XO = view;
            this.f23713Oo = (TextView) view.findViewById(R.id.tvTitle);
            this.f23712IXxxXO = (TextView) view.findViewById(R.id.tvName);
            this.f23714Oxx0xo = (AppCompatCheckBox) view.findViewById(R.id.cbSelectedState);
        }
    }

    public oxoX(MusicPicker.Builder builder, List<com.sma.smartv3.ui.musicpicker.oIX0oI> musicItemList, I0Io listener) {
        this.f23707oI0IIXIo = builder;
        this.f23706XO = musicItemList;
        this.f23704Oo = musicItemList;
        this.f23703IXxxXO = listener;
    }

    public List<com.sma.smartv3.ui.musicpicker.oIX0oI> OOXIXo() {
        ArrayList arrayList = new ArrayList();
        for (com.sma.smartv3.ui.musicpicker.oIX0oI oix0oi : this.f23704Oo) {
            if (oix0oi.Oxx0xo()) {
                arrayList.add(oix0oi);
            }
        }
        return arrayList;
    }

    public void filterOnText(String query) {
        this.f23705Oxx0xo = query;
        getFilter().filter(this.f23705Oxx0xo);
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new II0xO0();
    }

    public final List<com.sma.smartv3.ui.musicpicker.oIX0oI> getFilteredResults(String constraint) {
        ArrayList arrayList = new ArrayList();
        for (com.sma.smartv3.ui.musicpicker.oIX0oI oix0oi : this.f23704Oo) {
            if (oix0oi.x0xO0oo().toLowerCase().contains(constraint)) {
                arrayList.add(oix0oi);
            }
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<com.sma.smartv3.ui.musicpicker.oIX0oI> list = this.f23706XO;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final int getItemPosition(List<com.sma.smartv3.ui.musicpicker.oIX0oI> list, long mid) {
        Iterator<com.sma.smartv3.ui.musicpicker.oIX0oI> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().oOoXoXO() == mid) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final void highlightTerm(TextView tv, String query, String originalString) {
        if (query != null && !query.isEmpty()) {
            int indexOf = originalString.toLowerCase().indexOf(query.toLowerCase());
            int length = query.length() + indexOf;
            if (indexOf != -1) {
                SpannableString spannableString = new SpannableString(originalString);
                spannableString.setSpan(new TextAppearanceSpan(null, 1, -1, new ColorStateList(new int[][]{new int[0]}, new int[]{ViewCompat.MEASURED_STATE_MASK}), null), indexOf, length, 33);
                tv.setText(spannableString);
                return;
            }
            tv.setText(originalString);
            return;
        }
        tv.setText(originalString);
    }

    public int oOoXoXO() {
        if (OOXIXo() != null) {
            return OOXIXo().size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int i) {
        String str;
        if (holder instanceof C0976oxoX) {
            C0976oxoX c0976oxoX = (C0976oxoX) holder;
            com.sma.smartv3.ui.musicpicker.oIX0oI xoIox2 = xoIox(i);
            String x0xO0oo2 = xoIox2.x0xO0oo();
            float oO2 = (((float) xoIox2.oO()) / 1024.0f) / 1024.0f;
            if (xoIox2.XO().startsWith("<unk") && xoIox2.oxoX().equals("0")) {
                str = String.format(Locale.ENGLISH, "%.2fMB", Float.valueOf(oO2));
            } else {
                str = xoIox2.XO() + " - " + xoIox2.oxoX() + "   " + String.format(Locale.ENGLISH, "%.2fMB", Float.valueOf(oO2));
            }
            c0976oxoX.f23713Oo.setText(x0xO0oo2);
            c0976oxoX.f23712IXxxXO.setText(str);
            highlightTerm(c0976oxoX.f23713Oo, this.f23705Oxx0xo, c0976oxoX.f23713Oo.getText().toString());
            highlightTerm(c0976oxoX.f23712IXxxXO, this.f23705Oxx0xo, c0976oxoX.f23712IXxxXO.getText().toString());
            if (xoIox2.Oxx0xo()) {
                c0976oxoX.f23714Oxx0xo.setChecked(true);
            } else {
                c0976oxoX.f23714Oxx0xo.setChecked(false);
            }
            c0976oxoX.f23715XO.setOnClickListener(new oIX0oI(xoIox2, i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new C0976oxoX(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_music_pick_item, viewGroup, false));
    }

    public void ooOOo0oXI(long id) {
        this.f23706XO.get(getItemPosition(this.f23706XO, id)).XIxXXX0x0(!this.f23706XO.get(r2).Oxx0xo());
    }

    public void setAllSelected(boolean isAll) {
        for (com.sma.smartv3.ui.musicpicker.oIX0oI oix0oi : this.f23706XO) {
            oix0oi.XIxXXX0x0(isAll);
            I0Io i0Io = this.f23703IXxxXO;
            if (i0Io != null) {
                i0Io.oIX0oI(oix0oi, oOoXoXO());
            }
        }
        notifyDataSetChanged();
    }

    public final com.sma.smartv3.ui.musicpicker.oIX0oI xoIox(int pos) {
        return this.f23706XO.get(pos);
    }

    @Override // com.l4digital.fastscroll.FastScroller.xxIXOIIO
    public String getSectionText(int position) {
        try {
            return String.valueOf(this.f23706XO.get(position).x0xO0oo().charAt(0));
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            e.printStackTrace();
            return "";
        }
    }
}
