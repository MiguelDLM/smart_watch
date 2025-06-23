package com.sma.smartv3.ui.sport.coach;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nPlanConfirmActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlanConfirmActivity.kt\ncom/sma/smartv3/ui/sport/coach/PlanConfirmActivity$addRecyclerView$adapter$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,316:1\n1855#2,2:317\n1549#2:319\n1620#2,3:320\n*S KotlinDebug\n*F\n+ 1 PlanConfirmActivity.kt\ncom/sma/smartv3/ui/sport/coach/PlanConfirmActivity$addRecyclerView$adapter$1\n*L\n233#1:317,2\n243#1:319\n243#1:320,3\n*E\n"})
/* loaded from: classes12.dex */
public final class PlanConfirmActivity$addRecyclerView$adapter$1 extends CommonAdapter<AICoachManage.PlanGroupTitle> {
    final /* synthetic */ PlanConfirmActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlanConfirmActivity$addRecyclerView$adapter$1(PlanConfirmActivity planConfirmActivity, Ref.ObjectRef<List<AICoachManage.PlanGroupTitle>> objectRef) {
        super(planConfirmActivity, R.layout.item_ai_plan_item_group_head, objectRef.element);
        this.this$0 = planConfirmActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$3(PlanConfirmActivity$addRecyclerView$adapter$1 this$0, PlanConfirmActivity this$1, int i, AICoachManage.PlanGroupTitle item, View view) {
        List list;
        String str;
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(this$1, "this$1");
        IIX0o.x0xO0oo(item, "$item");
        if (((CommonAdapter) this$0).mContext != null) {
            ArrayList arrayList = new ArrayList();
            for (DslAdapterItem dslAdapterItem : this$1.getDslAdapter().getDataItems()) {
                if (!dslAdapterItem.getItemIsGroupHead()) {
                    List<String> itemGroups = dslAdapterItem.getItemGroups();
                    str = this$1.ITEM_GROUPS_TAG;
                    if (IIX0o.Oxx0IOOO(itemGroups, CollectionsKt__CollectionsKt.XOxIOxOx(str))) {
                        arrayList.add(dslAdapterItem);
                    }
                }
            }
            this$1.getDslAdapter().removeItem(arrayList);
            DslAdapter.updateItemDepend$default(this$1.getDslAdapter(), null, 1, null);
            this$1.curPosition = i;
            this$1.curDataPosition = item.getMLessonIndex();
            this$1.curTimeDay = item.getTimeDay();
            list = this$1.mListAdapter;
            List list2 = list;
            ArrayList arrayList2 = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                ((CommonAdapter) it.next()).notifyDataSetChanged();
                arrayList2.add(oXIO0o0XI.f29392oIX0oI);
            }
            this$1.showPlanFunction();
            DslAdapter.render$default(this$1.getDslAdapter(), false, null, new oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.PlanConfirmActivity$addRecyclerView$adapter$1$convert$1$1$3
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                    invoke2(dslAdapter);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo DslAdapter render) {
                    IIX0o.x0xO0oo(render, "$this$render");
                    DslAdapter.setAdapterStatus$default(render, 0, null, 2, null);
                }
            }, 3, null);
        }
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OOXIXo ViewHolder viewHolder, @OOXIXo final AICoachManage.PlanGroupTitle item, final int i) {
        int color;
        int i2;
        String str;
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        IIX0o.x0xO0oo(item, "item");
        TextView textView = (TextView) viewHolder.getView(R.id.text_time_calendar);
        TextView textView2 = (TextView) viewHolder.getView(R.id.text_time);
        textView.setText(item.getOfWeek());
        textView2.setText(item.getTimeDay());
        View view = viewHolder.getView(R.id.plan_item_group_head_title);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{60.0f, 60.0f, 60.0f, 60.0f, 60.0f, 60.0f, 60.0f, 60.0f});
        if (item.isHaveLesson() && AICoachManage.f23905XO.oIX0oI().oI0IIXIo().getDailySchedule().get(item.getMLessonIndex() % 7).intValue() == 1) {
            color = this.this$0.getResources().getColor(R.color.coach_assessment_rank_2);
        } else {
            color = this.this$0.getResources().getColor(R.color.coach_assessment_rank_6);
        }
        textView2.setBackground(null);
        textView.setTextColor(this.this$0.getResources().getColor(R.color.black));
        textView2.setTextColor(this.this$0.getResources().getColor(R.color.black));
        i2 = this.this$0.curPosition;
        if (i == i2) {
            String timeDay = item.getTimeDay();
            str = this.this$0.curTimeDay;
            if (IIX0o.Oxx0IOOO(timeDay, str)) {
                color = this.this$0.getResources().getColor(R.color.colorAccent);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(1);
                gradientDrawable2.setColor(this.this$0.getResources().getColor(R.color.light));
                textView2.setBackground(gradientDrawable2);
                textView.setTextColor(this.this$0.getResources().getColor(R.color.light));
                textView2.setTextColor(this.this$0.getResources().getColor(R.color.colorAccent));
            }
        }
        gradientDrawable.setColor(color);
        view.setBackground(gradientDrawable);
        View view2 = viewHolder.itemView;
        final PlanConfirmActivity planConfirmActivity = this.this$0;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.Oxx0IOOO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PlanConfirmActivity$addRecyclerView$adapter$1.convert$lambda$3(PlanConfirmActivity$addRecyclerView$adapter$1.this, planConfirmActivity, i, item, view3);
            }
        });
    }
}
