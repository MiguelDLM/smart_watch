package com.sma.smartv3.ui.timezonepicker;

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
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.l4digital.fastscroll.FastScroller;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.timezonepicker.TimeZonePicker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes12.dex */
public class oIX0oI extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements FastScroller.xxIXOIIO, Filterable {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public I0Io f24177IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public List<TimeZoneInfo> f24178Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public String f24179Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public List<TimeZoneInfo> f24180XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public TimeZonePicker.Builder f24181oI0IIXIo;

    /* loaded from: classes12.dex */
    public interface I0Io {
        void oIX0oI(TimeZoneInfo timezone, int totalSelectedTimeZones);
    }

    /* loaded from: classes12.dex */
    public class II0xO0 extends Filter {
        public II0xO0() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence constraint) {
            List filteredResults;
            if (constraint.length() == 0) {
                filteredResults = oIX0oI.this.f24178Oo;
                oIX0oI.this.f24179Oxx0xo = null;
            } else {
                filteredResults = oIX0oI.this.getFilteredResults(constraint.toString().toLowerCase());
            }
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = filteredResults;
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence constraint, Filter.FilterResults results) {
            oIX0oI.this.f24180XO = (List) results.values;
            oIX0oI.this.notifyDataSetChanged();
        }
    }

    /* renamed from: com.sma.smartv3.ui.timezonepicker.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class ViewOnClickListenerC1029oIX0oI implements View.OnClickListener {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ int f24184Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ TimeZoneInfo f24185XO;

        public ViewOnClickListenerC1029oIX0oI(final TimeZoneInfo val$item, final int val$i) {
            this.f24185XO = val$item;
            this.f24184Oo = val$i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (oIX0oI.this.f24181oI0IIXIo.selectionMode == 1 && this.f24185XO.isSelected()) {
                return;
            }
            if (oIX0oI.this.f24181oI0IIXIo.maxSelectCount != 0) {
                if (oIX0oI.this.ooOOo0oXI() > oIX0oI.this.f24181oI0IIXIo.maxSelectCount) {
                    return;
                }
                if (oIX0oI.this.ooOOo0oXI() == oIX0oI.this.f24181oI0IIXIo.maxSelectCount) {
                    oIX0oI oix0oi = oIX0oI.this;
                    int OOXIXo2 = oix0oi.OOXIXo(oix0oi.f24180XO, this.f24185XO.getTimeZoneId());
                    if (OOXIXo2 != -1 && ((TimeZoneInfo) oIX0oI.this.f24180XO.get(OOXIXo2)).isSelected()) {
                        oIX0oI.this.x0XOIxOo(this.f24185XO.getCityName());
                    } else {
                        return;
                    }
                } else {
                    oIX0oI.this.x0XOIxOo(this.f24185XO.getCityName());
                }
            } else {
                oIX0oI.this.x0XOIxOo(this.f24185XO.getCityName());
            }
            if (oIX0oI.this.f24177IXxxXO != null) {
                oIX0oI.this.f24177IXxxXO.oIX0oI(oIX0oI.this.xoIox(this.f24184Oo), oIX0oI.this.ooOOo0oXI());
            }
            oIX0oI.this.notifyDataSetChanged();
        }
    }

    /* loaded from: classes12.dex */
    public class oxoX extends RecyclerView.ViewHolder {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public TextView f24187IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public TextView f24188Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public TextView f24189Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public AppCompatRadioButton f24190OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        public final View f24191XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public AppCompatCheckBox f24192oI0IIXIo;

        public oxoX(View view) {
            super(view);
            this.f24191XO = view;
            this.f24188Oo = (TextView) view.findViewById(R.id.tvTitle);
            this.f24187IXxxXO = (TextView) view.findViewById(R.id.tvName);
            this.f24189Oxx0xo = (TextView) view.findViewById(R.id.tvTip);
            this.f24192oI0IIXIo = (AppCompatCheckBox) view.findViewById(R.id.cbSelectedState);
            this.f24190OxxIIOOXO = (AppCompatRadioButton) view.findViewById(R.id.rbSelectedState);
        }
    }

    public oIX0oI(TimeZonePicker.Builder builder, List<TimeZoneInfo> timeZoneItemList, I0Io listener) {
        this.f24181oI0IIXIo = builder;
        this.f24180XO = timeZoneItemList;
        this.f24178Oo = timeZoneItemList;
        this.f24177IXxxXO = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TimeZoneInfo> getFilteredResults(String constraint) {
        ArrayList arrayList = new ArrayList();
        for (TimeZoneInfo timeZoneInfo : this.f24178Oo) {
            if ((timeZoneInfo.getCityName() + " " + timeZoneInfo.getEnCityName().toLowerCase() + " " + timeZoneInfo.getDisplayName().toLowerCase() + " " + timeZoneInfo.getCountry().toLowerCase() + " " + timeZoneInfo.getGMTName().toLowerCase()).contains(constraint.toLowerCase())) {
                arrayList.add(timeZoneInfo);
            }
        }
        return arrayList;
    }

    private void highlightTerm(TextView tv, String query, String originalString) {
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

    public final int OOXIXo(List<TimeZoneInfo> list, String id) {
        Iterator<TimeZoneInfo> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (Objects.equals(it.next().getCityName(), id)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void filterOnText(String query) {
        this.f24179Oxx0xo = query;
        getFilter().filter(this.f24179Oxx0xo);
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new II0xO0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<TimeZoneInfo> list = this.f24180XO;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public ArrayList<TimeZoneInfo> oOoXoXO() {
        ArrayList<TimeZoneInfo> arrayList = new ArrayList<>();
        for (TimeZoneInfo timeZoneInfo : this.f24178Oo) {
            if (timeZoneInfo.isSelected()) {
                arrayList.add(timeZoneInfo);
            }
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int i) {
        if (holder instanceof oxoX) {
            oxoX oxox = (oxoX) holder;
            TimeZoneInfo xoIox2 = xoIox(i);
            oxox.f24188Oo.setText(xoIox2.getCityName());
            highlightTerm(oxox.f24188Oo, this.f24179Oxx0xo, oxox.f24188Oo.getText().toString());
            oxox.f24187IXxxXO.setText(xoIox2.getDisplayName());
            highlightTerm(oxox.f24187IXxxXO, this.f24179Oxx0xo, oxox.f24187IXxxXO.getText().toString());
            oxox.f24189Oxx0xo.setText(xoIox2.getCountry() + "  " + xoIox2.getGMTName());
            highlightTerm(oxox.f24189Oxx0xo, this.f24179Oxx0xo, oxox.f24189Oxx0xo.getText().toString());
            if (this.f24181oI0IIXIo.selectionMode == 0) {
                oxox.f24192oI0IIXIo.setVisibility(0);
                oxox.f24190OxxIIOOXO.setVisibility(8);
            } else {
                oxox.f24192oI0IIXIo.setVisibility(8);
                oxox.f24190OxxIIOOXO.setVisibility(0);
            }
            if (xoIox2.isSelected()) {
                oxox.f24192oI0IIXIo.setChecked(true);
                oxox.f24190OxxIIOOXO.setChecked(true);
            } else {
                oxox.f24192oI0IIXIo.setChecked(false);
                oxox.f24190OxxIIOOXO.setChecked(false);
            }
            oxox.f24191XO.setOnClickListener(new ViewOnClickListenerC1029oIX0oI(xoIox2, i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new oxoX(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_timezone_pick_item, viewGroup, false));
    }

    public int ooOOo0oXI() {
        if (oOoXoXO() != null) {
            return oOoXoXO().size();
        }
        return 0;
    }

    public void setAllSelected(boolean isAll) {
        for (TimeZoneInfo timeZoneInfo : this.f24180XO) {
            timeZoneInfo.setSelected(isAll);
            I0Io i0Io = this.f24177IXxxXO;
            if (i0Io != null) {
                i0Io.oIX0oI(timeZoneInfo, ooOOo0oXI());
            }
        }
        notifyDataSetChanged();
    }

    public void x0XOIxOo(String id) {
        this.f24180XO.get(OOXIXo(this.f24180XO, id)).setSelected(!this.f24180XO.get(r3).isSelected());
    }

    public final TimeZoneInfo xoIox(int pos) {
        return this.f24180XO.get(pos);
    }

    @Override // com.l4digital.fastscroll.FastScroller.xxIXOIIO
    public String getSectionText(int position) {
        try {
            return String.valueOf(this.f24180XO.get(position).getEnCityName().charAt(0));
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            e.printStackTrace();
            return "";
        }
    }
}
