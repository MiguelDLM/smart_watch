package com.sma.smartv3.ui.sport.coach.item;

import OXOo.OOXIXo;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.sport.coach.CreatePlanActivity;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public class LackPlanItem extends BaseDslItem {
    private Button mButton;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(LackPlanItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (ProjectManager.f19822oIX0oI.xIOXX()) {
            Button button = this$0.mButton;
            Button button2 = null;
            if (button == null) {
                IIX0o.XOxIOxOx("mButton");
                button = null;
            }
            Context context = button.getContext();
            Button button3 = this$0.mButton;
            if (button3 == null) {
                IIX0o.XOxIOxOx("mButton");
            } else {
                button2 = button3;
            }
            context.startActivity(new Intent(button2.getContext(), (Class<?>) CreatePlanActivity.class));
            return;
        }
        ToastUtils.showLong(R.string.abh_login_tip);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.coach_item_create_plan);
        IIX0o.ooOOo0oXI(v);
        this.mButton = (Button) v;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        Button button = this.mButton;
        if (button == null) {
            IIX0o.XOxIOxOx("mButton");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.item.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LackPlanItem.initView$lambda$0(LackPlanItem.this, view);
            }
        });
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.coach_item_lack_plan;
    }
}
