package com.sma.smartv3.ui.status.item;

import android.content.res.Resources;
import android.graphics.Color;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.TodayData;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public class HeathReportsBaseItem extends BaseDslItem {

    @OXOo.OOXIXo
    private final TodayData item;

    @OXOo.oOoXoXO
    private TextView tvState;

    @OXOo.oOoXoXO
    private TextView tvTitle;

    @OXOo.oOoXoXO
    private TextView tvValue;

    public HeathReportsBaseItem(@OXOo.OOXIXo TodayData item) {
        IIX0o.x0xO0oo(item, "item");
        this.item = item;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        this.tvTitle = (TextView) itemHolder.view(R.id.tv_top_title);
        this.tvValue = (TextView) itemHolder.view(R.id.tv_value);
        this.tvState = (TextView) itemHolder.view(R.id.tv_state_view);
    }

    @OXOo.OOXIXo
    public final TodayData getItem() {
        return this.item;
    }

    @OXOo.oOoXoXO
    public final TextView getTvState() {
        return this.tvState;
    }

    @OXOo.oOoXoXO
    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    @OXOo.oOoXoXO
    public final TextView getTvValue() {
        return this.tvValue;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        int parseColor;
        TextView textView = this.tvTitle;
        if (textView != null) {
            textView.setText(this.item.getTitle());
        }
        TextView textView2 = this.tvValue;
        if (textView2 != null) {
            textView2.setText(this.item.getValue());
        }
        TextView textView3 = this.tvState;
        if (textView3 != null) {
            textView3.setText(this.item.getState());
        }
        TextView textView4 = this.tvState;
        if (textView4 != null) {
            int stateColor = this.item.getStateColor();
            if (stateColor != 0) {
                if (stateColor != 1) {
                    if (stateColor != 2) {
                        parseColor = SupportMenu.CATEGORY_MASK;
                    } else {
                        parseColor = -16711936;
                    }
                } else {
                    TextView textView5 = this.tvState;
                    IIX0o.ooOOo0oXI(textView5);
                    Resources resources = textView5.getResources();
                    IIX0o.ooOOo0oXI(resources);
                    parseColor = resources.getColor(R.color.colorAccent);
                }
            } else {
                parseColor = Color.parseColor("#FE6D00");
            }
            textView4.setTextColor(parseColor);
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.heath_reports_item;
    }

    public final void setTvState(@OXOo.oOoXoXO TextView textView) {
        this.tvState = textView;
    }

    public final void setTvTitle(@OXOo.oOoXoXO TextView textView) {
        this.tvTitle = textView;
    }

    public final void setTvValue(@OXOo.oOoXoXO TextView textView) {
        this.tvValue = textView;
    }
}
