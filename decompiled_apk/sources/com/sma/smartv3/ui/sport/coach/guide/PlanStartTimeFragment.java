package com.sma.smartv3.ui.sport.coach.guide;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseFragment;
import com.github.appintro.SlideSelectionListener;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import com.sma.smartv3.util.xoIox;
import com.sma.smartv3.view.ChooseStartCalendarView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class PlanStartTimeFragment extends BaseFragment implements SlideSelectionListener {
    private long startTimeLong;
    private int startTimeOfWeek;

    @OOXIXo
    private final X0IIOO mCalendarView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ChooseStartCalendarView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PlanStartTimeFragment$mCalendarView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ChooseStartCalendarView invoke() {
            View mView;
            mView = PlanStartTimeFragment.this.getMView();
            return (ChooseStartCalendarView) mView.findViewById(R.id.calendar_view);
        }
    });
    private final Calendar mCalendar = Calendar.getInstance();

    @OOXIXo
    private final X0IIOO mTodayTime$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PlanStartTimeFragment$mTodayTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PlanStartTimeFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.today_is_time);
        }
    });

    @OOXIXo
    private final X0IIOO mCalendarTitle$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PlanStartTimeFragment$mCalendarTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PlanStartTimeFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.calendar_view_title);
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements ChooseStartCalendarView.oIX0oI {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.view.ChooseStartCalendarView.oIX0oI
        public void I0Io(@oOoXoXO String str) {
        }

        @Override // com.sma.smartv3.view.ChooseStartCalendarView.oIX0oI
        public void II0xO0(@oOoXoXO Calendar calendar, int i, int i2, int i3) {
        }

        @Override // com.sma.smartv3.view.ChooseStartCalendarView.oIX0oI
        public void oIX0oI(@oOoXoXO Calendar calendar, int i, int i2, int i3) {
            TextView mCalendarTitle = PlanStartTimeFragment.this.getMCalendarTitle();
            PlanStartTimeFragment planStartTimeFragment = PlanStartTimeFragment.this;
            IIX0o.ooOOo0oXI(calendar);
            mCalendarTitle.setText(planStartTimeFragment.formatCalendar(calendar, "MMMM yyyy"));
            PlanStartTimeFragment.this.startTimeLong = calendar.getTimeInMillis();
            PlanStartTimeFragment.this.startTimeOfWeek = AICoachManage.f23905XO.oIX0oI().xxX(calendar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatCalendar(Calendar calendar, String str) {
        String format = new SimpleDateFormat(str, Locale.getDefault()).format(calendar.getTime());
        IIX0o.oO(format, "format(...)");
        return format;
    }

    public final Calendar getMCalendar() {
        return this.mCalendar;
    }

    public final TextView getMCalendarTitle() {
        return (TextView) this.mCalendarTitle$delegate.getValue();
    }

    public final ChooseStartCalendarView getMCalendarView() {
        return (ChooseStartCalendarView) this.mCalendarView$delegate.getValue();
    }

    public final TextView getMTodayTime() {
        return (TextView) this.mTodayTime$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getMCalendarView().setOnDateSelectedListener(new oIX0oI());
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 7);
        getMCalendarView().setMax(calendar);
        TextView mTodayTime = getMTodayTime();
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.plan_start_time_tip));
        sb.append(TokenParser.SP);
        Calendar calendar2 = this.mCalendar;
        IIX0o.ooOOo0oXI(calendar2);
        sb.append(formatCalendar(calendar2, xoIox.f24702o00));
        mTodayTime.setText(sb.toString());
        getMCalendarView().setMin(this.mCalendar);
        getMCalendarView().setDate(this.mCalendar);
        TextView mCalendarTitle = getMCalendarTitle();
        Calendar calendar3 = this.mCalendar;
        IIX0o.ooOOo0oXI(calendar3);
        mCalendarTitle.setText(formatCalendar(calendar3, "MMMM yyyy"));
        this.startTimeLong = this.mCalendar.getTimeInMillis();
        AICoachManage oIX0oI2 = AICoachManage.f23905XO.oIX0oI();
        Calendar calendar4 = this.mCalendar;
        IIX0o.ooOOo0oXI(calendar4);
        this.startTimeOfWeek = oIX0oI2.xxX(calendar4);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.ai_coach_start_time;
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideDeselected() {
        ArrayList arrayList = new ArrayList();
        AICoachManage.oIX0oI oix0oi = AICoachManage.f23905XO;
        arrayList.addAll(oix0oi.oIX0oI().oI0IIXIo().getDailySchedule().subList(0, 7));
        arrayList.add(Integer.valueOf(this.startTimeOfWeek));
        oix0oi.oIX0oI().oI0IIXIo().setStartTime(this.startTimeLong);
        oix0oi.oIX0oI().OOXIXo();
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideSelected() {
    }
}
