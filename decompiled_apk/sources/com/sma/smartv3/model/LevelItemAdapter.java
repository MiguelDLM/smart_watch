package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class LevelItemAdapter extends RecyclerView.Adapter<LevelItemViewHolder> {

    @OOXIXo
    private final Context context;

    @OOXIXo
    private final int[] gridViewImgs;
    private final int level;

    @OOXIXo
    private final String[] levelRangeText;

    public LevelItemAdapter(int i, @OOXIXo String[] levelRangeText, @OOXIXo int[] gridViewImgs, @OOXIXo Context context) {
        IIX0o.x0xO0oo(levelRangeText, "levelRangeText");
        IIX0o.x0xO0oo(gridViewImgs, "gridViewImgs");
        IIX0o.x0xO0oo(context, "context");
        this.level = i;
        this.levelRangeText = levelRangeText;
        this.gridViewImgs = gridViewImgs;
        this.context = context;
    }

    @OOXIXo
    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.levelRangeText.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@OOXIXo LevelItemViewHolder holder, int i) {
        IIX0o.x0xO0oo(holder, "holder");
        holder.getTv().setText(this.levelRangeText[i]);
        holder.getIv().setImageResource(this.gridViewImgs[i]);
        holder.getLlLevelPanel().setBackground(null);
        if (i == this.level) {
            holder.getLlLevelPanel().setBackgroundColor(Color.parseColor("#3C8AF188"));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @OOXIXo
    public LevelItemViewHolder onCreateViewHolder(@OOXIXo ViewGroup parent, int i) {
        IIX0o.x0xO0oo(parent, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.item_weight_report_level, parent, false);
        IIX0o.oO(inflate, "inflate(...)");
        return new LevelItemViewHolder(inflate);
    }
}
