package com.sma.smartv3.ui.sport.course.item;

import OXOo.OOXIXo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bumptech.glide.Glide;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.CourseRecommendList;
import com.sma.smartv3.ui.sport.course.CourseDetailsActivity;
import com.sma.smartv3.util.UtilsKt;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nFitnessRecommendItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FitnessRecommendItem.kt\ncom/sma/smartv3/ui/sport/course/item/FitnessRecommendItem$addRecyclerAdapter$mAdapter$1\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,142:1\n87#2,7:143\n94#2,3:151\n70#2,7:154\n97#2:161\n1#3:150\n*S KotlinDebug\n*F\n+ 1 FitnessRecommendItem.kt\ncom/sma/smartv3/ui/sport/course/item/FitnessRecommendItem$addRecyclerAdapter$mAdapter$1\n*L\n105#1:143,7\n105#1:151,3\n105#1:154,7\n105#1:161\n105#1:150\n*E\n"})
/* loaded from: classes12.dex */
public final class FitnessRecommendItem$addRecyclerAdapter$mAdapter$1 extends CommonAdapter<CourseRecommendList> {
    final /* synthetic */ int $type;
    final /* synthetic */ FitnessRecommendItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessRecommendItem$addRecyclerAdapter$mAdapter$1(FitnessRecommendItem fitnessRecommendItem, int i, Context context, ArrayList<CourseRecommendList> arrayList) {
        super(context, R.layout.item_horizontal_course_recommend, arrayList);
        this.this$0 = fitnessRecommendItem;
        this.$type = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(FitnessRecommendItem$addRecyclerAdapter$mAdapter$1 this$0, CourseRecommendList item, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(item, "$item");
        Context context = ((CommonAdapter) this$0).mContext;
        IIX0o.x0XOIxOo(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        String string = ((CommonAdapter) this$0).mContext.getString(R.string.featured_courses);
        IIX0o.oO(string, "getString(...)");
        item.setCourseTitle(string);
        String id = item.getCourse().getId();
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", id);
        bundle.putInt("mArg1", 1);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", item);
        Intent intent = new Intent(activity, (Class<?>) CourseDetailsActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OOXIXo ViewHolder viewHolder, @OOXIXo final CourseRecommendList item, int i) {
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        IIX0o.x0xO0oo(item, "item");
        viewHolder.getView(R.id.course_recommend_layout_view).setBackground(this.this$0.setBackgroundResource(i, this.$type));
        Glide.with(((CommonAdapter) this).mContext).load(item.getCourse().getCoursePic1()).into((ImageView) viewHolder.getView(R.id.course_recommend_icon));
        viewHolder.setText(R.id.tv_course_class, item.getCourse().getCourseClass() + UtilsKt.oI0IIXIo(R.string.people_join));
        viewHolder.setText(R.id.item_special_course_name, item.getCourse().getCourseName());
        viewHolder.setText(R.id.item_special_course_intro, item.getCourse().getCourseDiff() + ((CommonAdapter) this).mContext.getString(R.string.d_minutes, Integer.valueOf(Integer.parseInt(item.getCourse().getCourseTime()))) + "  " + item.getCourse().getCourseHeat() + ((CommonAdapter) this).mContext.getString(R.string.kcal));
        viewHolder.setOnClickListener(R.id.course_recommend_layout, new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.item.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitnessRecommendItem$addRecyclerAdapter$mAdapter$1.convert$lambda$0(FitnessRecommendItem$addRecyclerAdapter$mAdapter$1.this, item, view);
            }
        });
    }
}
