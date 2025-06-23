package com.sma.smartv3.ui.sport.course;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment;
import com.sma.smartv3.biz.CourseManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.CourseList;
import com.sma.smartv3.ui.sport.course.item.FitnessRecommendItem;
import com.sma.smartv3.ui.sport.course.item.FitnessRecordItem;
import com.sma.smartv3.ui.sport.course.item.FitnessSpecialItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class CourseFragment extends BaseDSLRecyclerFragment {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final int ONE_DAY_TIME = 86400000;

    @OXOo.OOXIXo
    private List<CourseList> mCourseList = new ArrayList();
    public FitnessSpecialItem mFitnessSpecialItem;

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getTime(List<CourseList> list) {
        if (System.currentTimeMillis() - list.get(0).getOnSaveTime() <= 86400000) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadData(List<CourseList> list) {
        if (list != null) {
            this.mCourseList.addAll(list);
            getMFitnessSpecialItem().setData(this.mCourseList);
            com.sma.smartv3.util.x0xO0oo.II0xO0("刷新页面", null, 2, null);
        }
        getDslAdapter().notifyItemChanged(getDslAdapter().getItemCount() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRefPost() {
        CourseManager.II0XooXoX(CourseManager.f19940oIX0oI, null, new Oox.oOoXoXO<CourseList[], oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseFragment$onRefPost$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(CourseList[] courseListArr) {
                invoke2(courseListArr);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO CourseList[] courseListArr) {
                CourseFragment.this.onLoadData(courseListArr != null ? ArraysKt___ArraysKt.X0XOOO(courseListArr) : null);
            }
        }, 1, null);
    }

    private final void showData() {
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseFragment$showData$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo final DslAdapter renderAdapter) {
                IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                renderAdapter.clearAllItems();
                DslAdapter.setAdapterStatus$default(renderAdapter, 2, null, 2, null);
                DslViewHolder dslViewHolder = CourseFragment.this.getDslViewHolder();
                final CourseFragment courseFragment = CourseFragment.this;
                dslViewHolder.postDelay(100L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseFragment$showData$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                        invoke2();
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DslAdapterExKt.IXxxXO(DslAdapter.this, new FitnessRecordItem(), null, 2, null);
                        DslAdapterExKt.IXxxXO(DslAdapter.this, new FitnessRecommendItem(), null, 2, null);
                        DslAdapterExKt.IXxxXO(DslAdapter.this, courseFragment.getMFitnessSpecialItem(), null, 2, null);
                        DslAdapter.render$default(DslAdapter.this, false, null, new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseFragment.showData.1.1.1
                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                invoke2(dslAdapter);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo DslAdapter render) {
                                IIX0o.x0xO0oo(render, "$this$render");
                                DslAdapter.setAdapterStatus$default(render, 0, null, 2, null);
                            }
                        }, 3, null);
                    }
                });
            }
        });
    }

    @OXOo.OOXIXo
    public final FitnessSpecialItem getMFitnessSpecialItem() {
        FitnessSpecialItem fitnessSpecialItem = this.mFitnessSpecialItem;
        if (fitnessSpecialItem != null) {
            return fitnessSpecialItem;
        }
        IIX0o.XOxIOxOx("mFitnessSpecialItem");
        return null;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        setMFitnessSpecialItem(new FitnessSpecialItem(this.mCourseList));
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        kotlinx.coroutines.xoIox.XO(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CourseFragment$initView$1(this, null), 3, null);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.course_fragment_rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getActivity()));
        showData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getDslAdapter().notifyItemChanged(getDslAdapter().getItemCount() - 2);
        getDslAdapter().notifyItemChanged(getDslAdapter().getItemCount() - 1);
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int refreshLayoutId() {
        return 0;
    }

    public final void setMFitnessSpecialItem(@OXOo.OOXIXo FitnessSpecialItem fitnessSpecialItem) {
        IIX0o.x0xO0oo(fitnessSpecialItem, "<set-?>");
        this.mFitnessSpecialItem = fitnessSpecialItem;
    }
}
