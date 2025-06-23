package com.sma.smartv3.ui.sport.coach.guide;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseFragment;
import com.github.appintro.SlideSelectionListener;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes12.dex */
public final class PersonalActivityConfirmFragment extends BaseFragment implements SlideSelectionListener {

    @OOXIXo
    private final X0IIOO mLevelTv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalActivityConfirmFragment$mLevelTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PersonalActivityConfirmFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.assessment_you_level);
        }
    });

    @OOXIXo
    private final X0IIOO mDuration$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalActivityConfirmFragment$mDuration$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PersonalActivityConfirmFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.assessment_duration);
        }
    });

    @OOXIXo
    private final X0IIOO mTipTitle$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalActivityConfirmFragment$mTipTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PersonalActivityConfirmFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.start_title_tv);
        }
    });

    public final TextView getMDuration() {
        return (TextView) this.mDuration$delegate.getValue();
    }

    public final TextView getMLevelTv() {
        return (TextView) this.mLevelTv$delegate.getValue();
    }

    public final TextView getMTipTitle() {
        return (TextView) this.mTipTitle$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
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
        return R.layout.ai_coach_personal_assessment_cofirm;
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideDeselected() {
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideSelected() {
        String string;
        TextView mLevelTv = getMLevelTv();
        AICoachManage.oIX0oI oix0oi = AICoachManage.f23905XO;
        int level = oix0oi.oIX0oI().oI0IIXIo().getLevel();
        if (level != 2) {
            if (level != 3) {
                if (level != 4) {
                    if (level != 5) {
                        string = getString(R.string.coach_rank_beginner);
                    } else {
                        string = getString(R.string.coach_rank_athletic);
                    }
                } else {
                    string = getString(R.string.coach_rank_challenger);
                }
            } else {
                string = getString(R.string.coach_rank_intermediate);
            }
        } else {
            string = getString(R.string.coach_rank_elementary);
        }
        mLevelTv.setText(string);
        getMDuration().setText(oix0oi.oIX0oI().oI0IIXIo().getWeeklyTargetNumber() + TokenParser.SP + getString(R.string.week));
    }
}
