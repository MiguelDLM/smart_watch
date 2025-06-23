package com.sma.smartv3.ui.sport.coach;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.base.BaseActivity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.otherdevice.jl.view.CommonDecoration;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nCoachPlanDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoachPlanDetailActivity.kt\ncom/sma/smartv3/ui/sport/coach/CoachPlanDetailActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n1#2:112\n*E\n"})
/* loaded from: classes12.dex */
public final class CoachPlanDetailActivity extends BaseActivity {
    private AICoachManage.VitalityDayLesson mVitalityDayLesson;

    @OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.CoachPlanDetailActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CoachPlanDetailActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OOXIXo
    private final X0IIOO abhTitle$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.CoachPlanDetailActivity$abhTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CoachPlanDetailActivity.this.findViewById(R.id.plan_detail_title);
        }
    });

    @OOXIXo
    private final X0IIOO detailValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.CoachPlanDetailActivity$detailValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CoachPlanDetailActivity.this.findViewById(R.id.plan_detail_value);
        }
    });

    @OOXIXo
    private final X0IIOO detailRecycler$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.sport.coach.CoachPlanDetailActivity$detailRecycler$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) CoachPlanDetailActivity.this.findViewById(R.id.plan_detail_recycler);
        }
    });

    private final TextView getAbhTitle() {
        return (TextView) this.abhTitle$delegate.getValue();
    }

    private final TextView getAbhTitleCenter() {
        return (TextView) this.abhTitleCenter$delegate.getValue();
    }

    private final RecyclerView getDetailRecycler() {
        return (RecyclerView) this.detailRecycler$delegate.getValue();
    }

    private final TextView getDetailValue() {
        return (TextView) this.detailValue$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
        Serializable mArg3 = getMArg3();
        IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.ui.sport.coach.AICoachManage.VitalityDayLesson");
        this.mVitalityDayLesson = (AICoachManage.VitalityDayLesson) mArg3;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        final List mIntervalLessons;
        TextView abhTitle = getAbhTitle();
        AICoachManage.VitalityDayLesson vitalityDayLesson = this.mVitalityDayLesson;
        AICoachManage.VitalityDayLesson vitalityDayLesson2 = null;
        if (vitalityDayLesson == null) {
            IIX0o.XOxIOxOx("mVitalityDayLesson");
            vitalityDayLesson = null;
        }
        abhTitle.setText(vitalityDayLesson.getLessonTitle());
        TextView abhTitleCenter = getAbhTitleCenter();
        AICoachManage.VitalityDayLesson vitalityDayLesson3 = this.mVitalityDayLesson;
        if (vitalityDayLesson3 == null) {
            IIX0o.XOxIOxOx("mVitalityDayLesson");
            vitalityDayLesson3 = null;
        }
        abhTitleCenter.setText(vitalityDayLesson3.getLessonName());
        TextView detailValue = getDetailValue();
        AICoachManage.VitalityDayLesson vitalityDayLesson4 = this.mVitalityDayLesson;
        if (vitalityDayLesson4 == null) {
            IIX0o.XOxIOxOx("mVitalityDayLesson");
            vitalityDayLesson4 = null;
        }
        detailValue.setText(String.valueOf((int) vitalityDayLesson4.getLessonTarget()));
        getDetailRecycler().setLayoutManager(new LinearLayoutManager(this));
        getDetailRecycler().addItemDecoration(new CommonDecoration(this, 1, getResources().getColor(R.color.transparent), 32));
        AICoachManage.VitalityDayLesson vitalityDayLesson5 = this.mVitalityDayLesson;
        if (vitalityDayLesson5 == null) {
            IIX0o.XOxIOxOx("mVitalityDayLesson");
            vitalityDayLesson5 = null;
        }
        if (vitalityDayLesson5.getLessonCode() == 1) {
            AICoachManage.VitalityDayLesson vitalityDayLesson6 = this.mVitalityDayLesson;
            if (vitalityDayLesson6 == null) {
                IIX0o.XOxIOxOx("mVitalityDayLesson");
                vitalityDayLesson6 = null;
            }
            List<AICoachManage.VitalityLessonIntervalLessons> mIntervalLessons2 = vitalityDayLesson6.getMIntervalLessons();
            IIX0o.ooOOo0oXI(mIntervalLessons2);
            if (!mIntervalLessons2.isEmpty()) {
                AICoachManage.VitalityDayLesson vitalityDayLesson7 = this.mVitalityDayLesson;
                if (vitalityDayLesson7 == null) {
                    IIX0o.XOxIOxOx("mVitalityDayLesson");
                    vitalityDayLesson7 = null;
                }
                List<AICoachManage.VitalityLessonIntervalLessons> mIntervalLessons3 = vitalityDayLesson7.getMIntervalLessons();
                IIX0o.ooOOo0oXI(mIntervalLessons3);
                if (mIntervalLessons3.get(0).getTarget() != -1.0f) {
                    TextView detailValue2 = getDetailValue();
                    AICoachManage.VitalityDayLesson vitalityDayLesson8 = this.mVitalityDayLesson;
                    if (vitalityDayLesson8 == null) {
                        IIX0o.XOxIOxOx("mVitalityDayLesson");
                        vitalityDayLesson8 = null;
                    }
                    List<AICoachManage.VitalityLessonIntervalLessons> mIntervalLessons4 = vitalityDayLesson8.getMIntervalLessons();
                    IIX0o.ooOOo0oXI(mIntervalLessons4);
                    detailValue2.setText(String.valueOf((int) mIntervalLessons4.get(0).getTarget()));
                }
                mIntervalLessons = new ArrayList();
                AICoachManage.VitalityDayLesson vitalityDayLesson9 = this.mVitalityDayLesson;
                if (vitalityDayLesson9 == null) {
                    IIX0o.XOxIOxOx("mVitalityDayLesson");
                    vitalityDayLesson9 = null;
                }
                List<AICoachManage.VitalityLessonIntervalLessons> mIntervalLessons5 = vitalityDayLesson9.getMIntervalLessons();
                IIX0o.ooOOo0oXI(mIntervalLessons5);
                int repeatTimes = mIntervalLessons5.get(0).getRepeatTimes() * 2;
                for (int i = 0; i < repeatTimes; i++) {
                    AICoachManage.VitalityDayLesson vitalityDayLesson10 = this.mVitalityDayLesson;
                    if (vitalityDayLesson10 == null) {
                        IIX0o.XOxIOxOx("mVitalityDayLesson");
                        vitalityDayLesson10 = null;
                    }
                    List<AICoachManage.VitalityLessonIntervalLessons> mIntervalLessons6 = vitalityDayLesson10.getMIntervalLessons();
                    IIX0o.ooOOo0oXI(mIntervalLessons6);
                    mIntervalLessons.add(mIntervalLessons6.get(0));
                }
                final Activity mContext = getMContext();
                getDetailRecycler().setAdapter(new CommonAdapter<AICoachManage.VitalityLessonIntervalLessons>(mIntervalLessons, mContext) { // from class: com.sma.smartv3.ui.sport.coach.CoachPlanDetailActivity$initView$mAdapter$1
                    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
                    public void convert(@OOXIXo ViewHolder viewHolder, @OOXIXo AICoachManage.VitalityLessonIntervalLessons item, int i2) {
                        AICoachManage.VitalityDayLesson vitalityDayLesson11;
                        AICoachManage.VitalityDayLesson vitalityDayLesson12;
                        AICoachManage.VitalityDayLesson vitalityDayLesson13;
                        AICoachManage.VitalityDayLesson vitalityDayLesson14;
                        IIX0o.x0xO0oo(viewHolder, "viewHolder");
                        IIX0o.x0xO0oo(item, "item");
                        StringBuilder sb = new StringBuilder();
                        vitalityDayLesson11 = this.mVitalityDayLesson;
                        AICoachManage.VitalityDayLesson vitalityDayLesson15 = null;
                        if (vitalityDayLesson11 == null) {
                            IIX0o.XOxIOxOx("mVitalityDayLesson");
                            vitalityDayLesson11 = null;
                        }
                        sb.append(vitalityDayLesson11.getLessonTime());
                        sb.append(":00");
                        viewHolder.setText(R.id.item_detail_item_time_tv, sb.toString());
                        if (item.getLowerBoundHR() != -1 && item.getUpperBoundHR() != -1) {
                            viewHolder.setText(R.id.item_detail_item_hr_tv, item.getLowerBoundHR() + " - " + item.getUpperBoundHR() + TokenParser.SP + this.getString(R.string.bpm));
                        } else {
                            viewHolder.setText(R.id.item_detail_item_hr_tv, HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
                        }
                        vitalityDayLesson12 = this.mVitalityDayLesson;
                        if (vitalityDayLesson12 == null) {
                            IIX0o.XOxIOxOx("mVitalityDayLesson");
                            vitalityDayLesson12 = null;
                        }
                        viewHolder.setText(R.id.item_detail_item_title, vitalityDayLesson12.getLessonName());
                        AICoachManage oIX0oI2 = AICoachManage.f23905XO.oIX0oI();
                        vitalityDayLesson13 = this.mVitalityDayLesson;
                        if (vitalityDayLesson13 == null) {
                            IIX0o.XOxIOxOx("mVitalityDayLesson");
                            vitalityDayLesson13 = null;
                        }
                        viewHolder.setImageResource(R.id.item_detail_item_icon, oIX0oI2.x0XOIxOo(vitalityDayLesson13.getLessonCode()));
                        vitalityDayLesson14 = this.mVitalityDayLesson;
                        if (vitalityDayLesson14 == null) {
                            IIX0o.XOxIOxOx("mVitalityDayLesson");
                        } else {
                            vitalityDayLesson15 = vitalityDayLesson14;
                        }
                        int lessonCode = vitalityDayLesson15.getLessonCode();
                        if (lessonCode == 0) {
                            viewHolder.setText(R.id.item_detail_item_title, this.getString(R.string.workout7));
                            viewHolder.setImageResource(R.id.item_detail_item_icon, R.drawable.plan_detail_interval_run_icon);
                            return;
                        }
                        if (lessonCode != 1) {
                            return;
                        }
                        if (i2 % 2 == 0) {
                            viewHolder.setText(R.id.item_detail_item_time_tv, item.getIntenseMinutes() + ":00");
                            viewHolder.setText(R.id.item_detail_item_title, this.getString(R.string.workout7));
                            viewHolder.setText(R.id.item_detail_item_hr_tv, item.getLowerBoundHR() + " - " + item.getUpperBoundHR() + TokenParser.SP + this.getString(R.string.bpm));
                            return;
                        }
                        viewHolder.setText(R.id.item_detail_item_time_tv, item.getRestMinutes() + ":00");
                        viewHolder.setText(R.id.item_detail_item_title, this.getString(R.string.rest));
                        viewHolder.setText(R.id.item_detail_item_hr_tv, HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
                        viewHolder.setImageResource(R.id.item_detail_item_icon, R.drawable.plan_detail_lsd_rest_icon);
                    }
                });
            }
        }
        AICoachManage.VitalityDayLesson vitalityDayLesson11 = this.mVitalityDayLesson;
        if (vitalityDayLesson11 == null) {
            IIX0o.XOxIOxOx("mVitalityDayLesson");
        } else {
            vitalityDayLesson2 = vitalityDayLesson11;
        }
        mIntervalLessons = vitalityDayLesson2.getMIntervalLessons();
        final Activity mContext2 = getMContext();
        getDetailRecycler().setAdapter(new CommonAdapter<AICoachManage.VitalityLessonIntervalLessons>(mIntervalLessons, mContext2) { // from class: com.sma.smartv3.ui.sport.coach.CoachPlanDetailActivity$initView$mAdapter$1
            @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
            public void convert(@OOXIXo ViewHolder viewHolder, @OOXIXo AICoachManage.VitalityLessonIntervalLessons item, int i2) {
                AICoachManage.VitalityDayLesson vitalityDayLesson112;
                AICoachManage.VitalityDayLesson vitalityDayLesson12;
                AICoachManage.VitalityDayLesson vitalityDayLesson13;
                AICoachManage.VitalityDayLesson vitalityDayLesson14;
                IIX0o.x0xO0oo(viewHolder, "viewHolder");
                IIX0o.x0xO0oo(item, "item");
                StringBuilder sb = new StringBuilder();
                vitalityDayLesson112 = this.mVitalityDayLesson;
                AICoachManage.VitalityDayLesson vitalityDayLesson15 = null;
                if (vitalityDayLesson112 == null) {
                    IIX0o.XOxIOxOx("mVitalityDayLesson");
                    vitalityDayLesson112 = null;
                }
                sb.append(vitalityDayLesson112.getLessonTime());
                sb.append(":00");
                viewHolder.setText(R.id.item_detail_item_time_tv, sb.toString());
                if (item.getLowerBoundHR() != -1 && item.getUpperBoundHR() != -1) {
                    viewHolder.setText(R.id.item_detail_item_hr_tv, item.getLowerBoundHR() + " - " + item.getUpperBoundHR() + TokenParser.SP + this.getString(R.string.bpm));
                } else {
                    viewHolder.setText(R.id.item_detail_item_hr_tv, HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
                }
                vitalityDayLesson12 = this.mVitalityDayLesson;
                if (vitalityDayLesson12 == null) {
                    IIX0o.XOxIOxOx("mVitalityDayLesson");
                    vitalityDayLesson12 = null;
                }
                viewHolder.setText(R.id.item_detail_item_title, vitalityDayLesson12.getLessonName());
                AICoachManage oIX0oI2 = AICoachManage.f23905XO.oIX0oI();
                vitalityDayLesson13 = this.mVitalityDayLesson;
                if (vitalityDayLesson13 == null) {
                    IIX0o.XOxIOxOx("mVitalityDayLesson");
                    vitalityDayLesson13 = null;
                }
                viewHolder.setImageResource(R.id.item_detail_item_icon, oIX0oI2.x0XOIxOo(vitalityDayLesson13.getLessonCode()));
                vitalityDayLesson14 = this.mVitalityDayLesson;
                if (vitalityDayLesson14 == null) {
                    IIX0o.XOxIOxOx("mVitalityDayLesson");
                } else {
                    vitalityDayLesson15 = vitalityDayLesson14;
                }
                int lessonCode = vitalityDayLesson15.getLessonCode();
                if (lessonCode == 0) {
                    viewHolder.setText(R.id.item_detail_item_title, this.getString(R.string.workout7));
                    viewHolder.setImageResource(R.id.item_detail_item_icon, R.drawable.plan_detail_interval_run_icon);
                    return;
                }
                if (lessonCode != 1) {
                    return;
                }
                if (i2 % 2 == 0) {
                    viewHolder.setText(R.id.item_detail_item_time_tv, item.getIntenseMinutes() + ":00");
                    viewHolder.setText(R.id.item_detail_item_title, this.getString(R.string.workout7));
                    viewHolder.setText(R.id.item_detail_item_hr_tv, item.getLowerBoundHR() + " - " + item.getUpperBoundHR() + TokenParser.SP + this.getString(R.string.bpm));
                    return;
                }
                viewHolder.setText(R.id.item_detail_item_time_tv, item.getRestMinutes() + ":00");
                viewHolder.setText(R.id.item_detail_item_title, this.getString(R.string.rest));
                viewHolder.setText(R.id.item_detail_item_hr_tv, HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
                viewHolder.setImageResource(R.id.item_detail_item_icon, R.drawable.plan_detail_lsd_rest_icon);
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_coach_plan_detail;
    }

    public final void onTitleLeftClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        onBackPressed();
    }
}
