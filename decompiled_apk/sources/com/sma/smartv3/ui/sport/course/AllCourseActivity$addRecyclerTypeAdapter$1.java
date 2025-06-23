package com.sma.smartv3.ui.sport.course;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.CourseList;
import com.sma.smartv3.model.CourseType;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nAllCourseActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllCourseActivity.kt\ncom/sma/smartv3/ui/sport/course/AllCourseActivity$addRecyclerTypeAdapter$1\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,300:1\n50#2,3:301\n53#2:307\n55#2,2:309\n1549#3:304\n1620#3,2:305\n1622#3:308\n*S KotlinDebug\n*F\n+ 1 AllCourseActivity.kt\ncom/sma/smartv3/ui/sport/course/AllCourseActivity$addRecyclerTypeAdapter$1\n*L\n144#1:301,3\n144#1:307\n144#1:309,2\n144#1:304\n144#1:305,2\n144#1:308\n*E\n"})
/* loaded from: classes12.dex */
public final class AllCourseActivity$addRecyclerTypeAdapter$1 extends CommonAdapter<CourseType> {
    final /* synthetic */ Ref.IntRef $curPosition;
    final /* synthetic */ AllCourseActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AllCourseActivity$addRecyclerTypeAdapter$1(List<CourseType> list, Ref.IntRef intRef, AllCourseActivity allCourseActivity, Activity activity) {
        super(activity, R.layout.item_all_course_type, list);
        this.$curPosition = intRef;
        this.this$0 = allCourseActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(Ref.IntRef curPosition, int i, AllCourseActivity this$0, CourseType item, AllCourseActivity$addRecyclerTypeAdapter$1 this$1, View view) {
        RecyclerView mRecyclerViewCourse;
        Collection ooXIXxIX2;
        IIX0o.x0xO0oo(curPosition, "$curPosition");
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(item, "$item");
        IIX0o.x0xO0oo(this$1, "this$1");
        curPosition.element = i;
        this$0.setCourseType(item.getDictValue());
        this$0.getOnLineCourseList();
        this$1.notifyDataSetChanged();
        mRecyclerViewCourse = this$0.getMRecyclerViewCourse();
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
        this$0.addRecyclerCourseAdapter(mRecyclerViewCourse, CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2));
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OXOo.OOXIXo ViewHolder viewHolder, @OXOo.OOXIXo final CourseType item, final int i) {
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        IIX0o.x0xO0oo(item, "item");
        TextView textView = (TextView) viewHolder.getView(R.id.course_type_tv);
        View view = viewHolder.getView(R.id.course_type_view);
        textView.setText(item.getDictLabel());
        if (this.$curPosition.element == i) {
            textView.setTextColor(((CommonAdapter) this).mContext.getResources().getColor(R.color.black));
            view.setVisibility(0);
            viewHolder.itemView.setBackgroundResource(R.drawable.shape_course_tab_selected_bg);
        } else {
            view.setVisibility(8);
            textView.setTextColor(((CommonAdapter) this).mContext.getResources().getColor(R.color.line_color));
            viewHolder.itemView.setBackground(null);
        }
        final Ref.IntRef intRef = this.$curPosition;
        final AllCourseActivity allCourseActivity = this.this$0;
        viewHolder.setOnClickListener(R.id.course_type_tv, new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AllCourseActivity$addRecyclerTypeAdapter$1.convert$lambda$0(Ref.IntRef.this, i, allCourseActivity, item, this, view2);
            }
        });
    }
}
