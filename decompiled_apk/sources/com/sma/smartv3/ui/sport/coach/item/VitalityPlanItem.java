package com.sma.smartv3.ui.sport.coach.item;

import OXOo.OOXIXo;
import android.view.View;
import android.widget.TextView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nVitalityPlanItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VitalityPlanItem.kt\ncom/sma/smartv3/ui/sport/coach/item/VitalityPlanItem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,38:1\n1864#2,3:39\n*S KotlinDebug\n*F\n+ 1 VitalityPlanItem.kt\ncom/sma/smartv3/ui/sport/coach/item/VitalityPlanItem\n*L\n27#1:39,3\n*E\n"})
/* loaded from: classes12.dex */
public class VitalityPlanItem extends BaseDslItem {
    private TextView daysTv;
    private TextView goalTv;
    private TextView weekTv;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.vitality_plan_week_tv);
        IIX0o.ooOOo0oXI(v);
        this.weekTv = (TextView) v;
        View v2 = itemHolder.v(R.id.vitality_plan_days_tv);
        IIX0o.ooOOo0oXI(v2);
        this.daysTv = (TextView) v2;
        View v3 = itemHolder.v(R.id.vitality_plan_goal_tv);
        IIX0o.ooOOo0oXI(v3);
        this.goalTv = (TextView) v3;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        TextView textView = this.weekTv;
        TextView textView2 = null;
        if (textView == null) {
            IIX0o.XOxIOxOx("weekTv");
            textView = null;
        }
        AICoachManage.oIX0oI oix0oi = AICoachManage.f23905XO;
        textView.setText(String.valueOf(oix0oi.oIX0oI().oI0IIXIo().getWeeklyTargetNumber()));
        int i = 0;
        int i2 = 0;
        for (Object obj : oix0oi.oIX0oI().oI0IIXIo().getDailySchedule()) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            if (((Number) obj).intValue() == 1 && i != AICoachManage.f23905XO.oIX0oI().oI0IIXIo().getDailySchedule().size() - 1) {
                i2++;
            }
            i = i3;
        }
        TextView textView3 = this.daysTv;
        if (textView3 == null) {
            IIX0o.XOxIOxOx("daysTv");
            textView3 = null;
        }
        textView3.setText(String.valueOf(i2));
        TextView textView4 = this.goalTv;
        if (textView4 == null) {
            IIX0o.XOxIOxOx("goalTv");
        } else {
            textView2 = textView4;
        }
        textView2.setText(String.valueOf((int) AICoachManage.f23905XO.oIX0oI().oI0IIXIo().getPlanTarget()));
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.coach_item_vitality_plan;
    }
}
