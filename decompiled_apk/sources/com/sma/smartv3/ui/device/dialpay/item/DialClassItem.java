package com.sma.smartv3.ui.device.dialpay.item;

import OXOo.OOXIXo;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.OnlineWatchFaceV2;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nDialClassItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DialClassItem.kt\ncom/sma/smartv3/ui/device/dialpay/item/DialClassItem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n1#2:67\n*E\n"})
/* loaded from: classes12.dex */
public final class DialClassItem extends BaseDslItem {

    @OOXIXo
    private final List<OnlineWatchFaceV2> categorys;
    public Context mContext;
    private RecyclerView mRecyclerView;

    public DialClassItem(@OOXIXo List<OnlineWatchFaceV2> categorys) {
        IIX0o.x0xO0oo(categorys, "categorys");
        this.categorys = categorys;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.my_class_recyclerView);
        IIX0o.ooOOo0oXI(v);
        RecyclerView recyclerView = (RecyclerView) v;
        this.mRecyclerView = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            IIX0o.XOxIOxOx("mRecyclerView");
            recyclerView = null;
        }
        Context context = recyclerView.getContext();
        IIX0o.oO(context, "getContext(...)");
        setMContext(context);
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            IIX0o.XOxIOxOx("mRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(getMContext(), 0, false));
        if (!this.categorys.isEmpty()) {
            DialClassItem$bindView$mAdapter$1 dialClassItem$bindView$mAdapter$1 = new DialClassItem$bindView$mAdapter$1(getMContext(), this.categorys);
            RecyclerView recyclerView4 = this.mRecyclerView;
            if (recyclerView4 == null) {
                IIX0o.XOxIOxOx("mRecyclerView");
            } else {
                recyclerView2 = recyclerView4;
            }
            recyclerView2.setAdapter(dialClassItem$bindView$mAdapter$1);
        }
    }

    @OOXIXo
    public final List<OnlineWatchFaceV2> getCategorys() {
        return this.categorys;
    }

    @OOXIXo
    public final Context getMContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        IIX0o.XOxIOxOx("mContext");
        return null;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.layout_online_watchface_class_head;
    }

    public final void setMContext(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "<set-?>");
        this.mContext = context;
    }
}
