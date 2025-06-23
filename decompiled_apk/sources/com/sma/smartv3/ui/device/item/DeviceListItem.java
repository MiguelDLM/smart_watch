package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.co_fit.R;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nDeviceListItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceListItem.kt\ncom/sma/smartv3/ui/device/item/DeviceListItem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1#2:58\n*E\n"})
/* loaded from: classes12.dex */
public class DeviceListItem extends BaseDslItem {

    @oOoXoXO
    private Context context;

    @oOoXoXO
    private DslAdapter dslAdapter;
    public List<DslAdapterItem> items;

    @oOoXoXO
    private RecyclerView mRecyclerView;
    private int mTitle;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        this.context = itemHolder.getContext();
        TextView tv = itemHolder.tv(R.id.tv_title);
        if (tv != null) {
            if (this.mTitle != 0) {
                tv.setVisibility(0);
                tv.setText(this.mTitle);
            } else {
                tv.setVisibility(8);
            }
        }
        RecyclerView rv = itemHolder.rv(R.id.recycler_view);
        IIX0o.x0XOIxOo(rv, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.mRecyclerView = rv;
        if (rv != null) {
            rv.setItemViewCacheSize(100);
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        boolean z = true;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(this.context, 1, false));
        }
        for (DslAdapterItem dslAdapterItem : getItems()) {
            if (dslAdapterItem instanceof BaseDslItem) {
                ((BaseDslItem) dslAdapterItem).initView();
                if (!dslAdapterItem.getItemHidden()) {
                    z = false;
                }
            }
        }
        DslAdapter dslAdapter = new DslAdapter(getItems());
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(dslAdapter);
        }
        this.dslAdapter = dslAdapter;
        setItemHidden(z);
    }

    @OOXIXo
    public final List<DslAdapterItem> getItems() {
        List<DslAdapterItem> list = this.items;
        if (list != null) {
            return list;
        }
        IIX0o.XOxIOxOx("items");
        return null;
    }

    public final int getMTitle() {
        return this.mTitle;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_list_item;
    }

    public final void setItems(@OOXIXo List<DslAdapterItem> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.items = list;
    }

    public final void setMTitle(int i) {
        this.mTitle = i;
    }
}
