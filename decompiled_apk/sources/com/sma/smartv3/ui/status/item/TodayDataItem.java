package com.sma.smartv3.ui.status.item;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.huawei.openalliance.ad.constant.bn;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.TodayHealthyDataKt;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nTodayDataItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TodayDataItem.kt\ncom/sma/smartv3/ui/status/item/TodayDataItem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,81:1\n1#2:82\n*E\n"})
/* loaded from: classes12.dex */
public class TodayDataItem extends BaseDslItem {
    private Context context;
    private RecyclerView mRecyclerView;
    private View roomView;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.status_item_today_health_data);
        IIX0o.ooOOo0oXI(v);
        this.mRecyclerView = (RecyclerView) v;
        View v2 = itemHolder.v(R.id.today_health_title_layout);
        IIX0o.ooOOo0oXI(v2);
        this.roomView = v2;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            IIX0o.XOxIOxOx("mRecyclerView");
            recyclerView = null;
        }
        Context context = recyclerView.getContext();
        IIX0o.oO(context, "getContext(...)");
        this.context = context;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            IIX0o.XOxIOxOx("mRecyclerView");
            recyclerView = null;
        }
        Context context = this.context;
        if (context == null) {
            IIX0o.XOxIOxOx(bn.f.o);
            context = null;
        }
        boolean z = true;
        int i = 0;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        List itemHealthyData$default = TodayHealthyDataKt.getItemHealthyData$default(false, new Oox.oOoXoXO<Integer, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.item.TodayDataItem$initView$list$1
            public final void invoke(int i2) {
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num) {
                invoke(num.intValue());
                return oXIO0o0XI.f29392oIX0oI;
            }
        }, 1, null);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("TodayDataItem list = " + itemHealthyData$default.size());
        if (itemHealthyData$default.size() != 0) {
            z = false;
        }
        setItemHidden(z);
        View view = this.roomView;
        if (view == null) {
            IIX0o.XOxIOxOx("roomView");
            view = null;
        }
        if (itemHealthyData$default.size() == 0) {
            i = 8;
        }
        view.setVisibility(i);
        Context context2 = this.context;
        if (context2 == null) {
            IIX0o.XOxIOxOx(bn.f.o);
            context2 = null;
        }
        TodayDataItem$initView$mAdapter$1 todayDataItem$initView$mAdapter$1 = new TodayDataItem$initView$mAdapter$1(itemHealthyData$default, this, context2);
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            IIX0o.XOxIOxOx("mRecyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setAdapter(todayDataItem$initView$mAdapter$1);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.status_item_today_health_data;
    }
}
