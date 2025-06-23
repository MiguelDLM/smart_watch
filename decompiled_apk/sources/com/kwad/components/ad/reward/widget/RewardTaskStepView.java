package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.ad.reward.l.c;
import com.kwad.sdk.R;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.DividerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public class RewardTaskStepView extends LinearLayout {
    private List<c> Br;
    private String qa;

    public RewardTaskStepView(Context context) {
        super(context);
        this.Br = new ArrayList();
        kg();
    }

    private void ad(boolean z) {
        int i;
        DividerView dividerView = (DividerView) l.a(getContext(), R.layout.ksad_reward_task_dialog_dash, this, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_icon_size);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_divider_height);
        if (z) {
            i = R.color.ksad_reward_main_color;
        } else {
            i = R.color.ksad_reward_undone_color;
        }
        dividerView.setDividerColor(getResources().getColor(i));
        addView(dividerView, dimensionPixelSize, dimensionPixelSize2);
    }

    private void kg() {
        setOrientation(1);
    }

    private void kh() {
        int size = this.Br.size();
        int i = 0;
        while (i < size) {
            c cVar = this.Br.get(i);
            int i2 = i + 1;
            a(i2, cVar.jv(), cVar.jw(), cVar.isCompleted());
            if (i < size - 1) {
                ad(this.Br.get(i2).isCompleted());
            }
            i = i2;
        }
    }

    public final void a(List<c> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.qa = str;
        this.Br.clear();
        this.Br.addAll(list);
        kh();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Br = new ArrayList();
        kg();
    }

    private void a(int i, String str, String str2, boolean z) {
        int i2;
        if (z) {
            i2 = R.layout.ksad_reward_task_step_item_checked;
        } else {
            i2 = R.layout.ksad_reward_task_step_item_unchecked;
        }
        ViewGroup viewGroup = (ViewGroup) l.a(getContext(), i2, this, false);
        if (z) {
            a(viewGroup, str);
        } else {
            a(viewGroup, i, str2);
        }
        addView(viewGroup);
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Br = new ArrayList();
        kg();
    }

    @RequiresApi(api = 21)
    public RewardTaskStepView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Br = new ArrayList();
        kg();
    }

    private static void a(ViewGroup viewGroup, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(str);
    }

    private void a(ViewGroup viewGroup, int i, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(String.format(str, this.qa));
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_icon_text)).setText(String.valueOf(i));
    }
}
