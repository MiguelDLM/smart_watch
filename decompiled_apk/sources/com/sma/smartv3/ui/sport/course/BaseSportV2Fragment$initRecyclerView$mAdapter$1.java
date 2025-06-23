package com.sma.smartv3.ui.sport.course;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bumptech.glide.Glide;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.CourseList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBaseSportV2Fragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseSportV2Fragment.kt\ncom/sma/smartv3/ui/sport/course/BaseSportV2Fragment$initRecyclerView$mAdapter$1\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,219:1\n87#2,7:220\n94#2,3:228\n70#2,7:231\n97#2:238\n1#3:227\n*S KotlinDebug\n*F\n+ 1 BaseSportV2Fragment.kt\ncom/sma/smartv3/ui/sport/course/BaseSportV2Fragment$initRecyclerView$mAdapter$1\n*L\n208#1:220,7\n208#1:228,3\n208#1:231,7\n208#1:238\n208#1:227\n*E\n"})
/* loaded from: classes12.dex */
public final class BaseSportV2Fragment$initRecyclerView$mAdapter$1 extends CommonAdapter<CourseList> {
    final /* synthetic */ BaseSportV2Fragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSportV2Fragment$initRecyclerView$mAdapter$1(BaseSportV2Fragment baseSportV2Fragment, FragmentActivity fragmentActivity, List<CourseList> list) {
        super(fragmentActivity, R.layout.item_special_course, list);
        this.this$0 = baseSportV2Fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(BaseSportV2Fragment$initRecyclerView$mAdapter$1 this$0, CourseList item, View view) {
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
    public void convert(@OXOo.OOXIXo ViewHolder viewHolder, @OXOo.OOXIXo final CourseList item, int i) {
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        IIX0o.x0xO0oo(item, "item");
        if (i == 0) {
            viewHolder.getView(R.id.item_special_course_view).setVisibility(8);
        }
        if (item.getCoursePic2().length() > 0) {
            Glide.with(((CommonAdapter) this).mContext).load(item.getCoursePic2()).into((ImageView) viewHolder.getView(R.id.item_special_course_pic));
        }
        viewHolder.setText(R.id.item_special_course_name, item.getCourseName());
        viewHolder.setText(R.id.item_special_course_intro, item.getCourseDiff() + "  " + (Integer.parseInt(item.getCourseTime()) / 60) + this.this$0.getString(R.string.minute) + "  " + item.getCourseHeat() + this.this$0.getString(R.string.kcal));
        viewHolder.setOnClickListener(R.id.item_special_course_layout, new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.OOXIXo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSportV2Fragment$initRecyclerView$mAdapter$1.convert$lambda$0(BaseSportV2Fragment$initRecyclerView$mAdapter$1.this, item, view);
            }
        });
    }
}
