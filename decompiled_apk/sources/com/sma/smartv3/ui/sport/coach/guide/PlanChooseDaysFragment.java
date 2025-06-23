package com.sma.smartv3.ui.sport.coach.guide;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.base.BaseFragment;
import com.github.appintro.SlideSelectionListener;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nPlanChooseDaysFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlanChooseDaysFragment.kt\ncom/sma/smartv3/ui/sport/coach/guide/PlanChooseDaysFragment\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,106:1\n13358#2,2:107\n13444#2,3:109\n*S KotlinDebug\n*F\n+ 1 PlanChooseDaysFragment.kt\ncom/sma/smartv3/ui/sport/coach/guide/PlanChooseDaysFragment\n*L\n88#1:107,2\n97#1:109,3\n*E\n"})
/* loaded from: classes12.dex */
public final class PlanChooseDaysFragment extends BaseFragment implements SlideSelectionListener {

    @oOoXoXO
    private CommonAdapter<String> mAdapter;

    @OOXIXo
    private final X0IIOO llChoices$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PlanChooseDaysFragment$llChoices$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            View mView;
            mView = PlanChooseDaysFragment.this.getMView();
            return (RecyclerView) mView.findViewById(R.id.ll_choices);
        }
    });

    @OOXIXo
    private final X0IIOO mTipTitle$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PlanChooseDaysFragment$mTipTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PlanChooseDaysFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.start_title_tv);
        }
    });

    @OOXIXo
    private final boolean[] mChooseActivity = {false, false, true, false, true, true, false};

    private final RecyclerView getLlChoices() {
        return (RecyclerView) this.llChoices$delegate.getValue();
    }

    public final int getChoicesSize() {
        int i = 0;
        for (boolean z : this.mChooseActivity) {
            if (z) {
                i++;
            }
        }
        return i;
    }

    public final TextView getMTipTitle() {
        return (TextView) this.mTipTitle$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        String[] strArr = {getString(R.string.weekday7_s), getString(R.string.weekday1_s), getString(R.string.weekday2_s), getString(R.string.weekday3_s), getString(R.string.weekday4_s), getString(R.string.weekday5_s), getString(R.string.weekday6_s)};
        getLlChoices().setLayoutManager(new LinearLayoutManager(requireContext()));
        PlanChooseDaysFragment$initView$1 planChooseDaysFragment$initView$1 = new PlanChooseDaysFragment$initView$1(strArr, this, getLlChoices().getContext(), ArraysKt___ArraysKt.IoXOX(strArr));
        getLlChoices().setAdapter(planChooseDaysFragment$initView$1);
        this.mAdapter = planChooseDaysFragment$initView$1;
        CharSequence text = getMTipTitle().getText();
        SpannableString spannableString = new SpannableString(text);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(oIxOXo.oxoX.I0Io(getMTipTitle().getContext(), R.color.text_color));
        IIX0o.ooOOo0oXI(text);
        String string = getString(R.string.next);
        IIX0o.oO(string, "getString(...)");
        int O0O0Io00X2 = StringsKt__StringsKt.O0O0Io00X(text, string, 0, false, 6, null) - 1;
        spannableString.setSpan(foregroundColorSpan, O0O0Io00X2, getString(R.string.next).length() + O0O0Io00X2 + 1, 33);
        getMTipTitle().setText(spannableString);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.ai_coach_choose_day;
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideDeselected() {
        boolean[] zArr = this.mChooseActivity;
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            AICoachManage.f23905XO.oIX0oI().oI0IIXIo().getDailySchedule().set(i2, Integer.valueOf(oOXoIIIo.I0Io.I0Io(zArr[i])));
            i++;
            i2++;
        }
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideSelected() {
    }
}
