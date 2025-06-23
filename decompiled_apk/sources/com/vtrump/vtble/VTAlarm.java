package com.vtrump.vtble;

import androidx.annotation.Keep;
import java.util.Calendar;

@Keep
/* loaded from: classes13.dex */
public class VTAlarm {
    Calendar c;
    boolean open;
    int repeat_time;
    int ring;
    int wk_time;

    public VTAlarm() {
        this.open = true;
        this.c = Calendar.getInstance();
    }

    public Calendar getC() {
        return this.c;
    }

    public int getRepeat_time() {
        return this.repeat_time;
    }

    public int getRing() {
        return this.ring;
    }

    public int getWk_time() {
        return this.wk_time;
    }

    public boolean isOpen() {
        return this.open;
    }

    public VTAlarm setC(Calendar calendar) {
        this.c = calendar;
        return this;
    }

    public VTAlarm setOpen(boolean z) {
        this.open = z;
        return this;
    }

    public VTAlarm setRepeat_time(int i) {
        this.repeat_time = i;
        return this;
    }

    public VTAlarm setRing(int i) {
        this.ring = i;
        return this;
    }

    public VTAlarm setWk_time(int i) {
        this.wk_time = i;
        return this;
    }

    public VTAlarm(Calendar calendar, int i, int i2, boolean z, int i3) {
        this.c = calendar;
        this.ring = i;
        this.wk_time = i2;
        this.open = z;
        this.repeat_time = i3;
    }
}
