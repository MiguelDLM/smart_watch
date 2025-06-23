package com.sma.smartv3.ui.sport.course.item;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.RecommendSearch;
import com.sma.smartv3.ui.sport.course.model.CourseViewModel;
import com.sma.smartv3.view.text.PFMedium;
import java.util.ArrayList;
import java.util.List;
import kotlin.IIXOooo;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XI0IXoo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nFitnessRecommendItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FitnessRecommendItem.kt\ncom/sma/smartv3/ui/sport/course/item/FitnessRecommendItem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,142:1\n1#2:143\n*E\n"})
/* loaded from: classes12.dex */
public class FitnessRecommendItem extends BaseDslItem {
    public Context mContext;
    private RecyclerView mRecyclerViewFirst;
    private RecyclerView mRecyclerViewSecond;
    private PFMedium tvTitle;
    private PFMedium tvTitle2;

    @OOXIXo
    private final CourseViewModel viewModel = (CourseViewModel) new ViewModelProvider.NewInstanceFactory().create(CourseViewModel.class);

    @OOXIXo
    private final List<Integer> mFirstColors = CollectionsKt__CollectionsKt.X00IoxXI(Integer.valueOf(Color.parseColor("#444444")), Integer.valueOf(Color.parseColor("#E9BC6A")), Integer.valueOf(Color.parseColor("#8C6EB2")));

