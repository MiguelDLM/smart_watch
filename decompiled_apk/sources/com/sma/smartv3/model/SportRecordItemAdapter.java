package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sma.smartv3.co_fit.R;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class SportRecordItemAdapter extends RecyclerView.Adapter<SportRecordItemViewHolder> {

    @OOXIXo
    private final Context context;

    @OOXIXo
    private final List<SportRecordItemData> items;

    /* JADX WARN: Multi-variable type inference failed */
    public SportRecordItemAdapter(@OOXIXo List<? extends SportRecordItemData> items, @OOXIXo Context context) {
        IIX0o.x0xO0oo(items, "items");
        IIX0o.x0xO0oo(context, "context");
        this.items = items;
        this.context = context;
    }

    @OOXIXo
    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@OOXIXo SportRecordItemViewHolder holder, int i) {
        IIX0o.x0xO0oo(holder, "holder");
        SportRecordItemData sportRecordItemData = this.items.get(i);
        holder.getTv().setText(sportRecordItemData.getTv());
        holder.getIv().setImageResource(sportRecordItemData.getIv());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @OOXIXo
    public SportRecordItemViewHolder onCreateViewHolder(@OOXIXo ViewGroup parent, int i) {
        IIX0o.x0xO0oo(parent, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.item_sport_record_content, parent, false);
        IIX0o.oO(inflate, "inflate(...)");
        return new SportRecordItemViewHolder(inflate);
    }
}
