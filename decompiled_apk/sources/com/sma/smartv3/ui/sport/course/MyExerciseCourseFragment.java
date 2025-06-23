package com.sma.smartv3.ui.sport.course;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes12.dex */
public final class MyExerciseCourseFragment extends MyHaveCourseFragment {
    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getActivity()));
        showData(CollectionsKt__CollectionsKt.Oxx0xo("111", "222", "222", "333"));
    }
}