    @OOXIXo
    private final List<Integer> mSecondColors = CollectionsKt__CollectionsKt.X00IoxXI(Integer.valueOf(Color.parseColor("#8C6EB2")), Integer.valueOf(Color.parseColor("#FF882B")), Integer.valueOf(Color.parseColor("#444444")));

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements Observer, XI0IXoo {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ oOoXoXO f23972XO;

        public oIX0oI(oOoXoXO function) {
            IIX0o.x0xO0oo(function, "function");
            this.f23972XO = function;
        }

        public final boolean equals(@OXOo.oOoXoXO Object obj) {
            if ((obj instanceof Observer) && (obj instanceof XI0IXoo)) {
                return IIX0o.Oxx0IOOO(getFunctionDelegate(), ((XI0IXoo) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.XI0IXoo
        @OOXIXo
        public final IIXOooo<?> getFunctionDelegate() {
            return this.f23972XO;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f23972XO.invoke(obj);
        }
    }

    public final void addRecyclerAdapter(@OOXIXo RecyclerView mRecyclerView, int i, @OOXIXo RecommendSearch recommendSearch, @OOXIXo PFMedium tvTitle) {
        IIX0o.x0xO0oo(mRecyclerView, "mRecyclerView");
        IIX0o.x0xO0oo(recommendSearch, "recommendSearch");
        IIX0o.x0xO0oo(tvTitle, "tvTitle");
        tvTitle.setText(recommendSearch.getRecommendTitle());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getMContext(), 0, false));
        mRecyclerView.setAdapter(new FitnessRecommendItem$addRecyclerAdapter$mAdapter$1(this, i, getMContext(), recommendSearch.getCourseRecommendList()));
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo final DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        TextView tv = itemHolder.tv(R.id.tv_title);
        IIX0o.x0XOIxOo(tv, "null cannot be cast to non-null type com.sma.smartv3.view.text.PFMedium");
        this.tvTitle = (PFMedium) tv;
        TextView tv2 = itemHolder.tv(R.id.tv_title2);
        IIX0o.x0XOIxOo(tv2, "null cannot be cast to non-null type com.sma.smartv3.view.text.PFMedium");
        this.tvTitle2 = (PFMedium) tv2;
        View v = itemHolder.v(R.id.item_recommend_recycler_first);
        IIX0o.ooOOo0oXI(v);
        this.mRecyclerViewFirst = (RecyclerView) v;
        View v2 = itemHolder.v(R.id.item_recommend_recycler_second);
        IIX0o.ooOOo0oXI(v2);
        this.mRecyclerViewSecond = (RecyclerView) v2;
        RecyclerView recyclerView = this.mRecyclerViewFirst;
        if (recyclerView == null) {
            IIX0o.XOxIOxOx("mRecyclerViewFirst");
            recyclerView = null;
        }
        Context context = recyclerView.getContext();
        IIX0o.oO(context, "getContext(...)");
        setMContext(context);
        this.viewModel.getData();
        this.viewModel.getCourseLiveData().observe(this, new oIX0oI(new oOoXoXO<ArrayList<RecommendSearch>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.item.FitnessRecommendItem$bindView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(ArrayList<RecommendSearch> arrayList) {
                invoke2(arrayList);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<RecommendSearch> arrayList) {
                PFMedium pFMedium;
                PFMedium pFMedium2;
                RecyclerView recyclerView2;
                PFMedium pFMedium3;
                RecyclerView recyclerView3;
                PFMedium pFMedium4;
                if (arrayList != null) {
                    PFMedium pFMedium5 = null;
                    if (arrayList.size() <= 0) {
                        pFMedium = FitnessRecommendItem.this.tvTitle;
                        if (pFMedium == null) {
                            IIX0o.XOxIOxOx("tvTitle");
                            pFMedium = null;
                        }
                        pFMedium.setVisibility(8);
                        itemHolder.itemView.setVisibility(8);
                    } else {
                        FitnessRecommendItem fitnessRecommendItem = FitnessRecommendItem.this;
                        recyclerView3 = fitnessRecommendItem.mRecyclerViewFirst;
                        if (recyclerView3 == null) {
                            IIX0o.XOxIOxOx("mRecyclerViewFirst");
                            recyclerView3 = null;
                        }
                        RecommendSearch recommendSearch = arrayList.get(0);
                        IIX0o.oO(recommendSearch, "get(...)");
                        RecommendSearch recommendSearch2 = recommendSearch;
                        pFMedium4 = FitnessRecommendItem.this.tvTitle;
                        if (pFMedium4 == null) {
                            IIX0o.XOxIOxOx("tvTitle");
                            pFMedium4 = null;
                        }
                        fitnessRecommendItem.addRecyclerAdapter(recyclerView3, 0, recommendSearch2, pFMedium4);
                    }
                    if (arrayList.size() <= 1) {
                        pFMedium2 = FitnessRecommendItem.this.tvTitle2;
                        if (pFMedium2 == null) {
                            IIX0o.XOxIOxOx("tvTitle2");
                        } else {
                            pFMedium5 = pFMedium2;
                        }
                        pFMedium5.setVisibility(8);
                        return;
                    }
                    FitnessRecommendItem fitnessRecommendItem2 = FitnessRecommendItem.this;
                    recyclerView2 = fitnessRecommendItem2.mRecyclerViewSecond;
                    if (recyclerView2 == null) {
                        IIX0o.XOxIOxOx("mRecyclerViewSecond");
                        recyclerView2 = null;
                    }
                    RecommendSearch recommendSearch3 = arrayList.get(1);
                    IIX0o.oO(recommendSearch3, "get(...)");
                    RecommendSearch recommendSearch4 = recommendSearch3;
                    pFMedium3 = FitnessRecommendItem.this.tvTitle2;
                    if (pFMedium3 == null) {
                        IIX0o.XOxIOxOx("tvTitle2");
                    } else {
                        pFMedium5 = pFMedium3;
                    }
                    fitnessRecommendItem2.addRecyclerAdapter(recyclerView2, 1, recommendSearch4, pFMedium5);
                }
            }
        }));
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
    public final List<Integer> getMFirstColors() {
        return this.mFirstColors;
    }

    @OOXIXo
    public final List<Integer> getMSecondColors() {
        return this.mSecondColors;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.fitness_item_recommend;
    }

    @OOXIXo
    public final GradientDrawable setBackgroundResource(int i, int i2) {
        List<Integer> list;
        if (i2 == 0) {
            list = this.mFirstColors;
        } else {
            list = this.mSecondColors;
        }
        int intValue = list.get(i % list.size()).intValue();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColors(CollectionsKt___CollectionsKt.o0Oox0xox(CollectionsKt__CollectionsKt.X00IoxXI(Integer.valueOf(intValue), 0)));
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setGradientRadius(SizeUtils.dp2px(10.0f));
        return gradientDrawable;
    }

    public final void setMContext(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "<set-?>");
        this.mContext = context;
    }
}
