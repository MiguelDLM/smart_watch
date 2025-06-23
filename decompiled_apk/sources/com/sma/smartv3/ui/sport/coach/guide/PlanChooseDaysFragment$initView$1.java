package com.sma.smartv3.ui.sport.coach.guide;

import OXOo.OOXIXo;
import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.x0xO0oo;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class PlanChooseDaysFragment$initView$1 extends CommonAdapter<String> {
    final /* synthetic */ String[] $mChoices;
    final /* synthetic */ PlanChooseDaysFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlanChooseDaysFragment$initView$1(String[] strArr, PlanChooseDaysFragment planChooseDaysFragment, Context context, List<String> list) {
        super(context, R.layout.item_pop_multi_left_round, list);
        this.$mChoices = strArr;
        this.this$0 = planChooseDaysFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(PlanChooseDaysFragment this$0, int i, ViewHolder viewHolder, View view) {
        boolean[] zArr;
        boolean[] zArr2;
        boolean[] zArr3;
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(viewHolder, "$viewHolder");
        zArr = this$0.mChooseActivity;
        if (zArr[i]) {
            zArr3 = this$0.mChooseActivity;
            zArr3[i] = false;
            ((CheckBox) viewHolder.getView(R.id.checkbox)).setChecked(false);
        } else {
            zArr2 = this$0.mChooseActivity;
            zArr2[i] = true;
            ((CheckBox) viewHolder.getView(R.id.checkbox)).setChecked(true);
        }
        x0xO0oo.oIX0oI(x0xO0oo.f24590OIOoIIOIx, Integer.valueOf(this$0.getChoicesSize()));
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.$mChoices.length;
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OOXIXo final ViewHolder viewHolder, @OOXIXo String item, final int i) {
        boolean[] zArr;
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        IIX0o.x0xO0oo(item, "item");
        viewHolder.getView(R.id.item_line_view).setVisibility(i == 0 ? 4 : 0);
        ((TextView) viewHolder.getView(R.id.tv_value)).setText(this.$mChoices[i]);
        CheckBox checkBox = (CheckBox) viewHolder.getView(R.id.checkbox);
        zArr = this.this$0.mChooseActivity;
        checkBox.setChecked(zArr[i]);
        View view = viewHolder.itemView;
        final PlanChooseDaysFragment planChooseDaysFragment = this.this$0;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.guide.XO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlanChooseDaysFragment$initView$1.convert$lambda$0(PlanChooseDaysFragment.this, i, viewHolder, view2);
            }
        });
    }
}
