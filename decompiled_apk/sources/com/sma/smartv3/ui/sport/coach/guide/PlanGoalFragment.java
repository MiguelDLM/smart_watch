package com.sma.smartv3.ui.sport.coach.guide;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.base.BaseFragment;
import com.github.appintro.SlideSelectionListener;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import java.util.List;
import kotlin.Pair;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes12.dex */
public final class PlanGoalFragment extends BaseFragment implements SlideSelectionListener {

    @OOXIXo
    private final X0IIOO llChoices$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PlanGoalFragment$llChoices$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            View mView;
            mView = PlanGoalFragment.this.getMView();
            return (RecyclerView) mView.findViewById(R.id.ll_choices);
        }
    });

    @oOoXoXO
    private CommonAdapter<String> mAdapter;

    private final RecyclerView getLlChoices() {
        return (RecyclerView) this.llChoices$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.ai_coach_plan_goal;
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideDeselected() {
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideSelected() {
        Pair<List<String>, List<String>> Oxx0xo2 = AICoachManage.f23905XO.oIX0oI().Oxx0xo();
        final List<String> component1 = Oxx0xo2.component1();
        final List<String> component2 = Oxx0xo2.component2();
        getLlChoices().setLayoutManager(new LinearLayoutManager(requireContext()));
        final Context context = getLlChoices().getContext();
        final List oOo0o = CollectionsKt___CollectionsKt.oOo0o(component1);
        CommonAdapter<String> commonAdapter = new CommonAdapter<String>(context, oOo0o) { // from class: com.sma.smartv3.ui.sport.coach.guide.PlanGoalFragment$onSlideSelected$1
            @Override // com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return component1.size();
            }

            @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
            public void convert(@OOXIXo ViewHolder viewHolder, @OOXIXo String item, int i) {
                IIX0o.x0xO0oo(viewHolder, "viewHolder");
                IIX0o.x0xO0oo(item, "item");
                viewHolder.getView(R.id.item_line_view).setVisibility(i == 0 ? 4 : 0);
                ((TextView) viewHolder.getView(R.id.tv_time)).setText(component1.get(i));
                TextView textView = (TextView) viewHolder.getView(R.id.tv_value);
                textView.setText(component2.get(i));
                String str = component2.get(i);
                String string = this.getString(R.string.abh_mets_unit);
                IIX0o.oO(string, "getString(...)");
                if (StringsKt__StringsKt.o00xOoIO(str, string, false, 2, null)) {
                    textView.setTextColor(oIxOXo.oxoX.X0o0xo(this.requireActivity(), R.color.text_color));
                } else {
                    textView.setTextColor(this.getResources().getColor(R.color.line_color));
                }
            }
        };
        getLlChoices().setAdapter(commonAdapter);
        this.mAdapter = commonAdapter;
    }
}
