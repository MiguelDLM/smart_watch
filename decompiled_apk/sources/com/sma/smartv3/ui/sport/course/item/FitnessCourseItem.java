package com.sma.smartv3.ui.sport.course.item;

import OXOo.OOXIXo;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.sport.course.AllCourseActivity;
import com.sma.smartv3.ui.sport.course.MyCourseActivity;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nFitnessCourseItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FitnessCourseItem.kt\ncom/sma/smartv3/ui/sport/course/item/FitnessCourseItem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,69:1\n1#2:70\n*E\n"})
/* loaded from: classes12.dex */
public class FitnessCourseItem extends BaseDslItem {
    public Context mContext;
    private RecyclerView mRecyclerView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$1(FitnessCourseItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMContext().startActivity(new Intent(this$0.getMContext(), (Class<?>) MyCourseActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$2(FitnessCourseItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMContext().startActivity(new Intent(this$0.getMContext(), (Class<?>) AllCourseActivity.class));
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.my_course_recyclerView);
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
        final Context mContext = getMContext();
        final ArrayList Oxx0xo2 = CollectionsKt__CollectionsKt.Oxx0xo("111", "222", "333", "444");
        CommonAdapter<String> commonAdapter = new CommonAdapter<String>(mContext, Oxx0xo2) { // from class: com.sma.smartv3.ui.sport.course.item.FitnessCourseItem$bindView$mAdapter$1
            @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
            public void convert(@OOXIXo ViewHolder viewHolder, @OOXIXo String item, int i) {
                IIX0o.x0xO0oo(viewHolder, "viewHolder");
                IIX0o.x0xO0oo(item, "item");
            }
        };
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            IIX0o.XOxIOxOx("mRecyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.setAdapter(commonAdapter);
        itemHolder.click(R.id.go_to_my_course, new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.item.oIX0oI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitnessCourseItem.bindView$lambda$1(FitnessCourseItem.this, view);
            }
        });
        itemHolder.click(R.id.fitness_item_all_course, new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.item.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitnessCourseItem.bindView$lambda$2(FitnessCourseItem.this, view);
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

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.fitness_item_course;
    }

    public final void setMContext(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "<set-?>");
        this.mContext = context;
    }
}
