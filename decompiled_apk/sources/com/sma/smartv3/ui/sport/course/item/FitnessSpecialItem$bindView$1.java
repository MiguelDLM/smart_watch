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
import com.sma.smartv3.model.CourseList;
import com.sma.smartv3.ui.sport.course.CourseDetailsActivity;
import com.sma.smartv3.util.UtilsKt;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nFitnessSpecialItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FitnessSpecialItem.kt\ncom/sma/smartv3/ui/sport/course/item/FitnessSpecialItem$bindView$1\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,89:1\n87#2,7:90\n94#2,3:98\n70#2,7:101\n97#2:108\n1#3:97\n*S KotlinDebug\n*F\n+ 1 FitnessSpecialItem.kt\ncom/sma/smartv3/ui/sport/course/item/FitnessSpecialItem$bindView$1\n*L\n76#1:90,7\n76#1:98,3\n76#1:101,7\n76#1:108\n76#1:97\n*E\n"})
/* loaded from: classes12.dex */
public final class FitnessSpecialItem$bindView$1 extends CommonAdapter<CourseList> {
    public FitnessSpecialItem$bindView$1(Context context, List<CourseList> list) {
        super(context, R.layout.item_special_course, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(FitnessSpecialItem$bindView$1 this$0, CourseList item, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(item, "$item");
        Context context = ((CommonAdapter) this$0).mContext;
        IIX0o.x0XOIxOo(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        String id = item.getId();
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", id);
        bundle.putInt("mArg1", 0);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", item);
        Intent intent = new Intent(activity, (Class<?>) CourseDetailsActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OOXIXo ViewHolder viewHolder, @OOXIXo final CourseList item, int i) {
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        IIX0o.x0xO0oo(item, "item");
        if (i == 0) {
            viewHolder.getView(R.id.item_special_course_view).setVisibility(8);
        }
        Glide.with(((CommonAdapter) this).mContext).load(item.getCoursePic2()).into((ImageView) viewHolder.getView(R.id.item_special_course_pic));
        viewHolder.setText(R.id.item_special_course_name, item.getCourseName());
        viewHolder.setText(R.id.tv_course_class, item.getCourseClass() + UtilsKt.oI0IIXIo(R.string.people_join));
        viewHolder.setText(R.id.item_special_course_intro, item.getCourseDiff() + ((CommonAdapter) this).mContext.getString(R.string.d_minutes, Integer.valueOf(Integer.parseInt(item.getCourseTime()))) + "  " + item.getCourseHeat() + ((CommonAdapter) this).mContext.getString(R.string.kcal));
        viewHolder.setOnClickListener(R.id.item_special_course_layout, new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.item.XO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitnessSpecialItem$bindView$1.convert$lambda$0(FitnessSpecialItem$bindView$1.this, item, view);
            }
        });
    }
}
