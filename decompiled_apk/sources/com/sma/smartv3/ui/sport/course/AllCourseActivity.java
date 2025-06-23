package com.sma.smartv3.ui.sport.course;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.biz.CourseManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.CourSelectByType;
import com.sma.smartv3.model.CourseList;
import com.sma.smartv3.model.CourseType;
import com.sma.smartv3.network.GetCourSelectByType;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nAllCourseActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllCourseActivity.kt\ncom/sma/smartv3/ui/sport/course/AllCourseActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n*L\n1#1,300:1\n1#2:301\n1#2:305\n69#3,3:302\n72#3,5:306\n*S KotlinDebug\n*F\n+ 1 AllCourseActivity.kt\ncom/sma/smartv3/ui/sport/course/AllCourseActivity\n*L\n255#1:305\n255#1:302,3\n255#1:306,5\n*E\n"})
/* loaded from: classes12.dex */
public final class AllCourseActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private String courseDiff;

    @OXOo.oOoXoXO
    private String coursePart;

    @OXOo.oOoXoXO
    private String courseSortType;

    @OXOo.oOoXoXO
    private String courseType;

    @OXOo.oOoXoXO
    private CommonAdapter<CourseType> mAdapter;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XX mListPop;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XX mListPop2;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XX mListPop3;

    @OXOo.OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.AllCourseActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) AllCourseActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mRecyclerViewType$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.sport.course.AllCourseActivity$mRecyclerViewType$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) AllCourseActivity.this.findViewById(R.id.all_course_list_type);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mRecyclerViewCourse$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.sport.course.AllCourseActivity$mRecyclerViewCourse$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) AllCourseActivity.this.findViewById(R.id.all_course_list_course);
        }
    });

    @OXOo.OOXIXo
    private ArrayList<CourSelectByType> mListPopData = new ArrayList<>();

    @OXOo.OOXIXo
    private ArrayList<CourSelectByType> mListCoursePartPopData = new ArrayList<>();

    @OXOo.OOXIXo
    private ArrayList<CourSelectByType> mListCourseSortTypeData = new ArrayList<>();

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final void getCourSelectByType(final String str) {
        CourseManager.f19940oIX0oI.xxIXOIIO(str, new Oox.oOoXoXO<CourSelectByType[], oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.AllCourseActivity$getCourSelectByType$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(CourSelectByType[] courSelectByTypeArr) {
                invoke2(courSelectByTypeArr);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO CourSelectByType[] courSelectByTypeArr) {
                ArrayList arrayList;
                ArrayList arrayList2;
                ArrayList arrayList3;
                if (courSelectByTypeArr != null) {
                    if (!(courSelectByTypeArr.length == 0)) {
                        List X0XOOO = ArraysKt___ArraysKt.X0XOOO(courSelectByTypeArr);
                        String str2 = str;
                        if (IIX0o.Oxx0IOOO(str2, GetCourSelectByType.COURSE_DIFF)) {
                            arrayList3 = this.mListPopData;
                            arrayList3.addAll(X0XOOO);
                            return;
                        } else if (IIX0o.Oxx0IOOO(str2, GetCourSelectByType.COURSE_PART)) {
                            arrayList2 = this.mListCoursePartPopData;
                            arrayList2.addAll(X0XOOO);
                            return;
                        } else {
                            arrayList = this.mListCourseSortTypeData;
                            arrayList.addAll(X0XOOO);
                            return;
                        }
                    }
                }
                ToastUtils.showLong(R.string.auto_retry_active_tip);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView getMRecyclerViewCourse() {
        return (RecyclerView) this.mRecyclerViewCourse$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView getMRecyclerViewType() {
        return (RecyclerView) this.mRecyclerViewType$delegate.getValue();
    }

    public final void addRecyclerCourseAdapter(@OXOo.OOXIXo RecyclerView mRecyclerView, @OXOo.OOXIXo List<CourseList> list) {
        IIX0o.x0xO0oo(mRecyclerView, "mRecyclerView");
        IIX0o.x0xO0oo(list, "list");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getMContext(), 1, false));
        mRecyclerView.setAdapter(new AllCourseActivity$addRecyclerCourseAdapter$mAdapter$1(list, getMContext()));
    }

    public final void addRecyclerTypeAdapter(@OXOo.OOXIXo RecyclerView mRecyclerView, @OXOo.OOXIXo List<CourseType> list) {
        IIX0o.x0xO0oo(mRecyclerView, "mRecyclerView");
        IIX0o.x0xO0oo(list, "list");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getMContext(), 1, false));
        AllCourseActivity$addRecyclerTypeAdapter$1 allCourseActivity$addRecyclerTypeAdapter$1 = new AllCourseActivity$addRecyclerTypeAdapter$1(list, new Ref.IntRef(), this, getMContext());
        mRecyclerView.setAdapter(allCourseActivity$addRecyclerTypeAdapter$1);
        this.mAdapter = allCourseActivity$addRecyclerTypeAdapter$1;
    }

    @OXOo.oOoXoXO
    public final String getCourseDiff() {
        return this.courseDiff;
    }

    @OXOo.oOoXoXO
    public final String getCoursePart() {
        return this.coursePart;
    }

    @OXOo.oOoXoXO
    public final String getCourseSortType() {
        return this.courseSortType;
    }

    @OXOo.oOoXoXO
    /* renamed from: getCourseType, reason: collision with other method in class */
    public final String m285getCourseType() {
        return this.courseType;
    }

    public final void getOnLineCourse(@OXOo.OOXIXo String dictValue, @OXOo.OOXIXo String diff, @OXOo.OOXIXo String heat) {
        IIX0o.x0xO0oo(dictValue, "dictValue");
        IIX0o.x0xO0oo(diff, "diff");
        IIX0o.x0xO0oo(heat, "heat");
    }

    public final void getOnLineCourseList() {
        CourseManager.f19940oIX0oI.oO(this.courseType, this.courseDiff, this.coursePart, this.courseSortType, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.AllCourseActivity$getOnLineCourseList$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z) {
                RecyclerView mRecyclerViewCourse;
                Collection ooXIXxIX2;
                if (z) {
                    AllCourseActivity allCourseActivity = AllCourseActivity.this;
                    mRecyclerViewCourse = allCourseActivity.getMRecyclerViewCourse();
                    IIX0o.oO(mRecyclerViewCourse, "access$getMRecyclerViewCourse(...)");
                    try {
                        JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.X0o0xo().getString(XoI0Ixx0.f24377O0)).getAsJsonArray();
                        IIX0o.ooOOo0oXI(asJsonArray);
                        ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
                        Iterator<JsonElement> it = asJsonArray.iterator();
                        while (it.hasNext()) {
                            ooXIXxIX2.add(new Gson().fromJson(it.next(), CourseList.class));
                        }
                    } catch (Exception unused) {
                        ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                    }
                    allCourseActivity.addRecyclerCourseAdapter(mRecyclerViewCourse, CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2));
                }
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        getCourseType();
        getCourSelectByType(GetCourSelectByType.COURSE_DIFF);
        getCourSelectByType(GetCourSelectByType.COURSE_PART);
        getCourSelectByType(GetCourSelectByType.COURSE_SORT_TYPE);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(getString(R.string.all_courses));
        getOnLineCourseList();
        getAbhTitleRight().setVisibility(8);
        getAbhTitleRight().setImageResource(R.drawable.icon_right_search);
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_all_course;
    }

    public final void onCurriculum(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (this.mListCourseSortTypeData.isEmpty()) {
            getCourSelectByType(GetCourSelectByType.COURSE_SORT_TYPE);
        } else {
            showListPoP(view, this.mListCourseSortTypeData, GetCourSelectByType.COURSE_SORT_TYPE);
        }
    }

    public final void onDifficulty(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (this.mListPopData.isEmpty()) {
            getCourSelectByType(GetCourSelectByType.COURSE_DIFF);
        } else {
            showListPoP(view, this.mListPopData, GetCourSelectByType.COURSE_DIFF);
        }
    }

    public final void onExercisePart(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (this.mListCoursePartPopData.isEmpty()) {
            getCourSelectByType(GetCourSelectByType.COURSE_PART);
        } else {
            showListPoP(view, this.mListCoursePartPopData, GetCourSelectByType.COURSE_PART);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        CommonAdapter<CourseType> commonAdapter = this.mAdapter;
        if (commonAdapter != null) {
            commonAdapter.notifyDataSetChanged();
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) CourseSearchActivity.class));
    }

    public final void setCourseDiff(@OXOo.oOoXoXO String str) {
        this.courseDiff = str;
    }

    public final void setCoursePart(@OXOo.oOoXoXO String str) {
        this.coursePart = str;
    }

    public final void setCourseSortType(@OXOo.oOoXoXO String str) {
        this.courseSortType = str;
    }

    public final void setCourseType(@OXOo.oOoXoXO String str) {
        this.courseType = str;
    }

    public final void showListPoP(@OXOo.OOXIXo View view, @OXOo.OOXIXo List<CourSelectByType> data, @OXOo.OOXIXo String type) {
        IIX0o.x0xO0oo(view, "view");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(type, "type");
        com.sma.smartv3.pop.XX xx2 = new com.sma.smartv3.pop.XX(getMContext());
        xx2.xxIXOIIO(new AllCourseActivity$showListPoP$1$1(data, type, this, getMContext()));
        this.mListPop = xx2;
        xx2.showAsDropDown(view);
    }

    private final void getCourseType() {
        CourseManager.x0XOIxOo(CourseManager.f19940oIX0oI, null, new Oox.oOoXoXO<CourseType[], oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.AllCourseActivity$getCourseType$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(CourseType[] courseTypeArr) {
                invoke2(courseTypeArr);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO CourseType[] courseTypeArr) {
                CourseType copy;
                RecyclerView mRecyclerViewType;
                if (courseTypeArr != null) {
                    if (!(courseTypeArr.length == 0)) {
                        List<CourseType> X0XOOO = ArraysKt___ArraysKt.X0XOOO(courseTypeArr);
                        CourseType courseType = X0XOOO.get(0);
                        String string = AllCourseActivity.this.getString(R.string.all_courses);
                        IIX0o.oO(string, "getString(...)");
                        copy = courseType.copy((r22 & 1) != 0 ? courseType.dictCode : null, (r22 & 2) != 0 ? courseType.dictSort : null, (r22 & 4) != 0 ? courseType.dictLabel : string, (r22 & 8) != 0 ? courseType.dictValue : null, (r22 & 16) != 0 ? courseType.dictType : null, (r22 & 32) != 0 ? courseType.f9default : null, (r22 & 64) != 0 ? courseType.status : null, (r22 & 128) != 0 ? courseType.createBy : null, (r22 & 256) != 0 ? courseType.createTime : null, (r22 & 512) != 0 ? courseType.remark : null);
                        X0XOOO.add(0, copy);
                        AllCourseActivity allCourseActivity = AllCourseActivity.this;
                        mRecyclerViewType = allCourseActivity.getMRecyclerViewType();
                        IIX0o.oO(mRecyclerViewType, "access$getMRecyclerViewType(...)");
                        allCourseActivity.addRecyclerTypeAdapter(mRecyclerViewType, X0XOOO);
                        return;
                    }
                }
                ToastUtils.showLong(R.string.auto_retry_active_tip);
            }
        }, 1, null);
    }
}
