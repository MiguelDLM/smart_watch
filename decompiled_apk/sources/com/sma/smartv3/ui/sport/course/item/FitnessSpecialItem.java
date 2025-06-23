package com.sma.smartv3.ui.sport.course.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.CourseList;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nFitnessSpecialItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FitnessSpecialItem.kt\ncom/sma/smartv3/ui/sport/course/item/FitnessSpecialItem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,89:1\n1#2:90\n*E\n"})
/* loaded from: classes12.dex */
public class FitnessSpecialItem extends BaseDslItem {

    @oOoXoXO
    private CommonAdapter<CourseList> mAdapter;
    public Context mContext;

    @OOXIXo
    private List<CourseList> mListData;
    private RecyclerView mRecyclerView;

    public FitnessSpecialItem(@oOoXoXO List<CourseList> list) {
        if (list != null && list.isEmpty()) {
            this.mListData = new ArrayList();
        } else {
            IIX0o.ooOOo0oXI(list);
            this.mListData = list;
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.fitness_item_special_recycler);
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
        recyclerView3.setLayoutManager(new LinearLayoutManager(getMContext()));
        FitnessSpecialItem$bindView$1 fitnessSpecialItem$bindView$1 = new FitnessSpecialItem$bindView$1(getMContext(), this.mListData);
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            IIX0o.XOxIOxOx("mRecyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.setAdapter(fitnessSpecialItem$bindView$1);
        this.mAdapter = fitnessSpecialItem$bindView$1;
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
    public final List<CourseList> getMListData() {
        return this.mListData;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.fitness_item_special;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setData(@OOXIXo List<CourseList> list) {
        IIX0o.x0xO0oo(list, "list");
        this.mListData = list;
        CommonAdapter<CourseList> commonAdapter = this.mAdapter;
        if (commonAdapter != null) {
            commonAdapter.notifyDataSetChanged();
        }
    }

    public final void setMContext(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "<set-?>");
        this.mContext = context;
    }

    public final void setMListData(@OOXIXo List<CourseList> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mListData = list;
    }
}
