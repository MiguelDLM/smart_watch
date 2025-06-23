package com.sma.smartv3.ui.status.base;

import OXOo.OOXIXo;
import android.view.View;
import androidx.annotation.CallSuper;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.xoIox;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public abstract class BaseDetailsFragment<T> extends BaseStatusFragment implements View.OnClickListener {
    private boolean initUpdate = true;

    @Override // com.sma.smartv3.ui.status.base.BaseStatusFragment
    public void changeTime() {
        super.changeTime();
        setMOffset(0);
        update(getMCalendar(), getMOffset(), getMTimePeriod());
        changeTimeDisplay();
    }

    public final void changeTimeDisplay() {
        String IIXOooo2 = xoIox.IIXOooo(getMCalendar(), getMOffset(), getMTimePeriod());
        if (TimePeriod.DAY == getMTimePeriod()) {
            if (IIX0o.Oxx0IOOO(xoIox.oo0xXOI0I().format(new Date()), IIXOooo2)) {
                getTvCurrent().setText(R.string.today);
                return;
            } else {
                getTvCurrent().setText(IIXOooo2);
                return;
            }
        }
        getTvCurrent().setText(IIXOooo2);
    }

    public final boolean getInitUpdate() {
        return this.initUpdate;
    }

    @CallSuper
    public void initView() {
        getBtnPre().setOnClickListener(this);
        getBtnNext().setOnClickListener(this);
        if (this.initUpdate) {
            update(getMCalendar(), getMOffset(), getMTimePeriod());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        int id = view.getId();
        if (id != R.id.beforeTime) {
            if (id == R.id.nextTime && xoIox.OO(getMCalendar(), getMOffset() + 1, getMTimePeriod())) {
                Calendar mCalendar = getMCalendar();
                setMOffset(getMOffset() + 1);
                update(mCalendar, getMOffset(), getMTimePeriod());
                changeTimeDisplay();
                return;
            }
            return;
        }
        Calendar mCalendar2 = getMCalendar();
        setMOffset(getMOffset() - 1);
        update(mCalendar2, getMOffset(), getMTimePeriod());
        getTvCurrent().setText(xoIox.IIXOooo(getMCalendar(), getMOffset(), getMTimePeriod()));
    }

    public abstract void onDataChange(@OOXIXo List<? extends T> list);

    @OOXIXo
    public abstract List<T> onTimePeriodChange(@OOXIXo Calendar calendar, int i, @OOXIXo TimePeriod timePeriod);

    public final void setInitUpdate(boolean z) {
        this.initUpdate = z;
    }

    public void update(@OOXIXo Calendar calendar, int i, @OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        switchLoading(true);
        onDataChange(onTimePeriodChange(calendar, i, timePeriod));
        switchLoading(false);
    }
}
