package com.sma.smartv3.ui.sport.course.model;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.biz.CourseManager;
import com.sma.smartv3.model.RecommendSearch;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nCourseViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CourseViewModel.kt\ncom/sma/smartv3/ui/sport/course/model/CourseViewModel\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,57:1\n50#2,3:58\n53#2:64\n55#2,2:66\n1549#3:61\n1620#3,2:62\n1622#3:65\n*S KotlinDebug\n*F\n+ 1 CourseViewModel.kt\ncom/sma/smartv3/ui/sport/course/model/CourseViewModel\n*L\n22#1:58,3\n22#1:64\n22#1:66,2\n22#1:61\n22#1:62,2\n22#1:65\n*E\n"})
/* loaded from: classes12.dex */
public final class CourseViewModel extends ViewModel {

    @OOXIXo
    private final MutableLiveData<ArrayList<RecommendSearch>> courseLiveData = new MutableLiveData<>();

    private final void getRecommendSearchListList() {
        CourseManager.f19940oIX0oI.Oo("INDEX", new oOoXoXO<RecommendSearch[], oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.model.CourseViewModel$getRecommendSearchListList$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(RecommendSearch[] recommendSearchArr) {
                invoke2(recommendSearchArr);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO RecommendSearch[] recommendSearchArr) {
                if (recommendSearchArr != null) {
                    CourseViewModel.this.getCourseLiveData().postValue((ArrayList) ArraysKt___ArraysKt.X0XOOO(recommendSearchArr));
                }
            }
        });
    }

    private final boolean getTime(List<RecommendSearch> list) {
        if (System.currentTimeMillis() - list.get(0).getOnCreateTime() <= 86400000) {
            return false;
        }
        return true;
    }

    @OOXIXo
    public final MutableLiveData<ArrayList<RecommendSearch>> getCourseLiveData() {
        return this.courseLiveData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void getData() {
        List ooXIXxIX2;
        try {
            JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.X0o0xo().getString(XoI0Ixx0.f24477xI0oxI00)).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), RecommendSearch.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        if (!ooXIXxIX2.isEmpty()) {
            if (getTime(ooXIXxIX2)) {
                getRecommendSearchListList();
                return;
            } else {
                this.courseLiveData.postValue((ArrayList) ooXIXxIX2);
                return;
            }
        }
        getRecommendSearchListList();
    }
}
