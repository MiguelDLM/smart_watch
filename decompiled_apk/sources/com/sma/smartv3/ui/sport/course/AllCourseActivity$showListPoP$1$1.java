package com.sma.smartv3.ui.sport.course;

import android.app.Activity;
import android.view.View;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.CourSelectByType;
import com.sma.smartv3.network.GetCourSelectByType;
import com.sma.smartv3.pop.XX;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class AllCourseActivity$showListPoP$1$1 extends CommonAdapter<CourSelectByType> {
    final /* synthetic */ String $type;
    final /* synthetic */ AllCourseActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AllCourseActivity$showListPoP$1$1(List<CourSelectByType> list, String str, AllCourseActivity allCourseActivity, Activity activity) {
        super(activity, R.layout.item_all_pop_tv, list);
        this.$type = str;
        this.this$0 = allCourseActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(String type, AllCourseActivity this$0, CourSelectByType courSelectByType, View view) {
        XX xx2;
        IIX0o.x0xO0oo(type, "$type");
        IIX0o.x0xO0oo(this$0, "this$0");
        String str = null;
        if (IIX0o.Oxx0IOOO(type, GetCourSelectByType.COURSE_DIFF)) {
            if (courSelectByType != null) {
                str = courSelectByType.getDictValue();
            }
            this$0.setCourseDiff(str);
        } else if (IIX0o.Oxx0IOOO(type, GetCourSelectByType.COURSE_PART)) {
            if (courSelectByType != null) {
                str = courSelectByType.getDictValue();
            }
            this$0.setCoursePart(str);
        } else {
            if (courSelectByType != null) {
                str = courSelectByType.getDictValue();
            }
            this$0.setCourseSortType(str);
        }
        this$0.getOnLineCourseList();
        xx2 = this$0.mListPop;
        if (xx2 != null) {
            xx2.dismiss();
        }
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OXOo.OOXIXo ViewHolder viewHolder, @OXOo.oOoXoXO final CourSelectByType courSelectByType, int i) {
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        StringBuilder sb = new StringBuilder();
        sb.append(courSelectByType != null ? courSelectByType.getDictLabel() : null);
        sb.append("   ");
        viewHolder.setText(R.id.course_type_tv, sb.toString());
        final String str = this.$type;
        final AllCourseActivity allCourseActivity = this.this$0;
        viewHolder.setOnClickListener(R.id.course_type_tv, new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AllCourseActivity$showListPoP$1$1.convert$lambda$0(str, allCourseActivity, courSelectByType, view);
            }
        });
    }
}
