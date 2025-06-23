package com.sma.smartv3.ui.status.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.huawei.openalliance.ad.constant.bn;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.TodayData;
import com.sma.smartv3.ui.status.TodayHealthyDataActivity;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class TodayDataItem$initView$mAdapter$1 extends CommonAdapter<TodayData> {
    final /* synthetic */ List<TodayData> $list;
    final /* synthetic */ TodayDataItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TodayDataItem$initView$mAdapter$1(List<TodayData> list, TodayDataItem todayDataItem, Context context) {
        super(context, R.layout.item_today_healthy_data, list);
        this.$list = list;
        this.this$0 = todayDataItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$1$lambda$0(TodayDataItem this$0, View view) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        IIX0o.x0xO0oo(this$0, "this$0");
        if (com.sma.smartv3.ui.status.x0XOIxOo.f24154oIX0oI.oIX0oI()) {
            recyclerView = this$0.mRecyclerView;
            RecyclerView recyclerView3 = null;
            if (recyclerView == null) {
                IIX0o.XOxIOxOx("mRecyclerView");
                recyclerView = null;
            }
            Context context = recyclerView.getContext();
            recyclerView2 = this$0.mRecyclerView;
            if (recyclerView2 == null) {
                IIX0o.XOxIOxOx("mRecyclerView");
            } else {
                recyclerView3 = recyclerView2;
            }
            context.startActivity(new Intent(recyclerView3.getContext(), (Class<?>) TodayHealthyDataActivity.class));
        }
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OXOo.OOXIXo ViewHolder viewHolder, @OXOo.OOXIXo TodayData item, int i) {
        int parseColor;
        Context context;
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        IIX0o.x0xO0oo(item, "item");
        viewHolder.getView(R.id.today_healthy_data_top_view).setVisibility(i == 0 ? 4 : 0);
        viewHolder.getView(R.id.today_healthy_data_btn_view).setVisibility(i != this.$list.size() - 1 ? 0 : 4);
        TextView textView = (TextView) viewHolder.getView(R.id.item_today_healthy_data_time);
        TextView textView2 = (TextView) viewHolder.getView(R.id.item_today_healthy_data_title);
        TextView textView3 = (TextView) viewHolder.getView(R.id.item_today_healthy_data_value);
        TextView textView4 = (TextView) viewHolder.getView(R.id.item_today_healthy_data_state);
        Context context2 = null;
        textView.setText(com.sma.smartv3.util.xoIox.O0Xx(false, 1, null).format(Long.valueOf(item.getTime())));
        textView2.setText(item.getTitle());
        textView3.setText(item.getValue());
        textView4.setText(item.getState());
        int stateColor = item.getStateColor();
        if (stateColor == 0) {
            parseColor = Color.parseColor("#FE6D00");
        } else if (stateColor != 1) {
            parseColor = stateColor != 2 ? SupportMenu.CATEGORY_MASK : -16711936;
        } else {
            context = this.this$0.context;
            if (context == null) {
                IIX0o.XOxIOxOx(bn.f.o);
            } else {
                context2 = context;
            }
            parseColor = context2.getColor(R.color.colorAccent);
        }
        textView4.setTextColor(parseColor);
        View view = viewHolder.getView(R.id.item_today_healthy_data_layout);
        final TodayDataItem todayDataItem = this.this$0;
        view.setBackgroundTintList(ColorStateList.valueOf(oIxOXo.oxoX.I0Io(view.getContext(), R.color.today_healthy_item_bg)));
        view.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.item.x0XOIxOo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TodayDataItem$initView$mAdapter$1.convert$lambda$1$lambda$0(TodayDataItem.this, view2);
            }
        });
    }
}
