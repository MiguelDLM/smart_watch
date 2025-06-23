package com.sma.smartv3.ui.ai.item;

import OXOo.OOXIXo;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.biz.AIManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.AIGridSpacingItemDecoration;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nAISearchTopItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AISearchTopItem.kt\ncom/sma/smartv3/ui/ai/item/AISearchTopItem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,104:1\n1#2:105\n*E\n"})
/* loaded from: classes12.dex */
public class AISearchTopItem extends BaseDslItem {
    public Context mContext;
    private RecyclerView mHotrv;

    @OOXIXo
    private List<String> mList;
    private TextView mRecordsCleartv;
    private RecyclerView mRecordsrv;
    private TextView mRecordstv;

    public AISearchTopItem(@OOXIXo List<String> mList) {
        IIX0o.x0xO0oo(mList, "mList");
        this.mList = mList;
    }

    public static /* synthetic */ void setRecyclerView$default(AISearchTopItem aISearchTopItem, RecyclerView recyclerView, int i, List list, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 3;
            }
            aISearchTopItem.setRecyclerView(recyclerView, i, list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRecyclerView");
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.search_func_records_tv);
        IIX0o.ooOOo0oXI(v);
        TextView textView = (TextView) v;
        this.mRecordstv = textView;
        TextView textView2 = null;
        if (textView == null) {
            IIX0o.XOxIOxOx("mRecordstv");
            textView = null;
        }
        Context context = textView.getContext();
        IIX0o.oO(context, "getContext(...)");
        setMContext(context);
        View v2 = itemHolder.v(R.id.search_func_records_rv);
        IIX0o.ooOOo0oXI(v2);
        this.mRecordsrv = (RecyclerView) v2;
        View v3 = itemHolder.v(R.id.search_func_hot_rv);
        IIX0o.ooOOo0oXI(v3);
        this.mHotrv = (RecyclerView) v3;
        View v4 = itemHolder.v(R.id.search_records_clear_tv);
        IIX0o.ooOOo0oXI(v4);
        TextView textView3 = (TextView) v4;
        this.mRecordsCleartv = textView3;
        if (textView3 == null) {
            IIX0o.XOxIOxOx("mRecordsCleartv");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: o0oxo0oI.X0o0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x0xO0oo.oIX0oI(x0xO0oo.f24623o0, "");
            }
        });
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

    @OOXIXo
    public final List<String> getMList() {
        return this.mList;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        RecyclerView recyclerView;
        String[] stringArray = getMContext().getResources().getStringArray(R.array.search_hot);
        IIX0o.oO(stringArray, "getStringArray(...)");
        List X0XOOO = ArraysKt___ArraysKt.X0XOOO(stringArray);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        int i = 0;
        TextView textView = null;
        if (productManager.xox().length() > 0) {
            setTitle(productManager.xox());
        } else {
            setTitle(AIManager.x0XOIxOo(AIManager.f19833oIX0oI, 0, 1, null));
        }
        RecyclerView recyclerView2 = this.mHotrv;
        if (recyclerView2 == null) {
            IIX0o.XOxIOxOx("mHotrv");
            recyclerView = null;
        } else {
            recyclerView = recyclerView2;
        }
        setRecyclerView$default(this, recyclerView, 0, X0XOOO, 2, null);
        TextView textView2 = this.mRecordstv;
        if (textView2 == null) {
            IIX0o.XOxIOxOx("mRecordstv");
            textView2 = null;
        }
        List<String> list = this.mList;
        if (list != null && !list.isEmpty()) {
            RecyclerView recyclerView3 = this.mRecordsrv;
            if (recyclerView3 == null) {
                IIX0o.XOxIOxOx("mRecordsrv");
                recyclerView3 = null;
            }
            recyclerView3.setVisibility(0);
            RecyclerView recyclerView4 = this.mRecordsrv;
            if (recyclerView4 == null) {
                IIX0o.XOxIOxOx("mRecordsrv");
                recyclerView4 = null;
            }
            setRecyclerView(recyclerView4, 3, this.mList);
            TextView textView3 = this.mRecordsCleartv;
            if (textView3 == null) {
                IIX0o.XOxIOxOx("mRecordsCleartv");
            } else {
                textView = textView3;
            }
            textView.setVisibility(0);
        } else {
            RecyclerView recyclerView5 = this.mRecordsrv;
            if (recyclerView5 == null) {
                IIX0o.XOxIOxOx("mRecordsrv");
                recyclerView5 = null;
            }
            i = 8;
            recyclerView5.setVisibility(8);
            TextView textView4 = this.mRecordsCleartv;
            if (textView4 == null) {
                IIX0o.XOxIOxOx("mRecordsCleartv");
            } else {
                textView = textView4;
            }
            textView.setVisibility(8);
        }
        textView2.setVisibility(i);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.ai_item_search_top;
    }

    public final void setMContext(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "<set-?>");
        this.mContext = context;
    }

    public final void setMList(@OOXIXo List<String> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mList = list;
    }

    public final void setRecyclerView(@OOXIXo RecyclerView mRecyclerView, int i, @OOXIXo List<String> list) {
        IIX0o.x0xO0oo(mRecyclerView, "mRecyclerView");
        IIX0o.x0xO0oo(list, "list");
        mRecyclerView.setLayoutManager(new GridLayoutManager(getMContext(), i));
        mRecyclerView.setAdapter(new AISearchTopItem$setRecyclerView$mAdapter$1(list, getMContext()));
        if (mRecyclerView.getItemDecorationCount() == 0) {
            mRecyclerView.addItemDecoration(new AIGridSpacingItemDecoration(i, SizeUtils.dp2px(15.0f)));
        }
    }

    @OOXIXo
    public final String setTitle(@OOXIXo String titleStr) {
        IIX0o.x0xO0oo(titleStr, "titleStr");
        return AIManager.f19833oIX0oI.XOxIOxOx(titleStr);
    }
}
