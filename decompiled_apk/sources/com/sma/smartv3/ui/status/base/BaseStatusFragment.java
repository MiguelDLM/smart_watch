package com.sma.smartv3.ui.status.base;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.core.widget.NestedScrollView;
import com.bestmafen.androidbase.base.BaseFragment;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.xoIox;
import com.sma.smartv3.util.Oxx0IOOO;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import java.util.Calendar;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import oOXoIIIo.II0xO0;

/* loaded from: classes12.dex */
public abstract class BaseStatusFragment extends BaseFragment {

    @OOXIXo
    private Calendar mCalendar;

    @oOoXoXO
    private xoIox mCalendarPopup;
    private int mOffset;

    @OOXIXo
    private final X0IIOO btnPre$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.base.BaseStatusFragment$btnPre$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = BaseStatusFragment.this.getMView();
            return mView.findViewById(R.id.beforeTime);
        }
    });

    @OOXIXo
    private final X0IIOO btnNext$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.base.BaseStatusFragment$btnNext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = BaseStatusFragment.this.getMView();
            return mView.findViewById(R.id.nextTime);
        }
    });

    @OOXIXo
    private final X0IIOO tvCurrent$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.base.BaseStatusFragment$tvCurrent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = BaseStatusFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.nowTime);
        }
    });

    @OOXIXo
    private final X0IIOO nowValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.base.BaseStatusFragment$nowValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BaseStatusFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.nowValue);
        }
    });

    @OOXIXo
    private final X0IIOO loading$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.status.base.BaseStatusFragment$loading$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            View mView;
            mView = BaseStatusFragment.this.getMView();
            return (RelativeLayout) mView.findViewById(R.id.loading);
        }
    });

    @OOXIXo
    private final X0IIOO dataContent$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.base.BaseStatusFragment$dataContent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = BaseStatusFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.dataContent);
        }
    });

    @OOXIXo
    private final X0IIOO nowTimeDetails$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.base.BaseStatusFragment$nowTimeDetails$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BaseStatusFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.nowTimeDetails);
        }
    });

    @OOXIXo
    private final X0IIOO image$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.base.BaseStatusFragment$image$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = BaseStatusFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.image);
        }
    });

    @OOXIXo
    private final X0IIOO valueUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.base.BaseStatusFragment$valueUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = BaseStatusFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.valueUnit);
        }
    });

    @OOXIXo
    private final X0IIOO scrollView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NestedScrollView>() { // from class: com.sma.smartv3.ui.status.base.BaseStatusFragment$scrollView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final NestedScrollView invoke() {
            View mView;
            mView = BaseStatusFragment.this.getMView();
            return (NestedScrollView) mView.findViewById(R.id.scrollView);
        }
    });

    public BaseStatusFragment() {
        Calendar calendar = Calendar.getInstance();
        IIX0o.oO(calendar, "getInstance(...)");
        this.mCalendar = calendar;
    }

    public void changeTime() {
    }

    public final View getBtnNext() {
        return (View) this.btnNext$delegate.getValue();
    }

    public final View getBtnPre() {
        return (View) this.btnPre$delegate.getValue();
    }

    public final LinearLayout getDataContent() {
        return (LinearLayout) this.dataContent$delegate.getValue();
    }

    public final ImageView getImage() {
        return (ImageView) this.image$delegate.getValue();
    }

    public final RelativeLayout getLoading() {
        return (RelativeLayout) this.loading$delegate.getValue();
    }

    @OOXIXo
    public final Calendar getMCalendar() {
        return this.mCalendar;
    }

    @oOoXoXO
    public final xoIox getMCalendarPopup() {
        return this.mCalendarPopup;
    }

    public final int getMOffset() {
        return this.mOffset;
    }

    @OOXIXo
    public abstract TimePeriod getMTimePeriod();

    public final DINCondBold getNowTimeDetails() {
        return (DINCondBold) this.nowTimeDetails$delegate.getValue();
    }

    public final DINCondBold getNowValue() {
        return (DINCondBold) this.nowValue$delegate.getValue();
    }

    public final NestedScrollView getScrollView() {
        return (NestedScrollView) this.scrollView$delegate.getValue();
    }

    public final TextView getTvCurrent() {
        return (TextView) this.tvCurrent$delegate.getValue();
    }

    public final PFMedium getValueUnit() {
        return (PFMedium) this.valueUnit$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @CallSuper
    public void init(@oOoXoXO Bundle bundle) {
        Calendar calendar = this.mCalendar;
        II0xO0.OxxIIOOXO(calendar, 0);
        II0xO0.O0xOxO(calendar, 0);
        II0xO0.IIXOooo(calendar, 0);
        II0xO0.oI0IIXIo(calendar, 0);
        calendar.setMinimalDaysInFirstWeek(7);
        if (getMTimePeriod() == TimePeriod.WEEK) {
            Calendar calendar2 = this.mCalendar;
            II0xO0.Oxx0xo(calendar2, calendar2.getFirstDayOfWeek());
        } else if (getMTimePeriod() == TimePeriod.MONTH) {
            II0xO0.IXxxXO(this.mCalendar, 1);
        }
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        xoIox xoiox = this.mCalendarPopup;
        if (xoiox != null && xoiox != null) {
            xoiox.dismiss();
        }
    }

    public final void setMCalendar(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<set-?>");
        this.mCalendar = calendar;
    }

    public final void setMCalendarPopup(@oOoXoXO xoIox xoiox) {
        this.mCalendarPopup = xoiox;
    }

    public final void setMOffset(int i) {
        this.mOffset = i;
    }

    public void share() {
        Oxx0IOOO oxx0IOOO = Oxx0IOOO.f24316oIX0oI;
        NestedScrollView scrollView = getScrollView();
        IIX0o.oO(scrollView, "<get-scrollView>(...)");
        oxx0IOOO.oxoX(getMActivity(), oxx0IOOO.I0Io(scrollView));
    }

    public final void showCalendarPopop() {
        if (getMActivity() == null) {
            return;
        }
        if (this.mCalendarPopup == null) {
            xoIox xoiox = new xoIox(getMActivity());
            xoiox.IoOoX(new Oox.oOoXoXO<Calendar, Boolean>() { // from class: com.sma.smartv3.ui.status.base.BaseStatusFragment$showCalendarPopop$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @OOXIXo
                public final Boolean invoke(@OOXIXo Calendar calendar) {
                    IIX0o.x0xO0oo(calendar, "calendar");
                    BaseStatusFragment.this.setMCalendar(calendar);
                    BaseStatusFragment.this.changeTime();
                    return Boolean.TRUE;
                }
            });
            this.mCalendarPopup = xoiox;
        }
        xoIox xoiox2 = this.mCalendarPopup;
        if (xoiox2 != null) {
            xoiox2.oo(this.mCalendar);
            xoiox2.IIXOooo();
        }
    }

    public final void switchLoading(boolean z) {
        if (z) {
            getLoading().setVisibility(0);
            getDataContent().setVisibility(8);
        } else {
            getLoading().setVisibility(8);
            getDataContent().setVisibility(0);
        }
    }
}
