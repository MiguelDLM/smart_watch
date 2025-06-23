package com.sma.smartv3.ui.sport.coach.guide;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseFragment;
import com.github.appintro.SlideSelectionListener;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.me.WebViewActivity;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import com.sma.smartv3.util.UtilsKt;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nPersonalActivityFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PersonalActivityFragment.kt\ncom/sma/smartv3/ui/sport/coach/guide/PersonalActivityFragment\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n99#2,7:125\n106#2,3:133\n79#2,7:136\n109#2:143\n1#3:132\n*S KotlinDebug\n*F\n+ 1 PersonalActivityFragment.kt\ncom/sma/smartv3/ui/sport/coach/guide/PersonalActivityFragment\n*L\n54#1:125,7\n54#1:133,3\n54#1:136,7\n54#1:143\n54#1:132\n*E\n"})
/* loaded from: classes12.dex */
public final class PersonalActivityFragment extends BaseFragment implements SlideSelectionListener {
    private boolean isSpan;

    @OOXIXo
    private final X0IIOO mBeginnerView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalActivityFragment$mBeginnerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PersonalActivityFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.coach_rank_beginner_tv);
        }
    });

    @OOXIXo
    private final X0IIOO mElementaryView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalActivityFragment$mElementaryView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PersonalActivityFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.coach_rank_elementary_tv);
        }
    });

    @OOXIXo
    private final X0IIOO mIntermediateView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalActivityFragment$mIntermediateView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PersonalActivityFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.coach_rank_intermediate_tv);
        }
    });

    @OOXIXo
    private final X0IIOO mChallengerView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalActivityFragment$mChallengerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PersonalActivityFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.coach_rank_challenger_tv);
        }
    });

    @OOXIXo
    private final X0IIOO mAthleticView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalActivityFragment$mAthleticView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PersonalActivityFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.coach_rank_athletic_tv);
        }
    });

    @OOXIXo
    private final X0IIOO mGoalView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalActivityFragment$mGoalView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PersonalActivityFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.personal_goal_tv);
        }
    });

    @OOXIXo
    private final X0IIOO mTipTitle$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalActivityFragment$mTipTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PersonalActivityFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.start_title_tv);
        }
    });

    @OOXIXo
    private final X0IIOO mLayoutView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalActivityFragment$mLayoutView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = PersonalActivityFragment.this.getMView();
            return mView.findViewById(R.id.btn_layout_view);
        }
    });

    @OOXIXo
    private final X0IIOO mTipImgView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalActivityFragment$mTipImgView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = PersonalActivityFragment.this.getMView();
            return mView.findViewById(R.id.personal_tip_img);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(PersonalActivityFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", "https://api.iot-solution.net/web/help/ai_coach_about_mets.html");
        bundle.putInt("mArg1", 2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) WebViewActivity.class);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }

    private final void setRank(int i) {
        getMBeginnerView().setTextColor(oIxOXo.oxoX.X0o0xo(getMBeginnerView().getContext(), R.color.line_color));
        TextView mBeginnerView = getMBeginnerView();
        IIX0o.oO(mBeginnerView, "<get-mBeginnerView>(...)");
        setTextSpannableString(mBeginnerView, 1.0f);
        getMElementaryView().setTextColor(oIxOXo.oxoX.X0o0xo(getMBeginnerView().getContext(), R.color.line_color));
        TextView mElementaryView = getMElementaryView();
        IIX0o.oO(mElementaryView, "<get-mElementaryView>(...)");
        setTextSpannableString(mElementaryView, 1.0f);
        getMIntermediateView().setTextColor(oIxOXo.oxoX.X0o0xo(getMBeginnerView().getContext(), R.color.line_color));
        TextView mIntermediateView = getMIntermediateView();
        IIX0o.oO(mIntermediateView, "<get-mIntermediateView>(...)");
        setTextSpannableString(mIntermediateView, 1.0f);
        getMChallengerView().setTextColor(oIxOXo.oxoX.X0o0xo(getMBeginnerView().getContext(), R.color.line_color));
        TextView mChallengerView = getMChallengerView();
        IIX0o.oO(mChallengerView, "<get-mChallengerView>(...)");
        setTextSpannableString(mChallengerView, 1.0f);
        getMAthleticView().setTextColor(oIxOXo.oxoX.X0o0xo(getMBeginnerView().getContext(), R.color.line_color));
        TextView mAthleticView = getMAthleticView();
        IIX0o.oO(mAthleticView, "<get-mAthleticView>(...)");
        setTextSpannableString(mAthleticView, 1.0f);
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            TextView mAthleticView2 = getMAthleticView();
                            IIX0o.oO(mAthleticView2, "<get-mAthleticView>(...)");
                            setTextSpannableString$default(this, mAthleticView2, 0.0f, 2, null);
                            getMAthleticView().setTextColor(oIxOXo.oxoX.X0o0xo(getMBeginnerView().getContext(), R.color.text_color));
                        }
                    } else {
                        TextView mChallengerView2 = getMChallengerView();
                        IIX0o.oO(mChallengerView2, "<get-mChallengerView>(...)");
                        setTextSpannableString$default(this, mChallengerView2, 0.0f, 2, null);
                        getMChallengerView().setTextColor(oIxOXo.oxoX.X0o0xo(getMBeginnerView().getContext(), R.color.text_color));
                    }
                } else {
                    TextView mIntermediateView2 = getMIntermediateView();
                    IIX0o.oO(mIntermediateView2, "<get-mIntermediateView>(...)");
                    setTextSpannableString$default(this, mIntermediateView2, 0.0f, 2, null);
                    getMIntermediateView().setTextColor(oIxOXo.oxoX.X0o0xo(getMBeginnerView().getContext(), R.color.text_color));
                }
            } else {
                TextView mElementaryView2 = getMElementaryView();
                IIX0o.oO(mElementaryView2, "<get-mElementaryView>(...)");
                setTextSpannableString$default(this, mElementaryView2, 0.0f, 2, null);
                getMElementaryView().setTextColor(oIxOXo.oxoX.X0o0xo(getMBeginnerView().getContext(), R.color.text_color));
            }
        } else {
            TextView mBeginnerView2 = getMBeginnerView();
            IIX0o.oO(mBeginnerView2, "<get-mBeginnerView>(...)");
            setTextSpannableString$default(this, mBeginnerView2, 0.0f, 2, null);
            getMBeginnerView().setTextColor(oIxOXo.oxoX.X0o0xo(getMBeginnerView().getContext(), R.color.text_color));
        }
        this.isSpan = true;
    }

    public static /* synthetic */ void setRank$default(PersonalActivityFragment personalActivityFragment, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        personalActivityFragment.setRank(i);
    }

    private final void setTextSpannableString(TextView textView, float f) {
        if (this.isSpan && f == 1.3f) {
            return;
        }
        CharSequence text = textView.getText();
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new RelativeSizeSpan(f), 0, text.length(), 33);
        textView.setText(spannableString);
    }

    public static /* synthetic */ void setTextSpannableString$default(PersonalActivityFragment personalActivityFragment, TextView textView, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.3f;
        }
        personalActivityFragment.setTextSpannableString(textView, f);
    }

    public final TextView getMAthleticView() {
        return (TextView) this.mAthleticView$delegate.getValue();
    }

    public final TextView getMBeginnerView() {
        return (TextView) this.mBeginnerView$delegate.getValue();
    }

    public final TextView getMChallengerView() {
        return (TextView) this.mChallengerView$delegate.getValue();
    }

    public final TextView getMElementaryView() {
        return (TextView) this.mElementaryView$delegate.getValue();
    }

    public final TextView getMGoalView() {
        return (TextView) this.mGoalView$delegate.getValue();
    }

    public final TextView getMIntermediateView() {
        return (TextView) this.mIntermediateView$delegate.getValue();
    }

    public final View getMLayoutView() {
        return (View) this.mLayoutView$delegate.getValue();
    }

    public final View getMTipImgView() {
        return (View) this.mTipImgView$delegate.getValue();
    }

    public final TextView getMTipTitle() {
        return (TextView) this.mTipTitle$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        View mLayoutView = getMLayoutView();
        IIX0o.oO(mLayoutView, "<get-mLayoutView>(...)");
        UtilsKt.x0o(mLayoutView, 24.0f);
        CharSequence text = getMTipTitle().getText();
        SpannableString spannableString = new SpannableString(text);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(oIxOXo.oxoX.I0Io(getMTipTitle().getContext(), R.color.line_color));
        IIX0o.ooOOo0oXI(text);
        IIX0o.oO(getString(R.string.btn_start), "getString(...)");
        spannableString.setSpan(foregroundColorSpan, 0, StringsKt__StringsKt.O0O0Io00X(text, r2, 0, false, 6, null) - 1, 33);
        getMTipTitle().setText(spannableString);
        getMTipImgView().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.guide.oIX0oI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PersonalActivityFragment.initView$lambda$0(PersonalActivityFragment.this, view);
            }
        });
    }

    public final boolean isSpan() {
        return this.isSpan;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.ai_coach_personal_assessment;
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideDeselected() {
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideSelected() {
        TextView mGoalView = getMGoalView();
        AICoachManage.oIX0oI oix0oi = AICoachManage.f23905XO;
        mGoalView.setText(String.valueOf((int) oix0oi.oIX0oI().oI0IIXIo().getPlanTarget()));
        setRank(oix0oi.oIX0oI().oI0IIXIo().getLevel());
    }

    public final void setSpan(boolean z) {
        this.isSpan = z;
    }
}
