package com.sma.smartv3.ui.status.item;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.angcyo.dsladapter.DslViewHolder;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.ui.status.StepActivity;
import com.sma.smartv3.view.StepProgressBar;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public class StepItem extends MainStepItem {
    private StepProgressBar stepProgressBar;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0(StepItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (com.sma.smartv3.ui.status.x0XOIxOo.f24154oIX0oI.oIX0oI()) {
            ContextCompat.startActivity(this$0.getMContext(), new Intent(this$0.getMContext(), (Class<?>) StepActivity.class), new Bundle());
        }
    }

    @Override // com.sma.smartv3.ui.status.item.MainStepItem, com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        super.bindView(itemHolder);
        View v = itemHolder.v(R.id.stepPB);
        IIX0o.ooOOo0oXI(v);
        StepProgressBar stepProgressBar = (StepProgressBar) v;
        this.stepProgressBar = stepProgressBar;
        if (stepProgressBar == null) {
            IIX0o.XOxIOxOx("stepProgressBar");
            stepProgressBar = null;
        }
        stepProgressBar.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.item.oOoXoXO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepItem.bindView$lambda$0(StepItem.this, view);
            }
        });
    }

    @Override // com.sma.smartv3.ui.status.item.MainStepItem
    public void updateActivity() {
        super.updateActivity();
        StepProgressBar stepProgressBar = this.stepProgressBar;
        if (stepProgressBar == null) {
            IIX0o.XOxIOxOx("stepProgressBar");
            stepProgressBar = null;
        }
        Activity activity = getActivity();
        IIX0o.ooOOo0oXI(activity);
        stepProgressBar.oxoX(activity.getMStep(), BleCache.getInt$default(BleCache.INSTANCE, BleKey.STEP_GOAL, 0, null, 6, null));
    }
}
