package com.sma.smartv3.ui.sport.course;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.util.Xo0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nMyCollectCourseFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyCollectCourseFragment.kt\ncom/sma/smartv3/ui/sport/course/MyCollectCourseFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,30:1\n19#2:31\n15#2:32\n*S KotlinDebug\n*F\n+ 1 MyCollectCourseFragment.kt\ncom/sma/smartv3/ui/sport/course/MyCollectCourseFragment\n*L\n16#1:31\n16#1:32\n*E\n"})
/* loaded from: classes12.dex */
public final class MyCollectCourseFragment extends MyHaveCourseFragment {
    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getActivity()));
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        showData(CollectionsKt__CollectionsKt.Oxx0xo("111", "222"));
    }
}
