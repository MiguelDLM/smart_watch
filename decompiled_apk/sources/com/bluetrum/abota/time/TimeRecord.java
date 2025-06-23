package com.bluetrum.abota.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class TimeRecord {
    private Date endTime;
    private Date startTime;
    private Date tempTime;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
    private long timeInterval = 0;

    public Date getEndTime() {
        return this.endTime;
    }

    public String getEndTimeText() {
        Date date = this.endTime;
        if (date == null) {
            return "";
        }
        return this.dateFormat.format(date);
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public String getStartTimeText() {
        return this.dateFormat.format(this.startTime);
    }

    public long getTimeInterval() {
        return this.timeInterval;
    }

    public String getTimeIntervalText() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return String.format(Locale.getDefault(), "%02d:%02d:%02d.%03d", Long.valueOf(timeUnit.toHours(this.timeInterval)), Long.valueOf(timeUnit.toMinutes(this.timeInterval) % 60), Long.valueOf(timeUnit.toSeconds(this.timeInterval) % 60), Long.valueOf(timeUnit.toMillis(this.timeInterval) % 1000));
    }

    public void startRecord(boolean z) {
        this.tempTime = new Date();
        if (z) {
            this.timeInterval = 0L;
            this.startTime = new Date(this.tempTime.getTime());
        }
    }

    public void stopRecord() {
        if (this.tempTime == null) {
            return;
        }
        Date date = new Date();
        this.endTime = date;
        this.timeInterval += date.getTime() - this.tempTime.getTime();
    }
}
