package com.sma.smartv3.ui.status;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sma.smartv3.co_fit.R;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class SportRecordDetailSpeedAdapter extends RecyclerView.Adapter<SportRecordDetailSpeedViewHolder> {

    @OXOo.OOXIXo
    private final Context context;

    @OXOo.OOXIXo
    private final ArrayList<xoIox> items;

    public SportRecordDetailSpeedAdapter(@OXOo.OOXIXo ArrayList<xoIox> items, @OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(items, "items");
        IIX0o.x0xO0oo(context, "context");
        this.items = items;
        this.context = context;
    }

    @OXOo.OOXIXo
    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@OXOo.OOXIXo SportRecordDetailSpeedViewHolder holder, int i) {
        IIX0o.x0xO0oo(holder, "holder");
        xoIox xoiox = this.items.get(i);
        IIX0o.oO(xoiox, "get(...)");
        xoIox xoiox2 = xoiox;
        holder.getNumber().setText(xoiox2.oIX0oI());
        holder.getPb().setPB(xoiox2.I0Io());
        holder.getTvPace().setText(xoiox2.II0xO0());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @OXOo.OOXIXo
    public SportRecordDetailSpeedViewHolder onCreateViewHolder(@OXOo.OOXIXo ViewGroup parent, int i) {
        IIX0o.x0xO0oo(parent, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.item_sport_record_detail_pace_content, parent, false);
        IIX0o.oO(inflate, "inflate(...)");
        return new SportRecordDetailSpeedViewHolder(inflate);
    }
}
